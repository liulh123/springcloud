package com.atguigu.comtroller;

import com.atguigu.domain.CommonResult;
import com.atguigu.domain.Order;
import com.atguigu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther zzyy
 * @create 2019-12-11 16:55
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public CommonResult create( Order order) {

        orderService.create(order);
        return new CommonResult(200, "订单创建成功!");
    }
}

