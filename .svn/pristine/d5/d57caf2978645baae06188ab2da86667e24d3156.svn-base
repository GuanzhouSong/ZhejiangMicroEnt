<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--分支机构：12,14,22,24,28,32,34--%>
<%--外资企业：21,22,23,24,25,26,27,28--%>
<c:set var="FzTypeCode" value="12,14,22,24,28,32,34"/><%--分支机构--%>
<c:set var="TypeCatg" value="12,14,21,22,23,24,25,26,27,28,32,34"/><%--分支机构和外资企业--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>其它情况表填写页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>


<!-- 企业财务信息 -->
<form class="form-horizontal error-bottom" id="otherForm">
    <!-- 企业联系信息 -->
    <div class="mod contact">
        <div class="mod-hd">
            <div class="title">
                <h3>企业联系信息</h3>
                <p>以下信息请按照企业当前实际情况填写。</p>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content content-contact">
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>企业联系电话</div>
                            <div class="ipt-box js-ipt-box">
                              <input type="text" name="tel" value=" ${!empty yrOtherInfo.tel?yrOtherInfo.tel:'无'}" class="ipt-txt" readonly>
                            </div>
                        </td>


                        <td class="even focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>企业电子邮箱</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="email" value="${!empty yrOtherInfo.email?yrOtherInfo.email:'无'}" class="ipt-txt" readonly>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name special ">
                                <strong class="light">* </strong> 企业住所(营业场所)
                            </div>
                            <div class="ipt-box">
                                <div class="item-select">
                                </div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" class="ipt-txt" name="dom" value="${yrOtherInfo.dom}" readonly style="line-height: 58px;height: 58px;">
                                </div>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name special bg"><strong class="light">* </strong>企业通讯地址
                            </div>
                            <div class="ipt-box">
                                <div class="item-select">
                                </div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" class="ipt-txt" name="addr" value="${yrOtherInfo.addr}" readonly style="line-height: 58px;height: 58px;">
                                </div>
                            </div>
                        </td>
                    </tr>


                    <tr>
                        <td class="odd focus-state"  <c:if test="${fn:indexOf(FzTypeCode,entTypeCatg) == -1}"> colspan="2" </c:if> >
                            <div class="item-name bg"><strong class="light">* </strong>邮政编码</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="postalCode" value="${yrOtherInfo.postalCode}" class="ipt-txt ipt-txt-lg"  readonly>
                               <%-- <i class="icon-close"></i>--%>
                            </div>
                        </td>
                        <%--判断当前登录企业是否是 分支机构--%>
                        <c:if test="${fn:indexOf(FzTypeCode,entTypeCatg) != -1}">
                            <td class="even focus-state">
                                <div class="item-name bg"><strong class="light">* </strong>隶属企业名称</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="supEntname" value="${yrOtherInfo.supEntname}" class="ipt-txt" readonly>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </c:if>
                    </tr>

                    <%--判断当前登录企业是否是 分支机构--%>
                    <c:if test="${fn:indexOf(FzTypeCode,entTypeCatg) != -1}">
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name bg"><strong class="light">* </strong>隶属企业统一代码/注册号</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="supRegNO" value="${yrOtherInfo.supRegNO}" class="ipt-txt ipt-txt-lg" readonly>
                                </div>
                            </td>
                        </tr>
                    </c:if>

                    <c:if test="${empty uniscid}"> <%-- 判断当前企业是否有注册号  为空则显示下面 --%>
                        <tr>
                            <td class="odd focus-state" colspan="2">
                                <div class="item-name">企业组织机构代码证号</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="entOrgCode" value="${yrOtherInfo.entOrgCode}"
                                           class="ipt-txt ipt-txt-lg" readonly>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="even focus-state" colspan="2">
                                <div class="item-name">企业税务证登记号</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="taxRegNo" value="${yrOtherInfo.taxRegNo}"
                                           class="ipt-txt ipt-txt-lg" readonly>
                                </div>
                            </td>
                        </tr>
                  </c:if>
                 </tbody>
            </table>
            </div>
        </div>
    </div>

    <%--判断当前登录企业是否是 分支机构--%>
    <c:if test="${fn:indexOf(TypeCatg,entTypeCatg) == -1}">
        <!-- 企业党建信息 -->
        <div class="mod dangjian">
            <div class="mod-hd">
                <div class="title">
                    <h3>企业党建信息</h3>
                    <p>以下信息请按照截止${year}年12月31日时的企业情况进行填写</p>
                </div>
            </div>
            <div class="mod-bd">
                <div class="content content-dangjian">
                    <table class="table-public table-dangjian" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <input type="hidden" id="_empNum" value="${empNum}"/><!-- 企业从业人数 -->
                            <td class="odd focus-state" colspan="2">
                                <div class="item-name"><strong class="light">* </strong>企业从业人员中，党员（含预备党员）人数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_numParM" name="numParM" value="${yrOtherInfo.numParM}" class="ipt-txt" readonly>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name"><strong class="light">* </strong>法定代表人（执行合伙事务人，投资人，经营者）是否为党员</div>
                                <div class="radio-box">
                                    <label><input type="radio" name="resParMSign" value="1"  <c:if test="${yrOtherInfo.resParMSign=='1'}">checked</c:if> disabled >是</label>
                                    <label><input type="radio" id="No_ResParMSign" name="resParMSign" value="2"  <c:if test="${yrOtherInfo.resParMSign=='2'}">checked</c:if> disabled>否</label>
                                </div>
                            </td>
                            <td class="even focus-state">
                              <c:if test="${yrOtherInfo.resParMSign=='1'}">
                                <div class="item-name">是否担任党组织书记</div>
                                <div class="radio-box">
                                    <label><input type="radio" name="resParSecSign" value="1"  <c:if test="${yrOtherInfo.resParSecSign=='1'}">checked</c:if> disabled>是</label>
                                    <label><input type="radio" name="resParSecSign" value="2"  <c:if test="${yrOtherInfo.resParSecSign=='2'}">checked</c:if> disabled>否</label>
                                </div>
                             </c:if>

                            </td>
                        </tr>

                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name">党组织建制:</div>
                                <div class="ipt-box">
                                           ${yrOtherInfo.parIns=='1'?'党支部':''}
                                           ${yrOtherInfo.parIns=='2'?'党总支':''}
                                           ${yrOtherInfo.parIns=='3'?'党委':''}
                                           <c:if test="${empty yrOtherInfo.parIns}">未组建党支部</c:if>

                                </div>
                            </td>

                            <td class="odd focus-state js-ui-state">
                                <c:if test="${!empty yrOtherInfo.parInsCN&&yrOtherInfo.parInsCN!='未组建党支部'}">
                                    <div class="item-name"><strong class="light">* </strong>组建时间</div>
                                    <div class="ipt-box">
                                        <input type="text" id="_parSetTime" name="parSetTime" value="<fmt:formatDate value="${yrOtherInfo.parSetTime}"  pattern="yyyy-MM-dd" />" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" class="ipt-txt laydate-icon" readonly="readonly">
                                    </div>
                                </c:if>
                            </td>
                        </tr>

                        <tr class="js-ui-state">
                            <td class="odd focus-state">
                                <c:if test="${!empty yrOtherInfo.parInsCN&&yrOtherInfo.parInsCN!='未组建党支部'}">
                                <div class="item-name"><strong class="light">* </strong>组建方式</div>
                                <div class="ipt-box" >
                                    <c:if test="${yrOtherInfo.parOrgW=='1'}">单独组建</c:if>
                                    <c:if test="${yrOtherInfo.parOrgW=='2'}">联合组建</c:if>
                                    <c:if test="${yrOtherInfo.parOrgW=='3'}">加入社区党组织</c:if>
                                    <c:if test="${yrOtherInfo.parOrgW=='4'}">加入民营</c:if>
                                    <c:if test="${yrOtherInfo.parOrgW=='5'}">加入上级企业（母公司）党组织</c:if>
                                </div>
                             </c:if>
                            </td>
                        </tr>

                    </table>
                </div>
            </div>
        </div>

        <!-- 企业经营信息 -->
        <div class="mod jyxx">
            <div class="mod-hd">
                <div class="title">
                    <h3>企业经营信息</h3>
                    <div class="currency">币种：<strong class="light">人民币</strong></div>
                    <p>以下信息请按照截止${year}年12月31日时的企业情况进行填写</p>
                </div>
            </div>
            <div class="mod-bd">
                <div class="content content-jyxx">
                    <table class="table-public table-jyxx" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name">企业拥有专利的数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="otherInfoPatAmount" value="${yrOtherInfo.otherInfoPatAmount}" class="ipt-txt" readonly>
                                </div>
                                个
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <table class="table-public table-jyxx" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th colspan="3"><span>商标注册与许可使用情况</span><span class="line"></span></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="odd focus-state" width="355">
                                <span class="line"></span>
                                <div class="item-name">国内商标注册数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="domTraRegs" value="${yrOtherInfo.domTraRegs}" class="ipt-txt" readonly >
                                </div>
                                个
                            </td>
                            <td class="odd focus-state" colspan="2">
                                <div class="item-name">境外商标注册数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="abrTraRegs" value="${yrOtherInfo.abrTraRegs}" class="ipt-txt" readonly>
                                </div>
                                个
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <span class="line-portrait"></span>
                                <div class="item-name item-name-box">其中：实际在使用商标数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="usingTraRegs" value="${yrOtherInfo.usingTraRegs}" class="ipt-txt" readonly>
                                </div>
                                个
                            </td>
                            <td class="odd focus-state" width="364">
                                <div class="item-name">许可他人使用商标数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="licOthTraRegs" value="${yrOtherInfo.licOthTraRegs}" class="ipt-txt" readonly>
                                </div>
                                个
                            </td>
                            <td class="odd focus-state">
                                <div class="item-name">本年新申请商标数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="newAppTraRegs" value="${yrOtherInfo.newAppTraRegs}" class="ipt-txt ipt-txt-sm" readonly>
                                </div>
                                个
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <table class="table-public table-jyxx" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th colspan="3"><span>广告投入费用及经营情况</span><span class="line"></span></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="odd focus-state" width="355">
                                <div class="item-name">本年度投入广告费</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="thAnnAdvFee" value="${yrOtherInfo.thAnnAdvFee}" class="ipt-txt " readonly>
                                </div>
                                元
                            </td>
                            <td class="odd focus-state" width="364">
                                <div class="item-name  item-name-box">其中：在互联网投入广告费</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="thIntAnnAdvFee" value="${yrOtherInfo.thIntAnnAdvFee}" class="ipt-txt " readonly>
                                </div>
                                元
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name"><strong class="light">* </strong>是否经营广告费</div>
                                <div class="radio-box">
                                    <label><input type="radio" name="advBusFlag" value="1" <c:if test="${yrOtherInfo.advBusFlag=='1'}">checked</c:if> disabled>专营</label>
                                    <label><input type="radio" name="advBusFlag" value="2"  <c:if test="${yrOtherInfo.advBusFlag=='2'}">checked</c:if> disabled>兼营</label>
                                    <label><input type="radio" name="advBusFlag" value="0"  <c:if test="${yrOtherInfo.advBusFlag=='0'}">checked</c:if> disabled>否</label>
                                </div>
                            </td>
                            <td class="odd focus-state js-ui-advBusFlag">
                            <c:if test="${yrOtherInfo.advBusFlag!='0'}">
                                <div class="item-name"><strong class="light">* </strong>本年度广告经营额</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_thAdvTurnover" name="thAdvTurnover" value="${yrOtherInfo.thAdvTurnover}" class="ipt-txt " readonly>
                                </div>
                                元
                            </c:if>
                            </td>
                            <td class="odd focus-state js-ui-advBusFlag">
                             <c:if test="${yrOtherInfo.advBusFlag!='0'}">
                                <div class="item-name"><strong class="light">* </strong>广告经营上缴税收</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_advTurTaxPaid" name="advTurTaxPaid" value="${yrOtherInfo.advTurTaxPaid}" class="ipt-txt ipt-txt-sm " readonly>
                                </div>
                                元
                            </c:if>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <table class="table-public table-jyxx" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th colspan="2"><span>网络应用与经营信息</span><span class="line"></span></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="odd focus-state" width="355">
                                <div class="item-name">本年度通过网络交易经营额</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="thNetTraBusTur" value="${yrOtherInfo.thNetTraBusTur}" class="ipt-txt " readonly>
                                    <i class="icon-close"></i>
                                </div>
                                <strong class="light">万元</strong>
                            </td>
                            <td class="odd focus-state">
                                <span class="line line2"></span>
                                <div class="item-name  item-name-box w188">其中：跨境网络交易进出口经营额</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="partyAccNetAmount" value="${yrOtherInfo.partyAccNetAmount}" class="ipt-txt " readonly>
                                </div>
                                <strong class="light">万元</strong>
                            </td>
                            <td></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:if>
</form>

<!-- 企业网站信息 -->
<div id="qywz" class="mod yonggong" >
    <div class="mod-hd">
        <div class="title">
            <h3>企业网站信息</h3>
            <p>以下信息请按照企业当前实际情况填写</p>
        </div>
    </div>

    <div class="mod-bd">
        <div class="content table-website">
            <table class="table-public table-web">
                <thead>
                <tr>
                    <th width="88">类型</th>
                    <th width="320">名称</th>
                    <th width="360">域名</th>
                </tr>
                </thead>
                <tbody >
                <c:forEach var="list" items="${yrWebsiteInfoList}">
                    <tr>
                        <td>${list.webType==1?'网站':'网店'}</td>
                        <td>${list.webSitName}</td>
                        <td>${list.webSite}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/yr/entreportsearch/yrreport/other_view.js"/>"></script>

</body>
</html>
