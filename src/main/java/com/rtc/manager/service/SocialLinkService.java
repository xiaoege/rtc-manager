package com.rtc.manager.service;

import com.rtc.manager.vo.ResultData;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ChenHang
 */
public interface SocialLinkService {

    /**
     *
     * @param body
     * @param state 第三方类型,例如Google,Twitter
     * @return
     * @throws Exception
     */
    ResultData<Boolean> checkToken(String body, String state) throws Exception;

    /**
     *
     * @param body
     * @param state 第三方类型,例如Google,Twitter
     * @param request
     * @return
     * @throws Exception
     */
    ResultData linkAccount(String body, String state, HttpServletRequest request) throws Exception;

    /**
     * 绑定第三方
     * @param body
     * @param state Not NULL
     * @return
     * @throws Exception
     */
    ResultData bindThirdParty(String body, String state) throws Exception;

    /**
     * 解绑第三方
     * @param id 绑定的第三方在mysql里的id
     * @return
     */
    ResultData unbindThirdParty(Integer id);
}
