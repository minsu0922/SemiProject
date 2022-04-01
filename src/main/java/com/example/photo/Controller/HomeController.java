package com.example.photo.Controller;

import com.example.photo.Entity.login;
import com.example.photo.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/start")
    public String getLogin(){
        return "/start";
    }

    @GetMapping("/home")
    public String getHome(){
        return "/home";
    }

    @PostMapping("/home")
    public String postHome(){
        return "/home";
    }
}
