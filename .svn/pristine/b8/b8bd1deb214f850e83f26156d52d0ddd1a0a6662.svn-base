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
    <title>敏感词库维护</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab"> 
    <form id="taskForm" class="form-box">
    	<div class="form-list">
             <div class="form-item clearfix">
                 <div class="col-4">
                     <label class="item-name col-5">敏感词：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                         	<input type="text" class="ipt-txt" name="banLetter" value=""/>
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                    <label class="item-name col-5">设置日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon " style="cursor: pointer;"
                                   onclick="laydate()" readonly="readonly" name="setTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="setTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
                 
                 <div class="col-4">
                    <label class="item-name col-5">设置人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="setName" value=""/>
                        </div>
                    </div>
                </div>
              </div>
              <div class="form-item clearfix">
                <div class="col-4">
                     <label class="item-name col-5">状态：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                         	<select name="isValid">
                                <option value="">全部</option>
                                <option value="1" selected="selected">有效</option>
                                <option value="0">无效</option>
                            </select>
                         </div>
                     </div>
                 </div>
              </div>
        </div>
		<div class="form-group clearfix mt10">
		    <div class="center">
		   		<input type="button"  id="search" value="查询" class="btn mr20">
		   	 	<input type="button"  id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
		   	</div>
		</div>
    </form>
</div>
<div class="iframe-wrap">
    <div class="clearfix mb5 mt5">
    	<p class="fl"><input type="button" class="btn btn-sm mr5 js-add" value="新增敏感词" /></p>
	</div>
     <div class="table-out">
    <table id="sysforbid-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>禁用文字</th>
            <th>禁用说明</th>
            <th>是否有效</th>
            <th>设置人姓名</th>
            <th>设置时间</th>
        </tr>
        </thead>
    </table>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/sysforbidword/list_main.js"></script>
</body>
</html>
