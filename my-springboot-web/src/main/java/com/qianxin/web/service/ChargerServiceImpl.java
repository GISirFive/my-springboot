package com.qianxin.web.service;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.qianxin.web.entity.po.Charger;
import com.qianxin.web.mapper.jdbc.ChargerMapper;
import org.springframework.stereotype.Service;

/**
 *
 * Charger 表数据服务层接口实现类
 *
 */
@Service
public class ChargerServiceImpl extends SuperServiceImpl<ChargerMapper, Charger> implements IChargerService {

}