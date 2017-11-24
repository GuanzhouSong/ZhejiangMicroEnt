<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业详情</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="clearfix reg-company-basic">
<input type="hidden" id="priPID" value="${priPID }">
<input type="hidden" id="uid" value="${uid}">
    <div class="clearfix reg-caption">
        <div class="title clearfix">
            <span class="name fl mr5">${entBasicInfo.entName }</span>
            <span class="${hx:yReportStyle(entBasicInfo.regState)}">${hx:publicStatus(entBasicInfo.regState)}</span>
            <c:if test="${entBasicInfo.isIndivid=='1'}"> 
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
        <p>
            <i class="book2-icon"></i>统一社会信用代码/注册号：
            <span>
             <c:choose>
                <c:when test="${!empty entBasicInfo.uniCode}">
                    ${entBasicInfo.uniCode }
                </c:when>
                <c:otherwise>
                    ${entBasicInfo.regNO }
                </c:otherwise>
            </c:choose>
            </span>
        </p>
        <p>
            <i class="local-icon"></i>登记机关：<span>${entBasicInfo.regOrgName }</span>
        </p>
        <p>
        <c:if test="${fn:indexOf('12,14,34,32,22,28,24,17,26', entBasicInfo.entTypeCatg)!=-1}">
            <i class="person-icon"></i>负责人：<span></span>
        </c:if>
        <c:if test="${fn:indexOf('11,21,13,16', entBasicInfo.entTypeCatg)!=-1}">
                <i class="person-icon"></i>法定代表人：
         </c:if>
         <c:if test="${fn:indexOf('33,27', entBasicInfo.entTypeCatg)!=-1}">
             <i class="person-icon"></i>执行事务合伙人：
         </c:if>
         <c:if test="${fn:indexOf('31', entBasicInfo.entTypeCatg)!=-1}">
             <i class="person-icon"></i>投资人：
         </c:if>
         <c:if test="${fn:indexOf('50', entBasicInfo.entTypeCatg)!=-1}">
             <i class="person-icon"></i>经营者：
         </c:if>
          ${entBasicInfo.leRep }
        </p>
        <p>
            <i class="government-icon"></i>管辖单位：<span>${entBasicInfo.localAdmName}</span>
        </p>
        <p>
            <i class="capital-icon"></i>注册资本：
            <span>	<c:if test="${!empty entBasicInfo.regCap}">
			          <fmt:formatNumber type="number"  value=" ${entBasicInfo.regCap }"  pattern="0.00" maxFractionDigits="2"/>  
			         (万元)
         			</c:if>
         	</span>
        </p>
       <%--  <p><i class="date-icon"></i>成立日期：<span><fmt:formatDate value="${entBasicInfo.estDate}" dateStyle="long"/></span></p> --%>
        <c:if test="${entBasicInfo.isIndivid=='1'}">
        <p>
            <i class="date-icon"></i>转企日期：<span><fmt:formatDate value="${entBasicInfo.individDate}" dateStyle="long"/></span>
        </p>
        </c:if>
        <p>
        <c:choose>
                <c:when test="${entBasicInfo.regState=='D'}">
                    <i class="date-icon"></i>吊销日期：<span> <fmt:formatDate value="${entBasicInfo.altDate}"
                                                                         dateStyle="long"/></span>
                </c:when>
                <c:when test="${entBasicInfo.regState=='XX'||entBasicInfo.regState=='DX'}">
                    <i class="date-icon"></i>注销日期：<span>
                    <fmt:formatDate value="${entBasicInfo.altDate}" dateStyle="long"/>
                    </span>
                </c:when>
                <c:otherwise>
                    <i class="date-icon"></i>成立日期：<span>
                    <fmt:formatDate value="${entBasicInfo.estDate}" dateStyle="long"/>
                    </span>
                </c:otherwise>
            </c:choose>
        </p>
        <div class="btn-box">
            <div>
            <a href="javascript:void(0);" class="green-bg" id="printbtn" target="_blank"><input type="button" class="btn-print" id="s" /></a>
            </div>
            <div class="mt5"><input type="button" id="infoImport" class="btn-export"/></div>
            <div class="more js-fold" style="cursor:hand">收起详情<i></i></div>
             <!--  <div class="more reverse">点击后新增reverse类名<i></i></div> --> 
        </div>
    </div>
