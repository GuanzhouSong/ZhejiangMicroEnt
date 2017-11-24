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

import com.icinfo.cs.sccheck.dto.PubScentDto;
import com.icinfo.cs.sccheck.model.PubScent;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_scent 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface PubScentMapper extends Mapper<PubScent> {
	
	/**
	 * 
	 * 描述: 查询当前部门任务下已抽取企业列表 
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param params
	 * @return
	 */
	public List<PubScentDto> selectPubScentDtoList(Map<String, Object> params);
	
	/**
	 * 描述：统计某个专项库的登记机关
	 * @author chenxin
	 * @date 2017-05-17
	 * @param in
	 * @param taskUid
	 * @throws Exception
	 */
	public List<String> selectRegOrgsInSpecial(Map<String, Object> params)throws Exception;
	
	/**
	 * 描述: 查询抽检结果中的某个专项库的登记机关数量
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	public List<PubScentDto> selectRegOrgNumInSpecial(Map<String,Object> params) throws Exception;
	
	/**
	 * 描述: 查询抽检结果中的某个专项库的抽查机关数量
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	public List<PubScentDto> selectCheckNumInSpecial(Map<String,Object> params) throws Exception;
	
	/**
	 * 描述：统计某个专项库的管辖单位
	 * @author chenxin
	 * @date 2017-05-17
	 * @param in
	 * @param taskUid
	 * @throws Exception
	 */
	public List<PubScentDto> selectUidsNotInSpecial(Map<String, Object> params)throws Exception;
	
	/**
	 * 描述：查询各个地市抽取的比例
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @return
	 * @throws Exception
	 */
	public List<PubScentDto> selectPubSentDtoListBytaskUId(String taskUid)throws Exception;
	
	/**
	 * 
	 * 描述: 通过查询已抽取的企业进行滚动
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	public List<PubScent> selectPubSentListBytaskUId(String taskUid)throws Exception;

	/**
	 * 描述: 查询抽中企业的企业类型
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	public List<String> selectEntTypeCatg(String taskUid);
	
	/**
	 * 描述: 查询抽中企业的企业类型
	 * @auther chenxin
	 * @date 2017年8月25日
	 * @param deptTaskUid
	 * @return
	 */
	public List<PubScentDto> selectPubScentAllList(String deptTaskUid);
	
	/**
	 * 描述: 查询抽中企业的企业类型
	 * @auther chenxin
	 * @date 2017年8月25日
	 * @param deptTaskUid
	 * @return
	 */
	public List<PubScentDto> selectPubScentPageList(String deptTaskUid);

	/**
	 * 描述：任务指派列表
	 *
	 * @author chenxin
	 * @date 2017年7月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScentDto> selectAppointEntList(Map<String, Object> params);

	/**
	 * 描述：查询已抽取企业列表
	 *
	 * @author chenxin
	 * @date 2017年7月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScentDto> selectRandomEntList(Map<String, Object> params);

	/**
	 * 描述：统计一次任务所有企业所属的状态
	 * @author chenxin
	 * @date 22017-07-22
	 * @param taskUid
	 * @return
	 */
	public PubScentDto selectEntCountByTaskUid(String taskUid);
    
	/**
	 * 描述：通过任务UID查询个数
	 * @author yujingwei
	 * @date 2017-07-22
	 * @param taskUid
	 * @return Integer
	 */
	public Integer selectPubScentDtoTotal(Map<String, Object> params);
	
	/**
	 * 
	 * 描述   业务查询微信接口
	 * @author 赵祥江
	 * @date 2017年8月9日 上午11:45:09 
	 * @param 
	 * @return List<PubScentDto>
	 * @throws
	 */
	public List<PubScentDto> selectSccheckeEntList(Map<String, Object> params)throws Exception;
	
	/**
	 * 
	 * 描述  业务查询  查询总条数
	 * @author 赵祥江
	 * @date 2017年8月9日 下午2:44:54 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer selectSccheckeEntCount(Map<String, Object> params)throws Exception;
	
	
	
	/**
	 * 
	 * 描述   微信消息推送接口
	 * @author 赵祥江
	 * @date 2017年8月9日 上午11:45:09 
	 * @param 
	 * @return List<PubScentDto>
	 * @throws
	 */
	public List<PubScentDto> selectSccheckeMsgEntList(Map<String, Object> params)throws Exception;
	
	/**
	 * 
	 * 描述   查询微信推送总条数
	 * @author 赵祥江
	 * @date 2017年8月9日 下午2:44:54 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer selectSccheckeMsgCount(Map<String, Object> params)throws Exception;

	/**
	 * 
	 * 描述: 通过任务id查询已抽取的企业各地市数量
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	public List<PubScentDto> selectBytaskUIdAndRegOrg(String taskUid);
}