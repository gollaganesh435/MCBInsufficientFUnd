package com.mcb.insuffcient.fund.app.InsufficientFund.service;

import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.TokenRefreshRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.response.JwtResponse;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.LoginRequest;

import javax.validation.Valid;

public interface UserService {

    JwtResponse authenticateUser(@Valid LoginRequest loginRequest);

    JwtResponse refreshToken(@Valid TokenRefreshRequest request);

    void signout();
}
