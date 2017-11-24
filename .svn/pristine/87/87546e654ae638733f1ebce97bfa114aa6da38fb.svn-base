package com.icinfo.cs.nocreditPunish.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishInfoDto;
import com.icinfo.cs.nocreditPunish.mapper.NoCreditPunishDetailMapper;
import com.icinfo.cs.nocreditPunish.mapper.NoCreditPunishInfoMapper;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishDetail;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishInfo;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * cs_nocredit_punishinfo 对应的Mapper接口实现类.<br>
 * @author caoxu
 * @date 2016年10月18日
 */
@Service
public class NoCreditPunishInfoServiceImpl extends MyBatisServiceSupport implements NoCreditPunishInfoService {
	
	@Autowired
	private NoCreditPunishInfoMapper noCreditPunishInfoMapper;
	
	@Autowired
	private NoCreditPunishDetailMapper noCreditPunishDetailMapper;
	
	@Autowired
	private  HttpServletRequest request;
	
	/**
     * 查询列表带分页
     *
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public List<NoCreditPunishInfo> queryPage(PageRequest request, Map<String, Object> parms) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(NoCreditPunishInfo.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (parms != null) {
			for (Map.Entry<String, Object> entry : parms.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		return noCreditPunishInfoMapper.selectByExample(example);
	}
	
	/**
	 * 查询列表（不带分页）
	 * @param parms
	 * @return
	 */
	@Override
	public List<NoCreditPunishInfo> queryList(Map<String, Object> parms) throws Exception {
		Example example = new Example(NoCreditPunishInfo.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (parms != null) {
			for (Map.Entry<String, Object> entry : parms.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		List<NoCreditPunishInfo> list = noCreditPunishInfoMapper.selectByExample(example);
		return list;
	}
	
	/**
     * 保存惩戒单
     * @param rule
     * @return
     * @throws Exception
     */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insert(NoCreditPunishInfo noCreditPunishInfo) throws Exception {
		noCreditPunishInfo.setCreateTime(new Date());
		noCreditPunishInfo.setState(0);
		return this.noCreditPunishInfoMapper.insert(noCreditPunishInfo);
	}
	
	/**
	 * 根据企业名称获取信息
	 * @param entName
	 * @return
	 */
	@Override
	public NoCreditPunishDetail selectEnt(String entName) throws Exception {
		List<NoCreditPunishDetail> details = noCreditPunishDetailMapper.selectEnt(entName);
		if (details != null && details.size() > 0) {
			return details.get(0);
		}
		return null;
	}
	
	/**
	 * 根据证件号获取自然人信息
	 * @param keyword
	 * @return
	 */
	@Override
	public NoCreditPunishDetail selectMan(String keyword) throws Exception {
		List<NoCreditPunishDetail> details = noCreditPunishDetailMapper.selectMan(keyword);
		if (details != null && details.size() > 0) {
			return details.get(0);
		}
		return null;
	}
	
	/**
	 * 获取需要反馈的戒单列表（企业、自然人）
	 * @return
	 */
	@Override
	public List<NoCreditPunishInfoDto> selectAuditedInfoPage(PageRequest request, Map<String, Object> parms) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return this.noCreditPunishInfoMapper.selectAuditedInfoList(parms);
	}
	
	/**
	 * 获取所有的戒单列表（企业、自然人）
	 * @return
	 */
	@Override
	public List<NoCreditPunishInfoDto> selectAllInfoList(PageRequest request, Map<String, Object> parms) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return this.noCreditPunishInfoMapper.selectAllInfoList(parms);
	}
	
	/**
	 * 查询惩戒全信息列表
	 * @return
	 */
	@Override
	public List<NoCreditPunishInfoDto> selectAllFullInfoList(PageRequest request, Map<String, Object> parms) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return this.noCreditPunishInfoMapper.selectAllFullInfoList(parms);
	}
	
	/**
	 * 查询惩戒全信息列表统计
	 * @return
	 */
	public Integer getAllFullInfoTotal(Map<String, Object> qryMap) throws Exception{
		List<NoCreditPunishInfoDto> list = noCreditPunishInfoMapper.selectAllFullInfoList(qryMap);
		return list==null?0:list.size();
	}

	@Override
	public String searchlistJSON_downednum(Map<String, Object> param) {
		NoCreditPunishInfoDto noCreditPunishInfo = this.noCreditPunishInfoMapper.searchlistJSON_downednum(param);
		if(noCreditPunishInfo!=null)
			return noCreditPunishInfo.getDownState()==null?"0":noCreditPunishInfo.getDownState();
		return "0";
	}

