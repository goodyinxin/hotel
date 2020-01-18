package com.example.hotel.config;

import com.example.hotel.utils.Result;
import com.example.hotel.utils.State;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*统一异常处理*/
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(e.getMessage(), State.FAIL.INFO());

    }


}
