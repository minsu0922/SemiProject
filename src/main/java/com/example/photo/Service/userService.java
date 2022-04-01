package com.example.photo.Service;

import com.example.photo.Entity.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    com.example.photo.Repository.loginRepository loginRepository;

    public void joinUser(login signup) {
        loginRepository.save(signup);
    }

}
