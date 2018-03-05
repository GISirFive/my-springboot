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
 * 站点
 *
 */
@Data
@TableName("t_site")
public class Site implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 站点编号 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/** 站点名称 */
	private String name;

	/** 经度 */
	private Double longitude;

	/** 纬度 */
	private Double latitude;

	/** 站点地址 */
	private String address;

	/** 服务号码 */
	private String phone;

	/** 站点状态 */
	private Integer status;

	/**  */
	private String remark;

	/** 创建时间 */
	@TableField(value = "create_time")
	private Date createTime;

}
