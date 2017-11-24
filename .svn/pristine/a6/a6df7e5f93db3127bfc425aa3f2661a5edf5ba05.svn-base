/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service.impl;

import com.icinfo.cs.depsyn.dto.CsDepsynPunishDto;
import com.icinfo.cs.depsyn.mapper.CsDepsynPunishMapper;
import com.icinfo.cs.depsyn.model.CsDepsynPunish;
import com.icinfo.cs.depsyn.service.ICsDepsynPunishService;
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
 * 描述:    cs_depsyn_punish 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月10日
 */
@Service
public class CsDepsynPunishServiceImpl extends MyBatisServiceSupport implements ICsDepsynPunishService {

    @Autowired
    private CsDepsynPunishMapper csDepsynPunishMapper;

    // 企业基本信息
    @Autowired
    private MidBaseInfoMapper midBaseInfoMapper;

    /**
     * 根据企业名称或注册号或统一社会信用代码查询行政处罚数据
     *
     * @param params 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> queryPunish(Map<String, Object> params) throws Exception {
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
        Page<CsDepsynPunishDto> list = csDepsynPunishMapper.queryPunish(params);
        resultMap.put("dataList",new PageResponse<>(list));

        return resultMap;
    }

    /**
     * 新增行政处罚
     *
     * @param csDepsynPunish 行政处罚
     * @return 新增条数
     * @throws Exception
     */
    @Override
    public int addPunish(CsDepsynPunish csDepsynPunish) throws Exception {
        return csDepsynPunishMapper.insert(csDepsynPunish);
    }

    /**
     * 批量新增行政处罚
     *
     * @param list 行政处罚集合
     * @return 新增条数
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addPunishBatch(List<CsDepsynPunish> list) throws Exception {
        int result = 0;
        for(CsDepsynPunish punish: list) {
            punish.setId(null);
            int row = csDepsynPunishMapper.insert(punish);
            result += row;
        }
        return result;
    }
   /**
    * 获取行政许可数据
    * @author zjj
    */
	@Override
	public List<CsDepsynPunishDto> searchPunish(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum() ,request.getLength());
		return csDepsynPunishMapper.queryPunish(request.getParams());
	}
	
	
	/**
     * 查询行政处罚数据
     */
	@Override
  	public int searchPunishTotal(Map<String,Object> qryMap) throws Exception{
		List<CsDepsynPunishDto> list = csDepsynPunishMapper.queryPunish(qryMap);
		if(list == null){
			return 0;
		}
  		return list.size();
  	}
	/**
	    * 获取行政许可数据
	    * @author zjj
	    */
	@Override
	public List<CsDepsynPunishDto> selectPunishList(Map<String, Object> qryMap) throws Exception {
		return csDepsynPunishMapper.queryPunish(qryMap);
	}

	@Override
	public int editPunish(CsDepsynPunish csDepsynPunish) throws Exception {
		return csDepsynPunishMapper.updateByPrimaryKeySelective(csDepsynPunish);
	}
	/**
     * 删除行政处罚信息
     * @author zjj
     */
	@Override
	public int deletePunish(String id) throws Exception {
		return csDepsynPunishMapper.deleteByPrimaryKey(Integer.parseInt(id));
	}

}