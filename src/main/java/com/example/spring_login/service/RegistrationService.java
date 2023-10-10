package com.example.spring_login.service;

import com.example.spring_login.dto.request.RegistrationRequest;
import com.example.spring_login.dto.response.RegistrationResponse;

public interface RegistrationService {
    public RegistrationResponse register(RegistrationRequest request);
    public RegistrationResponse updateProfile(RegistrationRequest request);
    public RegistrationResponse deleteProfile();
    public RegistrationResponse getUser();
    public RegistrationResponse forgetPassword();

}