	/**
	 * 查询单个单据
	 * @param parms
	 * @return
	 */
	@Override
	public NoCreditPunishInfo getInfo(String batchNo) throws Exception {
		NoCreditPunishInfo noCreditPunishInfo=new NoCreditPunishInfo();
		noCreditPunishInfo.setBatchNo(batchNo);
		List<NoCreditPunishInfo> infos =noCreditPunishInfoMapper.select(noCreditPunishInfo);
		if (infos != null && infos.size() > 0) {
			return infos.get(0);
		} else
			return null;
	}
	
	/**
	 * 更新惩戒单主信息
	 * @param noCreditPunishInfo
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int update(NoCreditPunishInfo noCreditPunishInfo) throws Exception {
		Example example = new Example(NoCreditPunishInfo.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("batchNo", noCreditPunishInfo.getBatchNo());
		return this.noCreditPunishInfoMapper.updateByExampleSelective(noCreditPunishInfo, example);
	}
	
	/**
	 * 获取当前用户
	 * @return
	 */
	@Override
	public SysUserDto getCurrUser() throws Exception {
		SysUserDto user = (SysUserDto) request.getSession().getAttribute(Constants.SESSION_SYS_USER);
		return user;
	}

	/**
	 * 根据企业id获取信息
	 * @author chenyu
	 * @param entName
	 * @return
	 */
	@Override
	public List<NoCreditPunishInfo> selectInfoListByPriPID(PageRequest request) {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return this.noCreditPunishInfoMapper.selectInfoListByPriPID(request.getParams());
	}

	/**
	 * 根据个人cerNO获取信息
	 * * @author chenyu
	 * @param entName
	 * @return
	 */
	@Override
	public List<NoCreditPunishInfo> selectInfoListByCerNO(PageRequest request) {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return noCreditPunishInfoMapper.selectInfoListByCerNO(request.getParams());
	}
	
	/**
	 * 保存惩戒单明细
	 * @param array
	 * @param noCreditPunishInfoDto
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertDetail(JSONArray array, NoCreditPunishInfoDto noCreditPunishInfoDto) {
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			NoCreditPunishDetail detail = new NoCreditPunishDetail();
			if (noCreditPunishInfoDto.getPunType().equals("ent")) {
				detail.setPriPID(object.getString("priPID"));
				detail.setRegNo(object.getString("regNo"));
				detail.setEntName(valueConver(object.getString("entName")));
				detail.setUniCode(valueConver(object.getString("uniCode")));
				detail.setLeRep(valueConver(object.getString("leRep")));
			} else if (noCreditPunishInfoDto.getPunType().equals("man")) {
				detail.setLitiName(valueConver(object.getString("litiName")));
				detail.setPhone(valueConver(object.getString("phone")));
				detail.setEntName(detail.getLitiName());
			}
			//惩戒记录条数
			String recordCount= object.getString("recordCount");
			if(StringUtil.isBlank(recordCount)||"0".equals(recordCount)){
				recordCount="0";
				detail.setRecord("无");
			}else{
				detail.setRecord("有");
			} 
			detail.setCerType(valueConver(object.getString("cerType")));
			detail.setCardNo(valueConver(object.getString("cardNo"))); 
			detail.setBatchNo(noCreditPunishInfoDto.getBatchNo());
			detail.setRecordCount(recordCount);
			if (noCreditPunishDetailMapper.insert(detail) < 0) {
				break;
			}
		}
	}

	private String valueConver(String value) {
		if (value == null || value.equals("")) {
			return null;
		}
		return value;
	}

	@Override
	public List<NoCreditPunishDetail> selectNoCreditPunishDetailListByCerNO(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return noCreditPunishDetailMapper.selectListByCerNO(request.getParams());
	}

	/**
	 * 
	 * 描述   获取列表
	 * @author  赵祥江
	 * @date 2017年8月27日 下午12:19:49 
	 * @param  
	 * @throws
	 */
	@Override
	public List<NoCreditPunishInfoDto> selectAllInfoJsonList(
			PageRequest request, Map<String, Object> parms) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return this.noCreditPunishInfoMapper.selectAllInfoJsonList(parms);
	}

	/**
	 * 
	 * 描述   删除
	 * @author  赵祥江
	 * @date 2017年8月27日 下午2:17:32 
	 * @param  
	 * @throws
	 */
	@Override
	public int deleteNoCreditPunishInfoByBatchNo(String batchNo)
			throws Exception {
		NoCreditPunishInfo noCreditPunishInfo=new NoCreditPunishInfo();
		noCreditPunishInfo.setBatchNo(batchNo); 
		return noCreditPunishInfoMapper.delete(noCreditPunishInfo);
	} 
	
	 /** 
     * 描述:获取失信联合惩戒信息（公示企业展示）
     * @author yujingwei
     * @date 2017年08月25日 
     * @param parms
     * @return List<NoCreditPunishInfoDto>
     */
	public List<NoCreditPunishInfoDto> selectNoCreditPunishinfo(Map<String, Object> parms){
		return noCreditPunishInfoMapper.selectAllFullInfoList(parms);
	}
	
}
