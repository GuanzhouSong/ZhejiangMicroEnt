/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service.impl;

import com.icinfo.cs.depsyn.dto.CsDepsynSmallDto;
import com.icinfo.cs.depsyn.mapper.CsDepsynSmallMapper;
import com.icinfo.cs.depsyn.model.CsDepsynSmall;
import com.icinfo.cs.depsyn.service.ICsDepsynSmallService;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_small 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
@Service
public class CsDepsynSmallServiceImpl extends MyBatisServiceSupport implements ICsDepsynSmallService {

    @Autowired
    private CsDepsynSmallMapper csDepsynSmallMapper;

    // 企业基本信息
    @Autowired
    private MidBaseInfoMapper midBaseInfoMapper;

    /**
     * 根据企业名称或注册号或统一社会信用代码查询小微企业扶持
     *
     * @param params 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> querySmall(Map<String, Object> params) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        // 1. 查询企业信息
        List<MidBaseInfo> baseInfos = midBaseInfoMapper.selectMidInfoByKeyword(params);
        MidBaseInfo baseInfo = baseInfos.isEmpty() ? null : baseInfos.get(0);
        if (baseInfo == null) {
            return resultMap;
        }
        resultMap.put("baseInfo", baseInfo);

        // 2. 查询行政惩罚
        PageHelper.startPage(Integer.parseInt(String.valueOf(params.get("pageNum"))), Integer.parseInt(String.valueOf(params.get("pageSize"))));
        Page<CsDepsynSmallDto> list = csDepsynSmallMapper.querySmall(params);
        resultMap.put("dataList",new PageResponse<>(list));

        return resultMap;
    }


    /**
     * 新增小微企业扶持
     *
     * @param csDepsynSmall 小微企业扶持
     * @return 新增条数
     * @throws Exception
     */
    @Override
    public int addSmall(CsDepsynSmall csDepsynSmall) throws Exception {
        return csDepsynSmallMapper.insert(csDepsynSmall);
    }

    /**
     * 批量新增小微企业扶持
     *
     * @param list 小微企业扶持集合
     * @return 新增条数
     * @throws Exception
     */
    @Override
    public int addSmallBatch(List<CsDepsynSmall> list) throws Exception {
        int result = 0;
        for(CsDepsynSmall small: list) {
            int row = csDepsynSmallMapper.insert(small);
            result += row;
        }
        return result;
    }
}