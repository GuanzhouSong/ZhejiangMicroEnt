/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import com.icinfo.cs.sment.dto.SmEntAbovescaleDto;
import com.icinfo.cs.sment.model.SmEntAbovescale;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    sm-ent-abovescale 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年07月20日
 */
public interface ISmEntAbovescaleService extends BaseService {
	
	/**
	 * 
	 * 描述: 查询当前库中最大批次
	 * @auther gaojinling
	 * @date 2017年7月20日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer selectImBatchNum() throws Exception;
	
	/**
	 * 
	 * 描述: excel导入
	 * @auther gaojinling
	 * @date 2017年7月20日 
	 * @param file
	 * @param sysUser
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
    public Map<String, Object> excelImport(MultipartFile file,SysUserDto sysUser,String year) throws Exception;
    
	/**
	 * 
	 * 描述 : 查询规上企业（分页）
	 * @auther gaojinling
	 * @date 2017年7月21日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SmEntAbovescaleDto> selectSmEntAbovescale(PageRequest request) throws Exception;
	
	
	/**
	 * 
	 * 描述:修改
	 * @auther gaojinling
	 * @date 2017年7月21日 
	 * @param smEntAbovescaleDto
	 * @return
	 * @throws Exception
	 */
	public int update(SmEntAbovescaleDto smEntAbovescaleDto) throws Exception;
	
	
	/**
	 * 
	 * 描述: 根据uid查询单个
	 * @auther gaojinling
	 * @date 2017年7月21日 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public SmEntAbovescale selectone(String uid) throws Exception;
	
	/**
	 * 
	 * 描述: 限上规上企业成长轨迹
	 * @auther gaojinling
	 * @date 2017年8月16日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<SmEntAbovescaleDto> smEntAbovescaleCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 限上归上企业总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer smEntAbovescaleTotal(Map<String, Object> map) throws Exception;
	/**
	 * 
	 * 描述: 动产抵押总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer mortRegInfoTotal(Map<String, Object> map) throws Exception;

	/**
	 * 
	 * 描述: 国家局商标总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer tmDetailInfoTotal(Map<String, Object> map) throws Exception;
	
}