/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.im.mapper.ImInvsraltMapper;
import com.icinfo.cs.im.model.ImInvsralt;
import com.icinfo.cs.im.service.IImInvsraltService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    股权变更信息 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class ImInvsraltServiceImpl extends MyBatisServiceSupport implements IImInvsraltService {

    @Autowired
    private ImInvsraltMapper imInvsraltMapper;
    @Autowired
    private IEsManageService manageService; 
    /**
     * 描述:  保存股权变更信息
     *
     * @param imInvsralt 股权变更信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int insert(ImInvsralt imInvsralt) throws Exception {
        return imInvsraltMapper.insert(imInvsralt);
    }

    /**
     * 描述:  删除股权变更信息
     *
     * @param invAltId 股权变更信息ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int delByInvAltId(String invAltId,String priPID) throws Exception {
        ImInvsralt imInvsralt=new ImInvsralt();
        imInvsralt.setPriPID(priPID);
        imInvsralt.setInvAltID(invAltId);
        return imInvsraltMapper.delete(imInvsralt);
    }

    /**
     * 描述:  修改股权变更信息
     *
     * @param imInvsralt 股权变更信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int update(ImInvsralt imInvsralt) throws Exception {
        Example example=new Example(ImInvsralt.class);
        example.createCriteria().andEqualTo("invAltID",imInvsralt.getInvAltID()).andEqualTo("priPID", imInvsralt.getPriPID());
        return imInvsraltMapper.updateByExampleSelective(imInvsralt, example);
    }

    /**
     * 描述:  分页查询股权变更信息
     *
     * @param pageRequest 查询参数
     * @param priPID 主体ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public List<ImInvsralt> queryPage(PageRequest pageRequest,String priPID)throws Exception{
//        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getLength());
        Example example=new Example(ImInvsralt.class);
        example.createCriteria().andEqualTo("priPID",priPID);
        return imInvsraltMapper.selectByExample(example);
    }
    
    /**
     * 描述:  分页查询股权变更信息
     *
     * @param pageRequest 查询参数
     * @param priPID 主体ID
     * @return
     * @throws Exception
     * @auther chenyu
     * @date 2016年8月31日
     */
    @Override
    public List<ImInvsralt> queryPageForPub(PageRequest pageRequest,String priPID)throws Exception{
          //int pageNum=Integer.parseInt(pageRequest.getParams().get("pageNum").toString());
    	  PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getLength());
          Example example=new Example(ImInvsralt.class);
            example.createCriteria().andEqualTo("pubFlag","1").andEqualTo("priPID",priPID);
       return imInvsraltMapper.selectByExample(example);
    }
    
	@Override
	public List<ImInvsralt> queryPage(PageRequest pageRequest) throws Exception {
		Map<String, Object> params = pageRequest.getParams();
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getLength());
		Example example = new Example(ImInvsralt.class);
		example.createCriteria().andEqualTo("pubFlag", "1").andEqualTo("priPID", params.get("priPID"));
		return imInvsraltMapper.selectByExample(example);
	}
    
    /**
     * 描述:  根据股权变更信息ID查询股权变更信息
     *
     * @param invAltID 股权变更信息ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public ImInvsralt findByInvAltID(String invAltID,String priPID) throws Exception {
        //Example example=new Example(ImInvsralt.class);
        ImInvsralt imInvsralt=new ImInvsralt();
        imInvsralt.setInvAltID(invAltID);
        if(StringUtils.isNotEmpty(priPID)){
        imInvsralt.setPriPID(priPID);
        }
        return imInvsraltMapper.selectOne(imInvsralt);
    }


    /**
     * 描述:  根据主体身份ID来公示所有的股权变更信息
     *
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年9月09日
     */
    @Override
    public void pubAll(String priPID) throws Exception {
        Example example=new Example(ImInvsralt.class);
        //已经公示的就不用更新了  2016-9-28 chenyl
        example.createCriteria().andEqualTo("priPID",priPID).andNotEqualTo("pubFlag", Constants.PUB_FLG_Y);
        ImInvsralt imCaseMod=new ImInvsralt();
        imCaseMod.setPubFlag(Constants.PUB_FLG_Y);
        //增加公示日期
        imCaseMod.setPublicDate(new Date());
        manageService.updateOnePanoramaIdx(priPID);
        imInvsraltMapper.updateByExampleSelective(imCaseMod,example);
    }
}