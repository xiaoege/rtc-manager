package com.rtc.manager.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsUtils {
    private static Logger logger = LoggerFactory.getLogger(SmsUtils.class);

    public static void main(String[] args) {
        System.out.println(1);
    }

    public static void sendSms(String verificationCode) {
        String accessKey = "", secret = "";
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKey, secret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "18951788733");
        request.putQueryParameter("SignName", "ComChec");
        request.putQueryParameter("TemplateCode", "SMS_204460137");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + verificationCode + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
//            System.out.println(response.getData());
            logger.info(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
