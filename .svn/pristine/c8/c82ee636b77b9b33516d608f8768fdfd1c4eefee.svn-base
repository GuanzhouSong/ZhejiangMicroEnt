<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>经营异常名录</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<jsp:include page="common/header.jsp"></jsp:include>
<div class="mod clearfix">
    <jsp:include page="common/menu.jsp?module=sgz&menu=ycjyml"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)">信息接收</a> &gt;
            <a href="javascript:void(0)" class="cur">经营异常名录</a>
        </div>
        <div class="pdlr5">
            <div class="search-box filter-item mb10">
                <label>企业名称：</label>
                <input id="entName" type="text" class="ipt-txt2">
                <label>统一社会信用代码/注册号：</label>
                <input id="uniSCID" type="text" class="ipt-txt2">
                <input id="search" type="button" value="搜索" class="ipt-btn">
            </div>
            <div class="table-title">
             <p id="downinfo"></p>
                <input id="download" type="button" value="下载" class="ipt-btn  fr mr20 mb3 js-batchdownload">
            </div>
            <table id="pubdtinfoTable" cellpadding="0" cellspacing="0" class="table-common">
                <thead>
                <tr id="trTitle">
                    <th width="24"><input type="checkbox"/></th>
                    <th width="32">序号</th>
                    <th width="94">企业名称</th>
                    <th width="160">统一社会信用代码/注册号</th>
                    <th width="72">登记日期</th>
                    <th width="108">列入文号</th>
                    <th width="74">列入日期</th>
                    <th width="103">列入原因</th>
                    <th width="78">列入机关</th>
                    <th>下载状态</th>
                </tr>
                </thead>
                <tbody id="pubdtinfo_page">
           </tbody>
            </table>
 <div class="notice-pagination-box clearfix">
            <span class="page-total">共查询到<em id="pro_total"></em>条信息，共<em id="pro_pageNum"></em>页</span>
            <div id="" class="pagination">
            </div>
        </div>
        </div>
    </div>
</div>

  <form id="excelform" method="post" action="/depsyn/loadToExcel">
  <input type="hidden" id="cellInfo" name="cellInfo" />
  <input type="hidden" id="cellTitle" name="cellTitle" />
  <input type="hidden" id="fileName" name="fileName" />
  </form>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
<script id="pubdtinfo_list" type="text/x-handlebars-template">
    {{#each data}}
    <tr id="tr{{id}}">
        <td><input type="checkbox" class="chb" name="checkbox1" value="{{id}}"></td>
        <td>{{xh @index}}</td>
        <td><a priPID ="{{priPID}}" style="cursor: pointer;text-decoration:none;">{{entName}}</a></td>
        <td><a priPID ="{{priPID}}" style="cursor: pointer;text-decoration:none;">{{uniSCID}}</a></td>
        <td>{{estDate}}</td>
        <td>{{penDecNo}}</td>
        <td>{{abnTime}}</td>
        <td>{{speCauseCN}}</td>
		<td>{{decorgCN}}</td>
        <td>{{downStateDesc}}</td>
    </tr>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/jyyc_list.js"></script>
</html>