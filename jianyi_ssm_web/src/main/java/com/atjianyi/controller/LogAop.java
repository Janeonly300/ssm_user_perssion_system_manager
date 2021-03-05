package com.atjianyi.controller;

import com.atjianyi.pojo.SystemLog;
import com.atjianyi.service.SystemLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author 简一
 * @className LogAop
 * @Date 2021/3/5 15:04
 **/
@Component
@Aspect
public class LogAop {
    private Date visitTime; //访问时间
    private Class clazz; //访问的类
    private Method method;
    private String userName;
    private String url;
    private long executeTime; //执行的时间
    private String ip; //Ip地址

    @Autowired
    private HttpServletRequest req;
    @Autowired
    private SystemLogService service;

    @Pointcut("execution(* com.atjianyi.controller.*.*(..))")
    private void P1(){}

    /**
     * 前置通知
     * @param pjp
     */
    @Before("P1()")
    private void beforAdvice(JoinPoint pjp) throws NoSuchMethodException {
        Object[] objs = pjp.getArgs();
        //获取访问时间
        visitTime = new Date();
        //获取当前访问
        clazz = pjp.getTarget().getClass();
        //获取方法名称
        String methodName = pjp.getSignature().getName();
        if(clazz!=null&&clazz!=LogAop.class){
            if(objs!=null && objs.length>0){
                //有参数的方法
                Class[] argsClass = new Class[objs.length];
                for (int i = 0 ; i<objs.length;i++){
                    argsClass[i] = objs[i].getClass();
                }
                method = clazz.getMethod(methodName,argsClass);
            }else{
                //无参数的方法
                method = clazz.getMethod(methodName);
            }
        }
    }


    /**
     * 后置通知
     * @param pjp
     */
    @After("P1()")
    private void afterReturn(JoinPoint pjp) {
        //执行时间
        executeTime = new Date().getTime() - visitTime.getTime();
        //获取URL(RequestMapping上)
        if(clazz!=null && method !=null && clazz!=LogAop.class){
            //获取类上和方法上的注解
            RequestMapping classAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null && methodAnnotation!=null){
                String[] value = classAnnotation.value();
                String[] value1 = methodAnnotation.value();
                url = value[0]+value1[0];
            }
        }
        //获取用户名
        userName = getUserInfoName();
        ip = req.getRemoteAddr(); //获取Ip
        saveSystemLog();
    }

    private void saveSystemLog(){
        SystemLog systemLog = new SystemLog();
        systemLog.setSystemLogExecutionTime(executeTime);
        systemLog.setSystemLogIp(ip);
        systemLog.setSystemLogMethod("[类名:]"+clazz.getName()+"[方法:]"+method.getName());
        systemLog.setSystemLogUrl(url);
        systemLog.setSystemLogUserName(userName);
        systemLog.setSystemLogVisitTime(visitTime);

        //调用LogService进行存储
        service.insertSystemLog(systemLog);
    }


    /**
     * 获取用户名
     */
    private String getUserInfoName(){
        SecurityContext context = SecurityContextHolder.getContext();
        User principal = (User)context.getAuthentication().getPrincipal();
        return principal.getUsername();
    }

}
