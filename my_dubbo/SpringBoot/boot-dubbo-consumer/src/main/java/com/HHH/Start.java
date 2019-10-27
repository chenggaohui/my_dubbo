package com.HHH;

import com.HHH.service.ConUserService;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

import java.io.IOException;
import java.util.List;
@EnableDubbo //开启基于注解的dubbo功能
@SpringBootApplication
public class Start {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Start.class,args);
    }
}
