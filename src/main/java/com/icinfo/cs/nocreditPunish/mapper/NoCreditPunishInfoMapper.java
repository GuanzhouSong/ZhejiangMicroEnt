package com.icinfo.cs.nocreditPunish.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishInfoDto;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * cs_nocredit_punishinfo 对应的Mapper接口.<br>
 * @author caoxu
 * @date 2016年10月18日
 */
public interface NoCreditPunishInfoMapper extends Mapper<NoCreditPunishInfo> {
	
	/**
	 * 获取需要反馈的戒单列表（企业、自然人）
	 * @return
	 */
	List<NoCreditPunishInfoDto> selectAuditedInfoList(Map<String, Object> parms);
	
	/**
	 * 获取未审核的戒单列表（企业、自然人）
	 * @return
	 */
	List<NoCreditPunishInfoDto> selectUnauditInfoList(Map<String, Object> parms);
	
	/**
	 * 获取所有的戒单列表（企业、自然人）
	 * @return
	 */
	List<NoCreditPunishInfoDto> selectAllInfoList(Map<String, Object> parms);
	
	/**
	 * 查询惩戒全信息列表
	 * @param parms
	 * @return
	 */
	List<NoCreditPunishInfoDto> selectAllFullInfoList(Map<String, Object> parms);
	
	/**
	 * 根据批号获取单据
	 * @param batchNo
	 * @return
	 */
	List<NoCreditPunishInfo> selectByBatchNo(String batchNo);

	/**
	 * 根据企业ID获取列表信息
	 * @anthor chenyu
	 * @return
	 */
	List<NoCreditPunishInfo> selectInfoListByPriPID(Map<String, Object> parms);
	
	/**
	 * 根据个人cerNO获取列表信息
	 * @anthor chenyu
	 * @return
	 */
	List<NoCreditPunishInfo> selectInfoListByCerNO(Map<String, Object> parms);

	NoCreditPunishInfoDto searchlistJSON_downednum(Map<String, Object> params);
    
	/**
	 * 插入企业失信联合惩戒公告数据
	 * @param qrMap 
	 * @anthor yujingwei
	 * @return void
	 */
	void doInsertAnnounceByNocreditInfo();
    
	/**
	 * 插入自然人失信联合惩戒公告数据
	 * @anthor yujingwei
	 * @return void
	 */
	void doInsertAnnounceByNocreditManInfo();
	
	/**
	 * 需要插入企业失信联合惩戒公告个数
	 * @param qrMap 
	 * @anthor yujingwei
	 * @return void
	 */
	int selectNeedCreateEntBulletinTotal();
	
	/**
	 * 需要插入自然人失信联合惩戒公告个数
	 * @param qrMap 
	 * @anthor yujingwei
	 * @return void
	 */
	int selectNeedCreateManBulletinTotal();
	
	/**
	 * 
	 * 描述   获取列表
	 * @author 赵祥江
	 * @date 2017年8月27日 下午12:21:27 
	 * @param 
	 * @return List<NoCreditPunishInfoDto>
	 * @throws
	 */
	List<NoCreditPunishInfoDto> selectAllInfoJsonList(Map<String, Object> parms)throws Exception;

}
