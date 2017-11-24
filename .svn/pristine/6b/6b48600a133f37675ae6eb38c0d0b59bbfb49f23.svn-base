/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.copysend.mapper.CopySendMapper;
import com.icinfo.cs.copysend.service.ICopySendService;
import com.icinfo.cs.govguide.service.IGovguideService;
import com.icinfo.cs.inspect.service.IReportCheckInfoService;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.pbapp.service.impl.TokenManager;
import com.icinfo.cs.registinfo.service.IRegistInfoService;
import com.icinfo.cs.sccheck.dto.SccheckCount;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.secnocreditsup.mapper.ExpSeriousCrimeListMapper;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousPunishListService;
import com.icinfo.cs.secnocreditsup.service.impl.ExpSeriousCrimeListServiceImpl;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.yr.service.IModApplicationService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 描述:    cs_bulletins_read_record 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
@Service
public class RegIndexServiceImpl extends MyBatisServiceSupport implements IRegIndexService {
	
    private static final Logger logger =LoggerFactory.getLogger(RegIndexServiceImpl.class);

    @Autowired
    private IYrRegCheckService yrRegCheckService;
    @Autowired
    private IModApplicationService modApplicationService;
    @Autowired
    private IPubOpaDetailService pubOpaDetailService;
    @Autowired
    private IRegistInfoService registInfoService;
    @Autowired
    private IPubPbopanomalyService pubPbopanomalyService;
    @Autowired
    private IPubScPlanTaskService pubScPlanTaskService;
    @Autowired
    private IReportCheckInfoService reportCheckInfoService;
    @Autowired
    private IPubScentResultService pubScentResultService;
    @Autowired
    private IGovguideService govguideService;
    @Autowired
    private CopySendMapper copySendMapper;
    //严重违法主表
    @Autowired
    private IExpSeriousCrimeListService expSeriousCrimeListService;
    //处罚类严重违法
    @Autowired
    private IExpSeriousPunishListService expSeriousPunishListService;
    @Autowired
    private TokenManager tokenManager;
    /**
     * 协同系统里是否按照localAdm来过滤数据
     */
    private boolean baseLocalAdminWhenSyn=true;
    
    /**
     * 
     * 描述:首先获取当前用户redis缓存中的首页统计项
     * @auther gaojinling
     * @date 2017年3月21日 
     * @param userid
     * @param forBidmap（主要为添加操作权限字段）
     * @return
     * @throws Exception
     */
    public List<Integer> getRegCountList(String userid ,Map<String, Object> forBidmap,SysUserDto sysUserDto) throws Exception{
    	List<Integer> countList = new ArrayList<Integer>();	
        List<Integer> temList= tokenManager.getRegCountList(userid);
        if(temList != null && temList.size()>0){ //警示端统计缓存存在，从缓存中取值
        	countList = temList;
        }else{
        	countList = getCount(forBidmap,sysUserDto);
            tokenManager.setRegCountToken(userid, countList);  
        };
        return countList;
    }
    
    
    
