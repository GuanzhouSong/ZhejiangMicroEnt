/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.inspect.service.IReportCheckInfoService;
import com.icinfo.cs.inspect.service.impl.ReportCheckInfoServiceImpl;
import com.icinfo.framework.common.ajax.AjaxResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.mapper.MidInvMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.model.MidInv;
import com.icinfo.cs.im.dto.ImInvestmentDto;
import com.icinfo.cs.im.mapper.ImInvactdetailMapper;
import com.icinfo.cs.im.mapper.ImInvestmentMapper;
import com.icinfo.cs.im.mapper.ImInvprodetailMapper;
import com.icinfo.cs.im.model.ImInvactdetail;
import com.icinfo.cs.im.model.ImInvestment;
import com.icinfo.cs.im.model.ImInvprodetail;
import com.icinfo.cs.im.service.IImInvactdetailService;
import com.icinfo.cs.im.service.IImInvestmentService;
import com.icinfo.cs.im.service.IImInvprodetailService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_im_investment 对应的Service接口实现类.<br>
 *
 * @author zhudefeng
 * @date 2016年08月28日
 */
@Service
public class ImInvestmentServiceImpl extends MyBatisServiceSupport implements IImInvestmentService {

    private static final Logger logger = LoggerFactory.getLogger(ImInvestmentServiceImpl.class);

    @Autowired
    private ImInvestmentMapper imInvestmentMapper;

    /**
     * 实缴出资Service
     */
    @Autowired
    private IImInvactdetailService imInvactdetailService;

    @Autowired
    private ImInvactdetailMapper imInvactdetailMapper;
    
    @Autowired
    private IEsManageService manageService;


    /**
     * 认缴出资service
     */
    @Autowired
    private  IImInvprodetailService imInvprodetailService;
    @Autowired
    private ImInvprodetailMapper imInvprodetailMapper;

    @Autowired
    private MidInvMapper midInvMapper;

    @Autowired
    private MidBaseInfoMapper midBaseInfoMapper;

    @Autowired
    private IReportCheckInfoService reportCheckInfoService;


    /**
     * 描述:  分页查询出资情况列表（即时信息）
     *
     * @param request 请求参数
     * @return 出资情况列表
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    public List<ImInvestment> findInvestmentWithDetailByPriPID(PageRequest request,boolean isPageSearch) throws Exception {
        if(isPageSearch){
            int pageNum=Integer.parseInt(request.getParams().get("pageNum").toString());
            PageHelper.startPage(pageNum, request.getLength());
        }
        List<ImInvestment> investments=new ArrayList<>();
        Example example=new Example(ImInvestment.class);
        Example.Criteria criteria=example.createCriteria();
        if(request.getParams().containsKey(Constants.CS_PRIPID)){
            criteria.andEqualTo(Constants.CS_PRIPID, request.getParams().get(Constants.CS_PRIPID).toString());
            String name = request.getParams().get("name").toString();
            if(StringUtils.isNotBlank(name)){
                criteria.andLike("inv","%"+name+"%");
            }
            investments= imInvestmentMapper.selectByExample(example);
            findDetailByInvAndPubFlag(investments,request.getParams().get("pubFlag"));
            if(investments==null||investments.size()==0){
                String priPID=(request.getParams().get(Constants.CS_PRIPID)==null)?"":request.getParams().get(Constants.CS_PRIPID).toString();
//                genInvestmentDtosFromMidInv(priPID);
                investments= imInvestmentMapper.selectByExample(example);
            }
        }
        return investments;
    }

    /**
     * 描述:  分页查询出资情况列表（即时信息）for公示
     *
     * @param request 请求参数
     * @return 出资情况列表
     * @throws Exception
     * @auther ljx
     * @date 2016年12月8日
     */
    @Override
    
