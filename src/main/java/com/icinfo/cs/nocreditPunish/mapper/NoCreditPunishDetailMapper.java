package com.icinfo.cs.nocreditPunish.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.nocreditPunish.model.NoCreditPunishDetail;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * cs_nocredit_punishdetail 对应的Mapper接口.<br>
 * @author caoxu
 * @date 2016年10月18日
 */
public interface NoCreditPunishDetailMapper extends Mapper<NoCreditPunishDetail> {
	
	/**
	 * 根据企业名称获取信息
	 * @param entName
	 * @return
	 */
	List<NoCreditPunishDetail> selectEnt(String entName);
	
	/**
	 * 根据证件号获取自然人
	 * @param entName
	 * @return
	 */
	List<NoCreditPunishDetail> selectMan(String keyword);

	/**
	 * 某家企业是否存在惩戒记录
	 * @param entName
	 * @return
	 */
	List<NoCreditPunishDetail> detailEntExist(String priPID);
	
	/**
	 * 某个自然人是否存在惩戒记录
	 * @param entName
	 * @return
	 */
	List<NoCreditPunishDetail> detailManExist(String cardNo);

	/** 
	 * 描述: 根据自然人身份号获取列表数据
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param map
	 * @return 
	 */
	
	List<NoCreditPunishDetail>  selectListByCerNO(Map<String, Object> map);
}
