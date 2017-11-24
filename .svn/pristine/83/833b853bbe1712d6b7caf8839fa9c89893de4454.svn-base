<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>本部门问题数据处理</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<jsp:include page="common/header.jsp"></jsp:include>
<div class="mod clearfix">
   <jsp:include page="common/menu.jsp?module=wtsjcl&menu=wtsjcl"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)">信息管理</a> &gt;
            <a href="javascript:void(0)" class="cur">本部门问题数据处理</a>
        </div>
        <div class="pdlr5">
            <div class="tab">
                <li><a href="/depsyn/datamanage?menu=wtsjcl">行政处罚信息</a></li>
                <li><a href="/depsyn/licenseview?menu=wtsjcl" class="cur">行政许可信息</a></li>
                <li><a href="/depsyn/spotview?menu=wtsjcl">抽查检查结果</a></li>
                <li><a href="javascript:void(0)">小微企业扶持信息</a></li>
                <li><a href="javascript:void(0)">联合惩戒信息</a></li>
            </div>
            <div class="panel-bd">
              <form id="hxForm">
                <div class="search-box filter-item mb36">
                    <p class="mb7">
                        <label class="tr w100">企业名称：</label>
                        <input type="text" class="ipt-txt2" name="keyword">
                        <label class="tr w150">统一社会信用代码/注册号：</label>
                        <input type="text" class="ipt-txt2">
                        <label class="tr">提交时间：</label>
                        <input type="text" class="ipt-txt2 ipt-txt-time"> ~
                        <input type="text" class="ipt-txt2 ipt-txt-time">
                    </p>
                    <p>
                        <label class="tr w100">处罚决定书文号：</label>
                        <input type="text" class="ipt-txt2">
                        <label class="tr w150">提供方式：</label>
                        <input type="text" class="ipt-txt2">
                    </p>
                    <input type="hidden"   name="deptCode" value="${depCode}">
                    <input type="button" value="查询" id="search" class="ipt-btn  fr mr20 mb3">
                </div>
                </form>
                <input type="button" value="删除" class="ipt-btn  fr mr20 mb3 delete">
                <table cellpadding="0" cellspacing="0" class="table-common">
                    <thead>
                    <tr>
                        <th width="20"><input type="checkbox" class="chbAll"></th>
                        <th width="30">序号</th>
                        <th width="70">企业名称</th>
                        <th width="90">统一社会信用代码/注册号</th>
                        <th width="46">许可文件编号</th>
                        <th width="30">提供方式</th>
                        <th width="90">许可文件名称</th>
                        <th width="72">有效期自</th>
                        <th width="84">有效期至</th>
                        <th width="34">许可机关</th>
                        <th width="74">错误代码</th>
                        <th width="74">提交时间</th>
                        <th width="74">反馈时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="table_page">
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
</div>
<div class="mod">
    <div class="footer-box">
        <div class="footer">
            <p>版权所有：浙江省工商行政管理局</p>
            <p>年报公示业务咨询电话：400-888-4636（年报）&nbsp;&nbsp;&nbsp;&nbsp;技术支持电话：400-888-4636（公示）&nbsp;&nbsp;&nbsp;&nbsp;京ICP备16053442号-1</p>
        </div>
    </div>
</div>
<script id="table_list" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td><input type="checkbox" class="chb" value="{{id}}"></td>
        <td>{{xh @index}}</td>
        <td>{{entName}}</td>
        <td>{{uniSCID}}</td>
        <td>{{licNO}}</td>
        <td>{{proType}}</td>
        <td>{{licName}}</td>
        <td>{{valFrom}}</td>
        <td>{{valTo}}</td>
        <td>{{licAnth}}</td> 
        <td>{{errorCode}}</td> 
        <td>{{resubTime}}</td> 
        <td>{{feedbackTime}}</td> 
        <td><a href="javascript:void(0)" class="edit" id="{{id}}">修改</a></td>
    </tr>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/licensemanage.js"></script>
</body>
</html>