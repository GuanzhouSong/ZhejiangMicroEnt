<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>食品仓储申请退回</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
     <div class="form-list pdr8">
    	<input type="hidden" name="submitState" value="2"/>
    	     <div class="form-item clearfix">
                <div class="col-5">
                    <label class="item-name col-5">统一代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regNo" value="" placeholder="请输入注册号">
                        </div>
                    </div>
                </div>
                <div class="col-5">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                        </div>
                    </div>
                </div>
            </div>
       </div>
       <div class="form-group clearfix mt10">
         <div class="center">
		    <input id="search" type="button" class="btn mr20" value="查询">
		    <input id="cancel" type="button" class="btn mr20" onclick="$('#taskForm')[0].reset();" value="清空">
	     </div>
	  </div>
    </form>
</div>
<div>
    <div class="mb5 mt5">
        <button id="editbaseback" type="button" class="btn btn-primary">申报退回</button>
        <button id="returnback" type="button" class="btn btn-primary">返回</button>
        <span class="light">提示：此处仅查询当前年度已提交状态的企业</span>
    </div>
    <table id="foodstoragebaseback-table" border="0" cellspacing="0" cellpadding="0" class="table-row" style="width: 100%;white-space: nowrap;">
        <thead>
        <tr>
            <th>序号</th>
            <th></th>
            <th>统一代码/注册号</th>
            <th>企业名称</th>
            <th>提交日期</th>
            <th>填表人</th>
            <th>办公电话</th>
            <th>手机号码</th>
            <th>登记机关</th>
      		<th>管辖单位</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/foodstorageback/baseback_list_main.js"></script>
</body>
</html>
