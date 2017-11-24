package com.icinfo.cs.relation.dto;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.EntNameUtil;
 

public class RelationNodeDto {

	private String id;
	private String name;
	private String flag;
	private String key;
	private String category;
	private String longName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {

		try {
			this.name = EntNameUtil.getShortEntName(name);
			this.longName = name;
		} catch (Exception e) {
			this.name = name;
			e.printStackTrace();			
		}
		 
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getKey() {
		if("1".equals(this.getFlag()) && StringUtils.isNotBlank(key))
			return AESEUtil.encodeCorpid(key);
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCategory() {
		return this.getFlag();
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}
}
