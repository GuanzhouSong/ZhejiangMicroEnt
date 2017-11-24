<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>详细信息</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<style type="text/css">
.gold{background-color: #fff4df;}
</style>
<body class="pd10">
<form id="hx-form">
    <input type="hidden" id="priPID" name="priPID" value="${dto.priPID}">
    <input type="hidden" id="regNO" name="regNO" value="${dto.regNO}">
    <input type="hidden" id="uniCode" name="uniCode" value="${dto.uniCode}">
    <input type="hidden" id="entName" name="entName" value="${dto.entName}">
    <input type="hidden" id="entTypeCatg" name="entTypeCatg" value="${dto.entTypeCatg}">
</form>
<div class="clearfix reg-company-basic reg-company-basic-yellowish">
    <div class="clearfix reg-caption">
        <div class="title clearfix">
            <span class="name fl mr5">${dto.entName}</span>
            <span class="${hx:yReportStyle(dto.regState)}">${hx:publicStatus(dto.regState)}</span>
            <c:if test="${dto.isIndivid=='1'}"> 
             <span class="icon-rectangle blue fl mr10">个转企</span>
            </c:if>
            <c:if test="${isOpanomaly=='1'}">
             <span class="icon-rectangle red fl mr10">被列入经营异常名录和严重违法失信（黑名单）</span>
            </c:if>
            <c:if test="${isOpanomaly=='2'}">
             <span class="icon-rectangle red fl mr10">被列入经营异常名录</span>
            </c:if>
            <c:if test="${isOpanomaly=='3'}">
             <span class="icon-rectangle red fl mr10">被列入严重违法失信（黑名单）</span>
            </c:if> 
            <!-- 查无下落 -->
            <c:if test="${notFoundFlag=='1'}">
              <span class="icon-rectangle  fl mr10" style="background-color: purple;">查无下落</span>
            </c:if>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="book2-icon"></i>统一社会信用代码/注册号：<span>${empty dto.uniCode?dto.regNO:dto.uniCode}</span>
            </p>
            <p>
                <i class="local-icon"></i>登记机关：<span>${dto.regOrgName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="person-icon"></i>法定代表人：<span>${dto.leRep}</span>
            </p>
            <p>
                <i class="government-icon"></i>管辖单位：<span>${dto.localAdmName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="capital-icon"></i>注册资本：<span><fmt:formatNumber value="${dto.regCap}" pattern="###,###,###,##0.0000"/>万元</span>
            </p>
            <p><i class="date-icon"></i>成立日期：<span><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></span></p>
        </div>
        <div class="clearfix">
           <c:if test="${dto.isIndivid=='1'}">
            <p class="w360">
                 <i class="date-icon"></i>转企日期：<span><fmt:formatDate value="${dto.individDate}" pattern="yyyy-MM-dd"/></span>
            </p>
           </c:if> 
            <p>
                <c:if test="${dto.regState=='D'}">
	                <i class="date-icon"></i>吊销日期：
	                <span class="light"><fmt:formatDate value="${dto.punishDate}" pattern="yyyy-MM-dd"/></span>
                </c:if>
                <c:if test="${dto.regState=='XX'||dto.regState=='DX'}">
	                <i class="date-icon"></i>注销日期：
	                <span class="light"><fmt:formatDate value="${dto.altDate}" pattern="yyyy-MM-dd"/></span>
                </c:if>
            </p>
        </div>
        
        <!-- 如果有电子营业执照 则显示 -->
        <c:if test="${elBusinessLicFlag=='1'}">  
         <div class="clearfix">
	        <p class="w360">
	          <i class="book2-icon"></i>电子营业执照： 
	          <%-- <a href="${sysUser.userType=='1'?'/reg/server/panoramasearch':'/syn/panoramasearch'}/bussinessLic?encryPriPID=${encryPriPID}"   target="_blank" style="font-weight: bold;color: blue;">点击查看</a> --%>
	          <a href="http://zj.gsxt.gov.cn/client/entsearch/bussinessLic?encryPriPID=${encryPriPID}"   target="_blank" style="font-weight: bold;color: blue;">点击查看</a> 
	        </p> 
         </div> 
        </c:if> 
        <div class="btn-box ent">
            <div class="mb5 clearfix">
                <a class="btn-attention-box" id="czlc" href="javascript:void(0);">
                    <i class="attention-icon"></i>
                    <span>成长历程</span>
                </a>
                <a class="btn-print-box">
                    <i class="print-icon2"></i>
                    <span>打印</span>
                </a>
            </div>
            <div>
                <a class="btn-attention-box js-relation">
                    <i class="query-icon"></i>
                    <span>关系网查询</span>
                </a>
                <a class="btn-print-box">
                    <i class="export-icon"></i>
                    <span>导出</span>
                </a>
            </div>
        </div>
    </div>
    <c:if test="${!empty isEscApp && isEscApp.simplecanRea =='4'}">
    <div class="notice"><i class="notice-icon"></i>正在进行简易注销公告：公告期：<fmt:formatDate value="${isEscApp.noticeFrom}" pattern="yyyy年MM月dd日"/>
           至<fmt:formatDate value="${isEscApp.noticeTo}" pattern="yyyy年MM月dd日"/></div>
    </c:if>
</div>
<!-- <div class="supervise-about mt5 mb5"> -->
<!--     <p><label>监管项目：</label><span>食口生产</span><span>保化品</span><span>食品经营</span></p> -->
<!--     <p> -->
<!--         <label>监管提示：</label><span>重点监管对象</span><span>关注服务对象</span><span>列入异常即将届满3年</span><span>许可证已到期</span><span>经营期限已到期</span> -->
<!--     </p> -->
<!--     <div class="more reverse">展开全部详情<i></i></div> -->
<%--     <div class="more">点击后删除reverse类名<i></i></div> --%>
<!-- </div> -->
<div class="mb5">
    <span class="tag-block-item ft14 mr30"><i class="tag33cccc"></i>分类监管项目（<em class="light">${apprMarkRelDtoSize }</em>）/抽查专项库（<em class="light">${apprMarkRelSccount }</em>）</span>
    <span class="tag-block-item ft14 mr30"><i class="tagff6666"></i>重点监管对象（<em class="light">${csSuperviseObjDtoSize }</em>）</span>
    <span class="tag-block-item ft14 mr30"><i class="tag66cc66"></i>关注服务对象（<em class="light">${csConcernObjDtoSize }</em>）</span>
    <span class="tag-block-item ft14 mr30"><i class="tagff6600"></i>预警提醒提示（<em class="light">${tipsSize }</em>）</span>
    <span class="tag-block-item ft14 mr30"><i style="background-color: red;"></i>失信联合惩戒（<em class="light">${noCreditPunishInfoSize }</em>）</span>
</div>
<div class="mb5"> 
	<c:forEach var="apprMarkRelDto" items="${apprMarkRelDtos }">
	    <span class="tag33cccc tag-item">${apprMarkRelDto.markName }</span>
	</c:forEach>
	<c:forEach var="csSuperviseObjDto" items="${csSuperviseObjDtoList }">
	    <span class="tagff6666 tag-item">${csSuperviseObjDto.markName }</span>
	</c:forEach>
	<c:forEach var="csConcernObjDto" items="${csConcernObjDtoList }">
	    <span class="tag66cc66 tag-item">${csConcernObjDto.markName }</span>
	</c:forEach>
	<c:forEach var="tip" items="${tips }">
	    <span class="tagff6600 tag-item">${tip }</span>
	</c:forEach>
	<c:forEach var="noCreditPunishInfo" items="${noCreditPunishInfoList }">
	    <span class="tag-item" style="background-color: red;">${noCreditPunishInfo.punField }</span>
	</c:forEach>
</div>
<div class="light-info mt10">
    <div class="form-list light ">
        <div class="form-item clearfix">
            <div id="uniCode" class="col-4">
                <label class="right col-6">法定代表人（负责人）：</label>
                <div class="col-6">
                    ${dto.leRep}     ${dto.tel}
                </div>
            </div>
            <div class="col-4" id="entName">
                <label class="right col-6">工商联络员：</label>
                <div class="col-6">
                   ${liaName}   ${liaTel}
                </div>
            </div>
            <!-- <div class="col-4">
                <label class="right col-6">财务负责人：</label>
                <div class="col-6">
                    李二 13596489562
                </div>
            </div> -->
        </div>
    </div>
</div>

  <div class="tabbale" data-component="tab">
     <div class="tab-header w-a145 type-tab tbmr1 ent-tab person-tab">
                <ul class="clearfix">
                    <li class="tab-selected"><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="0">登记备案<span id="badjCount">(0)</span></a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="1">出资投资<span id="cztzCount">(0)</span></a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="2">许可资质<span id="xkzzCount">(0)</span></a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="3">知识产权<span id="zscqCount">(0)</span></a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="4">抵押质押担保<span id="dyzydbCount">(0)</span></a></span>
                    
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="5">抽查检查<span id="cxjcCount">(0)</span></a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="6">不良失信<span id="blxxCount">(0)</span></a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="9">投诉申诉<span id="toushuCount">(0)</span></a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="7">良好荣誉<span id="lhryCount">(0)</span></a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="8">企业公示信息<span id="qygsCount">(0)</span></a></span>
                    </li>
                </ul>
          </div>
    <div class="tab-content">  
          <div class="tab-panel tab-panel-show">
             <div id="">
              <div class="gold">
	              <span class="fr line-h30">数据来源：工商部门</span>
	              <i class="flex-icon dib2 va-3" id="baseinfo"></i>
		          <h6 class="add-title dib2">企业基本信息</h6>
	          </div>
	          <table id="table_baseinfo" cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
                            <tbody>
                            <c:if test="${empty dto.entTypeCatg}">
                                <tr>
                                    <td colspan='9' class='dataTables_empty2'>无</td>
                                </tr>
                            </c:if>
                            <c:if test="${not empty dto.entTypeCatg}">
                                <!-- 分支机构 start-->
                                <c:if test="${fn:indexOf('12,14,34,32,22,28,24', dto.entTypeCatg)!=-1}">
                                    <tr>
                                        <td class="bg-gray right" width="10%">名称</td>
                                        <td width="40%">${dto.entName}</td>
                                        <td class="bg-gray right" width="15%">统一社会信用代码/注册号</td>
                                        <td>${dto.uniCode==null?dto.regNO:dto.uniCode}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">类型</td>
                                        <td width="40%">${dto.entTypeName}</td>
                                        <td class="bg-gray right">负责人</td>
                                        <c:if test="${!empty isLimit}"><td class="red">${dto.leRep}&nbsp;(受限)</td></c:if>
                                        <c:if test="${empty isLimit}"><td>${dto.leRep}</td></c:if>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td width="40%">${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">管辖单位</td>
                                        <td width="40%">${dto.localAdmName}</td>
                                        <td class="bg-gray right">片区</td>
                                        <td>${dto.sliceNOName}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td width="40%">${hx:publicStatus(dto.regState)}</td>
                                        <td class="bg-gray right">成立日期</td>
                                        <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">营业场所</td>
                                        <td  width="40%">${dto.dom}</td>
                                        <td class="bg-gray right">营业期限</td>
                                        <td><fmt:formatDate value="${dto.opFrom}" pattern="yyyy年MM月dd日"/>—
                                        <fmt:formatDate value="${dto.opTo}" pattern="yyyy年MM月dd日"/></td>
                                     </tr>
                                     <tr>
                                        <td class="bg-gray right">经营范围</td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>

                                </c:if>
                                <!-- 分支机构 end-->

                                <!-- 公司,外商投资企业,非公司企业法人 start-->
                                <c:if test="${fn:indexOf('11,21,13', dto.entTypeCatg)!=-1}">
                                    <tr>
                                        <td class="bg-gray right" width="10%">名称</td>
                                        <td width="40%">${dto.entName}</td>
                                        <td class="bg-gray right" width="15%">统一社会信用代码/注册号</td>
                                        <td>${dto.uniCode==null?dto.regNO:dto.uniCode}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">类型</td>
                                        <td width="40%">${dto.entTypeName}</td>
                                        <td class="bg-gray right">法定代表人</td>
                                        <c:if test="${!empty isLimit}"><td class="red">${dto.leRep}&nbsp;(受限)</td></c:if>
                                        <c:if test="${empty isLimit}"><td>${dto.leRep}</td></c:if>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td width="40%">${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">管辖单位</td>
                                        <td width="40%">${dto.localAdmName}</td>
                                        <td class="bg-gray right">片区</td>
                                        <td>${dto.sliceNOName}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td width="40%">${hx:publicStatus(dto.regState)}</td>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('11,21', dto.entTypeCatg)!=-1}">营业期限</c:if>
                                            <c:if test="${fn:indexOf('13', dto.entTypeCatg)!=-1}">经营期限</c:if>
                                        </td>
                                        <td><fmt:formatDate value="${dto.opFrom}" pattern="yyyy年MM月dd日"/>—
                                        <fmt:formatDate value="${dto.opTo}" pattern="yyyy年MM月dd日"/></td>
                                        <td>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">经营范围</td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">住所</td>
                                        <td colspan="3">${dto.dom}</td>
                                    </tr>
                                </c:if>
                                <!-- 公司,外商投资企业,非公司企业法人 end-->

                                <!-- 合伙企业,外商投资合伙企业 start-->
                                <c:if test="${fn:indexOf('33,27', dto.entTypeCatg)!=-1}">
                                    <tr>
                                        <td class="bg-gray right" width="10%">名称</td>
                                        <td width="40%">${dto.entName}</td>
                                        <td class="bg-gray right" width="15%">统一社会信用代码/注册号</td>
                                        <td>${dto.uniCode==null?dto.regNO:dto.uniCode}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">类型</td>
                                        <td>${dto.entTypeName}</td>
                                        <td class="bg-gray right">执行事务合伙人</td>
                                        <c:if test="${!empty isLimit}"><td class="red">${dto.leRep}&nbsp;(受限)</td></c:if>
                                        <c:if test="${empty isLimit}"><td>${dto.leRep}</td></c:if>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td>${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">管辖单位</td>
                                        <td width="40%">${dto.localAdmName}</td>
                                        <td class="bg-gray right">片区</td>
                                        <td>${dto.sliceNOName}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">状态</td>
                                        <td>${hx:publicStatus(dto.regState)}</td>
                                        <td class="bg-gray right">成立日期</td>
                                        <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">主要经营场所</td>
                                        <td width="40%">${dto.dom}</td>
                                        <td class="bg-gray right">合伙期限</td>
                                        <td><fmt:formatDate value="${dto.opFrom}" pattern="yyyy年MM月dd日"/>—
                                        <fmt:formatDate value="${dto.opTo}" pattern="yyyy年MM月dd日"/></td>
                                     </tr>
                                     <tr>
                                        <td class="bg-gray right">经营范围</td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                </c:if>
                                <!-- 合伙企业,外商投资合伙企业 end-->

                                <!-- 个人独资企业,农民专业合作社分支机构 start-->
                                <c:if test="${fn:indexOf('31,17', dto.entTypeCatg)!=-1}">
                                    <tr>
                                        <td class="bg-gray right" width="10%">名称</td>
                                        <td width="40%">${dto.entName}</td>
                                        <td class="bg-gray right" width="15%">统一社会信用代码/注册号</td>
                                        <td>${dto.uniCode==null?dto.regNO:dto.uniCode}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">类型</td>
                                        <td>${dto.entTypeName}</td>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('31', dto.entTypeCatg)!=-1}">投资人</c:if>
                                            <c:if test="${fn:indexOf('17', dto.entTypeCatg)!=-1}">负责人</c:if>
                                        </td>
                                        <c:if test="${!empty isLimit}"><td class="red">${dto.leRep}&nbsp;(受限)</td></c:if>
                                        <c:if test="${empty isLimit}"><td>${dto.leRep}</td></c:if>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td>${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">管辖单位</td>
                                        <td width="40%">${dto.localAdmName}</td>
                                        <td class="bg-gray right">片区</td>
                                        <td>${dto.sliceNOName}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td>${hx:publicStatus(dto.regState)}</td>
                                        <td class="bg-gray right">成立日期</td>
                                        <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('31', dto.entTypeCatg)!=-1}">经营范围</c:if>
                                            <c:if test="${fn:indexOf('17', dto.entTypeCatg)!=-1}">业务范围</c:if>
                                        </td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('31', dto.entTypeCatg)!=-1}">住所</c:if>
                                            <c:if test="${fn:indexOf('17', dto.entTypeCatg)!=-1}">经营场所</c:if>
                                        </td>
                                        <td colspan="3">${dto.dom}</td>
                                    </tr>
                                </c:if>
                                <!-- 个人独资企业,农民专业合作社分支机构 end-->


                                <!-- 个体户,农民专业合作社 start-->
                                <c:if test="${fn:indexOf('50,16', dto.entTypeCatg)!=-1}">
                                    <tr>
                                        <td class="bg-gray right" width="10%">名称</td>
                                        <td width="40%">${dto.entName}</td>
                                        <td class="bg-gray right" width="15%">统一社会信用代码/注册号</td>
                                        <td>${dto.uniCode==null?dto.regNO:dto.uniCode}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">类型</td>
                                        <td>${dto.entTypeName}</td>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('50', dto.entTypeCatg)!=-1}">经营者</c:if>
                                            <c:if test="${fn:indexOf('16', dto.entTypeCatg)!=-1}">法定代表人</c:if>
                                        </td>
                                        <c:if test="${!empty isLimit}"><td class="red">${dto.leRep}&nbsp;(受限)</td></c:if>
                                        <c:if test="${empty isLimit}"><td>${dto.leRep}</td></c:if>
                                    </tr>
                                    <c:if test="${fn:indexOf('50', dto.entTypeCatg)!=-1}">
                                        <tr>
                                            <td class="bg-gray right">组成形式</td>
                                            <td>${dto.compFormName}</td>
                                            <td class="bg-gray right">注册日期</td>
                                            <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${fn:indexOf('16', dto.entTypeCatg)!=-1}">
                                        <tr>
                                            <td class="bg-gray right">成员出资总额</td>
                                            <td>>${dto.regCapUSD }万元人民币</td>
                                            <td class="bg-gray right">成立日期</td>
                                            <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
                                        </tr>
                                    </c:if>

                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td>${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">管辖单位</td>
                                        <td width="40%">${dto.localAdmName}</td>
                                        <td class="bg-gray right">片区</td>
                                        <td>${dto.sliceNOName}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td colspan="3">${hx:publicStatus(dto.regState)}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('50', dto.entTypeCatg)!=-1}">经营范围</c:if>
                                            <c:if test="${fn:indexOf('16', dto.entTypeCatg)!=-1}">业务范围</c:if>
                                        </td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('50', dto.entTypeCatg)!=-1}">经营场所</c:if>
                                            <c:if test="${fn:indexOf('16', dto.entTypeCatg)!=-1}">住所</c:if>
                                        </td>
                                        <td colspan="3">${dto.dom}</td>
                                    </tr>
                                </c:if>
                                <!-- 个体户,农民专业合作社 end-->
                            </c:if>
                            </tbody>
                        </table>
                     </div>
                        
                       <div id="tab_djxkxx">
                            <div class="gold">
	                            <span class="fr line-h30">数据来源：工商部门</span>
	                            <i id="manageinfo" class="flex-icon dib2 va-3"></i>
		                        <h6 class="add-title dib2">高管人员信息（<span id="ggryxx" class="light">0</span>）</h6>
                            </div>
	                        <table id="table_ggryxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
	                               width="100%">
	                            <thead>
	                            <tr>
	                                <th width="8%">序号</th>
	                                <th>姓名</th>
	                                <th>身份证号</th>
	                                <th>职务</th>
	                            </tr>
	                            </thead>
	                        </table>
                       </div>
                        
                      <div id="tab_fzjgxx">
                         <div class="gold">
	                        <span class="fr line-h30">数据来源：工商部门</span>
	                        <i id="branchinfo" class="flex-icon dib2 va-3"></i>
	                        <h6 class="add-title  dib2">分支机构信息（<span id="fzjg" class="light">0</span>）</h6>
	                     </div>
                         <table id="table_fzjgxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                               width="100%">
                            <thead>
                            <tr>
                                <th width="8%">序号</th>
                                <th>统一社会信用代码/注册号</th>
                                <th>企业名称</th>
                                <th>登记机关</th>
                                <th>登记状态</th>
                            </tr>
                            </thead>
                        </table>
                       </div>
                       
                        <div id="tab_qsxx">
                            <div class="gold">
	                            <span class="fr line-h30">数据来源：工商部门</span>
		                        <i id="clearInfo" class="flex-icon dib2 va-3"></i>
		                        <h6 class="add-title dib2">清算信息<span id="isShow">（<span id="qsxx" class="light">0</span>）</span></h6>
	                        </div>
	                        <table id="table_qsxx" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
	                             <thead>
				                    <tr>
				                        <th width="20%">清算组负责人</th>
				                        <td id="ligPrincipal"></td>
				                    </tr>
				                    <tr>
				                        <th width="20%">清算组成员</th>
				                        <td id="liqMem"></td>
				                    </tr>
				                  </thead>
	                         </table> 
                        </div>
                        
                       <div id="tab_bgxx" class="mb30">
                            <div class="gold"> 
	                            <span class="fr line-h30">数据来源：工商部门</span>
		                        <i id="changeInfo" class="flex-icon dib2 va-3"></i>
		                        <h6 class="add-title  dib2">变更信息（<span id="bgxx" class="light">0</span>）</h6>
	                        </div>
	                        <table id="table_bgxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
	                               width="100%">
	                            <thead>
	                            <tr>
	                                <th width="8%">序号</th>
	                                <th>变更事项</th>
	                                <th>变更前内容</th>
	                                <th>变更后内容</th>
	                                <th>变更日期</th>
	                            </tr>
	                            </thead>
	                        </table> 
                       </div>
                </div>
                
                <div class="tab-panel">
                    
                    <div id="tab_gdczxx">
                        <div class="gold"> 
	                        <span class="fr line-h30">数据来源：工商部门</span>
		                    <i id="investinfo"  class="flex-icon dib2 va-3"></i>
		                    <h6 class="add-title  dib2">股东及出资信息（<span id="gdczxx" class="light">0</span>）</h6>
	                    </div>
	                    <table id="table_gdjczxx" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
	                        <thead>
	                        <tr>
	                            <th width="8%">序号</th>
	                            <th width="22%">股东名称</th>
	<!--                        <th>国别</th> -->
	                            <th>股东类型</th>
	                            <th>证件类型</th>
	                            <th>证件号码</th>
	                            <th>认缴出资额</th>
	                            <th>币种</th>
	                            <th>百分比</th>
	                            <th>实缴出资额</th>
	                        </tr>
	                        </thead>
	                    </table>
                    </div>
 					
 					<div id="tab_dwtz">
 					    <div class="gold"> 
	 					    <span class="fr line-h30">数据来源：企业年报</span>
		 					<i id="outinverstinfo" class="flex-icon dib2 va-3"></i>
		                    <h6 class="add-title  dib2">企业对外投资信息（<span id="dwtzxx" class="light">0</span>）</h6>
	                    </div>
	                    <table id="table_dwtzxx" border="0" cellspacing="0" cellpadding="0" class="table-row">
	                        <thead>
	                        <tr>
	                            <th width="8%">序号</th>
	                            <th>对外投资企业统一社会信用代码(或注册号)</th>
			                    <th>投资设立（或购买股权）境内企业名称</th>
			                    <th>认缴投资总额</th>
			                    <th>认缴投资方式</th>
			                    <th>认缴投资总额占比（%）</th>
			                    <th>实缴投资总额</th>
			                    <th>实缴投资方式</th>
			                    <th>实缴投资总额占比</th>
	                        </tr>
	                        </thead>
	                    </table>
                    </div>
                    
                </div>
                
               <div class="tab-panel" >
                    <div class="gold"> 
	                    <span class="fr line-h30">数据来源：各审批许可部门</span>
	                    <i id="licenceinfo" class="flex-icon dib2 va-3"></i>
	                    <h6 class="add-title dib2">行政许可信息（<span id="pubotherlicTotal" class="light">0</span>）</h6>
                    </div>
                    <table id="_tab-pubotherlicence" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th class="col-first">序号 </th>
		                    <th class="col-second">许可文件编号 </th>
		                    <th class="col-three">许可文件名称 </th>
		                    <th class="col-four">有效期自 </th>
		                    <th class="col-five">有效期至 </th>
		                    <th class="col-six">许可机关 </th>
		                    <th class="col-seven">许可内容 </th> 
		                    <th>状态</th>
<!--                        <th>详情</th> -->
                        </tr>
                        </thead>
                        <tbody id="table-pubotherlicence">
                          <tr id="tr-pubotherlicence"></tr>
                        </tbody>
                    </table>
               </div>
               
               <div class="tab-panel">
               
                  <div id="tab_qysbxx">
                    <div class="gold"> 
	                    <span class="fr line-h30">数据来源：工商总局</span>
	                    <i id="tmdetailsinfo" class="flex-icon dib2 va-3"></i>
	                    <h6 class="add-title  dib2">企业商标信息（<span id="qysbxx" class="light">0</span>）</h6>
                    </div>
                    <table id="table_qysbxx" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                       <thead>
                         <tr>
                           <th width="8%">序号</th>
                           <th>商标图形</th>
                           <th>商标注册号</th>
                           <th>类别</th>
                           <th>商标专用权起止日期</th>
                           <th>注册公告日期</th>
                           <th>注册公告期号</th>
                           <th>商品/服务项目</th>
                         </tr>
                       </thead>
                    </table>
                  </div>
                    
                  <div id="tab_qyzlxx">
                    <div class="gold"> 
	                    <span class="fr line-h30">数据来源：知识产权部门</span>
	                    <i id="entzlinfo" class="flex-icon dib2 va-3"></i>
	                    <h6 class="add-title  dib2">企业专利信息（<span id="qyzlxx" class="light">0</span>）</h6>
                    </div>
                    <table id="table_qyzlxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                          width="100%">
                       <thead>
                       <tr>
                           <th width="8%">序号</th>
                           <th>专利申请号</th>
                           <th>发明名称</th>
                           <th>专利类型</th>
                           <th>申请人名称</th>
                       </tr>
                       </thead>
                   </table>
                 </div>
              </div>
               
               <div class="tab-panel" id="tab_dyzyxx">
                    <div>
                    <div class="gold">
	                    <span class="fr line-h30">数据来源：工商部门</span>
	                    <i class="flex-icon dib2 va-3" id="qydcdyxx_li"></i>
	                    <h6 class="add-title dib2">动产抵押信息 （<span id="qydcdyxxTotal" class="light">0</span>）</h6>
	                </div>
                    <table id="table_qydcdyxx" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr style="white-space: nowrap;">
                            <th width="8%">序号</th>
                            <th width="22%">登记编号</th>
                            <th>登记日期</th>
                            <th>登记机关</th>
                            <th>被担保债权数额（万元）</th>
                            <th>状态</th>
                            <th>公示日期</th>
                            <th>详情</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                    
                    <div>
                    <div class="gold">
	                    <span class="fr line-h30">数据来源：国土部门</span>
	                    <i class="flex-icon dib2 va-3" id="qybdcdyxx_li"></i>
	                    <h6 class="add-title dib2">不动产抵押信息 （<span class="light" id="qybdcdyxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_qybdcdyxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">抵押证编号</th>
                            <th>抵押物类型</th>
                            <th>抵押担保范围</th>
                            <th>抵押权人名称</th>
                            <th>抵押权人证件号</th>
                            <th>被担保主债权数额（万元）</th>
                            <th>债务期限起</th>
                            <th>债务期限至</th>
                            <th>申请抵押原因</th>
                        </tr>
                        </thead>
                    </table> 
                    </div>
                    
                    <div>
                    <div class="gold">
	                    <span class="fr  line-h30">数据来源：国家企业信用信息公示系统企业信息填报</span>
	                    <i class="flex-icon dib2 va-3" id="ippldg_li"></i>
	                    <h6 class="add-title dib2">知识产权出质登记信息（<span class="light" id="ippldgTotal">0</span>）</h6>
                    </div>
                    <table id="ippldg_table" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th>知识产权登记证号</th>
                            <th>名称</th>
                            <th>种类</th>
                            <th>出质人名称</th>
                            <th>质权人名称</th>
                            <th>质权登记期限</th>
                            <th>状态</th>
                            <th>公示日期</th>
                            <th>详情</th>
                        </tr>
                        </thead> 
                        <!-- <tbody id="ippldg">
                        <tr id="ippldgtplPage"></tr>
                        </tbody> -->
                    </table>
                    </div>
                    
                    <div>
                    <div class="gold">
	                    <span class="fr line-h30">数据来源：工商部门</span>
	                    <i class="flex-icon dib2 va-3" id="qygqczxx_li"></i>
	                    <h6 class="add-title dib2">股权出质登记信息（<span class="light" id="qygqczxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_qygqczxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">登记编号</th>
                            <th>出质人</th>
                            <th>出质人证照/证件号</th>
                            <th>出质股权数额（万元）</th>
                            <th>质权人</th>
                            <th>质权人证照/证件号</th>
                            <th>股权出质设立登记日期</th>
                            <th>状态</th>
                            <th>公示日期</th>
                            <th>详情</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                    
                    <div>
                    <div class="gold">
	                    <span class="fr line-h30">数据来源：企业报送信息</span>
	                    <i class="flex-icon dib2 va-3" id="forguaranteeinfo_li"></i>
	                    <h6 class="add-title dib2">对外提供担保信息（<span class="light" id="forguaranteeinfoTotal">0</span>）</h6>
                    </div>
                    <table id="table_forguaranteeinfo" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th >序号</th>
                            <th >债权人</th>
	                        <th >债务人</th>
	                        <th >主债权</br>种类</th>
	                        <th >主债权</br>数额（万元）</th>
	                        <th >履行债务的期限</th>
	                        <th>保证的</br>期间</th>
	                        <th>保证的</br>方式</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                </div>
                

                <div class="tab-panel" id="tab_ccjcxx">
                    <div> 
                    <div class="gold">
	                    <span class="fr line-h30">数据来源：工商部门</span>
	                    <i class="flex-icon dib2 va-3" id="ccjcxx_li"></i>
	                    <h6 class="add-title dib2">抽查检查信息 （<span class="light" id="ccjcxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_ccjcxx" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>检查类别</th>
                            <th>检查任务编号</th>
                            <th>检查实施机关</th>
                            <th>类型</th>
                            <th>日期</th>
                            <th>结果</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                </div>

                <div class="tab-panel" id="tab_pjdjxx">
                    <div> 
                    <div class="gold">
	                    <span class="fr line-h30">数据来源：工商部门</span>
	                    <i class="flex-icon dib2 va-3" id="qyjyqcxx_li"></i>
	                    <h6 class="add-title dib2">列入经营异常名录（<span class="light" id="qyjyqcxxTotal">0</span>）</h6>
                    </div> 
                    <table id="table_qyjyqcxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <c:choose>
                          <c:when test="${dto.entTypeCatg=='50'}">
                            <tr>
                            <th>序号</th>
                            <th>标记经营异常状态原因</th>
                            <th>标记日期</th>
                            <th>作出决定机关（标记）</th>
                            <th>恢复正常记载状态原因</th>
                            <th>恢复日期</th>
                            <th>作出决定机关（恢复）</th>
                            </tr>
                          </c:when>
                          <c:otherwise>
                            <tr>
                            <th>序号</th>
                            <th>列入经营异常原因</th>
                            <th>列入日期</th>
                            <th>列入决定书文号</th>
                            <th>作出决定机关（列入）</th>
                            <th>移出经营异常名录原因</th>
                            <th>移出日期</th>
                            <th>移出决定书文号</th>
                            <th>作出决定机关（移出）</th>
                            </tr>
                          </c:otherwise>
                        </c:choose> 
                        </thead>
                    </table>
                    </div>
                    
                    <div>
                    <div class="gold">
	                    <span class="fr line-h30">数据来源：工商部门</span></h5>
	                    <i class="flex-icon dib2 va-3" id="yzwfsxxx_li"></i>
	                    <h6 class="add-title dib2">列入严重违法失信（黑名单）（<span class="light" id="yzwfsxxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_yzwfsxxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">类别</th>
                            <th>列入严重违法失信企业名单（黑名单）原因</th>
                            <th>列入日期</th>
                            <th>列入决定书文号</th>
                            <th>作出决定机关（列入）</th>
                            <th>移出严重违法失信企业名单（黑名单）原因</th>
                            <th>移出日期</th>
                            <th>移出决定书文号</th>
                            <th>作出决定机关（移出）</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                    
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30" id="jsxzcfxx_span">数据来源：工商部门和其它部门</span>
	                    <i class="flex-icon dib2 va-3" id="jsxzcfxx_li"></i>
	                    <h6 class="add-title dib2">行政处罚信息（<span class="light" id="pubOtherpunishTotal">0</span>）</h6>
                    </div>
                    <table id="table_jsxzcfxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th>决定书文号</th>
                            <th>违法行为类型</th>
                            <th>行政处罚内容</th>
                            <th>决定机关名称</th>
                            <th>处罚决定日期</th>
                            <th>公示日期</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="pubOtherpunish">
                        <tr id="pubOtherpunishPage"></tr>
                        </tbody>
                    </table>
                    </div>
                    
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30">数据来源：人民法院</span>
	                    <i class="flex-icon dib2 va-3" id="qygqdjxx_li"></i>
	                    <h6 class="add-title dib2">司法协助信息（<span class="light" id="qygqdjxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_qygqdjxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">被执行人</th>
                            <th>股权数额</th>
                            <th>执行法院</th>
                            <th>执行通知书文号</th>
                            <th>类型</th>
                            <th>状态</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                    
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30">数据来源：不动产登记部门</span>
	                    <i class="flex-icon dib2 va-3" id="qybdccfxx_li"></i>
	                    <h6 class="add-title dib2">不动产查封信息（<span class="light" id="qybdccfxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_qybdccfxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">查封类型</th>
                            <th>查封文号</th>
                            <th>查封房屋坐落</th>
                            <th>申请查封单位</th>
                            <th>查封申请日期</th>
                            <th>撤销查封日期</th>
                            <th>状态</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                    
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30">数据来源：各相关政府部门</span>
	                    <i class="flex-icon dib2 va-3" id="sxlhcjxx_li"></i>
	                    <h6 class="add-title dib2">失信联合惩戒信息 （<span class="light" id="sxlhcjxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_sxlhcjxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="10%">惩戒领域</th>
                            <th>惩戒依据</th>
                            <th>惩戒事由</th>
                            <th>惩戒规则</th>
                            <th>惩戒提请部门</th>
                            <th>执行有效期</th>
                            <th>惩戒执行部门</th>
                            <th width="15%">惩戒执行措施</th>
                            <th>惩戒状态</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                </div>
                
                <div class="tab-panel" id="tab_toushu"> 
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30">数据来源:工商12315行政执法系统</span>
	                    <i class="flex-icon dib2 va-3" id="tab_toushu_li"></i>
	                    <h6 class="add-title dib2">投诉申诉信息 （<span class="light" id="tab_toushuTotal">0</span>）</h6>
                    </div>
                    <table id="table_toushu" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr style="white-space: nowrap;">
                            <th>序号</th>
                            <th>投诉类型</th>
                            <th>投诉（举报）日期</th>
                            <th>投诉（举报）内容</th>
                            <th>办理状态</th>
                        </tr>
                        </thead>
                    </table> 
                    </div>
                </div>

                <div class="tab-panel" id="tab_wfsxxx"> 
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30">数据来源:各相关政府部门</span>
	                    <i class="flex-icon dib2 va-3" id="qyxzcfxx_li"></i>
	                    <h6 class="add-title dib2">良好荣誉信息 （<span class="light" id="wfsxxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_qyxzcfxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr style="white-space: nowrap;">
                            <th>序号</th>
                            <th>良好信息类别</th>
                            <th>信息级别</th>
                            <th>认定发布年度</th>
                            <th>认定类别</th>
                            <th>认定有效期始</th>
                            <th>认定有效期止</th> 
                            <th>状态</th>
                            <th>认定发布时间</th>
                            <th>认定发布文号</th>
                            <th>认定发布部门</th>
                        </tr>
                        </thead>
                    </table> 
                    </div>
                </div>

                <div class="tab-panel">
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30" id="yrinfo_span">数据来源：国家企业信用信息公示系统企业信息填报</span>
	                    <i class="flex-icon dib2 va-3" id="yrinfo_li"></i>
	                    <h6 class="add-title dib2">企业年度报告（<span class="light" id="yrinfoTotal">0</span>）</h6>
                    </div>
                    <table id="yrinfo_table" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">报送年度</th>
                            <th>公示日期</th> 
                            <th>详情</th> 
                        </tr>
                        </thead>
                        <tbody id="table-yrinfo">
                          <tr id="pubtable-yrinfo"></tr>
                        </tbody>
                    </table>
                    </div>
                    
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30" id="table_jsgdyczxx_span">数据来源：国家企业信用信息公示系统企业信息填报</span>
	                    <i class="flex-icon dib2 va-3" id="table_jsgdyczxx_li"></i>
	                    <h6 class="add-title dib2">股东及出资信息 （<span class="light" id="investmentTotal">0</span>）</h6>
                    </div>
                    <table id="table_jsgdyczxx" class="table-row" cellspacing="0"
                           cellpadding="0">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>股东</th>
                            <th>认缴额(万元)</th>
                            <th>实缴额(万元)</th>
                            <th valign="top" class="th-sp">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                    <tr>
                                        <td colspan="4">认缴明细</td>
                                    </tr>
                                    <tr>
                                        <td width="20%">认缴<br/>出资方式</td>
                                        <td width="20%">认缴出资额<br/>（万元）</td>
                                        <td width="20%">认缴<br/>出资日期</td>
                                         <td width="20%">公示日期</td>
                                        <td width="20%">公示<br/>状态</td>
                                    </tr>
                                </table>
                            </th>
                            <th valign="top" class="th-sp">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                    <tr>
                                        <td colspan="4">实缴明细</td>
                                    </tr>
                                    <tr>
                                        <td width="20%">实缴出资方式</td>
                                        <td width="20%">实缴出资额<br/>（万元）</td>
                                        <td width="20%">实缴<br/>出资日期</td>
                                        <td width="20%">公示日期</td>
                                        <td width="20%">公示<br/>状态</td>
                                    </tr>
                                </table>
                            </th>
                        </tr>
                        </thead>
                        <tbody id="investments">
                        <tr id="investmenttplPage"></tr>
                        </tbody>
                    </table>
	                    <div class="notice-pagination-box clearfix">
				                <span class="page-total">共查询到 <em id="investmenitemCount">0</em> 条信息，共<em id="investmenpageCount">0</em>页</span>
				                <div id="investment_pagination_one" class="pagination"> </div>
				        </div>
                    </div>
                    
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30">数据来源：国家企业信用信息公示系统企业信息填报</span>
	                    <i class="flex-icon dib2 va-3" id="invsral_li"></i>
	                    <h6 class="add-title dib2">股权变更信息（<span class="light" id="invsralTotal">0</span>）</h6>
                    </div>
                    <table id="invsral_table" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">股东</th>
                            <th>变更前股权比例</th>
                            <th>变更后股权比例</th>
                            <th>股权变更日期</th>
                            <th>公示日期</th>
                        </tr>
                        </thead>
                        <!-- <tbody id="invsral">
                        <tr id="invsraltplPage"></tr>
                        </tbody> -->
                    </table>
                    </div>
                    
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30">数据来源：国家企业信用信息公示系统企业信息填报</span>
	                    <i class="flex-icon dib2 va-3" id="permit_li"></i>
	                    <h6 class="add-title dib2">行政许可信息（<span class="light" id="permittplTotal">0</span>）</h6>
                    </div>
                    <table id="permit_table" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">许可文件编号</th>
                            <th>许可文件名称</th>
                            <th>有效期自</th>
                            <th>有效期至</th>
                            <th>许可机关</th>
                            <th>许可内容</th>
                            <th>状态</th>
                            <th>详情</th>
                        </tr>
                        </thead>
                        <tbody id="permit">
                        <tr id="permittplPage"></tr>
                        </tbody>
                    </table>
                    </div>
                    
                    <div>
                     <div class="gold">
	                    <span class="fr  line-h30" id="imcase_span">数据由企业自行提供</span>
	                    <i class="flex-icon dib2 va-3" id="imcase_li"></i>
	                    <h6 class="add-title dib2">行政处罚信息（<span class="light" id="imcaseTotal">0</span>）</h6>
                    </div>
                    <table id="imcase_table" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th>决定书文号</th>
                            <th>违法行为类型</th>
                            <th>行政处罚内容</th>
                            <th>决定机关名称</th>
                            <th>处罚决定日期</th>
                            <th>公示日期</th>
                            <th>备注</th>
                        </tr>
                        </thead>
                        <tbody id="imcase">
                        <tr id="imcasetplPage"></tr>
                        </tbody>
                    </table>
                    </div>
                    
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30" id="er_esc_appinfo_span">数据来源：企业自行公示</span></h5>
	                    <i class="flex-icon dib2 va-3" id="er_esc_appinfo_li"></i>
	                    <h6 class="add-title dib2">简易注销公告信息（<span class="light" id="er_esc_appinfoTotal">0</span>）</h6>
                    </div>
                    <table id="er_esc_appinfo_table" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">简易注销信息</th>
                            <th>详情</th> 
                        </tr>
                        </thead>
                        <tbody id="table-er_esc_appinfo">
                          <tr id="tr-er_esc_appinfo"></tr>
                        </tbody>
                    </table>
                    </div>
                </div>
         </div>
</div>

<script id="investment-templates" type="text/x-handlebars-template">
 					 {{#each data}}
                        <tr>
 							<td> {{addOne @index}}</td>
                            <td>{{inv}}</td>
                            <td>{{liSubConAm}}</td>
                            <td>{{liAcConAm}}</td>
                            <td valign="top">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table">
                                    <tbody> {{#with imInvprodetailList}} {{#each this}}
                                    <tr>
                                        <td width="20%">{{conFormCN}}</td>
                                        <td width="20%">{{subConAm}}</td>
                                        <td width="20%">{{transDate conDate}}</td>
                                        <td width="20%">{{transDate publicDate}}</td>
                                        <td width="20%">{{trsPubFlag pubFlag}}</td>
                                    </tr>
                                    {{/each}} {{/with}}
                                    </tbody>
                                </table>
                            </td>
                            <td valign="top">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table">
                                    <tbody> {{#with imInvactdetailList}} {{#each this}}
                                    <tr>
                                        <td width="20%">{{acConFormCn}}</td>
                                        <td width="20%">{{acConAm}}</td>
                                        <td width="20%">{{transDate conDate}}</td>
                                        <td width="20%">{{transDate publicDate}}</td>
										<td width="20%">{{trsPubFlag pubFlag}}</td>
                                    </tr>
                                    {{/each}} {{/with}}
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        {{/each}}
</script>

<script id="investment-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{inv}}</td>
        <td>{{liSubConAm}}</td>
        <td>{{liAcConAm}}</td>
        <td valign="top">
             <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody> {{#with imInvprodetailList}} {{#each this}}
                <tr>
                    <td width="28%">{{conFormCN}}</td>
                    <td width="30%">{{subConAm}}</td>
                    <td width="28%">{{transDate conDate}}</td>
                    <td>{{trsPubFlag pubFlag}}</td>
                </tr>
                {{/each}} {{/with}}
                </tbody>
            </table>
        </td>
        <td valign="top">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody> {{#with imInvactdetailList}} {{#each this}}
                <tr>
                    <td width="28%">{{acConFormCn}}</td>
                    <td width="30%">{{acConAm}}</td>
                    <td width="28%">{{transDate conDate}}</td>
                    <td>{{trsPubFlag pubFlag}}</td>
                </tr>
                {{/each}} {{/with}}
                </tbody>
            </table>
        </td>

    </tr>
    {{/each}}
</script>
<!-- 工商和其他部门的行政处罚 -->
<script id="pubOtherpunish-template" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td> {{addOne @index}}</td>
                <td>{{penDecNo}}</td>
                <td>{{illegActType}}</td>
                <td >{{{transPenContent penContent}}}</td>
                <td>{{judAuth}}</td>
                <td>{{penDecIssDate}}</td>
                <td>{{transPubFlag pubFlag}}</td>
				<td>{{{transDetail this}}}</td>
            </tr>
			{{#if pubOtherPunishAlterList}}
            <tr >
                <td colspan="8" class="tip2">
                    <div class="fl">有变更情形：</div>
 					<div class="fl">
                    {{#each pubOtherPunishAlterList}}
                     <p class="fl">{{addOne @index}}、 {{judAuth}} {{altDate}}将{{contents}}</p><br/> 
 					{{/each}}
					</div>
                </td> 
            </tr>
 			{{/if}}
            {{/each}}
</script>
<!-- 企业年度报告 -->
<script id="table-template-yrinfo" type="text/x-handlebars-template">
            {{#each data}}
            <tr data-id="{{year}}">
                <td>{{addOne @index}}</td>
                <td>{{{year}}}</td>
                <td>{{{transAncheDate ancheDate}}}</td>
                <td>{{{transType reportType}}}</td>
            </tr>
            {{/each}}
</script>

<!-- 简易注销公告 -->
<script id="table-template-er_esc_appinfo" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td>{{xh @index}}</td>
                <td>{{{transAncheDate noticeFrom}}}</td>
                <td>{{{transNoticeTo noticeTo}}}</td>
            </tr>
            {{/each}}
</script>

<!-- 即时股权变更 -->
 <script id="invsral-template" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{addOne @index}}</td>
                            <td> {{inv}}</td>
                            <td> {{beTransAmPr}}%</td>
                            <td> {{afTransAmPr}}%</td>
                            <td> {{transDate equAltDate}}</td>
                            <td> {{dataFormat publicDate}}</td>
                        </tr>
                        {{/each}}
</script>

<!-- 即时行政许可 -->
<script id="permit-template" type="text/x-handlebars-template">
                    {{#each data}}
                    <tr>
                        <td> {{addOne @index}}</td>
                        <td> {{licNO}}</td>
                        <td>{{licNameCN}}</td>
                        <td>{{transDate valFrom}}</td>
                        <td> {{transDate valTo}}</td>
                        <td>{{licAnth}}</td>
                        <td>{{licItem}}</td>
                        <td>{{transPubType pubType}}</td>
                        <td><a href="javascript:void(0)" id="{{licID}}" class="showPermit">查看</a></td>
                    </tr>
                    {{/each}}
</script>
<script id="ippldg-template" type="text/x-handlebars-template">
                    {{#each data}}
                    <tr>
                        <td>{{addOne @index}}</td>
                        <td>
                            {{tmregNo}}
                        </td>
                        <td>{{tmname}}</td>
                        <td>{{transkinds kinds}}</td>
                        <td> {{pledgor}}</td>
                        <td>{{impOrg}}</td>
                        <td>{{transDate pleRegPerFrom}}-{{transDate pleRegPerTo}}</td>
                        <td>{{transType pubType}}</td>
                        <td>{{dataFormat publicDate}}</td>
                        <td><a id={{pleID}} href="javascript:void(0)" class="showIppldg">查看</a></td>
                    </tr>
                    {{/each}}
</script>

<script id="imcase-template" type="text/x-handlebars-template">
                    {{#each data}}
                    <tr>
                        <td> {{addOne @index}}</td>
                        <td>{{penDecNo}}</td>
                        <td>{{illegActType}}</td>
                        <td>{{{penContent}}}</td>
                        <td>{{judAuth}}</td>
                        <td>{{transDate penDecIssDate}}</td>
                        <td>{{dataFormat publicDate}}</td>

                        <td rowspan="">{{transType pubType}}</td>
                    </tr>
                    <tr style="{{dataList caslatList}}">
                        <td colspan="8" class="tip2">
                            <div class="fl">有变更情形：</div>
                            <div class="fl">
                                {{#with caslatList}}
                                {{#each this}}
                                <p>{{addOne @index}}.{{dataFormat altDate}}{{penAuthName}}将{{penContent}}。</p>
                                {{/each}}
                                {{/with}}
                            </div>
                        </td>
                    </tr>

                    {{/each}}
</script>

<script id="table-template_pubotherlicence" type="text/x-handlebars-template">
    {{#each data}}
    		<tr>
        		<td>{{addOne @index}}</td>
        		<td>{{licNO}}</td>
        		<td>{{licNameCN}}</td>
        		<td>{{licValFromDesc}}</td>
        		<td>{{licValToDesc}}</td>
        		<td>{{licAnth}}</td>
        		<td style="width: 600px;">{{licScope}}</td>
				<td >{{translicState licState}}</td>
    		</tr>
			<tr style="{{dataList pubOtherlicenceModList}}">
            	<td colspan="9" class="tip2">
                        <div class="fl">有变更情形：</div>
                        <div class="fl">
                            {{#with pubOtherlicenceModList}}
                            	{{#each this}}
                                <p>{{addOne @index}}、{{altDate altDate}}将{{altItem}}由{{altBe}}变更为{{altAf}}。</p>
                                {{/each}}
                        	{{/with}}
                        </div>
            	</td>
            </tr>
    {{/each}}
</script>
<script>
		if("${sysUser.userType}" == "1"){
			 window._CONFIG = {
					 _urlHead:'/reg/server/panoramasearch/',
					 _encryPriPID:'${encryPriPID}'
		     } 
		}else{
			window._CONFIG = {
					_urlHead:'/syn/panoramasearch/',
					_encryPriPID:'${encryPriPID}'
		     } 
		}
</script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/component/tab.js"></script>
<!-- <script src="/js/lib/laydate/laydate.js"></script> -->
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/search/appsearch/appsearchdetails.js"></script>
</body>
</html>
