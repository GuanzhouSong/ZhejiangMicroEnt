/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.writ.controller.server;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.writ.dto.WritCountDto;
import com.icinfo.cs.writ.dto.WritDto;
import com.icinfo.cs.writ.dto.WritParams;
import com.icinfo.cs.writ.model.Dzhz;
import com.icinfo.cs.writ.model.Dzqz;
import com.icinfo.cs.writ.model.Writ;
import com.icinfo.cs.writ.service.IDzhzService;
import com.icinfo.cs.writ.service.IDzqzService;
import com.icinfo.cs.writ.service.IWritService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_writ 对应的Controller类.  企业联连 文书 <br>
 *
 * @author framework generator
 * @date 2017年06月06日
 */
@Controller
@RequestMapping("/reg/server/writ")
public class WritServerController extends BaseController {

    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WritServerController.class);
    @Autowired
    private IWritService writService;
    @Autowired
    private IMidBaseInfoService midBaseInfoService;
    @Autowired
    private IPubPbopanomalyService pubPbopanomalyService;
    @Autowired
    private IPubOpaDetailService pubOpaDetailService;
    @Autowired
    IExpSeriousCrimeListService expSeriousCrimeListService;
    @Autowired
    IPubEppasswordService pubEppasswordService;
    @Autowired
    private IDzhzService dzhzService;
    @Autowired
    private IDzqzService dzqzService;
    @Autowired
    private IPubOpanoMalyService pubOpanoMalyService;


    /**
     * 显示列表页面
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView view = new ModelAndView("reg/server/writ/writ_server_list");
        view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
        return  view;
    }


    /**
     * 描述：获取企业文书列表
     * @author:wangjin
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list_json"})
    @ResponseBody
    public PageResponse<WritDto> list_json(PageRequest request)throws  Exception{
        List<WritDto> data = writService.search_result(request);
        return  new PageResponse<WritDto>(data);
        /*
         jdk1.8 新特性 TODO
         writNum = datas.stream().count(); //文书条数
         lookNum =  datas.stream().filter(data -> "1".equals(data.getMessageLookStatue())).count(); //查阅条数
         notLookNum = writNum-lookNum;//未查阅条数
         */
    }

    /**
     * 描述：根据统计条件进行查询
     * @author:wangjin
     * @return
     */
    @RequestMapping("/writCount")
    @ResponseBody
    public AjaxResult WritCount(PageRequest request){
        WritCountDto writCountDto = writService.search_countResult(request);
        return  AjaxResult.success("",writCountDto);
    }


