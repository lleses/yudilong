package com.dl.modules.mode.order;

import com.dl.comm.result.Result;
import com.dl.comm.result.ResultGenerator;
import org.springframework.stereotype.Component;

@Component("XCX")
public class XcxOrder implements OrderStrategy {

    @Override
    public Result addOrder(OrderDto order) {
        System.out.println("XCX strategy"+"====="+order.getSource());
        return ResultGenerator.getSuccessResult();
    }
}