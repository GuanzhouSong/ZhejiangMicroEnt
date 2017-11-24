<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <!-- 全部批列入查询参数传递 -->
            <input type="hidden" name="estDateStart" value="<fmt:formatDate value="${pubOpanoMalyDto.estDateStart}" type="date" pattern="yyyy-MM-dd"/>">
            <input type="hidden" name="estDateEnd" value="<fmt:formatDate value="${pubOpanoMalyDto.estDateEnd}" type="date" pattern="yyyy-MM-dd"/>">
            <input type="hidden" name="isIndivid" value="${pubOpanoMalyDto.isIndivid}">
            <!-- 参数传递列表 -->
            <input type="hidden" name="auditDate" id="auditDate" value="<fmt:formatDate value="${nowdate}" type="date" pattern="yyyy-MM-dd"/>">
            <input type="hidden" name="firstdate" id="firstdate" value="<fmt:formatDate value="${nowdate}" type="date" pattern="yyyy-MM-dd"/>">
            <input type="hidden" name="regOrg" id="regOrg" value="${pubOpanoMalyDto.regOrg}">
            <input type="hidden" name="localAdm" id="localAdm" value="${pubOpanoMalyDto.localAdm}">
            <input type="hidden" name="speCauseCN" id="speCauseCN" value="${pubOpanoMalyDto.year}年度未按照《企业信息公示暂行条例》第八条规定的期限公示年度报告的">
            <input type="hidden" name="speCause" id="speCause" value="1">
            <input type="hidden" name="decOrg" id="decOrg" value="${pubOpanoMalyDto.decOrg}">
            <input type="hidden" name="decorgCN" id="decorgCN" value="${pubOpanoMalyDto.decorgCN}">
            <input type="hidden" name="firstDept" value="${sysUser.departMent.deptName}">
            <input type="hidden" name="firstOpin" value="拟列入经营异常名录">
            <input type="hidden" name="auditOpin" value="予以列入经营异常名录">
            <input type="hidden" name="auditState" id="auditState" value="1">
            <input type="hidden" name="auditDept" id="auditDept" value="${sysUser.departMent.deptName}">
            <input type="hidden" id="deptName" name="deptName" value="${departMent.deptName}"/>
            <input type="hidden" id="deptUpName" name="deptUpName" value="${departMent.deptUpName}"/>
            <input type="hidden" id="deptSameCourt" name="deptSameCourt" value="${departMent.sameCourt}"/>
            <input type="hidden" id="deptSameGov" name="deptSameGov" value="${departMent.sameGov}"/>
            <input type="hidden" name="batchEntType" value="${pubOpanoMalyDto.batchEntType}"/>
            <input type="hidden" name="impFlag" value="0"/>
            <input type="hidden" name="priPID" id="priPID" value="${pubOpanoMalyDto.priPID }">
            <input type="hidden" name="year" id="year" value="${pubOpanoMalyDto.year }">
            <div class="leftTop"></div>
            <div class="right1Top"></div>
            <table class="table-horizontal">
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
                <tr >
                    <td class="bg-gray right">
                        <div class="ipt-box">列入对象：</div>
                    </td>
                    <td colspan="3">
                        <div class="ipt-box">共<span class="blue">${pubOpanoMalyDto.initBatchNum }</span>家</div>
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
                            <textarea id="anomalyRea" name="anomalyRea"
                                      style="width: 100%;height: 50px;">${pubOpanoMalyDto.anomalyRea}</textarea></div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box"><font color="red">* </font> 作出决定日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box"><input class="ipt-txt laydate-icon" type="text" style="cursor: pointer;"
                                                  readonly="readonly" name="abnTime" id="abnTime"
                                                  value="<fmt:formatDate value="${pubOpanoMalyDto.abnTime}" type="date" pattern="yyyy-MM-dd"/>"
                                                  onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"/></div>
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
                        <input type="text" class="ipt-txt" name ="firstName" value="${empty pubOpanoMalyDto.firstName ? sysUser.realName : pubOpanoMalyDto.firstName}"/>
                        </div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">审核人</div>
                    </td>
                    <td width="250">
                        <div class="ipt-box"><input type="text" class="ipt-txt" name ="auditName" value="${empty pubOpanoMalyDto.auditName ? sysUser.realName : pubOpanoMalyDto.auditName}"/></div>
                    </td>
                </tr>
                <tr>
                   <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">初审日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box"><fmt:formatDate value="${nowdate}" type="date"
                                                           pattern="yyyy-MM-dd"/></div>
                    </td>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">审核日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box"><fmt:formatDate value="${nowdate}" type="date"
                                                           pattern="yyyy-MM-dd"/></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <div class="ipt-box"><font style="color:red;">注：审核日期即为公示日期。</font></div>
                    </td>
                </tr>
<!--                 <tr id="decisiontr" style="display: none"> -->
<!--                     <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"> -->
<!--                         <div class="ipt-box">*生成决定书</div> -->
<!--                     </td> -->
<!--                     <td width="180" colspan="6"> -->
<!--                         <div class="ipt-box"><a style="text-decoration: underline;cursor: pointer;" -->
<%--                                               id="${pubOpanoMaly.busExcList}" class="pubOpanoJDS">生成列入经营异常名录决定书</a> --%>
<!--                         </div> -->
<!--                     </td> -->
<!--                 </tr> -->
            </table>
        </div>
    </form>
    <br><br>
    <div align="center">
        <input type="button" class="btn btn-info" id="savepubOpanoBtn" value="保存"/>
        <input type="button" class="btn " id="cancel" value="取消"/>
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