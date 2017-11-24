/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service.impl;

import com.icinfo.cs.depsyn.dto.CsDepsynLicenseDto;
import com.icinfo.cs.depsyn.dto.CsDepsynSpotDto;
import com.icinfo.cs.depsyn.mapper.CsDepsynSpotMapper;
import com.icinfo.cs.depsyn.model.CsDepsynSpot;
import com.icinfo.cs.depsyn.service.ICsDepsynSpotService;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_spot 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
@Service
public class CsDepsynSpotServiceImpl extends MyBatisServiceSupport implements ICsDepsynSpotService {

    @Autowired
    private CsDepsynSpotMapper csDepsynSpotMapper;

    // 企业基本信息
    @Autowired
    private MidBaseInfoMapper midBaseInfoMapper;

    /**
     * 根据企业名称或注册号或统一社会信用代码查询抽查检查数据
     *
     * @param params
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> querySpot(Map<String, Object> params) throws Exception {
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
        Page<CsDepsynSpotDto> list = csDepsynSpotMapper.querySpot(params);
        resultMap.put("dataList",new PageResponse<>(list));

        return resultMap;
    }

    /**
     * 新增抽查检查
     *
     * @param csDepsynSpot 抽查检查
     * @return 新增条数
     * @throws Exception
     */
    @Override
    public int addSpot(CsDepsynSpot csDepsynSpot) throws Exception {
        return csDepsynSpotMapper.insert(csDepsynSpot);
    }

    /**
     * 批量新增抽查检查
     *
     * @param list 抽查检查集合
     * @return 新增条数
     * @throws Exception
     */
    @Override
    public int addSpotBatch(List<CsDepsynSpot> list) throws Exception {
        int result = 0;
        for(CsDepsynSpot spot: list) {
            int row = csDepsynSpotMapper.insert(spot);
            result += row;
        }
        return result;
    }

    /**
     * 获取抽检抽查数据
     * @author zjj
     */
	@Override
	public List<CsDepsynSpotDto> searchSpot(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum() ,request.getLength());
		return csDepsynSpotMapper.querySpot(request.getParams());
	}
}