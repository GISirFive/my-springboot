package com.qianxin.web;

import com.alibaba.fastjson.JSON;
import com.qianxin.web.mapper.cache.IPeopleRedisDao;
import com.qianxin.web.entity.dto.People;
import com.qianxin.web.entity.po.Charger;
import com.qianxin.web.service.IChargerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringbootWebApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private IChargerService chargerService;


	@Autowired
	private IPeopleRedisDao peopleRedisDao;

	@Test
	public void test_IChargerService_C(){
		System.err.println("测试开始>>>>>>>>>>>>");
		Charger charger = new Charger();
		charger.setName("test_1");
		charger.setCurrent(1);
		charger.setElectricity(1);
		charger.setPower(1);
		charger.setVoltage(1);
		charger.setStatus(1);
		boolean b = chargerService.insertSelective(charger);
		System.out.println("测试结果-------" + b);
		System.err.println("测试结束<<<<<<<<<<<<");
	}


	@Test
	public void test_redisTemplate(){
		System.err.println("测试开始>>>>>>>>>>>>");
		People people = new People();
		people.setName("hello");
		people.setAge(12);
		people.setBirthday(new Date());
		boolean putPeopleSuccess = peopleRedisDao.hashPut("123", "4567", people);
		System.out.println("测试结果(1)-------putPeopleSuccess>>" + putPeopleSuccess);
		People findPeople = peopleRedisDao.hashGet("123", "4567");
		System.out.println("测试结果(1)-------" + JSON.toJSONString(findPeople));
		System.err.println("测试结束<<<<<<<<<<<<");

	}

	@Test
	public void test_redisTemplate_hashEntries(){
		System.err.println("测试开始>>>>>>>>>>>>");
		Map<String, People> peopleMap = peopleRedisDao.hashEntries("123");
		for(Map.Entry<String, People> peopleEntry: peopleMap.entrySet()){
			System.out.println("测试结果-------key:" + peopleEntry.getKey() + ", value:" + JSON.toJSONString(peopleEntry.getValue()));
		}
		System.err.println("测试结束<<<<<<<<<<<<");

	}

}
