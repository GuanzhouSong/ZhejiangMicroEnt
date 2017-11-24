<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<style type="text/css">
.inhei{height: 28px}
</style>
<body class="pd10">
<div class="print-nocard">
    <div class="mt20">
        <div class="tabbale" data-component="tab">
            <div class="tab-content">
              	<div class="tab-panel tab-panel-show" id="itemPanelDivId">
              	<form id="taskForm" method="post">
              	<input type="hidden" name="taskUid" value="${specialRecResult.taskUid}">
              	<input type="hidden" name="priPID" value="${specialRecResult.priPID }">
              	<input type="hidden" name="uid" value="${specialRecResult.uid }">
              	<input type="hidden" name="disposeMss" id="disposeMss">
              	<input type="hidden" name="checkType" id="checkType">
              	<input type="hidden" name="checkResult" id="checkResult">
              	<input type="hidden" id="maxNum" value="${(maxNum==0)?'1':maxNum}">
              	<input type="hidden" id="addNum" value="${(maxNum==0)?'1':maxNum}">
              	<input type="hidden" id="dataType" name="dataType" value="1">
                    <div class="mt10">
                        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
                            <tbody>
                            	<tr>
	                                <td class="bg-gray right" width="15%">任务名称</td>
	                                <td width="35%">${specialRecResult.taskName }</td>
	                                <td class="bg-gray right" width="15%">任务编号</td>
	                                <td width="35%">${specialRecResult.taskCode }</td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right">被检查对象</td>
	                                <td>${specialRecResult.entName }</td>
	                                <td class="bg-gray right">统一信用代码/注册号</td>
	                                <td>${!empty specialRecResult.uniCode?specialRecResult.uniCode:specialRecResult.regNO}</td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right" rowspan="2">住所地址</td>
	                                <td rowspan="2">${specialRecResult.dom }</td>
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
	                                <td class="bg-gray center" width="30%">
	                                    <span class="light">*</span>检查内容
	                                    <c:if test="${flag =='1'||flag =='2'}">
	                                		<a class="addSccheckType">添加信息栏</a>
	                                	</c:if>
	                                </td>
	                                <td class="bg-gray center" width="30%"><span class="light">*</span>发现问题情况 </td>
	                                <td class="bg-gray center" width="30%"><span class="light">*</span>处置情况 </td>
	                            </tr>
	                            <c:if test="${!empty specialRecItems}">
	                            	<c:forEach var="specialRecItem" items="${specialRecItems}" varStatus="status">
		                            <tr>
		                            	<td class="center"><a class="del">删除</a></td>
		                                <td>
		                                    <textarea  style="overflow-y:auto;"  name="checkContent_${status.index+1}">${specialRecItem.checkContent}</textarea>
		                                </td>
		                                <td class="center">
		                                	<textarea  style="overflow-y:auto;"  name="chechProblem_${status.index+1}">${specialRecItem.checkProblem}</textarea>
		                                </td>
		                                <td class="center">
		                                	<textarea  style="overflow-y:auto;"  name="disposalContent_${status.index+1}">${specialRecItem.disposalContent}</textarea>
		                                </td>
		                            </tr>
	                            </c:forEach>
	                            </c:if>
	                            <c:if test="${empty specialRecItems}">
	                                <tr>
		                            	<td class="center"><a class="del">删除</a></td>
		                                <td>
		                                    <textarea  style="overflow-y:auto;"  name="checkContent_1"></textarea>
		                                </td>
		                                <td class="center">
		                                	<textarea  style="overflow-y:auto;"  name="chechProblem_1"></textarea>
		                                </td>
		                                <td class="center">
		                                	<textarea  style="overflow-y:auto;"  name="disposalContent_1"></textarea>
		                                </td>
		                            </tr>
	                            </c:if>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                                <td width="15%" class="bg-gray center"><span class="light">*</span>核查方式(多选)</td>
	                                <td width="85%" colspan="2">
	                                	<input type="checkbox" value="1" name="checkTypeTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkType, 1)!=-1}">checked</c:if>
	                                	>实地检查 
		                                <input type="checkbox" value="2" name="checkTypeTmp"
		                                	<c:if test="${fn:indexOf(specialRecResult.checkType, 2)!=-1}">checked</c:if>
		                                >书面检查 
		                                <input type="checkbox" value="3" name="checkTypeTmp"
		                                	<c:if test="${fn:indexOf(specialRecResult.checkType, 3)!=-1}">checked</c:if>
		                                >行政部门检查结果或专业意见
		                                <input type="checkbox" value="4" name="checkTypeTmp"
		                                	<c:if test="${fn:indexOf(specialRecResult.checkType, 4)!=-1}">checked</c:if>
		                                >检验检测
		                                <input type="checkbox" value="5" name="checkTypeTmp"
		                                	<c:if test="${fn:indexOf(specialRecResult.checkType, 5)!=-1}">checked</c:if>
		                                >网络监测
		                                <input type="checkbox" value="6" name="checkTypeTmp"
		                                	<c:if test="${fn:indexOf(specialRecResult.checkType, 6)!=-1}">checked</c:if>
		                                >委托专业机构辅助 
	                                 </td>
	                                <tr>
	                            </tr>
	                            </tr>
	                            
	                            <c:set value="${fn:split(specialRecResult.checkResult, ',') }" var="str1" />
	                            <tr>
	                                <td width="15%" class="bg-gray center" rowspan="6"><span class="light">*</span>检查结果</td>
	                                <td width="40%"><input class="crt" type="checkbox" value="1" name="checkResultTmp" width="35%"
	                                	<c:forEach items="${str1 }" var="it">
	                                		<c:if test="${it=='1'}">checked</c:if>
	                                	</c:forEach>
	                                ><strong>未发现问题</strong></td>
	                                <td rowspan="6" width="45%">
	                                	<input class="crt re3" type="checkbox" value="A" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, 'A')!=-1}">checked</c:if>
	                                	><strong>发现问题待后续处理</strong><br/>
	                                	<p style="text-indent: 2em;line-height:2;"><input id="reCheckBox" class="crt re1" type="checkbox" value="2" name="checkResultTmp"
	                                		<c:forEach items="${str1 }" var="it">
	                                		<c:if test="${it=='2'}">checked</c:if>
	                                	</c:forEach>
	                                	>违反工商行政管理相关规定</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="B" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, 'B')!=-1}">checked</c:if>
	                                	>未按规定公示应当公示的信息</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="C" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, 'C')!=-1}">checked</c:if>
	                                	>公示信息隐瞒真实情况弄虚作假</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="6" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, '6')!=-1}">checked</c:if>
	                                	>通过登记的住所（经营场所）无法联系</p>
	                                	<p style="text-indent: 4em;line-height:2;"><input class="crt re2" type="checkbox" value="D" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, 'D')!=-1}">checked</c:if>
	                                	>违反其他工商行政管理规定行为</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt re1" type="checkbox" value="3" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, '3')!=-1}">checked</c:if>
	                                	>违反食品药品管理相关规定</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt re1" type="checkbox" value="4" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, '4')!=-1}">checked</c:if>
	                                	>违反质量技术监督相关规定</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt re1" type="checkbox" value="5" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, '5')!=-1}">checked</c:if>
	                                	>违反其他部门相关规定</p>
	                                </td>
	                            </tr>
	                           <tr>
	                                <td><input class="crt" type="checkbox" value="E" name="checkResultTmp"
	                                	<c:if test="${fn:indexOf(specialRecResult.checkResult, 'E')!=-1}">checked</c:if>
	                                ><strong>发现问题经责令已改正</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="F" name="checkResultTmp"
	                                	<c:if test="${fn:indexOf(specialRecResult.checkResult, 'F')!=-1}">checked</c:if>
	                                ><strong>未发现开展本次抽查涉及的经营活动</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="7" name="checkResultTmp"
	                                	<c:if test="${fn:indexOf(specialRecResult.checkResult, '7')!=-1}">checked</c:if>
	                                ><strong>已关闭停业或正在组织清算</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="8" name="checkResultTmp"
	                                	<c:if test="${fn:indexOf(specialRecResult.checkResult, '8')!=-1}">checked</c:if>
	                                ><strong>不配合检查情节严重</strong></td>
	                            </tr>
	                            <tr>
	                            	<td>
	                                	<input class="crt" type="checkbox" value="9" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, '9')!=-1}">checked</c:if>
	                                	><strong>注销</strong>
	                                	<input class="crt" type="checkbox" value="10" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, '10')!=-1}">checked</c:if>
	                                	><strong>被吊销</strong>
	                                	<input class="crt" type="checkbox" value="11" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, '11')!=-1}">checked</c:if>
	                                	><strong>被撤销</strong>
	                                	<input class="crt" type="checkbox" value="12" name="checkResultTmp"
	                                		<c:if test="${fn:indexOf(specialRecResult.checkResult, '12')!=-1}">checked</c:if>
	                                	><strong>迁出</strong>
	                                </td>
	                            </tr>
	                           <tr>
	                                <td class="bg-gray center"><span class="light">*</span>后续处置措施</td>
	                                <c:set value="${fn:split(specialRecResult.disposeMss, ',') }" var="str2" />
	                                <td colspan="2">
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="未发现问题或相关问题已规范、已改正，无需后续处置；"
	                                		<c:if test="${fn:indexOf(specialRecResult.disposeMss, '未发现问题或相关问题已规范、已改正，无需后续处置；')!=-1}">checked</c:if>
	                                	>未发现问题或相关问题已规范、已改正，无需后续处置；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="停止检查，反馈至日常监管部门依法依规处理；"
	                                		<c:if test="${fn:indexOf(specialRecResult.disposeMss, '停止检查，反馈至日常监管部门依法依规处理；')!=-1}">checked</c:if>
	                                	>停止检查，反馈至日常监管部门依法依规处理；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；"
	                                		<c:if test="${fn:indexOf(specialRecResult.disposeMss, '违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；')!=-1}">checked</c:if>
	                                	>违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="发现案件线索，初步固定相关证据后移送办案机构依法依规处理；"
	                                		<c:if test="${fn:indexOf(specialRecResult.disposeMss, '发现案件线索，初步固定相关证据后移送办案机构依法依规处理；')!=-1}">checked</c:if>
	                                	>发现案件线索，初步固定相关证据后移送办案机构依法依规处理；<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="违反其他部门相关规定，抄告相关部门。"
	                                		<c:if test="${fn:indexOf(specialRecResult.disposeMss, '违反其他部门相关规定，抄告相关部门。')!=-1}">checked</c:if>
	                                	>违反其他部门相关规定，抄告相关部门。<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="other"
	                                		<c:forEach items="${str2 }" var="it" varStatus="stat">
	                                			<c:if test="${stat.last}">
	                                				<c:if test="${it!='违反其他部门相关规定，抄告相关部门。'&&it!='发现案件线索，初步固定相关证据后移送办案机构依法依规处理；'
	                                				&&it!='违反本部门相关规定，责令改正；后续跟踪由日常监管部门负责；'&&it!='停止检查，反馈至日常监管部门依法依规处理；'
	                                				&&it!='未发现问题或相关问题已规范、已改正，无需后续处置；' &&it!=''
	                                				}">
	                                					checked
	                                					<c:set value="${it }" var="itt" />
	                                				</c:if>
	                                			</c:if>
	                                		</c:forEach>
	                                	>其他：<input id="other" class="inhei" type="text" value="${itt }">
	                                 </td>
	                            </tr>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       <input type='hidden' id="disposeState" value="${specialRecResult.disposeState }">
	                       		<tr>
	                       			<td class="bg-gray right" width="15%"><span class="light">*</span>后续处置措施是否完结</td>
	                       			<td width="35%">
	                       				<input type="radio" value="1" name="disposeState" class="dis"
	                       					<c:if test="${fn:indexOf(specialRecResult.disposeState, 1)!=-1}">checked</c:if>
	                       				>未完结 
	                       				<input type="radio" value="2" name="disposeState" class="dis"
	                       					<c:if test="${fn:indexOf(specialRecResult.disposeState, 2)!=-1}">checked</c:if>
	                       				>已完结<span class="sp"><textarea rows="2" name="disposeFinishMss">${specialRecResult.disposeFinishMss }</textarea></span>
	                       			</td>
	                       			<td class="bg-gray right" width="15%"><span class="sp"><span class="light">*</span>完结日期</span></td>
	                       			<td width="35%"><span class="sp"><input type="text" style="height: 28px" id="disposeFinishDate" name="disposeFinishDate" class="ipt-txt laydate-icon inhei" onclick="laydate()" readonly="readonly" value="<fmt:formatDate value='${specialRecResult.disposeFinishDate }' pattern='yyyy-MM-dd'/>"/></span></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>检查执行部门</td>
	                       			<td>
	                       				<input class="ipt-txt inhei" id="checkDeptName" name="checkDeptName" type="text" value="${(empty specialRecResult.checkDeptName)?sysUser.departMent.deptName:specialRecResult.checkDeptName}" readonly="readonly">
	                       			</td>
	                       			<td class="bg-gray right"><span class="light">*</span>检查机关</td>
	                       			<td>
	                       				<input class="ipt-txt inhei" id="setDeptName" name="setDeptName" type="text" value="${(empty specialRecResult.setDeptName)?specialRecResult.regOrgName:specialRecResult.setDeptName}" readonly="readonly">
	                       			</td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>检查人员</td>
	                       			<td>
	                       				<input type="text" class="ipt-txt inhei" id="checkDeptPerson" name="checkDeptPerson" value="${specialRecResult.checkDeptPerson }">
	                       			</td>
	                       			<td class="bg-gray right"><span class="light">*</span>检查日期</td>
	                       			<td>
	                       				<input id="checkDate" style="height: 28px"  name="checkDate" type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value="<fmt:formatDate value='${specialRecResult.checkDate }' pattern='yyyy-MM-dd'/>"/>
	                       			</td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>录入人员</td>
	                       			<td>
	                       				<input type="text" class="ipt-txt inhei" id="enterUserName" name="enterUserName" value="${(empty specialRecResult.enterUserName)?sysUser.realName:specialRecResult.enterUserName}" readonly="readonly"/>
	                       			</td>
	                       			<td class="bg-gray right"><span class="light">*</span>录入日期</td>
	                       			<td>
	                       			  <c:if test="${empty specialRecResult.enterDate}">
	                       			     <input type="text" style="height: 28px"  id="enterDate" name="enterDate" value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" class="ipt-txt" readonly="readonly"/>
	                       			  </c:if>
	                       			  <c:if test="${!empty specialRecResult.enterDate}">
	                       			  	 <input type="text" style="height: 28px"  id="enterDate"  name="enterDate" class="ipt-txt laydate-icon" readonly="readonly" value="<fmt:formatDate value='${specialRecResult.enterDate}' pattern='yyyy-MM-dd'/>"/>
	                       			  </c:if>
	                       			</td>
	                       		</tr>
	                       		<c:if test="${flag == '2'}">
	                       			<tr>
	                       			    <td class="bg-gray right"><span class="light">*</span>修改内容</td>
	                       			    <td colspan="3">
	                       			        <input type="text" class="ipt-txt inhei" id="modifyContent" name="modifyContent" value="${specialRecResult.modifyContent}"/>
	                       			    </td>
	                       			</tr>
		                       		<tr>
		                       			<td class="bg-gray right"><span class="light">*</span>修改人员</td>
		                       			<td>
		                       				<input type="text" class="ipt-txt inhei" id="modifyName" name="modifyName" value="${(empty specialRecResult.modifyName)?sysUser.realName:specialRecResult.modifyName}" readonly="readonly"/>
		                       			</td>
		                       			<td class="bg-gray right"><span class="light">*</span>修改日期</td>
		                       			<td>
		                       			  <c:if test="${empty specialRecResult.modifyDate}">
		                       			     <input type="text" style="height: 28px"  id="modifyDate" name="modifyDate" value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" class="ipt-txt" readonly="readonly"/>
		                       			  </c:if>
		                       			  <c:if test="${!empty specialRecResult.modifyDate}">
		                       			  	 <input type="text" style="height: 28px"  id="modifyDate"  name="modifyDate" class="ipt-txt laydate-icon"  readonly="readonly" value="<fmt:formatDate value='${specialRecResult.modifyDate}' pattern='yyyy-MM-dd'/>"/>
		                       			  </c:if>
		                       			</td>
		                       		</tr>
	                       		</c:if>
	                       </table>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <p class="center mb30 mt20">
      <c:if test="${flag == '1'}">
        <input type="button" class="btn mr20 save" dataType='2' value="暂存">
        <input type="button" class="btn mr20 save" dataType='1' id="save" value="提交">
      </c:if>
      <c:if test="${flag =='2'}">
      	<input type="button" class="btn mr20 save" dataType='3' value="提交">
      </c:if>
      <c:if test="${flag =='4'}">
      	<input type="button" class="btn mr20 save" dataType='4' value="提交">
      </c:if>
	    <input type="button" class="btn" id="close" value="关闭">
    </p>
</div>
<script>
window._CONFIG = {
   chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
   flag:'${flag}'
}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/specialrec/specialrec_input_edit.js"></script>
</body>
</html>