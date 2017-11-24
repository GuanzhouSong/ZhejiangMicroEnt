<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>网站网店信息</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<div class="mod mod-border investment-info mt10">
    <div class="mod-bd">
        <div class="content">
            <!-- 信息网站 start -->
            <div class="title">
                <h3>
                  <!--
                      网站网店类型(webType)  1：网站  2：网店
                      网站类型(webSmallType)：网络交易平台（1），企业信息管网（2）
                  -->
                    <c:if test="${yrWebsiteInfo.webType=='2'}">网店(或微店)</c:if>
                    <c:if test="${yrWebsiteInfo.webType=='1'}">
                        ${yrWebsiteInfo.webSmallType=='1'?'交易网站':'信息网站'}
                    </c:if>
                </h3>
            </div>
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg">
                            <strong class="light">* </strong>
                            <c:if test="${yrWebsiteInfo.webType=='2'}">网店(或微店)名称</c:if>
                            <c:if test="${yrWebsiteInfo.webType=='1'}">网站名称</c:if>
                        </div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="webSitName" value="${yrWebsiteInfo.webSitName}" class="ipt-txt ipt-txt-lg " readonly>
                        </div>
                    </td>

                    <td class="odd focus-state">
                        <div class="item-name bg">
                            <strong class="light">* </strong>网址(域名)
                        </div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="webSite" value="${yrWebsiteInfo.webSite}" class="ipt-txt ipt-txt-lg" readonly>
                           
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name">互联网信息服务(简称ICP)备案号</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="icpBackNO" value="${yrWebsiteInfo.icpBackNO}" class="ipt-txt w-730" placeholder="" readonly>
                           
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="odd focus-state">
                        <div class="item-name ">微信公众号</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="weChatPublicNO" value="${yrWebsiteInfo.weChatPublicNO}" class="ipt-txt ipt-txt-lg " placeholder="如有多个请以；隔开" readonly>
                           
                        </div>
                    </td>

                    <td class="odd focus-state">
                        <div class="item-name ">手机APP服务</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="appNames" value="${yrWebsiteInfo.appNames}" class="ipt-txt ipt-txt-lg " placeholder="如有多个请以；隔开" readonly>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
                <!-- 交易网站 start -->
            <div style="display: ${yrWebsiteInfo.webSmallType=='1'?'block':'none'}">
                    <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td class="odd focus-state" colspan="2">
                                <div class="item-name"><strong class="light">* </strong>网络交易平台运营类型:</div>
                                <div class="ipt-box js-ipt-box radio-box">
                                    &nbsp;
                                    ${yrWebsiteInfo.webPlatFormType}
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state" colspan="2">
                                <div class="item-name"><strong class="light">* </strong>网络交易产品类型:</div>
                                <div class="ipt-box js-ipt-box radio-box">
                                    &nbsp;
                                    ${yrWebsiteInfo.webGoodsType}
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state" colspan="2">
                                <div class="item-name"><strong class="light">* </strong>电商类型:</div>
                                <div class="ipt-box js-ipt-box radio-box">
                                    &nbsp;
                                    ${yrWebsiteInfo.eCommerceType}
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- 交易网站 end -->

                <!--网店 start-->
                    <div style="display: ${yrWebsiteInfo.webType=='2'?'block':'none'}">
                        <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                            <tbody>
                            <tr>
                                <td class="odd focus-state" colspan="2">
                                    <div class="item-name"><strong class="light">* </strong>所属平台:</div>
                                    <div class="ipt-box js-ipt-box radio-box">
                                        &nbsp;
                                        ${yrWebsiteInfo.belongPlatFormName}
                                    </div>
                                    <div class="ipt-box js-ipt-box" id="js-select-other" style="display: none">
                                        <input type="text" id="js-other" value="${yrWebsiteInfo.belongPlatFormName}"
                                               class="ipt-txt ipt-txt-lg " readonly>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd focus-state" colspan="2">
                                    <div class="item-name"><strong class="light">* </strong>发货地址</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="sendAddress" value="${yrWebsiteInfo.sendAddress}"
                                               class="ipt-txt w-730" placeholder="" readonly>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd focus-state" colspan="2">
                                    <div class="item-name"><strong class="light">* </strong>退货地址</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="backAddress" value="${yrWebsiteInfo.backAddress}"
                                               class="ipt-txt w-730" placeholder="" readonly>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                <!--网店 end-->

                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>
