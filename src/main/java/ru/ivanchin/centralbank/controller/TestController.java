package ru.ivanchin.centralbank.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
@EnableMethodSecurity
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/v1/login")
    public String login() {
        return "You are logging in";
    }

    @GetMapping("/v1/authorizedAdmin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String authorizedAdmin() {
        return "Authorized Admin.";
    }

    @GetMapping("/v1/authorizedUser")
    //@PreAuthorize("hasAuthority('USER')")
    public String authorizedUser() {
        return "Authorized User.";
    }

}
