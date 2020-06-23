package com.rtc.manager.service;

import java.io.File;

/**
 * @author ChenHang
 */
public interface SaveJson {
    String getTest();

    void readJson(File file) throws Exception;
}
