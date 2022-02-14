package com.xuncai.framework.role;

public enum Role {

    ADMIN(0,"ADMIN"),
    COMPANY(1,"COMPANY"),
    STUDENT(2,"STUDENT");

    private Integer code;
    private String type;

    Role(Integer code, String type) {
        this.code = code;
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
