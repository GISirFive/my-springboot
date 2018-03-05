package com.qianxin.web.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class People implements Serializable{

    private static final long serialVersionUID = 3977535941664929087L;

    private String name;

    private Integer age;

    private Date birthday;
}
