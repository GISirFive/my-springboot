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
 * 设备信息
 *
 */
@Data
@TableName("t_device")
public class Device implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** id */
	@TableId(type = IdType.AUTO)
	private Long id;

	/** 设备名称 */
	private String name;

	/** 产品系列id */
	@TableField(value = "product_id")
	private String productId;

	/** 设备序列号 */
	@TableField(value = "serial_number")
	private String serialNumber;

	/** 固件版本 */
	@TableField(value = "firmware_version")
	private String firmwareVersion;

	/** 备注 */
	private String remark;

	/** 创建人 */
	private String creator;

	/** 创建时间 */
	@TableField(value = "create_time")
	private Date createTime;

}
