package com.qianxin.redis;

import com.alibaba.fastjson.JSON;
import com.qianxin.redis.entity.Order;
import com.qianxin.redis.entity.People;
import com.qianxin.redis.service.OrderRedisHashService;
import com.qianxin.redis.service.PeopleRedisHashService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringbootRedisApplicationTests {

    @Autowired
    private PeopleRedisHashService peopleRedisHashService;

    @Autowired
    private OrderRedisHashService orderRedisHashService;


	@Test
	public void contextLoads() {
	}

	@Test
    public void test_redisTemplate(){
        System.err.println("测试开始>>>>>>>>>>>>");
        People people = new People();
        people.setName("hello");
        people.setAge(12);
        people.setBirthday(new Date());
        boolean putPeopleSuccess = peopleRedisHashService.put("123", "456", people);
        System.out.println("测试结果(1)-------putPeopleSuccess>>" + putPeopleSuccess);
        People findPeople = peopleRedisHashService.get("123", "456");
        System.out.println("测试结果(1)-------" + JSON.toJSONString(findPeople));

        Order order = new Order();
        order.setId(11L);
        order.setPrice(11);
        order.setElectricity(11);
        order.setRemark("11");
        order.setStatus(11);
        boolean putOrderSuccess = orderRedisHashService.put("11", "11", order);
        System.out.println("测试结果(2)-------putOrderSuccess>>" + putOrderSuccess);
        Order findOrder = orderRedisHashService.get("11", "11");
        System.out.println("测试结果(1)-------" + JSON.toJSONString(findOrder));
        System.err.println("测试结束<<<<<<<<<<<<");

    }
}