   /**
    * 
    * 描述:从数据库中查找统计值
    * @auther gaojinling
    * @date 2017年3月21日 
    * @param forBidmap
    * @return
    * @throws Exception
    */
   public List<Integer> getCount(Map<String, Object> forBidmap,SysUserDto sysUser) throws Exception{
       List<Integer> countList = new ArrayList<Integer>();
	   //敏感词待审核条数 0
       int forbidCount = yrRegCheckService.selectForbidCount(forBidmap);
       //修改申请待审核条数 1
       int modCount = modApplicationService.selectModCount(forBidmap);
       countList.add(forbidCount);
       countList.add(modCount);
       //企业 2
       forBidmap.put("systemType", "1");
       //列入异常待审核
       int qyInCount = pubOpaDetailService.selectPubOpaInCount(forBidmap);
       //移出+撤销异常待审核
       int qyOutCount = pubOpaDetailService.selectPubOpaOutCount(forBidmap);
       //农专社 3
       forBidmap.put("systemType", "2");
       int nzInCount = pubOpaDetailService.selectPubOpaInCount(forBidmap);
       int nzOutCount = pubOpaDetailService.selectPubOpaOutCount(forBidmap);
       //个体户列入审核+移出审核 4
       int gtInCount = pubPbopanomalyService.selectInAduitCount(forBidmap);
       int gtOutCount = pubPbopanomalyService.selectOutAduitCount(forBidmap);
       countList.add(qyInCount+qyOutCount);
       countList.add(nzInCount+nzOutCount);
       countList.add(gtInCount+gtOutCount);
       //主体户口建档 5 6 7 
       //新用户建档
       int newRegistInfoCount = registInfoService.selectNewRegistInfoCount(forBidmap);
       //变更户建档
       int modRegistInfoCount = registInfoService.selectModRegistInfoCount(forBidmap);
       //待分配
       int altRegistInfoCount = registInfoService.selectAltRegistInfoCount(forBidmap);
       countList.add(newRegistInfoCount);
       countList.add(modRegistInfoCount);
       countList.add(altRegistInfoCount);
       //抽查检查  8 9 10 （业务不适合放入缓存,后续直接查询赋值）
       //检查人员待抽取
//       int toExtractCount  =pubScPlanTaskService.selectPubScPlanTaskToExtractCount(sysUser);
       //检查结果待录入,检查结果待审核
//       SccheckCount sccheckCount = pubScentResultService.selectSccheckCount(sysUser);
       //检查（补报核查项）
//       int noInput = reportCheckInfoService.selectNeedToInputCountForCheck(forBidmap); //待录入
//       int auditCount = reportCheckInfoService.selectNeedToAuditCountForCheck(forBidmap); //待审核
//       countList.add(toExtractCount);
//       countList.add(sccheckCount.getNotInputNum());
//       countList.add(sccheckCount.getToCheckNum());
       countList.add(10);
       countList.add(10);
       countList.add(10);
       //跟踪管理  11 12 （查询权限） 13
       Map<String, Object> searchMap = new HashMap<String, Object>();
       //加上对应的查询权限
       creatDefaultDBAuthEnv(searchMap,"RegOrg","LocalAdm",sysUser);
       //1.4.1行政指导待审核
       int govCount = govguideService.selectAduitGovCount(searchMap);
       //1.4.2责令整改待审核
       int orderCount = govguideService.selectAduitOrdCount(searchMap);
       //1.4.3抄告抄送待审核（权限已加，对应到当前部门）
       forBidmap.put("userType", sysUser.getUserType());
		if("1".equals(sysUser.getUserType())){//警示
			forBidmap.put("departCode", sysUser.getDeptCode());
		}else{//协同
			forBidmap.put("departCode", sysUser.getSysDepart().getAdcode());
			forBidmap.put("dutyDeptCodes", sysUser.getDutyDeptCodes());
		}
       int coprSendCount = copySendMapper.selectDaiShenHeNum(forBidmap);
       countList.add(govCount);
       countList.add(orderCount);
       countList.add(coprSendCount);
       //严重违法 14 15 16 (无权限)
		//异常类
		Map<String, Object> qryMap = new HashMap<String, Object>();
		//待申请
		int opaDsqCount = expSeriousCrimeListService.getDLRNum(qryMap);
		//待初审
		qryMap.put("businessStatus", "1");
		int opaDcsCount = expSeriousCrimeListService.getNumByBusinessStatus(qryMap);
		qryMap.put("businessStatus", "3");
		//待审核
		int opaDshCount = expSeriousCrimeListService.getNumByBusinessStatus(qryMap);
		//处罚类
		qryMap.clear();
		int crimeDsqCount = expSeriousPunishListService.applySrcTotal(qryMap);
		int crimeDcsCount = expSeriousPunishListService.applyFirstTotal();
		int crimeDshCount = expSeriousPunishListService.applyAuditTotal();
		countList.add(opaDsqCount+crimeDsqCount);
		countList.add(opaDcsCount+crimeDcsCount);
		countList.add(opaDshCount+crimeDshCount);
       return countList;
   }
   
