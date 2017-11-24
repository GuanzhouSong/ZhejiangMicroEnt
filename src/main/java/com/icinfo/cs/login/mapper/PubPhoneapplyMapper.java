/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月28日
 * @version 2.0
 */
package com.icinfo.cs.login.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.login.dto.PubPhoneapplyDto;
import com.icinfo.cs.login.model.PubPhoneapply;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_phoneapply 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface PubPhoneapplyMapper extends Mapper<PubPhoneapply> {
	
	/**
	 * 
	 * 描述: 联络员确认书打印
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param map
	 * @return
	 */
	public List<PubPhoneapplyDto> selectPubPhoneapplyPrint(Map<String, Object> map);
    
	/**
	 * 
	 * 描述: 获取联络员接收列表list
	 * @param map 
	 * @auther yujingwei
	 * @date 2016年8月29日 
	 * @return
	 */
	public List<PubPhoneapply> selectPubPhoneInfoAcceptList(Map<String, Object> map);
}