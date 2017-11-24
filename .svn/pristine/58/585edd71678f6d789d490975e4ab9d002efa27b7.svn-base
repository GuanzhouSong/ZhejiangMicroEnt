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
    <title>日常检查结果详情</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="print-nocard">
    <div class="mt10">
        <div class="tabbale" data-component="tab">
            <div class="tab-content">
              	<div class="tab-panel tab-panel-show" id="itemPanelDivId">
                    <div class="mt10">
                        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                            <tbody>
                            	<tr>
	                                <td class="bg-gray right" width="15%">检查对象类型</td>
	                                <td width="85%" colspan="3">
	                                	<input 
	                                		<c:if test="${dailyInspectResult.checkObjType==1 }">checked</c:if>
	                                	type="radio" disabled="disabled">企业
	                                	<input
	                                		<c:if test="${dailyInspectResult.checkObjType==2 }">checked</c:if>
	                                	type="radio" disabled="disabled">无证无照户
	                                	<input
	                                		<c:if test="${dailyInspectResult.checkObjType==3 }">checked</c:if>
	                                	type="radio" disabled="disabled">非企业单位
	                                </td>
	                            </tr>
	                            <tr>
	                                <td width="15%" class="bg-gray right">被检查对象</td>
	                                <td width="35%"><input type="text" name="checkObj" readonly="readonly" size="49" value="${dailyInspectResult.checkObj }"></td>
	                                <td width="15%" class="bg-gray right">统一信用代码/注册号</td>
	                                <td width="35%">
		                                <input type="text" name="cidRegNO" size="35" readonly="readonly" value="${dailyInspectResult.cidRegNO }">
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right" rowspan="2">住所地址</td>
	                                <td rowspan="2">
	                                	<textarea name="dom" id="dom" readonly="readonly" rows="3" cols="50">${dailyInspectResult.dom }</textarea>
	                                </td>
	                                <td class="bg-gray right">负责人</td>
	                                <td>
	                                	<input id="lerep" name="lerep" value="${dailyInspectResult.lerep }" readonly="readonly" type="text" size="15"> 
		                                <input id="tel" name="tel" value="${dailyInspectResult.tel }" readonly="readonly" type="text" size="15">
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right">联系人</td>
	                                <td>
		                                <input id="liaName" name="liaName" value="${dailyInspectResult.liaName }" readonly="readonly" type="text" size="15" > 
		                                <input id="liaTel" name="liaTel" value="${dailyInspectResult.liaTel }" readonly="readonly" type="text" size="15" >
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right" width="15%">任务来源</td>
	                                <td width="85%" colspan="3">
	                                	<input name="taskSource" type="radio" value="1" disabled="disabled"
	                                		<c:if test="${dailyInspectResult.taskSource=='1' }">checked</c:if>
	                                	>交办转办
	                                	<input name="taskSource" type="radio" value="3" disabled="disabled"
	                                		<c:if test="${dailyInspectResult.taskSource=='3' }">checked</c:if>
	                                	>日常巡查
	                                	<input name="taskSource" type="radio" value="4" disabled="disabled"
	                                		<c:if test="${dailyInspectResult.taskSource=='4' }">checked</c:if>
	                                	>数据监测
	                                </td>
	                            </tr>
	                         </tbody>
	                       </table>
	                       <table id="table2" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
	                       	  <tbody>
	                            <tr>
	                            	<td class="bg-gray center" width="10%">序号</td>
	                                <td class="bg-gray center" width="23%">
	                                	检查内容
	                                </td>
	                                <td class="bg-gray center" width="30%">发现问题情况 
	                                <td class="bg-gray center" width="30%">处置情况 
	                            </tr>
	                            <c:forEach var="dailyInspectItemResult" items="${dailyInspectItemResultList }" varStatus="status">
		                            <tr>
		                                <td class="center">${status.index+1}</td>
		                                <td>
		                                	${dailyInspectItemResult.checkName }
		                                </td>
		                                <td>
		                                	${dailyInspectItemResult.problem }
		                                <td>
		                                	${dailyInspectItemResult.dispose }
		                                </td>
		                            </tr>
	                            </c:forEach>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                                <td width="15%" class="bg-gray center">核查方式(多选)</td>
	                                <td width="85%" colspan="2">
	                                	<input type="checkbox" value="1" name="checkTypeTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkType, 1)!=-1}">checked</c:if>
	                                	>实地检查 
		                                <input type="checkbox" value="2" name="checkTypeTmp" disabled="disabled"
		                                	<c:if test="${fn:indexOf(dailyInspectResult.checkType, 2)!=-1}">checked</c:if>
		                                >书面检查 
		                                <input type="checkbox" value="3" name="checkTypeTmp" disabled="disabled"
		                                	<c:if test="${fn:indexOf(dailyInspectResult.checkType, 3)!=-1}">checked</c:if>
		                                >行政部门检查结果或专业意见
		                                <input type="checkbox" value="4" name="checkTypeTmp" disabled="disabled"
		                                	<c:if test="${fn:indexOf(dailyInspectResult.checkType, 4)!=-1}">checked</c:if>
		                                >检验检测 
		                                <input type="checkbox" value="5" name="checkTypeTmp" disabled="disabled"
		                                	<c:if test="${fn:indexOf(dailyInspectResult.checkType, 5)!=-1}">checked</c:if>
		                                >网络监测
		                                <input type="checkbox" value="6" name="checkTypeTmp" disabled="disabled"
		                                	<c:if test="${fn:indexOf(dailyInspectResult.checkType, 6)!=-1}">checked</c:if>
		                                >委托专业机构辅助 
	                                 </td>
	                            </tr>
	                            <c:set value="${fn:split(dailyInspectResult.checkResult, ',') }" var="str1" />
	                            <tr>
	                                <td width="15%" class="bg-gray center" rowspan="6">检查结果</td>
	                                <td width="40%"><input disabled="disabled" class="crt" type="checkbox" value="1" name="checkResultTmp" width="35%"
	                                	<c:forEach items="${str1 }" var="it">
	                                		<c:if test="${it=='1'}">checked</c:if>
	                                	</c:forEach>
	                                ><strong>未发现问题</strong></td>
	                                <td rowspan="6" width="45%">
	                                	<input class="crt re3" type="checkbox" value="A" name="checkResultTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, 'A')!=-1}">checked</c:if>
	                                	><strong>发现问题待后续处理</strong><br/>
	                                	<p style="text-indent: 2em;line-height:2;"><input id="reCheckBox" class="crt re1" type="checkbox" value="2" name="checkResultTmp" disabled="disabled"
	                                		<c:forEach items="${str1 }" var="it">
		                                		<c:if test="${it=='2'}">checked</c:if>
		                                	</c:forEach>
	                                	>违反工商行政管理相关规定</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="B" name="checkResultTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, 'B')!=-1}">checked</c:if>
	                                	>未按规定公示应当公示的信息</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="C" name="checkResultTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, 'C')!=-1}">checked</c:if>
	                                	>公示信息隐瞒真实情况弄虚作假</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="6" name="checkResultTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, '6')!=-1}">checked</c:if>
	                                	>通过登记的住所（经营场所）无法联系</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="D" name="checkResultTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, 'D')!=-1}">checked</c:if>
	                                	>违反其他工商行政管理规定行为</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt re1" type="checkbox" value="3" name="checkResultTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, '3')!=-1}">checked</c:if>
	                                	>违反食品药品管理相关规定</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt re1" type="checkbox" value="4" name="checkResultTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, '4')!=-1}">checked</c:if>
	                                	>违反质量技术监督相关规定</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt re1" type="checkbox" value="5" name="checkResultTmp" readonly="readonly"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, '5')!=-1}">checked</c:if>
	                                	>违反其他部门相关规定</p>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="E" name="checkResultTmp" disabled="disabled"
	                                	<c:if test="${fn:indexOf(dailyInspectResult.checkResult, 'E')!=-1}">checked</c:if>
	                                ><strong>发现问题经责令已改正</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="F" name="checkResultTmp" disabled="disabled"
	                                	<c:if test="${fn:indexOf(dailyInspectResult.checkResult, 'F')!=-1}">checked</c:if>
	                                ><strong>未发现开展本次抽查涉及的经营活动</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="7" name="checkResultTmp" disabled="disabled"
	                                	<c:if test="${fn:indexOf(dailyInspectResult.checkResult, '7')!=-1}">checked</c:if>
	                                ><strong>已关闭停业或正在组织清算</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="8" name="checkResultTmp" disabled="disabled"
	                                	<c:if test="${fn:indexOf(dailyInspectResult.checkResult, '8')!=-1}">checked</c:if>
	                                ><strong>不配合检查情节严重</strong></td>
	                            </tr>
	                            <tr>
	                            	<td>
	                                	<input class="crt" type="checkbox" value="9" name="checkResultTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, '9')!=-1}">checked</c:if>
	                                	><strong>注销</strong>
	                                	<input class="crt" type="checkbox" value="10" name="checkResultTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, '10')!=-1}">checked</c:if>
	                                	><strong>被吊销</strong>
	                                	<input class="crt" type="checkbox" value="11" name="checkResultTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, '11')!=-1}">checked</c:if>
	                                	><strong>被撤销</strong>
	                                	<input class="crt" type="checkbox" value="12" name="checkResultTmp" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.checkResult, '12')!=-1}">checked</c:if>
	                                	><strong>迁出</strong>
	                                </td>
	                            </tr>
	                            <c:set value="${fn:split(dailyInspectResult.disposeMss, ',') }" var="str2" />
	                            <tr>
	                                <td class="bg-gray center">后续处置措施</td>
	                                <td colspan="2">
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="未发现问题或相关问题已规范、已改正，无需后续处置；" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.disposeMss, '未发现问题或相关问题已规范、已改正，无需后续处置；')!=-1}">checked</c:if>
	                                	>未发现问题或相关问题已规范、已改正，无需后续处置；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="停止检查，反馈至日常监管部门依法依规处理；" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.disposeMss, '停止检查，反馈至日常监管部门依法依规处理；')!=-1}">checked</c:if>
	                                	>停止检查，反馈至日常监管部门依法依规处理；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.disposeMss, '违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；')!=-1}">checked</c:if>
	                                	>违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="发现案件线索，初步固定相关证据后移送办案机构依法依规处理；" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.disposeMss, '发现案件线索，初步固定相关证据后移送办案机构依法依规处理；')!=-1}">checked</c:if>
	                                	>发现案件线索，初步固定相关证据后移送办案机构依法依规处理；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="违反其他部门相关规定，抄告相关部门。" disabled="disabled"
	                                		<c:if test="${fn:indexOf(dailyInspectResult.disposeMss, '违反其他部门相关规定，抄告相关部门。')!=-1}">checked</c:if>
	                                	>违反其他部门相关规定，抄告相关部门。<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="other" disabled="disabled"
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
	                                	>其他：<input id="other" type="text" value="${itt }" disabled="disabled">
	                                 </td>
	                            </tr>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       		<tr>
	                       			<td class="bg-gray right" width="15%">后续处置措施是否完结</td>
	                       			<td width="35%"><input type="radio" value="1" name="disposeState" class="dis" disabled="disabled"
	                       				<c:if test="${fn:indexOf(dailyInspectResult.disposeState, 1)!=-1}">checked</c:if>
	                       			>未完结 
	                       				<input type="radio" value="2" name="disposeState" class="dis"
	                       					<c:if test="${fn:indexOf(dailyInspectResult.disposeState, 2)!=-1}">checked</c:if>
	                       				>已完结
	                       				</td>
	                       			<td class="bg-gray right" width="15%"><span class="sp">完结日期</span></td>
	                       			<td width="35%"><span class="sp"><input readonly="readonly" type="text" id="disposeFinishDate" name="disposeFinishDate" class="ipt-txt laydate-icon" value="<fmt:formatDate value='${dailyInspectResult.disposeFinishDate }' pattern='yyyy-MM-dd'/>"/></span></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">检查执行部门</td>
	                       			<td><input type="text" name="checkDeptName" value="${dailyInspectResult.checkDeptName }" readonly="readonly"></td>
	                       			<td class="bg-gray right">检查机关</td>
	                       			<td><input type="text" name="checkOrgName" value="${dailyInspectResult.checkOrgName }" readonly="readonly"></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">检查人员</td>
	                       			<td><input readonly="readonly" id="checkDeptPerson" name="checkDeptPerson" type="text" value="${dailyInspectResult.checkDeptPerson }">
	                       			</td>
	                       			<td class="bg-gray right">检查日期</td>
	                       			<td><input id="checkDate" type="text" name="checkDate" class="ipt-txt laydate-icon" readonly="readonly" value="<fmt:formatDate value='${dailyInspectResult.checkDate }' pattern='yyyy-MM-dd'/>"/></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">录入人员</td>
	                       			<td><input name="enterUserName" value="${dailyInspectResult.enterUserName }" type="text" readonly="readonly">
	                       			</td>
	                       			<td class="bg-gray right">录入日期</td>
	                       			<td><input name="enterDate" type="text" value="<fmt:formatDate value='${dailyInspectResult.enterDate }' pattern='yyyy-MM-dd'/>" readonly="readonly"/></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">修改内容</td>
	                       			<td colspan="3"><input readonly="readonly" id="alterContent" name="alterContent" type="text" value="${dailyInspectResult.alterContent }">
	                       			</td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">修改人员</td>
	                       			<td><input readonly="readonly" name="alterUserName" type="text" value="${dailyInspectResult.alterUserName }">
	                       			</td>
	                       			<td class="bg-gray right">修改日期</td>
	                       			<td><input name="alterDate" readonly="readonly" type="text" value="<fmt:formatDate value='${dailyInspectResult.alterDate }' pattern='yyyy-MM-dd'/>"/></td>
	                       		</tr>
	                       </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
</body>
</html>