package com.sxt.store.controller;

import com.sxt.store.service.WeChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushController {
    @Autowired
    private WeChartService weChartService;

    @GetMapping("/send")
    public String sendMessage(){
        return weChartService.sendMessage();
    }

}
