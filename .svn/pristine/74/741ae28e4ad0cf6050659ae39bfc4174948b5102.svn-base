/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.icinfo.cs.other.dto.PubSamllSupportDto;
import com.icinfo.cs.other.model.PubSamllSupport;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_small_suporrt 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月28日
 */
public interface IPubSamllSupportService extends BaseService {
	/**
	 * 
	 * 描述: 多条件查询
	 * @auther ljx
	 * @date 2016年11月28日 
	 * @param map
	 * @return
	 */
	List<PubSamllSupportDto> selectByCation(PageRequest request);
	/**
	 * 
	 * 描述: 保存操作
	 * @auther ljx
	 * @date 2016年11月28日 
	 * @param pubSamllSupport
	 * @return
	 */
	 
	int saveSmalSupport(PubSamllSupport pubSamllSupport);
	/**
	 * 
	 * 描述: 更新操作
	 * @auther ljx
	 * @date 2016年11月28日 
	 * @param pubSamllSupport
	 * @return
	 */
	int updateSmallSupport(PubSamllSupport pubSamllSupport);
	
	/**
	 * 
	 * 描述:查询操作
	 * @auther ljx
	 * @date 2016年11月28日 
	 * @param uid
	 * @return
	 */
	PubSamllSupport  selectByOne(String uid);
	/**
	 * 
	 * 描述:批量删除操作
	 * @auther ljx
	 * @date 2016年11月28日 
	 * @param uid
	 * @return
	 */
	int deleteByUids(String uid);
	/**
	 * 
	 * 描述: 审核
	 * @auther ljx
	 * @date 2016年11月29日 
	 * @param pubSamllSupport
	 * @return
	 * @throws Exception
	 */
	int auditSmallSupport(PubSamllSupport pubSamllSupport) throws Exception;
	
	/**
	 * 
	 * 描述: Excel导入
	 * @auther ljx
	 * @date 2016年11月29日 
	 * @param list
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public int importByExcel(List<List<Object>> list,HttpSession session) throws Exception;
	
	
}