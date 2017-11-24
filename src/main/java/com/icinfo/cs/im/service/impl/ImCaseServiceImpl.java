/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.im.dto.ImCaseDto;
import com.icinfo.cs.im.mapper.ImCasaltMapper;
import com.icinfo.cs.im.mapper.ImCaseMapper;
import com.icinfo.cs.im.model.ImCase;
import com.icinfo.cs.im.service.IImCaseService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    行政处罚信息 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class ImCaseServiceImpl extends MyBatisServiceSupport implements IImCaseService {


    private static final Logger logger= LoggerFactory.getLogger(ImCaseServiceImpl.class);
    @Autowired
    private ImCaseMapper imCaseMapper;
    @Autowired
    private ImCasaltMapper casaltMapper;

    @Autowired
   private IEsManageService manageService; 
    
    /**
     * 描述:  保存行政处罚信息
     *
     * @param imCase 行政处罚信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int insert(ImCase imCase) throws Exception {
        return imCaseMapper.insert(imCase);
    }

    /**
     * 描述:  修改行政处罚信息
     *
     * @param imCase 行政处罚信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int update(ImCase imCase) throws Exception {
        Example example=new Example(ImCase.class);
        example.createCriteria().andEqualTo("caseNO",imCase.getCaseNO()).andEqualTo("priPID",imCase.getPriPID());
        return imCaseMapper.updateByExampleSelective(imCase,example);
    }

    /**
     * 描述:  删除行政处罚信息
     *
     * @param caseNO 行政处罚信息ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int deleteByCaseNO(String caseNO,String priPID) throws Exception {
        logger.info("delete imcase by caseNo:{}",caseNO);
        ImCase imCase=new ImCase();
        imCase.setCaseNO(caseNO); 
        imCase.setPriPID(priPID);
        return imCaseMapper.delete(imCase);
    }

    /**
     * 描述:  分页查询行政处罚信息
     *
     * @param pageRequest 查询参数
     * @param priPID      主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public List<ImCase> quryPage(PageRequest pageRequest, String priPID) throws Exception {
       // PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getLength());
        Example example=new Example(ImCase.class);
        example.createCriteria().andEqualTo("priPID",priPID);
        return imCaseMapper.selectByExample(example);
    }

    /**
     * 描述:  分页查询行政处罚信息for 公示
     *
     * @param pageRequest 查询参数
     * @param priPID      主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public List<ImCase> quryPageForPub(PageRequest pageRequest, String priPID) throws Exception {
    	int pageNum=Integer.parseInt(pageRequest.getParams().get("pageNum").toString());
    	PageHelper.startPage(pageNum, pageRequest.getLength());
        Example example=new Example(ImCase.class);
        example.createCriteria().andEqualTo("priPID",priPID).andEqualTo("pubFlag","1");
        return imCaseMapper.selectByExample(example);
    }
    /**
     * 描述:  根据行政处罚信息ID查询行政处罚信息
     *
     * @param caseNO 行政处罚ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public ImCase findByCaseNO(String caseNO,String priPID) throws Exception {
        ImCase imCase=new ImCase();
        imCase.setCaseNO(caseNO);
        if(StringUtils.isNotEmpty(priPID)){
        imCase.setPriPID(priPID);
        }
        return imCaseMapper.selectOne(imCase);
    }

    /**
     * 描述:  根据主体身份ID来公示所有的行政处罚信息
     *
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年9月09日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int pubAllImCase(String priPID) throws Exception {
        logger.info("pub all imcase by priPID:{}",priPID);
        Example example=new Example(ImCase.class);
        //已经公示的就不用更新了  2016-9-28 chenyl
        example.createCriteria().andEqualTo("priPID",priPID).andNotEqualTo("pubFlag", Constants.PUB_FLG_Y);
        List<ImCase> imCaseList = imCaseMapper.selectByExample(example);
         int result=0;
        for(ImCase imCase:imCaseList){
            //if(StringUtils.equalsIgnoreCase(imCase.getPubFlag(), Constants.PUB_FLG_Y))continue;
            //Example exampleCase=new Example(ImCase.class);
            //exampleCase.createCriteria().andEqualTo("caseNO",imCase.getCaseNO());
            ImCase imCaseMod=new ImCase();
            imCaseMod.setPubFlag(Constants.PUB_FLG_Y);
            //更新公示时间 2016-9-28 chenyl
            imCaseMod.setPublicDate(new Date());
            manageService.updateOnePanoramaIdx(priPID);
            result=imCaseMapper.updateByExampleSelective(imCaseMod,example);
        }
		return result;
    }

	@Override
	public List<ImCaseDto> queryToPub(PageRequest pageRequest, String priPID) throws Exception {
		int pageNum=Integer.parseInt(pageRequest.getParams().get("pageNum").toString());
    	PageHelper.startPage(pageNum, pageRequest.getLength());
        
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("priPID",priPID);
        map.put("pubFlag","1");
        List<ImCaseDto> listDto= imCaseMapper.findCaseByPriPID(map);
	  
		return listDto;
	}

	 
}