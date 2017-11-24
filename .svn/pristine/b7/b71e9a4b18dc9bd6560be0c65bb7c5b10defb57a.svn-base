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
    <input type="hidden" id="busExcList" name="busExcList" value="${busExcList}">
    <input type="hidden" id="entTypeFlag" name="entTypeFlag" value="${entTypeFlag}">
    <input type="hidden" id="entTypeCatg" value="${dto.entTypeCatg}">
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
        <div class="btn-box ent">
            <div class="mb5 clearfix">
                <a class="btn-attention-box">
                    <i class="attention-icon"></i>
                    <span>关注本企业</span>
                </a>
                <a class="btn-print-box">
                    <i class="print-icon2"></i>
                    <span>打印</span>
                </a>
            </div>
            <div>
                <a class="btn-attention-box">
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
                    ${dto.leRep}     ${dto.tel}
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
<div class="tabbale" data-component="tab">
   <div class="tab-content">  
       <div class="tab-panel tab-panel-show">
              <div> 
                    <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="qyjyqcxx_li"></i>
	                    <h6 class="add-title dib2">列入经营异常名录（<span class="light" id="qyjyqcxxTotal">1</span>）</h6>
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
	   </div>
  </div>
</div>
<script>
window._CONFIG = {
   chooseUrl:'${userType == 2 ? "/syn" : "/reg"}', 
}
</script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/opanomaly/opanosearch/opanosearch_details.js"/>"></script>
</body>
</html>
