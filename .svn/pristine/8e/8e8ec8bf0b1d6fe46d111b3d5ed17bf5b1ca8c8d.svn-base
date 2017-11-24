/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.system.dto.PermisionTreeNode;
import com.icinfo.cs.yr.dto.SysLicenseDto;
import com.icinfo.cs.yr.model.SysLicense;
import com.icinfo.cs.yr.service.ISysLicenseService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * 描述: cs_sys_license 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
@Controller
@RequestMapping({"/reg/server/yr/syslicense/","/syn/yr/syslicense/","/commom/yr/syslicense"})
public class SysLicenseController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SysLicenseController.class);

    @Autowired
    ISysLicenseService sysLicenseService;

    /**
     * 描述：进入许可证清单维护列表页面
     *
     * @author baifangfang
     * @date 2016年9月8日
     * @return
     * @throws Exception
     */
    @RequestMapping("list")
    public ModelAndView list() throws Exception {
        ModelAndView mav = new ModelAndView("reg/server/yr/syslicense/syslicence_list");
        return mav;
    }

    /**
     * 描述：获取无证无照涉嫌违法事项列表
     *
     * @author ylr
     * @date 2016年11月4日
     * @throws Exception
     */
    @RequestMapping("doGetNoCardItemList")
    @ResponseBody
    public AjaxResult doGetNoCardItemList(String licType,String searchParam) throws Exception {
        Map<String, Object> qryMap = new HashMap<String, Object>();
        qryMap.put("licType", licType);
        qryMap.put("licName", searchParam);
        List<SysLicense> sysLicenseList = sysLicenseService.selectSysLicenseList(qryMap);

        return AjaxResult.success("成功！", sysLicenseList);
    }


    /**
     * 描述：许可证清单维护JSON数据列表
     *
     * @author baifangfang
     * @date 2016年8月30日
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({ "list.json", "list.xml" })
    @ResponseBody
    public PageResponse<SysLicense> listJSON(PageRequest request) throws Exception {
        List<SysLicense> sysLicenses = sysLicenseService.queryPageResult(request);
        logger.info("sysLicenses {}", sysLicenses);
        return new PageResponse<SysLicense>(sysLicenses);
    }

    @RequestMapping({ "listSelect.json", "list.xml" })
    @ResponseBody
    public AjaxResult listSelect(String licName) throws Exception {

        List<Map<String,String>> data = sysLicenseService.listSelect(licName);
        return AjaxResult.success("",data);
    }
    /**
     * 描述：根据sysLicenseId查询许可证清单(进入添加或修改页面)
     *
     * @author baifangfang
     * @date 2016年8月30日
     * @param sysLicenseId
     * @return
     */
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam(required = false) Integer sysLicenseId) {
        ModelAndView mav = new ModelAndView("reg/server/yr/syslicense/syslicence_edit");

        if (!StringUtils.isEmpty(sysLicenseId)) {
            SysLicense sysLicense = sysLicenseService.doGetSysLicenseById(sysLicenseId);
            logger.info("sysLicense {}", sysLicense);
            mav.addObject("sysLicense", sysLicense);
        }
        return mav;
    }

    /**
     * 描述：添加或修改许可证清单
     *
     * @author baifangfang
     * @date 2016年8月30日
     * @param sysLicense
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult save(@Valid @RequestBody SysLicenseDto sysLicense, HttpSession session, BindingResult result) {
        UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
        sysLicense.setSetId(userProfile.getUserId());
        sysLicense.setSetName(userProfile.getUsername());
        logger.info("sysLicense {}", sysLicense);

        if (result.hasErrors()) {
            // 参数验证错误
            AjaxResult error = AjaxResult.error("参数验证错误");
            error.addErrorInfo(result.getAllErrors());
            return error;
        }
        if (!StringUtils.isEmpty(sysLicense.getId())) {
            if (sysLicenseService.update(sysLicense) > 0) {
                return AjaxResult.success("更新许可证成功");
            }
            return AjaxResult.error("更新许可证失败!");
        }
        if (sysLicenseService.insert(sysLicense) > 0) {
            return AjaxResult.success("添加许可证成功.");
        }
        return AjaxResult.error("添加许可证失败!");
    }

    /**
     * 描述：根据id删除许可证
     *
     * @author baifangfang
     * @date 2016年9月8日
     * @param sysLicenseId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public AjaxResult delete(@RequestParam Integer sysLicenseId) throws Exception {
        if (StringUtils.isEmpty(sysLicenseId)) {
            return AjaxResult.error("未选择删除许可证!");
        }
        if (sysLicenseService.deleteById(sysLicenseId) > 0) {
            return AjaxResult.success("删除许可证成功.");
        }
        return AjaxResult.error("删除许可证失败!");
    }
    
    
	/**
	 * 
	 * 描述: 许可证列表
	 * @auther gaojinling
	 * @date 2016年9月26日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"treelist.json","list.xml"})
	@ResponseBody
	public AjaxResult listJSON(String licConent)throws Exception{
	 List<SysLicense> data=	sysLicenseService.selectVaildLicList(licConent);
	 List<PermisionTreeNode> list=new ArrayList<PermisionTreeNode>();
	//因为审批事项没有上下级关系 这里默认给它设置一个父节点
	 PermisionTreeNode praenttreeNode = new PermisionTreeNode(); 
	 praenttreeNode.setName("许可证列表");
     praenttreeNode.setId("0");
	 praenttreeNode.setpId("0");
	 list.add(praenttreeNode);
	 for(SysLicense sysLicense:data){
		 PermisionTreeNode prT=new PermisionTreeNode();
		 prT.setId(sysLicense.getLicNO());
		 prT.setpId("0");
		 prT.setName(sysLicense.getLicName().toString());
		 prT.setOpen(true);
		 list.add(prT);
	 }
	 
	 return AjaxResult.success("查询成功",list);
	}
	
	
	/**
	 * 
	 * 描述: 根据licNo查询
	 * @auther gaojinling
	 * @date 2016年9月26日 
	 * @param licNO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"selectDetail.json","list.xml"})
	@ResponseBody
	public AjaxResult selectDetail(String licNO) throws Exception{
	  if(!licNO.isEmpty()){
		  SysLicense sysLicense=sysLicenseService.selectOneByLicNO(licNO);
	      return AjaxResult.success("查询成功",sysLicense);
	  }else{
		  return AjaxResult.error("查询失败");
	  }
	}
}