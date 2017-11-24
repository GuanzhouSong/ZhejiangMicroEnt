<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政指导</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <jsp:useBean id="nowdate" class="java.util.Date" />
</head>
<body class="pd10">
<div>
<%--     <h4 class="h4-title mt5">${qualificationLimit.entname}</h4> --%>
    <form id="infoForm">
        <input type="hidden" id="uid" name="uid" value="${qualificationLimit.uid}">
        <input type="hidden" id="pripid" name="priPID" value="${qualificationLimit.priPID}">
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <tbody>
            <tr>
                <td class="bg-gray right" width="15%">限制对象姓名</td>
                <td colspan="3" width="35%">${qualificationLimit.clientName}</td>
                <td class="bg-gray right" width="15%">限制对象证件号码</td>
                <td colspan="3" width="35%">${qualificationLimit.certNO}</td>
            </tr>
            <tr>
                <td class="bg-gray right" width="15%">限制原因类别</td>
                <td colspan="3">${qualificationLimit.limitTypeName}</td>
                <td class="bg-gray right">任职受限期限</td>
<%--                 <td colspan="3" ><fmt:formatDate value="${qualificationLimit.limitDateStart}" pattern="yyyy-MM-dd"/>-<fmt:formatDate value="${qualificationLimit.limitDateEnd}" pattern="yyyy-MM-dd"/></td> --%>
                <td colspan="3" >
                <div class="ipt-box">
                <input type="text" class="ipt-txt" style="width: 45%;" value="<fmt:formatDate value="${qualificationLimit.limitDateStart}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
                -<input type="text" class="ipt-txt" style="width: 45%;" value="<fmt:formatDate value="${qualificationLimit.limitDateEnd}" pattern="yyyy-MM-dd"/>" readonly="readonly"/>
                </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="15%">失信受限企业</td>
                <td colspan="3">${midBaseInfo.entName}</td>
                <input type="hidden" name="entName" value="${midBaseInfo.entName}"/>
                <td class="bg-gray right">统一代码/注册号</td>
                <td colspan="3" >${midBaseInfo.uniCode==null||midBaseInfo.uniCode==''? midBaseInfo.regNO : midBaseInfo.uniCode}</td>
                <input type="hidden" name="uniCode" value="${midBaseInfo.uniCode}"/>
                <input type="hidden" name="regNO" value="${midBaseInfo.regNO}"/>
            </tr>
            <tr>
                <td class="bg-gray right" width="15%">限制原因</td>
                <td colspan="7">${qualificationLimit.limitReason}</td>
            </tr>
            <tr>
                <td class="bg-gray right" width="15%">限制说明</td>
                <td colspan="7">${qualificationLimit.limitReason}</td>
            </tr>
            <tr>
                <td class="bg-gray right" width="15%">限制执行部门</td>
                <td colspan="3">${qualificationLimit.limitDepartName}</td>
                <td class="bg-gray right">限制执行文号</td>
                <td colspan="3">${qualificationLimit.limitNO}</td>
            </tr>
            <tr>
                <td class="bg-gray right">解除原因</td>
                <input type="hidden" name="removeReason" id="removeReason" value="${qualificationLimit.auditState !='2' ? qualificationLimit.removeReason : '' }">
                <c:set value="${fn:split(qualificationLimit.removeReason,',')}" var="removeReason"/>
                <td colspan="7">
                        <div class="ipt-box col-12" style="padding-bottom: 5px;padding-top: 5px;line-height: 1.5;">
                            <input type="checkbox" name="removeReasonCheck" value="1" required
                            ${fromtype!='checkview'?'':'onclick="return false"'}
                                <c:forEach var="o"
                                 items="${removeReason}">${(o == 1 && qualificationLimit.auditState !='2') ? 'checked':''}</c:forEach>  >1.已办理注销且股东证明其对吊销事宜无个人责任</br>
                            <input type="checkbox" name="removeReasonCheck" value="2" required
                            ${fromtype!='checkview'?'':'onclick="return false"'}
                                <c:forEach var="o"
                                           items="${removeReason}">${(o == 2 && qualificationLimit.auditState !='2') ? 'checked':''}</c:forEach>  >2.主管部门证明其对吊销事宜无个人责任</br>
                            <input type="checkbox" name="removeReasonCheck" value="3" required
                            ${fromtype!='checkview'?'':'onclick="return false"'}
                                <c:forEach var="o"
                                           items="${removeReason}">${(o == 3 && qualificationLimit.auditState !='2') ? 'checked':''}</c:forEach>  >3.有证据证明其年检期间无法正常履行法定代表人职权</br>
                            <input type="checkbox" name="removeReasonCheck" value="4" required
                            ${fromtype!='checkview'?'':'onclick="return false"'}
                                <c:forEach var="o"
                              items="${removeReason}">${(o == 4 && qualificationLimit.auditState !='2') ? 'checked':''}</c:forEach>  >4.有证据证明企业被吊销前已被解除法定代表人职务</br>
                            <input type="checkbox" name="removeReasonCheck" value="5" required
                            ${fromtype!='checkview'?'':'onclick="return false"'}
                                <c:forEach var="o"
                                           items="${removeReason}">${(o == 5 && qualificationLimit.auditState !='2') ? 'checked':''}</c:forEach>  >5.吊销机关出具证明同意解除或证明法定代表人对吊销事宜无个人责任</br>
                            <input type="checkbox" name="removeReasonCheck" value="6" required
                            ${fromtype!='checkview'?'':'onclick="return false"'}
                                <c:forEach var="o"
                                           items="${removeReason}">${(o == 6 && qualificationLimit.auditState !='2') ? 'checked':''}</c:forEach>  >6.抄告部门要求解除</br>
                            <input type="checkbox" name="removeReasonCheck" value="7" required  id="removeReasonCheck7"
                            ${fromtype!='checkview'?'':'onclick="return false"'}
                                <c:forEach var="o"
                                           items="${removeReason}">${(o == 7 && qualificationLimit.auditState !='2')  ? 'checked':''}</c:forEach>  >7.其他
                            <input type="text" style="${(qualificationLimit.auditState == '2' || empty qualificationLimit.removeOtherReason ) ? 'width: 91.5%;height: 25px;display: none;' : 'width: 91.5%;height: 25px;' }"  name="removeOtherReason" id="removeOtherReason" class="ipt-txt" value="${qualificationLimit.auditState !='2' ? qualificationLimit.removeOtherReason : '' }" />                
                        </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">解除机关</td>
                <td colspan="3">
                <div class="ipt-box">
                <input type="hidden" name="removeDept" id="removeDept" value="${(qualificationLimit.removeDept == null && qualificationLimit.auditState !='2' )? qualificationLimit.limitDepartName : qualificationLimit.removeDept}" />         
                <input type="text" name="removeDeptName" id="removeDeptName" class="ipt-txt" value="${(qualificationLimit.removeDeptName == null && qualificationLimit.auditState !='2' ) ? qualificationLimit.limitDepartName : qualificationLimit.removeDeptName}" placeholder="选择" class="fl ipt-txt" readonly="readonly" />         
                     <span id="chooseActiveDep" class="add-icon"><i></i></span>
                </div>
                </td>
                <td class="bg-gray right">申请人</td>
                <td >${sysUser.realName}</td>
                <td class="bg-gray right">申请日期</td>
                <td><fmt:formatDate value="${nowdate}" pattern="yyyy-MM-dd"/></td>
            </tr>
            </tbody>
        </table>
       
        <div class="center mt10">
            <input id="save" type="submit" class="btn" value="保 存">
            <input id="cancel" type="button" class="btn" value="取 消">

        </div>
    </form>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registmanage/qualifiedmanage/limitremoveaddapply_edit.js"></script>
</body>
</html>