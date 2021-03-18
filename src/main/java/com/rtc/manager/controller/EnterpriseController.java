package com.rtc.manager.controller;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.service.India;
import com.rtc.manager.service.Qcc;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @ApiOperation(value = "搜索企业-列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "name", value = "企业名，参数示例：China:南京，India:banana，Vietnam:viet", required = true),
            @ApiImplicitParam(name = "idx", value = "选择特定搜索国别", required = false),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从1开始", required = false, defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false, defaultValue = "20")
    })
    @GetMapping("listEnterprise")
    public ResultData<SearchEnterpriseListVO> listEnterprise(@RequestParam(name = "name", required = true) String name,
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
            resultData = qcc.listEnterprise(name, idx, pageNum, pageSize);
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
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "enterpriseId", value = "企业id", required = true),
            @ApiImplicitParam(name = "nation", value = "国家：China / India / Vietnam / America / Canada", required = true),
            @ApiImplicitParam(name = "e_type", value = "企业类型，对应国家：China.China / India.[cin, llpin] / Vietnam.Vietnam /America.[Alabama, NewHampshire] / Canada.Canada", required = true),
            @ApiImplicitParam(name = "timeZone", value = "时区，参数示例：8或者-8, 范围: -18 to 18 的整数", required = false)
    })
    @GetMapping("getEnterprise")
    public ResultData<Object> getEnterprise(@RequestParam(name = "enterpriseId", required = true) String enterpriseId,
                                            @RequestParam(name = "nation", required = true) String nation,
                                            @RequestParam(name = "e_type", required = true) String eType,
                                            @RequestParam(name = "timeZone", required = false, defaultValue = "+0") String timeZone) {
        Object qccVO = null;
        try {
            qccVO = qcc.getEnterprise(enterpriseId, nation, eType, timeZone);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("getEnterprise错误, {}", CommonUtils.getExceptionInfo(e));
            return ResultData.FAIL(qccVO, 500);
        }
        return ResultData.SUCCESS(qccVO);
    }

    /**
     * 查询企业列表-Bulletin，用于app主页企业列表展示
     *
     * @return 默认每次返回10个企业
     */
    @ApiOperation("查询企业列表-Bulletin，用于app主页企业列表展示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "size", value = "每次返回个数", defaultValue = "10", paramType = "query")
    })
    @GetMapping("listEnterprise4Bulletin")
    public ResultData<SearchEnterpriseListVO> listEnterprise4Bulletin(@RequestParam(name = "size", defaultValue = "10") int size) {
        return qcc.listEnterprise4Bulletin(size);
    }

    /**
     * China企业：五大类-列表
     *
     * @param name
     * @param enterpriseId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("China企业：五大类-列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "name", value = "类别", required = true),
            @ApiImplicitParam(name = "enterpriseId", value = "企业id", required = true),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从1开始", required = false),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false),
            @ApiImplicitParam(name = "nation", value = "国家：China", required = false),
            @ApiImplicitParam(name = "e_type", value = "企业类型，对应国家：China.China", required = false)
    })
    @GetMapping("getEnterpriseDetail")
    public ResultData<Object> getEnterpriseDetail(@RequestParam(name = "name", required = true) String name,
                                                  @RequestParam(name = "enterpriseId", required = true) String enterpriseId,
                                                  @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                  @RequestParam(name = "pageSize", required = false, defaultValue = "0") int pageSize,
                                                  @RequestParam(name = "nation", required = false) String nation,
                                                  @RequestParam(name = "e_type", required = false) String eType) {

        PageInfo<List> list = qcc.getEnterpriseDetail(name, enterpriseId, pageNum, pageSize, nation, eType);
        return ResultData.SUCCESS(list);
    }

    /**
     * China企业：五大类-详情
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
                                                     @RequestParam(name = "nation", required = false) String nation,
                                                     @RequestParam(name = "e_type", required = false) String eType) {
        Object data = qcc.getEnterpriseSubDetail(name, id, nation, eType);
        return ResultData.SUCCESS(data);
    }

    /**
     * China企业：五大类-详情,适配ios，只提供一个接口，不传入pid则根据enterpriseId查
     *
     * @param name
     * @param enterpriseId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("China企业：五大类-详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "name", value = "类别", required = true),
            @ApiImplicitParam(name = "pid", value = "详情id", required = false),
            @ApiImplicitParam(name = "enterpriseId", value = "企业id", required = false),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从1开始", required = false),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false),
            @ApiImplicitParam(name = "nation", value = "国家：China", required = false),
            @ApiImplicitParam(name = "e_type", value = "企业类型，对应国家：China.China", required = false)
    })
    @GetMapping("getEnterpriseSubDetailMuti")
    public ResultData<Object> getEnterpriseSubDetailMuti(@RequestParam(name = "name", required = true) String name,
                                                         @RequestParam(name = "pid", required = false) Integer id,
                                                         @RequestParam(name = "enterpriseId", required = false) String enterpriseId,
                                                         @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                         @RequestParam(name = "pageSize", required = false, defaultValue = "0") int pageSize,
                                                         @RequestParam(name = "nation", required = false) String nation,
                                                         @RequestParam(name = "e_type", required = false) String eType) {
        Object list = qcc.getEnterpriseSubDetailMuti(name, enterpriseId, id, pageNum, pageSize, nation, eType);
        return ResultData.SUCCESS(list);
    }

    /**
     * 查看企业的所有评论
     *
     * @param enterpriseId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("查看企业的所有评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "enterpriseId", value = "企业id", required = true),
            @ApiImplicitParam(name = "timeZone", value = "时区，参数示例：8或者-8, 范围: -18 to 18 的整数", required = false),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从1开始", required = false, defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false, defaultValue = "2")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "省略一些分页返回的字段，主要的评论list: \"list\": [\n" +
                    "            {\n" +
                    "                \"comment\": \"评论内容\",\n" +
                    "                \"gmtCreate\": \"服务器所在时区的创建时间，不展示，暂时提供以防备用\",\n" +
                    "                \"nickname\": \"miao\",\n" +
                    "                \"portrait\": \"http://192.168.1.125/portrait/dc410238-c5cc-4ad3-8e2f-96e0b145b239/2020-09-02-9643372645178440190.png\",\n" +
                    "                \"stars\": \"3.5\",\n" +
                    "                \"createTime\": \"评论创建时间\",\n" +
                    "                \"commentId\": 90\n" +
                    "            }" +
                    "]")
    }
    )
    @GetMapping("listEnterpriseComment")
    public ResultData listEnterpriseComment(@RequestParam(name = "enterpriseId", required = true) String enterpriseId,
                                            @RequestParam(name = "timeZone", required = false, defaultValue = "+0") String timeZone,
                                            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                            @RequestParam(name = "pageSize", required = false, defaultValue = "2") int pageSize) {
        return qcc.listEnterpriseComment(enterpriseId, timeZone, pageNum, pageSize);
    }


    /**
     * 搜索企业-企业推荐
     *
     * @param name 企业名
     * @return 默认返回10个
     */
    @ApiOperation(value = "搜索企业-企业推荐", notes = "默认返回10个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "name", value = "企业名，参数示例：China:南京，India:banana，Vietnam:viet", required = true),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从1开始", required = false, defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false, defaultValue = "10")
    })
    @GetMapping("listRecommend")
    public ResultData<SearchEnterpriseListVO> listRecommend(@RequestParam(name = "name", required = true) String name,
                                                            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        ResultData resultData = null;
        try {
            resultData = qcc.listRecommend(name, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("listEnterprise错误, {}", CommonUtils.getExceptionInfo(e));
        }
        return resultData;
    }

    /**
     * 新增企业-单个
     *
     * @return
     */
    @PostMapping("addEnterprise")
    public ResultData addEnterprise(@RequestBody String body,
                                    @RequestParam(name = "nation") String nation,
                                    @RequestParam(name = "e_type") String eType) {
        qcc.addEnterprise(body, nation, eType);

        return null;
    }
}
