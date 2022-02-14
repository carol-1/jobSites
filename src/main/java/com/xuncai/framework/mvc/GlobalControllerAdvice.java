package com.xuncai.framework.mvc;

import com.xuncai.framework.exception.TokenException;
import com.xuncai.utils.Result;
import com.xuncai.utils.Status;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.message.AuthException;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public Result handle(TokenException exception){
        return Result.fail(Status.TOKEN_ERROR.getCode(),Status.TOKEN_ERROR.getMsg());
    }
    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public Result handle(AuthException exception){
        return Result.fail(Status.NO_AUTH.getCode(),Status.NO_AUTH.getMsg());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result handle(RuntimeException exception){
        exception.printStackTrace();
        return Result.fail(exception.getMessage());
    }
}
