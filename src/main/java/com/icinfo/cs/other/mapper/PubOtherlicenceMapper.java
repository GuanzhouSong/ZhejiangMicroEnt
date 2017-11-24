/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月18日
 * @version 2.0
 */
package com.icinfo.cs.other.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.other.dto.LicenceInvalidCount;
import com.icinfo.cs.other.dto.PubOtherlicenceDto;
import com.icinfo.cs.other.model.PubOtherlicence;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_pub_otherlicence 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
public interface PubOtherlicenceMapper extends Mapper<PubOtherlicence> {
	/**
	 * 
	 * 描述: 多条查询
	 * 
	 * @auther ljx
	 * @date 2016年10月18日
	 * @param map
	 * @return
	 */
	List<PubOtherlicenceDto> selectPubOtherlicenceByCation(Map<String, Object> map);

	/**
	 * 
	 * 描述: 查询即时行政许可信息
	 * 
	 * @auther ljx
	 * @date 2016年10月20日
	 * @param map
	 * @return
	 */
	List<PubOtherlicenceDto> selectImPrimitByCation(Map<String, Object> map);

	/**
	 * 
	 * 描述: 统计
	 * 
	 * @auther ljx
	 * @date 2016年10月21日
	 * @return
	 */
	int selectCountOtherLicence(Map<String, Object> map);

	/**
	 * 
	 * 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年10月21日
	 * @return
	 */
	int selectCountPermit(Map<String, Object> map);

	/**
	 * 
	 * 描述: 统计
	 * 
	 * @auther ljx
	 * @date 2016年10月21日
	 * @return
	 */
	int selectCountOtherLicenceDistinct(Map<String, Object> map);

	/**
	 * 
	 * 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年10月21日
	 * @return
	 */
	int selectCountPermitDistinct(Map<String, Object> map);

	/**
	 * 描述: 获取行政许可信息列表数据（公示）
	 * 
	 * @auther ZhouYan
	 * @date 2016年11月7日
	 * @param params
	 * @return
	 */
	List<PubOtherlicenceDto> selectPubOtherlicenceForPub(Map<String, Object> params);

	List<PubOtherlicence> selectOtherlicencesList(Map<String, Object> qryMap);

	/**
	 * 描述：根据pripid查询经营许可信息
	 * 
	 * @param map
	 * @return
	 */
	List<PubOtherlicenceDto> selectOtherlicenceListByPriPID(Map<String, Object> map);

	/**
	 * 描述：食品许可到期
	 * 
	 * @author baifangfang
	 * @date 2017年10月11日
	 * @param qryMap
	 * @return
	 */
	int foodExpireNum(Map<String, Object> qryMap);

	/**
	 * 描述：药品许可到期
	 * 
	 * @author baifangfang
	 * @date 2017年10月11日
	 * @param qryMap
	 * @return
	 */
	int drugsExpireNum(Map<String, Object> qryMap);

	/**
	 * 描述：许可证失效到期管理json数据
	 * 
	 * @author baifangfang
	 * @date 2017年11月15日
	 * @param params
	 * @return
	 */
	List<PubOtherlicenceDto> selectLicenceInvalidMgrJSON(Map<String, Object> params);

	/**
	 * 描述：许可证失效到期管理数据统计
	 * 
	 * @author baifangfang
	 * @date 2017年11月17日
	 * @param params
	 * @return
	 */
	LicenceInvalidCount selectLicenceInvalidCount(Map<String, Object> params);

}