package com.base.ordercenter.controller.forpublic;

import cn.hutool.core.collection.CollUtil;
import com.base.ordercenter.client.WareClient;
import com.base.wareapi.VO.RequestVO;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/order/")

public class OrderController {
    @Autowired
    private WareClient wareClient;
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping(value = "serviceUrlForDiscoveryClient",method= RequestMethod.GET)
    public String serviceUrlForDiscoveryClient(String serviceId) {
        //serviceId区分大小写
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        if (CollUtil.isNotEmpty(instances)){
            return instances.get(0).getUri().toString();
        }
        return "";
    }
    @RequestMapping(value = "serviceUrl",method= RequestMethod.GET)
    public String serviceUrl(String serviceId) {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka(serviceId, false);
        return instance.getHomePageUrl();
    }
    @RequestMapping(value = "get",method= RequestMethod.POST)
    public String get(@RequestBody RequestVO vo) {
       String wareInfo  = wareClient.get(vo);
        return "公共接口：订单信息,其中商品信息："+wareInfo;
    }

    @PostMapping("add")
    public String add() {
        return "add";
    }


}
