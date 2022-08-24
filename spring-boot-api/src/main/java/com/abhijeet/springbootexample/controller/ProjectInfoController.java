package com.abhijeet.springbootexample.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProjectInfoController {

    @GetMapping("/ping")
    public String getProjectStatus(){
        return "Project is up and running";
    }


}
