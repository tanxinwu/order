package com.base.ordercenter.client;

import com.base.wareapi.VO.RequestVO;
import com.base.wareapi.service.WareService;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WareClient {

    @Autowired
    private WareService wareService;

    public String get(RequestVO requestVO){
        return wareService.get(requestVO);
    }
}
