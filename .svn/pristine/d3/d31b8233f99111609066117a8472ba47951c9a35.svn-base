/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dtinfo.service;

import java.io.InputStream;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.cs.dtinfo.model.HzDtinfoHis;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_pub_hzdtinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月20日
 */
public interface IHzDtinfoHisService extends BaseService {
    
	/**
     * 描述：excel批量导入
     * @author yujingwei
	 * @param districtType 
     * @date 2017年06月20日 
     * @throws Exception
     */
	public Map<String, Object> doSavePubDtInfoExcelBatch(InputStream in, String districtType) throws Exception;

	/**
	 * 描述   杭州，诸暨双告知接口
	 * @author yujingwei
	 * @date 2017年06月20日 
	 * @param token，districtType 01 杭州 02 诸暨 ，args,stateType 03 标识 认领  04 标识退回
	 * @return JSONObject
	 * @throws Exception
	 */
	public JSONObject doWorkPubDtInfoForHzzj(String token, String districtType,String args,boolean isInterfaceData,String stateType) throws Exception;
    
	/**
	 * 描述   插入杭州，诸暨双告知历史表信息
	 * @author yujingwei
	 * @date 2017年06月20日 
	 * @param insertOrUpdateInfo
	 * @return int
	 * @throws Exception
	 */
	public int insertHzzjDtInfo(HzDtinfoHis insertOrUpdateInfo) throws Exception;
    
	/**
	 * 描述   json键值处理
	 * @author yujingwei
	 * @date 2017年06月20日 
	 * @param insertOrUpdateInfo，jsonObjDtInfo
	 * @return HzDtinfoHis
	 * @throws Exception
	 */
	public HzDtinfoHis doOptKeyOrValueHandle(HzDtinfoHis insertOrUpdateInfo,JSONObject jsonObjDtInfo) throws Exception;
}