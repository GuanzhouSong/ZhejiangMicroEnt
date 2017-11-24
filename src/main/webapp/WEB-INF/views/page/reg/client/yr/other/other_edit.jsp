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
<c:set var="entTypeCatg" value="${sessionScope.midBaseInfoDto.entTypeCatg}"/> <%--大类--%>
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


<!-- 头部  start-->
<jsp:include page="../../common/reportheader.jsp"></jsp:include>


<div class="fold-msg-bg js-fold-msg">
    <jsp:include page="../template/view_template.jsp"></jsp:include>
</div>
<!-- 头部  end-->


<%--当前年报的状态：--%>
<input type="hidden" id="_reportState" value="${yrRegCheck.reportState}">
<input type="hidden" id="_year" value="${year}"/>

<!---后台传入的参数值-->
<form id="form-wz-params">
    <input type="hidden" name="anCheID" value="${anCheID}">
    <input type="hidden" name="priPID"  value="${priPID}"/>
    <input type="hidden" name="year"    value="${year}"/>
</form>



<!-- 企业财务信息 -->
<form class="form-horizontal error-bottom" id="otherForm">
    <div class="mod caiwu">
        <div class="mod-hd">
            <jsp:include page="../template/tab_template.jsp"></jsp:include>
        </div>
        <%--隐藏域的参数 start--%>
        <input type="hidden" name="otherID" value="${yrOtherInfo.otherID}"/>
        <input type="hidden" name="anCheID" id="anCheID" value="${anCheID}">
        <input type="hidden" name="priPID" value="${priPID}"/>
        <input type="hidden" name="year" value="${year}"/>
        <input type="hidden" id ="websiteFlag" name="websiteFlag" value="${yrOtherInfo.websiteFlag}"/>
        <%--隐藏域的参数 end--%>
    </div>
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
                <table class="table-public table-contact table-selected" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>企业联系电话</div>
                            <div class="radio-box js-ipt-box">
                                <label><input type="radio" id="tel_no" name="otherInfoIsTel" value="0"
                                              <c:if test="${yrOtherInfo.otherInfoIsTel=='0'}">checked</c:if> >无</label>
                                <label><input type="radio" id="tel_yes" name="otherInfoIsTel" value="1"
                                              <c:if test="${yrOtherInfo.otherInfoIsTel=='1'}">checked</c:if> >有</label>
                            </div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="tel" value="${yrOtherInfo.tel}" class="ipt-txt">
                                <i class="icon-close"></i>
                            </div>
                        </td>


                        <td class="even focus-state">
                            <div class="item-name bg"><strong class="light">* </strong>企业电子邮箱</div>
                            <div class="radio-box js-ipt-box">
                                <label><input type="radio" id="email_no" name="otherInfoIsEmail" value="0"
                                              <c:if test="${yrOtherInfo.otherInfoIsEmail=='0'}">checked</c:if> >无</label>
                                <label><input type="radio" id="email_yes" name="otherInfoIsEmail" value="1"
                                              <c:if test="${yrOtherInfo.otherInfoIsEmail=='1'}">checked</c:if> >有</label>
                            </div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="email" value="${yrOtherInfo.email}" class="ipt-txt">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>

                    <%--新增的企业住所 start--%>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name special ">
                                <strong class="light">* </strong>
                                企业住所(营业场所)
                            </div>
                            <div class="ipt-box">
                                <div class="item-select">
                                    <select name="" class="select-txt" disabled>
                                        <option value="330000000000">浙江省</option>
                                    </select>
                                    <select name="cityAddressCopy" class="select-txt" id="select_city_copy" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                    <select name="areaAddressCopy" class="select-txt" id="select_area_copy" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                    <select name="streeAddressCopy" class="select-txt" id="select_stree_copy" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                </div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="" class="ipt-txt" name="dom" value="${sessionScope.midBaseInfoDto.dom}" placeholder="只读显示企业注册地址" readonly >
                                </div>
                            </div>
                        </td>
                    </tr>

                    <%--新增的企业住所 end--%>

                    <%--企业通讯地址 start--%>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name special bg">
                                <i class="icon-question" id="A" data-id="A" data-msg="企业通讯地址指企业接收法律文书、信函通知的详细地址"></i>
                                <strong class="light">* </strong>企业通讯地址
                            </div>
                            <div class="ipt-box">
                                <div class="item-select">
                                    <select name="" class="select-txt" disabled>
                                        <option value="330000000000">浙江省</option>
                                    </select>
                                    <select name="cityAddress" class="select-txt" id="select_city" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                    <select name="areaAddress" class="select-txt" id="select_area" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                    <select name="streeAddress" class="select-txt" id="select_stree" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" id="desc_address" class="ipt-txt" name="desAddress" value="${yrOtherInfo.desAddress}" placeholder="请输入具体详细地址" style="width: 226px;">
                                        <i class="icon-close" id="icon-close-delete"></i>
                                    </div>
                                </div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="info_address" class="ipt-txt" name="addr" value="${yrOtherInfo.addr==null?lastYrOtherInfo.addr:yrOtherInfo.addr}" placeholder="请准确并详细填写你企业的收件地址，包含街道名称，门牌号码，楼层和房间号等信息" readonly >
                                </div>
                            </div>
                        </td>
                    </tr>
                    <%--企业通讯地址 end--%>


                    <tr>
                        <td class="odd focus-state"  <c:if test="${fn:indexOf(FzTypeCode,entTypeCatg) == -1}"> colspan="2" </c:if> >
                            <div class="item-name bg"><strong class="light">* </strong>邮政编码</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="postalCode"
                                       value="${yrOtherInfo.postalCode==null?lastYrOtherInfo.postalCode:yrOtherInfo.postalCode}"
                                       class="ipt-txt w256" placeholder="如您不清楚邮政编号，请填写000000">
                                <i class="icon-close"></i>
                            </div>
                        </td>
                        <%--判断当前登录企业是否是 分支机构 是 则填显示下面--%>
                        <c:if test="${fn:indexOf(FzTypeCode,entTypeCatg) != -1}">
                            <td class="even focus-state">
                                <div class="item-name bg"><strong class="light">* </strong>隶属企业名称</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="supEntname" value="${yrOtherInfo.supEntname}"
                                           class="ipt-txt w256">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </c:if>
                    </tr>

                    <%--判断当前登录企业是否是 分支机构 是 则填显示下面--%>
                    <c:if test="${fn:indexOf(FzTypeCode,entTypeCatg) != -1}">
                        <tr>
                            <td class="odd focus-state" colspan="2">
                                <div class="item-name bg"><strong class="light">* </strong>隶属企业统一代码/注册号</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="supRegNO" value="${yrOtherInfo.supRegNO}"
                                           class="ipt-txt w746" placeholder="无隶属企业统一代码则填写注册号">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                    </c:if>


                    <c:if test="${empty sessionScope.midBaseInfoDto.uniCode}">
                        <tr>
                            <td class="odd focus-state" colspan="2">
                                <div class="item-name">
                                    <i class="icon-question" id="B" data-id="B"
                                       data-msg="无独立的企业组织机构代码证、税务登记证号时按照母公司信息填写。已获得统一社会信用代码的企业无需填写组织机构代码和税务登记证号码信息"></i>
                                    企业组织机构代码证号
                                </div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="entOrgCode" value="${yrOtherInfo.entOrgCode}"
                                           class="ipt-txt w256">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="even focus-state" colspan="2">
                                <div class="item-name">企业税务证登记号</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="taxRegNo" value="${yrOtherInfo.taxRegNo}"
                                           class="ipt-txt w256">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

		<!-- 企业网站信息 -->
		<div id="webAndStoreInfo" class="mod yonggong">
		    <div class="mod-hd">
		        <div class="title">
		            <h3>网站或网店信息</h3>
		            <p>以下信息请按照企业当前实际情况填写，如有多个网站或网店可多次添加。</p>
		        </div>
		    </div>
		    <div class="mod-bd">
		        <div class="content content-yonggong">
		            <table class="table-public table-yonggong" border="0" cellspacing="0" cellpadding="0">
		                <tr>
		                    <td class="odd focus-state" colspan="2">
		                        <div class="item-name bg"><strong class="light">* </strong>企业是否有网站或网店</div>
		                        <div class="radio-box">
		                            <label><input type="radio" id="js-yes" name="websiteFlag" value="1"  <c:if test="${yrOtherInfo.websiteFlag == '1'}">checked</c:if>/>是</label>
		                            <label><input type="radio" id="js-no" name="websiteFlag" value="0" <c:if test="${yrOtherInfo.websiteFlag == '0'}">checked</c:if>/>否</label>
		                        </div>

                                <c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">
                                    <div class="radio-box" id="js-checkbox" style="display: ${yrOtherInfo.websiteFlag == '1'?'inline-block':'none'};font-size: 14px;">
                                        <div class="radio-box" style="margin-left: 20px;">
                                            <strong class="light">请选择一种类型进行添加</strong>：
                                            <label><input type="checkbox" id="js-checkbox-one"    value="1">信息网站</label>&nbsp;&nbsp;
                                            <label><input type="checkbox" id="js-checkbox-two"    value="2">交易网站</label>&nbsp;&nbsp;
                                            <label><input type="checkbox" id="js-checkbox-three"  value="3">网店(或微店)</label>&nbsp;&nbsp;
                                        </div>
                                    </div>
                                </c:if>

		                    </td>
		                </tr>
		            </table>
		        </div>

                <table class="table-public table-web" style="margin-bottom: 4px;">
                    <thead>
                    <tr>
                        <th width="100">类型</th>
                        <th width="400">名称</th>
                        <th width="400">域名</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="_websit" dataSize="${fn:length(yrWebsiteInfoList)}">
                        <c:forEach var="list" items="${yrWebsiteInfoList}">
                            <tr>
                                <td>
                                    <c:if test="${list.webType=='2'}">网店(或微店)</c:if>
                                    <c:if test="${list.webType=='1'}">${list.webSmallType=='1'?'交易网站':'信息网站'}</c:if>
                                </td>
                                <td>${list.webSitName}</td>
                                <td>${list.webSite}</td>
                                <td>
                                    <a href="javascript:void(0)" class="_show" data-webid="${list.webid}">详情</a>
                                    <c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">
                                        <a href="javascript:void(0)" class="_delete" data-webid="${list.webid}"  data-pripid="${list.priPID}">删除</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
		    </div>
		</div>

	 <%--判断当前登录企业是否是 分支机构或外资企业  如果是则不显示下面填写内容--%>
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
                                <div class="item-name">
                                    <i class="icon-question" id="C" data-id="C" data-msg="企业党员人数不能多于企业从业人数"></i>
                                    <strong class="light">* </strong>
                                    企业从业人员中，党员（含预备党员）人数
                                </div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_numParM" name="numParM" value="${yrOtherInfo.numParM}"
                                           class="ipt-txt">
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name"><strong class="light">* </strong>法定代表人（执行合伙事务人，投资人，经营者）是否为党员
                                </div>
                                <div class="radio-box">
                                    <label><input type="radio" name="resParMSign" value="1"
                                                  <c:if test="${yrOtherInfo.resParMSign=='1'}">checked</c:if> >是</label>
                                    <label><input type="radio" id="No_ResParMSign" name="resParMSign" value="2"
                                                  <c:if test="${yrOtherInfo.resParMSign=='2'}">checked</c:if> >否</label>
                                </div>
                            </td>
                            <td class="even focus-state">
                                <div class="item-name">是否担任党组织书记</div>
                                <div class="radio-box">
                                    <input type="hidden" id="_resParSecSign" name="" value="">
                                    <label><input type="radio" name="resParSecSign" value="1"
                                                  <c:if test="${yrOtherInfo.resParSecSign=='1'}">checked</c:if> >是</label>
                                    <label><input type="radio" name="resParSecSign" value="2"
                                                  <c:if test="${yrOtherInfo.resParSecSign=='2'}">checked</c:if> >否</label>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name">党组织建制</div>
                                <div class="ipt-box">
                                    <select id="parIns" name="parIns" class="select-txt">
                                        <option value="0"
                                                <c:if test="${yrOtherInfo.parIns==null||yrOtherInfo.parIns==''}">selected</c:if> >
                                            未组建党支部
                                        </option>
                                        <option value="1"
                                                <c:if test="${yrOtherInfo.parIns=='1'}">selected</c:if> >党支部
                                        </option>
                                        <option value="2"
                                                <c:if test="${yrOtherInfo.parIns=='2'}">selected</c:if> >党总支
                                        </option>
                                        <option value="3"
                                                <c:if test="${yrOtherInfo.parIns=='3'}">selected</c:if> >党委
                                        </option>
                                    </select>
                                </div>
                                <input type="hidden" id="_parIns" value="${yrOtherInfo.parIns}"/>
                                <input type="hidden" id="parInsCN" name="parInsCN"
                                       value="${yrOtherInfo.parInsCN==null?'未组建党支部':yrOtherInfo.parInsCN}"/>
                            </td>
                            <td class="odd focus-state js-ui-state">
                                <div class="item-name"><strong class="light">* </strong>组建时间</div>
                                <div class="ipt-box">
                                    <input type="text" id="_parSetTime" name="parSetTime"
                                           value="<fmt:formatDate value="${yrOtherInfo.parSetTime}"  pattern="yyyy-MM-dd" />"
                                           class="ipt-txt laydate-icon" readonly="readonly">
                                        <%-- <i class="icon-close"></i>--%>
                                </div>
                            </td>
                        </tr>
                        <tr class="js-ui-state">
                            <td class="odd focus-state">
                                <div class="item-name"><strong class="light">* </strong>组建方式</div>
                                <div class="ipt-box">
                                    <input type="hidden" id="_parOrgW" value="${yrOtherInfo.parOrgW}">
                                    <select id="_one" name="parOrgW" class="select-txt" style="display: none"
                                            disabled="disabled">
                                        <option value="">--请选择--</option>
                                        <option value="1">单独组建</option>
                                        <option value="2">联合组建</option>
                                    </select>

                                    <select id="_two" name="parOrgW" class="select-txt" style="display: none;"
                                            disabled="disabled">
                                        <option value="">--请选择--</option>
                                        <option value="1">单独组建</option>
                                        <option value="2">联合组建</option>
                                        <option value="3">加入社区党组织</option>
                                        <option value="4">加入民营（私营）企业协会党组织</option>
                                        <option value="5">加入上级企业（母公司）党组织</option>
                                    </select>


                                </div>
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
                                    <input type="text" name="otherInfoPatAmount"
                                           value="${yrOtherInfo.otherInfoPatAmount==null?'0':yrOtherInfo.otherInfoPatAmount}"
                                           class="ipt-txt" placeholder="0">
                                    <i class="icon-close"></i>
                                </div>
                                个
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <table class="table-public table-jyxx" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th colspan="3">
                                <span>商标注册与许可使用情况</span>
                                <span class="line"></span>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="odd focus-state" width="355">
                                <span class="line"></span>
                                <div class="item-name">国内商标注册数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="domTraRegs"
                                           value="${yrOtherInfo.domTraRegs==null?'0':yrOtherInfo.domTraRegs}"
                                           class="ipt-txt" placeholder="0">
                                    <i class="icon-close"></i>
                                </div>
                                个
                            </td>
                            <td class="odd focus-state" colspan="2">
                                <div class="item-name">境外商标注册数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="abrTraRegs"
                                           value="${yrOtherInfo.abrTraRegs==null?'0':yrOtherInfo.abrTraRegs}"
                                           class="ipt-txt" placeholder="0">
                                    <i class="icon-close"></i>
                                </div>
                                个
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <span class="line-portrait"></span>
                                <div class="item-name item-name-box">其中：实际在使用商标数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="usingTraRegs"
                                           value="${yrOtherInfo.usingTraRegs==null?'0':yrOtherInfo.usingTraRegs}"
                                           class="ipt-txt" placeholder="0">
                                    <i class="icon-close"></i>
                                </div>
                                个
                            </td>
                            <td class="odd focus-state" width="364">
                                <div class="item-name">许可他人使用商标数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="licOthTraRegs"
                                           value="${yrOtherInfo.licOthTraRegs==null?'0':yrOtherInfo.licOthTraRegs}"
                                           class="ipt-txt" placeholder="0">
                                    <i class="icon-close"></i>
                                </div>
                                个
                            </td>
                            <td class="odd focus-state">
                                <div class="item-name">本年新申请商标数</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="newAppTraRegs"
                                           value="${yrOtherInfo.newAppTraRegs==null?'0':yrOtherInfo.newAppTraRegs}"
                                           class="ipt-txt ipt-txt-sm" placeholder="0">
                                    <i class="icon-close"></i>
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
                                    <input type="text" name="thAnnAdvFee"
                                           value="${yrOtherInfo.thAnnAdvFee==null?'0.00':yrOtherInfo.thAnnAdvFee}"
                                           class="ipt-txt " placeholder="请输入金额">
                                    <i class="icon-close"></i>
                                </div>
                                元
                            </td>
                            <td class="odd focus-state" width="364">
                                <div class="item-name  item-name-box">其中：在互联网投入广告费</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="thIntAnnAdvFee"
                                           value="${yrOtherInfo.thIntAnnAdvFee==null?'0.00':yrOtherInfo.thIntAnnAdvFee}"
                                           class="ipt-txt " placeholder="请输入金额">
                                    <i class="icon-close"></i>
                                </div>
                                元
                            </td>
                        </tr>
                        <tr>
                            <td class="odd focus-state">
                                <div class="item-name"><strong class="light">* </strong>是否经营广告业务</div>
                                <div class="radio-box">
                                    <input type="hidden" id="_advBusFlag" value="${yrOtherInfo.advBusFlag}"/>
                                    <label><input type="radio" name="advBusFlag" value="1"
                                                  <c:if test="${yrOtherInfo.advBusFlag=='1'}">checked</c:if> >专营</label>
                                    <label><input type="radio" name="advBusFlag" value="2"
                                                  <c:if test="${yrOtherInfo.advBusFlag=='2'}">checked</c:if> >兼营</label>
                                    <label><input type="radio" name="advBusFlag" value="0"
                                                  <c:if test="${yrOtherInfo.advBusFlag=='0'}">checked</c:if> >否</label>
                                </div>
                            </td>
                            <td class="odd focus-state js-ui-advBusFlag">
                                <div class="item-name"><strong class="light">* </strong>本年度广告经营额</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_thAdvTurnover" name="thAdvTurnover"
                                           value="${yrOtherInfo.thAdvTurnover==null?'0.00':yrOtherInfo.thAdvTurnover}"
                                           class="ipt-txt " placeholder="请输入金额">
                                    <i class="icon-close"></i>
                                </div>
                                元
                            </td>
                            <td class="odd focus-state js-ui-advBusFlag">
                                <div class="item-name"><strong class="light">* </strong>广告经营上缴税收</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" id="_advTurTaxPaid" name="advTurTaxPaid"
                                           value="${yrOtherInfo.advTurTaxPaid==null?'0.00':yrOtherInfo.advTurTaxPaid}"
                                           class="ipt-txt ipt-txt-sm " placeholder="请输入金额">
                                    <i class="icon-close"></i>
                                </div>
                                元
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
                                    <input type="text" name="thNetTraBusTur"
                                           value="${yrOtherInfo.thNetTraBusTur==null?'0.0000':yrOtherInfo.thNetTraBusTur}"
                                           class="ipt-txt " placeholder="请输入金额">
                                    <i class="icon-close"></i>
                                </div>
                                <strong class="light">万元</strong>
                            </td>
                            <td class="odd focus-state">
                                <span class="line line2"></span>
                                <div class="item-name  item-name-box w188">其中：跨境网络交易进出口经营额</div>
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="partyAccNetAmount"
                                           value="${yrOtherInfo.partyAccNetAmount==null?'0.0000':yrOtherInfo.partyAccNetAmount}"
                                           class="ipt-txt " placeholder="请输入金额">
                                    <i class="icon-close"></i>
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

