package com.qianxin.web.service;

import com.qianxin.web.entity.dto.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User editUser(User user);

    List<User> getUserList();

    User getUser(Long id);

    User deleteUser(Long id);
}
