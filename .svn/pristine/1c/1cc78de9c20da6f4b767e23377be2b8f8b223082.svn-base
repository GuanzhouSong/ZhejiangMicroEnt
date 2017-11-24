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
    <div class="mt10">
        <div class="tabbale" data-component="tab">
            <div class="tab-content">
              	<div class="tab-panel tab-panel-show" id="itemPanelDivId">
              	<form id="taskForm" method="post">
              	<input type="hidden" name="checkDeptCode" value="${sysUserDto.departMent.deptDID }">
              	<input type="hidden" name="checkOrgCode" value="${sysUserDto.departMent.deptDID }">
              	<input type="hidden" name="disposeMss" id="disposeMss">
              	<input type="hidden" name="checkType" id="checkType">
              	<input type="hidden" name="checkResult" id="checkResult">
              	<input type="hidden" name="checkObjType" id="checkObjType" value="${checkObjType}">
              	<input type="hidden" name="state" id="state">
              	<input type="hidden" name="priPID" value="${midBaseInfoDto.priPID }">
              	
                    <div class="mt10">
                        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                            <tbody>
                            	<tr>
	                                <td class="bg-gray right" width="15%"><span class='light'>*</span>检查对象类型</td>
	                                <td width="85%" colspan="3">
	                                	<input 
	                                		<c:if test="${checkObjType==1 }">checked</c:if>
	                                	type="radio" disabled="disabled">企业
	                                	<input
	                                		<c:if test="${checkObjType==2 }">checked</c:if>
	                                	type="radio" disabled="disabled">无证无照户
	                                	<input
	                                		<c:if test="${checkObjType==3 }">checked</c:if>
	                                	type="radio" disabled="disabled">非企业单位
	                                </td>
	                            </tr>
	                            <tr>
	                                <td width="15%" class="bg-gray right">被检查对象</td>
	                                <td width="35%"><input type="text" name="checkObj" readonly="readonly" value="${entName }" size="49"></td>
	                                <td width="15%" class="bg-gray right">统一信用代码/注册号</td>
	                                <td width="35%">
		                                <input type="text" name="cidRegNO" size="35" maxlength="100"
		                                <c:if test="${flag=='2' }"> value="${!empty midBaseInfoDto.uniCode?midBaseInfoDto.uniCode:midBaseInfoDto.regNO }" readonly="readonly"</c:if>
		                                >
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right" rowspan="2"><span class='light'>*</span>住所地址</td>
	                                <td rowspan="2">
	                                	<textarea name="dom" id="dom"
	                                		<c:if test="${flag=='2' }"> readonly="readonly"</c:if>
	                                	 rows="3" cols="50">${midBaseInfoDto.dom }</textarea>
	                                </td>
	                                <td class="bg-gray right"><span class='light'>*</span>负责人</td>
	                                <td>
	                                <input id="lerep" name="lerep" 
		                                <c:if test="${flag=='2' }"> value="${midBaseInfoDto.leRep }" readonly="readonly"</c:if> 
		                                	type="text" size="15" placeholder="姓名"> 
		                                <input id="tel" name="tel" 
		                                	<c:if test="${flag=='2' }"> value="${midBaseInfoDto.tel }" readonly="readonly"</c:if> 
		                                type="text" size="15" placeholder="手机号">
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right"><span class='light'>*</span>联系人</td>
	                                <td><input id="liaName" name="liaName" <c:if test="${flag=='2' }"> value="${pubEppassword.lianame }" readonly="readonly"</c:if> type="text" size="15" placeholder="姓名"> <input id="liaTel" name="liaTel" <c:if test="${flag=='2' }"> value="${pubEppassword.tel }" readonly="readonly"</c:if> type="text" size="15" placeholder="手机号"></td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right" width="15%"><span class='light'></span>任务来源</td>
	                                <td width="85%" colspan="3">
	                                	<input name="taskSource" type="radio" value="1">交办转办
	                                	<input name="taskSource" type="radio" value="3">日常巡查
	                                	<input name="taskSource" type="radio" value="4">数据监测
	                                </td>
	                            </tr>
	                         </tbody>
	                       </table>
	                       <table id="table2" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                            	<td class="bg-gray center" width="5%">操作</td>
	                            	<td class="bg-gray center" width="5%">序号</td>
	                                <td class="bg-gray center" width="23%">
	                                	<span class='light'>*</span>检查内容 <a class="addInfo">添加信息栏</a>
	                                </td>
	                                <td class="bg-gray center" width="30%"><span class="light">*</span>发现问题情况 
	                                <td class="bg-gray center" width="30%"><span class="light">*</span>处置情况 
	                            </tr>
	                            <tr>
	                            	<td></td>
	                                <td class='center'>1</td>
	                                <td><textarea id="checkName1" name="checkName1"></textarea></td>
	                                <td><textarea id="problem1" name="problem1"></textarea></td>
	                                <td><textarea id="dispose1" name="dispose1"></textarea></td>
	                            </tr>
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
	                       				</td>
	                       			<td class="bg-gray right" width="15%"><span class="sp"><span class="light">*</span>完结日期</span></td>
	                       			<td width="35%"><span class="sp"><input type="text" id="disposeFinishDate" name="disposeFinishDate" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value=""/></span></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">检查执行部门</td>
	                       			<td><input type="text" name="checkDeptName" value="${sysUserDto.departMent.deptName }" readonly="readonly"></td>
	                       			<td class="bg-gray right">检查机关</td>
	                       			<td><input type="text" name="checkOrgName" value="${sysUserDto.departMent.deptName }" readonly="readonly"></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>检查人员</td>
	                       			<td><input id="checkDeptPerson" name="checkDeptPerson" type="text">
	                       			</td>
	                       			<td class="bg-gray right"><span class="light">*</span>检查日期</td>
	                       			<td><input id="checkDate" type="text" name="checkDate" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value=""/></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right">录入人员</td>
	                       			<td><input name="enterUserName" value="${sysUserDto.realName }" type="text" readonly="readonly">
	                       			</td>
	                       			<td class="bg-gray right">录入日期</td>
	                       			<td><input name="enterDate" type="text" value="<fmt:formatDate value='${now }' pattern='yyyy-MM-dd'/>" readonly="readonly"/></td>
	                       		</tr>
	                       </table>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <p class="center mb30 mt20">
    	<input type="button" class="btn mr20" id="tempsave" value="暂存">
	    <input type="button" class="btn mr20" id="save" value="提交">
	    <input type="button" class="btn" id="close" value="关闭">
    </p>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/dailyresult/dailyresult_insert.js"></script>
</body>
</html>