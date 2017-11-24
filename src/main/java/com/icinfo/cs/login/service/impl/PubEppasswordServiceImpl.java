/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.BeanUtil;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.mapper.PubEppasswordHisMapper;
import com.icinfo.cs.login.mapper.PubEppasswordMapper;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.model.PubEppasswordHis;
import com.icinfo.cs.login.service.IPubEppasswordHisService;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_pub_eppassword 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class PubEppasswordServiceImpl extends MyBatisServiceSupport implements IPubEppasswordService {
	@Autowired
	PubEppasswordMapper pubEppasswordMapper;
	
	@Autowired
	PubEppasswordHisMapper pubEppasswordHisMapper;

	@Autowired
	IEsManageService esManageService;
	@Autowired
	IPubEppasswordHisService pubEppasswordHisService;
	/**
	 * 描述: 查询企业联络员登录信息
	 * @auther ZhouYan
	 * @date 2016年8月30日
	 * @param pubEppasswordDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubEppassword> doCheckLogin(PubEppasswordDto pubEppasswordDto) throws Exception {
		return pubEppasswordMapper.selectLoginPubEppassword(pubEppasswordDto);
	}

	/**
	 * 
	 * 描述: 
	 * @auther gaojinling
	 * @date 2016年8月30日 
	 * @param key
	 * @param priPid
	 * @return
	 */
	@Override
	public List<PubEppassword> selectPubEppasswordByPriId(String key,
			String priPid) {
		Example example = new Example(PubEppassword.class);
		example.createCriteria().andEqualTo(key,priPid);
		return pubEppasswordMapper.selectByExample(example) ;
	}

	/** 
	 * 描述: 根据登录输入的统一代码/注册号匹配联络员信息
	 * @auther ZhouYan
	 * @date 2016年8月31日 
	 * @param regno
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<PubEppassword> selectByRegnoOrUnicode(String regno, String midRegNo)
			throws Exception {
		Example example = new Example(PubEppassword.class);
		example.createCriteria().andEqualTo("regno", regno);
		example.or(example.createCriteria().andEqualTo("unicode", regno));
		example.or(example.createCriteria().andEqualTo("regno", midRegNo));
		example.setOrderByClause(" CreateTime desc ");
		return pubEppasswordMapper.selectByExample(example) ;
	}
	

	/**
	 * 
	 * 描述: 联络员备案查询联络员信息
	 * @auther gaojinling
	 * @date 2016年8月31日 
	 * @param map
	 * @return
	 */
	@Override
	public List<PubEppasswordDto> selectPubEppasswordList(Map<String, Object> map) {
		return pubEppasswordMapper.selectPubEppasswordList(map);
	}

	/**
	 * 
	 * 描述: 联络员备案查询联络员信息
	 * @auther chenyl
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 */
	public List<PubEppasswordDto> selectPubEppasswordList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> hm = request.getParams();
		if(hm != null){
			if(hm.containsKey("regOrg")){
				String regorg = (String) hm.get("regOrg");
				if(StringUtil.isNotEmpty(regorg)){
					String[] regorgList = regorg.split(",");
					hm.put("regOrg", regorgList);
				}			
			}
			
			if(hm.containsKey("regUnit")){
			
				String regUnit = (String) hm.get("regUnit");
				if(StringUtil.isNotEmpty(regUnit)){
					String[] regUnitList = regUnit.split(",");
					hm.put("regUnit", regUnitList);
				}
			}
			
			if(hm.containsKey("appReviewOrg")){
				String appReviewOrg = (String) hm.get("appReviewOrg");
				if(StringUtil.isNotEmpty(appReviewOrg)){
					String[] appReviewOrgList = appReviewOrg.split(",");
					hm.put("appReviewOrg", appReviewOrgList);
				}
			}
			
			if(hm.containsKey("sliceNO")){
				String sliceNO = (String) hm.get("sliceNO");
				if(StringUtil.isNotEmpty(sliceNO)){
					String[] sliceNOList = sliceNO.split(",");
					hm.put("sliceNO", sliceNOList);
				}
			}
			if(hm.containsKey("regState")){
				String regState = (String) hm.get("regState");
				if(StringUtil.isNotEmpty(regState)){
					String[] regStateList = regState.split(",");
					hm.put("regState", regStateList);
				}
			}
			if(hm.containsKey("entType")){
				String entType = (String) hm.get("entType");
				if(StringUtil.isNotEmpty(entType)){
					String[] entTypeList = entType.split(",");
					hm.put("entType", entTypeList);
				}
			}
			
		}
		return pubEppasswordMapper.selectPubEppasswordListNew(hm);
	}

	/** 
	 * 描述: 更新密码
	 * @auther ZhouYan
	 * @date 2016年9月8日 
	 * @param pubEppassword
	 * @throws Exception 
	 */
	@Override
	public void updatePwd(PubEppassword pubEppassword) throws Exception {
		PubEppassword pubEppasswordTemp = new PubEppassword();
		pubEppasswordTemp.setId(pubEppassword.getId());
		pubEppasswordTemp.setPassword(pubEppassword.getPassword());
		pubEppasswordTemp.setCreatetime(new Date());
		pubEppasswordMapper.updateByPrimaryKeySelective(pubEppasswordTemp);
	}
	
    /** 
	 * 描述: 获取回执单打印数据
	 * @param map 
	 * @auther yujingwei
	 * @date 2016年8月31日 
	 * @return PubEppassword
	 * @throws Exception 
	 */
    @Override
	public PubEppassword selectPubEppasswordForPrint(HashMap<String, Object> map) throws Exception{
    	PubEppassword pubEppassword = pubEppasswordMapper.selectPubEppasswordForPrint(map);
    	if(pubEppassword != null){
			//法人手机号码
			String lerepphone = pubEppassword.getLerepphone();
			//联络员手机号码
			String tel = pubEppassword.getTel();
			//联络员证件号码类型
			String liaIdType = pubEppassword.getLiaidtype();
			//联络员证件号码
			String liaRecordNo = pubEppassword.getLiaidnum();
			if(lerepphone!=null&&lerepphone.length()==11){
				pubEppassword.setLerepphone(lerepphone.substring(0, 3)+"******"+lerepphone.substring(9,lerepphone.length()));
			}
			//pubEppassword.setTel(tel.substring(0, 3)+"******"+tel.substring(9,lerepphone.length()));
			pubEppassword.setTel(tel.substring(0, 3)+"******"+tel.substring(9,11));
			if(liaIdType != null && !liaIdType.equals(""))
			{
				if(liaIdType.equals("1")){
					if(liaRecordNo.length() == 18)
					{
						pubEppassword.setLiaidnum(liaRecordNo.substring(0, 2)+"**************"+liaRecordNo.substring(16, liaRecordNo.length()));
					}else if(liaRecordNo.length() == 15){
						pubEppassword.setLiaidnum(liaRecordNo.substring(0, 2)+"***********"+liaRecordNo.substring(13, liaRecordNo.length()));
					}
				}else{
					if(liaRecordNo.length() >= 4){
						//如果证件类型不是身份证,则判断证件号码长度,大于等于4时，只显示后两位
						String starLargerThanFour = "";
						for(int i = 0; i < liaRecordNo.length() - 2; i++)
						{
							starLargerThanFour += "*";
						}
						pubEppassword.setLiaidnum(starLargerThanFour+liaRecordNo.substring(liaRecordNo.length() - 2, liaRecordNo.length()));
					}else{
						//证件号码长度小于4时，则全部隐藏
						String starSmallerThanFour = "";
						for(int i = 0; i < liaRecordNo.length(); i++)
						{
							starSmallerThanFour += "*";
						}
						pubEppassword.setLiaidnum(starSmallerThanFour);
					}
				}
			}
    	    return pubEppassword;
    	}
    	return null;
    }
	 
    /** 
	 * 描述: 获取联络员信息历史数据list
	 * @auther yujingwei
	 * @date 2016年8月31日 
	 * @return List<PubEppasswordHis>
	 * @throws Exception 
	 */
	public List<PubEppasswordHis> queryPageForHis(PageRequest request) throws Exception{
	    PageHelper.startPage(request.getPageNum(), request.getLength());
	    if(request.getParams() != null){
	    	String pripid = (String) request.getParams().get("pripid");
	    	Example example = new Example(PubEppasswordHis.class);
			example.createCriteria().andEqualTo("pripid", pripid);
			return pubEppasswordHisMapper.selectByExample(example);
	    }
	    return new ArrayList<PubEppasswordHis>();
	}

	/**
	 * 
	 * 描述             : 根据企业主体代码获取联络员备案信息
	 * @author: 赵祥江
	 * @date  : 2016年9月12日 下午6:38:23 
	 * @param : 
	 * @throws
	 */
	@Override
	public PubEppassword selectPubEppasswordByPriPid(String pripid) {
		PubEppassword pubEppassword = new PubEppassword();
		pubEppassword.setPripid(pripid);
		List<PubEppassword> pubEppasswordList= pubEppasswordMapper.select(pubEppassword);
		if(pubEppasswordList.size()>0){
			return pubEppasswordList.get(0);
		}
		return null;
	}

	/**
	 * 
	 * 描述: 联络员变更信息从midbaseinfo表中取
	 * @auther gaojinling
	 * @date 2016年12月28日 
	 * @param pubEppasswordDto
	 * @return
	 */
	@Override
	public PubEppasswordDto handPubEppasswordDto(
			PubEppasswordDto pubEppasswordDto,MidBaseInfo midbaseinfo) {
		 pubEppasswordDto.setCerNO(midbaseinfo.getCerNO());
		 pubEppasswordDto.setLerep(midbaseinfo.getLeRep());
		 pubEppasswordDto.setRegno(midbaseinfo.getRegNO());
		 pubEppasswordDto.setUnicode(midbaseinfo.getUniCode());
		 pubEppasswordDto.setPripid(midbaseinfo.getPriPID());
		 pubEppasswordDto.setEntname(midbaseinfo.getEntName());
		 pubEppasswordDto.setEnttype(midbaseinfo.getEntType());
//		 pubEppasswordDto.setLerepphone(midbaseinfo.getTel());
		 String enlianame = pubEppasswordDto.getLianame();
		 if(enlianame.length()>2){ //处理联络员姓名
			 enlianame = enlianame.substring(0,1)+"*"+enlianame.substring(3,enlianame.length());
		 }else{
			 enlianame = enlianame.substring(0,1)+"*";
		 }
		 pubEppasswordDto.setLianame(enlianame);
		 String enliaidnum = pubEppasswordDto.getLiaidnum();
		 if(pubEppasswordDto.getLiaidtype().equals("10")){ //处理联络员证件号码(身份证时处理)
			 enliaidnum = enliaidnum.substring(0,4)+"*****";
		 }
		 String entel = pubEppasswordDto.getTel();
		 if(StringUtil.isNotEmpty(entel) && entel.length()==11){//处理电话号码
			 entel = entel.substring(0,3) + "*****" + entel.substring(8, entel.length());
		 }
		 pubEppasswordDto.setLiaidnum(enliaidnum);
		 pubEppasswordDto.setTel(entel);
		
		return pubEppasswordDto;
	}





	/**
	 * 描述：添加 联络员信息
	 * @author： wangjin
	 * @param pubEppassword
	 * @return
	 */
	@Override
	public int inset(PubEppassword pubEppassword){
		int i = 0;
		Date date = DateUtils.getSysDate();
		pubEppassword.setApplytime(date); //创建时间
		pubEppassword.setCreatetime(date);
		if(pubEppasswordMapper.insert(pubEppassword)>0){
			esManageService.updateOnePanoramaIdx(pubEppassword.getPripid());//更新索引
			i=i+1;
		}
		return i;
	}

	/**
	 * 描述：更新 联络员信息  -- 数字证书
	 * @author： wangjin
	 * @param pubEppassword
	 * @return
	 */
	@Override
	public int update(PubEppassword pubEppassword) {
		int i=0;
		if (StringUtil.isNotEmpty(pubEppassword.getUid()) && StringUtil.isNotEmpty(pubEppassword.getPripid())) {
			pubEppassword.setCreatetime(DateUtils.getSysDate());//更新时间戳
			Example example = new Example(PubEppassword.class);
			example.createCriteria().andEqualTo("uid", pubEppassword.getUid()).andEqualTo("pripid", pubEppassword.getPripid());
			//pubEppassword.setCreatetime(DateUtils.getSysDate());
			if( pubEppasswordMapper.updateByExampleSelective(pubEppassword, example)>0){
				esManageService.updateOnePanoramaIdx(pubEppassword.getPripid());//更新索引
				i=i+1;
			}
		}
		return  i;

	}
	/**
	 *  更新 联络员信息   -- 联络员登录
	 * @param pubEppassword
	 * @return
	 */
	@Override
	public int liaisonupdate(PubEppassword pubEppassword) {
		int i=0;
		if (StringUtil.isNotEmpty(pubEppassword.getUid()) && StringUtil.isNotEmpty(pubEppassword.getPripid())) {
			Example example = new Example(PubEppassword.class);
			example.createCriteria().andEqualTo("uid", pubEppassword.getUid()).andEqualTo("pripid", pubEppassword.getPripid());
			if( pubEppasswordMapper.updateByExampleSelective(pubEppassword, example)>0){
				esManageService.updateOnePanoramaIdx(pubEppassword.getPripid());//更新索引
				i=i+1;
			}
		}
		return  i;
	}


	/**
	 * 描述：根据条件查询联络员信息
	 * @author: wangjin
	 * @param unicode 统一社会信用代码
	 * @param regno 注册号
	 * @return
	 */
	@Override
	public PubEppassword select( String unicode, String regno) {
		PubEppassword pubEppassword = new PubEppassword();
		//如果统一社会信用代码和注册号都为空的话 返回null
		if(StringUtil.isEmpty(unicode)&&StringUtil.isEmpty(regno))return null;
		if(StringUtil.isNotEmpty(regno)){   //注册号
			pubEppassword.setRegno(regno);
		}else if(StringUtil.isNotEmpty(unicode)) { //统一社会信用代码
			pubEppassword.setUnicode(unicode);
		}
		return  pubEppasswordMapper.selectOne(pubEppassword);
		  /*
			Example example = new Example(PubEppassword.class);
			Example.Criteria criteria1=  example.createCriteria();
			criteria1.andEqualTo("unicode",unicode);
			Example.Criteria criteria2=  example.createCriteria();
			criteria2.andEqualTo("regno",regno);
			example.or(criteria2);
			List<PubEppassword> list = pubEppasswordMapper.selectByExample(example);
			*/
	}


	/**
	 * 查询联络员信息
	 * @author:wangjin
	 * @param unicode
	 * @param regno
	 * @return
	 */
	@Override
	public List<PubEppassword> selectPubEppasswordList(String unicode, String regno) {
		//如果统一社会信用代码和注册号都为空的话 返回null
		if(StringUtil.isEmpty(unicode)&&StringUtil.isEmpty(regno))return null;

		Example example = new Example(PubEppassword.class);
		Example.Criteria criteria=  example.createCriteria();

		if(StringUtil.isNotEmpty(regno)){   //注册号
			criteria.andEqualTo("regno",regno);
		}else if(StringUtil.isNotEmpty(unicode)) { //统一社会信用代码
			criteria.andEqualTo("unicode",unicode);
		}
		example.setOrderByClause(" CreateTime desc ");
		return pubEppasswordMapper.selectByExample(example);
	}
	
	/**
	 * 
	 * 描述: 个体户登录校验码查询
	 * @auther gaojinling
	 * @date 2017年1月4日 
	 * @param request
	 * @return
	 */
	@Override
	public List<PubEppasswordDto> selectPbEppasswordList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
		return pubEppasswordMapper.selectPbEppasswordList(paramsMap);
	}



	/**
	 * 获取联络员相关信息
	 * 
	 * @author zhuyong
	 * @param priPid
	 * @param year
	 * @return
	 */
	public List<PubEppassword> selectLiaInfo(List<String> priPid,int year) throws Exception{
		if(priPid == null || priPid.size() == 0) return null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("priPidList", priPid);
		params.put("year", year);
		return pubEppasswordMapper.selectLiaInfo(params);
	}
	
	
	
