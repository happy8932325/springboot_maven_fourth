package com.sic.springboot_maven_fourth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MainList")
public class MainListController {
    @GetMapping("/findAll")
    public String findAll() {
        return "Hello World!";
    }
}
