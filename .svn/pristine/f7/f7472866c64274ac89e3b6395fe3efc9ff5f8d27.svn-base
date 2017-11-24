/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sment.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:   小微企业-区域code sm_bus_entarchives_area 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月04日
 */
@Table(name = "sm_bus_entarchives_area")
public class SmBusEntarchivesArea implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uuid
     */
    @Column(name = "AreaCode")
    private String areaCode;

    /**
     * 主体身份代码(CA14)
     */
    @Column(name = "AreaName")
    private String areaName;

    /**
     * 企业负责人
     */
    @Column(name = "AreaPcode")
    private String areaPcode;

    //部门code
    @Column(name = "DeptCode")
    private String deptCode;
    
    
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
     * 获取uuid
     *
     * @return AreaCode - uuid
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置uuid
     *
     * @param areaCode uuid
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 获取主体身份代码(CA14)
     *
     * @return AreaName - 主体身份代码(CA14)
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置主体身份代码(CA14)
     *
     * @param areaName 主体身份代码(CA14)
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取企业负责人
     *
     * @return AreaPcode - 企业负责人
     */
    public String getAreaPcode() {
        return areaPcode;
    }

    /**
     * 设置企业负责人
     *
     * @param areaPcode 企业负责人
     */
    public void setAreaPcode(String areaPcode) {
        this.areaPcode = areaPcode;
    }

    
    public String getDeptCode(){
        return deptCode;
    }

    
    public void setDeptCode(String deptCode){
        this.deptCode = deptCode;
    }
}