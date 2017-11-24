/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.registinfo.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.registinfo.dto.RegistMarkDto;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_regist_mark 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IRegistMarkService extends BaseService {

    /** 
     * 描述: 根据条件查询分页列表
     * @author 张文男
     * @date 2017年3月22日 
     * @param map
     * @return 
     */

    public List<RegistMark> queryPageList(PageRequest request);

    /** 
     * 描述: 检测标签名称是否存在
     * @author 张文男
     * @date 2017年3月22日 
     * @param IDName
     * @return 
     */

    public boolean checkRegistMarkByNameIDName(String IDName);

    /** 
     * 描述: 保存或修改
     * @author 张文男
     * @date 2017年3月22日 
     * @param registMark 
     */

    public void saveOrUpdate(RegistMark registMark);

    /**
     * 
     * 描述   根据uid更新
     * @author 赵祥江
     * @date 2017年3月23日 下午7:33:58 
     * @param 
     * @return void
     * @throws
     */
    public int UpdateRegistMark(RegistMark registMark);

    /** 
     * 描述: 物理删除
     * @author 张文男
     * @date 2017年3月22日 
     * @param id 
     */

    public void deleteById(Integer id);

    /** 
     * 描述: 根据父级code，获取子类列表
     * @author 张文男
     * @date 2017年3月22日 
     * @param IDCode
     * @return 
     */

    public List<RegistMark> queryChildListByParentCode(String IDCode);

    /**
     * 
     * 描述   根据主键查询
     * @author 赵祥江
     * @date 2017年3月23日 上午11:14:53 
     * @param 
     * @return RegistMark
     * @throws
     */
    public RegistMark selectRegistMarkBymarkUuid(String markUuid);

    /** 
     * 描述: 根据标签类别 获取 最大标签编号
     * @author 张文男
     * @date 2017年3月22日 
     * @param IDType
     * @return 
     */

    public String queryMaxIDCodeByLength(String IDType,String IDCode);

    /** 
     * 描述: 根据类型、父级code获取所有标签列表
     * @author 张文男
     * @date 2017年3月23日 
     * @param IDType
     * @return 
     */
    public List<RegistMark> queryListByIDType(String IDType,String pIDCode);

    /** 
     * 描述: 根据标签名称模糊查询列表
     * @author 张文男
     * @date 2017年4月24日 
     * @param IDName
     * @param userType
     * @param setDeptCode
     * @return 
     */

    public List<RegistMark> queryListInstrIDName(String IDName,String userType,String setDeptCode,String psetDeptCode);

    /**
     * @throws Exception 
     * 
     * 描述   分页查询审核列表
     * @author 赵祥江
     * @date 2017年3月22日 下午7:05:42 
     * @param 
     * @return List<RegistMarkDto>
     * @throws
     */
    public List<RegistMarkDto> queryRegistMarkAuditJSONList(PageRequest request) throws Exception;

    /** 
     * 描述: 根据主键获取对象
     * @author 张文男
     * @date 2017年3月23日 
     * @param id
     * @return 
     */

    public RegistMark queryRegistMarkById(Integer id);

    /** 
     * 描述: 根据uuid获取数据
     * @author 张文男
     * @date 2017年3月23日 
     * @param markUuid
     * @return 
     */

    public RegistMarkDto queryBeanByMarkUuid(String markUuid);

    /** 
     * 描述: 删除
     * @author 张文男
     * @date 2017年3月23日 
     * @param markUuid 
     */

    public void deleteByMarkUuid(String markUuid);

    /** 
     * 描述: 删除标签并删除企业与标签绑定关系
     * @author 张文男
     * @date 2017年4月20日 
     * @param markUuid
     * @param markCode 
     */

    public void deleteByMarkUuid(String markUuid,String markCode);

    /** 
     * 描述: 根据范围CODE获取有效的小类列表
     * @author 张文男
     * @date 2017年3月30日 
     * @param applicationScopeCode
     * @return 
     */

    public List<RegistMarkDto> queryValidSubTypeListByApplicationScopeCode(String applicationScopeCode);

    /** 
     * 描述: 根据用户信息获取有效小类标签
     * @author 张文男
     * @date 2017年4月19日 
     * @param sysUser
     * @param idname
     * @param priPID
     * @return 
     * @throws Exception 
     */

    public List<Map<String, Object>> queryValidSubTypeListByUserInfo(SysUserDto sysUser,String idname,String priPID) throws Exception;

    /** 
     * 描述: 根据用户信息及参数获取选中小类标签
     * @author 张文男
     * @date 2017年4月24日 
     * @param sysUser
     * @param idname
     * @param priPID
     * @param isShowCheckOnly 是否只显示选中小类
     * @return 
     * @throws Exception 
     */

    public List<Map<String, Object>> queryValidSubTypeListByUserInfo(SysUserDto sysUser,String idname,String priPID,boolean isShowCheckOnly) throws Exception;

   
    /** 
     * 描述: 根据用户信息及参数获取选中小类标签(户口建档)
     * @author 张文男
     * @date 2017年4月24日 
     * @param sysUser
     * @param idname
     * @param priPID
     * @param isShowCheckOnly 是否只显示选中小类
     * @return 
     */
    public List<Map<String, Object>> queryValidMarkByUserInfo(SysUserDto sysUser,String webidname,String priPID,boolean isShowCheckOnly) throws Exception;
    
    
    
    
    /** 
     * 描述: 根据code获取标签信息
     * @author 张文男
     * @date 2017年4月19日 
     * @param idcode
     * @return 
     */

    public RegistMarkDto queryByIDCode(String idcode);
    
    
    /** 
     * 描述: 根据code获取标签信息
     * @author 陈鑫
     * @date 2017年4月19日 
     * @param idcode
     * @return 
     */
    public RegistMark selectByIDCode(String idcode);

    /** 
     * 描述: 统计子类标签数量
     * @author 张文男
     * @date 2017年4月20日 
     * @param idcode
     * @return 
     */

    public Long queryCountLikeIDCode(String idcode);

    /** 
     * 描述: 根据父类code获取双随机子类列表 
     * @author 张文男
     * @date 2017年4月21日 
     * @param pcode
     * @return 
     */

    public List<RegistMarkDto> queryDoublyStoListByPcode(String pcode);

    /** 
     * 描述: 根据code获取双随机3级信息
     * @author 张文男
     * @date 2017年4月21日 
     * @param pcode
     * @return 
     */

    public List<RegistMarkDto> queryDoublyStoThiInfoByCode(String pcode);

    /**
     * 获取当前标签下的专项库标签
     */
    public List<RegistMark> queryDoublyStoThiInfo(String idCodes);    

    /** 
     * 描述: 获取标签信息(用于专项库查询)
     * @author yujingwei
     * @date 2017年4月19日 
     * @param Code
     * @return List<RegistMark>
     */
    public List<RegistMark> doGetRegistMarkInfoForDrcheck(String pCode) throws Exception;

    /** 
     * 描述: 根据markuuid获取双随机第三级专项库code及标签基本信息
     * @author 张文男
     * @date 2017年4月25日 
     * @param markUuid
     * @return 
     */

    public List<RegistMark> queryListByMarkUuid(String markUuid);
    
    /** 
     * 描述: 审核
     * @author 张文男
     * @date 2017年4月27日 
     * @param sysUser
     * @param registMap 
     * @throws Exception 
     */
    
    public void audit(SysUserDto sysUser, Map<String, String> registMap) throws Exception;
}
