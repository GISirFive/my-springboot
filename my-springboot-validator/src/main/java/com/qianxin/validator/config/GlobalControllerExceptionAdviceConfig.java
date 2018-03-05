package com.qianxin.validator.config;

import com.qianxin.validator.msg.ErrorMassage;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestControllerAdvice(annotations = RestController.class)
public class GlobalControllerExceptionAdviceConfig {
    /**
     * http://blog.csdn.net/u012373815/article/details/72049796
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    public ErrorMassage<Object> ErrorHandle(HttpServletRequest request, MethodArgumentNotValidException e) throws Exception{
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        StringBuffer errorMsg = new StringBuffer();
        fieldErrors.stream().forEach(x -> errorMsg.append(x.getObjectName()).append(".").append(x.getField()).append(x.getDefaultMessage()));
        ErrorMassage<Object> errorMassage = new ErrorMassage<>();
        errorMassage.setCode(403);
        errorMassage.setMessage("Invalid argument: " + errorMsg.toString());
        errorMassage.setUrl(request.getRequestURL().toString());
        //errorMassage.setData(e);  此异常无法JSON化,存在循环依赖
        return errorMassage;
    }
}
