package com.qianxin.mybatisplus;

import com.alibaba.fastjson.JSON;
import com.qianxin.mybatisplus.entity.Charger;
import com.qianxin.mybatisplus.entity.ChargerOrder;
import com.qianxin.mybatisplus.service.IChargerOrderService;
import com.qianxin.mybatisplus.service.IChargerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringbootMybatisPlusApplicationTests {

	@Autowired
	private IChargerService chargerService;
	@Autowired
	private IChargerOrderService chargerOrderService;

	@Test
	public void contextLoads() {
	}

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
	public void test_IChargerService_R(){
		System.err.println("测试开始>>>>>>>>>>>>");
		Charger paramCharger = new Charger();
		paramCharger.setId(1);
		Charger charger = chargerService.selectOne(paramCharger);
		System.out.println("测试结果-------" + JSON.toJSONString(charger));
		System.err.println("测试结束<<<<<<<<<<<<");
	}

	@Test
	public void test_IChargerService_U(){
		System.err.println("测试开始>>>>>>>>>>>>");
		Charger charger = new Charger();
		charger.setId(1);
		charger.setName("test_1");
		charger.setCurrent(2);
		charger.setElectricity(2);
		charger.setPower(2);
		charger.setVoltage(2);
		charger.setStatus(2);
		boolean b = chargerService.updateById(charger);
		System.out.println("测试结果-------" + b);
		System.err.println("测试结束<<<<<<<<<<<<");
	}

	@Test
	public void test_IChargerService_D(){
		System.err.println("测试开始>>>>>>>>>>>>");
		Charger paramCharger = new Charger();
		paramCharger.setId(1);
		boolean b = chargerService.deleteSelective(paramCharger);
		System.out.println("测试结果-------" + b);
		System.err.println("测试结束<<<<<<<<<<<<");
	}


	@Test
	public void test_IChargerOrderService_C(){
		System.err.println("测试开始>>>>>>>>>>>>");
		ChargerOrder chargerOrder = new ChargerOrder();
		chargerOrder.setId(1L);
		chargerOrder.setChargerId("1");
		chargerOrder.setCreateTime(new Date());
		chargerOrder.setCustomerId(1L);
		chargerOrder.setElectricity(1);
		chargerOrder.setPrice(1);
		chargerOrder.setRemark("test_1");
		chargerOrder.setStationId(1L);
		chargerOrder.setStatus(1);
		boolean insert = chargerOrderService.insertSelective(chargerOrder);
		System.out.println("测试结果-------" + insert);
		System.err.println("测试结束<<<<<<<<<<<<");
	}

}
