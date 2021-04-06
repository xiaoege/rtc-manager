package com.rtc.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rtc.manager.entity.Qcc;
import com.rtc.manager.entity.QccBusinessInformation;
import com.rtc.manager.entity.QccShareholder;
import com.rtc.manager.entity.dto.*;
import com.rtc.manager.entity.india.*;
import com.rtc.manager.entity.vietnam.*;
import com.rtc.manager.entity.canada.*;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import com.rtc.manager.vo.canada.CanadaCorporateHistoryVO;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

/**
 * @author ChenHang
 */
public class PrintFields {
    public static void main(String[] args) {
        print(CanadaCorporateHistoryVO.class);
    }

    private static void print(Class c) {
//        Arrays.stream(c.getDeclaredFields()).forEach(q -> System.out.println(q.getName()));
        print2Json(QccShareholder.class);
        String json = "{\"喵\":{\"id\":66666666,\"enterpriseId\":null,\"name\":null,\"ratio\":null,\"subscribedCapital\":null,\"subscribedCapitalDate\":null,\"paidCapital\":null,\"paidCapitalDate\":null,\"subscribedCapitalWay\":null,\"paidCapitalWay\":null,\"gmtCreate\":null,\"gmtModified\":null,\"status\":null}}";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        try {
            QccShareholder qccShareholder = objectMapper.readValue(json, QccShareholder.class);
            System.out.println(json);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    private static void print2Json(Class c) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(c.getConstructor(null).newInstance()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
