/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.icinfo.framework.tools.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.mapper.YrWebsiteInfoMapper;
import com.icinfo.cs.yr.model.YrBaseInfo;
import com.icinfo.cs.yr.model.YrPbWebsiteInfo;
import com.icinfo.cs.yr.model.YrWebsiteInfo;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.cs.yr.service.IYrWebsiteInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_yr_websiteinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月31日
 */
@Service
public class YrWebsiteInfoServiceImpl extends MyBatisServiceSupport implements IYrWebsiteInfoService {
	private static final Logger logger = LoggerFactory.getLogger(YrWebsiteInfoServiceImpl.class);

	@Autowired
	private YrWebsiteInfoMapper yrWebsiteInfoMapper;
	@Autowired
	private IYrBaseInfoService iYrBaseInfoService;
	//网站标识
	private final String CS_YR_WEBSITEINFO_WEBID="webid";

	/**
	 *  新增
	 * @param yrWebsiteInfo
	 * @return
     */
	@Override
	public int insert(YrWebsiteInfo yrWebsiteInfo) {
		yrWebsiteInfo.setCreateTime(DateUtils.getSysDate());
		return yrWebsiteInfoMapper.insert(yrWebsiteInfo);
	}

	/**
	 * 更新
	 * @param yrWebsiteInfo
	 * @return
     */
	@Override
	public int update(YrWebsiteInfo yrWebsiteInfo) {
		Example example = new Example(YrWebsiteInfo.class);
		example.createCriteria().andEqualTo(CS_YR_WEBSITEINFO_WEBID, yrWebsiteInfo.getWebid());
		yrWebsiteInfo.setCreateTime(DateUtils.getSysDate());
		return yrWebsiteInfoMapper.updateByExampleSelective(yrWebsiteInfo,example);
	}

	/**
	 * 删除
	 * @param webid
	 * @return
     */
	@Override
	public int deleteByWebidwebid(String webid,String priPID) {
		if(StringUtils.isNotBlank(webid)&&StringUtils.isNotBlank(priPID)){
			YrWebsiteInfo yrWebsiteInfo = new YrWebsiteInfo();
			yrWebsiteInfo.setWebid(webid);
			yrWebsiteInfo.setPriPID(priPID);
			//采用的是物理删除
			return yrWebsiteInfoMapper.delete(yrWebsiteInfo);
		}
		return 0;
	}


	/**
	 * 根据当前年份和主体身份代码查询网站网店列表
	 *@autor：wangjin
	 * @param year
	 * @param pripid
	 * @return
	 */
	@Override
	public List<YrWebsiteInfo> selectByYearAndPriPID(Integer year, String pripid) {
		if(StringUtils.isNotBlank(pripid)&&year!=null){
			Example example=this.getExample(YrWebsiteInfo.class);
			example.createCriteria().andEqualTo(Constants.CS_PRIPID, pripid).andEqualTo(Constants.CS_YEAR, year);
			example.setOrderByClause(" CreateTime desc ");
			return yrWebsiteInfoMapper.selectByExample(example);
		}
		return null;
	}

	/**
	 * 描述：根据传入的参数 清空当前对象
	 * @author: wangjin
	 * @param yrWebsiteInfo
	 * @return
     */
	@Override
	public int deleteAll(YrWebsiteInfo yrWebsiteInfo) {
		Example example= new Example(YrWebsiteInfo.class);
		if(com.icinfo.cs.common.utils.StringUtil.checkYearAndPripid(yrWebsiteInfo.getYear(),yrWebsiteInfo.getPriPID())&& StringUtils.isNotBlank(yrWebsiteInfo.getAnCheID())){
			example.createCriteria().andEqualTo("anCheID", yrWebsiteInfo.getAnCheID()).andEqualTo(Constants.CS_PRIPID, yrWebsiteInfo.getPriPID()).
					andEqualTo(Constants.CS_YEAR, yrWebsiteInfo.getYear());
			return 	yrWebsiteInfoMapper.deleteByExample(example);
		}
		return 0;
	}

	/**
	 *
	 * 描述 : 根据webId查询
	 * @author: 赵祥江
	 * @date  : 2016年9月12日 下午8:36:15
	 * @param :
	 * @return: int
	 * @throws
	 */
	@Override
	public YrWebsiteInfo selectYrWebsiteInfoByWebId(String webid) throws Exception {

		if(StringUtils.isNotBlank(webid)){
			YrWebsiteInfo yrWebsiteInfo = new YrWebsiteInfo();
			yrWebsiteInfo.setWebid(webid);
			return yrWebsiteInfoMapper.selectOne(yrWebsiteInfo);
		}else{
			return null;
		}

	/*	List<YrWebsiteInfo> yrWebsiteInfoList=new ArrayList<YrWebsiteInfo>();
		try {
			Example example=this.getExample(YrWebsiteInfo.class);
			example.createCriteria().andEqualTo(CS_YR_WEBSITEINFO_WEBID, webId);
			yrWebsiteInfoList=yrWebsiteInfoMapper.selectByExample(example);
			if(yrWebsiteInfoList.size()>0){
				return yrWebsiteInfoList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}", "获取网站网店信息失败!");
			throw new BusinessException("获取网站网店信息失败!");
		}
		return null;*/
	}







	//TODO 以下代码暂未用到


