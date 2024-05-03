package com.obaydullah.springsecurity.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserDetails {
    
    @Bean
    public UserDetailsService userDetailsService(){
        org.springframework.security.core.userdetails.UserDetails normalUser = User.builder()
                .username("user")
              //  .password("$2a$12$Q3Q/JgOiy1kEH7YgCsCEF.fZXEOC7gYTvjQ3yFLjqFwGfpzH6AxHe")
                .password("{noop}password")
                .roles("USER")
                .build();

        org.springframework.security.core.userdetails.UserDetails adminUser = User.builder()
                .username("admin")
             //   .password("$2a$12$1bgJjAPLW/rxtnbQZ.kEqellDxWhtf8bLTAeEdEkdKz1gbf3r3dgC")
                .password("{noop}password")
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(adminUser,  normalUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
