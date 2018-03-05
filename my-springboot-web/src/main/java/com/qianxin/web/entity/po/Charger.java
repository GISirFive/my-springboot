package com.qianxin.web.entity.po;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * 枪头数据表
 *
 */
@Data
@TableName("bs_charger")
public class Charger implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 主键ID */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/** 枪头名称 */
	private String name;

	/** 电压22330表示，223.3v, */
	private Integer voltage;

	/** 电流，100表示1a, */
	private Integer current;

	/** 电量，值：220，表示为：2.2KWH */
	private Integer electricity;

	/** 功率，值：33000，表示为：3.3KW */
	private Integer power;

	/** 状态 */
	private Integer status;

}
