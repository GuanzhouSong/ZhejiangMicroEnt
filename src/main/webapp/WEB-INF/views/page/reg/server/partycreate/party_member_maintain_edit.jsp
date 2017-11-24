<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>详细信息</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<style type="text/css">
.gold{background-color: #fff4df;}
</style>
<body class="pd10">
<form id="hx-form">
    <input type="hidden" id="priPID" name="priPID" value="${dto.priPID}">
    <input type="hidden" id="busExcList" name="busExcList" value="${busExcList}">
    <input type="hidden" id="entTypeFlag" name="entTypeFlag" value="${entTypeFlag}">
    <input type="hidden" id="entTypeCatg" value="${dto.entTypeCatg}">
</form>
<div class="clearfix reg-company-basic reg-company-basic-yellowish">
    <div class="clearfix reg-caption">
        <div class="title clearfix">
            <span class="name fl mr5">${dto.entName}</span>
            <span class="${hx:yReportStyle(dto.regState)}">${hx:publicStatus(dto.regState)}</span>
            <c:if test="${dto.isIndivid=='1'}"> 
             <span class="icon-rectangle blue fl mr10">个转企</span>
            </c:if>
            <c:if test="${isOpanomaly=='1'}">
             <span class="icon-rectangle red fl mr10">被列入经营异常名录和严重违法失信（黑名单）</span>
            </c:if>
            <c:if test="${isOpanomaly=='2'}">
             <span class="icon-rectangle red fl mr10">被列入经营异常名录</span>
            </c:if>
            <c:if test="${isOpanomaly=='3'}">
             <span class="icon-rectangle red fl mr10">被列入严重违法失信（黑名单）</span>
            </c:if>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="book2-icon"></i>统一社会信用代码/注册号：<span>${empty dto.uniCode?dto.regNO:dto.uniCode}</span>
            </p>
            <p>
                <i class="local-icon"></i>登记机关：<span>${dto.regOrgName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="person-icon"></i>法定代表人：<span>${dto.leRep}</span>
            </p>
            <p>
                <i class="government-icon"></i>管辖单位：<span>${dto.localAdmName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="capital-icon"></i>注册资本：<span><fmt:formatNumber value="${dto.regCap}" pattern="###,###,###,##0.0000"/>万元</span>
            </p>
            <p><i class="date-icon"></i>成立日期：<span><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></span></p>
        </div>
        <div class="clearfix">
           <c:if test="${dto.isIndivid=='1'}"> 
            <p class="w360">
                <i class="date-icon"></i>转企日期：<span><fmt:formatDate value="${dto.individDate}" pattern="yyyy-MM-dd"/></span>
            </p>
           </c:if> 
            <p>
                <c:if test="${dto.regState=='D'}">
	                <i class="date-icon"></i>吊销日期：
	                <span class="light"><fmt:formatDate value="${dto.punishDate}" pattern="yyyy-MM-dd"/></span>
                </c:if>
                <c:if test="${dto.regState=='XX'||dto.regState=='DX'}">
	                <i class="date-icon"></i>注销日期：
	                <span class="light"><fmt:formatDate value="${dto.altDate}" pattern="yyyy-MM-dd"/></span>
                </c:if>
            </p>
        </div>
        <div class="btn-box ent">
            <div class="mb5 clearfix">
                <a class="btn-attention-box">
                    <i class="attention-icon"></i>
                    <span>关注本企业</span>
                </a>
                <a class="btn-print-box">
                    <i class="print-icon2"></i>
                    <span>打印</span>
                </a>
            </div>
            <div>
                <a class="btn-attention-box">
                    <i class="query-icon"></i>
                    <span>关系网查询</span>
                </a>
                <a class="btn-print-box">
                    <i class="export-icon"></i>
                    <span>导出</span>
                </a>
            </div>
        </div>
    </div>
    <c:if test="${!empty isEscApp && isEscApp.simplecanRea =='4'}">
    <div class="notice"><i class="notice-icon"></i>正在进行简易注销公告：公告期：<fmt:formatDate value="${isEscApp.noticeFrom}" pattern="yyyy年MM月dd日"/>
           至<fmt:formatDate value="${isEscApp.noticeTo}" pattern="yyyy年MM月dd日"/></div>
    </c:if>
</div>
<div class="mb5">
    <span class="tag-block-item ft14 mr30"><i class="tag33cccc"></i>分类监管项目（<em class="light">${apprMarkRelDtoSize }</em>）/抽查专项库（<em class="light">${apprMarkRelSccount }</em>）</span>
    <span class="tag-block-item ft14 mr30"><i class="tagff6666"></i>重点监管对象（<em class="light">${csSuperviseObjDtoSize }</em>）</span>
    <span class="tag-block-item ft14 mr30"><i class="tag66cc66"></i>关注服务对象（<em class="light">${csConcernObjDtoSize }</em>）</span>
    <span class="tag-block-item ft14 mr30"><i class="tagff6600"></i>预警提醒提示（<em class="light">${tipsSize }</em>）</span>
</div>
<div class="mb5">
	<c:forEach var="apprMarkRelDto" items="${apprMarkRelDtos }">
	    <span class="tag33cccc tag-item">${apprMarkRelDto.markName }</span>
	</c:forEach>
	<c:forEach var="csSuperviseObjDto" items="${csSuperviseObjDtoList }">
	    <span class="tagff6666 tag-item">${csSuperviseObjDto.markName }</span>
	</c:forEach>
	<c:forEach var="csConcernObjDto" items="${csConcernObjDtoList }">
	    <span class="tag66cc66 tag-item">${csConcernObjDto.markName }</span>
	</c:forEach>
	<c:forEach var="tip" items="${tips}">
	    <span class="tagff6600 tag-item">${tip}</span>
	</c:forEach>
</div>
<div class="light-info mt10">
    <div class="form-list light ">
        <div class="form-item clearfix">
            <div id="uniCode" class="col-4">
                <label class="right col-6">法定代表人（负责人）：</label>
                <div class="col-6">
                    ${dto.leRep}     ${dto.tel}
                </div>
            </div>
            <div class="col-4" id="entName">
                <label class="right col-6">工商联络员：</label>
                <div class="col-6">
                   ${liaName}   ${liaTel}
                </div>
            </div>
        </div>
    </div>
</div>
    <div class="party-info-wrap">
        <div class="party-title">
            <span class="fl mt5 mr5"></span>企业党建信息
        </div>
        <div class="party-info-con">
           <form id="entInfoFrom">
                <input type="hidden" name="priPID" value="${dto.priPID}">
                <input type="hidden" name="entName" value="${dto.entName}">
                <input type="hidden" name="UID" value="${partyEntInfo.UID}">
	            <div class="center party-whether">
	                <label class="item-name"><span class="start">*</span>个体户或企业是否自身建有党组织：</label>
	                    <input type="radio" id="isBuildOrg" class="isBuild" name="isBuildPartyOrg" value="1"  ${empty partyEntInfo?(lastYearInfo.partOrgIs==1?'checked':''):(partyEntInfo.isBuildPartyOrg ==1?'checked':'')}> 是
	                    <input type="radio" class="isBuild" name="isBuildPartyOrg" value="0"  ${empty partyEntInfo?(lastYearInfo.partOrgIs!=1?'checked':''):(partyEntInfo.isBuildPartyOrg ==0?'checked':'')}> 否
	            </div>
	            
	         <div id="entinfo" style="display: none">
	            <div class="form-item clearfix pd50">
	                <div class="col-6">
	                    <label class="item-name col-8"><span class="start">*</span>党组织建制：</label>
	                    <div class="col-4">
	                        <div class="ipt-box col-12">
	                            <select name="buildOrgType" id="buildOrgType" required="required">
	                                <option value="" ></option>
	                                <option value="1" ${empty partyEntInfo?(lastYearInfo.parIns==3?'selected':''):(partyEntInfo.buildOrgType ==1?'selected':'')}>党委</option>
	                                <option value="2" ${empty partyEntInfo?(lastYearInfo.parIns==2?'selected':''):(partyEntInfo.buildOrgType ==2?'selected':'')}>党总支</option>
	                                <option value="3" ${empty partyEntInfo?(lastYearInfo.parIns==1?'selected':''):(partyEntInfo.buildOrgType ==3?'selected':'')}>党支部</option>
	                            </select>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-6">
	                    <label class="item-name col-3"><span class="start">*</span>组建日期：</label>
	                    <div class="col-4">
	                        <div class="ipt-box col-12">
	                            <div class="ipt-box col-12">
	                            <c:if test="${empty partyEntInfo}">
	                               <input type="text" class="ipt-txt clx pointer" id="createOrgTime" name="createOrgTime" onclick="laydate()" readonly="readonly" value="${lastYearInfo.parSetTime}" required="required"/>
	                            </c:if>
	                            <c:if test="${!empty partyEntInfo}">
	                               <input type="text" class="ipt-txt clx pointer" id="createOrgTime" name="createOrgTime" onclick="laydate()" readonly="readonly" value="<fmt:formatDate value="${partyEntInfo.createOrgTime}" pattern="yyyy-MM-dd" />" required="required">
	                            </c:if>
	                        </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="mb10 form-item clearfix pd50">
	                <div class="col-6">
	                    <label class="item-name col-8"><span class="start">*</span>党员人数（含预备党员）：</label>
	                    <div class="col-4">
	                        <div class="ipt-box col-12">
	                            <input type="text" class="ipt-txt clx" id="partyMemberNum" name="partyMemberNum" value="${empty partyEntInfo?lastYearInfo.numParM:partyEntInfo.partyMemberNum}" required="required">
	                        </div>
	                    </div>
	                </div>
	                <div class="col-6">
	                    <label class="item-name col-3"><span class="start">*</span>组建方式：</label>
	                    <div class="col-4">
	                        <div class="ipt-box col-12">
	                            <select name="buildOrgWay" id="buildOrgWay" required="required">
	                                <option value="" ></option>
	                                <option value="1" ${empty partyEntInfo?(lastYearInfo.parOrgW==1?'selected':''):(partyEntInfo.buildOrgWay ==1?'selected':'')}>单独组建</option>
	                                <option value="2" ${empty partyEntInfo?(lastYearInfo.parOrgW==2?'selected':''):(partyEntInfo.buildOrgWay ==2?'selected':'')}>联合组建</option>
	                            </select>
	                        </div>
	                    </div>
	                </div>
	            </div>
	          </div>
	           <c:if test="${viewFlag != '3'}">
		           <div id="topInfo" style="display: none" class="form-item clearfix pd50">
		                    <div class="btn-box mt10 mb10">
		                        <input type="button" id="save" value="保存" class="btn mr20">
		                    </div>
		             </div>
	           </c:if>
		  </form>
		
		<form id="memberform">	
		    <input type="hidden" id="memberUid" name="UID" value="${partyMemberInfo.UID}"/>
	        <input type="hidden" name="priPID" value="${dto.priPID}"/>
	        <input type="hidden" name="inputType" value="${partyMemberInfo.inputType}"/>
	        <input type="hidden" value="${viewFlag}"/>
	        <input type="hidden" id="originLoc" name="originLoc" value="${partyMemberInfo.originLoc}">
            <div id="partymemberinfo">
               <div id="cleardom">
	                <div class="list-title mb10">
	                    <span class="title-header ml10 mr10">党员户口信息</span>
	                </div>
	                <div class="form-item clearfix pd50">
	                    <div class="col-5">
	                        <label class="item-name col-7"><span class="color-red">* </span> 党员姓名：</label>
	                        <div class="col-5">
	                            <div class="ipt-box col-12">
	                                <input type="text" id="memberName"  name="memberName" value="${partyMemberInfo.memberName}" class="ipt-txt mr5" required="required"/>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-6">
	                        <label class="item-name col-3"><span class="color-red">* </span> 党员成分：</label>
	                        <div class="fl radio-box">
	                            <input type="radio" id="memberType1" name="memberType" value="1"   ${partyMemberInfo.memberType =='1'?'checked':''}/>业主
	                            <input type="radio" id="memberType2" name="memberType" value="2"   ${partyMemberInfo.memberType =='2'?'checked':''}/>从业人员
	                        </div>
	                    </div>
	                </div>
	                <div class="form-item clearfix pd50">
	                    <div class="col-5">
	                        <label class="item-name  col-7"><span class="color-red">* </span> 性别：</label>
	                        <div class="fl radio-box">
	                           <input type="radio" id="sex1" name="sex" value="1"  ${partyMemberInfo.sex==1?'checked':''}/>男
	                           <input type="radio" id="sex2" name="sex" value="2"  ${partyMemberInfo.sex==2?'checked':''}/>女
	                        </div>
	                    </div>
	                    <div class="col-6">
	                        <label class="item-name col-3"><span class="color-red">* </span> 党员类别：</label>
	                        <div class="fl radio-box">
	                           <input type="radio" id="pmType1" name="pmType" value="1"   ${partyMemberInfo.pmType =='1'?'checked':''}/>正式党员
	                           <input type="radio" id="pmType2" name="pmType" value="2"   ${partyMemberInfo.pmType =='2'?'checked':''}/>预备党员
	                        </div>
	                    </div>
	                </div>
	                <div class="form-item clearfix pd50">
	                    <div class="col-5">
	                        <label class="item-name col-7"><span class="color-red">* </span> 身份证号：</label>
	                        <div class="col-5">
	                            <div class="ipt-box col-12">
	                                <input type="text" id="identityInfo"  name="identityInfo" value="${partyMemberInfo.identityInfo}" class="ipt-txt mr5 idCard" required="required"/>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-6">
	                        <label class="item-name col-3"><span class="color-red">* </span> 党内职务：</label>
	                        <div class="fl radio-box">
	                            <input type="radio" id="partyPosition1" class="attrPos" name="partyPosition" value="1" ${partyMemberInfo.partyPosition =='1'?'checked':''}/>普通党员
	                            <input type="radio" id="partyPosition2" class="attrPos" name="partyPosition" value="2" ${partyMemberInfo.partyPosition =='2'?'checked':''}/>干部
	                            (<input type="checkbox" id="isSecretary1" name="isSecretary" value="1" ${partyMemberInfo.isSecretary =='1'?'':'disabled'} ${partyMemberInfo.isSecretary =='1'?'checked':''}/>担任书记)
	                        </div>
	                    </div>
	                </div>
	                <div class="form-item clearfix pd50">
	                    <div class="col-5">
	                        <label class="item-name col-7">出生年月：</label>
	                        <div class="col-5">
	                            <div class="ipt-box col-12">
	                                <input style="background-color: #f4f4f4;" type="text" id="birthday" readonly="readonly" class="ipt-txt mr5" name="" value="">
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-6">
	                        <label class="item-name col-3"><span class="color-red">* </span> 党员分布：</label>
	                        <div class="fl radio-box">
	                            <input type="radio" id="pmDistributed1" name="pmDistributed" value="1"  ${partyMemberInfo.pmDistributed =='1'?'checked':''}/>个体
	                            <input type="radio" id="pmDistributed0" name="pmDistributed" value="0"  ${partyMemberInfo.pmDistributed =='0'?'checked':''}/>市场
	                        </div>
	                    </div>
	                </div>
	                <div class="form-item clearfix pd50">
	                    <div class="col-5">
	                        <label class="item-name col-7">年龄：</label>
	                        <div class="col-5">
	                            <div class="ipt-box col-12">
	                                <input style="background-color: #f4f4f4;" type="text"  id="memberAge"  name="memberAge" value="${partyMemberInfo.memberAge}"  readonly="readonly" class="ipt-txt mr5">
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-6">
	                        <label class="item-name col-3"><span class="color-red">* </span> 户籍所在地：</label>
	                        <div class="col-8">
	                            <div class="col-3 mr10">
	                                <div class="ipt-box col-12">
	                                    <select name="locProvince" id="locProvince" required="required">
	                                        <option value="33" ${(partyMemberInfo.locProvince =='3301')?'selected':''}>浙江省</option>
	                                    </select>
	                                </div>
	                            </div>
	                            
	                          <div id="locChoose">  
		                            <div class="col-3 mr10">
		                                <div class="ipt-box col-12">
		                                    <select name="locCity" id="locCity">
		                                        <option value="" ></option>
		                                        <option value="3301" ${(partyMemberInfo.locCity =='3301')?'selected':''}>杭州市</option>
												<option value="3302" ${(partyMemberInfo.locCity =='3302')?'selected':''}>宁波市</option>
												<option value="3303" ${(partyMemberInfo.locCity =='3303')?'selected':''}>温州市</option>
												<option value="3304" ${(partyMemberInfo.locCity =='3304')?'selected':''}>嘉兴市</option>
												<option value="3305" ${(partyMemberInfo.locCity =='3305')?'selected':''}>湖州市</option>
												<option value="3306" ${(partyMemberInfo.locCity =='3306')?'selected':''}>绍兴市</option>
												<option value="3307" ${(partyMemberInfo.locCity =='3307')?'selected':''}>金华市</option>
												<option value="3308" ${(partyMemberInfo.locCity =='3308')?'selected':''}>衢州市</option>
												<option value="3309" ${(partyMemberInfo.locCity =='3309')?'selected':''}>舟山市</option>
												<option value="3310" ${(partyMemberInfo.locCity =='3310')?'selected':''}>台州市</option>
												<option value="3311" ${(partyMemberInfo.locCity =='3311')?'selected':''}>丽水市</option>
		                                    </select>
		                                </div>
		                            </div>
		                            <div style="float: right" class="col-5">
		                                <div class="ipt-box col-12">
		                                    <select name="locCounty" id="locCounty">
		                                       <option value=""></option>
												 <c:forEach var="codeAddresses" items="${codeAddresses}">
													 <option value="${codeAddresses.code}"  ${(codeAddresses.code==partyMemberInfo.locCounty)?'selected':''}>${codeAddresses.addressName}</option>
												 </c:forEach>
		                                    </select>
		                                </div>
		                            </div>
	                            </div>
	                        </div>
	
	                    </div>
	                </div>
	                <div class="form-item clearfix pd50">
	                    <div class="col-5">
	                        <label class="item-name  col-7"><span class="color-red">* </span> 民族：</label>
	                        <div class="fl radio-box">
	                           <input type="radio" id="nationality1" name="nationality" value="1" ${partyMemberInfo.nationality =='1'?'checked':''}/>汉族
	                           <input type="radio" id="nationality2" name="nationality" value="2" ${partyMemberInfo.nationality =='2'?'checked':''}/>其它
	                        </div>
	                    </div>
	                    <div class="col-6">
	                        <label class="item-name col-3"><span class="color-red">* </span> 组织关系所在地：</label>
	                        <div class="col-8">
	                            <div class="ipt-box col-12">
	                                 <select id="orgRelationLoc" name="orgRelationLoc" required="required">
			                          <option value="">-请选择-</option>
			                          <option value="1" ${partyMemberInfo.orgRelationLoc == '1'?'selected':''}>在本辖区街道、社区、村党组织</option>
			                          <option value="2" ${partyMemberInfo.orgRelationLoc == '2'?'selected':''}>在本辖个私协会党组织</option>
			                          <option value="3" ${partyMemberInfo.orgRelationLoc == '3'?'selected':''}>在本辖区市场党组织</option>
			                          <option value="4" ${partyMemberInfo.orgRelationLoc == '4'?'selected':''}>在原籍党组织的流动党员</option>
			                        </select>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="form-item clearfix pd50">
	                    <div class="col-5">
	                        <label class="item-name col-7"><span class="color-red">* </span> 最高学历：</label>
	                        <div class="col-5">
	                            <div class="ipt-box col-12">
	                                 <select id="qualifications" name="qualifications" required="required">
			                          <option value="">-请选择-</option>
			                          <option value="1" ${partyMemberInfo.qualifications == '1'?'selected':''}>小学</option>
			                          <option value="2" ${partyMemberInfo.qualifications == '2'?'selected':''}>初中</option>
			                          <option value="3" ${partyMemberInfo.qualifications == '3'?'selected':''}>高中</option>
			                          <option value="4" ${partyMemberInfo.qualifications == '4'?'selected':''}>大专</option>
			                          <option value="5" ${partyMemberInfo.qualifications == '5'?'selected':''}>本科</option>
			                          <option value="6" ${partyMemberInfo.qualifications == '6'?'selected':''}>研究生</option>
			                          <option value="7" ${partyMemberInfo.qualifications == '7'?'selected':''}>硕士</option>
			                          <option value="8" ${partyMemberInfo.qualifications == '8'?'selected':''}>博士</option>
			                          <option value="9" ${partyMemberInfo.qualifications == '9'?'selected':''}>博士后</option>
			                        </select>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-6">
	                        <label class="item-name col-3"><span class="color-red">* </span> 所属党组织：</label>
	                        <div class="col-8">
	                            <div class="ipt-box col-12">
	                                 <input type="hidden" class="ipt-txt" name="partyOrgID" id="partyOrgID" value="${partyMemberInfo.partyOrgID}""/>
			                         <input type="text" class="ipt-txt" id="partyOrgName" name="partyOrgName" value="${partyMemberInfo.partyOrgName}" 
			                         required="required" readonly="readonly" placeholder="如未找到，企业自身建有党组织的可直接录入"/>
			                          <span class="add-icon" id="choseOrg">
			                              <i></i>
			                          </span>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="form-item clearfix pd50">
	                    <div class="col-5">
	                        <label class="item-name  col-7"><span class="color-red">* </span> 党务工作者：</label>
	                        <div class="fl radio-box">
	                            <input type="radio" id="partyWorker1" name="partyWorker" value="1" ${partyMemberInfo.partyWorker =='1'?'checked':''}/>是
	                            <input type="radio" id="partyWorker0" name="partyWorker" value="0" ${partyMemberInfo.partyWorker =='0'?'checked':''}/>否
	                        </div>
	                    </div>
	                    <div class="col-6">
	                        <label class="item-name col-3"><span class="color-red">* </span> 所属市场：</label>
	                        <div class="col-8">
	                            <div class="ipt-box col-12">
	                                <input type="text" id="belongMarket"  name="belongMarket" value="${partyMemberInfo.belongMarket}" class="ipt-txt" required="required"/>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="form-item clearfix pd50">
	                    <div class="col-5">
	                        <label class="item-name col-7">手机号码：</label>
	                        <div class="col-5">
	                            <div class="ipt-box col-12">
	                                <input type="text" id="phoneNum"  name="phoneNum" value="${partyMemberInfo.phoneNum}" class="ipt-txt mr5 checkMobile"/>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-6">
	                        <label class="item-name col-3">入党时间：</label>
	                        <div class="col-8">
	                            <div class="ipt-box col-12">
	                                <input type="text" id="joinPartyTime" name="joinPartyTime" onclick="laydate()" readonly="readonly"
	                       			 value="<fmt:formatDate value="${partyMemberInfo.joinPartyTime}" pattern="yyyy-MM-dd" />" class="ipt-txt mr5 pointer"/>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="form-item clearfix pd50">
	                    <div class="col-5">
	                        <label class="item-name col-7">联系电话：</label>
	                        <div class="col-5">
	                            <div class="ipt-box col-12">
	                                <input type="text" id="telNum"  name="telNum" value="${partyMemberInfo.telNum}" class="ipt-txt mr5 telandphone"/>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-6">
	                        <label class="item-name col-3">组织关系登记日期：</label>
	                        <div class="col-8">
	                            <div class="ipt-box col-12">
	                                <input type="text" id="orgRegisterTime" name="orgRegisterTime" onclick="laydate()" readonly="readonly" 
	                                value="<fmt:formatDate value="${partyMemberInfo.orgRegisterTime}" pattern="yyyy-MM-dd" />" class="ipt-txt mr5 pointer" />
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="mb5 form-item clearfix pd50">
	                    <div class="">
	                        <label style="width: 24.3%!important;" class="item-name col-3 bz-lb">备注：</label>
	                        <div class="col-9">
	                            <div style="width: 84.3%!important;" class="ipt-box col-12">
	                                <textarea id="remark" style="background-color: #F4F4F4;" class="bz-tt" name="remark" cols="30" rows="10">${partyMemberInfo.remark}</textarea>
	                            </div>
	                        </div>
	                    </div>
	                </div>
               </div>

                <div class="mb5 form-item clearfix pd50">
                    <div class="">
                        <label style="width: 24.3%!important;" class="item-name col-3">操作员：</label>
                        <div class="col-9">
                            <div style="width: 84.3%!important;" class="ipt-box">
                                <div style="width: 15%; margin-right: 10%;" class="fl ipt-box pdr5">
                                        <input style="background-color: #F4F4F4;" id="auditName" readonly="readonly" type="text" class="ipt-txt mr5" name="auditName" value="${viewFlag =='1'?sessionScope.session_sys_user.realName:partyMemberInfo.auditName}">
                                </div>
                                <label class="item-name fl">修改日期：</label>
                                <div class="fl pdr5" style="width: 15%;">
                                    <div class="ipt-box fl">
                                        <c:if test="${viewFlag =='1'}">
				                            <input type="text" id="modifyTime" name="modifyTime"  readonly="readonly" style="background-color: #F4F4F4"
				                       		 value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" class="ipt-txt pointer mr5" required="required"/>
				                       </c:if>
				                       <c:if test="${viewFlag !='1'}">
					                        <input type="text" id="modifyTime" name="modifyTime"  readonly="readonly" style="background-color: #F4F4F4"
					                        value="<fmt:formatDate value="${partyMemberInfo.modifyTime}" pattern="yyyy-MM-dd" />" class="ipt-txt pointer mr5" required="required"/>
				                        </c:if>
                                    </div>
                                </div>

                                <div class="fr">
                                    <label class="item-name fl">建档日期：</label>
                                    <div class="fl pdr5">
                                        <div class="ipt-box">
                                            <c:if test="${viewFlag =='1'}">
				                            <input type="text" id="createTime" name="createTime" readonly="readonly" style="background-color: #F4F4F4"
				                       		 value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" class="ipt-txt pointer mr5" required="required"/>
					                       </c:if>
					                       <c:if test="${viewFlag !='1'}">
						                        <input type="text" id="createTime" name="createTime" readonly="readonly" style="background-color: #F4F4F4"
						                        value="<fmt:formatDate value="${partyMemberInfo.createTime}" pattern="yyyy-MM-dd" />" class="ipt-txt pointer mr5" required="required"/>
					                       </c:if>
                                       </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
	                <div class="form-item clearfix pd50">
	                    <div class="btn-box mt10 mb20">
	                      <c:if test="${viewFlag != '3'}">
	                        <input type="submit" id="savemember" value="保存" class="btn mr20">
	                      </c:if>
	                        <input type="button" id="closemember" value="关闭" class="btn mr20">
	                    </div>
	                </div>
	            </div>
            </form>
                        <div class="list-title">
            <c:if test="${viewFlag != '3'}">        
                <span class="title-header ml10 mr10">党员列表</span> <span class="color-red">提示：选中某条信息进行修改或查看操作。</span>
            </c:if>
            <c:if test="${viewFlag == '3'}">        
                <span class="title-header ml10 mr10">党员列表</span> <span class="color-red">提示：选中某条信息进行查看操作。</span>
            </c:if>
            </div>

            <form id="search-form" class="form-box" novalidate="novalidate">
                <input type="hidden" name="priPID" value="${dto.priPID}"/>
                <div class="form-list">
                    <div class="form-item clearfix">


                        <div class="col-3 ipt-box pdr5">
                            <label class="item-name col-8">党员姓名：</label>
                            <div class="col-4">
                                <input type="text" id="memberName" class="ipt-txt mr5" name="memberName" value="">
                            </div>
                        </div>
                        <div class="col-2 pdr5">
                            <label class="item-name col-6">是否业主：</label>
                            <div class="ipt-box col-6">
                                <select name="memberType">
                                    <option value=""></option>
                                    <option value="1">是</option>
                                    <option value="2">否</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-2 pdr5 mr20">
                            <label class="item-name col-6">是否书记：</label>
                            <div class="ipt-box col-6">
                                <select id="isSecretary" name="isSecretary">
                                    <option value="">全部</option>
                                    <option value="1">是</option>
                                    <option value="0">否</option>
                                </select>
                            </div>
                        </div>


                        <div class="col-4">
                            <input id="searchBtn" type="button" value="查询" class="btn mr20">
                        </div>
                    </div>

                </div>
            </form>

            <div class="party-table">
                <table id="table_dyxx" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100  mt30 nowrap" style="width:100%;">
                    <thead>
                      <tr>
                            <th>序号</th>
                            <th>党员姓名</th>
                            <th>身份证号</th>
                            <th>性别</th>
                            <th>年龄</th>
                            <th>学历</th>
                            <th>民族</th>
                            <th>入党时间</th>
                            <th>是否业主</th>
                            <th>是否书记</th>
                            <th>党员类别</th>
                            <th>党内职务</th>
                            <th>党员分布</th>
                            <th>户籍所在地</th>
                            <th>组织关系所在</th>
                            <th>所属党组织</th>
                            <th>修改日期</th>
                            <th>建档日期</th>
                            <th>操作员</th>
                      </tr>
                    </thead>
                </table>
            </div>
            
            <div id="commitinfo" class="form-item clearfix pd50">
                    <div class="btn-box mb10">
<!--                         <input type="button" id="commit" value="提交" class="btn mr20"> -->
                        <input type="button" id="close" value="关闭" class="btn mr20">
                    </div>
	         </div>
            
        </div>
        
        <div class="party-title border-bottom">
            <span class="fl mt5 mr5"></span>近三年年报相关记录
            <!-- <a href="#" class="open-info">展开</a> -->
        </div>
         <div>
            <table id="table_threeyear" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100  mt30 nowrap" style="width:100%;">
                  <thead>
                      <tr>
                      <th>序号</th>
                      <th>年报年度</th>
                      <th>年报日期</th>
                      <th>最近修改日期</th>
                      <th>从业人员数</th>
                      <th>党员人数（含预备党员）</th>
                      <th>法定代表人/负责人是否为党员</th>
                      <th>是否为书记</th>
                      <th>党组织建制</th>
                      <th>组建日期</th>
                      <th>组建方式</th>
                      </tr>
                  </thead>
             </table>
	   </div>
    </div>
    
<form>
  <input type="hidden" id="priPID" name="priPID" value="${dto.priPID}">
  <input type="hidden" id="entType"  value="${dto.entType}">
</form>
<script>
window._CONFIG = {
    viewFlag:'${viewFlag}', 
}
</script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/partycreate/party_member_maintain_edit.js"/>"></script>
</body>
</html>
