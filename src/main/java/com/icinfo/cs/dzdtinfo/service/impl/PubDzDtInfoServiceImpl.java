/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.dzdtinfo.dto.PubDzDtInfoDto;
import com.icinfo.cs.dzdtinfo.mapper.PubDzDtInfoMapper;
import com.icinfo.cs.dzdtinfo.model.PubDzDtInfo;
import com.icinfo.cs.dzdtinfo.service.IPubDzDtInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_pub_dz_dtinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Service
public class PubDzDtInfoServiceImpl extends MyBatisServiceSupport implements IPubDzDtInfoService {

	private static final Logger logger = LoggerFactory.getLogger(PubDzDtInfoServiceImpl.class);

	@Autowired
	private PubDzDtInfoMapper pubDtInfoMapper; 
	//职能编码方法
	@Autowired
	private IDeptDutycodeRefService deptDutycodeRefService;
	
	private Map<String, Object> countMap;
	/**
	 * 
	 * 描述   涉证企业分流 查询推送失败和未分流的企业
	 * @author 赵祥江
	 * @date 2016年10月17日 下午3:19:01 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	@Override
	public List<PubDzDtInfoDto> queryPubdtinfoFailReBackListJSON(PageRequest request)
			throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			int pageSize = request.getLength();
			searchMap.put("numStart", (request.getPageNum() - 1) * pageSize);
			searchMap.put("pageSize", pageSize);
 			return pubDtInfoMapper.selectPubdtinfoFailReBackList(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "涉证企业分流 查询推送失败和未分流的企业失败!");
            throw new BusinessException("涉证企业分流 查询推送失败和未分流的企业失败!");
		}
	}
	
	/**
	 * 
	 * 描述   根据UID查询
	 * @author  赵祥江
	 * @date 2016年10月18日 下午12:15:26 
	 * @param  
	 * @throws
	 */
	@Override
	public PubDzDtInfo selectPubDtInfoByUID(String uid) throws Exception {
		try {
			PubDzDtInfo  pubDtInfo= new  PubDzDtInfo();
			pubDtInfo.setUid(uid);
			return pubDtInfoMapper.selectOne(pubDtInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据UID查询失败");
            throw new BusinessException("根据UID查询失败");
		}
	}


	/**
	 * 
	 * 描述   根据UID修改
	 * @author  赵祥江
	 * @date 2016年10月18日 下午12:15:37 
	 * @param  
	 * @throws
	 */
	@Override
	public int updatePubDtInfoByUID(PubDzDtInfo pubDtInfo) throws Exception {
		try {
			pubDtInfo.setCreateTime(DateUtils.getSysDate());
			if(pubDtInfo!=null&&StringUtil.isNotEmpty(pubDtInfo.getUid())){
				Example example = new Example(PubDzDtInfo.class);
				example.createCriteria().andEqualTo("uid", pubDtInfo.getUid()); 
				return pubDtInfoMapper.updateByExampleSelective(pubDtInfo, example);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据UID修改失败");
            throw new BusinessException("根据UID修改失败");
		}
	}
	
	
	/**
	 * 
	 * 描述   插入
	 * @author  赵祥江
	 * @date 2016年10月18日 下午12:15:37 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertPubDtInfo(PubDzDtInfo pubDtInfo) throws Exception {
		try {
			if(pubDtInfo!=null)
			{
				pubDtInfo.setCreateTime(DateUtils.getSysDate());
				return pubDtInfoMapper.insert(pubDtInfo);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "保存失败");
            throw new BusinessException("保存失败");
		}
	}
	
	/**
	 * 
	 * 描述: 查询单个涉证企业信息
	 * @auther gaojinling
	 * @date 2016年10月17日 
	 * @param priPID
	 * @param dtid
	 * @return
	 * @throws Exception
	 */
	public PubDzDtInfo selectOne(String priPID,String uid) throws Exception{
		PubDzDtInfo pubDtInfo = new PubDzDtInfo();
		pubDtInfo.setPriPID(priPID);
		pubDtInfo.setUid(uid);
		return pubDtInfoMapper.selectOne(pubDtInfo);
	}
	
	/**
	 * 
	 * 描述: 涉证企业查询
	 * @auther gaojinling
	 * @date 2016年10月17日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubDzDtInfoDto> queryPage(PageRequest request,SysUserDto sysUser) throws Exception {
		String checkDep = "000";
		if(sysUser.getUserType().equals("1") && StringUtil.isNotEmpty(sysUser.getDeptCode())){ //警示人员登录
			//根据登录工商部门的部门编码+000 及工商职能编码A058查询其对应的adcode
			List<DeptDutycodeRef> list = deptDutycodeRefService.getDeptDutycodeRefByAdCodeSubDutyDeptCode(StringUtil.substring(sysUser.getDeptCode(), 0, 6)+"000","A058");
			if(list != null && list.size() >0 && list.get(0) != null && StringUtil.isNotEmpty(list.get(0).getAdCode()) ){
				checkDep = list.get(0).getAdCode();
			}
		}
		Map<String, Object> map = request.getParams();
		if(map !=null){
			if(map.get("claimFlag") != null){
				if(sysUser.getUserType().equals("1") && StringUtil.isNotEmpty(sysUser.getDeptCode())){ //警示人员登录：
						map.put("checkDep", checkDep);
					}else{ //协同人员登录
					map.put("checkDep", sysUser.getSysDepart().getAdcode()); //当前用户的行政编码即为备案部门编码
				}
			}
			//查询时条件处理
			if(map.get("checkDeps") !=null){  //备案机关
				map.put("checkDeps", StringUtil.doSplitStringToSqlFormat(map.get("checkDeps").toString(),","));
			}
			if(map.get("industryCo") !=null){  //备案机关
				map.put("industryCo", StringUtil.doSplitStringToSqlFormat(map.get("industryCo").toString(),","));
			}
		}else{
			map = new HashMap<String, Object>();
		}
		int pageSize = request.getLength();
		map.put("numStart", request.getStart());
		map.put("pageSize", pageSize);
		//清空全局变量
		if(countMap != null){
			countMap.clear();
		}
		
		countMap = map;
		
		return pubDtInfoMapper.selectPubDtinfoListSearch(map);
	}
	
	/**
	 * 
	 * 描述: 涉证企业查询(条数)
	 * @auther gaojinling
	 * @date 2017年1月13日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer selectPubdtinfoSearchCount()
			throws Exception {
		try {
			return pubDtInfoMapper.selectPubDtinfoListSearchCount(countMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "涉证企业查询 分页条数失败!");
			throw new BusinessException("涉证企业查询 分页条数失败!");
		}
	}
	
	/**
	 * 
	 * 描述: 涉证企业查询详细信息（工商登记信息）
	 * @auther gaojinling
	 * @date 2016年10月17日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public PubDzDtInfoDto selectPubDtInfoByPraMap(Map<String, Object> map) throws Exception {
		return pubDtInfoMapper.selectPubDtInfoByPraMap(map);
	}

	/**
	 * 
	 * 描述   涉证企业推送反馈统计
	 * @author  赵祥江
	 * @date 2016年10月20日 下午4:40:40 
	 * @param  
	 * @throws
	 */
	@Override
	public List<PubDzDtInfoDto> selectPubDtInfoCount(PageRequest request)
			throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), 10000);
			return pubDtInfoMapper.selectPubDtInfoCountRlt(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "涉证企业推送反馈统计失败!");
            throw new BusinessException("涉证企业推送反馈统计失败!");
		}
	}
	
	/**
	 * 
	 * 描述   根据注册号和主体身份代码获取不重复的备案事项编码
	 * @author 赵祥江
	 * @date 2016年10月24日 上午11:37:58 
	 * @param 
	 * @return List<PubDtInfo>
	 * @throws
	 */
	@Override
	public List<PubDzDtInfo> selectDistinctExaCodeByRegNoAndPriPID(
			String  regNo,String priPid) throws Exception {
		try {
			Map<String,Object> queryMap=new HashMap<String,Object>();
			queryMap.put("regNO", regNo);
			queryMap.put("priPID", priPid);
			return pubDtInfoMapper.selectDistinctExaCodeByRegNoAndPriPID(queryMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据注册号和主体身份代码获取双告知主表数据失败!");
            throw new BusinessException("根据注册号和主体身份代码获取双告知主表数据失败!");
		}
	};

	/**
	 * 
	 * 描述: 涉证企业查询处统计(1.分流成功 2分流失败 3回退待分流 4终止推送 )
	 * @auther gaojinling
	 * @date 2016年10月23日 
	 * @return
	 */
	public int pubDtinfoSearchCount(Map<String, Object> map){
		return pubDtInfoMapper.pubDtinfoSearchCount(map);
	};
	
	/**
	 * 
	 * 描述: 涉证企业查询处统计：推送企业条数
	 * @auther gaojinling
	 * @date 2016年10月23日 
	 * @return
	 */
	public int pubDtinfoCount(Map<String, Object> map){
		return pubDtInfoMapper.pubDtinfoCount(map);
	};
	
	
	/**
	 * 
	 * 描述: 涉证企业查询处统计：推送备案 部门条数
	 * @auther gaojinling
	 * @date 2016年10月23日 
	 * @return
	 */
	public int sendDeptCount(Map<String, Object> map){
		return pubDtInfoMapper.sendDeptCount(map);
	}

	/**
	 * 
	 * 描述   批量保存
	 * @author  赵祥江
	 * @date 2016年10月24日 下午4:08:40 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertBatchPubDtinfo(List<PubDzDtInfo> pubDtinfoList)
			throws Exception {
		try {
			if(pubDtinfoList.size()>0)
			{
				 for(PubDzDtInfo pubDtInfo:pubDtinfoList){
					 this.insertPubDtInfo(pubDtInfo);
				 }
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "批量保存失败");
            throw new BusinessException("批量保存失败");
		}
	}

	/**
	 * 
	 * 描述   去掉参数的左右空格
	 * @author  赵祥江
	 * @date 2016年10月28日 下午4:26:31 
	 * @param  
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void paramTrim(Map<String, Object> dataMap) throws Exception {
		if(dataMap!=null){
			Iterator i=dataMap.entrySet().iterator();
			while(i.hasNext()){
				 Map.Entry e=(Map.Entry)i.next();
				 if(e.getValue()!=null&&!"".equals(e.getValue())){
					 dataMap.put(e.getKey().toString(), e.getValue().toString().trim());
				 } 
			} 
		}
	}

	/**
	 * 
	 * 描述   校验同一部门同一企业同一备案事项是否推送过
	 * @author  赵祥江
	 * @date 2016年11月10日 下午8:06:30 
	 * @param  
	 * @throws
	 */
	@Override
	public boolean checkPush(String exaCode, String checkDep,String priPID) throws Exception {
		/*PubDtInfo pubDtInfo=new PubDtInfo(); 
		pubDtInfo.setCheckDep(checkDep);
		pubDtInfo.setExaCode(exaCode);
		pubDtInfo.setCheckDeptType("1");
		pubDtInfo.setCheckPushType("1");
		pubDtInfo.setPriPID(priPID);*/
		List<String> dataList=new ArrayList<String>();
		dataList.add("1");
		dataList.add("2"); 
		Example example = new Example(PubDzDtInfo.class);
		example.createCriteria().andEqualTo("checkDep",checkDep)
		.andEqualTo("exaCode",exaCode)
		.andEqualTo("priPID",priPID)
		.andEqualTo("checkDeptType","3")
		.andNotEqualTo("checkStopState", "1")
 		.andIn("checkPushType", dataList); 
		if(pubDtInfoMapper.selectByExample(example).size()>0){
			return true;
		} 
		return false;
	}
	
	/**
	 * 
	 * 描述: 查询本年度本部门已认领或接收的条数
	 * @auther gaojinling
	 * @date 2016年11月17日 
	 * @param checkDep
	 * @return
	 * @throws Exception
	 */
	public int claimAndReceiveCount(SysUserDto sysUser) throws Exception{
		String checkDep ;
		String userType ;
		if(sysUser.getUserType().equals("1") && StringUtil.isNotEmpty(sysUser.getDeptCode())){ //警示人员登录：
			checkDep = StringUtil.substring(sysUser.getDeptCode(), 0, 6)+"0";//工商直接当前部门编码前6位加0
			userType = "2";
			//根据登录工商部门的部门编码+000 及工商职能编码A058查询其对应的adcode
			List<DeptDutycodeRef> list = deptDutycodeRefService.getDeptDutycodeRefByAdCodeSubDutyDeptCode(StringUtil.substring(sysUser.getDeptCode(), 0, 6)+"000","A058");
			if(list != null && list.size() >0 && list.get(0) != null ){
				checkDep = StringUtil.isEmpty(list.get(0).getAdCode()) ? "000" : list.get(0).getAdCode();
			}
		}else{ //协同人员登录
			checkDep = sysUser.getSysDepart().getAdcode(); //当前用户的行政编码即为备案部门编码
			userType = "2";
		}
		if(StringUtil.isNotEmpty(checkDep)&& StringUtil.isNotEmpty(userType)){
			return pubDtInfoMapper.claimAndReceiveCount(checkDep,userType,DateUtil.getCurrentYear());
		}
		return 0;
	}

	/**
	 * 
	 * 描述   查询待撤销数据
	 * @author  赵祥江
	 * @date 2017年1月5日 下午3:07:55 
	 * @param  
	 * @throws
	 */
	@Override
	public List<PubDzDtInfoDto> queryPubdtinfoCancelListJSON(PageRequest request)
			throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			return pubDtInfoMapper.selectPubdtinfoCancelList(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "查询待撤销数据失败!");
            throw new BusinessException("查询待撤销数据失败!");
		}
	}

	/**
	 * 
	 * 描述   认领撤销修改
	 * @author  赵祥江
	 * @date 2017年1月5日 下午6:47:49 
	 * @param  
	 * @throws
	 */
	@Override
	public int updatePubDtInfoCancel(PubDzDtInfo pubDtInfo) throws Exception {
		try {
			Map<String, Object> searchMap=  new HashMap<String,Object>();
			if(pubDtInfo!=null&&com.icinfo.framework.mybatis.mapper.util.StringUtil.isNotEmpty(pubDtInfo.getUid())){
				searchMap.put("uid", pubDtInfo.getUid());
				/*searchMap.put("deptType", pubDtInfo.getCheckDeptType());
				searchMap.put("checkDep", pubDtInfo.getCheckDep());
				searchMap.put("priPID", pubDtInfo.getPriPID());
				searchMap.put("regNO", pubDtInfo.getRegNO());*/
				return pubDtInfoMapper.updatePubDtInfoCancel(searchMap);
			}
 			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "认领撤销修改失败!");
            throw new BusinessException("认领撤销修改失败!");
		} 
	}

	/**
	 * 
	 * 描述   获取手动分流条数
	 * @author  赵祥江
	 * @date 2017年1月15日 下午6:35:17 
	 * @param  
	 * @throws
	 */
	@Override
	public Integer selectPubdtinfoFailReBackListCount(
			Map<String, Object> queryMap) throws Exception {
		 
		return pubDtInfoMapper.selectPubdtinfoFailReBackListCount(queryMap);
	}

	/**
	 * 
	 * 描述   查询部门未认领的备案事项
	 * @author ranah
	 * @date 2017年6月14日 
	 * @param 
	 * @return List<PubDzDtInfoDto>
	 * @throws
	 */
	@Override
	public List<PubDzDtInfoDto> selectTransferPubdtinfoList(String checkDep,
			String exaCode, String areaCode) throws Exception {
		Map<String, Object> queryMap=new HashMap<String,Object>();
		queryMap.put("checkDep", checkDep);
		queryMap.put("exaCode", exaCode);
		queryMap.put("areaCode", areaCode);
		return pubDtInfoMapper.selectTransferPubdtinfoList(queryMap);
	}
	
}