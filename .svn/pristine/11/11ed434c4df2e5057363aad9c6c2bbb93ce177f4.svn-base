<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>

<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>行政指导审核</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body class="pd10">
<div class="form-box pd14-mr">
    <form id="qryForm">
        <input type="hidden" id="regOrg" name="regOrg">
        <input type="hidden" id="localAdm" name="localAdm">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="unicode" class="ipt-txt">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" name="entname" class="ipt-txt">
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">提示状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="efftstatus">
                                <option value="">请选择</option>
                                <option value="0">无效</option>
                                <option value="1">有效</option>
                                <option value="2">待审核</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">申请人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="applyman">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">行政指导有效日期：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-575">
                                <input type="text" onclick="laydate()" readonly="readonly" name="stadate" value=""
                                       class="ipt-txt laydate-icon clx"/>
                            </div>
                            <span class="item-line col-05">-</span>
                            <div class="ipt-box col-575">
                                <input type="text" onclick="laydate()" class="ipt-txt laydate-icon clx"
                                       readonly="readonly" name="enddate" value=""/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 管辖单位：</label>
                    <div class="ipt-box col-6">
                        <input type="text" class="fl ipt-txt" readonly="readonly" id="localAdmName" placeholder="选择">
                         <span class="add-icon" id="choseregUnit">
                             <i></i>
                         </span>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">行政指导项目：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="adminguideitem">
                                <option value="">请选择</option>
                                <option value="1">其他</option>
                                <option value="2">股东出资提示</option>
                                <option value="3">许可证即将到期</option>
                                <option value="4">经营期限即将到期</option>
                                <option value="5">长期不开展经营活动</option>
                                <option value="6">清算</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核结果：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="auditstate">
                                <option value="">请选择</option>
                                <option value="0">未审核</option>
                                <option value="1">同意行政指导</option>
                                <option value="2">退回修改</option>
                                <option value="3">取消行政指导</option>
                                <option value="4">中止</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5"> 登记机关：</label>
                    <div class="ipt-box col-6">
                        <input type="text" class="fl ipt-txt" readonly="readonly" id="regOrgName" placeholder="选择">
                         <span class="add-icon" id="choseorgReg">
                             <i></i>
                         </span>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">审核人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="auditname">
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix">
                <div class="btn-box mt10">
                    <input id="qry" type="button" value="查 询" class="btn mr20">
                    <input id="cancel" type="button" value="重 置" class="btn">
                </div>
            </div>
        </div>
</div>
</form>
<div class="clearfix mb5 mt5">
    <p class="fl"><input type="button" class="btn btn-sm mr5 js-add" value="新增">
        <%--<input type="button" class="btn btn-sm" value="导出"></p>--%>
</div>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>审核状态</th>
            <th>提示状态</th>
            <th class="uniCode">统一信用代码/注册号/批号</th>
            <th>企业名称</th>
            <th class="adminguideitem">行政指导项目</th>
            <th>开始日期</th>
            <th>结束日期</th>
            <th>申请人</th>
            <th>申请日期</th>
            <th>审核人</th>
            <th>审核日期</th>
        </tr>
        </thead>
    </table>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/govguide/govguide_list.js"></script>
</body>
</html>