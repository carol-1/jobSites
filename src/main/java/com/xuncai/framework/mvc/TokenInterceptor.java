package com.xuncai.framework.mvc;

import com.xuncai.framework.exception.TokenException;
import com.xuncai.framework.redis.RedisUtil;
import com.xuncai.utils.Status;
import com.xuncai.utils.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String token = request.getHeader("token");//token从这里拿
        boolean flag = redisUtil.hasKey(token);
        if(flag){
            UserThreadLocal.set(token);
            redisUtil.expire(token,redisUtil.EXPR);
        }else{
            throw new TokenException(Status.TOKEN_ERROR.getMsg());


        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        UserThreadLocal.remove();
    }
}
