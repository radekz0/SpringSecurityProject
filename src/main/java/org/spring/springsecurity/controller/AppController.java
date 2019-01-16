package org.spring.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/admins")
    public String adminsPage(){
        return "admins-page";
    }

    @GetMapping("managers")
    public String managersPage(){
        return "managers-page";
    }

    @GetMapping("access-denied")
    public String accessDenied(){
        return "access-denied";
    }

}
