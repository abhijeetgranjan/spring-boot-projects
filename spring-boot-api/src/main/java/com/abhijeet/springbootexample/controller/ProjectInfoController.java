package com.abhijeet.springbootexample.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProjectInfoController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${welcome.message}")
    private String welcomeMessage;


    @GetMapping("/ping")
    public String getProjectStatus(){

        return
            "the active profile is" + activeProfile + "\n"+ welcomeMessage;
    }


}
