package com.rtc.manager.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ChenHang
 */
@Configuration
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rtc.manager.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("接口文档")
                        .description("自定义错误码：{702:验证码发送次数过多，请15分钟稍后再试, 705:数据有误, 706:翻译所传参数有误, 707:验证码错误, 708:翻译失败" +
                                "800:手机号格式错误, 801:手机号已注册, 803:国家代码与手机号不符, 804:该手机号尚未发送验证码, " +
                                "805:新手机号不能和原来一样, 806:输入的手机号和原始手机号不一致" +
                                "850:邮箱格式错误, 851:邮箱已注册, 852:该邮箱尚未发送验证码, 853:邮箱验证失败, 854:邮箱注册失败, 855:邮箱不能与原来相同" +
                                "901:昵称格式错误, 902:昵称已存在, 903:密码格式错误, 904:新密码不能和原密码相同, " +
                                "905:头像文件格式错误, 906:请重新上传头像" +
                                "1001:未登录, 1002:该账号不存在, 1003:密码错误, 1004:原始密码错误}" + "\n" +
                                "参数位置：{query:url里, header:请求头里, body:请求体里}" + "\n" +
                                 "用户角色：role:{ROLE_USER, ROLE_VIP}" + "\n" +
                                "昵称格式：可以有字母，数字，下划线，点。3-30个字符之间，不能以Comcheck开头，只能以字母开头" + "\n" +
                                "密码格式：可以有字母，数字。5-15个字符之间，只能以字母开头" + "\n" +
                                "企业详情：favourite: 0:未关注,1:已关注" + "\n" +
                                "短信验证码内置cd 55s，页面展示为60s倒计时"  + "\n" +
                                "短信：目前暂时只支持国内短信，countryCode国家代码暂时无需校验")
                        .version("0.3.0")
//                        .contact(new Contact("啊啊啊啊", "blog.csdn.net", "aaa@gmail.com"))
//                        .license("The Apache License")
//                        .licenseUrl("http://www.baidu.com")
                        .build());
    }

}
