package com.HHH.service.stub;

import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

import java.util.List;
public class UserServiceStub implements UserService{
    private final UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getUserList(char c) {
        System.out.println("通过存根~~~~~~~~~~~");
        return userService.getUserList(c);
    }
}
