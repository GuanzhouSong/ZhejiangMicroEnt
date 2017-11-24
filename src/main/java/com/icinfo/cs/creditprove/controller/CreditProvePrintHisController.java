/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.creditprove.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.creditprove.model.CreditProvePrintHis;
import com.icinfo.cs.creditprove.service.ICreditProvePrintHisService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_credit_prove_print_his 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
@Controller
@RequestMapping({ "/syn/creditproveprinthis", "/reg/server/creditproveprinthis" })
public class CreditProvePrintHisController extends CSBaseController {
	@Autowired
	private ICreditProvePrintHisService creditProvePrintHisService;
	
	/**
	 * 
	 * 描述   根据查证单编号查询打印记录
	 * @author 赵祥江
	 * @date 2017年4月18日 下午1:59:27 
	 * @param 
	 * @return PageResponse<CreditProvePrintHis>
	 * @throws
	 */
	@RequestMapping("/selectCreditProvePrintHisJSON.json")
	@ResponseBody
	public PageResponse<CreditProvePrintHis> selectCreditProvePrintHisJSON(PageRequest request) throws Exception {
		List<CreditProvePrintHis> creditProvePrintHisList=creditProvePrintHisService.selectCreditProvePrintHisJSON(request);
		return  new PageResponse<CreditProvePrintHis>(creditProvePrintHisList); 
	}
	
	/**
	 * 
	 * 描述   保存打印记录
	 * @author 赵祥江
	 * @date 2017年4月19日 上午11:24:04 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(String proveNo,HttpSession session) throws Exception{
		if (StringUtil.isNotEmpty(proveNo)) { 
			try {
				SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
				CreditProvePrintHis creditProvePrintHis=new CreditProvePrintHis();
				//协同
				if("2".equals(sysUser.getUserType())){
					creditProvePrintHis.setPrintDeptName(sysUser.getSysDepart().getOrgName());
				}else{
					creditProvePrintHis.setPrintDeptName(sysUser.getDepartMent().getDeptName());
				}
				creditProvePrintHis.setPrintName(sysUser.getRealName());
				creditProvePrintHis.setProveNo(proveNo);
				creditProvePrintHis.setPrintTime(DateUtil.getSysDate());
				creditProvePrintHisService.insertCreditProvePrintHis(creditProvePrintHis);
				return AjaxResult.success("保存成功");
			} catch (Exception e) {
				e.printStackTrace();
			}   
		}
		return  AjaxResult.error("保存失败");
	}
}