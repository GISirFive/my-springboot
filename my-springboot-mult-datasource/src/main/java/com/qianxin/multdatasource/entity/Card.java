package com.qianxin.multdatasource.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 *
 * 卡片
 *
 */
@Data
@TableName("t_card")
public class Card implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 自动增长列 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/** 卡片名称 */
	private String name;

	/** 卡片类型 */
	private Integer type;

	/** 卡片面值 */
	private BigDecimal price;

	/** 卡状态 */
	private String status;

	/** 手机号 */
	private String phone;

	/** 创建时间 */
	@TableField(value = "create_time")
	private Date createTime;

}
