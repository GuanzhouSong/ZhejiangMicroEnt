/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.mainmark.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.mainmark.dto.MainMarkRelDto;
import com.icinfo.cs.mainmark.mapper.MainMarkRelMapper;
import com.icinfo.cs.mainmark.model.MainMarkRel;
import com.icinfo.cs.mainmark.service.IMainMarkRelService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;

/**
 * 描述:    cs_main_mark_rel 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
@Service
public class MainMarkRelServiceImpl extends MyBatisServiceSupport implements IMainMarkRelService {

    @Autowired
    private MainMarkRelMapper mainMarkRelMapper;

    /** 
     * 描述: 根据多个企业id，是否历史获取关系信息
     * @author 张文男
     * @date 2017年3月31日 
     * @param priPIDs
     * @param ishis
     * @return 
     */
    @Override
    public List<MainMarkRelDto> queryListInPriPIDAndIshis(String priPIDs,String ishis){
        Map<String, Object> map = new HashMap<String, Object> ();
        priPIDs = StringUtil.doSplitStringToSqlFormat (priPIDs, ",");
        map.put ("priPID", priPIDs);
        map.put ("ishis", ishis);
        return mainMarkRelMapper.queryListInPriPIDAndIshis (map);
    }

    /** 
     * 描述: 根据多个企业id，是否历史删除关系信息
     * @author 张文男
     * @date 2017年3月31日 
     * @param map 
     */
    @Override
    public void deleteInPriPIDAndIshis(String priPIDs,String ishis){
        Map<String, Object> map = new HashMap<String, Object> ();
        priPIDs = StringUtil.doSplitStringToSqlFormat (priPIDs, ",");
        map.put ("priPID", priPIDs);
        map.put ("ishis", ishis);
        mainMarkRelMapper.deleteInPriPIDAndIshis (map);
    }

    /** 
     * 描述: 批量插入
     * @author 张文男
     * @date 2017年3月30日 
     * @param list 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBatch(List<MainMarkRel> list){
        for ( MainMarkRel mainMarkRel : list ) {
            mainMarkRelMapper.insertOne (mainMarkRel);
        }
    }

    /** 
     * 描述: 根据多个企业id，是否历史获取关系信息
     * @author 张文男
     * @date 2017年3月31日 
     * @param priPIDs
     * @param ishis
     * @return 
     */
    @Override
    public List<MainMarkRelDto> queryListInPriPIDAndIshis(String priPIDs,String type,String ishis){
        Map<String, Object> map = new HashMap<String, Object> ();
        priPIDs = StringUtil.doSplitStringToSqlFormat (priPIDs, ",");
        map.put ("priPID", priPIDs);
        map.put ("ishis", ishis);
        map.put ("type", type);
        return mainMarkRelMapper.queryListInPriPIDAndIshis (map);
    }

    /** 
     * 描述: 根据markUuid删除对应关系
     * @author 张文男
     * @date 2017年4月1日 
     * @param markUuid 
     */
    @Override
    public void deleteByMarkUuid(String markUuid){
        Example e = new Example (MainMarkRel.class);
        Criteria c = e.createCriteria ();
        c.andEqualTo ("markUuid", markUuid);
        mainMarkRelMapper.deleteByExample (e);
    }

    /** 
     * 描述: 根据code修改名称
     * @author 张文男
     * @date 2017年4月6日 
     * @param markCode 
     */
    public void updateMarkNameByMarkCode(String markCode){
        mainMarkRelMapper.updateMarkNameByMarkCode (markCode);
    }

    /** 
     * 描述:  根据code修改名称
     * @author 张文男
     * @date 2017年4月6日 
     * @param map 
     */

    public void updateAllMarkNameByMarkCode(String markCode,String markName){
        Map<String, Object> map = new HashMap<String, Object> ();
        map.put ("markCode", markCode);
        map.put ("markName", markName);
        mainMarkRelMapper.updateAllMarkNameByMarkCode (map);
    }

    /** 
     * 描述: 新增
     * @author 张文男
     * @date 2017年4月6日 
     * @param mainMarkRel 
     */

    public void insertOne(MainMarkRel mainMarkRel){
        mainMarkRelMapper.insertOne (mainMarkRel);
    }

    /** 
    * 描述: 根据参数删除对应数据
    * @author 张文男
    * @date 2017年4月20日 
    * @param markCode
    * @param type
    * @param ishis 
    */

    public void deleteBy(String markCode,String type,String ishis){
        MainMarkRel bean = new MainMarkRel ();
        bean.setMarkCode (markCode);
        bean.setType (type);
        bean.setIshis (ishis);
        mainMarkRelMapper.deleteByBean (bean);
    }

    @Override
    public List<MainMarkRelDto> qryMainMarkRelDtoByPriPID(String priPID){
        Map<String, Object> map = new HashMap<String, Object> ();
        map.put ("priPID", priPID);
        return mainMarkRelMapper.selectMainMarkRelDtoByPriPID (map);
    }

    /**
     * 
     * 描述: 根绝pripid查询企业所属标签(当前有效的标签)（分组化后）
     * @auther gaojinling
     * @date 2017年4月21日 
     * @param map
     * @return
     */
    public List<MainMarkRelDto> selectMainMarkRelDtoByPriPIDGroup(String priPID){
        Map<String, Object> map = new HashMap<String, Object> ();
        map.put ("priPID", priPID);
        return mainMarkRelMapper.selectMainMarkRelDtoByPriPIDGroup (map);
    }

    /** 
    * 描述:根据企业id获取标签列表但不包含已设置双随机列表
    * @author 张文男
    * @date 2017年4月25日 
    * @param map
    * @return 
    */

    public List<MainMarkRelDto> queryListInPriPIDAndIshisAndNotIncludeDoublySto(String priPIDs,String type,String ishis){
        Map<String, Object> map = new HashMap<String, Object> ();
        priPIDs = StringUtil.doSplitStringToSqlFormat (priPIDs, ",");
        map.put ("priPID", priPIDs);
        map.put ("ishis", ishis);
        map.put ("type", type);
        List<MainMarkRelDto> list =  mainMarkRelMapper.queryListInPriPIDAndIshisAndNotIncludeDoublySto (map);
        return list;
    }
}