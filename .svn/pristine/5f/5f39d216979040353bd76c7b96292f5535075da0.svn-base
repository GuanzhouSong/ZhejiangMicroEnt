<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>严重违法失信企业名单</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<jsp:include page="common/header.jsp"></jsp:include>
<div class="mod clearfix">
    <jsp:include page="common/menu.jsp?module=sgz&menu=qymd"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)">信息接收</a> &gt;
            <a href="javascript:void(0)" class="cur">严重违法失信企业名单</a>
        </div>
        
        <div class="pdlr5">
            <div class="search-box filter-item mb10">
                <label>企业名称：</label>
                <input type="text" id="entName" class="ipt-txt2">
                <label>统一社会信用代码/注册号：</label>
                <input type="text" id="uniSCID" class="ipt-txt2">
                <input type="button" id="search" value="搜索" class="ipt-btn">
            </div>
            
            <div class="table-title">
            <p id="downinfo"></p>
                <input type="button" value="下载" class="ipt-btn  fr mr20 mb3 js-batchdownload js-export">
            </div>
            
            <table cellpadding="0" cellspacing="0" class="table-common" id="pubdtinfoTable">
                <thead>
                <tr id="trTitle">
                    <th width="24"><input class="chbAll" type="checkbox"/></th>
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

            <div class="encounter-layer" style="display:none">
                <h3 class="i-title">
                    <i></i>照面信息
                </h3>
                <ul class="encounter-info clearfix">
                    <li>
                        <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
                        <span>91330183699844628C</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>企业名称：</span>
                        <span>杭州富阳大凯房产经纪有限公司</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>类型：</span>
                        <span>私营有限责任公司(自然人控股或私营性质企业控股)</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>法定代表人：</span>
                        <span>骆明霞</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>注册资本：</span>
                        <span>200.0万人民币</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                        <span>2010年03月11日</span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>营业期限自：
                        </span>
                        <span>2010年03月11日</span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>营业期限至：
                        </span>
                        <span>2030年03月10日</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                        <span>杭州市富阳区市场监督管理局</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                        <span>2016年02月25日</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>住所：</span>
                        <span>杭州富阳区银湖街道富闲路9号银湖创新中心7号4层465室</span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记状态：</span>
                        <span>存续</span>
                    </li>
                    <li class="width-per100">
                        <span class="title right qyzc-info"><em>• </em>经营范围：</span>
                        <span>服务：房屋中介、房屋租赁、房地产信息咨询、代办房屋所有权证。房屋中介、房屋租赁、房地产信息咨询、代办房屋所有权证。房屋中介、房屋租赁、房地产信息咨询、代办房屋所有权证。房屋中介、房屋租赁、房地产信息咨询、代办房屋所有权证。</span>
                    </li>
                </ul>
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
 <form id="excelform" method="post" action="/depsyn/loadToExcel">
 <input type="hidden" id="cellInfo" name="cellInfo" />
 <input type="hidden" id="cellTitle" name="cellTitle" />
 <input type="hidden" id="fileName" name="fileName" />
 </form>
<script id="pubdtinfo_list" type="text/x-handlebars-template">
    {{#each data}}
    <tr id="tr{{id}}">
        <td><input type="checkbox" class="chb" downState="{{downState}}" priPID ="{{priPID}}" value="{{id}}"></td>
        <td>{{xh @index}}</td>
        <td><a priPID ="{{priPID}}" style="cursor: pointer;text-decoration:none;">{{entName}}</a></td>
        <td><a priPID ="{{priPID}}" style="cursor: pointer;text-decoration:none;">{{uniSCID}}</a></td>
        <td>{{estDate}}</td>
        <td>{{addSecNo}}</td>
        <td>{{abnTime}}</td>
        <td>{{addSecCause}}</td>
        <td>{{addSecOrg}}</td>
        <td>{{downStateDesc}}</td>
    </tr>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/yzwf_list.js"></script>
</body>
</html>