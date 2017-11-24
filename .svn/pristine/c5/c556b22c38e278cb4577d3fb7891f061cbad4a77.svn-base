/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.specialrec.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_special_rec_item 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月03日
 */
@Table(name = "cs_special_rec_item")
public class SpecialRecItem implements Serializable {
	
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 唯一标识
     */
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 结果Uid
     */
    @Column(name = "ResultUid")
    private String resultUid;

    /**
     * 检查内容
     */
    @Column(name = "CheckContent")
    private String checkContent;

    /**
     * 发现问题情况
     */
    @Column(name = "CheckProblem")
    private String checkProblem;

    /**
     * 处置情况
     */
    @Column(name = "DisposalContent")
    private String disposalContent;

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
     * 获取唯一标识
     *
     * @return Uid - 唯一标识
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置唯一标识
     *
     * @param uid 唯一标识
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取结果Uid
     *
     * @return ResultUid - 结果Uid
     */
    public String getResultUid() {
        return resultUid;
    }

    /**
     * 设置结果Uid
     *
     * @param resultUid 结果Uid
     */
    public void setResultUid(String resultUid) {
        this.resultUid = resultUid;
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
    
    

    public String getCheckProblem() {
		return checkProblem;
	}

	public void setCheckProblem(String checkProblem) {
		this.checkProblem = checkProblem;
	}

	/**
     * 获取处置情况
     *
     * @return DisposalContent - 处置情况
     */
    public String getDisposalContent() {
        return disposalContent;
    }

    /**
     * 设置处置情况
     *
     * @param disposalContent 处置情况
     */
    public void setDisposalContent(String disposalContent) {
        this.disposalContent = disposalContent;
    }
}