<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>执法人员列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<form id="qryForm">
    <input type="hidden" id="deptCode" name="deptCode" value="${sessionDeptCode}">
    <div class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">检查事项：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="" class="ipt-txt">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">检查人员要求：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<input type="hidden" class="ipt-txt" name="checkManFlag" id="checkManFlag" value=""/>
                            <select id="checkManFlags" multiple="multiple">
	                            <option value="N">无需专业岗资格</option>
	                            <option value="Y">需要专业岗资格</option>
	                        </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">检查方式：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
	                        <input type="hidden" class="ipt-txt" name="checkWay" id="checkWay" value=""/>
                            <select id="checkWays" multiple="multiple">
	                            <option value="1">现场检查</option>
	                            <option value="2">书式检查</option>
	                            <option value="3">检验检测</option>
	                            <option value="4">行政部门检查结果或专业意见</option>
	                            <option value="5">审计、验资、评估等第三方验证</option>
	                            <option value="6">网络监测</option>
	                        </select>
                        </div>
                        </div>
                    </div>
                </div> 
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="isScVlid">
	                            <option value="">全部</option>
	                            <option value="Y">有效</option>
	                            <option value="N">失效</option>
	                        </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">设置人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="" name="setUserName" class="fl ipt-txt">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">设置日期：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="setTimeStart">
							</div>
							<span class="item-txt col-2"><i class="line-icon"></i></span>
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="setTimeEnd">
							</div>
                        </div>
                    </div>
                </div>
            </div>
			</div>
            <div class="form-item clearfix mt10">
                <div class="btn-box">
                    <input type="button" value="查 询" id="qry" class="btn mr20">
                    <input type="button" value="重 置" id="cancel"  class="btn mr20">
                </div>
            </div>
        </div>
    </div>
</form>
<div class="clearfix mb5">
    <input type="button" class="btn btn-sm mr5 " id="toAdd" value="添加检查事项清单">
</div>
<div>
    <table border="0" id="sccheckbill-table" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
	        <tr>
	            <th>序号</th>
	            <th>操作</th>
	            <th>检查事项名称</th>
	            <th>检查子项</th>
	            <th>检查方式</th>
	            <th>检查人员要求</th>
	            <th>状态</th>
	            <th>设置人</th>
	            <th>设置日期</th>
	            <th>设置部门</th>
	        </tr>
        </thead>
    </table>
</div>
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/sccheckbill/sccheckbill_list.js"></script>
</html>