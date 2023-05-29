package com.mcb.insuffcient.fund.app.InsufficientFund.service.impl;

import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.LoginRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.modal.RefreshToken;
import com.mcb.insuffcient.fund.app.InsufficientFund.modal.User;
import com.mcb.insuffcient.fund.app.InsufficientFund.repository.UserRepository;
import com.mcb.insuffcient.fund.app.InsufficientFund.security.jwt.JwtUtils;
import com.mcb.insuffcient.fund.app.InsufficientFund.security.service.RefreshTokenService;
import com.mcb.insuffcient.fund.app.InsufficientFund.security.service.UserDetailsImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class UserServiceImpleTest {

    @InjectMocks
    private UserServiceImpl serviceImpl;

    @Mock
    private RefreshTokenService refreshTokenService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtUtils jwtUtils;

    @Mock
    private PasswordEncoder encoder;

    @Mock
    private UserRepository userRepository;

    @Test
    void testAuthenticateUser() {
        Authentication auth = Mockito.mock(Authentication.class);
        Mockito.when(authenticationManager.authenticate(Mockito.any())).thenReturn(auth);
        Mockito.when(jwtUtils.generateJwtToken(Mockito.any())).thenReturn("abc");
        User user = new User();
        user.setId(Long.valueOf(1));
        Mockito.when(auth.getPrincipal()).thenReturn(UserDetailsImpl.build(user));
        Mockito.when(refreshTokenService.createRefreshToken(Mockito.anyLong())).thenReturn(new RefreshToken());
        serviceImpl.authenticateUser(new LoginRequest());
    }

}

