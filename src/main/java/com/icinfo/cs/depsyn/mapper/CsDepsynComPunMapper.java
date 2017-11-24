/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年12月12日
 * @version 2.0
 */
package com.icinfo.cs.depsyn.mapper;

import com.icinfo.cs.depsyn.dto.CsDepsynComPunDto;
import com.icinfo.cs.depsyn.model.CsDepsynComPun;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_com_pun 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
public interface CsDepsynComPunMapper extends Mapper<CsDepsynComPun> {

    /**
     * 根据证照号码/证件号码, 姓名查询
     *
     * @param params 查询参数
     * @return 查询结果
     */
    List<CsDepsynComPunDto> queryComPun(Map<String, Object> params);
    List<CsDepsynComPunDto> searchFeedBackList(Map<String, Object> paramMap);
}