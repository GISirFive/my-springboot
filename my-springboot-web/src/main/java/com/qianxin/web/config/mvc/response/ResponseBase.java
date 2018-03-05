package com.qianxin.web.config.mvc.response;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class ResponseBase implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4992866296675736795L;
    /** 0成功，1失败,2没有登录 **/
    protected Integer code;
    /** 消息 **/
    protected String message;

    public ResponseBase() {
    }

    public ResponseBase(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseBase success() {
        return new ResponseBase(ResponseConstant.SUCCESS_CODE, ResponseConstant.SUCCESS_MSG);
    }

    public static ResponseBase erro() {
        return erro(ResponseConstant.ERROR_MSG);
    }

    public static ResponseBase erro(String message) {
        return new ResponseBase(ResponseConstant.ERROR_CODE, message);
    }

    public static ResponseBase loginTimeOut(){
        return new ResponseBase(ResponseConstant.SESSION_DISABLED, ResponseConstant.BUSINESS_ERROR_MSG);
    }

    public static ResponseBase logicalError(String msg){
        return new ResponseBase(ResponseConstant.BUSINESS_ERROR, msg);
    }

    public static ResponseBase logicalError(){
        return new ResponseBase(ResponseConstant.BUSINESS_ERROR, ResponseConstant.BUSINESS_ERROR_MSG);
    }

    public static ResponseBase systemError(String msg){
        return new ResponseBase(ResponseConstant.SYSTEM_ERROR, ResponseConstant.SYSTEM_ERROR_MSG);
    }

    public static ResponseBase accessError(String msg){
        return new ResponseBase(ResponseConstant.ACCESS_ERROR, ResponseConstant.ACCESS_MSG);
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

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
