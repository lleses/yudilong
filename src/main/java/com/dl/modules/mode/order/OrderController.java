package com.dl.modules.mode.order;

import com.dl.comm.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/addOrder")
    public Result addOrder(@RequestBody OrderDto order) {
        //TODO 校验数据
        //..............
        //TODO 获取待处理数据
        //.........
        //TODO 处理
        Result result = orderService.addOrder(order);
        return result;
    }


}
