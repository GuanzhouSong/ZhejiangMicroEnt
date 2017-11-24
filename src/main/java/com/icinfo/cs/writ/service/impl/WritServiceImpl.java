/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.writ.service.impl;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.constant.WritTypeEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.opanomaly.model.PubOpaDetail;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.writ.dto.WritCountDto;
import com.icinfo.cs.writ.dto.WritDto;
import com.icinfo.cs.writ.mapper.WritMapper;
import com.icinfo.cs.writ.model.Writ;
import com.icinfo.cs.writ.service.IWritService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_writ 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月06日
 */
@Service
public class WritServiceImpl extends MyBatisServiceSupport implements IWritService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WritServiceImpl.class);

    @Autowired
    private WritMapper writMapper;

    @Autowired
    private IPubEppasswordService pubEppasswordService;

    //列入异常名录
    @Autowired
    private IPubOpanoMalyService pubOpanoMalyService;

    //移出或撤销
    @Autowired
    private IPubOpaDetailService pubOpaDetailService;


    /**
     * 描述：获取企业文书列表 client
     * @author:wangjin
     * @param request
     * @return
     */
    @Override
    public List<WritDto> select_queryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        Map<String, Object> searchMap=  request.getParams();
        if(StringUtil.isNotBlank(searchMap.get("priPID").toString())){
        	searchMap.put("regState", RegStateEnum.CUNXU.getParam());
            return writMapper.selectByPripidAndYear(searchMap);
        }
        return null;
    }

    /**
     * 描述：更新回执时间
     * @param writUuid
     */
    @Override
    public void UpdateReceiveTimeByWritUuid(String writUuid,String receivePeople) {
        if(StringUtil.isNotBlank(writUuid)){
            Example example = new Example(Writ.class);
            Writ writ = new Writ();
            writ.setWritReceiveTime(DateUtil.getSysDate());//更新回执时间
            writ.setWritReceiveStatue("1");//回执状态
            writ.setReceivePeople(receivePeople);//回执人
            example.createCriteria().andEqualTo("uuid",writUuid);
           writMapper.updateByExampleSelective(writ,example);
        }
    }

    /**
     * 描述：查阅状态更新
     * @param uuid
     */
    @Override
    public int UpdateLookStatue(String uuid) {
        if(StringUtil.isNotBlank(uuid)){
            Example example = new Example(Writ.class);
            Writ writ = new Writ();
            writ.setMessageLookStatue("1");//查阅状态
            example.createCriteria().andEqualTo("uuid",uuid);
            return  writMapper.updateByExampleSelective(writ,example);
        }
        return 0;
    }


    /**
     * 描述：根据条件查询获取结果集
     * @author:wangjin
     * @param request
     * @return
     */
    @Override
    public List<WritDto> search_result(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        Map<String, Object> searchMap = request.getParams();
        formateMapParams(searchMap);
        return writMapper.selectByParameters(searchMap);
    }

    /**
     * 描述:根据查询条件统计数据
     * @author:wangjin
     * @param request
     * @return
     */
    @Override
    public WritCountDto search_countResult(PageRequest request) {
        Map<String, Object> searchMap=  request.getParams();
        formateMapParams(searchMap);
        return writMapper.search_countResult(searchMap);
    }


    /**
     * 描述:格式化 参数符合 in 查询的格式
     * @author:wangjin
     * @param maps
     */
    public void formateMapParams(Map<String, Object> maps){
        //主体类别
        if (maps.get("entTypeCatg") != null) {
            maps.put("entTypeCatg", StringUtil.doSplitStringToSqlFormat(maps.get("entTypeCatg").toString(), ","));
        }
        //登记状态
        if (maps.get("regState") != null) {
            maps.put("regState", StringUtil.doSplitStringToSqlFormat(maps.get("regState").toString(), ","));
        }
        //登记机关
        if (maps.get("regOrg") != null) {
            maps.put("regOrg", StringUtil.doSplitStringToSqlFormat(maps.get("regOrg").toString(), ","));
        }
        //片区
        if (maps.get("sliceNO") != null) {
            maps.put("sliceNO", StringUtil.doSplitStringToSqlFormat(maps.get("sliceNO").toString(), ","));
        }
        //管辖单位
        if (maps.get("localAdm") != null) {
            maps.put("localAdm", StringUtil.doSplitStringToSqlFormat(maps.get("localAdm").toString(), ","));
        }
    }

    /**
     * 描述：根据pripid 查询当前企业的文书
     * @author：wangjin
     * @param priPID
     * @return
     */
    @Override
    public List<Writ> selectByPripidList(String priPID) {
        Example example = new Example(Writ.class);
        if(StringUtils.isNotBlank(priPID)){
            example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID);
            return writMapper.selectByExample(example);
        }
        return null;
    }

    /**
     * 描述：获取当前对象值
     * @author: wangjin
     * @param uuid
     * @return
     */
    @Override
    public Writ selectByUUID(String uuid) {
        if(StringUtils.isNotBlank(uuid)){
            Writ writ = new Writ();
            writ.setUuid(uuid);
            return writMapper.selectOne(writ);
        }
        return null;
    }

    /**
     * 描述：添加文书内容  map 参数
     * @author: wangjin
     * @param map
     * TODO  文书类型的设置使用枚举中的方法：如（WritTypeEnum.WRIT_TYPE_XingZheng.getType()//行政指导书类型）
     */
    @Override
    public void addWritByMap(Map<String, Object> map) {
        if(map!=null){
            Writ writ = new Writ();
            writ.setYear(Integer.valueOf((Integer) map.get("year"))); //年份
            writ.setPriPID((String) map.get("priPID"));              //主体身份代码(CA14)
            writ.setWritNo((String) map.get("writNo"));              //文号
            writ.setWritType((String) map.get("writType"));          //文书类型
            writ.setWritName((String) map.get("writName"));          //文书名称
            writ.setNoticePeople((String) map.get("noticePeople"));  //通知对象  联络员
            writ.setTel((String) map.get("tel"));                    //通知对象 联系方式
            writ.setMessageLookStatue("0");                 //查阅状态：0 未查阅  1已查阅
            writ.setWritReceiveStatue("0");                 //未回执
            writ.setInformNum(0);                           //催告次数
            writ.setWritKeyID((String) map.get("writKeyID"));        //文书关联主键  决定书
            writ.setCreateTime(DateUtil.getSysDate());      //创建时间
            writMapper.insert(writ);
        }


    }

    /**
     * 描述：添加文书内容 对象参数
     * @author: wangjin
     * @param writ
     *
     * 调用接口时候需要引入和传入的值：
     *
     *  @Autowired
     *  private IWritService writService;
     *
     *  writService.addWrit(new Writ("内部序号","文书文号","文书类型","决定书主键","年份"));  //没有年报的 传入 null值
     *
     *  TODO  注意点：文书类型： 文书类型的设置使用枚举中的方法：如（WritTypeEnum.WRIT_TYPE_XingZheng.getType()//行政指导书类型）
     *
     *  TODO  最后麻烦把  根据决定书查询的方法接口提供给我一下！  如：列入经营异常名录决定书 pubOpanoMalyService.selectPubOpanoMalyByBusExcList(writ.getWritKeyID())
     *
     *
     *
     */
    @Override
    public void addWrit(Writ writ) {
        if(writ!=null){
            writ.setWritType(writ.getWritType());           //文书类型
            writ.setWritName(WritTypeEnum.getValue(writ.getWritType())); //文书名称
            writ.setMessageLookStatue("0");                 //查阅状态：0 未查阅  1已查阅
            writ.setWritReceiveStatue("0");                 //未回执
            writ.setInformNum(0);                           //催告次数
            writ.setCreateTime(DateUtil.getSysDate());      //创建时间
            //添加联络员信息：
            PubEppassword pubEppassword= pubEppasswordService.selectPubEppasswordByPriPid(writ.getPriPID());
            if(pubEppassword!=null&&StringUtils.isNotBlank(pubEppassword.getLianame())&&StringUtils.isNotBlank(pubEppassword.getTel())){
                writ.setNoticePeople(pubEppassword.getLianame()); //通知对象
                writ.setTel(pubEppassword.getTel());              //通知对象联系方式
            }
            writMapper.insert(writ);
        }
    }


    /**
     * @描述: 判断 文书的类型显示
     * @author：wangjin
     * @date:  2017-06-29
     * @param view
     * @param uuid
     * @return
     */
    /*
        PubOpaDetailController.java (移除和撤销)  方法：opadetailAuditCommit  添加文书
        方法：
        pubOpanoMalyService.selectPubOpanoMalyByBusExcList(writ.getWritKeyID())
        pubOpaDetailService.selectPubOpaDetailByBusExcList(writ.getWritKeyID(),writ.getPriPID())
        是查询决定书

        PubOpanoMalyServiceImpl.java( 列入 ) 方法：commitAuditPubOpanoMaly  添加文书
        方法：
        pubOpanoMalyService.selectPubOpanoMalyByBusExcList(writ.getWritKeyID())
    */
    @Override
    public ModelAndView getChooseWritData(ModelAndView view, String uuid) throws Exception {
        if (StringUtils.isNotBlank(uuid)) {

            Writ writ = selectByUUID(uuid);

            //列入异常名录
            PubOpanoMaly pubOpanoMaly = null;

            //列入或撤销 异常名录
            PubOpaDetail pubOpaDetail = null;

            if (writ != null && StringUtils.isNotBlank(writ.getWritType())) {
                switch (writ.getWritType()) {
                    //行政指导书
                    case "1":
                        view.addObject("", "");
                        view.addObject("typeMark", "1");
                        //责令整改书
                    case "2":
                        view.addObject("", "");
                        view.addObject("typeMark", "2");
                        break;
                    //抽查检查通知书
                    case "3":
                        view.addObject("", "");
                        view.addObject("typeMark", "3");
                        break;
                    //列入经营异常名录决定书
                    case "4":
                        view.addObject("pubOpanoMaly", pubOpanoMalyService.selectPubOpanoMalyByBusExcList(writ.getWritKeyID()));
                        view.addObject("typeMark", "4");
                        break;
                    //移出经营异常名录决定书
                    case "5":
                        view.addObject("pubOpaDetail", pubOpaDetailService.selectPubOpaDetailByBusExcList(writ.getWritKeyID(), writ.getPriPID()));
                        view.addObject("pubOpanoMaly", pubOpanoMalyService.selectPubOpanoMalyByBusExcList(writ.getWritKeyID()));
                        view.addObject("typeMark", "5");
                        break;
                    //撤销列入经营异常名录决定书
                    case "6":
                        view.addObject("pubOpaDetail", pubOpaDetailService.selectPubOpaDetailByBusExcList(writ.getWritKeyID(), writ.getPriPID()));
                        view.addObject("pubOpanoMaly", pubOpanoMalyService.selectPubOpanoMalyByBusExcList(writ.getWritKeyID()));
                        view.addObject("typeMark", "6");
                        break;
                    default:
                        break;
                }
            }
        }
        return view;
    }

}