package com.maaz.JobApp_Java.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoggingAspect.class);

    //Return type, class-name.method-name(args)

    @Before("execution (* com.maaz.JobApp_Java.service.JobService.addJob(..)) || execution (* com.maaz.JobApp_Java.service.JobService.getAllJobPost(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called! "+ jp.getSignature().getName());
    }

    @After("execution (* com.maaz.JobApp_Java.service.JobService.addJob(..)) || execution (* com.maaz.JobApp_Java.service.JobService.getAllJobPost(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method called! After Executed "+ jp.getSignature().getName());
    }

    @AfterThrowing("execution (* com.maaz.JobApp_Java.service.JobService.addJob(..)) || execution (* com.maaz.JobApp_Java.service.JobService.getAllJobPost(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method called! After Crash "+ jp.getSignature().getName());
    }

    @AfterReturning("execution (* com.maaz.JobApp_Java.service.JobService.addJob(..)) || execution (* com.maaz.JobApp_Java.service.JobService.getAllJobPost(..))")
    public void logMethodAfterSuccess(JoinPoint jp){
        LOGGER.info("Method called! After Success "+ jp.getSignature().getName());
    }

}
