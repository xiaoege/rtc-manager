package com.rtc.manager.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.dao.RtcUserOauthMapper;
import com.rtc.manager.entity.RtcUser;
import com.rtc.manager.entity.RtcUserOauth;
import com.rtc.manager.entity.dto.RtcUserDTO;
import com.rtc.manager.service.SocialLinkService;
import com.rtc.manager.service.UtilsService;
import com.rtc.manager.util.UserUtils;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.RtcUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author ChenHang
 */
@Service
public class SocialLinkServiceImpl implements SocialLinkService {

    private final Logger logger = LoggerFactory.getLogger(SocialLinkServiceImpl.class);

    @Value("${rtc.loginTokenTTL}")
    private Long loginTokenTTL;

    private final String BEARER = "Bearer ";

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private RtcUserMapper rtcUserMapper;

    @Autowired
    private RtcUserOauthMapper rtcUserOauthMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UtilsService utilsService;

    /**
     * @param body
     * @param state 第三方类型,例如Google,Twitter
     * @return
     * @throws Exception
     */
    @Override
    public ResultData<Boolean> checkToken(String body, String state) throws Exception {
        switch (state) {
            case "Google":
                String CLIENT_ID = (String) utilsService.getAccessKey("google-android").get("accessKey");
                GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                        .setAudience(Collections.singletonList(CLIENT_ID)).build();
                HashMap<String, String> map = (HashMap<String, String>) objectMapper.readValue(body, Map.class);
                String token = map.get("token");
                GoogleIdToken verify = verifier.verify(token);
                if (verify != null) {
                    return ResultData.SUCCESS(true);
                }
                break;
            default:
        }
        return ResultData.FAIL(false, 400);
    }

    /**
     * 用第三方注册时，绑定其邮箱。如果第三方注册后解绑，再次注册时，则不绑定其邮箱（避免出现同一个邮箱绑定多个用户的情况）
     *
     * @param body
     * @param state   第三方类型,例如Google,Twitter
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData linkAccount(String body, String state, HttpServletRequest request) throws Exception {
        switch (state) {
            case "Google":
                String CLIENT_ID = (String) utilsService.getAccessKey("google-android").get("accessKey");
                GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                        .setAudience(Collections.singletonList(CLIENT_ID)).build();
                HashMap<String, String> map = (HashMap<String, String>) objectMapper.readValue(body, Map.class);
                String token = map.get("token");
                GoogleIdToken verify = verifier.verify(token);
                if (verify != null) {
                    GoogleIdToken.Payload payload = verify.getPayload();
                    String openId = payload.getSubject();
                    String email = payload.getEmail();
                    String pictureUrl = (String) payload.get("picture");
                    RtcUserOauth userOauth = new RtcUserOauth(openId, "Google");
                    // 不存在则注册
                    String userId = rtcUserOauthMapper.selectUserByOpenId(openId);
                    if (StringUtils.isEmpty(userId)) {
                        String password = map.get("password");
                        String retypePassword = map.get("retypePassword");
                        // 密码格式验证
                        if (!UserUtils.checkPasswordFormat(password)) {
                            return ResultData.FAIL(null, 903, "密码格式错误");
                        }
                        RtcUser rtcUser = new RtcUser();
                        userId = UUID.randomUUID().toString();
                        rtcUser.setUuid(userId);
                        rtcUser.setNickname(generateNickname());
                        // 用第三方注册时，绑定其邮箱。如果第三方注册后解绑，再次注册时，则不绑定其邮箱（避免出现同一个邮箱绑定多个用户的情况）
                        if (rtcUserMapper.selectByPhoneOrAccount(email) == null) {
                            rtcUser.setEmail(email);
                        }
                        rtcUser.setPortrait(pictureUrl);
                        rtcUser.setPassword(new BCryptPasswordEncoder().encode(password));
                        rtcUserMapper.insertSelective(rtcUser);
                        userOauth.setUserId(userId);
                        rtcUserOauthMapper.insertSelective(userOauth);
                    }
                    logger.info("Google payload:{}", payload);
                    // 返回登录token
                    String bearerToken = getBearerToken(request, userId);
                    return ResultData.SUCCESS(bearerToken, "请求成功");
                } else {
                    return ResultData.FAIL(null, 1005, "无效token");
                }
            default:
        }

        return ResultData.FAIL(null, 500);
    }

    /**
     * 绑定第三方
     *
     * @param body
     * @param state Not NULL
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData bindThirdParty(String body, String state) throws Exception {
        // 校验当前登录用户是否已绑定第三方
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RtcUserVO rtcUserVO = rtcUserMapper.selectByPhoneOrAccount2RtcUserVO(userDetails.getUsername());
        List<RtcUserOauth> oauthList = rtcUserVO.getOauthList();
        if (oauthList != null) {
            for (RtcUserOauth userOauth : oauthList) {
                if (state.equals(userOauth.getSource())) {
                    return ResultData.FAIL(null, 1006, "当前账号已绑定其他第三方账号");
                }
            }
        }
        switch (state) {
            case "Google":
                String CLIENT_ID = (String) utilsService.getAccessKey("google-android").get("accessKey");
                GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                        .setAudience(Collections.singletonList(CLIENT_ID)).build();
                HashMap<String, String> map = (HashMap<String, String>) objectMapper.readValue(body, Map.class);
                String token = map.get("token");
                GoogleIdToken verify = verifier.verify(token);
                if (verify != null) {
                    GoogleIdToken.Payload payload = verify.getPayload();
                    String openId = payload.getSubject();
                    RtcUserOauth userOauth = new RtcUserOauth(openId, "Google");
                    // 已绑定则拒绝
                    String userId = rtcUserOauthMapper.selectUserByOpenId(openId);
                    if (!StringUtils.isEmpty(userId)) {
                        return ResultData.FAIL(null, 1007, "该第三方已绑定其他账号");
                    }
                    userOauth.setUserId(rtcUserVO.getUuid());
                    rtcUserOauthMapper.insertSelective(userOauth);
                    return ResultData.SUCCESS(null, "绑定成功");
                }
                break;
            default:
        }

        return ResultData.FAIL(null, 500);
    }

    /**
     * 解绑第三方
     *
     * @param id 绑定的第三方在mysql里的id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData unbindThirdParty(Integer id) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // 传入userId确保解绑的是当前用户
        RtcUserVO rtcUserVO = rtcUserMapper.selectByPhoneOrAccount2RtcUserVO(userDetails.getUsername());
        if (rtcUserOauthMapper.unbindThirdParty(rtcUserVO.getUuid(), id) > 0) {
            return ResultData.SUCCESS(null, "解绑成功");
        }
        return ResultData.FAIL(null, 500);
    }

    /**
     * 根据用户的uuid返回Bearer Token
     *
     * @param request
     * @param userId  uuid/phone/email/nickname
     * @return
     */
    private String getBearerToken(HttpServletRequest request, String userId) {
        UserDetails userDetails = userDetailService.loadUserByUsername(userId);
        if (userDetails != null) {
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(userId);
//        String bearerToken = UserUtils.getToken(rtcUserDTO.getUuid());
//        stringRedisTemplate.opsForValue().set(bearerToken, rtcUserDTO.getUuid(), loginTokenTTL, TimeUnit.DAYS);
        String bearerToken = UserUtils.getJWT(rtcUserDTO.getUuid());
        return BEARER + bearerToken;
    }

    /**
     * 第三方注册时，自动生成 User + uuid + 随机数
     *
     * @return
     */
    private String generateNickname() {
        return "User-" + UUID.randomUUID().toString().substring(0, 12) + new Random().nextInt(100);
    }
}
