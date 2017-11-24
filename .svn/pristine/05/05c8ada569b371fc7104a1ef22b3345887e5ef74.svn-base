<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业详情其它信息页面</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
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
		            <a href="../../entinfo/iminfo?encryPriPID=${entBasicInfo.encryPriPID }">企业即时信息</a>
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
            <a href="../../entinfo/otherinfo?encryPriPID=${entBasicInfo.encryPriPID }" class="current">其他信息</a>
        </li>
        <li>
            <a href="../../entinfo/featureinfo?encryPriPID=${entBasicInfo.encryPriPID }">地方特色信息</a>
        </li>
    </ul>
</div>

<div class="mb20">
    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <div class="tip">其他信息由政府各部门提供，信息的真实性准确性由政府各部门负责</div>
            <h3 class="i-title">
                <i></i>司法协助信息
                <a href="#" class="more">查看全部&gt;&gt;</a>
            </h3>
            <table class="table-common">
                <thead>
                <tr>
                    <th width="40">
                        序号
                    </th>
                    <th width="240">
                        被执行人
                    </th>
                    <th width="120">
                        股权数额
                    </th>
                    <th width="160">
                        执行法院
                    </th>
                    <th width="190">
                        执行通知书文号
                    </th>
                    <th width="130">
                        类型
                    </th>
                    <th>
                        详情
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        中至粮油有限责任公司
                    </td>
                    <td>
                        50万美元
                    </td>
                    <td>
                        北京法院
                    </td>
                    <td>
                        （2016）京02执字第264号
                    </td>
                    <td>股权冻结</td>
                    <td><a href="javascript:void(0);" class="js-punishdetail-view">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        中至粮油有限责任公司
                    </td>
                    <td>
                        50万美元
                    </td>
                    <td>
                        北京法院
                    </td>
                    <td>
                        （2016）京02执字第264号
                    </td>
                    <td>股权冻结</td>
                    <td><a href="javascript:void(0);" class="js-punishdetail-view">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        中至粮油有限责任公司
                    </td>
                    <td>
                        50万美元
                    </td>
                    <td>
                        北京法院
                    </td>
                    <td>
                        （2016）京02执字第264号
                    </td>
                    <td>股权冻结</td>
                    <td><a href="javascript:void(0);" class="js-punishdetail-view">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        中至粮油有限责任公司
                    </td>
                    <td>
                        50万美元
                    </td>
                    <td>
                        北京法院
                    </td>
                    <td>
                        （2016）京02执字第264号
                    </td>
                    <td>股权冻结</td>
                    <td><a href="javascript:void(0);" class="js-punishdetail-view">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        中至粮油有限责任公司
                    </td>
                    <td>
                        50万美元
                    </td>
                    <td>
                        北京法院
                    </td>
                    <td>
                        （2016）京02执字第264号
                    </td>
                    <td>股权冻结</td>
                    <td><a href="javascript:void(0);" class="js-punishdetail-view">查看</a></td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 885634 条信息，共234页</span>
                <div id="pagination" class="pagination">

                </div>
            </div>
        </div>
    </div>

    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>动产抵押登记信息
                <a href="#" class="more">查看全部&gt;&gt;</a>
            </h3>
            <table class="table-common">
                <thead>
                <tr>
                    <th width="40">
                        序号
                    </th>
                    <th width="120">
                        登记编号
                    </th>
                    <th width="130">
                        登记日期
                    </th>
                    <th width="240">
                        登记机关
                    </th>
                    <th width="150">
                        被担保债权数额
                    </th>
                    <th width="55">
                        状态
                    </th>
                    <th >
                        公示日期
                    </th>
                    <th width="55">
                        详情
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        12332451231
                    </td>
                    <td>
                        2012年9月9日
                    </td>
                    <td>
                        北京市海淀区工商行政管理局
                    </td>
                    <td>
                        30000 万元
                    </td>
                    <td>
                        有效
                    </td>
                    <td>
                        2012年9月9日
                    </td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        12332451231
                    </td>
                    <td>
                        2012年9月9日
                    </td>
                    <td>
                        北京市海淀区工商行政管理局
                    </td>
                    <td>
                        30000 万元
                    </td>
                    <td>
                        有效
                    </td>
                    <td>
                        2012年9月9日
                    </td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        12332451231
                    </td>
                    <td>
                        2012年9月9日
                    </td>
                    <td>
                        北京市海淀区工商行政管理局
                    </td>
                    <td>
                        30000 万元
                    </td>
                    <td>
                        有效
                    </td>
                    <td>
                        2012年9月9日
                    </td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        12332451231
                    </td>
                    <td>
                        2012年9月9日
                    </td>
                    <td>
                        北京市海淀区工商行政管理局
                    </td>
                    <td>
                        30000 万元
                    </td>
                    <td>
                        有效
                    </td>
                    <td>
                        2012年9月9日
                    </td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        12332451231
                    </td>
                    <td>
                        2012年9月9日
                    </td>
                    <td>
                        北京市海淀区工商行政管理局
                    </td>
                    <td>
                        30000 万元
                    </td>
                    <td>
                        有效
                    </td>
                    <td>
                        2012年9月9日
                    </td>
                    <td><a href="#">查看</a></td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 885634 条信息，共234页</span>
                <div id="pagination2" class="pagination">

                </div>
            </div>
        </div>
    </div>

    <div class="mod company-about">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>股权出质登记信息
                <a href="#" class="more">查看全部&gt;&gt;</a>
            </h3>
            <table class="table-common">
                <thead>
                <tr>
                    <th width="35">
                        序号
                    </th>
                    <th width="100">
                        登记编号
                    </th>
                    <th width="90">
                        出质人
                    </th>
                    <th width="100">
                        证照/证件号码
                    </th>
                    <th width="100">
                        出质股权数额
                    </th>
                    <th width="100">
                        质权人
                    </th>
                    <th width="100">
                        证照/证件号码
                    </th>
                    <th width="110">
                        股权出质设立登记日期
                    </th>
                    <th width="40">
                        状态
                    </th>
                    <th width="110">
                        公示日期
                    </th>
                    <th>
                        详情
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        12332451231
                    </td>
                    <td>
                        李耀刚
                    </td>
                    <td>
                        100000000032233
                    </td>
                    <td>
                        82.1415 万元
                    </td>
                    <td>
                        建设综合勘察研究设计院有限公司
                    </td>
                    <td>
                        100000000013874
                    </td>
                    <td>
                        2011年1月16日
                    </td>
                    <td>
                        有效
                    </td>
                    <td>
                        2011年1月16日
                    </td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        12332451231
                    </td>
                    <td>
                        李耀刚
                    </td>
                    <td>
                        100000000032233
                    </td>
                    <td>
                        82.1415 万元
                    </td>
                    <td>
                        建设综合勘察研究设计院有限公司
                    </td>
                    <td>
                        100000000013874
                    </td>
                    <td>
                        2011年1月16日
                    </td>
                    <td>
                        有效
                    </td>
                    <td>
                        2011年1月16日
                    </td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        12332451231
                    </td>
                    <td>
                        李耀刚
                    </td>
                    <td>
                        100000000032233
                    </td>
                    <td>
                        82.1415 万元
                    </td>
                    <td>
                        建设综合勘察研究设计院有限公司
                    </td>
                    <td>
                        100000000013874
                    </td>
                    <td>
                        2011年1月16日
                    </td>
                    <td>
                        有效
                    </td>
                    <td>
                        2011年1月16日
                    </td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        12332451231
                    </td>
                    <td>
                        李耀刚
                    </td>
                    <td>
                        100000000032233
                    </td>
                    <td>
                        82.1415 万元
                    </td>
                    <td>
                        建设综合勘察研究设计院有限公司
                    </td>
                    <td>
                        100000000013874
                    </td>
                    <td>
                        2011年1月16日
                    </td>
                    <td>
                        有效
                    </td>
                    <td>
                        2011年1月16日
                    </td>
                    <td><a href="#">查看</a></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        12332451231
                    </td>
                    <td>
                        李耀刚
                    </td>
                    <td>
                        100000000032233
                    </td>
                    <td>
                        82.1415 万元
                    </td>
                    <td>
                        建设综合勘察研究设计院有限公司
                    </td>
                    <td>
                        100000000013874
                    </td>
                    <td>
                        2011年1月16日
                    </td>
                    <td>
                        有效
                    </td>
                    <td>
                        2011年1月16日
                    </td>
                    <td><a href="#">查看</a></td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 885634 条信息，共234页</span>
                <div id="pagination3" class="pagination">

                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="../../../../js/lib/pagination/jquery.pagination.js"></script>
<script src="../../../../js/lib/layer/layer.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/entinfo/entinfo_main.js"></script>
<script>
    $(document).on('click','.js-punishdetail-view',function(){
        layer.open({
            isIframeAuto: true,  //如果iframe内容是异步获取不要传此参数
            type:2,
            shadeClose: true,
            closeBtn: 0,
            area: ['940px','700px'],
            title: false,
            content: '/ui/pub/infopublic/infodetail/punishdetail'
        })
    });

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
</script>
</body>
</html>