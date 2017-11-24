/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.sment.dto.EntarchivesDto;
import com.icinfo.cs.sment.model.Entarchives;
import com.icinfo.cs.sment.model.EntarchivesAdjust;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:   小微企业培育档案库 sm_bus_entarchives 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
public interface IEntarchivesService extends BaseService {
    
    /** 
     * 描述: 保存或修改
     * @author 张文男
     * @date 2017年4月27日 
     * @param bean 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws InstantiationException 
     * @throws IllegalAccessException 
     */
    
    public void saveOrUpdate(EntarchivesDto bean,SysUserDto sysUser) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException;
    
    
    /** 
     * 描述: 保存修改帮扶信息-是否开启事务
     * @author 张文男
     * @date 2017年4月28日 
     * @param bean
     * @param isTransactional 
     */
    
    public void saveOrUpdateForHelp(EntarchivesDto bean,boolean isTransactional);
    
    /** 
     * 描述: 根据uid获取对应数据
     * @author 张文男
     * @date 2017年4月27日 
     * @param uid
     * @return 
     */
    
    public EntarchivesDto queryBeanByUID(String uid);
    
    /** 
     * 描述: 根据uuid更新数据
     * @author 张文男
     * @date 2017年4月28日 
     * @param bean 
     */
    
    public void updateByUID(Entarchives bean);
    
    /** 
     * 描述: 根据pripid获取信息
     * @author 张文男
     * @date 2017年5月4日 
     * @param priPID
     * @return 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */
    
    public  EntarchivesDto queryEntarchivesDtoByPriPID(String priPID) throws IllegalAccessException, InvocationTargetException;
    
    /** 
     * 描述: 根据pripid获取信息
     * @author 张文男
     * @date 2017年5月8日 
     * @param priPID
     * @return 
     */
    
    public  Entarchives queryEntarchivesByPriPID(String priPID);
    
    /** 
     * 描述: 移除培育库
     * @author 张文男
     * @date 2017年5月5日 
     * @param bean
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException 
     */
    
    public void remove(EntarchivesAdjust bean)  throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException; 
    
    /** 
     * 描述: 根据企业id删除培育库数据
     * @author 张文男
     * @date 2017年5月5日 
     * @param priPID 
     */
    
    public  void deleteByPriPID(String priPID);
    
    /** 
     * 描述: 初始化负责人 和联络员
     * 
     * @author zhuyong
     * @date 2017年5月4日
     */ 
    public EntarchivesDto initEntarchivesDto(EntarchivesDto dto) throws Exception;
    
    /** 
     * 描述: 根据用户部门code、培育库类型，获取待添加培育库数量
     * @author 张文男
     * @date 2017年6月15日 
     * @param sysUser
     * @param cultivationTypeCode
     * @return 
     */
    
    public int count(SysUserDto sysUser,String cultivationTypeCode);
    
    /** 
     * 描述: 统计帮扶信息
     * @author 张文男
     * @date 2017年6月20日 
     * @return
     */
    
    public int countByHelp(SysUserDto sysUser, PageRequest request);
    
    /** 
     * 描述: 统计入库企业违法违规数量
     * @author 张文男
     * @date 2017年6月23日 
     * @param setDeptCode
     * @return 
     */
    
    public Long countWfwgBySetDeptCode(SysUserDto sysUser);
    
    /** 
     * 描述: 统计入库企业经营异常数量
     * @author 张文男
     * @date 2017年6月23日 
     * @param setDeptCode
     * @return 
     */
    
    public Long countJyycBySetDeptCode(SysUserDto sysUser);
    
    /** 
     * 描述:  统计入库企业上规升级数量
     * @author 张文男
     * @date 2017年6月26日 
     * @param map
     * @return 
     */
    
    public Long countSgsjBySetDeptCode(SysUserDto sysUser);
    
    /** 
     * 描述: 统计入库企业经营下降20%数量
     * @author 张文男
     * @date 2017年6月26日 
     * @param setDeptCode
     * @return 
     */
    
    public Long  countJyxjBySetDeptCode(SysUserDto sysUser);
    
    /**
     * 
     * 描述: 统计培育库企业企业类型
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto cultivationTypeScount(Map<String, Object> map) throws Exception;
    /**
     * 
     * 描述: 统计培育库企业企业类型
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto qyflCount(Map<String, Object> map) throws Exception;
    /**
     * 
     * 描述: 统计培育库企业企业类型
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto industryTypeCount(Map<String, Object> map) throws Exception;
    
    /**
     * 
     * 描述: 统计培育库企业企业类型
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto entCrowdCodeCount(Map<String, Object> map) throws Exception;
    
    /**
     * 
     * 描述: 统计培育库企业营业总收入
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public List<EntarchivesDto> vendIncCount(Map<String, Object> map) throws Exception;
      
}