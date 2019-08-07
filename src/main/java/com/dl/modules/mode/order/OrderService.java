package com.dl.modules.mode.order;

import com.dl.comm.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {

    @Autowired
    private final Map<String, OrderStrategy> strategyMap = new ConcurrentHashMap<>();

    public OrderService(Map<String, OrderStrategy> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach((k, v) -> this.strategyMap.put(k, v));
    }

    public Result addOrder(OrderDto order) {
        //选择处理订单策略
        return strategyMap.get(order.getSource()).addOrder(order);
    }

}