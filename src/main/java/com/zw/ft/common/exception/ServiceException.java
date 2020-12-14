package com.zw.ft.common.exception;


import org.springframework.http.HttpStatus;

/*
 * 功能描述: <br>
 * 〈服务异常〉
 * @Author: Oliver
 * @Date: 2020/12/14 14:47
 */

public final class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 6508932456885124360L;
    /**
     * 错误码
     */
    private final Integer code;

    public ServiceException(HttpStatus httpStatus) {
        // 使用父类的 message 字段
        super(httpStatus.getReasonPhrase());
        // 设置错误码
        this.code = httpStatus.value();
    }

    public Integer getCode() {
        return code;
    }

}
