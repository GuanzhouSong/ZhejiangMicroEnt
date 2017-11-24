<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>关注服务活动单</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css"> 
</head>
<body>
<div class="pd20">
    <div class="print-nocard mb20">
        <h3>关注服务活动单</h3>
    </div>
    <div class="form-list">
    	<input type="hidden" id="id" value="${activity.id}" >
    	
    	<form id="activityForm">
	        <div class="form-item clearfix">
	            <label class="item-name col-3">关注服务主题：</label>
	            <div class="col-8">
	                <div class="ipt-box">
	                    ${activity.theme}
	                </div>
	            </div>
	        </div>
	        <div class="form-item clearfix">
	            <label class="item-name col-3 newline">关注服务内容：<p class="light-gray">（包括目的，具体形式，具体内容，开展效果评价等）</p></label>
	            <div class="col-8">
	                <div class="ipt-box">
	                    <textarea rows="5" name="content" readonly>${activity.content}</textarea>
	                </div>
	            </div>
	        </div>
	        <div class="form-item clearfix">
	            <label class="item-name col-3">关注服务对象：</label>
	            <div class="col-8">
	                <div class="ipt-box col-5">
	                	<input type="text" class="ipt-txt" id="markName" name="markName" value="${activity.markName}" readonly >
	                	<input type="hidden" id="markNo" name="markNo" value="${activity.markNo}" >
	                </div>
	            </div>
	        </div>
	        <div class="form-item clearfix">
	            <label class="item-name col-3">开展关注服务日期：</label>
	            <div class="col-8">
	                <div class="ipt-box col-2">
	                    <input type="text" class="ipt-txt" id="dateBegin" name="dateBegin" value="<fmt:formatDate value="${activity.dateBegin}" pattern="yyyy-MM-dd" />"  readonly >
	                </div>
	                <span class="item-txt col-1"><i class="line-icon"></i></span>
	                <div class="ipt-box col-2">
	                    <input type="text" class="ipt-txt" id="dateEnd" name="dateEnd" value="<fmt:formatDate value="${activity.dateEnd}" pattern="yyyy-MM-dd" />"  readonly >
	                </div>
	                <div class="radio-box">
	                    <label class="ml20"><input type="checkbox" id="isLong" name="isLong" value="1" <c:if test="${activity.isLong=='1'}">checked="checked"</c:if>>长期</label>
	                </div>
	            </div>
	        </div>
	        
	        <div class="form-item clearfix">
	            <label class="item-name col-3">关注服务形式：</label>
	            <div class="col-8">
	                <div class="col-12 clearfix">
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" name="actFormat" value="贷款授信" class="money" <c:if test="${activity.actFormat=='贷款授信'}">checked="checked"</c:if>>贷款授信</label>
	                        </div>
	                        <div class="ipt-box fl">
	                            <c:if test="${activity.actFormat=='贷款授信'}">金额：${activity.amount}&nbsp;万元</c:if>
	                        </div>
	                    </div>
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" name="actFormat" value="奖金奖励" class="money" <c:if test="${activity.actFormat=='奖金奖励'}">checked="checked"</c:if>>奖金奖励</label>
	                        </div>
	                        <div class="ipt-box fl">
	                            <c:if test="${activity.actFormat=='奖金奖励'}">金额：${activity.amount}&nbsp;万元</c:if>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-12 clearfix">
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" name="actFormat" value="税费优惠" class="money" <c:if test="${activity.actFormat=='税费优惠'}">checked="checked"</c:if>>税费优惠</label>
	                        </div>
	                        <div class="ipt-box fl">
	                            <c:if test="${activity.actFormat=='税费优惠'}">金额：${activity.amount}&nbsp;万元</c:if>
	                        </div>
	                    </div>
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="培训讲座" <c:if test="${activity.actFormat=='培训讲座'}">checked="checked"</c:if>>培训讲座</label>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-12 clearfix">
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="表彰评优" <c:if test="${activity.actFormat=='表彰评优'}">checked="checked"</c:if>>表彰评优</label>
	                        </div>
	                    </div>
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="补贴补助" <c:if test="${activity.actFormat=='补贴补助'}">checked="checked"</c:if>>补贴补助</label>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-12 clearfix">
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="品牌培育" <c:if test="${activity.actFormat=='品牌培育'}">checked="checked"</c:if>>品牌培育</label>
	                        </div>
	                    </div>
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="回访走访" <c:if test="${activity.actFormat=='回访走访'}">checked="checked"</c:if>>回访走访</label>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-12 clearfix">
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="展销展会" <c:if test="${activity.actFormat=='展销展会'}">checked="checked"</c:if>>展销展会</label>
	                        </div>
	                    </div>
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="登记许可指导" <c:if test="${activity.actFormat=='登记许可指导'}">checked="checked"</c:if>>登记许可指导</label>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-12 clearfix">
	                    <div class="radio-box col-2">
	                        <label><input type="radio" id="other" name="actFormat" value="其他" <c:if test="${activity.actFormat=='其他'}">checked="checked"</c:if>>其他</label>
	                    </div>
	                    <div class="ipt-box col-10">
	                        <input type="text" class="ipt-txt" id="otherAct" name="otherAct" readonly value="${activity.otherAct}" >
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="form-item clearfix mt40">
	            <div class="btn-box">
	                <input type="button" id="print" value="打印" class="btn mr20">
	                <input type="button" id="cancel" value="返回" class="btn">
	            </div>
	        </div>
	    </div>
    </form>
    
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
	$(function(){
		$("#cancel").click(function(){
			window.location.href='/syn/con/csconcernactivity/list';
		})
		$("#print").click(function () {
			window.open("/syn/con/csconcernactivity/show?deal=2&id="+$("#id").val());
        })
	})
</script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
</body>
</html>