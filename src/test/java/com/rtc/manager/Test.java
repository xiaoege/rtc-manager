package com.rtc.manager;

import lombok.SneakyThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenHang
 */
public class Test {
    public static void main(String[] args) {
        String dirPath = "/Users/chenhang/work/round_2";
        File fileDirPath = new File(dirPath);
        List fileList = new ArrayList();
        readFiles(fileDirPath, fileList);
        System.out.println(fileList);
        System.out.println(fileList.size());
    }

    @SneakyThrows
    private static void readFiles(File fileDirPath, List<String> fileList) {
        if (fileDirPath.exists() && fileList != null) {
            File[] files = fileDirPath.listFiles();
            for (File file :
                    files) {
                // 忽略mac的隐藏文件
                if (file.getName().contains(".DS_Store")) {
                    continue;
                }
                if (file.isFile()) {
                    if ("json".equals(file.getName().substring(file.getName().lastIndexOf(".") + 1))) {
                        fileList.add(file.getPath());
                    }
                } else if (file.isDirectory()) {
                    readFiles(file, fileList);
                }
            }
        }

    }
}