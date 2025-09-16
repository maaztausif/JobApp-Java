package com.maaz.JobApp_Java.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution (* com.maaz.JobApp_Java.service.JobService.getJob(..)) && args(postId)")
    public Object validationAndUpdate(ProceedingJoinPoint jp,Integer postId) throws Throwable {

        if(postId < 0){
            LOGGER.info("Post id is negative now I am making it Positive " + postId);
            postId = -postId;
            LOGGER.info("The new PostId is "+ postId);
        }
        Object obj =  jp.proceed(new Object[]{postId});
        return obj;
    }
}

