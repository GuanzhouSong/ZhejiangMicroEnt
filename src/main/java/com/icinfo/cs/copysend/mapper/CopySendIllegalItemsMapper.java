/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月01日
 * @version 2.0
 */
package com.icinfo.cs.copysend.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.copysend.dto.CopySendIllegalItemsDto;
import com.icinfo.cs.copysend.model.CopySendIllegalItems;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_copy_send_illegal_items 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年11月01日
 */
public interface CopySendIllegalItemsMapper extends Mapper<CopySendIllegalItems> {
	/**
     * 描述：获取涉嫌违法事项列表
     * @author ylr
     * @date 2016-11-1
     * @throws Exception
     */
	List<CopySendIllegalItems> selectCopySendIllegalItemsList(Map<String, Object> qryMap) throws Exception;
	
	/**
     * 描述：获取涉嫌违法事项维护列表
     * @author chenyu
     * @date 2016-11-1
     * @throws Exception
     */
	List<CopySendIllegalItemsDto> selectCopySendIllegalItemsWeiHuList(Map<String, Object> qryMap) throws Exception;
	
	/**
     * 描述：插入涉嫌违法事项
     * @author chenyu
     * @date 2016-11-1
     */
	public int insert(CopySendIllegalItems copySendIllegalItems) ;
	
	/**
     * 描述：根据ID获取涉嫌违法事项
     * @author 陈宇
     * @date 2016-11-1
     * @throws Exception
     */
	public CopySendIllegalItemsDto selectCopySendIllegalItemsWeiHuById(String id) throws Exception;
}