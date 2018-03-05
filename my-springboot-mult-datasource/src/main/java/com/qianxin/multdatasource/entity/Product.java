package com.qianxin.multdatasource.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 *
 * 产品系列
 *
 */
@Data
@TableName("t_product")
public class Product implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** id */
	@TableId(type = IdType.AUTO)
	private Long id;

	/** 产品名称 */
	private String name;

	/** 注册码 */
	@TableField(value = "pass_number")
	private String passNumber;

	/** 备注 */
	private String remake;

	/** 创建人 */
	private String creator;

	/** 创建时间 */
	@TableField(value = "create_time")
	private Date createTime;

}