    public List<ImInvestment> findInvestmentWithDetatilForPub(PageRequest request)throws Exception{
    	int pageNum=Integer.parseInt(request.getParams().get("pageNum").toString());
    	 PageHelper.startPage(pageNum, request.getLength());
         List<ImInvestment> investments=new ArrayList<>();
         Example example=new Example(ImInvestment.class);
         example.createCriteria().andEqualTo(Constants.CS_PRIPID, request.getParams().get(Constants.CS_PRIPID).toString());
         investments= imInvestmentMapper.selectByExample(example);  
    	
         if(investments!=null&&investments.size()>0){
        	  ImInvprodetail invprodetailCondtion= new ImInvprodetail(); 
              ImInvactdetail invactdetailCondition=new ImInvactdetail();
        	 for(ImInvestment invMe:investments){ 
        		  invprodetailCondtion.setInvID(invMe.getInvID());
        		  invprodetailCondtion.setPubFlag("1");
        		  invactdetailCondition.setInvID(invMe.getInvID());
        		  invactdetailCondition.setPubFlag("1");
        		 invMe.setImInvactdetailList(imInvactdetailMapper.select(invactdetailCondition));
        		 invMe.setImInvprodetailList(imInvprodetailMapper.select(invprodetailCondtion));
        	 } 
        	 
         }
         
         return investments; 
    	
    	
    }
    
    
    

    /**
     * 描述:  查询出资明细
     *
     * @param investments 请求参数
     * @param pubFlag 是否公示
     * @return 出资情况列表
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年10月8日
     */
    private List<ImInvestment> findDetailByInvAndPubFlag(List<ImInvestment> investments,Object pubFlag) {
        List<ImInvestment> imInvestmentList=new ArrayList<>();
        ImInvprodetail invprodetailCondtion= new ImInvprodetail();
        ImInvactdetail invactdetailCondition=new ImInvactdetail();
        if(pubFlag!=null){
            invprodetailCondtion.setPubFlag(pubFlag.toString());
            invactdetailCondition.setPubFlag(pubFlag.toString());
        }
        for(ImInvestment investment:investments){
            invprodetailCondtion.setInvID(investment.getInvID());
            invactdetailCondition.setInvID(investment.getInvID());
            List<ImInvprodetail> invprodetailList=imInvprodetailMapper.select(invprodetailCondtion);
            List<ImInvactdetail> invactdetailList=imInvactdetailMapper.select(invactdetailCondition);
            investment.setImInvactdetailList(invactdetailList);
            investment.setImInvprodetailList(invprodetailList);
            imInvestmentList.add(investment);
        }

        return imInvestmentList;
    }

    /**
     * 描述:  分页查询出资情况列表（即时信息For公示）
     *
     * @param request 请求参数
     * @return 出资情况列表
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    public List<ImInvestmentDto> findInvestmentWithDetailByPriPIDForPub(PageRequest request)throws Exception{
    	int pageNum=Integer.parseInt(request.getParams().get("pageNum").toString());
        PageHelper.startPage(pageNum, request.getLength());
        List<ImInvestmentDto> investmentDtos=imInvestmentMapper.findInvestmentWithDetailByPriPID(request.getParams());
        if(investmentDtos==null||investmentDtos.size()==0){
            String priPID=(request.getParams().get(Constants.CS_PRIPID)==null)?"":request.getParams().get(Constants.CS_PRIPID).toString();
//            genInvestmentDtosFromMidInv(priPID);
            investmentDtos=imInvestmentMapper.findInvestmentWithDetailByPriPID(request.getParams());
        }
        return investmentDtos;
    }
    
    

    /**
     * 描述:  查询出资情况中间表数据并往即时信息-出资人信息表插入
     *
     * @param priPID  登陆主体身份ID
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月30日
     */
    private void genInvestmentDtosFromMidInv(String priPID) {

        Example example = new Example(MidInv.class);
        example.createCriteria().andEqualTo("priPID",priPID);
        List<MidInv> midInvs=midInvMapper.selectByExample(example);

        MidBaseInfo midBaseInfo=new MidBaseInfo();
        midBaseInfo.setPriPID(priPID);
        midBaseInfo=midBaseInfoMapper.selectOne(midBaseInfo);

        for(MidInv midInv:midInvs){
            ImInvestment imInvestment=new ImInvestment();
            imInvestment.setInv(midInv.getInv());
            imInvestment.setPriPID(priPID);
            imInvestment.setEntName(midBaseInfo.getEntName());
            imInvestmentMapper.insert(imInvestment);
        }
    }

