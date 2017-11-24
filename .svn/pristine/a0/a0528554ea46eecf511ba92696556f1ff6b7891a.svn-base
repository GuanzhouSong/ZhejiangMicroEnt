/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import com.icinfo.cs.sment.model.SmBaseinfoTemp;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    sm_baseinfo_temp 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
public interface ISmBaseinfoTempService extends BaseService {
    /** 
     * 描述: 查询分页列表
     * @author 张文男
     * @date 2017年6月15日 
     * @param request
     * @param sysUser
     * @return 
     */
    public PageResponse<SmBaseinfoTemp> queryPageList(PageRequest request,SysUserDto sysUser);
    
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
    
    public Map<String, Object> excelImport(MultipartFile file,SysUserDto sysUser) throws InvalidFormatException,IOException;
    
    /** 
     * 描述: 删除
     * @author 张文男
     * @date 2017年6月15日 
     * @param key 
     */
    
    public void deleteByid(Integer key);
}