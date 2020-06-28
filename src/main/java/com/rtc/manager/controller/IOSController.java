package com.rtc.manager.controller;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.service.Qcc;
import com.rtc.manager.vo.QccListVO;
import com.rtc.manager.vo.QccVO;
import com.rtc.manager.vo.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChenHang
 */
@RestController
@RequestMapping("ios")
public class IOSController {
//    @Autowired
//    private RtcEnterprise rtcEnterprise;

    private final Logger logger = LoggerFactory.getLogger(IOSController.class);

    @Autowired
    private Qcc qcc;

    /**
     * 搜索企业-列表
     *
     * @param name 企业名
     * @return
     */
    @GetMapping("listEnterprise")
    public ResultData listEnterprise(@RequestParam(name = "name", required = true) String name,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        PageInfo<QccListVO> info = null;
        try {
            info = qcc.listEnterprise(name, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("getEnterprise错误,参数是{},{}", name);
            return ResultData.FAIL(info, 500);
        }
        return ResultData.SUCCESS(info);
    }

    @GetMapping("getEnterprise")
    public ResultData getEnterprise(@RequestParam(name = "enterpriseId", required = true) String enterpriseId) {
        Object qccVO = null;
        try {
            qccVO = qcc.getEnterprise(enterpriseId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("getEnterprise错误,参数是{}", enterpriseId);
            return ResultData.FAIL(qccVO, 500);
        }
        return ResultData.SUCCESS(qccVO);
    }

    @GetMapping("getEnterpriseDetail")
    public ResultData getEnterpriseDetail(@RequestParam(name = "name", required = true) String name,
                                          @RequestParam(name = "enterpriseId", required = true) String enterpriseId) {
        List<Object> list = qcc.getEnterpriseDetail(name, enterpriseId);
        return ResultData.SUCCESS(list);
    }
}
