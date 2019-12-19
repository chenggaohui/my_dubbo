package com.HHH.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    String name="程高辉1";
    public UserController(){
        System.out.println(name);
    }
    public void getName(){
        System.out.println(name);
    }
}
