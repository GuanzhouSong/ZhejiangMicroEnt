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
    <title>新增标记异常记录</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<form id="taskForm">
<input type="hidden" name="entTypeCatg" value="50">
<input type="hidden" name="regState" value="K,B,A,DA,X">
<input type="hidden" id="rocode" value="${codeRegorg.code }">
<input type="hidden" id="rocontent" value="${codeRegorg.content }">
    <div class="form-box pdr8">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="cidRegNO" value="" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value="${codeRegorg.code }"/>
                            <input type="text" readonly="readonly" class="ipt-txt" name="regOrgName" id="regOrgName" value="${codeRegorg.content }"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">经营者：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="leRep" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="hidden_input" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" readonly="readonly"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="center mt10">
                <div class="btn-box">
                    <input type="button" id="js-search" value="查 询" class="btn mr20">
                    <input type="reset" id="cancel" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </div>
</form>
<div>
	<input type="button" id="ret" value="返回" class="btn mr20">
	<input type="button" id="add" value="申请标记异常状态" class="btn mr20">
</div>
<div class="iframe-wrap mt10">
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
           style="width: 100%;white-space: nowrap;" cellspacing="0">
        <thead>
        <tr>
            <th style="padding:0 20px;">序号</th>
            <th>单选</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>经营者</th>
            <th>登记机关</th>
            <th>管辖单位</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value='/js/reg/server/opanomaly/pbopanomaly/pbopanomalyadd_list.js'/>"></script>
</body>
</html>
