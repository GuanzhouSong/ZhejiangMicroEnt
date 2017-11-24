/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.mainmark.service;

import java.util.List;

import com.icinfo.cs.mainmark.dto.MainMarkRelDto;
import com.icinfo.cs.mainmark.model.MainMarkRel;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_main_mark_rel 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
public interface IMainMarkRelService extends BaseService {

    /** 
     * 描述: 根据多个企业id，是否历史获取关系信息
     * @author 张文男
     * @date 2017年3月31日 
     * @param priPIDs
     * @param ishis
     * @return 
     */

    public List<MainMarkRelDto> queryListInPriPIDAndIshis(String priPIDs,String ishis);

    /** 
     * 描述: 根据多个企业id，是否历史获取关系信息
     * @author 张文男
     * @date 2017年3月31日 
     * @param priPIDs
     * @param type
     * @param ishis
     * @return 
     */

    public List<MainMarkRelDto> queryListInPriPIDAndIshis(String priPIDs,String type,String ishis);

    /** 
     * 描述: 根据多个企业id，是否历史删除关系信息
     * @author 张文男
     * @date 2017年3月31日 
     * @param map 
     */

    public void deleteInPriPIDAndIshis(String priPIDs,String ishis);

    /** 
     * 描述: 批量插入
     * @author 张文男
     * @date 2017年3月30日 
     * @param list 
     */

    public void insertBatch(List<MainMarkRel> list);

    /** 
     * 描述: 根据markUuid删除对应关系
     * @author 张文男
     * @date 2017年4月1日 
     * @param markUuid 
     */

    public void deleteByMarkUuid(String markUuid);

    /** 
     * 描述: 根据code修改名称
     * @author 张文男
     * @date 2017年4月6日 
     * @param markCode 
     */
    public void updateMarkNameByMarkCode(String markCode);

    /** 
     * 描述:  根据code修改名称
     * @author 张文男
     * @date 2017年4月6日 
     * @param map 
     */

    public void updateAllMarkNameByMarkCode(String markCode,String markName);

    /** 
     * 描述: 新增
     * @author 张文男
     * @date 2017年4月6日 
     * @param mainMarkRel 
     */

    public void insertOne(MainMarkRel mainMarkRel);

    /** 
    * 描述: 根据参数删除对应数据
    * @author 张文男
    * @date 2017年4月20日 
    * @param markCode
    * @param type
    * @param ishis 
    */

    public void deleteBy(String markCode,String type,String ishis);

    /**
     * 描述：根据pripid查询监管项目标签
     * @author baifangfang
     * @date 2017年4月19日
     * @param priPID
     * @return
     */
    public List<MainMarkRelDto> qryMainMarkRelDtoByPriPID(String priPID);

    /**
     * 
     * 描述: 根绝pripid查询企业所属标签(当前有效的标签)（分组化后）
     * @auther gaojinling
     * @date 2017年4月21日 
     * @param map
     * @return
     */
    public List<MainMarkRelDto> selectMainMarkRelDtoByPriPIDGroup(String priPID);

    /** 
    * 描述:根据企业id获取标签列表但不包含已设置双随机列表
    * @author 张文男
    * @date 2017年4月25日 
    * @param map
    * @return 
    */

    public List<MainMarkRelDto> queryListInPriPIDAndIshisAndNotIncludeDoublySto(String priPIDs,String type,String ishis);
}