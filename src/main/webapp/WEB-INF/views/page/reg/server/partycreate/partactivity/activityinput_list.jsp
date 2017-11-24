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
    <title>党建活动录入</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<form id="taskForm">
    <div class="form-box">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">活动名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="activityName" placeholder="可输入关键词查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">发布部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="publishDeptUID" id="specialCode" />
                            <input type="text" readonly="readonly" class="ipt-txt" name="publishDeptName" id="specialName" />
                            <span class="add-icon" id="choseSpecial"><i></i></span>
                        </div>                        
                    </div>
                </div>
	             <div class="col-4">
	                <label class="item-name col-5">发布日期：</label>
	                <div class="col-7">
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();" name="startPublishDate" id="startPublishDate" value="" readonly="readonly"/>
	                    </div>
	                    <span class="item-line col-05">-</span>
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();" name="endPublishDate" id="endPublishDate" value="" readonly="readonly"/>
	                    </div>
	                </div>
	            </div> 
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">活动类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="activityType">
                                <option value="">全部</option>
                                <option value="1">重点常规活动</option>
                                <option value="2">党员日常活动</option>
                            </select>
                        </div>
                    </div>
                </div>
	             <div class="col-4">
	                <label class="item-name col-5">要求活动结束日期：</label>
	                <div class="col-7">
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();" name="startRequireEndDate" id="startRequireEndDate" value="" readonly="readonly"/>
	                    </div>
	                    <span class="item-line col-05">-</span>
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();" name="endRequireEndDate" id="endRequireEndDate" value="" readonly="readonly"/>
	                    </div>
	                </div>
	            </div> 
                <div class="col-4">
                    <label class="item-name col-5">录入员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="inputName">
                        </div>
                    </div>
                </div>                             
            </div>
            <div class="center mt10">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="reset" id="reset" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </div>
</form>

<div class="clearfix mb5 mt5">
    <p class="fl"><button type="button" id="add" class="btn btn-sm">新增党建活动</button></p>
</div>
<!-- <div class="light-info mb5"> -->
<!--     <span class="light">提示：查询范围为当前时点本局登记的在册企业。申请信息在完成审核后可打印“经营异常名录审批表”；审核结果为“予以移出、予以更正”时可打印“移出经营异常名录决定书”；予以移出的异常信息自动通过公示系统予以公示；予以更正的异常信息自动从公示系统撤回不予公示。</span> -->
<!-- </div> -->

<table id="user_table" border="0" cellspacing="0" cellpadding="0" class="table-row"
       style="width: 100%;white-space: nowrap;">
    <thead>
    <tr>
        <th style="padding:0 20px;">序号</th>
        <th>操作</th>
        <th>活动类别</th>
        <th>活动名称</th>
        <th>要求活动结束日期</th>
        <th>发布部门</th>
        <th>发布日期</th>
        <th>录入员</th>
        <th>录入日期</th>
    </tr>
    </thead>
</table>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/partycreate/partactivity/activityinput_list.js"/>"></script>
</body>
</html>
