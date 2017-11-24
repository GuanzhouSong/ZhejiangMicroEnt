<%--
  Created by IntelliJ IDEA.
  User: dxh
  Date: 2017/2/22
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>小微企业名录</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/smallent.css"/>"/>
</head>
<body>
<div class="header">
    <h1 class="logo"></h1>
    <span class="logo_text">（浙江）</span>
</div>
<div class="nav">
    <ul class="nav_list">
        <li>
            <a href="http://xwqy.gsxt.gov.cn/home?df=33" >
                <i class="i_n1"></i>
                <span>首页</span>
            </a>
        </li>
        <li>
            <a href="http://xwqy.gsxt.gov.cn/home/mirco/info_list?channelId=2200&organId=33" >
                <i class="i_n2"></i>
                <span>扶持政策集中公示</span>
            </a>
        </li>
        <li>
            <a href="http://xwqy.gsxt.gov.cn/home/mirco/info_list?channelId=2300&organId=33" >
                <i class="i_n3"></i>
                <span>申请扶持导航</span>
            </a>
        </li>
        <li class="default">
            <a href="<c:url value="/pub/smallentsupport/index"/>" >
                <i class="i_n4"></i>
                <span>企业享受扶持信息公示</span>
            </a>
        </li>
        <li>
            <a href="<c:url value="/pub/smallentdir/index"/>" >
                <i class="i_n5"></i>
                <span>小微企业库</span>
            </a>
        </li>
    </ul>
</div>
<div class="mainbody">
    <h2 class="bread_crumbs">当前位置：<a href="">首页</a> > <a href="">企业享受扶持信息公示</a></h2>
    <div class="main_left">
        <h3 class="mlf_title">区域选择</h3>
        <table class="mlf_area" id="select_area">
            <tr>
                <td>
                    <a href="javascript:void(0)" class="selectCode cur" data-code="">浙江省:</a><br>
                    <a href="javascript:void(0)" class="selectCode" data-code="3301" >杭州市</a>&nbsp;
                    <a href="javascript:void(0)" class="selectCode" data-code="3302" >宁波市</a>&nbsp;
                    <a href="javascript:void(0)" class="selectCode" data-code="3303" >温州市</a><br>

                    <a href="javascript:void(0)" class="selectCode" data-code="3304" >嘉兴市</a>&nbsp;
                    <a href="javascript:void(0)" class="selectCode" data-code="3305" >湖州市</a>&nbsp;
                    <a href="javascript:void(0)" class="selectCode" data-code="3306" >绍兴市</a><br>

                    <a href="javascript:void(0)" class="selectCode" data-code="3307" >金华市</a>&nbsp;
                    <a href="javascript:void(0)" class="selectCode" data-code="3308" >衢州市</a>&nbsp;
                    <a href="javascript:void(0)" class="selectCode" data-code="3309" >舟山市</a><br>

                    <a href="javascript:void(0)" class="selectCode" data-code="3310" >台州市</a>&nbsp;
                    <a href="javascript:void(0)" class="selectCode" data-code="3325" >丽水市</a>&nbsp;&nbsp;

                </td>
            </tr>
        </table>
    </div>
    <div class="main_right">
        <div class="mr_box">
            <div class="mr_search">
                <input style="width:760px" type="text" class="search_input" value="" placeholder="请输入企业名称或统一社会信用代码或注册号"/>
                <input type="button" id="popup-submit"  class="search_btn" value="搜索"/>
            </div>
            <div class="mr_result">
                <table class="mr_list">
                    <thead>
                    <tr>
                        <th>企业名称</th>
                        <th>注册号/统一<br/>社会信用代码</th>
                        <th>内容</th>
                        <th>部门</th>
                        <th>日期</th>
                    </tr>
                    </thead>
                    <tbody id="supportList">

                    </tbody>
                </table>

                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到<em id="tody_total">0</em>条信息，共<em id="tody_pageNum">0</em>页</span>
                    <div id="tody_pagination" class="pagination"></div>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>

    <div class="footer">
        <p>版权所有：浙江省工商行政管理局</p>
        <p>地址：杭州市莫干山路77号金汇大厦北门&nbsp;&nbsp;邮政编码：310005</p>
    </div>
</div>

<%--极客校验 start --%>
<div id="popup-captcha"></div>
<%--极客校验 start --%>

<script id="supportTemplate" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td class="td_1"><a href="javascript:void(0)" class="doView" data-pripid="{{priPID}}" title="{{entName}}" >{{substr entName}}</a></td>
        <td >{{regNO}}</td>
        <td class="td_2"><span>{{substr enjSpContent}}</span></td>
        <td class="td_cc">{{impSpDepart}}</td>
        <td class="td_cc">{{impSpDate}}</td>
    </tr>
    {{/each}}
</script>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="http://static.geetest.com/static/tools/gt.js"></script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/pub/smallent/smsupport_main.js"/>"></script>


</body>
</html>