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
    <title>党员户口新增</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="cidRegNO" value="" placeholder="可输入尾号后四位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
               <div class="col-4">
                    <label class="item-name col-5">法定代表人/负责人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="leRep" value="" placeholder="可输入名称关键词查询">
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">企业类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <label><input type="checkbox" name="entType" checked="checked" value="9500">个体户</label>
                            <label><input type="checkbox" name="entType" checked="checked" value="1122,1130,1151,1152,1212,1222,2122,2130,2151,2152,2212,2222,4500,4510,4550,4530,4570,4560,4580">私营企业</label>
                        </div>
                    </div>
                </div>
               <div class="col-4">
                    <label class="item-name col-5">所属市场：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="belongMarket" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="请选择管辖单位" readonly="readonly"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
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
    <div class="iframe-wrap">
        <div class="mb5 mt5">
            <button type="button" id="addBtn" style="min-width: 80px" class="btn btn-primary">添加</button>
            <button type="button" id="back" style="min-width: 80px" class="btn btn-primary">返回</button>
        </div>
        <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 50px">序号</th>
                <th style="min-width: 140px">统一信用代码/注册号</th>
                <th style="min-width: 150px">企业名称</th>
                <th style="min-width: 70px">类型</th>
                <th style="min-width: 80px">法定代表人/负责人</th>
                <th style="min-width: 120px">管辖单位</th>
                <th style="min-width: 120px">所属市场</th>
            </tr>
            </thead>
        </table>
    </div>
    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script src="/js/reg/server/partycreate/add_choose.js"></script>
</div>
</body>
</html>
