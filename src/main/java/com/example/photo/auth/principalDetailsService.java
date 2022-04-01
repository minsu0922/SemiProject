package com.example.photo.auth;

import com.example.photo.Entity.login;
import com.example.photo.Repository.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class principalDetailsService implements UserDetailsService {

    @Autowired
    private com.example.photo.Repository.loginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username :" + username);
        login loginEntity = loginRepository.findByEmail(username);
        if(loginEntity !=null){
            return new principalDetails(loginEntity);
        }
        return null;
    }
}
