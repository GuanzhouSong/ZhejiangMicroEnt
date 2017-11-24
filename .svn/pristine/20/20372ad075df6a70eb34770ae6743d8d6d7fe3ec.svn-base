/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.DeptTree;
import com.icinfo.cs.system.dto.SysDepartDto;
import com.icinfo.cs.system.mapper.DeptDutycodeRefMapper;
import com.icinfo.cs.system.mapper.SysDepartMapper;
import com.icinfo.cs.system.mapper.SysDepartOptRecordMapper;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysDepartOptRecord;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.framework.common.exception.GenericException;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_sys_depart 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Service
public class SysDepartServiceImpl extends MyBatisServiceSupport implements ISysDepartService{

    private final Logger logger = LoggerFactory.getLogger(SysDepartServiceImpl.class);
    @Autowired
    private SysDepartMapper sysDepartMapper;
    @Autowired
    private DeptDutycodeRefMapper deptDutycodeRefMapper;
    @Autowired
    private SysDepartOptRecordMapper sysDepartOptRecordMapper;
    @Autowired
    private ICodeDutydeptService codeDutydeptService;


    /**
     * 描述:根据ID查询部门信息
     *
     * @param id
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-19
     */
    @Override
    public SysDepart doGetById(Integer id) throws Exception {
        SysDepart sysDepart=sysDepartMapper.selectByPrimaryKey(id);
        updateDutyCodeAndName(sysDepart);
        return sysDepart;
    }

    /**
     * 描述:根据部门代码查询部门信息
     *
     * @param orgCoding 部门节点Code
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-20
     */
    @Override
    public SysDepart doGetByCode(String orgCoding) throws Exception {
        SysDepart sysDepart = new SysDepart();
        sysDepart.setOrgCoding(orgCoding);
        return sysDepartMapper.selectOne(sysDepart);
    }

    /**
     * 描述:根据部门代码查询部门信息
     *
     * @param orgCoding 部门节点Code
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-20
     */
    @Override
    public DeptTree doGetDeptTreeByCode(String orgCoding,String isParent,String nocheck) throws Exception {
        SysDepart sysDepart=doGetByCode(orgCoding);
        if(sysDepart==null) return null;
        DeptTree deptTree=new DeptTree();
        deptTree.setAdcode(sysDepart.getAdcode());
        deptTree.setOrgCoding(sysDepart.getOrgCoding());
        deptTree.setOrgName(sysDepart.getOrgName());
        deptTree.setPorgCoding(sysDepart.getPorgCoding());
        deptTree.setIsParent(isParent);
        deptTree.setNocheck(nocheck);
        return deptTree;
    }

    /**
     * 
     * 描述   根据行政编码查询
     * @author  赵祥江
     * @date 2016年10月26日 下午7:57:23 
     * @param  
     * @throws
     */
    @Override
    public List<SysDepart> doGetSysDepartByAdcode(String adcode) throws Exception {
        SysDepart sysDepart = new SysDepart();
        sysDepart.setAdcode(adcode);
        return sysDepartMapper.select(sysDepart);
    }


    /**
     * 描述:根据父节点获取直接子节点的代码集合<br/>
     * 部门行政编码是13位的为最末端子节点（真正意义的部门节点）
     * @param isSetNoCheck 是否设置树节点的noCheck属性
     * @param sysDepart 协同部门树查询参数
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-19
     */
    @Override
    public List<SysDepart> doGetDepartment(SysDepart sysDepart,boolean isSetNoCheck) throws Exception {
        List<SysDepart> sysDepartList=sysDepartMapper.select(sysDepart);
        Iterator<SysDepart> sysDepartIterator = sysDepartList.iterator();
        while (sysDepartIterator.hasNext()) {
            SysDepart depart = sysDepartIterator.next();
            if(depart.getAdcode().length() < 13){ //如果行政编码是13位（类似于：330100000M002）的才是最末端部门节点
                depart.setIsParent("true");
                if(isSetNoCheck) depart.setNocheck("true");
            }else if(depart.getAdcode().length() ==13 && "1".equals(depart.getParentFlag())){
            	depart.setIsParent("true");
            	depart.setNocheck("");
            }else{
                depart.setIsParent("false");
                if(isSetNoCheck) depart.setNocheck("");
            }
        }
        return sysDepartList;
    }

