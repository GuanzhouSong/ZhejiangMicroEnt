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
    <title>随机抽取执法人员</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<!--     <link rel="stylesheet" href="/css/vendor/bootstrap.min.css"> -->
</head>
<body class="pd10">
<h3 class="h3-title2">实施计划设置</h3>
<div class="fold-text fr light-yellow" id="fold-text">收起</div>
<div id="fold-box">
<h5 class="h5-title">检查任务设置</h5>
<form id="paramForm"><input type="hidden" value="${taskNO }" name="taskNO"/></form>
<input type="hidden" id="taskNO" value="${taskNO }"/>
 <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tbody>
            <tr>
                <td class="bg-gray right" width="14%">任务编号：</td>
                <td>
                ${pubSctask.taskCode}
                </td>
                <td colspan="2" class="left-border-none">
                    <span class="fr light-gray2">任务牵头组织机关简称+抽查+年度+序号，如：浙工商抽查[2017]1号</span>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">任务名称：</td>
                <td colspan="3">
                ${pubSctask.taskName}
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">任务组织部门：</td>
                <td width="36%">
                ${pubSctask.leaderDeptDesc}
                </td>
                <td class="bg-gray right" width="14%">抽查方式：</td>
                <td width="36%">
                 ${pubSctask.speckWay=='0'?'定向':'不定向'}
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">检查实施部门：</td>
                <td colspan="3">
                ${pubSctask.implDeptDesc}
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">检查主体范围：</td>
                <td>
                ${pubSctask.taskEntCatgDesc}
                </td>
                <td class="bg-gray right">任务期限：</td>
                <td>
                    <fmt:formatDate value="${pubSctask.startDate}" pattern="yyyy-MM-dd" />&nbsp;至&nbsp;<fmt:formatDate value="${pubSctask.endDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">任务说明（2000字内）：</td>
                <td colspan="3">
                    <div class="ipt-box">
                        <textarea id="checkContent"  class="min-h100" readonly>${pubSctask.checkContent}</textarea>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
<h5 class="h5-title">检查内容设置</h5>
<table class="table-row perc-100 mb5" cellpadding="0" cellspacing="0" border="0">
    <thead>
    <tr>
        <th width="7%">序号</th>
        <th width="20%">检查部门</th>
        <th> 检查事项</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pubDeptSctaskDtoList}" var="pubDeptSctaskDtoV" varStatus="status">
	    <tr>
	        <td>${status.index+1}</td>
	        <td>${pubDeptSctaskDtoV.inspectDesc }</td>
	        <td class="left">
	            <div class="display-table">
	                <span class="table-cell vm" id="scNames">${pubDeptSctaskDtoV.inspectTypeDesc }</span>
	                <c:if test="${pubDeptSctaskDtoV.inspectDept == sessionDeptCode}">
	                	<input type="hidden" id="deptCode" value="${pubDeptSctaskDtoV.inspectDept}"/>
	                	<input type="hidden" id="deptTaskUid" value="${pubDeptSctaskDtoV.UID}"/>
	                	<input type="hidden" id="scNameCodes" value="${pubDeptSctaskDtoV.inspectType }"/>
	                	<c:if test="${pubDeptSctaskDtoV.inspectState == '1'}">
<!-- 	                	<span class="table-cell right vm"><input type="button" class="btn btn-xs" id="deptChooseButton" value="选择"></span> -->
	                	</c:if>
	                </c:if>
	            </div>
	        </td>
	    </tr>
    </c:forEach>
    </tbody>
</table>
<h5 class="h5-title">抽查检查名单</h5>
<table border="0" id="info-table" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 mb10 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人</th>
            <th>联系电话</th>
            <th>联络员</th>
            <th>联络员电话</th>
            <th>成立日期</th>
            <th>企业类型</th>
            <th>行业</th>
        </tr>
        </thead>
    </table>
</div>
<h5 class="h5-title">部门执法人员待选库配置</h5>
<div class="tabbale" data-component="tab">
    <div class="tab-header type-tab tbmr1 border-bottom gray-bg">
        <ul class="clearfix" id="ulID">
        	<c:forEach items="${pubDeptSctaskDtoList}" var="pubDeptSctaskDto" varStatus="status">
            <li <c:if test="${pubDeptSctaskDto.inspectDept == sessionDeptCode}">class="tab-selected" flag="Y"</c:if> <c:if test="${pubDeptSctaskDto.inspectDept != sessionDeptCode}">flag="N"</c:if> lichooseid="${pubDeptSctaskDto.UID}">
	            <span class="tab-item">
	            	<a href="javascript:void(0);" class="min90">
		            	<c:if test="${pubDeptSctaskDto.inspectState == '2'}"><i class="right-icon"></i></c:if>	
		            	<c:if test="${empty pubDeptSctaskDto.inspectState || pubDeptSctaskDto.inspectState == '1'}"><i class="new-icon"></i></c:if>
            			${pubDeptSctaskDto.inspectDesc }
            		</a>
	            </span>
            </li>
            </c:forEach>
        </ul>
    </div>
    <div class="tab-content">
        <div class="tab-panel tab-panel-show">
        <br/>
