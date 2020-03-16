package com.HHH.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import pojo.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
@Service //dubbo家的注解Service，作用暴露服务接口
@Component
public class UserServiceImpl implements UserService
{
    static User user;
    static List<User> finalList=new ArrayList<User>();
    static{
        for(int i=0;i<19;i++){

            user=new User("我叫"+i,i%2==1?15:18,"长安街"+i+i+"号",i%2==1?'男':'女',i*521+"");
            finalList.add(user);
        }
    }
    public List<User> getUserList(char gender) {
        List<User> result=new ArrayList<User>();
        for (User u:finalList){
            if (u.getGender()==gender){
                result.add(u);
            }
        }
        return result;
    }
}
