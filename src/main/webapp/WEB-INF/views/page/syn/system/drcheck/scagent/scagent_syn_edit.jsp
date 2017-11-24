<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
	<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body>
<form id="sysUserForm">
    <div class="pd20 clearfix">
        <h3 class="h3-title center"></h3>
        <input type="hidden" id="dutyDeptCode"  value="${dutyDeptCode}">
        <input type="hidden" name="deptCode" id="deptCode" value="${sessionDeptCode}"/>
        <input type="hidden" id="locAreaName" name="locAreaName" value="${pubScagent.locAreaName}">
        <input type="hidden" id="agentArea" name="agentArea" value="${pubScagent.agentArea}">
        <input type="hidden" id="detailsFlag"  value="${detailsFlag}">
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
            <tr>
                <td class="bg-gray right" width="15%">单位工号：</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="hidden" name="UID" value="${pubScagent.UID }"/>
                        <input type="text" id="employeeNO" name="employeeNO" value="${pubScagent.employeeNO}" class="ipt-txt required"/>
                    </div>
                </td>
                <td class="bg-gray right"><span class="light">*</span>工作单位：</td>
                <td colspan="3">
                    <div class="ipt-box pd0">
                      <input type="hidden" id="localAdm"  name="slicenNO" value="${empty pubScagent.slicenNO?adCode:pubScagent.slicenNO}"/>
                      <input type="text" class="ipt-txt" id="localAdmName" name="slicenNOName" value="${empty pubScagent.slicenNOName?sessionScope.session_sys_user.dept:pubScagent.slicenNOName}" readonly/>
                       <span class="add-icon" id="choseregUnit">
                           <i></i>
                      </span>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span class="light">*</span>性别：</td>
                <td>
                    <div class="ipt-box pd0" id="agentSexDiv">
                    	<input type="radio" name="agentSex" id="agentSex1" value="1" <c:if test="${pubScagent.agentSex == '1'}">checked="checked"</c:if>/>男
                    	<input type="radio" name="agentSex" value="2" <c:if test="${pubScagent.agentSex == '2'}">checked="checked"</c:if>/>女
                    </div>
                </td>
               <td class="bg-gray right"><span class="light">*</span>单位层级：</td>
                <td colspan="3">
                    <div class="ipt-box pd0" id="unitLevelDiv">
                    	<input type="hidden" id="unitType" name="unitType"/>
                    	<input type="radio" value="3" name="unitLevel" id="unitLevel1" <c:if test="${pubScagent.unitLevel == '3'}">checked="checked"</c:if>/>省级
                    	<input type="radio" value="1" name="unitLevel" <c:if test="${pubScagent.unitLevel == '1'}">checked="checked"</c:if>/>市级
                    	<input type="radio" value="2" name="unitLevel" <c:if test="${pubScagent.unitLevel == '2'}">checked="checked"</c:if>/>县级
                    	<input type="radio" value="4" name="unitLevel" <c:if test="${pubScagent.unitLevel == '4'}">checked="checked"</c:if>/>所级
                    </div>
                </td>
            </tr>
            <tr>
            	<td class="bg-gray right"><span class="light">*</span>姓名：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="agentName" id="agentName" value="${pubScagent.agentName }" class="ipt-txt required"/>
                    </div>
                </td>
                <td class="bg-gray right">单位所在区划：</td>
                <td colspan="3">
                     <div id="locChoose">  
                        <div style="width: 18%;margin-right: 10px">
                            <div class="ipt-box col-12">
                                <select name="locCity" id="locCity">
                                    <option value="" ></option>
                                    <option value="3301" ${(pubScagent.locCity =='3301')?'selected':''}>杭州市</option>
									<option value="3302" ${(pubScagent.locCity =='3302')?'selected':''}>宁波市</option>
									<option value="3303" ${(pubScagent.locCity =='3303')?'selected':''}>温州市</option>
									<option value="3304" ${(pubScagent.locCity =='3304')?'selected':''}>嘉兴市</option>
									<option value="3305" ${(pubScagent.locCity =='3305')?'selected':''}>湖州市</option>
									<option value="3306" ${(pubScagent.locCity =='3306')?'selected':''}>绍兴市</option>
									<option value="3307" ${(pubScagent.locCity =='3307')?'selected':''}>金华市</option>
									<option value="3308" ${(pubScagent.locCity =='3308')?'selected':''}>衢州市</option>
									<option value="3309" ${(pubScagent.locCity =='3309')?'selected':''}>舟山市</option>
									<option value="3310" ${(pubScagent.locCity =='3310')?'selected':''}>台州市</option>
									<option value="3311" ${(pubScagent.locCity =='3311')?'selected':''}>丽水市</option>
                                </select>
                            </div>
                        </div>
                        <div style="float: left;width: 30%;margin-left: 10px">
                            <div class="ipt-box col-12">
                                <select name="locCounty" id="locCounty">
                               		<option value=""></option>
									<c:forEach var="addressCounty" items="${addressCounty}">
										 <option value="${addressCounty.code}"  ${(addressCounty.code==pubScagent.locCounty)?'selected':''}>${addressCounty.addressName}</option>
									</c:forEach>
                                </select>
                            </div>
                        </div>
                        <div style="float: left;width: 43%;margin-left: 10px">
                            <div class="ipt-box col-12">
                               <select name="locAddress" id="locAddress">
                               		<option value=""></option>
									<c:forEach var="addressStreet" items="${addressStreet}">
										 <option value="${addressStreet.code}"  ${(addressStreet.code==pubScagent.locAddress)?'selected':''}>${addressStreet.addressName}</option>
									</c:forEach>
                                </select>
                            </div>
                        </div>
                     </div>
                </td>
            </tr>
            
             <tr>
             	<td class="bg-gray right"><span class="light">*</span>身份证号：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="agentNO" id="agentNO" class="ipt-txt  idCard" value="${pubScagent.agentNO}" <c:if test="${!empty pubScagent.UID }">disabled="disabled"</c:if>/>
                    </div>
                </td>
                <td class="bg-gray right"><span class="light">*</span>所在业务部门（机构）：</td>
                <td colspan="3">
                    <div class="ipt-box pd0">
