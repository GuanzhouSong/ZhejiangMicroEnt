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
    <title>经济户口销户记录</title>
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
        <input type="hidden" id="sliceNO" name="sliceNO">

        <div class="form-list pd14-mr">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cidRegNO">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">销户事由：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="regState">
                                <option value="">请选择</option>
                                <option value="X">注销</option>
                                <option value="D">吊销</option>
                                <option value="C">撤销</option>
                                <option value="Q">迁出</option>
                                <select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6"> 管辖单位：</label>
                    <div class="ipt-box col-5">
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
                            <input type="text" class="ipt-txt" name="entName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">销户日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" readonly="readonly" onclick="laydate()" name="altDateStart"
                                   class="ipt-txt laydate-icon clx">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" readonly="readonly" onclick="laydate()" name="altDateEnd"
                                   class="ipt-txt laydate-icon clx">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6"> 片区/商圈：</label>
                    <div class="ipt-box col-5">
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
                            <input type="text" class="ipt-txt" name="leRep">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">住所（经营场所）：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="dom">
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-6"><span class="long-label">企业类型（大类）：</span></label>
                    <div class="ipt-box col-5">
                        <input type="text" class="fl ipt-txt" id="entTypeName" readonly="readonly" placeholder="选择">
                  <span class="add-icon" id="choseEntType">
                      <i></i>
                  </span>
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
        <%--<input type="button" class="btn btn-sm" value="导出">--%>
    </p>
</div>
<table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" width="100%">
    <thead>
    <tr>
        <th width="5%">序号</th>
        <th width="5%">销户时间</th>
        <th width="4%">销户事由</th>
        <th width="8%" class="uniCode">统一信用代码/注册号</th>
        <th width="8%">企业名称</th>
        <th width="5%"> 法定代表人</th>
        <th width="8%">住所（经营场所）</th>
        <th width="5%">成立日期</th>
        <th width="8%">管辖单位</th>
        <th width="8%">登记机关</th>
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
<script src="/js/reg/server/registinfo/logoff_list.js"></script>
</body>
</html>
