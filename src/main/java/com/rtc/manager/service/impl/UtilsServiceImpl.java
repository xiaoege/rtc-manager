package com.rtc.manager.service.impl;

import com.rtc.manager.dao.RtcRefCountryMapper;
import com.rtc.manager.dao.utils.UtilsMapper;
import com.rtc.manager.entity.RtcRefCountry;
import com.rtc.manager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author ChenHang
 */
@Service
public class UtilsServiceImpl implements UtilsService {
    @Autowired
    private UtilsMapper utilsMapper;

    @Autowired
    private RtcRefCountryMapper rtcRefCountryMapper;

    @Override
    public HashMap getAccessKey(String account) {
        return utilsMapper.selectAccessKey(account);
    }

    /**
     * 根据field类型来获得相应field的list
     * @param field 指定字段
     * @return 指定字段的list
     */
    @Override
    public List<String> getRtcRefCountry(String field) {
        List<RtcRefCountry> rtcRefCountries = rtcRefCountryMapper.selectRtcRefCountries();
        Field[] declaredFields = RtcRefCountry.class.getDeclaredFields();
        List<String> resultList = null;
        if (Arrays.stream(declaredFields).anyMatch(f -> f.getName().equals(field))) {
            resultList = new ArrayList();
            for (int i = 0; i < rtcRefCountries.size(); i++) {
                RtcRefCountry rtcRefCountry = rtcRefCountries.get(i);
                Class clazz = RtcRefCountry.class;
                try {
                    Method method = clazz.getDeclaredMethod("get" + field.substring(0, 1).toUpperCase() + field.substring(1).toLowerCase());
                    String invoke = (String) method.invoke(rtcRefCountry);
                    resultList.add(invoke);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return resultList;
    }

    /**
     * 根据es的index返回mysql表名
     * @return
     */
    @Override
    public String getTb(String index) {
        List<RtcRefCountry> rtcRefCountries = rtcRefCountryMapper.selectRtcRefCountries();
        for (int i = 0; i < rtcRefCountries.size(); i++) {
            RtcRefCountry rtcRefCountry = rtcRefCountries.get(i);
            if (rtcRefCountry.getIdx().equals(index)) {
                return rtcRefCountry.getTb();
            }
        }
        return null;
    }
}
