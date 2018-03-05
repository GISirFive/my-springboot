package com.qianxin.mybatisplus.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 *
 * 订单基础信息表
 *
 */
@Data
@TableName("t_charger_order")
public class ChargerOrder implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 订单编号 */
	@TableId(type = IdType.INPUT)
	private Long id;

	/** 站点ID */
	@TableField(value = "station_id")
	private Long stationId;

	/** 用户ID */
	@TableField(value = "customer_id")
	private Long customerId;

	/** 充电接口(枪)编号 */
	@TableField(value = "charger_id")
	private String chargerId;

	/** 订单金额 */
	private Integer price;

	/** 订单电量 */
	private Integer electricity;

	/** 状态 */
	private Integer status;

	/** 备注 */
	private String remark;

	/** 订单创建时间 */
	@TableField(value = "create_time")
	private Date createTime;

}
