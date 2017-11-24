/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月20日
 * @version 2.0
 */
package com.icinfo.cs.other.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.other.dto.PubJusticeInfoDto;
import com.icinfo.cs.other.model.PubJusticeInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_justiceinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public interface PubJusticeInfoMapper extends Mapper<PubJusticeInfo> {

	List<PubJusticeInfoDto> selectPubJusticeInfoListByCerNO(Map<String, Object> params);
	
	List<PubJusticeInfo> selectPubJusticeInfoForApply(Map<String, Object> params);

	List<PubJusticeInfoDto> selectPubJusticeInfoForSearch(Map<String, Object> params);

	int selectTotalOneForSearch(Map<String, Object> params);

	int selectTotalTwoForSearch(Map<String, Object> params);

	int selectTotalAllForSearch(Map<String, Object> params);

	int selectTotalAmountForSearch(Map<String, Object> params);

	List<PubJusticeInfo> selectPubJusticeInfoForInclude(Map<String, Object> params);

	List<PubJusticeInfo> selectJusticeInfoForBulletin(Map<String, Object> params);

	List<PubJusticeInfo> selectJusticeinfoListForBulletin(String updateDate);

	List<PubJusticeInfo> selectFrozenStateInfo(String priPID);
}