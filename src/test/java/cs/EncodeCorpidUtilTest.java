package cs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.icinfo.cs.common.utils.AESEUtil;

public class EncodeCorpidUtilTest{
	
	static String filePath = "D:/测试.xls";
	
    public static void main(String[] args) throws Exception{
     
		List<String> list = new ArrayList<String>();
		List<String> strList = new ArrayList<String>();
	//读取文件
		InputStream is = new FileInputStream(filePath);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        // 获取每一个工作薄
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 获取当前工作薄的每一行
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    HSSFCell one = hssfRow.getCell(0);
                    list.add(one.getStringCellValue());
                }
            }
        }
        for(String str: list){
        	System.out.println(str+"===="+AESEUtil.encodeCorpid(str));
        	strList.add(AESEUtil.encodeCorpid(str));
        }
     //写入文件
        OutputStream os = new FileOutputStream(filePath);
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 获取当前工作薄的每一行
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                hssfRow.createCell(1).setCellValue(strList.get(rowNum-1));
            }
        }
        os.flush();  
        hssfWorkbook.write(os);    
        os.close(); 
    }
	
}
	