    /**
     * 更新当前用户的职能部门编码和职能部门名称
     * @author ZhuDefeng
     * @date 2016-11-29
     * @param sysDepart
     * @throws Exception
     */
    private void updateDutyCodeAndName(SysDepart sysDepart)throws Exception{
        DeptDutycodeRef deptDutycodeRef=new DeptDutycodeRef();
        deptDutycodeRef.setOrgCoding(sysDepart.getOrgCoding());
        List<DeptDutycodeRef> deptDutycodeRefs =deptDutycodeRefMapper.select(deptDutycodeRef);
        String dutyDeptCodes="";//合并的部门个数不会超过三个，就不用StringBuilder了
        String dutyDeptNames="";
        for(DeptDutycodeRef item:deptDutycodeRefs){
        	if(StringUtil.isNotBlank(item.getDutyDeptCode())&&StringUtil.isNotBlank(item.getDutyDeptName())){
        		dutyDeptCodes+=item.getDutyDeptCode()+",";
                dutyDeptNames+=item.getDutyDeptName()+",";
        	} 
        }
        if (StringUtil.isNotBlank(dutyDeptCodes)&&StringUtil.isNotBlank(dutyDeptNames)) {
            dutyDeptCodes = dutyDeptCodes.substring(0, dutyDeptCodes.length() - 1);
            dutyDeptNames = dutyDeptNames.substring(0, dutyDeptNames.length() - 1);
            sysDepart.setDutyCodes(dutyDeptCodes);
            sysDepart.setDutyNames(dutyDeptNames);
        }
    }


    /**
     * 描述:部门维护修改接口
     *
     * @param sysDepart
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-19
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int doModDepartment(SysDepartDto sysDepart) throws Exception {
        SysDepartOptRecord sysDepartOptRecord=newModOptRecord(sysDepart);
        sysDepartOptRecordMapper.insert(sysDepartOptRecord);
        updateDeptDutyCodeRef(sysDepart);
        int rslt=sysDepartMapper.updateByPrimaryKeySelective(sysDepart);
        return rslt;
    }

    /**
     * 实例化一个部门删除记录实体
     * @author ZhuDefeng
     * @date 2016-12-09
     * @param sysDepart
     * @return
     * @throws Exception
     */
    private SysDepartOptRecord newDelOptRecord(SysDepart sysDepart)throws  Exception{
        SysDepart tmpDepart=sysDepartMapper.selectByPrimaryKey(sysDepart.getId());
        SysDepartOptRecord sysDepartOptRecord=new SysDepartOptRecord();
        sysDepartOptRecord.setOrgCoding(tmpDepart.getOrgCoding());
        sysDepartOptRecord.setOrgName(tmpDepart.getOrgName());
        sysDepartOptRecord.setAdcode(tmpDepart.getAdcode());
        sysDepartOptRecord.setDevCoding(tmpDepart.getDevCoding());
        sysDepartOptRecord.setPorgCoding(tmpDepart.getPorgCoding());
        sysDepartOptRecord.setDutyCodes(tmpDepart.getDutyCodes());
        sysDepartOptRecord.setDutyNames(tmpDepart.getDutyNames());
        sysDepartOptRecord.setDevCoding(tmpDepart.getDevCoding());
        sysDepartOptRecord.setOrderBy(tmpDepart.getOrderBy());
        sysDepartOptRecord.setOrganizeAllName(tmpDepart.getOrganizeAllName());
        sysDepartOptRecord.setOptType("-1");
        return sysDepartOptRecord;
    }

