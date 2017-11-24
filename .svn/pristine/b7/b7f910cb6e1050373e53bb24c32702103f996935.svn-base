/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月26日
 * @version 2.0
 */
package com.icinfo.cs.supervise.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.model.CsSuperviseObj;
import com.icinfo.framework.mybatis.mapper.common.Mapper;


/**
 * 描述:    cs_supervise_obj 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface CsSuperviseObjMapper extends Mapper<CsSuperviseObj> {
	
	/**
	 * 重点监管信息查询
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsSuperviseObjDto> selectCsSuperviseObjDtoList(Map<String,Object> map) throws Exception;
	
	/**
	 * 重点监管信息查询
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsSuperviseObjDto> selectByBatchNOList(Map<String,Object> map) throws Exception;
	
	/**
	 * 重点监管信息查看页面查询
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsSuperviseObjDto> selectCsSuperviseObjDtoForViewList(Map<String,Object> map) throws Exception;
	
	
	/**
	 * 获取一家企业重点监管情况
	 * 返回Map作为全景查询索引参数
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public String doGetSuperviewInfoForIndex(Map<String,Object> map) throws Exception;

	/**
	 * 描述：根据pripid获取有效的重点监管对象
	 * @author baifangfang
	 * @date 2017-04-19
	 * @param priPID
	 * @return
	 */
	public List<CsSuperviseObjDto> selectCsSuperviseObjDtoByPriPID(Map<String, Object> map);
}