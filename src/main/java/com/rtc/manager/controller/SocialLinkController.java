package com.rtc.manager.controller;

import com.rtc.manager.config.SwaggerConfig;
import com.rtc.manager.service.SocialLinkService;
import com.rtc.manager.vo.ResultData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ChenHang
 */
@ApiIgnore
@RestController
@RequestMapping("socialLink")
public class SocialLinkController {

    @Autowired
    private SocialLinkService socialLinkService;

    /**
     * 校验第三方token
     *
     * @param body
     * @param state 第三方类型,例如Google,Twitter
     * @return
     * @throws Exception
     */
    @ApiOperation("校验第三方token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "state", value = "第三方类型,参数示例:{Google,Twitter}", paramType = "query", required = true),
            @ApiImplicitParam(name = "body", value = "参数示例:{\"token\":\"\"}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"请求成功\",\n" +
                    "    \"data\": boolean,\n" +
                    "    \"code\": 200\n" +
                    "}")
    })
    @PostMapping("checkToken")
    public ResultData<Boolean> checkToken(@RequestBody String body,
                                          @RequestParam String state) throws Exception {
        return socialLinkService.checkToken(body, state);
    }

    /**
     * 第三方注册/登录
     *
     * @param body
     * @param state   第三方类型,例如Google,Twitter
     * @param request
     * @return
     * @throws Exception
     */
    @ApiOperation("第三方注册/登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "state", value = "第三方类型,参数示例:{Google,Twitter}", paramType = "query", required = true),
            @ApiImplicitParam(name = "body", value = "参数示例:{\"token\":\"\",\"password\":\"\"}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"请求成功\",\n" +
                    "    \"data\": \"Bearer xxxxx\",\n" +
                    "    \"code\": 200\n" +
                    "}"),
            @ApiResponse(code = 903, message = "密码格式错误"),
            @ApiResponse(code = 1005, message = "无效token")
    })
    @PostMapping("linkAccount")
    public ResultData linkAccount(@RequestBody String body, @RequestParam String state,
                                  HttpServletRequest request) throws Exception {

        return socialLinkService.linkAccount(body, state, request);

    }

    /**
     * 绑定第三方
     *
     * @param body
     * @param state
     * @return
     * @throws Exception
     */
    @ApiOperation("绑定第三方")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "state", value = "第三方类型,参数示例:{Google,Twitter}", paramType = "query", required = true),
            @ApiImplicitParam(name = "body", value = "参数示例:{\"token\":\"\",\"password\":\"\"}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\"message\":\"绑定成功\",\"data\":null,\"code\":200}"),
            @ApiResponse(code = 1006, message = "{\"message\":\"当前账号已绑定其他第三方账号\",\"data\":null,\"code\":200}"),
            @ApiResponse(code = 1007, message = "{\"message\":\"该第三方已绑定其他账号\",\"data\":null,\"code\":200}")
    })
    @PostMapping("bindThirdParty")
    public ResultData bindThirdParty(@RequestBody String body, @RequestParam String state) throws Exception {
        return socialLinkService.bindThirdParty(body, state);
    }

    /**
     * 解绑第三方
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation("绑定第三方")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "id", value = "第三方id,从/user/getUserInformation里获得", paramType = "query", required = true),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\"message\":\"解绑成功\",\"data\":null,\"code\":200}")
    })
    @PostMapping("unbindThirdParty")
    public ResultData unbindThirdParty(@RequestParam Integer id) throws Exception {
        return socialLinkService.unbindThirdParty(id);
    }
}
