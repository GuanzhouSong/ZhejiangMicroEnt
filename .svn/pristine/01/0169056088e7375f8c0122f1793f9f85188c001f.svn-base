/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.rpt.rptdto.RptWarningInfoDto;
import com.icinfo.cs.rpt.rptservice.IRptWarningInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_rpt_warning_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年10月18日
 */
@Controller
@RequestMapping("/reg/server/rptWarningInfo" )
public class RptWarningInfoController extends CSBaseController {
	
	@Autowired
	private IRptWarningInfoService rptWarningInfoService;
	


	/**
	 * 
	 * 描述: 警示首页风险监测统计项
	 * @auther gaojinling
	 * @date 2017年10月18日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/rptWarningInfoCount.json","list.xml"})
	@ResponseBody
	public AjaxResult rptWarningInfoCountJson(String selectCode)throws Exception{
	 Map<String, Object> map = new HashMap<String, Object>();
	 map.put("selectCode", selectCode);
	 creatOptDBAuthEnv(map,"regorg","localadm");
     SysUserDto sysUser= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
     if("1".equals(sysUser.getUserType())){
    	 map.put("deptCode",sysUser.getDeptCode() != null ? StringUtil.substring(sysUser.getDeptCode(), 0, 8) : "000000");
     }
      RptWarningInfoDto rptWarningInfoDto = rptWarningInfoService.selectWarnCount(map);
	 
	 //2.3抽检部分
	 RptWarningInfoDto dto = rptWarningInfoService.selectRptScentCheck(sysUser);
	 if(rptWarningInfoDto != null){
		 rptWarningInfoDto.setDeptCode(dto == null ? "" : dto.getDeptCode());
		 rptWarningInfoDto.setSetUserUid(dto == null ? "" : dto.getSetUserUid());
		 rptWarningInfoDto.setNum(dto == null ? 0 : dto.getNum());
	 }
	 return AjaxResult.success("rptWarningInfoDto",rptWarningInfoDto);
	}
}