package com.rtc.manager.controller;

import com.rtc.manager.service.Elasticsearch;
import com.rtc.manager.service.EnterpriseManage;
import com.rtc.manager.service.Qcc;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ChenHang
 */
@Api(tags = "企业后台管理")
@ApiIgnore
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
     * 搜索企业-列表
     */
    @ApiOperation(value = "搜索企业-列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
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
     * 新增单个企业-mysql/es
     *
     * @param body
     * @param nation 国家
     * @param eType  地区
     * @return
     */
    @ApiIgnore
    @ApiOperation("新增单个企业")
    @PostMapping("addEnterprise")
    public ResultData addEnterprise(@RequestBody String body,
                                    @RequestParam(name = "nation") String nation,
                                    @RequestParam(name = "e_type") String eType) {

        return qcc.addEnterprise(body, nation, eType);
    }

    /**
     * 企业修改-es/mysql
     */

    /**
     * 企业删除-es/mysql-多个
     */
    @ApiIgnore
    @PostMapping("delEnterprise")
    public ResultData delEnterprise(@RequestBody String body) {
        return elasticsearch.delEnterprise(body);
    }

    //todo 用户权限管理
}
