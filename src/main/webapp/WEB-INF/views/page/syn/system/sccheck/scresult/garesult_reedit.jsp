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
              	<input type="hidden" id="taskUid" value="${pubScentResultDto.taskUid }">
              	<input type="hidden" id="mainTaskUid" value="${pubScentResultDto.mainTaskUid }">
              	<input type="hidden" id="priPID" value="${pubScentResultDto.priPID }">
              	<input type="hidden" id="uid" value="${pubScentResultDto.uid }">
              	<input type="hidden" id="dutyDeptCode" value="${pubScentResultDto.dutyDeptCode }">
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
	                            	<td class="bg-gray center" width="5%">序号</td>
	                                <td class="bg-gray center" width="10%">检查内容</td>
	                                <td class="bg-gray center" width="45%">操作方法与要领</td>
	                                <td class="bg-gray center" width="10%">
	                                	<span class="light">*</span>是否规范
	                                </td>
	                                <td class="bg-gray center" width="30%"><span class="light">*</span>发现问题情况</td>
	                            </tr>
	                            <c:forEach items="${sccheckKeyList }" var="sccheckKey" varStatus="status">
	                            	<tr>
		                            	<td class="center indexkey">${status.index + 1}</td>
		                            	<td class="center" id="content_${status.index + 1}">${sccheckKey.checkContent }</td>
		                            	<td id="method_${status.index + 1}">${sccheckKey.checkMethod }</td>
		                            	<td class="center">
		                            		<input type="radio" value="1" disabled="disabled" class="checkkey" name="check${status.index + 1}" problem="1" id="ra_${status.index + 1}_1" defaultinput="${sccheckKey.yesText }" <c:if test="${sccheckKey.isCheck == '1' }">checked</c:if>/>是
		                            		<input type="radio" name="check${status.index + 1}" disabled="disabled" class="checkkey" problem="1" value="2" id="ra_${status.index + 1}_2" defaultinput="${sccheckKey.noText }" <c:if test="${sccheckKey.isCheck == '2' }">checked</c:if>/>否
		                            	</td>
		                            	<td class="center"><input type="input" id="problem_${status.index + 1}" disabled="disabled" class="ipt-txt" style="width: 99%" value="${sccheckKey.problem }"/></td>
		                            </tr>
	                            </c:forEach>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                                <td width="15%" class="bg-gray center"><span class="light">*</span>要求提供材料</td>
	                                <td width="85%" colspan="2">
	                                	<c:if test="${!empty pubScentResultDto.materials }">
	                                		<c:set value="${fn:split(pubScentResultDto.materials, ',') }" var="materialsV" />
	                                	</c:if>
	                                	<input type="checkbox" value="1" name="materail" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.materials, '1')!=-1}">checked</c:if> />营业执照
		                                <input type="checkbox" value="2" name="materail" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.materials, '2')!=-1}">checked</c:if> />取得的生产经营许可证和非药品类易制毒化学品生产经营备案证明<br/>
		                                <input type="checkbox" value="3" name="materail" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.materials, '3')!=-1}">checked</c:if> />身份证明
		                                <input type="checkbox" value="4" name="materail" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.materials, '4')!=-1}">checked</c:if> />日常手工台账
		                                <input type="checkbox" value="5" name="materail" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.materials, '5')!=-1}">checked</c:if> />购买许可证或备案证明 
		                                <input type="checkbox" value="6" name="materail" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.materials, '6')!=-1}">checked</c:if> />运输许可证或备案证明<br/>
		                                <input class="disaf" type="checkbox" name="materail" disabled="disabled" value="other"
		                                	<c:if test="${!empty pubScentResultDto.materials }">
			                                	<c:forEach items="${materialsV }" var="it" varStatus="stat">
		                                			<c:if test="${stat.last}">
		                                				<c:if test="${it!='1'&&it!='2'&&it!='3'&&it!='4'&&it!='5'&&it!='6'}">
		                                					checked
		                                					<c:set value="${it }" var="itt" />
		                                				</c:if>
		                                			</c:if>
		                                		</c:forEach> 
	                                		</c:if>
	                                		/>
		                                                                                                其他：<input id="materailOther" type="text" disabled="disabled" value="<c:if test='${!empty pubScentResultDto.materials }'>${itt }</c:if>" />
	                                 </td>
	                            </tr>
	                            <tr>
	                                <td width="15%" class="bg-gray center" rowspan="6"><span class="light">*</span>检查结果</td>
	                                <td width="40%"><input class="crt" type="checkbox" value="1" disabled="disabled" name="checkResultTmp" width="35%" <c:if test="${pubScentResultDto.checkResult == '1'}">checked</c:if> textkey="未发现问题；" /><strong>未发现问题</strong></td>
	                                <td rowspan="6" width="45%">
	                                	<input class="crt re3" type="checkbox" value="A" disabled="disabled" name="checkResultTmp" textkey="发现问题待后续处理；" <c:if test="${fn:indexOf(pubScentResultDto.checkResult, 'A')!=-1}">checked</c:if> <c:if test="${pubScentResultDto.checkResult == '1'}">disabled="disabled"</c:if>/><strong>发现问题待后续处理</strong><br/>
	                                	<p style="text-indent: 2em;line-height:2;"><input id="reCheckBox" class="crt re1" type="checkbox" disabled="disabled" value="G" name="checkResultTmp" textkey="违反公安部门相关规定；" <c:if test="${fn:indexOf(pubScentResultDto.checkResult, 'G')!=-1}">checked</c:if> <c:if test="${pubScentResultDto.checkResult == '1'}">disabled="disabled"</c:if>/>违反公安部门相关规定</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt re1" type="checkbox" value="5" disabled="disabled" name="checkResultTmp" textkey="违反其他部门相关规定；" <c:if test="${fn:indexOf(pubScentResultDto.checkResult, '5')!=-1}">checked</c:if> <c:if test="${pubScentResultDto.checkResult == '1'}">disabled="disabled"</c:if>/>违反其他部门相关规定</p>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="E" name="checkResultTmp" textkey="发现问题经责令已改正；" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.checkResult, 'E')!=-1}">checked</c:if> <c:if test="${pubScentResultDto.checkResult == '1'}">disabled="disabled"</c:if>/><strong>发现问题经责令已改正</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="F" name="checkResultTmp" textkey="未发现开展本次抽查涉及的经营活动；" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.checkResult, 'F')!=-1}">checked</c:if> <c:if test="${pubScentResultDto.checkResult == '1'}">disabled="disabled"</c:if>/><strong>未发现开展本次抽查涉及的经营活动</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="7" name="checkResultTmp" textkey="已关闭停业或正在组织清算；" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.checkResult, '7')!=-1}">checked</c:if> <c:if test="${pubScentResultDto.checkResult == '1'}">disabled="disabled"</c:if>/><strong>已关闭停业或正在组织清算</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="8" name="checkResultTmp" textkey="不配合检查情节严重；" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.checkResult, '8')!=-1}">checked</c:if> <c:if test="${pubScentResultDto.checkResult == '1'}">disabled="disabled"</c:if>/><strong>不配合检查情节严重</strong></td>
	                            </tr>
	                            <tr>
	                            	<td>
	                                	<input class="crt" type="checkbox" value="9" name="checkResultTmp" textkey="注销；" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.checkResult, '9')!=-1}">checked</c:if> <c:if test="${pubScentResultDto.checkResult == '1'}">disabled="disabled"</c:if>/><strong>注销</strong>
	                                	<input class="crt" type="checkbox" value="10" name="checkResultTmp" textkey="被吊销；" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.checkResult, '10')!=-1}">checked</c:if> <c:if test="${pubScentResultDto.checkResult == '1'}">disabled="disabled"</c:if>/><strong>被吊销</strong>
	                                	<input class="crt" type="checkbox" value="11" name="checkResultTmp" textkey="被撤销；" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.checkResult, '11')!=-1}">checked</c:if> <c:if test="${pubScentResultDto.checkResult == '1'}">disabled="disabled"</c:if>/><strong>被撤销</strong>
	                                	<input class="crt" type="checkbox" value="12" name="checkResultTmp" textkey="迁出；" disabled="disabled" <c:if test="${fn:indexOf(pubScentResultDto.checkResult, '12')!=-1}">checked</c:if> <c:if test="${pubScentResultDto.checkResult == '1'}">disabled="disabled"</c:if>/><strong>迁出</strong>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray center"><span class="light">*</span>后续处置措施</td>
	                                <td colspan="2">
	                                	<c:if test="${!empty pubScentResultDto.disposeMss }">
		                                	<c:set value="${fn:split(pubScentResultDto.disposeMss, '；') }" var="disMssV" />
	                                	</c:if>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" disabled="disabled" value="违法处罚；"  <c:if test="${fn:indexOf(pubScentResultDto.disposeMss, '违法处罚；')!=-1}">checked</c:if> />违法处罚<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" disabled="disabled" value="刑事立案；"  <c:if test="${fn:indexOf(pubScentResultDto.disposeMss, '刑事立案；')!=-1}">checked</c:if> />刑事立案<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" disabled="disabled" value="违反其他部门相关规定，抄告相关部门；"  <c:if test="${fn:indexOf(pubScentResultDto.disposeMss, '违反其他部门相关规定，抄告相关部门；')!=-1}">checked</c:if> />违反其他部门相关规定，抄告相关部门。<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" disabled="disabled" value="other"
	                                		<c:if test="${!empty pubScentResultDto.disposeMss }">
		                                		<c:forEach items="${disMssV }" var="it" varStatus="status">
		                                			<c:if test="${status.last}">
		                                				<c:if test="${it!='违法处罚 '&&it!='刑事立案'&&it!='违反其他部门相关规定，抄告相关部门'}">
		                                					checked
		                                					<c:set value="${it }" var="otherDis" />
		                                				</c:if>
		                                			</c:if>
		                                		</c:forEach>
	                                		</c:if>
	                                	/>
	                                	其他：
	                                	<input id="other" type="text" disabled="disabled" value="<c:if test='${!empty pubScentResultDto.disposeMss }'>${otherDis }</c:if>">
	                                 </td>
	                            </tr>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       		<tr>
	                       			<td class="bg-gray right" width="15%"><span class="light">*</span>后续处置措施是否完结</td>
	                       			<td width="35%"><input type="radio" value="1" id="disposeState1" name="disposeState" class="dis" <c:if test="${pubScentResultDto.disposeState == '1'}">checked</c:if> />未完结 
	                       				<input type="radio" value="2" name="disposeState" class="dis" <c:if test="${pubScentResultDto.disposeState == '2'}">checked</c:if> />已完结
	                       				<span class="sp" <c:if test="${pubScentResultDto.disposeState == '1'}">style="display: none"</c:if>>
	                       					<textarea  rows="2" id="disposeFinishMss" name="disposeFinishMss">${pubScentResultDto.disposeFinishMss }</textarea>
                       					</span>
	                       				</td>
	                       			<td class="bg-gray right" width="15%"><span class="sp" <c:if test="${pubScentResultDto.disposeState == '1'}">style="display: none"</c:if>><span class="light">*</span>完结日期</span></td>
	                       			<td width="35%">
		                       			<span class="sp" <c:if test="${pubScentResultDto.disposeState == '1'}">style="display: none"</c:if> >
		                       				<input type="text" id="disposeFinishDate" name="disposeFinishDate" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value="<fmt:formatDate value='${pubScentResultDto.disposeFinishDate }' pattern='yyyy-MM-dd'/>"/>
		                       			</span>
	                       			</td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>检查执行部门</td>
	                       			<td colspan="3"><input id="checkDeptName" name="checkDeptName" type="text" disabled="disabled" value="${pubScentResultDto.checkDeptName }"></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>检查人员</td>
	                       			<td><input type="text" id="checkDeptPerson" name="checkDeptPerson" disabled="disabled" value="${pubScentResultDto.checkDeptPerson }">
