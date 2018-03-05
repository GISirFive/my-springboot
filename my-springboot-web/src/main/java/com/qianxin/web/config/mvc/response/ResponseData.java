package com.qianxin.web.config.mvc.response;

import java.io.Serializable;


public class ResponseData<T> extends ResponseBase implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8389534598865802502L;

    private T data;

    public ResponseData() {

    }

    public ResponseData(T data, Integer code, String message) {
        super(code, message);
        this.data = data;
    }

    public static <T> ResponseData<T> success(T t) {
        return new ResponseData<T>(t, ResponseConstant.SUCCESS_CODE, ResponseConstant.SUCCESS_MSG);
    }

    public static <T> ResponseData<T> error() {
        return error(ResponseConstant.ERROR_MSG);
    }

    public static <T> ResponseData<T> error(String message) {
        return new ResponseData<T>(null, ResponseConstant.ERROR_CODE, message);
    }

    public static <T> ResponseData<T> logicError(String message) {
        return new ResponseData<T>(null, ResponseConstant.BUSINESS_ERROR, message);
    }

    public static <T> ResponseData<T> sysError(String message) {
        return new ResponseData<T>(null, ResponseConstant.SYSTEM_ERROR, message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
