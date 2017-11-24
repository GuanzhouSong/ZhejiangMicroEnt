package com.icinfo.cs.upload.utils;

import com.icinfo.framework.tools.utils.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by wangxiao on 2016/12/10.
 */
public class ExcelUtil {

    /**
     * 数据格式化对象 .
     */
    private static final DataFormatter FORMATTER = new DataFormatter();

    /**
     * 获取单元格内容
     * @param cell 单元格
     * @return 单元格对应的文本内容
     */
    public static String getCellContent(Cell cell){
    	if(cell==null||"".equals(cell.toString().trim())) return null;
        if(cell.getCellType() == 0 && DateUtil.isCellDateFormatted(cell)){
            return DateUtils.formatDate(cell.getDateCellValue(),"yyyy-MM-dd");
        }else{
            return replaceAllBlank(strFulltoHalf(FORMATTER.formatCellValue(cell)));
        }
    }
    

    /**
     * 获取单元格内容
     * @param cell 单元格
     * @return 单元格对应的文本内容
     */
    public static String getCellContent11(Cell cell){
    	if(cell==null||"".equals(cell.toString().trim())) return null;
        return cell.toString().trim();
    }

    /**
     * 全角转半角
     *
     * @param src
     * @return
     */
    private static String strFulltoHalf(String src) {
        try {
            if (src == null) {
                return "";
            } else {
                char[] c = src.toCharArray();
                for (int index = 0; index < c.length; index++) {
                    if (c[index] == 12288) {// 全角空格
                        c[index] = (char) 32;
                    } else if (c[index] > 65280 && c[index] < 65375) {// 其他全角字符
                        c[index] = (char) (c[index] - 65248);
                    }
                }
                return String.valueOf(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return src;
    }

    /**
     * 替换所有空格（包含换行）.

     * @param str
     * @return
     */
    private static String replaceAllBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s|\u3000|\t|\r\n|\r|\n|\n\r");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


}
