/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.SysLicenseMapper;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.model.SysLicense;
import com.icinfo.cs.yr.service.ISysLicenseService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述: cs_sys_license 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
@Service
public class SysLicenseServiceImpl extends MyBatisServiceSupport implements ISysLicenseService {
    @Autowired
    SysLicenseMapper sysLicenseMapper;

    @Override
    public List<SysLicense> queryPageResult(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return sysLicenseMapper.queryPageResult(request.getParams());
    }

    @Override
    public SysLicense doGetSysLicenseById(Integer sysLicenseId) {
        return sysLicenseMapper.selectByPrimaryKey(sysLicenseId);
    }

    @Override
    public int deleteById(Integer sysLicenseId) {
        return sysLicenseMapper.deleteByPrimaryKey(sysLicenseId);
    }

    @Override
    public int update(SysLicense sysLicense) {
        return sysLicenseMapper.updateByPrimaryKeySelective(sysLicense);
    }

    @Override
    public int insert(SysLicense sysLicense) {
    	sysLicense.setOrderBy(2); //设置初始排序优先级为2
        sysLicense.setCreateTime(DateUtils.getSysDate());
        return sysLicenseMapper.insert(sysLicense);
    }

    /**
     *
     * 描述: 根据licNo查询单个许可证
     * @auther gaojinling
     * @date 2016年9月26日
     * @param licNo
     * @return
     */
    public SysLicense selectOneByLicNO(String licNO) {
        SysLicense sysLicense = new SysLicense();
        sysLicense.setLicNO(licNO);
        return sysLicenseMapper.selectOne(sysLicense);
    }

    /**
     *
     * 描述: 查询有效的许可证列表
     * @auther gaojinling
     * @date 2016年9月26日
     * @return
     */
    public List<SysLicense> selectVaildLicList(String licConent) {
        Example example = new Example(SysLicense.class);
        example.orderBy("licNO").asc();
        if(StringUtil.isNotBlank(licConent)){
            example.createCriteria().andEqualTo("isValid", "1").andLike("licName", "%"+licConent+"%");
        }else{
            example.createCriteria().andEqualTo("isValid", "1");
        }
        return sysLicenseMapper.selectByExample(example);
    }

    /**
     *
     * 描述: 获取无证无照涉嫌违法事项列表
     * @auther ylr
     * @date 2016年11月4日
     * @return
     */
    public List<SysLicense> selectSysLicenseList(Map<String, Object> qryMap) throws Exception{
        return sysLicenseMapper.selectSysLicenseList(qryMap);
    }

    @Override
    public List<Map<String, String>> listSelect(String licName) {
      Map param = new HashedMap();
        param.put("licName",licName);
        return  sysLicenseMapper.listSelect(param);
    }
    
    
    /**
    *
    * 描述: 查询有效的许可证列表(优先排序为已经设置的优先级)
    * @auther gaojinling
    * @date 2016年9月26日
    * @return
    */
   public List<SysLicense> selectVaildLicListOrderBy(String licConent) throws Exception {
       Example example = new Example(SysLicense.class);
       example.orderBy("orderBy").asc().orderBy("licNO").asc();
       if(StringUtil.isNotBlank(licConent)){
           example.createCriteria().andEqualTo("isValid", "1").andLike("licName", "%"+licConent+"%");
       }else{
           example.createCriteria().andEqualTo("isValid", "1");
       }
       return sysLicenseMapper.selectByExample(example);
   }
    
}