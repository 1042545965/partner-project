package com.partner.config;

import com.ruoyi.common.core.result.RestResponseBo;
import com.ruoyi.common.exception.operation.OptBaseException;
import com.ruoyi.common.exception.operation.OptUserException;
import com.ruoyi.common.exception.operation.OrderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  conlon
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public RestResponseBo exception(Exception e){
        LOGGER.error("find exception:e={}",e.getMessage());
        e.printStackTrace();
        return RestResponseBo.fail(500);
    }

    @ExceptionHandler(OrderException.class)
    public RestResponseBo storeExceptionHandler(OrderException ex) {
        LOGGER.error("find orderException:e={}", ex.getMessage());
        return RestResponseBo.fail(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(OptBaseException.class)
    public RestResponseBo optBaseExceptionHandler(OptBaseException ex) {
        LOGGER.error("find optBaseException:e={}", ex.getMessage());
        return RestResponseBo.fail(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(OptUserException.class)
    public RestResponseBo OptUserException(OptUserException ex) {
        LOGGER.error("find optBaseException:e={}", ex.getMessage());
        return RestResponseBo.fail(ex.getCode(), ex.getMessage());
    }

}