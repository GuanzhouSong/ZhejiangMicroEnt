<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="nowdate" class="java.util.Date" />
<fmt:formatDate var="nowyear" value="${nowdate}" pattern="yyyy"/> 
<fmt:formatDate var="duedate" value="${nowdate}" pattern="MMdd"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>个体户年报报送页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<div class="mod caiwu">
    <div class="mod-hd">
<!--    <div class="tips"> -->
<!--     <span class="txt">报表中背景颜色为</span> -->
<!--     <span class="blockage"></span> -->
<!--     <span class="txt">的内容经选择公示后将公示于企业信用信息公示系统</span> -->
<!--    </div> -->
</div>
</div> 


<%--基本信息--%>
<form class="form-horizontal error-bottom" id="form">
  <input type="hidden" name="anCheID" id = "anCheID" value="${yrPbBaseInfo.anCheID}"/>
  <input type="hidden" name="priPID" id ="priPID" value="${yrPbBaseInfo.priPID}"/>
  <input type="hidden" name="year" id ="year" value="${yrPbBaseInfo.year}"/>
  <input type="hidden" name="addRecState" id ="addRecState" value="${yrRegCheck.addRecState}"/>
  <input type="hidden" name="regNO" value="${yrPbBaseInfo.regNO}"/>
  <input type="hidden" name="uniCode" value="${yrPbBaseInfo.uniCode}"/>
  <input type="hidden" id="encodeYear" value="${encodeYear}"/>
  <input type="hidden" id ="websiteFlag" name="websiteFlag" value="${yrPbBaseInfo.websiteFlag}"/>
<div class="mod pbreport-basic">
    <div class="mod-hd">
        <div class="title">
            <h3>基本信息</h3>
            <p>以下内容请按照当前个体工商户最新的情况进行填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact table-selected" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd" colspan="2">
                        <div class="item-name bg">名称字号</div>
                        <div class="ipt-box">
                            <input type="text" name="traName" value="${yrPbBaseInfo.traName}" class="ipt-txt w725 pbReport" readonly>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd">
                        <div class="item-name bg">统一社会信用代码/注册号</div>
                        <div class="ipt-box">
                            <input type="text" class="ipt-txt ipt-txt-lg pbReport" value="${empty yrPbBaseInfo.uniCode ? yrPbBaseInfo.regNO : yrPbBaseInfo.uniCode}" readonly>
                        </div>
                    </td>
                    <td class="odd">
                        <div class="item-name bg">经营者姓名</div>
                        <div class="ipt-box">
                            <input type="text" class="ipt-txt ipt-txt-lg pbReport" name="name" value="${yrPbBaseInfo.name}" readonly>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>对外公开联系电话</div>
                        <select name="" id="isComphone" class="select-txt select-txt-sm pbReport" >
                            <option value="1" <c:if test="${!empty yrPbBaseInfo.tel}">selected</c:if> >有</option>
                            <option value="0" <c:if test="${empty yrPbBaseInfo.tel}">selected</c:if> >无</option>
                        </select>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="tel" id="comPhone" value="${yrPbBaseInfo.tel}" class="ipt-txt w184 pbReport">
                            <c:if test="${!empty yrPbBaseInfo.tel}"><i class="icon-close" id="comPhoneClose"></i></c:if>
                        </div>
                    </td>
                    <td class="odd focus-state">
                        <div class="item-name"><strong class="light">* </strong>联系手机号码</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="comPhone" value="${yrPbBaseInfo.comPhone}" class="ipt-txt ipt-txt-lg pbReport">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>



<!--                 <tr> -->
<!--                     <td class="odd focus-state" colspan="2"> -->
<!--                         <div class="item-name special "> -->
<!--                             <strong class="light">* </strong>经营场所 -->
<!--                         </div> -->
<!--                         <div class="ipt-box"> -->
<!--                             <div class="item-select"> -->
<!--                                 <select name="" class="select-txt" disabled> -->
<!--                                     <option value="330000000000">浙江省</option> -->
<!--                                 </select> -->
<!--                                 <select name="cityAddressCopy" class="select-txt" id="select_city_copy" > -->
<!--                                     <option value="" >--请选择--</option> -->
<!--                                 </select> -->
<!--                                 <select name="areaAddressCopy" class="select-txt" id="select_area_copy" > -->
<!--                                     <option value="" >--请选择--</option> -->
<!--                                 </select> -->
<!--                                 <select name="streeAddressCopy" class="select-txt" id="select_stree_copy" > -->
<!--                                     <option value="" >--请选择--</option> -->
<!--                                 </select> -->
<!--                             </div> -->
<!--                             <div class="ipt-box js-ipt-box"> -->
<%--                                 <input type="text" id="" class="ipt-txt" name="opLoc" value="${yrPbBaseInfo.opLoc}" placeholder="" readonly > --%>
<!--                             </div> -->
<!--                         </div> -->
<!--                     </td> -->
<!--                 </tr> -->



                <%--实际经营场所 start--%>
