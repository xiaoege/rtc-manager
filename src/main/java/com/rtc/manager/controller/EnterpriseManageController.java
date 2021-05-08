package com.rtc.manager.controller;

import com.rtc.manager.config.SwaggerConfig;
import com.rtc.manager.service.Elasticsearch;
import com.rtc.manager.service.EnterpriseManage;
import com.rtc.manager.service.Qcc;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ChenHang
 */
//@ApiIgnore
@Api(tags = "企业后台管理")
@RestController
@RequestMapping(("enterpriseManage"))
public class EnterpriseManageController {
    private final Logger logger = LoggerFactory.getLogger(EnterpriseController.class);

    @Autowired
    private Qcc qcc;

    @Autowired
    private EnterpriseManage enterpriseManage;

    @Autowired
    private Elasticsearch elasticsearch;

    /**
     * 搜索企业-列表，此接口的查询不限制必须查name，如果不传入name或者name为""时，改为查所有
     */
    @ApiOperation(value = "搜索企业-列表", notes = "此接口的查询不限制必须查name，如果不传入name或者name为\"\"时，改为查所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "name", value = "企业名", required = true),
            @ApiImplicitParam(name = "idx", value = "选择特定搜索国别，参数实例：[\"china\",\"india-cin\",\"india-llpin\",\"vietnam\"]", required = false),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从1开始", required = false, defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false, defaultValue = "20")
    })
    @GetMapping("listEnterprise")
    public ResultData<SearchEnterpriseListVO> listEnterprise(@RequestParam(name = "name", required = false) String name,
                                                             @RequestParam(name = "idx", required = false) String idx,
                                                             @RequestParam(name = "pageNum", required = false, defaultValue = "0") int pageNum,
                                                             @RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize) {
        // 此处的pageNum在es里从0开始
        if (pageNum < 2) {
            pageNum = 0;
        } else {
            pageNum -= 1;
        }

        ResultData resultData = null;
        try {
            resultData = enterpriseManage.listEnterprise(name, idx, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("listEnterprise错误, {}", CommonUtils.getExceptionInfo(e));
        }
        return resultData;
    }


    /**
     * 新增单个企业-es/mysql
     *
     * @param body
     * @param nation 国家
     * @param eType  地区
     * @return
     */
    @ApiOperation("新增单个企业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "body", value = "企业数据请看文档", paramType = "body", required = true),
            @ApiImplicitParam(name = "nation", value = SwaggerConfig.NATION, paramType = "query", required = true),
            @ApiImplicitParam(name = "e_type", value = SwaggerConfig.E_TYPE, paramType = "query", required = true),
    })
    @PostMapping("addEnterprise")
    public ResultData addEnterprise(@RequestBody String body,
                                    @RequestParam(name = "nation") String nation,
                                    @RequestParam(name = "e_type") String eType) throws Exception {
        return enterpriseManage.addEnterprise(body, nation, eType);
    }

    /**
     * 单个企业修改-es/mysql
     */
    @ApiOperation("修改单个企业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "body", value = "企业数据请看文档", paramType = "body", required = true),
            @ApiImplicitParam(name = "nation", value = SwaggerConfig.NATION, paramType = "query", required = true),
            @ApiImplicitParam(name = "e_type", value = SwaggerConfig.E_TYPE, paramType = "query", required = true),
            @ApiImplicitParam(name = "esId", value = "esId", paramType = "query", required = true),
            @ApiImplicitParam(name = "enterpriseId", value = "enterpriseId", paramType = "query", required = true),
            @ApiImplicitParam(name = "timezone", value = "时区，参数示例：8或者-8, 范围: -18 to 18 的整数", paramType = "query", required = false),
    })
    @PostMapping("modifyEnterprise")
    @ApiResponses({
            @ApiResponse(code = 1101, message = "修改企业时该enterpriseId不存在")
    })
    public ResultData modifyEnterprise(@RequestBody String body,
                                       @RequestParam(name = "nation") String nation,
                                       @RequestParam(name = "e_type") String eType,
                                       @RequestParam(name = "esId") String esId,
                                       @RequestParam(name = "enterpriseId") String enterpriseId,
                                       String timezone) throws Exception {
        return enterpriseManage.modifyEnterprise(body, nation, eType, esId, enterpriseId, timezone);
    }

    /**
     * 企业删除-es/mysql-多个
     */
    @ApiOperation("企业删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "body", value = "参数示例：[\n" +
                    "    {\n" +
                    "        \"esId\": \"esId\",\n" +
                    "        \"pid\": 23,\n" +
                    "        \"idx\": \"选择特定搜索国别，参数实例：[\"china\",\"india-cin\",\"india-llpin\",\"vietnam\"]\"\n" +
                    "    }\n" +
                    "]", paramType = "body", required = true)
    })
    @PostMapping("delEnterprise")
    public ResultData delEnterprise(@RequestBody String body) {
        return elasticsearch.delEnterprise(body);
    }

    /**
     * 中国企业-五大类-新增
     *
     * @param body         五大类详情数据
     * @param category     五大类栏目
     * @param enterpriseId 企业id
     * @return
     */
    @ApiOperation("中国企业-五大类-新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "body", value = "企业数据请看文档", paramType = "body", required = true),
            @ApiImplicitParam(name = "category", value = "五大类栏目,请看文档", paramType = "query", required = true),
            @ApiImplicitParam(name = "enterpriseId", value = "enterpriseId", paramType = "query", required = true),
    })
    @PostMapping("addChinaCategory")
    public ResultData addChinaCategory(@RequestBody String body,
                                       @RequestParam(name = "category") String category,
                                       @RequestParam(name = "enterpriseId") String enterpriseId) throws Exception {
        return qcc.addChinaCategory(body, category, enterpriseId);
    }

    /**
     * 中国企业-五大类-修改
     *
     * @param body         五大类详情新数据
     * @param category     五大类栏目
     * @param enterpriseId 企业id
     * @param id           五大类id
     * @return
     */
    @ApiOperation("中国企业-五大类-修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "body", value = "企业数据请看文档", paramType = "body", required = true),
            @ApiImplicitParam(name = "category", value = "五大类栏目,请看文档", paramType = "query", required = true),
            @ApiImplicitParam(name = "enterpriseId", value = "enterpriseId", paramType = "query", required = true),
            @ApiImplicitParam(name = "pid", value = "pid", paramType = "query", required = true),
    })
    @PostMapping("modifyChinaCategory")
    public ResultData modifyChinaCategory(@RequestBody String body,
                                          @RequestParam(name = "category") String category,
                                          @RequestParam(name = "enterpriseId") String enterpriseId,
                                          @RequestParam(name = "pid") Integer id) throws Exception {
        return qcc.modifyChinaCategory(body, category, enterpriseId, id);
    }

    /**
     * 中国企业-五大类-删除
     * 根据五大类的id来删除
     *
     * @param body     id的数组
     * @param category 五大类栏目
     * @return
     */
    @ApiOperation("中国企业-五大类-删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "body", value = "五大类pid的数组", paramType = "body", required = true),
            @ApiImplicitParam(name = "category", value = "五大类栏目,请看文档", paramType = "query", required = true),
    })
    @PostMapping("delChinaCategory")
    public ResultData delChinaCategory(@RequestBody String body,
                                       @RequestParam(name = "category") String category) throws Exception {
        return qcc.delChinaCategory(body, category);
    }

    /**
     * 上传logo图片
     *
     * @return 可访问的临时地址
     */
    @ApiOperation("上传logo图片")
    @PostMapping("uploadLogo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "file", value = "后缀名是jpg,jpeg,png,bmp格式的图片,大小在2MB以内", paramType = "form", dataType = "__file", required = true),
    })
    @ApiResponses({
            @ApiResponse(code = 905, message = "文件格式错误")
    })
    public ResultData uploadLogo(@RequestParam MultipartFile file) throws Exception {
        return enterpriseManage.uploadLogo(file);
    }

}
