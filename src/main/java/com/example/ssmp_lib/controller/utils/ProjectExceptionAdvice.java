package com.example.ssmp_lib.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//抛异常后传给前端的格式与正常传递的格式一致，可方便前端人员管理

//作为springMVC的处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //拦截所有异常
    @ExceptionHandler//可指定异常
    R doException(Exception ex){
        //记录日记
        //通知运营
        //通知开发
        ex.printStackTrace();
        return new R(false,"服务器异常，请稍后再试");
    }

}
