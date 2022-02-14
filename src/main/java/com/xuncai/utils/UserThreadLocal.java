package com.xuncai.utils;

import com.xuncai.vo.UserData;

public class UserThreadLocal {

    //存放本地线程变量
    private static ThreadLocal<String> useThreadLocal = new ThreadLocal<>();

    public static void set(String token){
        useThreadLocal.set(token);
    }

    public static String get(){
        String token = useThreadLocal.get();
        return token;
    }

    public static void remove(){
        useThreadLocal.remove();
    }

}

