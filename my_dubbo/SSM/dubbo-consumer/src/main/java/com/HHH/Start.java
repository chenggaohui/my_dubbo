package com.HHH;

import com.HHH.service.ConUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

import java.io.IOException;
import java.util.List;

public class Start {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        ConUserService conUserService = context.getBean(ConUserService.class);
        List<User> result = conUserService.getUserInfoByGender('男');
        for (User user : result) {
            System.out.println(user.toString());
        }
        System.in.read();
    }
}
