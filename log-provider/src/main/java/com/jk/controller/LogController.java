package com.jk.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.pojo.LogBean;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogController {

    //监听方法
    @RabbitListener(queues = "2004-olg")
    public void hello(String mes) {
        System.out.println(mes);
    }

    @RabbitListener(queues = "2004-lgo")
    public void user(String mes){
        System.out.println(mes);
        LogBean user = JSONObject.parseObject(mes, LogBean.class);
        System.out.println(user);
    }


    @RabbitListener(queues = "2004-log")
    public void userList(String mes){
        System.out.println(mes);
        List<LogBean> userList = JSONArray.parseArray(mes, LogBean.class);
        System.out.println(userList);
    }
}
