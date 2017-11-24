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
    <title>联合惩戒信息</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body class="pd10">
<div class="form-box">
    <form id="qryForm">

        <div class="form-list pd14-mr">
            <div class="form-item clearfix">
  <%--              <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">证照号码/证件号码：</span></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cardNo">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">名称/姓名：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName_litiName">
                        </div>
                    </div>
                </div>--%>
      <div class="col-4">
          <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
          <div class="col-6">
              <div class="ipt-box col-12">
                  <input type="text" class="ipt-txt" name="uniCode">
              </div>
          </div>
      </div>
      <div class="col-4">
          <label class="item-name col-5">企业名称：</label>
          <div class="col-6">
              <div class="ipt-box col-12">
                  <input type="text" class="ipt-txt" name="entName">
              </div>
          </div>
      </div>

            </div>
            </div>
    </form>
    <div class="form-item clearfix mt10">
        <div class="btn-box">
            <input id="qry" type="button" value="查 询" class="btn mr20">
            <input id="cancel" type="button" value="重 置" class="btn">
        </div>
    </div>

</div>
<div class="clearfix mb5 mt5">
    <p class="fl">
        <span class="mt5" id="downinfo"></span>
        <input type="button" class="btn btn-sm js-batchdownload" value="下载">
    </p>
</div>
<table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" width="100%">
    <thead>
    <tr>
        <th width="3%">序号</th>
        <th width="4%">全选<input type='checkbox' id='checkAll'></th>
        <th width="8%" class="name">名称/姓名</th>
        <th width="6%" class="code">证照号码/证件号码</th>
        <th width="10%">信息接收部门名称</th>
        <th width="8%">信息发送部门名称</th>
        <th width="4%" class="puntype">信息类型</th>
        <th width="5%">限制法律依据</th>
        <th width="7%">法律描述</th>
        <th width="6%" class="exebegin">限制期限自</th>
        <th width="6%" class="exeend">限制期限至</th>
        <th width="6%" class="downstate">下载状态</th>
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
<script src="/js/syn/system/inforece/unionpunish/unionpunish_list.js"></script>
</body>
</html>
