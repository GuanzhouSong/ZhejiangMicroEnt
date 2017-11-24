/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.copysend.service.impl;

import com.icinfo.cs.copysend.dto.CopySendDto;
import com.icinfo.cs.copysend.mapper.CopySendMapper;
import com.icinfo.cs.copysend.model.CopySend;
import com.icinfo.cs.copysend.service.ICopySendService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.mapper.SysDepartMapper;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_copy_send 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月21日
 */
@Service("copySendService")
public class CopySendServiceImpl extends MyBatisServiceSupport implements ICopySendService {
	@Autowired
	private CopySendMapper copySendMapper;
	@Autowired
	private SysDepartMapper sysDepartMapper;
	
	/**
     * 描述:抄告抄送的分页
     *
     * @param copysend
     * @throws Exception
     * @auther chenyu
     * @date 2016年10月24日
     */
	@Override
	public List<CopySendDto> queryPage(PageRequest request,SysUserDto sysUser) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> qryMap = request.getParams();
		List<CopySendDto> list = null; 
		if("1".equals(sysUser.getUserType())){//警示
			list = copySendMapper.selectJSSend(qryMap); 
		}
		if("2".equals(sysUser.getUserType())){//2协同
			list = copySendMapper.selectXTSend(qryMap);
		}
		
		return list;
	}
	
	/**
     * 描述:抄送的分页
     *
     * @param copysend
     * @throws Exception
     * @auther chenyu
     * @date 2016年10月24日
     */
	@Override
	public
	List<CopySendDto> doGetAcceptListJSON(PageRequest request,SysUserDto sysUser) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return copySendMapper.selectAllAccept(request.getParams());
	}
	/**
     * 描述:获取抄告状态分类的map
     *
     * @param copysend
     * @throws Exception
     * @auther chenyu
     * @date 2016年10月24日
     */
	@Override
	public Map<String, Object> getParams(Map<String, Object> qryMap) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> maps = new HashMap<String, Object>();
		int total = copySendMapper.selectTotal(qryMap);
		int dshNum = copySendMapper.selectDaiShenHeNum(qryMap);
		int shthNum = copySendMapper.selectSHTHNum(qryMap);
		int ycgfkzNum = copySendMapper.selectYCGFGZNum(qryMap);
		int ycgfkwcNum = copySendMapper.selectYCGFGZSuccessNum(qryMap);
		int qxcgNum = copySendMapper.selectCancelCGNum(qryMap);
		int cgwc = copySendMapper.selectCGSuccessNum(qryMap);
		int dfkNum = copySendMapper.selectDFKNum(qryMap);
		int yfkNum = copySendMapper.selectYFKNum(qryMap);
		int acceptTotal = copySendMapper.selectAcceptTotal(qryMap);
		maps.put("total", total);
		maps.put("dshNum", dshNum);
		maps.put("shthNum", shthNum);
		maps.put("ycgfkzNum", ycgfkzNum);
		maps.put("ycgfkwcNum", ycgfkwcNum);
		maps.put("qxcgNum", qxcgNum);
		maps.put("cgwc", cgwc);
		maps.put("dfkNum", dfkNum);
		maps.put("yfkNum", yfkNum);
		maps.put("acceptTotal", acceptTotal);
		//System.out.println("========="+dfkNum+"=========="+yfkNum);
		return maps;
	}
	
	/**
     * 描述:添加抄告抄送数据
     *
     * @param copysend
     * @throws Exception
     * @auther ylr
     * @date 2016年10月24日
     */
	public Integer insert(CopySendDto copySend) throws Exception{
		return copySendMapper.insert(copySend);
	}
	
	/**
     * 描述:根据批次号获取抄告抄送数据
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月28日
     */
	public CopySendDto selectCopySend(Map<String, Object> qryMap) throws Exception{
		List<CopySendDto> copySendList = copySendMapper.selectAllSend(qryMap);
		if(copySendList.size()>0)
			return copySendList.get(0);
		return null;
	}
	
	/**
     * 描述:更新添加抄告抄送数据
     *
     * @param copysend
     * @throws Exception
     * @auther ylr
     * @date 2016年10月28日
     */
	public Integer update(CopySendDto copySend) throws Exception{
		Example example = new Example(CopySend.class);
        example.createCriteria().andEqualTo("copyFormNo", copySend.getCopyFormNo());
		return copySendMapper.updateByExampleSelective(copySend, example);
	}
	
	/**
     * 描述:获取本部门抄告抄送最大抄送编号
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年11月22日
     */
	public CopySendDto getMaxCopyFormNo(Map<String, Object> qryMap) throws Exception{
		return copySendMapper.selectMaxCopyFormNo(qryMap);
	}
}