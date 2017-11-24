/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月09日
 * @version 2.0
 */
package com.icinfo.cs.registinfo.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.registinfo.dto.RegistInfoDto;
import com.icinfo.cs.registinfo.dto.RegistMarkDto;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_regist_mark 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface RegistMarkMapper extends Mapper<RegistMark> {

    int batchInsertByiDCode(RegistMark registMark);

    List<RegistMark> selectCsWarnMarkGroupByType(RegistInfoDto example);

    /**
     * 描述: 根据条件查询分页列表
     * 
     * @author 张文男
     * @date 2017年3月22日
     * @param map
     * @return
     */

    List<RegistMark> queryPageList(Map<String, Object> map);

    /**
     * 描述: 根据标签编号长度获取最大编号
     * 
     * @author 张文男
     * @date 2017年3月22日
     * @param map
     * @return
     */

    String queryMaxIDCodeByLength(Map<String, Object> map);

    /**
     * 描述: 根据idcode like查询获取列表
     * 
     * @author 张文男
     * @date 2017年3月23日
     * @param map
     * @return
     */

    List<RegistMark> queryListLikeIDCode(Map<String, String> map);

    /**
     * 描述: 根据标签名称模糊查询列表
     * 
     * @author 张文男
     * @date 2017年3月23日
     * @param map
     * @return
     */

    List<RegistMark> queryTopListInstrIDName(Map<String, Object> map);

    /**
     * 
     * 描述 分页查询审核列表 @author 赵祥江 @date 2017年3月22日 下午7:11:00 @param @return
     * List<RegistMarkDto> @throws
     */
    public List<RegistMarkDto> selectRegistMarkAuditList(Map<String, Object> queryMap) throws Exception;

    /**
     * 描述: 根据uuid获取数据
     * 
     * @author 张文男
     * @date 2017年3月23日
     * @param markUuid
     * @return
     */

    public RegistMarkDto queryBeanByMarkUuid(String markUuid);

    /**
     * 描述: 删除
     * 
     * @author 张文男
     * @date 2017年3月23日
     * @param markUuid
     */

    public void deleteByMarkUuid(String markUuid);

    /**
     * 描述: 更新
     * 
     * @author 张文男
     * @date 2017年3月23日
     * @param map
     */

    public void updateByMarkUuid(RegistMark bean);

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
     * @date 2017年3月30日
     * @param queryMap
     * @return
     */
    public List<RegistMarkDto> queryValidSubTypeListByUserInfo(Map<String, Object> queryMap);

    /** 
     * 描述: 根据code获取标签信息
     * @author 张文男
     * @date 2017年4月19日 
     * @param idcode
     * @return 
     */
    
    public RegistMarkDto queryByIDCode(String idcode);
    
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
     * 描述: 根据markuuid获取双随机第三级专项库code及标签基本信息
     * @author 张文男
     * @date 2017年4月25日 
     * @param markUuid
     * @return 
     */
    
    public List<RegistMark>  queryListByMarkUuid(String markUuid);
}