package com.rtc.manager.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.entity.dto.LoggerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.Map;

/**
 * @author ChenHang
 */
public class LogInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            ObjectMapper objectMapper = new ObjectMapper();
            String paramStr = objectMapper.writeValueAsString(parameterMap);

            Principal userPrincipal = request.getUserPrincipal();
            String userPhone = "";
            if (userPrincipal != null) {
                userPhone = userPrincipal.getName();
            }

            StringBuilder body = new StringBuilder();
//            InputStream in = request.getInputStream();
//            byte[] bytes = new byte[1024];
//            for (int i; (i = in.read(bytes)) != -1; ) {
//                body.append(new String(bytes, 0, i));
//            }
//
//            in.close();

//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            String invoke = handlerMethod.toString();

//            LoggerDTO loggerDTO = new LoggerDTO(userPhone, paramStr, body.toString(), invoke);

//            logger.info("{}", loggerDTO.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
