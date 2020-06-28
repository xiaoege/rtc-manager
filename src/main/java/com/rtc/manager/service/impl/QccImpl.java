package com.rtc.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtc.manager.dao.QccMapper;
import com.rtc.manager.service.Qcc;
import com.rtc.manager.vo.QccListVO;
import com.rtc.manager.vo.QccVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenHang
 */
@Service
public class QccImpl implements Qcc {

    @Autowired
    private QccMapper qccMapper;

    @Override
    public PageInfo<QccListVO> listEnterprise(String name, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List list = qccMapper.selectByName(name);
        return new PageInfo<>(list);
    }

    @Override
    public QccVO getEnterprise(String enterpriseId) {
        QccVO qccVO = qccMapper.selectByEnterpriseId(enterpriseId);
        return qccVO;
    }
}
