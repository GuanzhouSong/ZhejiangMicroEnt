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
<div class="header mod">
<jsp:include page="common/header.jsp"></jsp:include>
<div class="mod clearfix">
   <jsp:include page="common/menu.jsp?module=wtsjcl&menu=sjyyfk"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)">信息管理</a> &gt;
            <a href="javascript:void(0)" class="cur">数据应用反馈</a>
        </div>
        <div class="pdlr5">
           <form id="hxForm">
            <div class="search-box filter-item mb36">
                <p>
                    <label class="tr w100">年度：</label>
                    <select id="selectDate" name="year">
                    </select>
                    <label class="tr w100" >来源部门：</label>
                    <select name="deptCode">
                        <option value="">全部</option>
                        <option value="浙江省发展和改革委员会">浙江省发展和改革委员会</option>
                        <option value="浙江省经济和信息化委员会">浙江省经济和信息化委员会</option>
                        <option value="浙江省教育厅">浙江省教育厅</option>
                        <option value="浙江省科学技术厅">浙江省科学技术厅</option>
                        <option value="浙江省民族宗教事务委员会">浙江省民族宗教事务委员会</option>
                        <option value="浙江省公安厅">浙江省公安厅</option>
                        <option value="浙江省监察厅">浙江省监察厅</option>
                        <option value="浙江省民政厅">浙江省民政厅</option>
                        <option value="浙江省环境保护厅">浙江省环境保护厅</option>
                    </select>
                    <input type="button" value="查询" id="search" class="ipt-btn ml50">
                </p>
            </div>
            </form>
            <table cellpadding="0" cellspacing="0" class="table-common">
                <thead>
                <tr>
                    <th width="40">序号</th>
                    <th width="116">信息来源部门</th>
                    <th width="122">反馈类型</th>
                    <th width="66">年度</th>
                    <th width="180">信息类别</th>
                    <th width="80">接收条数</th>
                    <th width="148">本部门实际处理条数</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody  id="table_page">
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
<div class="mod">
    <div class="footer-box">
        <div class="footer">
            <p>版权所有：浙江省工商行政管理局</p>
			<p>年报公示业务咨询电话：400-888-4636（年报）&nbsp;&nbsp;&nbsp;&nbsp;技术支持电话：400-888-4636（公示）&nbsp;&nbsp;&nbsp;&nbsp;京ICP备16053442号-1</p>        </div>
    </div>
</div>
<script id="table_list" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{xh @index}}</td>
        <td>{{inputDepCode}}</td>
        <td>联合惩戒反馈信息</td>
        <td>{{year}}</td>
        <td>{{msgType}}</td>
        <td>{{num}}</td>
        <td>{{realNum}}</td>
        <td><a href="javascript:void(0)" class="edit" id="{{id}}">{{state realNum}}</a></td>
    </tr>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/sjyyfk_list.js"></script>
</body>
</html>