package com.dl.modules.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test1() {
        logger.info("info 11111");
        logger.debug("debug 1111");
        logger.error("error 11111");
    }


}
