package com.xuncai.utils;

public class Result {
    //后端往前端返回的数据
    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result ok(){
        return new Result(Status.SUCCESS.getCode(),Status.SUCCESS.getMsg(),null);
    }
    public static Result ok(Object data){
        return new Result(Status.SUCCESS.getCode(),Status.SUCCESS.getMsg(),data);
    }
    public static Result error(){
        return new Result(Status.ERROR.getCode(),Status.ERROR.getMsg(),null);
    }
    public static Result error(String msg){
        return new Result(Status.ERROR.getCode(),msg,null);
    }
    public Result(Integer code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
