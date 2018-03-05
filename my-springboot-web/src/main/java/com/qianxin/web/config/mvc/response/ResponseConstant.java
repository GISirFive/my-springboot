package com.qianxin.web.config.mvc.response;

public interface ResponseConstant {
    /**返回编码：成功**/
    Integer SUCCESS_CODE = 0;
    /**失败**/
    Integer ERROR_CODE = 1;
    int SESSION_DISABLED = 2;//登录超时
    int BUSINESS_ERROR = 3;//逻辑异常
    int SYSTEM_ERROR = 4;//系统错误
    int ACCESS_ERROR = 5;//无权限
    int CHECK_CODE_ERROR = 6;//验证码错误
    int TOKEN_NULL_ERROR = 7;//TOKEN为空
    int ACCOUNT_NOT_EXIST = 8;//用户名不存在
    int PASSWORD_ERROR = 9;//密码错误
    int PARAMETEN_MISS = 10;//没有传必要的参数
    int PARAMETEN_TYPE_ERROR = 11;//参数类型错误
    /**返回信息：成功**/
    String SUCCESS_MSG = "成功";
    String ERROR_MSG = "失败";
    String SESSION_DISABLED_MSG = "登录超时";
    String BUSINESS_ERROR_MSG = "逻辑异常";
    String SYSTEM_ERROR_MSG = "系统异常";
    String ACCESS_MSG = "无权限";
    String CHECK_CODE_ERROR_MSG = "验证码错误";
    String TOKEN_NULL_ERROR_MSG = "登录信息已过期";
    String ACCOUNT_NOT_EXIST_MSG = "用户不存在";
    String PASSWORD_ERROR_MSG = "密码错误";
    String PARAMETEN_MISS_MSG = "参数不完整";
    String PARAMETEN_TYPE_ERROR_MSG = "参数类型错误";//参数类型错误

}
