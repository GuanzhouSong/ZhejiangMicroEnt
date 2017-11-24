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
    <title>专项库类别维护</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix moresearch_oth">
                <div class="col-4">
                    <label class="item-name col-5">专项库类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="specialName" value="" placeholder="可输入关键字查询">
                        </div>
                        </div>
                    </div>
                </div>
				<div class="col-4">
                    <label class="item-name col-5">主体状态：</label>
                    <div class="col-7">
                    <div class="ipt-box col-11">
                        <select name="isVlid">
                            <option value=""></option>
                            <option value="1" selected="selected">有效</option>
                            <option value="0">无效</option>
                         </select>
                         </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"></label>
                    <div class="col-7">
                        <div class="center mt10">
			                <input type="button" id="search" value="查询" class="btn mr20">
			            </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
 
<div class="iframe-wrap">
    <button type="button" id="addBtn" class="btn btn-primary mt5">添加专项库类别</button>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>专项库类别</th>
            <th>对应的检查事项</th>
            <th>状态</th>
            <th>说明</th>
            <th>适用部门</th>
            <th>创建日期</th>
            <th>设置人</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/specialtype/specialtype_list.js"></script>
</body>
</html>
