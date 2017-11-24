<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
</head>
<body class="pd10">
<div class="print-nocard">
    <h3>市场监管领域随机抽查情况记录表</h3>
    <div class="mt10">
        <div class="tabbale" data-component="tab">
            <div class="tab-content">
              	<div class="tab-panel tab-panel-show" id="itemPanelDivId">
              	<form id="taskForm" method="post">
              	<input type="hidden" name="taskUid" value="${pubScentResultDto.taskUid }">
              	<input type="hidden" name="priPID" value="${pubScentResultDto.priPID }">
              	<input type="hidden" name="uid" value="${pubScentResultDto.uid }">
              	<input type="hidden" name="disposeMss" id="disposeMss">
              	<input type="hidden" name="checkType" id="checkType">
              	<input type="hidden" name="checkResult" id="checkResult">
              	<input type="hidden" id="maxNum" value="${maxNum }">
                    <div class="mt10">
                        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
                            <tbody>
                            	<tr>
	                                <td class="bg-gray right" width="15%">任务名称</td>
	                                <td width="35%">${pubScentResultDto.taskName }</td>
	                                <td class="bg-gray right" width="15%">任务编号</td>
	                                <td width="35%">${pubScentResultDto.taskCode }</td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right">被检查对象</td>
	                                <td>${pubScentResultDto.entName }</td>
	                                <td class="bg-gray right">统一信用代码/注册号</td>
	                                <td>${!empty pubScentResultDto.uniCode?pubScentResultDto.uniCode:pubScentResultDto.regNO}</td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right" rowspan="2">住所地址</td>
	                                <td rowspan="2">${pubScentResultDto.dom }</td>
	                                <td class="bg-gray right">法定代表人</td>
	                                <td>${pubEppassword.lerep } ${pubEppassword.lerepphone }</td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right">工商联络员</td>
	                                <td>${pubEppassword.lianame } ${pubEppassword.tel }</td>
	                            </tr>
	                         </tbody>
	                       </table>
	                       <table id="table2" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                            	<td class="bg-gray center" width="5%">操作</td>
	                                <td class="bg-gray center" width="23%">检查事项 
	                                <a class="addSccheckType">添加检查事项</a> <a class="addOtherSccheckType">添加其他检查事项</a></td>
	                                <td class="bg-gray center" width="12%">
	                                	<span class="light">*</span>是否检查
	                                	<input type="checkbox" id="checkAll" value="1">全选
	                                </td>
	                                <td class="bg-gray center" width="30%"><span class="light">*</span>发现问题情况 <input type="checkbox" class="problemno" value="2">全选“无”</td>
	                                <td class="bg-gray center" width="30%"><span class="light">*</span>处置情况 <input type="checkbox" class="disposeno" value="3">全选“无”</td>
	                            </tr>
	                            <c:forEach var="pubSccheckItem" items="${pubSccheckItemList1 }" varStatus="status">
		                            <tr>
		                            	<td></td>
		                                <td>${status.index + 1}. ${pubSccheckItem.checkName }<input type="hidden" name="checkName_${pubSccheckItem.checkCode }" value="${pubSccheckItem.checkName }"></td>
		                                <td class="center">
		                                	<input type="checkbox" class="chk" value="${pubSccheckItem.checkCode }" name="chk_${pubSccheckItem.checkCode }"
		                                	>是
		                                </td>
		                                <td><textarea class="prodis" style="overflow-y:auto;display: none" id="problem_${pubSccheckItem.checkCode }" name="problem_${pubSccheckItem.checkCode }"></textarea></td>
		                                <td><textarea class="prodis" style="overflow-y:auto;display: none" id="dispose_${pubSccheckItem.checkCode }" name="dispose_${pubSccheckItem.checkCode }"></textarea></td>
		                            </tr>
	                            </c:forEach>
	                            <c:forEach var="pubSccheckItem" items="${pubSccheckItemList2 }" varStatus="status">
		                            <tr>
		                            	<td class="center"><a class="del">删除</a></td>
		                                <td>其他：<input type="text" id="checkName_${pubSccheckItem.checkCode }" name="checkName_${pubSccheckItem.checkCode }" value="${pubSccheckItem.checkName }"></td>
		                                <td class="center">
		                                	<input type="checkbox" class="chk" value="${pubSccheckItem.checkCode }" name="chk_${pubSccheckItem.checkCode }">是
		                                </td>
		                                <td><textarea class="prodis" style="overflow-y:auto;display: none" id="problem_${pubSccheckItem.checkCode }" name="problem_${pubSccheckItem.checkCode }" ></textarea></td>
		                                <td><textarea class="prodis" style="overflow-y:auto;display: none"
		                                 id="dispose_${pubSccheckItem.checkCode }" name="dispose_${pubSccheckItem.checkCode }" ></textarea></td>
		                            </tr>
	                            </c:forEach>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                                <td width="15%" class="bg-gray center"><span class="light">*</span>核查方式(多选)</td>
	                                <td width="85%" colspan="2">
	                                	<input type="checkbox" value="1" name="checkTypeTmp" checked="checked">实地检查 
		                                <input type="checkbox" value="2" name="checkTypeTmp">书面检查 
		                                <input type="checkbox" value="3" name="checkTypeTmp">行政部门检查结果或专业意见
		                                <input type="checkbox" value="4" name="checkTypeTmp">检验检测 
		                                <input type="checkbox" value="5" name="checkTypeTmp">网络监测
		                                <input type="checkbox" value="6" name="checkTypeTmp">委托专业机构辅助 
	                                 </td>
	                            </tr>
	                            
	                            <tr>
	                                <td width="15%" class="bg-gray center" rowspan="6"><span class="light">*</span>检查结果</td>
	                                <td width="40%"><input class="crt" type="checkbox" value="1" name="checkResultTmp" width="35%"><strong>未发现问题</strong></td>
	                                <td rowspan="6" width="45%">
	                                	<input class="crt re3" type="checkbox" value="A" name="checkResultTmp"><strong>发现问题待后续处理</strong><br/>
	                                	<p style="text-indent: 2em;line-height:2;"><input id="reCheckBox" class="crt re1" type="checkbox" value="2" name="checkResultTmp">违反工商行政管理相关规定</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="B" name="checkResultTmp">未按规定公示应当公示的信息</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="C" name="checkResultTmp">公示信息隐瞒真实情况弄虚作假</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="6" name="checkResultTmp">通过登记的住所（经营场所）无法联系</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="D" name="checkResultTmp">违反其他工商行政管理规定行为</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt re1" type="checkbox" value="3" name="checkResultTmp">违反食品药品管理相关规定</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt re1" type="checkbox" value="4" name="checkResultTmp">违反质量技术监督相关规定</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt re1" type="checkbox" value="5" name="checkResultTmp">违反其他部门相关规定</p>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="E" name="checkResultTmp"><strong>发现问题经责令已改正</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="F" name="checkResultTmp"><strong>未发现开展本次抽查涉及的经营活动</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="7" name="checkResultTmp"><strong>已关闭停业或正在组织清算</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="8" name="checkResultTmp"><strong>不配合检查情节严重</strong></td>
	                            </tr>
	                            <tr>
	                            	<td>
	                                	<input class="crt" type="checkbox" value="9" name="checkResultTmp"><strong>注销</strong>
	                                	<input class="crt" type="checkbox" value="10" name="checkResultTmp"><strong>被吊销</strong>
	                                	<input class="crt" type="checkbox" value="11" name="checkResultTmp"><strong>被撤销</strong>
	                                	<input class="crt" type="checkbox" value="12" name="checkResultTmp"><strong>迁出</strong>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray center"><span class="light">*</span>后续处置措施</td>
	                                <td colspan="2">
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="未发现问题或相关问题已规范、已改正，无需后续处置；">未发现问题或相关问题已规范、已改正，无需后续处置；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="停止检查，反馈至日常监管部门依法依规处理；">停止检查，反馈至日常监管部门依法依规处理；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；">违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="发现案件线索，初步固定相关证据后移送办案机构依法依规处理；">发现案件线索，初步固定相关证据后移送办案机构依法依规处理；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="违反其他部门相关规定，抄告相关部门。">违反其他部门相关规定，抄告相关部门。<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="other">其他：<input id="other" type="text">
	                                 </td>
	                            </tr>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       		<tr>
	                       			<td class="bg-gray right" width="15%"><span class="light">*</span>后续处置措施是否完结</td>
	                       			<td width="35%"><input type="radio" value="1" name="disposeState" class="dis" checked="checked">未完结 
	                       				<input type="radio" value="2" name="disposeState" class="dis">已完结
	                       				<span class="sp"><textarea  rows="2" name="disposeFinishMss"></textarea></span>
	                       				</td>
	                       			<td class="bg-gray right" width="15%"><span class="sp"><span class="light">*</span>完结日期</span></td>
	                       			<td width="35%"><span class="sp"><input type="text" id="disposeFinishDate" name="disposeFinishDate" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value=""/></span></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>检查执行部门</td>
	                       			<td colspan="3"><input id="checkDeptName" name="checkDeptName" type="text" value="${pubScentResultDto.checkDeptName }"></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>检查人员</td>
	                       			<td><input type="text" id="checkDeptPerson" name="checkDeptPerson" value="${pubScentResultDto.checkDeptPerson }">
<!-- 	                       			<a href="javascript:void(0);" id="addAgent">添加</a> -->
	                       			</td>
	                       			<td class="bg-gray right"><span class="light">*</span>检查日期</td>
	                       			<td><input id="checkDate" name="checkDate" type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value=""/></td>
	                       		</tr>
	                       </table>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <p class="center mb30 mt20">
	    <input type="button" class="btn mr20" id="save" value="提交">
	    <input type="button" class="btn" id="close" value="关闭">
    </p>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scresult/scresultinsert_edit.js"></script>
</body>
</html>