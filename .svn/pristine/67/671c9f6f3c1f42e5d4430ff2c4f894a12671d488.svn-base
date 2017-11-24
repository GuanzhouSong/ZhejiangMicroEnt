<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="<c:url value="/css/reg.client.css"/>">
</head>
<body>
<div class="mod header">
    <a href="##" target="_blank">
        <img src="<c:url value="/img/reg/client/reg-c-logo.jpg"/>" alt="">
    </a>
</div>
<div class="bg-blue">
    <div class="mod clearfix gssb-nav">
        <h3 class="h22-title">工商部门咨询电话——《企业工商联络员备案表》送达地址与联系信息</h3>
    </div>
</div>
<div class="mt20">
    <div class="mod mod-contact">
        <div class="tabbale clearfix" data-component="tab">
            <div class="tab-header">
                <ul class="contact-city-list">
                    <li class="tab-selected">
                        <a class="tab-item" href="javascript:void(0);">省局</a>
                    </li>
                    <li>
                        <a class="tab-item" href="javascript:void(0);">杭州</a>
                    </li>
                    <li>
                        <a class="tab-item" href="javascript:void(0);">宁波</a>
                    </li>
                    <li>
                        <a class="tab-item" href="javascript:void(0);">温州</a>
                    </li>
                    <li>
                        <a class="tab-item" href="javascript:void(0);">嘉兴</a>
                    </li>
                    <li>
                        <a class="tab-item" href="javascript:void(0);">湖州</a>
                    </li>
                    <li>
                        <a class="tab-item" href="javascript:void(0);">绍兴</a>
                    </li>
                    <li>
                        <a class="tab-item" href="javascript:void(0);">金华</a>
                    </li>
                    <li>
                        <a class="tab-item" href="javascript:void(0);">衢州</a>
                    </li>
                    <li>
                        <a class="tab-item" href="javascript:void(0);">舟山</a>
                    </li>
                    <li>
                        <a class="tab-item" href="javascript:void(0);">台州</a>
                    </li>
                    <li>
                        <a class="tab-item" href="javascript:void(0);">丽水</a>
                    </li>
                </ul>
            </div>
            <div class="tab-content">
                <!-- 省局 start -->
                <div class="tab-panel tab-panel-show">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3300")}">
			                        	<c:set var="sum" value="${sum=sum+1}" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName}</td>
			                            <td class="left">${deliver.deliAddress}</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3300")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3300")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 省局 end -->
                <!-- 杭州 start -->
                <div class="tab-panel">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3301")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3301")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3300")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 杭州 end -->
                <!-- 宁波 start -->
                <div class="tab-panel">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3302")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3302")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3302")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 宁波 end -->
                <!-- 温州 start -->
                <div class="tab-panel">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3303")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3303")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3303")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 温州 end -->
                <!-- 嘉兴start -->
                <div class="tab-panel">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3304")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3304")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3304")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 嘉兴 end -->
                <!-- 湖州 start -->
                <div class="tab-panel">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3305")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3305")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3305")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 湖州 end -->
                <!-- 绍兴 start -->
                <div class="tab-panel">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3306")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3306")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3306")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 绍兴 end -->
                <!-- 金华 start -->
                <div class="tab-panel">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3307")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3307")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3307")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 金华 end -->
                <!-- 衢州 start -->
                <div class="tab-panel">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3308")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3308")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3308")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 衢州 end -->
                <!-- 舟山 start -->
                <div class="tab-panel">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3309")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3309")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3309")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 舟山 end -->
                <!-- 台州 start -->
                <div class="tab-panel">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3310")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3310")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3310")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 台州 end -->
                <!-- 丽水 start -->
                <div class="tab-panel">
                    <div class="tabbale clearfix" data-component="tab">
                        <div class="tab-header">
                            <ul class="contact-sub-tab-list clearfix">
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">内资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">外资企业</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="tab-item">农民专业合作社</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-panel tab-panel-show">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==1 && fn:startsWith(deliver.deliCode,"3325")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==2 && fn:startsWith(deliver.deliCode,"3325")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-panel">
                                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                                    <thead>
                                    <tr>
                                        <th width="60">序号</th>
                                        <th width="250">送达单位名称</th>
                                        <th width="180">送达地址</th>
                                        <th width="100">邮政编码</th>
                                        <th width="130">联系电话</th>
                                        <th>备注</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="sum" value="0" /> 
			                        <c:forEach items="${deliverList }" var="deliver" varStatus="i">
			                        	<c:if test="${deliver.deliType==3 && fn:startsWith(deliver.deliCode,"3325")}">
			                        	<c:set var="sum" value="${sum=sum+1 }" /> 
			                        	<tr>
			                            <td>${sum}</td>
			                            <td class="left">${deliver.deliName }</td>
			                            <td class="left">${deliver.deliAddress }</td>
			                            <td>${deliver.postalCode }</td>
			                            <td>${deliver.tel }</td>
			                            <td class="left">${deliver.remark }</td>
			                      	  </tr>
			                        	</c:if>
			                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 丽水 end -->
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/component/tab.js"></script>
</body>
</html>