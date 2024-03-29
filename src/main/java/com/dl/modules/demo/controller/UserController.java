package com.dl.modules.demo.controller;

import com.dl.comm.result.Result;
import com.dl.comm.result.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/demo/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/test1")
    @RequestMapping
    public Result test1() {
        return ResultGenerator.getSuccessResult("444");
    }

    @GetMapping("/test2")
    public Result test2() throws IOException {
        throw new IOException("id不能为空！");
    }

}