/************************************************* 文书详情页面 start *************************************************************************/

    /**
     * 描述：文书回执详情
     * @author: wangjin
     * @param priPID
     * @param uuid
     * @param noticePeople 联络员
     * @param tel  联系电话
     * @return
     */
    @RequestMapping("/writDetails")
    public ModelAndView writDetails(String priPID,String noticePeople,String tel,String uuid) throws Exception {
        ModelAndView view = new ModelAndView("reg/server/writ/writ_server_tab");

        MidBaseInfoDto midBaseInfo = null;
        //当前企业所有的文书
        List<Writ> writList = null;
        //当前企业未回执的文书
        List<String> notReceiveList = null;

        //业务代码
        if (StringUtils.isNotBlank(priPID)) {
            midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
            //检查企业是否是异常名录
            view.addObject("isOpanomaly", checkIsOpanomaly(midBaseInfo.getEntTypeCatg(), midBaseInfo.getPriPID()));

            writList = writService.selectByPripidList(priPID);
            if (writList != null) {
                notReceiveList = new ArrayList<>();
                for (Writ writ : writList) {
                    if ("0".equals(writ.getWritReceiveStatue())) {
                        //添加未回执的的文书
                        notReceiveList.add(writ.getWritName());
                    }
                }
            }
        }
        //当前选中的对象获取值
        if (StringUtils.isNotBlank(uuid)) {
            Writ writ = writService.selectByUUID(uuid);
            view.addObject("writ", writ);
        }

        view.addObject("midBaseInfo", midBaseInfo);
        view.addObject("writList", writList);
        view.addObject("notReceiveList", notReceiveList);
        view.addObject("noticePeople", noticePeople);
        view.addObject("tel", tel);

        return view;
    }

    /**
     * 查看详情页面
     * @author: wangjin
     * @return
     */
    @RequestMapping("/promptly_writ")
    @ResponseBody
    public ModelAndView promptly(WritParams writParams) throws UnsupportedEncodingException {
        ModelAndView view = new ModelAndView("reg/server/writ/promptly_server_writ");
        PubEppassword pubEppassword = null;
        Dzhz dzhz = null;
        Dzqz dzqz = null;
        if(StringUtils.isNotBlank(writParams.getUuid())&&StringUtils.isNotBlank(writParams.getPriPID())){
            //获取联络员信息
            pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(writParams.getPriPID());
            //获取电子回执
            dzhz =dzhzService.selectbyWritUuid(writParams.getUuid());
            //获取电子签章
            dzqz = dzqzService.selectbyWritUuid(writParams.getUuid());
        }
        view.addObject("dzhz",dzhz);//电子回执
        view.addObject("dzqz",dzqz);//电子签章

        //获取不同类型的决定书
        try {
            view = writService.getChooseWritData(view,writParams.getUuid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取系统时间
        String sysDate = DateUtil.getCurrentDate();
        view.addObject("sysDate",sysDate); //系统时间
        view.addObject("writParams",writParams);

        //判断联络信息是否为空
        if(pubEppassword!=null&&StringUtils.isNotBlank(pubEppassword.getLiaidnum())&&StringUtils.isNotBlank(pubEppassword.getTel())){
            view.addObject("lianname",pubEppassword.getLianame());//联络员姓名
            view.addObject("tel",pubEppassword.getTel());//联络员电话号码
        }
        return  view;
    }



    /**
     * 描述：根据uuid获取当前对象值
     * @author:wangjin
     * @param uuid
     * @return
     */
    @RequestMapping("/getWritData")
    @ResponseBody
    public AjaxResult getWritData(String uuid) {
        Writ writ = writService.selectByUUID(uuid);
        if (writ != null) {
            return AjaxResult.success("获取数据成功", writ);
        } else {
            return AjaxResult.error("获取数据失败");
        }

    }

/************************************************* 文书详情页面 ens *************************************************************************/

        /**
         * 检查企业是否是异常名录
         * @param entTypeCatg
         * @param priPID
         * @return
         * @throws Exception
         */
    private String checkIsOpanomaly(String entTypeCatg, String priPID) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("priPID", priPID);
        String opanomaly = "0";
        String seriousCrime = "0";
        if ("50".equals(entTypeCatg)) {
            List<PubPbopanomalyDto> dataList = pubPbopanomalyService.pubPbopanomalySearchRecoverList(map);
            if (dataList != null && dataList.size() > 0) {
                opanomaly = "1";
            }
        } else {
            List<PubOpaDetailDto> dataList = pubOpaDetailService.selectAddMoveOutSearch(map);
            if (dataList != null && dataList.size() > 0) {
                opanomaly = "1";
            }
        }
        List<ExpSeriousCrimeList> expSeriousCrimeList = expSeriousCrimeListService
                .selectSeriousCrimeInfoByPriPID(priPID);
        if (expSeriousCrimeList != null && expSeriousCrimeList.size() > 0) {
            seriousCrime = "1";
        }
        // 同时被列入异常和严重违法
        if ("1".equals(opanomaly) && "1".equals(seriousCrime)) {
            return "1";
        } else if ("1".equals(opanomaly) && !"1".equals(seriousCrime)) {// 只列入异常
            return "2";
        } else if (!"1".equals(opanomaly) && "1".equals(seriousCrime)) {// 只列入严重违法
            return "3";
        } else {
            return "0";
        }
    }


}