    /**
     * 
     * 描述: 用于处理经营异常相关操作更新缓存（列入异常申请提交、移出申请提交 +1）
     * @auther gaojinling
     * @date 2017年3月22日 
     * @param userid 当前用户id reids缓存的key值
     * @param forBidmap 查询map（主要为操作权限）
     * @param entTypeCatg 用于区分异常操作数据为企业还是农专
     * @param operate 1 Add 列入异常申请提交、移出申请提交 +1  2 minus 列入（移出、撤销）申请删除、列入审核成功、移出（撤销）首次审核-1
     * @throws Exception
     */
	public void doRedisRegCount(String userid,Map<String, Object>  forBidmap ,String entTypeCatg,String operate,SysUserDto sysUserDto) throws Exception{
		//1.得到当前统计列表
		List<Integer> temList= tokenManager.getRegCountList(userid);
		List<Integer> countTepList = new ArrayList<Integer>();
		if(temList != null && temList.size() >0 ){ //缓存存在
		    countTepList.add(temList.get(0));  //敏感词审核
		    countTepList.add(temList.get(1)); //修改申请审核
		    	if("1".equals(operate)){//add 
					if("16".equals(entTypeCatg) || "17".equals(entTypeCatg)){ //农专社
				            countTepList.add(temList.get(2)); //企业异常待审核（包括列入待审核+移出待审核+撤销待审核）
				            countTepList.add(temList.get(3)+1); //农专异常待审核（包括列入待审核+移出待审核+撤销待审核）
				   }else{//企业
				            countTepList.add(temList.get(2)+1); //企业异常待审核（包括列入待审核+移出待审核+撤销待审核）
				            countTepList.add(temList.get(3)); //农专异常待审核（包括列入待审核+移出待审核+撤销待审核）
				   }
		    	}else{ //minus
					if("16".equals(entTypeCatg) || "17".equals(entTypeCatg)){ //农专社
			            countTepList.add(temList.get(2)); //企业异常待审核（包括列入待审核+移出待审核+撤销待审核）
			            countTepList.add(temList.get(3)-1); //农专异常待审核（包括列入待审核+移出待审核+撤销待审核）
				   }else{//企业
				            countTepList.add(temList.get(2)-1); //企业异常待审核（包括列入待审核+移出待审核+撤销待审核）
				            countTepList.add(temList.get(3)); //农专异常待审核（包括列入待审核+移出待审核+撤销待审核）
				   }
		    	}
		}else{ //缓存不存在,数据库取值
			countTepList = getCount(forBidmap,sysUserDto);
		}
		//2 重新设置缓存
		tokenManager.setRegCountToken(userid, countTepList);
	}
	
	/**
	 * 
	 * 描述: 修改缓存(直接加减)
	 * @auther gaojinling
	 * @date 2017年10月16日 
	 * @param userid 缓存id，即当前用户对应id 
	 * @param forBidmap 查询列表
	 * @param i 操作项对应缓存列表索引序号
	 * @param count 操作项缓存条数
	 * @param operate 操作：加1减2
	 * @throws Exception
	 */
	public void  doRedisRegcountAll(String userid,Map<String, Object>  forBidmap ,int i,int count,String operate,SysUserDto sysUser) throws Exception{
		//1.得到当前统计列表
		if(count >0){
			List<Integer> temList= tokenManager.getRegCountList(userid);
			List<Integer> countTepList = new ArrayList<Integer>();
			if(temList != null && temList.size() >0 ){ //缓存存在
				for(int j = 0;j<temList.size();j++){//循环当前缓存列表
					if(j==i){//操作项为当前取到项
						if("1".equals(operate)){//加
							countTepList.add(temList.get(j)+count);
						}else{//减
							countTepList.add(temList.get(j)-count);
						}
					}else{//操作项不为当前项，直接放入tempList
						countTepList.add(temList.get(j));
					}
				}
			}else{ //缓存不存在,数据库取值
				countTepList = getCount(forBidmap,sysUser);
			}
			//2 重新设置缓存
			tokenManager.setRegCountToken(userid, countTepList);
		}
	}
	
