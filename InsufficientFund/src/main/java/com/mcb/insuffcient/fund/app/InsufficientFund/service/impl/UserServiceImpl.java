package com.mcb.insuffcient.fund.app.InsufficientFund.service.impl;

import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.TokenRefreshRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.response.JwtResponse;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.LoginRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.exception.TokenRefreshException;
import com.mcb.insuffcient.fund.app.InsufficientFund.modal.RefreshToken;
import com.mcb.insuffcient.fund.app.InsufficientFund.security.jwt.JwtUtils;
import com.mcb.insuffcient.fund.app.InsufficientFund.security.service.RefreshTokenService;
import com.mcb.insuffcient.fund.app.InsufficientFund.security.service.UserDetailsImpl;
import com.mcb.insuffcient.fund.app.InsufficientFund.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    RefreshTokenService refreshTokenService;

    /**
     * Authenticate user.
     *
     * @param loginRequest the login request
     * @return the jwt response
     */
    @Override
    public JwtResponse authenticateUser(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

        return new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(), userDetails.getUsername());
    }

    /**
     * RefreshToken user.
     *Used to refresh the token
     * @return the jwt response
     */

    @Override
    public JwtResponse refreshToken(@Valid TokenRefreshRequest request) {
        return refreshTokenService.findByToken(request.getRefreshToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return new JwtResponse(token, request.getRefreshToken(), user.getId(), user.getUsername());
                })
                .orElseThrow(() -> new TokenRefreshException(request.getRefreshToken(),
                        "Refresh token is not in database!"));
    }

    @Override
    public void signout() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Long userId = userDetails.getId();
        refreshTokenService.deleteByUserId(userId);

    }
}
