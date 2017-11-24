/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_sys_deliverinfo 对应的实体类.(确认书送达地址表)<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月30日
 */
@Table(name = "cs_sys_deliverinfo")
public class SysDeliverInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 邮政编码
     */
    @Column(name = "PostalCode")
    private String postalCode;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 联系人
     */
    @Column(name = "Linkman")
    private String linkman;

    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 部门ID
     */
    @Column(name = "DeptId")
    private String deptId;

    /**
     * 送达地址
     */
    @Column(name = "DeliAddress")
    private String deliAddress;

    /**
     * 送达单位名称
     */
    @Column(name = "DeliName")
    private String deliName;

    /**
     * 送达单位编码
     */
    @Column(name = "DeliCode")
    private String deliCode;

    /**
     * 类型：1内资2外资3农专
     */
    @Column(name = "DeliType")
    private String deliType;

    /**
     * 设置时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")     
    private Date setTime;

    /**
     * 设置人名字
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 设置人ID
     */
    @Column(name = "SetId")
    private String setId;

    /**
     * 是否有效1有效 0无效
     */
    @Column(name = "IsValid")
    private String isValid;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取邮政编码
     *
     * @return PostalCode - 邮政编码
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 设置邮政编码
     *
     * @param postalCode 邮政编码
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 获取联系电话
     *
     * @return Tel - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取联系人
     *
     * @return Linkman - 联系人
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * 设置联系人
     *
     * @param linkman 联系人
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }


    /**
     * 获取部门ID
     *
     * @return DeptId - 部门ID
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 设置部门ID
     *
     * @param deptId 部门ID
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取送达地址
     *
     * @return DeliAddress - 送达地址
     */
    public String getDeliAddress() {
        return deliAddress;
    }

    /**
     * 设置送达地址
     *
     * @param deliAddress 送达地址
     */
    public void setDeliAddress(String deliAddress) {
        this.deliAddress = deliAddress;
    }

    /**
     * 获取送达单位名称
     *
     * @return DeliName - 送达单位名称
     */
    public String getDeliName() {
        return deliName;
    }

    /**
     * 设置送达单位名称
     *
     * @param deliName 送达单位名称
     */
    public void setDeliName(String deliName) {
        this.deliName = deliName;
    }

    /**
     * 获取送达单位编码
     *
     * @return DeliCode - 送达单位编码
     */
    public String getDeliCode() {
        return deliCode;
    }

    /**
     * 设置送达单位编码
     *
     * @param deliCode 送达单位编码
     */
    public void setDeliCode(String deliCode) {
        this.deliCode = deliCode;
    }

    /**
     * 获取类型：1内资2外资
     *
     * @return DeliType - 类型：1内资2外资
     */
    public String getDeliType() {
        return deliType;
    }

    /**
     * 设置类型：1内资2外资
     *
     * @param deliType 类型：1内资2外资
     */
    public void setDeliType(String deliType) {
        this.deliType = deliType;
    }

    /**
     * 获取设置时间
     *
     * @return SetTime - 设置时间
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置设置时间
     *
     * @param setTime 设置时间
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取设置人名字
     *
     * @return SetName - 设置人名字
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置设置人名字
     *
     * @param setName 设置人名字
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取设置人ID
     *
     * @return SetId - 设置人ID
     */
    public String getSetId() {
        return setId;
    }

    /**
     * 设置设置人ID
     *
     * @param setId 设置人ID
     */
    public void setSetId(String setId) {
        this.setId = setId;
    }

    /**
     * 获取是否有效1有效 0无效
     *
     * @return IsValid - 是否有效1有效 0无效
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * 设置是否有效1有效 0无效
     *
     * @param isValid 是否有效1有效 0无效
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    /**
     * 获取备注
     *
     * @return Remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    
    public void setUid(String uid) {
		this.uid = uid;
	}
    
    public String getUid() {
		return uid;
	}
}