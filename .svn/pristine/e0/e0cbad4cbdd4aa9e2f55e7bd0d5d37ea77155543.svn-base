<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
 	<meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>异常状态设置审核</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
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
            <table width="100%" border="0" class="table-horizontal">
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center" rowspan="2"
                        height="100px">
                        <div class="ipt-box">当前在列记录</div>
                    </td>
                    <td class="bg-gray center" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">列入文号</div>
                    </td>
                    <td class="bg-gray center" valign="middle" class="lb_1" style="text-align:center" width="150px"
                        colspan="3">
                        <div class="ipt-box">列入原因</div>
                    </td>
                    <td class="bg-gray center" valign="middle" class="lb_1" style="text-align:center" width="150px">
                        <div class="ipt-box">决定日期</div>
                    </td>
                    <td class="bg-gray center" valign="middle" class="lb_1" style="text-align:center" width="100px">
                        <div class="ipt-box">详情</div>
                    </td>
                </tr>
                <tr>
                    <td colspan="6" style="padding:0px;">
                        <div id="unusualCatalog">
                            <table style="border:none;">
                                <col width="150px"/>
                                <col width="600px"/>
                                <col width="100px"/>
                                <c:forEach var="pubOpanoMalyDto" items="${pubOpanoMalyDtoList}" varStatus="vs">
                                    <tr style="border:none">
                                        <td style="border:0px;text-align:left;background:none;min-width: 156px" >
                                            <div>
                                                    ${pubOpanoMalyDto.penDecNo}
                                            </div>
                                        </td>
                                        <td style="border:0px;text-align:center;background:none;max-width: 400px">${pubOpanoMalyDto.speCauseCN}</td>
                                        <td style="border:0px;text-align:center;background:none"><fmt:formatDate
                                                value="${pubOpanoMalyDto.abnTime}" type="date"
                                                pattern="yyyy-MM-dd"/></td>
                                        <td style="border:0px;text-align:center;background:none;width: 100px"><a
                                                href="javascript:void(0);" id="${pubOpanoMalyDto.busExcList}"
                                                class="pubOpanoMalyDetail">详情</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box" style="width:100px"><font color="red">* </font>新增异常原因</div>
                    </td>
                    <td colspan="6">
                        <div class="ipt-box">
                            <select id="speCause" name="speCause" style="width: 98%" disabled="disabled">
                                <option value="">请选择</option>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box"><font color="red">* </font>事实和理由</div>
                    </td>
                    <td colspan="6">
                        <div class="ipt-box">
                            <textarea disabled="disabled" id="anomalyRea" name="anomalyRea"
                                      style="height: 50px;">${pubOpanoMaly.anomalyRea}</textarea></div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box"><font color="red">* </font>初审意见</div>
                    </td>
                    <td colspan="6">
                        <div class="ipt-box">
                            <textarea disabled="disabled" id="firstOpin" name="firstOpin"
                                      style="height: 50px;">${pubOpanoMaly.firstOpin}</textarea></div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">作出决定日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box"><input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                                    name="abnTime" id="abnTime"
                                                    value="<fmt:formatDate value="${pubOpanoMaly.abnTime}" type="date" pattern="yyyy-MM-dd"/>"/>
                        </div>
                    </td>
                    <td width="120" colspan="2">
                        <div class="ipt-box" class="light">注：该日期为公示的决定日期。</div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">决定机关</div>
                    </td>
                    <td width="250" colspan="2">
                        <div class="ipt-box">${pubOpanoMaly.decorgCN}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">初审日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box"><fmt:formatDate value="${pubOpanoMaly.firstdate}" type="date"
                                                             pattern="yyyy-MM-dd"/></div>
                    </td>
                    <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">初审人</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box">${pubOpanoMaly.firstName}</div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">初审部门</div>
                    </td>
                    <td width="250" colspan="2">
                        <div class="ipt-box">${pubOpanoMaly.firstDept}</div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">审核意见</div>
                    </td>
                    <td colspan="6">
                        <div class="radio-box">
                            <c:if test="${pubOpanoMaly.auditState=='1'}">
                                <label class="font-12"><input type="radio" disabled="disabled" checked="checked" id="auditStateY"
                                              name="auditState" value="1">予以列入经营异常名录</label>
                                <label class="font-12"><input type="radio" disabled="disabled" id="auditStateN" name="auditState"
                                              value="2">不予以列入经营异常名录</label>
                            </c:if>
                            <c:if test="${pubOpanoMaly.auditState=='2'}">
                                <label class="font-12"> <input type="radio" disabled="disabled" checked="checked" id="auditStateY"
                                               name="auditState" value="1">予以列入经营异常名录</label>
                                <label class="font-12"><input type="radio" disabled="disabled" checked="checked" id="auditStateN"
                                              name="auditState" value="2">不予以列入经营异常名录</label>
                            </c:if>
                        </div>
                        <div class="ipt-box">
                            <textarea id="auditOpin" disabled="disabled" name="auditOpin"
                                      style="height: 50px;">${pubOpanoMaly.auditOpin}</textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">审核日期</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box"><fmt:formatDate value="${pubOpanoMaly.auditDate}" type="date"
                                                             pattern="yyyy-MM-dd"/></div>
                    </td>
                    <td class="bg-gray right" width="120" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">审核人</div>
                    </td>
                    <td width="180">
                        <div class="ipt-box">${pubOpanoMaly.auditName}</div>
                    </td>
                    <td class="bg-gray right" width="130" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">审核部门</div>
                    </td>
                    <td width="250" colspan="2">
                        <div class="ipt-box">${pubOpanoMaly.auditDept}</div>
                    </td>
                </tr>
                <tr>
                    <td colspan="7">
                        <div class="ipt-box"><font class="light">注：审核通过的日期即为该决定信息对外公示的公示日期。</font></div>
                    </td>
                </tr>
                <!--  <tr id="decisiontr" style="display: none">
                    <td class="bg-gray right" width="100" valign="middle" class="lb_1" style="text-align:center"><div class="ipt-box">*生成决定书</div></td>
                    <td width="180" colspan="6"><div class="ipt-box"><a style="text-decoration: underline;cursor: pointer;" onclick="doEnDecisionBook()">生成列入经营异常名录决定书</a></div></td>
                 </tr> -->
            </table>
        </div>
    </form>
    <div class="center mt10">
        <input type="button" class="btn" id="cancel" value="关闭"/>
    </div>
</div>
<script>
    window._CONFIG = {
        _speCause: '${pubOpanoMaly.speCause}'//列入原因编码
    }
</script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentaudit_edit_main.js"/>"></script>
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