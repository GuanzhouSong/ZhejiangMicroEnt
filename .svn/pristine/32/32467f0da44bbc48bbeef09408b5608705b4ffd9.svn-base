/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_daily_inspect_item_result 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月07日
 */
@Table(name = "cs_daily_inspect_item_result")
public class DailyInspectItemResult implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 日常检查结果表uid
     */
    @Column(name = "ResultUid")
    private String resultUid;

    /**
     * 日常检查事项表id
     */
    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 检查内容名称
     */
    @Column(name = "CheckName")
    private String checkName;

    /**
     * 发现问题情况
     */
    @Column(name = "Problem")
    private String problem;

    /**
     * 处置情况
     */
    @Column(name = "Dispose")
    private String dispose;

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
     * 获取日常检查结果表uid
     *
     * @return ResultUid - 日常检查结果表uid
     */
    public String getResultUid() {
        return resultUid;
    }

    /**
     * 设置日常检查结果表uid
     *
     * @param resultUid 日常检查结果表uid
     */
    public void setResultUid(String resultUid) {
        this.resultUid = resultUid;
    }

    /**
     * 获取日常检查事项表id
     *
     * @return uid - 日常检查事项表id
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置日常检查事项表id
     *
     * @param uid 日常检查事项表id
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取检查内容名称
     *
     * @return CheckName - 检查内容名称
     */
    public String getCheckName() {
        return checkName;
    }

    /**
     * 设置检查内容名称
     *
     * @param checkName 检查内容名称
     */
    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    /**
     * 获取发现问题情况
     *
     * @return Problem - 发现问题情况
     */
    public String getProblem() {
        return problem;
    }

    /**
     * 设置发现问题情况
     *
     * @param problem 发现问题情况
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * 获取处置情况
     *
     * @return Dispose - 处置情况
     */
    public String getDispose() {
        return dispose;
    }

    /**
     * 设置处置情况
     *
     * @param dispose 处置情况
     */
    public void setDispose(String dispose) {
        this.dispose = dispose;
    }
}