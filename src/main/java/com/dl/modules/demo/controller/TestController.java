package com.dl.modules.demo.controller;

import com.dl.modules.demo.service.SimpleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private SimpleContext simpleContext;

    @GetMapping("/choose")
    public String choose(@RequestParam String poolId){
        return simpleContext.getResource(poolId);
    }

}