<!--                 <tr> -->
<!--                     <td class="odd focus-state" colspan="2"> -->
<!--                         <div class="item-name special "> -->
<!--                             <strong class="light">* </strong>实际经营场所 -->
<!--                         </div> -->
<!--                         <div class="ipt-box"> -->
<!--                             <div class="item-select"> -->
<!--                                 <select name="" class="select-txt" disabled> -->
<!--                                     <option value="330000000000">浙江省</option> -->
<!--                                 </select> -->
<!--                                 <select name="cityAddress" class="select-txt" id="select_city" > -->
<!--                                     <option value="" >--请选择--</option> -->
<!--                                 </select> -->
<!--                                 <select name="areaAddress" class="select-txt" id="select_area" > -->
<!--                                     <option value="" >--请选择--</option> -->
<!--                                 </select> -->
<!--                                 <select name="streeAddress" class="select-txt" id="select_stree" > -->
<!--                                     <option value="" >--请选择--</option> -->
<!--                                 </select> -->
<!--                                 <div class="ipt-box js-ipt-box"> -->
<%--                                     <input type="text" id="desc_address" class="ipt-txt" name="desAddress" value="${yrPbBaseInfo.desAddress}" style="width: 226px;"> --%>
<!--                                     <i class="icon-close" id="icon-close-delete"></i> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                             <div class="ipt-box js-ipt-box"> -->
<%--                                 <input type="text" id="info_address" class="ipt-txt" name="addr" value="${yrPbBaseInfo.addr}" placeholder="" readonly > --%>
<!--                             </div> -->
<!--                         </div> -->
<!--                     </td> -->
<!--                 </tr> -->
                <%--实际经营场所 end--%>





            
               <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name">经营场所</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="opLoc" value="${yrPbBaseInfo.opLoc}" class="ipt-txt w725 pbReport" readonly="readonly"   placeholder="请按照实际情况填写自己现在的住址">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>资金数额</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="fundAm" id="fundAm" value="${yrPbBaseInfo.fundAm}" class="ipt-txt ipt-txt-lg finance pbReport" placeholder="0.00">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
<!--                     <td class="odd focus-state"> -->
<%--                         <div class="item-name bg"><strong class="light">* </strong>其中，${yrRegCheck.year}年投入经营资金</div> --%>
<!--                         <div class="ipt-box js-ipt-box"> -->
<%--                             <input type="text" name="pbFundAm" id="pbFundAm" value="${yrPbBaseInfo.pbFundAm}" class="ipt-txt ipt-txt-lg finance pbReport" placeholder="0.00"> --%>
<!--                             <i class="icon-close"></i> -->
<!--                         </div> -->
<!--                         <strong class="light">元</strong> -->
<!--                     </td> -->
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name bg"><strong class="light">* </strong>${yrRegCheck.year}年末,从业人数（含雇工）</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="empNum" id= "empNum" value="${yrPbBaseInfo.empNum}" class="ipt-txt ipt-txt-lg pbReport" placeholder="填写大于1的整数">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">人</strong>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name">其中，经营者属于</div>
                        <div class="radio-box pbReport">
                            <label><input type="radio" name="isLegRep" value="1" <c:if test="${yrPbBaseInfo.isLegRep == '1'}">checked</c:if> class="conForm">高校毕业生</label>
                            <label><input type="radio" name="isLegRep" value="2" <c:if test="${yrPbBaseInfo.isLegRep == '2'}">checked</c:if> class="conForm">退役士兵</label>
                            <label><input type="radio" name="isLegRep" value="3" <c:if test="${yrPbBaseInfo.isLegRep == '3'}">checked</c:if> class="conForm">残疾人</label>
                            <label><input type="radio" name="isLegRep" value="4" <c:if test="${yrPbBaseInfo.isLegRep == '4'}">checked</c:if> class="conForm">失业人员再就业</label>
                            <label><input type="radio" name="isLegRep" value="5" <c:if test="${yrPbBaseInfo.isLegRep == '5'}">checked</c:if> class="conForm">都不是</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name">其中，雇工人员中属于</div>
                        高校毕业生
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="uniGradEmps" id="uniGradEmps" value="${yrPbBaseInfo.uniGradEmps}" class="ipt-txt ipt-txt-sm pbReport" placeholder="0">
                            <i class="icon-close"></i>
                        </div>
                        退役士兵
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="exSoldEmps" id="exSoldEmps" value="${yrPbBaseInfo.exSoldEmps}" class="ipt-txt ipt-txt-sm pbReport" placeholder="0" >
                            <i class="icon-close"></i>
                        </div>
                        残疾人
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="disEmps" id="disEmps" value="${yrPbBaseInfo.disEmps}" class="ipt-txt ipt-txt-sm pbReport" placeholder="0" >
                            <i class="icon-close"></i>
                        </div>
                        失业人员再就业
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="unemEmps" id="unemEmps" value="${yrPbBaseInfo.unemEmps}" class="ipt-txt ipt-txt-sm pbReport" placeholder="0" >
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--经营信息--%>
<div class="mod contact">
    <div class="mod-hd">
        <div class="title">
            <h3>经营信息</h3>
            <p>以下内容请按照${yrRegCheck.year}年1月1日-12月31日期间的信息进行填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg js-ipt-box"><strong class="light">* </strong>营业额或营业收入</div>
                        <div class="ipt-box">
                            <input type="text" name="vendInc" value="${yrPbBaseInfo.vendInc}" id="vendInc" class="ipt-txt ipt-txt-lg finance pbReport" placeholder="0.00">
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
<!--                     <td class="odd focus-state"> -->
<!--                         <div class="item-name"><strong class="light">* </strong>本条信息是否向社会公开</div> -->
<!--                         <div class="radio-box"> -->
<%--                             <label><input type="radio" name="vendIncIsPub" value="1" <c:if test="${yrPbBaseInfo.vendIncIsPub == '1'}">checked</c:if> >是</label> --%>
<%--                             <label><input type="radio" name="vendIncIsPub" value="0" <c:if test="${yrPbBaseInfo.vendIncIsPub == '0'}">checked</c:if> >否</label> --%>
<!--                         </div> -->
<!--                     </td> -->
                </tr>
                <tr>
                    <td class="odd focus-state" colspan="2">
                        <div class="item-name"><strong class="light">* </strong>属于免征纳税对象</div>
                        <div class="radio-box">
                            <label><input type="radio" name="rreeTaxIs" id="rreeTaxYes" value="1" <c:if test="${yrPbBaseInfo.rreeTaxIs == '1'}">checked</c:if> >是</label>
                            <label><input type="radio" name="rreeTaxIs" id="rreeTaxNo" value="0" <c:if test="${yrPbBaseInfo.rreeTaxIs == '0'}">checked</c:if> >否</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg"><strong class="light">* </strong>纳税总额</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="ratGro" id="ratGro"  value="${yrPbBaseInfo.ratGro}" class="ipt-txt ipt-txt-lg finance pbReport" placeholder="0.00">
                            <i class="icon-close viewicon"></i>
                        </div>
                        <strong class="light">元</strong>
                    </td>
