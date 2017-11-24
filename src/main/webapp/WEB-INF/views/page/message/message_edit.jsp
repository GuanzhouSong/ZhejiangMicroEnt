<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<title>KindEditor JSP</title>
<link rel="stylesheet" href="/js/lib/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="/css/reg.server.css">
</head>
<div class="form-list">
	<form class="form-horizontal" id="webform">
		<input type="hidden" id="checkAllEnt" name="checkAllEnt" >
		<input type="hidden" id="priPIDs" name="priPIDs" >
		<input type="hidden" id="entNames" name="entNames" >
		<input type="hidden" id="msgType" name="msgType" value="1" >
		<input type="hidden" id="sendId" name="sendId" >
		<input type="hidden" id="sendDeptId" name="sendDeptId" >
		<input type="hidden" id="msgPcReadState" name="msgPcReadState" value="0" >
		<input type="hidden" id="msgWxReadState" name="msgWxReadState" value="0" >
		<input type="hidden" id="msgLlReadState" name="msgLlReadState" value="0" >
		<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
			<tr>
				<td class="bg-gray right" width="15%">消息标题</td>
				<td colspan="3">
					<div class="ipt-box col-12">
						<input name="msgTitle" id="msgTitle" placeholder="请输入消息通知的标题" class="ipt-txt" maxlength="100">
					</div>
				</td>
			</tr>
			<tr>
				<td class="bg-gray right">摘要</td>
				<td colspan="3">
					<div class="ipt-box col-12">
						<textarea id="msgAbstract" name="msgAbstract"  rows="3" style="width: 100%; height: 100px; " maxlength="500"></textarea>
					</div>
				</td>
			</tr>
					<tr>
				<td class="bg-gray right">备注</td>
				<td colspan="3">
					<div class="ipt-box col-12">
						<textarea id="msgRemark" name="msgRemark"  rows="3" style="width: 100%; height: 100px; " maxlength="500"></textarea>
					</div>
				</td>
			</tr>
			<tr>
				<td class="bg-gray right">消息内容</td>
				<td colspan="3">
					<div class="ipt-box col-12">
						<textarea id="msgContent" name="msgContent"  rows="10" style="width:100%; height: 280px; visibility: hidden;"></textarea>
					</div> 
				</td>
			</tr>
	
		</table>
		<div class="pd20">
		<div class="form-item clearfix">
			<label class="item-name col-2">发送人：</label>
			<div class="col-2">
				<div class="ipt-box">
					<input id="sendName" name="sendName" type="text" class="ipt-txt"   readonly="readonly">
				</div>
			</div>
		<div class="form-item clearfix">
			<label class="item-name col-1">发送日期：</label>
			<div class="col-2">
				<div class="ipt-box">
					<input id="sendTime" name="sendTime" type="text" class="ipt-txt"   readonly="readonly">
				</div>
			</div>
		<div class="form-item clearfix">
			<label class="item-name col-1">发送部门：</label>
			<div class="col-2">
				<div class="ipt-box">
					<input id="sendDeptName" name="sendDeptName" type="text" class="ipt-txt"  readonly="readonly">
				</div>
			</div>
		</div>
	</form>
	<p class="center mt10">
		<input type="button" class="btn mr20" value="提交内容" id="submit" /> <input type="button" class="btn" value="取 消" id="cancel" />
	</p>
	<script charset="utf-8" src="/js/lib/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="/js/lib/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="/js/lib/kindeditor/plugins/code/prettify.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/reg/server/message/message_edit.js"></script>
</body>
</html>

