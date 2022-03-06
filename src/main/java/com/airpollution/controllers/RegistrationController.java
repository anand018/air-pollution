package com.airpollution.controllers;

import com.airpollution.dtos.User;
import com.airpollution.entities.RegistrationEntity;
import com.airpollution.service.RegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestParam String request, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        registrationService.register(jsonToObject(request), multipartFile);
    }

    @GetMapping("/username/{username}")
    public boolean validateUserName(@PathVariable String username) {
        return registrationService.validateUserName(username);
    }

    private User jsonToObject(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(json, User.class);
        return user;
    }
}
