package com.qianxin.web.rest;

import com.qianxin.web.entity.dto.User;
import com.qianxin.web.service.UserService;
import com.qianxin.web.config.mvc.validator.First;
import com.qianxin.web.config.mvc.validator.Second;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户操作")
@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation(value = "创建用户")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User", paramType = "body")
    public User addUser(@RequestBody @Validated(value = First.class) User user){
        return userService.addUser(user);
    }

    @PutMapping
    @ApiOperation(value = "更新用户")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User", paramType = "body")
    public User editUser(@RequestBody @Validated(value = Second.class) User user){
        return userService.editUser(user);
    }

    @GetMapping
    @ApiOperation(value = "获取所有用户")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "根据id获取指定用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "long", paramType = "path")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "根据id删除指定用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "long", paramType = "path")
    public User deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
