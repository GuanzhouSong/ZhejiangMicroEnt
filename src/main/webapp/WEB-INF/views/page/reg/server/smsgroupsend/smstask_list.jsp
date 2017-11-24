<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>短信群发</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body class="pd10">
<div class="form-box pd14-mr">
    <form id="searchForm">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">短信任务编号：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="taskid">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">短信任务名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="taskName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">设置部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt"  name="deptId" id="regOrg" value="" />
                            <input type="text" class="ipt-txt" readonly id="regOrgName" value="" />
	                            <span class="add-icon" id="choseDept">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">短信发送对象：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                         <input type="hidden" id="isLerep" name="smsLerep"/>
                         <input type="hidden" id="isLia" name="smsLia"/>
                         <label><input type="checkbox" id="smsLerep"/>负责人&nbsp;</label>
                         <label><input type="checkbox" id="smsLia" />联络员</label>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">任务开始日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clx" readonly="readonly" onclick="laydate();"
                                   name="setTimeStart">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clx" readonly="readonly" onclick="laydate();"
                                   name="setTimeEnd">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">设置人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="setName">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
				<div class="col-4">
                    <label class="item-name col-5">短信发送类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="smsType">
                                <option value="">请选择</option>
                                <option value="1">年报提醒（适用企业、农专社）</option>
                                <option value="2">年报提醒（适用个体户）</option>
                            </select>
                        </div>
                    </div>
                </div>
				<div class="col-4">
                    <label class="item-name col-5">短信任务状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="taskType">
                                <option value="">请选择</option>
                                <option value="1">待发送</option>
                                <option value="2">发送中</option>
                                <option value="3">已结束</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="btn-box">
                    <input id="search" type="button" value="查 询" class="btn mr20">
                    <input id="cancel" type="button" onclick="$('#searchForm')[0].reset();" value="重 置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
</div>

<div class="clearfix mb5 mt5">
<c:if test="${flag!='1' }">
    <p class="fl"><input id="addTask" type="button" class="btn btn-sm mr5 js-masssms" value="新增短信任务">
</c:if>    
    <p class="fl"><input id="smsTypeFind" type="button" class="btn btn-sm mr5 js-masssms" value="短信类别查看">
    
</div>
<div class="light-info mb5 mt5">
        <span class="light">提示：短信任务开始前可选择删除或修改任务信息，短信任务开始执行后将不能中止，短信任务执行完成前不能新增短信任务。</span>
 </div>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>短信任务编号</th>
            <th>短信任务名称</th>
            <th>状态</th>
            <th>发送对象</th>
            <th>短信类别</th>
            <th>任务原始名单</th>
      <!--  <th>发送企业数</th>
            <th>发送负责人手机数</th>
            <th>发送联络员手机数</th> -->
            <th>任务开始日期</th>
            <th>设置人</th>
            <th>设置日期</th>
            <th>设置部门</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/smsgroupsend/smstask_list.js"></script>
</body>
<script>
    window._CONFIG = {
        isAdmin:'${sessionScope.session_sys_user.isAdmin}',
            <c:if test="${sessionScope.session_sys_user.isAdmin!='1'}">
             select_detp_tree_url:'<c:url value="/common/system/dept/tree/select"/>',
            </c:if>
            <c:if test="${sessionScope.session_sys_user.isAdmin=='1'}">
            select_detp_tree_url:'<c:url value="/common/system/dept/tree/selectAll"/>',
            </c:if>
    }
</script>
</html>
