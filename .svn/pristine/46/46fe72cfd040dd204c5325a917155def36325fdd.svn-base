/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.ext.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_mid_liquidation 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月21日
 */
@Table(name = "cs_mid_liquidation")
public class MidLiquidation implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 内部序号
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 清算负责人
     */
    @Column(name = "LigPrincipal")
    private String ligPrincipal;

    /**
     * 地址
     */
    @Column(name = "Addr")
    private String addr;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 清算完结情况
     */
    @Column(name = "LigSt")
    private String ligSt;

    /**
     * 清算完结日期
     */
    @Column(name = "LigEndDate")
    private Date ligEndDate;

    /**
     * 债务承接人
     */
    @Column(name = "DebtTranee")
    private String debtTranee;

    /**
     * 债权承接人
     */
    @Column(name = "ClaimTranee")
    private String claimTranee;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 清算组成员
     */
    @Column(name = "LiqMem")
    private String liqMem;

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
     * 获取内部序号
     *
     * @return PriPID - 内部序号
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置内部序号
     *
     * @param priPID 内部序号
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取清算负责人
     *
     * @return LigPrincipal - 清算负责人
     */
    public String getLigPrincipal() {
        return ligPrincipal;
    }

    /**
     * 设置清算负责人
     *
     * @param ligPrincipal 清算负责人
     */
    public void setLigPrincipal(String ligPrincipal) {
        this.ligPrincipal = ligPrincipal;
    }

    /**
     * 获取地址
     *
     * @return Addr - 地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置地址
     *
     * @param addr 地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
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
     * 获取清算完结情况
     *
     * @return LigSt - 清算完结情况
     */
    public String getLigSt() {
        return ligSt;
    }

    /**
     * 设置清算完结情况
     *
     * @param ligSt 清算完结情况
     */
    public void setLigSt(String ligSt) {
        this.ligSt = ligSt;
    }

    /**
     * 获取清算完结日期
     *
     * @return LigEndDate - 清算完结日期
     */
    public Date getLigEndDate() {
        return ligEndDate;
    }

    /**
     * 设置清算完结日期
     *
     * @param ligEndDate 清算完结日期
     */
    public void setLigEndDate(Date ligEndDate) {
        this.ligEndDate = ligEndDate;
    }

    /**
     * 获取债务承接人
     *
     * @return DebtTranee - 债务承接人
     */
    public String getDebtTranee() {
        return debtTranee;
    }

    /**
     * 设置债务承接人
     *
     * @param debtTranee 债务承接人
     */
    public void setDebtTranee(String debtTranee) {
        this.debtTranee = debtTranee;
    }

    /**
     * 获取债权承接人
     *
     * @return ClaimTranee - 债权承接人
     */
    public String getClaimTranee() {
        return claimTranee;
    }

    /**
     * 设置债权承接人
     *
     * @param claimTranee 债权承接人
     */
    public void setClaimTranee(String claimTranee) {
        this.claimTranee = claimTranee;
    }

    /**
     * 获取时间戳
     *
     * @return CreateTime - 时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置时间戳
     *
     * @param createTime 时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取清算组成员
     *
     * @return LiqMem - 清算组成员
     */
    public String getLiqMem() {
        return liqMem;
    }

    /**
     * 设置清算组成员
     *
     * @param liqMem 清算组成员
     */
    public void setLiqMem(String liqMem) {
        this.liqMem = liqMem;
    }
}