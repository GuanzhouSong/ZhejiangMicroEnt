/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.registinfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.registinfo.dto.PubApprMarkRelDto;
import com.icinfo.cs.registinfo.mapper.PubApprMarkRelMapper;
import com.icinfo.cs.registinfo.model.PubApprMarkRel;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.registinfo.service.IPubApprMarkRelService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;


@Service
public class PubApprMarkRelServiceImpl extends MyBatisServiceSupport implements IPubApprMarkRelService {

    @Autowired
    private PubApprMarkRelMapper pubApprMarkRelMapper;

    /** 
     * 描述: 根据企业id删除对应信息
     * @author 张文男
     * @date 2017年4月26日 
     * @param priPID 
     */
    
    public void deleteInPriPID(String priPIDs){
        pubApprMarkRelMapper.deleteInPriPID (priPIDs);
    }

    /** 
     * 描述: 根据企业id、标签code删除对应信息
     * @author 张文男
     * @date 2017年4月27日 
     * @param priPIDs
     * @param markCodes 
     */
    
    public void deleteBy(String priPIDs,String markCodes){
        Map<String, Object > map = new HashMap<String, Object > ();
        map.put ("priPIDs", priPIDs);
        map.put ("markCodes", markCodes);
        pubApprMarkRelMapper.deleteByMap (map);
    }
    
    /** 
     * 描述: 根据markcodes 删除对应数据
     * @author 张文男
     * @date 2017年4月27日 
     * @param markCode 
     */
    
    public void deleteByMarkCode(String markCode){
        pubApprMarkRelMapper.deleteByMarkCode (markCode);
    }

    /** 
     * 描述: 保存或更新
     * @author 张文男
     * @date 2017年4月26日 
     * @param priPIDs
     * @param list 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(String priPIDs,List<RegistMark> list,boolean isReverse){
        if (StringUtil.isNotBlank (priPIDs)) {
            String deletePriPIDs = StringUtil.doSplitStringToSqlFormat (priPIDs, ",");
            
            if(isReverse){//如果是反向调用则只需要删除有专项库的标签，否则删除所有对应标签
                List<String> markCodeList = pubApprMarkRelMapper.queryDoublyStoMarkCodeListInPriPID (priPIDs);
                if(null != markCodeList && markCodeList.size () >0){
                    String markCodes = "";
                    for ( int i = 0 ; i < markCodeList.size () ; i++ ) {
                        markCodes += (i>0?",":"")+"'"+markCodeList.get (i)+"'";
                    }
                    deleteBy (deletePriPIDs, markCodes);
                }
            }else{
                pubApprMarkRelMapper.deleteInPriPID (deletePriPIDs);
            }
          
            String[] priPIDsArr = priPIDs.split (",");
            for ( int i = 0 ; i < priPIDsArr.length ; i++ ) {
                for ( RegistMark registMark : list ) {
                    String idcode = registMark.getIDCode ();
                    String idname = registMark.getIDName ();

                    PubApprMarkRel bean = new PubApprMarkRel ();
                    bean.setPriPID (priPIDsArr[i]);
                    bean.setMarkCode (idcode);
                    bean.setMarkName (idname);

                    pubApprMarkRelMapper.insert (bean);
                }
            }

        }

    }
  
    
	/**
	 * 
	 * 描述: 查询单家企业所属的标签
	 * @auther gaojinling
	 * @date 2017年4月26日 
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public List<PubApprMarkRel> queryListByPripid(String priPID)throws Exception{
		Example example = new Example(PubApprMarkRel.class);
        example.createCriteria ().andEqualTo ("priPID", priPID);
		return pubApprMarkRelMapper.selectByExample(example);
	}
	
	
    /**
     * 
     * 描述: 根绝pripid查询企业所属标签(当前有效的标签)（分组化后）
     * @auther gaojinling
     * @date 2017年4月21日 
     * @param map
     * @return
     */
    public List<PubApprMarkRelDto> selectMainMarkRelDtoByPriPIDGroup(String priPID){
        Map<String, Object> map = new HashMap<String, Object> ();
        map.put ("priPID", priPID);
        return pubApprMarkRelMapper.selectPubApprMarkRelDtoByPriPIDGroup (map);
    }
    
    /**
     * 
     * 描述: 获取当前企业所属标签及标签是否为专项库标签
     * @auther gaojinling
     * @date 2017年4月26日 
     * @param priPID
     * @return
     */
    public List<PubApprMarkRelDto> selectPubApprMarkRelDtoByPriPID(String priPID){
        Map<String, Object> map = new HashMap<String, Object> ();
        map.put ("priPID", priPID);
        return pubApprMarkRelMapper.selectPubApprMarkRelDtoByPriPID(map);
    }
}