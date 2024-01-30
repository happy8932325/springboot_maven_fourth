package com.sic.springboot_maven_fourth.controller;

import com.sic.springboot_maven_fourth.service.CashService;
import com.sic.springboot_maven_fourth.service.CashServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cash")
public class CashController {
    private final CashService service;
    private final CashServiceV2 cashServiceV2;

    @Autowired
    public CashController(CashService service, CashServiceV2 cashServiceV2) {
        this.service = service;
        this.cashServiceV2 = cashServiceV2;
    }

    @GetMapping("/CalCash")
    public String CalCash() {
        return cashServiceV2.getCash();
    }
}
