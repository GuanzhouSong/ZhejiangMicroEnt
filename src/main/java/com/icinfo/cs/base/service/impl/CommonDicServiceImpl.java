/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import java.util.List;

import com.icinfo.cs.base.mapper.CommonDicMapper;
import com.icinfo.cs.base.model.CommonDic;
import com.icinfo.cs.base.service.ICommonDicService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_common_dic 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月08日
 */
@Service
public class CommonDicServiceImpl extends MyBatisServiceSupport implements ICommonDicService {
    @Autowired
	private CommonDicMapper commonDicMapper;
	/**
	 * 
	 * 描述   根据dicColumn查询
	 * @author 赵祥江
	 * @date 2016年11月10日 下午9:00:10 
	 * @param 
	 * @return List<CommonDic>
	 * @throws
	 */
	@Override
	public List<CommonDic> selectCommonDicListByDicColumn(String dicColumn) {
		CommonDic commonDic=new CommonDic();
		commonDic.setDicColumn(dicColumn);
		return commonDicMapper.select(commonDic);
	}
}