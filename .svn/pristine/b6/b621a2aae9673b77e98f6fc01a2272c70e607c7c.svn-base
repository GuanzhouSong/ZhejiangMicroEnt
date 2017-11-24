/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.controller;

import java.io.File;
import java.util.Date;
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
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.sment.dto.SmBaseinfoDto;
import com.icinfo.cs.sment.dto.SmEntAbovescaleDto;
import com.icinfo.cs.sment.model.SmEntAbovescale;
import com.icinfo.cs.sment.service.ISmEntAbovescaleService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    sm-ent-abovescale 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年07月20日
 */
@Controller
@RequestMapping("/sment/smEntAbovescale/")
public class SmEntAbovescaleController extends BaseController {
	
	@Autowired
	private ISmEntAbovescaleService smEntAbovescaleService; 
	
	
	/**
	 * 
	 * 描述: 规上企业导入页面
	 * @auther gaojinling
	 * @date 2017年7月20日 
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("toImportList")
    public String toImportList() throws Exception{
        return "sment/smentabovescale/smentabovescale_list";
    }
    
    
    
    
    /**
     * 
     * 描述: 规上企业模板下载
     * @auther gaojinling
     * @date 2017年7月20日 
     * @param request
     * @param file_name
     * @return
     * @throws Exception
     */
	@RequestMapping("downExcelTemplate")
	public ResponseEntity<byte[]> downLoadEnt(HttpServletRequest request, String file_name)throws Exception{
		String path = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/views/page/sment/exceltemplate")+File.separator+"smentabovescale.xlsx";
		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("规上企业导入模板.xlsx".getBytes("GBK"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
	
	/**
	 * 
	 * 描述: 规上企业excel数据导入
	 * @auther gaojinling
	 * @date 2017年7月20日 
	 * @param file
	 * @param response
	 * @param session
	 * @throws Exception
	 */
    @RequestMapping(value="/excelImport",method= RequestMethod.POST)
    @ResponseBody
    public void excelImport(@RequestParam("file") MultipartFile file,@RequestParam("year") String year, HttpServletResponse response,HttpSession session) throws Exception {
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        
        Map<String, Object> resultMap = smEntAbovescaleService.excelImport(file, sysUser,year);
        JSONObject json = new JSONObject();
        if(resultMap != null){        
         json.put("state", "success");
         json.put("status", resultMap.get("status"));
            json.put("allImportTatol", resultMap.get("allImportTatol"));
            json.put("notMatchCount", resultMap.get("notMatchCount"));
            json.put("msg", resultMap.get("msg"));
        }else{
         json.put("state", "error");
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();//关闭流
    }
    
    /**
     * 
     * 描述: 归上企业列表查询
     * @auther gaojinling
     * @date 2017年7月21日 
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "smEntAbovescaleList.json", method = RequestMethod.POST)
	@ResponseBody
	public PageResponse<SmEntAbovescaleDto> queryPageListForEntarchives(PageRequest request) throws Exception {
	 List<SmEntAbovescaleDto> list = smEntAbovescaleService.selectSmEntAbovescale(request);
	 return new PageResponse<SmEntAbovescaleDto>(list);
	}
	
	

	/**
	 * 
	 * 描述: 规上企业修改
	 * @auther gaojinling
	 * @date 2017年7月21日 
	 * @param session
	 * @param busExcList
	 * @param operate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("smEntAbovescaleEdit")
	public ModelAndView smEntAbovescaleEdit(HttpSession session,String uid,String operate) throws Exception{
		ModelAndView view = new ModelAndView("sment/smentabovescale/smentabovescale_edit");
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		SmEntAbovescale  smEntAbovescale = smEntAbovescaleService.selectone(uid);
		view.addObject("sysUser", sysUser);
		view.addObject("smEntAbovescale", smEntAbovescale);
		return view;
	}
	
	/**
	 * 
	 * 描述: 规上企业修改提交
	 * @auther gaojinling
	 * @date 2017年7月21日 
	 * @param pubOpaDetailDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "smEntAbovescaleditCommit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult editCommit(SmEntAbovescaleDto smEntAbovescaleDto) throws Exception{
		smEntAbovescaleDto.setImportTime(new Date());
		if(smEntAbovescaleService.update(smEntAbovescaleDto)>0){
			return AjaxResult.success("归上企业修改成功");
		}else{
			return AjaxResult.error("归上企业修改失败");
		}
	}
	
}