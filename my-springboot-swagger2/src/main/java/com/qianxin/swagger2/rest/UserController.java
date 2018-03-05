package com.qianxin.swagger2.rest;

import com.qianxin.swagger2.entity.User;
import com.qianxin.swagger2.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户操作")
@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "创建用户")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User", paramType = "body")
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @ApiOperation(value = "更新用户")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User", paramType = "body")
    @PutMapping
    public User editUser(@RequestBody User user){
        return userService.editUser(user);
    }

    @ApiOperation(value = "获取所有用户")
    @GetMapping
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @ApiOperation(value = "根据id获取指定用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "long", paramType = "path")
    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @ApiOperation(value = "根据id删除指定用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "long", paramType = "path")
    @DeleteMapping(path = "/{id}")
    public User deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
