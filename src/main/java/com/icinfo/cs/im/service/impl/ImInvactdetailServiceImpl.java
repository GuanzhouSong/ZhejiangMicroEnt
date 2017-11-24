/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service.impl;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.im.mapper.ImInvactdetailMapper;
import com.icinfo.cs.im.mapper.ImInvestmentMapper;
import com.icinfo.cs.im.model.ImInvactdetail;
import com.icinfo.cs.im.model.ImInvestment;
import com.icinfo.cs.im.service.IImInvactdetailService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
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
 * 描述:    实缴出资详细信息 对应的Service接口实现类.<br>
 *
 * @author zhudefeng
 * @date 2016年08月29日
 */
@Service
public class ImInvactdetailServiceImpl extends MyBatisServiceSupport implements IImInvactdetailService {


    private static final Logger logger = LoggerFactory.getLogger(ImInvactdetailServiceImpl.class);

    @Autowired
    private ImInvactdetailMapper imInvactdetailMapper;

    @Autowired
    private ImInvestmentMapper imInvestmentMapper;


    /**
     * 描述:  保存实缴出资详细信息
     *
     * @param imInvactdetail 实缴出资详细信息
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(ImInvactdetail imInvactdetail) throws Exception {
        imInvactdetail.setCreateTime(new Date());
        if (imInvactdetailMapper.insert(imInvactdetail) <= 0) {
            logger.error("exception {}", "保存实缴出资详细信息失败!");
            throw new BusinessException("保存实缴出资详细信息失败!");
        }

        //==新增实缴出资明细的时更新出资人的累计实缴出资额：1、查询之前的累计实缴出资额；2、累计实缴出资额加上新增的实缴出资明细的出资额；2、更新出资人信息表==//
        ImInvestment imInvestment=findByInvId(imInvactdetail.getInvID());

        imInvestment.setLiAcConAm(imInvestment.getLiAcConAm().add(imInvactdetail.getAcConAm()));

        Example example=new Example(ImInvestment.class);
        example.createCriteria().andEqualTo("invID",imInvactdetail.getInvID());
        imInvestmentMapper.updateByExampleSelective(imInvestment,example);
    }

    /**
     * 描述:  修改实缴出资详细信息
     *
     * @param imInvactdetail 实缴出资详细信息
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(ImInvactdetail imInvactdetail) throws Exception {
        ImInvactdetail tmpimInvactdetail=new ImInvactdetail();
        tmpimInvactdetail.setPaidID(imInvactdetail.getPaidID());
        tmpimInvactdetail=imInvactdetailMapper.selectOne(tmpimInvactdetail);

        Example example=new Example(ImInvactdetail.class);
        example.createCriteria().andEqualTo("paidID",imInvactdetail.getPaidID());
        if (imInvactdetailMapper.updateByExampleSelective(imInvactdetail, example) <= 0) {
            logger.error("exception {}", "修改实缴出资详细信息失败!");
            throw new BusinessException("修改实缴出资详细信息失败!");
        }

        //==修改实缴出资明细时更新出资人的累计实缴出资额：
        // 处理方式1、查询之前的累计实缴出资额；2、累计实缴出资额先减去之前的实缴出资明细中的出资额，然后再加上新增的实缴出资明细的出资额；2、更新出资人信息表==//
        ImInvestment imInvestment=findByInvId(imInvactdetail.getInvID());

        if(imInvactdetail.getAcConAm()!=null){//如果是修改出资额才执行下面运算
            imInvestment.setLiAcConAm(imInvestment.getLiAcConAm().subtract(tmpimInvactdetail.getAcConAm()).add(imInvactdetail.getAcConAm()));
        }

        Example example4ImInvestment=new Example(ImInvestment.class);
        example4ImInvestment.createCriteria().andEqualTo("invID",imInvactdetail.getInvID());
         return imInvestmentMapper.updateByExampleSelective(imInvestment,example4ImInvestment);

    }

    /**
     * 描述:  根据实缴ID删除实缴出资详细信息
     *
     * @param paidID 实缴出资详细信息ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    public void delByPaidId(String paidID) throws Exception {
        logger.info("delete iminvactdetail by paid:{}",paidID);
        ImInvactdetail invactdetail=new ImInvactdetail();
        invactdetail.setPaidID(paidID);
         invactdetail=imInvactdetailMapper.selectOne(invactdetail);
        if(invactdetail==null||StringUtil.isEmpty(invactdetail.getPaidID())){
            logger.error("exception {}", "删除实缴出资详细信息失败!PaidId不存在或者为空["+paidID+"]");
            throw new BusinessException("删除实缴出资详细信息失败!PaidId不存在或者为空["+paidID+"]");
        }
        int rlt=imInvactdetailMapper.delete(invactdetail);
        if(rlt<=0){
            logger.error("exception {}", "删除实缴出资详细信息失败!");
            throw new BusinessException("删除实缴出资详细信息失败!");
        }

        //==删除实缴出资明细时更新出资人的累计实缴出资额：
        // 处理方式1、查询之前的累计实缴出资额；2、累计实缴出资额减去这条实缴出资明细中的出资额2、更新出资人信息表==//
        ImInvestment imInvestment=findByInvId(invactdetail.getInvID());

        imInvestment.setLiAcConAm(imInvestment.getLiAcConAm().subtract(invactdetail.getAcConAm()));

        Example example4ImInvestment=new Example(ImInvestment.class);
        example4ImInvestment.createCriteria().andEqualTo("invID",invactdetail.getInvID());
        imInvestmentMapper.updateByExampleSelective(imInvestment,example4ImInvestment);

    }

    /**
     * 描述:  根据出资人ID删除所有实缴出资详细信息
     *
     * @param invId 出资人ID
     * @param isUpdateLicomam 是否更新L累计出资额
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    public void delByInvId(String invId,boolean isUpdateLicomam) throws Exception {
        logger.info("delete iminvactdetail by invid:{}",invId);

        ImInvactdetail conditionImInvactdetail=new ImInvactdetail();
        conditionImInvactdetail.setInvID(invId);
        List<ImInvactdetail> imInvactdetailList=imInvactdetailMapper.select(conditionImInvactdetail);

        imInvactdetailMapper.delete(conditionImInvactdetail);
        if(!isUpdateLicomam){
            return;
        }
        //==删除所有的实缴出资明细时更新出资人的累计实缴出资额：
        // 处理方式1、查询删除了的所有的实缴出资额总数；2、出资人信息中的累计实缴出资额减去上一步结算的出资总额 3、更新出资人信息表==//
        BigDecimal count=new BigDecimal(0);
        for(ImInvactdetail imInvactdetail1:imInvactdetailList){
            count=count.add(imInvactdetail1.getAcConAm());
        }

        ImInvestment imInvestment=findByInvId(invId);

        imInvestment.setLiAcConAm(imInvestment.getLiAcConAm().subtract(count));

        Example example4ImInvestment=new Example(ImInvestment.class);
        example4ImInvestment.createCriteria().andEqualTo("invID", invId);
        imInvestmentMapper.updateByExampleSelective(imInvestment,example4ImInvestment);
    }

    /**
     * 描述:  根据实缴出资ID查询实缴出资详细信息
     *
     * @param paidID 实缴出资ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月30日
     */
    @Override
    public ImInvactdetail findByPaidID(String paidID) throws Exception {
        ImInvactdetail imInvactdetail=new ImInvactdetail();
        imInvactdetail.setPaidID(paidID);
        return imInvactdetailMapper.selectOne(imInvactdetail);
    }

