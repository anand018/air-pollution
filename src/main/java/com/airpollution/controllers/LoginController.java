package com.airpollution.controllers;

import com.airpollution.dtos.Credentials;
import com.airpollution.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public Boolean login(@RequestBody Credentials credentials) {
        return loginService.login(credentials);

    }
}
