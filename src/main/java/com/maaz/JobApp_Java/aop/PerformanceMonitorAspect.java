package com.maaz.JobApp_Java.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution (* com.maaz.JobApp_Java.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {

        Long startTime = System.currentTimeMillis();
        Object obj = jp.proceed();
        Long endTime = System.currentTimeMillis();

        LOGGER.info("Time Taken: " + jp.getSignature().getName() + " " + (endTime-startTime));
        return  obj;
    }
}
