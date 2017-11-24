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
    <title>邮件任务详情</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
    <h3 class="h22-title center"></h3>
    <div class="pd10 bg-gray">
    <h5 class="h6-title mb10 mt10">邮件任务信息</h5>
        <div class="clearfix">
            <div class="clear">
	            <div class="form-item ">
	                <div class="col-4">
	                    <div class="item-name col-4"><span class='light'>*</span>邮件任务名称：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" readonly="readonly" class="ipt-txt" value="${emailTask.taskName}"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-4">任务开始日期：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" name="startTime" onclick="" readonly="readonly" class="ipt-txt" value="<fmt:formatDate value='${emailTask.startTime }' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-3"></div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                        </div>
	                    </div>
	                </div>
                </div>
            </div>
            
            <div class="clear">
	            <div class="form-item ">
	                <div class="col-4">
	                    <div class="item-name col-4"><span class='light'>*</span>发送邮件内容：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <textarea name="taskContent" rows="5" cols="100" readonly="readonly">${emailTask.taskContent }</textarea>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-4">发送邮件说明：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                        	<textarea name="emailInstruction" rows="5" cols="100" readonly="readonly">${emailTask.emailInstruction }</textarea>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-3"></div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                        </div>
	                    </div>
	                </div>
                </div>
            </div>
            
            <div class="clear">
	            <div class="form-item ">
	                <div class="col-4">
	                    <div class="item-name col-4">设置人：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" readonly="readonly" name="setName" class="ipt-txt"  value="${emailTask.setName}" />
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-4">设置日期：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" readonly="readonly" name="setTime" class="ipt-txt" value="<fmt:formatDate value='${emailTask.setTime}' pattern='yyyy-MM-dd'/>"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-3">设置部门：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" readonly="readonly" name="deptName" class="ipt-txt"  value="${emailTask.deptName}" />
	                        </div>
	                    </div>
	                </div>
                </div>
            </div>
        </div>
    </div>
    <div class="pd10 bg-gray" style="margin-top: 10px;">
    	<h5 class="h6-title mb10 mt10">邮件任务名单</h5>
                <div class="form-list pdr10">
                <form id="taskForm" class="form-box mb5">
                	<input type="hidden" name="uid" value="${emailTask.uid}">
                    <div class="form-item clearfix">
                        <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cidRegNO" value="" placeholder="可输入尾号后4位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">发送邮箱：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="email" value=""/>
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
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
        <thead>
         <tr>
             <th>序号</th>
             <th>统一代码/注册号</th>
             <th>企业名称</th>
             <th>成立日期</th>
             <th>主体类别</th>
             <th>发送邮箱</th>
             <th>登记机关</th>
             <th>管辖单位</th>
         </tr>
        </thead>
    </table>
</div>
        

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/emailsend/emailtask_detail.js"></script>
</body>
</html>