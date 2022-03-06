package com.airpollution.service.impl;

import com.airpollution.dtos.User;
import com.airpollution.entities.RegistrationEntity;
import com.airpollution.repo.RegistrationRepo;
import com.airpollution.service.RegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;

    @Override
    public void register(User user, MultipartFile multipartFile) throws IOException {
        user.setPassword(new String(Base64.getEncoder().encode(user.getPassword().getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8));
        RegistrationEntity registrationEntity = new RegistrationEntity();
        BeanUtils.copyProperties(user, registrationEntity);
        registrationEntity.setImageFile(multipartFile.getBytes());
        registrationRepo.save(registrationEntity);
    }

    @Override
    public Boolean validateUserName(String username) {
        Integer count = registrationRepo.checkIfUserExists(username);
        if (count == 0) {
            return false;
        }
        return true;
    }
}
