package com.example.authentication.control;

import com.example.authentication.model.User;
import com.example.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @Autowired
    public void AuthenticationService(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("/auth")
    public boolean authenticate(@RequestBody User user){
        return authenticationService.checkValidation(user);
    }
}