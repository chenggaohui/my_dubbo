package com.HHH.service.impl;

import com.HHH.service.ConUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

import java.util.List;

@Service
public class ConUserServiceImpl implements ConUserService {
    @Autowired
    UserService userService;

    public List<User> getUserInfoByGender(char gender) {
        List<User> result = userService.getUserList(gender);
        return result;
    }
}