<!-- 	                       			<a href="javascript:void(0);" id="addAgent">添加</a> -->
	                       			</td>
	                       			<td class="bg-gray right"><span class="light">*</span>检查日期</td>
	                       			<td><input id="checkDate" name="checkDate" type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value="<fmt:formatDate value='${pubScentResultDto.checkDate }' pattern='yyyy-MM-dd'/>"/></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">录入员</td>
	                       			<td><input type="text" disabled="disabled" name="checkDeptPerson" value="${pubScentResultDto.enterUserName }"></td>
	                       			<td class="bg-gray right">录入日期</td>
	                       			<td><input disabled="disabled" name="enterDate" type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value="<fmt:formatDate value='${pubScentResultDto.enterDate }' pattern='yyyy-MM-dd'/>"/></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>审核结果</td>
	                       			<td><input type="radio" class="pa" name="auditState" value="5" disabled="disabled" <c:if test="${pubScentResultDto.auditState == '5' }">checked</c:if>>通过
	                       			   <input type="radio" class="pa" name="auditState" value="4" disabled="disabled" <c:if test="${pubScentResultDto.auditState == '4' }">checked</c:if>>不通过</td>
	                       			<td class="bg-gray right">审核员</td>
	                       			<td><input disabled="disabled" type="text" id="auditUserName" value="${pubScentResultDto.auditUserName }"/></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>审核意见</td>
	                       			<td>
                       					<input type="text" id="auditOpinion" name="auditOpinion" disabled="disabled" value="${pubScentResultDto.auditOpinion }"/>
	                       			</td>
	                       			<td class="bg-gray right">审核日期</td>
	                       			<td>
	                       				<input name="auditDate" type="text" class="ipt-txt laydate-icon" readonly="readonly" value="<fmt:formatDate value='${pubScentResultDto.auditDate }' pattern='yyyy-MM-dd'/>"/>
	                       			</td>
	                       		</tr>
	                       </table>
                    </div>
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
<script src="/js/syn/system/sccheck/scresult/garesult_reedit.js"></script>
</body>
</html>