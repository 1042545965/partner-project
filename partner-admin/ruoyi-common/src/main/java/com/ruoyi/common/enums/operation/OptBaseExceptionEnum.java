package com.ruoyi.common.enums.operation;

/** dkz 基础异常处理
 * OptBaseExceptionEnum
 * 1000 - 10000 之间的异常码
 */
public enum OptBaseExceptionEnum {

    PARAMETER_ERROR(1000, "参数错误");

    private Integer code;

    private String message;

    private OptBaseExceptionEnum(Integer code, String message) {
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
