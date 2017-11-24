/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.dto;

import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.framework.core.validator.Level;
import com.icinfo.framework.core.validator.Password;
import com.icinfo.cs.system.model.SysUser;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * 描述:  系统用户DTO.<br>
 *
 * @author xiajunwei
 * @date 2016年04月25日
 */
public class SysUserDto extends SysUser {


    /**
     * 部门ID(cs_deptment.DeptDID或者cs_sys_depart.OrgCoding)
     */
    @Transient
    private String deptId;

    /**
     * 用户所对应协同部门信息
     */
    @Transient
    private SysDepart sysDepart;

    /**
     * 用户所对应警示部门信息
     */
    @Transient
    private DepartMent departMent;

    /**
     * 当前登录用户对应的职能部门编码（如果多个，以逗号形式隔开）
     */
    private String dutyDeptCodes;

    // 0管理员,
    // 1所级,
    // 2分局,
    // 3市级
    // 4省级
    @Transient
    private String userVest;

//    @Password(level = Level.WEAK)
    @Override
    public String getPassword() {
        return super.getPassword();
    }
    
    /**
     * 公示部门协同名称
     */
    @Transient 
    private String depSynName;


    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUserVest() {
        return userVest;
    }

    public String getUserVest(SysUserDto sysUserDto) {
        if(StringUtil.isNotBlank(userVest))return userVest;
        try {
            if("1".equals(getIsAdmin())||"2".equals(getIsAdmin())){
                return DBAuthorConstants.USER_LEVEL_ADMIN;
            }
            if("2".equals(getIsAdmin())){
                return DBAuthorConstants.USER_LEVEL_ADMIN;
            }
            if("1".equals(sysUserDto.getUserType()) || "3".equals(sysUserDto.getUserType())){
                String deptCode=sysUserDto.getDepartMent().getDeptCode();
                return userVestByDeptCode(deptCode);
            }
            if("2".equals(sysUserDto.getUserType())){
                return userVestByAdCode();
            }
        } catch (Exception er) {
            er.printStackTrace();
        }
        return userVest;
    }

    /**
     * 根据部门（行政）编码来得到用户所属层级（工商部门）
     * @param deptCode
     * @return
     */
    private String userVestByDeptCode(String deptCode){
        if (deptCode != null) {
            for (int i = 0; i < 8 - getDeptCode().length(); i++) {//如果不足8位，追加0来拼凑成八位
                deptCode = deptCode.concat("0");
            }
            if(deptCode.length()>8)deptCode=deptCode.substring(0,8);
        }
        if (deptCode != null) {
            if (deptCode.substring(2).equals("000000")) {
                return DBAuthorConstants.USER_LEVEL_PROV;//省局
            }
            if (deptCode.substring(4).equals("0000")) {
                return DBAuthorConstants.USER_LEVEL_CITY;//市局
            }
            if (deptCode.substring(6).equals("00")) {
                return DBAuthorConstants.USER_LEVEL_COUNTRY;//分局
            }else{
                return DBAuthorConstants.USER_LEVEL_UNIT;//所级
            }
        }
        return null;
    }

    /**
     * 获取用户所属层级（通过全省部门的ADCODE）
     * @return
     */
    private String userVestByAdCode(){
        if(getSysDepart()!=null){
            String[] adCodeInfo=getSysDepart().getAdcode().split("M");
            if(adCodeInfo.length>0&&adCodeInfo.length>1){
                String adCodeMark=adCodeInfo[0];
                return userVestByDeptCode(adCodeMark);
            }
        }
        return null;
    }

    public void setUserVest(String userVest) {
        this.userVest = userVest;
    }

    public String getDutyDeptCodes() {
        return dutyDeptCodes;
    }

    public void setDutyDeptCodes(String dutyDeptCodes) {
        this.dutyDeptCodes = dutyDeptCodes;
    }

    public SysDepart getSysDepart() {
        return sysDepart;
    }

    public void setSysDepart(SysDepart sysDepart) {
        this.sysDepart = sysDepart;
    }

    public DepartMent getDepartMent() {
        return departMent;
    }

    public void setDepartMent(DepartMent departMent) {
        this.departMent = departMent;
    }



    /**
     * 用户角色
     */
    private String roles;

    private String[] searchRangeEntTypes;

    public String[] getSearchRangeEntTypes() {
        return searchRangeEntTypes;
    }

    public void setSearchRangeEntTypes(String[] searchRangeEntTypes) {
        this.searchRangeEntTypes = searchRangeEntTypes;
    }

    @Override
    public String getSearchRangeEntType() {
        StringBuilder stringBuilder=new StringBuilder();
        if(getSearchRangeEntTypes()!=null){
            for (int i = 0; i < getSearchRangeEntTypes().length; i++) {
                stringBuilder.append(getSearchRangeEntTypes()[i]+",");
            }
            return stringBuilder.substring(0,stringBuilder.length()-1);
        }else{
            return super.getSearchRangeEntType();
        }
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Email
    @Override
    public String getEmail() {
        return super.getEmail();
    }

	public String getDepSynName() {
		return depSynName;
	}

	public void setDepSynName(String depSynName) {
		this.depSynName = depSynName;
	}
    
    
}