<%--         	<c:if test="${pubDeptSctaskDto.inspectDept == sessionDeptCode && pubDeptSctaskDto.inspectState == '1'}"> --%>
		<div class="form-box" id="sctypeDivid">
		    <div class="form-list">
		        <div class="form-item clearfix mb10">
	               	<div class="col-3">
	               		<div class="col-6 item-name">抽取方式：</div>
	                	<div class="col-6 ipt-box">
<!-- 	                		<label><input type="radio" name="scTypeWay" value="1-2"/>局所联动检查</label> -->
<!-- 	                		<label><input type="radio" name="scTypeWay" value="1"/>局本级科(室)检查</label> -->
<!-- 	                		<label><input type="radio" name="scTypeWay" value="2"/>局本所(站)检查</label> -->
<!-- 	                		<label><input type="radio" name="scTypeWay" value="2"/>所所交叉检查</label> -->
	                		<select id="scTypeWay">
	                			<option value="2">全局模式(混合随机)</option>
	                			<option value="2">全局模式(区域定向随机)</option>
	                			<option value="1">局所联动随机模式</option>
	                			<option value="3">所所联动随机模式</option>
	                			<option value="4">所所交叉随机模式</option>
	                			<option value="3">全所混合随机模式</option>
	                		</select>
	                	</div>
	               	</div>
	            </div>
	           </div>
	          </div>
            <div class="mt10" id="backDIV">
                <div class="clearfix mb5" id="waitrandom">
                    <h5 class="fl mr10 h5-title">待选库</h5>
                    <c:if test="${pubDeptSctaskDto.inspectState == '1'}">
                   	<p class="fl"><input type="button" class="btn btn-sm" id="addAgentId" value="添加本部门待选库"></p>
                   	</c:if>
                </div>
                <div id="waitrandom-table">
                    <table  border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 mb10 nowrap" id="backTableId">
                        <thead>
	                        <tr>
	                            <th width="5%">序号</th>
	                             <th width="8%">姓名</th>
	                            <th width="13%">单位</th>
	                            <th width="8%">单位层级</th>
	                            <th width="8%">部门机构</th>
	                            <th width="11%">岗位大类</th>
	                            <th width="10%">岗位管辖片区</th>
	                            <th>执法清单事项范围</th>
                            	<th width="5%">操作</th>
	                        </tr>
                        </thead>
                    </table>
                </div>
                <div class="center">
                	<c:if test="${pubDeptSctaskDto.inspectState == '1'}">
                	<div class="form-box" id="agent-form">
					    <div class="form-list">
					        <div class="form-item clearfix">
			                	<div class="col-3">
			                		<div class="col-6 item-name">抽取执法人员数量：</div>
				                	<div class="col-6 ipt-box">
				                		<input type="text" id="checkNumber" class="ipt-txt"/>
				                	</div>
			                	</div>
			                	<div class="col-3">
					                <div class="col-6 item-name">每组最少分配人数：</div>
					                <div class="col-6 ipt-box">
					                   <input type="text" class="ipt-txt" id="groupAgentNumber"/>
					                </div>
					            </div>
				            </div>
			            </div>
		            </div>
                    <input type="button" class="btn mt10" id="random" value="随机抽取检查执法人员">
                    <input type="button" class="btn mt10" id="searchAgentScinfo" style="display: none;" value="查看企业与人员随机配对结果">
                    </c:if>
                </div>
            </div>
<%--             </c:if> --%>
            <form id="backFormId">
    			<input type="hidden" class="taskNO" name="taskNO" id="depttaskNO" value="${pubDeptSctaskDto.UID}"/>
	    	</form>
	    	<div class="clearfix mb5">
			    <h5 class="fl mr10 h5-title">检查人员</h5>
			    <c:if test="${pubDeptSctaskDto.inspectDept == sessionDeptCode}">
			    <p class="fl" id="flPid">
			    <c:if test="${pubDeptSctaskDto.inspectState == '1'}">
			    <input type="button" class="btn btn-sm mr5" id="clean" value="清除"/>
			<!--     <input type="button" class="btn btn-sm" value="导出"/> -->
				</c:if>
			    </p>
			    </c:if>
			</div>
			<table border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 mb10 nowrap" id="agentTableId">
			    <thead>
			    <tr>
			        <th width="5%">序号</th>
			        <th width="8%">姓名</th>
                    <th width="13%">单位</th>
                    <th width="8%">单位层级</th>
                    <th width="8%">部门机构</th>
                    <th width="11%">岗位大类</th>
                    <th width="10%">岗位管辖片区</th>
                    <th>执法清单事项范围</th>
			    </tr>
			    </thead>
			</table>
        </div>
    </div>
</div>
<div class="center mb20">
<!--     <input type="button" value="打印" class="btn mr20"/> -->
<c:forEach items="${pubDeptSctaskDtoList}" var="pubDeptSctaskDto" varStatus="status">
	<c:if test="${pubDeptSctaskDto.inspectDept == sessionDeptCode && pubDeptSctaskDto.inspectState == '1'}">
    <input type="button" value="保存设置" class="btn mr20" id="save"/>
    </c:if>
    </c:forEach>
<input type="button" value="关闭" class="btn" id="close"/>
</div>
<!-- <script src="/js/lib/jquery/jquery-1.12.3.min.js"></script> -->
<!-- <script src="/js/component/tab.js"></script> -->
<!-- <script src="/js/lib/laydate/laydate.js"></script> -->
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/sctack/randomagent_main.js"></script>
</body>
</html>