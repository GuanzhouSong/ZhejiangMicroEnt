/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.base.controller;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.framework.core.web.BaseController;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:无需拦截的公用的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月08日
 */
@Controller
@RequestMapping("/common/system/util/")
public class CommonUtilController extends BaseController{

    /**
     *  文件下载
     * @throws Exception
     */
    @RequestMapping("/down")
    public ResponseEntity<byte[]> file_down(HttpServletRequest request,String fullFileName)throws Exception{
        Map<String,Object> qry=new HashMap<>();
        qry.put("1","qzspsx.pdf");
        qry.put("2","hzspml.pdf");
        qry.put("3","ptsgz.mp4");
        qry.put("4","sgzczsm.pps");
        qry.put("5","czjyjs.pdf");
        qry.put("6","sgzgztz.doc");
        qry.put("7","ssjppt.ppt");
        qry.put("8","ssjjj.pdf");
        qry.put("9","ssjspjs.mp4");
        qry.put("10","zgsqg201618.doc");
        qry.put("11","zsyjf201608.pdf");

        String path = request.getSession().getServletContext()
                .getRealPath("WEB-INF")+ File.separator+"file"+ File.separator+qry.get(fullFileName);
        File file=new File(path);

        if(!file.isFile()){
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        String fileName=new String(qry.get(fullFileName).toString().getBytes("GBK"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

    /**
     *  文件下载
     * @throws Exception
     */
    @RequestMapping("/xszn")
    public String  xszn(HttpServletRequest request,String fullFileName)throws Exception{
        return "/syn/xszn";
    }

}
