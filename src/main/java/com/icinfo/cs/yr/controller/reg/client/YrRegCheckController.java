/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.login.service.impl.LoginServiceImpl;
import com.icinfo.cs.mainmark.service.IMainMarkService;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.model.FoodstorageBase;
import com.icinfo.cs.yr.model.IndividQueMain;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IFoodstorageBaseService;
import com.icinfo.cs.yr.service.IIndividQueMainService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:    cs_yr_reg_check 对应的Controller类.<br>
 *
 * @author wangjin
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/yr/yrregcheck")
public class YrRegCheckController extends BaseController {

    @Autowired
    IYrRegCheckService yrRegCheckService;

    @Autowired
    IIndividQueMainService iIndividQueMainService;

    @Autowired
    IFoodstorageBaseService foodstorageBaseService;
    @Autowired
    ICodeCertypeService codeCertypeService; //证件类型
    @Autowired
    private IPubEppasswordService pubEppasswordService;
    @Autowired
    private ISysLogService sysLogService;  //登录日志
    
    @Autowired
    private IMainMarkService mainMarkService;


    private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    /**********************************wangjin start 单表操作***************************************************************/



    /**
     * 描述: 国家局版本统一登录跳转首页
     * @auther ZhouYan
     * @date 2016年12月10日
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/index_list")
    public ModelAndView indexall_list(HttpSession session) throws Exception {
    	ModelAndView view = new ModelAndView("reg/client/index");
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
        List<YrRegCheck> yrRegCheckList = new ArrayList<YrRegCheck>();
        String priPID = midBaseInfoDto.getPriPID();
        String systemType =  RepTypeUtil.getSystemType(midBaseInfoDto.getEntTypeCatg());
        if(systemType.equals(Constants.SYSTEM_TYPE_ENT)) {
        	//即时信息报表配置
            view.addObject("imReportTypeList", RepTypeUtil.getImReportTypeList(midBaseInfoDto.getEntTypeCatg(), midBaseInfoDto.getEntType()));
            //是否需要填写个转企调查表标志
            int year = Calendar.getInstance().get(Calendar.YEAR);
            boolean questionaireFlag = doVerifyQuestionaire(midBaseInfoDto);
            if(questionaireFlag) {
            	List<IndividQueMain>  individQueMainList = iIndividQueMainService.selectIndividQueMainList(priPID, year);
                if(CollectionUtils.isNotEmpty(individQueMainList)){
                	IndividQueMain IndividQueMain = individQueMainList.get(0);
                	view.addObject("individQueMain", IndividQueMain);
                }
            }
            //是否需要填写食品仓储标志
            boolean foodstorageFlag = doVerifyFoodstorage(midBaseInfoDto);
            if(foodstorageFlag){
            	 FoodstorageBase foodstorageBase = foodstorageBaseService.selecFoodstorageBaseByPriPIDandYear(priPID, year);
                 view.addObject("foodstorageBase", foodstorageBase);
            }
          //获取年报列表信息
            yrRegCheckList = CompanyCheckList(midBaseInfoDto,priPID);
            view.addObject("questionaireFlag", questionaireFlag);
            view.addObject("foodstorageFlag", foodstorageFlag);
        }else {
        	yrRegCheckList =regCheckList(midBaseInfoDto);
        }

        //判断是【数字证书登录】还是【联络员登录】  从session中获取登录方式   1,5数字证书登录    2：联络员登录
        String loginType = (String) session.getAttribute("loginType");

        //查询联络员信息：   参数    统一社会信用代码   注册号
        PubEppassword liaison =  pubEppasswordService.selectPubEppasswordByPriPid(midBaseInfoDto.getPriPID());
        session.setAttribute("liaison",liaison);                           //将联络员信息存进session中

        //证件类型：
        List<CodeCertype> codeCertypeList = codeCertypeService.selectAll();

        //查询日志最新一次操作日期
     /*   List<SysLog> list_date = sysLogService.selectSysLogByPripid(midBaseInfoDto.getPriPID());
        Date endDate = list_date.get(0).getSetTime();
        //获取系统当前年份时间
        Date newDate = DateUtil.stringToDate(DateUtil.getCurrentYear() + "-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"); //获取当前年份日期的时分秒
        if(endDate!=null){
            if(endDate.getTime()>newDate.getTime()){   //判断最后一次操作日期时间是否大于当前系统年份时间
                view.addObject("date_flag", "true");   //时间标志
            }else{
                view.addObject("date_flag", "false");  //时间标志  表示需要进行弹框
            }
        }else{
            view.addObject("date_flag", "false");      //时间标志      表示需要进行弹框
        }*/

