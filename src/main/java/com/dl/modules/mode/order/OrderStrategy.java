package com.dl.modules.mode.order;

import com.dl.comm.result.Result;

public interface OrderStrategy {

    Result addOrder(OrderDto order);

}