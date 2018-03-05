package com.qianxin.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.qianxin.dubbo.entity.People;
import com.qianxin.dubbo.intface.PeopleRpcService;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class PeopleRpcServiceImpl implements PeopleRpcService {
    @Override
    public People selectPeopleByName(String name) {
        if(StringUtils.isEmpty(name)){
            name = "hello";
        }
        People people = new People();
        people.setName(name);
        people.setAge(12);
        people.setBirthday(new Date());
        return people;
    }
}
