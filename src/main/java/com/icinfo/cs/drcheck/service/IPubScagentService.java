/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.cs.drcheck.dto.PubScagentDto;
import com.icinfo.cs.drcheck.model.PubScagent;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_scagent 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface IPubScagentService extends BaseService {
	List<PubScagent> selectAll()throws Exception ;
	/**
	 * 
	 * 描述:多条件查询for ListJSON
	 * @auther ljx
	 * @date 2016年10月31日 
	 * @param request
	 * @return
	 */
	List<PubScagentDto> selectByManyCationToListJSON(PageRequest request);
	/**
	 * 
	 * 描述: 查询单个by  id
	 * @auther ljx
	 * @date 2016年10月31日 
	 * @param id
	 * @return
	 */
	PubScagent selectById(String uid);
	
	/**
	 * 
	 * 描述:保存
	 * @auther ljx
	 * @date 2016年10月31日 
	 * @param pubScagent
	 * @return
	 */
	public int savePubScagent(PubScagent pubScagent) throws Exception;
	
	/**
	 * 
	 * 描述:保存
	 * @auther ljx
	 * @date 2016年10月31日 
	 * @param pubScagent
	 * @return
	 */
	public boolean savePubScagentNoRepeat(PubScagent pubScagent) throws Exception;

	/**
	 * 
	 * 描述:excel批量导入
	 * @auther chenxin
	 * @date 2017年02月23日 
	 * @param pubScagent
	 * @return
	 */
	public JSONObject saveExcelBatch(InputStream in,SysUserDto sysUser,String localAdm) throws Exception;
	
	/**
	 * 
	 * 描述: 更新操作
	 * @auther ljx
	 * @date 2016年10月31日 
	 * @param pubScagent
	 * @return
	 */
	int updatePubScagent(PubScagent pubScagent);
	/**
	 * 
	 * 描述:删除根据id
	 * @auther ljx
	 * @date 2016年10月31日 
	 * @param id
	 * @return
	 */
	int deletePubScagentById(String id);
	
	/**
	 * 描述: 获取执法清单范围树数据
	 * @auther chenxin
	 * @date 2017年4月21日
	 * @return List<Map<String, Object>>
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectScPtypeMap() throws Exception;
	
	/**
	 * 
	 * 描述: 执法人员统计
	 * @auther gaojinling
	 * @date 2017年6月1日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
    public List<PubScagentDto> selectScAgentCount(PageRequest request) throws Exception;
    
    
    /**
     * 
     * 描述: 执法人员统计
     * @auther gaojinling
     * @date 2017年6月1日 
     * @param request
     * @return
     * @throws Exception
     */
    public List<PubScagentDto> selectSynScAgentCount(PageRequest request) throws Exception;
    
    /**
	 * 
	 * 描述: 查询信息
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
    public PubScagentDto selectPubScagentDtoByUid(String uid) throws Exception;
    
    /**
	 * 
	 * 描述:excel批量导入(协同)
     * @param localAdmName 
	 * @auther chenxin
	 * @date 2017年02月23日 
	 * @param pubScagent
	 * @return
	 */
	public JSONObject saveExcelBatchSyn(InputStream in, SysUserDto sysUser,String localAdm, String localAdmName) throws Exception;
    
}