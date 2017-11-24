package com.icinfo.cs.system.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeSliceno;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.base.service.ICodeSlicenoService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.PermisionTreeNode;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.tools.utils.StringUtils;

@Controller
@RequestMapping("/reg/system/slicenomanage")
public class SlicenoManageController extends BaseController {

	@Autowired
	private ICodeSlicenoService codeSlicenoService;

	@Autowired
	ICodeRegunitService codeRegunitService;

	/**
	 * 描述: 进入片区商圈维护
	 * 
	 * @auther yujingwei
	 * @date 2016年9月21日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView view = new ModelAndView("/system/slicenomanage/slicenomanage_main");
		return view;
	}

	/**
	 * 描述: 获取片区树 数据
	 * 
	 * @auther yujingwei
	 * @date 2016年9月21日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public AjaxResult listJSON(HttpSession session) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("regUnit_permission_limit", getLimitReg());// 权限限制字段
		List<CodeSliceno> resultData = codeSlicenoService.selectListForTree(param);
		List<PermisionTreeNode> list = new ArrayList<PermisionTreeNode>();
		for (CodeSliceno codeSliceno : resultData) {
			PermisionTreeNode treeNode = new PermisionTreeNode();
			treeNode.setId(codeSliceno.getCode());
			treeNode.setpId(codeSliceno.getSupCode());
			treeNode.setName(codeSliceno.getContent());
			list.add(treeNode);
		}
		return AjaxResult.success("查询成功", list);
	}

	/**
	 * 根据部门id查询部门信息
	 * 
	 * @author yujingwei
	 * @date 2015-9-21
	 * @param deptId
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping({ "selectDetail.json", "list.xml" })
	@ResponseBody
	public AjaxResult selectDetail(String code) throws Exception {
		if (!code.isEmpty()) {
			CodeSliceno codeSliceno = codeSlicenoService.selectCodeSlicenoInfo(code);
			return AjaxResult.success("查询成功", codeSliceno);
		} else {
			return AjaxResult.error("查询失败");
		}
	}

	/**
	 * 描述: 进入添加修改页面
	 * 
	 * @auther yujingwei
	 * @date 2016年9月21日
	 * @param deptid
	 * @param sid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(String code, String sid, String supContent) throws Exception {
		ModelAndView view = new ModelAndView("/system/slicenomanage/slicenomanage_edit");
		if (StringUtil.isNotBlank(code)) {
			CodeSliceno codeSliceno = codeSlicenoService.selectCodeSlicenoInfo(code);
			view.addObject("codeSliceno", codeSliceno);
			view.addObject("supContent", supContent);
		} else {
			if (StringUtils.isNotEmpty(sid)) {
				view.addObject("parentSid", sid);
				view.addObject("supContent", supContent);
			}
		}
		return view;
	}

	/**
	 * 描述: 添加或修改片区商圈信息
	 * 
	 * @auther yujingwei
	 * @date 2016年9月21日
	 * @param department
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(CodeSliceno codeSliceno) throws Exception {
		DecimalFormat df = new DecimalFormat("0000");
		// 根据管辖单位编码查询下面所属片区编码
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("supCode", codeSliceno.getSupCode());
		List<CodeSliceno> slicenoList = codeSlicenoService.selectListForTree(map);
		List<Integer> list = new ArrayList<Integer>();
		for (CodeSliceno sliceno : slicenoList) {
			String code = sliceno.getCode();
			if (code.length() == 12) {
				String subCode = code.substring(8, 12);
				int codeInt = Integer.valueOf(subCode);
				list.add(codeInt);
			}
		}

		String nextCodeSub;
		if (list.size() <= 0) {
			nextCodeSub = "0001";
		} else {
			int maxNum = Collections.max(list);// 取出最大的编号
			nextCodeSub = df.format(maxNum + 1);
		}
		String nextCode = codeSliceno.getSupCode() + nextCodeSub;// 生成下一片区编号
		if (codeSliceno.getId() == null) {
			codeSliceno.setCode(nextCode);
		}
		if (codeSlicenoService.doAddOrEditInfo(codeSliceno)) {
			return AjaxResult.success("保存成功！");
		}
		return AjaxResult.error("保存失败！");
	}

	/**
	 * 描述：删除片区信息
	 * 
	 * @author yujingwei
	 * @param deptId
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(String code) throws Exception {
		if (StringUtils.isEmpty(code)) {
			return AjaxResult.error("删除的片区不存在");
		}
		if (codeSlicenoService.deleteSliceInfoBycode(code) > 0) {
			return AjaxResult.success("删除片区成功");
		}
		return AjaxResult.error("删除片区失败");
	}

	/**
	 * 获取权限限制
	 * 
	 * @return
	 */
	public String getLimitReg() {
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		String level = sysUser.getUserVest(sysUser);
		String isAdmin = sysUser.getIsAdmin();
		// 1：本所2：本局3：本市4：本省
		if (StringUtils.isNotBlank(isAdmin) && "1".equals(isAdmin)) { // 管理员权限放开
			return "";
		}
		if (StringUtils.equalsIgnoreCase(level, "1") || StringUtils.isBlank(level)) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 8);
		}
		if (StringUtils.equalsIgnoreCase(level, "2")) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 6);
		}
		if (StringUtils.equalsIgnoreCase(level, "3")) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 4);
		}
		return "";
	}
}
