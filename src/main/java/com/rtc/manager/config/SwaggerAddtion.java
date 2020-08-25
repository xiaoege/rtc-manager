package com.rtc.manager.config;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Sets;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SwaggerAddtion implements ApiListingScannerPlugin {
    @Override
    public List<ApiDescription> apply(DocumentationContext documentationContext) {
        return new ArrayList<ApiDescription>(
                Arrays.asList(
                        new ApiDescription(
                                "/login",  //url
                                "", //描述
                                Arrays.asList(
                                        new OperationBuilder(
                                                new CachingOperationNameGenerator())
                                                .method(HttpMethod.POST)//http请求类型
                                                .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                                                .summary("登录")
                                                .notes("")//方法描述
                                                .tags(Sets.newHashSet("用户接口"))//归类标签
                                                .parameters(
                                                        Arrays.asList(
                                                                new ParameterBuilder()
                                                                        .description("参数例子：{\"username\":\"333\",\"password\":\"asd\"}")//参数描述
                                                                        .type(new TypeResolver().resolve(String.class))//参数数据类型
                                                                        .name("")//参数名称
                                                                        .defaultValue("password")//参数默认值
                                                                        .parameterType("body")//参数类型
                                                                        .parameterAccess("access")
                                                                        .required(true)//是否必填
                                                                        .modelRef(new ModelRef("string")) //参数数据类型
                                                                        .build()
                                                        ))
                                                .build()),
                                false)));


    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return DocumentationType.SWAGGER_2.equals(documentationType);
    }
}