/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.im.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.anno.Forbidword;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:    cs_im_casalt 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_im_casalt")
public class ImCasalt implements Serializable {
    /**
     * 主键自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 变更日期
     */
    @Column(name = "AltDate")
    private Date altDate;

    /**
     * 行政处罚ID
     */
    @Column(name = "CaseNO")
    private String caseNO;

    /**
     * 作出变更决定机关名称
     */
    @Column(name = "PenAuth")
    @Forbidword
    private String penAuth;

    /**
     * 创建时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 行政处罚变更ID（UUID）
     */
    @Column(name = "CaseAltID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String caseAltID;


    /**
     * 作出变更决定机关名称
     */
    @Column(name = "PenAuthName")
    @Forbidword
    private String penAuthName;

    /**
     * 备注
     */
    @Column(name = "Remark")
    @Forbidword
    private String remark;

    /**
     * 变更内容
     */
    @Column(name = "PenContent")
    @Forbidword
    private String penContent;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键自增id
     *
     * @return id - 主键自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键自增id
     *
     * @param id 主键自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取变更日期
     *
     * @return AltDate - 变更日期
     */
    public Date getAltDate() {
        return altDate;
    }

    /**
     * 设置变更日期
     *
     * @param altDate 变更日期
     */
    public void setAltDate(Date altDate) {
        this.altDate = altDate;
    }

    /**
     * 获取行政处罚ID
     *
     * @return CaseNO - 行政处罚ID
     */
    public String getCaseNO() {
        return caseNO;
    }

    /**
     * 设置行政处罚ID
     *
     * @param caseNO 行政处罚ID
     */
    public void setCaseNO(String caseNO) {
        this.caseNO = caseNO;
    }

    /**
     * 获取作出变更决定机关名称
     *
     * @return PenAuth - 作出变更决定机关名称
     */
    public String getPenAuth() {
        return penAuth;
    }

    /**
     * 设置作出变更决定机关名称
     *
     * @param penAuth 作出变更决定机关名称
     */
    public void setPenAuth(String penAuth) {
        this.penAuth = penAuth;
    }

    /**
     * 获取创建时间戳
     *
     * @return CreateTime - 创建时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间戳
     *
     * @param createTime 创建时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取行政处罚变更ID（UUID）
     *
     * @return CaseAltID - 行政处罚变更ID（UUID）
     */
    public String getCaseAltID() {
        return caseAltID;
    }

    /**
     * 设置行政处罚变更ID（UUID）
     *
     * @param caseAltID 行政处罚变更ID（UUID）
     */
    public void setCaseAltID(String caseAltID) {
        this.caseAltID = caseAltID;
    }

    /**
     * 获取作出变更决定机关名称
     *
     * @return PenAuthName - 作出变更决定机关名称
     */
    public String getPenAuthName() {
        return penAuthName;
    }

    /**
     * 设置作出变更决定机关名称
     *
     * @param penAuthName 作出变更决定机关名称
     */
    public void setPenAuthName(String penAuthName) {
        this.penAuthName = penAuthName;
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

    /**
     * 获取变更内容
     *
     * @return PenContent - 变更内容
     */
    public String getPenContent() {
        return penContent;
    }

    /**
     * 设置变更内容
     *
     * @param penContent 变更内容
     */
    public void setPenContent(String penContent) {
        this.penContent = penContent;
    }
}