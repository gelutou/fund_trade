package com.zw.ft.common.web;

import com.zw.ft.common.exception.ServiceException;
import com.zw.ft.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice(basePackages = "com.zw.ft.modules.*.controller")
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理 ServiceException 异常
     */
    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public R serviceExceptionHandler(HttpServletRequest req, ServiceException ex) {
        logger.debug("[serviceExceptionHandler]", ex);
        // 包装 CommonResult 结果
        return R.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理 MissingServletRequestParameterException 异常
     *
     * SpringMVC 参数不正确
     */
    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public R missingServletRequestParameterExceptionHandler(HttpServletRequest req, MissingServletRequestParameterException ex) {
        logger.debug("[missingServletRequestParameterExceptionHandler]", ex);
        // 包装结果
        return R.error(4001,
                ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public R constraintViolationExceptionHandler(HttpServletRequest req, ConstraintViolationException ex) {
        logger.debug("[constraintViolationExceptionHandler]", ex);
        // 拼接错误
        StringBuilder detailMessage = new StringBuilder();
        for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
            // 使用 ; 分隔多个错误
            if (detailMessage.length() > 0) {
                detailMessage.append(";");
            }
            // 拼接内容到其中
            detailMessage.append(constraintViolation.getMessage());
        }
        // 包装结果
        return R.error(4002,
                 "Invalid Request Parameter :" + detailMessage.toString());
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public R bindExceptionHandler(HttpServletRequest req, BindException ex) {
        logger.debug("[bindExceptionHandler]", ex);
        // 拼接错误
        StringBuilder detailMessage = new StringBuilder();
        for (ObjectError objectError : ex.getAllErrors()) {
            // 使用 ; 分隔多个错误
            if (detailMessage.length() > 0) {
                detailMessage.append(";");
            }
            // 拼接内容到其中
            detailMessage.append(objectError.getDefaultMessage());
        }
        // 包装 CommonResult 结果
        return R.error(4002,
                "Invalid Request Parameter :" + detailMessage.toString());
    }

    /**
     * 处理其它 Exception 异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public R exceptionHandler(HttpServletRequest req, Exception e) {
        // 记录异常日志
        logger.error("[exceptionHandler]", e);
        // 返回 ERROR CommonResult
        return R.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

}
