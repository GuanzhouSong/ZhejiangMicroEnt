/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年03月29日
 * @version 2.0
 */
package com.icinfo.cs.mainmark.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.mainmark.dto.MainMarkDto;
import com.icinfo.cs.mainmark.model.MainMark;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_main_mark 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
public interface MainMarkMapper extends Mapper<MainMark> {

    /**
     * 描述: 分页列表
     * 
     * @author 张文男
     * @date 2017年3月30日
     * @param map
     * @return
     */

    public List<MainMarkDto> queryPageList(Map<String, Object> map);

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
     * 描述: 批量新增
     * @author 张文男
     * @date 2017年3月30日 
     * @param list 
     */

    public void insertBatch(List<MainMark> list);

    /** 
     * 描述: 新增
     * @author 张文男
     * @date 2017年4月6日 
     * @param bean 
     */

    public void insertOne(MainMark bean);

    /**
     * 描述: 更新
     * @author 张文男
     * @date 2017年3月30日
     * @param mainMark
     */

    public void updateByMarkUuid(MainMark mainMark);

    /** 
     * 描述: 根据企业id批量删除对应信息
     * @author 张文男
     * @date 2017年3月31日 
     * @param priPID 
     */

    public void deleteInPriPID(String priPID);

    /** 
    * 描述: 根据当前markuuid获取双随机第三级专项库code
    * @author 张文男
    * @date 2017年4月22日 
    * @param markUuid
    * @return 
    */
    public List<String> queryDoublyStoThiCodeListByMarkUuid(String markUuid);

}