package com.rtc.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.rtc.manager.dao")
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

}
