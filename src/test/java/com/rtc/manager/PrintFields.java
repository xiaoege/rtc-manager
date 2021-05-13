package com.rtc.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rtc.manager.dao.america.washington.AmericaWashingtonGovernorMapper;
import com.rtc.manager.entity.*;
import com.rtc.manager.entity.america.louisiana.AmericaLouisiana;
import com.rtc.manager.entity.america.louisiana.AmericaLouisianaRegisteredAgent;
import com.rtc.manager.entity.america.utah.AmericaUtah;
import com.rtc.manager.entity.america.vermount.AmericaVermount;
import com.rtc.manager.entity.america.virginia.AmericaVirginia;
import com.rtc.manager.entity.america.washington.AmericaWashington;
import com.rtc.manager.entity.america.washington.AmericaWashingtonGovernor;
import com.rtc.manager.entity.dto.*;
import com.rtc.manager.entity.india.*;
import com.rtc.manager.entity.vietnam.*;
import com.rtc.manager.entity.canada.*;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import com.rtc.manager.vo.canada.CanadaCorporateHistoryVO;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Formatter;

/**
 * @author ChenHang
 */
public class PrintFields {
    public static void main(String[] args) {
        print(QccKeyman.class);
    }

    private static void print(Class c) {
//        Arrays.stream(c.getDeclaredFields()).forEach(q -> System.out.println(q.getName()));
        print2Json(c);

    }

    /**
     * @exception NullPointerException if <code>c</code> is null
     * @param c
     *
     */
    private static void print2Json(Class c) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(c.getConstructor(null).newInstance()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}