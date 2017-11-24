package com.icinfo.cs.yr.controller.reg.server;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * 描述:    cs_department 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月20日
 */
@Controller
@RequestMapping("/reg/server/yr/departname")
public class DepartmentNameController extends CSBaseController {
	@Autowired
	private IDepartMentService departMentService;
	
	
	
	/**
	 * 描述: 进入部门名称规范维护页面
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public  ModelAndView list() throws Exception{
		ModelAndView view=new ModelAndView("/reg/server/yr/sysmanage/deptname/list");
		return view;
	}
	
	/**
	 * 描述: 获取部门名称规范管理列表数据
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
    @ResponseBody
    public PageResponse<DepartMent> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"deptCode","deptCode");
		List<DepartMent> data = departMentService.queryPage(request);
        return new PageResponse<DepartMent>(data);
    }
	
	/**
	 * 描述: 进入部门名称规范管理修改页面
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view")
	public  ModelAndView list(String deptDID) throws Exception{
		ModelAndView view=new ModelAndView("/reg/server/yr/sysmanage/deptname/edit");
		DepartMent departMent = departMentService.selectOne(deptDID);
	    view.addObject("departMent", departMent);
		return view;
	}
	
	/**
	 * 描述: 保存部门信息
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public  AjaxResult save(DepartMent department,HttpSession session) throws Exception{
		UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
		if(department.getDeptDID() != null){
			department.setSetName(userProfile.getRealName());
			department.setSetTime(new Date());
			if(departMentService.update(department) > 0){
				return AjaxResult.success("保存成功！");
			}
		}
		return AjaxResult.error("保存失败！");
	}
}