    /**
     * 实例化一个部门修改记录实体
     * @author ZhuDefeng
     * @date 2016-12-09
     * @param sysDepart
     * @return
     * @throws Exception
     */
    private SysDepartOptRecord newModOptRecord(SysDepart sysDepart)throws  Exception{
        //orgCoding、orgName、adcode、progCoding、dutyCodes、dutyNames、orgNameNew、dutyCodesNew、dutyNamesNew、optType、createTime、devCoding、organizeAllName、orderBy
        SysDepart tmpDepart=sysDepartMapper.selectByPrimaryKey(sysDepart.getId());
        updateDutyCodeAndName(tmpDepart);
        SysDepartOptRecord sysDepartOptRecord=new SysDepartOptRecord();
        //OLD
        sysDepartOptRecord.setOrgCoding(tmpDepart.getOrgCoding());
        sysDepartOptRecord.setOrgName(tmpDepart.getOrgName());
        sysDepartOptRecord.setAdcode(tmpDepart.getAdcode());
        sysDepartOptRecord.setDevCoding(tmpDepart.getDevCoding());
        sysDepartOptRecord.setPorgCoding(tmpDepart.getPorgCoding());
        sysDepartOptRecord.setDutyCodes(tmpDepart.getDutyCodes());
        sysDepartOptRecord.setDutyNames(tmpDepart.getDutyNames());
        sysDepartOptRecord.setDevCoding(tmpDepart.getDevCoding());
        sysDepartOptRecord.setOrderBy(tmpDepart.getOrderBy());
        sysDepartOptRecord.setOrganizeAllName(tmpDepart.getOrganizeAllName());
        //NEW
        sysDepartOptRecord.setOrgNameNew(sysDepart.getOrgName());
        sysDepartOptRecord.setDutyCodesNew(sysDepart.getDutyCodes());
        sysDepartOptRecord.setDutyNamesNew(sysDepart.getDutyNames());
        sysDepartOptRecord.setAdcode(sysDepart.getAdcode());
        sysDepartOptRecord.setOrgCoding(sysDepart.getOrgCoding());
        sysDepartOptRecord.setCreateTime(new Date());
        sysDepartOptRecord.setOptType("0");
        sysDepartOptRecord.setOrgCoding(sysDepart.getOrgCoding());
        return sysDepartOptRecord;

    }

    /**
     * 实例化一个部门新增记录实体
     * @author ZhuDefeng
     * @date 2016-12-09
     * @param sysDepart
     * @return
     * @throws Exception
     */
    private SysDepartOptRecord newAddOptRecord(SysDepart sysDepart)throws  Exception{
        updateDutyCodeAndName(sysDepart);
        SysDepartOptRecord sysDepartOptRecord=new SysDepartOptRecord();
        sysDepartOptRecord.setOrgNameNew(sysDepart.getOrgName());
        sysDepartOptRecord.setDutyCodesNew(sysDepart.getDutyCodes());
        sysDepartOptRecord.setAdcode(sysDepart.getAdcode());
        sysDepartOptRecord.setCreateTime(new Date());
        sysDepartOptRecord.setOrgCoding(sysDepart.getOrgCoding());
        sysDepartOptRecord.setPorgCoding(sysDepart.getPorgCoding());
        sysDepartOptRecord.setOptType("1");
        return sysDepartOptRecord;

    }


    /**
     * 描述:部门维护删除接口
     *
     * @param id
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-19
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int doRmDepartment(Integer id) throws Exception {
        SysDepart sysDepart=doGetById(id);
        DeptDutycodeRef deptDutycodeRef=new DeptDutycodeRef();
        deptDutycodeRef.setOrgCoding(sysDepart.getOrgCoding());
//        if(StringUtil.isBlank(deptDutycodeRef.getAdCode())){
//            throw new GenericException("更新职能部门编码时候adcode为空");
//        }
        SysDepartOptRecord sysDepartOptRecord=newDelOptRecord(sysDepart);
        sysDepartOptRecordMapper.insert(sysDepartOptRecord);
        deptDutycodeRefMapper.delete(deptDutycodeRef);
        return sysDepartMapper.deleteByPrimaryKey(id);
    }

    /**
     * 描述:部门维护新增接口
     *
     * @param sysDepart
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-19
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int doSaveDepartment(SysDepartDto sysDepart) throws Exception {
        SysDepart sysDepartTmp=doGetByCode(sysDepart.getOrgCoding());
        if(sysDepartTmp!=null) {
            throw new BusinessException("部门编码["+sysDepartTmp.getOrgName()+"-"+sysDepartTmp.getOrgName()+"]重复，添加失败!");
        }
        updateDeptDutyCodeRef(sysDepart);
        SysDepartOptRecord sysDepartOptRecord=newAddOptRecord(sysDepart);
        sysDepartOptRecordMapper.insert(sysDepartOptRecord);
        return sysDepartMapper.insert( sysDepart);
    }
    
    /**
	 * 描述：判断父级节点是否还有子节点
	 * 
	 * @author chenxin
	 * @date 2017-09-22
	 * @param porgCoding
	 * @return
	 * @throws Exception
	 */
    @Override
    public void updateParentFlag(String porgCoding) throws Exception {
    	SysDepart params = new SysDepart();
    	params.setOrgCoding(porgCoding);
    	int count = sysDepartMapper.selectCount(params);
    	SysDepart sysDepart = doGetByCode(porgCoding);
    	if(count > 0){
    		sysDepart.setParentFlag("1");
    	}else{
    		sysDepart.setParentFlag("0");
    	}
    	sysDepartMapper.updateByPrimaryKey(sysDepart);
    }

