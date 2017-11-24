/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.copysend.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.copysend.dto.CopySendDto;
import com.icinfo.cs.copysend.model.CopySend;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_copy_send 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月21日
 */
public interface ICopySendService extends BaseService {
	/**
     * 描述:抄告的分页
     *
     * @param copysend
     * @throws Exception
     * @auther chenyu
     * @date 2016年10月24日
     */
	List<CopySendDto> queryPage(PageRequest request,SysUserDto sysUser) throws Exception;
	
	/**
     * 描述:抄送的分页
     *
     * @param copysend
     * @throws Exception
     * @auther chenyu
     * @date 2016年10月24日
     */
	List<CopySendDto> doGetAcceptListJSON(PageRequest request,SysUserDto sysUser) throws Exception;
	
	
	/**
     * 描述:获取抄告状态分类的map
     *
     * @param copysend
     * @throws Exception
     * @auther chenyu
     * @date 2016年10月24日
     */
	Map<String, Object> getParams(Map<String, Object> qryMap) throws Exception;

	/**
     * 描述:添加抄告抄送数据
     *
     * @param copysend
     * @throws Exception
     * @auther ylr
     * @date 2016年10月24日
     */
	Integer insert(CopySendDto copySend) throws Exception;
	/**
     * 描述:根据批次号获取抄告抄送数据
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月28日
     */
	CopySendDto selectCopySend(Map<String, Object> qryMap) throws Exception;
	
	/**
     * 描述:更新添加抄告抄送数据
     *
     * @param copysend
     * @throws Exception
     * @auther ylr
     * @date 2016年10月28日
     */
	Integer update(CopySendDto copySend) throws Exception;
	/**
     * 描述:获取本部门抄告抄送最大抄送编号
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年11月22日
     */
	CopySendDto getMaxCopyFormNo(Map<String, Object> qryMap) throws Exception;
	
	
}