    /**
     * 通过企业内部序列号来查询股东列表
     * @author ZhuDefeng
     * @date 2017-02-14
     * @param priPID
     * @return
     */
    public List<MidInv>  selectInvestmentDtosFromMidInv(String priPID) throws Exception{
        Example example = new Example(MidInv.class);
        example.createCriteria().andEqualTo("priPID",priPID);
        List<MidInv> midInvs=midInvMapper.selectByExample(example);
        return midInvs;
    }

    /**
     * 描述:  全查询出资情况列表（即时信息）
     *
     * @param priPID  登陆主体身份ID
     * @return 出资情况列表
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月30日
     */
    @Override
    public List<ImInvestmentDto> findInvestmentWithDetailByPriPIDNoPage( String priPID) throws Exception {
        Map<String,Object> qryMap=new HashMap<String,Object>();
        qryMap.put(Constants.CS_PRIPID,priPID);
        return imInvestmentMapper.findInvestmentWithDetailByPriPID(qryMap);
    }

    /**
     * 描述:  获取认缴出资总额
     *
     * @param imInvprodetailList
     * @return 出资情况列表
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月30日
     */
    private BigDecimal countSubConAm(List<ImInvprodetail> imInvprodetailList){
        BigDecimal count=new BigDecimal(0);
        if(imInvprodetailList!=null&&imInvprodetailList.size()!=0){
            for(int i=0 ;i<imInvprodetailList.size();i++){
                count=count.add(imInvprodetailList.get(i).getSubConAm());
            }
        }
        return count;
    }

    /**
     * 描述:  获取实缴出资总额
     *
     * @param imInvactdetailList
     * @return 出资情况列表
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月30日
     */
    private BigDecimal countAcConAmCount(List<ImInvactdetail> imInvactdetailList) {
        BigDecimal count=new BigDecimal(0);
        if(imInvactdetailList!=null&&imInvactdetailList.size()!=0){
            for(int i=0 ;i<imInvactdetailList.size();i++){
                count=count.add(imInvactdetailList.get(i).getAcConAm());
            }
        }
        return count;
    }

