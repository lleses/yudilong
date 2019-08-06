package com.dl;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 *      加入原因:websocket是需要依赖tomcat等容器的启动。所以在测试过程中我们要真正的启动一个tomcat作为容器。
 *
 * WebAppConfiguration
 *      由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebAppConfiguration
public class ApplicationTest {

    private long begin;

    @Before
    public void before() {
        begin = System.currentTimeMillis();
    }

    @After
    public void after() {
        long time = System.currentTimeMillis() - begin;
        System.out.println("总耗时:" + time+"ms");
    }
}
