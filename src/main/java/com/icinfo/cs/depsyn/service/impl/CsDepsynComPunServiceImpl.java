/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service.impl;

import com.icinfo.cs.depsyn.dto.CsDepsynComPunDto;
import com.icinfo.cs.depsyn.dto.CsDepsynPunishDto;
import com.icinfo.cs.depsyn.mapper.CsDepsynComPunMapper;
import com.icinfo.cs.depsyn.model.CsDepsynComPun;
import com.icinfo.cs.depsyn.service.ICsDepsynComPunService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_com_pun 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
@Service
public class CsDepsynComPunServiceImpl extends MyBatisServiceSupport implements ICsDepsynComPunService {

    @Autowired
    private CsDepsynComPunMapper csDepsynComPunMapper;

    /**
     * 根据证照号码/证件号码, 姓名查询
     *
     * @param params 查询参数
     * @return 查询结果
     */
    @Override
    public List<CsDepsynComPunDto> queryComPun(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.parseInt(String.valueOf(params.get("pageNum"))), Integer.parseInt(String.valueOf(params.get("pageSize"))));
        return csDepsynComPunMapper.queryComPun(params);
    }

    /**
     * 新增
     *
     * @param csDepsynComPun
     * @return
     */
    @Override
    public int addComPun(CsDepsynComPun csDepsynComPun) {
        return csDepsynComPunMapper.insert(csDepsynComPun);
    }
    
	/**
     * 获取数据反馈信息
     * @author zjj
     */
	@Override
	public List<CsDepsynComPunDto> searchFeedBackList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum() ,request.getLength());
		return csDepsynComPunMapper.searchFeedBackList(request.getParams());
	}
	/**
     * 条件查询
     * @author zjj
     */
	@Override
	public List<CsDepsynComPunDto> selectDepsynComPunList(Map<String, Object> params) throws Exception {
		return csDepsynComPunMapper.searchFeedBackList(params);
	}
}