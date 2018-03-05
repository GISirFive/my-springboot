package com.qianxin.multdatasource.service;

import org.springframework.stereotype.Service;

import com.qianxin.multdatasource.mapper.master.CardMapper;
import com.qianxin.multdatasource.entity.Card;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Card 表数据服务层接口实现类
 *
 */
@Service
public class CardServiceImpl extends SuperServiceImpl<CardMapper, Card> implements ICardService {

}