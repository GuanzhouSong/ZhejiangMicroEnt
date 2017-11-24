/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.*;
import com.icinfo.cs.yr.service.*;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_yr_forguaranteeinfo 对应的Controller类.<br>
 * 对外担保
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping({"/reg/client/yr/ent/forguarantee","/syn/client/yr/ent/forguarantee"})
public class YrForGuaranteeInfoController extends BaseController {
	@Autowired
	private IYrForGuaranteeInfoService yrForGuaranteeInfoService;  
	@Autowired
	private IYrFormService yrFormService;
	@Autowired
	IYrBaseInfoService yrBaseInfoService;
	@Autowired
	IYrRegCheckService yrRegCheckService;
	@Autowired
	private ISignatureService signatureService;



	/**
	 * 页面显示
	 * @param
	 * @author: wangjin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(String year,HttpSession session) throws Exception {

		ModelAndView view = new ModelAndView("reg/client/yr/forguarantee/forguarantee_edit");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码

		if(StringUtil.checkYearAndPripid(year,priPID)) {
			String encodeYear = year;          //接收加密年份
			year = AESEUtil.decodeYear(year);  //年份解密

			//获取年报anCheID
			YrBaseInfo yrBaseInfo = yrBaseInfoService.selectByYearAndPriPID(Integer.valueOf(year), priPID);
			if (yrBaseInfo != null) {
				if (com.icinfo.framework.mybatis.mapper.util.StringUtil.isNotEmpty(yrBaseInfo.getAnCheID())) {
					view.addObject("anCheID", yrBaseInfo.getAnCheID());
				}
			}

			//查询年报主表信息
			YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year));
			//获取表单填写的状态
			YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID, Integer.valueOf(year));


			//获取电子公章图片字符串路径
			Signature signature = signatureService.selectByYearAndPripid(year,priPID);
			if(signature!=null&& com.icinfo.framework.tools.utils.StringUtils.isNotBlank(signature.getTextCode())){
				view.addObject("qzImgBase64", signature.getTextCode());
			}

			view.addObject("year", year);
			view.addObject("encodeYear", encodeYear);  //年份进行加密
			view.addObject("priPID", priPID);
			view.addObject("tabName", RepTypeUtil.formForguaranteeinfo);//对外担保
			view.addObject("yrRegCheck", yrRegCheck);//年报主表信息
			view.addObject("yrForm", yrForm);
		}

		return view;
	}


	/**
	 *
	 * 外投资信息表 数据列表 当前年份的上一年
	 * @author: wangjin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list_json_last"})
	@ResponseBody
	public PageResponse<YrForGuaranteeInfo> list_json_last(PageRequest request) throws Exception {
		List<YrForGuaranteeInfo> data = yrForGuaranteeInfoService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrForGuaranteeInfo>(data);
	}


	/**
	 *
	 * 外投资信息表 数据列表 当前年份
	 * @author: wangjin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list_json_tody"})
	@ResponseBody
	public PageResponse<YrForGuaranteeInfo> list_json_tody(PageRequest request,HttpSession session) throws Exception {

		String year = (String)request.getParams().get("year"); //获取当前年份
		String priPID = (String) request.getParams().get("priPID");//主体身份代码

		if(StringUtil.checkYearAndPripid(year,priPID)) {

			if (!(year.equals(session.getAttribute("yrForGuaranteeInfo_flag")))) {
				session.removeAttribute("yrForGuaranteeInfo_flag");//如果不是同一年份则删除该session值
			}
			//手动全部清除列表   数据的标识
			String delteFalg = (String) session.getAttribute("yrForGuaranteeInfo_flag");  //获取手动全部删除的session 年份值

			YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year)); //获取年报信息
			if (yrRegCheck != null && "0".equals(yrRegCheck.getIsReported())) {       //判断当前对象是否已经进行年报 如果进行年报 则不再往下执行
				YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID, Integer.valueOf(year));
				if (yrForm != null && !"1".equals(yrForm.getForguaranteeinfo())) {   //如果是未填报就往下执行
					if (!year.equals(delteFalg)) {        //用于判断当前插入的上一年的数据是否是手动清空 而就不必再次插入上一年的数据
						List<YrForGuaranteeInfo> list = yrForGuaranteeInfoService.selectByYearAndPripidList(Integer.valueOf(year), priPID); //获取当前数据
						if (list.size() == 0) {   //如果当前年份的数据为空的时候 往下执行
							YrBaseInfo yrBaseInfo = yrBaseInfoService.selectByYearAndPriPID(Integer.valueOf(year), priPID); //获取年基本信息 主要是为了获取年报id
							List<YrForGuaranteeInfo> _list = yrForGuaranteeInfoService.selectByYearAndPripidList(Integer.valueOf(year) - 1, priPID);
							yrForGuaranteeInfoService.insertYrForGuaranteeinfoList(_list, yrBaseInfo.getAnCheID());
						}
					}
				}
			}
		}

		List<YrForGuaranteeInfo> data = yrForGuaranteeInfoService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrForGuaranteeInfo>(data);
	}


	/**
	 *	主债权数额 (合计)
	 * @author: wangjin
	 * @param year
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/countMoney", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult countMoney(String year,String priPID) throws Exception {
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put(Constants.CS_PRIPID, priPID);
		queryMap.put(Constants.CS_YEAR,year );
		BigDecimal sumMoney =  new BigDecimal(0);
		if(StringUtil.checkYearAndPripid(year,priPID)){
			//主债权数额 (合计)
			 sumMoney = yrForGuaranteeInfoService.sumMoney(queryMap);
			 sumMoney = sumMoney.setScale(4, BigDecimal.ROUND_HALF_UP);
		}
		return AjaxResult.success("",sumMoney);
	}


	/**
	 * 保存和更新操作页面
	 * @author: wangjin
	 * @param moreID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit_show", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult edit_show(String moreID,String priPID) throws Exception {
		if(StringUtil.isNotEmpty(moreID)&&StringUtil.isNotEmpty(priPID)){
			return AjaxResult.success("更新成功!",yrForGuaranteeInfoService.selectByMoreIDAndPriPID(moreID,priPID));
		}
		return AjaxResult.error("更新失败!");
	}



	/**
	 * 保存和更新操作
	 * @author: wangjin
	 * @param yrForGuaranteeInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
	public AjaxResult save( YrForGuaranteeInfo yrForGuaranteeInfo) throws Exception {
		if(StringUtil.checkYearAndPripid(yrForGuaranteeInfo.getYear(),yrForGuaranteeInfo.getPriPID())) {

			yrForGuaranteeInfo.setMore(StringUtil.doHtm(yrForGuaranteeInfo.getMore())); //设置转义字符
			yrForGuaranteeInfo.setMortgagor(StringUtil.doHtm(yrForGuaranteeInfo.getMortgagor())); //设置转义字符

			if (StringUtils.isNotEmpty(yrForGuaranteeInfo.getMoreID())) {
				if (yrForGuaranteeInfoService.update(yrForGuaranteeInfo) > 0) {
					return AjaxResult.success("更新成功!");
				} else {
					return AjaxResult.error("更新失败!");
				}
			}

			if (yrForGuaranteeInfoService.insert(yrForGuaranteeInfo) > 0) {
				return AjaxResult.success("新增成功!");
			} else {
				return AjaxResult.error("新增失败!");
			}
		}
		return AjaxResult.error("参数为空,执行失败!");
	}

	/**
	 * 删除 操作
	 * @author: wangjin
	 * @param moreID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/batch_delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult batch_delete(String moreID,String year,HttpSession session) throws Exception {

		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String priPID = midBaseInfoDto.getPriPID(); //获取主体身份代码
		if(StringUtil.isNotEmpty(priPID)){
			String  moreIDs[]=moreID.split(",");
			List<String> list_moreID= Arrays.asList(moreIDs);
			if(StringUtil.isNotEmpty(moreID)){
				synchronized (this){
					if(yrForGuaranteeInfoService.batch_delete(list_moreID,priPID)>0){
						List<YrForGuaranteeInfo> list = yrForGuaranteeInfoService.selectByYearAndPripidList(Integer.valueOf(year),priPID);
						if((list.size()==0)){ //判断当前年份是否存在数据
							session.setAttribute("yrForGuaranteeInfo_flag", year);
						}
						return AjaxResult.success("删除成功!");
					}
				}
			}
		}
		return AjaxResult.error("删除失败!");
	}

	/**
	 * 根据年份和身份主体代码更新表单状态
	 * @autor:wangjin
	 * @param year
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateForm", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult updateForm(String year,String priPID) throws Exception {
		if(StringUtil.checkYearAndPripid(year,priPID)){
			YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID,Integer.valueOf(year));
			if(yrForm!=null){
				yrForm.setForguaranteeinfo("1");//表单状态已填报
				if(yrFormService.updateForm(yrForm)>0){
					return AjaxResult.success("保存完成!");
				}
			}
		}
		return AjaxResult.error("保存失败!");
	}
	
	/** 
	 * 描述: 根据自然人身份证号获取 个人对外提供担保信
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	
	@RequestMapping({"/doGetYrForGuaranteeInfoListByCerNO"})
	@ResponseBody
	public PageResponse<YrForGuaranteeInfo> doGetYrForGuaranteeInfoListByCerNO(PageRequest request) throws Exception {
		List<YrForGuaranteeInfo> data = yrForGuaranteeInfoService.selectListByCerNO(request);
		return new PageResponse<YrForGuaranteeInfo>(data);
	}


	/**
	 *  文件下载
	 * @throws Exception
	 */
	@RequestMapping("/file_down")
	public ResponseEntity<byte[]> file_down(HttpServletRequest request, String file_name)throws Exception{

		/************************************GBK的写法 start *****************************************/

		//TODO 获取WEB-INF 下面文件夹的文件路径：
		String path = request.getSession().getServletContext()
				.getRealPath("WEB-INF/views/page/reg/client/yr/forguarantee")+File.separator+"yearcheck_guarantee.xls";

		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("导入模板.xls".getBytes("GBK"),"iso-8859-1");//为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);

		/************************************GBK的写法 end *******************************************/

	}


