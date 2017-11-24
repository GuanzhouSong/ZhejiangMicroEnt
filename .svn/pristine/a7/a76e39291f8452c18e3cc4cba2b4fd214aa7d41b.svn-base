<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>党组织选择</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="page-content clear">
    <div class="col-3 col-xs-3" style="border-right: 1px solid #CCC; min-height: 400px">
        <div>
            <ul id="ztree" class="ztree">
            </ul>
        </div>
    </div>
    <div class="col-8 col-xs-9 pd10" style="display: none;" >
        <div class="pd10">
			<input class="tree-box-searcher" id="tree-box-searchertree_Njjg" placeholder="输入党组织关键字进行检索">
			<input type="button" class="tree-box-searcher-btn btn" id="tree-box-searcher" value="检索">
	    </div>
        <div class="form-header">
           <h2>
               <span class="bmgl h6-title">点击左侧的树可进行筛选</span>
           </h2>
        </div>
        <p class="mb10">
<!--             <button class="btn btn-sm" id="addBtn">新增</button> -->
<!--             <button class="btn btn-sm" id="editBtn">修改</button> -->
<!--             <button class="btn btn-sm" id="delBtn">删除</button> -->
        </p>

       <div id="showArea">
	       <table id="user-table" class="table-row center" style="width: 100%;white-space: nowrap;">
	        <thead>
	        <tr>
	            <th>选择</th>
	            <th>党组织名称</th>
	            <th>管辖单位名称</th>
	        </tr>
	        </thead>
	       </table>
        </div>
    </div>
</div>

<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/partycreate/party_org_choose.js"></script>
</body>
</html>
