<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/layout-default-latest.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
<form id="sysUserForm">
    <div class="pd20 clearfix">
        <h3 class="h3-title center"></h3>
        <input type="hidden" id ="formuid" name="UID" value="${partyMemberInfo.UID}"/>
        <input type="hidden" id ="priPID" name="priPID" value="${priPID}"/>
        <input type="hidden" id ="inputType" name="inputType" value="${inputType}"/>
        <input type="hidden" id ="viewFlag" value="${viewFlag}"/>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
            <tr>
                <td class="bg-gray right" width="15%"><span class="light">*</span>党员姓名：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                        <input type="text" id="memberName"  name="memberName" value="${partyMemberInfo.memberName}" class="ipt-txt" required="required"/>
                    </div>
                </td>
                <td class="bg-gray right" width="15%"><span class="light">*</span>党员成分：</td>
                <td width="35%">
                    <div style="font-size: 13px">
                        &nbsp;<label><input type="radio" id="memberType1" name="memberType" value="1"  class="ipt-txt" ${partyMemberInfo.memberType =='1'?'checked':''}/>业主&nbsp;&nbsp;</label>
                        &nbsp;<label><input type="radio" id="memberType2" name="memberType" value="2" class="ipt-txt" ${partyMemberInfo.memberType =='2'?'checked':''}/>从业人员</label>
                    </div>
                </td>
            </tr>
            
            <tr>
                <td class="bg-gray right" width="15%"><span class="light">*</span>性别：</td>
                <td width="35%">
                    <div style="font-size: 13px">
                         &nbsp;<label><input type="radio" id="sex1" name="sex" value="1"  class="ipt-txt" ${partyMemberInfo.sex =='1'?'checked':''}/>男&nbsp;&nbsp;</label>
                         &nbsp;<label><input type="radio" id="sex2" name="sex" value="2" class="ipt-txt" ${partyMemberInfo.sex =='2'?'checked':''}/>女</label>
                    </div>
                </td>
                <td class="bg-gray right" width="15%"><span class="light">*</span>党员类别：</td>
                <td width="35%">
                    <div style="font-size: 13px">
                        &nbsp;<label><input type="radio" id="pmType1" name="pmType" value="1"  class="ipt-txt" ${partyMemberInfo.pmType =='1'?'checked':''}/>正式党员&nbsp;&nbsp;</label>
                        &nbsp;<label><input type="radio" id="pmType2" name="pmType" value="2" class="ipt-txt" ${partyMemberInfo.pmType =='2'?'checked':''}/>预备党员</label>
                    </div>
                </td>
            </tr>
            
            <tr>
                <td class="bg-gray right" width="15%"><span class="light">*</span>身份证号：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                        <input type="text" id="identityInfo"  name="identityInfo" value="${partyMemberInfo.identityInfo}" class="ipt-txt" required="required"/>
                    </div>
                </td>
                <td class="bg-gray right" width="15%"><span class="light">*</span>党内职务：</td>
                <td width="35%">
                    <div style="font-size: 13px">
                        &nbsp;<label><input type="radio" id="partyPosition1" name="partyPosition" value="1"  class="ipt-txt" ${partyMemberInfo.partyPosition =='1'?'checked':''}/>普通党员&nbsp;&nbsp;</label>
                        &nbsp;<label><input type="radio" id="partyPosition2" name="partyPosition" value="2" class="ipt-txt" ${partyMemberInfo.partyPosition =='2'?'checked':''}/>干部</label>
                        (<label><input type="checkbox" id="isSecretary" name="isSecretary" value="1" class="ipt-txt" ${partyMemberInfo.isSecretary =='1'?'checked':''}/>担任书记</label>)
                    </div>
                </td>
            </tr>
            
             <tr>
                <td class="bg-gray right" width="15%">出生年月：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                        <input type="text" id="birthday"  name=""  class="ipt-txt"/>
                    </div>
                </td>
                <td class="bg-gray right" width="15%"><span class="light">*</span>党员分布：</td>
                <td width="35%">
                    <div style="font-size: 13px">
                        &nbsp;<label><input type="radio" id="pmDistributed1" name="pmDistributed" value="1"  class="ipt-txt" ${partyMemberInfo.pmDistributed =='1'?'checked':''}/>个体&nbsp;&nbsp;</label>
                        &nbsp;<label><input type="radio" id="pmDistributed2" name="pmDistributed" value="0" class="ipt-txt" ${partyMemberInfo.pmDistributed =='0'?'checked':''}/>市场</label>
                    </div>
                </td>
            </tr>
            
            <tr>
                <td class="bg-gray right" width="15%">年龄：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                        <input type="text" id="memberAge"  name="memberAge" value="${partyMemberInfo.memberAge}" class="ipt-txt" required="required"/>
                    </div>
                </td>
                <td class="bg-gray right" width="15%"><span class="light">*</span>户籍所在地：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                         <input type="text" id="originLoc"  name="originLoc" value="${partyMemberInfo.originLoc}" class="ipt-txt" required="required"/>
                    </div>
                </td>
            </tr>
            
            <tr>
                <td class="bg-gray right" width="15%"><span class="light">*</span>民族：</td>
                <td width="35%">
                    <div style="font-size: 13px">
                        &nbsp;<label><input type="radio" id="nationality1" name="nationality" value="1"  class="ipt-txt" ${partyMemberInfo.nationality =='1'?'checked':''}/>汉族&nbsp;&nbsp;</label>
                        &nbsp;<label><input type="radio" id="nationality2" name="nationality" value="2" class="ipt-txt" ${partyMemberInfo.nationality =='2'?'checked':''}/>其它</label>
                    </div>
                </td>
                <td class="bg-gray right" width="15%"><span class="light">*</span>组织关系所在：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                        <select id="orgRelationLoc" name="orgRelationLoc" required="required">
                          <option value="">-请选择-</option>
                          <option value="1" ${partyMemberInfo.orgRelationLoc == '1'?'selected':''}>在本辖区街道、社区、村党组织</option>
                          <option value="2" ${partyMemberInfo.orgRelationLoc == '2'?'selected':''}>在本辖个私协会党组织</option>
                          <option value="3" ${partyMemberInfo.orgRelationLoc == '3'?'selected':''}>在本辖区市场党组织</option>
                          <option value="4" ${partyMemberInfo.orgRelationLoc == '4'?'selected':''}>在原籍党组织的流动党员</option>
                        </select>
                    </div>
                </td>
            </tr>
            
            <tr>
                <td class="bg-gray right" width="15%"><span class="light">*</span>最高学历：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
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
                </td>
                <td class="bg-gray right" width="15%"><span class="light">*</span>所属党组织：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                         <input type="hidden" class="ipt-txt" name="partyOrgID" id="partyOrgID" value="value="${partyMemberInfo.partyOrgID}""/>
                         <input type="text" class="ipt-txt" id="partyOrgName" name="partyOrgName" value="${partyMemberInfo.partyOrgName}" readonly="readonly" placeholder="请选择党组织"/>
                          <span class="add-icon" id="choseOrg">
                              <i></i>
                          </span>
                   </div>
                </td>
            </tr>
            
             <tr>
                <td class="bg-gray right" width="15%"><span class="light">*</span>党务工作者：</td>
                <td width="35%">
                    <div style="font-size: 13px">
                        &nbsp;<label><input type="radio" id="partyWorker1" name="partyWorker" value="1"  class="ipt-txt" ${partyMemberInfo.partyWorker =='1'?'checked':''}/>是&nbsp;&nbsp;</label>
                        &nbsp;<label><input type="radio" id="partyWorker2" name="partyWorker" value="0" class="ipt-txt" ${partyMemberInfo.partyWorker =='0'?'checked':''}/>否</label>
                    </div>
                </td>
                <td class="bg-gray right" width="15%"><span class="light">*</span>所属市场：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                      <input type="text" id="belongMarket"  name="belongMarket" value="${partyMemberInfo.belongMarket}" class="ipt-txt" required="required"/>
                    </div>
                </td>
            </tr>
            
             <tr>
                <td class="bg-gray right" width="15%">手机号码：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                       <input type="text" id="phoneNum"  name="phoneNum" value="${partyMemberInfo.phoneNum}" class="ipt-txt"/>
                    </div>
                </td>
                <td class="bg-gray right" width="15%">入党时间：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                        <input type="text" id="joinPartyTime" name="joinPartyTime" onclick="laydate()" readonly="readonly" style="width: 150px;cursor: pointer;"
                        value="<fmt:formatDate value="${partyMemberInfo.joinPartyTime}" pattern="yyyy-MM-dd" />" class="ipt-txt" required="required"/>
                    </div>
                </td>
            </tr>
            
            <tr>
                <td class="bg-gray right" width="15%">联系电话：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                       <input type="text" id="telNum"  name="telNum" value="${partyMemberInfo.telNum}" class="ipt-txt"/>
                    </div>
                </td>
                <td class="bg-gray right" width="15%">组织关系登记日期：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                        <input type="text" id="orgRegisterTime" name="orgRegisterTime" onclick="laydate()" readonly="readonly" style="width: 150px;cursor: pointer;"
                        value="<fmt:formatDate value="${partyMemberInfo.orgRegisterTime}" pattern="yyyy-MM-dd" />" class="ipt-txt" required="required"/>
                    </div>
                </td>
            </tr>
            
             <tr>
                <td class="bg-gray right" width="15%">备注：</td>
                <td colspan="3">
                    <div class="ipt-box pd0">
                       <textarea id="remark" name="remark" style="height: 55px" rows="" cols="">${partyMemberInfo.remark}</textarea>
                    </div>
                </td>
            </tr>
        </table>
        
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
             <tr>
                <td class="bg-gray right" width="12%">操作员：</td>
                <td width="20%">
                    <div class="ipt-box pd0">
                       <input type="text" id="auditName"  name="auditName" value="${viewFlag =='1'?sessionScope.session_sys_user.realName:partyMemberInfo.auditName}" class="ipt-txt"/>
                    </div>
                </td>
                <td class="bg-gray right" width="12%">修改日期：</td>
                <td width="20%">
                    <div class="ipt-box pd0">
                       <c:if test="${viewFlag =='1'}">
                            <input type="text" id="modifyTime" name="modifyTime" onclick="laydate()" readonly="readonly" style="cursor: pointer;"
                       		 value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" class="ipt-txt" required="required"/>
                       </c:if>
                       <c:if test="${viewFlag !='1'}">
	                        <input type="text" id="modifyTime" name="modifyTime" onclick="laydate()" readonly="readonly" style="cursor: pointer;"
	                        value="<fmt:formatDate value="${partyMemberInfo.modifyTime}" pattern="yyyy-MM-dd" />" class="ipt-txt" required="required"/>
                        </c:if>
                    </div>
                </td>
                <td class="bg-gray right" width="12%">建档日期：</td>
                <td width="20%">
                    <div class="ipt-box pd0">
                        <input type="text" id="createTime" name="createTime" onclick="laydate()" readonly="readonly" style="cursor: pointer;"
                        value="<fmt:formatDate value="${partyMemberInfo.createTime}" pattern="yyyy-MM-dd" />" class="ipt-txt" required="required"/>
                    </div>
                </td>
            </tr>
        </table>
	      <p class="center mt10">
		        <input type="submit" id="save" class="btn mr20" value="提交"/>
		        <button id="cancel" type="button" class="btn">关闭</button>
		  </p>
    </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/partycreate/party_member_input.js"></script>
</body>
</html>