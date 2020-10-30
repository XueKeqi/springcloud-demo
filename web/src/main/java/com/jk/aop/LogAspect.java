package com.jk.aop;

import com.alibaba.fastjson.JSONObject;
import com.jk.pojo.LogBean;
import com.jk.service.impl.LogSenderService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Autowired
    private LogSenderService logSenderService;

    @Pointcut(value="execution(* com.jk.controller.*.*(..))")
    public void logCut(){ }

    @AfterReturning(pointcut = "logCut()",returning = "obj")
    public void saveLog(JoinPoint joinPoint,Object obj){

        String MethodName=joinPoint.getClass().getName();
        String className=joinPoint.getTarget().getClass().getSimpleName();
        Object[] args= joinPoint.getArgs();
        StringBuffer requestPatams= new StringBuffer();
        for(int i=0;i<args.length;i++){
            requestPatams.append("第"+i+"个参数="+args[i]);
        }
        String responseParams=obj==null?"":obj.toString();
        LogBean log=  new LogBean();
        log.setClassName(className);
        log.setMethodName(MethodName);
        log.setRequestParam(responseParams);
        log.setResponseParan(responseParams);
        String logJson= JSONObject.toJSONString(log);
        logSenderService.send(logJson);
    }
}
