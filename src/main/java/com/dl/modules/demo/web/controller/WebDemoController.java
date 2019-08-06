package com.dl.modules.demo.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/webDemo")
public class WebDemoController {

    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        return "index";
    }
}
