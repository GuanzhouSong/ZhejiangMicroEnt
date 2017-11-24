<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>数据导入结果显示提交</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="mod clearfix">
    <jsp:include page="../common/menu.jsp?module=zxlr&menu=pldr"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)">信息提供</a> &gt;
            <a href="javascript:void(0)" class="cur">批量导入</a>
        </div>
        <hr/>
        <div class="drsuccess-box">
            <h3 class="date-upload-title mb16 mt10">
                提交成功后，10个工作日再查看是否正常公示
            </h3>
            <div class="table-title">
                上传的数据中有<font class="light">${sessionScope.invalid}</font>条数据为无效数据
                <input id="js-submit" type="button" value="提交" class="ipt-btn  fr mr20 mb3">
            </div>
            <table cellpadding="0" cellspacing="0" class="table-common">
                <thead>
                <tr>
                    <th width="40">序号</th>
                    <th width="96">企业名称</th>
                    <th width="106">社会统一信用代码</th>
                    <th width="100">注册号</th>

                    <th width="78">处罚机关</th>
                    <th width="88">处罚决定书文号</th>
                    <th width="100">处罚决定书签发日期</th>

                    <th width="94">违法行为类型</th>
                    <th width="80">处罚种类</th>
                </tr>
                </thead>
                <tbody id="js-list-content">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_total_yrinfo"></em> 条信息，共 <em id="_pageNum_yrinfo"></em> 页</span>
                <div class="pagination">
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script id="listTemplate" type="text/x-handlebars-template">
    {{#each data}}
    <tr class="{{classAdd 'checkState' checkState}}">
        <td>{{id}}</td>
        <td>{{entName}}</td>
        <td class="{{classAdd uniScidState}}">{{uniScid}}</td>
        <td class="{{classAdd regNOState }}">{{regNO}}</td>

        <td>{{penAuth}}</td>
        <td>{{penDecNo}}</td>
        <td class="{{classAdd cerIssDateState  }}">{{cerIssDate}}</td>

        <td>{{illegActType}}</td>
        <td>{{penType}}</td>
    </tr>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/upload/punish_addbatch.js"></script>
</body>
</html>