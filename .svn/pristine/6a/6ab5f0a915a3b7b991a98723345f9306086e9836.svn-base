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
    <title>案源信息管理</title>
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
                    <label class="item-name col-5"><span class="long-label">企业名称：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入名称关键字">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">统一社会代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <input type="text" class="ipt-txt" name="regOrUnicode" value="" placeholder="请输入统一代码或注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">案源名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="caseName" value="" placeholder="请输入名称关键字"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">举报人姓名：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="reporterName" value="" placeholder="请输入举报人姓名">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">举报时间：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                         		<div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt pointer laydate-icon" readonly="readonly" name="reportTimeStart"
	                                  onclick="laydate()" value=""/>
		                        </div>
		                        <span class="item-line col-05">-</span>
		                        <div class="ipt-box col-575">
		                            <input type="text" class="ipt-txt pointer laydate-icon" readonly="readonly" name="reportTimeEnd"
		                              onclick="laydate()" value=""/>
		                        </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">举报内容：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                           <input type="text" class="ipt-txt" name="reportContent" value="" placeholder="请输入关键字"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">举报人证件号码：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="reporterCard" value="" placeholder="请输入举报人证件号码">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">受理日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                         		<div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt pointer laydate-icon" readonly="readonly" name="setTimeStart"
	                                  onclick="laydate()" onclick="laydate()" value=""/>
		                        </div>
		                        <span class="item-line col-05">-</span>
		                        <div class="ipt-box col-575">
		                            <input type="text" class="ipt-txt pointer laydate-icon" readonly="readonly" name="setTimeEnd" 
		                              onclick="laydate()" onclick="laydate()" value=""/>
		                        </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">受理人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="setName" value="" placeholder="请输入受理人"/>
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
    <div class="clearfix mb5 mt5">
        <p class="fl"><input type="button" id="addBtn" class="btn btn-sm mr5" value="列入案源"></p>
    </div>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="specialrec_table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
	                        <th>操作</th>
	                        <th>案源名称</th>
	                        <th>统一代码/注册号</th>
	                        <th>企业名称</th>
	                        <th>举报人姓名</th>
	                        <th>举报内容</th>
	                        <th>举报人联系电话</th>
	                        <th>举报人证件号码</th>
	                        <th>举报时间</th>
	                        <th>受理人</th>
	                        <th>受理日期</th>
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
   chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
}
</script>
<script src="/js/reg/server/casesource/casesource_list.js"></script>
</body>
</html>