        if("1".equals(loginType)||"5".equals(loginType)){  //判断条件成立表示是数字证书登录

            String flag = "true";                                              //用于判断法人是否发生变化的标志

            //获取企业大类 判断是否是（合伙企业 27,33）
            // Boolean _boolean = ("27,33").contains(midBaseInfoDto.getEntTypeCatg());
            Boolean _boolean = ("33,27").indexOf(midBaseInfoDto.getEntTypeCatg()) == -1; //判断是否是合伙企业
            if(liaison!=null&&_boolean){
                String midName = StringUtil.trim(midBaseInfoDto.getLeRep());   //mid表中的法人代表
                if(StringUtil.isNotEmpty(midName)){                            //判断 mid表中的法人代表是否为空 如果为空则是合伙人 否则进行 法人代表的判断
                    String liaisonName =  StringUtil.trim(liaison.getLerep()); //联络员法人代表
                    if(!midName.equals(liaisonName)){flag = "false";}          //判断联络员信息的法人代表和mid表里面的法人代表是否是同一个人 true：是  否：false
                }
            }
            view.addObject("flag", flag);
            view.addObject("liaison", liaison);//联络员信息

        }else if("2".equals(loginType)){
            view.addObject("liaisonLogin","liaisonLogin");  //联络员登录的标志
        }
        view.addObject("codeCertypeList", codeCertypeList);//证件类型
        view.addObject("pripid",priPID);
        view.addObject("EntTypeCatg",midBaseInfoDto.getEntTypeCatg());//企业类型
        view.addObject("yrRegCheckList",yrRegCheckList);
        return view;
    }


    /**
     *  首页 显示 企业
     * @author wangjin
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/ent/index_list")
    public ModelAndView index_list(HttpSession session) throws Exception {
    	ModelAndView view = new ModelAndView("reg/client/index");
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
        //即时信息报表配置
        view.addObject("imReportTypeList", RepTypeUtil.getImReportTypeList(midBaseInfoDto.getEntTypeCatg(), midBaseInfoDto.getEntType()));
        //是否需要填写个转企调查表标志
        int year = Calendar.getInstance().get(Calendar.YEAR);
        boolean questionaireFlag = doVerifyQuestionaire(midBaseInfoDto);
        if(questionaireFlag) {
        	List<IndividQueMain>  individQueMainList = iIndividQueMainService.selectIndividQueMainList(midBaseInfoDto.getPriPID(), year);
            if(CollectionUtils.isNotEmpty(individQueMainList)){
            	IndividQueMain IndividQueMain = individQueMainList.get(0);
            	view.addObject("individQueMain", IndividQueMain);
            }
        }
        //是否需要填写食品仓储标志
        boolean foodstorageFlag = doVerifyFoodstorage(midBaseInfoDto);
        if(foodstorageFlag){
        	 FoodstorageBase foodstorageBase = foodstorageBaseService.selecFoodstorageBaseByPriPIDandYear(midBaseInfoDto.getPriPID(), year);
             view.addObject("foodstorageBase", foodstorageBase);
        }
        //获取年报列表信息
        String priPID=midBaseInfoDto.getPriPID();
        List<YrRegCheck> yrRegCheckList = yrRegCheckService.doGetYrRegCheckInit(priPID);
        view.addObject("questionaireFlag", questionaireFlag);
        view.addObject("foodstorageFlag", foodstorageFlag);
        view.addObject("pripid",priPID);
        view.addObject("yrRegCheckList",yrRegCheckList);
        return view;
    }


	/**
     * 描述: 首页 显示 农专
     * @auther ZhouYan
     * @date 2016年11月15日
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/sfc/index_list")
    public ModelAndView sfcindex_list(HttpSession session) throws Exception {
        ModelAndView view = new ModelAndView("reg/client/index");
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
        //获取年报列表信息
        String priPID=midBaseInfoDto.getPriPID();
        List<YrRegCheck> yrRegCheckList =regCheckList(midBaseInfoDto);
        view.addObject("pripid",priPID);
        view.addObject("yrRegCheckList",yrRegCheckList);

        return view;
    }

    /**
     * 描述: 首页 显示 个体户
     * @auther ZhouYan
     * @date 2016年11月15日
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/pb/index_list")
    public ModelAndView pbindex_list(HttpSession session) throws Exception {
        ModelAndView view = new ModelAndView("reg/client/index");
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
        //获取年报列表信息
        String priPID=midBaseInfoDto.getPriPID();
        List<YrRegCheck> yrRegCheckList = regCheckList(midBaseInfoDto);
        view.addObject("pripid",priPID);
        view.addObject("yrRegCheckList",yrRegCheckList);

        return view;
    }


    /**
     * 判断当前企业是否是个转企 是 只获取个转企 年份 的展示列表 否显示 成立日期的列表
     * @autrhor: wangjin
     * @param midBaseInfoDto
     * @return
     * @throws Exception
     */
    private  List<YrRegCheck> CompanyCheckList(MidBaseInfoDto midBaseInfoDto,String priPID) throws Exception {

        List<YrRegCheck> yrRegCheckList  = yrRegCheckService.doGetYrRegCheckInit(priPID);
        //判断是否是个转企 1：表示是个转企
        String isIndivid = midBaseInfoDto.getIsIndivid();
        // 个转企日期
        Date individDate = midBaseInfoDto.getIndividDate();
        //获取系统年份
        int systemYear = Integer.valueOf(DateUtil.dateToString(DateUtil.getSysDate(), "yyyy"));

        if(StringUtils.isNotBlank(isIndivid)&&individDate!=null){
            int estYear = Integer.valueOf(DateUtil.dateToString(individDate, "yyyy")); // 获取个转企日期的年份
            if("1".equals(isIndivid)){                                                 //是否是个转企 标识是 ：1
                //如果个转企是当前年份则填写前一年的年报信息
                if(systemYear==estYear){
                    for(int i=0;i<yrRegCheckList.size();i++){
                        if(yrRegCheckList.get(i).getYear()<(estYear-1)){
                            yrRegCheckList.remove(i);  i--;
                        }
                    }
                }else{
                    for(int i=0;i<yrRegCheckList.size();i++){
                        if(yrRegCheckList.get(i).getYear()<estYear){
                            yrRegCheckList.remove(i);  i--;
                        }
                    }
                }
            }
        }
        return yrRegCheckList;
    }


    /**
     * 描述：用以区分 企业 农专 个体户判断
     * @author: wangjin
     * @param midBaseInfoDto
     * @return
     * @throws Exception
     */
    private  List<YrRegCheck> regCheckList(MidBaseInfoDto midBaseInfoDto) throws Exception {
        List<YrRegCheck> yrRegCheckList = null;
        String priPID=midBaseInfoDto.getPriPID();//身份主体代码
        //判断当前企业是否是个体户
        if(midBaseInfoDto.getEntTypeCatg().equals(Constants.entTypeCatgPB)){
            yrRegCheckList = yrRegCheckService.doGetYrRegCheckInit(priPID);
            for(int i=0;i<yrRegCheckList.size();i++){
                if(yrRegCheckList.get(i).getYear()<2015){ // 个体户从15年开始展示
                    yrRegCheckList.remove(i);  i--;
                }
            }
        }else if(Constants.entTypeCatgSFC.indexOf(midBaseInfoDto.getEntTypeCatg())!=-1){
            yrRegCheckList = yrRegCheckService.doGetYrRegCheckInit(priPID);
            for(int i=0;i<yrRegCheckList.size();i++){
                if(yrRegCheckList.get(i).getYear()<2014){  //农专从14年开始展示
                    yrRegCheckList.remove(i);  i--;
                }
            }
        }else{
            yrRegCheckList = yrRegCheckService.doGetYrRegCheckInit(priPID);
        }
        return yrRegCheckList;
    }


    /**
     * 年报模板列表页面
     * @author wangjin
     * @return
     * @throws Exception
     */
    @RequestMapping("/yearrport_template")
    public ModelAndView template(HttpSession session)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        //获取session的企业基本信息
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
        String priPID=midBaseInfoDto.getPriPID();//身份主体代码
        List<YrRegCheck> yrRegCheckList = regCheckList(midBaseInfoDto);
        modelAndView.addObject("pripid",priPID);
        modelAndView.addObject("yrRegCheckList",yrRegCheckList);
        modelAndView.setViewName("reg/client/yearrport_template");
        return modelAndView;
    }


    /**
     * 描述 ： 判断是否需要填写食品仓储备案表
     * @author yujingwei
     * @date 2016-9-24
     * @param midBaseInfoDto
     * @return boolean
     * @throws Exception
     */
    private boolean doVerifyFoodstorage(MidBaseInfoDto midBaseInfoDto) throws Exception{
     /* 1.具有“食品仓储”标签企业；
   	 	2.所属杭州地区(不用了)
    	*/
    	if(!foodstorageBaseService.doJudgeIsFoodStorageEnt(midBaseInfoDto.getPriPID())){
    		return false;
    	}
		return true;
	}

    /**
     * 描述 ： 判断是否需要填写个转企调查表
     * @author yujingwei
     * @date 2016-9-24
     * @param midBaseInfoDto
     * @return boolean
     * @throws Exception
     */
    private boolean doVerifyQuestionaire(MidBaseInfoDto midBaseInfoDto) throws Exception {
     /* 1.准入系统中有“个转企”标识的企业；
   	 	2.个体户成立日期时长在“个转企”时点前已≥12个月；
   	 	3.企业由“个转企”时点到当前填表时已≥12个月。
   	 	4.所属杭州地区
    	*/
    	if(midBaseInfoDto.getLocalAdm() !=null
    			&& !midBaseInfoDto.getLocalAdm().substring(0, 4).equals("3301")){
    		return false;
    	}
    	if( "1".equals(midBaseInfoDto.getIsIndivid())
    			&& midBaseInfoDto.getIndividDate() != null
    			&& DateUtil.getBetweenMonths(
						DateUtil.dateToString(midBaseInfoDto.getEstDate(),
								"yyyy-MM-dd HH:mm:ss"), DateUtil.dateToString(
										midBaseInfoDto.getIndividDate(),
								"yyyy-MM-dd HH:mm:ss")) >= 12
				&& DateUtil.getBetweenMonths(DateUtil.dateToString(
						midBaseInfoDto.getIndividDate(),
						"yyyy-MM-dd HH:mm:ss"), DateUtil.dateToString(
						new Date(), "yyyy-MM-dd HH:mm:ss")) >= 12){
    		return true;
    	}
		return false;
	}


}