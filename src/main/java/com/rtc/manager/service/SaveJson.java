package com.rtc.manager.service;

import java.io.File;

/**
 * @author ChenHang
 */
public interface SaveJson {
    void readJson(File filePath) throws Exception;

    void readJsonIndia(File filePath) throws Exception;

    void readJsonVietnam(File fileDirPath) throws Exception;

    void saveJsonAmerica4Alabama(File fileDirPath) throws Exception;

    void saveJsonAmerica4NewHampshire(File fileDirPath) throws Exception;

    void saveJsonAmerica4NorthCarolina(File fileDirPath) throws Exception;

    void saveJsonAmerica4Alaska(File fileDirPath) throws Exception;

    void saveJsonAmerica4AlaskaCSV(File fileDirPath) throws Exception;
}
