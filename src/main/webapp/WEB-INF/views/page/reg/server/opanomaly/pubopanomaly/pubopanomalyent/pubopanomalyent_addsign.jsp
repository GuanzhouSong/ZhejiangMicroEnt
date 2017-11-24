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
 	<meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>异常状态设置申请</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style> 
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
    <form id="pubosaveform">
        <div class="listBox2 thBg">
            <!-- 参数传递列表 -->
            <input type="hidden" name="entName" value="${midBaseInfoDto.entName }">
            <input type="hidden" name="regNO" id="regNO" value="${midBaseInfoDto.regNO }">
            <input type="hidden" name="leRep" value="${midBaseInfoDto.leRep }">
            <input type="hidden" name="year" id="year" value="${empty pubOpanoMaly.year ? nowNbYear : pubOpanoMaly.year }">
            <input type="hidden" name="regOrg" value="${midBaseInfoDto.regOrg }">
            <input type="hidden" name="localAdm" value="${midBaseInfoDto.localAdm}">
            <input type="hidden" name="priPID" value="${midBaseInfoDto.priPID }">
            <input type="hidden" name="uniSCID" value="${midBaseInfoDto.uniCode }">
            <input type="hidden" name="cerNO" value="${midBaseInfoDto.cerNO }">
            <input type="hidden" name="cerType" value="${pubEppassword.liaidtype }"> 
            <input type="hidden" name="auditState" value="0">
            <input type="hidden" name="batchEntType" id="batchEntType" value="${batchEntType}">
            <input type="hidden" name="impFlag" value="1">
            <input type="hidden" name="firstName" value="${sysUser.realName}">
            <input type="hidden" name="firstdate" id="firstdate" value="${firstDate}">
            <input type="hidden" name="speCauseCN" id="speCauseCN" value="${pubOpanoMaly.speCauseCN}">
            <input type="hidden" name="busExcList" id="busExcList" value="${pubOpanoMaly.busExcList}">
            <input type="hidden" name="decorgCN" id="decorgCN" value="${codeRegorg.contentShort}">
            <input type="hidden" name="decOrg" id="decorgCN" value="${codeRegorg.code}">
            <input type="hidden" name="firstDept" id="firstDept" value="${departMent.deptName}">
            <input type="hidden" name="estDate"  value="<fmt:formatDate value="${midBaseInfoDto.estDate}" type="date"
                                                           pattern="yyyy-MM-dd"/>">
            <input type="hidden" name="regState"  value="${midBaseInfoDto.regState}">
            <div class="leftTop"></div>
            <div class="right1Top"></div>
            <table class="table-horizontal">
                <tr id="appBasic">
                    <td class="bg-gray right" width="100px">
                        <div class="ipt-box">企业名称</div>
                    </td>
                    <td width="270px">
                        <div class="ipt-box">${midBaseInfoDto.entName}</div>
                    </td>
                    <td class="bg-gray right" width="100px">
                        <div class="ipt-box">注册号</div>
                    </td>
                    <td width="180px">
                        <div class="ipt-box">${midBaseInfoDto.regNO}</div>
                    </td>
                    <td class="bg-gray right" width="100px">
                        <div class="ipt-box">成立日期</div>
                    </td>
                    <td width="150px">
                        <div class="ipt-box"><fmt:formatDate value="${midBaseInfoDto.estDate}" type="date"
                                                           pattern="yyyy-MM-dd"/></div>
                    </td>
                </tr>
                <tr id="appBasic">
                    <td class="bg-gray right">
                        <div class="ipt-box">登记机关</div>
                    </td>
                    <td>
                        <div class="ipt-box">${midBaseInfoDto.regOrgName}</div>
                    </td>
                    <td class="bg-gray right">
                        <div class="ipt-box">法定代表人</div>
                    </td>
                    <td>
                        <div class="ipt-box">${midBaseInfoDto.leRep}</div>
                    </td>
                    <td class="bg-gray right">
                        <div class="ipt-box">联系电话</div>
                    </td>
                    <td>
                        <div class="ipt-box">${midBaseInfoDto.tel}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">
                        <div class="ipt-box">管辖单位</div>
                    </td>
                    <td>
                        <div class="ipt-box">${midBaseInfoDto.localAdmName}</div>
                    </td>
                    <td class="bg-gray right">
                        <div class="ipt-box">联络员</div>
                    </td>
                    <td>
                        <div class="ipt-box">${pubEppassword.lianame }</div>
                    </td>
                    <td class="bg-gray right">
                        <div class="ipt-box">联络员电话</div>
                    </td>
                    <td>
                        <div class="ipt-box">${pubEppassword.tel}</div>
                    </td>

                </tr>
            </table>
        </div>
        <br/>
        <div class="listBox2 thBg">
            <div class="leftTop"></div>
            <div class="rightTop"></div>
            <table border="0" class="table-horizontal">
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" rowspan="2" height="100px">
                        <div class="ipt-box">当前在列记录</div>
                    </td>
                    <td class="bg-gray center" valign="middle" class="lb_1">
                        <div class="ipt-box">列入文号</div>
                    </td>
                    <td class="bg-gray center" valign="middle" class="lb_1" colspan="2">
                        <div class="ipt-box">列入原因</div>
                    </td>
                    <td class="bg-gray center" valign="middle" class="lb_1">
                        <div class="ipt-box">决定日期</div>
                    </td>
                    <td class="bg-gray center" valign="middle" class="lb_1">
                        <div class="ipt-box">详情</div>
                    </td>
                </tr>
                <tr>
                    <td colspan="5" style="padding:0px;">
                        <div id="unusualCatalog">
                            <table style="border:none;">
                                <col width="150px"/>
                                <col width="200px"/>
                                <col width="100px"/>
                                <c:forEach var="pubOpanoMalyDto" items="${pubOpanoMalyDtoList}" varStatus="vs">
                                    <span class="appInReaCodeExist" year="${empty pubOpanoMalyDto.year ? '0000' : pubOpanoMalyDto.year }"
                                          style="display:none">${pubOpanoMalyDto.speCause}</span>
                                    <tr style="border:none">
                                        <td style="border:0px;text-align:left;background:none">
                                            <div class="ipt-box">
                                                    ${pubOpanoMalyDto.penDecNo}
                                            </div>
                                        </td>
                                        <td style="border:0px;text-align:center;background:none;max-width: 150px"><%-- <c:if
                                                test="${!empty pubOpanoMalyDto.year}">${pubOpanoMalyDto.year}年度</c:if> --%>
                                                ${pubOpanoMalyDto.speCauseCN}</td>
                                        <td style="border:0px;text-align:center;background:none"><fmt:formatDate
                                                value="${pubOpanoMalyDto.abnTime}" type="date"
                                                pattern="yyyy-MM-dd"/></td>
                                        <td style="border:0px;text-align:center;background:none" width="100px"><a
                                                href="javascript:void(0);" id="${pubOpanoMalyDto.busExcList}"
                                                style="color:red" class="pubOpanoMalyDetail">详情</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <div class="ipt-box" style="width:100px;"><font color="red">* </font>新增异常原因</div>
                    </td>
                    <td colspan="5">
                        <div class="ipt-box">
                            <select id="speCause" name="speCause">
                                <option value="">请选择</option>
                                <%-- <c:choose>
                                 <c:when test="${pubOpanoMaly.speCause=='1' }">
                                     <option value="1" selected="selected">未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的</option>
                                    <option value="2">未在工商行政管理部门依照《企业信息公示暂行条例》第十条规定责令的期限内公示有关企业信息的</option>
                                    <option value="3">公示企业信息隐瞒真实情况、弄虚作假的</option>
                                    <option value="4">通过登记的住所或者经营场所无法联系的</option>

                                 </c:when>
                                 <c:when test="${pubOpanoMaly.speCause=='2' }">
                                     <option value="1" >未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的</option>
                                    <option value="2" selected="selected">未在工商行政管理部门依照《企业信息公示暂行条例》第十条规定责令的期限内公示有关企业信息的</option>
                                    <option value="3">公示企业信息隐瞒真实情况、弄虚作假的</option>
                                    <option value="4">通过登记的住所或者经营场所无法联系的</option>

                                 </c:when>
                                 <c:when test="${pubOpanoMaly.speCause=='3' }">
                                     <option value="1" selected="selected">未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的</option>
                                    <option value="2">未在工商行政管理部门依照《企业信息公示暂行条例》第十条规定责令的期限内公示有关企业信息的</option>
                                    <option value="3" selected="selected">公示企业信息隐瞒真实情况、弄虚作假的</option>
                                    <option value="4">通过登记的住所或者经营场所无法联系的</option>

                                 </c:when>
                                 <c:when test="${pubOpanoMaly.speCause=='4' }">
                                     <option value="1" >未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的</option>
                                    <option value="2">未在工商行政管理部门依照《企业信息公示暂行条例》第十条规定责令的期限内公示有关企业信息的</option>
                                    <option value="3">公示企业信息隐瞒真实情况、弄虚作假的</option>
                                    <option value="4" selected="selected">通过登记的住所或者经营场所无法联系的</option>
                                 </c:when>
                                 <c:otherwise>
                                     <option value="1">未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的</option>
                                    <option value="2">未在工商行政管理部门依照《企业信息公示暂行条例》第十条规定责令的期限内公示有关企业信息的</option>
                                    <option value="3">公示企业信息隐瞒真实情况、弄虚作假的</option>
                                    <option value="4">通过登记的住所或者经营场所无法联系的</option>
                                 </c:otherwise>
                                </c:choose> --%>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <div class="ipt-box"><font color="red">* </font>事实和理由<br>(限500字)</div>
                    </td>
                    <td colspan="5">
                        <div class="ipt-box">
                            <textarea id="anomalyRea" name="anomalyRea"
                                      style="height: 50px;">${pubOpanoMaly.anomalyRea}</textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <div class="ipt-box"><font color="red">* </font>初审意见<br>(限500字)</div>
                    </td>
                    <td colspan="5">
                        <div class="ipt-box">
                            <textarea id="firstOpin" name="firstOpin"
                                      style="height: 50px;">${pubOpanoMaly.firstOpin}</textarea></div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1">
                        <div class="ipt-box">作出决定日期</div>
                    </td>
                    <td>
                        <div class="ipt-box"><input class="laydate-icon ipt-txt" type="text"
                                                  readonly="readonly" name="abnTime" id="abnTime"
                                                  value="<fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy-MM-dd"/>"
                                                  onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"/></div>
                    </td>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <div class="ipt-box">注：局领导已在纸质材料上审批的，请录入领导审批日期，若尚未审批可不填写。</div>
                    </td>
                    <td class="bg-gray right" valign="middle" class="lb_1">
                        <div class="ipt-box">决定机关</div>
                    </td>
                    <td width="250" colspan="2">
                        <div class="ipt-box">${codeRegorg.contentShort}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1">
                        <div class="ipt-box">初审日期</div>
                    </td>
                    <td>
                        <div class="ipt-box">${firstDate}</div>
                    </td>
                    <td class="bg-gray right" width="120" valign="middle" class="lb_1">
                        <div class="ipt-box">初审人</div>
                    </td>
                    <td>
                        <div class="ipt-box">${sysUser.realName}</div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1">
                        <div class="ipt-box">初审部门</div>
                    </td>
                    <td width="100">
                        <div class="ipt-box">${departMent.deptName}</div>
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <br><br>
    <div align="center">
        <input type="button" class="btn btn-info" id="savepubOpanoBtn" value="保存"/>
        <input type="button" class="btn " id="cancel" value="取消"/>
    </div>
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentapply_edit_main.js"/>"></script>
<script>
    window._CONFIG = {
        _speCause: '${pubOpanoMaly.speCause}'//列入原因编码
    }
</script>
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