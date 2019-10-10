package com.HHH.echo.impl;
import com.HHH.echo.EchoService;
import org.apache.dubbo.rpc.RpcContext;

import java.text.SimpleDateFormat;
import java.util.Date;
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String message) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("["+now+"] Hello "+message+", request from consumer:"+ RpcContext.getContext().getRemoteAddress());
        return message;
    }
}
