<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>批量导入</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<jsp:include page="common/header.jsp"></jsp:include>
<div class="mod clearfix">
    <jsp:include page="common/menu.jsp?module=wtsjcl&menu=plbd"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)" class="cur">起始页</a>
        </div>
        <hr/>

        <div class="gl-result-box">
            <div class="title clearfix">
            <input id="pageflag" type="hidden" value="${pageflag}" />
            <input id="msg" type="hidden" value="${msg}" />
                <span class="fl">上传的文件<strong><span id="fileName">${fileName}</span></strong></span>
                <div class="fr">
                    <input id="compare" type="button" class="ipt-btn" value="对比" style="margin-right: 20px">
                    <input id="getout" type="button" class="ipt-btn" value="导出">
                </div>
            </div>
            <h5>
                上传的文件中有<font class="light">${num}</font>户无效企业
            </h5>
            <table class="table-common">
            <thead>
                <tr>
                    <th>序号</th>
                    <th>企业名称</th>
                    <th>企业注册号</th>
                    <th>社会统一信用代码</th>
                    <th>当前是否无效企业</th>
                    <th>登记日期</th>
                </tr>
                <thead>
                <tbody id="pubdtinfo_page"></tbody>
            </table>
            
            
            
            <div class="notice-pagination-box clearfix">
                        <span class="page-total">共查询到 <em id="pro_total"></em> 条信息，共 <em
                                id="pro_pageNum"></em> 页</span>
                        <div id="pagination_midinv_stock" class="pagination">
                        </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script id="pubdtinfo_list" type="text/x-handlebars-template">
                {{#each this}}
                <tr data-id="{{id}}">
                    <td>{{xh @index}}</td>
                    <td>{{entName}}</td>
                    <td>{{regNO}}</td>
                    <td>{{uniCode}}</td>
                    <td>{{regState}}</td>
					<td>{{estDate}}</td>
                </tr>
                {{/each}}
            </script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/comparesec.js"></script>
</body>
</html>