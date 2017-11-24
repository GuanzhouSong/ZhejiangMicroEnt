<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>后置审批事项列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list">
            <input type="hidden" name="licType" value="2" >
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5">审批事项编码：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="exaCode" value="" placeholder="请输入审批事项编码">
                        </div>
                    </div>
                    
                </div>
                <div class="col-4"> 
                    <label class="item-name col-5">审批事项名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="exaName" value="" placeholder="请输入审批事项名称"/>
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-3">部门级别：</label>
                    <div class="col-9">
                        <div class="ipt-box col-8">
                            <select name="licZone">
                                <option value="">全部</option>
                                <option value="0">国家级</option>
                                <option value="1">省级</option>
                                <option value="2">市级</option>
                                <option value="3">县级</option>
                                <option value="4">混合</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item mt10">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
    <div class="clearfix mb5">
        <p class="fl"><input type="button" class="btn btn-sm mr5" value="新增" id="pubdtinfohandpushlist"></p>
        <p class="fl" style="display: none"><input type="button" class="btn btn-sm mr5" value="生成审批对照数据"
                                                   id="executeLicDeptData"></p>
    </div>
    <div class="light-info mb5">
            <p class="light">提示：后置审批事项的数据和准入系统保持一致，若非准入系统的后置审批事项有变化，请勿执行新增、修改、删除操作</p>
           <!--  <i class="xbt-icon close"></i> -->
    </div>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
                            <th>操作</th>
                            <th>审批事项编码</th>
                            <th>审批事项名称</th>
                            <th>审批机关</th>
                            <th>部门级别</th> 
                            <th>法律依据</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script src="/js/syn/system/codeLicense/codelicense_list_main.js"></script>
</body>
</html>