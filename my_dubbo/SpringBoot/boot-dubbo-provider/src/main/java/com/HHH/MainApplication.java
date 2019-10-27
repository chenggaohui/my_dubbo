package com.HHH;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
@EnableDubbo //启动基于注解的dubbo功能
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(MainApplication.class,args);
    }
}
