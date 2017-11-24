<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/printer.css"/>
</head>
<body class="pd10">
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="0px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="0px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
<div class="print-nocard">
    <h3>市场监管领域随机抽查情况记录表</h3>
    <div class="mt10">
        <div class="tabbale" data-component="tab">
            <div class="tab-content">
              	<div class="tab-panel tab-panel-show" id="itemPanelDivId">
                    <div class="mt10">
                        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
                            <tbody>
                            	<tr>
	                                <td class="bg-gray right" width="12%"><strong>任务名称</strong></td>
	                                <td>${pubScentResultDto.taskName }</td>
	                                <td class="bg-gray right" width="20%"><strong>任务编号</strong></td>
	                                <td>${pubScentResultDto.taskCode }</td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right"><strong>被检查单位</strong></td>
	                                <td>${pubScentResultDto.entName }</td>
	                                <td class="bg-gray right"><strong>统一信用代码/注册号</strong></td>
	                                <td>${!empty pubScentResultDto.uniCode?pubScentResultDto.uniCode:pubScentResultDto.regNO}</td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right" rowspan="2"><strong>住所地址</strong></td>
	                                <td rowspan="2">${pubScentResultDto.dom }</td>
	                                <td class="bg-gray right"><strong>法定代表人/电话</strong></td>
	                                <td>${pubEppassword.lerep } ${pubEppassword.lerepphone }</td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right"><strong>联络员/电话</strong></td>
	                                <td>${pubEppassword.lianame } ${pubEppassword.tel }</td>
	                            </tr>
	                         </tbody>
	                       </table><br/>
	                       <table id="table2" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                                <td class="bg-gray center" width="30%"><strong>检查事项</strong> 
	                                <td class="bg-gray center" width="35%"><strong>发现问题情况</strong></td>
	                                <td class="bg-gray center" width="35%"><strong>处置情况</strong></td>
	                            </tr>
	                            <c:forEach var="pubSccheckItem" items="${pubSccheckItemList }" varStatus="status">
		                            <tr>
		                                <td>${status.index + 1}. ${pubSccheckItem.checkName }</td>
		                                <td></td>
		                                <td></td>
		                            </tr>
	                            </c:forEach>
	                          </tbody>
	                       </table><br/>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                                <td class="bg-gray center"><strong>核查方式(多选)</strong></td>
	                                <td colspan="2">
	                                	<input type="checkbox" value="1" disabled="disabled">实地检查 
		                                <input type="checkbox" value="2" disabled="disabled" >书面检查 
		                                <input type="checkbox" value="3" disabled="disabled" >行政部门检查结果或专业意见<br/>
		                                <input type="checkbox" value="4" disabled="disabled" >检验检测 
		                                <input type="checkbox" value="5" disabled="disabled">网络监测
		                                <input type="checkbox" value="6" disabled="disabled">委托专业机构辅助 
	                                 </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray center" rowspan="6" width="15%"><strong>检查结果</strong></td>
	                                <td><input class="crt" type="checkbox" width="35%" disabled="disabled"><strong>未发现问题</strong></td>
	                                <td rowspan="6" width="50%">
	                                	<input class="crt" type="checkbox" disabled="disabled"><strong>发现问题待后续处理</strong><br/>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt" type="checkbox" disabled="disabled">违反工商行政管理相关规定</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt" type="checkbox" disabled="disabled">未按规定公示应当公示的信息</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt" type="checkbox" disabled="disabled">公示信息隐瞒真实情况弄虚作假</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt" type="checkbox" disabled="disabled">通过登记的住所（经营场所）无法联系</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt" type="checkbox" disabled="disabled">违反其他工商行政管理规定行为</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt" type="checkbox" disabled="disabled">违反食品药品管理相关规定</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt" type="checkbox" disabled="disabled">违反质量技术监督相关规定</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt" type="checkbox" disabled="disabled">违反其他部门相关规定</p>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" disabled="disabled"><strong>发现问题经责令已改正</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" disabled="disabled"><strong>未发现开展本次抽查涉及的经营活动</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" disabled="disabled"><strong>已关闭停业或正在组织清算</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" disabled="disabled"><strong>不配合检查情节严重</strong></td>
	                            </tr>
	                            <tr>
	                                <td>
	                                	<input class="crt" type="checkbox" disabled="disabled"><strong>注销</strong>
	                                	<input class="crt" type="checkbox" disabled="disabled"><strong>被吊销</strong>
	                                	<input class="crt" type="checkbox" disabled="disabled"><strong>被撤销</strong>
	                                	<input class="crt" type="checkbox" disabled="disabled"><strong>迁出</strong></td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray center"><strong>后续处置措施</strong></td>
	                                <td colspan="2">
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="未发现问题或相关问题已规范、已改正，无需后续处置；">未发现问题或相关问题已规范、已改正，无需后续处置；<br>
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="停止检查，反馈至日常监管部门依法依规处理；">停止检查，反馈至日常监管部门依法依规处理；<br>
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；">违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；<br>
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="发现案件线索，初步固定相关证据后移送办案机构依法依规处理；">发现案件线索，初步固定相关证据后移送办案机构依法依规处理；<br>
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="违反其他部门相关规定，抄告相关部门。">违反其他部门相关规定，抄告相关部门。<br>
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="other">其他：<input type="text" style="border:none;border-bottom:1px solid #000;">
	                                 </td>
	                            </tr>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       		 <tr>
	                                <td class="bg-gray center" width="15%"><strong style="line-height:1.5;">被检查<br/>单位意见</strong></td>
	                                <td colspan="3">
	                                <div style="float: right;"><strong>法定代表人（负责人）（签字或盖章）</strong></div>
	                                <br/>
	                                <div style="float: right;"><strong>&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</strong></div>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray center"><strong style="line-height:1.5;">检查人员<br/>签      名</strong></td>
	                                <td><div style="float: right;"><strong>&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</strong></div></td>
	                                <td class="bg-gray center" width="15%"><strong style="line-height:1.5;">组长审核<br/>意      见</strong></td>
	                                <td><div style="float: right;"><strong>&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</strong></div></td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray center"><strong style="line-height:1.5;">结果公示<br/>审批意见</strong></td>
	                                <td colspan="3"><div style="float: right;"><strong>&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</strong></div></td>
	                            </tr>
	                       </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</body>
</html>