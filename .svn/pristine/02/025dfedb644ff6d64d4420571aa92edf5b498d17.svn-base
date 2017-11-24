<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>股东及出资信息列表页面</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>

<div class="mod pdt20">
    <div class="mod-cont">
        <h4>股东及出资信息</h4>
        <div style="padding:0 24px;">
            <em style="font-size: 14px;">股东姓名：</em>
            <input type="text" id="key_value" class="ipt-txt w304" value="" >
            <button id="key_btn" class="btn-common btn-add h30">搜索</button>
        </div>
        <div  style="margin-top: -28px;">
            <table border="0" cellspacing="0" id="permit-table" cellpadding="0"
                   class="table-public table-web table-nest table-gdcz">
                <thead>
                <tr>
                    <th width="80">股东</th>
                    <th width="80">认缴额<br/>（万${midBaseInfoDto.currencyCn}）</th>
                    <th width="80">实缴额<br/>（万${midBaseInfoDto.currencyCn}）</th>
                    <th valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td colspan="4">认缴明细</td>
                            </tr>
                            <tr>
                                <td width="28%">认缴<br/>出资方式</td>
                                <td width="30%">认缴出资额<br/>（万${midBaseInfoDto.currencyCn}）</td>
                                <td width="28%">认缴<br/>出资日期</td>
                                <td>公示<br/>状态</td>
                            </tr>
                        </table>
                    </th>
                    <th valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td colspan="4">实缴明细</td>
                            </tr>
                            <tr>
                                <td width="28%">实缴出资方式</td>
                                <td width="30%">实缴出资额<br/>（万${midBaseInfoDto.currencyCn}）</td>
                                <td width="28%">实缴<br/>出资日期</td>
                                <td>公示<br/>状态</td>
                            </tr>
                        </table>
                    </th>
                    <th width="60">操作</th>
                </tr>
                </thead>
            </table>
        </div>
        <p class="btn">
            <input type="button" value="添加" class="btn-common js-add" />
            <input type="button" id="print" value="打印预览" class="btn-common" />
            <input type="button" value="保存并公示" id="pubAll" class="btn-common" />
            <input type="button" value="关闭" class="btn-common" id="close" />
        </p>
    </div>
</div>


<form id="key_parmas">
    <input type="hidden" name="name" id="key_name" value="">
</form>

<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <a href="#" class="{{this.class}}">{{this.text}}</a>
    {{/each}}
</script>
<script id="act-template" type="text/x-handlebars-template">
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <tbody>
        {{#each data}}
        <tr>
            <td width="28%">{{acConFormCn}}</td>
            <td width="30%">{{acConAm}}</td>
            <td width="28%">{{transDate conDate}}</td>
            <td>{{trsPubFlag pubFlag}}</td>
        </tr>
        {{/each}}
        </tbody>
    </table>
</script>
<script id="prv-template" type="text/x-handlebars-template">
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <tbody>
        {{#each data}}
        <tr>
            <td width="28%">{{conFormCN}}</td>
            <td width="30%">{{subConAm}}</td>
            <td width="28%">{{transDate conDate}}</td>
            <td>{{trsPubFlag pubFlag}}</td>
        </tr>
        {{/each}}
        </tbody>
    </table>
</script>

<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/im/investment/investment_list.js"/>"></script>

</body>
</html>