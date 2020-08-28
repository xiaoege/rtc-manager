package com.rtc.manager.service;

import java.io.File;

/**
 * @author ChenHang
 */
public interface SaveJson {
    void readJson(File filePath) throws Exception;

    void readJsonIndia(File filePath) throws Exception;

    void readJsonVietnam(File fileDirPath) throws Exception;
}
