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
    <title>许可证清单维护</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">许可事项名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="licName" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">前置/后置：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="licType">
                                <option value="">全部</option>
                                <option value="1">前置</option>
                                <option value="2">后置</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">是否有效：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="isValid">
                                <option value="">全部</option>
                                <option value="1">有效</option>
                                <option value="0">无效</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">设置人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="setName" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审批部门类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="licDeptType">
                                <option value="">全部</option>
                                <option value="1">审批部门类型1</option>
                                <option value="2">审批部门类型2</option>
                                <option value="3">审批部门类型3</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审批部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="licDept" value=""/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">编号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="licNO" value=""/>
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
                            <input type="text" class="ipt-txt laydate-icon " style="cursor: pointer;"
                                   onclick="laydate()" readonly="readonly" name="setTimeEnd" value=""/>
                        </div>

                    </div>
                </div>

            </div>
            <div class="form-group clearfix">
                <div class="center mt10">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
</div>

<div class="clearfix mb5 mt5">
    <p class="fl"><input type="button" class="btn btn-sm mr5 js-add" value="添加许可证"/></p>
</div>
<div class="table-out">
    <table id="syslicence-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>许可事项名称</th>
            <th>许可事项编号</th>
            <th>审批部门类型</th>
            <th>审批部门</th>
            <th>法律依据</th>
            <th>级别</th>
            <th>前置/后置</th>
            <th>设置人姓名</th>
            <th>是否有效</th>
        </tr>
        </thead>
    </table>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/syslicense/list_main.js"></script>
</body>
</html>
