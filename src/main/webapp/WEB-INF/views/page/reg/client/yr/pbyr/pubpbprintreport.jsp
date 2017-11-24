<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>个体户年报公示预览页面</title>
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
 <c:if test="${printFalg=='2'}">
	 <div class="button Noprint" style="width:600px;">
	    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
	    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
	    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
     	<a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
 	</div>
	<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
	<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
 </c:if> 
<div class="mod info-title">
    <h5 class="pdt20 center">个体户年报公示信息表</h5>
<!--     <strong class="light">注：以下为个体户公示信息，若有误请返回年度报告报表中进行修改。</strong> -->
 </div>
<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>基本信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact"> 
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd">
                        <div class="item-name">名称：</div>
                        <div class="item-txt">${pbBaseInfo.traName}</div>
                    </td>
                    <td class="odd">
                        <div class="item-name">经营者姓名：</div>
                        <div class="item-txt">${pbBaseInfo.name}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">统一社会信用代码/注册号：</div>
                        <div class="item-txt">${empty pbBaseInfo.uniCode ? pbBaseInfo.regNO : pbBaseInfo.uniCode}</div>
                    </td>
                    <td class="odd">
                        <div class="item-name">联系电话：</div>
                        <div class="item-txt">${pbBaseInfo.tel}</div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name">资金数额：</div>
                        <div class="item-txt"><fmt:formatNumber value="${pbBaseInfo.fundAm}" pattern="###,###,###,##0.0000"/>万元</div>
                    </td>
                    <td class="odd">
                        <div class="item-name">从业人数：</div>
                        <div class="item-txt">${pbBaseInfo.empNum}人</div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>行政许可情况</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
          <div >
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th class="bg">行政许可名称</th>
                        <th class="bg">有效期至</th>
                    </tr>
                    </thead>
                    <tbody >
                    	<c:forEach var="pbLicenceinfo" items="${pbLicenceinfoList}" varStatus="status">
			        		<tr>
			        			<td >${pbLicenceinfo.licNameCN}</td> 
			        			<td >
			        			<fmt:formatDate var="pbvalTo"
								value="${pbLicenceinfo.valTo}"
								pattern="yyyy-MM-dd" />
			        			${(!fn:contains(pbvalTo,'9999'))?pbvalTo:'长期有效'}
			        			</td>
			        		</tr>
		        		</c:forEach> 
                    </tbody>
                </table>
            </div>
            <!-- <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount1"></em> 条信息，共<em id="pageCount1"></em>页</span>
                <div id="pagination1" class="pagination">
                </div>
            </div> -->
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>网站或网店信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <div >
             
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th class="bg" width="90">类型</th>
                        <th class="bg">名称</th>
                        <th class="bg">网址</th>
                    </tr>
                    </thead>
                    <tbody >
                    	<c:forEach var="pbWebsiteinfo" items="${pbWebsiteinfoList}" varStatus="status">
			        		<tr>
			        			<td >
			        			 <c:if test="${pbWebsiteinfo.webType==1}">网站</c:if>
			        			 <c:if test="${pbWebsiteinfo.webType==2}">网店</c:if> 
			        			</td>
			        			<td > ${pbWebsiteinfo.webSitName}</td>
			        			<td >${pbWebsiteinfo.webSite} </td>
			        		</tr>
		        		</c:forEach> 
                    </tbody>
                </table>
            </div>
            <!-- <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount"></em> 条信息，共<em id="pageCount"></em>页</span>
                <div id="pagination2" class="pagination">
                </div>
            </div> -->
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>生产经营情况信息</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd">
                        <div class="item-name">销售额或营业收入：</div>
                        <div class="item-txt">
                        <c:if test="${pbBaseInfo.vendIncIsPub == '1'}"><fmt:formatNumber value="${pbBaseInfo.vendInc}" pattern="###,###,###,##0.0000"/>万元</c:if>
                    	<c:if test="${pbBaseInfo.vendIncIsPub == '0'}">个体工商户选择不公示</c:if></div>
                    </td>
                    <td class="odd">
                        <div class="item-name">纳税总额：</div>
                        <div class="item-txt">
                        <c:if test="${pbBaseInfo.vendIncIsPub == '1'}"><fmt:formatNumber value="${pbBaseInfo.ratGro}" pattern="###,###,###,##0.0000"/>万元</c:if>
                        <c:if test="${pbBaseInfo.vendIncIsPub == '0'}">个体工商户选择不公示</c:if>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<c:if test="${printFalg=='1'}">
	<div class="mod btn-box">
	    <button class="btn-common" id="pbprintreport">打印</button>
	</div>
</c:if>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/lib/laydate/laydate.js"/>"></script>
<script src="<c:url value="/js/lib/layer/layer.js"/>"></script>
<script src="<c:url value="/js/lib/pagination/jquery.pagination.js"/>"></script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/pbyr/edit_main.js"/>"></script>

<script>
  window._CONFIG = {
     _year:'${encodeYear}', //年报年度加密
     _pripid:'${pripid}'  //主体代码 
  }
</script>
</body>
</html>