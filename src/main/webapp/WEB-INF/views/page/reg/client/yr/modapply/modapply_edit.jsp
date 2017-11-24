<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="nowdate" class="java.util.Date" /> 
<fmt:formatDate var="curDate" value="${nowdate}" pattern="yyyy-MM-dd"/> 
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>申请修改年报页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include>
<input type="hidden" name="entTypeCatg" id="entTypeCatg" value="${midBaseInfoDto.entTypeCatg}"/>
<c:if test="${empty modApplicationList}">
<form class="form-horizontal error-bottom" id="modapplyForm">
    <input type="hidden" name="priPID" value="${midBaseInfoDto.priPID}"/> 
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="unicode" value="${midBaseInfoDto.uniCode}"/>
    <input type="hidden" name="entName" value="${midBaseInfoDto.entName}"/>
<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>申请修改年度报告</h3>
        </div>
        <div class="content">
            <table class="table-public table-report">
                <tbody>
                <tr>
                    <td width="296">
                        <div class="item-name">统一代码/注册号：</div>
                        <div class="item-txt">
                        	<c:if test="${!empty midBaseInfoDto.uniCode}">${midBaseInfoDto.uniCode}</c:if>
                        	<c:if test="${empty midBaseInfoDto.uniCode}">${midBaseInfoDto.regNO}</c:if>
                        </div>
                    </td>
                    <td width="320">
                        <div class="item-name">企业名称：</div>
                        <div class="item-txt">${midBaseInfoDto.entName}</div>
                    </td>
                    <td>
                    	<div class="item-name">年度报告年度：</div>
                        <div class="item-txt">${year}</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name">申请日期：</div>
                        <div class="item-txt">${curDate}</div>
                    </td>
                    <td>
                        <div class="item-name"></div>
                        <div class="item-txt"></div>
                    </td>
                    <td>
                        <div class="item-name"></div>
                        <div class="item-txt"></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <div class="item-name">修改原因及内容：</div>
                        <div class="item-txt">
                            <textarea name="modReason" placeholder="请填写原因" cols="" rows="13" class="textarea-w788"></textarea>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <p class="btn-box"><input type="submit" value="保存" id="saveButton" class="btn-common"><input type="button" value="取消" class="btn-common" id="cancel"></p>
        </div>
    </div>
</div>
</form>
</c:if>
<c:if test="${!empty modApplicationList && modApplicationList[0].modResult == '2'}">
<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>申请修改年度报告——审核未通过</h3>
        </div>
        <div class="content content-change-report clearfix">
            <div class="change-report-left">
                <div class="thumbnail">
                    <img src="<c:url value="/img/reg/client/audit-notpass.png"/>" alt="">
                </div>
            </div>
            <div class="change-report-right">
                <h3 class="light">很抱歉，您的年度报告修改申请未通过
                    <a href="javascript:void(0);" class="reapply">重新申请</a>
                </h3>
                <p>企业名称：${modApplicationList[0].entName}</p>
                <p>注册号：${midBaseInfoDto.regNO}</p>
                <p>申请日期：<fmt:formatDate value="${modApplicationList[0].modSubmitDate}" pattern="yyyy-MM-dd"/></p>
                <p>修改原因：${modApplicationList[0].modReason}</p>
                <p>审核结果：不同意</p>
                <p>结果说明：${modApplicationList[0].modDescription}</p>
            </div>
        </div>
    </div>
</div>
</c:if>
<c:if test="${!empty modApplicationList && modApplicationList[0].modResult == '0'}">
<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>申请修改年度报告——审核中</h3>
        </div>
        <div class="content content-change-report clearfix">
            <div class="change-report-left">
                <div class="thumbnail">
                    <img src="<c:url value="/img/reg/client/auditing.png"/>" alt="">
                </div>
            </div>
            <div class="change-report-right">
                <h3 class="warning">年度报告修改申请已提交，请耐心等待审批结果</h3>
                <p>企业名称：${modApplicationList[0].entName}</p>
                <p>注册号：${midBaseInfoDto.regNO}</p>
                <p>申请日期：<fmt:formatDate value="${modApplicationList[0].modSubmitDate}" pattern="yyyy-MM-dd"/></p>
                <p>修改原因：${modApplicationList[0].modReason}</p>
            </div>
        </div>
    </div>
</div>
</c:if>
<c:if test="${!empty modApplicationList && modApplicationList[0].modResult == '1'}">
<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>申请修改年度报告——审核通过</h3>
        </div>
        <div class="content content-change-report clearfix">
            <div class="change-report-left">
                <div class="thumbnail">
                    <img src="<c:url value="/img/reg/client/audit-pass.png"/>" alt="">
                </div>
            </div>
            <div class="change-report-right">
                <h3>恭喜您，您的年度报告修改申请已审核通过</h3>
                <p>企业名称：${modApplicationList[0].entName}</p>
                <p>注册号：${midBaseInfoDto.regNO}</p>
                <p>申请日期：<fmt:formatDate value="${modApplicationList[0].modSubmitDate}" pattern="yyyy-MM-dd"/></p>
                <p>修改原因：${modApplicationList[0].modReason}</p>
                <p>审核结果：同意</p>
                <p class="warning">结果说明：${modApplicationList[0].modDescription}</p>
            </div>
        </div>
    </div>
</div>
</c:if>
<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3><i class="icon-history"></i>历史申请记录</h3>
            <div class="currency">
                <div class="show-tips">
                    <span>展开</span>
                    <i></i>
                </div>
            </div>
        </div>
        <div class="content js-content-show">
            <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="60">序号</th>
                    <th width="88" class="pos">申请日期
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-name="modSubmitDate" data-order="asc"></i>
                            <i class="icon-arrow-down cur order_by" data-name="modSubmitDate" data-order="desc"></i>
                        </div>
                    </th>
                    <th width="140">修改原因及内容</th>
                    <th width="88" class="pos">审核状态
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-name="modResult" data-order="asc"></i>
                            <i class="icon-arrow-down order_by" data-name="modResult" data-order="desc"></i>
                        </div>
                    </th>
                    <th width="390">审核意见</th>
                    <th width="80">审核人</th>
                    <th class="pos">审核日期
                        <div class="arrow-box">
                            <i class="icon-arrow-up order_by" data-name="audDate" data-order="asc"></i>
                            <i class="icon-arrow-down order_by" data-name="audDate" data-order="desc"></i>
                        </div>
                    </th>
                </tr>
                </thead>
                <tbody id="modItem">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount"></em> 条信息，共<em id="pageCount"></em>页</span>
                <div id="pagination" class="pagination">

                </div>
            </div>
        </div>

    </div>
</div>

<jsp:include page="../../common/footer.jsp"></jsp:include>

<form id="_params">
    <input type="hidden" name="year" value="${year}"/>
    <input type="hidden" name="encodeYear" id="encodeYear" value="${encodeYear}"/>
    <input type="hidden" name="priPID" value="${midBaseInfoDto.priPID}"/>
	<!-- 默认按申请日期降序 -->
    <input type="hidden" id="orderby" name="orderby" value="modSubmitDate desc"/>
</form>

<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{addOne @index}}</td>
        <td>{{modSubmitDate}}</td>
        <td>{{modReason}}</td>
        <td>{{modResult modResult}}</td>
        <td>{{modDescription}}</td>
        <td>{{audName}}</td>
        <td>{{audDate}}</td>
    </tr>
    {{/each}}
</script>

<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/yr/modapply/edit_main.js"></script>
</body>
</html>