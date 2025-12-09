package com.example.exception;

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    //处理异常
    @ExceptionHandler
    public Result ex(Exception e){//方法形参中指定能够处理的异常类型
        log.error("捕获到异常: {}", e.getMessage());
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }

    @ExceptionHandler
    public Result duplicateKeyException(DuplicateKeyException e){//方法形参中指定能够处理的异常类型
        log.error("捕获到异常: {}", e.getMessage());
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,数据重复,请检查后重新添加");
    }


}