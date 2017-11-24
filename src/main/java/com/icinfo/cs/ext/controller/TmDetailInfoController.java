/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Encoder;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.OssClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.TmDetailInfoDto;
import com.icinfo.cs.ext.model.TmDetailInfo;
import com.icinfo.cs.ext.model.TmGoods;
import com.icinfo.cs.ext.service.ITmDetailInfoService;
import com.icinfo.cs.ext.service.ITmGoodsService;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:    cs_tm_detail_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年12月08日
 */
@Controller
@RequestMapping("/tmDetailInfo/")
public class TmDetailInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TmDetailInfo.class);

	@Autowired
	private ITmDetailInfoService tmDetailInfoService;
	
	@Autowired
	private ITmGoodsService tmGoodsService;
	
	@Autowired
	private  HttpServletRequest request;
	
	@Autowired
	private OssClient ossClient;
	
	

	/**
	 * 
	 * 描述: 商标注册信息查询
	 * @auther gaojinling
	 * @date 2016年12月8日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public List<TmDetailInfoDto> listJSON(@RequestParam String priPID) throws Exception {
		List<TmDetailInfoDto> tmDetailInfoList = new ArrayList<TmDetailInfoDto>();
		if(StringUtil.isNotEmpty(priPID)){
			tmDetailInfoList = tmDetailInfoService.queryPageResult(priPID,null);
		}
		if(tmDetailInfoList != null && tmDetailInfoList.size()>0){
			for(TmDetailInfoDto tmDetailInfoDto : tmDetailInfoList){
				tmDetailInfoDto.setEnRegNum(AESEUtil.encodeCorpid(tmDetailInfoDto.getREG_NUM()));
				//将获取到的文件流（本地）
//				tmDetailInfoDto.setTM_IMAGE(downFromLoc("CJQ201612191645270000-宽的像素小于640k (3).JPG"));
				//oss下载获取的文件流（oss）
//				OssClient.listAllObjects(null);
				
				tmDetailInfoDto.setTM_IMAGE(downFormOSS("brand/"+tmDetailInfoDto.getREG_NUM()+".jpg"));
			}
		}
		return tmDetailInfoList;
	}
	
	/**
	 * 
	 * 描述: 商标注册信息查询单个信息详情
	 * @auther gaojinling
	 * @date 2016年12月8日 
	 * @param regnum 商标注册号
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listDetail")
	public ModelAndView listDetail(@RequestParam String enregnum) throws Exception {
		ModelAndView view = new ModelAndView("/pub/infopublic/infodetail/branddetail");
		if(StringUtil.isNotEmpty(enregnum)){ //防止传值为空时查询出所有数据
			enregnum = AESEUtil.decodeCorpid(enregnum); //商标注册号解密
			List<TmDetailInfoDto> tmDetailInfoList = tmDetailInfoService.queryPageResult(null,enregnum);
			TmDetailInfoDto tmDetailInfoDto =  tmDetailInfoList.get(0);
			//oss下载获取的文件流（oss）
			tmDetailInfoDto.setTM_IMAGE(downFormOSS("brand/"+tmDetailInfoDto.getREG_NUM()+".jpg"));
			//将二进制流转Base64字符串
			BASE64Encoder encoder = new BASE64Encoder();
		    tmDetailInfoDto.setImageString(encoder.encode(tmDetailInfoDto.getTM_IMAGE()));
			view.addObject("tmDetailInfoDto",tmDetailInfoDto);	
			List<TmGoods> goodsList = tmGoodsService.selectTmGoodsList(enregnum);
			view.addObject("goodsList", goodsList);
		}
		return view;
	}
	
	/**
	 * 
	 * 描述: 商标注册信息列表
	 * @auther gaojinling
	 * @date 2016年12月8日 
	 * @param regnum 商标注册号
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(@RequestParam String encryPriPID) throws Exception {
		ModelAndView view = new ModelAndView("/pub/infopublic/infodetail/brandlist");
		if(StringUtil.isNotEmpty(encryPriPID)){ //防止传值为空时查询出所有数据
			encryPriPID = AESEUtil.decodeCorpid(encryPriPID); //主体代码解密
			List<TmDetailInfoDto> tmDetailInfoList = tmDetailInfoService.queryPageResult(encryPriPID,null);
//			List<TmDetailInfoDto> tmDetailInfoList = tmDetailInfoService.queryPageResult("3300006000006451",null);
			if(tmDetailInfoList != null && tmDetailInfoList.size()>0){
				for(TmDetailInfoDto tmDetailInfoDto:  tmDetailInfoList ){
					//oss下载获取的文件流（oss）
					tmDetailInfoDto.setTM_IMAGE(downFormOSS("brand/"+tmDetailInfoDto.getREG_NUM()+".jpg"));
					//将二进制流转Base64字符串
					BASE64Encoder encoder = new BASE64Encoder();
				    tmDetailInfoDto.setImageString(encoder.encode(tmDetailInfoDto.getTM_IMAGE()));
					//加密商标注册号
				    tmDetailInfoDto.setEnRegNum(AESEUtil.encodeCorpid(tmDetailInfoDto.getREG_NUM()));
				    
				}
				view.addObject("tmDetailInfoList", tmDetailInfoList);
			}
			view.addObject("length", tmDetailInfoList.size());
		}
		return view;
	}
	
	
	/**
	 * 从OSS下载文件接口
	 * @param fileName
	 * @return
	 */
	private byte[] downFormOSS(String fileName) {
		if (fileName == null || StringUtils.isBlank(fileName)) {
			return null;
		}
		try {// 从OSS获取文件流
			byte[] by = null;
			by = ossClient.getStream(fileName);
			return by;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 从本地下载接口
	 * @param fileName
	 * @return
	 */
	private byte[] downFromLoc(String fileName) {
		byte[] buffer = null;
		try {
			String realPath = request.getSession().getServletContext().getRealPath("/upload");
			File file = new File(realPath + File.separator + fileName);
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
			return buffer;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
	}
  
}
}