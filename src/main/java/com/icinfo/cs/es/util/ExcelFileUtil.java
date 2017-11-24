package com.icinfo.cs.es.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.cs.sccheck.model.PubScdeptTask;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubScdeptTaskService;

@Component
public class ExcelFileUtil {
	
	@Autowired
	IMidBaseInfoService midBaseInfoService;
	
	@Autowired
	IPubScPlanTaskService pubScPlanTaskService;
	@Autowired
	IPubScdeptTaskService pubScdeptTaskService;

	public HSSFWorkbook write(List<PanoramaResultDto> list, String year) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("企业信息综合查询");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("序号");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("统一代码/注册号");
		cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("企业名称");
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("成立日期");
		cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("年度");
		cell.setCellStyle(style);
		cell = row.createCell(5);
		cell.setCellValue("年报状态");
		cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("年报方式");
		cell.setCellStyle(style);
		cell = row.createCell(7);
		cell.setCellValue("年报日期");
		cell.setCellStyle(style);
		cell = row.createCell(8);
		cell.setCellValue("最近修改日期");
		cell.setCellStyle(style);
		cell = row.createCell(9);
		cell.setCellValue("当前年报状态");
		cell.setCellStyle(style);
		cell = row.createCell(10);
		cell.setCellValue("法定代表人/负责人");
		cell.setCellStyle(style);
		cell = row.createCell(11);
		cell.setCellValue("负责人电话");
		cell.setCellStyle(style);
		cell = row.createCell(12);
		cell.setCellValue("企业联络员");
		cell.setCellStyle(style);
		cell = row.createCell(13);
		cell.setCellValue("联络员电话");
		cell.setCellStyle(style);
		cell = row.createCell(14);
		cell.setCellValue("注册资本(万元)");
		cell.setCellStyle(style);
		cell = row.createCell(15);
		cell.setCellValue("企业类型");
		cell.setCellStyle(style);
		cell = row.createCell(16);
		cell.setCellValue("行业");
		cell.setCellStyle(style);
		cell = row.createCell(17);
		cell.setCellValue("住所地");
		cell.setCellStyle(style);
		cell = row.createCell(18);
		cell.setCellValue("登记机关");
		cell.setCellStyle(style);
		cell = row.createCell(19);
		cell.setCellValue("管辖单位");
		cell.setCellStyle(style);
		cell = row.createCell(20);
		cell.setCellValue("片区/商圈");
		cell.setCellStyle(style);
		cell = row.createCell(21);
		cell.setCellValue("登记状态");
		cell.setCellStyle(style);
		cell = row.createCell(22);
		cell.setCellValue("是否列入经营异常");
		cell.setCellStyle(style);
		cell = row.createCell(23);
		cell.setCellValue("是否列入严重违法失信");
		cell.setCellStyle(style);
		cell = row.createCell(23);
		cell.setCellValue("是否正在简易注销公告");
		cell.setCellStyle(style);

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		for (int i = 0; i < list.size(); i++) {
			if (i == 20000) {
				break;
			}
			row = sheet.createRow(i + 1);
			PanoramaResultDto panoramaResultDto = (PanoramaResultDto) list.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(i + 1);
			String uniscid = panoramaResultDto.getUniscid();
			if (!StringUtil.isEmpty(uniscid)) {
				row.createCell(1).setCellValue(uniscid);
			} else {
				row.createCell(1).setCellValue(panoramaResultDto.getRegNO());
			}
			row.createCell(2).setCellValue(panoramaResultDto.getEntName());
			row.createCell(3).setCellValue(panoramaResultDto.getEstDate());
			row.createCell(4).setCellValue(year);

			String isOpan = panoramaResultDto.getIsOpan();//经营异常
			String isSerVio = panoramaResultDto.getIsSerVio();//严重违法
			String isSim = panoramaResultDto.getIsSim();//简易注销

			if ("2022".equals(year)) {
				String yrIsRepCN = transYrIsRepCN(panoramaResultDto.getYrIsRep2022());
				row.createCell(5).setCellValue(yrIsRepCN);
				String yrRepModeCN = transYrRepModeCN(panoramaResultDto.getYrRepMode2022());
				row.createCell(6).setCellValue(yrRepModeCN);
				row.createCell(7).setCellValue(panoramaResultDto.getYrFirRepTime2022());
				row.createCell(8).setCellValue(panoramaResultDto.getYrRecRepTime2022());
				String yrRepStateCN = transYrRepStateCN(panoramaResultDto.getYrRepState2022());
				row.createCell(9).setCellValue(yrRepStateCN);

			} else if ("2021".equals(year)) {
				String yrIsRepCN = transYrIsRepCN(panoramaResultDto.getYrIsRep2021());
				row.createCell(5).setCellValue(yrIsRepCN);
				String yrRepModeCN = transYrRepModeCN(panoramaResultDto.getYrRepMode2021());
				row.createCell(6).setCellValue(yrRepModeCN);
				row.createCell(7).setCellValue(panoramaResultDto.getYrFirRepTime2021());
				row.createCell(8).setCellValue(panoramaResultDto.getYrRecRepTime2021());
				String yrRepStateCN = transYrRepStateCN(panoramaResultDto.getYrRepState2021());
				row.createCell(9).setCellValue(yrRepStateCN);
			} else if ("2020".equals(year)) {
				String yrIsRepCN = transYrIsRepCN(panoramaResultDto.getYrIsRep2020());
				row.createCell(5).setCellValue(yrIsRepCN);
				String yrRepModeCN = transYrRepModeCN(panoramaResultDto.getYrRepMode2020());
				row.createCell(6).setCellValue(yrRepModeCN);
				row.createCell(7).setCellValue(panoramaResultDto.getYrFirRepTime2020());
				row.createCell(8).setCellValue(panoramaResultDto.getYrRecRepTime2020());
				String yrRepStateCN = transYrRepStateCN(panoramaResultDto.getYrRepState2020());
				row.createCell(9).setCellValue(yrRepStateCN);
			} else if ("2019".equals(year)) {
				String yrIsRepCN = transYrIsRepCN(panoramaResultDto.getYrIsRep2019());
				row.createCell(5).setCellValue(yrIsRepCN);
				String yrRepModeCN = transYrRepModeCN(panoramaResultDto.getYrRepMode2019());
				row.createCell(6).setCellValue(yrRepModeCN);
				row.createCell(7).setCellValue(panoramaResultDto.getYrFirRepTime2019());
				row.createCell(8).setCellValue(panoramaResultDto.getYrRecRepTime2019());
				String yrRepStateCN = transYrRepStateCN(panoramaResultDto.getYrRepState2019());
				row.createCell(9).setCellValue(yrRepStateCN);
			} else if ("2018".equals(year)) {
				String yrIsRepCN = transYrIsRepCN(panoramaResultDto.getYrIsRep2018());
				row.createCell(5).setCellValue(yrIsRepCN);
				String yrRepModeCN = transYrRepModeCN(panoramaResultDto.getYrRepMode2018());
				row.createCell(6).setCellValue(yrRepModeCN);
				row.createCell(7).setCellValue(panoramaResultDto.getYrFirRepTime2018());
				row.createCell(8).setCellValue(panoramaResultDto.getYrRecRepTime2018());
				String yrRepStateCN = transYrRepStateCN(panoramaResultDto.getYrRepState2018());
				row.createCell(9).setCellValue(yrRepStateCN);
			} else if ("2017".equals(year)) {
				String yrIsRepCN = transYrIsRepCN(panoramaResultDto.getYrIsRep2017());
				row.createCell(5).setCellValue(yrIsRepCN);
				String yrRepModeCN = transYrRepModeCN(panoramaResultDto.getYrRepMode2017());
				row.createCell(6).setCellValue(yrRepModeCN);
				row.createCell(7).setCellValue(panoramaResultDto.getYrFirRepTime2017());
				row.createCell(8).setCellValue(panoramaResultDto.getYrRecRepTime2017());
				String yrRepStateCN = transYrRepStateCN(panoramaResultDto.getYrRepState2017());
				row.createCell(9).setCellValue(yrRepStateCN);
			} else if ("2016".equals(year)) {
				String yrIsRepCN = transYrIsRepCN(panoramaResultDto.getYrIsRep2016());
				row.createCell(5).setCellValue(yrIsRepCN);
				String yrRepModeCN = transYrRepModeCN(panoramaResultDto.getYrRepMode2016());
				row.createCell(6).setCellValue(yrRepModeCN);
				row.createCell(7).setCellValue(panoramaResultDto.getYrFirRepTime2016());
				row.createCell(8).setCellValue(panoramaResultDto.getYrRecRepTime2016());
				String yrRepStateCN = transYrRepStateCN(panoramaResultDto.getYrRepState2016());
				row.createCell(9).setCellValue(yrRepStateCN);
			} else if ("2015".equals(year)) {
				String yrIsRepCN = transYrIsRepCN(panoramaResultDto.getYrIsRep2015());
				row.createCell(5).setCellValue(yrIsRepCN);
				String yrRepModeCN = transYrRepModeCN(panoramaResultDto.getYrRepMode2015());
				row.createCell(6).setCellValue(yrRepModeCN);
				row.createCell(7).setCellValue(panoramaResultDto.getYrFirRepTime2015());
				row.createCell(8).setCellValue(panoramaResultDto.getYrRecRepTime2015());
				String yrRepStateCN = transYrRepStateCN(panoramaResultDto.getYrRepState2015());
				row.createCell(9).setCellValue(yrRepStateCN);
			} else if ("2014".equals(year)) {
				String yrIsRepCN = transYrIsRepCN(panoramaResultDto.getYrIsRep2014());
				row.createCell(5).setCellValue(yrIsRepCN);
				String yrRepModeCN = transYrRepModeCN(panoramaResultDto.getYrRepMode2014());
				row.createCell(6).setCellValue(yrRepModeCN);
				row.createCell(7).setCellValue(panoramaResultDto.getYrFirRepTime2014());
				row.createCell(8).setCellValue(panoramaResultDto.getYrRecRepTime2014());
				String yrRepStateCN = transYrRepStateCN(panoramaResultDto.getYrRepState2014());
				row.createCell(9).setCellValue(yrRepStateCN);
			} else if ("2013".equals(year)) {
				String yrIsRepCN = transYrIsRepCN(panoramaResultDto.getYrIsRep2013());
				row.createCell(5).setCellValue(yrIsRepCN);
				String yrRepModeCN = transYrRepModeCN(panoramaResultDto.getYrRepMode2013());
				row.createCell(6).setCellValue(yrRepModeCN);
				row.createCell(7).setCellValue(panoramaResultDto.getYrFirRepTime2013());
				row.createCell(8).setCellValue(panoramaResultDto.getYrRecRepTime2013());
				String yrRepStateCN = transYrRepStateCN(panoramaResultDto.getYrRepState2013());
				row.createCell(9).setCellValue(yrRepStateCN);
			}
			row.createCell(10).setCellValue(panoramaResultDto.getLeRep());
			row.createCell(11).setCellValue(panoramaResultDto.getTel());
			row.createCell(12).setCellValue(panoramaResultDto.getLiaName());
			row.createCell(13).setCellValue(panoramaResultDto.getLiaTel());
			row.createCell(14).setCellValue(panoramaResultDto.getRegCap());
			row.createCell(15).setCellValue(panoramaResultDto.getEntTypeName());
			row.createCell(16).setCellValue(panoramaResultDto.getIndustryCoName());
			row.createCell(17).setCellValue(panoramaResultDto.getDom());
			row.createCell(18).setCellValue(panoramaResultDto.getRegOrgName());
			row.createCell(19).setCellValue(panoramaResultDto.getLocalAdmName());
			row.createCell(20).setCellValue(panoramaResultDto.getSliceNOName());
			String regState = transRegStateCN(panoramaResultDto.getRegState());
			row.createCell(21).setCellValue(regState);
			if ("Y".equals(isOpan)) {
				row.createCell(22).setCellValue("是");
			}else if("N".equals(isOpan)){
				row.createCell(22).setCellValue("否");
			}else{
				row.createCell(22).setCellValue("-");
			}
			if ("Y".equals(isSerVio)) {
				row.createCell(23).setCellValue("是");
			}else if("N".equals(isSerVio)){
				row.createCell(23).setCellValue("否");
			}else{
				row.createCell(23).setCellValue("-");
			}
			if ("Y".equals(isSim)) {
				row.createCell(24).setCellValue("是");
			}else if("N".equals(isSim)){
				row.createCell(24).setCellValue("否");
			}else{
				row.createCell(24).setCellValue("-");
			}
		}
		return wb;

	}

	/**
	 * 年报方式编码转换中文
	 * 
	 * @param yrRepMode
	 * @return
	 */
	private String transYrRepModeCN(String yrRepMode) {
		String yrRepModeCN;
		if ("5".equals(yrRepMode)) {
			yrRepModeCN = "数字证书";
		} else if ("2".equals(yrRepMode)) {
			yrRepModeCN = "联络员";
		} else if ("6".equals(yrRepMode)) {
			yrRepModeCN = "纸质报告";
		} else if ("4".equals(yrRepMode)) {
			yrRepModeCN = "手机APP";
		} else {
			yrRepModeCN = "-";
		}
		return yrRepModeCN;
	}

	/**
	 * 年报状态编码转换中文
	 * 
	 * @param yrIsRep
	 * @return
	 */
	private String transYrIsRepCN(String yrIsRep) {
		String yrIsRepCN;
		if ("0".equals(yrIsRep)) {
			yrIsRepCN = "未年报";
		} else if ("1".equals(yrIsRep)) {
			yrIsRepCN = "已年报";
		} else if ("2".equals(yrIsRep)) {
			yrIsRepCN = "已年报(逾期)";
		} else {
			yrIsRepCN = "-";
		}
		return yrIsRepCN;
	}

	/**
	 * 年报状态编码转换中文
	 * 
	 * @param yrRepState
	 * @return
	 */
	private String transYrRepStateCN(String yrRepState) {
		String yrRepStateCN;
		if ("00".equals(yrRepState)) {
			yrRepStateCN = "未公示";
		} else if ("10".equals(yrRepState)) {
			yrRepStateCN = "已公示";
		} else if ("12".equals(yrRepState)) {
			yrRepStateCN = "已公示(敏感词待审核)";
		} else if ("11".equals(yrRepState)) {
			yrRepStateCN = "已公示(敏感词通过)";
		} else if ("13".equals(yrRepState)) {
			yrRepStateCN = "已公示(敏感词不通过)";
		} else if ("20".equals(yrRepState)) {
			yrRepStateCN = "待修改";
		} else {
			yrRepStateCN = "-";
		}
		return yrRepStateCN;
	}

	/**
	 * 登记状态编码转换中文
	 * 
	 * @param regState
	 * @return
	 */
	private String transRegStateCN(String regState) {
		String regStateCN;
		if ("K".equals(regState) || "B".equals(regState) || "A".equals(regState) || "DA".equals(regState)
				|| "X".equals(regState)) {
			regStateCN = "存续";
		} else if ("XX".equals(regState) || "DX".equals(regState)) {
			regStateCN = "注销";
		} else if ("C".equals(regState)) {
			regStateCN = "撤销";
		} else if ("D".equals(regState)) {
			regStateCN = "吊销";
		} else if ("Q".equals(regState)) {
			regStateCN = "迁出";
		} else {
			regStateCN = "-";
		}
		return regStateCN;
	}
	
	

	/**
	 * 
	 * 描述: 异常名录批列入导出excel
	 * @auther gaojinling
	 * @date 2017年7月3日 
	 * @param list
	 * @param year
	 * @return
	 */
	public HSSFWorkbook batchOpanomalyWrite(List<MidBaseInfoDto> list) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("可批量列入异常列表");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("序号");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("年度");
		cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("统一代码/注册号");
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("企业名称");
		cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("类型");
		cell.setCellStyle(style);
		cell = row.createCell(5);
		cell.setCellValue("成立日期");
		cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("个转企");
		cell.setCellStyle(style);
		cell = row.createCell(7);
		cell.setCellValue("个转企日期");
		cell.setCellStyle(style);
		cell = row.createCell(8);
		cell.setCellValue("登记机关");
		cell.setCellStyle(style);
		cell = row.createCell(9);
		cell.setCellValue("管辖单位");
		cell.setCellStyle(style);

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		for (int i = 0; i < list.size(); i++) {
			if (i == 20000) {
				break;
			}
			row = sheet.createRow(i + 1);
			MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) list.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(i + 1);
			String uniscid = midBaseInfoDto.getUniCode();
			if (!StringUtil.isEmpty(uniscid)) {
				row.createCell(2).setCellValue(uniscid);
			} else {
				row.createCell(2).setCellValue(midBaseInfoDto.getRegNO());
			}
			row.createCell(1).setCellValue(midBaseInfoDto.getYear());
			row.createCell(3).setCellValue(midBaseInfoDto.getEntName());
			row.createCell(4).setCellValue(getBatchEntType(midBaseInfoDto.getBatchEntType()));
			row.createCell(5).setCellValue(DateUtil.dateToString(midBaseInfoDto.getEstDate(), "YYYY-MM-dd"));
			if(StringUtil.isNotBlank(midBaseInfoDto.getIsIndivid())){
				row.createCell(6).setCellValue("1".equals(midBaseInfoDto.getIsIndivid()) ? "是" : "否");
			}else{
				row.createCell(6).setCellValue("否");
			}
			row.createCell(7).setCellValue(DateUtil.dateToString(midBaseInfoDto.getIndividDate(), "YYYY-MM-dd"));
			row.createCell(8).setCellValue(midBaseInfoDto.getRegOrgName());
			row.createCell(9).setCellValue(midBaseInfoDto.getLocalAdmName());
		}
		return wb;

	}
	
	
	public  String getBatchEntType(String batchEntType){
		if(StringUtil.isBlank(batchEntType)){
			return "";
		}
		if("2".equals(batchEntType)){
			return "农专社";
		}else if("3".equals(batchEntType)){
			return "外资企业";
		}else if("1".equals(batchEntType)){
			return "内资企业";
		}
		return batchEntType; 
	}

	/**
	 * 导出excel专项检查表
	 * 
	 * @author yujingwei
	 * @throws Exception 
	 */
	public void ExportScCheck(HttpServletResponse response, String priPID,
			String taskUid, String checkCode, File file) throws Exception {
		
		MidBaseInfo baseInfo = midBaseInfoService.selectInfoByPriPID(priPID);
		PubScdeptTask pubScdeptTask = pubScdeptTaskService.selectPubScdeptTaskByUid(taskUid);
		String taskName = null;
		if (pubScdeptTask != null){
			PubScPlanTask planTask = pubScPlanTaskService.selectPubScPlanTaskByUid(pubScdeptTask.getTaskUid());
			taskName = planTask.getTaskName();
		}
		InputStream is = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(is);
        HSSFSheet sheet = workbook.getSheetAt(0);
        if (sheet != null){
        	try {
        		 // 写入数据
                FileOutputStream fos = new FileOutputStream(file);
                
                HSSFRow row = sheet.getRow(1);
                HSSFCell cell1 = row.getCell(3);
                HSSFCell cell2 = row.getCell(0);
                cell1.setCellValue("企业名称："+baseInfo.getEntName());
                cell2.setCellValue("任务名称："+taskName);
                
                HSSFRow row2 = sheet.getRow(2);
                HSSFCell cell3 = row2.getCell(0);
                cell3.setCellValue("企业住所："+baseInfo.getDom());
                
                // 保健食品检查模板分页情况
                if (checkCode.equalsIgnoreCase("B02")) {
                	HSSFRow row14 = sheet.getRow(14);
                	HSSFCell cell4 = row14.getCell(3);
                    HSSFCell cell5 = row14.getCell(0);
                    cell4.setCellValue("企业名称："+baseInfo.getEntName());
                    cell5.setCellValue("任务名称："+taskName);
                    
                    HSSFRow row15 = sheet.getRow(15);
                    HSSFCell cell6 = row15.getCell(0);
                    cell6.setCellValue("企业住所："+baseInfo.getDom());
                }
                
                workbook.write(fos);
                fos.flush();
                fos.close();
                // 下载
                InputStream fis = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                response.reset();
                response.setContentType("text/html;charset=UTF-8");
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/x-msdownload");
                String newName = URLEncoder.encode(returnExcelName(checkCode)+".xls", "UTF-8");
                response.addHeader("Content-Disposition", "attachment;filename=\""+ newName + "\"");
                response.addHeader("Content-Length", "" + file.length());
                toClient.write(buffer);
                toClient.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
                    if (null != is) {
                        is.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
			}
        }
	}
	
	/**
	 * 导出excel专项检查表
	 * 
	 * @author yujingwei
	 * @throws Exception 
	 */
	public void downLoadSccheck(HttpServletResponse response,String checkCode, File file) throws Exception {
		
		InputStream is = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(is);
        HSSFSheet sheet = workbook.getSheetAt(0);
        if (sheet != null){
        	try {
        		 // 写入数据
                FileOutputStream fos = new FileOutputStream(file);
                
                HSSFRow row = sheet.getRow(1);
                HSSFCell cell1 = row.getCell(3);
                HSSFCell cell2 = row.getCell(0);
                cell1.setCellValue("企业名称：");
                cell2.setCellValue("任务名称：");
                
                HSSFRow row2 = sheet.getRow(2);
                HSSFCell cell3 = row2.getCell(0);
                cell3.setCellValue("企业住所：");
                
                // 保健食品检查模板分页情况
                if (checkCode.equalsIgnoreCase("B02")) {
                	HSSFRow row14 = sheet.getRow(14);
                	HSSFCell cell4 = row14.getCell(3);
                    HSSFCell cell5 = row14.getCell(0);
                    cell4.setCellValue("企业名称：");
                    cell5.setCellValue("任务名称：");
                    
                    HSSFRow row15 = sheet.getRow(15);
                    HSSFCell cell6 = row15.getCell(0);
                    cell6.setCellValue("企业住所：");
                }
                
                workbook.write(fos);
                fos.flush();
                fos.close();
                // 下载
                InputStream fis = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                response.reset();
                response.setContentType("text/html;charset=UTF-8");
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/x-msdownload");
                String newName = URLEncoder.encode(returnExcelName(checkCode)+".xls", "UTF-8");
                response.addHeader("Content-Disposition", "attachment;filename=\""+ newName + "\"");
                response.addHeader("Content-Length", "" + file.length());
                toClient.write(buffer);
                toClient.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
                    if (null != is) {
                        is.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
			}
        }
	}
	
	/**
	 * 获取下载excel名称
	 * 
	 * @date 2017-10-10
	 */
	public String returnExcelName(String checkCode){
		if(checkCode.equals("A01")){return "直销违法行为双随机抽查记录表";}
		if(checkCode.equals("A02")){return "流通领域商品质量双随机抽查记录表";}
		if(checkCode.equals("A03")){return "侵害消费者权益行为双随机抽查记录表";}
		if(checkCode.equals("A04")){return "拍卖活动经营资格双随机抽查记录表";} //#
		if(checkCode.equals("A05")){return "为非法交易野生动物提供交易服务双随机抽查记录表";}
		if(checkCode.equals("A06")){return "未经许可擅自设立文物商店等违法行为的检查";}//#
		if(checkCode.equals("A07")){return "公示信息双随机抽查记录表";}
		if(checkCode.equals("A08")){return "登记事项双随机抽查记录表";}
		if(checkCode.equals("A09")){return "年度报告双随机抽查记录表";}//#
		if(checkCode.equals("A10")){return "广告违法行为双随机抽查记录表";}
		if(checkCode.equals("A11")){return "商标违法行为双随机抽查记录表";}
		if(checkCode.equals("A12")){return "特殊标志违法行为务双随机抽查记录表";}
		if(checkCode.equals("B01")){return "获证食品生产企业双随机抽查记录表";}
		if(checkCode.equals("B02")){return "保健食品生产企业双随机抽查记录表";}
		if(checkCode.equals("B03")){return "食品销售单位证后监管双随机抽查记录表";}
		if(checkCode.equals("B04")){return "化妆品生产企业双随机抽查记录表";}
		if(checkCode.equals("B05")){return "对药品经营企业药品GSP实施情况进行飞行检查";}//#
		if(checkCode.equals("B06")){return "医疗机构药品使用质量双随机抽查记录表";}
		if(checkCode.equals("B07")){return "第一类医疗器械经营企业双随机抽查记录表";}
		if(checkCode.equals("B08")){return "第二类医疗器械零售经营企业双随机抽查记录表";}//#
		if(checkCode.equals("B09")){return "第一类医疗器械生产企业双随机抽查记录表";}
		if(checkCode.equals("B10")){return "县级以下医疗机构医疗器械使用质量双随机抽查记录表";}
		if(checkCode.equals("C01")){return "制造计量器具生产企业双随机抽查记录表";}
		if(checkCode.equals("C02")){return "用能生产单位产品效能标识使用情况双随机抽查记录表";}//#
		if(checkCode.equals("C03")){return "定量包装商品量生产、销售单位双随机抽查记录表";}
		if(checkCode.equals("C04")){return "重点用能单位计量器具使用双随机抽查记录表";}
		if(checkCode.equals("C05")){return "计量标准、技术机构监管";}// #
		if(checkCode.equals("C06")){return "检验检测机构资质认定双随机抽查记录表";}
		if(checkCode.equals("C07")){return "自愿性认证活动双随机抽查记录表";}
		if(checkCode.equals("C08")){return "特种设备生产单位双随机抽查记录表";}
		if(checkCode.equals("C09")){return "特种设备检验检测单位双随机抽查记录表";}//#
		if(checkCode.equals("C10")){return "特种设备销售单位双随机抽查记录表";}//#
		if(checkCode.equals("C11")){return "特种设备使用（出租）单位双随机抽查记录表";}//#
		if(checkCode.equals("C12")){return "重要工业产品生产许可证企业双随机抽查记录表";}
		if(checkCode.equals("C13")){return "产品质量监督抽查双随机抽查记录表";}
		if(checkCode.equals("C14")){return "开展质监领域执法专项行动，对重点单位、重点产品进行执法检查";}//#
		return checkCode;
	}
}