<!--                     <td class="odd focus-state"> -->
<!--                         <div class="item-name"><strong class="light">* </strong>本条信息是否向社会公开</div> -->
<!--                         <div class="radio-box pbReport"> -->
<%--                             <label><input type="radio" name="ratGroIsPub" value="1" <c:if test="${yrPbBaseInfo.ratGroIsPub == '1'}">checked</c:if> >是</label> --%>
<%--                             <label><input type="radio" name="ratGroIsPub" value="0" <c:if test="${yrPbBaseInfo.ratGroIsPub == '0'}">checked</c:if> >否</label> --%>
<!--                         </div> -->
<!--                     </td> -->
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--共产党员党建情况--%>
<div class="mod contact">
    <div class="mod-hd">
        <div class="title">
            <h3>共产党员党建情况</h3>
            <p>以下内容请按照当前你个体工商户最新的情况进行填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name w240"><strong class="light">*</strong>从业人员中，有中共党员（含预备党员）</div>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" id="numParM" name ="numParM" value="${yrPbBaseInfo.numParM}" class="ipt-txt pbReport" placeholder="0" >
                            <i class="icon-close"></i>
                        </div>
                        <strong class="light">人</strong>
                    </td>
                    <td class="odd">
                        <div class="item-name w240"><strong class="light">*</strong>已独立或联合建立党支部</div>
                        <div class="radio-box">
                            <label><input type="radio" name="partOrgIs" value="1" <c:if test="${yrPbBaseInfo.partOrgIs == '1'}">checked</c:if> >是</label>
                            <label><input type="radio" name="partOrgIs" value="0" <c:if test="${yrPbBaseInfo.partOrgIs == '0'}">checked</c:if> >否</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name w240"><strong class="light">*</strong>经营者本人为党员</div>
                        <div class="radio-box">
                            <label><input type="radio" name="resParMSign" id="resParMSignYes" value="1" <c:if test="${yrPbBaseInfo.resParMSign == '1'}">checked</c:if>>是</label>
                            <label><input type="radio" name="resParMSign" id="resParMSignNO" value="2" <c:if test="${yrPbBaseInfo.resParMSign == '2'}">checked</c:if> >否</label>
                        </div>
                    </td>
                    <td class="odd">
                        <div class="item-name w240"><strong class="light">*</strong>经营者本人为党组织书记</div>
                        <div class="radio-box">
                            <label><input type="radio" name="resParSecSign" value="1" class ="resParSecSign" <c:if test="${yrPbBaseInfo.resParSecSign == '1'}">checked</c:if> >是</label>
                            <label><input type="radio" name="resParSecSign" value="2" class = "resParSecSign" <c:if test="${yrPbBaseInfo.resParSecSign == '2'}">checked</c:if> >否</label>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</form>


<%--添加开设网站网店情况--%>
<%--添加开设网站网店情况--%>
<div class="mod mod-border investment-info js-content-show" id = "mod_website" style="display: none;">
    <div class="mod-hd" >
        <div class="title">
            <h3>添加开设网站网店情况</h3>
            <p>以下内容请按照当前你个体工商户最新的情况进行填写，新增信息请点击"添加"，选中已填写的信息可进行修改与删除操作</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <form class="form-horizontal error-bottom" id="websiteForm">
              <input type="hidden" name="anCheID" class="anCheID" value="${yrPbBaseInfo.anCheID}"><!-- 年报id -->
              <input type="hidden" name="webID" id="webID" class="webhidden" value="${yrPbWebsiteInfo.webID}"><!-- 网站id -->
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd">
                            <div class="item-name">类型</div>
                            <select name="webType" id="webselect" class="select-txt w245 pbReport">
                                <option value="1" class="pbReport">网站</option>
                                <option value="2" class="pbReport">网店</option>
                            </select>
                        </td>
                        <td class="odd focus-state">
                            <div class="item-name">名称</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="webSitName" id ="webSitName"  class="ipt-txt  ipt-txt-lg pbReport" placeholder="输入名称" >
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state" colspan="2">
                            <div class="item-name">网址</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="webSite" id ="webSite"  class="ipt-txt w720 pbReport" placeholder="输入网址" >
                                <i class="icon-close"></i>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn-box">
                    <input type="submit" value="确定" id="websave" class="btn-common pbReport">
                    <input type="button" value="取消" id="webcancel"class="btn-common ">
                </div>
            </form>
        </div>
    </div>
