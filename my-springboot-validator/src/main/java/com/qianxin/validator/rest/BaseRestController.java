package com.qianxin.validator.rest;

import com.alibaba.fastjson.JSON;
import com.qianxin.validator.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@ResponseBody
public class BaseRestController {

    @PostMapping
    /*@ResponseStatus(value = HttpStatus.CREATED)*/
    public String putUser(@RequestBody @Validated User user){
        return JSON.toJSONString(user);
    }

    @GetMapping(value = "/{id}")
    public String get(@PathVariable long id){
        return String.valueOf(id);
    }
}
