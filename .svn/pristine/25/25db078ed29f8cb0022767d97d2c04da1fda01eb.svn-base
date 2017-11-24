<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>关注服务审核</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<form id="hx-form">
    <div class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">批次编号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="batchNo">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4">标识名称：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="markName">
                        </div>
                    </div>
                </div>
	            <div class="col-4">
	                <label class="item-name col-5">审核人：</label>
	                <div class="col-6">
	                    <div class="ipt-box col-12">
	                        <input type="text" class="ipt-txt" name="checkPeople">
	                    </div>
	                </div>
	            </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">标识适用地区：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="markUseArea">
                                <option value="">请选择</option>
                                <option value="省">省</option>
                                <option value="市">市</option>
                                <option value="县（市区）">县（市区）</option>
                                <option value="省本级">省本级</option>
                                <option value="市本级">市本级</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4">标识有效期：</label>
                    <div class="col-8">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate();"
                                   name="markStartDate">
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate();"
                                   name="markEndDate">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">录入人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="importPeople">
                        </div>
                    </div>
                </div>
            </div>
            
            <input value="${userCode}" name="deptCode" type="hidden">
            <div class="form-item clearfix">
                <div class="btn-box mt10">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="reset" id="reset" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </div>
</form>
<div>
    <table id="con_apply_table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>审核状态</th>
            <th>批次编号</th>
            <th>标识名称</th>
            <th>标识适用地区</th>
            <th>标识开始日期</th>
            <th>标识结束日期</th>
            <th>录入人</th>
            <th>录入时间</th>
            <th>审核人</th>
            <th>审核时间</th>
        </tr>
        </thead>
    </table>
</div>
<script>
    window._CONFIG = {
        select_regOrg_url: '<c:url value="/commom/server/regorg/regorgmutiselect"/>',
        select_localAdm_url: '<c:url value="/commom/server/regunit/regunitmutiselect"/>',
        select_entType_url: '<c:url value="/commom/server/entcatg/entcatgmutiselect"/>',
        select_industryCo_url: '<c:url value="/commom/server/industry/toIndustryPhyTree"/>'
    }
</script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/concern/conc/con_apply_auditlist.js"></script>
</body>
</html>