/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import java.util.List;

import com.icinfo.cs.base.dto.SelectCodeAddress;
import com.icinfo.cs.base.model.CodeAddress;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_code_address 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年01月20日
 */
public interface ICodeAddressService extends BaseService {

    /**
     * 获取编码数据
     * @return
     */
    SelectCodeAddress selectBycodeAddress();
    
    /**
     * 
     * 描述: 递归查询市县区（单个市下）
     * @auther gaojinling
     * @date 2017年3月10日 
     * @param selectCodeAddress
     * @param supCode
     * @return
     */
    public SelectCodeAddress setSubCode(SelectCodeAddress selectCodeAddress, String supCode) ;
    
    /**
     * 
     * 描述: 根据编码查询单个
     * @auther gaojinling
     * @date 2017年3月10日 
     * @param code
     * @return
     */
    public SelectCodeAddress selectByPriKey(String code);
     
    /**
	 * 描述：通过市编码获取区县
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param cityCode
	 * @throws Exception
	 */
    public List<CodeAddress> selectCountyListByCityCode(String cityCode) throws Exception;
    
    /**
	 * 描述：通过区县编码获取街道信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param countyCode
	 * @throws Exception
	 */
	public List<CodeAddress> selectCountyListByCountyCode(String countyCode) throws Exception;
}