package com.dl.modules.mode.order;

import com.dl.comm.result.Result;
import com.dl.comm.result.ResultGenerator;
import org.springframework.stereotype.Component;

@Component("TV")
public class TvOrder implements OrderStrategy {

    @Override
    public Result addOrder(OrderDto order) {
        System.out.println("TV strategy"+"====="+order.getSource());
        return ResultGenerator.getSuccessResult();
    }

}