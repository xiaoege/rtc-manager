package com.rtc.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.util.baidutranslate.BaiduTranslatePOJO;
import com.rtc.manager.util.baidutranslate.TransApi;
import com.rtc.manager.util.baidutranslate.TransResult;
import com.rtc.manager.vo.QccListVO;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.List;

/**
 * @author ChenHang
 */
public class ReflactTest {
    public static void main(String[] args) {
        try {
            QccListVO qccListVO = new QccListVO();
//            qccListVO.setName("喵帕斯");
            Class<?> aClass = qccListVO.getClass();
            Method[] methods = aClass.getMethods();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            Method method = aClass.getDeclaredMethod("getName");
            Object invoke = method.invoke(qccListVO);

            Method method1 = aClass.getDeclaredMethod("setName",String.class);
            Object invoke1 = method1.invoke(qccListVO,"压一压");
            invoke = method.invoke(qccListVO);
            int i = 0;

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }


}
