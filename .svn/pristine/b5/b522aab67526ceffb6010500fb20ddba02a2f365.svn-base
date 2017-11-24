<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>检查对象随机抽取列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box pd14-mr"> 
         <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">任务名称：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                             <input type="text" class="ipt-txt" name="taskName" value="" placeholder="请输入抽查活动名称">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">任务编号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <input type="text" class="ipt-txt" name="taskCode" value="" placeholder=" 请输入活动任务编号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">任务组织部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="taskLeadDeptName" value="" placeholder="请输入任务组织部门"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">抽查方式：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="taskType">
                                <option value="">全部</option>
                                <option value="1">定向</option>
                                <option value="2">不定向</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">任务期限：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                         		<div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="taskStartTime"
	                                   id="startInfaustlDate" value=""/>
	
		                        </div>
		                        <span class="item-line col-05">-</span>
		                        <div class="ipt-box col-575">
		                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="taskEndTime"
		                                   id="endInfaustlDate" value=""/>
		
		                        </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">设置人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                           <input type="text" class="ipt-txt" name="setUserName" value="" placeholder="请输入设置人"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">抽查对象：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                          <input type="checkbox" name="taskObjectStr" value="1">企业
                          <input type="checkbox" name="taskObjectStr"   value="2">农专社
                          <input type="checkbox" name="taskObjectStr"  value="3">个体户
                          <input type="checkbox" name="taskObjectStr"   value="4">外资代表机构
                          <input type="hidden" name="taskObject"  id="taskObject"  value="1,2,3,4">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">任务执行状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="taskState">
                                <option value="">全部</option>
                                <option value="01">待抽取</option>
                                <option value="02">已抽取</option>
                            </select>
                        </div>
                    </div>
                </div>
                
            </div>
              
            <div class="center mt10">
            <input type="button" id="search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
       		</div>
        </div>
    </form>
    <div class="light-info mt5">
        <span class="light">提示：请先在本模块完成检查任务设置后，再进入“检查对象名单抽取”模块选择对应的检查任务进行检查名单抽取。检查对象范围对应已抽取确认的检查对象名单。
    </div> 
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="pubopanomalylist_table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
	                        <th>操作</th>
	                        <th>任务编号</th>
	                        <th>任务名称</th>
	                        <th>检查名单状态</th>
	                        <th>检查对象范围</th>
	                        <th>检查对象数量</th>
	                        <th>抽查方式</th>
	                        <th>任务开始日期</th>
	                        <th>任务结束日期</th>
	                        <th>任务组织部门</th> 
	                        <th>设置人</th> 
	                        <th>设置日期</th> 
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script>
    window._CONFIG = { 
       _sysUrl:'${sysUrl}'
    }
	</script>
    <script src="/js/syn/system/sccheck/scentback/scentbacktask_list.js"></script>
</body>
</html>