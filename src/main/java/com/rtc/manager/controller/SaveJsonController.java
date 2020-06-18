package com.rtc.manager.controller;

import com.rtc.manager.service.SaveJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenHang
 */
@RestController
@RequestMapping("/savejson")
public class SaveJsonController {
    //test git push
    @Autowired
    private SaveJson saveJson;

    @PostMapping("/saveJson")
    public String saveJson() {
        return "";
    }

    @GetMapping("/test")
    public String test() {
        return saveJson.getTest();
    }
}
