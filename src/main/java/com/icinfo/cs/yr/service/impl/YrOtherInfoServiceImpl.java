/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.framework.tools.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.ext.model.MidSup;
import com.icinfo.cs.ext.service.IMidSupService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.yr.mapper.YrOtherInfoMapper;
import com.icinfo.cs.yr.model.YrOtherInfo;
import com.icinfo.cs.yr.model.YrWebsiteInfo;
import com.icinfo.cs.yr.service.IYrOtherInfoService;
import com.icinfo.cs.yr.service.IYrWebsiteInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_yr_otherinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月31日
 */
@Service
public class YrOtherInfoServiceImpl extends MyBatisServiceSupport implements IYrOtherInfoService {
	private static final Logger logger = LoggerFactory.getLogger(YrOtherInfoServiceImpl.class);

	   @Autowired
	   YrOtherInfoMapper yrOtherInfoMapper;	 
	   @Autowired
	   private IYrWebsiteInfoService yrWebsiteInfoService;
	   @Autowired
	   private IPubEppasswordService pubEppasswordService;
	   @Autowired
	   private IMidSupService midSupService;
	   //uuid
	   private final String CS_YR_OTHERINFO_OTHERID="otherID";


	/**
	 * 根据 年份和身份主体代码查询当前对象
	 * @param year
	 * @param pripid
	 * @return
	 */
	@Override
	public YrOtherInfo selectByYearAndPripid(Integer year, String pripid) {
		if(StringUtil.isNotEmpty(pripid)&&year!=null){
			YrOtherInfo yrOtherInfo = new YrOtherInfo();
			yrOtherInfo.setYear(year);
			yrOtherInfo.setPriPID(pripid);
			yrOtherInfo=yrOtherInfoMapper.selectOne(yrOtherInfo);
			if(yrOtherInfo!=null){
				/**金额转换显示*/
				//本年度投入广告费
				yrOtherInfo.setThAnnAdvFee (yrOtherInfo.getThAnnAdvFee ()==null?null:yrOtherInfo.getThAnnAdvFee().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
				//其中：在互联网投入广告费
				yrOtherInfo.setThIntAnnAdvFee (yrOtherInfo.getThIntAnnAdvFee ()==null?new BigDecimal(0):yrOtherInfo.getThIntAnnAdvFee().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
				//本年度广告经营额
				yrOtherInfo.setThAdvTurnover (yrOtherInfo.getThAdvTurnover()==null?new BigDecimal(0):yrOtherInfo.getThAdvTurnover().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
				//广告经营上缴税收
				yrOtherInfo.setAdvTurTaxPaid(yrOtherInfo.getAdvTurTaxPaid()==null?new BigDecimal(0):yrOtherInfo.getAdvTurTaxPaid().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
				//本年度通过网络交易经营额
				yrOtherInfo.setThNetTraBusTur(yrOtherInfo.getThNetTraBusTur()==null?null:yrOtherInfo.getThNetTraBusTur().setScale(4,BigDecimal.ROUND_HALF_UP));
				//跨境网络交易进出口经营额
				yrOtherInfo.setPartyAccNetAmount(yrOtherInfo.getPartyAccNetAmount()==null?null:yrOtherInfo.getPartyAccNetAmount().setScale(4,BigDecimal.ROUND_HALF_UP));
			}
			return yrOtherInfo;
		}
		return null;
	}





	/**
	     * 无条件查询
	     * @param request
	     * @return
	     */
	    @Override
	    public List<YrOtherInfo> queryPage(PageRequest request) {
	        PageHelper.startPage(request.getPageNum(), request.getLength());
	        return yrOtherInfoMapper.selectAll();
	    }

	   /**
	    * 
	    * 描述: TODO
	    * @auther gaojinling
	    * @date 2016年9月8日 
	    * @param request
	    * @return
	    */
	    @Override
	    public List<YrOtherInfo> search_queryPage(PageRequest request) {
	        PageHelper.startPage(request.getPageNum(), request.getLength());
	        return yrOtherInfoMapper.selectYrOtherInfoBysearch_queryPage(request.getParams());
	    }

	    /**
	     * 更新数据
	     * @param yrOtherInfo
	     * @return
	     */
	    @Override
	    public int update(YrOtherInfo yrOtherInfo) {
			/**金额转换插入*/
			//本年度投入广告费
			yrOtherInfo.setThAnnAdvFee(yrOtherInfo.getThAnnAdvFee ()==null?null:yrOtherInfo.getThAnnAdvFee().divide(new BigDecimal(10000)));
			//其中：在互联网投入广告费
			yrOtherInfo.setThIntAnnAdvFee (yrOtherInfo.getThIntAnnAdvFee  ()==null?null:yrOtherInfo.getThIntAnnAdvFee ().divide(new BigDecimal(10000)));
			//本年度广告经营额
			yrOtherInfo.setThAdvTurnover (yrOtherInfo.getThAdvTurnover()==null?null:yrOtherInfo.getThAdvTurnover().divide(new BigDecimal(10000)));
			//广告经营上缴税收
			yrOtherInfo.setAdvTurTaxPaid(yrOtherInfo.getAdvTurTaxPaid()==null?null:yrOtherInfo.getAdvTurTaxPaid().divide(new BigDecimal(10000)));
	        Example example = new Example(YrOtherInfo.class);
	        example.createCriteria().andEqualTo(CS_YR_OTHERINFO_OTHERID, yrOtherInfo.getOtherID()).andEqualTo("priPID",yrOtherInfo.getPriPID());
			//yrOtherInfo.setCreateTime(DateUtils.getSysDate());
			//判断当前选中党组织建制值是否为0 是 则将组建时间设置为null
			if("0".equals(yrOtherInfo.getParIns())){
				Map<String, String> map = new HashMap<String, String>();
				map.put("otherID",yrOtherInfo.getOtherID());
				map.put("priPID",yrOtherInfo.getPriPID());
				yrOtherInfoMapper.updateParSetTime(map);
			}
			yrOtherInfo.setParIns("0".equals(yrOtherInfo.getParIns())?"":yrOtherInfo.getParIns());
	        return yrOtherInfoMapper.updateByExampleSelective(yrOtherInfo,example);


	    }
	    /**
	     * 新增数据
	     * @param yrOtherInfo
	     * @return
	     */
	    @Override
	    public int insert(YrOtherInfo yrOtherInfo) {
	    	yrOtherInfo.setCreateTime(DateUtils.getSysDate());
			/**金额转换插入*/
			//本年度投入广告费
			yrOtherInfo.setThAnnAdvFee(yrOtherInfo.getThAnnAdvFee ()==null?null:yrOtherInfo.getThAnnAdvFee().divide(new BigDecimal(10000)));
			//其中：在互联网投入广告费
			yrOtherInfo.setThIntAnnAdvFee (yrOtherInfo.getThIntAnnAdvFee  ()==null?null:yrOtherInfo.getThIntAnnAdvFee ().divide(new BigDecimal(10000)));
			//本年度广告经营额
			yrOtherInfo.setThAdvTurnover (yrOtherInfo.getThAdvTurnover()==null?null:yrOtherInfo.getThAdvTurnover().divide(new BigDecimal(10000)));
			//广告经营上缴税收
			yrOtherInfo.setAdvTurTaxPaid(yrOtherInfo.getAdvTurTaxPaid()==null?null:yrOtherInfo.getAdvTurTaxPaid().divide(new BigDecimal(10000)));
			yrOtherInfo.setParIns("0".equals(yrOtherInfo.getParIns())?"":yrOtherInfo.getParIns());
	        return  yrOtherInfoMapper.insert(yrOtherInfo);
	    }


	    /**
	     * 
	     * 描述: 根绝主体代码和年份查询其他情况表信息
	     * @auther gaojinling
	     * @date 2016年9月8日 
	     * @return
	     */
	    @Override   
	public YrOtherInfo selectOtherInfoListByYearPriID(String priPID,int year) {
	    	YrOtherInfo yrOtherInfo=new YrOtherInfo();
	    	yrOtherInfo.setYear(year);
	    	yrOtherInfo.setPriPID(priPID);
	    	return yrOtherInfoMapper.selectOne(yrOtherInfo);
	   }


	    /**
	     * 根据 年份和身份主体代码集查询当前对象集合
	     * 
	     * @author zhuyong
	     * @param year
	     * @param pripid
	     * @return
	     */
	    public List<YrOtherInfo> selectByYearAndPripidList(List<String> pripidList , int year){
	    	if(pripidList == null || pripidList.size() == 0)
	    		return null;
	    	
	    	Map<String, Object> params = new HashMap<String, Object>();
			params.put("priPidList", pripidList);
			params.put("year", year);
			return yrOtherInfoMapper.selectByYearAndPripidList(params);
	    }





	    /**
	     * @throws Exception 
	     * 
	     * 描述             : 获取网站 其他情况信息
	     * @author: 赵祥江
	     * @date  : 2016年9月12日 下午7:01:38 
	     * @param :
	     * @return: Map<String,Object>
	     * @throws
	     */
	/*	@Override
		public Map<String, Object> getOtherCircsIniRpt(
				Map<String, String> qryMap) throws Exception { 
			Map<String, Object> resultMap = new HashMap<String, Object>();
			//验证是否主体代码和年报年度都传了
			if(qryMap.containsKey(Constants.CS_PRIPID)&&qryMap.containsKey(Constants.CS_YEAR)){
				int year=Integer.parseInt(qryMap.get(Constants.CS_YEAR).toString());
				String priPID=qryMap.get(Constants.CS_PRIPID).toString(); 
				//获取当年其他情况
				YrOtherInfo otherInfo = selectOtherInfoListByYearPriID(priPID, year);
				//获取当年网站网店
				List<YrWebsiteInfo> yrWebsiteInfoList= yrWebsiteInfoService.selectYrWebsiteInfoByPriPIDAndYear(priPID, year); 
				//当年没有 获取上一年
				if(otherInfo==null){
					int preYear=year-1;
					otherInfo= selectOtherInfoListByYearPriID(priPID, preYear);
				}
				if(otherInfo!=null){
					//从准入获取
					List<MidSup> midSupList= midSupService.selectMidSupBypriPID(priPID);
					if(midSupList.size()>0){
 						String supEntname=midSupList.get(0).getEntName();
						//隶属企业
						otherInfo.setSupEntname(supEntname);
					}
				}
				//金额单位转换
				otherInfo=doWapMulitplyOtherInfo(otherInfo); 
				//联络员备案信息 
				PubEppassword  pubEppassword  =pubEppasswordService.selectPubEppasswordByPriPid(priPID); 
				resultMap.put("yrWebsiteInfoList", yrWebsiteInfoList);
				resultMap.put("otherInfo", otherInfo);
				resultMap.put("pubEppassword", pubEppassword); 
			}
			return resultMap;
		}*/
		
		/**
		 * 
		 * 描述             : 万元转换为元
		 * @author: 赵祥江
		 * @date  : 2016年9月12日 下午7:06:17 
		 * @param :
		 * @return: List<YrOtherInfo>
		 * @throws
		 */
		/*private YrOtherInfo doWapMulitplyOtherInfo(YrOtherInfo otherInfo) {
			if(otherInfo == null ){
				return otherInfo;
			}
			//本年度投入广告费
			otherInfo.setThAdvTurnover (otherInfo.getThAdvTurnover ()==null?new BigDecimal(0):otherInfo.getThAdvTurnover().multiply(new BigDecimal(10000)));
			//其中：在互联网投入广告费
			otherInfo.setThIntAnnAdvFee (otherInfo.getThIntAnnAdvFee ()==null?new BigDecimal(0):otherInfo.getThIntAnnAdvFee().multiply(new BigDecimal(10000)));
			//本年度广告经营额
			otherInfo.setThAdvTurnover (otherInfo.getThAdvTurnover()==null?new BigDecimal(0):otherInfo.getThAdvTurnover().multiply(new BigDecimal(10000)));
			//广告经营上缴税收
			otherInfo.setAdvTurTaxPaid(otherInfo.getAdvTurTaxPaid()==null?new BigDecimal(0):otherInfo.getAdvTurTaxPaid().multiply(new BigDecimal(10000)));
			//本年度通过网络交易经营额
			otherInfo.setThNetTraBusTur(otherInfo.getThNetTraBusTur()==null?new BigDecimal(0):otherInfo.getThNetTraBusTur().multiply(new BigDecimal(10000)));
			//其中跨境网络交易进出口经营额
			otherInfo.setPartyAccNetAmount(otherInfo.getPartyAccNetAmount()==null?new BigDecimal(0):otherInfo.getPartyAccNetAmount().multiply(new BigDecimal(10000)));
			return otherInfo;
		}*/
		
		
		

		/**
		 * 
		 * 描述             : 保存其他情况 
		 * @author: 赵祥江
		 * @date  : 2016年9月13日 上午9:44:39 
		 * @param : 
		 * @throws
		 */
	/*	public int insertYrOtherInfo(YrOtherInfo yrOtherInfo) {
 			try {
				if(yrOtherInfo!=null){ 
					 yrOtherInfo.setCreateTime(DateUtils.getSysDate());
					 return yrOtherInfoMapper.insert(yrOtherInfo);
				} 
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("exception {}", "获取网站网店信息失败!");
	            throw new BusinessException("获取网站网店信息失败!");
			}
			return 0;
		}*/
		

	/*	private Example getExample(Class<?> classObj){
			Example example=new Example(classObj); 
			return example;
		}*/


	/**
	 * 根据otherID进行 物理删除
	 * @param otherID
	 * @return
	 */
	@Override
	public int deleteByUuid(String otherID) {
		YrOtherInfo yrOtherInfo = new YrOtherInfo();
		yrOtherInfo.setOtherID(otherID);
		return yrOtherInfoMapper.delete(yrOtherInfo);
	}

	/**
	 *  根据唯一主键otherID查询
	 * @param otherID
	 * @return
	 */
	@Override
	public  YrOtherInfo selectByAssetID(String otherID){
		YrOtherInfo yrOtherInfo=new YrOtherInfo();
		yrOtherInfo.setOtherID(otherID);
		return yrOtherInfoMapper.selectOne(yrOtherInfo);
	}
	   
}