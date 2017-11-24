<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>通知公告</title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/layout-default-latest.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<input type="hidden" id="moreFlag" value="0"/>
<div class="notice-info border-bottom">
    <div class="title"><strong><i class="xbt-icon"></i>通知公告</strong><a id="bulletinMore" href="javascript:void(0);" style="display: none;">更多>></a></div>
    <ul class="notice-info-list">
<!--         <li class="no-read"><span>2016-12-1</span><a href="">浙江省工商行政管理局关于报送2016年度报告的公告 <em>[ 浙江省工商管理局 ]</em></a></li> -->
<!--         <li><span>2016-12-1</span><a href="">关于开展2015年度未按时年报企业列入异常工作要求 <em>[ 浙江省工商管理局 ]</em></a></li> -->
<!--         <li><span>2016-12-1</span><a href="">关于开展2015年度未按时年报企业列入异常工作要求 <em>[ 浙江省工商管理局 ]</em></a></li> -->
</div>


<div class="index-main">
    <h4 class="index-item-h">待办工作<span class="ml15">更新时间：2016-6-13  9:24</span></h4>
    <div class="wait-job">
        <ul class="clearfix mb10">
            <li>
                <h6 class="fl-hd bm-info">部门信息</h6>
                <div class="fr-cont">
                    <div class="dib">
                        <p>行政许可公示审核[<font class="light">-</font>]</p>
                        <p>行政处罚公示审核[<font class="light">-</font>]</p>
                        <p>司法协助公示审核[<font class="light">-</font>]</p>
                       
                    </div>
                    <span class="dib"></span>
                </div>
            </li>
            <li>
                <h6 class="fl-hd zz-ld">证照联动</h6>
                <div class="fr-cont">
                    <div class="dib">
                        <p>待认领[<font class="light">-</font>] </p>
                        <p>待接收[<font class="light">-</font>] </p>
                    </div>
                    <span class="dib"></span>
                </div>
            </li>
            <li>
                <h6 class="fl-hd cc-check">抽查检查</h6>
                <div class="fr-cont">
                    <div class="dib">
                        <p>待检查录入 [<font class="light">-</font>]</p>
                        <p>戴抽检结果审核 [<font class="light">-</font>]</p>
                    </div>
                    <span class="dib"></span>
                </div>
            </li>
        </ul>
        <ul class="clearfix">
            <li>
                <h6 class="fl-hd lh-punish">联合惩戒</h6>
                <div class="fr-cont">
                    <div class="dib">
                        <p>待审核 [<font class="light">-</font>] </p>
                        <p>待反馈 [<font class="light">-</font>] </p>
                    </div>
                    <span class="dib"></span>
                </div>
            </li>
            <li>
                <h6 class="fl-hd syn-law">协同执法</h6>
                <div class="fr-cont">
                    <div class="dib">
                        <p>抄告抄送 [<font class="light">-</font>] </p>
                        <p>事务提请 [<font class="light">-</font>] </p>
                    </div>
                    <span class="dib"></span>
                </div>
            </li>
            <li>
                <h6 class="fl-hd jg-server">监管服务</h6>
                <div class="fr-cont">
                    <div class="dib">
                        <p>风险预警信息 [<font class="light">-</font>] </p>
                        <p>重点监管对象[<font class="light">-</font>] </p>
                        <p>关注服务对象[<font class="light">-</font>] </p>
                    </div>
                    <span class="dib"></span>
                </div>
            </li>
        </ul>
    </div>
    <h4 class="index-item-h border-bottom">部门概览<span class="ml15">更新时间：2016-6-13  9:24</span></h4>
    <div class="section-gl mt10">
        <ul class="clearfix">
            <li>
                <h6>行政许可信息</h6>
                <span>1</span>
            </li>
            <li>
                <h6>行政处罚信息</h6>
                <span>1</span>
            </li>
           
            <li>
                <h6>抽查检查结果</h6>
                <span>1</span>

            </li>
            <li>
                <h6>联合惩戒信息</h6>
                <span>1</span>

            </li>
        </ul>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/bulletin/bulletin_list.js"></script>

<script>
    window._CONFIG = {
        chooseUrl: '${sessionScope.session_sys_user.userType == '2' ? "/syn" : "/reg"}',
        <c:if test="${sessionScope.session_sys_user.userType=='1'}">
        collection: '<c:url value="/reg/system/bulletin/collection"/>',
        read: '<c:url value="/reg/system/bulletin/read"/>'
        </c:if>
        <c:if test="${sessionScope.session_sys_user.userType=='2'}">
        collection: '<c:url value="/syn/system/bulletin/collection"/>',
        read: '<c:url value="/syn/system/bulletin/read"/>'
        </c:if>
    }
</script>
</body>
</html>
