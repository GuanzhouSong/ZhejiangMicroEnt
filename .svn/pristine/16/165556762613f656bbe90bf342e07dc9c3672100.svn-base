/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.SignatureMapper;
import com.icinfo.cs.yr.model.Signature;
import com.icinfo.cs.yr.service.ISignatureService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  cs_signature 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月18日
 */
@Service
public class SignatureServiceImpl extends MyBatisServiceSupport implements ISignatureService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SignatureServiceImpl.class);

    @Autowired
    private SignatureMapper signatureMapper;

    /**
    * 描述：只根据年份和pripid查询  不查询签章状态
    * @param year
    * @param pripid
    * @return
     */
    @Override
    public Signature selectNotbySatuts(String year, String pripid) {
        if(StringUtil.checkYearAndPripid(year,pripid)){
            Signature signature = new Signature();
            signature.setYear(Integer.valueOf(year));
            signature.setPriPID(pripid);
            return  signatureMapper.selectOne(signature);
        }
        return null;
    }

    /**
     * 描述：根据年份和内部序号查询当前对象
     * @param year
     * @param pripid
     * @return
     */
    @Override
    public Signature selectByYearAndPripid(String year, String pripid) {
        if(StringUtil.checkYearAndPripid(year,pripid)){
            Signature signature = new Signature();
            signature.setYear(Integer.valueOf(year));
            signature.setPriPID(pripid);
            signature.setQzStatus("1");   //查询签章成功的状态
            return  signatureMapper.selectOne(signature);
        }
        return null;
    }
    /**
     * 描述：新增一条签章纪录
     * @param year
     * @param pripid
     * @return
     */
    @Override
    public int save(String year, String pripid,String sealImgBase64) {
        Signature signature = new Signature();
        if(StringUtil.checkYearAndPripid(pripid,year)) {
            signature.setYear(Integer.valueOf(year));
            signature.setPriPID(pripid);
            signature.setQzStatus("1"); //签章成功
            signature.setTextCode(sealImgBase64);//签章图片路径
            signature.setQzTime(DateUtil.getSysDate());//签章时间
            signature.setCreateTime(DateUtil.getSysDate());//创建时间
            return signatureMapper.insert(signature);
        }
        return 0;
    }

    /**
     * 描述：根据参数条件修改签章状态
     * @param signature
     * @return
     */
    @Override
    public int modify(Signature signature) {
        if(StringUtil.checkYearAndPripid(signature.getYear(),signature.getPriPID())) {
            signature.setQzStatus("1"); //修改为签章成功状态
            Example example = new Example(Signature.class);
            example.createCriteria().andEqualTo("priPID", signature.getPriPID()).andEqualTo("year",signature.getYear());
            return signatureMapper.updateByExample(signature,example);
        }
        return 0;
    }

    /**
     * 描述：修改签章失败后的状态
     * @param signature
     * @return
     */
    @Override
    public int modifyStatus(Signature signature) {
        if(signature!=null){
            if(StringUtil.checkYearAndPripid(signature.getYear(),signature.getPriPID())) {
                signature.setQzStatus("0"); //修改为签章失败状态
                Example example = new Example(Signature.class);
                example.createCriteria().andEqualTo("priPID", signature.getPriPID()).andEqualTo("year",signature.getYear());
                return signatureMapper.updateByExample(signature,example);
            }
        }
        return 0;
    }

}