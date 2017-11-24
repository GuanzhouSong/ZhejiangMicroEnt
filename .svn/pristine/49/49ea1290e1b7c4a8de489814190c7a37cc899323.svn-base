<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>列入经营异常名录信息</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>
<jsp:include page="../../common/basicheader.jsp"></jsp:include>

<div class="mod detail-main">
 <input type="hidden" name="encryPriPID" id="encryPriPID" value="${entBasicInfo.encryPriPID }"/>
<form id="params">
   <input type="hidden" name="priPID" id="priPID" value="${entBasicInfo.priPID}"/>
</form>
    <div class="tab-panel">
    	<!-- 企业、农专经营异常信息 -->
    	<c:if test="${entBasicInfo.entTypeCatg != '50'}">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>列入经营异常名录信息
            </h3>
            <table class="table-common table-chufa mb20">
                <thead>
                <tr>
                    <th width="35">序号</th>
                    <th width="220">纳入经营异常名录原因</th>
                    <th width="105">列入日期</th>
                    <th width="140">作出决定机关（列入）</th>
                    <th width="250">移出经营异常名录原因</th>
                    <th width="105">移出日期</th>
                    <th>作出决定机关（移出）</th>
                </tr>
                </thead>
                <tbody id="_opanomaly">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_opanomalyItemCount"></em> 条信息，共 <em id="_opanomalyPageCount"></em> 页</span>
                <div id="_opanomalyPagination" class="pagination">
                </div>
            </div>
        </div>
        </c:if>
        <!-- 个体户经营异常信息 -->
        <c:if test="${entBasicInfo.entTypeCatg == '50'}">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>列入经营异常名录信息
            </h3>
            <table class="table-common table-chufa mb20">
                <thead>
                <tr>
                    <th width="35">序号</th>
                    <th width="220">标记经营异常状态原因</th>
                    <th width="105">标记日期</th>
                    <th width="140">作出决定机关（标记）</th>
                    <th width="250">恢复正常记载状态原因</th>
                    <th width="105">恢复日期</th>
                    <th>作出决定机关（恢复）</th>
                </tr>
                </thead>
                <tbody id="_pbopanomaly">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_pbopanomalyItemCount"></em> 条信息，共 <em id="_pbopanomalyPageCount"></em> 页</span>
                <div id="_pbopanomalyPagination" class="pagination">
                </div>
            </div>
        </div>
        </c:if>
    </div>
</div>
<script>
    //参数的传递
    window._CONFIG = {
    		entTypeCatg:'${entBasicInfo.entTypeCatg}'
    }
</script>
<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
    var jiathis_config = {
        url:'http://118.178.31.19/client/entsearch/toEntSearch?entName='+'${hx:encodeYear(entBasicInfo.entName)}',
        title:"国家企业信用信息公示系统",
        summary:'',
        desc:'',
        data_track_clickback:false
    };
</script>
<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
<script type="text/javascript" src="http://v3.jiathis.com/code/plugin.client.js" charset="utf-8"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/entinfo/anomaly_main.js"></script>
<script src="<c:url value='/js/pub/entinfo/sendPdf.js'/>"></script>
<%--信息分享--%>
<script src="/js/pub/entinfo/information_share.js"></script>
<script id="opanomaly-table-template" type="text/x-handlebars-template">
    		{{#each data}}
    		<tr>
        		<td>{{xh @index}}</td>
        		<td>{{speCauseCN}}</td>
        		<td>{{abnTime abnTime}}</td>
				<td>{{decorgCN}}</td>
        		<td>{{remExcpresCN}}</td>
				<td>{{remDate remDate}}</td>
				<td>{{reDecOrgCN}}</td>
    		</tr>
    		{{/each}}
</script>
<script id="pbopanomaly-table-template" type="text/x-handlebars-template">
    		{{#each data}}
    		<tr>
        		<td>{{xh @index}}</td>
        		<td>{{excpStaResCN}}</td>
        		<td>{{cogDate cogDate}}</td>
				<td>{{decorgCN}}</td>
        		<td>{{norReaCN}}</td>
				<td>{{norDate norDate}}</td>
				<td>{{norDecOrgCN}}</td>
    		</tr>
    		{{/each}}
</script>
<script>
    $('.company-basic .title .tip').on('click',function(){
        $('.exceptionlist-layer').show();
        $('.exceptionlist-layer .close').click(function(){
            $(this).parent().hide();
        })
    })
</script>
<script type="text/javascript" src="http://fwtj.gsxt.gov.cn/js/logcollector.js?nodenum=330000"></script>
<script>
    window.onload = function () {
        var sessionId = '<%=request.getSession().getId()%>';
        sessionId_gsxt = sessionId; // 正常情况JS可以拿到sessionId,但经过测试发现有些web服务器，js拿不到sessionId，这种情况需要手动对sessionId进行赋值，如sessionId_gsxt=${sessionId}
        var entName = '${entBasicInfo.entName }';
        try{
	        t1Collect_gsxt(); // 收集访问信息，每个页面都需要调用该方法
	        t2Collect_gsxt(entName); // 企业详情页收集被访问的企业名称，当用户进入企业详情页时，调用该方法，并将企业完整名称作为该方法的入参
        }catch(e){
        	
        }
    }
</script>
</body>
</html>