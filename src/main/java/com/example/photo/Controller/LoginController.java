package com.example.photo.Controller;

import com.example.photo.Entity.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    com.example.photo.Service.userService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String getLogin(){
        return "/login";
    }

    @PostMapping("/login")
    public String postLogin(){
        return "/home";
    }

    @GetMapping("/signup")
    public String getSignup() {
        return "/signup";
    }

    @PostMapping("/signup")
    public String postSignup(login login) {
        login.setRole("ROLE_USER");
        String rawPassword = login.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        login.setPassword(encPassword);
        userService.joinUser(login);
        return "redirect:/login";
    }
}
