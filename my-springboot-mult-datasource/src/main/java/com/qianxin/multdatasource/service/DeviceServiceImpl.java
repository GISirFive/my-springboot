package com.qianxin.multdatasource.service;

import org.springframework.stereotype.Service;

import com.qianxin.multdatasource.mapper.second.DeviceMapper;
import com.qianxin.multdatasource.entity.Device;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Device 表数据服务层接口实现类
 *
 */
@Service
public class DeviceServiceImpl extends SuperServiceImpl<DeviceMapper, Device> implements IDeviceService {

}