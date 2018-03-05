package com.qianxin.multdatasource;

import com.qianxin.multdatasource.entity.Card;
import com.qianxin.multdatasource.entity.Product;
import com.qianxin.multdatasource.service.ICardService;
import com.qianxin.multdatasource.service.IDeviceService;
import com.qianxin.multdatasource.service.IProductService;
import com.qianxin.multdatasource.service.ISiteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringbootMultDatasourceApplicationTests {

	/**
	 * master
	 */
	@Autowired
	private ICardService cardService;
	@Autowired
	private ISiteService siteService;

	/**
	 * second
	 */
	@Autowired
	private IProductService productService;
	@Autowired
	private IDeviceService deviceService;


	@Test
	public void contextLoads() {
	}



	@Test
	public void test_multDataSource(){
        System.err.println("测试开始>>>>>>>>>>>>");
		Card card = new Card();
		card.setCreateTime(new Date());
		card.setName("3");
		card.setPhone("3");
		card.setPrice(new BigDecimal(3));
		card.setStatus("3");
		card.setType(3);
		boolean isCardSuccess = cardService.insertSelective(card);
        System.out.println("测试(1)结果-------" + isCardSuccess);

		Product product = new Product();
		product.setCreateTime(new Date());
		product.setCreator("33");
		product.setName("33");
		product.setPassNumber("33");
		product.setRemake("33");
		boolean isProductSuccess = productService.insertSelective(product);
        System.out.println("测试(2)结果-------" + isProductSuccess);
        System.err.println("测试结束<<<<<<<<<<<<");
	}

}