</div>


<%--开设网站网店情况--%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>开设网站网店情况</h3>
            <div class="btn-box">
                <a class="btn-common btn-add pbReportbutton" id="js-website-add" >新增</a>
            </div>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-yonggong">
            <table class="table-public table-yonggong" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td class="odd focus-state">
                        <div class="item-name bg">企业是否有网站或网店</div>
                        <div class="radio-box">
                            <label><input type="radio" id="_yes" name="websiteFlag" value="1"  <c:if test="${yrPbBaseInfo.websiteFlag == '1'}">checked</c:if>/>是</label>
                            <label><input type="radio" id="_no" name="websiteFlag" value="0" <c:if test="${yrPbBaseInfo.websiteFlag == '0'}">checked</c:if>/>否</label>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    
    
    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips">
                <label><input type="checkbox" id="checkWebAll" >全选</label>
                默认读取开设网站网店信息<c:if test="${yrRegCheck.reportState == '00' || yrRegCheck.reportState == '13' || yrRegCheck.reportState == '20'}">，请根据企业当前实际情况进行<strong class="light">添加/修改</strong></c:if>
                <div class="fr edit">
                    <a  href="javascript:void(0);" id="js-website-edit" class="pbReportbutton">修改</a>
                    <a  href="javascript:void(0);" id="js-website-delete" class="pbReportbutton" >删除</a>
                </div>
<%--网站示例--%>
                <a href="javascript:void(0);" class="js-write-tips">
                    填写示例
                </a>
                <div class="tip-cont js-tip-cont none">
                    <h3>填写示例</h3>
                    <table class="table-public table-web table-layer" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <th width="90">类型</th>
                            <th>网站或网店名称</th>
                            <th>网址(域名)</th>
                        </tr>
                        <tr>
                            <td>网站</td>
                            <td>汇信科技</td>
                            <td>http://www.icinfo.cn</td>
                        </tr>
                        <tr>
                            <td>网店</td>
                            <td>汇信科技</td>
                            <td>http://www.icinfo.cn</td>
                        </tr>
                    </table>
                </div>
            </div>
<!-- 网站查询信息 -->
            <div style="overflow-y: auto;min-height: 30px">
             
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="90" class="bg">序号</th>
                        <th width="90" class="bg">类型</th>
                        <th class="bg">名称</th>
                        <th class="bg">网址</th>
                    </tr>
                    </thead>
                    <tbody id="dbao_page">
                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount"></em> 条信息，共<em id="pageCount"></em>页</span>
                <div id="pagination2" class="pagination">
                </div>
            </div>
        </div>
    </div>
</div>






<!-- <div id="webAndStoreInfo" class="mod yonggong"> -->
<!--     <div class="mod-hd"> -->
<!--         <div class="title"> -->
<!--             <h3>网站或网店信息</h3> -->
<!--             <p>以下信息请按照企业当前实际情况填写，如有多个网站或网店可多次添加。</p> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="mod-bd"> -->
<!--         <div class="content content-yonggong"> -->
<!--             <table class="table-public table-yonggong" border="0" cellspacing="0" cellpadding="0"> -->
<!--                 <tr> -->
<!--                     <td class="odd focus-state"> -->
<!--                         <div class="item-name bg">企业是否有网站或网店</div> -->
<!--                         <div class="radio-box"> -->
<%--                             <label><input type="radio" id="_yes" name="websiteFlag" value="1"  <c:if test="${yrPbBaseInfo.websiteFlag == '1'}">checked</c:if>/>是</label> --%>
<%--                             <label><input type="radio" id="_no" name="websiteFlag" value="0" <c:if test="${yrPbBaseInfo.websiteFlag == '0'}">checked</c:if>/>否</label> --%>
<!--                         </div> -->
<!--                     </td> -->
<!--                 </tr> -->
<!--             </table> -->
<!--         </div> -->
<!--     </div> -->
<!-- </div> -->





<!-- <div id="qywz" class="mod yonggong"> -->
<!--     <div class="mod-hd"> -->
<!--         <div class="title"> -->
<!--             <h3>企业网站信息</h3> -->
<!--         </div> -->
<!--     </div> -->

