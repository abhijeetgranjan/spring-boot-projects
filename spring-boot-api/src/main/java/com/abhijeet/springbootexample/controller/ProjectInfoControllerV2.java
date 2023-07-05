package com.abhijeet.springbootexample.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProjectInfoControllerV2 {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${welcome.message}")
    private String welcomeMessage;


    @GetMapping("/ping/v2")
    public String getProjectStatusViaURI(){

        return
            "the active profile is " + activeProfile + "\n"+ welcomeMessage;
    }

    @GetMapping(value = "/ping", params = "version=2")
    public String getProjectStatusViaRequestParam(){

        return
                "the active profile is " + activeProfile + "\n"+ welcomeMessage +" and the request param versioning  is used " ;
    }

    @GetMapping(value = "/ping", headers = "X-API-VERSION=1")
    public String getProjectStatusViaHeaderVersioning(){

        return
                "the active profile is " + activeProfile + "\n"+ welcomeMessage +" and the header versioning is used.";
    }


    @GetMapping(value = "/ping", produces = "application/vnd.company.app-v1+json")
    public String getProjectStatusViaMediaVersioning() {
        return
                "the active profile is " + activeProfile + "\n"+ welcomeMessage +" and the media versioning is used.";
    }
}
