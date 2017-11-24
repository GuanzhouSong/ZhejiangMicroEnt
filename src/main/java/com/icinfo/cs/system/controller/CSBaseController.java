package com.icinfo.cs.system.controller;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：增加创建数据权限相关的查询条件
 * @author ZhuDefeng
 * @date 2016-12-5
 */
public class CSBaseController extends BaseController {

    private static final Logger logger =LoggerFactory.getLogger(CSBaseController.class);

    /**
     * 登记状态为存续的值（用户IN查询）
     */
    public  String REG_STATE_VAL_SUBSIST="'K','B','A','DA'";

    /**
     * 登记状态属性名
     */
    public  String REG_STATE_FIELD_NAME="RegState";

    /**
     * 协同系统里是否按照localAdm来过滤数据
     */
    private boolean baseLocalAdminWhenSyn=true;
   
    
    /**
     * 根据当前登录用户的所属层级、是否管理员、数据查询范围等条件来为其他业务查询创建查询条件（与查询权限相关的查询条件）
     * @author ZhuDefeng
     * @date 2016-12-05
     * @param pageRequest 查询参数
     * @param orgCodeFieldName (省市县)条件查询参数名（比如CheckDep）
     * @param locaAdminFieldName (管辖单位)条件查询参数名（比如LocalName）
     *
     */
    public CSBaseController creatDefaultDBAuthEnv(PageRequest pageRequest,String orgCodeFieldName,String locaAdminFieldName){
        return creatDefaultDBAuthEnv(getRequestParam(pageRequest),orgCodeFieldName,locaAdminFieldName);
    }
    /**
     * 根据当前登录用户的所属层级、是否管理员、数据查询范围等条件来为其他业务查询创建查询条件（与操作权限相关的查询条件）
     * @author ZhuDefeng
     * @date 2016-12-05
     * @param pageRequest 查询参数
     * @param orgCodeFieldName (省市县)条件查询参数名（比如CheckDep）
     * @param locaAdminFieldName (管辖单位)条件查询参数名（比如LocalName）
     */
    public CSBaseController creatOptDBAuthEnv(PageRequest pageRequest, String orgCodeFieldName,String locaAdminFieldName){
        return creatOptDBAuthEnv(getRequestParam(pageRequest),orgCodeFieldName,locaAdminFieldName);
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
    public CSBaseController creatDefaultDBAuthEnv(Map<String,Object>  param,String orgCodeFieldName,String locaAdminFieldName){
        try {
            putQueryFieldName(param, orgCodeFieldName);//添加数据库查询条件（字段名）
            SysUserDto sysUserDto=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
            String userLevel=sysUserDto.getUserVest(sysUserDto);
            String searchRange=sysUserDto.getSearchRangeLevel();
            if(userLevel.equals(DBAuthorConstants.USER_LEVEL_ADMIN)||
                    (searchRange.equals(DBAuthorConstants.USER_LEVEL_PROV)&&!StringUtil.equals(DBAuthorConstants.USER_SEARCH_RANGE_SELF_DEPT,searchRange))){
                //如果是省局(查询范围不是本部门)或者超级管理员 ，不加查询条件
                return this;
            }
            if(searchRange.equals(DBAuthorConstants.USER_LEVEL_UNIT)){ //如果是管辖单位,需要用精准查询 LocalAdm=????????
                putQueryFieldName(param, locaAdminFieldName);
                putQueryFieldEqualVal(param);
            }else{//模糊查询
                String fieldValue= getWhereSqlBySysUser("%");//模糊查询值 比如3301%
                putQueryFieldLikeVal(param, fieldValue);
            }
            if(userLevel.equals(DBAuthorConstants.USER_LEVEL_COUNTRY)&&(StringUtil.equals(sysUserDto.getUserType(),DBAuthorConstants.USER_TYPE_REG) || StringUtil.equals(sysUserDto.getUserType(),DBAuthorConstants.USER_TYPE_SMENT) )){//如果是局级用户，则需要加上OR localAdm like xxxxxx%
                putLocalAdmLike(param,locaAdminFieldName);
            }
//            addDefaultRegStateParam(param,REG_STATE_FIELD_NAME,REG_STATE_VAL_SUBSIST);
            if(DBAuthorConstants.USER_TYPE_SYN.equals(sysUserDto.getUserType())&&isBaseLocalAdminWhenSyn()){
                putQueryFieldName(param, locaAdminFieldName);
            }
        }catch (Exception e){
            logger.error("构建默认的查询权限时候出现错误:"+e.getMessage());
        }
        return this;
    }

    /**
     * 根据当前登录用户的所属层级、是否管理员、数据查询范围等条件来为其他业务查询创建查询条件（与操作权限相关的查询条件）
     * @author ZhuDefeng
     * @date 2016-12-05
     * @param param 查询参数
     * @param orgCodeFieldName (省市县)条件查询参数名（比如CheckDep）
     * @param locaAdminFieldName (管辖单位)条件查询参数名（比如LocalName）
     */
    public CSBaseController creatOptDBAuthEnv(Map<String,Object>  param,String orgCodeFieldName,String locaAdminFieldName){
        try{
            SysUserDto sysUserDto=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
            String userLevel=sysUserDto.getUserVest(sysUserDto);
            String searchRangeLevel=sysUserDto.getSearchRangeLevel();
            if(userLevel.equals(DBAuthorConstants.USER_LEVEL_ADMIN)){
                //如果是省局(查询范围不是本部门)或者超级管理员 ，不加查询条件
                return this;
            }
            putQueryFieldName(param, orgCodeFieldName);
            putQueryFieldEqualVal(param);
            if(searchRangeLevel.equals(DBAuthorConstants.USER_LEVEL_UNIT)){
                //如果是管辖单位，精准查询的条件字段要locaAdmin
                putQueryFieldName(param, locaAdminFieldName);
            }
            if(userLevel.equals(DBAuthorConstants.USER_LEVEL_COUNTRY)&&(StringUtil.equals(sysUserDto.getUserType(),DBAuthorConstants.USER_TYPE_REG)||StringUtil.equals(sysUserDto.getUserType(),DBAuthorConstants.USER_TYPE_SMENT))){//如果是局级用户，则需要加上OR localAdm like xxxxxx%
                putLocalAdmLike(param,locaAdminFieldName);
            }
            if(DBAuthorConstants.USER_TYPE_SYN.equals(sysUserDto.getUserType())&&isBaseLocalAdminWhenSyn()){
                putQueryFieldName(param, orgCodeFieldName);
            }
//            addDefaultRegStateParam(param,REG_STATE_FIELD_NAME,REG_STATE_VAL_SUBSIST);
        }catch (Exception e){
            logger.error("构建默认的操作权限时候出现错误:"+e.getMessage());
        }
        return this;
    }

    /**
     * 登记机关为市局，checkDep为分局或者所的查询条件<br/>
     * 情景描述：登记机关为市局，checkDep为市局，但是管辖单位却为市局下的分局或者所，分局或所也想要看到checkDep为市局的企业
     * @author ZhuDefeng
     * @date 2017-01-11
     * @param param
     * @param localAdmAlias
     */
    public void putLocalAdmLike(Map<String,Object> param, String localAdmAlias){
        param.put(DBAuthorConstants.PARAM_NAME_LOCAL_ADM_ALIAS, localAdmAlias);
        param.put(DBAuthorConstants.PARAM_LIKE_VAL_LOCAL_ADM,getLeftOfDeptAdCode(6)+"%");
    }

    /**
     * 添加默认的存续状态查询条件（in查询）
     * @param param
     * @param regStateFieldName
     * @param regStatesVal
     * @return
     */
    private void addDefaultRegStateParam(Map<String,Object> param, String regStateFieldName, String regStatesVal){
        String tabAlias=getTabAlias(param);
        if(tabAlias!=null){
            regStateFieldName =tabAlias+"."+ regStateFieldName;
        }
        param.put(DBAuthorConstants.PARAM_NAME_REG_STATE, regStateFieldName);
        param.put(DBAuthorConstants.PARAM_NAME_REG_STATE_IN_VALUE,REG_STATE_VAL_SUBSIST);
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
    private void putQueryFieldEqualVal(Map<String,Object> param){
        SysUserDto sysUserDto=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
        String deptCode= getLeftOfDeptAdCode(8);
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
    public String getLeftOfDeptAdCode(int leftIndex) {
        SysUserDto sysUserDto=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
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
     * 获取PageRequest中的Map
     * @author ZhuDefeng
     * @date 2016-12-05
     * @param pageRequest 查询参数
     */
    public Map<String,Object> getRequestParam(PageRequest pageRequest){
        if(pageRequest.getParams()==null){
            Map<String,Object> qryMap=new HashMap<>();
            pageRequest.setParams(qryMap);
        }
        return pageRequest.getParams();
    }


    /**
     * 根据当前登录用户来获取CheckDep查询条件
     * @author ZhuDefeng
     * @date 2016-10-05
     * @param conditionMark 查询条件通配符标识 *：ES形式；%：SQL形式
     * @return CheckDep查询条件
     */
    public String getWhereSqlBySysUser(String conditionMark) {
        SysUserDto sysUserDto=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
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

    public String getWhereValBySysUser(String conditionMark){
        SysUserDto sysUser=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
        return replaceByUserLevel(getCodeByUserType(sysUser),sysUser.getSearchRangeLevel(),conditionMark);
    }
    /**
     * 根据用户类型返回行政编码或者部门编码
     * @author zjj
     */
    public String getCodeByUserType(SysUserDto sysUser){
        if("2".equals(sysUser.getUserType()))
            return sysUser.getSysDepart().getAdcode();
        else
            return sysUser.getDeptCode();
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

    /**
     * 构造查询权限时需要的环境参数【协同系统里是否按照localAdm来过滤数据】
     * @author ZhuDefeng
     * @date 2017-01-22
     * @param baseLocalAdminWhenSyn
     * @return
     */
    public CSBaseController buildDBEnv_baseLocalAdminWhenSyn(boolean baseLocalAdminWhenSyn) {
        this.baseLocalAdminWhenSyn = baseLocalAdminWhenSyn;
        return this;
    }
    /**
     * ws服务器端请求参数组装
     * @author ylr
     * @param req
     * @return
     */
    public Map<String,Object> doWrapperMapParam(HttpServletRequest req){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("startdate",req.getParameter("startdate"));
        paramMap.put("enddate",req.getParameter("enddate"));
        paramMap.put("startNum",req.getParameter("startNum"));
        paramMap.put("endNum",req.getParameter("endNum"));
        paramMap.put("pageSize",req.getParameter("pageSize"));
        return paramMap;
    }
    
    /**
     * 
     * 描述:查询警示系统登录用户对应的登记机关编码
     * @auther gaojinling
     * @date 2017年7月3日 
     * @param sysUser
     * @return
     */
    public String selectRegorgByDeptCode(SysUserDto sysUser){
//    	if("1".equals(sysUser.getIsAdmin())){//如果是管理员
//    		return "0000";
//    	}
		String regOrg= sysUser.getDepartMent().getDeptCode().length() > 5 ? sysUser.getDepartMent().getDeptCode().substring(0,6) : "0000";
		//省局直属分局特殊处理
		if("330010".equals(regOrg)){
			regOrg = "330000";
		}
		//丽水市市场监督管理局开发区分局特殊处理
		if(sysUser.getDepartMent().getDeptCode().length() > 5 && "33250103".equals(sysUser.getDepartMent().getDeptCode())){
			regOrg = "332500";
		}
		return regOrg;
    }
    
	/**
	 * 描述: 获取权限级别
	 * @return String
	 */
	public String getLimitReg(){
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		String level = sysUser.getUserVest(sysUser);
		String isAdmin = sysUser.getIsAdmin(); 
        //1：本所 2：本局3：本市 4：本省   0 管理员
		if((StringUtils.isNotBlank(isAdmin) && "1".equals(isAdmin)) 
				|| (StringUtils.equalsIgnoreCase(level, "4")
			    ||  StringUtils.isBlank(level))){
			return "";
		}
		if (StringUtils.equalsIgnoreCase(level, "1")||StringUtils.isBlank(level)) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 8);
		}
		if (StringUtils.equalsIgnoreCase(level, "2")) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 6);
		}
		if (StringUtils.equalsIgnoreCase(level, "3")) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 4);
		} 
		return null;
	}
	
	/**
	 * 描述：设置默认职能部门参数
	 * @author chenxin
	 * @date 2017-10-12
	 * @param sysUser
	 * @param queryMap
	 */
	public void setCheckDefaultParams(SysUserDto sysUser,Map<String,Object>	queryMap){
		//职能部门编码
		if("1".equals(sysUser.getUserType())){
			queryMap.put("dutyDeptCodes","A058,A012,A027");
		}else if("2".equals(sysUser.getUserType())){
			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes()) && ("A058".indexOf(sysUser.getDutyDeptCodes()) != -1
					 || "A012".indexOf(sysUser.getDutyDeptCodes()) != -1
					 || "A027".indexOf(sysUser.getDutyDeptCodes()) != -1)){
				queryMap.put("dutyDeptCodes","A058,A012,A027");
			}else{
				queryMap.put("dutyDeptCodes",sysUser.getDutyDeptCodes());
			}
		}
		if(queryMap.get("dutyDeptCodes")!=null&&StringUtils.isNotBlank(queryMap.get("dutyDeptCodes").toString())){
			queryMap.put("dutyDeptCodeArr",queryMap.get("dutyDeptCodes").toString().split(","));
		}
	}
    
}
