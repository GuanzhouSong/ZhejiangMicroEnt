<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>即时信息股东及出资修改记录页面</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>
<!-- 公司基本信息 -->
<div class="mod company-basic clearfix">
    <div class="thumbnail">
        <img src="../../../../img/pub/thumbnail.png" alt="">
    </div>
    <div class="caption">
        <h3 class="title">${entBasicInfo.entName }
            <c:if test="${entBasicInfo.regState=='K'||entBasicInfo.regState=='A'||entBasicInfo.regState=='B'}">
                <span class="icon-rectangle icon-blue">存续</span>
            </c:if>
            <c:if test="${entBasicInfo.regState=='DA'}">
                <span class="tip">（该企业被列入经营异常名录）</span>
                <span class="icon-rectangle icon-red">吊销未注销</span>
            </c:if>
            <c:if test="${entBasicInfo.regState=='D'}">
                <span class="tip">（该企业被列入经营异常名录）</span>
                <span class="icon-rectangle icon-gray">吊销</span>
            </c:if>
        </h3>
        <p>
            <i class="icon-book"></i>统一社会信用代码/注册号：<span>${entBasicInfo.regNO }</span>
        </p>
        <p>
            <i class="icon-person"></i>法定代表人：<span>${entBasicInfo.leRep }</span>
        </p>
        <p>
            <i class="icon-local"></i>住所：<span>${entBasicInfo.dom }</span>
        </p>
        <p>
            <i class="icon-date"></i>成立日期：<span>${fn:substring(entBasicInfo.estDate,0,10)}</span>
        </p>
    </div>
    <div class="btn-box">
        <a href="#"><i class="icon-send"></i>发送报告</a>
        <a href="#"><i class="icon-share"></i>信息分享</a>
    </div>
</div>

<!-- tab -->
<div class="mod company-tab">
    <ul class="tab-list">
        <li>
            <a href="../../entinfo/baseinfo?encryPriPID=${entBasicInfo.encryPriPID }">基本信息</a>
        </li>
        <c:choose>  
		    <c:when test="${entBasicInfo.entTypeCatg==16||entBasicInfo.entTypeCatg==17||entBasicInfo.entTypeCatg==50}"> 
		    </c:when>  
		    <c:otherwise>
		        <li>
		            <a href="../../entinfo/iminfo?encryPriPID=${entBasicInfo.encryPriPID }" class="current">企业即时信息</a>
		        </li>
		    </c:otherwise>
	    </c:choose>
        <li>
            <a href="../../entinfo/yrinfo?encryPriPID=${entBasicInfo.encryPriPID }&id=1">
            <c:choose>  
			    <c:when test="${entBasicInfo.entTypeCatg==16||entBasicInfo.entTypeCatg==17}"> 
					农专年报信息
			    </c:when>  
			    <c:when test="${entBasicInfo.entTypeCatg==50}">  
					个体户年报信息
			    </c:when>  
			    <c:otherwise>
					企业年报信息
			    </c:otherwise>
		    </c:choose>
            </a>
        </li>
        <li>
            <a href="../../entinfo/anomalyinfo?encryPriPID=${entBasicInfo.encryPriPID }">警示信息</a>
        </li>
        <li>
            <a href="../../entinfo/otherinfo?encryPriPID=${entBasicInfo.encryPriPID }">其他信息</a>
        </li>
        <li>
            <a href="../../entinfo/featureinfo?encryPriPID=${entBasicInfo.encryPriPID }">地方特色信息</a>
        </li>
    </ul>
</div>

