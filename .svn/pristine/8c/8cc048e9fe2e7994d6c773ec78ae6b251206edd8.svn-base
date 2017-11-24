<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>短信任务详情</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
    <h3 class="h22-title center"></h3>
    <div class="pd10 bg-gray">
        <div class="clearfix">
            <div class="col-8 border0">
                <h5 class="h6-title mb10">短信任务信息</h5>
                <div class="form-list">
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <div class="item-name col-4">短信任务编号：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" readonly="readonly" value="${sendSmsTask.taskid}" >
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2">短信任务名称：</div>
                            <div class="col-10">
                                <div class="ipt-box">
                                    <input type="text" readonly="readonly" class="ipt-txt" value="${sendSmsTask.taskName}" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <div class="item-name col-4">短信任务模板：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                <c:if test="${sendSmsTask.smsType =='1'}">
                                    <input type="text" readonly="readonly" class="ipt-txt" value="年报提醒（适用企业、农专社）" />
                                </c:if>
                                <c:if test="${sendSmsTask.smsType =='2'}">
                                    <input type="text" readonly="readonly" class="ipt-txt" value="年报提醒（适用个体户）" />
                                </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2"></div>
                            <div class="col-10">
                                <div class="ipt-box">
                                    <textarea rows="3" cols="50" readonly="readonly">${sendSmsTask.smsMsg}</textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <div class="item-name col-4">短信发送对象：</div>
                            <div class="col-6">
                                <div class="ipt-box">
	                                <c:choose>
		                                <c:when test="${sendSmsTask.smsLerep=='1'}">
		                                    <input type="checkbox" disabled="disabled" checked> 负责人
		                                </c:when>
		                                <c:otherwise>
		                                    <input disabled="disabled" type="checkbox"> 负责人
		                                </c:otherwise>
		                            </c:choose>
	                                    &nbsp;&nbsp;&nbsp;&nbsp;
	                                <c:choose>
		                                <c:when test="${sendSmsTask.smsLia=='1'}">
		                                    <input disabled="disabled" type="checkbox" checked> 联络员
		                                </c:when>
		                                <c:otherwise>
		                                    <input disabled="disabled" type="checkbox"> 联络员
		                                </c:otherwise>
		                            </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="item-name col-3">任务开始日期：</div>
                            <div class="col-9">
                                <div class="ipt-box">
                                    <input type="text" readonly="readonly" class="ipt-txt"  value="<fmt:formatDate value='${sendSmsTask.smsDate}' pattern="yyyy年MM月dd日"/>" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2">任务原始名单：</div>
                            <div class="col-10">
                                <div class="ipt-box">
                                    <input type="text" readonly="readonly" class="ipt-txt" value="${sendSmsTask.smsIntroduction}" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2">手机号码去重：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                	<c:choose>
		                                <c:when test="${sendSmsTask.repeatLerep=='1'}">
		                                    <input disabled="disabled" type="checkbox" checked> 负责人手机号去重
		                                </c:when>
		                                <c:otherwise>
		                                    <input disabled="disabled" type="checkbox"> 负责人手机号去重
		                                </c:otherwise>
		                            </c:choose>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <c:choose>
		                                <c:when test="${sendSmsTask.repeatLia=='1'}">
		                                    <input disabled="disabled" type="checkbox" checked> 联络员手机号去重
		                                </c:when>
		                                <c:otherwise>
		                                    <input disabled="disabled" type="checkbox"> 联络员手机号去重
		                                </c:otherwise>
		                            </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2">任务去重名单：</div>
                            <div class="col-10">
                                <div class="ipt-box">
                                    <input type="text" readonly="readonly" class="ipt-txt" value="${sendSmsTask.rsmsIntroduction}" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4">
            	<div class='pdl10'>
                	<h5 class="h6-title mb10 pdl10">发送任务说明（<span class="light">200</span>字内）</h5>
                	<div class="ipt-box pd0 clearfix h300">
                		<textarea cols="" rows="19" readonly="readonly" class='border0'>${sendSmsTask.taskInstruction}</textarea>
                	</div>
                </div>
            </div>
            <div class="clear">
            	<div class="form-item ">
                        <div class="col-4">
                            <div class="item-name col-4">设置人：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" readonly="readonly" class="ipt-txt"  value="${sendSmsTask.setName}" />
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="item-name col-4">设置日期：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" readonly="readonly" class="ipt-txt"  value="<fmt:formatDate value='${sendSmsTask.setTime}' pattern="yyyy年MM月dd日"/>" />
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="item-name col-3">设置部门：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" readonly="readonly" class="ipt-txt"  value="${sendSmsTask.deptName}" />
                                </div>
                            </div>
                        </div>
                 </div>
            </div>
        </div>
    </div>
    <div class="pd10 bg-gray" style="margin-top: 10px;">
    	<h5 class="h6-title mb10 mt10">短信任务名单</h5>
                <div class="form-list pdr10">
                <form id="taskForm" class="form-box mb5">
                	<input type="hidden" name="UID" value="${sendSmsTask.UID}">
                	<div class="form-item clearfix">
                        <div class="col-4">
                            <div class="item-name col-4">发送对象类型：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                	<c:choose>
		                                <c:when test="${sendSmsTask.smsLerep=='1'}">
		                                    <input type="checkbox" name="smsLerep" checked> 负责人
		                                </c:when>
		                                <c:otherwise>
		                                    <input type="checkbox" name="smsLerep"> 负责人
		                                </c:otherwise>
		                            </c:choose>
	                                    &nbsp;&nbsp;&nbsp;&nbsp;
	                                <c:choose>
		                                <c:when test="${sendSmsTask.smsLia=='1'}">
		                                    <input type="checkbox" name="smsLia" checked> 联络员
		                                </c:when>
		                                <c:otherwise>
		                                    <input type="checkbox" name="smsLia"> 联络员
		                                </c:otherwise>
		                            </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="item-name col-4">发送企业名称：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" name="entName" class="ipt-txt"  value="" placeholder="可输入关键字查询"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="item-name col-4">统一代码/注册号：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" name="cidRegNO" class="ipt-txt" value="" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-4">
                            <div class="item-name col-4">短信发送状态：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                	<select name="smsStatus">
                                		<option value="">全部</option>
                                		<option value="1">发送成功</option>
                                		<option value="0">发送失败</option>
                                		<option value="2">未发送</option>
                                	</select>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="item-name col-4">发送对象号码：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" name="phone" class="ipt-txt"  value="" />
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="item-name col-4">发送对象姓名：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" name="name" class="ipt-txt"  value="" />
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                </div>
    </div>
    <p class="center mt10 mb10">
        <input type="button" id="js-search" value="查询" class="btn mr20">
        <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
    </p>
<div class="tip-info left">
    查询结果：发送成功企业共<label id="sendEntSuccess" class="light-blue">0</label>户，
   发送成功手机号共<label id="sendTelSuccess" class="light-blue">0</label>条，
    其中发送成功负责人手机号<label id="sendLerepTelSuccess" class="light-blue">0</label>条，
   发送成功联络员手机号<label id="sendLiaTelSuccess" class="light-blue">0</label>条，
</div>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
        <thead>
         <tr>
             <th>序号</th>
             <th>统一代码/注册号</th>
             <th>企业名称</th>
             <th>成立日期</th>
             <th>主体类别</th>
             <th>发送对象类型</th>
             <th>发送对象姓名</th>
             <th>发送对象号码</th>
             <th>短信发送时间</th>
             <th>短信发送状态</th>
             <th>企业登记机关</th>
             <th>管辖单位</th>
         </tr>
        </thead>
    </table>
</div>
        

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/smsgroupsend/smstask_detail.js"></script>
</body>
</html>