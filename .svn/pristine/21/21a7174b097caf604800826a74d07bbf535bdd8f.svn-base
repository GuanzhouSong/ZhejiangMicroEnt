<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<style type="text/css">
.colorcss{background-color: #f4f4f5;}
</style>
<body>
<div class="pd20 clearfix">
      <input type="hidden" id="userType" value="${userType }">
    <input type="hidden" id="priPID" value="${priPID}">
    <input type="hidden" id="executeItem" value="${executeItem}">
    <div class="" style="margin-top: 20px;">
            <div id="viewGridFroz">
             <h1 class="h3-title left">司法协助公示股权冻结信息记录</h1>
             <table id="FrozTable" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
		        <thead>
		        <tr>
		            <td class="colorcss"></td>
		            <td class="colorcss">被执行人</td>
		            <td class="colorcss">执行裁定书文号</td>
		            <td class="colorcss">证照类型</td>
		            <td class="colorcss">证照号码</td>
		            <td class="colorcss">股权数额</td>
		            <td class="colorcss">状态</td>
		        </tr>
		        </thead>
		     </table>
	        </div>
	        
	        <div id="viewGridAlter" style="display: none">
	        <h1 class="h3-title left">司法协助公示股东强制变更信息记录</h1>
            <table id="AlterTable" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
		        <thead>
		        <tr>
		            <td class="colorcss"></td>
		            <td class="colorcss">被执行人</td>
		            <td class="colorcss">执行裁定书文号</td>
		            <td class="colorcss">证照类型</td>
		            <td class="colorcss">证照号码</td>
		            <td class="colorcss">股权数额</td>
		            <td class="colorcss">受让人</td>
		        </tr>
		        </thead>
		     </table>
	        </div>
	        
	        <div class="clearfix mt20">     
		         <div class="center" style="position: relative;margin-bottom: 50px">
	                <button id="save" type="button" class="btn btn-primary">保存</button>
	                <button id="cancel" type="button" class="btn btn-primary">关闭</button>
	             </div>
            </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/pubjusticeinfo/pubjusticeinfo_include_main.js"></script>
</body>
</html>