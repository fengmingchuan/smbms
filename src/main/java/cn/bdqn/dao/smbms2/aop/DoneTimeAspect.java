package cn.bdqn.dao.smbms2.aop;


import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Slf4j
@Aspect
@Component
public class DoneTimeAspect {




    @Around("@annotation(doneTime)")
    public Object around(ProceedingJoinPoint joinPoint, DoneTime doneTime) throws Throwable {
        System.out.println("方法开始时间是:" + new Date());

        Object o = joinPoint.proceed();
        log.debug("Response args:{}", new Gson().toJson(o));
        System.out.println("方法结束时间是:" + new Date());
        log.debug("commons end:{}", new Gson().toJson(System.currentTimeMillis()));
        return o;
    }
}
