package com.example.showresult.service;

import com.example.showresult.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService {
    public boolean authentication(User user){
        RestTemplate restTemplate = new RestTemplate();
        String http = "http://authentication:8081/auth";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        ResponseEntity<Boolean> response = restTemplate.postForEntity(http , request, Boolean.class);
        return Boolean.TRUE.equals(response.getBody());
    }
}