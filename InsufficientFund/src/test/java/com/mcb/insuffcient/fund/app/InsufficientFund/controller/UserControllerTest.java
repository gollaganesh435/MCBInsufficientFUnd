package com.mcb.insuffcient.fund.app.InsufficientFund.controller;

import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.LoginRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.TokenRefreshRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.response.JwtResponse;
import com.mcb.insuffcient.fund.app.InsufficientFund.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {


    @InjectMocks
    private UserController controller;

    @Mock
    private UserService service;


    @Test
    void testAuthenticateUser() {
        Mockito.when(service.authenticateUser(Mockito.any()))
                .thenReturn(new JwtResponse("abc", "abc", Long.valueOf(1), "USERNAME"));
        controller.authenticateUser(new LoginRequest());
        Mockito.verify(service, Mockito.times(1)).authenticateUser(Mockito.any());
    }
    @Test
    void testLogoutUser() throws Exception {
        // Setup
        // Run the test
        Mockito.doNothing().when(service).signout();
        controller.logoutUser();
        Mockito.verify(service, Mockito.times(1)).signout();
    }
}
