package com.rtc.manager.controller;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.service.Qcc;
import com.rtc.manager.vo.QccListVO;
import com.rtc.manager.vo.QccVO;
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

    /**
     * 搜索企业-列表
     *
     * @param name 企业名
     * @return
     */
    @ApiOperation("搜索企业-列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "企业名", required = true),
            @ApiImplicitParam(name = "pageNum", value = "当前页数", required = false),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false)})
    @GetMapping("listEnterprise")
    public ResultData<QccListVO> listEnterprise(@RequestParam(name = "name", required = true) String name,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<QccListVO> info = null;
        try {
            info = qcc.listEnterprise(name, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("getEnterprise错误,参数是{}", name);
            return ResultData.FAIL(info, 500);
        }
        return ResultData.SUCCESS(info);
    }

    /**
     * 企业详情
     *
     * @param enterpriseId
     * @return
     */
    @ApiOperation("企业详情")
    @ApiImplicitParam(name = "enterpriseId", value = "企业id", required = true)
    @GetMapping("getEnterprise")
    public ResultData<QccVO> getEnterprise(@RequestParam(name = "enterpriseId", required = true) String enterpriseId) {
        QccVO qccVO = null;
        try {
            qccVO = qcc.getEnterprise(enterpriseId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("getEnterprise错误,参数是{}", enterpriseId);
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
            @ApiImplicitParam(name = "pageNum", value = "当前页数", required = false),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false)})
    @GetMapping("getEnterpriseDetail")
    public ResultData getEnterpriseDetail(@RequestParam(name = "name", required = true) String name,
                                          @RequestParam(name = "enterpriseId", required = true) String enterpriseId,
                                          @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                          @RequestParam(name = "pageSize", required = false, defaultValue = "0") int pageSize) {

        PageInfo<List> list = qcc.getEnterpriseDetail(name, enterpriseId, pageNum, pageSize);
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
    public ResultData getEnterpriseSubDetail(@RequestParam(name = "name", required = true) String name,
                                             @RequestParam(name = "pid", required = true) Integer id) {
        Object data = qcc.getEnterpriseSubDetail(name, id);
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
            @ApiImplicitParam(name = "pageNum", value = "当前页数", required = false),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false)})
    @GetMapping("getEnterpriseSubDetailMuti")
    public ResultData getEnterpriseSubDetailMuti(@RequestParam(name = "name", required = true) String name,
                                                 @RequestParam(name = "pid", required = false) Integer id,
                                                 @RequestParam(name = "enterpriseId", required = false) String enterpriseId,
                                                 @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                 @RequestParam(name = "pageSize", required = false, defaultValue = "0") int pageSize) {
        Object list = qcc.getEnterpriseSubDetailMuti(name, enterpriseId, id, pageNum, pageSize);
        return ResultData.SUCCESS(list);
    }
}
