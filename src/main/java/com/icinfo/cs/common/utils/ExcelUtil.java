package com.icinfo.cs.common.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 导出Excel文档工具类
 * [@author](http://my.oschina.net/arthor) 那位先生
 * [@date](http://my.oschina.net/u/2504391) 2014-8-6
 */
public class ExcelUtil {


    /**
     * 创建excel文档，
     * [@param](http://my.oschina.net/u/2303379) list 数据
     *
     * @param sheetName   excel的sheet名称
     * @param keys        list中map的key数组集合
     * @param columnNames excel的列名
     */
    public static Workbook createWorkBook(String sheetName, List list, String[] keys, String columnNames[]) {
        // 创建excel工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建第一个sheet（页），并命名

        HSSFSheet sheet = wb.createSheet(sheetName);
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for (int i = 0; i < keys.length; i++) {
            sheet.setColumnWidth((short) i, (short) (35.7 * 150));
        }



        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // 创建第一种字体样式（用于列名）
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.BLACK.getIndex());
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);

        // 创建第二种字体样式（用于值）
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());

//        Font f3=wb.createFont();
//        f3.setFontHeightInPoints((short) 10);
//        f3.setColor(IndexedColors.RED.getIndex());

        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        cs.setAlignment(CellStyle.ALIGN_CENTER);

        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        cs2.setAlignment(CellStyle.ALIGN_CENTER);
        cs2.setAlignment(CellStyle.ALIGN_LEFT);
        // 创建第一行
        HSSFRow row = sheet.createRow( 0);
        //设置列名
        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }
        //设置每行每列的值
        for (short i = 0; i < list.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
            Row row1 = sheet.createRow((short) i+1);
            // 在row行上创建一个方格
            for (short j = 0; j < keys.length; j++) {
                Cell cell = row1.createCell(j);
                Object o = list.get(i);
                Class c = o.getClass();
                try {
                    Method m = c.getMethod(keys[j]);
                    String val = (String) m.invoke(o);
                    cell.setCellValue(val);
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                cell.setCellValue(list.get(i).get(columnNames[j]) == null ? " " : list.get(i).get(columnNames[j]).toString());
                cell.setCellStyle(cs2);
            }
        }
        return wb;
    }
    
    /**
     * 描述：公式选择数据下载excel
     * 暂时支持pdf，xls，doc格式
     * @author ylr
     * @date 2016-12-10
     */
    public static String downLoadGSExcel(HttpServletResponse response,String fileName,List<List<String>> list ,String columnNames[]) throws Exception {
//    	String fileName = "信息管理下载";
//		List<MidBaseInfoDto> list = (List<MidBaseInfoDto>) session.getAttribute("compareOutList");
//		if(list.isEmpty()) return null;
		
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
			    HSSFSheet sheet = (HSSFSheet) wb.createSheet("信息管理下载");
			    // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
			    for(int i=0;i<columnNames.length;i++){
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
				for(int j=1;j<=list.size();j++){
					HSSFRow row_j = sheet.createRow(j);
					for(int k=0;k<columnNames.length;k++){
						HSSFCell cell_j_k = row_j.createCell(k);
						cell_j_k.setCellValue(list.get(j-1).get(k));
					}
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
    
    
    
    
    /**
     * 描述：下载本地文件方法
     * 暂时支持pdf，xls，doc格式
     * @author ylr
     * @date 2016-12-10
     */
    public static boolean downLoadFile(String filePath,
            HttpServletResponse response, String fileName, String fileType)
            throws Exception {
            File file = new File(filePath);  //根据文件路径获得File文件
            //设置文件类型(这样设置就不止是下Excel文件了，一举多得)
            if("pdf".equals(fileType)){
               response.setContentType("application/pdf;charset=GBK");
            }else if("xls".equals(fileType)){
               response.setContentType("application/msexcel;charset=GBK");
            }else if("doc".equals(fileType)){
               response.setContentType("application/msword;charset=GBK");
            }
            //文件名
            response.setHeader("Content-Disposition", "attachment;filename=\""
                + new String(fileName.getBytes(), "ISO8859-1") + "\"");
            response.setContentLength((int) file.length());
            byte[] buffer = new byte[4096];// 缓冲区
            BufferedOutputStream output = null;
            BufferedInputStream input = null;
            try {
              output = new BufferedOutputStream(response.getOutputStream());
              input = new BufferedInputStream(new FileInputStream(file));
              int n = -1;
              //遍历，开始下载
              while ((n = input.read(buffer, 0, 4096)) > -1) {
                 output.write(buffer, 0, n);
              }
              output.flush();   //不可少
              response.flushBuffer();//不可少
            } catch (Exception e) {
              //异常自己捕捉       
            } finally {
               //关闭流，不可少
               if (input != null)
                    input.close();
               if (output != null)
                    output.close();
            }
           return false;
        }
    
	 /**
  * 描述：是否为有效的批量比对模板文件
  * @author ylr
  * @date 2016-12-11
  * @param row 
  * @return boolean <br/> true:是，false：不是
  */
 public static boolean isValidCompare(Row row){
   if(row==null) return false;
   boolean flag = true;
   String[] titleNameArr = new String[]{"企业名称","注册号","统一社会信用代码"};
   for (int i = 0; i < titleNameArr.length; i++) {
     if(!row.getCell(i).toString().contains(titleNameArr[i])){
       flag = false;
     }
   }
   return flag;
 }
 
 /**
	 * 描述：上传Excel文件提示信息
	 * @author 马亚伟
 * @param <T>
	 * @date 2015-11-12
	 * @param paramTotal 上传条数
	 * @param paramState 上传状态  成功 ：true 或者 失败： false
	 * @return Map<String,Object>
	 */
	public static Map<String,Object> sucMsgInfo (String fileName,int paramTotal,boolean paramState){
		Map<String,Object> sucMsgInfoMap =  new HashMap<String, Object>();
		sucMsgInfoMap.put("total", paramTotal+"");
		if(paramState){
			sucMsgInfoMap.put("state", "1");//1 表示成功
			sucMsgInfoMap.put("msgInfo", "上传成功！");
		}else{
			sucMsgInfoMap.put("state", "0");//0表示失败
			sucMsgInfoMap.put("msgInfo", "上传失败！");
		} 
		sucMsgInfoMap.put("entName", "");
		sucMsgInfoMap.put("posRowNum", "");
		
		return sucMsgInfoMap;
	}
	
	/**
	 * 描述：Excel内容重复或格式错误的提示信息
	 * @author 马亚伟
	 * @date 2015-11-12
	 * @param paramPosRowNum 出错的行号
	 * @param paramMsgInfo 错误信息："重复内容" 或 "xxx格式错误"
	 * @param paramEntName 企业名称
	 * @return
	 */
	public static Map<String,Object> errMsgInfo (int paramPosRowNum,String paramMsgInfo,String paramEntName){
		Map<String,Object> errMsgInfoMap =  new HashMap<String, Object>();
		errMsgInfoMap.put("posRowNum", paramPosRowNum+"");
		errMsgInfoMap.put("msgInfo", paramMsgInfo);
		if(paramEntName!=null){
			errMsgInfoMap.put("entName", paramEntName);
		}else{
			errMsgInfoMap.put("entName", "");
		}
		errMsgInfoMap.put("state", "0");//0 表示失败
		errMsgInfoMap.put("total", "0");
		return errMsgInfoMap;
	}
	
	/**
	 * 描述：判断cell是否为null或空格
	 * @author MaYawei
	 * @date 2016-01-04
	 * @param paramCell
	 * @return boolean<br/>
	 *         true：为空、false:非空
	 */
	public static Boolean isBlankCell(Cell paramCell){
		boolean flag = false;
		
		if(paramCell==null||"".equals(paramCell.toString().trim()))
				flag = true;
		
		return flag;
	}
	
	/**
	 * 描述：将Cell的内容转为String。<br/>适用于汉字信息、序号等，<br/>不适用于带小数点的数量 转为String,如123.45
	 * @author MaYawei
	 * @date 2015-12-26
	 * @param cell
	 * @return String
	 */
	public static String parseCellValueToString(Cell cell){
		if(isBlankCell(cell)) return null;
		String str=null;
		try{
			if(cell.getCellType()==0){
				str = String.valueOf(new BigDecimal(cell.getNumericCellValue()).toBigInteger());
			}else if(cell.getCellType()==1){
				str = cell.getStringCellValue();
			}else{
				str = String.valueOf(cell);
			}
		}catch(Exception e){
			str = null;
		}
		//return str;
		return str==null?null:str.trim();
	}

}
