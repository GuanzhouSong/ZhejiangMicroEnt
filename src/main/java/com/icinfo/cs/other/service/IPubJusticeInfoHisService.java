/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service;

import com.icinfo.cs.other.model.PubJusticeInfoHis;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_pub_justiceinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public interface IPubJusticeInfoHisService extends BaseService {
     
	/**
	 * 描述: 获取司法协助历史记录信息
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param  pripid，modUID，hisNO
	 * @return PubJusticeInfoHis
	 * @throws Exception
	 */
	public PubJusticeInfoHis doGetPubJusticeInfoHis(String pripid, String modUID,
			String hisNO) throws Exception;
}