package com.rtc.manager.controller;

import com.rtc.manager.service.Elasticsearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.web.bind.annotation.*;
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


    @PostMapping("add")
    public String add() throws Exception {
        elasticsearch.addTest();
        return "喵帕斯";
    }

    @GetMapping("get")
    public Object get() throws Exception {
        elasticsearch.getTest();
        return "喵喵喵";
    }

    @GetMapping("search")
    public Object search(String index, String field, String value) throws Exception {
        return elasticsearch.search(index, field, value);
    }


    @PutMapping("modify")
    public Object modify(String index, String document) throws Exception {

        return elasticsearch.modify(index, document);
    }

    @DeleteMapping("remove")
    public Object remove(String index, String document) throws Exception {

        return elasticsearch.remove(index, document);
    }
}
