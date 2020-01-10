package com.xiangxue.jack.controllerAdvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.xiangxue.jack")
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler({ArrayIndexOutOfBoundsException.class})
    public @ResponseBody String handlerArrayIndexOutOfBoundsException(Exception e) {
        System.out.println("====ExceptionHandlerControllerAdvice-->" + e.getMessage());
        return "ArrayIndexOutOfBoundsException";
    }

    @ExceptionHandler({NullPointerException.class})
    public @ResponseBody String handlerNullPointerException(Exception e) {
        System.out.println("====ExceptionHandlerControllerAdvice-->" + e.getMessage());
        return "NullPointerException";
    }
}
