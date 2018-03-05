package com.qianxin.redis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 5264880068131744424L;

    /** 订单编号 */
    private Long id;

    /** 订单金额 */
    private Integer price;

    /** 订单电量 */
    private Integer electricity;

    /** 状态 */
    private Integer status;

    /** 备注 */
    private String remark;

    /** 订单创建时间 */
    private Date createTime;

}
