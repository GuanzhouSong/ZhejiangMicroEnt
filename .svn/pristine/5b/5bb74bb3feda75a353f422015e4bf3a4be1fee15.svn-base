/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.sment.dto.SmEntAbovescaleDto;
import com.icinfo.cs.sment.mapper.SmEntAbovescaleMapper;
import com.icinfo.cs.sment.model.SmEntAbovescale;
import com.icinfo.cs.sment.service.ISmEntAbovescaleService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.upload.utils.ExcelUtil;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;
import com.icinfo.framework.tools.utils.StringUtils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 描述:    sm-ent-abovescale 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年07月20日
 */
@Service
public class SmEntAbovescaleServiceImpl extends MyBatisServiceSupport implements ISmEntAbovescaleService {
	
	@Autowired
	private SmEntAbovescaleMapper smEntAbovescaleMapper;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	/**
	 * 
	 * 描述: excel导入
	 * @auther gaojinling
	 * @date 2017年7月20日 
	 * @param file
	 * @param sysUser
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
    public Map<String, Object> excelImport(MultipartFile file,SysUserDto sysUser,String year) throws Exception{
        Map<String, Object> qMap = new HashMap<String, Object> ();
        // 校验成功状态 0 成功 1 失败
        qMap.put ("status", "0");
        StringBuffer bf = new StringBuffer ();

        // 解析excel
        Workbook workbook = WorkbookFactory.create (file.getInputStream ());
        Sheet sheet = workbook.getSheetAt (0);
        int rows = sheet.getPhysicalNumberOfRows ();
        //校验模板数据
        if (rows < 3) { 
        	qMap.put("status", 2);
        	qMap.put("msg", "模板数据为空");
        	qMap.put("allImportTatol", 0);
        	qMap.put("notMatchCount", 0);
        	return qMap; }
        String titleArr[] = {"组织机构代码","企业名称","统一社会信用代码","报表类别编码","报表类别中文"};
        //比对模板
        for(int j= 0 ;j<titleArr.length-1;j++ ){
            if(!sheet.getRow (1).getCell(j).getStringCellValue().trim().equals(titleArr[j])){
            	qMap.put("status", 2);
            	qMap.put("msg", "模板选择错误，请重新选择文件");
            	qMap.put("allImportTatol", 0);
            	qMap.put("notMatchCount", 0);
            	return qMap;
            }
        }
        int allImportTatol = 0;
        int notMatchCount = 0;
        // 遍历处理每行
        Map<String, Object> map = new HashMap<String, Object>();
		Integer maxNo = selectImBatchNum();
		if (maxNo == null) {
			maxNo = new Integer(1);
		}
        for ( int i = 2 ; i < rows ; i++ ) {
            int count = i;
            Row row = sheet.getRow (i);

            String unicode = com.icinfo.cs.common.utils.ExcelUtil.parseCellValueToString (row.getCell (2));// 统一代码
            String entName = ExcelUtil.getCellContent (row.getCell (1)); // 企业名称 
            if (StringUtil.isBlank (entName)) {
                ++count;
                bf.append ("第" + count + "行第2列企业名称不能为空;");
                qMap.put ("status", "1");
                continue;
            }
            /*
             * 匹配规则，首先通过“统一社会信用代码（源）”与系统中企业登记数据匹配，
                                             如果匹配成功则将匹配后的企业名称、统一代码、注册号赋值匹配后三个字段，如果匹配不成功，则再通过“企业名称（源）”与系统中企业登记数据匹配，
                                             如果匹配成功则将匹配后的企业名称、统一代码、注册号赋值匹配后三个字段，如果没有“统一社会信用代码（源）”，则直接通过“企业名称（源）”进行匹配
             */
            List<MidBaseInfoDto> midBaseInfoDtos;
            if(StringUtil.isNotBlank (unicode)){
            	map.clear();
                map.put("searchuniCode", unicode);
                midBaseInfoDtos = midBaseInfoService.selectMidBaseinfoByRegNoAndName(map);
            	if(midBaseInfoDtos!=null && midBaseInfoDtos.size()>0 && midBaseInfoDtos.get(0)!=null ){//统一代码匹配成功,放入库中
            		insert(sysUser,"1",midBaseInfoDtos.get(0),row,maxNo,year);
                    allImportTatol++;
            	}else{
            		map.clear();
                    map.put("searchentName", entName);
                    midBaseInfoDtos = midBaseInfoService.selectMidBaseinfoByRegNoAndName(map);
                	if(midBaseInfoDtos!=null && midBaseInfoDtos.size()>0 && midBaseInfoDtos.get(0)!=null ){//企业名称匹配成功,得到匹配后的企业放入库中
                		insert(sysUser,"1",midBaseInfoDtos.get(0),row,maxNo,year);
                        allImportTatol++;
                	}else{//企业名称匹配成功,企业直接放入库中，不匹配
                		insert(sysUser,"0",null,row,maxNo,year);
                        notMatchCount++;
                	}
            	}
            }else{
        		map.clear();
                map.put("searchentName", entName);
                midBaseInfoDtos = midBaseInfoService.selectMidBaseinfoByRegNoAndName(map);
            	if(midBaseInfoDtos.size()>0 && midBaseInfoDtos.get(0)!=null ){//企业名称,放入库中
            		insert(sysUser,"1",midBaseInfoDtos.get(0),row,maxNo,year);
                    allImportTatol++;
            	}else{
            		insert(sysUser,"0",null,row,maxNo,year);
                    notMatchCount++;
            	}	
            }
        }
        qMap.put("allImportTatol", allImportTatol);
        qMap.put("notMatchCount", notMatchCount);
        qMap.put("msg", bf.toString());
        return qMap;
    }
    
    /**
     * 
     * 描述: 数据插入
     * @auther gaojinling
     * @date 2017年7月20日 
     * @param sysUserDto
     * @param isMatch 是否匹配 1是  0否
     */
    public void insert(SysUserDto sysUser,String isMatch,MidBaseInfoDto midBaseInfoDto,Row row,Integer maxNo,String year){
        SmEntAbovescale smEntAbovescale = new SmEntAbovescale();
        smEntAbovescale.setOrganizecode(ExcelUtil.getCellContent(row.getCell(0)));
        smEntAbovescale.setEntName(ExcelUtil.getCellContent(row.getCell(1)));
        smEntAbovescale.setUniCode(ExcelUtil.getCellContent(row.getCell(2)));
        smEntAbovescale.setFormType(ExcelUtil.getCellContent(row.getCell(3)));
        smEntAbovescale.setFormTypeCn(ExcelUtil.getCellContent(row.getCell(4)));
        smEntAbovescale.setImportName(sysUser.getRealName());
        smEntAbovescale.setImportTime(new Date());
        smEntAbovescale.setIsMatch(isMatch);
        //根据formType确定规上企业类型（1限上：E和S  2规上工业：B 3规上服务业：F ）
        String formType = smEntAbovescale.getFormType();
        String aboveType = StringUtil.isNotBlank(formType) ? (("E".equals(formType) || "S".equals(formType)) ? "1" : ("B".equals(formType) ? "2" : ("F".equals(formType) ? "3" : formType ))) : formType;
        smEntAbovescale.setAboveType(aboveType);
        String batchNum = maxNo < 10 ? "00" : (maxNo <100 ? "0":"");
        String strYear = StringUtil.isBlank(year) ? DateUtil.getCurrentYear() : year;
        smEntAbovescale.setYear(Integer.parseInt(strYear));
        //批次号
        smEntAbovescale.setImBatchNum(strYear+"-"+batchNum+maxNo);
        smEntAbovescale.setCreateTime(new Date());
        if("1".equals(isMatch) && midBaseInfoDto!=null){
        	smEntAbovescale.setPripid(midBaseInfoDto.getPriPID());
        	smEntAbovescale.setMatchUniCode(midBaseInfoDto.getUniCode());
        	smEntAbovescale.setMatchRegNO(midBaseInfoDto.getRegNO());
        	smEntAbovescale.setMatchEntName(midBaseInfoDto.getEntName());
        }
        smEntAbovescaleMapper.insert(smEntAbovescale);
    }
    
    
	/**
	 * 
	 * 描述: 查询当前库中最大批次
	 * @auther gaojinling
	 * @date 2017年7月20日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer selectImBatchNum() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		return smEntAbovescaleMapper.selectImBatchNum(map);
	}
	
	/**
	 * 
	 * 描述 : 查询规上企业（分页）
	 * @auther gaojinling
	 * @date 2017年7月21日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SmEntAbovescaleDto> selectSmEntAbovescale(PageRequest request) throws Exception{
        PageHelper.startPage (request.getPageNum (), request.getLength ());
		return smEntAbovescaleMapper.selectSmEntAbovescale(request.getParams ());	
	}
    
	/**
	 * 
	 * 描述:修改
	 * @auther gaojinling
	 * @date 2017年7月21日 
	 * @param smEntAbovescaleDto
	 * @return
	 * @throws Exception
	 */
	public int update(SmEntAbovescaleDto smEntAbovescaleDto) throws Exception{
		try {
			if(smEntAbovescaleDto!=null&&StringUtils.isNotEmpty(smEntAbovescaleDto.getUID())){
				//时间戳
				smEntAbovescaleDto.setCreateTime(new Date());
				match(smEntAbovescaleDto);
		        //根据formType确定规上企业类型（1限上：E和S  2规上工业：B 3规上服务业：F ）
		        String formType = smEntAbovescaleDto.getFormType();
		        String aboveType = StringUtil.isNotBlank(formType) ? (("E".equals(formType) || "S".equals(formType)) ? "1" : ("B".equals(formType) ? "2" : ("F".equals(formType) ? "3" : formType ))) : formType;
		        smEntAbovescaleDto.setAboveType(aboveType);
				Example example = new Example(SmEntAbovescale.class);
				example.createCriteria().andEqualTo("UID", smEntAbovescaleDto.getUID());
				return smEntAbovescaleMapper.updateByExample(smEntAbovescaleDto, example);
			} 
		} catch (Exception e) {
			e.printStackTrace();
            throw new BusinessException("根据主键修改规上企业失败！");
		} 
		return 0;		
	}
	
	/**
	 * 
	 * 描述: 根据uid查询单个
	 * @auther gaojinling
	 * @date 2017年7月21日 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public SmEntAbovescale selectone(String uid) throws Exception{
		try {
			if(StringUtil.isNotBlank(uid)){
				SmEntAbovescale smEntAbovescale = new SmEntAbovescale();
				smEntAbovescale.setUID(uid);
				return smEntAbovescaleMapper.selectOne(smEntAbovescale);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	   return null;
	}
	
	/**
	 * 
	 * 描述: 更新单个（处理是否匹配）
	 * @auther gaojinling
	 * @date 2017年7月21日 
	 * @param smEntAbovescaleDto
	 * @return
	 * @throws Exception
	 */
	public SmEntAbovescale match(SmEntAbovescaleDto smEntAbovescaleDto) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String  unicode = smEntAbovescaleDto.getUniCode();
		String  entName = smEntAbovescaleDto.getEntName();
		/*
         * 匹配规则，首先通过“统一社会信用代码（源）”与系统中企业登记数据匹配，
                                         如果匹配成功则将匹配后的企业名称、统一代码、注册号赋值匹配后三个字段，如果匹配不成功，则再通过“企业名称（源）”与系统中企业登记数据匹配，
                                         如果匹配成功则将匹配后的企业名称、统一代码、注册号赋值匹配后三个字段，如果没有“统一社会信用代码（源）”，则直接通过“企业名称（源）”进行匹配
         */
        List<MidBaseInfoDto> midBaseInfoDtos;
        if(StringUtil.isNotBlank (unicode)){
        	map.clear();
            map.put("searchuniCode", unicode);
            midBaseInfoDtos = midBaseInfoService.selectMidBaseinfoByRegNoAndName(map);
        	if(midBaseInfoDtos!=null && midBaseInfoDtos.size()>0 && midBaseInfoDtos.get(0)!=null ){//统一代码匹配成功,放入库中
        		smEntAbovescaleDto.setIsMatch("1");
        		smEntAbovescaleDto.setMatchEntName(midBaseInfoDtos.get(0).getEntName());
        		smEntAbovescaleDto.setMatchRegNO(midBaseInfoDtos.get(0).getRegNO());
        		smEntAbovescaleDto.setMatchUniCode(midBaseInfoDtos.get(0).getUniCode());
        		smEntAbovescaleDto.setPripid(midBaseInfoDtos.get(0).getPriPID());
        	}else{
        		map.clear();
                map.put("searchentName", entName);
                midBaseInfoDtos = midBaseInfoService.selectMidBaseinfoByRegNoAndName(map);
            	if(midBaseInfoDtos!=null && midBaseInfoDtos.size()>0 && midBaseInfoDtos.get(0)!=null ){//企业名称匹配成功,得到匹配后的企业放入库中
            		smEntAbovescaleDto.setIsMatch("1");
            		smEntAbovescaleDto.setMatchEntName(midBaseInfoDtos.get(0).getEntName());
            		smEntAbovescaleDto.setMatchRegNO(midBaseInfoDtos.get(0).getRegNO());
            		smEntAbovescaleDto.setMatchUniCode(midBaseInfoDtos.get(0).getUniCode());
            		smEntAbovescaleDto.setPripid(midBaseInfoDtos.get(0).getPriPID());
            	}else{//企业名称匹配不成功,企业直接放入库中，不匹配
            		smEntAbovescaleDto.setIsMatch("0");
            		smEntAbovescaleDto.setMatchEntName(null);
            		smEntAbovescaleDto.setMatchRegNO(null);
            		smEntAbovescaleDto.setMatchUniCode(null);
            		smEntAbovescaleDto.setPripid(null);
            	}
        	}
        }else{
    		map.clear();
            map.put("searchentName", entName);
            midBaseInfoDtos = midBaseInfoService.selectMidBaseinfoByRegNoAndName(map);
        	if(midBaseInfoDtos.size()>0 && midBaseInfoDtos.get(0)!=null ){//企业名称,放入库中
        		smEntAbovescaleDto.setIsMatch("1");
        		smEntAbovescaleDto.setMatchEntName(midBaseInfoDtos.get(0).getEntName());
        		smEntAbovescaleDto.setMatchRegNO(midBaseInfoDtos.get(0).getRegNO());
        		smEntAbovescaleDto.setMatchUniCode(midBaseInfoDtos.get(0).getUniCode());
        		smEntAbovescaleDto.setPripid(midBaseInfoDtos.get(0).getPriPID());
        	}else{
        		smEntAbovescaleDto.setIsMatch("0");
        		smEntAbovescaleDto.setMatchEntName(null);
        		smEntAbovescaleDto.setMatchRegNO(null);
        		smEntAbovescaleDto.setMatchUniCode(null);
        		smEntAbovescaleDto.setPripid(null);
        	}	
        }
		return smEntAbovescaleDto;
	}
	
	
	/**
	 * 
	 * 描述: 限上规上企业成长轨迹
	 * @auther gaojinling
	 * @date 2017年8月16日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<SmEntAbovescaleDto> smEntAbovescaleCount(Map<String, Object> map) throws Exception{
		return smEntAbovescaleMapper.smEntAbovescaleCount(map);
	}
	
	
	/**
	 * 
	 * 描述: 限上归上企业总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer smEntAbovescaleTotal(Map<String, Object> map) throws Exception{
		return smEntAbovescaleMapper.smEntAbovescaleTotal(map);
	}
	/**
	 * 
	 * 描述: 动产抵押总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer mortRegInfoTotal(Map<String, Object> map) throws Exception{
        return smEntAbovescaleMapper.mortRegInfoTotal(map);
	}
	/**
	 * 
	 * 描述: 国家局商标总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer tmDetailInfoTotal(Map<String, Object> map) throws Exception{
		return smEntAbovescaleMapper.tmDetailInfoTotal(map);
	}
    
    
}