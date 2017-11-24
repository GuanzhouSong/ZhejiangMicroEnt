package com.icinfo.cs.depsyn.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStates;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.ExcelUtil;
import com.icinfo.cs.dtinfo.dto.PubDtInfoDto;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.inforece.sercive.IPubDtInfoForReceService;
import com.icinfo.cs.inforece.sercive.ISecNoCreditService;
import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishInfoDto;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishInfoService;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.secnocreditsup.dto.SecNoCreditSearchDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:  新公示首页对应的controller.<br>
 *
 * @author framework generator
 * @date 2016年12月10日
 */
@Controller
@RequestMapping("/depsyn")
public class DepSynController extends BaseController {
	
	@Autowired
	private ISecNoCreditService secNoCreditService;
	
	@Autowired
	private IPubDtInfoForReceService pubDtInfoForReceService;
	
	@Autowired
	private NoCreditPunishInfoService noCreditPunishInfoService;
	
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	
	/** 
	 * 进入批量比对
	 * @author ylr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnBatchCompare",method= RequestMethod.GET)
	public ModelAndView doEnBatchCompare(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/depsyn/comparefir");
		return mv;
	}
	/** 
	 * 进入批量比对
	 * @author ylr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnCompareUpload",method= RequestMethod.GET)
	public ModelAndView doEnCompareUpload(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/depsyn/compare_upload");
		return mv;
	}
	
	/** 
	 * 进入严违失信名单
	 * @author zjj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/nocreditview",method= RequestMethod.GET)
	public ModelAndView noCreditView(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/depsyn/yzwf_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mv.addObject("adcode",sysUser.getSysDepart().getAdcode());
		return mv;
	}
	
	/**
	 * 获取严违失信名单数据
	 * @author zjj
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/nocreditlist.json", "list.xml" })
	@ResponseBody
	public PageResponse<SecNoCreditSearchDto> noCreditList(PageRequest request) throws Exception{
		List<SecNoCreditSearchDto> List = secNoCreditService.queryPage(request);
		return new PageResponse<SecNoCreditSearchDto>(List);
	}
	
    /**
     * 查询已下载数据
     * 
     */
	@RequestMapping(value="/secdownlist",method=RequestMethod.POST)
	@ResponseBody
	public List<SecNoCreditSearchDto> downList(@RequestBody SecNoCreditSearchDto secNoCreditSearchDto,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		secNoCreditSearchDto.setAdcode(sysUser.getSysDepart().getAdcode());
		List<SecNoCreditSearchDto> list = secNoCreditService.getDownList(secNoCreditSearchDto);
		return list;
	}
	
	
	/** 
	 * 进入信息接收双告知页面
	 * @author zjj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/pubdtinfo",method= RequestMethod.GET)
	public ModelAndView pubDtInfo(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/depsyn/sgz_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mv.addObject("adcode",sysUser.getSysDepart().getAdcode());
		return mv;
	}
	
	/**
     * 进入照面信息页面
     *
     * @return
     * @throws Exception
     * @author liuhq
     */
    @RequestMapping(value = "/toedit", method = RequestMethod.GET)
    public ModelAndView toedit(String pripid, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("/depsyn/pubdtinfo/pubdtinfo_details");
        if (StringUtil.isEmpty(pripid) || "null".equals(pripid)) return mv;
        MidBaseInfoDto midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(pripid);
        if(midBaseInfo!=null)
        midBaseInfo.setRegState(RegStates.getValue(midBaseInfo.getRegState()).getName());
        mv.addObject("midBaseInfo", midBaseInfo);
        return mv;
    }
	
