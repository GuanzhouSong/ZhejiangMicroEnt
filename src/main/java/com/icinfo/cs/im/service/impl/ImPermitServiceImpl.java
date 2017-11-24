/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service.impl;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.im.mapper.ImPermitMapper;
import com.icinfo.cs.im.model.ImPermit;
import com.icinfo.cs.im.service.IImPermitService;
import com.icinfo.cs.yr.service.ISysForbidwordService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    即时信息—许可信息 对应的Service接口实现类.<br>
 *
 * @author zhudefeng
 * @date 2016年08月28日
 */
@Service
public class ImPermitServiceImpl extends MyBatisServiceSupport implements IImPermitService {
    private static final Logger logger = LoggerFactory.getLogger(ImPermitServiceImpl.class);

    @Autowired
    private ImPermitMapper imPermitMapper;

    @Autowired
    private ISysForbidwordService sysForbidwordService;
    
    @Autowired
    private IEsManageService manageService;

    /**
     *
     * 描述:  保存即时信息-许可信息
     * @auther zhudefeng
     * @date 2016年8月28日
     * @return
     * @throws Exception
     */
    @Override
    public int insert(ImPermit imPermit) throws Exception {
        imPermit.setCreateTime(new Date());
        imPermit.setPubFlag(Constants.PUB_FLG_N);
        if (imPermitMapper.insert(imPermit) <= 0) {
            logger.error("exception {}", "保存许可信息（即时信息）失败!");
            throw new BusinessException("保存许可信息（即时信息）失败!");
        }
        return 1;
    }

    /**
     *
     * 描述:  保存并公示即时信息-许可信息
     * @auther zhudefeng
     * @date 2016年8月28日
     * @return
     * @throws Exception
     */
    @Override
    public int insertAndPub(ImPermit imPermit) throws Exception {
        imPermit.setCreateTime(new Date());
        imPermit.setPubFlag(Constants.PUB_FLG_Y);
        imPermit.setPublicDate(new Date());
        if (imPermitMapper.insert(imPermit) <= 0) {
            logger.error("exception {}", "保存并公示许可信息（即时信息）失败!");
            throw new BusinessException("保存并公示许可信息（即时信息）失败!");
        }
        return 1;
    }

    /**
     *
     * 描述:  修改即时信息-许可信息
     * @auther zhudefeng
     * @date 2016年8月28日
     * @return
     * @throws Exception
     */
    @Override
    public int update(ImPermit imPermit) throws Exception {
        Example example=new Example(ImPermit.class);
        example.createCriteria().andEqualTo("licID",imPermit.getLicID()).andEqualTo("priPID",imPermit.getPriPID());
       // imPermitMapper.updateByExample(imPermit, example);
        if (imPermitMapper.updateByExampleSelective(imPermit, example) < 0) {
            logger.error("exception {}", "修改许可信息（即时信息）失败!");
            throw new BusinessException("修改许可信息（即时信息）失败!");
        }
        return 1;
    }



    /**
     *
     * 描述:  根据LicId删除即时信息-许可信息
     * @auther zhudefeng
     * @date 2016年8月28日
     * @return 1：删除成功;-1:已经公示不允许删除;0:不存在
     * @throws Exception
     */
    @Override
    public int deleteByLicId(String licId,String priPID) throws Exception {
        ImPermit imPermit=selectByLicId(licId,priPID);
        if(imPermit==null){
            return 0;
        }
        if(StringUtils.equalsIgnoreCase(imPermit.getPubFlag(),Constants.PUB_FLG_Y)){//如果许可信息已经公示，则不能删除
            logger.info("exception {}", "该即时信息（许可信息）已经公示，不能删除!");
            return -1;
        }
        ImPermit imPermitTmp=new ImPermit();
        imPermitTmp.setLicID(licId);
        imPermitTmp.setPriPID(priPID);
        int rlt=imPermitMapper.delete(imPermitTmp);
        if(rlt<=0){
            logger.error("exception {}", "删除并公示许可信息（即时信息）失败!");
            throw new BusinessException("删除并公示许可信息（即时信息）失败!");
        }
        return 1;
    }

    /**
     *
     * 描述:  根据LicId查询即时信息-许可信息
     * @auther zhudefeng
     * @date 2016年8月28日
     * @return
     * @throws Exception
     */
    @Override
    public ImPermit selectByLicId(String licId,String priPID) throws Exception {
        if (isEmpty(licId)) {
            return null;
        }
        ImPermit imPermit=new ImPermit();
        imPermit.setLicID(licId);
        if(StringUtils.isNotEmpty(priPID)){
        imPermit.setPriPID(priPID);
        }
        return imPermitMapper.selectOne(imPermit);
    }

    /**
     *
     * 描述:  查询许可信息列表
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param request 查询参数
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     */
    @Override
    public List<ImPermit> queryPage(PageRequest request,String priPID) throws Exception {
       // PageHelper.startPage(request.getPageNum(), request.getLength());
        Example example=new Example(ImPermit.class);
        example.createCriteria().andEqualTo("priPID",priPID);
        return imPermitMapper.selectByExample(example);
    }
    /**
    *
    * 描述:  查询许可信息列表for 公示
    * @auther zhudefeng
    * @date 2016年8月29日
    * @param request 查询参数
    * @param priPID 主体身份ID
    * @return
    * @throws Exception
    */
   @Override
    public List<ImPermit> queryPageForPub(PageRequest request,String priPID)throws Exception{
	    int pageNum=Integer.parseInt(request.getParams().get("pageNum").toString());
	    PageHelper.startPage(pageNum, request.getLength());
        Example example=new Example(ImPermit.class);
        example.createCriteria().andEqualTo("priPID",priPID).andEqualTo("pubFlag","1");
        return imPermitMapper.selectByExample(example);
    }
    

    /**
     * 描述:  根据主体身份ID来公示所有的行政许可信息
     *
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年9月09日
     */
    @Override
    public int  pubAll(String priPID) throws Exception {
        Example example=new Example(ImPermit.class);
        //已经公示了的数据不用修改
        example.createCriteria().andEqualTo("priPID",priPID).andNotEqualTo("pubFlag", Constants.PUB_FLG_Y);
        ImPermit imCaseMod=new ImPermit();
        imCaseMod.setPubFlag(Constants.PUB_FLG_Y);
        //增加公示日期
        imCaseMod.setPublicDate(new Date());
        manageService.updateOnePanoramaIdx(priPID);
        return imPermitMapper.updateByExampleSelective(imCaseMod,example);
    }
}