//	/**
//	 * 
//	 * 描述: 个体户App联络员登录 获取密码（获取密码，通过联络员手机号码更新）
//	 * @auther gaojinling
//	 * @date 2017年2月22日 
//	 * @param pubEppassword
//	 * @return
//	 * @throws Exception
//	 */
//	public int updatePwdByTel(PubEppassword pubEppassword) throws Exception{
//		Example example = new Example(PubEppassword.class);
//		example.createCriteria().andEqualTo("tel", pubEppassword.getTel()).andEqualTo("enttype", "9500").andEqualTo("passtatus", "01");
//		return pubEppasswordMapper.updateByExampleSelective(pubEppassword, example);
//	}
	
	
	/**
	 * 
	 * 描述: 补录联系信息提交
	 * @auther gaojinling
	 * @date 2017年3月14日 
	 * @param pubEppassword
	 * @throws Exception
	 */
	public void save(PubEppassword pubEppassword) throws Exception{
		
		String pripid = pubEppassword.getPripid();
		//1.查询当前联络员
		PubEppassword pubEppasswordold = selectPubEppasswordByPriPid(pripid);
		//2.删除当前联络员信息
		PubEppassword pubEppasswordtem = new PubEppassword();
		pubEppasswordtem.setPripid(pripid);
		int deleteCount = pubEppasswordMapper.delete(pubEppasswordtem);
		if(deleteCount < 0){
			throw new Exception("删除备案申请表失败");
		}
		//3.保存联络员备案信息（最新）
		int insertCount = pubEppasswordMapper.insert(pubEppassword);
		if(insertCount <0){
			throw new Exception("保存联络员备案信息（最新）失败");
		}
		//4.保存联络员备案历史信息（最新）
		if(pubEppasswordold != null ){
            PubEppasswordHis pubEppasswordHis = new PubEppasswordHis();
            pubEppasswordold.setId(null);
            BeanUtil.getBeanUtilsBean().copyProperties(pubEppasswordHis, pubEppasswordold);
            int saveCount = pubEppasswordHisService.doSavePubEppasswordInfo(pubEppasswordHis);
    		if(saveCount <0){
			throw new Exception("保存联络员备案历史信息（最新）失败");
		}
		}
	}



