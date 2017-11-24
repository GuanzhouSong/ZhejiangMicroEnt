/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.es.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_patentinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月08日
 */
@Table(name = "cs_patentinfo")
public class CsPatentiInfo implements Serializable {
    /**
     * id
     */
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
     * 专利申请号
     */
    @Column(name = "PatentNO")
    private String patentNO;

    /**
     * 发明名称
     */
    @Column(name = "PatentName")
    private String patentName;

    /**
     * 专利类型
     */
    @Column(name = "PatentType")
    private String patentType;

    /**
     * 申请人
     */
    @Column(name = "Patenter")
    private String patenter;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
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
     * 获取专利申请号
     *
     * @return PatentNO - 专利申请号
     */
    public String getPatentNO() {
        return patentNO;
    }

    /**
     * 设置专利申请号
     *
     * @param patentNO 专利申请号
     */
    public void setPatentNO(String patentNO) {
        this.patentNO = patentNO;
    }

    /**
     * 获取发明名称
     *
     * @return PatentName - 发明名称
     */
    public String getPatentName() {
        return patentName;
    }

    /**
     * 设置发明名称
     *
     * @param patentName 发明名称
     */
    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    /**
     * 获取专利类型
     *
     * @return PatentType - 专利类型
     */
    public String getPatentType() {
        return patentType;
    }

    /**
     * 设置专利类型
     *
     * @param patentType 专利类型
     */
    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    /**
     * 获取申请人
     *
     * @return Patenter - 申请人
     */
    public String getPatenter() {
        return patenter;
    }

    /**
     * 设置申请人
     *
     * @param patenter 申请人
     */
    public void setPatenter(String patenter) {
        this.patenter = patenter;
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
}