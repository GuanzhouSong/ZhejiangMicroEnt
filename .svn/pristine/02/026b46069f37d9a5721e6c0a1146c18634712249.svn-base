<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>严重违法失信企业黑名单</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>
<jsp:include page="../../common/basicheader.jsp"></jsp:include>

<div class="mod detail-main">
    <div class="tab-panel">
        <!-- 严重违法失信企业名单（黑名单）信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>列入严重违法失信企业名单信息
            </h3>
            <table class="table-common table-chufa mb20">
                <thead>
                <tr>
                    <th width="35">
                        序号
                    </th>
                    <th width="70">
                        类别
                    </th>        
                    <th width="185">
                        列入严重违法失信企业名单（黑名单）原因
                    </th>
                    <th width="115">
                        列入日期
                    </th>
                    <th width="120">
                        作出决定机关（列入）
                    </th>
                    <th width="185">
                        移出严重违法失信企业名单（黑名单）原因
                    </th>
                    <th width="115">
                        移出日期
                    </th>
                    <th>
                        作出决定机关（移出）
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_punishItemCount">0</em> 条信息，共 <em id="_punishPageCount">0</em> 页</span>
                <div id="_punishPagination" class="pagination">
                </div>
            </div>
        </div>
    </div>
</div>


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
<script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
<%--信息分享--%>
<script src="/js/pub/entinfo/information_share.js"></script>
<script src="../../../../js/lib/pagination/jquery.pagination.js"></script>
<script type="text/javascript" src="http://fwtj.gsxt.gov.cn/js/logcollector.js?nodenum=330000"></script>
<%--发送报告 --%>
<script src="/js/pub/entinfo/sendPdf.js" ></script>
 
<script>
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
</script>
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