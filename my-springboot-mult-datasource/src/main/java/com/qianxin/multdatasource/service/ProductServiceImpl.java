package com.qianxin.multdatasource.service;

import org.springframework.stereotype.Service;

import com.qianxin.multdatasource.mapper.second.ProductMapper;
import com.qianxin.multdatasource.entity.Product;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Product 表数据服务层接口实现类
 *
 */
@Service
public class ProductServiceImpl extends SuperServiceImpl<ProductMapper, Product> implements IProductService {

}