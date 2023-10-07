package com.example.spring_login.dto.response;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RegistrationResponse {
    private final String name;
    private final String email;
}