<!--     <div class="mod-bd"> -->
<%--         <div class="content table-website" id="table-website-div"  <c:if test="${yrPbBaseInfo.websiteFlag == '0'}">style="display: none;"</c:if>> --%>
<%--         	<c:if test="${yrRegCheck.addRecState != '2'}"> --%>
<!--             <form class="form-horizontal error-bottom" id="websitForm"> -->
<!--             	<input type="hidden" name="icpBackNO" id="icpBackNO"/>  -->
<!--                 <table class="table-public table-website" border="0" cellspacing="0" cellpadding="0"> -->
<!--                     <tr class="_wesittrhide"> -->
<!--                         <td class="odd focus-state"> -->
<!--                             <div class="item-name bg"> -->
<!--                                 <div class="radio-box"> -->
<%--                                     <input type="hidden" id="webid" name="webid" value=""> --%>
<%--                                     <input type="hidden" name="priPID" value="${priPID}"/> --%>
<%--                                     <input type="hidden" name="year" value="${year}"/> --%>
<%--                                     <input type="hidden" name="anCheID" value="${yrPbBaseInfo.anCheID}"> --%>
<%--                                     网站网店类型 --%>
<!--                                     <label><input type="radio" name="webType" value="1" id="webinput1">网站</label> -->
<!--                                     <label><input type="radio" name="webType" value="2" id="webinput2">网店</label> -->
<!--                                 </div> -->
<!--                                	 网站或网店名称 -->
<!--                             </div> -->
<!--                             <div class="ipt-box js-ipt-box"> -->
<!--                                 <input type="text" id="webSitName" name="webSitName" value="" class="ipt-txt"> -->
<!--                                 <i class="icon-close"></i> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                         <td class="odd focus-state"> -->
<!--                             <div class="item-name bg"> -->
<!--                                 <i class="icon-question" id="wz-wd" data-id="wz-wd" -->
<%--                                    data-msg="网站/网店的网址,如：http://www.baidu.com</br>https://www.baidu.com"></i> --%>
<!--                               		  网址（域名） -->
<!--                             </div> -->
<!--                             <div class="ipt-box js-ipt-box"> -->
<!--                                 <input type="text" id="webSite" name="webSite" value="" class="ipt-txt"> -->
<!--                                 <i class="icon-close"></i> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                     <tr id="webTr2" style="display: none;"> -->
<!--                         <td class="focus-state col-website2" colspan="2"> -->
<!--                             <div class="item-name">所属平台名称</div> -->
<!--                             <div class="radio-box" id="belongPlatFormName_div"> -->
<!--                                 <label> -->
<!--                                     <input type="radio" name="belongPlatFormRadio" value="天猫" id ="belong_checkbox">天猫 -->
<!--                                 </label> -->
<!--                                 <label> -->
<!--                                     <input type="radio" name="belongPlatFormRadio" value="淘宝">淘宝 -->
<!--                                 </label> -->
<!--                                 <label> -->
<!--                                     <input type="radio" name="belongPlatFormRadio" value="京东">京东 -->
<!--                                 </label> -->
<!--                                 <label> -->
<!--                                     <input type="radio" name="belongPlatFormRadio" value="1688">1688 -->
<!--                                 </label> -->
<!--                                 <label> -->
<!--                                     <input type="radio" name="belongPlatFormRadio" value="other" id="belongPlatFormRadio_other">其他 -->
<!--                                 </label> -->
<!--                             </div> -->
<!--                             <div class="ipt-box js-ipt-box" id="belongPlatFormInput_div" style="display: none;"> -->
<!--                             	<input type="hidden" name="belongPlatFormName" id="belongPlatFormName"> -->
<!--                                 <input type="text" id="belongPlatFormNameother" class="ipt-txt" style="width:150px;"> -->
<!--                                 <i class="icon-close"></i> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                     <tr id="webTr3" style="display: none;"> -->
<!--                         <td class="focus-state col-website2" colspan="2"> -->
<!--                             <div class="item-name"> 发货地址</div> -->
<!--                             <div class="ipt-box js-ipt-box"> -->
<!--                                 <input type="text" value="" name="sendAddress" id="sendAddress" class="ipt-txt" style="width:753px;"> -->
<!--                                 <i class="icon-close"></i> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                     <tr id="webTr4" style="display: none;"> -->
<!--                         <td class="focus-state col-website2" colspan="2"> -->
<!--                             <div class="item-name"> 退货地址</div> -->
<!--                             <div class="ipt-box js-ipt-box"> -->
<!--                                 <input type="text" value="" name="backAddress" id="backAddress" class="ipt-txt" style="width:753px;"> -->
<!--                                 <i class="icon-close"></i> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                 </table> -->
<!--                 <table class="table-public table-website comp-add-detail"  id="webTable2" style="display: none;"> -->
<!--                 	<tr> -->
<!--                         <td class="odd focus-state" colspan="2"> -->
<!--                             <div class="item-name">网站类型</div> -->
<!--                             <div class="radio-box check-box"> -->
<!--                             	<select name="webSmallType" id="webSmallType" class="select-txt select-txt-sm"> -->
<!--                             		<option value="">请选择</option> -->
<!--                             		<option value="1">网络交易平台</option> -->
<!--                             		<option value="2">企业信息网</option> -->
<!--                             	</select> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                     <tr id="webTr1" style="display: none;"> -->
<!--                         <td class="odd focus-state" colspan="2"> -->
<!--                             <div class="item-name"> -->
<!--                                 ICP证号/备案号 -->
<!--                             </div> -->
<!--                             <div class="ipt-box js-ipt-box"> -->
<!--                                 <input type="text" value="" id="webicpbackno2" class="ipt-txt"  style="width: 340px;"> -->
<!--                                 <i class="icon-close"></i> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                 </table> -->
<!--                 <table class="table-public table-website comp-add-detail"  id="webTable1" style="display: none;"> -->
<!--                     <tr> -->
<!--                         <td class="odd focus-state" colspan="2"> -->
<!--                             <div class="item-name">网络交易平台运营类型</div> -->
<!--                             <div class="radio-box check-box"> -->
<!--                                 <input type="hidden" id="webPlatFormType" name="webPlatFormType"> -->
<!--                                 <label><input type="radio" name="webPlatFormTypecbox" id="webPlatFormType3" value="第三方（含自营）网络交易平台">第三方（含自营）网络交易平台</label> -->
<!--                                 <label><input type="radio" name="webPlatFormTypecbox" id="webPlatFormType1" value="第三方网络交易平台">第三方网络交易平台</label> -->
<!--                                 <label><input type="radio" name="webPlatFormTypecbox" id="webPlatFormType2" value="自营网络交易平台">自营网络交易平台</label> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                     <tr> -->
<!--                         <td class="odd focus-state" colspan="2"> -->
<!--                             <div class="item-name">网络交易产品类型</div> -->
<!--                             <div class="radio-box check-box"> -->
<!--                                 <input type="hidden" id="webGoodsType" name="webGoodsType" value="1"> -->
<!--                                 <label><input type="radio" name="webGoodsTypecbox" id="webGoodsType3" value="商品及服务交易类平台">商品及服务交易类平台</label> -->
<!--                                 <label><input type="radio" name="webGoodsTypecbox" id="webGoodsType1" value="商品交易类平台">商品交易类平台</label> -->
<!--                                 <label><input type="radio" name="webGoodsTypecbox" value="服务交易类平台">服务交易类平台</label> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                     <tr> -->
<!--                         <td class="odd focus-state" colspan="2"> -->
<!--                             <div class="item-name">电商类型</div> -->
<!--                             <div class="radio-box"> -->
<!--                             	<input type="hidden" name="eCommerceType" id="eCommerceType"> -->
<!--                                 <label><input type="radio" name="eCommerceTyperadio" id="eCommerceTyperadio1" value="B2B" checked="checked">B2B</label> -->
<!--                                 <label><input type="radio" name="eCommerceTyperadio" value="B2C">B2C</label> -->
<!--                                 <label><input type="radio" name="eCommerceTyperadio" value="C2C">C2C</label> -->
<!--                                 <label><input type="radio" name="eCommerceTyperadio" value="团购">团购</label> -->
<!--                                 <label><input type="radio" name="eCommerceTyperadio" value="其他">其他</label> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                     <tr> -->
<!--                         <td class="odd focus-state" colspan="2"> -->
<!--                             <div class="item-name">ICP证号/备案号</div> -->
<!--                             <div class="ipt-box js-ipt-box"> -->
<!--                                 <input type="text" id="webicpbackno1" value="" class="ipt-txt "> -->
<!--                                 <i class="icon-close"></i> -->
<!--                             </div> -->

