package com.ruoyi.common.exception.operation;


import com.ruoyi.common.enums.operation.OrderExceptionEnum;

import java.io.Serializable;


/**
 * @author dkzadmin
 * 自定义订单异常抛出,逻辑处理层使用
 */
public class MessageException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = 7265355637697200657L;
    private String message;
    private Integer code;


    /**
     *  服务门店异常处理
     * @param orderExceptionEnum
     */
    public MessageException(OrderExceptionEnum orderExceptionEnum) {
        this.code = orderExceptionEnum.getCode();
        this.message = orderExceptionEnum.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
