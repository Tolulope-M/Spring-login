package com.example.spring_login.controller;

import com.example.spring_login.request.RegistrationRequest;
import com.example.spring_login.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class UserRegistrationController {
    private final RegistrationService registrationService;
    @GetMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

}
