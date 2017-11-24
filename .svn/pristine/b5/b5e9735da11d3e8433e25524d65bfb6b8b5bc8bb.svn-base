<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="nowdate" class="java.util.Date" />
<fmt:formatDate var="nowyear" value="${nowdate}" pattern="yyyy"/> 
<fmt:formatDate var="duedate" value="${nowdate}" pattern="MMdd"/>
<!DOCTYPE html>
<html>
<head>
    <title>年报填写页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<!-- 头部 -->
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="banner-bg">
    <div class="mod banner">
        <h4>欢迎您！${midBaseInfoDto.entName}</h4>
        <p>
        	<em class="js-show-tips show-tips fr" data-component="dropDown" data-trigger="toggle" data-target=".js-fold-msg">收起年报信息<i class="tiny-icon"></i></em>
        	<em class="register-office">登记机关：${midBaseInfoDto.regOrgName}</em>
        	<c:if test="${!empty midBaseInfoDto.uniCode}"><em>统一社会信用代码：${midBaseInfoDto.uniCode}</em></c:if>
            <em>注册号：${midBaseInfoDto.regNO}</em>
        </p>
        <p class="warn-txt">敬请下载安装<span>“联连”企业信用信息警示软件</span>，第一时间获取企业信用警示提示。避免消息滞后，延误处理，影响贵企业的信用状况</p>
        <%--<a href="##"  target="_blank" class="download btn-icon"><h5>安装客户端软件</h5><span>第一时间获取预警信息推送</span></a>--%>
    </div>
</div>
<div class="fold-msg-bg js-fold-msg">
    <div class="mod state-msg">
        <em class="ann-rep">
            <span class="pdb16"><label>年报年度：</label>${yrRegCheck.year}年度</span>
            <span>
            	<label>
	            	<c:if test="${!empty yrRegCheck.firstReportTime}">
	            	首次提交：<fmt:formatDate value="${yrRegCheck.firstReportTime}" pattern="yyyy年MM月dd日"/>
	            	</c:if>
            	</label>
            </span>
        </em>
        <em class="rep-state">
            <span class="pdb16">
                <label>年度报告状态：</label><strong class="<c:if test="${yrRegCheck.isReported == '0'}">light</c:if>">${yrRegCheck.isReportedClientDesc}</strong>
            </span>
            <span>
            	<label>
            		<c:if test="${!empty yrRegCheck.lastReportTime}">
            		最近修改：<fmt:formatDate value="${yrRegCheck.lastReportTime}" pattern="yyyy年MM月dd日"/>
            		</c:if>
            	</label>
            </span>
        </em>
        <em class="pub-state bdnone w147">
            <span class="pdb16"><label>公示状态：</label>
                <strong class="word-expand <c:if test="${yrRegCheck.reportState == '12' || yrRegCheck.reportState == '13'}">light</c:if>">${yrRegCheck.reportStateClientDesc}</strong>
            </span>
            <span><label>历次年报公示记录：</label><a href="<c:url value="/reg/client/yr/ent/pubprint/readReportPage"/>?year=${year}&pripid=${pripid}"  target="_blank">查看</a></span>
        </em>
    </div>
</div>

