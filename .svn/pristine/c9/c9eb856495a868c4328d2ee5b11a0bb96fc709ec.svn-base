<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>关注服务活动打印页</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
<style type="text/css">
.hide{
		display: none;
}
</style>
<style media="print" type="text/css">
.STYLE1 {
	font-size: 16px;
	font-weight: bold;
}
object { display: none}
.Noprint{ display:none; }
.PageNext{ page-break-after: always; clear: both; width: 100%}
	</style>
<style type="text/css">
	.height40{
		height: 40px;
	}
</style>
</head>
<body>
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6，2，433，14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>

<div class="pd20">
    <div class="creat-copy">
        <div class="print-nocard mb20">
	        <h3>关注服务活动单</h3>
	    </div>
	    
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
                    ${activity.content}
                </div>
            </div>
        </div>
        
        <div class="form-item clearfix">
            <label class="item-name col-3">关注服务对象：</label>
            <div class="col-8">
                <div class="ipt-box col-5">
                	${activity.markName}
                </div>
            </div>
        </div>
        
        <div class="form-item clearfix">
            <label class="item-name col-3">开展关注服务日期：</label>
            <div class="col-8">
                <div class="ipt-box col-2">
                    <fmt:formatDate value="${activity.dateBegin}" pattern="yyyy-MM-dd" /> - <fmt:formatDate value="${activity.dateEnd}" pattern="yyyy-MM-dd" />
                </div>
                <div class="ipt-box col-2">
                    <label class="ml20"><c:if test="${activity.isLong=='1'}">长期</c:if></label>
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
                        ${activity.otherAct}
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/print/printsetup.js"></script>
<script src="/js/common/print/print.js"></script>
</body>
</html>