	/**
	 * 获取Excel数据并导入至数据库表中
	 * @param file
	 * @throws Exception
	 *
	 */
	@RequestMapping("/importExcel")
	public void  importExcel(@RequestParam("file") MultipartFile file,String year,String priPID,String anCheID,HttpServletResponse response)throws Exception {
		JSONObject json = new JSONObject();
		if(StringUtil.checkYearAndPripid(year,priPID)){
			AjaxResult  result = yrForGuaranteeInfoService.importYrForGuaranteeInfoByExcel( file, year, priPID,anCheID);
			if(result.getStatus()=="success"){
				json.put("status","success");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(json);
			}else if(result.getStatus()=="fail"){
				json.put("status","fail");
				json.put("msg",result.getMsg());
				//通知浏览器服务器发送的数据格式
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(json);
			}
		}else{
			json.put("status","fail");
			json.put("msg","参数为空,执行失败");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(json);
		}


	}



	//TODO 下面暂未用到---------------------------------------------------------------------------------------------------------------------------

	/**
	 * @throws IOException 
	 * 
	 * 描述 下载导入模板
	 * @author 赵祥江
	 * @date 2016年9月20日 下午4:40:33 
	 * @param 
	 * @return String
	 * @throws
	 */
/*	@RequestMapping("/download")
	public String download( HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String fileName="yearcheck_guarantee.xls";
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		OutputStream os=null;
		InputStream inputStream =null;
		try {
			@SuppressWarnings("deprecation")
			String path = request.getRealPath("/")+File.separator+"WEB-INF"+File.separator+"views"
			+File.separator+"page"+File.separator+"reg"+File.separator+"client"+File.separator+"yr"
			+File.separator+"forguarantee";
			inputStream = new FileInputStream(new File(path
					+ File.separator + fileName));

			 os = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			os.close(); 
			inputStream.close();
		}     
		return null;
	}*/
}
	