<!--                         </td> -->
<!--                     </tr> -->
<!--                     <tr> -->
<!--                         <td class="odd focus-state" colspan="2"> -->
<!--                             <div class="item-name">微信公众服务号</div> -->
<!--                             <div class="radio-box"> -->
<!--                                 <label><input type="radio" name="weChatPublicNOradio" id="weChatPublicNOradio1" value="1" checked="checked">无</label> -->
<!--                                 <label><input type="radio" name="weChatPublicNOradio" id="weChatPublicNOradio2" value="2">有</label> -->
<!--                             </div> -->
<!--                             <div class="ipt-box js-ipt-box"  style="display: none;" id="weChatPublicNOdiv"> -->
<!--                                 <input type="text" id="weChatPublicNO"  name="weChatPublicNO" class="ipt-txt "> -->
<!--                                 <i class="icon-close"></i> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                     <tr> -->
<!--                         <td class="odd focus-state" colspan="2"> -->
<!--                             <div class="item-name">APP软件名称</div> -->
<!--                             <div class="radio-box"> -->
<!--                                 <label><input type="radio" name="appNamesradio" id="appNamesradio1" value="1" checked="checked">无</label> -->
<!--                                 <label><input type="radio" name="appNamesradio" id="appNamesradio2" value="2">有</label> -->
<!--                             </div> -->
<!--                             <div class="ipt-box js-ipt-box" style="display: none;" id="appNamesdiv"> -->
<!--                                 <input type="text" id="appNames" name="appNames" placeholder="只填写应用名称，可填写多个，名称之间请用逗号隔开" class="ipt-txt w580"> -->
<!--                                 <i class="icon-close"></i> -->
<!--                             </div> -->
<!--                         </td> -->
<!--                     </tr> -->
<!--                 </table> -->
<!--                 <table class="table-public table-website comp-add-detail"  > -->
<!--                 <tr> -->
<!--                         <td class="center"> -->
<!--                <div class="mt10"> -->
<!--                    <button id="webSit_add" type="submit" class="btn-common btn-add">添加</button> -->
<!--                    <button id="webSit_cancel" class="btn-common btn-add" style="display:none">取消</button> -->
<!--                </div> -->
<!--                 </td> -->
<!--                     </tr> -->
<!--                </table> -->
<!--             </form> -->
<%--             </c:if> --%>
<!--             <table class="table-public table-web"> -->
<!--                 <thead> -->
<!--                 <tr> -->
<!--                     <th width="88">类型</th> -->
<!--                     <th width="220">名称</th> -->
<!--                     <th width="300">域名</th> -->
<!--                     <th width="200">ICP证号/备案号</th> -->
<!--                     <th>操作</th> -->
<!--                 </tr> -->
<!--                 </thead> -->
<!--                 <tbody id="_websit"> -->
<%--                 <c:forEach var="list" items="${yrPbWebsiteInfoList}"> --%>
<!--                     <tr> -->
<%--                         <td>${list.webType==1?'网站':'网店'}</td> --%>
<%--                         <td>${list.webSitName}</td> --%>
<%--                         <td>${list.webSite}</td> --%>
<%--                         <td>${list.icpBackNO}</td> --%>
<!--                         <td> -->
<%--                             <a href="javascript:void(0)" class="_show" data-webid="${list.webID}" data-webtypekey="${list.webType}">详情</a> --%>
<%--                             <c:if test="${yrRegCheck.addRecState != '2'}"> --%>
<%--                             <a href="javascript:void(0)" class="_delete" data-webid="${list.webID}">删除</a> --%>
<%--                             </c:if> --%>
<!--                         </td> -->
<!--                     </tr> -->
<%--                 </c:forEach> --%>
<!--                 </tbody> -->
<!--             </table> -->
<!--         </div> -->
<!--     </div>	 -->
<!-- </div> -->