	/**
	 * 
	 * 描述: 修改缓存（直接查表修改单项）
	 * @auther gaojinling
	 * @date 2017年10月17日 
	 * @param userid 用户id
	 * @param forBidmap 操作对应的map
	 * @param i 修改项对象在list中的索引
	 * @param count 当前修改项的值
	 * @param sysUser 当前用户
	 * @throws Exception
	 */
	public void dodoRedisRegcountMod(String userid,Map<String, Object>  forBidmap ,int i,int count,SysUserDto sysUser) throws Exception{
		List<Integer> temList= tokenManager.getRegCountList(userid);
		List<Integer> countTepList = new ArrayList<Integer>();
		if(temList != null && temList.size() >0 ){ //缓存存在
			for(int j = 0;j<temList.size();j++){//循环当前缓存列表
				if(j==i){//操作项为当前取到项
					countTepList.add(count);
				}else{//操作项不为当前项，直接放入tempList
					countTepList.add(temList.get(j));
				}
			}
		}else{ //缓存不存在,数据库取值
			countTepList = getCount(forBidmap,sysUser);
		}
		//2 重新设置缓存
		tokenManager.setRegCountToken(userid, countTepList);
	}
	
	
    /**
     * 根据当前登录用户的所属层级、是否管理员、数据查询范围等条件来为其他业务查询创建查询条件（与查询权限相关的查询条件）
     * @author ZhuDefeng
     * @date 2016-12-05
     * @param param 查询参数
     * @param orgCodeFieldName (省市县)条件查询参数名（比如CheckDep）
     * @param locaAdminFieldName (管辖单位)条件查询参数名（比如LocalName）
     *
     */
    public void creatDefaultDBAuthEnv(Map<String,Object>  param,String orgCodeFieldName,String locaAdminFieldName,SysUserDto sysUserDto){
        try {
            putQueryFieldName(param, orgCodeFieldName);//添加数据库查询条件（字段名）
            String userLevel=sysUserDto.getUserVest(sysUserDto);
            String searchRange=sysUserDto.getSearchRangeLevel();
            if(userLevel.equals(DBAuthorConstants.USER_LEVEL_ADMIN)||
                    (searchRange.equals(DBAuthorConstants.USER_LEVEL_PROV)&&!StringUtil.equals(DBAuthorConstants.USER_SEARCH_RANGE_SELF_DEPT,searchRange))){
                //如果是省局(查询范围不是本部门)或者超级管理员 ，不加查询条件
            }
            if(searchRange.equals(DBAuthorConstants.USER_LEVEL_UNIT)){ //如果是管辖单位,需要用精准查询 LocalAdm=????????
                putQueryFieldName(param, locaAdminFieldName);
                putQueryFieldEqualVal(param,sysUserDto);
            }else{//模糊查询
                String fieldValue= getWhereSqlBySysUser("%",sysUserDto);//模糊查询值 比如3301%
                putQueryFieldLikeVal(param, fieldValue);
            }
            if(userLevel.equals(DBAuthorConstants.USER_LEVEL_COUNTRY)&&StringUtil.equals(sysUserDto.getUserType(),DBAuthorConstants.USER_TYPE_REG)){//如果是局级用户，则需要加上OR localAdm like xxxxxx%
                putLocalAdmLike(param,locaAdminFieldName,sysUserDto);
            }
            if(DBAuthorConstants.USER_TYPE_SYN.equals(sysUserDto.getUserType())&&isBaseLocalAdminWhenSyn()){
                putQueryFieldName(param, locaAdminFieldName);
            }
        }catch (Exception e){
            logger.error("构建默认的查询权限时候出现错误:"+e.getMessage());
        }
    }

