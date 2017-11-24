/**
 * Copyright@ 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 工具文件 <br/>
 * @author chenxin
 * @date 2016-09-19
 * @version 1.0
 */
package com.icinfo.cs.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.icinfo.cs.system.model.SysLogJsonItem;

/** 
 * 描述: 对象字段比对（用于保存日志）
 * @author chenxin
 * @date 2016年9月19日  
 */
public class ObjectComparator {
	public static List<SysLogJsonItem> compareObject(Object oldObject, Object newObject)
			throws Exception {
		Class clazz1 = oldObject.getClass();
		Class clazz2 = newObject.getClass();
		if (!clazz1.getName().equals(clazz2.getName())) {
			return null;
		}
		Field fields1[] = clazz1.getDeclaredFields();
		Field fields2[] = clazz2.getDeclaredFields();
		if(fields1 == null||fields2 == null){
			return null;
		}
		List<SysLogJsonItem> logJsonItemList= new ArrayList<SysLogJsonItem>();
		SysLogJsonItem logJsonItem;		
		for (int i = 0; i < fields1.length; i++) {
			Field field1 = fields1[i];
			// 设置成可以操作private的变量
			field1.setAccessible(true);		
			
			//自定义属性，不作比较
			if(field1.getGenericType().toString().startsWith("class com.icinfo")){
				continue;
			}
			//任何描述字段,List字段不作比较
			if(field1.getName().toString().endsWith("Desc") || field1.getName().toString().endsWith("List")){
				continue;
			}
			for (int j = 0; j < fields2.length; j++) {
				Field field2 = fields1[j];
				field2.setAccessible(true);
				// 是否是同一个属性
				if (field1.getName().equals(field2.getName())) {
					//当新属性为null时，是更改不掉DB的
					if(field2.get(newObject) ==null){						
						continue;
					}
					/*//自定义属性继续比较
					if(field2.getGenericType().toString().startsWith("class com.icinfo")){						
						List<LogJsonItem> subLogJsonItemList = ObjectComparator.compareObject(getFieldValueByName(field1.getName(),oldObject), getFieldValueByName(field2.getName(),newObject));
						logJsonItemList.addAll(subLogJsonItemList);
						continue;
					}*/
					// 两个值是否相等
					if (!field2.get(newObject).equals(field1.get(oldObject))) {
						boolean flag;
						if(field1.get(oldObject)==null){
							flag=true;
						}else{
							flag = StringUtils.isBlank(field2.get(newObject).toString());
						}
						if(!(StringUtils.isBlank(field2.get(newObject).toString())&& flag)){							
							String beforeValue = (field1.get(oldObject) == null ? null : field1.get(oldObject).toString());							
							String afterValue = (field2.get(newObject) == null ? null : field2.get(newObject).toString());							
							logJsonItem = new SysLogJsonItem(field1.getName(),beforeValue,afterValue);						
							logJsonItemList.add(logJsonItem);
						}						
					}
				}
			}
		}
		return logJsonItemList;
	}
}
