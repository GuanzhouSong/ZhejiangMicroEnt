<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title>企业抽查检查提醒</title>
<link rel="stylesheet" href="/css/sccheck/style.css">
<link rel="stylesheet" href="/css/reg.client.css">

</head>
<body style="background-color: #fbf7e6;">
    <div class="c-remind-wrap">
        <div class="c-remind-head">

        </div>
        <div class="c-remind-body">
            <div class="c-r-b-wrap">
                <div class="c-r-title">
                    <h2>企业抽查检查提醒</h2>
                    <p class="c-r-date">发送日期：<span class="span_sendDate"></span></p>
                    <p class="c-r-tel">联系客服  400-888-4636</p>
                    <p class="c-r-msg">您担任联络员的<span class="c-r-red">${fn:length(pList)}</span>家企业在<fmt:formatDate value="${pList[0].estDate}" type="date" pattern="yyyy年MM月dd日"/>已被浙江省工商局抽中为“${pList[0].taskName}”工作的抽查检查对象。</p>
                    <p class="c-r-warn">请积极配合做好抽查准备工作</p>
                    <div class="c-r-content">
                        <h3>具体企业名称如下：</h3>
                        <ul>
                        <c:forEach items="${pList}" var="pubOpaDetail" varStatus="status">
                        	 <li>
                                <p class="con-title"><span>${status.count}、</span>${pubOpaDetail.entName }</p>
                                <p class="c-r-code">统一社会信用代码: <span> ${empty pubOpaDetail.uniCode?pubOpaDetail.regNO:pubOpaDetail.uniCode }</span></p>
                            </li>
                        </c:forEach> 
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="mod1366">
	<div class="footer-box">
	    <div class="mod footer">
	        <p>主办单位：浙江省工商行政管理局</p>
	        <p>地址：杭州市莫干山路77号金汇大厦北门&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：310005&nbsp;&nbsp;&nbsp;&nbsp;备案号：京ICP备16053442号</p>
	   		<p><a href="../../client/entsearch/contact">业务咨询与技术支持联系方式</a></p>
	    </div>
	</div>
	</div>
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scresult/sccheckmessage_view.js"></script>
<%-- <script src="${scCheckDomain}/js/lib/hx_mms.min.js"></script> --%>
<script type="text/javascript">
 (function() {
        window._hx_mms_server_=  "${scCheckDomain}"; 
        var hm = document.createElement("script");
        hm.src = window._hx_mms_server_+"/js/lib/hx_mms.min.js";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
 </script>
</html>