<div class="btn-box">
    <c:if test="${yrForm.otherinfo!='1'}">
        <input type="button" value="暂存" class="btn-common btn-save js-temporary">
    </c:if>
    <button id="save" class="btn-common btn-save js-save">保存</button>
</div>


<%--传递至js的参数： start--%>
<input type="hidden" id="params_area_address" value="${yrOtherInfo.areaAddress}" ><%--330104000000--%>
<input type="hidden" id="params_stree_address" value="${yrOtherInfo.streeAddress}"><%--330104005000--%>
<input type="hidden" id="params_area_addresscopy" value="${yrOtherInfo.areaAddressCopy}"><%--330104000000--%>
<input type="hidden" id="params_stree_addresscopy" value="${yrOtherInfo.streeAddressCopy}"><%--330104005000--%>
<%--传递至js的参数： end--%>

<!--网店网站操作标记-->
<input type="hidden" id="web-sgin" value="">

<jsp:include page="../../common/footer.jsp"></jsp:include>

<!--模板-->
<script id="table-template-web" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{descText webType}}</td>
        <td>{{webSitName}}</td>
        <td>{{webSite}}</td>
        <td>
			<a href="javascript:void(0)" class="_show" data-webid="{{webid}}" >详情</a>
            <a href="javascript:void(0)" class="_delete" data-webid="{{webid}}"  data-pripid="{{priPID}}">删除</a>
        </td>
    </tr>
    {{/each}}
</script>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<%-- 填报表单中的jquery 这行代码不能删除  这里涉及到提交年报使用到的$.ajax请求--%>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/other/edit_main.js"/>"></script>


</body>
</html>
