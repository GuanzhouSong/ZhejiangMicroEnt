package com.icinfo.cs.es.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.model.PanoramaSearch;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 全景查询相关业务接口
 * 
 * @author zhuyong
 */
public interface IPanoramaSearchService {
	
	/**
	 * 获取全景查询返回结果
	 * 
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PanoramaResultDto> doGetSearchList(String keyword) throws Exception;
	
	/**
	 * 获取企业综合查询查询返回结果
	 * 
	 * @author bff
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Page<PanoramaResultDto> doGetComSearchList(PageRequest request) throws Exception;
	
	/**
	 * 获取全景查询返回结果-供分页框架使用
	 * 
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Page<PanoramaResultDto> doGetSearchList(PageRequest request) throws Exception;

	/**
	 * 抽检。。。。
	 * 
	 * @author zhuyong
	 * @param taskNO
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String doSearchForPubScinfoList(String taskNO,Map<String,Object> params) throws Exception;
	/**
	 * 往工商云平台索引插入数据
	 * 
	 * @author zhuyong 
	 * @throws Exception
	 */
	public void doInsertIndexToGs() throws Exception;
	
	/**
	 * 更新全景查询索引
	 * 
	 * @author zhuyong
	 * @param jsonMap 需要更新的内容
	 */
	public String updatePanoramaIdx(Map<String,Object> jsonMap);
	
	/**
	 * 获取查询返回结果
	 * 
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String doGetResponseStr(String keyword);
	
	/**
	 * 获取创建索引的增量数据
	 * 
	 * @author zhuyong
	 * @return
	 */
	public List<PanoramaSearch> queryIncDataForIdx(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取创建索引的增量数据
	 * 
	 * @author zhuyong
	 * @return
	 */
	public Integer queryIncDataTotalForIdx(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取单条全景实体
	 * 
	 * @author zhuyong
	 * @return
	 */
	public PanoramaSearch selectOnePanorama(String priPID) throws Exception;

	/**
	 * 获取多年度企业综合查询
	 * 
	 * @author baifangfang
	 * @return
	 * @throws Exception 
	 */
	public Page<PanoramaResultDto> doGetYearsComSearchList(PageRequest request) throws Exception;

	/**
	 * 获取发送短信企业列表
	 * 
	 * @author baifangfang
	 * @return
	 * @throws Exception 
	 */
	public Page<PanoramaResultDto> doGetSmsSearchList(PageRequest request) throws Exception;

	/**
	 * 获取发送短信企业列表(导出全部用)
	 * 
	 * @author baifangfang
	 * @return
	 * @throws Exception 
	 */
	public Page<PanoramaResultDto> doGetComSearchListAll(PageRequest request) throws Exception;

	/**
	 * 获取综合查询企业统计数量(导出全部用)
	 * 
	 * @author baifangfang
	 * @return
	 * @throws Exception 
	 */
	public Integer doGetComSearchListAllCount(PageRequest request) throws Exception;

	/**
	 * 描述：获取邮件发送企业列表(业务辅助管理-邮件管理)
	 * @author baifangfang
	 * @date 2017年11月14日
	 * @param request
	 * @return
	 */
	public Page<PanoramaResultDto> doGetEmailSearchList(PageRequest request) throws Exception;

}
