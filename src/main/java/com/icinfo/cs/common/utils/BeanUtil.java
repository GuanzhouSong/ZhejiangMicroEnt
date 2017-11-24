package com.icinfo.cs.common.utils;

import java.math.BigDecimal;

import org.apache.commons.beanutils.BeanUtilsBean;

public class BeanUtil {
	
	/** 
	 * 描述: 初始化BeanUtilsBean（解决Date,BigDecimal等类型为null时复制属性报错问题）
	 * @auther yujingwei
	 * @date 2016年8月29日 
	 * @param 
	 * @return beanUtilsBean
	 */
	public static BeanUtilsBean getBeanUtilsBean(){
		BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
		beanUtilsBean.getConvertUtils().register(
				new org.apache.commons.beanutils.converters.BigDecimalConverter(null), BigDecimal.class);  
		beanUtilsBean.getConvertUtils().register(
				new org.apache.commons.beanutils.converters.DateConverter(null), java.util.Date.class);  
		beanUtilsBean.getConvertUtils().register(
				new org.apache.commons.beanutils.converters.SqlTimestampConverter(null), java.sql.Timestamp.class);  
		beanUtilsBean.getConvertUtils().register(
				new org.apache.commons.beanutils.converters.SqlDateConverter(null), java.sql.Date.class);  
		beanUtilsBean.getConvertUtils().register(
				new org.apache.commons.beanutils.converters.SqlTimeConverter(null), java.sql.Time.class);  
		return beanUtilsBean;
	}
}
