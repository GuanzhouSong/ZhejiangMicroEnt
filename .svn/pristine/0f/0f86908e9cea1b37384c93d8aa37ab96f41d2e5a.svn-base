/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述:
 *
 * @author framework generator
 * @date 2016年08月28日
 * @version 2.0
 */
package com.icinfo.cs.im.mapper;

import com.icinfo.cs.im.dto.ImInvestmentDto;
import com.icinfo.cs.im.model.ImInvestment;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_im_investment 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface ImInvestmentMapper extends Mapper<ImInvestment> {

    /**
     *
     * 描述:  查询出资情况列表（即时信息）
     * @auther zhudefeng
     * @param qryMap 登陆主体身份ID
     * @date 2016年8月29日
     * @return 出资情况列表
     * @throws Exception
     */
    List<ImInvestmentDto> findInvestmentWithDetailByPriPID(Map<String,Object> qryMap)throws Exception;

    /**
     * 生成UUID
     * @author ZhuDefeng
     * @return
     * @throws Exception
     */
    String genInvId()throws Exception;

}