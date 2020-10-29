package com.jk.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogSenderServiceImpl implements RabbitTemplate.ReturnCallback{
    @Autowired
    private RabbitTemplate rabbitTemplate;




    public void send(String logSoin){
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if(ack){
               System.out.println("消息发送成功");
            }else{
                System.out.println("消息发送失败，原因"+cause+correlationData.toString());
            }
        });
        rabbitTemplate.convertAndSend("5_xiao",logSoin);
    }


    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
    System.out.println("Acksender returnedMessage"+message.toString()+"===="+i+"===="+s1+"=="+s2);
    }
}
