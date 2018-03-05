package com.qianxin.web.config.mvc;

import com.qianxin.web.exception.MineException;
import com.qianxin.web.config.mvc.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionConfig {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseData<Object> ErrorHandle(HttpServletRequest request, MethodArgumentNotValidException e) throws Exception{
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        StringBuffer errorMsg = new StringBuffer();
        fieldErrors.stream().forEach(x -> errorMsg.append(x.getObjectName()).append(".").append(x.getField()).append(x.getDefaultMessage()));
        return ResponseData.error(errorMsg.toString());
    }

    /**
     * 捕获自定义异常，返回json信息
     */
    @ExceptionHandler(value = MineException.class)
    @ResponseBody
    public ResponseData<Object> ErrorHandle(HttpServletRequest request, MineException e) throws Exception{
        return ResponseData.error("Not Found Exception !!!");
    }

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public ResponseData<Object> ErrorHandle(HttpServletRequest request, ArithmeticException e) throws Exception{
        return ResponseData.error("java.lang.ArithmeticException: / by zero !!!");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData<Object> ErrorHandle(HttpServletRequest request, Exception e) throws Exception{
        return ResponseData.error("系统繁忙!!!");
    }

    /**
     * @ExceptionHandler用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
     */
/*    @ExceptionHandler(value = Exception.class)
    public ModelAndView ErrorHandle(HttpServletRequest request, Exception e) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        ErrorMassage<Object> errorMassage = new ErrorMassage<>();
        errorMassage.setCode(400);
        errorMassage.setMessage("系统异常 !!!");
        errorMassage.setUrl(request.getRequestURI());
        errorMassage.setData(e);
        modelAndView.addObject(errorMassage);
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }*/
}
