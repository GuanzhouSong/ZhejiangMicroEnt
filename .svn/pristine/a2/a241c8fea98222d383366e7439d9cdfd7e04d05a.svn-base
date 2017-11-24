<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<jsp:useBean id="nowdate" class="java.util.Date" />
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>批量列入异常</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style>
    #unusualCatalog {
        padding: 0px;
        margin: 0px;
        overflow-x: hidden;
        overflow-y: auto;
        height: 100px;
    }

    .warn {
        background: #F00 !important;
        color: #FFF !important
    }

    #form select, #form textarea {
        background: #F4F8F9;
    }
</style>
<body class="pd10">
<div class="main">
    <h1 id="title"></h1>
    <form id="pubauditosaveform">
        <div class="listBox2 thBg">
            <div class="leftTop"></div>
            <div class="right1Top"></div>
            <table class="table-horizontal">
                <tr id="appBasic">
                    <td class="bg-gray right">
                        <div class="ipt-box">列入决定书文号：</div>
                    </td>
                    <td colspan="3">
                        <div class="ipt-box"><a class="blue" id="printbook" penDecNo="${penDecNo}" initBatchNum="${initBatchNum }"  href="javascript:void(0);" >${penDecNo}</a></div>
                    </td>
                </tr>
                <tr id="appBasic">
                    <td class="bg-gray right" width="100px">             
                        <div class="ipt-box">年报年度</div>
                    </td>
                    <td width="190px">
                        <div class="ipt-box">${pubOpanoMalyDto.year}</div>
                    </td>
                    <td class="bg-gray right" width="100px">
                        <div class="ipt-box">对象类型</div>
                    </td>
                    <td width="270px">
                        <div class="ipt-box">
                        <c:if test="${pubOpanoMalyDto.batchEntType == 1}">内资企业</c:if>
                        <c:if test="${pubOpanoMalyDto.batchEntType == 2}">农专社</c:if>
                        <c:if test="${pubOpanoMalyDto.batchEntType == 3}">外资企业</c:if>
                        </div>
                    </td>
                </tr>
                <tr id="appBasic">
                    <td class="bg-gray right">
                        <div class="ipt-box">列入对象：</div>
                    </td>
                    <td colspan="3">
                        <div class="ipt-box">
                        	共<span class="blue">${initBatchNum }</span>
                       		 <div style="margin-right: 10px;float: right;"><span class="right"><i class="light-box-y mr5"></i><span class="light">表示已更正移出</span></span></div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <br/>
        <div class="listBox2 thBg">
            <div class="leftTop"></div>
            <div class="rightTop"></div>
            <table width="100%" border="0" class="table-horizontal">
                <tr>
                    <td class="bg-gray" valign="middle" class="lb_1" style="text-align:center"; height="40px"; width="50px" >
                        <div class="ipt-box">序号</div>
                    </td>
                    <td class="bg-gray" valign="middle" class="lb_1" style="text-align:center;"width="200px">
                        <div class="ipt-box">列入文号</div>
                    </td>
                    <td class="bg-gray" valign="middle" class="lb_1" style="text-align:center" width="150px">
                        <div class="ipt-box">统一代码/注册号</div>
                    </td>
                    <td class="bg-gray" valign="middle" class="lb_1" style="text-align:center" width="300px">
                        <div class="ipt-box">企业名称</div>
                    </td>
                    <td class="bg-gray" valign="middle" class="lb_1" style="text-align:center" width="100px">
                        <div class="ipt-box">状态</div>
                    </td>
                </tr>
                <tr>
                    <td colspan="5" style="padding:0px;">
                        <div id="unusualCatalog">
                            <table style="border:none;">
                                <c:forEach var="pubOpanoMaly" items="${pubOpanoMalyDtos}" varStatus="vs">
                                    <tr style="border:none">
                                        <td style="border:0px;text-align:center;background:none;" width="50px">
                                            <div class="ipt-box">${vs.index+1}</div>
                                        </td>
                                        <td style="border:0px;text-align:center;background:none" width="230px">
                                            <div class="ipt-box">${pubOpanoMaly.penDecNo}</div>
                                        </td>
                                        <td style="border:0px;text-align:center;background:none" width="180px">
                                            <span style="<c:if test="${pubOpanoMaly.revokeFlag == '1'}">background: yellow</c:if>">${empty pubOpanoMaly.uniSCID ? pubOpanoMaly.regNO : pubOpanoMaly.uniSCID}</span>
                                        </td>
                                        <td style="border:0px;text-align:center;background:none" width="350px">${pubOpanoMaly.entName}</td> 
                                        <td style="border:0px;text-align:center;background:none">${hx:publicStatus(pubOpanoMaly.regState)}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </td>
                </tr>
            </table>
            <table width="100%" border="0" class="table-horizontal">
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box" style="width:100px">列入原因</div>
                    </td>
                    <td colspan="6">
                        <div class="ipt-box">
                           ${pubOpanoMalyDto.year}年度未按时年报（未按照《企业信息公示暂行条例》第八条规定的期限公示年度报告的）
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box"><font color="red">* </font>事实和理由（500字以内）</div>
                    </td>
                    <td colspan="6">
                        <div class="ipt-box">
                            <textarea id="anomalyRea" name="anomalyRea" disabled="disabled"
                                      style="width: 100%;height: 50px;">${pubOpanoMalyDto.anomalyRea}</textarea></div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box"><font color="red">* </font>作出决定日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box"><input class="ipt-txt" type="text"
                                                  readonly="readonly" name="abnTime" id="abnTime"
                                                  value="<fmt:formatDate value="${pubOpanoMalyDto.abnTime}" type="date" pattern="yyyy-MM-dd"/>"
                                                  /></div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">作出决定机关</div>
                    </td>
                    <td width="250">
                        <div class="ipt-box">${pubOpanoMalyDto.decorgCN}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">初审意见</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box">拟列入经营异常名录</div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">审核意见</div>
                    </td>
                    <td width="250">
                        <div class="ipt-box">予以列入经营异常名录</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">初审人</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box">
                        <input type="text" readonly="readonly" class="ipt-txt" name ="firstName" value="${empty pubOpanoMalyDto.firstName ? sysUser.realName : pubOpanoMalyDto.firstName}"/>
                        </div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">审核人</div>
                    </td>
                    <td width="250">
                        <div class="ipt-box"><input type="text" readonly="readonly" class="ipt-txt" name ="auditName" value="${empty pubOpanoMalyDto.auditName ? sysUser.realName : pubOpanoMalyDto.auditName}"/></div>
                    </td>
                </tr>
                <tr>
                   <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">初审日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box"><fmt:formatDate value="${pubOpanoMalyDto.firstdate}" type="date"
                                                           pattern="yyyy-MM-dd"/></div>
                    </td>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">审核日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box"><fmt:formatDate value="${pubOpanoMalyDto.auditDate}" type="date"
                                                           pattern="yyyy-MM-dd"/></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <div class="ipt-box"><font style="color:red;">注：审核日期即为公示日期。</font></div>
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <br><br>
    <div align="center">
        <input type="button" class="btn " id="cancel" value="关闭"/>
    </div>
</div>
<script>
    window._CONFIG = {
       _type:'${type}'
     } 
</script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalybatchadd_edit.js"/>"></script>
</body>
</html>
<style type="text/css">
    table.gridtable {
        font-family: verdana, arial, sans-serif;
        font-size: 11px;
        color: #333333;
        border-width: 1px;
        border-color: #666666;
        border-collapse: collapse;
    }

    table.gridtable th {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #dedede;
    }

    table.gridtable td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #ffffff;
    }
</style>