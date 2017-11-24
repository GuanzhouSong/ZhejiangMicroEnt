<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>联络员确认书打印页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/printer.css"/>"/>
</head>
<body>
<div class="right-top Noprint" style="width:600px;margin-right: 10%">
	<a href="javascript:Print();"><strong style="font-size:16px">打印</strong></a><br>
	<a href="javascript:PrintView();"><strong style="font-size:16px">预览</strong></a><br>
	<a href="javascript:PrintSetup();"><strong style="font-size:16px">设置</strong></a><br>
	<a id="closeBtn" href="javascript:closeWindow();"><strong style="font-size:16px">关闭</strong></a>
</div>
<object height="0px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="0px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
<div id="printarea">
	<div class="print2" id="print2">
	</div>
</div>

<div class="mod mod-print" style="position:relative; bottom: 30px;">
    <div class="mod-print-hd">
        <h1><c:if test="${entTypeCatg  != 16 && entTypeCatg != 17}">企业工商联络员备案通知书</c:if>
        <c:if test="${entTypeCatg  == 16 || entTypeCatg == 17}">农专社工商联络员备案通知书</c:if></h1>
        <span>
        <c:if test="${entTypeCatg  >= 21 && entTypeCatg <= 28}">（外资企业）</c:if>
        <c:if test="${!(entTypeCatg  >= 21 && entTypeCatg <= 28) && entTypeCatg != 17 && entTypeCatg != 16}">（内资企业）</c:if>
        </span>
        
    </div>
    <div class="clearfix" style="margin-bottom: 3px;">
        <p class="col-6"><strong>流水号：</strong>${PhoneApplyPrint[0].pasid}</p>
     <!--  <p class="col-6"><strong>档案号：</strong>20160922163004281509</p> -->  
    </div>
    <table class="table-print" cellpadding="0" cellspacing="0" border="0" width="100%">
        <tbody>
        <tr>
            <td width="20%">企业名称</td>
            <td width="37%" class="col-l">${PhoneApplyPrint[0].entname}</td>
            <td width="18%">统一代码/注册号</td>
            <td class="col-l">${empty PhoneApplyPrint[0].unicode ? PhoneApplyPrint[0].regno : PhoneApplyPrint[0].unicode}</td>
        </tr>
        <tr>
            <td>企业法定代表人<br>（负责人）姓名</td>
            <td class="col-l">${PhoneApplyPrint[0].lerep}</td>
            <td>手机号码</td>
            <td class="col-l">${PhoneApplyPrint[0].lerepphone}</td>
        </tr>
        <tr>
            <td>联络员姓名</td>
            <td class="col-l">${PhoneApplyPrint[0].lianame}</td>
            <td>手机号码<br>（接收验证码）</td>
            <td class="col-l">${PhoneApplyPrint[0].tel}</td>
        </tr>
        <tr>
            <td>联络员<br>身份证件类型</td>
            <td class="col-l">
                 <c:forEach items="${Certypes}" var="certype" varStatus="status">
			                <c:if test="${certype.code == PhoneApplyPrint[0].liaidtype}">
			                  ${certype.content }
			                </c:if>
			    </c:forEach>
            </td>
            <td>联络员<br>身份证件号码</td>
            <td class="col-l">${PhoneApplyPrint[0].liaidnum}</td>
        </tr>
        <tr>
            <td>委托事项及权限</td>
            <td colspan="3" class="col-l">
                委托企业联络员通过其手机接收验证码，进行浙江省企业信用信息公示平台报送和公示年度报告及其他法定公示信息。本企业对该联络员报送和公示的信息的真实性、及时性负责。
            </td>
        </tr>
        </tbody>
    </table>
    <table class="table-print table-print2" cellpadding="0" cellspacing="0" border="0" width="100%">
        <tbody>
        <tr>
            <td width="50%">联络员<br>身份证件（正面）复印件粘贴处</td>
            <td>联络员<br>身份证件（反面）复印件粘贴处</td>
        </tr>
        </tbody>
    </table>
    <p>注：请在身份证复印件上注明“与原件一致”字样及与身份证件名字一致的签字。</p>
    <p style="margin:20px 0 0 215px;">企业法定代表人（负责人）签字：</p>
    <p style="margin:20px 0 0 215px;">企业公章（加盖）：</p>
    <p style="margin:20px 0 0 425px;">年<span style="margin-left: 50px;">月</span><span style="margin-left: 50px;">日</span></p>
    <div class="clearfix" style="margin-top: 20px;margin-bottom: 20px">
        <p class="col-6"><strong>登记机关：</strong>${PhoneApplyPrint[0].regOrgName}</p>
        <p class="col-6"><strong>管辖单位：</strong>${PhoneApplyPrint[0].localAdmName}</p>
    </div>
    <c:if test="${not empty deliverList[0] }">
    <p><strong>本备案书送达地址：</strong></p>
    <p style="margin-bottom: 20px">${deliverList[0].deliName}，地址：${deliverList[0].deliAddress}，邮政编码：${deliverList[0].postalCode}，联系电话 ：${deliverList[0].tel}</p>
    </c:if>
    <p><strong>填表说明：</strong></p>
    <p>1.已申领企业数字证书的企业，可以直接使用数字证书登录报送企业公示信息，无须办理备案手续。</p>
    <p>2.此表请按上述地址送达至工商部门。如采用当面送达的，工商部门接收后打印回执交企业备存；如以邮寄方式送达，工商部门接收后将以手机短信方式发送相关信息到联络员手机。</p>
    <p>3.企业联络员信息发生变化或企业名称、企业法定代表人（负责人）发生变更后与企业备案的信息不符时，应及时向工商部门重新备案。</p>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/print/printsetup.js"></script>
<script src="/js/common/print/print.js"></script>
</body>
</html>
