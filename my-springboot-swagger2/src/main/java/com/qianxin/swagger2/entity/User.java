package com.qianxin.swagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@Data
@ApiModel(value = "User", description = "用户实体")
public class User implements Serializable {

    private static final long serialVersionUID = 2975584418584260548L;

    @ApiModelProperty(value = "id", name = "用户ID", required = false, example = "1")
    private Long id;

    @ApiModelProperty(value = "name", name = "用户名", required = false, example = "123")
    private String name;

    @ApiModelProperty(value = "age", name = "年龄", required = false, example = "12")
    private Integer age;

    @ApiModelProperty(value = "email", name = "邮箱", required = false, example = "Qinhua_Zhao@outlook.com")
    private String email;
}
