/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.mainmark.service;

import java.text.ParseException;
import java.util.List;

import com.icinfo.cs.mainmark.dto.MainMarkDto;
import com.icinfo.cs.mainmark.model.MainMark;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_main_mark 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
public interface IMainMarkService extends BaseService {

    /** 
     * 描述: 分页列表
     * @author 张文男
     * @date 2017年3月31日 
     * @param request
     * @return 
     */
    public List<MainMarkDto> queryPageList(PageRequest request);

    /** 
     * 描述: 保存企业与标签关系
     * @author 张文男
     * @date 2017年3月31日 
     * @param priPIDs
     * @param markCodes
     * @param markNames
     * @param setName
     * @param setTime
     * @param setDeptname
     * @throws ParseException 
     */

    public void saveOrUpdate(String priPIDs,String markCodes,String markNames,String setName,String setTime,String setDeptname,String setDeptCode) throws ParseException;
    
    /** 
     * 描述: 保存企业与标签关系
     * @author 张文男
     * @date 2017年4月25日 
     * @param priPIDs
     * @param markCodes
     * @param markNames
     * @param setName
     * @param setTime
     * @param setDeptname
     * @param setDeptCode
     * @param isDoublySto
     * @throws ParseException 
     */
    
    public void saveOrUpdate(String priPIDs,String markCodes,String markNames,String setName,String setTime,String setDeptname,String setDeptCode,boolean isDoublySto) throws ParseException;
    
    /** 
     * 描述: 双随机反向绑定标签
     * @author 张文男
     * @date 2017年4月25日 
     * @param priPIDs
     * @param list
     * @param user
     * @throws Exception 
     */
    
    public void saveOrUpdateForDoublySto(String priPIDs,List<RegistMark> list,SysUserDto user) throws Exception;

    /** 
     * 描述: 审核
     * @author 张文男
     * @date 2017年4月1日 
     * @param mainMark
     * @throws ParseException 
     */

    public void audit(MainMark mainMark,SysUserDto sysUser) throws Exception;

    /** 
     * 描述: 根据企业id批量删除对应信息
     * @author 张文男
     * @date 2017年3月31日 
     * @param priPID 
     */

    public void deleteInPriPID(String priPID);

    /** 
     * 描述: 根据标签id删除对应记录 
     * @author 张文男
     * @date 2017年4月1日 
     * @param markUuid 
     */

    public void deleteByMarkUuid(String markUuid);

    /**
     * 描述: 根据uuid获取信息
     * 
     * @author 张文男
     * @date 2017年3月30日
     * @param markUuid
     * @return
     */

    public MainMarkDto queryViewByMarkUuid(String markUuid);

    /**
     * 根据PriPID获取信息
     * @param priPID
     * @return
     */
    public MainMarkDto queryViewByMarkPriPID(String priPID);

    /** 
     * 批量插入
     * 描述: TODO
     * @author 张文男
     * @date 2017年4月6日 
     * @param list 
     */

    public void insertBatch(List<MainMark> list);
    
    /**
     * 描述: 判断是否带有食品仓储标签企业
     * @author yujingwei
     * @date 2017年5月24日
     * @param priPID
     * @return boolean
     */
	public boolean doJudgeIsFoodStorageEnt(String priPID) throws Exception;
    
}