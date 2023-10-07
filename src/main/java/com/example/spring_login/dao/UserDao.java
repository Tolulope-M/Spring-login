package com.example.spring_login.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Repository
public class UserDao {

    private final static String USER_NOT_FOUND_MESSAGE =
            "User with email %s not found";


    public UserDetails findUserByEmail(String email){
         List<UserDetails> APPLICATION_USERS = Arrays.asList(
                new User(
                        "dnlremi@gmail.com",
                        "password"
                        ,
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
                ),
                new User(
                        "gracedfamale@gmail.com",
                        "password",
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
                )
        );
        UserDetails userDetails = APPLICATION_USERS.stream().filter(a->a.getUsername().equals(email))
                .findFirst().orElseThrow(()-> new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE));
        return userDetails;
    }
}
