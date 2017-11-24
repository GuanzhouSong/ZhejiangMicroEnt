/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service.impl;

import com.icinfo.cs.depsyn.mapper.CsDepsynNoticeMapper;
import com.icinfo.cs.depsyn.model.CsDepsynNotice;
import com.icinfo.cs.depsyn.service.ICsDepsynNoticeService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_notice 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
@Service
public class CsDepsynNoticeServiceImpl extends MyBatisServiceSupport implements ICsDepsynNoticeService {

    @Autowired
    private CsDepsynNoticeMapper csDepsynNoticeMapper;

    /**
     * 根据企业名称或注册号或统一社会信用代码查询行政处罚数据
     *
     * @param params 查询参数
     * @return
     * @throws Exception
     */
    @Override
    public List<CsDepsynNotice> queryNotice(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.parseInt(String.valueOf(params.get("pageNum"))), Integer.parseInt(String.valueOf(params.get("pageSize"))));
        Example example = new Example(CsDepsynNotice.class);
        example.setOrderByClause(" id desc ");
        example.createCriteria().andEqualTo("inputDepCode", params.get("deptCode"));
        return csDepsynNoticeMapper.selectByExample(example);
    }

    @Override
    public int addNotice(CsDepsynNotice csDepsynNotice) {
        return csDepsynNoticeMapper.insert(csDepsynNotice);
    }
}