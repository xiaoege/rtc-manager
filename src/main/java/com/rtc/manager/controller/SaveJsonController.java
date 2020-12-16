package com.rtc.manager.controller;

import com.rtc.manager.service.SaveJson;
import com.rtc.manager.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;

/**
 * @author ChenHang
 */
@ApiIgnore
@RestController
@RequestMapping("/savejson")
public class SaveJsonController {

    Logger logger = LoggerFactory.getLogger(SaveJsonController.class);

    @Autowired
    private SaveJson saveJson;

    /**
     * 解析json文件导入到数据库
     * 中国企业
     *
     * @param dirPath json文件上一级文件夹路径，里面只能有json文件
     * @return
     */
    @PostMapping("/saveJson")
    public String saveJson(@RequestParam(name = "dirPath", required = true) String dirPath) {
        try {
            File fileDirPath = new File(dirPath);
            if (fileDirPath.exists()) {
                saveJson.readJson(fileDirPath);
            } else {
                return "路径错误";
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("错误，{}", CommonUtils.getExceptionInfo(e));
        }
        return "导入" + dirPath + "成功";
    }


    /**
     * 解析json文件导入到数据库
     * 印度企业
     *
     * @param dirPath json文件上一级文件夹路径，里面只能有json文件
     * @return
     */
    @PostMapping("/saveJsonIndia")
    public String saveJsonIndia(@RequestParam(name = "dirPath", required = true) String dirPath) {
        try {
            File fileDirPath = new File(dirPath);
            if (fileDirPath.exists()) {
                saveJson.readJsonIndia(fileDirPath);
            } else {
                return "路径错误";
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("错误，{}", CommonUtils.getExceptionInfo(e));
        }
        return "导入" + dirPath + "成功";
    }

    /**
     * 解析json文件导入到数据库
     * 越南企业
     *
     * @param dirPath json文件上一级文件夹路径，里面只能有json文件
     * @return
     */
    @PostMapping("/saveJsonVietnam")
    public String saveJsonVietnam(@RequestParam(name = "dirPath", required = true) String dirPath) {
        try {
            File fileDirPath = new File(dirPath);
            if (fileDirPath.exists()) {
                saveJson.readJsonVietnam(fileDirPath);
            } else {
                return "路径错误";
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("错误，{}", CommonUtils.getExceptionInfo(e));
        }
        return "导入" + dirPath + "成功";
    }

    /**
     * 解析json文件导入到数据库
     * 美国企业
     *
     * @param dirPath json文件上一级文件夹路径，里面只能有json文件
     * @return
     */
    @PostMapping("saveJsonAmerica")
    public String saveJsonAmerica(@RequestParam(name = "dirPath") String dirPath,
                                  @RequestParam(name = "type") String type,
                                  @RequestParam(name = "pojoType", required = false) String pojoType) {
        try {
            File fileDirPath = new File(dirPath);
            if (fileDirPath.exists()) {
                if ("Alabama".equals(type)) {
                    saveJson.saveJsonAmerica4Alabama(fileDirPath);
                }
                if ("NewHampshire".equals(type)) {
                    saveJson.saveJsonAmerica4NewHampshire(fileDirPath);
                }
                if ("NorthCarolina".equals(type)) {
                    saveJson.saveJsonAmerica4NorthCarolina(fileDirPath);
                }
                if ("Alaska".equals(type)) {
                    saveJson.saveJsonAmerica4Alaska(fileDirPath);
                }
                if ("AlaskaCSV".equals(type)) {
                    saveJson.saveJsonAmerica4AlaskaCSV(fileDirPath);
                }
                if ("WyomingCSV".equals(type)) {
                    saveJson.saveJsonAmerica4WyomingCSV(fileDirPath, pojoType);
                }
                if ("Florida".equals(type)) {
                    saveJson.saveJsonAmerica4Florida(fileDirPath);
                }
                if ("Ohio".equals(type)) {
                    saveJson.saveJsonAmerica4Ohio(fileDirPath);
                }
                if ("Oklahoma".equals(type)) {
                    saveJson.saveJsonAmerica4Oklahoma(fileDirPath);
                }
                if ("Delaware".equals(type)) {
                    saveJson.saveJsonAmerica4Delaware(fileDirPath);
                }
                if ("Oregon".equals(type)) {
                    saveJson.saveJsonAmerica4Oregon(fileDirPath);
                }
                if ("PuertoRico".equals(type)) {
                    saveJson.saveJsonAmerica4PuertoRico(fileDirPath);
                }
                if ("RhodeIsland".equals(type)) {
                    saveJson.saveJsonAmerica4RhodeIsland(fileDirPath);
                }
                if ("Minnesota".equals(type)) {
                    saveJson.saveJsonAmerica4Minnesota(fileDirPath);
                }
                if ("Mississippi".equals(type)) {
                    saveJson.saveJsonAmerica4Mississippi(fileDirPath);
                }
                if ("Michigan".equals(type)) {
                    saveJson.saveJsonAmerica4Michigan(fileDirPath);
                }
            } else {
                return "路径错误";
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("错误，{}", CommonUtils.getExceptionInfo(e));
        }
        return "导入" + dirPath + "成功";
    }

    /**
     * 解析json文件导入到数据库
     * 加拿大企业
     *
     * @param dirPath json文件上一级文件夹路径，里面只能有json文件
     * @return
     */
    @PostMapping("saveJsonCanada")
    public String saveJsonCanada(@RequestParam(name = "dirPath") String dirPath) {
        try {
            File fileDirPath = new File(dirPath);
            if (fileDirPath.exists()) {
                saveJson.readJsonCanada(fileDirPath);
            } else {
                return "路径错误";
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("错误，{}", CommonUtils.getExceptionInfo(e));
        }
        return "导入" + dirPath + "成功";
    }
}
