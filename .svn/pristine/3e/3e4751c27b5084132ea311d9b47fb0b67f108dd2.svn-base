/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.CardUtil;
import com.icinfo.cs.es.dto.CsMidPersonDto;
import com.icinfo.cs.es.mapper.CsMidPersonMapper;
import com.icinfo.cs.es.service.ICsMidPersonService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_mid_person 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月06日
 */
@Service
public class CsMidPersonServiceImpl extends MyBatisServiceSupport implements ICsMidPersonService {

	private static final Integer PAGE_FROM = 0;
	private static final Integer PAGE_SIZE = 100;

	@Autowired
	private CsMidPersonMapper csMidPersonMapper;

	/**
	 * 获取人员信息列表
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsMidPersonDto> queryList(Map<String, Object> map) throws Exception {
		map.put("pageFrom", PAGE_FROM);
		map.put("pageSize", PAGE_SIZE);
		map.get("keyword");
		return csMidPersonMapper.selectPersonList(map);
	}

	private Map<String, Object> getQueryCommonParam(String keyword, String sex, String dictCode){
		String[] strArray = keyword.trim().split(" ");
		Map<String, Object> map = new HashMap<String, Object>();
		String keywordStr = "";
		if (strArray.length == 1) {// 只有一个查询条件
			keywordStr = strArray[0].trim();
			map.put("keyword", keywordStr);

		} else {// 姓名+身份证
			map.put("keyword", strArray[0]);
			map.put("keyword2", strArray[1]);
			keywordStr = strArray[1].trim();

		}

		CardUtil cc = new CardUtil();
		try {
			if("".equals(cc.IDCardValidate(keywordStr)) && keywordStr.length() ==15){//15转18
                map.put("cerNO18", cc.getEighteenIDCard(keywordStr));
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("sex", sex);
		map.put("dictCode", dictCode);
		map.put("pageFrom", PAGE_FROM);
		map.put("pageSize", PAGE_SIZE);
		return map;
	}
	public List<CsMidPersonDto> queryList(String keyword, String sex, String dictCode) throws Exception {
		Map<String, Object> map = getQueryCommonParam(keyword,sex,dictCode);
		return csMidPersonMapper.selectPersonList(map);
	}

	@Override
	public List<CsMidPersonDto> selectPersonEntPageList(String type, String cerNo, PageRequest request)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("cerNo", cerNo);
		request.getParams().putAll(map);
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return csMidPersonMapper.selectPersonEntPageList(request.getParams());
	}
	

	@Override
	public Long selectPersonListCount(String keyword, String sex, String dictCode) throws Exception {
		Map<String, Object> map = getQueryCommonParam(keyword,sex,dictCode);
		return csMidPersonMapper.selectPersonListCount(map);
	}
	
	

}