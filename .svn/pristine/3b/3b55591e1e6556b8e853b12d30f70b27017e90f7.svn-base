/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.dto.SelectCodeAddress;
import com.icinfo.cs.base.mapper.CodeAddressMapper;
import com.icinfo.cs.base.model.CodeAddress;
import com.icinfo.cs.base.service.ICodeAddressService;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:  cs_code_address 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年01月20日
 */
@Service
public class CodeAddressServiceImpl extends MyBatisServiceSupport implements ICodeAddressService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(CodeAddressServiceImpl.class);
    @Autowired
    private CodeAddressMapper codeAddressMapper;

    /**
     * 获取编码数据
     * @author ：wangjin
     * @return
     */
    @Override
    public SelectCodeAddress selectBycodeAddress() {
        SelectCodeAddress selectCodeAddress = new SelectCodeAddress();
        selectCodeAddress.setCode("330000000000");
        selectCodeAddress.setAddressName("浙江省");
        return setSubCode(selectCodeAddress,null);
    }

    /**
     * 递归方法获取并封装数据
     * @param selectCodeAddress
     * @param supCode
     * @return
     */
    public SelectCodeAddress setSubCode(SelectCodeAddress selectCodeAddress, String supCode) {
        if(StringUtil.isEmpty(supCode)){
            supCode = selectCodeAddress.getCode();
        }
        List<SelectCodeAddress> codeList = selectBySuper(supCode);
        selectCodeAddress.setCodeAddress(codeList);
        for(SelectCodeAddress item:codeList){
            if(item.getCode().substring(6,12).equals("000000")){//判断是否存在子节点(市、区/县)
                setSubCode(item,item.getCode());
            }
        }
        return selectCodeAddress;
    }

    /**
     * 将获取的数据赋值给 SelectCodeAddress  的集合中
     * @param supCode
     * @return
     */
    public List<SelectCodeAddress> selectBySuper(String supCode) {
        List<CodeAddress> codeList=selectByCode(supCode); //获取查询的数据
        List<SelectCodeAddress> selectList = new ArrayList<SelectCodeAddress>(); //接收查询的数据集合
        SelectCodeAddress item=null;
        for(int i=0;i<codeList.size();i++){
            item=new SelectCodeAddress();
            item.setCode(codeList.get(i).getCode());
            item.setAddressName(codeList.get(i).getAddressName());
            selectList.add(item);
        }
        return selectList;
    }

    public List<CodeAddress> selectByCode(String code) {
        Example example = new Example(CodeAddress.class);
        Example.Criteria criteria=  example.createCriteria();
        //example.orderBy("code").asc(); //升序
        if (StringUtil.isNotEmpty(code)) {
            boolean isProv = code.indexOf("0000000000") == -1 ? false : true; //省
            boolean isCity = code.indexOf("00000000") == -1 ? false : true;   //市
            boolean isArea = code.indexOf("000000") == -1 ? false : true;     //县或区
            String _code;
            if (isProv) {    //省 ->  市
                 _code = code.substring(0, 2)+"__00000000";
                criteria.andLike("code", _code).andNotEqualTo("code","330000000000");
                return  codeAddressMapper.selectByExample(example);
            }
            if (isCity) {   //市  ->  县或区
                _code = code.substring(0, 4)+"__000000";
                criteria.andLike("code", _code).andNotEqualTo("code",code);
                return  codeAddressMapper.selectByExample(example);
            }
            if (isArea) {    //县或区 -> 街道
                _code = code.substring(0, 6)+"___000";
                criteria.andLike("code", _code).andNotEqualTo("code",code);
                return  codeAddressMapper.selectByExample(example);
            }
        }
       return  null;
    }
    
    /**
     * 
     * 描述: 根据编码查询单个
     * @auther gaojinling
     * @date 2017年3月10日 
     * @param code
     * @return
     */
    public SelectCodeAddress selectByPriKey(String code){
        SelectCodeAddress selectCodeAddress = new SelectCodeAddress();
        CodeAddress codeAddress = codeAddressMapper.selectByPrimaryKey(code);
        if(codeAddress != null){
            selectCodeAddress.setCode(codeAddress.getCode());
            selectCodeAddress.setAddressName(codeAddress.getAddressName());
        }
        return selectCodeAddress;
    }
    
    /**
	 * 描述：通过市编码获取区县
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param cityCode
	 * @throws Exception
	 */
    public List<CodeAddress> selectCountyListByCityCode(String cityCode) throws Exception{
    	if(StringUtil.isEmpty(cityCode)){
    		return null;
    	}
    	return codeAddressMapper.selectCountyListByCityCode(cityCode);
	}
    
    /**
	 * 描述：通过区县编码获取街道信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param countyCode
	 * @throws Exception
	 */
	public List<CodeAddress> selectCountyListByCountyCode(String countyCode) throws Exception{
		if(StringUtil.isEmpty(countyCode)){
    		return null;
    	}
		return codeAddressMapper.selectCountyListByCountyCode(countyCode.substring(0, 6));
	}

}