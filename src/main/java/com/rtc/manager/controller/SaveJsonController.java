package com.rtc.manager.controller;

import com.rtc.manager.service.SaveJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;

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
    public String saveJson(@RequestParam(name = "dirPath", required = true) String dirPath) {
        String errorName = "";
        try {
            File fileDirPath = new File(dirPath);
            if (fileDirPath.exists()) {
                File[] files = fileDirPath.listFiles();
                for (File file :
                        files) {
                    // 忽略mac的隐藏文件
                    if (file.getName().contains(".DS_Store")) {
                        continue;
                    }
                    logger.debug("开始saveJson，文件是{}", file.getName());
                    saveJson.readJson(file);
                    logger.debug("结束saveJson，文件是{}", file.getName());
                    errorName = file.getName();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("错误，文件是{}", errorName);
            System.out.println("错误，文件是" + errorName);
        }
        return "导入成功";
    }


    @GetMapping("/test")
    public String test() {
        return saveJson.getTest();
    }
}
