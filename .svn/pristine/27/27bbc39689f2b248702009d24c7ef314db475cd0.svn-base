<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>群发邮件企业列表页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
    	<input type='hidden' value='K,B,A,DA,X' name='regState'>
        <div class="form-list pdr8">
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
            </div>
       </div>
        <div class="center mt10">
            <input type="button" id="js-search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
        </div>
    </form>
</div>


<div>
	<input type="button" id="emailSend" value="发送邮件" class="btn mr20">
	<input type="button" id="return" value="返回" class="btn mr20">
</div>

<div style="display: none">
	<form action="/reg/server/emailtaskinfo/emailshow" method="post" name="form1">
		<input type="hidden" name="params" id="params">
	</form>
	<form action="/syn/panoramasearch/smsQueryPageAll" method="post" name="form2">
		<input type="hidden" name="map" id="map">
	</form>
</div>
<div class="tab-content mb20 mt10">
    <div class="tab-panel tab-panel-show">
        <div class="">
            <div class="table-out">
                <table id="user-table" border="0" cellspacing="0" cellpadding="0"
                       class="table-row display nowrap">
                    <thead>
	                    <tr>
	                        <th>序号</th>
	                        <th>全选<input type="checkbox" id="checkAll"></th>
	                        <th>统一代码/注册号</th>
	                        <th>企业名称</th>
	                        <th>成立日期</th>
	                        <th>主体类别</th>
	                        <th>邮箱</th>
	                        <th>登记机关</th>
	                        <th>管辖单位</th>
	                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/emailsend/addent_list.js"></script>
</body>
</html>
