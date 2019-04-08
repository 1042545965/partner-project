package com.ruoyi.common.enums.operation;

/**
 * @program: springboot-parent
 * @description:
 * @author: conlon
 * @create: 2018-12-01 20:40
 * 20000 到 30000 之间定义为订单异常
 **/
public enum OrderExceptionEnum {

    ORDERINFO_INIT_FAILE(20001, "订单初始化失败"),

    ORDERINFO_INSERT_FAILE(20002, "订单保存失败"),

    ORDERINFO_UPDATE_FAILE(20003, "订单修改失败"),

    ORDERINFO_IS_NOT_FOUND_FAILE(20004, "订单不存在"),

    ORDERINFO_WX_PAY_XML_FAILE(20005, "订单在xml解析时出错"),

    FAILE(20, "失败");

    private Integer code;

    private String message;

    private OrderExceptionEnum(Integer code, String message) {
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
