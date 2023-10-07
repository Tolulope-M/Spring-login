package com.example.spring_login.service.impl;

import com.example.spring_login.model.AppUser;
import com.example.spring_login.model.AppUserRole;
import com.example.spring_login.dto.response.RegistrationResponse;
import com.example.spring_login.repository.AppUserRepository;
import com.example.spring_login.dto.request.RegistrationRequest;
import com.example.spring_login.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepository;
    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        appUserRepository.findByEmail(request.getEmail()).ifPresentOrElse(appUser -> {
                    throw new IllegalStateException("email taken");
                },
                () -> {
                });
        AppUser appUser = new AppUser();
        appUser.setName(request.getName());
        appUser.setUsername(request.getUsername());
        appUser.setEmail(request.getEmail());
        appUser.setPassword(passwordEncoder.encode(request.getPassword()));
        appUser.setAppUserRole(AppUserRole.ADMIN);

        AppUser appUser1 = appUserRepository.save(appUser);
        return RegistrationResponse.builder()
                .name(appUser1.getName())
                .email(appUser1.getEmail())
                .build();
    }

    @Override
    public RegistrationResponse editUser(RegistrationRequest request) {
        return null;
    }

    @Override
    public RegistrationResponse deleteUser() {
        return null;
    }

    @Override
    public RegistrationResponse getUser() {
        return null;
    }
}
