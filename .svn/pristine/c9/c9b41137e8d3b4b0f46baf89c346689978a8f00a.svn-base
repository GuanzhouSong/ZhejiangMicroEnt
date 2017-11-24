/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.message.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.message.dto.CsMessageRelDto;
import com.icinfo.cs.message.mapper.CsMessageRelMapper;
import com.icinfo.cs.message.model.CsMessage;
import com.icinfo.cs.message.model.CsMessageRel;
import com.icinfo.cs.message.service.ICsMessageRelService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_message_rel 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月18日
 */
@Service
public class CsMessageRelServiceImpl extends MyBatisServiceSupport implements ICsMessageRelService {

    @Autowired
    private CsMessageRelMapper csMessageRelMapper;

    private CsMessageRelDto    dto = null;
    private Long               count = 0L;

    /** 
     * 描述: 新增
     * @author 张文男
     * @date 2017年5月19日 
     * @param bean 
     */

    public void insert(CsMessageRel bean){
        csMessageRelMapper.insert (bean);
    }

    /** 
     * 描述: 获取消息分页列表 
     * @author 张文男
     * @date 2017年5月23日 
     * @param request
     * @return 
     */

    public PageResponse<CsMessageRelDto> queryMessagPageList(PageRequest request){
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        Map<String, Object> map = request.getParams ();
        putQueryMessagPageListMap (map);
        List<CsMessageRelDto> list = csMessageRelMapper.queryMessagPageList (map);
        return new PageResponse<CsMessageRelDto> (list);
    }
    
    private void putQueryMessagPageListMap(Map<String, Object> map){
        if (map.get ("entType") != null) {
            map.put ("entType", StringUtil.doSplitStringToSqlFormat (map.get ("entType").toString (), ","));
        }
        if (map.get ("regOrg") != null) {
            map.put ("regOrg", StringUtil.doSplitStringToSqlFormat (map.get ("regOrg").toString (), ","));
        }
        if (map.get ("localAdm") != null) {
            map.put ("localAdm", StringUtil.doSplitStringToSqlFormat (map.get ("localAdm").toString (), ","));
        }
        if (map.get ("sliceNO") != null) {
            map.put ("sliceNO", StringUtil.doSplitStringToSqlFormat (map.get ("sliceNO").toString (), ","));
        }
        if (map.get ("regStateM") != null) {
            map.put ("regStateM", StringUtil.doSplitStringToSqlFormat (map.get ("regStateM").toString (), ","));
        }
        
    }

    /** 
     * 描述: 获取消息分页列表根据企业id
     * @author 张文男
     * @date 2017年5月24日 
     * @param map
     * @return 
     */

    public PageResponse<CsMessageRelDto> queryMessagPageListByPriPID(PageRequest request){
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        Map<String, Object> map = request.getParams ();
        List<CsMessageRelDto> list = csMessageRelMapper.queryMessagPageListByPriPID (map);
        return new PageResponse<CsMessageRelDto> (list);
    }

    /** 
     * 描述:  获取消息分页列表根据消息ID
     * @author 张文男
     * @date 2017年5月24日 
     * @param request
     * @return 
     */

    public PageResponse<CsMessageRel> queryMessagPageListByMsgUid(PageRequest request){
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        Map<String, Object> map = request.getParams ();
        List<CsMessageRel> list = queryMessagListByMsgUid (map.get ("msgUid").toString ());
        return new PageResponse<CsMessageRel> (list);
    }

    /** 
     * 描述: 获取消息列表根据消息ID
     * @author 张文男
     * @date 2017年5月25日 
     * @param msgUid
     * @return 
     */

    public List<CsMessageRel> queryMessagListByMsgUid(String msgUid){
        Example e = new Example (CsMessageRel.class);
        Criteria c = e.createCriteria ();
        c.andEqualTo ("msgUid", msgUid);
        List<CsMessageRel> list = csMessageRelMapper.selectByExample (e);
        return list;
    }

    /** 
     * 描述: 导出excel
     * @author 张文男
     * @date 2017年5月25日 
     * @param msgUid
     * @param ouputStream
     * @throws IOException 
     */

    public void excelExportByMsgUid(String msgUid,OutputStream ouputStream) throws IOException{
        List<CsMessageRel> list = queryMessagListByMsgUid (msgUid);
        if (null != list && list.size () > 0) {
            // 第一步，创建一个webbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook ();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet ("企业信息");
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow row = sheet.createRow (0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = wb.createCellStyle ();
            style.setAlignment (HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

            HSSFCell cell = row.createCell (0);
            cell.setCellValue ("序号");
            cell.setCellStyle (style);
            cell = row.createCell (1);
            cell.setCellValue ("企业名称");
            cell.setCellStyle (style);

            for ( int i = 0 ; i < list.size () ; i++ ) {
                row = sheet.createRow (i + 1);
                CsMessageRel csMessageRel = (CsMessageRel) list.get (i);
                // 第四步，创建单元格，并设置值
                row.createCell (0).setCellValue (i + 1);
                row.createCell (1).setCellValue (csMessageRel.getEntName ());

            }
            wb.write (ouputStream);
        }
    }

    /** 
     * 描述: 根据查询条件获取统计信息
     * @author 张文男
     * @date 2017年5月25日 
     * @param map
     * @return
     * @throws InterruptedException 
     */
    
    public CsMessageRelDto queryMessageCount(Map<String,Object> map) throws InterruptedException{
        putQueryMessagPageListMap (map);
        final CountDownLatch countDownLatch = new CountDownLatch (2);
        new Thread (new Runnable () {

            @Override
            public void run(){
                try {
                    count = queryMessagCountGroupByPriPID (map);
                    countDownLatch.countDown ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        }).start ();

        new Thread (new Runnable () {

            @Override
            public void run(){
                try {
                    dto = queryMessagCountGroupByMsgUid (map);
                    countDownLatch.countDown ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }

            }
        }).start ();

        countDownLatch.await ();
        dto.setEntNum (count);
        return dto;
    }

    /** 
     * 描述: 根据企业id获取统计数据 
     * @author 张文男
     * @date 2017年5月25日 
     * @param map
     * @return 
     */

    public Long queryMessagCountGroupByPriPID(Map<String, Object> map){
        Long count = csMessageRelMapper.queryMessagCountGroupByPriPID (map);
        return count;
    }

    /** 
     * 描述: 根据消息id获取统计数据
     * @author 张文男
     * @date 2017年5月25日 
     * @param map
     * @return 
     */

    public CsMessageRelDto queryMessagCountGroupByMsgUid(Map<String, Object> map){
        CsMessageRelDto csMessageRelDto = csMessageRelMapper.queryMessagCountGroupByMsgUid (map);
        return csMessageRelDto;
    }
}