<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>风险预警查看</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<form id="hx-form">
    <div class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-6">统一信用代码/注册号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="regNO">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4">企业名称：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="entName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">批次编号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="batchNo">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-6">管辖单位：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="localAdm" class="ipt-txt clx" style="height: 30px;" name="" value=""
                                   readonly/>
                            <input type="hidden" id="localAdmCode" class="clx" name="localAdm" value=""/>
                            <a id="selectLocalAdm" class="link js-show">
                                <span class="add-icon" id="yccodetree"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4"> 登记机关：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" id="regOrg" class="ipt-txt clx" style="height: 30px;" name="" value=""
                                   readonly/>
                            <input type="hidden" id="regOrgCode" class="clx" name="regOrg" value=""/>
                            <a id="selectRegOrg" class="link js-show">
                                <span class="add-icon" id="yccodetree"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 标识名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="markName">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-6">企业预警状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="entWarnState" class="clx">
                                <option value="">请选择</option>
                                <option value="1">有效</option>
                                <option value="0">无效</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4">标识有效期：</label>
                    <div class="col-8">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();"
                                   name="markStartDate">
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();"
                                   name="markEndDate">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="checkState" class="clx">
                                <option value="">请选择</option>
                                <option value="1">通过</option>
                                <option value="0">未通过</option>
                                <option value="2">未审核</option>
                                <option value="3">审核退回</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb10">
                <div class="col-4">
                    <label class="item-name col-6">录入人/审核人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="importPeople">
                        </div>
                    </div>
                </div>
            </div>
            <input value="${MarkSetDeptCode}" name="markSetDeptCode" type="hidden">
            <div class="form-item clearfix">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="button" id="reset" value="重 置" class="btn mr20">
                </div>
            </div>
        </div>
    </div>
</form>
<div class="clearfix mb5">
</div>
<div>
    <table id="apply_table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>审核状态</th>
            <th>标识名称</th>
            <th>标识开始日期</th>
            <th>结束日期</th>
            <th>企业预警状态</th>
            <th>批次编号</th>
            <th>统一信用代码</th>
            <th>注册号</th>
            <th>企业名称</th>
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
        select_localAdm_url: '<c:url value="/commom/server/regunit/regunitmutiselect"/>'
    }
</script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/risk/entwarninfo/entwarnview_list.js"></script>
</body>
</html>