    /**
     * 根据当前登录用户的所属层级、是否管理员、数据查询范围等条件来为其他业务查询创建查询条件（与操作权限相关的查询条件）
     * @author ZhuDefeng
     * @date 2016-12-05
     * @param param 查询参数
     * @param orgCodeFieldName (省市县)条件查询参数名（比如CheckDep）
     * @param locaAdminFieldName (管辖单位)条件查询参数名（比如LocalName）
     */
    public void creatOptDBAuthEnv(Map<String,Object>  param,String orgCodeFieldName,String locaAdminFieldName,SysUserDto sysUserDto){
        try{
            String userLevel=sysUserDto.getUserVest(sysUserDto);
            String searchRangeLevel=sysUserDto.getSearchRangeLevel();
            if(userLevel.equals(DBAuthorConstants.USER_LEVEL_ADMIN)){
                //如果是省局(查询范围不是本部门)或者超级管理员 ，不加查询条件
            }
            putQueryFieldName(param, orgCodeFieldName);
            putQueryFieldEqualVal(param,sysUserDto);
            if(searchRangeLevel.equals(DBAuthorConstants.USER_LEVEL_UNIT)){
                //如果是管辖单位，精准查询的条件字段要locaAdmin
                putQueryFieldName(param, locaAdminFieldName);
            }
            if(userLevel.equals(DBAuthorConstants.USER_LEVEL_COUNTRY)&&StringUtil.equals(sysUserDto.getUserType(),DBAuthorConstants.USER_TYPE_REG)){//如果是局级用户，则需要加上OR localAdm like xxxxxx%
                putLocalAdmLike(param,locaAdminFieldName,sysUserDto);
            }
            if(DBAuthorConstants.USER_TYPE_SYN.equals(sysUserDto.getUserType())&&isBaseLocalAdminWhenSyn()){
                putQueryFieldName(param, orgCodeFieldName);
            }
        }catch (Exception e){
            logger.error("构建默认的操作权限时候出现错误:"+e.getMessage());
        }
    }

    /**
     * 登记机关为市局，checkDep为分局或者所的查询条件<br/>
     * 情景描述：登记机关为市局，checkDep为市局，但是管辖单位却为市局下的分局或者所，分局或所也想要看到checkDep为市局的企业
     * @author ZhuDefeng
     * @date 2017-01-11
     * @param param
     * @param localAdmAlias
     */
    public void putLocalAdmLike(Map<String,Object> param, String localAdmAlias,SysUserDto sysUserDto){
        param.put(DBAuthorConstants.PARAM_NAME_LOCAL_ADM_ALIAS, localAdmAlias);
        param.put(DBAuthorConstants.PARAM_LIKE_VAL_LOCAL_ADM,getLeftOfDeptAdCode(6,sysUserDto)+"%");
    }



    /**
     * 获取添加数据权限时候传入的表别名
     * @author ZhuDefeng
     * @date 2017-01-11
     * @param param
     * @return
     */
    private String getTabAlias(Map<String,Object> param){
        if(!param.containsKey(DBAuthorConstants.PARAM_NAME_CHECK_DEP)){
            logger.error("追加默认的查询条件（登记状态）时出现异常~");
        }
        String defaultFieldName=param.get(DBAuthorConstants.PARAM_NAME_CHECK_DEP).toString();
        String[] arr=defaultFieldName.split("\\.");
        if(arr.length>1){
            return arr[0];
        }
        return null;
    }
    /**
     * 往PageRequest中添加查询条件（字段名）
     * @author ZhuDefeng
     * @date 2016-12-05
     * @param param 查询参数
     * @param fieldName 条件查询参数名
     */
    private void putQueryFieldName(Map<String,Object>  param, String fieldName){
        param.put(DBAuthorConstants.PARAM_NAME_CHECK_DEP,fieldName);
    }

    /**
     * 往PageRequest中添加查询参数值（模糊查询）
     * @author ZhuDefeng
     * @date 2016-12-05
     * @param param 查询参数
     * @param fieldValue 条件查询参数值
     */
    private void putQueryFieldLikeVal(Map<String,Object>  param, String fieldValue){
        param.put(DBAuthorConstants.PARAM_LIKE_VAL_CHECK_DEP,fieldValue);
    }
    /**
     * 往PageRequest中添加查询参数值（精准查询）
     * @author ZhuDefeng
     * @date 2016-12-05
     * @param param 查询参数
     */
    private void putQueryFieldEqualVal(Map<String,Object> param,SysUserDto sysUserDto){
        String deptCode= getLeftOfDeptAdCode(8,sysUserDto);
        if(StringUtil.equals(sysUserDto.getSearchRangeLevel(),DBAuthorConstants.USER_LEVEL_UNIT)){
            param.put(DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP,deptCode);
        }else{
            param.put(DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP,StringUtil.substring(deptCode,0,6));
        }
    }

