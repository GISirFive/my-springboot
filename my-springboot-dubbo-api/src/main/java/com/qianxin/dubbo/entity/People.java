package com.qianxin.dubbo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class People implements Serializable{
    private static final long serialVersionUID = -1093732943886895715L;

    private String name;

    private Integer age;

    private Date birthday;
}