</div>
<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal" id="entDetail">
    <tbody>
    <tr>
        <td class="bg-gray right" width="15%">企业类型</td>
        <td>${entBasicInfo.entTypeName}</td>
        <td class="bg-gray right">核准日期</td>
        <td><fmt:formatDate value="${entBasicInfo.apprDate}" dateStyle="long"/></td>
    </tr>
    <tr>
        <td class="bg-gray right">住所</td>
        <td>${entBasicInfo.dom}</td>
        <td class="bg-gray right">营业期限</td>
        <td><fmt:formatDate value="${entBasicInfo.opFrom}" dateStyle="long"/>至<fmt:formatDate value="${entBasicInfo.opTo}" dateStyle="long"/></td>
    </tr>
    <tr>
        <td class="bg-gray right">经营范围</td>
        <td colspan="3">  ${entBasicInfo.opScope}</td>
    </tr>
    </tbody>
</table>
<div class="light-info mt10">
    <div class="form-list light ">
        <div class="form-item clearfix">
            <div id="uniCode" class="col-4">
                <label class="right col-6">法定代表人（负责人）：</label>
                <div class="col-6">
                ${entBasicInfo.leRep}     ${entBasicInfo.tel}
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
                                                    李二    13596489562
                </div>
            </div> -->
        </div>
    </div>
</div>
<div class="clearfix mt5 mb5">
    <h6 class="add-title fl">企业良好信息（<span class="light" id="favorableCount">0</span>）</h6>
    <div class="ipt-box col-1">
        <select name="efftStatus" id="efftStatus">
            <option value="">全部</option>
            <option value="1" selected="selected">有效</option>
            <option value="0">无效</option>
        </select>
    </div>
</div>
<table class="table-row" cellpadding="0" cellspacing="0" border="0">
    <thead>
    <tr>
        <th>序号</th>
        <th>良好信息名称</th>
        <th>良好信息类别</th>
        <th>评定级别</th>
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
    <tbody id="case">
    </tbody>
</table>
<script id="case-template" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td> {{addOne @index}}</td>
				<td>{{favName}}</td>
                <td>{{transfavType favType}}</td>
                <td>{{translicZone licZone}}</td>
                <td>{{regYear}}</td>
                <td>{{regType}}</td>
                <td>{{regFrom}}</td>
                <td>{{regTo}}</td> 
                <td rowspan="">{{transEfftStatus efftStatus}}</td>
				<td>{{regDate}}</td> 
				<td>{{regDocNo}}</td> 
				<td>{{{regDeptCn}}}</td> 
            </tr>
            {{/each}}
        </script>
<div class="clearfix mt5 mb5">
    <h6 class="add-title fl">企业不良信息（<span class="light" id="CaseTotalCount">0</span>）</h6>
</div>
<table class="table-row" cellpadding="0" cellspacing="0" border="0">
    <thead>
    <tr>
        <th>序号</th>
        <th>不良信息类别</th>
        <th>信息来源</th>
        <th>发生日期</th>
        <th>文号</th>
    </tr>
    </thead>
    <tbody id="ippldg">
    </tbody>
</table>
<script id="ippldg-template" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td>{{addOne @index}}</td>
                <td>{{regType}}</td>
                <td>{{transRegDeptCn regDeptCn}}</td>
                <td> {{regDate}}</td>
                <td>{{transRegDocNo regDocNo}}</td>
            </tr>
            {{/each}}
</script>
</body>
<script>
    //参数的传递
    window._CONFIG = {
        repType: '${imReportType}',
        _sysUrl: '${sysUrl}'

    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/favorable/favorabledetail_edit_main.js"></script>
<script src="/js/reg/server/favorable/favorabledetail_print_main.js"></script>
</html>
