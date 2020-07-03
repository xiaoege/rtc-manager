package com.rtc.manager.controller;

import com.rtc.manager.service.SaveJson;
import com.rtc.manager.util.CommonUtils;
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

    /**
     * 解析json文件导入到数据库
     *
     * @param dirPath json文件上一级文件夹路径，里面只能有json文件
     * @return
     */
    @PostMapping("/saveJson")
    public String saveJson(@RequestParam(name = "dirPath", required = true) String dirPath) {
        try {
            File fileDirPath = new File(dirPath);
            if (fileDirPath.exists()) {
                File[] files = fileDirPath.listFiles();
                saveJson.readJson(files);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("错误，", CommonUtils.getExceptionInfo(e));
        }
        return "导入成功";
    }

}
