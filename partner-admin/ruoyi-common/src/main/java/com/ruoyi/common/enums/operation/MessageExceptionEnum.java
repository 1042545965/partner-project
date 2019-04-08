package com.ruoyi.common.enums.operation;

/**
 * @program: springboot-parent
 * @description:
 * @author: conlon
 * @create: 2018-12-01 20:40
 * 20000 到 30000 之间定义为订单异常
 **/
public enum MessageExceptionEnum {

    ORDERINFO_INIT_FAILE(20001, "订单初始化失败");

    private Integer code;

    private String message;

    private MessageExceptionEnum(Integer code, String message) {
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
