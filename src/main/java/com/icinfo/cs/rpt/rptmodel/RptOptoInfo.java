/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_rpt_opto_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年03月22日
 */
@Table(name = "cs_rpt_opto_info")
public class RptOptoInfo implements Serializable {
    
	@Column(name = "areacode")
    private String areacode;

    @Column(name = "regorg")
    private String regorg;

    @Column(name = "localadm")
    private String localadm;

    @Column(name = "willexpired")
    private Long willexpired;

    @Column(name = "expired")
    private Long expired;

    private static final long serialVersionUID = 1L;

    /**
     * @return areacode
     */
    public String getAreacode() {
        return areacode;
    }

    /**
     * @param areacode
     */
    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    /**
     * @return regorg
     */
    public String getRegorg() {
        return regorg;
    }

    /**
     * @param regorg
     */
    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    /**
     * @return localadm
     */
    public String getLocaladm() {
        return localadm;
    }

    /**
     * @param localadm
     */
    public void setLocaladm(String localadm) {
        this.localadm = localadm;
    }

    /**
     * @return willexpired
     */
    public Long getWillexpired() {
        return willexpired;
    }

    /**
     * @param willexpired
     */
    public void setWillexpired(Long willexpired) {
        this.willexpired = willexpired;
    }

    /**
     * @return expired
     */
    public Long getExpired() {
        return expired;
    }

    /**
     * @param expired
     */
    public void setExpired(Long expired) {
        this.expired = expired;
    }
}