package com.HHH;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
public class RchoProvider {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springConfig/echo-provider.xml"});
        context.start();
        System.in.read();
    }

}
