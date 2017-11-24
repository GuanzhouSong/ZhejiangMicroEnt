/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.CardUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidAltitemDto;
import com.icinfo.cs.ext.mapper.MidAltitemMapper;
import com.icinfo.cs.ext.service.IMidAltitemService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_mid_altitem 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Service
public class MidAltitemServiceImpl extends MyBatisServiceSupport implements IMidAltitemService {
	@Autowired
	private MidAltitemMapper midAltitemMapper;

	@Override
	public List<MidAltitemDto> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		List<MidAltitemDto> midAltitemDtos = midAltitemMapper.queryPageResultByPripid(request.getParams());
		if (midAltitemDtos == null) {
			return midAltitemDtos;
		}

		for (int i = 0; i < midAltitemDtos.size(); i++) {
			String altBeContent = midAltitemDtos.get(i).getAltBeContent();
			altBeContent = CardUtil.getHide(altBeContent);
			midAltitemDtos.get(i).setAltBeContent(altBeContent);

			String altAfContent = midAltitemDtos.get(i).getAltAfContent();
			altAfContent = CardUtil.getHide(altAfContent);
			midAltitemDtos.get(i).setAltAfContent(altAfContent);

			String altitem = midAltitemDtos.get(i).getAltItem();
			// 将如下数字用*号替代
			if ("02".equals(altitem) || "03".equals(altitem) || "10".equals(altitem) || "23".equals(altitem)
					|| "19".equals(altitem) || "50".equals(altitem) || "70".equals(altitem) || "124".equals(altitem)
					|| "119".equals(altitem)) {
				if (!StringUtil.isEmpty(altBeContent)) {
					altBeContent = Pattern.compile("\\d").matcher(altBeContent).replaceAll("*");
					midAltitemDtos.get(i).setAltBeContent(altBeContent);
				}
				if (!StringUtil.isEmpty(altAfContent)) {
					altAfContent = Pattern.compile("\\d").matcher(altAfContent).replaceAll("*");
					midAltitemDtos.get(i).setAltAfContent(altAfContent);
				}

			}
		}
		return midAltitemDtos;
	}

	/**
	 * 
	 * 描述 根据主体身份代码获取变更信息 @author 赵祥江 @date 2017年7月12日 下午4:17:04 @param @return
	 * List<MidAltitemDto> @throws
	 */
	@Override
	public List<MidAltitemDto> selectMidAltitemByPripid(String priPid) {
		Map<String, Object> qMap = new HashMap<String, Object>();
		qMap.put("priPID", priPid);
		return midAltitemMapper.selectMidAltitemByPripid(qMap);
	}

}