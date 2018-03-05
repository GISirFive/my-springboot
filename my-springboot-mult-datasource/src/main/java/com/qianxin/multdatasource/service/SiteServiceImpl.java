package com.qianxin.multdatasource.service;

import org.springframework.stereotype.Service;

import com.qianxin.multdatasource.mapper.master.SiteMapper;
import com.qianxin.multdatasource.entity.Site;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Site 表数据服务层接口实现类
 *
 */
@Service
public class SiteServiceImpl extends SuperServiceImpl<SiteMapper, Site> implements ISiteService {

}