	/**
	 * 
	 * 描述  查询adCode不重复且其长度为13 包含M编码的部门结果集
	 * @author 赵祥江
	 * @date 2016年11月3日 下午3:19:35 
	 * @param 
	 * @return List<SysDepart>
	 * @throws
	 */
	@Override
	public List<SysDepart> selectDistinctAdCodeSysDepartList(
			Map<String, Object> parmMap) {
 		return sysDepartMapper.selectDistinctAdCodeSysDepartList(parmMap);
	}



    /**
     * 描述：根据职能部门编码获取部门
     *
     * @param qryMap
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-11-23
     */
    @Override
    public List<DeptTree> doFindDeptByDutyCodeByDutyCode(Map<String, Object> qryMap) throws Exception {
        return sysDepartMapper.findDeptByDutyCodeByDutyCode(qryMap);
    }


    /**
     * 描述：根据部门编码获取部门
     *
     * @param orgCoding
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-11-25
     */
    @Override
    public List<DeptTree> doFindDeptByDutyCodeAndOrgCoding(String orgCoding) throws Exception {
        return sysDepartMapper.findDeptByDutyCodeByOrgCoding(orgCoding);
    }


    /**
     * 获取当前节点下的下一个唯一的AdCode值
     *
     * @param orgCoding 父节点部门编码
     * @return
     * @author ZhuDefeng
     * @date 2016-11-29
     */
    @Override
    public String doNextAdCode(String orgCoding,boolean flag) throws Exception{
        String nextAdCode="";
        SysDepart deptTree=doGetByCode(orgCoding);
        if(deptTree==null){
            throw new BusinessException("获取下一个Adcode出现异常，orgCoding错误【"+orgCoding+"】");
        }
        String maxAdCode=sysDepartMapper.getMaxAdCode(orgCoding);
        String parentAdcode=deptTree.getAdcode();
        if(flag){//创建所及部门树
        	if(StringUtil.isEmpty(maxAdCode)){
        		nextAdCode=deptTree.getAdcode()+"S001";
        	}else{
        		String[] maxId = maxAdCode.split("S");
        		if(maxId.length > 1){
        			int keyNum = Integer.parseInt(maxId[1])+1;
        			nextAdCode = parentAdcode+"S"+StringUtil.addZero(keyNum, 3);
        		}
        	}
        }else{
        	if(StringUtil.isEmpty(maxAdCode)){
        		nextAdCode=deptTree.getAdcode()+"000M001";
        	}else{
        		String[] maxAdCodeInfo=maxAdCode.split("M");
        		if(maxAdCodeInfo!=null&&maxAdCodeInfo.length==2&&StringUtil.isNotBlank(maxAdCodeInfo[1])){
        			int nextAdCodeFlg=Integer.parseInt(maxAdCodeInfo[1])+1;
        			if(nextAdCodeFlg<10){
        				nextAdCode= parentAdcode+"000M00"+nextAdCodeFlg;
        			}
        			else if(nextAdCodeFlg<99){
        				nextAdCode = parentAdcode+"000M0"+nextAdCodeFlg;
        			}else{
        				nextAdCode = parentAdcode+"000M"+nextAdCodeFlg;
        			}
        		}
        	}
        }
        if(StringUtil.isNotEmpty(nextAdCode)){
            List<SysDepart> sysDeparts=doGetSysDepartByAdcode(nextAdCode);
            if(sysDeparts!=null&&sysDeparts.size()>0){
                nextAdCode="";
            }
        }
        return nextAdCode;
    }