/** 
 * 描述: 根据联络员手机号获取信息
 * @author 张文男
 * @date 2017年5月19日 
 * @param tel
 * @return 
 */

public List<PubEppassword> queryPubEppasswordListByTel(String tel){
    Example example = new Example(PubEppassword.class);
    Example.Criteria criteria=  example.createCriteria();
    criteria.andEqualTo ("tel", tel);
    List<PubEppassword> list = pubEppasswordMapper.selectByExample (example);
    return list;
}

/** 
* 描述: 根据联络电话获取3条企业名称数据 
* @author 张文男
* @date 2017年5月22日 
* @param tel
* @return 
*/

public List<String> queryEntNameFirst3ListByPubEppasswordTel(String tel){
    List<String> list =   pubEppasswordMapper.queryEntNameFirst3ListByPubEppasswordTel (tel, RegStateEnum.CUNXU.getParam());
    return list;
}


/** 
 * 描述: 获取联络员年报信息列表
 * @author 张文男
 * @date 2017年6月19日 
 * @param year
 * @param isreported
 * @param numStart
 * @param pageSize
 * @return 
 */

public List<PubEppasswordDto> queryYearReportList(Integer year,String isreported,Long numStart,Long pageSize){
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("year", year);
    params.put("isreported", isreported);
    params.put("numStart", numStart);
    params.put("pageSize", pageSize);
    params.put("regState", RegStateEnum.CUNXU.getParam());
    List<PubEppasswordDto> list =  pubEppasswordMapper.queryYearReportList (params);
    return list;
}

