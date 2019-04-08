package com.ruoyi.common.enums.operation;

/**
 * 20000 到 30000 之间定义为用户异常
 **/
public enum OptUserExceptionEnum {

    USER_NOT_EXIST(20001, "用户不存在"),

    USER_PASSWORD_ERROR(20002, "密码错误"),

    USER_REGISTER_ERROR(20003, "用户注册失败"),

    USER_NAME_NOT_NULL(20004, "用户名不能为null");

    private Integer code;

    private String message;

    private OptUserExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
