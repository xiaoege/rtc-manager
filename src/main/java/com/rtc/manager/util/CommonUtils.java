package com.rtc.manager.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.util.baidutranslate.BaiduTranslatePOJO;
import com.rtc.manager.util.baidutranslate.TransApi;
import com.rtc.manager.util.baidutranslate.TransResult;
import com.rtc.manager.vo.QccVO;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import com.rtc.manager.vo.UserCommentVO;
import com.rtc.manager.vo.india.IndiaCinEnterpriseVO;
import com.rtc.manager.vo.india.IndiaCinVO;
import com.rtc.manager.vo.india.IndiaLlpinEnterpriseVO;
import com.rtc.manager.vo.india.IndiaLlpinVO;
import com.rtc.manager.vo.vietnam.VietnamEnterpriseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.UUID.randomUUID;

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
     * 验证是否是英文字母
     */
    private final static Pattern PATTERN_ENGLISH = Pattern.compile("^[a-zA-Z]*");

    /**
     * 和美元之间的汇率
     */
    public final static String CNY = "7";
    /**
     * 和欧元之间的汇率
     */
    public final static String EUR = "0.86";
    /**
     * 和港元之间的汇率
     */
    public final static String HKD = "7.75";

    private static final String APP_ID = "20200722000524091";
    private static final String SECURITY_KEY = "fzXcZ4t3jWGnRP0cIVIn";

    private static final List<String> LOGO_COLOR_LIST = List.of("#ff9393",
            "#DA8EBE",
            "#90c968",
            "#7cb4d9",
            "#e9a57b",
            "#702f96",
            "#c74433");

    private static final DateTimeFormatter FORMATTER_0 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATTER_1 = DateTimeFormatter.ofPattern("yyyy-M-d");
    private static final DateTimeFormatter FORMATTER_2 = DateTimeFormatter.ofPattern("d/M/yyyy");

    /**
     * d/M/yyyy
     */
    private static final Pattern PATTERN_DATE_FORMAT_0 = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
    /**
     * yyyy-M-d
     */
    private static final Pattern PATTERN_DATE_FORMAT_1 = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");

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
     * 把服务器时间转换成所在时区的时间
     *
     * @param timeZone 要转换成的时间的时区
     * @param time     服务器时间
     * @return
     */
    public static LocalDateTime transfer2LocalTime(String timeZone, LocalDateTime time) {
        LocalDateTime localDateTime;
        try {
            localDateTime = time.plusHours(Long.parseLong(timeZone));
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(CommonUtils.getExceptionInfo(e));
            return time;
        }

        return localDateTime;
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
                    fileList.add(file.getPath());
                } else if (file.isDirectory()) {
                    readFiles(file, fileList);
                }
            }
        }

    }

    /**
     * 获得该路径文件夹下所有文件
     *
     * @param fileDirPath 路径
     * @param fileList    所有文件的list
     */
    public static void readJsonFiles(File fileDirPath, List fileList) {
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
                    readJsonFiles(file, fileList);
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
        if (registeredCapital != null) {

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
        }
        return "-";
    }

    /**
     * xxx万元/xxx - $x,xx0,000
     *
     * @param registeredCapital 钱
     * @param arg               不是数字的钱展示arg
     * @param magnification     倍率
     * @return $x, xx0, 000
     */
    public static String transferMoney2(String registeredCapital, String arg, double magnification) {
        try {
            Matcher isNum = PATTERN_NUMBER.matcher(registeredCapital);
            if (registeredCapital.contains("万")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("万"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(CNY), s, Math.pow(10, 4));
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            } else if (isNum.matches()) {
                BigDecimal bigDecimal = numberFormat(new BigDecimal(CNY), registeredCapital, magnification);
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
     * @return xxx0000
     */
    public static BigDecimal numberFormat(BigDecimal exchangeRate, String s, double magnification) throws Exception {
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
            return new BigDecimal(s).multiply(new BigDecimal(magnification));
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
        if (StringUtils.isEmpty(query) || StringUtils.isEmpty(query.strip())) {
            return "";
        }
        logger.info("开始翻译{}", Instant.now());
        try {
            query = query.strip();
            TransApi transApi = new TransApi(APP_ID, SECURITY_KEY);
            String transResult = transApi.getTransResult(query, from, to);
            logger.info("翻译返回json：{}", transResult);
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
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("翻译错误{}", CommonUtils.getExceptionInfo(e));
        }
        logger.info("结束翻译{}", Instant.now());
        return null;
    }

    public static Map translate2(String query, String from, String to) throws Exception {
        Map map = new HashMap();
        map.put("code", 500);
        map.put("data", null);
        if (StringUtils.isEmpty(query) || StringUtils.isEmpty(query.strip())) {
            map.put("code", 706);
            return map;
        }
        query = query.strip();
        logger.info("开始翻译:{}, {}", query, Instant.now());
        TransApi transApi = new TransApi(APP_ID, SECURITY_KEY);
        String transResult = transApi.getTransResult(query, from, to);
        logger.info("结束翻译:{}, {}", transResult, Instant.now());

        ObjectMapper objectMapper = new ObjectMapper();
        BaiduTranslatePOJO baiduTranslatePOJO = objectMapper.readValue(transResult, BaiduTranslatePOJO.class);
        if (baiduTranslatePOJO != null && baiduTranslatePOJO.getError_code() == null) {
            List list = (List) baiduTranslatePOJO.getTrans_result();
            if (!CollectionUtils.isEmpty(list)) {
                TransResult o = (TransResult) list.get(0);
                String dst = o.getDst();
                map.put("data", dst);
                map.put("code", 200);
                return map;
            }
        }
        return map;
    }

    public static void translate3(String query, String from, String to, Object object, String field) throws Exception {

        try {
            if (!StringUtils.isEmpty(query) && !StringUtils.isEmpty(query.strip())) {
                logger.info("开始翻译{}", Instant.now());
                query = query.strip();
                TransApi transApi = new TransApi(APP_ID, SECURITY_KEY);
                String transResult = transApi.getTransResult(query, from, to);
                logger.info("翻译返回json：{}", transResult);
                ObjectMapper objectMapper = new ObjectMapper();
                BaiduTranslatePOJO baiduTranslatePOJO = objectMapper.readValue(transResult, BaiduTranslatePOJO.class);
                if (baiduTranslatePOJO != null) {
                    List list = (List) baiduTranslatePOJO.getTrans_result();
                    if (!CollectionUtils.isEmpty(list)) {
                        TransResult o = (TransResult) list.get(0);
                        String dst = o.getDst();

                        Class<?> aClass = object.getClass();
                        field = "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
                        Method method = aClass.getDeclaredMethod(field, String.class);
                        method.invoke(object, dst);

                    }
                }
                logger.info("结束翻译{}", Instant.now());
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("翻译错误{}", CommonUtils.getExceptionInfo(e));
        }


    }

    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    /**
     * 姓名格式化，Song Changjiang - SONG, Changjiang
     *
     * @param name 姓名
     * @return
     */
    public static String nameFormat(String name) {
        if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(name.strip())) {
            name = name.strip();
            if (name.contains(" ")) {
                String preName = name.substring(0, name.indexOf(" "));
                String sufName = name.substring(name.indexOf(" ") + 1);
                String str = sufName.substring(0, 1).toUpperCase() + sufName.substring(1);
                return preName.toUpperCase() + ", " + str;
            } else {
                return name;
            }
        }

        return "";
    }

    /**
     * 获得map的key
     *
     * @param map
     * @return
     */
    public static List getKeys(Map map) {
        List list = new ArrayList();
        if (!CollectionUtils.isEmpty(map)) {
            Set<Map.Entry> entrySet = map.entrySet();
            for (Map.Entry e :
                    entrySet) {
                list.add(e.getKey());
            }
        }
        return list;
    }

    /**
     * 印度企业charges-address修改格式，把结尾的xxxxIN用空格隔开
     *
     * @param address
     * @return
     */
    public static String formatIndiaChargeAddress(String address) {
        // 不是以IN结尾，并且IN前一位不是数字的则跳过
        if (address == null || !address.endsWith("IN") || !Character.isDigit(address.charAt(address.length() - 3))) {
            return address;
        }

        int in = address.lastIndexOf("IN");
        int i = 1;
        for (; i < in; i++) {
            char c = address.charAt(in - i);
            if (!Character.isDigit(c)) {
                break;
            }
        }
        int addressDigit = address.length() - i - 1;

        return address.substring(0, addressDigit) + " " + address.substring(addressDigit, in) + " " + address.substring(in);
    }

    /**
     * 打印Map的key
     *
     * @param map
     */
    public static void printMapKey(Map map) {
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getKey());
        }
    }

    public static void main(String[] args) {
        String address = "FEDERAL TOWERSP B NO 103ALWAYEERANAKULAMKe683101IN";
        address = "ndsnjfdsn1111f33333IN";
        String s = formatIndiaChargeAddress(address);
        System.out.println(s);
    }

    /**
     * 获得enterpriseId
     *
     * @return
     */
    public static String getUUID() {
        return randomUUID().toString().replace("-", "");
    }

    /**
     * 新增/修改企业时，校验object的field是否全为无效数据(not null & not "")
     */
    public static boolean checkJsonField(Object object) {
        if (object != null) {
            try {
                Field[] declaredFields = object.getClass().getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    if (!StringUtils.isEmpty(declaredField.get(object))) {
                        return true;
                    }
                    declaredField.setAccessible(false);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 新增/修改企业时，校验object的field是否全为无效数据(not null & not "")
     * 只校验field是java.lang.String或java.lang.Integer的情况
     */
    public static boolean checkJsonFieldNotSub(Object object) {
        if (object != null) {
            try {
                Field[] declaredFields = object.getClass().getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    String fieldTypeName = declaredField.getType().getName();
                    if ("java.lang.String".equals(fieldTypeName) || "java.lang.Integer".equals(fieldTypeName)) {
                        if (!StringUtils.isEmpty(declaredField.get(object))) {
                            return true;
                        }
                    }
                    declaredField.setAccessible(false);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 如果企业logo为null或""，则将设置其公司名为logoName，随机logo背景
     *
     * @param object object instance of SearchEnterpriseListVO | QccVO | IndiaCinEnterpriseVO | IndiaLlpinEnterpriseVO
     */
    public static void setLogoNameAndColor(Object object) {
        if (object instanceof SearchEnterpriseListVO) {
            String name = ((SearchEnterpriseListVO) object).geteName();
            if (StringUtils.isEmpty(((SearchEnterpriseListVO) object).getLogo())) {
                if (!StringUtils.isEmpty(name)) {
                    Random random = new Random();
                    String firstLetter = name.substring(0, 1);
                    Matcher matcher = PATTERN_ENGLISH.matcher(firstLetter);
                    // 如果是英文字母开头
                    if (matcher.matches()) {
                        ((SearchEnterpriseListVO) object).setLogoName(firstLetter);
                        // 如果不是英文字母开头
                    } else if (name.length() > 3) {
                        ((SearchEnterpriseListVO) object).setLogoName(name.substring(0, 4));
                        // 如果不是英文字母开头
                    } else {
                        ((SearchEnterpriseListVO) object).setLogoName(firstLetter);
                    }
                    ((SearchEnterpriseListVO) object).setLogoColor(LOGO_COLOR_LIST.get(random.nextInt(LOGO_COLOR_LIST.size())));
                }
            }
        } else if (object instanceof QccVO) {
            String name = ((QccVO) object).getName();
            if (StringUtils.isEmpty(((QccVO) object).getLogo())) {
                if (!StringUtils.isEmpty(name)) {
                    Random random = new Random();
                    String firstLetter = name.substring(0, 1);
                    Matcher matcher = PATTERN_ENGLISH.matcher(firstLetter);
                    // 如果是英文字母开头
                    if (matcher.matches()) {
                        ((QccVO) object).setLogoName(firstLetter);
                        // 如果不是英文字母开头
                    } else if (name.length() > 3) {
                        ((QccVO) object).setLogoName(name.substring(0, 4));
                        // 如果不是英文字母开头
                    } else {
                        ((QccVO) object).setLogoName(firstLetter);
                    }
                    ((QccVO) object).setLogoColor(LOGO_COLOR_LIST.get(random.nextInt(LOGO_COLOR_LIST.size())));
                }
            }
        } else if (object instanceof IndiaCinEnterpriseVO) {
            IndiaCinVO indiaCin = ((IndiaCinEnterpriseVO) object).getIndiaCin();
            String name = indiaCin.getCompanyName();
            if (StringUtils.isEmpty(((IndiaCinVO) object).getLogo())) {
                if (!StringUtils.isEmpty(name)) {
                    Random random = new Random();
                    String firstLetter = name.substring(0, 1);
                    Matcher matcher = PATTERN_ENGLISH.matcher(firstLetter);
                    // 如果是英文字母开头
                    if (matcher.matches()) {
                        ((IndiaCinVO) object).setLogoName(firstLetter);
                        // 如果不是英文字母开头
                    } else if (name.length() > 3) {
                        ((IndiaCinVO) object).setLogoName(name.substring(0, 4));
                        // 如果不是英文字母开头
                    } else {
                        ((IndiaCinVO) object).setLogoName(firstLetter);
                    }
                    ((IndiaCinVO) object).setLogoColor(LOGO_COLOR_LIST.get(random.nextInt(LOGO_COLOR_LIST.size())));
                }
            }
        } else if (object instanceof IndiaLlpinEnterpriseVO) {
            IndiaLlpinVO indiaLlpinVO = ((IndiaLlpinEnterpriseVO) object).getIndiaLlpinVO();
            String name = indiaLlpinVO.getLlpName();
            if (StringUtils.isEmpty(((IndiaLlpinVO) object).getLogo())) {
                if (!StringUtils.isEmpty(name)) {
                    Random random = new Random();
                    String firstLetter = name.substring(0, 1);
                    Matcher matcher = PATTERN_ENGLISH.matcher(firstLetter);
                    // 如果是英文字母开头
                    if (matcher.matches()) {
                        ((IndiaLlpinVO) object).setLogoName(firstLetter);
                        // 如果不是英文字母开头
                    } else if (name.length() > 3) {
                        ((IndiaLlpinVO) object).setLogoName(name.substring(0, 4));
                        // 如果不是英文字母开头
                    } else {
                        ((IndiaLlpinVO) object).setLogoName(firstLetter);
                    }
                    ((IndiaLlpinVO) object).setLogoColor(LOGO_COLOR_LIST.get(random.nextInt(LOGO_COLOR_LIST.size())));
                }
            }
        } else if (object instanceof VietnamEnterpriseVO) {
            String name = ((VietnamEnterpriseVO) object).getEnterpriseName();
            if (StringUtils.isEmpty(((VietnamEnterpriseVO) object).getLogo())) {
                if (!StringUtils.isEmpty(name)) {
                    Random random = new Random();
                    String firstLetter = name.substring(0, 1);
                    Matcher matcher = PATTERN_ENGLISH.matcher(firstLetter);
                    // 如果是英文字母开头
                    if (matcher.matches()) {
                        ((VietnamEnterpriseVO) object).setLogoName(firstLetter);
                        // 如果不是英文字母开头
                    } else if (name.length() > 3) {
                        ((VietnamEnterpriseVO) object).setLogoName(name.substring(0, 4));
                        // 如果不是英文字母开头
                    } else {
                        ((VietnamEnterpriseVO) object).setLogoName(firstLetter);
                    }
                    ((VietnamEnterpriseVO) object).setLogoColor(LOGO_COLOR_LIST.get(random.nextInt(LOGO_COLOR_LIST.size())));
                }
            }
        } else if (object instanceof UserCommentVO) {
            String name = ((UserCommentVO) object).geteName();
            if (StringUtils.isEmpty(((UserCommentVO) object).getLogo())) {
                if (!StringUtils.isEmpty(name)) {
                    Random random = new Random();
                    String firstLetter = name.substring(0, 1);
                    Matcher matcher = PATTERN_ENGLISH.matcher(firstLetter);
                    // 如果是英文字母开头
                    if (matcher.matches()) {
                        ((UserCommentVO) object).setLogoName(firstLetter);
                        // 如果不是英文字母开头
                    } else if (name.length() > 3) {
                        ((UserCommentVO) object).setLogoName(name.substring(0, 4));
                        // 如果不是英文字母开头
                    } else {
                        ((UserCommentVO) object).setLogoName(firstLetter);
                    }
                    ((UserCommentVO) object).setLogoColor(LOGO_COLOR_LIST.get(random.nextInt(LOGO_COLOR_LIST.size())));
                }
            }
        }

    }

    /**
     * 格式化日期
     *
     * @param var0
     * @return dd/MM/yyyy 类型的日期字符串
     */
    public static String dateFormat(String var0) {
        if (!StringUtils.isEmpty(var0)) {
            Matcher matcher0 = PATTERN_DATE_FORMAT_0.matcher(var0);
            Matcher matcher1 = PATTERN_DATE_FORMAT_1.matcher(var0);
            if (matcher0.matches()) {
                return var0;
            } else if (matcher1.matches()) {
                return LocalDate.parse(var0, FORMATTER_1).format(FORMATTER_0);
            }
        }
        return var0;
    }
}
