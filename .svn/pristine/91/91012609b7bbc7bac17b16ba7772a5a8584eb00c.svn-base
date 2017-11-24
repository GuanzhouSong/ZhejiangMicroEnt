/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.batch.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_batch 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月25日
 */
@Table(name = "cs_batch")
public class Batch implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 批次类型
     */
    @Column(name = "BatchType")
    private String batchType;

    /**
     * 批次编号
     */
    @Column(name = "BatchData")
    private String batchData;

    /**
     * 批次序号
     */
    @Column(name = "BatchNo")
    private String batchNo;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    private Date createTime;

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
     * 获取UID
     *
     * @return UID - UID
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置UID
     *
     * @param UID UID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取批次类型
     *
     * @return BatchType - 批次类型
     */
    public String getBatchType() {
        return batchType;
    }

    /**
     * 设置批次类型
     *
     * @param batchType 批次类型
     */
    public void setBatchType(String batchType) {
        this.batchType = batchType;
    }

    /**
     * 获取批次编号
     *
     * @return BatchData - 批次编号
     */
    public String getBatchData() {
        return batchData;
    }

    /**
     * 设置批次编号
     *
     * @param batchData 批次编号
     */
    public void setBatchData(String batchData) {
        this.batchData = batchData;
    }

    /**
     * 获取批次序号
     *
     * @return BatchNo - 批次序号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * 设置批次序号
     *
     * @param batchNo 批次序号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
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