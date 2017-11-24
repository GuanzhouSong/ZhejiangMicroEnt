<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>主体填报公示信息</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body class="enterprise-info-bg notice-info-top">
<div>
    <div class="mod1366 info-tb-hd border-top9">
        <div class="logo"><a href="/client/entsearch/toEntSearch"></a></div>
    </div>
</div>
<div class="mod">
   <form id ="phoneApply_form">       
    <div class="border-box2" style="padding-bottom: 10px;">
 		<input type="hidden" name="regno" id="regno" >
        <input type="hidden" name="unicode" id="unicode" >
        <input type="hidden" name="pripid" id="pripid" >
        <input type="hidden" id="entTypeCatg" >
        <input type="hidden" name="enttype" id="enttype" >
        <input type="hidden" name="entname" id="entName">
        <input type="hidden" name="lerepphone"  id="lerepphone" >
        <input type="hidden" name="cerNO" id="cerNo" value=""  >                
        <table class="table-horizontal2 table-horizontal3" border="0" cellspacing="0" cellpadding="0" width="100%">
            <tbody>
            <tr>
                <td width="354" class="bg-brown" align="right">统一社会信用代码/注册号*</td>
                <td>
                    <input type="text" id="regcode" value="" >
                    <span id="regcode-span" style="display: none;"><i class="icon-tip"></i><label id="regcode-error" class="tip" for="regcode" style="display: inline;">请输入正确的注册号或者统一代码</label></span>
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">法定代表人（负责人）姓名*</td>
                <td>
                   <input type="text" id="lerep" name="lerep" value="" readonly="readonly" class="ipt-specical">
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">法定代表人（负责人）证件号码*</td>
                <td>
                   <input type="text" id="encerNo" value=""  readonly="readonly" class="ipt-specical">
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">原联络员姓名*</td>
                <td>
                   <input type="text" id="oldlianame" value=""  readonly="readonly">
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">原联络员证件号码*</td>
                <td>
                   <input type="text" id="oldliaidnum" value=""  readonly="readonly">
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">原联络员手机号码*</td>
                <td>
                   <input type="text" id="oldtel" value=""  readonly="readonly">
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">新联络员姓名*</td>
                <td>
                   <input type="text" name="lianame" id="lianame" value="" class="ipt-edit" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">联络员证件类型*</td>
                <td>
                    <select class="text_sketch select-edit" name="liaidtype" id="liaidtype" disabled="disabled" >
	                	<c:forEach items="${Certypes}" var="certype" varStatus="status">
	                		<option value="${certype.code }">${certype.content }</option>
	                	</c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">新联络员证件号码*</td>
                <td>
                     <input type="text" name="liaidnum" id="liaidnum" value="" class="ipt-edit ipt-view" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">新联络员手机号码*</td>
                <td>
                   <input type="text" name="tel" id="tel" value="" class="ipt-edit ipt-view" readonly="readonly">
                </td>
            </tr>
            </tbody>
        </table>
        <p class="tr-center light" style="margin-top: 15px;">注意：系统目前不支持外省移动，联通的手机号码</p>
        <p class="tr-center" style="margin-top: 15px;">
        <input type="submit" value="保  存" class="btn" >
    </div>
</form>
<!-- 点击确定返回登录页 -->
<div class="zj-alert-box tip1" >
    <ul>
        <li class="zj-alert-hd">提示框<div id="cancel">X</div></li>
        <li class='zj-alert-cont cont1'></li>
        <li class="zj-alert-footer"><input type="button" value="确定" id="gobacklogin"></li>
    </ul>
</div>
<!-- 点击确定关闭当前页 -->
<div class="zj-alert-box tip2">
    <ul>
        <li class="zj-alert-hd">提示框<div id="cancel">X</div></li>
        <li class='zj-alert-cont cont2'></li>
        <li class="zj-alert-footer"><input type="button" value="确定" id="close"></li>
    </ul>
</div>
<!-- 成功页（无证书且已确认过联络员的企业、农专社） -->
<div class="zj-alert-box tip3">
    <ul>
        <li class="zj-alert-hd">提示框<div id="cancel">X</div></li>
        <li class='zj-alert-cont cont3 mb15'></li>
        <li class="zj-alert-footer"><input type="button" value="免费申领数字证书" class="keyapply" style="padding:0 10px;">
        <input type="button" value="继续书式变更联络员" id="cancel" style="padding:0 10px;">
        </li>
    </ul>
</div>   
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/infobulletin/modify.js"></script>
</body>
</html>