package com.rtc.manager.controller;

import com.rtc.manager.service.Elasticsearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ChenHang
 */
@ApiIgnore
@RestController
@RequestMapping("es")
public class ElasticsearchController {

    @Autowired
    private Elasticsearch elasticsearch;


    @GetMapping("test")
    public String test() {
        elasticsearch.addTest();
        return "喵帕斯";
    }
}
