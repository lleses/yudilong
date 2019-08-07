package com.dl.modules.mode.stategy;

import com.dl.comm.utils.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 策略模式
 */
@RestController
@RequestMapping("/strategyMode")
public class StrategyModeController {

    @Autowired
    private SimpleContext simpleContext;

    @GetMapping("/choose")
    public String choose(@RequestParam String poolId) {
        return simpleContext.getResource(poolId);
    }

    @GetMapping("/choose2")
    public String choose2(@RequestParam String poolId) {
        Strategy strategy = SpringUtil.getBean(poolId);
        return strategy.getVpcList(poolId);
    }

}
