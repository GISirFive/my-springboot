package com.qianxin.web.entity.dto;

import com.qianxin.web.config.mvc.validator.First;
import com.qianxin.web.config.mvc.validator.Second;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ApiModel(value = "User", description = "用户实体")
public class User implements Serializable {

    private static final long serialVersionUID = 2975584418584260548L;

    @ApiModelProperty(value = "id", name = "用户ID", required = false, example = "1")
    private Long id;

    @NotNull(message = "数据不能为空", groups = {First.class, Second.class})
    @Size(max = 10, min = 2, groups = {First.class, Second.class}, message = "{resource.sort.null}")
    @ApiModelProperty(value = "name", name = "用户名", required = false, example = "123")
    private String name;

    @NotNull(message = "数据不能为空", groups = {First.class})
    @Max(value = 99,message = "最大值为 99", groups = {First.class})
    @Min(value = 0, groups = {First.class})
    @ApiModelProperty(value = "age", name = "年龄", required = false, example = "12")
    private Integer age;

    @NotNull(message = "数据不能为空", groups = {First.class})
    //@Email(message = "123456", groups = {First.class})
    @ApiModelProperty(value = "email", name = "邮箱", required = false, example = "Qinhua_Zhao@outlook.com")
    private String email;
}
