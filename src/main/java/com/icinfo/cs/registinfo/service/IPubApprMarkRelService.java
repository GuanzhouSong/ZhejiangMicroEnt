/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service;

import java.util.List;

import com.icinfo.cs.registinfo.dto.PubApprMarkRelDto;
import com.icinfo.cs.registinfo.model.PubApprMarkRel;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_pub_appr_mark_rel 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年04月26日
 */
public interface IPubApprMarkRelService extends BaseService {
    
    /** 
     * 描述: 根据企业id删除对应信息
     * @author 张文男
     * @date 2017年4月26日 
     * @param priPID 
     */
    
    public void deleteInPriPID(String priPIDs);
    
    /** 
     * 描述: 根据企业id、标签code删除对应信息
     * @author 张文男
     * @date 2017年4月27日 
     * @param priPIDs
     * @param markCodes 
     */
    
    public void deleteBy(String priPIDs,String markCodes);
    
    /** 
     * 描述: 根据markcodes 删除对应数据
     * @author 张文男
     * @date 2017年4月27日 
     * @param markCode 
     */
    
    public void deleteByMarkCode(String markCode);
    
    
    /** 
     * 描述: 保存或更新
     * @author 张文男
     * @date 2017年4月27日 
     * @param priPIDs
     * @param list
     * @param isReverse 
     */
    
    public void saveOrUpdate(String priPIDs,List<RegistMark> list,boolean isReverse);
    
	/**
	 * 
	 * 描述: 查询单家企业所属的标签
	 * @auther gaojinling
	 * @date 2017年4月26日 
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public List<PubApprMarkRel> queryListByPripid(String priPID)throws Exception;
	
    /**
     * 
     * 描述: 根绝pripid查询企业所属标签(当前有效的标签)（分组化后）
     * @auther gaojinling
     * @date 2017年4月21日 
     * @param map
     * @return
     */
    public List<PubApprMarkRelDto> selectMainMarkRelDtoByPriPIDGroup(String priPID);
    
    /**
     * 
     * 描述: 获取当前企业所属标签及标签是否为专项库标签
     * @auther gaojinling
     * @date 2017年4月26日 
     * @param priPID
     * @return
     */
    public List<PubApprMarkRelDto> selectPubApprMarkRelDtoByPriPID(String priPID);
	
}