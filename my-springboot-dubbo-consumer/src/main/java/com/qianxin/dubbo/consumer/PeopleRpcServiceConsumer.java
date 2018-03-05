package com.qianxin.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qianxin.dubbo.entity.People;
import com.qianxin.dubbo.intface.PeopleRpcService;
import org.springframework.stereotype.Service;

@Service
public class PeopleRpcServiceConsumer {

    @Reference
    private PeopleRpcService peopleRpcService;

    public People getPeople(String name) {
        return peopleRpcService.selectPeopleByName(name);
    }
}
