package com.rtc.manager.controller;

import com.rtc.manager.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenHang
 */
@RestControllerAdvice
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e) {
        e.printStackTrace();
        String exceptionInfo = CommonUtils.getExceptionInfo(e);

        logger.debug(exceptionInfo);
        logger.info(exceptionInfo);

        Map map = new HashMap();
        map.put("message", "请求失败");
        map.put("data", null);
        map.put("code", 500);
        return map;
    }


}
