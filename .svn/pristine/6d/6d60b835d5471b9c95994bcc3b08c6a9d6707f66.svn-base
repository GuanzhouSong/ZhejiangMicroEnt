/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.specialrec.controller;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.specialrec.dto.SpecialRecEntDto;
import com.icinfo.cs.specialrec.service.ISpecialRecEntService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_special_rec_ent 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
@Controller
@RequestMapping({"/reg/server/specialrec/ent","/syn/server/specialrec/ent"})
public class SpecialRecEntController extends CSBaseController {
	
	@Autowired
	private ISpecialRecEntService specialRecEntService;
	
	/**
	 * 描述：查询检查名单列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<SpecialRecEntDto> listJSON(PageRequest request) throws Exception {
		if (request != null) {
			Map<String, Object> qryMap = request.getParams();
			//去掉查询参数的左右空格
			StringUtil.paramTrim(qryMap);
		}
		List<SpecialRecEntDto> specialRecTaskList = specialRecEntService.querySpecialrecEntList(request);
		return new PageResponse<SpecialRecEntDto>(specialRecTaskList);
	}
	
	/**
	 * 描述：添加检查名单
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param specialRecTask
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "addSpecialreceEnt", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult addSpecialreceEnt(String taskUid, String priPIDs, HttpSession session) throws Exception{
		try {
			String reBackUid = specialRecEntService.addSpecialreceEntBatch(taskUid, priPIDs);
			if (reBackUid != null) {
				return AjaxResult.success("导入成功！",reBackUid);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return AjaxResult.error("导入失败！");
		}
		return AjaxResult.error("导入失败！");
	}
	
	/**
	 * 描述：删除检查对象信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param delUidList
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteSpeciakrecEnt(String delUidList) throws Exception{
		try {
			if (specialRecEntService.doDelSpecialRecEntInfo(delUidList) > 0) {
				return AjaxResult.success("删除成功！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return AjaxResult.error("删除失败！");
		}
		return AjaxResult.error("删除失败！");
	}
	
	/**
	 * 描述：清空检查对象信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param taskUid
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "cleanAll", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult cleanAllSpeciakrecEnt(String taskUid) throws Exception{
		try {
			if (specialRecEntService.doCleanSpecialRecEntInfo(taskUid) > 0) {
				return AjaxResult.success("清除成功！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return AjaxResult.error("清除失败！");
		}
		return AjaxResult.error("清除失败！");
	}
	
	/**
     * 描述：批量导入待抽检库
     * @author yujingwei
     * @date 2017-05-17
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/export",method= RequestMethod.POST)
    @ResponseBody
    public void doExportEnt(@RequestParam("file") MultipartFile file, String taskUid,HttpServletResponse response,HttpSession session) throws Exception {
        InputStream in = file.getInputStream();
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        JSONObject json = specialRecEntService.doAddExcelBatch(in, taskUid,sysUser);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();//关闭流
    }
	
	/**
	 * 检查主体名单导入模板下载
	 * @author yujingwei
	 * @date 2017年5月10日 
	 * @throws Exception
	 */
	@RequestMapping("/downloadExcel")
	public ResponseEntity<byte[]> downloadExcel(HttpServletRequest request, String file_name)throws Exception{
		String path = request.getSession().getServletContext()
				.getRealPath("/template")+File.separator+file_name;
		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("专项整治名单导入模板.xls".getBytes("GBK"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
}