/** 
 * 描述: 获取联络员年报信息列表-总数
 * @author 张文男
 * @date 2017年6月9日 
 * @param year
 * @return 
 */
public Long queryYearReportCount(Integer year,String isreported){
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("year", year);
    params.put("isreported", isreported);
    params.put("regState", RegStateEnum.CUNXU.getParam());
    Long count =  pubEppasswordMapper.queryYearReportCount (params);
    return count;
}

/** 
 * 描述: 根据年份、是否年报、联络员手机获取企业名称列表
 * @author 张文男
 * @date 2017年6月9日 
 * @param params
 * @return 
 */

public List<PubEppasswordDto> queryEntNameList(Integer year,String isreported,String tel){
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("year", year);
    params.put("isreported", isreported);
    params.put("tel", tel);
    params.put("regState", RegStateEnum.CUNXU.getParam());
    List<PubEppasswordDto> list =  pubEppasswordMapper.queryEntNameList (params);
    return list;
}


/** 
 * 描述: 根据年份、是否年报、联络员手机获取企业名称分页列表
 * @author 张文男
 * @date 2017年6月9日 
 * @param request
 * @return 
 */

public PageResponse<PubEppasswordDto> queryEntNamePageList(PageRequest request) {
    PageHelper.startPage(request.getPageNum(), request.getLength());
    List<PubEppasswordDto> list =  pubEppasswordMapper.queryEntNameList (request.getParams());
    return new PageResponse<PubEppasswordDto> (list);
   
}

