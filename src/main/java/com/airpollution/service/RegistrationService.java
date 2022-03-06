package com.airpollution.service;

import com.airpollution.dtos.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RegistrationService {

    void register(User user, MultipartFile multipartFile) throws IOException;
    Boolean validateUserName(String username);
}
