package com.HHH.service;

import pojo.User;

import java.util.List;

public interface ConUserService {
    List<User> getUserInfoByGender(char gender);
}