	/**
	 * 获取双告知数据
	 * @author zjj
	 */
	@RequestMapping({ "/pubdtinfolist.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubDtInfoDto> pubdtinfoList(PageRequest request,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		List<PubDtInfoDto> data = pubDtInfoForReceService.queryPage(request,sysUser);
		return new PageResponse<PubDtInfoDto>(data);
	}
	
    /**
     * 查询已下载数据
     * 
     */
	@RequestMapping(value="/pubdownlist",method=RequestMethod.POST)
	@ResponseBody
	public List<PubDtInfoDto> downList(@RequestBody PubDtInfoDto PubDtInfo,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		PubDtInfo.setAdcode(sysUser.getSysDepart().getAdcode());
		List<PubDtInfoDto> list = pubDtInfoForReceService.getDownList(PubDtInfo);
		return list;
	}
	
	 /**
     * 进入异常名录页面
     *
     * @return
     * @throws Exception
     * @author liuhq
     */
    @RequestMapping(value = "/toabonList", method = RequestMethod.GET)
    public ModelAndView toabonList(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("/depsyn/jyyc_list");
        return mv;
    }
    
    /**
	 * 查询企业农专的异常经营名录----协同系统---数据接入使用。add by liuhq
	 * @param request
	 * @return
	 * @throws Exception
	 * @date 2016.11.30
	 */
	@RequestMapping({"/getEntForDatajoinJSON.json","getEntForDatajoinJSON.xml"})
	@ResponseBody
	public PageResponse<PubOpanoMalyDto> getEntForDatajoinJSON(PageRequest request,HttpSession session)throws Exception{
		Map<String,Object> queryMap= new HashedMap();
		//企业农专
		//applyFalg标识 1 表示查询已经审核通过的
		queryMap.put("applyFalg", "1");
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		queryMap.put("adCode",sysUserDto.getSysDepart().getAdcode());
		if(request.getParams()==null)
		request.setParams(queryMap);
		else request.getParams().putAll(queryMap);
		List<PubOpanoMalyDto> pubOpanoMalyDtoList= pubOpanoMalyService.selectPubOpanoMalyList_Fordatain(request);
		return new PageResponse<PubOpanoMalyDto>(pubOpanoMalyDtoList);
	}
	
	 /**
		 * 查询企业农专的异常经营名录----协同系统---数据接入使用。add by liuhq
		 * @param request
		 * @return
		 * @throws Exception
		 * @date 2016.11.30
	 */
	@RequestMapping({"/getEntForDatajoinJSON_downednum"})
	@ResponseBody
	public AjaxResult getEntForDatajoinJSON_downednum(String uniCode_regNO,String entName,HttpSession session)throws Exception{
		Map<String,Object> queryMap= new HashedMap();
		//企业农专
		//applyFalg标识 1 表示查询已经审核通过的
		queryMap.put("applyFalg", "1");
		queryMap.put("uniCode_regNO", uniCode_regNO);
		queryMap.put("entName", entName);
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		queryMap.put("adCode",sysUserDto.getSysDepart().getAdcode());
		String downed = pubOpanoMalyService.getEntForDatajoinJSON_downednum(queryMap);
		return AjaxResult.success("downed",downed );

	}
	
    /**
     * 进入联合惩戒页面
     *
     * @return
     * @throws Exception
     * @author liuhq
     */
    @RequestMapping(value = "/topunishList", method = RequestMethod.GET)
    public ModelAndView topunishList(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("/depsyn/lhcj_list");
        return mv;
    }

    /**
	 * 查询惩戒全信息列表
	 * @param request
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/searchlist.json", "searchlist.xml" })
	@ResponseBody
	public PageResponse<NoCreditPunishInfoDto> searchlistJSON(PageRequest request, String type, HttpSession session) throws Exception {
		Map<String, Object> parms = request.getParams();
		if (parms == null) {
			parms = new HashMap<String, Object>();
		}
		if (type != null) {
			parms.put("type", type);
		}
		parms.put("exeEnd", new Date());
		// --------------------加个adcode add by liuhq
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if (sysUserDto.getSysDepart() != null) {
			parms.put("adCode", sysUserDto.getSysDepart().getAdcode());
		}
		// --------------------加个adcode 完 add by liuhq
		List<NoCreditPunishInfoDto> dtos = this.noCreditPunishInfoService.selectAllFullInfoList(request, parms);
		return new PageResponse<NoCreditPunishInfoDto>(dtos);
	}
	
	/**
	 *
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/searchlistJSON_downednum"})
	@ResponseBody
	public AjaxResult searchlistJSON_downednum(String uniCode,String entName,HttpSession session)throws Exception{
		Map<String, Object> parms  = new HashMap<String, Object>();

		parms.put("exeEnd", new Date());
		parms.put("uniCode",uniCode);
		parms.put("entName",entName);
		//--------------------加个adcode add by liuhq
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		parms.put("adCode",sysUserDto.getSysDepart().getAdcode());
		//--------------------加个adcode 完 add by liuhq
		String downed = noCreditPunishInfoService.searchlistJSON_downednum(parms);
		return AjaxResult.success("downed",downed );

	}
	
	/**
	 * 描述：公式模板下载
	 * @author ylr
	 * @date 2016-12-13
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loadToExcel",method= RequestMethod.POST)
	@ResponseBody
	public String doDownloadToExcel(@RequestParam(name="cellInfo",required=true) List<List<String>> cellInfo,
			@RequestParam(name="cellTitle",required=true) String[] cellTitle,
			@RequestParam(name="fileName",required=true) String fileName,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		int a = cellInfo.size()/cellTitle.length;
		int b = cellTitle.length;
		int c = 0;
		List<String> list1 ;
		List<List<String>> list2 = new ArrayList<List<String>>();
		for(int i=0;i<a;i++){
			list1 = new ArrayList<>();
			for(int j=0;j<cellTitle.length;j++){
				c = i*b+j;
				list1.add(cellInfo.get(c).toString().replace("[", "").replace("]", ""));
			}
			list2.add(list1);
		}
		ExcelUtil.downLoadGSExcel(response, fileName,list2,cellTitle );
		return null;
	}
	
	/**
	 * 描述：下载模板
	 * @author ylr
	 * @date 2016-12-10
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/comparedownload"})
	@ResponseBody
	public String doDownloadTemplateAction(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String fileName = "信息管理-批量比对-批量比对模板.xlsx";
		String filePath = request.getSession().getServletContext().getRealPath("/compareupload")+File.separator+fileName;//模板文件
		
			ExcelUtil.downLoadFile(filePath, response, fileName, "xls");
		return null;
	}
	
	/**
	 * 描述：数据比对导出
	 * @author ylr
	 * @date 2016-12-12
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/doGetOutCompare"})
	@ResponseBody
	public String doGetOutCompare(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		String fileName = "信息管理-批量比对-批量导出模板";
		String filePath = request.getSession().getServletContext().getRealPath("/compareupload")+File.separator+fileName;//模板文件
		List<MidBaseInfoDto> list = (List<MidBaseInfoDto>) session.getAttribute("compareOutList");
		if(list.isEmpty()) return null;
		String[] keys = {"entName","regNO","uniCode","regState","estDate"};
		String columnNames[] = {"企业名称","注册号","统一社会信用代码","当前是否无效企业","登记日期"};
		//解析sheet
		
//				HSSFWorkbook workbook = ExcelUtil.createWorkBook("批量导出模板", list,keys,columnNames);
				 // 创建excel工作簿
				HSSFWorkbook wb = new HSSFWorkbook();
			    Font f = wb.createFont();
			    f.setFontHeightInPoints((short) 10);
		        f.setColor(IndexedColors.BLACK.getIndex());
		        f.setBoldweight(Font.BOLDWEIGHT_BOLD);
		        CellStyle cs = wb.createCellStyle();
		        cs.setFont(f);
		        cs.setBorderLeft(CellStyle.BORDER_THIN);
		        cs.setBorderRight(CellStyle.BORDER_THIN);
		        cs.setBorderTop(CellStyle.BORDER_THIN);
		        cs.setBorderBottom(CellStyle.BORDER_THIN);
		        cs.setAlignment(CellStyle.ALIGN_CENTER);
			    // 创建第一个sheet（页），并命名
			    HSSFSheet sheet = (HSSFSheet) wb.createSheet("批量导出模板");
			    // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
			    for(int i=0;i<keys.length;i++){
			        sheet.setColumnWidth((short) i, (short) (35.7 * 150));
			    }
			    // 创建第一行
			    HSSFRow row_0 = sheet.createRow((short) 0);
			    //设置列名
			    for(int i=0;i<columnNames.length;i++){
			        Cell cell = row_0.createCell(i);
			        cell.setCellValue(columnNames[i]);
			        cell.setCellStyle(cs);
			    }
			    //同理可以设置数据行
			    int j=1;
				for(MidBaseInfoDto dto:list){
					HSSFRow row_j = sheet.createRow(j);
					HSSFCell cell_j_0 = row_j.createCell(0);//企业名称
					cell_j_0.setCellValue(dto.getEntName());
					HSSFCell cell_j_1 = row_j.createCell(1);//注册号
					cell_j_1.setCellValue(dto.getRegNO());
					HSSFCell cell_j_2 = row_j.createCell(2);//统一社会信用代码
					cell_j_2.setCellValue(dto.getUniCode());
					HSSFCell cell_j_3 = row_j.createCell(3);//当前是否无效企业
					cell_j_3.setCellValue(dto.getRegState());
					HSSFCell cell_j_4 = row_j.createCell(4);//登记日期
					cell_j_4.setCellValue(DateUtil.dateToString(dto.getEstDate(), "yyyy-MM-dd"));
					j++;
				}
				
				ByteArrayOutputStream os = new ByteArrayOutputStream();
			    try {
			    	wb.write(os);
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			    byte[] content = os.toByteArray();
			    InputStream is = new ByteArrayInputStream(content);
			    // 设置response参数，可以打开下载页面
			    response.reset();
			    response.setContentType("application/vnd.ms-excel;charset=utf-8");
			    response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
			    ServletOutputStream out = response.getOutputStream();
			    BufferedInputStream bis = null;
			    BufferedOutputStream bos = null;
			    try {
			        bis = new BufferedInputStream(is);
			        bos = new BufferedOutputStream(out);
			        byte[] buff = new byte[2048];
			        int bytesRead;
			        // Simple read/write loop.
			        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			            bos.write(buff, 0, bytesRead);
			        }
			    } catch (final IOException e) {
			        throw e;
			    } finally {
			        if (bis != null)
			            bis.close();
			        if (bos != null)
			            bos.close();
			    }
		return null;
	}
	
	public String getRegStateCh(String regSate) throws Exception{
		if("A".equals(regSate)||"B".equals(regSate)||"K".equals(regSate)||"DA".equals(regSate))
			return "否";
		if("X".equals(regSate)||"C".equals(regSate)||"D".equals(regSate)||"Q".equals(regSate))
			return "是";
		return null;
	}
	
	/**
	 * 描述：表格模板上传
	 * @author ylr
	 * @date 2015-12-10
	 * @return String 
	 * @throws Exception
	 */
	@RequestMapping(value = "/doCompareUpload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public ModelAndView doCompareUpload(@RequestParam("filename") CommonsMultipartFile file,HttpSession session) throws Exception{
		ModelAndView mv_t = new ModelAndView("/depsyn/comparesec");
		ModelAndView mv_f = new ModelAndView("/depsyn/compare_upload");
		String fileName = file.getOriginalFilename();
		//sheet名称数组
		String[] sheetNamesArr = new String[]{"批量比对"};
		StringBuffer buf = new StringBuffer();
		
		Map<String,Integer> sheetNamesMap = new HashMap<String, Integer>();
		for (int i = 0; i < sheetNamesArr.length; i++) {
			sheetNamesMap.put(sheetNamesArr[i], i);
		}
		
		//解析sheet
		InputStream is = file.getInputStream();
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(is);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	    
	    if(workbook.getNumberOfSheets() != 1){
	    	mv_f.addObject("msg", "此文件非模板文件！Sheet名称或数目不正确！");
	    	return mv_f;
	    };
	    //有效sheet数
	    if(!"批量比对".equals(workbook.getSheetAt(0).getSheetName())){//没有有效sheet
	    	mv_f.addObject("msg", "没有有效sheet，不能上传！");
	    	return mv_f;
	    }
	    
	    boolean uploadFileToLocalFlag = false;//是否需要将所传文件保存
//		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
	    	 Sheet sheet=workbook.getSheetAt(0);
			 String sheetName = sheet.getSheetName();
			 Map<String, Object> msgInfo = new HashMap<String, Object>();
			 try{
						 
						 //没有上传，则上传
						  msgInfo = midBaseInfoService.doDepSynImportCompare(sheet,fileName,session) ;//批量比对上传数据读取
						 
						 //处理返回信息
						 if("1".equals(msgInfo.get("state"))){//上传成功
							 mv_t.addObject("msg", sheetName+"上传成功！");
							 mv_t.addObject("fileName", fileName);
						    return mv_t;
//							 uploadFileToLocalFlag = true;
						 }
						 if("0".equals(msgInfo.get("state"))){//上传失败
						   if("0".equals(msgInfo.get("posRowNum"))){
							   buf.append(sheetName+"上传失败："+msgInfo.get("msgInfo"));
							   mv_f.addObject("msg", buf);
						    	return mv_f;
							 }else {
								 buf.append(sheetName+"上传失败：第"+msgInfo.get("posRowNum")+"行"+msgInfo.get("msgInfo"));
								   mv_f.addObject("msg", buf);
							    	return mv_f;
							 }
						 }
						 
				 
			 }catch(Exception e){
				 e.printStackTrace();
			 }

		//上传文件到本地
//		if(uploadFileToLocalFlag) doUploadFileToLocal(importfileFileName, importfile);
		
			 mv_t.addObject("msg", sheetName+"上传成功！");
			 mv_t.addObject("fileName", fileName);
		    return mv_t;
	}
	
	
	/**
	 * 描述：数据比对分页显示
	 * @author ylr
	 * @date 2015-12-12
	 * @return String 
	 * @throws Exception
	 */
	@RequestMapping(value = "/doBulidPage")
	@ResponseBody
	public Page<MidBaseInfoDto> doBulidPage(PageRequest request,HttpSession session) throws Exception{
		List<MidBaseInfoDto> list = (List<MidBaseInfoDto>) session.getAttribute("compareOutList");
		Page<MidBaseInfoDto> page = new Page<MidBaseInfoDto>(request.getStart(), request.getLength());
		page.setTotal(list.size());
		page.addAll(list);
		return page;
	}
	
	
	/**
	 * 描述：数据比对
	 * @author ylr
	 * @date 2015-12-12
	 * @return String 
	 * @throws Exception
	 */
	@RequestMapping(value = "/doGetCompareList")
	@ResponseBody
	public ModelAndView doGetCompareList(String fileName,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/depsyn/comparesec");
		List<MidBaseInfo> list = (List<MidBaseInfo>) session.getAttribute("compareList");
		int i = 0;
		for(MidBaseInfo info:list){
			MidBaseInfo mid = doBuildMidBaseInfoDto(info);
			if(mid != null){
				info.setRegState(getRegStateCh(mid.getRegState()));
				info.setEstDate(mid.getEstDate());
				if("是".equals(info.getRegState()))
					i++;
			}
		}
		session.setAttribute("compareOutList", list);
		
		mv.addObject("msg", "比对成功！");
		mv.addObject("fileName", fileName);
		mv.addObject("pageflag", "pageflag");
		mv.addObject("num", i);
		return mv;
	}
	
	public MidBaseInfo doBuildMidBaseInfoDto(MidBaseInfo info) throws Exception{
		Map<String, Object> qryMap = new HashMap<>();
		List<MidBaseInfoDto> list = new ArrayList<>();
		
		if(StringUtils.isNotBlank(info.getEntName())){
			qryMap.put("entName", info.getEntName());
			list = midBaseInfoService.selectMidBaseinfoByRegNoAndName(qryMap);
		}
		if(list.isEmpty() && StringUtils.isNotBlank(info.getRegNO())){
			qryMap.clear();
			qryMap.put("regNO", info.getRegNO());
			list = midBaseInfoService.selectMidBaseinfoByRegNoAndName(qryMap);
		}
		if(list.isEmpty() && StringUtils.isNotBlank(info.getUniCode())){
			qryMap.clear();
			qryMap.put("regNO", info.getUniCode());
			list = midBaseInfoService.selectMidBaseinfoByRegNoAndName(qryMap);
		}
		if(list.isEmpty())
			return null;
		return list.get(0);
		
	}
}
