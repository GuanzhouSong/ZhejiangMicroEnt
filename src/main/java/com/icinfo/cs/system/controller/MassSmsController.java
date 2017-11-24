package com.icinfo.cs.system.controller;

import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.impl.MidBaseInfoServiceImpl;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.model.YrOtherInfo;
import com.icinfo.cs.yr.service.IYrOtherInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hzhb on 2016/11/24.
 */
@Controller
@RequestMapping("reg/server/masssms")
public class MassSmsController  extends BaseController {


    @Autowired
    private ISmsService smsService;
    @Autowired
    private IPanoramaSearchService panoramaSearchService;
    @Autowired
    IPubEppasswordService pubEppasswordService;
    @Autowired
    IYrOtherInfoService yrOtherInfoService;
    @Autowired
    IMidBaseInfoService midBaseInfoService;



    @RequestMapping("/tomasssms")
    public ModelAndView tomasssms() throws Exception{
        ModelAndView view  = new ModelAndView("reg/server/masssms/masssms_list");
        return view;
    }

    @RequestMapping("/tomasssmsedit")
    public ModelAndView tomasssmsedit(String priPID,String tel,String liatel,HttpSession session) throws Exception{
        ModelAndView view  = new ModelAndView("reg/server/masssms/masssms_edit");
        if(priPID==null||tel==null||liatel==null)return view;
        String[] _priPID = priPID.split(",");
        String[] _tel = tel.split(",");
        String[] _liatel = liatel.split(",");
        String entname = "";
        String regorg="";
        List<Map> masslist = new ArrayList<>();
        for (int i=0;i<_priPID.length;i++){
            MidBaseInfo midBaseInfo =  midBaseInfoService.selectByPripid(_priPID[i]);
            Map masssmsobj = new HashedMap();
            masssmsobj.put("entname",midBaseInfo.getEntName());
            masssmsobj.put("tel",_tel[i]/*.equals("-")?"":_tel[i]*/);
            masssmsobj.put("liatel",_liatel[i]/*.equals("-")?"":_liatel[i]*/);
            entname+=","+midBaseInfo.getEntName();
            regorg+=","+(StringUtil.isEmpty(midBaseInfo.getRegOrg())?"-":midBaseInfo.getRegOrg());
            masslist.add(masssmsobj);
        }
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        view.addObject("uname",sysUser.getRealName());
        view.addObject("dept",sysUser.getDepartMent()==null?"":sysUser.getDepartMent().getDeptName());
        view.addObject("now",new Date());
        view.addObject("masslist",masslist);
        view.addObject("entsize",_priPID.length);
        view.addObject("entname",entname.length()>0?entname.substring(1):"");
        view.addObject("regorg",regorg.length()>0?regorg.substring(1):"");
        view.addObject("tel",tel);
        view.addObject("liatel",liatel);
        return view;
    }

    /**
     * 把索引的数据进行处理取电话
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/ent.json")
    @ResponseBody
    public PageResponse<PanoramaResultDto> againList(PageRequest request) throws Exception {
        Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
        String year="";
        if(request.getParams()!=null){
            year= (String) request.getParams().get("yrYear");
        }

        if(data==null) return new PageResponse<PanoramaResultDto>(data);
        for (PanoramaResultDto dto : data){
            String tel="";
            String liaTel="";
            String pripid = dto.getPriPID();

            /**
             * - 联络员信息表
             * -- CS_PUB_EPPASSWORD
             */
            PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(pripid);
            if(pubEppassword!=null&&StringUtil.isNotEmpty(pubEppassword.getLerepphone())){
                tel = pubEppassword.getLerepphone();
            }
            if(pubEppassword!=null&&StringUtil.isNotEmpty(pubEppassword.getTel())){
                liaTel = pubEppassword.getTel();
            }
            /**
             * 3.4.4企业年报其他情况表
             * -- CS_YR_OTHERINFO
             */
            YrOtherInfo yrOtherInfo=new YrOtherInfo();
            if(StringUtil.isEmpty(tel)){
                int yrYear = LocalDate.now().getYear();
                if(request.getParams()!=null&&StringUtil.isNotEmpty((String) request.getParams().get("yrYear"))){
                    yrYear=Integer.valueOf((String) request.getParams().get("yrYear"));
                }
                 yrOtherInfo = yrOtherInfoService.selectByYearAndPripid(yrYear,pripid);
                if(yrOtherInfo!=null&&StringUtil.isNotEmpty(yrOtherInfo.getLeRepPhone())){
                    tel = yrOtherInfo.getLeRepPhone();
                }
            }
            if(StringUtil.isEmpty(liaTel)){
                if(yrOtherInfo!=null&&StringUtil.isNotEmpty(yrOtherInfo.getLiaPhone())){
                    liaTel = yrOtherInfo.getLiaPhone();
                }
            }
            /**
             * 准入系统登记表
             */
            if(StringUtil.isEmpty(tel)){
                tel = dto.getTel();
            }
            if(StringUtil.isEmpty(liaTel)){
                liaTel = dto.getLiaTel();
            }
            dto.setTel(tel);
            dto.setLiaTel(liaTel);
            dto.setSpotYear(year);
            try {
                Class c = Class.forName("com.icinfo.cs.es.dto.PanoramaResultDto");
                Method m_getYrLiaConfirm = c.getMethod("getYrLiaConfirm" + year);
                Method m_getYrIsRep = c.getMethod("getYrIsRep" + year);
                Method m_getYrRepState = c.getMethod("getYrRepState" + year);
//                dto.setYrLiaConfirm2013(m_getYrLiaConfirm==null||m_getYrLiaConfirm.invoke(dto)==null?"":(String) m_getYrLiaConfirm.invoke(dto));
                dto.setYrIsRep2013(m_getYrIsRep==null||m_getYrIsRep.invoke(dto)==null?"":(String) m_getYrIsRep.invoke(dto));
                dto.setYrRepState2013(m_getYrRepState==null||m_getYrRepState.invoke(dto)==null?"":(String) m_getYrRepState.invoke(dto));

            }catch (Exception e){

            }/*finally {

            }*/

             }
        
        return new PageResponse<PanoramaResultDto>(data);
    }

    /**
     *
     * @param smscontent 内容
     * @param send 发送对象
     * @param tel 电话
     * @param liatel 联络员电话
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/sendsms")
    @ResponseBody
    public AjaxResult sendsms(String smscontent, String send,String tel, String liatel,String regorg)throws Exception{
        if(send ==null)   return AjaxResult.success("发送失败，请选择发送对象");
        String alltel = "";
        smscontent = smscontent.replace(",","，");
        if(send.indexOf("0")>-1){
            alltel+=tel+",";
        }
        if(send.indexOf("1")>-1){
            alltel+=liatel+",";
        }
        String[] alltelArr = alltel.split(",");
        String[] regorgArr = regorg.split(",");
        for(int i=0;i<alltelArr.length;i++){
            if(StringUtil.isEmpty(alltelArr[i])||alltelArr[i].equals("-")) continue;
            String[] _t = alltelArr[i].split(" ");
            String _regorg = regorgArr[i];
            for(String det:_t){
                if(StringUtil.isEmpty(det)) continue;
                    System.out.println("电话："+det+";内容："+smscontent);
                     smsService.doSendMsg(det, smscontent,_regorg);//发短信
            }

        }
        return AjaxResult.success("发送成功");
    }

}
