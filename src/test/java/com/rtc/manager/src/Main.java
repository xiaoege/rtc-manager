package com.rtc.manager.src;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.src.com.baidu.translate.demo.TransApi;
import com.rtc.manager.util.baidutranslate.BaiduTranslatePOJO;
import com.rtc.manager.util.baidutranslate.TransResult;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20200722000524091";
    private static final String SECURITY_KEY = "fzXcZ4t3jWGnRP0cIVIn";

    public static void main(String[] args) throws UnsupportedEncodingException, JsonProcessingException {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "喵帕斯第一集";
        query = "重庆市九龙坡区石桥铺渝州路4号11-8号";
        String s = api.getTransResult(query, "zh", "en");
        System.out.println(s);
        ObjectMapper objectMapper = new ObjectMapper();
        BaiduTranslatePOJO baiduTranslatePOJO = objectMapper.readValue(s, BaiduTranslatePOJO.class);
        System.out.println(baiduTranslatePOJO);
        if (baiduTranslatePOJO != null) {
            List transResult = (List) baiduTranslatePOJO.getTrans_result();
            if (!CollectionUtils.isEmpty(transResult)) {
                TransResult o = (TransResult)transResult.get(0);
                String src = o.getSrc();
                String dst = o.getDst();
                System.out.println(src);
                System.out.println(dst);
            }
        }
    }

}
