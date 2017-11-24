/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月21日
 * @version 2.0
 */
package com.icinfo.cs.copysend.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.copysend.dto.CopySendDto;
import com.icinfo.cs.copysend.model.CopySend;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_copy_send 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月21日
 */
public interface CopySendMapper extends Mapper<CopySend> {
	public List<CopySendDto> selectAllSend(Map<String, Object> map);
	
	public List<CopySendDto> selectJSSend(Map<String, Object> map);
	
	public List<CopySendDto> selectXTSend(Map<String, Object> map);
	
	
	public List<CopySendDto> selectAllAccept(Map<String, Object> map);
	
	public String getDepartment(String departCode);
	
	
	public int selectTotal(Map<String, Object> map);
	
	public int selectDaiShenHeNum(Map<String, Object> map);
	
	public int selectSHTHNum(Map<String, Object> map);
	
	public int selectYCGFGZNum(Map<String, Object> map);
	
	public int selectYCGFGZSuccessNum(Map<String, Object> map);
	
	public int selectCancelCGNum(Map<String, Object> map);
	
	public int selectCGSuccessNum(Map<String, Object> map);
	
	public int selectDFKNum(Map<String, Object> map);
	
	public int selectYFKNum(Map<String, Object> map);
	
	public int selectAcceptTotal(Map<String, Object> map);
	
	public CopySendDto selectMaxCopyFormNo(Map<String, Object> qryMap);
}