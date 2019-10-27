package service;

import pojo.User;

import java.util.List;

public interface UserService {
    List<User> getUserList(char gender);

}
