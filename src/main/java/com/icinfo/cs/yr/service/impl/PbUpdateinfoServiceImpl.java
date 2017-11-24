/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.dto.PbUpdateinfoDto;
import com.icinfo.cs.yr.mapper.PbUpdateinfoMapper;
import com.icinfo.cs.yr.model.PbUpdateinfo;
import com.icinfo.cs.yr.service.IPbUpdateinfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_pb_updateinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月09日
 */
@Service
public class PbUpdateinfoServiceImpl extends MyBatisServiceSupport implements IPbUpdateinfoService {

	@Autowired
	PbUpdateinfoMapper pbUpdateinfoMapper;
	
	@Override
	public List<PbUpdateinfoDto> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pbUpdateinfoMapper.queryPageResult(request.getParams());
	}
	
	
	/**
	 * 
	 * 描述: 个体户比较两个修改对象
	 * @auther gaojinling
	 * @date 2016年10月12日 
	 * @param newEntity
	 * @param oldEntity
	 * @param strings
	 * @param anCheID
	 * @throws Exception
	 */
	public void doCompareEntity(Object newEntity, Object oldEntity,
			String[] strings, String anCheID) throws Exception {
		try {
			// 获取两个类中所有的属性
			Field[] fields1 = oldEntity.getClass().getDeclaredFields();
			Field[] fields2 = newEntity.getClass().getDeclaredFields();
			for (int i = 0; i < fields1.length; i++) {
				Field field1 = fields1[i];
				// 设置成可以操作private的变量
				field1.setAccessible(true);
				for (int j = 0; j < fields2.length; j++) {
					Field field2 = fields2[j];
					field2.setAccessible(true);
					for (String s : strings) {
						//对象1和对象2的属性都和s相等，进入if语句
						if (field1.getName() == s && field2.getName()==s) {
							//有一个属性有值且不是"",进入if
							if((field1.get(oldEntity) != null && !"".equals(field1.get(oldEntity))) || (field2.get(newEntity) != null && !"".equals(field2.get(newEntity))) ){
								PbUpdateinfo pbUpdateinfo = new PbUpdateinfo();
								//历史的为空，当前属性有值，添加
								if(field1.get(oldEntity)==null){
									pbUpdateinfo.setAltBe(null);
									pbUpdateinfo.setAltAf(String.valueOf(field2.get(newEntity)).replace("'","\\\'"));
								}
								//当前为空，历史有值  ，删除
								if(field2.get(newEntity)==null){
									pbUpdateinfo.setAltBe(String.valueOf(field1.get(oldEntity)).replace("'","\\\'"));
									pbUpdateinfo.setAltAf(null);
								}
								//当前的都有值且不相等，修改
								if(field1.get(oldEntity)!=null &&field2.get(newEntity)!=null&& !field1.get(oldEntity).equals(field2.get(newEntity))){
									pbUpdateinfo.setAltBe(String.valueOf(field1.get(oldEntity)).replace("'","\\\'"));
									pbUpdateinfo.setAltAf(String.valueOf(field2.get(newEntity)).replace("'","\\\'"));
								}
								//当前有值相等 break
								if(field1.get(oldEntity)!=null &&field2.get(newEntity)!=null&&field1.get(oldEntity).equals(field2.get(newEntity))){
									break;
								}

								pbUpdateinfo.setAltItem(field1.getName());
								pbUpdateinfo.setAltDate(new Date());
								pbUpdateinfo.setAnCheID(anCheID);
								// 获取类的名字
								String className = newEntity.getClass().getName();
								// 处理类的名字
								className = className.substring(className.lastIndexOf(".") + 1, className.length());
								// 比较类名

                                //chenyl 2016-10-14 updateinfo表中需要保存被修改表的主键
								String altID = "";
								String tempClassName = className.toUpperCase();
								if(tempClassName.indexOf("PBBASEINFO")>-1){
									altID = "anCheID";	 
								}
								if(tempClassName.indexOf("PBWEBSITEINFO")>-1){
									altID = "webid";	 
								}
								if(tempClassName.indexOf("PBLICENCEINFO")>-1){
									altID = "licID";	 
								}
								tempClassName = null;
								if(!"".equals(altID)){
									Field field = newEntity.getClass().getDeclaredField(altID);
									field.setAccessible(true);
									String id = (String) field.get(newEntity);
									//System.out.println("ClassName :"+tempClassName+"  +++++++++++++altID++++++++++++++++altID : "+id);
									pbUpdateinfo.setAltID(id);
								}
								
								pbUpdateinfo.setAltTable(className);
								pbUpdateinfo.setCreateTime(new Date());
								pbUpdateinfoMapper.insert(pbUpdateinfo);
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	/** 
	 * 描述: 比较两个list的历史记录
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param newList
	 * @param oldList
	 * @param fieldNames对比的依据(数组的集合必须是唯一的)
	 * @param strings要存入pubreportmodhis表中的属性的名称
	 * @param reportNo
	 * @param anCheID
	 * @throws Exception 
	 */
	public <T> void doCompareList(List<T> newList, List<T> oldList,
			String[] fieldNames, String[] strings, 
			String anCheID) throws Exception {
		boolean flag = false;
		if (newList != null && newList.size() > 0) {
			//遍历当前数据
			for (int i = 0; i < newList.size(); i++) {
				if (oldList != null && oldList.size() > 0) {
					flag = true;
					//遍历历史数据
					for (int j = 0; j < oldList.size(); j++) {
						//以fieldNames作为比较规则，去比较两个类型。
						if (isEqual(newList.get(i),oldList.get(j),fieldNames)) {
							// 比较对象
							this.doCompareEntity(newList.get(i), oldList.get(j), strings, anCheID);
							// 过滤修改的对象，剩下添加或者删除的对象，分别在newList或者oldList中
							newList.remove(i);
							oldList.remove(j);
							i--;
							j--;
							break;
						}
					}
				}
			}
		}
		// 如果flag为true，则不是第一次添加，需要保存到pubreportmodhis表中
		if (flag) {
			// 如果newList中有数据，说明这些数据是新添加的
			if (newList != null && newList.size() != 0) {
				for (int i = 0; i < newList.size(); i++) {
					Object oldEntity = getEntity(newList.get(i));
					this.doCompareEntity(newList.get(i),oldEntity, strings, anCheID);
				}
			}
		}
		// 如果oldList中有数据，说明这些数据是删除的
		if (oldList != null && oldList.size() != 0) {
			for (int i = 0; i < oldList.size(); i++) {
				// 比较对象
				Object newEntity = getEntity(oldList.get(i));
				this.doCompareEntity(newEntity,oldList.get(i), strings, anCheID);
			}
		}
	}
	
	
	/** 
	 * 描述: 要比较的属性的值是否都想等 
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param newEntity
	 * @param hisEntity
	 * @param strings要比较的属性(数组类型)
	 * @return 
	 */
	private <T> boolean isEqual(T newEntity, T hisEntity, String[] strings) {
		//遍历要比较的字段的属性
		for (String fieldName : strings) {
			//取到当前的比较字段属性的值
			String fieldValue = getFieldValue(newEntity, fieldName);
			//取到历史的比较字段的属性的值
			String hisFieldValue = getFieldValue(hisEntity, fieldName);
			//如果你传过来的string[] 中有一个属性值不同则认为不相等，返回false
			if(!fieldValue.equals(hisFieldValue)){
				return false;
			}
		}
		return true;
	}
	
	/** 
	 * 描述: 获取传入属性(fieldName)的值
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param entity
	 * @param fieldName
	 * @return 
	 */
	private <T> String getFieldValue(T entity, String fieldName) {
		String fieldValue = null;
		try {
			// 获取指定的属性
			Field field = entity.getClass().getDeclaredField(fieldName);
			// 可以访问私有属性
			field.setAccessible(true);
			// 获取指定属性的value
			fieldValue = String.valueOf(field.get(entity));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return fieldValue;
	}
	
	/** 
	 * 描述: 通过反射获取对象
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param entity
	 * @return 
	 */
	private <T> Object getEntity(T entity){
		Object object = null;
		try {
			//映射类中必须有默认构造方法，实例化对象。
			object = entity.getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return object;
	}
	
	/** 
	 * 描述: 更新历史信息年报编号
	 * @auther ZhouYan
	 * @date 2016年9月30日 
	 * @param anCheID
	 * @param reportNo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int updateHis(String anCheID, String reportNo) throws Exception {
		PbUpdateinfo pbUpdateinfo = new PbUpdateinfo();
		pbUpdateinfo.setReportNo(reportNo);
		pbUpdateinfo.setCreateTime(DateUtil.getSysDate());//时间戳
		Example example = new Example(PbUpdateinfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID).andIsNull("reportNo");
		return pbUpdateinfoMapper.updateByExampleSelective(pbUpdateinfo,example);
	}
	
	/** 
	 * 描述: 获取个体修改记录（用于敏感词审核）
	 * @auther yujingwei
	 * @date 2016年9月30日 
	 * @param request
	 * @return List<PbUpdateinfoDto>
	 * @throws Exception 
	 */
	public List<PbUpdateinfoDto> queryPageForbidWord(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		if(request!=null && request.getParams() !=null){
			return pbUpdateinfoMapper.selectInfoForbidWord(request.getParams()); 
		}
		return new ArrayList<PbUpdateinfoDto>();
	}
	
	
}