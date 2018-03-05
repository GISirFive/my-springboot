package com.qianxin.validator.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 2975584418584260548L;

    @NotNull(message = "数据不能为空")
    @Size(max = 10, min = 2)
    private String name;

    @NotNull(message = "数据不能为空")
    @Max(value = 99,message = "最大值为 99")
    @Min(0)
    private Integer age;

    @NotNull(message = "数据不能为空")
    @Email
    private String email;
}
