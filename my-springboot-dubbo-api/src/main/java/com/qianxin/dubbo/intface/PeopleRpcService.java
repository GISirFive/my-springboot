package com.qianxin.dubbo.intface;

import com.qianxin.dubbo.entity.People;

public interface PeopleRpcService {

    People selectPeopleByName(String name);

}
