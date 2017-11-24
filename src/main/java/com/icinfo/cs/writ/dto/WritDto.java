/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.writ.dto;

import com.icinfo.cs.writ.model.Writ;

import javax.persistence.Column;

/**
 * 描述:  cs_writ 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年06月06日
 */
public class WritDto extends Writ {

    /**
     * 注册号(CA15)
     */
    private String regNO;

    /**
     * 统一社会信用代码(CA91)
     */
    private String uniCode;

    /**
     * 企业(机构)名称
     */
    private String entName;

    /**
     * 法定代表人
     */
    private String leRep;

    /**
     * 登记机关(CA11)
     */
    private String regOrg;

    /**
     * 管辖单位
     */
    private String localAdmName;

    /**
     * 登记状态(CA19)
     */
    private String regState;

    /**
     * 责任区商圈名称
     */
    private String sliceNOName;

    public String getRegNO() {
        return regNO;
    }

    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    public String getUniCode() {
        return uniCode;
    }

    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getLeRep() {
        return leRep;
    }

    public void setLeRep(String leRep) {
        this.leRep = leRep;
    }

    public String getRegOrg() {
        return regOrg;
    }

    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg;
    }

    public String getLocalAdmName() {
        return localAdmName;
    }

    public void setLocalAdmName(String localAdmName) {
        this.localAdmName = localAdmName;
    }

    public String getRegState() {
        return regState;
    }

    public void setRegState(String regState) {
        this.regState = regState;
    }

    public String getSliceNOName() {
        return sliceNOName;
    }

    public void setSliceNOName(String sliceNOName) {
        this.sliceNOName = sliceNOName;
    }
}