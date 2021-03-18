package com.rtc.manager.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.rtc.manager.service.UtilsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
public class SmsUtils {
    private static Logger logger = LoggerFactory.getLogger(SmsUtils.class);

    private static UtilsService utilsService;

    @Autowired
    private UtilsService utilsServiceInit;

    @PostConstruct
    public void beforeInit() {
        utilsService = utilsServiceInit;
    }

    /**
     *
     * @param phoneNumbers 手机号
     * @param verificationCode 验证码
     */
    public static void sendSms(String phoneNumbers, String verificationCode) {
        HashMap<String, String> accessKeyMap = utilsService.getAccessKey("");
        String accessKey = accessKeyMap.get("accessKey");
        String secret = accessKeyMap.get("secret");

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKey, secret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumbers);
        request.putQueryParameter("SignName", "ComChec");
        request.putQueryParameter("TemplateCode", "SMS_204460137");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + verificationCode + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            logger.info(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
