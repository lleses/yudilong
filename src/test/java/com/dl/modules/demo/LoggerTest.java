package com.dl.modules.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LoggerTest{

    @Test
    public void test1() {
        log.info("info 11111");
        log.debug("debug 1111");
        log.error("error 11111");
    }


}