	/**
	 * 
	 * 描述             : 根据年度和主体代码分页查询网站网店信息 
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 上午10:26:49 
	 * @param :
	 * @return: List<YrWebsiteInfo>
	 * @throws
	 */
	@Override
	public List<YrWebsiteInfo> queryPagePreview(PageRequest request) throws Exception {
		List<YrWebsiteInfo> yrWebsiteInfoList=new ArrayList<YrWebsiteInfo>();
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=this.getExample(YrWebsiteInfo.class);
			//验证是否主体代码和年报年度都传了
			if(searchMap.containsKey(Constants.CS_PRIPID)&&searchMap.containsKey(Constants.CS_YEAR)){
				example.createCriteria().andEqualTo(Constants.CS_PRIPID, searchMap.get(Constants.CS_PRIPID).toString())
				.andEqualTo(Constants.CS_YEAR, searchMap.get(Constants.CS_YEAR).toString());
				yrWebsiteInfoList=yrWebsiteInfoMapper.selectByExample(example); 
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}", "获取网站网店信息失败!");
            throw new BusinessException("获取网站网店信息失败!");
		}
		return yrWebsiteInfoList;
	}

	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj); 
		return example;
	}

	/**
	 * 
	 * 描述             : 根据年度和主体代码分页查询网站网店信息(不分页)
	 * @author: 赵祥江
	 * @date  : 2016年9月12日 下午7:32:20 
	 * @param : 
	 * @throws
	 */
	@Override
	public List<YrWebsiteInfo> selectYrWebsiteInfoByPriPIDAndYear(String priPID, int year) throws Exception {
		List<YrWebsiteInfo> yrWebsiteInfoList=new ArrayList<YrWebsiteInfo>();
		try { 
			Example example=this.getExample(YrWebsiteInfo.class);
			 example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID).andEqualTo(Constants.CS_YEAR, year);
			 yrWebsiteInfoList=yrWebsiteInfoMapper.selectByExample(example);
			 
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}", "获取网站网店信息失败!");
            throw new BusinessException("获取网站网店信息失败!");
		}
		return yrWebsiteInfoList;
	}


	@Override
	public int insertYrWebsiteInfo(YrWebsiteInfo yrWebsiteInfo)
			throws Exception {
		List<YrWebsiteInfo> yrWebsiteInfoList=new ArrayList<YrWebsiteInfo>();
		try { 
			if(yrWebsiteInfo!=null){
				int year=yrWebsiteInfo.getYear();
				String priPID=yrWebsiteInfo.getPriPID();
				//获取当年网站网店信息
				yrWebsiteInfoList=this.selectYrWebsiteInfoByPriPIDAndYear(priPID,year);
				//获取年报基本信息
				List<YrBaseInfo> yrBaseInfoList= iYrBaseInfoService.selectYrBaseInfoByYearAndPriPID(year, priPID);
				
				Example example=this.getExample(YrWebsiteInfo.class);
				 example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID)
					.andEqualTo(Constants.CS_YEAR, year);
				if(yrWebsiteInfoList.size()>0){
					//删除
					if(yrWebsiteInfoMapper.deleteByExample(example)>0){
						yrWebsiteInfo.setAnCheID(yrBaseInfoList.get(0).getAnCheID());
					 } 
				} 
				return yrWebsiteInfoMapper.insert(yrWebsiteInfo);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}", "新增网站网店信息失败!");
            throw new BusinessException("新增网站网店信息失败!");
		}		
		return 0;
	}


	/**
	 * 
	 * 描述             : 根据主键修改网站网店
	 * @author: 赵祥江
	 * @date  : 2016年9月13日 上午9:28:55 
	 * @param : 
	 * @throws
	 */
	@Override
	public int updateYrWebsiteInfoByWebId(YrWebsiteInfo yrWebsiteInfo)
			throws Exception { 
		try { 
			if(yrWebsiteInfo!=null&&StringUtil.isNotEmpty(yrWebsiteInfo.getWebid())){
				int year=yrWebsiteInfo.getYear();
				String priPID=yrWebsiteInfo.getPriPID();
				 //获取年报基本信息
				List<YrBaseInfo> yrBaseInfoList= iYrBaseInfoService.selectYrBaseInfoByYearAndPriPID(year, priPID);
				
				Example example=this.getExample(YrWebsiteInfo.class);
				 example.createCriteria()
				 .andEqualTo(CS_YR_WEBSITEINFO_WEBID, yrWebsiteInfo.getWebid());
				 //年报ID
				 yrWebsiteInfo.setAnCheID(yrBaseInfoList.get(0).getAnCheID());
				 //时间戳
				 yrWebsiteInfo.setCreateTime(DateUtils.getSysDate());
				return yrWebsiteInfoMapper.updateByExampleSelective(yrWebsiteInfo, example);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}", "新增网站网店信息失败!");
            throw new BusinessException("新增网站网店信息失败!");
		}		
		return 0;
	}




	/**
	 * 
	 * 描述             : 根据webId删除
	 * @author: 赵祥江
	 * @date  : 2016年9月13日 上午10:20:02 
	 * @param : 
	 * @throws
	 */
	@Override
	public int deleteYrWebsiteInfoByWebId(String webId) throws Exception {
		try { 
			if(StringUtil.isNotEmpty(webId)){
				Example example=this.getExample(YrWebsiteInfo.class);
				 example.createCriteria().andEqualTo(CS_YR_WEBSITEINFO_WEBID, webId);
				 int i=yrWebsiteInfoMapper.deleteByExample(example);
				 return i;
			}  
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}", "删除网站网店信息失败!");
            throw new BusinessException("删除网站网店信息失败!");
		}
		return 0;
	}


}