/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.yr.mapper.YrForGuaranteeInfoMapper;
import com.icinfo.cs.yr.model.YrBaseInfo;
import com.icinfo.cs.yr.model.YrForGuaranteeInfo;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.cs.yr.service.IYrForGuaranteeInfoService;
import com.icinfo.cs.yr.service.IYrFormService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.framework.tools.utils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * 描述:    cs_yr_forguaranteeinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class YrForGuaranteeInfoServiceImpl extends MyBatisServiceSupport implements IYrForGuaranteeInfoService {
    private static final Logger logger = LoggerFactory.getLogger(YrForGuaranteeInfoServiceImpl.class);

    @Autowired
    private YrForGuaranteeInfoMapper yrForGuaranteeInfoMapper;
    @Autowired
    private IYrBaseInfoService iYrBaseInfoService;
    @Autowired
    private IYrFormService iYrFormService;

    //对外担保主键uuid
    private final String CS_YR_FORINVESTMENT_MOREID = "moreID";
    //年报表单填写情况 对应表 cs_yr_form 
    private final String CS_YR_FORM_FORGUARANTEEINFO = "forguaranteeinfo";

    /**
     * 新增
     *
     * @param yrForGuaranteeInfo
     * @return
     * @author: wangjin
     */

    @Override
    public int insert(YrForGuaranteeInfo yrForGuaranteeInfo) {
        yrForGuaranteeInfo.setCreateTime(DateUtils.getSysDate());
        return yrForGuaranteeInfoMapper.insert(yrForGuaranteeInfo);
    }

    /**
     * 更新对象
     *
     * @param yrForGuaranteeInfo
     * @return
     * @author: wangjin
     */
    @Override
    public int update(YrForGuaranteeInfo yrForGuaranteeInfo) {
        Example example = new Example(YrForGuaranteeInfo.class);
        example.createCriteria().andEqualTo(CS_YR_FORINVESTMENT_MOREID, yrForGuaranteeInfo.getMoreID()).andEqualTo("priPID", yrForGuaranteeInfo.getPriPID());
        //yrForGuaranteeInfo.setCreateTime(DateUtils.getSysDate());
        return yrForGuaranteeInfoMapper.updateByExampleSelective(yrForGuaranteeInfo, example);
    }

    /**
     * 列表查询
     *
     * @param request
     * @return
     * @author: wangjin
     */
    @Override
    public List<YrForGuaranteeInfo> select_queryPage(PageRequest request) {
        String priPID = request.getParams().get(Constants.CS_PRIPID).toString();
        String year = request.getParams().get(Constants.CS_YEAR).toString();
        if (StringUtil.checkYearAndPripid(year, priPID)) {
            PageHelper.startPage(request.getPageNum(), request.getLength());
            return yrForGuaranteeInfoMapper.search_queryPage(request.getParams());
        }
        return null;
    }

    /**
     * 获取 主债额的 合计
     *
     * @param queryMap
     * @return
     */
    @Override
    public BigDecimal sumMoney(Map<String, Object> queryMap) {
        BigDecimal sumMoney = yrForGuaranteeInfoMapper.sumMoeny(queryMap);
        return sumMoney != null ? sumMoney : new BigDecimal(0);
    }


    /**
     * 根据moreID 和 priPID　查询对象
     *
     * @param moreID
     * @param priPID
     * @return
     * @author: wangjin
     */
    @Override
    public YrForGuaranteeInfo selectByMoreIDAndPriPID(String moreID, String priPID) {
        YrForGuaranteeInfo yrForGuaranteeInfo = new YrForGuaranteeInfo();
        yrForGuaranteeInfo.setMoreID(moreID);
        yrForGuaranteeInfo.setPriPID(priPID);
        return yrForGuaranteeInfoMapper.selectOne(yrForGuaranteeInfo);
    }

    /**
     * 批量删除
     *
     * @param list_moreID
     * @param priPID
     * @return
     * @autor:wangjin
     */
    @Override
    public int batch_delete(List<String> list_moreID, String priPID) {
        if (StringUtil.isNotEmpty(priPID)) {
            YrForGuaranteeInfo yrForGuaranteeInfo = null;
            int num = 0;
            for (String moreID : list_moreID) {
                yrForGuaranteeInfo = new YrForGuaranteeInfo();
                yrForGuaranteeInfo.setMoreID(moreID);
                yrForGuaranteeInfo.setPriPID(priPID);
                yrForGuaranteeInfoMapper.delete(yrForGuaranteeInfo);
                num++;
            }
            return num;
        }
        return 0;
    }


    /**
     * 根据年份和主体身份代码获取 对象集合数据
     *
     * @param year
     * @param priPID
     * @return
     * @autor:wangjin
     */
    @Override
    public List<YrForGuaranteeInfo> selectByYearAndPripidList(Integer year, String priPID) {
        Example example = new Example(YrForGuaranteeInfo.class);
        if (StringUtil.isNotEmpty(String.valueOf(year)) && StringUtil.isNotEmpty(priPID)) {
            example.createCriteria().andEqualTo(Constants.CS_YEAR, year).andEqualTo(Constants.CS_PRIPID, priPID);
            return yrForGuaranteeInfoMapper.selectByExample(example);
        }
        return null;
    }

    /**
     * 插入当前年份上一年份的数据集合
     *
     * @param list
     * @param anCheID 年报ID
     * @return
     * @autor:wangjin
     */
    @Override
    public void insertYrForGuaranteeinfoList(List<YrForGuaranteeInfo> list, String anCheID) {
        YrForGuaranteeInfo yrForGuaranteeInfo = null;
        int leng = list.size();
        for (int i = 0; i < leng; i++) {
            yrForGuaranteeInfo = new YrForGuaranteeInfo();
            yrForGuaranteeInfo.setMoreID(StringUtils.uuid());//主键 生成uuid 对外担保标识ID
            yrForGuaranteeInfo.setPriPID(list.get(i).getPriPID());//主体身份代码
            yrForGuaranteeInfo.setYear(list.get(i).getYear() + 1);//年份
            yrForGuaranteeInfo.setMore(list.get(i).getMore().replace("'", "\\\'"));//债权人
            yrForGuaranteeInfo.setMortgagor(list.get(i).getMortgagor().replace("'","\\\'"));//债务人
            yrForGuaranteeInfo.setCreateTime(DateUtils.getSysDate());//系统当前时间
            yrForGuaranteeInfo.setAnCheID(anCheID);//当前年报ID
            yrForGuaranteeInfo.setGaRange(list.get(i).getGaRange());//保证担保额范围：1：主债权  2：利息 3：违约金 4：损害赔偿金 5：实现债权的费用 6：其他约定
            yrForGuaranteeInfo.setPriClaSecKind(list.get(i).getPriClaSecKind());//主债权种类
            yrForGuaranteeInfo.setPriClaSecAm(list.get(i).getPriClaSecAm());//主债权数额
            yrForGuaranteeInfo.setPefPerForm(list.get(i).getPefPerForm());//履行债务的期限自
            yrForGuaranteeInfo.setPefPerTo(list.get(i).getPefPerTo());//履行债务的期限至
            yrForGuaranteeInfo.setIsPubFlag(list.get(i).getIsPubFlag());//对外担保是否公示
            yrForGuaranteeInfo.setGaType(list.get(i).getGaType());//保证的方式
            yrForGuaranteeInfo.setGuaPeriod(list.get(i).getGuaPeriod());//保证的期间
            yrForGuaranteeInfoMapper.insert(yrForGuaranteeInfo);//
        }

    }

    /**
     * 插入Excel数据
     *
     * @param file
     * @param year
     * @param priPID HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls
     * @autor:wangjin
     */
    @Override
    public AjaxResult importYrForGuaranteeInfoByExcel(MultipartFile file, String year, String priPID, String anCheID) throws Exception {

        //获取文件后和后缀名
        String fileName = file.getOriginalFilename(); //获取文件名
        String ext = StringUtil.getExtNoPoint(fileName);//获取后缀名

        //判断Excel是2003版本还是2007版本
        if (StringUtils.equalsIgnoreCase("xls", ext)) {
            return readExcel2003(file, year, priPID, anCheID); //读取2003版本
        } else if (StringUtils.equalsIgnoreCase("xlsx", ext)) {
            return readExcel2007(file, year, priPID, anCheID);//读取2007版本
        }


        return null;
    }


    //Excel 2003版本
    @Transactional(rollbackFor = Exception.class)
    private AjaxResult readExcel2003(MultipartFile file, String year, String priPID, String anCheID) throws Exception {

        //获取文件流
        InputStream in = file.getInputStream();
        // 得到工作薄
        HSSFWorkbook workbook = new HSSFWorkbook(in);
        //得到工作表的张数
        int num = workbook.getNumberOfSheets();
        //System.out.println("工作表得数目" + num);
        //得到第一张工作表
        HSSFSheet sheet = workbook.getSheetAt(0);
        //得到第一列的宽度
        int width = sheet.getColumnWidth(0);
        // System.out.println("第一列的宽度是：" + width);
       /* //得到第一行的单元格迭代器
        Iterator iter = sheet.getRow(0).cellIterator();*/
        // 得到工作表的行数
        int frnum = sheet.getFirstRowNum();
        int lrnum = sheet.getLastRowNum();
        int rnum = lrnum - frnum + 1;
        //System.out.println("工作表的行数为:" + rnum);
        // 得到工作表的列数
        int fcnum = sheet.getRow(0).getFirstCellNum();
        int lcnum = sheet.getRow(0).getLastCellNum();
        int cnum = lcnum - fcnum;
        //System.out.println("工作表的列数为:" + cnum);

        //判断所选的Excel表格是否是下载的模板数据
        if (cnum != 16) {
            return AjaxResult.error("您选择的Excel表格数据非下载模板,请重新选择!");
        }
        Iterator iter2 = sheet.getRow(2).cellIterator();
        boolean flag = true;
        while (iter2.hasNext()) {
            // 得到第一行单元格
            HSSFCell cell = (HSSFCell) iter2.next();
            if (cell.getColumnIndex() == 0 && !StringUtils.equals(cell.getStringCellValue().trim(), "序号")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 1 && !StringUtils.equals(cell.getStringCellValue().trim(), "债权人")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 2 && !StringUtils.equals(cell.getStringCellValue().trim(), "债务人")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 3 && !StringUtils.equals(cell.getStringCellValue().trim(), "主债权种类")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 5 && !StringUtils.equals(cell.getStringCellValue().trim(), "保证的期间")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 6 && !StringUtils.equals(cell.getStringCellValue().trim(), "保证的方式")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 15 && !StringUtils.equals(cell.getStringCellValue().trim(), "是否公示")) {
                flag = false;
                break;
            }
        }
        if (!flag) {  //如果和模板的表头不匹配则提醒操作用
            return AjaxResult.error("您选择的Excel表格数据非下载模板,请重新选择!");
        }
        //判断当前模板是否有填写数据
        if (StringUtils.isEmpty(sheet.getRow(4).getCell(1).getStringCellValue())) { //判断第5行的第一列的单元格是否有值
            return AjaxResult.error("您选择的Excel模板表格数据未填写!");
        }

        List<YrForGuaranteeInfo> yrForGuaranteeInfoList = new ArrayList<YrForGuaranteeInfo>();
        for (int i = 4; i < rnum; i++) {
            //得到单元格迭代器
            Iterator iter = sheet.getRow(i).cellIterator();
            //初始化对象
            YrForGuaranteeInfo yrForGuaranteeInfo = new YrForGuaranteeInfo();
            String GaRangeStr = ""; //对外担保参数
            HSSFCell cellFirstColumn = sheet.getRow(i).getCell(1); // //判断每一行的第二列数据是否为空
            if (cellFirstColumn == null || StringUtils.isEmpty(cellFirstColumn.getStringCellValue())) break;
            while (iter.hasNext()) {
                // 得到单元格
                HSSFCell cell = (HSSFCell) iter.next();
                // 单元格为字符串型的情况
                if (HSSFCell.CELL_TYPE_STRING == cell.getCellType() || HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) { //单元格为字符串或数字类型进行进入
                    //债权人
                    if (cell.getColumnIndex() == 1) {
                        yrForGuaranteeInfo.setMore(cell.getStringCellValue());
                    }
                    //债务人
                    if (cell.getColumnIndex() == 2) {
                        yrForGuaranteeInfo.setMortgagor(cell.getStringCellValue());
                    }

                    //主债权种类
                    if (cell.getColumnIndex() == 3) {
                        if ("合同".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setPriClaSecKind("1");
                        } else if ("其他".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setPriClaSecKind("2");
                        }
                    }
                    //主债权数额
                    if (cell.getColumnIndex() == 4) {
                        yrForGuaranteeInfo.setPriClaSecAm(new BigDecimal(cell.getStringCellValue().trim()));
                    }

                    //保证期间
                    if (cell.getColumnIndex() == 5) {
                        if ("期间".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setGuaPeriod("1");
                        } else if ("未约定".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setGuaPeriod("2");
                        }
                    }

                    //保证方式
                    if (cell.getColumnIndex() == 6) {
                        if ("一般保证".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setGaType("1");
                        } else if ("连带保证".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setGaType("2");
                        } else if ("未约定".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setGaType("3");
                        }
                    }

                    //保证担保的范围
                    if (cell.getColumnIndex() == 7) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "1,";
                        }
                    }
                    if (cell.getColumnIndex() == 8) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "2,";
                        }
                    }
                    if (cell.getColumnIndex() == 9) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "3,";
                        }
                    }
                    if (cell.getColumnIndex() == 10) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "4,";
                        }
                    }
                    if (cell.getColumnIndex() == 11) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "5,";
                        }
                    }
                    if (cell.getColumnIndex() == 12) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "6,";
                        }
                    }

                    //履行债务的期限自
                    if (cell.getColumnIndex() == 13) {
                        yrForGuaranteeInfo.setPefPerForm(DateUtil.stringToDate(cell.getStringCellValue().trim(), "yyyy-MM-dd"));
                    }//字符串转换成日期格式
                    //履行债务的期限至
                    if (cell.getColumnIndex() == 14) {
                        yrForGuaranteeInfo.setPefPerTo(DateUtil.stringToDate(cell.getStringCellValue().trim(), "yyyy-MM-dd"));
                    }

                    //是否公示
                    if (cell.getColumnIndex() == 15) {
                        if ("公示".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setIsPubFlag("1");
                        } else if ("不公示".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setIsPubFlag("0");
                        }
                    }
                }
            }
            //对外担保参数拼接
            if (GaRangeStr.length() > 0) {
                yrForGuaranteeInfo.setGaRange(GaRangeStr.substring(0, GaRangeStr.length() - 1));
            }
            //时间戳
            yrForGuaranteeInfo.setCreateTime(DateUtils.getSysDate());
            //年份
            yrForGuaranteeInfo.setYear(Integer.valueOf(year));
            //身份主体代码
            yrForGuaranteeInfo.setPriPID(priPID);
            //获取年报anCheID
            yrForGuaranteeInfo.setAnCheID(anCheID);
            yrForGuaranteeInfoList.add(yrForGuaranteeInfo);
        }

        //删除当前数据库中存在的数据
        YrForGuaranteeInfo _yrForGuaranteeInfo = new YrForGuaranteeInfo();
        _yrForGuaranteeInfo.setYear(Integer.valueOf(year));
        _yrForGuaranteeInfo.setPriPID(priPID);
        yrForGuaranteeInfoMapper.delete(_yrForGuaranteeInfo);

        //循环导入
        boolean _sign = true;
        if (yrForGuaranteeInfoList.size() > 0) {
            for (YrForGuaranteeInfo yrForGuaranteeInfo : yrForGuaranteeInfoList) {
                if (!(yrForGuaranteeInfoMapper.insert(yrForGuaranteeInfo) > 0)) {
                    _sign = false;
                }
            }
        }
        if (_sign) {
            return AjaxResult.success("导入成功!");
        }
        return AjaxResult.error("导入失败,可能是导入数据存在问题!");
    }

    //Excel 2007版本
    @Transactional(rollbackFor = Exception.class)
    private AjaxResult readExcel2007(MultipartFile file, String year, String priPID, String anCheID) throws Exception {

        //2007版 Excel
        //获取文件流
        InputStream in = file.getInputStream();
        // 得到工作薄
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        //得到工作表的张数
        int num = workbook.getNumberOfSheets();
        //System.out.println("工作表得数目" + num);
        //得到第一张工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //得到第一列的宽度
        int width = sheet.getColumnWidth(0);

        // 得到工作表的行数
        int frnum = sheet.getFirstRowNum();
        int lrnum = sheet.getLastRowNum();
        int rnum = lrnum - frnum + 1;
        //System.out.println("工作表的行数为:" + rnum);
        // 得到工作表的列数
        int fcnum = sheet.getRow(0).getFirstCellNum();
        int lcnum = sheet.getRow(0).getLastCellNum();
        int cnum = lcnum - fcnum;
        //System.out.println("工作表的列数为:" + cnum);

        //判断所选的Excel表格是否是省局模板数据
        if (cnum != 16) {
            return AjaxResult.error("您选择的Excel表格数据非下载模板,请重新选择!");
        }
        Iterator iter2 = sheet.getRow(2).cellIterator();
        boolean flag = true;
        while (iter2.hasNext()) {
            // 得到第一行单元格
            XSSFCell cell = (XSSFCell) iter2.next();
            if (cell.getColumnIndex() == 0 && !StringUtils.equals(cell.getStringCellValue().trim(), "序号")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 1 && !StringUtils.equals(cell.getStringCellValue().trim(), "债权人")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 2 && !StringUtils.equals(cell.getStringCellValue().trim(), "债务人")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 3 && !StringUtils.equals(cell.getStringCellValue().trim(), "主债权种类")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 5 && !StringUtils.equals(cell.getStringCellValue().trim(), "保证的期间")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 6 && !StringUtils.equals(cell.getStringCellValue().trim(), "保证的方式")) {
                flag = false;
                break;
            }
            if (cell.getColumnIndex() == 15 && !StringUtils.equals(cell.getStringCellValue().trim(), "是否公示")) {
                flag = false;
                break;
            }

        }
        if (!flag) {  //如果和模板的表头不匹配则提醒操作用
            return AjaxResult.error("您选择的Excel表格数据非下载模板,请重新选择!");
        }
        //判断当前模板是否有填写数据
        if (StringUtils.isEmpty(sheet.getRow(4).getCell(1).getStringCellValue())) { //判断第5行的第一列的单元格是否有值
            return AjaxResult.error("您选择的Excel模板表格数据未填写!");
        }

        //////////////////////////////////////////判断Excel表格中是否存在空值///////////////////////////////////////////////////
    /*	//判断Excel表格中是否存在空值
		Integer currentRow = null;
		boolean _flag = true;
		for (int i = 4; i <rnum; i++) { //行
			Row ros = sheet.getRow(i);
			for(int j = 1; j < ros.getLastCellNum(); j++){ //列
				Cell cell = ros.getCell(j);
				//验证单元格为必填项 只有都有数据时才执行导入此行
				if("".equals( cell.getStringCellValue().trim()) || cell.getCellType() == Cell.CELL_TYPE_BLANK){_flag = false;}
				if(_flag==false){break;}
			}
			if(!_flag){currentRow = i; break;}
		}
		if(!_flag){return AjaxResult.error("表格中的第"+(currentRow+1)+"行存在空值!");}*/
        //////////////////////////////////////////判断Excel表格中是否存在空值///////////////////////////////////////////////////

        List<YrForGuaranteeInfo> yrForGuaranteeInfoList = new ArrayList<YrForGuaranteeInfo>();
        for (int i = 4; i < rnum; i++) {
            //得到单元格迭代器
            Iterator iter = sheet.getRow(i).cellIterator();
            //初始化对象
            YrForGuaranteeInfo yrForGuaranteeInfo = new YrForGuaranteeInfo();
            String GaRangeStr = ""; //对外担保参数
            XSSFCell cellFirstColumn2 = sheet.getRow(i).getCell(1); //判断每一行的第二列数据是否为空
            if (cellFirstColumn2 == null || StringUtils.isEmpty(cellFirstColumn2.getStringCellValue())) break;

            while (iter.hasNext()) {
                // 得到单元格
                XSSFCell cell = (XSSFCell) iter.next();
                // 单元格为字符串型的情况
                if (XSSFCell.CELL_TYPE_STRING == cell.getCellType() || XSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) { //单元格为字符串或数字类型进行进入
                    //债权人
                    if (cell.getColumnIndex() == 1) {
                        yrForGuaranteeInfo.setMore(cell.getStringCellValue());
                    }
                    //债务人
                    if (cell.getColumnIndex() == 2) {
                        yrForGuaranteeInfo.setMortgagor(cell.getStringCellValue());
                    }

                    //主债权种类
                    if (cell.getColumnIndex() == 3) {
                        if ("合同".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setPriClaSecKind("1");
                        } else if ("其他".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setPriClaSecKind("2");
                        }
                    }
                    //主债权数额
                    if (cell.getColumnIndex() == 4) {
                        yrForGuaranteeInfo.setPriClaSecAm(new BigDecimal(cell.getStringCellValue()));
                    }

                    //保证期间
                    if (cell.getColumnIndex() == 5) {
                        if ("期间".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setGuaPeriod("1");
                        } else if ("未约定".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setGuaPeriod("2");
                        }
                    }

                    //保证方式
                    if (cell.getColumnIndex() == 6) {
                        if ("一般保证".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setGaType("1");
                        } else if ("连带保证".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setGaType("2");
                        } else if ("未约定".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setGaType("3");
                        }
                    }

                    //保证担保的范围
                    if (cell.getColumnIndex() == 7) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "1,";
                        }
                    }
                    if (cell.getColumnIndex() == 8) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "2,";
                        }
                    }
                    if (cell.getColumnIndex() == 9) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "3,";
                        }
                    }
                    if (cell.getColumnIndex() == 10) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "4,";
                        }
                    }
                    if (cell.getColumnIndex() == 11) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "5,";
                        }
                    }
                    if (cell.getColumnIndex() == 12) {
                        if ("有".equals(cell.getStringCellValue().trim())) {
                            GaRangeStr += "6,";
                        }
                    }

                    //履行债务的期限自
                    if (cell.getColumnIndex() == 13) {
                        yrForGuaranteeInfo.setPefPerForm(DateUtil.stringToDate(cell.getStringCellValue().trim(), "yyyy-MM-dd"));
                    }//字符串转换成日期格式
                    //履行债务的期限至
                    if (cell.getColumnIndex() == 14) {
                        yrForGuaranteeInfo.setPefPerTo(DateUtil.stringToDate(cell.getStringCellValue().trim(), "yyyy-MM-dd"));
                    }

                    //是否公示
                    if (cell.getColumnIndex() == 15) {
                        if ("公示".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setIsPubFlag("1");
                        } else if ("不公示".equals(cell.getStringCellValue().trim())) {
                            yrForGuaranteeInfo.setIsPubFlag("0");
                        }
                    }
                }
            }
            //对外担保参数拼接
            yrForGuaranteeInfo.setGaRange(GaRangeStr.substring(0, GaRangeStr.length() - 1));
            //时间戳
            yrForGuaranteeInfo.setCreateTime(DateUtils.getSysDate());
            //年份
            yrForGuaranteeInfo.setYear(Integer.valueOf(year));
            //身份主体代码
            yrForGuaranteeInfo.setPriPID(priPID);
            //获取年报anCheID
            yrForGuaranteeInfo.setAnCheID(anCheID);
            yrForGuaranteeInfoList.add(yrForGuaranteeInfo);
        }

        //删除当前数据库中存在的数据
        YrForGuaranteeInfo yrForGuaranteeInfo2 = new YrForGuaranteeInfo();
        yrForGuaranteeInfo2.setYear(Integer.valueOf(year));
        yrForGuaranteeInfo2.setPriPID(priPID);
        yrForGuaranteeInfoMapper.delete(yrForGuaranteeInfo2);

        //循环导入
        boolean _sign = true;
        if (yrForGuaranteeInfoList.size() > 0) {
            for (YrForGuaranteeInfo yrForGuaranteeInfo : yrForGuaranteeInfoList) {
                if (!(yrForGuaranteeInfoMapper.insert(yrForGuaranteeInfo) > 0)) {
                    _sign = false;
                }
            }
        }
        if (_sign) {
            return AjaxResult.success("导入成功!");
        }
        return AjaxResult.error("导入失败,可能是导入数据存在问题!");

    }


    /**
     * 描述: 年报预览：对外提供保证担保信息
     *
     * @param request
     * @return
     * @throws Exception
     * @auther ZhouYan
     * @date 2016年9月24日
     */
    @Override
    public List<YrForGuaranteeInfo> queryPagePreview(PageRequest request) throws Exception {
        List<YrForGuaranteeInfo> yrForGuaranteeInfoList = new ArrayList<YrForGuaranteeInfo>();
        try {
            Map<String, Object> searchMap = request.getParams();
            PageHelper.startPage(request.getPageNum(), request.getLength());
            Example example = this.getExample(YrForGuaranteeInfo.class);
            //验证是否主体代码和年报年度都传了
            if (searchMap.containsKey(Constants.CS_PRIPID) && searchMap.containsKey(Constants.CS_YEAR)) {
                example.createCriteria().andEqualTo(Constants.CS_PRIPID, searchMap.get(Constants.CS_PRIPID).toString())
                        .andEqualTo(Constants.CS_YEAR, searchMap.get(Constants.CS_YEAR).toString());
                yrForGuaranteeInfoList = yrForGuaranteeInfoMapper.selectByExample(example);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("exception {}", "获取对外提供保证担保信息失败!");
            throw new BusinessException("获取对外提供保证担保信息失败!");
        }
        return yrForGuaranteeInfoList;
    }


    //TODO  下面暂未用到代码---------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * 描述             : 根据主键moreId（uuid） 获取对外担保对象
     *
     * @param :
     * @throws
     * @author: 赵祥江
     * @date : 2016年8月30日 下午5:21:34
     * @return: YrForGuaranteeInfo
     */
    @Override
    public YrForGuaranteeInfo selectYrForGuaranteeInfoByMoreId(String moreId) throws Exception {
        try {
            if (StringUtil.isNotEmpty(moreId)) {
                Example example = this.getExample(YrForGuaranteeInfo.class);
                example.createCriteria()
                        .andEqualTo(CS_YR_FORINVESTMENT_MOREID, moreId);
                List<YrForGuaranteeInfo> yrForGuaranteeInfoList = yrForGuaranteeInfoMapper.selectByExample(example);
                if (yrForGuaranteeInfoList.size() > 0) {
                    return yrForGuaranteeInfoList.get(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("exception {}", "查询对外担保数据失败!");
            throw new BusinessException("查询对外担保数据失败!");
        }
        return null;
    }


    /**
     * 描述             : 根据主键moreId（uuid） 修改对外担保对象
     *
     * @param :
     * @throws
     * @author: 赵祥江
     * @date : 2016年8月30日 下午5:22:50
     * @return: int
     */
    @Override
    public int updateYrForGuaranteeInfoByMoreId(YrForGuaranteeInfo yrForGuaranteeInfo) throws Exception {
        int i = 0;
        try {
            if (yrForGuaranteeInfo != null && StringUtil.isNotEmpty(yrForGuaranteeInfo.getMoreID())) {
                //时间戳
                yrForGuaranteeInfo.setCreateTime(DateUtils.getSysDate());
                Example example = this.getExample(YrForGuaranteeInfo.class);
                example.createCriteria()
                        .andEqualTo(CS_YR_FORINVESTMENT_MOREID, yrForGuaranteeInfo.getMoreID());
                yrForGuaranteeInfoMapper.updateByExampleSelective(yrForGuaranteeInfo, example);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("exception {}", "修改对外担保数据失败!");
            throw new BusinessException("修改对外担保数据失败!");
        }
        return i;
    }

    /**
     * 描述             : 根据主键moreId（uuid）删除对外担保对象
     *
     * @param :
     * @throws
     * @author: 赵祥江
     * @date : 2016年8月30日 下午2:09:36
     * @return: YrForinvestMent
     */
    @Override
    public int deleteYrForGuaranteeInfoByMoreId(String moreId) throws Exception {
        int i = 0;
        try {
            if (StringUtil.isNotEmpty(moreId)) {
                Example example = this.getExample(YrForGuaranteeInfo.class);
                example.createCriteria()
                        .andEqualTo(CS_YR_FORINVESTMENT_MOREID, moreId);
                i = yrForGuaranteeInfoMapper.deleteByExample(example);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("exception {}", "删除对外担保数据失败!");
            throw new BusinessException("删除对外担保数据失败!");
        }
        return i;
    }

    /**
     * 描述             : 根据年报年度和主体代码获取对外担保结果集
     *
     * @param :
     * @throws
     * @author: 赵祥江
     * @date : 2016年8月30日 下午2:09:36
     * @return: YrForinvestMent
     */
    @Override
    public List<YrForGuaranteeInfo> selectYrForGuaranteeInfoByYearAndPriPID(int year, String priPID) throws Exception {
        List<YrForGuaranteeInfo> yrForGuaranteeInfoList = new ArrayList<YrForGuaranteeInfo>();
        try {
            if (StringUtil.isNotEmpty(priPID) && StringUtil.isNotEmpty(year + "")) {
                Example example = this.getExample(YrForGuaranteeInfo.class);
                example.createCriteria()
                        .andEqualTo(Constants.CS_PRIPID, priPID)
                        .andEqualTo(Constants.CS_YEAR, year);
                yrForGuaranteeInfoList = yrForGuaranteeInfoMapper.selectByExample(example);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("exception {}", "根据年报年度和主体代码获取对外担保结果集失败!");
            throw new BusinessException("根据年报年度和主体代码获取对外担保结果集失败!");
        }
        return yrForGuaranteeInfoList;
    }

    /**
     * 描述             : 保存对外担保对象
     *
     * @param :
     * @throws
     * @author: 赵祥江
     * @date : 2016年8月30日 下午2:09:36
     * @return: YrForinvestMent
     */
    @Override
    public int insertYrForGuaranteeInfo(YrForGuaranteeInfo yrForGuaranteeInfo) throws Exception {
        int i = 0;
        try {
            if (yrForGuaranteeInfo != null) {
                String pripid = yrForGuaranteeInfo.getPriPID();
                int year = yrForGuaranteeInfo.getYear();
                List<YrBaseInfo> yrBaseInfoList = iYrBaseInfoService.selectYrBaseInfoByYearAndPriPID(year, pripid);
                //年报ID
                yrForGuaranteeInfo.setAnCheID(yrBaseInfoList.get(0).getAnCheID());
                //时间戳
                yrForGuaranteeInfo.setCreateTime(DateUtils.getSysDate());
                i = yrForGuaranteeInfoMapper.insert(yrForGuaranteeInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("exception {}", "修改对外担保数据失败!");
            throw new BusinessException("修改对外担保数据失败!");
        }
        return i;
    }


    /**
     * 描述             : 对外担保导入
     *
     * @param :
     * @throws
     * @author: 赵祥江
     * @date : 2016年9月13日 下午12:02:24
     */
    @Override
    public int importYrForGuaranteeInfo(MultipartFile file, String PriPID, int year)
            throws Exception {
        int i = 0;
        try {
            //获取文件后和后缀名
            String fileName = file.getOriginalFilename(); //获取文件名
            String ext = this.getExtNoPoint(fileName);//获取后缀名
            if ("xls".equals(ext)) {//2003
                //this.readExcel2003(file,PriPID, year);
            } else if ("xlsx".equals(ext)) {//2007
                //this.readExcel2007(file,  PriPID, year);
            } else {
                throw new BusinessException("导入模板的格式不对,只能导入excel表格模板!");
            }
            i++;
        } catch (Exception e) {
            logger.error("exception {}", e.getMessage());
            throw new BusinessException(e.getCause().getMessage(), e);
        }
        return i;
    }


    /**
     *
     * 描述             : 2007版本
     * @author: 赵祥江
     * @date  : 2016年9月13日 下午1:43:21
     * @param :
     * @return: void
     * @throws
     */
/*	private void readExcel2007(MultipartFile file,
			 String priPID, int year)throws Exception{
		List<YrForGuaranteeInfo> yrForGuaranteeInfoList=new ArrayList<YrForGuaranteeInfo>();
		try { 
			List<YrBaseInfo> yrBaseInfoList= iYrBaseInfoService.selectYrBaseInfoByYearAndPriPID(year, priPID);
			String ancheId=yrBaseInfoList.get(0).getAnCheID();
			boolean flag;
	        //获取文件流
	        InputStream in = file.getInputStream();
	        // 得到工作薄
	        XSSFWorkbook workbook = new XSSFWorkbook(in); 
	        //得到第一张工作表
	        XSSFSheet sheet = workbook.getSheetAt(0); 
             
            //Row firstRow = sheet.getRow(0);  
            //Iterator<Cell> iterator = firstRow.iterator();  
            //保存列名  
           *//* List<String> cellNames = new ArrayList<String>();
            while (iterator.hasNext()) {  
                cellNames.add(iterator.next().getStringCellValue());  
            } *//*
            for (int i = 4; i <= sheet.getLastRowNum(); i++) {  
            	flag = true;
                Row ros = sheet.getRow(i);  
                for(int j = 1; j < ros.getLastCellNum(); j++){
                	Cell cell = ros.getCell(j);
                	//验证单元格为必填项 只有都有数据时才执行导入此行
                	if("".equals( cell.getStringCellValue().trim()) || cell.getCellType() == Cell.CELL_TYPE_BLANK){
                		flag = false; 
                	}
                	if(flag==false){
                		break;
                	}
                }
                if(flag){ 
                    yrForGuaranteeInfoList.add(this.rowsToYrForGuaranteeInfo(ros, ancheId, priPID, year));
                }else{
                	continue;
                }
            } 
            if(yrForGuaranteeInfoList.size()>0){ 
		    	Example example=this.getExample(YrForGuaranteeInfo.class);
				example.createCriteria()
				.andEqualTo(Constants.CS_PRIPID, priPID)
				.andEqualTo(Constants.CS_YEAR,year);
				//删除
				yrForGuaranteeInfoMapper.deleteByExample(example);
            	//新增
            	for(YrForGuaranteeInfo yrForGuaranteeInfo:yrForGuaranteeInfoList){
            		yrForGuaranteeInfoMapper.insert(yrForGuaranteeInfo);
            	}
            	YrForm yrForm=this.iYrFormService.selectYrFormByPripidAndYear(priPID, year);
            	if(yrForm!=null&&!"1".equals(yrForm.getForguaranteeinfo())){
            		//更新年报表单填报 0 未填报 1 已填报
            		yrForm.setForguaranteeinfo("1");
            		iYrFormService.updateYrFormByPripidAndYear(yrForm);
            	} 
            } 
		} catch (Exception e) {
			logger.error("exception {}", e.getMessage());
            throw new BusinessException(e.getCause().getMessage(),e);
		}
	}*/


    /**
     *
     * 描述             : 2003版本
     * @author: 赵祥江
     * @date  : 2016年9月13日 下午1:43:21
     * @param :
     * @return: void
     * @throws
     */
/*	private void readExcel2003(MultipartFile file,
			 String priPID, int year)throws Exception{
		List<YrForGuaranteeInfo> yrForGuaranteeInfoList=new ArrayList<YrForGuaranteeInfo>(); 
		try {
			List<YrBaseInfo> yrBaseInfoList= iYrBaseInfoService.selectYrBaseInfoByYearAndPriPID(year, priPID);
			String ancheId=yrBaseInfoList.get(0).getAnCheID();
			boolean flag;
			//获取文件流
	        InputStream in = file.getInputStream();
	        // 得到工作薄
	        HSSFWorkbook workbook = new HSSFWorkbook(in); 
	        //得到第一张工作表
	        HSSFSheet sheet = workbook.getSheetAt(0);  
	        
	        for (int i = 4; i <= sheet.getLastRowNum(); i++) {  
            	flag = true;
                Row ros = sheet.getRow(i);  
                for(int j = 1; j < ros.getLastCellNum(); j++){
                	Cell cell = ros.getCell(j);
                	//验证单元格为必填项 只有都有数据时才执行导入此行
                	if("".equals( cell.getStringCellValue().trim()) || cell.getCellType() == Cell.CELL_TYPE_BLANK){
                		flag = false; 
                	}
                	if(flag==false){
                		break;
                	}
                }
                if(flag){ 
                    yrForGuaranteeInfoList.add(this.rowsToYrForGuaranteeInfo(ros, ancheId, priPID, year));
                }else{
                	continue;
                }
            } 
	        if(yrForGuaranteeInfoList.size()>0){ 
		    	Example example=this.getExample(YrForGuaranteeInfo.class);
				example.createCriteria()
				.andEqualTo(Constants.CS_PRIPID, priPID)
				.andEqualTo(Constants.CS_YEAR,year);
				//删除
				yrForGuaranteeInfoMapper.deleteByExample(example);
            	//新增
            	for(YrForGuaranteeInfo yrForGuaranteeInfo:yrForGuaranteeInfoList){
            		yrForGuaranteeInfoMapper.insert(yrForGuaranteeInfo);
            	}
            	
            	YrForm yrForm=this.iYrFormService.selectYrFormByPripidAndYear(priPID, year);
            	if(yrForm!=null&&!"1".equals(yrForm.getForguaranteeinfo())){
            		//更新年报表单填报 0 未填报 1 已填报
            		yrForm.setForguaranteeinfo("1");
            		iYrFormService.updateYrFormByPripidAndYear(yrForm);
            	} *//*else{
            		List<String> reportTypeList=new ArrayList<String>(); 
            		reportTypeList.add(RepTypeUtil.formForguaranteeinfo); 
            		this.iYrFormService.insert(priPID, year, reportTypeList);
            	} *//*
            }
		} catch (Exception e) {
			logger.error("exception {}", e.getMessage());
            throw new BusinessException(e.getCause().getMessage(),e);
		}
	}
	*/

    /**
     * 描述             : 对外担保导入根据excel的行组装成对象
     *
     * @param :
     * @throws
     * @author: 赵祥江
     * @date : 2016年9月13日 下午4:55:11
     * @return: YrForGuaranteeInfo
     */
    private YrForGuaranteeInfo rowsToYrForGuaranteeInfo(Row ros, String ancheId, String priPID, int year) {
        YrForGuaranteeInfo guaranteeInfo = new YrForGuaranteeInfo();
        guaranteeInfo.setPriPID(priPID);
        guaranteeInfo.setYear(year);
        //债权人
        guaranteeInfo.setMore(ros.getCell(1).getStringCellValue().trim());
        //债务人
        guaranteeInfo.setMortgagor(ros.getCell(2).getStringCellValue().trim());
        //主债权种类
        if ("合同".equals(ros.getCell(3).getStringCellValue().trim())) {
            guaranteeInfo.setPriClaSecKind("1");
        } else if ("其他".equals(ros.getCell(3).getStringCellValue().trim())) {
            guaranteeInfo.setPriClaSecKind("2");
        } else {
            guaranteeInfo.setPriClaSecKind("");
        }
        //主债权数额
        if ("".equals(ros.getCell(4).getStringCellValue().toString().trim())) {
            guaranteeInfo.setPriClaSecAm(null);
        } else {
            guaranteeInfo.setPriClaSecAm(new BigDecimal(ros.getCell(4).getStringCellValue().toString().trim()));
        }
        //保证期间
        if ("期间".equals(ros.getCell(5).getStringCellValue().trim())) {
            guaranteeInfo.setGuaPeriod("1");
        } else if ("未约定".equals(ros.getCell(5).getStringCellValue().trim())) {
            guaranteeInfo.setGuaPeriod("2");
        } else {
            guaranteeInfo.setGuaPeriod("");
        }
        //保证方式
        if ("一般保证".equals(ros.getCell(6).getStringCellValue().trim())) {
            guaranteeInfo.setGaType("1");
        } else if ("连带保证".equals(ros.getCell(6).getStringCellValue().trim())) {
            guaranteeInfo.setGaType("2");
        } else if ("未约定".equals(ros.getCell(6).getStringCellValue().trim())) {
            guaranteeInfo.setGaType("3");
        } else {
            guaranteeInfo.setGaType("");
        }
        //保证担保的范围
        String strTmp = "";
        if ("有".equals(ros.getCell(7).getStringCellValue().trim())) {
            strTmp += "1,";
        }
        if ("有".equals(ros.getCell(8).getStringCellValue().trim())) {
            strTmp += "2,";
        }
        if ("有".equals(ros.getCell(9).getStringCellValue().trim())) {
            strTmp += "3,";
        }
        if (ros.getCell(10).getStringCellValue().trim().equals("有")) {
            strTmp += "4,";
        }
        if (ros.getCell(11).getStringCellValue().trim().equals("有")) {
            strTmp += "5,";
        }
        if (ros.getCell(12).getStringCellValue().trim().equals("有")) {
            strTmp += "6,";
        }
        guaranteeInfo.setGaRange(strTmp);
        //履行债务的期限自
        if (StringUtil.isEmpty(ros.getCell(13).getStringCellValue().trim())) {
            guaranteeInfo.setPefPerForm(null);
        } else {
            guaranteeInfo.setPefPerForm(
                    com.icinfo.cs.common.utils.DateUtil.stringToDate(ros.getCell(13)
                            .getStringCellValue().trim(), "yyyy-MM-dd"));
        }

        //履行债务的期限至
        if (StringUtil.isEmpty(ros.getCell(14).getStringCellValue().trim())) {
            guaranteeInfo.setPefPerTo(null);
        } else {
            guaranteeInfo.setPefPerTo(
                    com.icinfo.cs.common.utils.DateUtil.stringToDate(ros.getCell(14)
                            .getStringCellValue().trim(), "yyyy-MM-dd"));
        }

        //是否公示
        if ("公示".equals(ros.getCell(15).getStringCellValue().trim())) {
            guaranteeInfo.setIsPubFlag("1");
        } else if ("不公示".equals(ros.getCell(15).getStringCellValue().trim())) {
            guaranteeInfo.setIsPubFlag("0");
        } else {
            guaranteeInfo.setIsPubFlag("");
        }
        //时间戳
        guaranteeInfo.setCreateTime(DateUtils.getSysDate());
        //年报ID
        guaranteeInfo.setAnCheID(ancheId);
        return guaranteeInfo;
    }

    /**
     * 描述             : 获取文件后缀名
     *
     * @param :
     * @throws
     * @author: 赵祥江
     * @date : 2016年9月13日 下午1:47:08
     * @return: String
     */
    private String getExtNoPoint(String fileName) {
        if (fileName.lastIndexOf(".") < 0)
            return "";
        int pos = fileName.lastIndexOf(".") + 1;
        return fileName.substring(pos, fileName.length());
    }


    /**
     * 描述             : 获取组装查询sql工具对象
     *
     * @param :
     * @throws
     * @author: 赵祥江
     * @date : 2016年8月30日 下午2:23:46
     * @return: Criteria
     */
    private Example getExample(Class<?> classObj) {
        Example example = new Example(classObj);
        return example;
    }


    /**
     * 描述             : 初始化对外担保 先获取当年的对外担保 如果没有则获取上一年的
     *
     * @param :
     * @throws
     * @author: 赵祥江
     * @date : 2016年9月18日 上午10:37:26
     * @return: void
     */
    @Override
    public void initYrForGuaranteeInfo(int year, String priPID)
            throws Exception {
        List<YrForGuaranteeInfo> yrForGuaranteeInfoList = new ArrayList<YrForGuaranteeInfo>();
        try {
            Example example = getExample(YrForGuaranteeInfo.class);
            example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID)
                    .andEqualTo(Constants.CS_YEAR, year);
            //如果当年没有则获取上一年的年报对外投资 并赋给当年的年报对外投资以便修改
            int total = yrForGuaranteeInfoMapper.selectCountByExample(example);
            if (total <= 0) {
                example.clear();
                int preYear = year - 1;
                example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID)
                        .andEqualTo(Constants.CS_YEAR, preYear);
                yrForGuaranteeInfoList = yrForGuaranteeInfoMapper.selectByExample(example);
                if (yrForGuaranteeInfoList.size() > 0) {
                    for (YrForGuaranteeInfo yrForGuaranteeInfo : yrForGuaranteeInfoList) {
                        //时间戳
                        yrForGuaranteeInfo.setCreateTime(DateUtils.getSysDate());
                        //年份
                        yrForGuaranteeInfo.setYear(year);
                        yrForGuaranteeInfoMapper.insert(yrForGuaranteeInfo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("exception {}", "初始化对外担保信息失败");
            throw new BusinessException("初始化对外担保信息失败");
        }
    }

    @Override
    public List<YrForGuaranteeInfo> selectListByCerNO(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return yrForGuaranteeInfoMapper.selectListByCerNO(request.getParams());
    }
}