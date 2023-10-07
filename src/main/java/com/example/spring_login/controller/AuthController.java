package com.example.spring_login.controller;

import com.example.spring_login.dto.request.AuthenticationRequest;
import com.example.spring_login.security.AppUserService;
import com.example.spring_login.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
//    private final UserDao userDao;
    private final AppUserService appUserService;
    private final JwtUtil jwtUtil;
    @PostMapping("/authenticate")
    public ResponseEntity<Map> authenticate(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                ));
        final UserDetails user = appUserService.loadUserByUsername(request.getEmail());
        if (user != null) {
            final String jwtToken = jwtUtil.generateToken(user);
            Map response = Map.of("token", jwtToken);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
