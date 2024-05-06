package com.obaydullah.springsecurity.controller;


import com.obaydullah.springsecurity.entity.MyUser;
import com.obaydullah.springsecurity.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private MyUserRepository MyUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MyUserRepository myUserRepository;

    @PostMapping("/regi/user")
    public MyUser registerUser(@RequestBody MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myUserRepository.save(user);
    }
}
