package com.rtc.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.entity.dto.*;
import com.rtc.manager.entity.india.*;
import com.rtc.manager.entity.vietnam.*;
import com.rtc.manager.entity.canada.*;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import com.rtc.manager.vo.canada.CanadaCorporateHistoryVO;

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
//        print2Json(IndiaCin.class);

        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println(createTime);
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
