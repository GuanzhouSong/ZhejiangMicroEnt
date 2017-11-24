/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.im.mapper.ImIppldgMapper;
import com.icinfo.cs.im.model.ImIppldg;
import com.icinfo.cs.im.service.IImIppldgService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    知识产权出质登记信息 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class ImIppldgServiceImpl extends MyBatisServiceSupport implements IImIppldgService {

    @Autowired
    private ImIppldgMapper imIppldgMapper;
    @Autowired
    private IEsManageService manageService;

    /**
     * 描述:  保存知识产权出质登记信息
     *
     * @param iImIppldg 知识产权出质登记信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int insert(ImIppldg iImIppldg) throws Exception {
        return imIppldgMapper.insert(iImIppldg);
    }

    /**
     * 描述:  修改知识产权出质登记信息
     *
     * @param iImIppldg 知识产权出质登记信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int update(ImIppldg iImIppldg) throws Exception {
        Example example=new Example(ImIppldg.class);
        example.createCriteria().andEqualTo("pleID",iImIppldg.getPleID()).andEqualTo("priPID",iImIppldg.getPriPID());
        return imIppldgMapper.updateByExampleSelective(iImIppldg,example);
    }

    /**
     * 描述:  删除知识产权出质登记信息
     *
     * @param pleID 知识产权出质登记信息ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int deleteByPleID(String pleID,String priPID) throws Exception {
        ImIppldg iImIppldg=new ImIppldg();
        iImIppldg.setPleID(pleID);
        iImIppldg.setPriPID(priPID);
        return imIppldgMapper.delete(iImIppldg);
    }

    /**
     * 描述:  分页查询知识产权出质登记信息
     *
     * @param pageRequest 查询参数
     * @param priPID      主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public List<ImIppldg> quryPage(PageRequest pageRequest, String priPID) throws Exception {
//        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getLength());
        Example example=new Example(ImIppldg.class);
        example.createCriteria().andEqualTo("priPID",priPID);
        return imIppldgMapper.selectByExample(example);
    }
    /**
     * 
     * 描述: 分页查询行政许可信息
     * @auther ljx
     * @date 2016年9月24日 
     * @param pageReqeust
     * @param priPID
     * @return
     * @throws Exception
     */
    @Override
   public List<ImIppldg> queryPageForPUb(PageRequest pageReqeust,String priPID) throws Exception{
    	 int pageNum=Integer.parseInt(pageReqeust.getParams().get("pageNum").toString());
    	PageHelper.startPage(pageNum, pageReqeust.getLength());
	   Example example=new Example(ImIppldg.class);
       example.createCriteria().andEqualTo("priPID",priPID).andEqualTo("pubFlag","1");
       return imIppldgMapper.selectByExample(example); 
	   
   }
    
    /**
     * 描述:  根据知识产权出质登记信息ID查询知识产权出质登记信息
     *
     * @param pleID 股权变更信息ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public ImIppldg findByPleId(String pleID,String priPID) throws Exception {
        ImIppldg imIppldg=new ImIppldg();
        imIppldg.setPleID(pleID);
        if(StringUtils.isNotEmpty(priPID)){
        imIppldg.setPriPID(priPID);
        }
        return imIppldgMapper.selectOne(imIppldg);
    }



    /**
     * 描述:  根据主体身份ID来公示所有的 知识产权出质登记信息
     *
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年9月09日
     */
    @Override
    public int pubAll(String priPID) throws Exception {
        Example example=new Example(ImIppldg.class);
        //已经公示的就不用更新了  2016-9-28 chenyl
        example.createCriteria().andEqualTo("priPID",priPID).andNotEqualTo("pubFlag", Constants.PUB_FLG_Y);
        ImIppldg imIppldgMod=new ImIppldg();
        imIppldgMod.setPubFlag(Constants.PUB_FLG_Y);
        //增加公示日期
        imIppldgMod.setPublicDate(new Date());
        manageService.updateOnePanoramaIdx(priPID);
       return  imIppldgMapper.updateByExampleSelective(imIppldgMod,example);
    }

	@Override
	public List<ImIppldg> selectListByCerNO(PageRequest pageRequest) {
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getLength());
		return imIppldgMapper.selectListByCerNO(pageRequest.getParams());
	}
}