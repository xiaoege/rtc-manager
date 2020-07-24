package com.rtc.manager.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.util.baidutranslate.BaiduTranslatePOJO;
import com.rtc.manager.util.baidutranslate.TransApi;
import com.rtc.manager.util.baidutranslate.TransResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ChenHang
 */
public final class CommonUtils {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    /**
     * 验证是否是数字
     */
    private final static Pattern PATTERN_NUMBER = Pattern.compile("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$");
    /**
     * 和美元之间的汇率
     */
    private final static String CNY = "7";
    /**
     * 和美元之间的汇率
     */
    private final static String EUR = "0.86";
    /**
     * 和美元之间的汇率
     */
    private final static String HKD = "7.75";

    private static final String APP_ID = "20200722000524091";
    private static final String SECURITY_KEY = "fzXcZ4t3jWGnRP0cIVIn";

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
     *
     * @param timeZone 时区
     * @param time     时间
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
            logger.info("{}, {}, {}", getExceptionInfo(e), timeZone, time);
            return "";
        }

        return String.valueOf(serverTime);
    }

    /**
     * 获得该路径文件夹下所有文件
     *
     * @param fileDirPath 路径
     * @param fileList    所有文件的list
     */
    public static void readFiles(File fileDirPath, List fileList) {
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

    /**
     * xxx万人民币 - $x,xx0,000
     *
     * @param registeredCapital 钱
     * @return $x, xx0, 000
     */
    public static String transferMoney(String registeredCapital) {
        try {
            if (registeredCapital.contains("万元人民币") || registeredCapital.contains("万人民币")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("万"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(CNY), s, (long) Math.pow(10, 4));
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            } else if (registeredCapital.contains("万美元")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("万"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(1), s, (long) Math.pow(10, 4));
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            } else if (registeredCapital.contains("万港元")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("万"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(HKD), s, (long) Math.pow(10, 4));
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            } else if (registeredCapital.contains("万欧元")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("万"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(EUR), s, (long) Math.pow(10, 4));
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            } else if (registeredCapital.contains("亿人民币")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("亿"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(CNY), s, (long) Math.pow(10, 8));
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            } else if (registeredCapital.contains("亿美元")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("亿"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(1), s, (long) Math.pow(10, 8));
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("{}, {}", getExceptionInfo(e), registeredCapital);
            return "-";
        }
        return "-";
    }

    /**
     * xxx万元/xxx - $x,xx0,000
     *
     * @param registeredCapital 钱
     * @return $x, xx0, 000
     */
    public static String transferMoney2(String registeredCapital, String arg) {
        try {
            Matcher isNum = PATTERN_NUMBER.matcher(registeredCapital);
            if (registeredCapital.contains("万")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("万"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(CNY), s, (long) Math.pow(10, 4));
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            } else if (isNum.matches()) {
                BigDecimal bigDecimal = numberFormat(new BigDecimal(CNY), registeredCapital, (long) Math.pow(10, 4));
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("{}, {}", getExceptionInfo(e), registeredCapital);
            return "-";
        }
        return arg == null ? "-" : arg;
    }

    /**
     * 把xxx万换算成x,xx0,000
     * 保底10,000
     *
     * @param exchangeRate  汇率
     * @param s             xxx
     * @param magnification 倍率:万还是亿
     * @return x, xx0, 000
     */
    public static BigDecimal numberFormat(BigDecimal exchangeRate, String s, long magnification) throws Exception {
        if (s != null && exchangeRate != null && new BigDecimal(1).compareTo(exchangeRate) != 0) {
            Matcher isNum = PATTERN_NUMBER.matcher(s);
            if (isNum.matches()) {
                BigDecimal bigDecimal = new BigDecimal(s);
                BigDecimal divide = bigDecimal.divide(exchangeRate, 0, RoundingMode.HALF_UP);
                if (new BigDecimal(0).compareTo(divide) == 0) {
                    divide = new BigDecimal(1);
                }
                return divide.multiply(new BigDecimal(magnification));
            }
        } else if (new BigDecimal(1).compareTo(exchangeRate) == 0) {
            return new BigDecimal(s).multiply(new BigDecimal(Math.pow(10, 4)));
        }
        return new BigDecimal(0);
    }

    /**
     * 翻译
     *
     * @param query 原文
     * @param from  原文编码
     * @param to    译文编码
     * @return 译文
     * @throws Exception
     */
    public static String translate(String query, String from, String to) throws Exception {
        TransApi transApi = new TransApi(APP_ID, SECURITY_KEY);
        String transResult = transApi.getTransResult(query, from, to);
        ObjectMapper objectMapper = new ObjectMapper();
        BaiduTranslatePOJO baiduTranslatePOJO = objectMapper.readValue(transResult, BaiduTranslatePOJO.class);
        if (baiduTranslatePOJO != null) {
            List list = (List) baiduTranslatePOJO.getTrans_result();
            if (!CollectionUtils.isEmpty(list)) {
                TransResult o = (TransResult) list.get(0);
                String dst = o.getDst();
                return dst;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String dateTimeStr = "2020-07-11 14:30:15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, df);
        String l = compareTime("+0", dateTime);
        System.out.println(l);
    }


}
