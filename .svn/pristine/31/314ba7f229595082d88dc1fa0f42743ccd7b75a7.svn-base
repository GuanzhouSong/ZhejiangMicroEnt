/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月17日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubScagentDto;
import com.icinfo.cs.sccheck.dto.PubScentResultDto;
import com.icinfo.cs.sccheck.dto.SccheckCount;
import com.icinfo.cs.sccheck.model.PubScentResult;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_pub_scent_result 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface PubScentResultMapper extends Mapper<PubScentResult> {

	/**
	 * 描述：抽查检查结果列表
	 * 
	 * @author baifangfang
	 * @date 2017年5月17日
	 * @param params
	 * @return
	 */
	List<PubScentResultDto> queryPageResult(Map<String, Object> params); 
	

	/**
	 * 描述：抽查查询结果统计
	 * 
	 * @author baifangfang
	 * @date 2017年5月17日
	 * @param params
	 * @return
	 */
	SccheckCount querySccheckCount(Map<String, Object> params);
	
	/**
	 * 描述：抽查查询结果统计
	 * 
	 * @author baifangfang
	 * @date 2017年5月17日
	 * @param params
	 * @return
	 */
	SccheckCount querySccheckSearchCount(Map<String, Object> params);

	/**
	 * 描述：根据任务序号查询抽查检查结果信息
	 * 
	 * @author baifangfang
	 * @date 2017年5月18日
	 * @param params
	 * @return
	 */
	PubScentResultDto selectPubScentResultDtoByTaskUidAndPriPID(Map<String, Object> params);

	/**
	 * 描述：公示系统查询抽查检查结果信息
	 * 
	 * @author baifangfang
	 * @date 2017年6月2日
	 * @param params
	 * @return
	 */
	List<PubScentResultDto> queryPageResultByPriPID(Map<String, Object> params);

	/**
	 * 描述：根据任务序号查询抽查检查结果信息
	 * 
	 * @author baifangfang
	 * @date 2017年6月2日
	 * @param params
	 * @return
	 */
	PubScentResultDto selectPubScentResultDtoByUid(Map<String, Object> params);

	/**
	 * 描述：综合抽查实施准备列表JSON数据列表
	 * 
	 * @author baifangfang
	 * @date 2017年6月12日
	 * @param params
	 * @return
	 */
	List<PubScentResultDto> queryPreParePageResult(Map<String, Object> params);

	/**
	 * 
	 * 描述: 综合抽查结果统计
	 * @auther chenxin
	 * @date 2017年6月26日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<PubScentResultDto> selectScentResultCount(Map<String, Object> parmMap);
	
	/**
	 * 
	 * 描述: 抽查工作情况统计
	 * @auther chenxin
	 * @date 2017年6月26日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<PubScentResultDto> selectCheckWorkCount(Map<String, Object> parmMap);

	/**
	 * 描述：抽查检查数据列表
	 * 
	 * @author chenxin
	 * @date 2017年6月28日
	 * @param request
	 * @return
	 */
	List<PubScentResultDto> queryPageSearchResult(Map<String, Object> params);
    
	/**
	 * 描述：通过结果表uid查询agentid
	 * 
	 * @author yujingwei
	 * @date 2017年6月28日
	 * @param request
	 * @return
	 */
	List<PubScentResultDto> doGetAgentIdByResultuid(String resultUids);
	
	/**
	 * 描述：调整之后，执法人员、组长和专家赋空值
	 * 
	 * @author chenxin
	 * @date 2017年6月28日
	 * @param request
	 * @return
	 */
	void doUpdateDefaultNull(Map<String,Object> params);
    
	/**
	 * 描述：通过主任务uid查询检查结果
	 * 
	 * @author yujingwei
	 * @date 2017年10月12日
	 * @param request
	 * @return List
	 */
	List<PubScentResultDto> selectPubScentResultDtoByMainUid(Map<String, Object> params);

	public Integer selectPubScentResultTotalByUid(Map<String, Object> params) throws Exception;	
	
	/**
	 * 
	 * 描述   获取企业检查结果包括查无下落的最大检查日期
	 * @author 赵祥江
	 * @date 2017年11月6日 下午4:13:55 
	 * @param 
	 * @return List<PubScentResultDto>
	 * @throws
	 */
	public PubScentResultDto selectMaxCheckDateScentResultByPriPID(Map<String, Object> params) throws Exception;
	
	
	/**
	 * 
	 * 描述:可视化综合抽查结果统计
	 * @auther gaojinling
	 * @date 2017年11月8日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<PubScentResultDto> selectScentResultChartCount(Map<String, Object> map) throws Exception;

	/**
	 * 描述：查看是否本次任务涉及的所有企业都已经录入结果并且公示(跳过执法人员抽取抽取步骤)
	 * 
	 * @author chenxin
	 * @date 2017年5月27日
	 * @param deptTaskUid
	 * @return
	 */
	public int selectCountNotFinishNum(String deptTaskUid);
}