    /**
     * 描述:  根据出资人ID分页查询缴出资详细信息
     *
     * @param invId 出资人ID
     * @param request 查询参数
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    public List<ImInvactdetail> findByInvId(PageRequest request,String invId) throws Exception {
//        PageHelper.startPage(request.getPageNum(), request.getLength());
        Example example=new Example(ImInvactdetail.class);
        example.createCriteria().andEqualTo("invID",invId);
        return imInvactdetailMapper.selectByExample(example);
    }

    /**
     * 描述:  根据出资人ID查询所有缴出资详细信息
     *
     * @param invId 出资人ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月30日
     */
    @Override
    public List<ImInvactdetail> findByInvIdNoPage(String invId) throws Exception {
        Example example=new Example(ImInvactdetail.class);
        example.createCriteria().andEqualTo("invID",invId);
        return imInvactdetailMapper.selectByExample(example);
    }
    /**
     * 
     * 描述:  根据出资人ID查询所有缴出资详细信息for公示
     * @auther ljx
     * @date 2016年9月30日 
     * @param invId
     * @return
     * @throws Exception
     */
    @Override
    public List<ImInvactdetail> findByInvIdNoPageForPub(String invId) throws Exception {
        Example example=new Example(ImInvactdetail.class);
        example.createCriteria().andEqualTo("invID",invId).andEqualTo("pubFlag","1");
        return imInvactdetailMapper.selectByExample(example);
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
    public ImInvestment findByInvId(String invId)throws Exception{

        ImInvestment conditionImInvestment=new ImInvestment();
        conditionImInvestment.setInvID(invId);
        ImInvestment imInvestment =imInvestmentMapper.selectOne(conditionImInvestment);

        if(imInvestment!=null){
            if(imInvestment.getLiAcConAm()==null){
                imInvestment.setLiAcConAm(new BigDecimal(0));
            }
        }
        return imInvestment;
    }


}