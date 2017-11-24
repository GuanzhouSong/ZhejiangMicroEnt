/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service.impl;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.im.mapper.ImInvestmentMapper;
import com.icinfo.cs.im.mapper.ImInvprodetailMapper;
import com.icinfo.cs.im.model.ImInvestment;
import com.icinfo.cs.im.model.ImInvprodetail;
import com.icinfo.cs.im.service.IImInvprodetailService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 描述:    认缴出资详细信息 对应的Service接口实现类.<br>
 *
 * @author zhudefeng
 * @date 2016年08月28日
 */
@Service
public class ImInvprodetailServiceImpl extends MyBatisServiceSupport implements IImInvprodetailService {

    private static final Logger logger = LoggerFactory.getLogger(ImInvprodetailServiceImpl.class);

    @Autowired
    private ImInvprodetailMapper imInvprodetailMapper;

    @Autowired
    private ImInvestmentMapper imInvestmentMapper;

    /**
     * 描述:  保存认缴出资详细信息
     *
     * @param imInvprodetail 认缴出资详细信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(ImInvprodetail imInvprodetail) throws Exception {
        imInvprodetail.setCreateTime(new Date());
        if (imInvprodetailMapper.insert(imInvprodetail) <= 0) {
            logger.error("exception {}", "保存认缴出资详细信息失败!");
            throw new BusinessException("保存认缴出资详细信息失败!");
        }

        //==新增认缴出资明细的时更新出资人的累计认缴出资额：1、查询之前的累计认缴出资额；2、累计认缴出资额加上新增的认缴出资明细的出资额；2、更新出资人信息表==//
        ImInvestment imInvestment= findInvestByInvId(imInvprodetail.getInvID());

        imInvestment.setLiSubConAm(imInvestment.getLiSubConAm().add(imInvprodetail.getSubConAm()));

        Example example=new Example(ImInvestment.class);
        example.createCriteria().andEqualTo("invID",imInvprodetail.getInvID());
        imInvestmentMapper.updateByExampleSelective(imInvestment,example);

    }


    /**
     * 描述:  修改认缴出资详细信息
     *
     * @param imInvprodetail 认缴出资详细信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(ImInvprodetail imInvprodetail) throws Exception {
        ImInvprodetail tmpImInvprodetail1=new ImInvprodetail();
        tmpImInvprodetail1.setSubID(imInvprodetail.getSubID());
        tmpImInvprodetail1=imInvprodetailMapper.selectOne(tmpImInvprodetail1);

        Example example=new Example(ImInvprodetail.class);
        example.createCriteria().andEqualTo("subID",imInvprodetail.getSubID());
        if (imInvprodetailMapper.updateByExampleSelective(imInvprodetail, example) <= 0) {
            logger.error("exception {}", "修改认缴出资详细信息失败!");
            throw new BusinessException("修改认缴出资详细信息失败!");
        }

        //==修改认缴出资明细时更新出资人的累计认缴出资额：
        // 处理方式1、查询之前的累计认缴出资额；2、累计认缴出资额先减去之前的认缴出资明细中的出资额，然后再加上新增的认缴出资明细的出资额；2、更新出资人信息表==//
        ImInvestment imInvestment= findInvestByInvId(imInvprodetail.getInvID());
        if(imInvprodetail.getSubConAm()!=null){//如果需要修改出资额才会执行下面的换算
            imInvestment.setLiSubConAm(imInvestment.getLiSubConAm().subtract(tmpImInvprodetail1.getSubConAm()).add(imInvprodetail.getSubConAm()));
        }

        Example example4ImInvestment=new Example(ImInvestment.class);
        example4ImInvestment.createCriteria().andEqualTo("invID",imInvprodetail.getInvID());
        if(imInvestmentMapper.updateByExampleSelective(imInvestment,example4ImInvestment)>0){
        	return 1;
        }else{
        	return 0;
        }

    }

    /**
     * 描述:  根据认缴ID删除认缴出资详细信息
     *
     * @param subID 认缴出资详细信息ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delBySubId(String subID) throws Exception {
        ImInvprodetail imInvprodetail=new ImInvprodetail();
        imInvprodetail.setSubID(subID);
        imInvprodetail=imInvprodetailMapper.selectOne(imInvprodetail);
        if(imInvprodetail==null|| StringUtil.isEmpty(imInvprodetail.getSubID())){
            logger.error("exception {}", "删除认缴出资详细信息失败!subID不存在或者为空["+subID+"]");
            throw new BusinessException("删除认缴出资详细信息失败!subID不存在或者为空["+subID+"]");
        }
        int rlt=imInvprodetailMapper.delete(imInvprodetail);
        if(rlt<=0){
            logger.error("exception {}", "删除认缴出资详细信息失败!");
            throw new BusinessException("删除认缴出资详细信息失败!");
        }

        //==删除认缴出资明细时更新出资人的累计认缴出资额：
        // 处理方式1、查询之前的累计认缴出资额；2、累计认缴出资额减去这条认缴出资明细中的出资额2、更新出资人信息表==//
        ImInvestment imInvestment= findInvestByInvId(imInvprodetail.getInvID());

        imInvestment.setLiSubConAm(imInvestment.getLiSubConAm().subtract(imInvprodetail.getSubConAm()));

        Example example4ImInvestment=new Example(ImInvestment.class);
        example4ImInvestment.createCriteria().andEqualTo("invID",imInvprodetail.getInvID());
       return  imInvestmentMapper.updateByExampleSelective(imInvestment,example4ImInvestment);
    }

    /**
     * 描述:  根据出资人ID删除所有认缴出资详细信息
     *
     * @param invId 出资人ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delByInvId(String invId,boolean isUpdateLicomam) throws Exception {
        ImInvprodetail imInvprodetail=new ImInvprodetail();
        imInvprodetail.setInvID(invId);
        List<ImInvprodetail> imInvprodetailList=imInvprodetailMapper.select(imInvprodetail);

        imInvprodetailMapper.delete(imInvprodetail);

        if(!isUpdateLicomam){
            return;
        }

        //==删除所有的认缴出资明细时更新出资人的累计认缴出资额：
        // 处理方式1、查询删除了的所有的认缴出资额总数；2、出资人信息中的累计认缴出资额减去上一步结算的出资总额 3、更新出资人信息表==//
        BigDecimal count=new BigDecimal(0);
        for(ImInvprodetail imInvprodetail1:imInvprodetailList){
            count=count.add(imInvprodetail1.getSubConAm());
        }

        ImInvestment imInvestment= findInvestByInvId(invId);

        imInvestment.setLiSubConAm(imInvestment.getLiSubConAm().subtract(count));

        Example example4ImInvestment=new Example(ImInvestment.class);
        example4ImInvestment.createCriteria().andEqualTo("invID", invId);
        imInvestmentMapper.updateByExampleSelective(imInvestment,example4ImInvestment);

    }


    /**
     * 描述:  根据认缴出资ID查询认缴出资详细信息
     *
     * @param subID 认缴出资ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月30日
     */
    @Override
    public ImInvprodetail findBySubID(String subID) throws Exception {
        ImInvprodetail imInvprodetail=new ImInvprodetail();
        imInvprodetail.setSubID(subID);
        return imInvprodetailMapper.selectOne(imInvprodetail);
    }

