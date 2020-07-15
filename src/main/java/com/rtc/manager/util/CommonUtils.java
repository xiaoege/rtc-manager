package com.rtc.manager.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author ChenHang
 */
public final class CommonUtils {
    /**
     * 获得exception的堆栈信息
     *
     * @param e Exception
     * @return String
     */
    public static String getExceptionInfo(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        return "\n" + sw.getBuffer().toString();
    }

    /**
     * 用户所在时区的时间和新闻发布所在时区的时间比较，1小时内显示分钟差，其次显示小时，时间，超过maxDay显示年月日时分秒
     * @param timeZone
     * @param time
     * @return
     */
    public static String compareTime(String timeZone, LocalDateTime time) {
        Instant serverTime = null;
        try {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            long maxDay = 3;
            // 用户所在时区时间
            LocalDateTime now = LocalDateTime.now();
            Instant clientTime = now.toInstant(ZoneOffset.of(timeZone));

            //服务器时间转化为用户时区时间
            serverTime = time.toInstant(ZoneOffset.of(timeZone));
            Duration duration = Duration.between(clientTime, serverTime);
            long day = duration.toDays();
            long hour = duration.toHours();
            long minutes = duration.toMinutes();

            if (Math.abs(day) < 1) {
                if (Math.abs(hour) < 1) {
                    return Math.abs(minutes) <= 1 ? Math.abs(minutes) + " minute ago" : Math.abs(minutes) + " minutes ago";
                } else {
                    return Math.abs(hour) == 1 ? Math.abs(hour) + " hour ago" : Math.abs(hour) + " hours ago";
                }
                } else if (Math.abs(day) == 1) {
                return Math.abs(day) + " day ago";
            } else if (Math.abs(day) <= maxDay) {
                return Math.abs(day) + " days ago";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        return String.valueOf(serverTime);
    }

    public static void main(String[] args) {
        String dateTimeStr = "2020-07-11 14:30:15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, df);
        String l = compareTime("+0", dateTime);
        System.out.println(l);
    }
}
