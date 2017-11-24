package com.icinfo.cs.favorable.controller;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
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
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.favorable.dto.FavorAbleInfoDto;
import com.icinfo.cs.favorable.model.FavorAbleInfo;
import com.icinfo.cs.favorable.service.IFavorAbleInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;


@Controller
@RequestMapping({"/reg/server/favorableinput", "/syn/favorableinput"})
public class FavorAbleInfoInputController extends CSBaseController {
	
	@Autowired
	private IFavorAbleInfoService favorAbleInfoService;
	
	@Autowired
	private IPanoramaSearchService panoramaSearchService;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	
	/**
	 * 描述   进入企业良好信息录入页面
	 * @author yujingwei
	 * @date 2017年3月2日 
	 * @return view
	 */
	@RequestMapping("/list")
	public ModelAndView favorableInfoInputList() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/favorable/favorableinput_list");
		view.addObject("yearList", DateUtil.getYearToNow());
		return view;
	}
	
	/**
	 * 描述   进入企业良好信息录入新增列表页面
	 * @author yujingwei
	 * @date 2017年3月2日 
	 * @return view
	 */
	@RequestMapping("/addview")
	public ModelAndView doViewAdd() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/favorable/favorableadd_list");
		return view;
	}
	
	/**
	 * 描述   进入企业良好信息新增页面
	 * @author yujingwei
	 * @date 2017年3月2日 
	 * @return view
	 */
	@RequestMapping("/addOrEditView")
	public ModelAndView doAddOrEditView(String priPID , String uid , String isAudit) throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/favorable/favorablea_edit");
		if(StringUtil.isNotEmpty(uid)){
			FavorAbleInfo favorAbleInfo = favorAbleInfoService.selectFavorAbleInfoByUid(uid);
			view.addObject("favorAbleInfo", favorAbleInfo);
		}
		MidBaseInfo baseInfo = midBaseInfoService.selectByPripid(priPID);
		view.addObject("baseInfo", baseInfo);
		view.addObject("isAudit", isAudit);
		view.addObject("yearList", DateUtil.getYearToNow());
		return view;
	}
	
	/**
	 * 描述：查询企业良好信息录入列表数据
	 * @author yujingwei
	 * @date 2017年3月2日 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<FavorAbleInfoDto> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"a.checkDep","a.localAdm");
		Map<String,Object> parmMap=request.getParams();
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		com.icinfo.cs.common.utils.StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
		List<FavorAbleInfoDto> favorAbleInfoList  = favorAbleInfoService.queryPageResult(request);
		return new PageResponse<FavorAbleInfoDto>(favorAbleInfoList);
	}
	
	/**
	 * 描述：删除企业良好信息
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doDeleteFavorableInfo(String uid) throws Exception{
		if(StringUtil.isBlank(uid)){
			return AjaxResult.error("删除失败！");
		}
		if(favorAbleInfoService.doDeleteInfoByUid(uid) > 0){
			return AjaxResult.success("删除成功！");
		}
		return AjaxResult.success("删除失败！");
	}
	
	/**
	 * 描述：保存或修改企业良好信息
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveOrEdit", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=2000)
	public AjaxResult doSaveOrEditFavorableInfo(FavorAbleInfo favorAbleInfo) throws Exception{
		if(favorAbleInfo == null)
			return AjaxResult.success("保存失败！");
		if(StringUtil.isNotEmpty(favorAbleInfo.getUid())){
			if(favorAbleInfoService.doUpdateFavorableInfo(favorAbleInfo,favorAbleInfo.getUid()) > 0){
				return AjaxResult.success("保存成功！");
			}
		}else{
			if(favorAbleInfoService.doSaveFavorableInfo(favorAbleInfo) > 0){
				return AjaxResult.success("保存成功！");
			}
		}
		return AjaxResult.success("保存失败！");
	}
	
	/**
	 * 获取查询企业列表
	 * @author yujingwei
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/panoQueryPage"})
	@ResponseBody
	public PageResponse<PanoramaResultDto> panoQueryPage(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"checkDep","localAdm");
		Map<String,Object> parmMap=request.getParams();
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		com.icinfo.cs.common.utils.StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}
	
	/**
	 * 企业良好信息模板下载
	 * @author yujingwei
	 * @date 2017年3月13日 
	 * @throws Exception
	 */
	@RequestMapping("/favorablemod")
	public ResponseEntity<byte[]> commitment(HttpServletRequest request, String file_name)throws Exception{
		String path = request.getSession().getServletContext()
				.getRealPath("WEB-INF/views/page/reg/server/favorable")+File.separator+"favorable.xlsx";
		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("企业良好信息导入模板.xlsx".getBytes("GBK"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
	
	 /**
     * 描述：excel批量导入企业良好信息
     * @author chenxin
     * @date 2016-10-26
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/addbatch",method= RequestMethod.POST)
    @ResponseBody
    public void addbatch(@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpSession session) throws Exception {
        InputStream in = file.getInputStream();
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        Map<String, String> resultMap = favorAbleInfoService.doSaveFavorableInfoExcelBatch(in , sysUser);
        JSONObject json = new JSONObject();
        if(resultMap != null){
        	json.put("status", "success");
            json.put("regNOs", resultMap.get("regNOs"));
        }else{
        	json.put("status", "error");
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();//关闭流
    }
	

}