    /**
     * 描述:  根据出资人ID查询所有认缴出资详细信息
     *
     * @param invId 出资人ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    public List<ImInvprodetail> findByInvIdNoPage(String invId) throws Exception {
        Example example=new Example(ImInvprodetail.class);
        example.createCriteria().andEqualTo("invID",invId);
        return imInvprodetailMapper.selectByExample(example);
    }


    /**
     * 描述:  根据投资人ID查询投资人信息
     *
     * @param invId 投资人ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    private ImInvestment findInvestByInvId(String invId)throws Exception{
        ImInvestment conditionImInvestment=new ImInvestment();
        conditionImInvestment.setInvID(invId);
        ImInvestment imInvestment=imInvestmentMapper.selectOne(conditionImInvestment);

        if(imInvestment!=null){
            if(imInvestment.getLiSubConAm()==null){
                imInvestment.setLiSubConAm(new BigDecimal(0));
            }
        }
        return imInvestment;
    }


	@Override
	public List<ImInvprodetail> findByInvIdNoPageForPub(String invId) throws Exception {
		  Example example=new Example(ImInvprodetail.class);
	        example.createCriteria().andEqualTo("invID",invId).andEqualTo("pubFlag", "1");
	        return imInvprodetailMapper.selectByExample(example);
 
	}
}