/**
 * 
 * 描述  获取已经接收了且企业为存续状态的联络员，联络员手机号码不重复条数
 * @author  赵祥江
 * @date 2017年7月5日 下午4:26:04 
 * @param  
 * @throws
 */
public Long queryPubEppasswordPsCount(){
	Long count=0L;
	try {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("regState", RegStateEnum.CUNXU.getParam());
	    count =  pubEppasswordMapper.queryPubEppasswordPsCount (params);
	} catch (Exception e) {
		e.printStackTrace(); 
	} 
    return count;
}

/**
 * 
 * 描述   获取已经接收了且企业为存续状态的联络员，联络员手机号码不重复
 * @author 赵祥江
 * @date 2017年7月5日 下午4:33:56 
 * @param 
 * @return List<PubEppasswordDto>
 * @throws
 */
public List<PubEppasswordDto> queryPubEppasswordPsList(Long numStart,Long pageSize){
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("numStart", numStart);
    params.put("pageSize", pageSize);
    params.put("regState", RegStateEnum.CUNXU.getParam());
    List<PubEppasswordDto> list =  pubEppasswordMapper.queryPubEppasswordPsList (params);
    return list;
}

/**
 * 
 * 描述   获取存续企业即时信息推送条数
 * @author 赵祥江
 * @date 2017年7月18日 下午3:02:29 
 * @param 
 * @return Long
 * @throws
 */
