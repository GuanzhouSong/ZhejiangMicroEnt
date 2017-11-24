<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<input id="state" type="hidden" value="${state}" />

<div class="layder-hd">
    <div class="form-list send-message">
    <c:if test="${state=='other'}">
    <div class="form-item clearfix">
    <label class="item-name col-3"></label>
            <div class="col-6 mr5">
                <div class="ipt-box">
                    <span class="item-name col-3" style="color: red;">当事人为企业时方才需要校验</span>
                </div>
            </div>
            </div></c:if>
    
    	<c:if test="${state=='nocard'}">
	        <div class="form-item clearfix">
	            <label class="item-name col-3">无证无照类型：</label>
	            <div class="col-6">
	                <div id="type" class="ipt-box">
		                <select id="have_card" >
	                		<option value="1">无照</option>
	                		<option value="2">无照无证</option>
	                		<option value="3">有照无证</option>
	                		<option value="4">执照过期</option>
	                		<option value="5">吊销未注销</option>
	                	</select>
	                </div>
	               
	            </div>
	        </div>
        </c:if>
        
        <form id="content_form">
        <div class="form-item clearfix">
            <label class="item-name col-3">当事人名称：</label>
            <div class="col-6 mr5">
                <div class="ipt-box">
                    <input id="entName" name="entName" type="text" class="ipt-txt" placeholder="请输入当事人名称">
                </div>
            </div>
            
            <div class="col-2">
                <div class="ipt-box">
                    <input id="check" type="button" value="校 验" style="display: none;" class="btn">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">证件类型：</label>
            <div class="col-6">
                <div class="ipt-box">
                	<select id="cardtype" >
                		<option code="0">营业执照</option>
                		<option code="10">居民身份证</option>
                		<option code="20">军官证</option>
                		<option code="30">警官证</option>
                		<option code="40">外国(地区)护照</option>
                		<option code="52">香港身份证</option>
                		<option code="54">澳门身份证</option>
                		<option code="56">台湾身份证</option>
                		<option code="90">其他有效身份证件</option>
                	</select>
                </div>
            </div>

        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">证件号：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <input id="cardno" name="cardno" type="text" class="ipt-txt">
                </div>
            </div>

        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">当事人地址：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <input id="address" name="address" type="text" class="ipt-txt">
                </div>
            </div>

        </div>
        <div class="form-item clearfix mb20">
            <label class="item-name col-3">当事人联系电话：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <input id="tel" name="tel" type="text" class="ipt-txt">
                </div>
            </div>
        </div>
        <div class="form-item clearfix col-offset-3">
            <div class="ml60">
                <input id="save" type="button" value="提 交" class="btn mr20">
                <input id="close" type="button" value="关 闭" class="btn">
            </div>
        </div></form>
    </div>
</div>
<script>
		if("${sysUser.userType}" == "1"){
			 window._CONFIG = {
		    		_urlHead:'/reg/server/sendaffairs/',//整改项目 
		     } 
		}else{
			window._CONFIG = {
		    		_urlHead:'/syn/sendaffairs/',//整改项目 
		     } 
		}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sendaffairs/cgcs_check_out.js"></script>
</body>
</html>