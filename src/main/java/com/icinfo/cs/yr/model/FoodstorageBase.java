/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_foodstorage_base 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月26日
 */
@Table(name = "cs_foodstorage_base")
public class FoodstorageBase implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private Integer id;
   
    /**
     * 序号
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 涉及范围：1 食品生产；2 食品经营； 3 食品仓储服务；4 都不涉及；（多项逗号分割）
     */
    @Column(name = "FsScope")
    private String fsScope;

    /**
     * 食品生产许可证数目
     */
    @Column(name = "ProAmount")
    private Integer proAmount;
    
    /**
     * 食品流通许可证数目
     */
    @Column(name = "DisAmount")
    private Integer disAmount;

    /**
     * 仓库数目
     */
    @Column(name = "WareAmount")
    private Integer wareAmount;

    /**
     * 填表人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 填表人办公电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 填表人手机号码
     */
    @Column(name = "MobTel")
    private String mobTel;

    /**
     * 填写日期
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date setTime;

    /**
     * 更新日期
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 状态：1 暂存；2 提交
     */
    @Column(name = "SubmitState")
    private String submitState;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取序号
     *
     * @return UID - 序号
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置序号
     *
     * @param UID 序号
     */
    public void setUID(String UID) {
        this.UID = UID;
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
     * 获取年度
     *
     * @return Year - 年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年度
     *
     * @param year 年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取涉及范围：1 食品生产；2 食品经营； 3 食品仓储服务；4 都不涉及；（多项逗号分割）
     *
     * @return FsScope - 涉及范围：1 食品生产；2 食品经营； 3 食品仓储服务；4 都不涉及；（多项逗号分割）
     */
    public String getFsScope() {
        return fsScope;
    }

    /**
     * 设置涉及范围：1 食品生产；2 食品经营； 3 食品仓储服务；4 都不涉及；（多项逗号分割）
     *
     * @param fsScope 涉及范围：1 食品生产；2 食品经营； 3 食品仓储服务；4 都不涉及；（多项逗号分割）
     */
    public void setFsScope(String fsScope) {
        this.fsScope = fsScope;
    }

    /**
     * 获取食品生产许可证数目
     *
     * @return ProAmount - 食品生产许可证数目
     */
    public Integer getProAmount() {
        return proAmount;
    }

    /**
     * 设置食品生产许可证数目
     *
     * @param proAmount 食品生产许可证数目
     */
    public void setProAmount(Integer proAmount) {
        this.proAmount = proAmount;
    }

    /**
     * 获取食品流通许可证数目
     *
     * @return DisAmount - 食品流通许可证数目
     */
    public Integer getDisAmount() {
        return disAmount;
    }

    /**
     * 设置食品流通许可证数目
     *
     * @param disAmount 食品流通许可证数目
     */
    public void setDisAmount(Integer disAmount) {
        this.disAmount = disAmount;
    }

    /**
     * 获取仓库数目
     *
     * @return WareAmount - 仓库数目
     */
    public Integer getWareAmount() {
        return wareAmount;
    }

    /**
     * 设置仓库数目
     *
     * @param wareAmount 仓库数目
     */
    public void setWareAmount(Integer wareAmount) {
        this.wareAmount = wareAmount;
    }

    /**
     * 获取填表人
     *
     * @return SetName - 填表人
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置填表人
     *
     * @param setName 填表人
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取填表人办公电话
     *
     * @return Tel - 填表人办公电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置填表人办公电话
     *
     * @param tel 填表人办公电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取填表人手机号码
     *
     * @return MobTel - 填表人手机号码
     */
    public String getMobTel() {
        return mobTel;
    }

    /**
     * 设置填表人手机号码
     *
     * @param mobTel 填表人手机号码
     */
    public void setMobTel(String mobTel) {
        this.mobTel = mobTel;
    }

    /**
     * 获取填写日期
     *
     * @return SetTime - 填写日期
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置填写日期
     *
     * @param setTime 填写日期
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取更新日期
     *
     * @return CreateTime - 更新日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置更新日期
     *
     * @param createTime 更新日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取状态：1 暂存；2 提交
     *
     * @return SubmitState - 状态：1 暂存；2 提交
     */
    public String getSubmitState() {
        return submitState;
    }

    /**
     * 设置状态：1 暂存；2 提交
     *
     * @param submitState 状态：1 暂存；2 提交
     */
    public void setSubmitState(String submitState) {
        this.submitState = submitState;
    }
    
    @Override
   	public String toString() {
   		return "FoodstorageBase [id=" + id + ", priPID=" + priPID + ", UID="
   				+ UID + ", year=" + year + ", fsScope="
   				+ fsScope + ", proAmount=" + proAmount + ", disAmount="
   				+ disAmount + ", wareAmount=" + wareAmount + ", setName=" + setName
   				+ ", tel=" + tel + ", mobTel=" + mobTel + ", setTime=" + setTime 
   				+ ", createTime=" + createTime + ", submitState=" + submitState + "]";
   	}
}