package com.rtc.manager.controller;

import com.rtc.manager.service.SaveJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author ChenHang
 */
@RestController
@RequestMapping("/savejson")
public class SaveJsonController {

    Logger logger = LoggerFactory.getLogger(SaveJsonController.class);

    @Autowired
    private SaveJson saveJson;

    @PostMapping("/saveJson")
    public String saveJson(@RequestParam(name = "dirPath", required = false) String dirPath) {
        try {
            logger.debug("get innnnnnnnnnnnnnn");
            saveJson.readJson();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    @GetMapping("/test")
    public String test() {
        return saveJson.getTest();
    }
}
