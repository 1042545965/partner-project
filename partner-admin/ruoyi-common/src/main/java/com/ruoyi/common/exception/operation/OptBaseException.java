package com.ruoyi.common.exception.operation;


import com.ruoyi.common.enums.operation.OptBaseExceptionEnum;

import java.io.Serializable;


/**
 * @author dkzadmin
 * 自定义订单异常抛出,逻辑处理层使用
 */
public class OptBaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 7265355637697200657L;
    private String message;
    private Integer code;


    /**
     * 项目基础异常类
     *
     * @param optBaseExceptionEnum
     */
    public OptBaseException(OptBaseExceptionEnum optBaseExceptionEnum) {
        this.code = optBaseExceptionEnum.getCode();
        this.message = optBaseExceptionEnum.getMessage();
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
