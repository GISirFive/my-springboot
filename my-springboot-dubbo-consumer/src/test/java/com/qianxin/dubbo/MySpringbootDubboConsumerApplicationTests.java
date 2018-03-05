package com.qianxin.dubbo;

import com.alibaba.fastjson.JSON;
import com.qianxin.dubbo.consumer.PeopleRpcServiceConsumer;
import com.qianxin.dubbo.entity.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringbootDubboConsumerApplicationTests {

    @Autowired
    private PeopleRpcServiceConsumer peopleRpcServiceConsumer;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test_DubboConsumer(){
        System.out.println("测试开始>>>>>>>>>>>>>>>>>>>>>");
        People hello = peopleRpcServiceConsumer.getPeople("hello");
        System.out.println("测试结果" + JSON.toJSONString(hello));
        System.out.println("测试结束<<<<<<<<<<<<<<<<<<<<<");
    }

}
