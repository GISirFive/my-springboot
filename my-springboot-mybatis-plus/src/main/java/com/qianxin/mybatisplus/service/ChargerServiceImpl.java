package com.qianxin.mybatisplus.service;

import org.springframework.stereotype.Service;

import com.qianxin.mybatisplus.mapper.ChargerMapper;
import com.qianxin.mybatisplus.entity.Charger;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Charger 表数据服务层接口实现类
 *
 */
@Service
public class ChargerServiceImpl extends SuperServiceImpl<ChargerMapper, Charger> implements IChargerService {

}