<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>限制管理</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <div class="tab-content">
        <div class="tab-panel tab-panel-show">
       	<form id="searchForm" class="searchForm">
            <div class="form-box">
                <div class="form-list">
                    <div class="form-item clearfix">
                            <input type="hidden" value="${ids}" name="peoplelist"/>
                            <input type="hidden" value="${priPIDs}" name="priPIDs"/>
                            <label class="item-name ml10 pdt10">关联企业类型：</label>
                            <div class="col-8">
                                <div class="radio-box col-12">
<!--                                     <label for="" class="mr20"><input id="" name="linktype" type="radio" value="tz">投资企业</label> -->
<!--                                     <label for="" class="mr20"><input id="" name="linktype" type="radio" value="gg">高管关联企业</label> -->
                                    <label for="" class="mr20"><input id="" name="linktype" type="radio" value="fr" checked />法人关联企业</label>
                                    <input id="search" type="button" value="涉及企业名单查询" class="btn btn-sm">
                                </div>
                            </div>
                    </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="clearfix mb5 mt5">
    <p class="fl"><input id="adminguide" type="button" class="btn btn-sm mr5" value="行政指导"/><input id="reform" type="button" class="btn btn-sm mr5" value="责令整改"></p>
</div>

<div class="table-out">
<div class="iframe-wrap">
    <table id="qua-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="white-space: nowrap;width: 100%;">
        <thead><tr>
            <th width="5%">序号</th>
            <th>选择 </th>
            <th>当事人名称</th>
            <th>关联企业关系</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人</th>
            <th>住所</th>
<!--             <th>案件详情</th> -->
        </tr>
        </thead>
     </table>
</div>

 <p class="center mt20">
                            <input id="cancel" type="button" class="btn mr20" value="返  回"></p>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registmanage/qualifiedmanage/limitmanage.js"></script>
</body>
</html>