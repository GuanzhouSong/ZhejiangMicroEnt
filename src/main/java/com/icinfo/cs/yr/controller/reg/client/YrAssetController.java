/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.dto.YrAssetDto;
import com.icinfo.cs.yr.model.Signature;
import com.icinfo.cs.yr.model.YrBaseInfo;
import com.icinfo.cs.yr.model.YrForm;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.*;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.tools.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 描述:    cs_yr_asset 对应的Controller类.<br>
 *
 * @author wangjin
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/yr/ent/yrasset")
public class YrAssetController extends BaseController {

    @Autowired
    IYrAssetService yrAssetService;
    @Autowired
    IYrFormService yrFormService;
    @Autowired
    IYrBaseInfoService yrBaseInfoService;
    @Autowired
    IYrRegCheckService yrRegCheckService;
    @Autowired
    private ISignatureService signatureService;
    
    //登录时企业放进session的key
  	private final String SESSION_MIDBASEINFODTO="midBaseInfoDto";
  	

    /**********************************wangjin start 单表操作***************************************************************/

    /**
     * 编辑对话框
     * @autor:wangjin
     * @param year
     * @return
     * @throws Exception
     */
    @RequestMapping("/show")
    public ModelAndView show(String year,HttpSession session) throws Exception {

        ModelAndView view = new ModelAndView("reg/client/yr/asset/asset_edit");
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码

        if(StringUtil.checkYearAndPripid(year,priPID)){

                String encodeYear = year;          //接收加密年份
                year = AESEUtil.decodeYear(year);  //年份解密

                //资产状况信息
                if (StringUtil.isNotEmpty(year)&&StringUtil.isNotEmpty(priPID)) {
                    view.addObject("yrAsset", yrAssetService.selectByYearAndPripid(Integer.parseInt(year),priPID));
                }

                //获取年报anCheID
                YrBaseInfo yrBaseInfo =  yrBaseInfoService.selectByYearAndPriPID(Integer.valueOf(year),priPID);
                if(yrBaseInfo!=null){
                    if(StringUtil.isNotEmpty(yrBaseInfo.getAnCheID())){
                        view.addObject("anCheID",yrBaseInfo.getAnCheID());
                    }
                }
                //查询年报主表信息
                YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID,Integer.valueOf(year));
                //获取表单填写的状态
                YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID, Integer.valueOf(year));

                //获取电子公章图片字符串路径
                Signature signature = signatureService.selectByYearAndPripid(year,priPID);
                if(signature!=null&&StringUtils.isNotBlank(signature.getTextCode())){
                    view.addObject("qzImgBase64", signature.getTextCode());
                }

                view.addObject("year",year);
                view.addObject("encodeYear",encodeYear);  //年份进行加密
                view.addObject("priPID",priPID);
                view.addObject("tabName", RepTypeUtil.formAsset);//年报资产状况
                view.addObject("yrRegCheck",yrRegCheck);//年报主表信息
                view.addObject("yrForm",yrForm);
        }

        return view;
    }


    /**
     * 保存和更新操作
     * @autor: wangjin
     * @param yrAssetDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
    public AjaxResult save(YrAssetDto yrAssetDto) throws Exception {
        //判断参数是否有值
        if(StringUtil.checkYearAndPripid(yrAssetDto.getYear(),yrAssetDto.getPriPID())) {
            YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(yrAssetDto.getPriPID(), yrAssetDto.getYear());
            String sign = yrAssetDto.getSign();   //获取当前是【暂存状态】还是保持状态 【保存】

            //更新
            if (StringUtil.isNotEmpty(yrAssetDto.getAssetID())) {
                if (yrAssetService.update(yrAssetDto) > 0) {
                    if ((StringUtil.equalsIgnoreCase("temporary", sign))) {
                        return AjaxResult.success("暂存成功");
                    } else {
                        if (yrForm != null) {
                            if (!"1".equals(yrForm.getAsset())) {
                                yrForm.setAsset("1");//已填报
                                yrFormService.updateForm(yrForm);//更新填报表单状态
                            }
                        }
                        return AjaxResult.success("保存成功!");
                    }
                } else {
                    return AjaxResult.error("保存失败!");
                }
            }
            //新增
            if (yrAssetService.insert(yrAssetDto) > 0) {
                if (!(StringUtil.equalsIgnoreCase("temporary", sign))) {  //如果是【暂存】情况的时候不进行保存表单状态
                    //更新填报表单状态
                    if (yrForm != null) {
                        yrForm.setAsset("1");//已填报
                        yrFormService.updateForm(yrForm);//更新填报表单状态
                    }
                }
                return AjaxResult.success("保存成功!", yrAssetDto.getAssetID());
            } else {
                return AjaxResult.error("保存失败!");
            }
        }
        return AjaxResult.error("参数为空,执行失败!");
    }
    
    /**
     * @throws Exception 
     * 
     * 描述 : 根据企业大类更新更新表单填报情况
     * @author: 赵祥江
     * @date  : 2016年9月14日 下午1:58:30 
     * @param :
     * @return: void
     * @throws
     */
    private void updateYrFormByEntTypeCatg(YrForm yrForm, HttpSession session) throws Exception{ 
    	//企业基本信息
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute(SESSION_MIDBASEINFODTO);
		//企业大类
		String entTypeCatg=midBaseInfoDto.getEntTypeCatg();
    	/*
		 * 12内资分公司
		 * 14内资非公司企业法人分支机构
		 * 34内资合伙企业分支机构
		 * 32个人独资分支机构
		 * 22外资分支机构
		 * 28外商投资合伙企业分支机构
		 * 24外国（地区）企业在中国境内从事生产经营活动
		 */
		if("12,14,22,24,28,32,34".indexOf(entTypeCatg) != -1){//分支机构
			if(!"1".equals(yrForm.getAssetbranch())){
				yrForm.setAssetbranch("1");
				yrFormService.updateYrFormByPripidAndYear(yrForm);
			}
		}else{
			if(!"1".equals(yrForm.getAsset())){
				yrForm.setAsset("1");
				yrFormService.updateYrFormByPripidAndYear(yrForm);
			} 
		} 
    }

    /**********************************wangjin end 单表操作***************************************************************/
}