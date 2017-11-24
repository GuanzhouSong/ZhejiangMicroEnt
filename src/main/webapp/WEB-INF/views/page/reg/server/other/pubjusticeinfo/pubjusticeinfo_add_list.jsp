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
    <title>司法协助录入</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style type="text/css">
</style>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <input type="hidden" id="userType" value="${userType }">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-6">注册号/统一社会信用代码：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cidRegNO" value="" placeholder="注册号或统一社会信用代码">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">股权所在企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入股权所在企业名称"/>
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
                    <label class="item-name col-6">法定代表人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep" value="" placeholder="请输入法定代表人">
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
                <div class="col-4">
                    <label class="item-name col-5">责任区：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNO" value=""/>
                            <input type="text" class="ipt-txt" id="sliceNOName" value="" placeholder="请选择责任区" readonly="readonly"/>
	                            <span class="add-icon" id="chosesliceNo">
	                            <i></i>
	                         </span>
                        </div>
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
    </form>
    <div class="iframe-wrap mt20">
        <button type="button" id="addBtn" class="btn btn-primary">添加</button>
        <button type="button" id="back" class="btn btn-primary">返回</button>
        <div class="light-info mt5">
            <span class="light">提示：同一个股权所在的企业涉及多个被执行人信息公示，请按照一个被执行人一条信息方式进行添加。</span>
        </div>
        <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row table-"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 50px">序号</th>
                <th style="min-width: 140px">股权所在企业统一代码</th>
                <th style="min-width: 140px">股权所在企业注册号</th>
                <th style="min-width: 150px">股权所在企业名称</th>
                <th style="min-width: 100px">法定代表人</th>
                <th style="min-width: 120px">登记机关</th>
                <th style="min-width: 120px">管辖单位</th>
                <th style="min-width: 120px">责任区</th>
            </tr>
            </thead>
        </table>
    </div>
    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script src="/js/reg/server/other/pubjusticeinfo/pubjusticeinfo_add_main.js"></script>
</div>
</body>
</html>