<%--                         <input type="hidden" name="unitCode" id="unitCode" value="${pubScagent.unitCode }"/> --%>
                        <input type="text" id="unitName" name="unitName" value="${pubScagent.unitName }" class="fl ipt-txt">
<!--                         <span class="add-icon" id="unitChoose"><i></i></span> -->
                    </div>
                </td>
            </tr>
            <tr>
             	<td class="bg-gray right">出生年月：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="birthDay" id="birthDay" value="${pubScagent.birthDay}" disabled="disabled" id="birthDay" class="ipt-txt required"/>
                    </div>
                </td>
                <td class="bg-gray right"><span class="light">*</span>担任职务类别：</td>
                <td colspan="3">
                    <div class="ipt-box pd0">
                      <select name="agentPosition" id="agentPosition" class="required">
                            <option value=""></option>
                            <option value="1" <c:if test="${pubScagent.agentPosition == '1'}">selected</c:if>>局领导</option>
                            <option value="2" <c:if test="${pubScagent.agentPosition == '2'}">selected</c:if>>科室（处、办、中心）负责人（正职）</option>
                            <option value="3" <c:if test="${pubScagent.agentPosition == '3'}">selected</c:if>>科室（处、办、中心）负责人（副职）</option>
                            <option value="4" <c:if test="${pubScagent.agentPosition == '4'}">selected</c:if>>所（站、分局）长（正职）</option>
                            <option value="5" <c:if test="${pubScagent.agentPosition == '5'}">selected</c:if>>所（站、分局）长（副职）</option>
                            <option value="6" <c:if test="${pubScagent.agentPosition == '6'}">selected</c:if>>一般干部</option>
                        </select>
                    </div>
                </td>
            </tr>
            <tr>
             	<td class="bg-gray right">年龄：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="agentAge" value="${pubScagent.agentAge}" disabled="disabled" id="agentAge" class="ipt-txt required"/>
                    </div>
                </td>
                <td class="bg-gray right">具体职务：</td>
                <td colspan="3">
                    <div class="ipt-box pd0">
                        <input type="text" name="concreteDuties" value="${pubScagent.concreteDuties}"  id="concreteDuties" class="ipt-txt"/>
                    </div>
                </td>
            </tr>
             <tr>
             	<td class="bg-gray right"><span class="light">*</span>手机号码：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="mobile" id="mobile" class="ipt-txt required" value="${pubScagent.mobile}"/>
                    </div>
                </td>
                <td class="bg-gray right"><span class="light">*</span>从事岗位（大类）：</td>
                <td colspan="3">
                    <div class="ipt-box pd0" id="deptCatgDiv">
                        <input type="hidden" class="ipt-txt" name="deptCatg" id="deptCatg" value=""/>
                        <select id="deptCatgM" multiple="multiple">
                        	<c:forEach items="${codePositionTypeList}" var="codePositionType">
	                            <option value="${codePositionType.positionCode}" ${fn:indexOf(pubScagent.deptCatg,codePositionType.positionCode)!=-1?'selected="selected"':''}>${codePositionType.positionName}</option>
	                    	</c:forEach>
                        </select>
                    </div>
                </td>
            </tr>
            <tr>
            	<td class="bg-gray right">最高学历：</td>
                <td>
                    <div class="ipt-box pd0">
                        <select name="studyLevel" id="studyLevel">
                            <option value=""></option>
                            <option value="8" <c:if test="${pubScagent.studyLevel == '8'}">selected</c:if>>小学</option>
                            <option value="4" <c:if test="${pubScagent.studyLevel == '4'}">selected</c:if>>初中</option>
                            <option value="5" <c:if test="${pubScagent.studyLevel == '5'}">selected</c:if>>高中</option>
                            <option value="1" <c:if test="${pubScagent.studyLevel == '1'}">selected</c:if>>大专</option>
                            <option value="2" <c:if test="${pubScagent.studyLevel == '2'}">selected</c:if>>本科</option>
                            <option value="3" <c:if test="${pubScagent.studyLevel == '3'}">selected</c:if>>研究生</option>
                            <option value="6" <c:if test="${pubScagent.studyLevel == '6'}">selected</c:if>>硕士</option>
                            <option value="7" <c:if test="${pubScagent.studyLevel == '7'}">selected</c:if>>博士</option>
                            <option value="9" <c:if test="${pubScagent.studyLevel == '9'}">selected</c:if>>博士后</option>
                        </select>
                    </div>
                </td>
                <td class="bg-gray right">从事本岗起始日期：</td>
                <td colspan="3">
                    <div class="ipt-box pd0">
                        <input type="text" class="ipt-txt laydate-icon" name="workTime" id="workTime" value="<fmt:formatDate  value='${pubScagent.workTime}' type='both' pattern='yyyy-MM-dd' />" readonly onclick="laydate()">
                    </div>
                </td>
             </tr>
             <tr>
                <td class="bg-gray right">学历专业：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="professionals" id="professionals" class="ipt-txt " placeholder="与最高学历对应的院校专业名称" value="${pubScagent.professionals}"/>
                    </div>
                </td>
                <td class="bg-gray right">执法证编号：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="lawNO" id="lawNO" class="ipt-txt" value="${pubScagent.lawNO }"/>
                    </div>
                </td>
                <td class="bg-gray right" width="10%">有效期至：</td>
                <td width="10%">
                    <div class="ipt-box pd0">
	                        <input type="text" class="ipt-txt laydate-icon" name="lawEndDate" value="<fmt:formatDate  value='${pubScagent.lawEndDate}' type='both' pattern='yyyy-MM-dd' /> " readonly onclick="laydate()">
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">个人专业技术职称：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" name="technicalTitle" id="technicalTitle" class="ipt-txt" value="${pubScagent.technicalTitle }"/>
                    </div>
                </td>
                 <td class="bg-gray right">发证机关：</td>
                <td colspan="3">
                    <div class="ipt-box pd0">
                        <input type="text" id="certificateDept" name="certificateDept" value="${pubScagent.certificateDept}" class="fl ipt-txt">
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span class="light">*</span>获得岗位资格资质：</td>
                <td colspan="5">
                    <div class="ipt-box pd0" id="stationTermDiv">
                    	<input type="hidden" id="stationTerm" name="stationTerm"/>
                        <input type="radio" value="N" id="stationTermN" name="stationTermM" ${fn:indexOf(pubScagent.stationTerm,'N')!=-1?'checked':''}/>无
                        <input type="radio" value="Y" id="stationTermM" name="stationTermM" ${fn:indexOf(pubScagent.stationTerm,'Y')!=-1?'checked':''}/>有
                        <span style="color: blue;">(</span>
                        <c:forEach items="${codeRightTypeList}" var="codeRightType">
	                        <input type="checkbox" value="${codeRightType.rightCode}" class="stationTermM" ${fn:indexOf(pubScagent.stationTerm,codeRightType.rightCode)!=-1?'checked':''} ${fn:indexOf(pubScagent.stationTerm,'N')!=-1?'disabled="disabled"':''}/>${codeRightType.rightName}
                    	</c:forEach>
                        <span style="color: blue;">)</span>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span class="light">*</span>是否属于专家：</td>
                <td colspan="5">
                    <div class="ipt-box pd0" id="expertFlagDiv">
                    	<input type="hidden" id="expertFlag" name="expertFlag"/>
                        <input type="radio" id="expertFlagN" name="expertFlagM" value="N" ${fn:indexOf(pubScagent.expertFlag,'N')!=-1?'checked':''}/>否
                        <input type="radio" id="expertFlagM" name="expertFlagM" value="Y" ${fn:indexOf(pubScagent.expertFlag,'Y')!=-1?'checked':''}/>是
                        <span style="color: blue;">(</span>
                        <c:forEach items="${codeExpertTypeList}" var="codeExperType">
                       	 	<input type="checkbox" value="${codeExperType.expertCode}" class="expertFlagK" ${fn:indexOf(pubScagent.expertFlag,codeExperType.expertCode)!=-1?'checked':''} ${fn:indexOf(pubScagent.expertFlag,'N')!=-1?'disabled="disabled"':''}/>${codeExperType.expertName }
                    	</c:forEach>
                        <span style="color: blue;">)</span>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span class="light">*</span>执法事项清单范围：</td>
                <td colspan="5">
                    <div class="ipt-box pd0">
                    	<input type="hidden" id="agentRange" name="agentRange"/>
                    	<a href="javascript:void(0);" id="agentRangeA">选择执法事项清单</a>
                        <textarea rows="" cols="" style="height:80px;margin-top: 5px;" id="agentRangeName" name="agentRangeName" readonly="readonly">${pubScagent.agentRangeName }</textarea>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span class="light">*</span>执法人员状态：</td>
                <td colspan="5">
                    <div class="ipt-box pd0" id="agentStateDiv">
                    	<input type="radio" id="agentState1" name="agentState" value="1" <c:if test="${pubScagent.agentState == '1' || empty pubScagent.agentState}">checked</c:if>/>有效
                    	<input type="radio" id="agentState2" name="agentState" value="2" <c:if test="${pubScagent.agentState == '2'}">checked</c:if> />失效
                    	<span style="color: red;">（失效人员不纳入检查执法人员抽取范围）</span>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">设置部门：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" class="ipt-txt" value="${deptName}" disabled="disabled"/>
                    </div>
                </td>
                <td class="bg-gray right">设置人：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text"  class="ipt-txt" disabled="disabled" value="${sessionScope.session_sys_user.realName}"/>
                    </div>
                </td>
                <td class="bg-gray right">设置日期：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" class="ipt-txt" disabled="disabled" value="${sysdate}">
                    </div>
                </td>
            </tr>
        </table>
        <p class="center mt10">
          <c:if test="${detailsFlag != '1'}">
			<input type="button" id="save" class="btn mr20" value="保 存"/>          
          </c:if>
	        <input type="button" class="btn" value="关 闭" id="cancel"/>
        </p>
    </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/scagent/scagent_syn_edit.js"></script>
</body>
</html>