<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>打印年度报告证明页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    	<style media="print" type="text/css">
		.STYLE1 {
			font-size: 16px;
			font-weight: bold;
		}
		object { display: none}
		.Noprint{ display:none; }
		.PageNext{ page-break-after: always; clear: both; width: 100%}
	</style>

	<style type="text/css">
		.height40{
			height: 40px;
		}
	</style>
</head>
<body>
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <!-- <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a> -->
</div>
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
<div class="mod info-title">
    <h5 class="pdt20 center">个体户年度报告证明</h5>
    <h3>出具日期：${reportProveDate}</h3>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>基本信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact"> 
	            <table class="table-public" border="0" cellspacing="0" cellpadding="0">
	                <tbody>
	                <tr>
	                    <td class="odd" width="20%" align="right">统一代码/注册号：</td>
	                    <td width="30">${empty midBaseInfoDto.uniCode ? midBaseInfoDto.regNO : midBaseInfoDto.uniCode}</td>
	                    <td class="odd" width="20%" align="right">名称：</td>
	                    <td width="30%">${midBaseInfoDto.entName}</td>
	                </tr>
	                <tr>
	                    <td class="odd" width="20%" align="right">类型：</td>
	                    <td width="30">${codeEntType.content }</td>
	                    <td class="odd" width="20%" align="right">经营者姓名：</td>
	                    <td width="30%">${midBaseInfoDto.leRep}</td>
	                </tr>
	              
	                <tr>
	                    <td class="odd" width="20%" align="right">住所：</td>
	                    <td class="odd" colspan="3">${midBaseInfoDto.dom}</td>
	                </tr>  
					 <tr>
	                    <td class="odd" width="20%" align="right">经营范围：</td>
	                    <td class="odd" colspan="3">${midBaseInfoDto.opScope }</td>
	                </tr> 
				   <tr>
	                    <td class="odd" width="20%" align="right">登记机关：</td>
	                    <td width="30">${midBaseInfoDto.regOrgName} </td>
	                    <td class="odd" width="20%" align="right">核准日期：</td>
	                    <td width="30%"><fmt:formatDate value="${midBaseInfoDto.apprDate}" pattern="yyyy年MM月dd日"/>  </td>
	               </tr> 
					<tr>
 						<td class="odd" width="20%" align="right">登记状态：</td>
	                    <td width="30%">${hx:publicStatus(midBaseInfoDto.regState)}</td>
					</tr> 
	               </tbody>
	            </table>
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>年度报告情况</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd" width="20%" align="right">报告年度：</td>
                    <td width="30">	${year}</td>
                    <td class="odd" width="20%" align="right">报送状态：</td>
                    <td width="30%">
                      <c:choose>
	         			<c:when test="${yrRegCheck.isReported== 1}">已年报</c:when>
	         			<c:when test="${yrRegCheck.isReported== 2}">已年报（逾期）</c:when>
	         			<c:otherwise>未年报</c:otherwise>
		         	  </c:choose>
		         	</td>
                </tr>
                <tr>
                    <td class="odd" width="20%" align="right">报送日期：</td>
                    <td class="odd" colspan="3"><fmt:formatDate value="${yrRegCheck.firstReportTime}" pattern="yyyy-MM-dd"/></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>报告修改情况</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <div style="overflow-y: auto;">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="50%">修改记录</th>
                        <th>修改日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${empty pbBaseinfoHisList}">
		        		<tr>
		        			<td colspan="2" style="text-align:center;">无</td>
		        		</tr>
		        	</c:if>
		        	<c:if test="${not empty pbBaseinfoHisList}">
		        		<c:forEach var="pbBaseinfoHis" items="${pbBaseinfoHisList}" varStatus="status">
			        		<tr>
			        			<td >${status.count}</td>
			        			<td >
			        				<fmt:formatDate value="${pbBaseinfoHis.lastReportTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
			        			</td>
			        		</tr>
		        		</c:forEach>
		        	</c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="mod btn-box">
    <p class="light center mb10">注：登录浙江省企业信用信息公示系统（<a href="http://gsxt.zjaic.gov.cn" target="_blank">http://gsxt.zjaic.gov.cn</a>）可查询企业年度报告信息。</p>
</div> 
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>

</body>
</html>