<%--添加取得许可证情况 block--%>
<div class="mod mod-border investment-info js-content-show" id= "mod_licence" style="display: none;">
    <div class="mod-hd">
        <div class="title">
            <h3>添加取得许可证情况</h3>
            <p>以下内容请按照当前你个体工商户经营范围中涉及的前置或后置许可证进行填写</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <form class="form-horizontal error-bottom" id="licenceForm">
              <input type="hidden" name="licName" id ="licName" class="lichidden" value="${yrPbLicenceInfo.licName}" ><!-- 许可证code -->
              <input type="hidden" name="anCheID" class="anCheID" value="${yrPbBaseInfo.anCheID}" ><!-- 年报id -->
              <input type="hidden" name="licID" id="licID" class="lichidden" value="${yrPbLicenceInfo.licID}"><!-- 许可证id -->
                <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">行政许可名称</div>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" name="licNameCN" id ="licNameCN" class="ipt-txt ipt-txt-lg sfcreport" placeholder="选择经营范围内涉及的许可" >
                                <i class="icon-close"></i>
                            </div>
                            <strong class="light pointer" id="licenceList">许可证列表</strong>
                        </td>
                    </tr>
                    <tr>
                        <td class="odd focus-state">
                            <div class="item-name">有效期至</div>
                            <div class="ipt-box">
                                <input type="text" readonly name="valTo" id="valTo" class="ipt-txt laydate-icon ipt-txt-lg pbReport" placeholder="选择许可证有效期截止日期" 
                                       onclick="laydate({istime:true})">
                            </div>
                            <strong class="light"><label><input type="checkbox" name="longTime"  id="longTime"/>无有效期或长期有效</label></strong>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn-box">
                    <input type="submit" value="确定" class="btn-common pbReport">
                    <input type="button" value="取消" class="btn-common" id="licenceCancel">
                </div>
            </form>
        </div>
    </div>
</div>
<%--取得许可证情况--%>
<div class="mod subcapital">
    <div class="mod-hd">
        <div class="title">
            <h3>取得许可证情况</h3>
            <div class="btn-box">
                <a class="btn-common btn-add pbReportbutton" id="js-add">新增</a>
            </div>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
            <div class="subcapital-tips">
                <label><input type="checkbox" id="checkLicAll">全选</label>
                默认读取许可证信息，请根据企业当前实际情况进行<strong class="light ">添加/修改</strong>
                <div class="fr edit">
                    <a id="js-edit" href="javascript:void(0);" class="pbReportbutton">修改</a>
                    <a id="js-delete" href="javascript:void(0);" class="pbReportbutton">删除</a>
                </div>
            </div>
            <div style="overflow-y: auto;min-height: 30px">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="90" class="bg">序号</th>
                        <th class="bg">行政许可名称</th>
                        <th class="bg">有效期至</th>
                    </tr>
                    </thead>
                    <tbody id="dbao_page_one">
                    </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount1"></em> 条信息，共<em id="pageCount1"></em>页</span>
                <div id="pagination1" class="pagination">
                </div>
            </div>
        </div>
    </div>
</div>


<%--联系信息--%>
<!-- <div class="mod pbreport-basic"> -->
<!--     <div class="mod-hd"> -->
<!--         <div class="title"> -->
<!--             <h3>联系信息</h3> -->
<!--             <p>已办理过工商联络员确认手续的个体户请核对以下信息是否正确；</br>未办理过工商联络员确认手续的个体户请按照实际报告情况的情况进行填写 -->
<!--             </p> -->
<!--         </div> -->
<!--     </div> -->
<!--     <form id="epasswordForm" > -->
<%--      <input type="hidden" name ="uid" value="${pubEppassword.uid }" > --%>
<!--      <input type="hidden" name ="pasStatus" value="01"  > -->
<%--      <input type="hidden" name ="pasid" value="${pubEppassword.pasid}" > --%>
    