<div class="mb20">
    <!-- 股东及出资信息 -->
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <div class="tip">
                <input type="hidden" id="priPID" value="${priPID}">
                企业即时信息由该企业提供，企业对其即时信息的真实性、合法性负责
            </div>
            <h3 class="i-title">
                <i></i>股东及出资信息
                <a href="#" class="more">查看修改记录>></a>
            </h3>
            <table class="table-common table-gudong-imme table-nest" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th>
                        股东
                    </th>
                    <th>
                        认缴额(万元)
                    </th>
                    <th>
                        实缴额(万元)
                    </th>
                    <th valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td colspan="4">实缴明细</td>
                            </tr>
                            <tr>
                                <td width="28%">认缴<br/>出资方式</td>
                                <td width="30%">认缴出资额<br/>（万元）</td>
                                <td width="28%">认缴<br/>出资日期</td>
                                <td>公示<br/>状态</td>
                            </tr>
                        </table>
                    </th>
                    <th valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td colspan="4">认缴明细</td>
                            </tr>
                            <tr>
                                <td width="28%">实缴出资方式</td>
                                <td width="30%">实缴出资额<br/>（万元）</td>
                                <td width="28%">实缴<br/>出资日期</td>
                                <td>公示<br/>状态</td>
                            </tr>
                        </table>
                    </th>
                    <th>详情</th>

                </tr>

                </thead>
                <tbody id="investment">

                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="investmentCount"></em>条信息，共<em
                        id="investmentPageCount"></em>页</span>

                <div id="pageinvestment" class="pagination">

                </div>
            </div>
        </div>
    </div>

    <!-- 股权变更信息 -->
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>股权变更信息
                <a href="#" class="more">查看修改记录&gt;&gt;</a>
            </h3>
            <table class="table-common">
                <thead>
                <tr>
                    <th width="80">
                        序号
                    </th>
                    <th width="200">
                        股东
                    </th>
                    <th width="200">
                        变更前股权比例
                    </th>
                    <th width="170">
                        变更后股权比例
                    </th>
                    <th width="150">
                        股权变更日期
                    </th>
                    <th>
                        公示日期
                    </th>
                </tr>
                </thead>
                <tbody id="invsral">

                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到  <em id="invsralCount"></em>条信息，共<em id="invsralPageCount"></em>页</span>
                <div id="paginvsral" class="pagination">

                </div>
            </div>
        </div>
    </div>

    <!-- 行政许可信息 -->
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>行政许可信息
            </h3>
            <table class="table-common">
                <thead>
                <tr>
                    <th width="46">
                        序号
                    </th>
                    <th width="130">
                        许可文件编号
                    </th>
                    <th width="130">
                        许可文件名称
                    </th>
                    <th width="110">
                        有效期自
                    </th>
                    <th width="110">
                        有效期至
                    </th>
                    <th width="150">
                        许可机关
                    </th>
                    <th width="150">
                        许可内容
                    </th>
                    <th width="50">
                        状态
                    </th>
                    <th>
                        详情
                    </th>
                </tr>
                </thead>
                <tbody id="permit">
              
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="permitCount"></em> 条信息，共<em id="permitPageCount"></em>页</span>
                <div id="pagepermit" class="pagination">

                </div>
            </div>
        </div>
    </div>

    <!-- 知识产权出质登记信息 -->
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>知识产权出质登记信息
            </h3>
            <table class="table-common">
                <thead>
                <tr>
                    <th width="35">
                        序号
                    </th>
                    <th width="170">
                        注册号/统一社会信用代码
                    </th>
                    <th width="80">
                        名称
                    </th>
                    <th width="70">
                        种类
                    </th>
                    <th width="92">
                        出质人名称
                    </th>
                    <th width="92">
                        质权人名称
                    </th>
                    <th width="210">
                        质权登记期限
                    </th>
                    <th width="35">
                        状态
                    </th>
                    <th width="100">
                        公示日期
                    </th>
                    <th>
                        详情
                    </th>
                </tr>
                </thead>
                <tbody id="ippldg">
                 
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="ippldgCount"></em> 条信息，共<em id="ippldgPageCount"></em>页</span>
                <div id="pageippldg" class="pagination">

                </div>
            </div>
        </div>
    </div>

    <!-- 行政处罚信息 -->
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>行政处罚信息
            </h3>
            <table class="table-common table-chufa">
                <thead>
                <tr>
                    <th width="35">
                        序号
                    </th>
                    <th width="155">
                        决定书文号
                    </th>
                    <th width="155">
                        违法行为类型
                    </th>
                    <th width="130">
                        行政处罚内容
                    </th>
                    <th width="155">
                        决定机关名称
                    </th>
                    <th width="110">
                        处罚决定日期
                    </th>
                    <th width="110">
                        公示日期
                    </th>
                    <th>
                        备注
                    </th>
                    <th>
                        详情
                    </th>
                </tr>
                </thead>
                <tbody id="case">
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        京工商处字2012第1号
                    </td>
                    <td>
                        京工商处字2012第1号
                    </td>
                    <td>
                        罚款100万
                    </td>
                    <td>
                        北京市工商行政管理局
                    </td>
                    <td>2013年12月1日</td>
                    <td>2013年12月1日</td>
                    <td rowspan="2">复议结束</td>
                </tr>
                <tr>
                    <td colspan="7" class="tip2">
                        <div class="fl">有变更情形：</div>
                        <div class="fl">
                            <p>1、北京市工商行政管理局2013年5月4日将行政复议罚款金额由100万变更为50万。</p>
                            <p>2、北京市工商行政管理局2012年3月4日将行政复议罚款金额由50万变更为60万</p>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="caseCount"></em> 条信息，共<em id="casePageCount"></em>页</span>
                <div id="pagecase" class="pagination">

                </div>
            </div>
        </div>
    </div>

