<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
	<link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">

<div>
    <div>
        <form class="form-horizontal" id="modapplication-form">
            <input  type="hidden" id="priPID" value="${foodstorageBase.priPID }"/>
            <input  type="hidden" id="year" value="${foodstorageBase.year}"/>
        	<table class="table-horizontal" width="100%">
	            <tr>
	                <td width="20%" class="bg-gray right">你企业涉及</td>
	                <td width="80%" colspan="5">
	                	<input type="checkbox" disabled="disabled" <c:if test="${fn:indexOf(foodstorageBase.fsScope,'1')!=-1}">checked="checked"</c:if> />食品生产  
	                	<input type="checkbox" disabled="disabled" <c:if test="${fn:indexOf(foodstorageBase.fsScope,'2')!=-1}">checked="checked"</c:if> />食品经营  
	                	<input type="checkbox" disabled="disabled" <c:if test="${fn:indexOf(foodstorageBase.fsScope,'3')!=-1}">checked="checked"</c:if> />食品仓储服务 
	                	<input type="checkbox" disabled="disabled" <c:if test="${fn:indexOf(foodstorageBase.fsScope,'5')!=-1}">checked="checked"</c:if> />食用农产品 
	                	<input type="checkbox" disabled="disabled" <c:if test="${fn:indexOf(foodstorageBase.fsScope,'4')!=-1}">checked="checked"</c:if> />都不涉及
	                </td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">食品生产许可证</td>
	                <td colspan="2">
						<div class="ipt-box  col-8">
							<input type="text"  class="ipt-txt" readonly="readonly" value="${foodstorageBase.proAmount }"/>
						</div>
						<div class="item-txt">
							个
						</div>
	                </td>
	                <td class="bg-gray right">许可证信息:</td>
	                <td colspan="2"><a href="javascript:void(0);" id="proAmountId" class="js-punishdetail-view" >详情</a></td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">食品流通(经营)许可证</td>
	                <td colspan="2">
						<div class="ipt-box col-8">
							<input type="text" readonly="readonly" value="${foodstorageBase.disAmount }" class="ipt-txt"/>
						</div>
						<div class="item-txt">
							个
						</div>
	                </td>
	                <td class="bg-gray right">许可证信息:</td>
	                <td colspan="2"><a href="javascript:void(0);" id="disAmountId" class="js-punishdetail-view" >详情</a></td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">仓库</td>
	                <td colspan="2">
						<div class="ipt-box  col-8">
							<input type="text" readonly="readonly" class="ipt-txt" value="${foodstorageBase.wareAmount }"/>
						</div>
						<div class="item-txt">
							个
						</div>
	                </td>
	                <td class="bg-gray right">仓库信息:</td>
	                <td colspan="2"><a href="javascript:void(0);" id="wareAmountId" class="js-punishdetail-view" >详情</a></td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">填表人</td>
	                <td width="20%">
						<div class="ipt-box col-8">
							<input type="text" class="ipt-txt" readonly="readonly" value="${foodstorageBase.setName }"/>
						</div>
	                </td>
	                <td width="15%" class="bg-gray right">办公电话</td>
	                <td width="15%">
						<div class="ipt-box">
	                	<input type="text" readonly="readonly" class="ipt-txt" value="${foodstorageBase.tel }"/>
	                </td>
	                <td width="15%" class="bg-gray right">手机号码</td>
	                <td width="15%">
						<div class="ipt-box">
	                	<input type="text" readonly="readonly" class="ipt-txt" value="${foodstorageBase.mobTel }"/>
							</div>
	                </td>
	            </tr>
            </table>
            <div class="center mt10">
                <button id="cancel" type="button" class="btn">关闭</button>
            </div>
        </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/foodstoragebase/edit_main.js"></script>
</body>
</html>