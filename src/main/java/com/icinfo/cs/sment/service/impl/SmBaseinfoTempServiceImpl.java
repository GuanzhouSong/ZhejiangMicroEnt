/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.sment.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sment.mapper.SmBaseinfoTempMapper;
import com.icinfo.cs.sment.model.SmBaseinfoTemp;
import com.icinfo.cs.sment.service.ISmBaseinfoTempService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.upload.utils.ExcelUtil;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    sm_baseinfo_temp 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class SmBaseinfoTempServiceImpl extends MyBatisServiceSupport implements ISmBaseinfoTempService {

    @Autowired
    private SmBaseinfoTempMapper smBaseinfoTempMapper;

    /** 
     * 描述: 查询分页列表
     * @author 张文男
     * @date 2017年6月15日 
     * @param request
     * @param sysUser
     * @return 
     */
    public PageResponse<SmBaseinfoTemp> queryPageList(PageRequest request,SysUserDto sysUser){
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        Map<String, Object> queryMap = request.getParams ();

        String entName = queryMap.get ("entName").toString ();
        String regNO = queryMap.get ("regNO").toString ();

        Example example = new Example (SmBaseinfoTemp.class);
        Criteria c = example.createCriteria ();
        c.andEqualTo ("userId", sysUser.getId ());
        if (StringUtil.isNotBlank (entName)) {
            entName = entName.replaceAll ("%", "");
            if (StringUtil.isNotBlank (entName)) {
                c.andLike ("entName", "%" + entName + "%");
            }
        }
        if (StringUtil.isNotBlank (regNO)) {
            regNO = regNO.replaceAll ("%", "");
            if (StringUtil.isNotBlank (regNO)) {
                c.andLike ("regNO","%" + regNO );
            }
        }
        
        List<SmBaseinfoTemp> list = smBaseinfoTempMapper.selectByExample (example);

        return new PageResponse<SmBaseinfoTemp> (list);
    }

    /** 
     * 描述: excel导入
     * @author 张文男
     * @date 2017年6月15日 
     * @param file
     * @param sysUser
     * @return
     * @throws InvalidFormatException
     * @throws IOException 
     */
    
    public Map<String, Object> excelImport(MultipartFile file,SysUserDto sysUser) throws InvalidFormatException,IOException{
        Map<String, Object> qMap = new HashMap<String, Object> ();
        // 校验成功状态 0 成功 1 失败
        qMap.put ("status", "0");
        StringBuffer bf = new StringBuffer ();

        // 解析excel
        Workbook workbook = WorkbookFactory.create (file.getInputStream ());
        Sheet sheet = workbook.getSheetAt (0);
        int rows = sheet.getPhysicalNumberOfRows ();
        if (rows < 3) { return null; }
        int allImportTatol = 0;
        // 遍历处理每行
        for ( int i = 2 ; i < rows ; i++ ) {
            int count = i;
            Row row = sheet.getRow (i);

            String regOrUnicode = com.icinfo.cs.common.utils.ExcelUtil.parseCellValueToString (row.getCell (0));// 注册号或统一代码
            String entName = ExcelUtil.getCellContent (row.getCell (1)); // 企业名称
            if (StringUtil.isBlank (regOrUnicode)) {
                ++count;
                bf.append ("第" + count + "行第1列统一信用代码/注册号不能为空;");
                qMap.put ("status", "1");
                continue;
            }
            
            if (StringUtil.isBlank (entName)) {
                ++count;
                bf.append ("第" + count + "行第2列企业名称不能为空;");
                qMap.put ("status", "1");
                continue;
            }
            if(StringUtil.isNotBlank (regOrUnicode) && StringUtil.isNotBlank (entName)){
                SmBaseinfoTemp smBaseinfoTemp = new SmBaseinfoTemp ();
                smBaseinfoTemp.setCreateTime (new Date());
                smBaseinfoTemp.setEntName (entName);
                smBaseinfoTemp.setRegNO (regOrUnicode);
                smBaseinfoTemp.setUserId (sysUser.getId ());
                
                smBaseinfoTempMapper.insert (smBaseinfoTemp);
                allImportTatol++;
            }
            
        }
        qMap.put("allImportTatol", allImportTatol);
        qMap.put("msg", bf.toString());
        return qMap;
    }
    
    /** 
     * 描述: 删除
     * @author 张文男
     * @date 2017年6月15日 
     * @param key 
     */
    
    public void deleteByid(Integer key){
        smBaseinfoTempMapper.deleteByPrimaryKey (key);
    }
}