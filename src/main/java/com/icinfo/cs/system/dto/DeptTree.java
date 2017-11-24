/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:    部门树数据 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月19日
 */
@Table(name = "cs_sys_depart")
public class DeptTree implements Serializable {

    @Column(name = "OrgCoding")
    private String orgCoding;

    @Column(name = "OrgName")
    private String orgName;

    @Column(name = "Adcode")
    private String adcode;

    @Column(name = "DutyDeptName")
    private String dutyDeptName;

    @Column(name = "DutyDeptCode")
    private String dutyDeptCode;

    @Column(name = "PorgCoding")
    private String porgCoding;

    @Column(name = "IsParent")
    private String isParent;

    @Column(name = "Nocheck")
    private String nocheck;

    public String getDutyDeptName() {
        return dutyDeptName;
    }

    public void setDutyDeptName(String dutyDeptName) {
        this.dutyDeptName = dutyDeptName;
    }

    public String getDutyDeptCode() {
        return dutyDeptCode;
    }

    public void setDutyDeptCode(String dutyDeptCode) {
        this.dutyDeptCode = dutyDeptCode;
    }

    public String getNocheck() {
        return nocheck;
    }

    public void setNocheck(String nocheck) {
        this.nocheck = nocheck;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    private static final long serialVersionUID = 1L;


    /**
     * 获取编码
     *
     * @return OrgCoding - 编码
     */
    public String getOrgCoding() {
        return orgCoding;
    }

    /**
     * 设置编码
     *
     * @param orgCoding 编码
     */
    public void setOrgCoding(String orgCoding) {
        this.orgCoding = orgCoding;
    }

    /**
     * 获取机构名称
     *
     * @return OrgName - 机构名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置机构名称
     *
     * @param orgName 机构名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }


    /**
     * @return Adcode
     */
    public String getAdcode() {
        return adcode;
    }

    /**
     * @param adcode
     */
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    /**
     * 获取上级机构编码
     *
     * @return PorgCoding - 上级机构编码
     */
    public String getPorgCoding() {
        return porgCoding;
    }

    /**
     * 设置上级机构编码
     *
     * @param porgCoding 上级机构编码
     */
    public void setPorgCoding(String porgCoding) {
        this.porgCoding = porgCoding;
    }

}