/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service.impl;

import com.icinfo.cs.depsyn.dto.CsDepsynLicenseDto;
import com.icinfo.cs.depsyn.mapper.CsDepsynLicenseMapper;
import com.icinfo.cs.depsyn.model.CsDepsynLicense;
import com.icinfo.cs.depsyn.service.ICsDepsynLicenseService;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_license 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
@Service
public class CsDepsynLicenseServiceImpl extends MyBatisServiceSupport implements ICsDepsynLicenseService {

    @Autowired
    private CsDepsynLicenseMapper csDepsynLicenseMapper;

    // 企业基本信息
    @Autowired
    private MidBaseInfoMapper midBaseInfoMapper;

    /**
     * 根据企业名称或注册号或统一社会信用代码查询行政许可数据
     *
     * @param params 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> queryLicense(Map<String, Object> params) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        // 1. 查询企业信息
        List<MidBaseInfo> baseInfos = midBaseInfoMapper.selectMidInfoByKeyword(params);
        MidBaseInfo baseInfo = baseInfos.isEmpty() ? null : baseInfos.get(0);
        if (baseInfo == null) {
            return resultMap;
        }
        resultMap.put("baseInfo", baseInfo);

        // 2. 查询行政许可
        PageHelper.startPage(Integer.parseInt(String.valueOf(params.get("pageNum"))), Integer.parseInt(String.valueOf(params.get("pageSize"))));
        Page<CsDepsynLicenseDto> list = csDepsynLicenseMapper.queryLicense(params);
        resultMap.put("dataList",new PageResponse<>(list));

        return resultMap;
    }
    
    /**
     * 
     * @param params
     * @return
     * @throws Exception
     */
    public int queryLicenseTotal(Map<String, Object> params) throws Exception{
    	List<CsDepsynLicenseDto> list = csDepsynLicenseMapper.queryLicense(params);
    	if(list == null){
    		return 0;
    	}
    	return list.size();
    }

    /**
     * 新增行政许可
     *
     * @param csDepsynLicense 行政许可
     * @return 新增条数
     * @throws Exception
     */
    @Override
    public int addLicense(CsDepsynLicense csDepsynLicense) throws Exception {
        return csDepsynLicenseMapper.insert(csDepsynLicense);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addLicenseBatch(List<CsDepsynLicense> list) throws Exception {
        int result = 0;
        for(CsDepsynLicense license: list) {
            license.setId(null);
            int row = csDepsynLicenseMapper.insert(license);
            result += row;
        }
        return result;
    }

	@Override
	public List<CsDepsynLicenseDto> searchLicense(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum() ,request.getLength());
		return csDepsynLicenseMapper.queryLicense(request.getParams());
	}

	@Override
	public List<CsDepsynLicenseDto> selectLicenseList(Map<String, Object> params) throws Exception {
		return csDepsynLicenseMapper.queryLicense(params);
	}

	@Override
	public int editLicense(CsDepsynLicense csDepsynLicense) throws Exception {
		return csDepsynLicenseMapper.updateByPrimaryKeySelective(csDepsynLicense);
	}

	@Override
	public int deleteLicense(String id) throws Exception {
		return csDepsynLicenseMapper.deleteByPrimaryKey(Integer.parseInt(id));
	}
}