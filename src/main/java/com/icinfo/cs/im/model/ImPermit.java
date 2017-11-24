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
 * 描述:    cs_im_permit 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_im_permit")
public class ImPermit implements Serializable {
    /**
     * 主键自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业(机构)名称
     */
    @Column(name = "EntName")
  
    private String entName;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 许可文件编号
     */
    @Column(name = "LicNO")
    @Forbidword
    private String licNO;

    /**
     * 有效期至
     */
    @Column(name = "ValTo")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date valTo;

    /**
     * 许可机关
     */
    @Column(name = "LicAnth")
    @Forbidword
    private String licAnth;

    /**
     * 有效期自
     */
    @Column(name = "ValFrom")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date valFrom;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 注销日期
     */
    @Column(name = "CanDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date canDate;

    /**
     * 被吊销日期
     */
    @Column(name = "RevDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date revDate;

    /**
     * 注销原因
     */
    @Column(name = "EquPleCanRea")
    @Forbidword
    private String equPleCanRea;

    /**
     * 创建时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 许可文件名称（中文名称）
     */
    @Column(name = "LicNameCN")
    @Forbidword
    private String licNameCN;

    /**
     * 许可信息ID
     */
    @Column(name = "LicID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String licID;

    /**
     * 其他无效原因
     */
    @Column(name = "InvAliDRea")
    @Forbidword
    private String invAliDRea;

    /**
     * 其它无效日期
     */
    @Column(name = "InvAlidDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date invAlidDate;

    /**
     * 类别选择：1变更，2注销，3被吊销，4撤销
     */
    @Column(name = "PubType")
    private String pubType;

    /**
     * 公示状态：暂存2，公示1
     */
    @Column(name = "PubFlag")
    private String pubFlag;

    /**
     * 公示日期
     */
    @Column(name = "PublicDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date publicDate;

    /**
     * 许可内容
     */
    @Column(name = "LicItem")
    @Forbidword
    private String licItem;

    /**
     * 被吊销原因
     */
    @Column(name = "SugRevReason")
    @Forbidword
    private String sugRevReason;

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
     * 获取主体身份代码
     *
     * @return PriPID - 主体身份代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码
     *
     * @param priPID 主体身份代码
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取企业(机构)名称
     *
     * @return EntName - 企业(机构)名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业(机构)名称
     *
     * @param entName 企业(机构)名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取注册号
     *
     * @return RegNO - 注册号
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号
     *
     * @param regNO 注册号
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取许可文件编号
     *
     * @return LicNO - 许可文件编号
     */
    public String getLicNO() {
        return licNO;
    }

    /**
     * 设置许可文件编号
     *
     * @param licNO 许可文件编号
     */
    public void setLicNO(String licNO) {
        this.licNO = licNO;
    }

    /**
     * 获取有效期至
     *
     * @return ValTo - 有效期至
     */
    public Date getValTo() {
        return valTo;
    }

    /**
     * 设置有效期至
     *
     * @param valTo 有效期至
     */
    public void setValTo(Date valTo) {
        this.valTo = valTo;
    }

    /**
     * 获取许可机关
     *
     * @return LicAnth - 许可机关
     */
    public String getLicAnth() {
        return licAnth;
    }

    /**
     * 设置许可机关
     *
     * @param licAnth 许可机关
     */
    public void setLicAnth(String licAnth) {
        this.licAnth = licAnth;
    }

    /**
     * 获取有效期自
     *
     * @return ValFrom - 有效期自
     */
    public Date getValFrom() {
        return valFrom;
    }

    /**
     * 设置有效期自
     *
     * @param valFrom 有效期自
     */
    public void setValFrom(Date valFrom) {
        this.valFrom = valFrom;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return UniCode - 统一社会信用代码
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniCode 统一社会信用代码
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    /**
     * 获取注销日期
     *
     * @return CanDate - 注销日期
     */
    public Date getCanDate() {
        return canDate;
    }

    /**
     * 设置注销日期
     *
     * @param canDate 注销日期
     */
    public void setCanDate(Date canDate) {
        this.canDate = canDate;
    }

    /**
     * 获取被吊销日期
     *
     * @return RevDate - 被吊销日期
     */
    public Date getRevDate() {
        return revDate;
    }

    /**
     * 设置被吊销日期
     *
     * @param revDate 被吊销日期
     */
    public void setRevDate(Date revDate) {
        this.revDate = revDate;
    }

    /**
     * 获取注销原因
     *
     * @return EquPleCanRea - 注销原因
     */
    public String getEquPleCanRea() {
        return equPleCanRea;
    }

    /**
     * 设置注销原因
     *
     * @param equPleCanRea 注销原因
     */
    public void setEquPleCanRea(String equPleCanRea) {
        this.equPleCanRea = equPleCanRea;
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
     * 获取许可文件名称（中文名称）
     *
     * @return LicNameCN - 许可文件名称（中文名称）
     */
    public String getLicNameCN() {
        return licNameCN;
    }

    /**
     * 设置许可文件名称（中文名称）
     *
     * @param licNameCN 许可文件名称（中文名称）
     */
    public void setLicNameCN(String licNameCN) {
        this.licNameCN = licNameCN;
    }

    /**
     * 获取许可信息ID
     *
     * @return LicID - 许可信息ID
     */
    public String getLicID() {
        return licID;
    }

    /**
     * 设置许可信息ID
     *
     * @param licID 许可信息ID
     */
    public void setLicID(String licID) {
        this.licID = licID;
    }

    /**
     * 获取其他无效原因
     *
     * @return InvAliDRea - 其他无效原因
     */
    public String getInvAliDRea() {
        return invAliDRea;
    }

    /**
     * 设置其他无效原因
     *
     * @param invAliDRea 其他无效原因
     */
    public void setInvAliDRea(String invAliDRea) {
        this.invAliDRea = invAliDRea;
    }

    /**
     * 获取其它无效日期
     *
     * @return InvAlidDate - 其它无效日期
     */
    public Date getInvAlidDate() {
        return invAlidDate;
    }

    /**
     * 设置其它无效日期
     *
     * @param invAlidDate 其它无效日期
     */
    public void setInvAlidDate(Date invAlidDate) {
        this.invAlidDate = invAlidDate;
    }

    /**
     * 获取类别选择：1变更，2注销，3被吊销，4撤销
     *
     * @return PubType - 类别选择：1变更，2注销，3被吊销，4撤销
     */
    public String getPubType() {
        return pubType;
    }

    /**
     * 设置类别选择：1变更，2注销，3被吊销，4撤销
     *
     * @param pubType 类别选择：1变更，2注销，3被吊销，4撤销
     */
    public void setPubType(String pubType) {
        this.pubType = pubType;
    }

    /**
     * 获取公示状态：暂存2，公示1
     *
     * @return PubFlag - 公示状态：暂存2，公示1
     */
    public String getPubFlag() {
        return pubFlag;
    }

    /**
     * 设置公示状态：暂存2，公示1
     *
     * @param pubFlag 公示状态：暂存2，公示1
     */
    public void setPubFlag(String pubFlag) {
        this.pubFlag = pubFlag;
    }

    /**
     * 获取公示日期
     *
     * @return PublicDate - 公示日期
     */
    public Date getPublicDate() {
        return publicDate;
    }

    /**
     * 设置公示日期
     *
     * @param publicDate 公示日期
     */
    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    /**
     * 获取许可内容
     *
     * @return LicItem - 许可内容
     */
    public String getLicItem() {
        return licItem;
    }

    /**
     * 设置许可内容
     *
     * @param licItem 许可内容
     */
    public void setLicItem(String licItem) {
        this.licItem = licItem;
    }

    /**
     * 获取被吊销原因
     *
     * @return SugRevReason - 被吊销原因
     */
    public String getSugRevReason() {
        return sugRevReason;
    }

    /**
     * 设置被吊销原因
     *
     * @param sugRevReason 被吊销原因
     */
    public void setSugRevReason(String sugRevReason) {
        this.sugRevReason = sugRevReason;
    }


}