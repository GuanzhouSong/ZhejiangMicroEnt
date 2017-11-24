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
    <title>网站网店信息详情</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<style type="text/css">
.gold{background-color: #fff4df;}
</style>
<body class="pd10">
<div class="clearfix reg-company-basic reg-company-basic-yellowish">
    <div class="clearfix reg-caption">
        <div class="title clearfix">
            <span class="name fl mr5">${midBaseInfo.entName}</span>
            <span class="${hx:yReportStyle(midBaseInfo.regState)}">${hx:publicStatus(midBaseInfo.regState)}</span>
            <span class="icon-rectangle blue fl mr10">${midBaseInfo.isIndivid=='1'?'个转企':''}</span>
            <c:if test="${isOpanomaly=='1'}">
             <span class="icon-rectangle red fl mr10">被列入经营异常名录和严重违法失信（黑名单）</span>
            </c:if>
            <c:if test="${isOpanomaly=='2'}">
             <span class="icon-rectangle red fl mr10">被列入经营异常名录</span>
            </c:if>
            <c:if test="${isOpanomaly=='3'}">
             <span class="icon-rectangle red fl mr10">被列入严重违法失信（黑名单）</span>
            </c:if>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="book2-icon"></i>统一社会信用代码/注册号：<span>${empty midBaseInfo.uniCode?midBaseInfo.regNO:midBaseInfo.uniCode}</span>
            </p>
            <p>
                <i class="local-icon"></i>登记机关：<span>${midBaseInfo.regOrgName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="person-icon"></i>法定代表人：<span>${midBaseInfo.leRep}</span>
            </p>
            <p>
                <i class="government-icon"></i>管辖单位：<span>${midBaseInfo.localAdmName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="capital-icon"></i>注册资本：
                <span>
                    <c:if test="${!empty midBaseInfo.regCap}">
                        <fmt:formatNumber type="number"  value=" ${midBaseInfo.regCap }"  pattern="0.00" maxFractionDigits="2"/>(万元)
                    </c:if>
                </span>
            </p>
            <c:if test="${midBaseInfo.regState!='D'&&midBaseInfo.regState!='DX'}">
                <p><i class="date-icon"></i>成立日期：<span><fmt:formatDate value="${midBaseInfo.estDate}" dateStyle="long"/></span></p>
            </c:if>
        </div>
        <div class="clearfix">
           <c:if test="${midBaseInfo.regState=='D'}">
               <p class="w360">
                   <i class="date-icon"></i>吊销日期：<span><fmt:formatDate value="${midBaseInfo.altDate}" dateStyle="long"/></span>
               </p>
           </c:if>

           <c:if test="${midBaseInfo.regState=='DX'}">
               <p>
                   <i class="date-icon"></i> 注销日期：<span class="light"><fmt:formatDate value="${midBaseInfo.altDate}" dateStyle="long" /></span>
               </p>
           </c:if>
       </div>
       <div class="clearfix">
           <c:if test="${midBaseInfo.isIndivid=='1'}">
               <p>
                   <i class="date-icon"></i> 转企日期：<span class="light"><fmt:formatDate value="${midBaseInfo.individDate}" dateStyle="long"/></span>
               </p>
           </c:if>
           <p>
               <i></i>&nbsp;<span class="light">&nbsp;</span>
           </p>
       </div>
       
       <c:if test="${yrRegCheck.isReported == 1 || yrRegCheck.isReported == 2}">
            <div class="btn-box">
                <div class="mb5 clearfix">
                    <a class="btn-print-box" style="width: 162px;">
                        <i class="print-icon2"></i>
                        <span class="dy-report-bg">打印年度报告</span>
                        <c:if test="${fn:indexOf('16,17,50',midBaseInfo.entTypeCatg) == -1}">
                            <input type="hidden" class="js-reprot-year" value="<c:url value="/reg/server/reportprint/showReportProvePage"/>">
                        </c:if>
                        <c:if test="${midBaseInfo.entTypeCatg == 16 || midBaseInfo.entTypeCatg == 17}">
                            <input type="hidden" class="js-reprot-year" value="<c:url value="/reg/server/reportprint/showSfcReportProve"/>">
                        </c:if>
                        <c:if test="${midBaseInfo.entTypeCatg == 50}">
                            <input type="hidden" class="js-reprot-year" value="<c:url value="/reg/server/reportprint/showPbReportProve"/>">
                        </c:if>
                    </a>
                </div>
                <div>
                    <a class="btn-print-box" style="width: 162px;">
                        <i class="print-icon2"></i>
                        <span class="dy-reprot-zm">打印年度报告证明</span>
                        <c:if test="${fn:indexOf('16,17,50',midBaseInfo.entTypeCatg) == -1}">
                            <input type="hidden" class="js-reprot-zm" value="<c:url value="/reg/server/reportprint/showEnAnnualReportProve"/>">
                        </c:if>
                        <c:if test="${midBaseInfo.entTypeCatg == 16 || midBaseInfo.entTypeCatg == 17}">
                            <input type="hidden" class="js-reprot-zm" value="<c:url value="/reg/server/reportprint/printPubSfcPrintProve"/>">
                        </c:if>
                        <c:if test="${midBaseInfo.entTypeCatg == 50}">
                            <input type="hidden" class="js-reprot-zm" value="<c:url value="/reg/server/reportprint/printPubPbPrintProve"/>">
                        </c:if>
                    </a>
                </div>
            </div>
        </c:if>
        <div class="supervise-about mt5 mb5">
            <div class="more js-fold reverse" style="cursor: pointer">展开详情<i></i></div>
        </div>
    </div>
    
    <c:if test="${erEscAppinfo.simplecanRea=='4'}">
        <div class="notice"><i class="notice-icon"></i>正在进行简易注销公告：公告期：<fmt:formatDate value="${erEscAppinfo.noticeFrom}" pattern="yyyy年MM月dd日"/>-<fmt:formatDate value="${erEscAppinfo.noticeTo}" pattern="yyyy年MM月dd日"/></div>
    </c:if>
</div>

<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal  js-table-horizontal" style="display:none;">
    <tbody>
    <tr>
        <td class="bg-gray right" width="15%">类型</td>
        <td>${midBaseInfo.entTypeName}</td>
        <td class="bg-gray right">核准日期</td>
        <td><fmt:formatDate value="${midBaseInfo.apprDate}" dateStyle="long"/></td>
    </tr>
    <tr>
        <td class="bg-gray right">住所</td>
        <td>${midBaseInfo.dom}</td>
        <td class="bg-gray right">营业期限</td>
        <td><fmt:formatDate value="${midBaseInfo.opFrom}" dateStyle="long"/>至<fmt:formatDate value="${midBaseInfo.opTo}" dateStyle="long"/></td>
    </tr>
    <tr>
        <td class="bg-gray right">经营范围</td>
        <td colspan="3">${midBaseInfo.opScope}</td>
    </tr>
    </tbody>
</table>

<div class="mb5">
    <span class="tag-block-item ft14 mr30"><i class="tag33cccc"></i>分类监管项目（<em class="light">${apprMarkRelDtoSize }</em>）/抽查专项库（<em class="light">${apprMarkRelSccount }</em>）</span>
    <span class="tag-block-item ft14 mr30"><i class="tagff6666"></i>重点监管对象（<em class="light">${csSuperviseObjDtoSize }</em>）</span>
    <span class="tag-block-item ft14 mr30"><i class="tag66cc66"></i>关注服务对象（<em class="light">${csConcernObjDtoSize }</em>）</span>
    <span class="tag-block-item ft14 mr30"><i class="tagff6600"></i>预警提醒提示（<em class="light">${tipsSize }</em>）</span>
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
	<c:forEach var="tip" items="${tips}">
	    <span class="tagff6600 tag-item">${tip}</span>
	</c:forEach>
</div>
<div class="light-info mt10">
    <div class="form-list light ">
        <div class="form-item clearfix">
            <div id="uniCode" class="col-4">
                <label class="right col-6">法定代表人（负责人）：</label>
                <div class="col-6">
                    ${midBaseInfo.leRep}     ${midBaseInfo.tel}
                </div>
            </div>
            <div class="col-4" id="entName">
                <label class="right col-6">工商联络员：</label>
                <div class="col-6">
                   ${liaName}   ${liaTel}
                </div>
            </div>
        </div>
    </div>
</div>
<!--获取加密的年份和pripid 参数 start-->
    <c:forEach var="selectYear" items="${yearList}">
        <input type="hidden" class="js-year"  data-year="${hx:encodeYear(selectYear)}"  value="${selectYear}">
    </c:forEach>
      <input type="hidden" id="js-pripid"  value="${hx:encodePripid(priPID)}" >
<!--获取加密的年份和pripid 参数 end -->
<div class=" clearfix pd10">
    <div>
        <h2 class="border-bottom pdb10 h15-title">
        	<input type="hidden" id="priPID" value="${priPID}">
        	<input type="hidden" id="systemType" value="${systemType}">
            <strong>报告年度：</strong>
            <select id="year_list">
                <option value="">--请选择--</option>
                <c:forEach var="selectYear" items="${yearList}">
                   <option value="${selectYear}" ${year==(selectYear)?'selected':''}>${selectYear}</option>
                </c:forEach>
            </select>
                &nbsp;&nbsp;
                报告年度：<em class="light">${yrRegCheck.year}</em>
                &nbsp;&nbsp;
                年报状态：
                <c:if test="${yrRegCheck.isReported==0 }">
                    <em class="light">未年报</em>
                </c:if>
                <c:if test="${yrRegCheck.isReported==1 }">
                    <em class="light"> 已年报</em>
                </c:if>
                <c:if test="${yrRegCheck.isReported==2 }">
                    <em class="light">已年报（逾期）</em>
                </c:if>
                &nbsp;&nbsp;
                年报日期：
                <em class="light"><fmt:formatDate value="${yrRegCheck.firstReportTime}" pattern="yyyy-MM-dd HH:mm:ss"/></em>
                &nbsp;&nbsp;
                当前状况：
                <c:if test="${yrRegCheck.reportState=='00' }">
                    <em class="light"> 未公示</em>
                </c:if>
                <c:if test="${yrRegCheck.reportState=='10' }">
                    <em class="light">已公示</em>
                </c:if>
                <c:if test="${yrRegCheck.reportState=='11' }">
                    <em class="light">敏感词通过</em>
                </c:if>
                <c:if test="${yrRegCheck.reportState=='12' }">
                    <em class="light">敏感词待审核</em>
                </c:if>
                <c:if test="${yrRegCheck.reportState=='13' }">
                    <em class="light"> 敏感词不通过</em>
                </c:if>
                <c:if test="${yrRegCheck.reportState=='20' }">
                    <em class="light"> 待修改</em>
                </c:if>
                &nbsp;&nbsp;
                最近修改日期：
                <em class="light"><fmt:formatDate value="${yrRegCheck.lastReportTime}" pattern="yyyy-MM-dd HH:mm:ss"/></em>
        </h2>
    </div>

	<h4 class="h4-title mt10">网站网店信息</h4>
    <div class="start-copy">
        <table id="webTable" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row mt30">
            <thead>
            <tr>
                <th>序号</th>
                <th>类型</th>
                <th>网站类型/网店所属平台</th>
                <th>网站网店名称</th>
                <th>网址（域名）</th>
                <th>ICP备案号</th>
                <th>微信公众号</th>
                <th>手机APP服务</th>
                <th>发货地址</th>
                <th>退货地址</th>
                <th>网络交易平台运营类型</th>
                <th>网络交易产品类型</th>
                <th>电商类型</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/yr/websiteinfosearch/websiteinfosearch_details.js"/>"></script>
</body>
</html>
