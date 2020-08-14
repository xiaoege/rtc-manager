package com.rtc.manager.controller;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.service.India;
import com.rtc.manager.service.Qcc;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.vo.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author ChenHang
 */
@Api(tags = "企业查询")
@RestController
@RequestMapping("enterprise")
public class EnterpriseController {

    private final Logger logger = LoggerFactory.getLogger(EnterpriseController.class);

    @Autowired
    private Qcc qcc;

    @Autowired
    private India india;

    /**
     * 搜索企业-列表
     *
     * @param name 企业名
     * @return
     */
    @ApiOperation("搜索企业-列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "企业名", required = true),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从0开始", required = false, defaultValue = "0"),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false, defaultValue = "20")})
    @GetMapping("listEnterprise")
    public ResultData listEnterprise(@RequestParam(name = "name", required = true) String name,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "0") int pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize) {
        ResultData resultData = null;
        try {
            resultData = qcc.listEnterprise(name, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("listEnterprise错误, {}", CommonUtils.getExceptionInfo(e));
        }
        return resultData;
    }

    /**
     * 企业详情
     *
     * @param enterpriseId
     * @return
     */
    @ApiOperation("企业详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "enterpriseId", value = "企业id", required = true),
            @ApiImplicitParam(name = "nation", value = "国家：china / india", required = true),
            @ApiImplicitParam(name = "e_type", value = "企业类型，对应国家：china:china / india:[cin, llpin]", required = true)})
    @GetMapping("getEnterprise")
    public ResultData<Object> getEnterprise(@RequestParam(name = "enterpriseId", required = true) String enterpriseId,
                                            @RequestParam(name = "nation", required = true) String nation,
                                            @RequestParam(name = "e_type", required = true) String eType) {
        Object qccVO = null;
        try {
            qccVO = qcc.getEnterprise(enterpriseId, nation, eType);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("getEnterprise错误, {}", CommonUtils.getExceptionInfo(e));
            return ResultData.FAIL(qccVO, 500);
        }
        return ResultData.SUCCESS(qccVO);
    }

    /**
     * 五大类-列表
     *
     * @param name
     * @param enterpriseId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("五大类-列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "类别", required = true),
            @ApiImplicitParam(name = "enterpriseId", value = "企业id", required = true),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从1开始", required = false),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false),
            @ApiImplicitParam(name = "nation", value = "国家：china", required = true),
            @ApiImplicitParam(name = "e_type", value = "企业类型，对应国家：china:china", required = true)})
    @GetMapping("getEnterpriseDetail")
    public ResultData<Object> getEnterpriseDetail(@RequestParam(name = "name", required = true) String name,
                                                  @RequestParam(name = "enterpriseId", required = true) String enterpriseId,
                                                  @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                  @RequestParam(name = "pageSize", required = false, defaultValue = "0") int pageSize,
                                                  @RequestParam(name = "nation", required = true) String nation,
                                                  @RequestParam(name = "e_type", required = true) String eType) {

        PageInfo<List> list = qcc.getEnterpriseDetail(name, enterpriseId, pageNum, pageSize, nation, eType);
        return ResultData.SUCCESS(list);
    }

    /**
     * 五大类-详情
     *
     * @param name
     * @param id
     * @return
     */
    @ApiIgnore
    @Deprecated
    @GetMapping("getEnterpriseSubDetail")
    public ResultData<Object> getEnterpriseSubDetail(@RequestParam(name = "name", required = true) String name,
                                                     @RequestParam(name = "pid", required = true) Integer id,
                                                     @RequestParam(name = "nation", required = true) String nation,
                                                     @RequestParam(name = "e_type", required = true) String eType) {
        Object data = qcc.getEnterpriseSubDetail(name, id, nation, eType);
        return ResultData.SUCCESS(data);
    }

    /**
     * 五大类-详情,适配ios，只提供一个接口，不传入pid则根据enterpriseId查
     *
     * @param name
     * @param enterpriseId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("五大类-详情")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "类别", required = true),
            @ApiImplicitParam(name = "pid", value = "详情id", required = false),
            @ApiImplicitParam(name = "enterpriseId", value = "企业id", required = false),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从1开始", required = false),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false),
            @ApiImplicitParam(name = "nation", value = "国家：china", required = true),
            @ApiImplicitParam(name = "e_type", value = "企业类型，对应国家：china:china", required = true)})
    @GetMapping("getEnterpriseSubDetailMuti")
    public ResultData<Object> getEnterpriseSubDetailMuti(@RequestParam(name = "name", required = true) String name,
                                                         @RequestParam(name = "pid", required = false) Integer id,
                                                         @RequestParam(name = "enterpriseId", required = false) String enterpriseId,
                                                         @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                         @RequestParam(name = "pageSize", required = false, defaultValue = "0") int pageSize,
                                                         @RequestParam(name = "nation", required = true) String nation,
                                                         @RequestParam(name = "e_type", required = true) String eType) {
        Object list = qcc.getEnterpriseSubDetailMuti(name, enterpriseId, id, pageNum, pageSize, nation, eType);
        return ResultData.SUCCESS(list);
    }

    /**
     * 印度-企业列表
     *
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @ApiIgnore
    @GetMapping("listIndiaEnterprise")
    public ResultData listIndiaEnterprise(@RequestParam(name = "name", required = true) String name,
                                          @RequestParam(name = "pageNum", required = false, defaultValue = "0") int pageNum,
                                          @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) throws Exception {
        List list = india.listIndiaEnterprise(name, pageNum, pageSize);
        return ResultData.SUCCESS(list);
    }

    /**
     * 印度-企业详情
     *
     * @param enterpriseId
     * @return
     * @throws Exception
     */
    @ApiIgnore
    @GetMapping("getIndiaEnterprise")
    public ResultData getIndiaEnterprise(@RequestParam(name = "enterpriseId", required = true) String enterpriseId,
                                         @RequestParam(name = "e_type", required = true) String eType,
                                         @RequestParam(name = "nation", required = true) String nation) throws Exception {
        Object vo = india.getIndiaEnterprise(enterpriseId, eType);
        return ResultData.SUCCESS(vo);
    }
}
