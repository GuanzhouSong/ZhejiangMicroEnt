<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="now" class="java.util.Date" />
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
	                                <td class="bg-gray center" width="18%">检查事项</td>
	                                <td class="bg-gray center" width="12%">
	                                	是否检查
	                                </td>
	                                <td class="bg-gray center" width="35%">发现问题情况</td>
	                                <td class="bg-gray center" width="35%">处置情况</td>
	                            </tr>
	                            <c:forEach var="pubSccheckItemResult1" items="${pubSccheckItemResultList }" varStatus="status">
		                            <tr>
		                                <td>${status.index+1}. ${pubSccheckItemResult1.checkName }</td>
		                                <td class="center">
		                                	<input type="checkbox" disabled="disabled" class="chk" value="${pubSccheckItemResult1.checkCode }" name="chk_${pubSccheckItemResult1.checkCode }"
		                                		<c:if test="${not empty pubSccheckItemResult1.problem}">checked </c:if> 
		                                	>是
		                                </td>
		                                <td><textarea class="prodis" readonly="readonly"
		                                	style="<c:if test='${empty pubSccheckItemResult1.problem }'>display: none;</c:if>overflow-y:auto;"
		                                 id="problem_${pubSccheckItemResult1.checkCode }" name="problem_${pubSccheckItemResult1.checkCode }" >${pubSccheckItemResult1.problem }</textarea></td>
		                                <td><textarea class="prodis" readonly="readonly" 
		                                	style="<c:if test='${empty pubSccheckItemResult1.dispose }'>display: none;</c:if>overflow-y:auto;"
		                                 id="dispose_${pubSccheckItemResult1.checkCode }" name="dispose_${pubSccheckItemResult1.checkCode }" >${pubSccheckItemResult1.dispose }</textarea></td>
		                            </tr>
	                            </c:forEach>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                                <td class="bg-gray center">核查方式</td>
	                                <td colspan="2">
	                                	<input disabled="disabled" type="checkbox" value="1" name="checkTypeTmp"
	                                		<c:if test="${fn:indexOf(pubScentResultDto.checkType, 1)!=-1}">checked</c:if>
	                                	>实地检查 
		                                <input disabled="disabled" type="checkbox" value="2" name="checkTypeTmp"
		                                	<c:if test="${fn:indexOf(pubScentResultDto.checkType, 2)!=-1}">checked</c:if>
		                                >书面检查 
		                                <input disabled="disabled" type="checkbox" value="3" name="checkTypeTmp"
		                                	<c:if test="${fn:indexOf(pubScentResultDto.checkType, 3)!=-1}">checked</c:if>
		                                >行政部门检查结果或专业意见
		                                <input disabled="disabled" type="checkbox" value="4" name="checkTypeTmp"
		                                	<c:if test="${fn:indexOf(pubScentResultDto.checkType, 4)!=-1}">checked</c:if>
		                                >检验检测
		                                <input disabled="disabled" type="checkbox" value="5" name="checkTypeTmp"
		                                	<c:if test="${fn:indexOf(pubScentResultDto.checkType, 5)!=-1}">checked</c:if>
		                                >网络监测
		                                <input disabled="disabled" type="checkbox" value="6" name="checkTypeTmp"
		                                	<c:if test="${fn:indexOf(pubScentResultDto.checkType, 6)!=-1}">checked</c:if>
		                                >委托专业机构辅助 
	                                 </td>
	                            </tr>
	                           
	                            <c:set value="${fn:split(pubScentResultDto.checkResult, ',') }" var="str1" />
	                            <tr>
	                                <td class="bg-gray center" rowspan="5" width="20%"><span class="light">*</span>检查结果</td>
	                                <td><input disabled="disabled" class="crt" type="checkbox" value="1" name="checkResultTmp" width="40%"
									 	<c:forEach items="${str1 }" var="it">
	                                		<c:if test="${it=='1'}">checked</c:if>
	                                	</c:forEach>
	                                >未发现违法行为
	                                
	                                </td>
	                                <td><input disabled="disabled" class="crt" type="checkbox" value="6" name="checkResultTmp" width="40%"
	                                	<c:forEach items="${str1 }" var="it">
	                                		<c:if test="${it=='6'}">checked</c:if>
	                                	</c:forEach>
	                                >查无下落
	                            </tr>
	                            <tr>
	                                <td><input disabled="disabled" class="crt" type="checkbox" value="2" name="checkResultTmp"
	                                	<c:forEach items="${str1 }" var="it">
	                                		<c:if test="${it=='2'}">checked</c:if>
	                                	</c:forEach>
	                                >违反工商行政管理相关规定</td>
	                                <td><input disabled="disabled" class="crt" type="checkbox" value="7" name="checkResultTmp"
	                                	<c:if test="${fn:indexOf(pubScentResultDto.checkResult, 7)!=-1}">checked</c:if>
	                                >已关闭停业或正在清算</td>
	                            </tr>
	                            <tr>
	                                <td><input disabled="disabled" class="crt" type="checkbox" value="3" name="checkResultTmp"
	                                	<c:forEach items="${str1 }" var="it">
	                                		<c:if test="${it=='3'}">checked</c:if>
	                                	</c:forEach>
	                                >违反食品药品管理相关规定</td>
	                                <td><input disabled="disabled" class="crt" type="checkbox" value="8" name="checkResultTmp"
	                                	<c:if test="${fn:indexOf(pubScentResultDto.checkResult, 8)!=-1}">checked</c:if>
	                                >不予配合情节严重</td>
	                            </tr>
	                            <tr>
	                                <td><input disabled="disabled" class="crt" type="checkbox" value="4" name="checkResultTmp"
	                                	<c:forEach items="${str1 }" var="it">
	                                		<c:if test="${it=='4'}">checked</c:if>
	                                	</c:forEach>
	                                >违反质量技术监督相关规定</td>
	                                <td>
	                                	<input disabled="disabled" class="crt" type="checkbox" value="9" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(pubScentResultDto.checkResult, 9)!=-1}">checked</c:if>
	                                	>注销
	                                	<input disabled="disabled" class="crt" type="checkbox" value="10" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(pubScentResultDto.checkResult, 10)!=-1}">checked</c:if>
	                                	>被吊销
	                                	<input disabled="disabled" class="crt" type="checkbox" value="11" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(pubScentResultDto.checkResult, 11)!=-1}">checked</c:if>
	                                	>被撤销
	                                	<input disabled="disabled" class="crt" type="checkbox" value="12" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(pubScentResultDto.checkResult, 12)!=-1}">checked</c:if>
	                                	>迁出
	                                </td>
	                            </tr>
	                            <tr>
	                                <td colspan="2"><input disabled="disabled" class="crt" type="checkbox" value="5" name="checkResultTmp"
	                                	<c:if test="${fn:indexOf(pubScentResultDto.checkResult, 5)!=-1}">checked</c:if>
	                                >违反其他部门相关规定</td>
	                            </tr>
	                            
	                            <tr>
	                                <td class="bg-gray center">后续处置措施</td>
	                                <c:set value="${fn:split(pubScentResultDto.disposeMss, ',') }" var="str2" />
	                                <td colspan="2">
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="未发现问题或相关问题已规范、已改正，无需后续处置；"
	                                		<c:if test="${fn:indexOf(pubScentResultDto.disposeMss, '未发现问题或相关问题已规范、已改正，无需后续处置；')!=-1}">checked</c:if>
	                                	>未发现问题或相关问题已规范、已改正，无需后续处置；<br>
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="停止检查，反馈至日常监管部门依法依规处理；"
	                                		<c:if test="${fn:indexOf(pubScentResultDto.disposeMss, '停止检查，反馈至日常监管部门依法依规处理；')!=-1}">checked</c:if>
	                                	>停止检查，反馈至日常监管部门依法依规处理；<br>
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；"
	                                		<c:if test="${fn:indexOf(pubScentResultDto.disposeMss, '违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；')!=-1}">checked</c:if>
	                                	>违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；<br>
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="发现案件线索，初步固定相关证据后移送办案机构依法依规处理；"
	                                		<c:if test="${fn:indexOf(pubScentResultDto.disposeMss, '发现案件线索，初步固定相关证据后移送办案机构依法依规处理；')!=-1}">checked</c:if>
	                                	>发现案件线索，初步固定相关证据后移送办案机构依法依规处理；<br>
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="违反其他部门相关规定，抄告相关部门。"
	                                		<c:if test="${fn:indexOf(pubScentResultDto.disposeMss, '违反其他部门相关规定，抄告相关部门。')!=-1}">checked</c:if>
	                                	>违反其他部门相关规定，抄告相关部门。<br>
	                                	<input disabled="disabled" class="disaf" type="checkbox" name="disposeMssTmp" value="other"
	                                		<c:forEach items="${str2 }" var="it" varStatus="stat">
	                                			<c:if test="${stat.last}">
	                                				<c:if test="${it!='违反其他部门相关规定，抄告相关部门。'&&it!='发现案件线索，初步固定相关证据后移送办案机构依法依规处理；'
	                                				&&it!='违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；'&&it!='停止检查，反馈至日常监管部门依法依规处理；'
	                                				&&it!='未发现问题或相关问题已规范、已改正，无需后续处置；'
	                                				}">
	                                					checked
	                                					<c:set value="${it }" var="itt" />
	                                				</c:if>
	                                			</c:if>
	                                		</c:forEach>
	                                	>其他：<input readonly="readonly" id="other" type="text" value="${itt }">
	                                 </td>
	                            </tr>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       <input type='hidden' id="disposeState" value="${pubScentResultDto.disposeState }">
	                       		<tr>
	                       			<td class="bg-gray right" width="15%"><span class="light">*</span>后续处置措施是否完结</td>
	                       			<td width="35%">
	                       				<input type="radio" value="1" name="disposeState" class="dis"
	                       					<c:if test="${fn:indexOf(pubScentResultDto.disposeState, 1)!=-1}">checked</c:if>
	                       				>未完结 
	                       				<input type="radio" value="2" name="disposeState" class="dis"
	                       					<c:if test="${fn:indexOf(pubScentResultDto.disposeState, 2)!=-1}">checked</c:if>
	                       				>已完结<span class="sp"><textarea  rows="2" name="disposeFinishMss"></textarea></span>
	                       			</td>
	                       			<td class="bg-gray right" width="15%"><span class="sp"><span class="light">*</span>完结日期</span></td>
	                       			<td width="35%"><span class="sp"><input type="text" id="disposeFinishDate" name="disposeFinishDate" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value="<fmt:formatDate value='${pubScentResultDto.disposeFinishDate }' pattern='yyyy-MM-dd'/>"/></span></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">检查执行部门</td>
	                       			<td colspan="3"><input readonly="readonly" id="checkDeptName" type="text" value="${pubScentResultDto.checkDeptName }"></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">检查人员</td>
	                       			<td><input type="text" readonly="readonly" id="checkDeptPerson" value="${pubScentResultDto.checkDeptPerson }"></td>
	                       			<td class="bg-gray right">检查日期</td>
	                       			<td><input id="checkDate" type="text" class="ipt-txt laydate-icon"  readonly="readonly" value="<fmt:formatDate value='${pubScentResultDto.checkDate }' pattern='yyyy-MM-dd'/>"/></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">录入员</td>
	                       			<td><input type="text" disabled="disabled" value="${pubScentResultDto.enterUserName }"></td>
	                       			<td class="bg-gray right">录入日期</td>
	                       			<td><input disabled="disabled" type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value="<fmt:formatDate value='${pubScentResultDto.enterDate }' pattern='yyyy-MM-dd'/>"/></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">审核结果</td>
	                       			<td><input type="radio" disabled="disabled" class="pa" value="5"
	                       				<c:if test="${pubScentResultDto.auditState=='5' }">checked</c:if>
	                       			>通过
	                       			   <input type="radio" disabled="disabled" class="pa" value="4"
	                       			   		<c:if test="${pubScentResultDto.auditState=='4' }">checked</c:if>
	                       			   >不通过</td>
	                       			<td class="bg-gray right">审核员</td>
	                       			<td><input readonly="readonly" type="text" value="${pubScentResultDto.auditUserName }"/></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">审核意见</td>
	                       			<td><input type="text" readonly="readonly" id="auditOpinion" value="${pubScentResultDto.auditOpinion }"></td>
	                       			<td class="bg-gray right">审核日期</td>
	                       			<td><input type="text" class="ipt-txt laydate-icon" readonly="readonly" value="<fmt:formatDate value='${pubScentResultDto.auditDate }' pattern='yyyy-MM-dd'/>"/></td>
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
<script src="/js/syn/system/sccheck/scresult/scresultsupply_edit.js"></script>
</body>
</html>