    /**
     * 获取当前登录用户的管辖单位的前N位(前面？位)
     * @author ZhuDefeng
     * @date 2017-01-10
     * @return
     */
    public String getLeftOfDeptAdCode(int leftIndex,SysUserDto sysUserDto) {
        String deptCode="";
        if("1".equals(sysUserDto.getUserType()) || "3".equals(sysUserDto.getUserType())){
            deptCode= StringUtil.substring(sysUserDto.getDepartMent().getDeptCode(),0,leftIndex);
        }
        if("2".equals(sysUserDto.getUserType())){
            deptCode=StringUtil.substring(sysUserDto.getSysDepart().getAdcode(),0,leftIndex);
        }
        return deptCode;
    }


    /**
     * 根据当前登录用户来获取CheckDep查询条件
     * @author ZhuDefeng
     * @date 2016-10-05
     * @param conditionMark 查询条件通配符标识 *：ES形式；%：SQL形式
     * @return CheckDep查询条件
     */
    public String getWhereSqlBySysUser(String conditionMark,SysUserDto sysUserDto) {
        if("1".equals(sysUserDto.getUserType()) || "3".equals(sysUserDto.getUserType()) ){
//            return replaceByUserLevel(sysUserDto.getDepartMent().getDeptCode(),sysUserDto.getUserVest(sysUserDto),conditionMark);
            return replaceByUserLevel(sysUserDto.getDepartMent().getDeptCode(),sysUserDto.getSearchRangeLevel(),conditionMark);
        }
        if("2".equals(sysUserDto.getUserType())){
//            return replaceByUserLevel(sysUserDto.getSysDepart().getAdcode(),sysUserDto.getUserVest(sysUserDto),conditionMark);
            return replaceByUserLevel(sysUserDto.getSysDepart().getAdcode(),sysUserDto.getSearchRangeLevel(),conditionMark);
        }
        if("3".equals(sysUserDto.getUserType())){
//          return replaceByUserLevel(sysUserDto.getSysDepart().getAdcode(),sysUserDto.getUserVest(sysUserDto),conditionMark);
        	return replaceByUserLevel(sysUserDto.getSysDepart().getAdcode(),sysUserDto.getSearchRangeLevel(),conditionMark);
      }
        return null;
    }

    /**
     * 根据用户所属层级(查询范围)来拼装查询条件
     * @author ZhuDefeng
     * @date 2016-10-05
     * @param deptCode
     * @param userLevel
     * @param conditionMark
     * @return
     */
    public String replaceByUserLevel(String deptCode,String userLevel,String conditionMark){
        if(StringUtil.isBlank(deptCode))return "";
        StringBuffer adCodeTmp=new StringBuffer(deptCode.substring(0,deptCode.length()));
        if(userLevel.equals(DBAuthorConstants.USER_LEVEL_PROV)||userLevel.equals(DBAuthorConstants.USER_LEVEL_ADMIN)){
            return null;
        }
        if(userLevel.equals(DBAuthorConstants.USER_LEVEL_CITY)){
            return adCodeTmp.replace(4,deptCode.length(),"").append(conditionMark).toString();
        }
        if(userLevel.equals(DBAuthorConstants.USER_LEVEL_COUNTRY)){
            return adCodeTmp.replace(6,deptCode.length(),"").append(conditionMark).toString();
        }
        if(userLevel.equals(DBAuthorConstants.USER_LEVEL_UNIT)){
            return adCodeTmp.append(conditionMark).toString();
        }
        return deptCode+conditionMark;
    }
    
    /**
     * 获取查询权限时需要的环境参数【协同系统里是否按照localAdm来过滤数据】
     * @author ZhuDefeng
     * @date 2017-01-22
     * @return
     */
    public boolean isBaseLocalAdminWhenSyn() {
        return baseLocalAdminWhenSyn;
    }

	
	
    
    
   
}