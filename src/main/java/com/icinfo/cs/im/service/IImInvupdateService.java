/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service;

import java.util.List;

import com.icinfo.cs.im.dto.ImInvupdateDto;
import com.icinfo.cs.im.model.ImInvupdate;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    出资修改信息 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IImInvupdateService extends BaseService {

    /**
     * 描述:保存出资修改信息
     *
     * @param imInvupdate 出资修改信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    int insert(ImInvupdate imInvupdate) throws Exception;


    /**
	 * 描述：查询股东及出资信息
	 * 
	 * @author zhuyong
	 * @date 2016年10月20日
	 * @param priPID
	 * @return
	 */
	List<ImInvupdateDto> queryList(PageRequest request) throws Exception;
	/**
	 * 
	 * 描述: 查询for公示
	 * @auther ljx
	 * @date 2016年11月1日 
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
    List<ImInvupdate> queryListForPub(String priPID)throws Exception;
	


}