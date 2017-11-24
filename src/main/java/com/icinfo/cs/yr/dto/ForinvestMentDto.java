/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.model.ForinvestMent;

/**
 * 描述:    cs_forinvestment 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public class ForinvestMentDto extends ForinvestMent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4651994429553115208L;
	/**
	 * 所投资企业名称
	 */
	private String entName;
	
	 /**
     * 获取所投资企业名称
     *
     * @return EntName - 所投资企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 
     * 描述: 设置所投资企业名称（过滤敏感词）
     * @auther chenyl
     * @date 2016年10月10日 
     * @param entName
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }
    
    /**
     * 修改记录表名
     */
    private String altTable;
    /**
     * 修改记录列名
     */
    private String altItem;
	public String getAltTable() {
		return altTable;
	}

	public void setAltTable(String altTable) {
		this.altTable = altTable;
	}

	public String getAltItem() {
		return altItem;
	}

	public void setAltItem(String altItem) {
		this.altItem = altItem;
	}
	
	// 增加敏感词过滤方法 2016-11-04 重新修改 chenyulong
	public void doFilterForbidword() {
		this.entName = KeywordFilter.getReplaceCon(entName);
	}
}