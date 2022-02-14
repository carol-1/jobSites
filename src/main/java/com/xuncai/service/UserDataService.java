package com.xuncai.service;

import com.xuncai.framework.exception.TokenException;
import com.xuncai.framework.redis.RedisUtil;
import com.xuncai.utils.Status;
import com.xuncai.utils.UserThreadLocal;
import com.xuncai.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    @Autowired
    private RedisUtil redisUtil;

    public UserData getUserData(){
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        if(userData != null){
            return userData;
        }else{
            throw new TokenException(Status.TOKEN_ERROR.getMsg());
        }
    }
}
