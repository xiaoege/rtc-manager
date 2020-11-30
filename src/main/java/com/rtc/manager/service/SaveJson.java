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

    void saveJsonAmerica4WyomingCSV(File fileDirPath, String pojoType) throws Exception;

    void readJsonCanada(File fileDirPath) throws Exception;

    void saveJsonAmerica4Florida(File fileDirPath) throws Exception;

    void saveJsonAmerica4Ohio(File fileDirPath) throws Exception;

    void saveJsonAmerica4Oklahoma(File fileDirPath) throws Exception;

    void saveJsonAmerica4Delaware(File fileDirPath) throws Exception;

    void saveJsonAmerica4Oregon(File fileDirPath) throws Exception;

    void saveJsonAmerica4PuertoRico(File fileDirPath) throws Exception;

    void saveJsonAmerica4RhodeIsland(File fileDirPath) throws Exception;

    void saveJsonAmerica4Minnesota(File fileDirPath) throws Exception;
}