    /**
     * 描述:  保存出资人信息
     *
     * @param imInvestment 出资人信息
     * @return 投资人ID
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    public String insert(ImInvestment imInvestment) throws Exception {
        imInvestment.setCreateTime(new Date());
        imInvestmentMapper.insert(imInvestment);
        return imInvestment.getInvID();
    }

    /**
     * 描述:  公示该主体的所有股东的出资信息
     *
     * @param priPID 主体身份编号
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String,String> pubInv(String priPID) throws Exception {
        Map<String,String> qryMap=new HashMap<>();
        qryMap.put("success","true");
        List<ImInvestmentDto> investmentDtoList=findInvestmentWithDetailByPriPIDNoPage(priPID);
        boolean compareFlg=compareInvproWithRegCap(investmentDtoList,priPID);
        if(!compareFlg){
            qryMap.put("success","false");
            qryMap.put("compareFlg","false");
            return qryMap;
        }
        for(int i=0;i<investmentDtoList.size();i++){
            Example example=new Example(ImInvactdetail.class);
            //已经公示的就不用更新了  2016-9-28 chenyl
            example.createCriteria().andEqualTo("invID",investmentDtoList.get(i).getInvID()).andNotEqualTo("pubFlag", Constants.PUB_FLG_Y);

            ImInvactdetail imInvactdetailMod=new ImInvactdetail();
            imInvactdetailMod.setPubFlag(Constants.PUB_FLG_Y);
            //增加年报公示时间
            imInvactdetailMod.setPublicDate(new Date());
            imInvactdetailMapper.updateByExampleSelective(imInvactdetailMod, example);

            ImInvprodetail imInvprodetail=new ImInvprodetail();
            imInvprodetail.setPubFlag(Constants.PUB_FLG_Y);
            //增加年报公示时间
            imInvprodetail.setPublicDate(new Date());
            manageService.updateOnePanoramaIdx(priPID);
            imInvprodetailMapper.updateByExampleSelective(imInvprodetail,example);
        }
        return qryMap;
    }

    /**
     * 比较应缴出资总额应与公司注册资本额
     * @author ZhuDefeng
     * @param investmentDtoList
     * @param priPID
     * @return 应缴出资总额应与公司注册资本额 是否相等
     */
    private boolean compareInvproWithRegCap(List<ImInvestmentDto> investmentDtoList, String priPID) {
        MidBaseInfo midBaseInfo=midBaseInfoMapper.selectMidBaseInfoByPripid(priPID);
        String entTypeLTD = RepTypeUtil.entTypeLTD;
        String entType = midBaseInfo.getEntType();//市场主体类型(CA16)
        if (entTypeLTD.indexOf(entType) != -1) {//如果不是有限责任公司，则不判断
            return true;
        }
        BigDecimal regCap=midBaseInfo.getRegCap();
        BigDecimal invProCount=new BigDecimal(0);
        for(int i=0;i<investmentDtoList.size();i++){
            if(investmentDtoList.get(i).getLiSubConAm()==null) continue;
            invProCount=invProCount.add(investmentDtoList.get(i).getLiSubConAm());
        }
        if(invProCount.compareTo(regCap)!=0){
            return false;
        }
        return true;
    }

    /**
     * 描述:  删除出资人信息（同时删除实缴出资明细、认缴出资明细）
     *
     * @param invId 出资人ID
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delByInvId(String invId,String priPID) throws Exception {
        
    	ImInvestment conditionImInvestment=new ImInvestment();
        conditionImInvestment.setInvID(invId);
        conditionImInvestment.setPriPID(priPID);
        imInvestmentMapper.delete(conditionImInvestment);
        imInvactdetailService.delByInvId(invId,false);
        imInvprodetailService.delByInvId(invId,false);

    }

    /**
     * 描述:  根据出资人ID查询股东信息
     *
     * @param invId 出资人ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月29日
     */
    @Override
    public ImInvestment findByInvId(String invId,String priPID) throws Exception {
        ImInvestment conditionImInvestment=new ImInvestment();
        conditionImInvestment.setInvID(invId);
        if(StringUtils.isNotEmpty(priPID)){
        conditionImInvestment.setPriPID(priPID);
        }
        return imInvestmentMapper.selectOne(conditionImInvestment);
    }
    @Override
   public int  update(ImInvestment imInvestment)throws Exception{
	     Example example=new Example(ImInvestment.class);
	     example.createCriteria().andEqualTo("invID",imInvestment.getInvID()).andEqualTo("priPID",imInvestment.getPriPID());
	      return imInvestmentMapper.updateByExampleSelective(imInvestment, example);
	    
   }

	@Override
	public ImInvestment findByOnlyInvId(String invId) throws Exception {
		  Example example=new Example(ImInvestment.class);   
		   example.createCriteria().andEqualTo("invID", invId);
		   List<ImInvestment> list=imInvestmentMapper.selectByExample(example);
		     if(list!=null&&list.size()>0){
		    	 return list.get(0);
		     }else{
		    	 return null;
		     }
		    
	}


    /**
     * 生成UUID
     *
     * @return
     * @throws Exception
     * @author ZhuDefeng
     */
    @Override
    public String genInvId() throws Exception {
        return imInvestmentMapper.genInvId();
    }
}