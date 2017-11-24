/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.base.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_code_regorg 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月12日
 */
@Table(name = "cs_code_regorg")
public class CodeRegorg implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    @Column(name = "ContentWord")
    private String contentWord;

    @Column(name = "ContentShort")
    private String contentShort;

    @Column(name = "Content")
    private String content;

    @Column(name = "Code")
    private String code;
    //登记机关联络员
    @Column(name = "LiaName")
    private String liaName;
    
    //联络员电话号码
    @Column(name = "LiaPhone")
    private  String liaPhone;


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
     * @return ContentWord
     */
    public String getContentWord() {
        return contentWord;
    }

    /**
     * @param contentWord
     */
    public void setContentWord(String contentWord) {
        this.contentWord = contentWord;
    }

    /**
     * @return ContentShort
     */
    public String getContentShort() {
        return contentShort;
    }

    /**
     * @param contentShort
     */
    public void setContentShort(String contentShort) {
        this.contentShort = contentShort;
    }

    /**
     * @return Content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return Code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setLiaName(String liaName) {
		this.liaName = liaName;
	}
    
    public String getLiaName() {
		return liaName;
	}
    
	public void setLiaPhone(String liaPhone) {
		this.liaPhone = liaPhone;
	}
	
	public String getLiaPhone() {
		return liaPhone;
	}
}