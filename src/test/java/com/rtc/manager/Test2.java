package com.rtc.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ChenHang
 */
public class Test2 {

    static Logger logger = LoggerFactory.getLogger(Test2.class);

    public static void main(String[] args) throws JsonProcessingException {
        String registeredCapital = "5000万人民币";
//        registeredCapital = "2万美元";
//        registeredCapital = "2万欧元";
//        registeredCapital = "2万港元";
        String s = transferMoney(registeredCapital);
        System.out.println(s);
        logger.info("喵{}{}","帕","斯");
        List list = new ArrayList();
        if (!CollectionUtils.isEmpty(list)) {
            System.out.println(123);
        }
    }

    public static String transferMoney(String registeredCapital) {
        try {
            if (registeredCapital.contains("万人民币")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("万"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(7), s);
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            } else if (registeredCapital.contains("万美元")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("万"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(1), s);
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            } else if (registeredCapital.contains("万港元")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("万"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(7.75), s);
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            } else if (registeredCapital.contains("万欧元")) {
                String s = registeredCapital.substring(0, registeredCapital.indexOf("万"));
                BigDecimal bigDecimal = numberFormat(new BigDecimal(0.86), s);
                DecimalFormat decimalFormat = new DecimalFormat("$,###");
                String format = decimalFormat.format(bigDecimal);
                return format;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
        return "0";
    }

    /**
     * 把xxx万换算成x,xx0,000
     * 保底10,000
     *
     * @param exchangeRate 汇率
     * @param s            xxx
     * @return x, xx0, 000
     */
    public static BigDecimal numberFormat(BigDecimal exchangeRate, String s) throws Exception {
        if (s != null && exchangeRate != null) {
            Pattern pattern = Pattern.compile("^[0-9]*$");
            pattern = Pattern.compile("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$");
            Matcher isNum = pattern.matcher(s);
            if (isNum.matches()) {
                BigDecimal bigDecimal = new BigDecimal(s);
                BigDecimal divide = bigDecimal.divide(exchangeRate, 0, RoundingMode.HALF_UP);
                if (new BigDecimal(0).compareTo(divide) == 0) {
                    divide = new BigDecimal(1);
                }
                return divide.multiply(new BigDecimal(10000));
            }
        }
        return new BigDecimal(0);
    }
}
