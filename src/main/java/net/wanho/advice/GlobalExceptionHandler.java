package net.wanho.advice;

import net.wanho.vo.AjaxResult;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public AjaxResult handleException(Exception e) {
        e.printStackTrace();
        return AjaxResult.fail(e.getMessage());
    }

}
