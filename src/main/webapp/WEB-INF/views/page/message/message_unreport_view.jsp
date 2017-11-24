<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title></title>
<%--<link rel="stylesheet" href="/css/reg.server.css">--%>
<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="/css/reg.client.css">
<!-- 正式 -->
<script type="text/javascript" src="https://hm.baidu.com/hm.js?503ba8bab9e32eb24b79b59a886d8e8f"></script>
<!-- 测试 -->
<!-- <script type="text/javascript" src="https://hm.baidu.com/hm.js?3ecdad4c6bf5c76ce987441f963a4fba"></script> -->
</head>
<body style="background-color: #fbf8ef;">
<div class="mod header">
     <h2 class=""><a href="#"><img src="/img/pub/zj-logo.png" alt=""></a></h2>
</div>
 <form id="taskForm" class="form-box">
	<div class="mt20">
	<div class="mod-wrap">
		<div class="mod mod-tb-notice-detail">
			<h1 class="center report-title">企业工商年报提醒</h1>
			<div class="report-title-prompt center mb20">
				<p><span class="span_year"></span>年度企业年报将于<span class="span_nowyear"></span>年6月30日截止，逾期将被列入经营异常名录并公示。</p>
			</div>
			<p class="fs14 mb20">年报状态：<span class="font-red mr42">未年报</span> 发送日期：<span class="span_sendDate"></span></p>
			<p class="fs20 mb10">您担任工商联络员的以下企业<span class="font-red">未完成</span><span class="span_year"></span>年度企业年报 :</p>
			<p class="fs14 mb20">为了不影响您企业信用，请电脑登录企业信用公示系统申报(公示系统链接：<span class="font-red">http://zj.gsxt.gov.cn</span>)</p>
			<p class="fs20">企业列表【<span class="font-red listCount">0</span>】</p>
			<div class="mt10" style="display: none" id="div_pageTable">
				<div class="iframe-wrap">
					<%--    <p><h2>企业名称:${map.entName}&nbsp;&nbsp;&nbsp;注册号/ 统一信用社会代码:${map.uniCode }</h2></p> --%>
					<table id="permit-table" class="table-row display nowrap" cellspacing="0" width="100%">
						<thead>
						<tr>
							<th>序号</th>
							<th>企业名称</th>
						</tr>
						</thead>
					</table>
				</div>
			</div>

			<table id="tab_wx" class="table-row" cellspacing="0" width="100%" style="display: none">
				<thead>
				<tr>
					<th>序号</th>
					<th>企业名称</th>
				</tr>
				</thead>
				<tbody id="tbody_entList">

				</tbody>
			</table>
		</div>
	</div>
<div class="mod1366">
<div class="footer-box">
    <div class="mod footer">
        <p>主办单位：浙江省工商行政管理局</p>
        <p>地址：杭州市莫干山路77号金汇大厦北门&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：310005&nbsp;&nbsp;&nbsp;&nbsp;备案号：京ICP备16053442号</p>
    </div>
</div>
</div>


</form>
		<script id="tpl_entList" type="text/x-handlebars-template">
		{{#each this}}
			<tr>
					<td>{{tableNum @index}}</td>
					<td>{{entname}}</td>
				</tr>
		{{/each}}
		</script>
		<script src="/js/lib/require.js"></script>
		<script src="/js/config.js"></script>
		<script src="/js/reg/server/message/message_report_view.js"></script>
		
</body>
</html>