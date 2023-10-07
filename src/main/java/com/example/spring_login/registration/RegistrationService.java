package com.example.spring_login.registration;

import com.example.spring_login.request.RegistrationRequest;
import com.example.spring_login.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserRepository appUserRepository;
    public String register(RegistrationRequest request) {
        return "works";
    }
}
