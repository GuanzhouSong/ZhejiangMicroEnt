<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
	<title>股东及出资信息打印</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
	 
	<style media="print" type="text/css">
		.STYLE1 {
			font-size: 16px;
			font-weight: bold;
		}
		object { display: none}
		.Noprint{ display:none; }
		.PageNext{ page-break-after: always; clear: both; width: 100%}
	</style>

	<style type="text/css">
		.height40{
			height: 40px;
		}
	</style>
</head>
<body>
<div class="button Noprint" style="width:600px;">
	<a href="javascript:Print();"><strong style="font-size:16px">打印</strong></a>
	<a href="javascript:PrintView();"><strong style="font-size:16px">预览</strong></a>
	<a href="javascript:PrintSetup();"><strong style="font-size:16px">设置</strong></a>
	<a id="closeBtn" href="javascript:closeWindow();"><strong style="font-size:16px">关闭</strong></a>
</div>

<object id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>

<div id="printarea">
	<div class="print2" id="print2">

	</div>
</div>

<form id="key_parmas">
	<input type="hidden" name="name" id="key_name" value="">
</form>

<script id="inv-template" type="text/x-handlebars-template">


			<table border="0" cellspacing="0" id="permit-table" cellpadding="0"
				   class="table-ordinary">
				<thead>
				<tr>
					<th width="8%">股东</th>
					<th width="8%">认缴额<br />（万元）
					</th>
					<th width="8%">实缴额<br />（万元）
					</th>
					<th width="38%">认缴明细</th>
					<th > 实缴明细</th>
				</tr>
				</thead>
				{{#each this}}
					<tr>
						<th  >{{inv}}</th>
						<th  >{{liSubConAm}}<br />（万元）
						</th>
						<th  >{{liAcConAm}}<br />（万元）
						</th>
						<th >
							<table>
								<thead>
								<tr  >
									<th width="28%">认缴<br/>出资方式</th>
									<th width="22%">认缴出资额<br/>（万元）</th>
									<th width="32%">认缴<br/>出资日期</th>
									<th>公示<br/>状态</th>
								</tr>
								</thead>
								<tbody>
								{{#with imInvprodetailList}}
								{{#each this}}
								<tr>
									<td>{{conFormCN}}</td>
									<td>{{subConAm}}</td>
									<td>{{transDate conDate}}</td>
									<td>{{transFlag pubFlag}}</td>
								</tr>
								{{/each}}
								{{/with}}
								</tbody>
							</table>
						</th>
						<th width="140">
							<table>
								<thead>
								<tr class="height40">
									<th>实缴<br/>出资方式</th>
									<th>实缴出资额<br/>（万元）</th>
									<th>实缴<br/>出资日期</th>
									<th>公示<br/>状态</th>
								</tr>
								</thead>
								<tbody>
								{{#with imInvactdetailList}}
									{{#each this}}
									<tr>
										<td>{{acConFormCn}}</td>
										<td>{{acConAm}}</td>
										<td>{{transDate conDate}}</td>
										<td>{{transFlag pubFlag}}</td>
									</tr>
									{{/each}}
								{{/with}}

								</tbody>
							</table>
						</th>
					</tr>
				{{/each}}
			</table>


</script>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/print/printsetup.js"></script>
<script src="/js/common/print/print.js"></script>
<script src="/js/reg/client/im/investment/list_print.js"></script>
<script>
	window._CONFIG = {
		investmentDtoList:'${investmentDtoList}'
	}
</script>


</body>
</html>