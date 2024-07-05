package ru.ivanchin.centralbank.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

}
