<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>主体变更重建档</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body class="pd10">
<div class="form-box">
    <form id="qryForm">
        <input type="hidden" id="regOrg" name="regOrg">
        <input type="hidden" id="localAdm" name="localAdm">
        <input type="hidden" id="entType" name="entType">
        <input type="hidden" id="sliceNo" name="sliceNO">
        <input type="hidden" id="street" name="street">

        <div class="form-list pd14-mr">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniCode" placeholder="请输入完整的统一信用代码/注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">企业类型（大类）：</span></label>
                    <div class="ipt-box col-7">
                        <input type="text" class="fl ipt-txt" readonly="readonly" id="entTypeName" placeholder="选择">
                       <span class="add-icon" id="choseEntType">
                           <i></i>
                       </span>
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
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" placeholder="请输入完整的企业名称">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">核准日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-575">
                                <input type="text" readonly="readonly" onclick="laydate()" name="apprDate_sta"
                                       class="ipt-txt laydate-icon clx">
                            </div>
                            <span class="item-line col-05">-</span>
                            <div class="ipt-box col-575">
                                <input type="text" readonly="readonly" onclick="laydate()" name="apprDate_end"
                                       class="ipt-txt laydate-icon clx">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 片区/商圈：</label>
                    <div class="ipt-box col-6">
                        <input type="text" class="fl ipt-txt" readonly="readonly" id="sliceNoName" placeholder="选择">
                          <span class="add-icon" id="choseSilceno">
                              <i></i>
                          </span>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">法定代表人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep" placeholder="请输入完整的法定代表人名称">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">经营范围：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="opScope">
                        </div>
                    </div>
                </div>
                <div class="col-4" hidden>
                    <label class="item-name col-5"> 乡镇/街道：</label>
                    <div class="ipt-box col-6">
                        <input type="text" class="fl ipt-txt" readonly="readonly" id="streetName" placeholder="选择">
                        <span class="add-icon" id="choseStreet">
                            <i></i>
                        </span>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">住所（经营场所）：</span></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="dom">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mt10">
                <div class="btn-box">
                    <input id="qry" type="button" value="查 询" class="btn mr20">
                    <input id="cancel" type="button" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </form>
</div>
<div class="clearfix mb5 mt5">
    <p class="fl">
        <input type="button" class="btn btn-sm mr5 js-batchregist" value="批量建档">
        <%--<input type="button" class="btn btn-sm" value="导出">--%>
    </p>
</div>
<table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
    <thead>
    <tr>
        <th>序号</th>
        <th>全选<input type='checkbox' id='checkAll'></th>
        <th>操作</th>
        <th class="uniCode">统一代码/注册号</th>
        <th>企业名称</th>
        <th>法定代表人</th>
        <th>住所</th>
        <th>核准日期</th>
        <th>管辖单位</th>
        <th class="altItem">变更事项</th>
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
<script src="/js/reg/server/registinfo/registinfoagain_list.js"></script>
</body>
</html>
