package com.qianxin.web.service;

import com.qianxin.web.entity.dto.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> userList;

    @PostConstruct
    public void initUser(){
        userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId((long)i);
            user.setName("name-" + i);
            user.setAge(i);
            user.setEmail("email-" + i);
            userList.add(user);
        }
    }

    @Override
    public User addUser(User user) {
        long maxId = userList.get(0).getId();
        for (User u : userList) {
            Long id = u.getId();
            if(id > maxId){
                maxId = id;
            }
        }
        user.setId(maxId + 1);
        userList.add(user);
        return user;
    }

    @Override
    public User editUser(User user) {
        userList.removeIf(value -> value.getId() == user.getId());
        userList.add(user);
        return user;
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }

    @Override
    public User getUser(Long id) {
        User findUser = null;
        for (User user : userList) {
            if(user.getId() == id){
                findUser = user;
            }
        }
        return findUser;
    }

    @Override
    public User deleteUser(Long id) {
        User findUser = null;
        for (User user : userList) {
            if(user.getId() == id){
                findUser = user;
            }
        }
        userList.removeIf(value -> value.getId() == id);
        return findUser;
    }
}
