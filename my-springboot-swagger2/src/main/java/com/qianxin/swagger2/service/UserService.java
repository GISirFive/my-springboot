package com.qianxin.swagger2.service;

import com.qianxin.swagger2.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User editUser(User user);

    List<User> getUserList();

    User getUser(Long id);

    User deleteUser(Long id);
}
