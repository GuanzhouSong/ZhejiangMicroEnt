/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.base.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_code_chgtype 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月09日
 */
@Table(name = "cs_code_chgtype")
public class CodeChgType implements Serializable {
    @Column(name = "code")
    private String code;

    @Column(name = "content")
    private String content;

    /**
     * 企业类型
     */
    @Column(name = "entTypeCatgs")
    private String entTypeCatgs;

    private static final long serialVersionUID = 1L;

    /**
     * @return code
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

    /**
     * @return content
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

	public String getEntTypeCatgs() {
		return entTypeCatgs;
	}

	public void setEntTypeCatgs(String entTypeCatgs) {
		this.entTypeCatgs = entTypeCatgs;
	}

}