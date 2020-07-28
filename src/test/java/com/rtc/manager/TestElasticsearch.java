package com.rtc.manager;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author ChenHang
 */
public class TestElasticsearch {

    @Value("${rtc.url}")
    private static String HOST;
    private static Integer PORT = 9200;
    private String INDEX_NAME = "cat";


    public static void main(String[] args) {

    }
}
