/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.im.dto.ImInvupdateDto;
import com.icinfo.cs.im.mapper.ImInvupdateMapper;
import com.icinfo.cs.im.model.ImInvupdate;
import com.icinfo.cs.im.service.IImInvupdateService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;


/**
 * 描述:    即时信息-股东及出资情况 对应的Service接口实现类.<br>
 *
 * @author 朱德峰
 * @date 2016年08月28日
 */
@Service
public class ImInvupdateServiceImpl extends MyBatisServiceSupport implements IImInvupdateService {

    @Autowired
    private ImInvupdateMapper invupdateMapper;


    /**
     * 描述:  保存出资修改信息
     *
     * @param imInvupdate 出资修改信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int insert(ImInvupdate imInvupdate) throws Exception {
        return invupdateMapper.insert(imInvupdate);
    }


    /**
	 * 描述：获取股东及出资方JSON数据列表
	 * 
	 * @author zhuyong
	 * @date 2016年10月24日
	 * @param params
	 * @return
	 */
	@Override
	public List<ImInvupdateDto> queryList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return invupdateMapper.queryList(request.getParams());
	}


	@Override
	public List<ImInvupdate> queryListForPub(String priPID) throws Exception {
	      Example example=new Example(ImInvupdate.class);
	      example.createCriteria().andEqualTo("priPID", priPID);
		  return invupdateMapper.selectByExample(example);
	}
    
    

}