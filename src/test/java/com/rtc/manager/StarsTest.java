package com.rtc.manager;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author ChenHang
 */
public class StarsTest {


    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("4.144",new MathContext(2, RoundingMode.HALF_UP));
        BigDecimal bigDecimal1 = new BigDecimal("4.444",new MathContext(2, RoundingMode.HALF_UP));
        BigDecimal bigDecimal2 = new BigDecimal("4.4666",new MathContext(2, RoundingMode.HALF_UP));
        BigDecimal bigDecimal3 = new BigDecimal("4.4919",new MathContext(2, RoundingMode.HALF_UP));
        BigDecimal bigDecimal4 = new BigDecimal("4.5166",new MathContext(2, RoundingMode.HALF_UP));
        BigDecimal bigDecimal5 = new BigDecimal("4.5666",new MathContext(2, RoundingMode.HALF_UP));
        System.out.println(1);
        BigDecimal ca = new BigDecimal("4.1", new MathContext(2, RoundingMode.HALF_DOWN));
        BigDecimal ca1 = new BigDecimal("4.4", new MathContext(2, RoundingMode.HALF_DOWN));
        BigDecimal ca2 = new BigDecimal("4.5", new MathContext(2, RoundingMode.HALF_DOWN));
        BigDecimal ca3 = new BigDecimal("4.6", new MathContext(2, RoundingMode.HALF_DOWN));
        BigDecimal ca4 = new BigDecimal("4.9", new MathContext(2, RoundingMode.HALF_DOWN));
        bigDecimal5.compareTo(new BigDecimal("4.9"));
        System.out.println(1);
    }
}
