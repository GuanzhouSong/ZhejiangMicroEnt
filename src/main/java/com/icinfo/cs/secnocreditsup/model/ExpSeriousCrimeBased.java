/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.secnocreditsup.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_exp_serious_crime_based 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月30日
 */
@Table(name = "cs_exp_serious_crime_based")
public class ExpSeriousCrimeBased implements Serializable {
    /**
     * 自增主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uuid
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 对应严违表SourceId
     */
    @Column(name = "SourceId")
    private String sourceId;

    /**
     * 依据
     */
    @Column(name = "Based")
    private String based;

    /**
     * 上传路径
     */
    @Column(name = "BasedUpload")
    private String basedUpload;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增主键ID
     *
     * @return id - 自增主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键ID
     *
     * @param id 自增主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取uuid
     *
     * @return UID - uuid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uuid
     *
     * @param UID uuid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取对应严违表SourceId
     *
     * @return SourceId - 对应严违表SourceId
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置对应严违表SourceId
     *
     * @param sourceId 对应严违表SourceId
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 获取依据
     *
     * @return Based - 依据
     */
    public String getBased() {
        return based;
    }

    /**
     * 设置依据
     *
     * @param based 依据
     */
    public void setBased(String based) {
        this.based = based;
    }

    /**
     * 获取上传路径
     *
     * @return BasedUpload - 上传路径
     */
    public String getBasedUpload() {
        return basedUpload;
    }

    /**
     * 设置上传路径
     *
     * @param basedUpload 上传路径
     */
    public void setBasedUpload(String basedUpload) {
        this.basedUpload = basedUpload;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}