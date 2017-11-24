<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>无证无照--涉嫌违法事项</title>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>

<div class="layer-bd pd10">
    <div class="mass-distribution">
        <input type="hidden" id ="selecttype" value="${selecttype}" ><!-- 内部序号 -->
        <div class="mt15 ztree h-160">
            <div id="real" class="select-intercept">
                <%--<div class="option-item">--%>
                    <%--<label class="clearfix">--%>
                        <%--<div class="right col-1"><input type="checkbox" name="illegalitem" class=""></div>--%>
                        <%--<span class="name col-10">公共航空运输经营审批公共航空运输经营审批公共航空运输经营审批公共航空运输经营审批公共航空运输经营审批公共航空运输经营审批</span>--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="option-item">--%>
                    <%--<label class="clearfix">--%>
                        <%--<div class="right col-1"><input type="checkbox" name="illegalitem" class=""></div>--%>
                        <%--<span class="name col-10">公共航空运输经营审空运输经营审批</span>--%>
                    <%--</label>--%>
                <%--</div>--%>
                <%--<div class="option-item">--%>
                    <%--<label class="clearfix">--%>
                        <%--<div class="right col-1"><input type="checkbox" name="illegalitem" class=""></div>--%>
                        <%--<span class="name col-10">公共航空运输经营审运输经营审批</span>--%>
                    <%--</label>--%>
                <%--</div>--%>
            </div>
        </div>
        <div class="center mt20">
            <input id="save" type="button" class="btn mr20" value="保 存">
            <input id="cancel" type="button" class="btn" value="取 消">
        </div>
    </div>
</div>
<script id="listTemplate" type="text/x-handlebars-template">
    {{#each this}}
    <div class="option-item">
        <label class="clearfix">
            <div class="right col-1 pdr5"><input type="checkbox" id="{{id}}" value="{{id}}" class="" name="selecttype"></div>
            <span class="name col-10">{{text}}</span>
        </label>
    </div>
    {{/each}}
</script>

<script src="/js/common/select/listlib.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/select/selectinterceptmuti.js"></script>
</body>
</html>