@Override
public Long queryPubEppasswordImInfoCount() {
	Long count=0L;
	try {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("nowDate", DateUtils.getDate("yyyy-MM-dd")); 
	    params.put("regState", RegStateEnum.CUNXU.getParam());
	    count =  pubEppasswordMapper.queryPubEppasswordImInfoCount (params);
	} catch (Exception e) {
		e.printStackTrace(); 
	} 
    return count;
}

/**
 * 
 * 描述    获取存续企业即时信息推送信息
 * @author 赵祥江
 * @date 2017年7月18日 下午3:02:40 
 * @param 
 * @return List<PubEppasswordDto>
 * @throws
 */
@Override
public List<PubEppasswordDto> queryPubEppasswordImInfoList(Long numStart,
		Long pageSize) {
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("numStart", numStart);
	    params.put("pageSize", pageSize);
	    params.put("nowDate", DateUtils.getDate("yyyy-MM-dd")); 
	    params.put("regState", RegStateEnum.CUNXU.getParam());
	    List<PubEppasswordDto> list =  pubEppasswordMapper.queryPubEppasswordImInfoList (params);
     return list;
}

/**
 * 
 * 描述   
 * @author  赵祥江
 * @date 2017年7月18日 下午7:22:15 
 * @param  
 * @throws
 */
@Override
public List<PubEppasswordDto> queryPubEppasswordImInfoBytelList(String tel) {
	Map<String, Object> params = new HashMap<String, Object>();
    params.put("tel", tel);
    params.put("nowDate", DateUtils.getDate("yyyy-MM-dd")); 
    params.put("regState", RegStateEnum.CUNXU.getParam());
	return pubEppasswordMapper.queryPubEppasswordImInfoBytelList(params);
}

}