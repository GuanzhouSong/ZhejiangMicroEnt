package com.icinfo.cs.common.utils;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * 描述: excel导入工具类<br>
 * 
 * @author ljx
 * @date 2016年11月24日
 */
public class ImportExcelUtil {
	private final static String excel2003L = ".xls"; // 2003- 版本的excel
	private final static String excel2007U = ".xlsx"; // 2007+ 版本的excel

	public Map<String,Object> getBankListByExcel(InputStream in, String fileName,int rows,String [] titles) throws Exception {
		List<List<Object>> list = null;
        Map<String,Object> map=new HashMap<String,Object>();
		
		
		Workbook work=this.getWorkbook(in, fileName);
	    if(null==work){
	    	throw new Exception("创建Excel工作薄为空!");
	    }
	    Sheet sheet=null;
	    Row row=null;
	    Cell cell=null;
	    list=new ArrayList<List<Object>>();
	    //遍历Excel中所有的sheet 
	    for(int i=0;i<=work.getNumberOfSheets()-1;i++){
	    	sheet=work.getSheetAt(i);
	    	if(sheet==null){continue;}
	    	//遍历当前sheet中的所有行
	    	Row rowT=sheet.getRow(rows-1);//标题
	    	if(rowT==null){continue;}//如果当前工作表标题为空则退出
	    	int columnNum=titles.length; 
	    	for(int l=0;l<=columnNum-1;l++){//通过标题判断模板  
	        	  if(!rowT.getCell(l).getStringCellValue().trim().equals(titles[l])){
	        		  map.put("errorType","模板选择错误,请重新选择!");
	        		  return map;
	        		 //throw new Exception("模板选择错误,请重新选择!");
	        	 } 
	        	 
	        }
	    	 Row rowF=sheet.getRow(rows);
	    	if(rowF==null){
	    		  map.put("errorType","您选择的Excel模板表格数据未填写!");
	    		  return map;
	    	 
	    	} 
	    	
	    	 String [] texTitles={};  
	    	 for(int j=rows;j<sheet.getLastRowNum()+1;j++){
	    		row=sheet.getRow(j);
	    		if(row==null||row.getFirstCellNum()==j){continue;}
	    		
	    		//遍历所有的列
	    	    List<Object> li=new ArrayList<Object>();
	    	    for(int y=row.getFirstCellNum();y<row.getLastCellNum();y++){
	    	    	cell=row.getCell(y);
	    	    	li.add(this.getCellValue(cell));
	    	    }
	    	    list.add(li); 
	    	}  
	    }
	    
	    map.put("errorType","ok");
	    map.put("listob",list);
	 return map;
	    
	    
	}

	/**
	 * 描述：根据文件后缀，自适应上传文件的版本
	 * 
	 * @param inStr,fileName
	 * @return
	 * @throws Exception
	 */

	/**
	 * 
	 * 描述: 选择上传文件版本
	 * 
	 * @auther ljx
	 * @date 2016年11月24日
	 * @param inStr
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
		Workbook wb = null;
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		if (excel2003L.equals(fileType)) {
			wb = new HSSFWorkbook(inStr);// 2003-
		} else if (excel2007U.equals(fileType)) {
			wb = new XSSFWorkbook(inStr);// 2007+
		} else {
			throw new Exception("解析文件格式有误!");
		}
		return wb;

	}

	public Object getCellValue(Cell cell) {
		Object value = null;
		DecimalFormat df = new DecimalFormat("0"); // 格式化number String字符
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd"); // 日期格式化
		DecimalFormat df2 = new DecimalFormat("0"); // 格式化数字
		if(cell!=null){ 
		switch (cell.getCellType()) {  
	        case Cell.CELL_TYPE_STRING:  
	            value = cell.getRichStringCellValue().getString();  
	            break;  
	        case Cell.CELL_TYPE_NUMERIC:  
	            if("General".equals(cell.getCellStyle().getDataFormatString())){  
	                value = df.format(cell.getNumericCellValue());  
	            }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){  
	                value = sdf.format(cell.getDateCellValue());  
	            }else{  
	                value = df2.format(cell.getNumericCellValue());  
	            }  
	            break;  
	        case Cell.CELL_TYPE_BOOLEAN:  
	            value = cell.getBooleanCellValue();  
	            break;  
	        case Cell.CELL_TYPE_BLANK:  
	            value = "";  
	            break;  
	        default:  
	            break;  
	        }   
		
	}
		
		return value;

	}

}
