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
    <title>食品仓储申请退回</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <input type="hidden" id="fsScopeValue" name="fsScopeValue" value="">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regNo" value="" placeholder="请输入统一代码/注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value="" placeholder="请选择登记机关" readonly="readonly"/>
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">退回人员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="backName" value="" placeholder="请输入统一代码/注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">退回日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon pointer" onclick="laydate()" readonly="readonly"
                                   name="backTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon pointer" onclick="laydate()" readonly="readonly"
                                   name="backTimeEnd" value=""/>
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
        </div>
        <div class="form-group clearfix mt10">
            <div class="center">
                <input type="button" id="search" value="查询" class="btn mr20">
                <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn">
            </div>
        </div>
    </form>
    <div class="iframe-wrap">
        <div class="info-box mb5 mt5">
            <span style="color: red;">历史退回记录</span>
            <button type="button" id="showBaseList" class="btn btn-primary">新增退回</button>
            <span style="color: red;">提示：需要退回已提交仓储信息的企业请点击“新增退回”</span>
        </div>

        <table id="foodstorageback-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 50px">序号</th>
                <th style="min-width: 150px">统一代码/注册号</th>
                <th style="min-width: 150px">企业名称</th>
                <th style="min-width: 120px">退回日期</th>
                <th style="min-width: 150px">退回原因</th>
                <th style="min-width: 80px">退回人员</th>
                <th style="min-width: 100px">登记机关</th>
                <th style="min-width: 100px">管辖单位</th>
            </tr>
            </thead>
        </table>
    </div>
    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script src="/js/reg/server/yr/foodstorageback/list_main.js"></script>
</div>
</body>
</html>
