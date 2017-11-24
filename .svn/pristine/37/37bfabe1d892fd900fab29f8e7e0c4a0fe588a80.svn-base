/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年02月13日
 * @version 2.0
 */
package com.icinfo.cs.simpleesc.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.simpleesc.dto.ErEscAppinfoDto;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    er_esc_appinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
public interface ErEscAppinfoMapper extends Mapper<ErEscAppinfo> {

	/**
	 * 描述：根据内部序号查询简易注销公告
	 * @author baifangfang
	 * @date 2017-02-13
	 * @param priPID
	 * @return
	 */
	ErEscAppinfoDto queryResultByPriPID(Map<String, Object> queryMap);
    
	/**
	 * 描述：查询正在进行简易注销公告的信息（用于信息公告）
	 * @author yujingwei
	 * @date 2017-02-14
	 * @param updateDate
	 * @return List<ErEscAppinfo
	 */
	List<ErEscAppinfo> selectEscAppInfoForBulletin(String updateDate);
	
	/**
	 * 
	 * 描述   分页查询简易注销公告
	 * @author 赵祥江
	 * @date 2017年2月21日 下午5:07:09 
	 * @param 
	 * @return List<ErEscAppinfo>
	 * @throws
	 */
	List<ErEscAppinfoDto> selectErEscAppinfoPageResult(Map<String, Object> queryMap); 
}