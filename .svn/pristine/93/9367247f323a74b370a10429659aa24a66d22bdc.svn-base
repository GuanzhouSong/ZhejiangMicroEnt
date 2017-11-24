/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.registinfo.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.base.model.CodeAddress;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.mainmark.service.IMainMarkRelService;
import com.icinfo.cs.registinfo.dto.RegistMarkDto;
import com.icinfo.cs.registinfo.mapper.RegistMarkMapper;
import com.icinfo.cs.registinfo.model.PubApprMarkRel;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.registinfo.model.RegistMarkHis;
import com.icinfo.cs.registinfo.service.IPubApprMarkRelService;
import com.icinfo.cs.registinfo.service.IRegistMarkHisService;
import com.icinfo.cs.registinfo.service.IRegistMarkService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_regist_mark 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class RegistMarkServiceImpl extends MyBatisServiceSupport implements IRegistMarkService {

    @Autowired
    private RegistMarkMapper      registMarkMapper;

    @Autowired
    private IMainMarkRelService   mainMarkRelService;

    @Autowired
    private IRegistMarkHisService registMarkHisService;
    //最终标签标记表
    @Autowired
    private IPubApprMarkRelService pubApprMarkRelService;

    @Override
    public List<RegistMark> queryPageList(PageRequest request){
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        Map<String, Object> queryMap = request.getParams ();
        String IDType = StringUtil.doSplitStringToSqlFormat (queryMap.get ("IDType").toString (), ",");
        String setDeptCode = StringUtil.doSplitStringToSqlFormat (queryMap.get ("setDeptCode").toString (), ",");
        queryMap.put ("IDType", IDType);
        queryMap.put ("setDeptCode", setDeptCode);
        return registMarkMapper.queryPageList (queryMap);
    }

    @Override
    public boolean checkRegistMarkByNameIDName(String IDName){
        if (StringUtil.isNotBlank (IDName)) {
            IDName = IDName.trim ();
            Example example = new Example (CodeAddress.class);
            Example.Criteria criteria = example.createCriteria ();
            criteria.andEqualTo ("IDName", IDName);
            List<RegistMark> list = registMarkMapper.selectByExample (example);
            if (null != list && list.size () > 0) { return true; }
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(RegistMark registMark){
        // Integer id = registMark.getId();

        if (com.icinfo.framework.mybatis.mapper.util.StringUtil.isNotEmpty (registMark.getMarkUuid ())) {// 修改
            registMark.setUpdateTime (new SimpleDateFormat ("yyyy-MM-dd").format (new Date ()));
            registMarkMapper.updateByMarkUuid (registMark);
        } else {// 新增
            String idType = registMark.getIDType ();
            String pIDCode = registMark.getIDCode ();
            String maxIDCode = queryMaxIDCodeByLength (idType, pIDCode);
            String IDCode = "";
            if ("1".equals (idType)) {// 大类
                if (StringUtil.isNotBlank (maxIDCode)) {
                    if (!"Z".equals (maxIDCode)) {
                        Character charIDCode = ++maxIDCode.toCharArray ()[0];
                        IDCode = charIDCode.toString ();
                    }

                } else {// 第一次录入大类
                    IDCode = "A";
                }
            } else if ("2".equals (idType)) {// 中类
                if (StringUtil.isNotBlank (maxIDCode)) {
                    String codeE = maxIDCode.substring (1, 4);
                    if (!"999".equals (codeE)) {
                        Integer num = Integer.parseInt (codeE) + 1;
                        String strNum = num.toString ();
                        if (strNum.length () == 1) {
                            IDCode = pIDCode + "00" + strNum;
                        } else if (strNum.length () == 2) {
                            IDCode = pIDCode + "0" + strNum;
                        } else {
                            IDCode = pIDCode + strNum;
                        }
                    }
                } else {// 第一次录入
                    IDCode = pIDCode + "001";
                }
            } else if ("3".equals (idType)) {// 小类
                if (StringUtil.isNotBlank (maxIDCode)) {
                    String codeE = maxIDCode.substring (4, 6);
                    if (!"99".equals (codeE)) {
                        Integer num = Integer.parseInt (codeE) + 1;
                        String strNum = num.toString ();
                        if (strNum.length () == 1) {
                            IDCode = pIDCode + "0" + strNum;
                        } else {
                            IDCode = pIDCode + strNum;
                        }
                    }
                } else {// 第一次录入
                    IDCode = pIDCode + "01";
                }
            }
            registMark.setCreateTime (new Date ());
            registMark.setIDStateCode ("1");
            registMark.setAuditState ("1");
            registMark.setMarkUuid (StringUtil.uuid ());
            registMark.setIDCode (IDCode);
            registMarkMapper.insert (registMark);
        }

    }

    @Override
    public void deleteById(Integer id){
        registMarkMapper.deleteByPrimaryKey (id);
    }

    @Override
    public List<RegistMark> queryChildListByParentCode(String IDCode){
        if (StringUtil.isNotBlank (IDCode)) {
            Example example = new Example (CodeAddress.class);
            Example.Criteria criteria = example.createCriteria ();
            criteria.andLike ("IDCode", IDCode + "%");
            List<RegistMark> list = registMarkMapper.selectByExample (example);
            return list;
        }
        return null;
    }

    /**
     * @throws Exception 
     * 
     * 描述   分页查询标签审核列表
     * @author  赵祥江
     * @date 2017年3月22日 下午7:06:15 
     * @param  
     * @throws
     */
    @Override
    public List<RegistMarkDto> queryRegistMarkAuditJSONList(PageRequest request) throws Exception{
        Map<String, Object> queryMap = request.getParams ();
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        String IDType = StringUtil.doSplitStringToSqlFormat (queryMap.get ("IDType").toString (), ",");
        String setDeptCode = StringUtil.doSplitStringToSqlFormat (queryMap.get ("setDeptCode").toString (), ",");
        queryMap.put ("IDType", IDType);
        queryMap.put ("setDeptCode", setDeptCode);
        return registMarkMapper.selectRegistMarkAuditList (queryMap);
    }

    @Override
    public String queryMaxIDCodeByLength(String IDType,String IDCode){
        Map<String, Object> map = new HashMap<String, Object> ();
        if ("1".equals (IDType)) {// 大类
            map.put ("length", 1);
            map.put ("IDCode", "_");
        } else if ("2".equals (IDType)) {// 中类
            map.put ("length", 4);
            map.put ("IDCode", IDCode + "___");
        } else if ("3".equals (IDType)) {// 小类
            map.put ("length", 6);
            map.put ("IDCode", IDCode + "__");
        }
        return registMarkMapper.queryMaxIDCodeByLength (map);
    }

    /** 
     * 描述: 根据类型、父级code获取所有标签列表
     * @author 张文男
     * @date 2017年3月23日 
     * @param IDType
     * @return 
     */
    @Override
    public List<RegistMark> queryListByIDType(String IDType,String pIDCode){
        Map<String, String> map = new HashMap<String, String> ();
        if ("1".equals (IDType)) {// 大类
            map.put ("IDCode", "_");
        } else if ("2".equals (IDType)) {// 中类
            map.put ("IDCode", pIDCode + "___");
        } else if ("3".equals (IDType)) {// 小类
            map.put ("IDCode", pIDCode + "__");
        }
        return registMarkMapper.queryListLikeIDCode (map);
    }

    /** 
     * 描述:  根据标签名称模糊查询列表
     * @author 张文男
     * @date 2017年3月23日 
     * @param IDName
     * @return 
     */
    @Override
    public List<RegistMark> queryListInstrIDName(String IDName,String userType,String setDeptCode,String psetDeptCode){
        Map<String, Object> map = new HashMap<String, Object> ();
        map.put ("IDName", IDName);
        map.put ("userType", userType);
        map.put ("setDeptCode", setDeptCode);
        map.put ("validDate", new Date ());
        map.put ("psetDeptCode", psetDeptCode);
        return registMarkMapper.queryTopListInstrIDName (map);
    }

    /** 
     * 描述: 根据主键获取对象
     * @author 张文男
     * @date 2017年3月23日 
     * @param id
     * @return 
     */

    public RegistMark queryRegistMarkById(Integer id){
        return registMarkMapper.selectByPrimaryKey (id);
    }

    /** 
     * 描述: 根据uuid获取数据
     * @author 张文男
     * @date 2017年3月23日 
     * @param markUuid
     * @return 
     */

    public RegistMarkDto queryBeanByMarkUuid(String markUuid){
        RegistMarkDto registMark = registMarkMapper.queryBeanByMarkUuid (markUuid);
        String setTimeStr = new SimpleDateFormat ("yyyy-MM-dd").format (registMark.getSetTime ());
        registMark.setSetTimeStr (setTimeStr);
        return registMark;
    }

    /** 
     * 描述: 删除
     * @author 张文男
     * @date 2017年3月23日 
     * @param markUuid 
     */

    public void deleteByMarkUuid(String markUuid){
        registMarkMapper.deleteByMarkUuid (markUuid);
    }

    /** 
     * 描述: 删除标签并删除企业与标签绑定关系
     * @author 张文男
     * @date 2017年4月20日 
     * @param markUuid
     * @param markCode 
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteByMarkUuid(String markUuid,String markCode){
        registMarkMapper.deleteByMarkUuid (markUuid);
        mainMarkRelService.deleteBy (markCode, "1", "0");
        registMarkHisService.deleteByIDCode (markCode);
    }

    /**
     * 
     * 描述   根据主键查询
     * @author  赵祥江
     * @date 2017年3月23日 上午11:15:34 
     * @param  
     * @throws
     */
    @Override
    public RegistMark selectRegistMarkBymarkUuid(String markUuid){
        RegistMark registMark = new RegistMark ();
        if (com.icinfo.framework.mybatis.mapper.util.StringUtil.isNotEmpty (markUuid)) {
            registMark.setMarkUuid (markUuid);
            return registMarkMapper.selectOne (registMark);
        }
        return null;
    }

    /**
     * 
     * 描述   根据uid修改
     * @author  赵祥江
     * @date 2017年3月23日 下午7:41:30 
     * @param  
     * @throws
     */
    @Override
    public int UpdateRegistMark(RegistMark registMark){
        try {
            if (registMark != null && StringUtil.isNotEmpty (registMark.getMarkUuid ())) {
                // registMark.setCreateTime(DateUtils.getSysDate());
                Example example = new Example (RegistMark.class);
                example.createCriteria ().andEqualTo ("markUuid", registMark.getMarkUuid ());
                return registMarkMapper.updateByExampleSelective (registMark, example);
            }
        } catch (Exception e) {
            e.printStackTrace ();
            throw new BusinessException ("修改标签失败!");
        }
        return 0;

    }

    /** 
     * 描述: 根据范围CODE获取有效的小类列表
     * @author 张文男
     * @date 2017年3月30日 
     * @param applicationScopeCode
     * @return 
     */
    @Override
    public List<RegistMarkDto> queryValidSubTypeListByApplicationScopeCode(String applicationScopeCode){
        if ("3300".equals (applicationScopeCode)) {// 如果是浙江省则去除00模糊查询
            applicationScopeCode = "33";
        }
        return registMarkMapper.queryValidSubTypeListByApplicationScopeCode (applicationScopeCode);
    }

    @Override
    public List<Map<String, Object>> queryValidSubTypeListByUserInfo(SysUserDto sysUser,String webidname,String priPID) throws Exception{
        return queryValidSubTypeListByUserInfo (sysUser, webidname, priPID, false);
    }

    /** 
     * 描述: 根据code获取标签信息
     * @author 张文男
     * @date 2017年4月19日 
     * @param idcode
     * @return 
     */

    public RegistMarkDto queryByIDCode(String idcode){
        return registMarkMapper.queryByIDCode (idcode);
    }
    
    /** 
     * 描述: 根据code获取标签信息
     * @author 陈鑫
     * @date 2017年4月19日 
     * @param idcode
     * @return 
     */
    @Override
    public RegistMark selectByIDCode(String idcode) {
    	RegistMark registMark = new RegistMark();
    	registMark.setIDCode(idcode);
    	return registMarkMapper.selectOne(registMark);
    }

    /** 
     * 描述: 统计子类标签数量
     * @author 张文男
     * @date 2017年4月20日 
     * @param idcode
     * @return 
     */

    public Long queryCountLikeIDCode(String idcode){
        return registMarkMapper.queryCountLikeIDCode (idcode);
    }

    /** 
     * 描述: 根据父类code获取双随机子类列表 
     * @author 张文男
     * @date 2017年4月21日 
     * @param pcode
     * @return 
     */

    public List<RegistMarkDto> queryDoublyStoListByPcode(String pcode){
        List<RegistMarkDto> list = registMarkMapper.queryDoublyStoListByPcode (pcode);
        return list;
    }

    /** 
     * 描述: 根据code获取双随机3级信息
     * @author 张文男
     * @date 2017年4月21日 
     * @param pcode
     * @return 
     */

    public List<RegistMarkDto> queryDoublyStoThiInfoByCode(String pcode){
        List<RegistMarkDto> list = registMarkMapper.queryDoublyStoThiInfoByCode (pcode);
        return list;
    }

    /**
     * 获取当前标签下的专项库标签
     */
    public List<RegistMark> queryDoublyStoThiInfo(String idCodes){
//        List<String> DoublyStoThiCodes = new ArrayList<String>();
        List<RegistMark> list = new ArrayList<RegistMark>();
        if(StringUtil.isNotEmpty(idCodes)){
            String[] superNo = idCodes.split(",");
            List<String> fieldValues = new ArrayList<String>();
            for (int i = 0; i < superNo.length; i++) {
                if (superNo[i].equals("")) continue;
                fieldValues.add(superNo[i]);
            }
            Example example = new Example (RegistMark.class);        
            example.createCriteria().andEqualTo ("doublyStoState", "1").andIn("IDCode", fieldValues);
        	list = registMarkMapper.selectByExample(example);
//        	if(list != null && list.size() > 0 ){
//        		for( int  i= 0 ;i<list.size();i++){
//            		DoublyStoThiCodes.add(list.get(i).getDoublyStoThiCode());
//        		}
//        	}
    	}
    	return list;
    }

    /** 
     * 描述: 根据用户信息及参数获取选中小类标签
     * @author 张文男
     * @date 2017年4月24日 
     * @param sysUser
     * @param idname
     * @param priPID
     * @param isShowCheckOnly 是否只显示选中小类
     * @return 
     * @throws Exception 
     */

    public List<Map<String, Object>> queryValidSubTypeListByUserInfo(SysUserDto sysUser,String webidname,String priPID,boolean isShowCheckOnly) throws Exception{
        Map<String, String> checkCodeMaps = new HashMap<String, String> ();
        String hasMarkCode = "";
        if (StringUtil.isNotBlank (priPID)) {
            List<PubApprMarkRel> checkList= pubApprMarkRelService.queryListByPripid (priPID);
            //List<MainMarkRelDto> checkList = mainMarkRelService.queryListInPriPIDAndIshis (priPID, "1", "0");
            for ( PubApprMarkRel pubApprMarkRel : checkList ) {
                checkCodeMaps.put (pubApprMarkRel.getMarkCode (), pubApprMarkRel.getMarkCode ());
                if (isShowCheckOnly) {
                    hasMarkCode += "'" + pubApprMarkRel.getMarkCode () + "',";
                }
            }
        }
        Map<String, Object> map = new HashMap<String, Object> ();
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>> ();
        String deptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        String userType = "";
        if (deptCode.equals ("330000")) {// 省局
            userType = "1";
        } else if (deptCode.substring (4, 6).equals ("00")) {// 市局
            userType = "2";
        } else {// 区县局
            userType = "3";
            map.put ("psetDeptCode", deptCode.substring (0, 4) + "00");
        }

        map.put ("idname", webidname);
        map.put ("userType", userType);
        map.put ("validDate", new Date ());
        map.put ("setDeptCode", deptCode);
        map.put ("hasMarkCode", (!"".equals (hasMarkCode) ? hasMarkCode.substring (0, hasMarkCode.length () - 1) : null));

        List<RegistMarkDto> list = registMarkMapper.queryValidSubTypeListByUserInfo (map);

        if (null != list && list.size () > 0) {

            // 默认父节点
            Map<String, Object> dataMap = new LinkedHashMap<String, Object> ();
            dataMap.put ("name", "当前可选标签");
            dataMap.put ("id", "0");
            dataMap.put ("pId", "-1");
            dataMap.put ("nocheck", true);
            listMap.add (dataMap);

            Map<String, Object> codeMap = new LinkedHashMap<String, Object> ();

            for ( RegistMarkDto registMarkDto : list ) {
                String idcode = registMarkDto.getIDCode ();
                String idname = registMarkDto.getIDName ();
                String idcode2 = registMarkDto.getIDCode2 ();
                String idname2 = registMarkDto.getIDName2 ();
                String idcode3 = registMarkDto.getIDCode3 ();
                String idname3 = registMarkDto.getIDName3 ();

                if (!codeMap.containsKey (idcode3)) {
                    codeMap.put (idcode3, idname3);
                    Map<String, Object> dataMap2 = new LinkedHashMap<String, Object> ();
                    dataMap2.put ("name", idcode3 + " " + idname3);
                    dataMap2.put ("id", idcode3);
                    dataMap2.put ("pId", "0");
                    dataMap2.put ("nocheck", true);
                    listMap.add (dataMap2);
                }

                if (!codeMap.containsKey (idcode2)) {
                    codeMap.put (idcode2, idcode2);
                    Map<String, Object> dataMap3 = new LinkedHashMap<String, Object> ();
                    dataMap3.put ("name", idcode2 + " " + idname2);
                    dataMap3.put ("id", idcode2);
                    dataMap3.put ("pId", idcode3);
                    dataMap3.put ("nocheck", true);
                    listMap.add (dataMap3);
                }

                // 只显示选中小类标签
                if (isShowCheckOnly && checkCodeMaps.containsKey (idcode)) {
                    Map<String, Object> dataMap4 = new LinkedHashMap<String, Object> ();
                    dataMap4.put ("name", idcode + " " + idname);
                    dataMap4.put ("id", idcode);
                    dataMap4.put ("pId", idcode2);
                    dataMap4.put ("nocheck", false);
                    dataMap4.put ("chkDisabled", true);
                    dataMap4.put ("checked", checkCodeMaps.containsKey (idcode));
                    listMap.add (dataMap4);
                } else if (!isShowCheckOnly) {
                    Map<String, Object> dataMap4 = new LinkedHashMap<String, Object> ();
                    dataMap4.put ("name", idcode + " " + idname);
                    dataMap4.put ("id", idcode);
                    dataMap4.put ("pId", idcode2);
                    dataMap4.put ("nocheck", false);
                    dataMap4.put ("checked", checkCodeMaps.containsKey (idcode));
                    listMap.add (dataMap4);
                }

            }
        }

        return listMap;
    }
    
    /** 
     * 描述: 根据用户信息及参数获取选中小类标签(户口建档)
     * @author 张文男
     * @date 2017年4月24日 
     * @param sysUser
     * @param idname
     * @param priPID
     * @param isShowCheckOnly 是否只显示选中小类
     * @return 
     */
    public List<Map<String, Object>> queryValidMarkByUserInfo(SysUserDto sysUser,String webidname,String priPID,boolean isShowCheckOnly) throws Exception{
        Map<String, String> checkCodeMaps = new HashMap<String, String> ();
        String hasMarkCode = "";
        if (StringUtil.isNotBlank (priPID)) {
        	//查询当前企业所属标签
        	List<PubApprMarkRel> apprMarkRels = pubApprMarkRelService.queryListByPripid(priPID);
        	
        	for (PubApprMarkRel pubApprMarkRel : apprMarkRels) {
        		checkCodeMaps.put(pubApprMarkRel.getMarkCode(), pubApprMarkRel.getMarkCode());
                if (isShowCheckOnly) {
                    hasMarkCode += "'" + pubApprMarkRel.getMarkCode () + "',";
                }
			}
        	
        }
        Map<String, Object> map = new HashMap<String, Object> ();
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>> ();
        String deptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        String userType = "";
        if (deptCode.equals ("330000")) {// 省局
            userType = "1";
        } else if (deptCode.substring (4, 6).equals ("00")) {// 市局
            userType = "2";
        } else {// 区县局
            userType = "3";
            map.put ("psetDeptCode", deptCode.substring (0, 4) + "00");
        }

        map.put ("idname", webidname);
        map.put ("userType", userType);
        map.put ("validDate", new Date ());
        map.put ("setDeptCode", deptCode);
        map.put ("hasMarkCode", (!"".equals (hasMarkCode) ? hasMarkCode.substring (0, hasMarkCode.length () - 1) : null));

        List<RegistMarkDto> list = registMarkMapper.queryValidSubTypeListByUserInfo (map);

        if (null != list && list.size () > 0) {

            // 默认父节点
            Map<String, Object> dataMap = new LinkedHashMap<String, Object> ();
            dataMap.put ("name", "当前可选标签");
            dataMap.put ("id", "0");
            dataMap.put ("pId", "-1");
            dataMap.put ("nocheck", true);
            listMap.add (dataMap);

            Map<String, Object> codeMap = new LinkedHashMap<String, Object> ();

            for ( RegistMarkDto registMarkDto : list ) {
                //标签code
            	String idcode = registMarkDto.getIDCode ();
            	//标签名
                String idname = registMarkDto.getIDName ();
                //中类
                String idcode2 = registMarkDto.getIDCode2 ();
                String idname2 = registMarkDto.getIDName2 ();
                //大类
                String idcode3 = registMarkDto.getIDCode3 ();
                String idname3 = registMarkDto.getIDName3 ();

                if (!codeMap.containsKey (idcode3)) {//未包含此大类
                    codeMap.put (idcode3, idname3);
                    Map<String, Object> dataMap2 = new LinkedHashMap<String, Object> ();
                    dataMap2.put ("name", idcode3 + " " + idname3);
                    dataMap2.put ("id", idcode3);
                    dataMap2.put ("pId", "0");
                    dataMap2.put ("nocheck", true);
                    listMap.add (dataMap2);
                }

                if (!codeMap.containsKey (idcode2)) {
                    codeMap.put (idcode2, idcode2);
                    Map<String, Object> dataMap3 = new LinkedHashMap<String, Object> ();
                    dataMap3.put ("name", idcode2 + " " + idname2);
                    dataMap3.put ("id", idcode2);
                    dataMap3.put ("pId", idcode3);
                    dataMap3.put ("nocheck", true);
                    listMap.add (dataMap3);
                }

                // 只显示选中小类标签
                if (isShowCheckOnly && checkCodeMaps.containsKey (idcode)) {
                    Map<String, Object> dataMap4 = new LinkedHashMap<String, Object> ();
                    dataMap4.put ("name", idcode + " " + idname);
                    dataMap4.put ("id", idcode);
                    dataMap4.put ("pId", idcode2);
                    dataMap4.put ("nocheck", false);
                    dataMap4.put ("chkDisabled", true);
                    dataMap4.put ("checked", checkCodeMaps.containsKey (idcode));
                    listMap.add (dataMap4);
                } else if (!isShowCheckOnly) { //显示全部标签
                    Map<String, Object> dataMap4 = new LinkedHashMap<String, Object> ();
                    dataMap4.put ("name", idcode + " " + idname);
                    dataMap4.put ("id", idcode);
                    dataMap4.put ("pId", idcode2);
                    dataMap4.put ("nocheck", false);
                    dataMap4.put ("checked", checkCodeMaps.containsKey (idcode));
                    listMap.add (dataMap4);
                }

            }
        }
        return listMap;
    }
    
    
    
    
    
    

    /** 
     * 描述: 获取标签信息(用于专项库查询)
     * @author yujingwei
     * @date 2017年4月19日 
     * @param Code
     * @return List<RegistMark>
     */
    public List<RegistMark> doGetRegistMarkInfoForDrcheck(String pCode) throws Exception{
        Example example = new Example (RegistMark.class);
        example.createCriteria ().andEqualTo ("doublyStoThiCode", pCode).andEqualTo ("auditState", "2").andEqualTo ("IDStateCode", "1");
        return registMarkMapper.selectByExample (example);
    }

    /** 
     * 描述: 根据markuuid获取双随机第三级专项库code及标签基本信息
     * @author 张文男
     * @date 2017年4月25日 
     * @param markUuid
     * @return 
     */
    public List<RegistMark> queryListByMarkUuid(String markUuid){
        List<RegistMark> list = registMarkMapper.queryListByMarkUuid (markUuid);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void audit(SysUserDto sysUser, Map<String, String> registMap) throws Exception{
        RegistMark registMark = new RegistMark ();
        // 主键
        String uid = registMap.get ("markUuid").toString ();
        // 审核意见
        String auditorDesc = registMap.get ("auditorDesc").toString ();
        // 审核状态
        String auditState = registMap.get ("auditState").toString ();
        // 获取审核对象
        RegistMark registMarkTem = selectRegistMarkBymarkUuid (uid);
        // 变更审核提交 插入历史表数据
        if ("2".equals (auditState)) {
            RegistMarkHis registMarkHisTem = new RegistMarkHis ();
            registMarkHisTem.setMarkUuid (null);
            registMarkHisTem.setAuditState (auditState);
            // registMark.setIDStateCode(registMarkTem.getIDStateCode());
            registMarkHisTem.setSetName (registMarkTem.getSetName ());
            registMarkHisTem.setIDCode (registMarkTem.getIDCode ());
            registMarkHisTem.setIDName (registMarkTem.getIDName ());
            registMarkHisTem.setCreateTime (DateUtil.getSysDate ());
            registMarkHisTem.setSetTime (registMarkTem.getSetTime ());
            registMarkHisTem.setSetDeptname (registMarkTem.getSetDeptname ());
            registMarkHisTem.setIDType (registMarkTem.getIDType ());
            registMarkHisTem.setIDDesc (registMarkTem.getIDDesc ());
            registMarkHisTem.setIDStateCode (registMarkTem.getIDStateCode ());
            registMarkHisTem.setApplicationScopeCode (registMarkTem.getApplicationScopeCode ());
            registMarkHisTem.setApplicationScopeName (registMarkTem.getApplicationScopeName ());
            registMarkHisTem.setAuditorDesc (auditorDesc);
            registMarkHisTem.setValidDate (registMarkTem.getValidDate ());
            registMarkHisTem.setDoublyStoState (registMarkTem.getDoublyStoState ());
            registMarkHisTem.setDoublyStoFirCode (registMarkTem.getDoublyStoFirCode ());
            registMarkHisTem.setDoublyStoFirName (registMarkTem.getDoublyStoFirName ());
            registMarkHisTem.setDoublyStoSecCode (registMarkTem.getDoublyStoSecCode ());
            registMarkHisTem.setDoublyStoSecName (registMarkTem.getDoublyStoSecName ());
            registMarkHisTem.setDoublyStoThiCode (registMarkTem.getDoublyStoThiCode ());
            registMarkHisTem.setDoublyStoThiName (registMarkTem.getDoublyStoThiName ());

            PageRequest request = new PageRequest ();
            Map<String, Object> queryMap = new HashMap<String, Object> ();
            queryMap.put ("IDCode", registMarkTem.getIDCode ());
            request.setLength (1);
            request.setPageNum (0);
            request.setParams (queryMap);
            List<RegistMarkHis> registMarkHisList = registMarkHisService.queryRegistMarkHisListByIdCode (request);
            if (registMarkHisList == null || registMarkHisList.size () == 0) {
                registMarkHisTem.setAuditTime (DateUtil.getSysDate ());
                registMarkHisTem.setUpdateTime (null);
                registMark.setUpdateTime (null);
            } else {
                registMark.setUpdateTime (DateUtil.getCurrentTime ());
                registMarkHisTem.setUpdateTime (registMarkTem.getUpdateTime ());
                registMarkHisTem.setAuditTime (registMarkTem.getAuditTime ());
            }
            // 审核时间
            registMark.setAuditTime (DateUtil.getSysDate ());
            registMarkHisTem.setAuditDeptName (sysUser.getDepartMent ().getDeptName ());
            registMarkHisTem.setAuditorName (sysUser.getRealName ());
            // registMarkHisTem.setUpdateTime(DateUtil.getCurrentTime());
            // registMark.setUpdateTime(DateUtil.getCurrentTime());
            // 插入历史表
            registMarkHisService.insertRegistMark (registMarkHisTem);
            
            
            // 同时修改标签标注表的冗余名称
            mainMarkRelService.updateAllMarkNameByMarkCode (registMarkTem.getIDCode (), registMarkTem.getIDName ());
            
            String idStateCode = registMarkTem.getIDStateCode ();
            if("2".equals (idStateCode)){//如果无效删除企业与标签绑定关系
                mainMarkRelService.deleteBy (registMarkTem.getIDCode (), "1", "0");
                pubApprMarkRelService.deleteByMarkCode (registMarkTem.getIDCode ());
            }
        }else if ("3".equals (auditState)) {//审核不通过
            mainMarkRelService.deleteBy (registMarkTem.getIDCode (), "1", "0");
            pubApprMarkRelService.deleteByMarkCode (registMarkTem.getIDCode ());
        }
        registMark.setAuditState (auditState);
        // 主键
        registMark.setMarkUuid (uid);
        registMark.setAuditorName (sysUser.getRealName ());
        // 协同
        if ("2".equals (sysUser.getUserType ())) {
            registMark.setAuditDeptName (sysUser.getSysDepart ().getOrgName ());
        } else {
            registMark.setAuditDeptName (sysUser.getDepartMent ().getDeptName ());
        }
        // 审核意见
        registMark.setAuditorDesc (auditorDesc);
        

        
        UpdateRegistMark (registMark);
        
    }
}