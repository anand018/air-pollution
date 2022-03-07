package com.airpollution.service.impl;

import com.airpollution.dtos.Credentials;
import com.airpollution.repo.LoginRepo;
import com.airpollution.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepo loginRepo;

    @Override
    public Boolean login(Credentials credentials) {
        String actualPassword = loginRepo.findPasswordByUsername(credentials.getUsername());
        String givenPassword = new String(Base64.getEncoder().encode(credentials.getPassword().getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);

        if (actualPassword != null && actualPassword.equals(givenPassword)) {
            return true;
        }
        return false;
    }
}
