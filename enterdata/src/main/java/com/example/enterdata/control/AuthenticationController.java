package com.example.enterdata.control;

import com.example.enterdata.model.User;
import com.example.enterdata.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@Controller
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public void authService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String authenticationValidation() {
        return "auth-form";
    }

    @PostMapping("/login/check-validation")
    public String validation(@RequestParam(required = false) String username,
                             @RequestParam(required = false) String password) {
        if ( StringUtils.isEmpty(username) || StringUtils.isEmpty(password) ) {
            return "auth-fail-form";
        }
        boolean isValidation = authenticationService.authentication(new User(username, password));
        return (isValidation ? "redirect:/add-student" : "auth-fail-form");
    }
}