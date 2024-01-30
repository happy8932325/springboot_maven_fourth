package com.sic.springboot_maven_fourth.controller;

import com.sic.springboot_maven_fourth.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cash")
public class CashController {
    private final CashService service;

    @Autowired
    public CashController(CashService service) {
        this.service = service;
    }

    @GetMapping("/CalCash")
    public String CalCash() {
        return service.CalCash();
    }
}
