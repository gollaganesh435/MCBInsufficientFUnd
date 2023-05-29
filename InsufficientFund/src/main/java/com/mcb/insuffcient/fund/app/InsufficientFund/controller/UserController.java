package com.mcb.insuffcient.fund.app.InsufficientFund.controller;

import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.LoginRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.TokenRefreshRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.response.JwtResponse;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;



    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        JwtResponse jwtResponse = userService.authenticateUser(loginRequest);
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);

    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
        return new ResponseEntity<>(userService.refreshToken(request), HttpStatus.OK);
    }

    @GetMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        userService.signout();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
