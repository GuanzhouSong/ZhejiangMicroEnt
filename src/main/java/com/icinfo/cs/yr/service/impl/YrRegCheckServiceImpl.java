/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogTables;
import com.icinfo.cs.common.constant.OperationTypes;
import com.icinfo.cs.common.constant.ReportStatusEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.ObjectComparator;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.message.service.ICsMessageService;
import com.icinfo.cs.system.model.SysLogJsonItem;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.dto.YrRegCheckDto;
import com.icinfo.cs.yr.mapper.YrRegCheckMapper;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_reg_check 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class YrRegCheckServiceImpl extends MyBatisServiceSupport implements IYrRegCheckService {
	
	@Autowired
	IPanoramaSearchService panoramaSearchService;
    @Autowired
    YrRegCheckMapper yrRegCheckMapper;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IEsManageService esManageService;
	
 @Autowired
 private IPubEppasswordService pubEppasswordService;
 @Autowired
 private ICsMessageService csMessageService;
 @Value("${webDomain}")
 private String webDomain;
	
	private Map<String, Object> countMap;
	
	

    /**
     * 无条件查询
     * @param request
     * @return
     */
    @Override
    public List<YrRegCheck> queryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return yrRegCheckMapper.selectAll();
    }

    /**
     * 条件查询
     * @param request
     * @return
     */
    @Override
    public List<YrRegCheck> search_queryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return yrRegCheckMapper.search_queryPage(request.getParams());
    }

	/** 
	 * 描述: 登录时获取企业已有年报主表数据
	 * @auther ZhouYan
	 * @date 2016年8月30日 
	 * @param pripid
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<YrRegCheck> doGetYrRegCheckInit(String pripid) throws Exception {
		Example example = new Example(YrRegCheck.class);
        example.createCriteria().andEqualTo("priPID", pripid);
        example.setOrderByClause("year desc");
        List<YrRegCheck> list = yrRegCheckMapper.selectByExample(example);
        return list;
	}

	/** 
	 * 描述: 初始化年报主表数据
	 * @auther ZhouYan
	 * @date 2016年8月30日 
	 * @param pripid
	 * @param year
	 * @throws Exception 
	 */
	@Override
	public void doInitYrRegCheck(String pripid, Integer year) throws Exception {
		//年报主表
		YrRegCheck yrRegCheck = new YrRegCheck();
		//企业核准表数据
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pripid);
		if(midBaseInfo!=null){
			yrRegCheck.setPriPID(midBaseInfo.getPriPID());
			yrRegCheck.setEntName(midBaseInfo.getEntName());
			yrRegCheck.setRegNO(midBaseInfo.getRegNO());
			yrRegCheck.setDom(midBaseInfo.getDom());
			yrRegCheck.setLeRep(midBaseInfo.getLeRep());
			yrRegCheck.setRegCap(midBaseInfo.getRegCap());
			yrRegCheck.setCurrency(midBaseInfo.getCurrency());
			yrRegCheck.setEntType(midBaseInfo.getEntType());
			yrRegCheck.setEstDate(midBaseInfo.getEstDate());
			yrRegCheck.setIndustryCo(midBaseInfo.getIndustryCo());
			yrRegCheck.setRegOrg(midBaseInfo.getRegOrg());
			yrRegCheck.setLocalAdm(midBaseInfo.getLocalAdm());
			yrRegCheck.setRegState(midBaseInfo.getRegState());
			yrRegCheck.setPostalCode(midBaseInfo.getPostalCode());
			yrRegCheck.setEntTypeCatg(midBaseInfo.getEntTypeCatg());
			yrRegCheck.setUniCode(midBaseInfo.getUniCode());
			yrRegCheck.setTel(midBaseInfo.getTel());
			yrRegCheck.setYear(year);
			yrRegCheck.setCreateTime(midBaseInfo.getCreateTime());
			yrRegCheck.setCheckDep(midBaseInfo.getRegOrg());
			yrRegCheck.setSliceNo(midBaseInfo.getSliceNO());
			if(Constants.entTypeCatgSFC.indexOf(midBaseInfo.getEntTypeCatg()) != -1) {
				yrRegCheck.setDeclStatus("0");//农专需要初始化综合信息状态
			}
			yrRegCheck.setReportState("00");
			yrRegCheck.setRepType(midBaseInfo.getEntTypeCatg());
			yrRegCheck.setIsReported("0");
			yrRegCheck.setIsForbidWord("0");
			yrRegCheck.setModifyCount(0);
		}
		yrRegCheckMapper.insert(yrRegCheck);
		//yrRegCheckMapper.initYrRegCheck(pripid, year);
	}
	
	/** 
     * 描述: 工商端查询年报主表数据（作为敏感词审核列表数据）
     * @auther yujingwei
     * @date 2016年8月30日 
     * @param request
     * @throws Exception 
     */
	@Override
	public List<YrRegCheckDto> queryPageForForbidResult(PageRequest request) throws Exception{
		 PageHelper.startPage(request.getPageNum(), request.getLength());
	     return yrRegCheckMapper.queryPageForForbidResult(request.getParams());
	}
	
	/** 
     * 描述: 查询年报信息
     * @auther yujingwei
     * @date 2016年8月30日 
     * @param priPID,year
     * @throws Exception 
     */
	public YrRegCheck selectCheckInfoByPripidAndYear(String priPID, Integer year) throws Exception{
		if(StringUtil.isNotEmpty(priPID)&&year!=null){
			YrRegCheck yrRegCheck = new YrRegCheck();
			yrRegCheck.setPriPID(priPID);
			yrRegCheck.setYear(year);
			return yrRegCheckMapper.selectOne(yrRegCheck);
		}
		return null;

	}

	/** 
	 * 描述: 提交年报时更新主表信息
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @param pripid
	 * @param year
	 * @param loginType
	 * @param subIp
	 * @param isForbid
	 * @throws Exception 
	 */
	@Override
	public void updateYrRegCheck(String pripid, Integer year, String loginType,
			String subIp, boolean isForbid, Date curDate) throws Exception {
		Map<String,Object> jsonMap = new HashMap<String,Object>(); //索引map
		YrRegCheck yrRegCheck = this.selectCheckInfoByPripidAndYear(pripid, year);
		YrRegCheck yrRegCheckTemp = new YrRegCheck();
		yrRegCheckTemp.setId(yrRegCheck.getId());
        yrRegCheckTemp.setCreateTime(curDate);
        /* a.首次提交时，设置首次报送日期及年度报告状态，修改次数不变；再次提交时，修改次数+1：
         * 已年报：首次提交年报在6月30日前且当前年报未涉及敏感词审核不通过情况
         * 已年报（逾期）：首次提交年报在6月30日后
         */
        if (yrRegCheck.getFirstReportTime() == null) {
        	yrRegCheckTemp.setFirstReportTime(curDate);
        	jsonMap.put("yrFirRepTime" + year, DateUtil.dateToString(curDate, "yyyy-MM-dd")); // 索引：首次报送时间
        	Date endDate = DateUtil.stringToDate((yrRegCheck.getYear() + 1) + "-06-30 23:59:59", "yyyy-MM-dd HH:mm:ss");
        	if(curDate.before(endDate)){
        		yrRegCheckTemp.setIsReported(ReportStatusEnum.IsReportedYes.getStatusCode());
        	}else{
        		yrRegCheckTemp.setIsReported(ReportStatusEnum.IsReportedOverdue.getStatusCode());
        	}
        	jsonMap.put("yrIsRep" + year, yrRegCheckTemp.getIsReported()); // 索引：年度报告状态
        }else{
        	yrRegCheckTemp.setModifyCount(yrRegCheck.getModifyCount() + 1);
        	jsonMap.put("yrRepModify" + year, "Y"); // 索引：是否修改过年报
        }
        // b.设置最近年报时间
        yrRegCheckTemp.setLastReportTime(curDate);
        jsonMap.put("yrRecRepTime" + year, DateUtil.dateToString(curDate, "yyyy-MM-dd")); // 索引：最近报送时间
        // c.设置年报公示状态（当前年报状态）
        if(isForbid){
        	yrRegCheckTemp.setReportState(ReportStatusEnum.ReportStateForbidAuditing.getStatusCode());
    	}else{
    		yrRegCheckTemp.setReportState(ReportStatusEnum.ReportStateYes.getStatusCode());
    	}
        jsonMap.put("yrRepState" + year, yrRegCheckTemp.getReportState()); // 索引：当前年报状态
        // d.只记录首次提交方式
        if(yrRegCheck.getReportType() == null){
        	yrRegCheckTemp.setReportType(loginType);
        	jsonMap.put("yrRepMode" + year, loginType); // 索引：报送方式
        }
        // e.提交IP
        yrRegCheckTemp.setSubIp(subIp);
        yrRegCheckMapper.updateByPrimaryKeySelective(yrRegCheckTemp);
        
        // f.更新索引
        jsonMap.put("priPID", pripid); // 索引：内部序号
//		panoramaSearchService.updatePanoramaIdx(jsonMap);
		esManageService.updateOnePanoramaIdx(pripid);
		
		String isReport = yrRegCheck.getIsReported ();
		if("0".equals (isReport)){
		    
		}
		 
		  //调用手机端接口并推送信息给手机端
		  PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid (pripid);
		  String tel = pubEppassword.getTel ();
		  String entName = pubEppassword.getEntname ();
		
		  String json = "{\"title\" : \"企业工商年报提醒\", "+
		          "\"pusher\" : \"国家企业信用信息公示系统\", "+
		          "\"receiver\" : \"${tel}\","+                
		          "\"sourceUrl\" : \"${url}\","+
		          "\"type\" : \"03\","+
		          "\"midType\" : \"03001\","+
		          "\"subType\" : \"03001004\","+
		          "\"content\" : \"${content}\","+
		          "\"additionInfo\" : {"+
		          "\"备注\" : \"\","+
		         /* "\"发送日期\" : \""+DateUtil.getCurrentDate()+"\","+*/
		          "\"年报状态\" : \"${reportType}\"  "+
		          "},"+
		          "\"pushChannels\" : \"1,2\""+
		          "}";
		  
		  String newJson = json.replace ("${tel}", tel).
		  replace ("${url}", webDomain+"/reg/message/toMessageReportView?year="+DateUtil.getPreYear ()+"&isreported=1&msgSource=wx&msgReadTel="+tel+"&sendDate="+DateUtil.getDate ("yyyyMMdd")).
		  replace ("${content}", "您担任工商联络员的"+entName+"已报送并公示"+DateUtil.getPreYear ()+"年度企业年报。")
		  .replace ("${reportType}", "已年报");
		  
		  csMessageService.sendPOSTRequest (newJson, tel);
	}
	
	/** 
	 * 描述: 年报修改申请同意
	 * @auther chenxin
	 * @date 2016年9月19日 
	 * @param pripid
	 * @param year
	 * @param logCollector
	 * @throws Exception 
	 */
	@Override
	public boolean doAddLog4UpdateYrRegCheckState(String pripid, Integer year,List<SysLogTable> logCollector) throws Exception {
		YrRegCheck yrRegCheck = new YrRegCheck();
		yrRegCheck.setPriPID(pripid);
		yrRegCheck.setYear(year);
		YrRegCheck yrRegCheckReult = yrRegCheckMapper.selectOne(yrRegCheck);
		YrRegCheck yrRegCheckUpdate = new YrRegCheck();
		yrRegCheckUpdate.setId(yrRegCheckReult.getId());
		yrRegCheckUpdate.setReportState(ReportStatusEnum.ReportStateModify.getStatusCode());
		if(doAddLog4ModYrRegCheck(yrRegCheckUpdate, logCollector)){
			if(yrRegCheckMapper.updateByPrimaryKeySelective(yrRegCheckUpdate) > 0){
				Map<String,Object> jsonMap = new HashMap<String,Object>(); //索引map
	        	jsonMap.put("priPID", pripid); // 索引：内部序号
	        	jsonMap.put("yrRepState" + year, yrRegCheckUpdate.getReportState()); // 索引：当前年报状态
	        	// f.更新索引
//	    		panoramaSearchService.updatePanoramaIdx(jsonMap);
				//更新索引
				esManageService.updateOnePanoramaIdx(pripid);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 年报主表修改添加日志
	 * @auther chenxin
	 * @date 2016年9月18日 
	 * @param yrRegCheck 新数据
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4ModYrRegCheck(YrRegCheck yrRegCheck,List<SysLogTable> logCollector) throws Exception {
		if(yrRegCheck != null && yrRegCheck.getId() != null){
			YrRegCheck yrRegCheckparam = new YrRegCheck();
			yrRegCheckparam.setId(yrRegCheck.getId());
			YrRegCheck dbYrRegCheck = yrRegCheckMapper.selectOne(yrRegCheckparam);
			List<SysLogJsonItem> logJsonItemList = ObjectComparator.compareObject(dbYrRegCheck, yrRegCheck);
			SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_YR_REG_CHECK.getCode(), logJsonItemList, null, OperationTypes.UPDATE.getCode());	
			if(logTable!=null){
				logCollector.add(logTable);
    		} 
			return true;
		}
    	return false;
	}

	/**
	 * 
	 * 描述: 个体户接收列表查询
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<YrRegCheck> selectPbReceiveQueryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return yrRegCheckMapper.selectPbReceiveQueryPage(request.getParams());
	}

	/**
	 * 
	 * 描述: 更新（通过主体代码和年份）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param yrRegCheck
	 * @return
	 * @throws Exception
	 */
	public int updateYrRegCheckByPriPIdAndYear(YrRegCheck yrRegCheck) throws Exception {
		yrRegCheck.setCreateTime(new Date());
		Example example = new Example(YrRegCheck.class);
        example.createCriteria().andEqualTo("priPID", yrRegCheck.getPriPID().toString()).andEqualTo("year", yrRegCheck.getYear());
		return yrRegCheckMapper.updateByExampleSelective(yrRegCheck, example);
	}
	
	/**
	 * 
	 * 描述: 查询已经用电子方式提交过个体户年报的个数
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param priPID
	 * @return
	 */
	public int selectCountIsReportByParper(String priPID) throws Exception{
		Example example = new Example(YrRegCheck.class);
        example.createCriteria().andEqualTo("priPID", priPID).
        andNotEqualTo("reportType", Constants.LOGIN_TYPE_PAPER).     //设置报告方式为纸质年报
        andNotEqualTo("isReported", '0');  //设置为已年报
		return yrRegCheckMapper.selectCountByExample(example) ;
	}

	/** 
	 * 描述: 修改年度报告：修改主表状态
	 * @auther ZhouYan
	 * @date 2016年9月21日 
	 * @param pripid
	 * @param year
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int modYearReport(String pripid, Integer year) throws Exception {
		YrRegCheck yrRegCheck = new YrRegCheck();
		yrRegCheck.setReportState(ReportStatusEnum.ReportStateModify.getStatusCode());
		yrRegCheck.setCreateTime(new Date());
		Example example = new Example(YrRegCheck.class);
        example.createCriteria().andEqualTo(Constants.CS_PRIPID, pripid).andEqualTo(Constants.CS_YEAR, year);
        int i = yrRegCheckMapper.updateByExampleSelective(yrRegCheck, example);
        if(i > 0) {
        	Map<String,Object> jsonMap = new HashMap<String,Object>(); //索引map
        	jsonMap.put("priPID", pripid); // 索引：内部序号
        	jsonMap.put("yrRepState" + year, yrRegCheck.getReportState()); // 索引：当前年报状态
        	// f.更新索引
//    		panoramaSearchService.updatePanoramaIdx(jsonMap);
    		esManageService.updateOnePanoramaIdx(pripid);	
        }
		return i;
	}

	 /**
     * 
     * 描述   根据部门类型（农业、农信、工商查询待审核和意见录入的信息）
     * @author 赵祥江
     * @date 2016年11月29日 下午1:43:16 
     * @param 
     * @return List<YrRegCheckDto>
     * @throws
     */
	@Override
	public List<YrRegCheckDto> comInfoCheckDtoListJSON(PageRequest request)
			throws Exception {
		 PageHelper.startPage(request.getPageNum(), request.getLength());
	     return yrRegCheckMapper.selectcomInfoCheckDtoList(request.getParams());
	}

	/**
	 * 根据年份和身份主体代码更新 农专年报中的辅助报表的 年报状态：declStatus
	 * @param year
	 * @param priPID
	 * @return
	 */
	@Override
	public int updateYrRegCheckDeclStatus(Integer year, String priPID) {
		YrRegCheck yrRegCheck = new YrRegCheck();
		yrRegCheck.setDeclStatus("1");
		Example example = new Example(YrRegCheck.class);
		example.createCriteria().andEqualTo("priPID", priPID).andEqualTo("year",year);
		return yrRegCheckMapper.updateByExampleSelective(yrRegCheck, example);
	}

	@Override
	public List<YrRegCheck> selectByRegNoOrName(String regNO, String entName) {
	   Example example=new Example(YrRegCheck.class);
	   Criteria criteria=example.createCriteria(); 
	   criteria.andEqualTo("regNO",regNO);  
	 /*  Criteria criteria2=  example.createCriteria();
	   criteria2.andEqualTo("uniCode",regNO);
	   example.or(criteria2);
	   */
		return yrRegCheckMapper.selectByExample(example);
	}

	@Override
	public List<YrRegCheck> selectByRegNoAndName(PageRequest request) { 
		return yrRegCheckMapper.selectByRegNoAndName(request.getParams());
	}

	@Override
	public int updatePriPIdForDataReturn(String priPID, String oldPriPId) {
		Example example=new Example(YrRegCheck.class);
		example.createCriteria().andEqualTo("priPID",oldPriPId);
		YrRegCheck yrRegCheck = new YrRegCheck(); 
		yrRegCheck.setPriPID(priPID);
		
		return yrRegCheckMapper.updateByExampleSelective(yrRegCheck, example);
	}
	
	
	/**
	 * 
	 * 描述: 个体户纸质报告补录查询
	 * @auther gaojinling
	 * @date 2017年3月8日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<YrRegCheck> selectPbAddRecQueryPage(PageRequest request) throws Exception {
		Map<String, Object> map = request.getParams();
		map.put("regStateM", StringUtil.doSplitStringToSqlFormat(map.get("regStateM").toString(),","));
		int pageSize = request.getLength();
		map.put("numStart", request.getStart());
		map.put("pageSize", pageSize);
		//清空全局变量
		if(countMap != null){
			countMap.clear();
		}
		countMap = map;
//		PageHelper.startPage(request.getPageNum(), request.getLength());
		return yrRegCheckMapper.selectPbAddRecQueryPage(map);
	}
	
	
	/**
	 * 
	 * 描述:纸质补录条数
	 * @auther gaojinling
	 * @date 2017年3月16日 
	 * @return
	 * @throws Exception
	 */
	public Integer selectPbAddRecCount()
			throws Exception {
		try {
			return yrRegCheckMapper.selectPbAddRecCount(countMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("个体户纸质补录 分页条数查询失败!");
		}
	}
	
	
	/**
	 * 
	 * 描述: 年报敏感词审核条数（警示端首页）
	 * @auther gaojinling
	 * @date 2017年3月17日 
	 * @param map
	 * @return
	 */
	public Integer selectForbidCount(Map<String, Object> map) throws Exception {
		try {
			return yrRegCheckMapper.selectForbidCount(map);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("年报修改申请分页条数查询失败!");
		}
	}

}