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
    <div class="border-box2">
        <input type="hidden" name="regno" id="regno"  >
        <input type="hidden" name="unicode" id="unicode" >
        <input type="hidden" name="pripid" id="pripid"  >
        <input type="hidden" name="enttype" id="enttype" >
        <input type="hidden" id="entTypeCatg" >
        <input type="hidden" name="entname" id="entName">
        <input type="hidden" name="lerepphone"  id="lerepphone" >
<%--         <input type="hidden" name="lerep"  id="lerep" value="${midbaseinfo.tel}" > --%>
        <input type="hidden" name="cerNO" id="cerNo" value="">
        <table class="table-horizontal2" border="0" cellspacing="0" cellpadding="0" width="100%">
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
                   <input type="text" name="lerep"  id="lerep" value="" readonly="readonly" class="ipt-specical">
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">法定代表人（负责人）证件号码*</td>
                <td>
                   <input type="text" id="encerNo" value=""  readonly="readonly" class="ipt-specical">
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">联络员姓名*</td>
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
                <td class="bg-brown" align="right">联络员证件号码*</td>
                <td>
                     <input type="text" name="liaidnum" id="liaidnum" value="" class="ipt-edit ipt-view" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td class="bg-brown" align="right">联络员手机号码*</td>
                <td>
                   <input type="text" name="tel" id="tel" value="" class="ipt-edit ipt-view" readonly="readonly">
                </td>
            </tr>
            </tbody>
        </table>
        <p class="tr-center light" style="margin-top: 15px;">注意：系统目前不支持外省移动，联通的手机号码</p>
        <p class="tr-center" style="margin-top: 30px;">
        <input type="submit" value="保  存" class="btn" style="cursor: pointer;">
<!--         <a href="javascript:void(0);" class="btn">保&nbsp;&nbsp;存</a></p> -->
    </div>
    </form>
<!-- 点击确定返回登录页 -->
<div class="zj-alert-box tip1" >
    <ul>
        <li class="zj-alert-hd">提示框<div id="cancel">X</div></li>
        <li class='zj-alert-cont cont1'></li>
        <li class="zj-alert-footer"><input type="button" value="确定" class="gobacklogin"></li>
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
        <li class='zj-alert-cont cont3'></li>
        <li class="zj-alert-footer"><input type="button" value="免费申领数字证书" class="keyapply">
        <input type="button" value="继续书式变更联络员" id="cancel">
        </li>
    </ul>
</div>
<!-- 成功页个体户直接登录 -->
<div class="zj-alert-box tip4">
    <ul>
        <li class="zj-alert-hd">提示框<div class="gobacklogin">X</div></li>
        <li class='zj-alert-cont cont4'>联络员注册成功，若你想直接登录，请点击马上登录，否则点击下次登录！</li>
        <li class="zj-alert-footer"><input type="button" value="马上登录" class="publogin">
        <input type="button" value="下次登录" class="gobacklogin">
        </li>
    </ul>
</div>

<!-- 成功页个体户直接登录 -->
<div class="zj-alert-box tip5">
<div class=" info-tab-cont">
<form id="loginform">
        <input type="hidden" name="regno" id="login-regno"  >
        <input type="hidden" name="entname" id="login-entname"  >
        <input type="hidden" name="liaidnum" id="login-liaidnum"  >
        <input type="hidden" name="lianame" id="login-lianame"  >  
    <ul class="gslly-log" style="padding:0;">
        <li class="zj-alert-hd">联络员登录<div class="gobacklogin" >X</div></li>
<!--         <li class='zj-alert-cont cont4'></li> -->
                   <li class="clearfix " style="margin-bottom: 10px;margin-top:20px;"><label>
                        <span>工商联络员手机号</span></label>
                        <input type="text"  value="" id="gttel" name="tel" class="ipt-txt" readonly="readonly" style="width:200px;">
                    </li>

                    <li class="clearfix " style="margin-bottom: 10px">
                        <label><span>验证码</span></label>
                        <input type="text" id="password" name="password" value="" class="ipt-txt yzm" style="width: 120px;margin-right: 10px;">
                        <span class="hq-yzm" style="width: 70px;
    padding-left: 10px;">获取验证码</span>
                    </li>
        
        <li class="zj-alert-footer"><input type="button" value="登录" class="js-log-yz">
        <input type="button" value="取消" class="gobacklogin">
        </li>
    </ul>
</form>
</div>
</div>

</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script>
    window._CONFIG = {
        _entage :'${entage}'   //系统类型 1  企业或者及时  2  农专
    }
</script>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/infobulletin/register.js"></script>
</body>
</html>