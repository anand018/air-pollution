package com.airpollution.service;

import com.airpollution.dtos.Credentials;

public interface LoginService {

    Boolean login(Credentials credentials);
}
