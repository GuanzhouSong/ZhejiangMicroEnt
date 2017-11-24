/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_sccheck_key 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月08日
 */
@Table(name = "cs_sccheck_key")
public class SccheckKey implements Serializable {
    /**
     * 自增长序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 序号：UUID
     */
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 检查内容
     */
    @Column(name = "CheckContent")
    private String checkContent;

    /**
     * 操作方法与要领
     */
    @Column(name = "CheckMethod")
    private String checkMethod;

    /**
     * 是否检查1-是 2-否
     */
    @Column(name = "IsCheck")
    private String isCheck;

    /**
     * 发现问题
     */
    @Column(name = "Problem")
    private String problem;

    /**
     * 主任务UID
     */
    @Column(name = "TaskUid")
    private String taskUid;

    /**
     * 结果表UID
     */
    @Column(name = "ResultUid")
    private String resultUid;

    /**
     * 检查事项编码
     */
    @Column(name = "CheckCode")
    private String checkCode;
    
    /**
     * 默认描述
     */
    @Column(name = "YesText")
    private String yesText;
    
    /**
     * 默认描述
     */
    @Column(name = "NoText")
    private String noText;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增长序号
     *
     * @return id - 自增长序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增长序号
     *
     * @param id 自增长序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取序号：UUID
     *
     * @return Uid - 序号：UUID
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置序号：UUID
     *
     * @param uid 序号：UUID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取检查内容
     *
     * @return CheckContent - 检查内容
     */
    public String getCheckContent() {
        return checkContent;
    }

    /**
     * 设置检查内容
     *
     * @param checkContent 检查内容
     */
    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    /**
     * 获取操作方法与要领
     *
     * @return CheckMethod - 操作方法与要领
     */
    public String getCheckMethod() {
        return checkMethod;
    }

    /**
     * 设置操作方法与要领
     *
     * @param checkMethod 操作方法与要领
     */
    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod;
    }

    /**
     * 获取是否检查1-是 2-否
     *
     * @return IsCheck - 是否检查1-是 2-否
     */
    public String getIsCheck() {
        return isCheck;
    }

    /**
     * 设置是否检查1-是 2-否
     *
     * @param isCheck 是否检查1-是 2-否
     */
    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    /**
     * 获取发现问题
     *
     * @return Problem - 发现问题
     */
    public String getProblem() {
        return problem;
    }

    /**
     * 设置发现问题
     *
     * @param problem 发现问题
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * 获取主任务UID
     *
     * @return TaskUid - 主任务UID
     */
    public String getTaskUid() {
        return taskUid;
    }

    /**
     * 设置主任务UID
     *
     * @param taskUid 主任务UID
     */
    public void setTaskUid(String taskUid) {
        this.taskUid = taskUid;
    }

    /**
     * 获取结果表UID
     *
     * @return ResultUid - 结果表UID
     */
    public String getResultUid() {
        return resultUid;
    }

    /**
     * 设置结果表UID
     *
     * @param resultUid 结果表UID
     */
    public void setResultUid(String resultUid) {
        this.resultUid = resultUid;
    }

    /**
     * 获取检查事项编码
     *
     * @return CheckCode - 检查事项编码
     */
    public String getCheckCode() {
        return checkCode;
    }

    /**
     * 设置检查事项编码
     *
     * @param checkCode 检查事项编码
     */
    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

	public String getYesText() {
		return yesText;
	}

	public void setYesText(String yesText) {
		this.yesText = yesText;
	}

	public String getNoText() {
		return noText;
	}

	public void setNoText(String noText) {
		this.noText = noText;
	}
}