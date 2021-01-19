package com.rtc.manager;

import com.rtc.manager.entity.america.california.AmericaCalifornia;
import com.rtc.manager.entity.america.colorado.AmericaColorado;
import com.rtc.manager.entity.america.kentucky.AmericaKentucky;

import java.util.Arrays;

/**
 * @author ChenHang
 */
public class PrintFields {
    public static void main(String[] args) {
        print(AmericaColorado.class);
    }

    private static void print(Class c) {
        Arrays.stream(c.getDeclaredFields()).forEach(q -> System.out.println(q.getName()));
    }
}