</div>

<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/pub/client/investalter/edit_main.js"/>"></script>
<script id="investment-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{inv}}</td>
        <td>{{liSubConAm}}</td>
        <td>{{liAcConAm}}</td>
        <td valign="top">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody> {{#with imInvactdetailList}} {{#each this}}
                <tr>
                    <td width="28%">{{acConFormCn}}</td>
                    <td width="30%">{{acConAm}}</td>
                    <td width="28%">{{transDate conDate}}</td>
                    <td>{{trsPubFlag pubFlag}}</td>
                </tr>
                {{/each}} {{/with}}
                </tbody>
            </table>
        </td>
        <td valign="top">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody> {{#with imInvprodetailList}} {{#each this}}
                <tr>
                    <td width="28%">{{conFormCN}}</td>
                    <td width="28%">{{subConAm}}</td>
                    <td width="28%">{{transDate conDate}}</td>
                    <td width="28%">{{trsPubFlag pubFlag}}</td>
                </tr>
                {{/each}} {{/with}}
                </tbody>
            </table>

        </td>
        <td><a href="#" id="{{invID}}" class="showInvesment">查看</a></td>

    </tr>
    {{/each}}
</script>
<!-- 股权变更 -->
<script id="invsral-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{addOne @index}}</td>
        <td> {{inv}}</td>
        <td> {{beTransAmPr}}%</td>
        <td> {{afTransAmPr}}%</td>
        <td> {{transDate equAltDate}}</td>
        <td> {{dataFormat publicDate}}</td>
    </tr>
    {{/each}}
</script>
<!-- 行政许可 -->
<script id="permit-template" type="text/x-handlebars-template">
    {{#each data}}

    <tr>
        <td> {{addOne @index}}</td>
        <td> {{licNO}}</td>
        <td>{{licNameCN}}</td>
        <td>{{transDate valFrom}}</td>
        <td> {{transDate valTo}}</td>
        <td>{{licAnth}}</td>
        <td>{{licItem}}</td>
        <td>{{transPubType pubType}}</td>
        <td><a href="#" id="{{licID}}" class="showPermit">查看</a></td>
    </tr>

    {{/each}}
</script>

<!--知识产权 -->

<script id="ippldg-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{addOne @index}}</td>
        <td>{{regNO}}</td>
        <td>{{tmname}}</td>
        <td>{{kinds}}</td>
        <td> {{pledgor}}</td>
        <td>{{impOrg}}</td>
        <td>{{transDate pleRegPerFrom}}-{{transDate pleRegPerTo}}</td>
        <td>{{transType pubType}}</td>
        <td>{{dataFormat publicDate}}</td>
        <td><a href="#">查看</a></td>
    </tr>

    {{/each}}
</script>
<!-- 行政处罚 -->

<script id="case-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td> {{addOne @index}}</td>
        <td>{{penDecNo}}</td>
        <td>{{illegActType}}</td>
        <td>{{penContent}}</td>
        <td>{{judAuth}}</td>
        <td>{{transDate penDecIssDate}}</td>
        <td>{{dataFormat publicDate}}</td>
        <td>{{ penContent}}</td>
        <td><a href="#" id="{{caseNO}}" class="showCase">查看</a></td>
    </tr>

    {{/each}}


</script>


<!-- <script>
    $('#pagination').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });

    $('#pagination2').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });

    $('#pagination3').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });

    $('#pagination4').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });

    $('#pagination5').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        c urrent_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });

    $('#pagination6').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });
</script> -->
</body>
</html>