<div class="mod caiwu">
    <div class="mod-hd">
        <div class="links">
	        <c:if test="${yrRegCheck.reportState == '10' || yrRegCheck.reportState == '11'}">
				<!--申请修改年度报告（6月30日后 或者 之前年度）-->
				<c:if test="${duedate > 0630 || yrRegCheck.year < nowyear -1}">
					<a href="javascript:void(0);" class="first" id="modapply">申请修改年度报告</a>
				</c:if>
				<!--修改年度报告（6月30日前）-->
				<c:if test="${duedate <= 0630}">
					<a href="javascript:void(0);" class="first" id="mod">修改年度报告</a>
				</c:if>
			</c:if>

			<c:if test="${yrRegCheck.isReported == '1' || yrRegCheck.isReported == '2'}">
             <a  href="<c:url value="/reg/client/yr/ent/pubprint/showReportProvePage"/>?year=${year}&pripid=${pripid}&printFalg=1"  target="_blank">查看与打印年度报告</a>&nbsp;&nbsp;
             <a  href="#"  id="printReportProve">打印年度报告证明</a>
           </c:if>

        </div>
        <div class="tips">
            <span class="txt">报表中背景颜色为</span>
            <span class="blockage"></span>
            <span class="txt">的内容经选择公示后将公示于企业信用信息公示系统</span>
        </div>
        <div class="btn-box">
        	<c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">
            <input class="btn-report" type="button" value="预览并提交年报"/>
            </c:if>
        </div>
        <ul class="tabs-nav">
            <c:forEach  items="${reportTypeList}" var="repName">
            <c:if test="${repName == 'subcapital'}">
                <li class="_items " data-url="<c:url value="/reg/client/yr/subcapital/show"/>?year=${year}&pripid=${pripid}">
                    <a href="javascript:void(0);">出资情况（<c:if test="${yrForm.subcapital == '1'}"><strong class="blue">已填报</strong></c:if><c:if test="${yrForm.subcapital != '1'}"><strong class="light">待填报</strong></c:if>）</a>
                </li>
            </c:if>

            <c:if test="${repName == 'asset'}">
                <li class="_items" data-url="<c:url value="/reg/client/yr/ent/yrasset/show"/>?year=${year}&pripid=${pripid}">
                    <a href="javascript:void(0);">资产状况（<c:if test="${yrForm.asset == '1'}"><strong class="blue">已填报</strong></c:if><c:if test="${yrForm.asset != '1'}"><strong class="light">待填报</strong></c:if>）</a>
                </li>
            </c:if>
            <c:if test="${repName == 'otherinfo'}">
                <li class="_items" data-url="<c:url value="/reg/client/yr/ent/yrotherinfo/show"/>?year=${year}&pripid=${pripid}">
                    <a href="javascript:void(0);">其他情况（<c:if test="${yrForm.otherinfo == '1'}"><strong class="blue">已填报</strong></c:if><c:if test="${yrForm.otherinfo != '1'}"><strong class="light">待填报</strong></c:if>）</a>
                </li>
            </c:if>
            <c:if test="${repName == 'forguaranteeinfo'}">
                <li class="_items" data-url="<c:url value="/reg/client/yr/ent/forguarantee/show"/>?year=${year}&pripid=${pripid}">
                    <a href="javascript:void(0);">对外担保（<c:if test="${yrForm.forguaranteeinfo == '1'}"><strong class="blue">已填报</strong></c:if><c:if test="${yrForm.forguaranteeinfo != '1'}"><strong class="light">待填报</strong></c:if>）</a>
                </li>
            </c:if>

            <c:if test="${repName == 'forinvestment'}">
                <li class="_items" data-url="<c:url value="/reg/client/yr/ent/forinvestment/list"/>?year=${year}&pripid=${pripid}" >
                    <a href="javascript:void(0);">对外投资（<c:if test="${yrForm.forinvestment == '1'}"><strong class="blue">已填报</strong></c:if><c:if test="${yrForm.forinvestment != '1'}"><strong class="light">待填报</strong></c:if>）</a>
                </li>
            </c:if>
<%--
            <c:if test="${repName == 'assetbranch'}">
                <li class="_items" data-url="<c:url value="/reg/client/yr/ent/yrasset/show"/>?year=${year}&pripid=${pripid}">
                    <a href="javascript:void(0);">经营情况（<c:if test="${yrForm.assetbranch == '1'}"><strong class="blue">已填报</strong></c:if><c:if test="${yrForm.assetbranch != '1'}"><strong class="light">待填报</strong></c:if>）</a>
                </li>
            </c:if>--%>

            <c:if test="${repName == 'alterstockinfo'}">
                <li class="_items" data-url="<c:url value="/reg/client/yr/ent/alterstock/list"/>?year=${year}">
                    <a href="javascript:void(0);">股权转让（<c:if test="${yrForm.alterstockinfo == '1'}"><strong class="blue">已填报</strong></c:if><c:if test="${yrForm.alterstockinfo != '1'}"><strong class="light">待填报</strong></c:if>）</a>
                </li>
            </c:if>



            </c:forEach>
        </ul>
    </div>
</div>
<%--测试--%>
<div id="_content" style="text-align: center;">
    <iframe id="_frame" src="" frameborder="0" style="min-width: 1000px;" height="1000px"  scrolling="no"></iframe>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>


<script>
    //参数的传递
    window._CONFIG = {
            year:'${year}',
            mod_url: '<c:url value="/reg/client/yr/modapplication/ent/show"/>',
            preview_url: '<c:url value="/reg/client/yr/ent/pubpreview/show"/>'
    }

</script>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/yrwrite_home_main.js"/>"></script>
<script>
    /**
     * 更改填报的填报状态： 待填报 已填报
     */
    function change_text() {
        $(".active").children("a").children(".light").text("已填报");
        $(".active").children("a").children("strong").attr("class", "blue");
    };

</script>

</body>
</html>