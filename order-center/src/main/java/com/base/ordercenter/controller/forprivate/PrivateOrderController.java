package com.base.ordercenter.controller.forprivate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private/order/")
@Slf4j
public class PrivateOrderController {
    @RequestMapping(value = "get",method= RequestMethod.GET)
    public String get() {
        log.info("请求进来：");
        return "内部接口返回信息";
    }
}
