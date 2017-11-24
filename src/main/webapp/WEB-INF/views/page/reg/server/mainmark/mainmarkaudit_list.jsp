<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>分类标签审核列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="webForm" class="form-box pd14-mr">
        <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">标签名称：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="markName" value="" placeholder="可输入关键字查询">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">申请人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="setName" value="" placeholder=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">申请部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="setDeptname" value="" placeholder=""/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">审核状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12"> 
                             <select name="auditState" id="auditState" multiple="multiple">
                             	<option value='1'>待审核</option>
                             	<option value='2'>审核通过</option>
                             	<option value='3'>审核不通过</option>
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12"> 
                            <input type="text" class="ipt-txt" name="auditorName" value="" placeholder=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="auditDeptName" value="" placeholder=""/>
                        </div>
                    </div>
                </div>
            </div>
          
            <div class="center mt10">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#webForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
     
    <div class="clearfix mb5 mt5">
   
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
                            <th>统一信用代码/注册号</th>
                            <th>企业名称</th>
                            <th>当前标签</th>
                            <th>添加标签</th>
                            <th>去除标签</th>
                            <th>审核状态</th>
                            <th>申请人</th>
                            <th>申请日期</th>
                            <th>申请部门</th>
                            <th>审核人</th>
                            <th>审核日期</th>
                            <th>审核部门</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
<script>
    window._CONFIG = {
       deptCode:'${deptCode}',
       isAdmin :'${sysUser.isAdmin}',
       searchRangeLevel:'${sysUser.searchRangeLevel}'
    }
</script>
    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script src="<c:url value="/js/reg/server/mainmark/mainmarkaudit_list.js"/>"></script>
</body>
</html>