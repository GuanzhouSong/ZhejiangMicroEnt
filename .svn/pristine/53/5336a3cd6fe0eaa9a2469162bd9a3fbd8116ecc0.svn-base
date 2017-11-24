package com.icinfo.cs.nocreditPunish.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.nocreditPunish.model.NoCreditPunishBack;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * cs_nocredit_punishback 对应的Mapper接口.<br>
 * @author caoxu
 * @date 2016年10月18日
 */
public interface NoCreditPunishBackMapper extends Mapper<NoCreditPunishBack> {
	
	/**
	 * 判断某个部门是否已反馈
	 * @param batchNo
	 * @param deptCode
	 * @return
	 */
	List<NoCreditPunishBack> deptBackExist(Map<String, Object> parms);
	
	void updateBack(NoCreditPunishBack noCreditPunishBack);

}
