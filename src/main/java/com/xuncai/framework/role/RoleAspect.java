package com.xuncai.framework.role;

import com.xuncai.framework.exception.AuthException;
import com.xuncai.framework.redis.RedisUtil;
import com.xuncai.utils.Status;
import com.xuncai.utils.UserThreadLocal;
import com.xuncai.vo.UserData;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class RoleAspect {

    @Autowired
    private RedisUtil redisUtil;

    @Pointcut
    public void pointCut(){

    }

    @Before("execution(* com.xuncai.controller.*Controller.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //通过方法获取注解
        RequiresRoles annotation = method.getAnnotation(RequiresRoles.class);
        if(annotation != null){
            String token = UserThreadLocal.get();
            UserData userData = (UserData) redisUtil.get(token);
            if(userData != null){
                if(!String.valueOf(userData.getType()).equals(String.valueOf(annotation.type().getCode()))){
                    throw new AuthException(Status.NO_AUTH.getMsg());
                }
            }else{
                throw new AuthException(Status.NO_AUTH.getMsg());
            }
        }
    }
}
