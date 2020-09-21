package com.rtc.manager;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author ChenHang
 */
public class TimezoneTest {
    public static void main(String[] args) {
        String timeZone = "+19";
        LocalDateTime now = LocalDateTime.now();
        Instant clientTime = now.toInstant(ZoneOffset.of(timeZone));
        System.out.println(clientTime);
    }
}
