package com.qianxin.mybatisplus.service;

import org.springframework.stereotype.Service;

import com.qianxin.mybatisplus.mapper.ChargerOrderMapper;
import com.qianxin.mybatisplus.entity.ChargerOrder;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * ChargerOrder 表数据服务层接口实现类
 *
 */
@Service
public class ChargerOrderServiceImpl extends SuperServiceImpl<ChargerOrderMapper, ChargerOrder> implements IChargerOrderService {

}