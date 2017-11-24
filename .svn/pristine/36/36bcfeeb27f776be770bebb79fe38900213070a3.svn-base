package com.icinfo.cs.es.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.es.dto.PubEntSearchDto;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;

import cn.gov.zj.gsj.v2.sys.ApiException;

/**
 * 
 * @author bff
 * @date 2016-7-18
 *
 */
public interface IEntSearchService {

	/**
	 * 描述：公示企业综合查询
	 * 
	 * @author
	 * @date 2016年8月30日
	 * @param searchKeyWord
	 * @param currentPage
	 * @return
	 */
	Map<String, Object> doGetAppSearchResult(String searchKeyWord, int currentPage, String isOpanomaly);

	/**
	 * 描述：根据文档id查询企业详情信息
	 * 
	 * @author baifangfang
	 * @date 2016年9月9日
	 * @param docId
	 * @return
	 */
	PubEntSearchDto selectByDocId(String docId);

	/**
	 * 根据Pripid来查询企业详情信息
	 * 
	 * @author zjj
	 */
	MidBaseInfoDto selectByPripid(String priPID);

	/**
	 * 描述：向云服务器导数据根据id范围
	 * 
	 * @author baifangfang
	 * @date 2016年11月15日
	 */
	void doInsertPubDataToGsById();

	/**
	 * 索引数据增量更新
	 */
	void doInsertIncreToGs();

	/**
	 * 更新公示索引(主要针对异常名录信息的更新)
	 * 
	 * @author baifangfang
	 * @date 2016年12月5日
	 * @param jsonMap
	 *            需要更新的内容
	 */
	public String updatePubIndex(Map<String, Object> jsonMap);

	/**
	 * 描述：向云服务器导入单条数据
	 * 
	 * @author baifangfang
	 * @date 2016年12月10日
	 * @param condition
	 */
	Boolean doInsertPubSingleDataToGs(String condition);

	/**
	 * 描述：根据核准日期向云服务器导入数据
	 * 
	 * @author baifangfang
	 * @date 2016年12月16日
	 * @param condition
	 */
	Boolean doInsertPubDataToGsByApprDate(String apprDate);

	/**
	 * 描述：根据内部序号企业详情信息
	 * 
	 * @author baifangfang
	 * @date 2016年12月19日
	 * @param docId
	 * @return
	 */
	PubEntSearchDto selectByPriPID(String priPID);

	/**
	 * 描述：向云服务器导入全量数据根据id范围(使用多线程的方式)
	 * 
	 * @author baifangfang
	 * @date 2017年1月3日
	 * @return
	 * @throws Exception
	 */
	void doInsertPubDataToGsByIdUseThreadPool();

	/**
	 * 描述：根据内部序号删除索引
	 * 
	 * @author baifangfang
	 * @date 2017年2月8日
	 * @return
	 * @throws Exception
	 */
	Boolean deleteEntByPriPID(String priPID) throws ApiException;

	/**
	 * 描述：更新历史名称
	 * 
	 * @author baifangfang
	 * @date 2017年11月2日
	 */
	void updateHisEntName();

	/**
	 * 
	 * 描述：日常检查结果选入企业
	 * 
	 * @author baifangfang
	 * @date 2017年11月3日
	 * @param searchKeyWord
	 * @return
	 */
	List<PubEntSearchDto> queryEntList(String searchKeyWord);

}
