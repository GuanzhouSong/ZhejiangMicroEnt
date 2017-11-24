/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.model.SfcUpdateinfo;

/**
 * 描述:    cs_sfc_updateinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月10日
 */
public class SfcUpdateinfoDto extends SfcUpdateinfo {
	// TODO
		private static final long serialVersionUID = 1L;

		private String altBe;// 修改前

		private String altAf;// 修改后
		
		private String dicValue;//修改字段
		
		private String altItemName;//修改事项对应字典名称

		public String getDicValue() {
			return dicValue;
		}

		public void setDicValue(String dicValue) {
			this.dicValue = dicValue;
		}

		public String getAltBe() {
			return altBe;
		}

		public void setAltBe(String altBe) {
			this.altBe = altBe;
		}

		public String getAltAf() {
			return altAf;
		}

		public void setAltAf(String altAf) {
			this.altAf = altAf;
		}
		// 增加敏感词过滤方法 2016-11-04 重新修改 chenyulong
		public void doFilterForbidword() {
			this.altBe = KeywordFilter.getReplaceCon(altBe);
			this.altAf = KeywordFilter.getReplaceCon(altAf);
		}

		public String getAltItemName() {
			return altItemName;
		}

		public void setAltItemName(String altItemName) {
			this.altItemName = altItemName;
		}
}