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

import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.registinfo.model.RegistMarkHis;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_regist_mark 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface RegistMarkHisMapper extends Mapper<RegistMarkHis> {

    /**
     * 
     * 描述   根据编号查询历史信息
     * @author 赵祥江
     * @date 2017年3月24日 上午10:54:40 
     * @param 
     * @return List<RegistMarkHis>
     * @throws
     */
    List<RegistMarkHis> selectRegistMarkHisListByIdCode(Map<String, Object> map);

    /** 
     * 描述: 根据code删除对应记录
     * @author 张文男
     * @date 2017年4月20日 
     * @param idcode 
     */
    
    public void deleteByIDCode(String idcode);
}