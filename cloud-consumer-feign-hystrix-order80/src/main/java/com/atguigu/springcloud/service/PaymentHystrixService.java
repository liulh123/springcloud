package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther zzyy
 * @create 2020-02-04 16:34
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService
{
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")

    String paymentInfo_TimeOut(@PathVariable("id") Integer id);


}
//1.调用失败会触发降级，而降级会调用fallback方法
//2.但无论如何降级的流程一定会先调用正常方法再调用fallback方法
//        3假如单位时间内调用失败次数过多，也就是降级次数过多，则触发熔断
//        4熔断以后就会跳过正常方法直接调用fallback方法
//        5所谓“熔断后服务不可用”就是因为跳过了正常方法直接执行fallback