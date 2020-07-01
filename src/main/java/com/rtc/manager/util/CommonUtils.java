package com.rtc.manager.util;

import java.io.PrintWriter;
import java.io.StringWriter;

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
}
