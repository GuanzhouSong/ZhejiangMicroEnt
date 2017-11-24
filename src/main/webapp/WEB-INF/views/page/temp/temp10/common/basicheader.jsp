<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!-- 公司基本信息 -->
<div class="mod company-basic clearfix">
    <div class="caption">
        <h3 class="title">${entBasicInfo.entName }
        	<c:if test="${entBasicInfo.regState=='K'||entBasicInfo.regState=='A'||entBasicInfo.regState=='B'}">
	            <span class="icon-rectangle icon-blue">存续</span>
            </c:if>
            <c:if test="${entBasicInfo.regState=='DA'}">
            	<span class="tip">（该企业被列入经营异常名录）</span>
           		<span class="icon-rectangle icon-red">吊销未注销</span>
            </c:if>
            <c:if test="${entBasicInfo.regState=='D'}">
            	<span class="tip">（该企业被列入经营异常名录）</span>
           		<span class="icon-rectangle icon-gray">吊销</span>
            </c:if>
        </h3>
        <p>
            <i class="book-icon"></i>统一社会信用代码/注册号：<span>${entBasicInfo.regNO }</span>
        </p>
        <p>
            <i class="person-icon"></i>法定代表人：<span>${entBasicInfo.leRep }</span>
        </p>
        <p>
            <i class="local-icon"></i>住所：<span>${entBasicInfo.dom }</span>
        </p>
        <p>
            <i class="date-icon"></i>成立日期：<span><fmt:formatDate value="${entBasicInfo.estDate}" pattern="yyyy-MM-dd"/> </span>
        </p>
    </div>
    <div class="btn-box">
        <a href="#"><i class="send-icon"></i>发送报告</a>
        <a href="#" class="light-blue-bg"><i class="share-icon"></i>信息分享</a>
        <a href="#" class="green-bg"><i class="print-icon"></i>信息打印</a>
    </div>
</div>
<div class="mod tab-header-outer">
    <div class="tab-header tab-detail">
        <ul class="clearfix">
            <li class="tab-selected"><a class="tab-item" href="javascript:void(0);">基础信息</a></li>
            <li>|</li>
            <li><a class="tab-item" href="javascript:void(0);">行政许可信息</a></li>
            <li>|</li>
            <li><a class="tab-item" href="javascript:void(0);">行政处罚信息</a></li>
            <li>|</li>
            <li><a class="tab-item" href="javascript:void(0);">纳入经营异常名录信息</a></li>
            <li>|</li>
            <li><a class="tab-item" href="javascript:void(0);">纳入严重违法失信企业名单（黑名单）信息</a></li>
        </ul>
    </div>
</div>