<!--     <div class="mod-bd"> -->
<!--         <div class="content content-contact"> -->
<!--             <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0"> -->
<!--                 <tbody> -->
<!--                 <tr> -->
<!--                     <td class="odd focus-state"> -->
<!--                         <div class="item-name"><strong class="light">* </strong>法定代表人姓名</div> -->
<!--                         <div class="ipt-box js-ipt-box"> -->
<%--                             <input type="text" name ="lerep" value="${empty pubEppassword.lerep ? yrPbBaseInfo.name : pubEppassword.lerep}" id="lerep"  class="ipt-txt ipt-txt-lg sfcreport" readonly="readonly" placeholder="请输入姓名" > --%>
<!--                         </div> -->
<!--                     </td> -->
<!--                     <td class="odd focus-state"> -->
<!--                         <div class="item-name"><strong class="light">* </strong>法定代表人手机号码</div> -->
<!--                         <div class="ipt-box js-ipt-box"> -->
<%--                             <input type="text" name="apprevieworg" id="lerepphone"  value="${empty pubEppassword.lerepphone ? yrPbBaseInfo.tel : pubEppassword.lerepphone}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="请输入手机号码" > --%>
<!--                             <i class="icon-close viewicon"></i> -->
<!--                         </div> -->
<!--                     </td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td class="odd focus-state"> -->
<!--                         <div class="item-name"><strong class="light">* </strong>工商联络员姓名</div> -->
<!--                         <div class="ipt-box js-ipt-box"> -->
<%--                             <input type="text" name="lianame" id ="lianame" value="${pubEppassword.lianame}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="请输入联络员姓名" > --%>
<!--                             <i class="icon-close viewicon"></i> -->
<!--                         </div> -->
<!--                     </td> -->
<!--                     <td class="odd focus-state"> -->
<!--                         <div class="item-name"><strong class="light">* </strong>联络员手机号码</div> -->
<!--                         <div class="ipt-box js-ipt-box"> -->
<%--                             <input type="text" name="lerepphone" id="tel" value="${pubEppassword.tel}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="请输入联络员手机号码" > --%>
<!--                             <i class="icon-close viewicon"></i> -->
<!--                         </div> -->
<!--                     </td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td class="odd focus-state"> -->
<!--                         <div class="item-name"><strong class="light">* </strong>联络员证件类型</div> -->
<!--                         <select name="liaidtype" id="liaidtype" class="select-txt w245 sfcreport" onfocus="this.defaultIndex=this.selectedIndex;" onchange="this.selectedIndex=this.defaultIndex;"> -->
<%--                             <c:forEach items="${Certypes}" var="certype" varStatus="status"> --%>
<%-- 			                		<option value="${certype.code }" <c:if test="${pubEppassword.liaidtype == certype.code}">selected</c:if> >${certype.content }</option> --%>
<%-- 			                </c:forEach> --%>
<!--                         </select> -->
<!--                     </td> -->
<!--                     <td class="odd focus-state"> -->
<!--                         <div class="item-name"><strong class="light">* </strong>联络员证件号码</div> -->
<!--                         <div class="ipt-box js-ipt-box"> -->
<%--                             <input type="text" name="liaidnum" id = "liaidnum" value="${pubEppassword.liaidnum}" class="ipt-txt ipt-txt-lg sfcreport" placeholder="请输入联络员证件号码"> --%>
<!--                             <i class="icon-close viewicon"></i> -->
<!--                         </div> -->
<!--                     </td> -->
<!--                 </tr> -->
<!--                 </tbody> -->
<!--             </table> -->
<!--         </div> -->
<!--     </div> -->
<!-- </div>  -->

<%-- <c:if test="${yrRegCheck.addRecState != '2'}"> --%>
<div class="mod save-box">
    <button class="btn-common btn-save" id="save">暂存</button>
    <button class="btn-common btn-save" id="view">预览并提交</button>
</div>
<%-- </c:if> --%>

<%--传递至js的参数： start--%>
<input type="hidden" id="params_area_address" value="${yrPbBaseInfo.areaAddress}" >
<input type="hidden" id="params_stree_address" value="${yrPbBaseInfo.streeAddress}">

<input type="hidden" id="params_area_addresscopy" value="${yrPbBaseInfo.areaAddressCopy}">
<input type="hidden" id="params_stree_addresscopy" value="${yrPbBaseInfo.streeAddressCopy}">
<%--传递至js的参数： end--%>
<%-- <jsp:include page="../../common/footer.jsp"></jsp:include> --%>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/placeholder/jquery.placeholder.min.js"/>"></script>
<script src="<c:url value="/js/lib/jquery/jquery.icinfo.js"/>"></script>
<script>
    $('input, textarea').placeholder(); //ie8支持placeholder
    $('.js-ipt-box').expandInput();
</script>
<script id="table-template-one" type="text/x-handlebars-template">
{{#each data}}  
             <tr>
                    <td><input type="checkbox" name="licencechose" value="{{licID}}">{{xh @index}}</td>
                    <td>{{licNameCN}}</td>
                    <td>{{valto valTo}}</td>
             </tr> 
{{/each}} 
</script>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}  
             <tr>
                    <td><input type="checkbox" name="websitechose" value="{{webID}}">{{num @index}}</td>
                    <td>{{webtype webType}}</td>
                    <td>{{webSitName}}</td>
                    <td>{{webSite}}</td>
                </tr> 
    {{/each}} 
</script>
<!-- 网站点击 -->
<script>
    $('.js-write-tips').on('click', function () {
        var that = this;
        layer.tips($('.js-tip-cont').html(), that, {tips: 3, time: -1, closeBtn: 1,area:'500px'})
    })
</script>
<script>
    window._CONFIG = {
        _empNum:'${yrPbBaseInfo.empNum}' , //获取从业人数  判断是否保存过
        _year:'${year}' ,//年度
        _pripid:'${pripid}', //主体代码 
        _reportState:'${yrRegCheck.reportState}',
        _addRecState:'${yrRegCheck.addRecState}',
        mod_url: '<c:url value="/reg/client/yr/modapplication/pb/show"/>',
    	pubEppassword:'${pubEppassword}', //获取备案信息对象（仅能判断是否存在）
    	leRep:'${pubEppassword.lerep}' ,      //法定代表人
    	leRepPhone:'${pubEppassword.lerepphone}',  //法定代表人电话
    	liaName:'${pubEppassword.lianame}',  //联络员姓名
    	tel:'${pubEppassword.tel}',  //联络员电话
    	liaIDType:'${pubEppassword.liaidtype}',  //联络员证件号码
    	liaIDNum:'${pubEppassword.liaidnum}' //联络员证件号码
    }
</script>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/pbaddrec/pbaddrec_edit.js"></script>
</body>
</html>