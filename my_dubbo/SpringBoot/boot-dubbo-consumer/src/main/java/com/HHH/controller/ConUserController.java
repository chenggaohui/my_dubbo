package com.HHH.controller;

import com.HHH.service.ConUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;

import java.util.List;

@Controller
public class ConUserController {
    @Autowired
    ConUserService conUserService;
    @ResponseBody
    @RequestMapping("getUser")
    public List<User> getUserByGender(@RequestParam("gender") char gender){
        List<User> result = conUserService.getUserInfoByGender(gender);
        return result;
    }

}
