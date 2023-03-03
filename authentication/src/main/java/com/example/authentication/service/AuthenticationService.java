package com.example.authentication.service;

import com.example.authentication.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean checkValidation(User user){
        return (user.getName().equalsIgnoreCase("admin"))
                && (user.getPassword().equalsIgnoreCase("homeo2003"));
    }
}