    /**
     * 获取当前节点下的下一个唯一的OrgCoding值
     *
     * @param orgCoding 父节点部门编码
     * @return
     * @author ZhuDefeng
     * @date 2016-11-29
     */
    @Override
    public String doNextOrgCoding(String orgCoding,boolean flag) throws Exception {
        String  nextOrgCoding="";
        SysDepart deptTree=doGetByCode(orgCoding);
        if(deptTree==null){
            throw new BusinessException("获取下一个Adcode出现异常，orgCoding错误【"+orgCoding+"】");
        }
        String maxOrgCode=sysDepartMapper.getMaxOrgCode(orgCoding);
        if(flag){//创建所及部门树
        	if(StringUtil.isEmpty(maxOrgCode)){
        		nextOrgCoding=deptTree.getOrgCoding()+"S001";
        	}else{
        		String[] maxId = maxOrgCode.split("S");
        		if(maxId.length > 1){
        			int keyNum = Integer.parseInt(maxId[1])+1;
        			nextOrgCoding = deptTree.getOrgCoding()+"S"+StringUtil.addZero(keyNum, 3);
        		}
        	}
        }else{
        	if(StringUtil.isEmpty(maxOrgCode)){
        		nextOrgCoding=deptTree.getOrgCoding()+"001";
        	}else{
        		maxOrgCode=StringUtil.substring(maxOrgCode,2,maxOrgCode.length());
        		BigDecimal nextAdCodeFlg=new BigDecimal(maxOrgCode).add(new BigDecimal(1));
        		if(nextAdCodeFlg.compareTo(new BigDecimal(10))==-1){
        			nextOrgCoding= "00"+"00"+nextAdCodeFlg;
        		}
        		else if(nextAdCodeFlg.compareTo(new BigDecimal(10))==99){
        			nextOrgCoding = "00"+"0"+nextAdCodeFlg;
        		}else{
        			nextOrgCoding = "00"+nextAdCodeFlg;
        		}
        	}
        }
        if(StringUtil.isNotEmpty(nextOrgCoding)){
            SysDepart sysDepart=doGetByCode(nextOrgCoding);
            if(sysDepart!=null&&StringUtil.isNotEmpty(sysDepart.getOrgCoding())){
                nextOrgCoding="";
            }
        }
        return nextOrgCoding;
    }


    /**
     * 描述：更新部门与职能部门编码对应关系
     * @author ZhuDefeng
     * @date 2016-11-21
     * @param sysDepart
     * @throws Exception
     * 
     */
    private List<DeptDutycodeRef> updateDeptDutyCodeRef(SysDepartDto sysDepart)throws Exception{
        if(StringUtil.isBlank(sysDepart.getOrgCoding())||StringUtil.isBlank(sysDepart.getDutyCodes())) return new ArrayList<>();
        DeptDutycodeRef condition=new DeptDutycodeRef();
        condition.setOrgCoding(sysDepart.getOrgCoding());
        if(StringUtil.isBlank(sysDepart.getOrgCoding())){
            throw new GenericException("更新职能部门编码时候orgCoding为空");
        }
        deptDutycodeRefMapper.delete(condition);
        DeptDutycodeRef deptDutycodeRef=new DeptDutycodeRef();
        String[] dutyCodeArr=sysDepart.getDutyCodes().split(",");

        for(String dutyCode:dutyCodeArr){
            CodeDutydept codeDutydept=codeDutydeptService.doSelectCodeDutydeptBydeptCode(dutyCode);
            if(codeDutydept!=null) deptDutycodeRef.setDutyDeptName(codeDutydept.getDeptName());
            deptDutycodeRef.setAdCode(sysDepart.getAdcode());
            deptDutycodeRef.setOrgCoding(sysDepart.getOrgCoding());
            deptDutycodeRef.setOrgName(sysDepart.getOrgName());
            deptDutycodeRef.setDutyDeptCode(dutyCode);
            deptDutycodeRef.setPorgCoding(sysDepart.getPorgCoding());
            deptDutycodeRefMapper.insert(deptDutycodeRef);
        }
        List<DeptDutycodeRef> deptDutycodeRefs=deptDutycodeRefMapper.select(condition);
        return deptDutycodeRefs;
    }

    /**
     * 
     * 描述   获取行政区划的树形结构
     * @author  赵祥江
     * @date 2017年1月11日 上午10:22:07 
     * @param  
     * @throws
     */
	@Override
	public List<DeptTree> deptTreeCtity(Map<String, Object> qryMap)
			throws Exception { 
		return sysDepartMapper.deptTreeCtity(qryMap);
	}
	
	 /**
     * 查询部门编码
     * @param checkDeptName
     * @param dutyDeptCodes
     * @return
     */
	@Override
	public DeptDutycodeRef selectByName(String checkDeptName, String dutyDeptCodes) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("orgName", checkDeptName);
		params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
		List<DeptDutycodeRef> deptDutycodeRefList =  deptDutycodeRefMapper.selectByName(params);
		if(CollectionUtils.isEmpty(deptDutycodeRefList)){
			return null;
		}
		return deptDutycodeRefList.get(0);
	}
}