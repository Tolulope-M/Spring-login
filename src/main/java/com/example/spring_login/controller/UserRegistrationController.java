package com.example.spring_login.controller;

import com.example.spring_login.dto.request.RegistrationRequest;
import com.example.spring_login.dto.response.RegistrationResponse;
import com.example.spring_login.service.impl.RegistrationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class UserRegistrationController {
    private final RegistrationServiceImpl registrationServiceImpl;
    @PostMapping("/register")
    ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {
       return new ResponseEntity<>(registrationServiceImpl.register(request), HttpStatus.OK);
    }
}
