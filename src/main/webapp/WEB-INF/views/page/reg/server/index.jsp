<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>警示首页</title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/layout-default-latest.css">
    <script src="/js/lib/respond.js"></script>
</head>
<body class="pd10 index-v2">

<div class="clearfix no-todo-thing1">
    <div class="col-7">
        <input type="hidden" id="moreFlag" value="0"/>
        <div class="ind-tit">
            <h4 class="one">通知公告</h4>
            <span id="bulletinMore">查看更多>></span>
        </div>
        <div class="ind-notice">
<!--              <a class="light"><span class="mr20">2017-09-12</span><span class="three mr20">关于开展2016年度未按时年报企业列入异常工作要求 </span><span class="one">[浙江省工商管理局]</span></a> -->
<!--              <a><span class="mr20">2017-09-01</span><span class="three mr20">关于开展2016年度未按时年报企业列入异常工作要求 </span><span class="one">[杭州市市场监督管理局]</span></a> -->
<!--              <a><span class="mr20">2017-09-01</span><span class="three mr20">关于开展2016年度未按时年报企业列入异常工作要求 </span><span class="one">[杭州市市场监督管理局]</span></a> -->
        </div>
    </div>
    <div class="col-5">
        <div class="ind-tit">
            <h4 class="two">全局概览</h4>
            <a href="javascript:void(0);">查看更多>></a>
        </div>
        <div class="ind-entry">
            <div><a href="###" class="js-charts" data-id="1" >主体登记</a><a href="####" class="js-charts" data-id="5">双告知</a><a href="###">多证合一</a></div>
            <div><a href="###" class="js-charts" data-id="3" >年报公示</a><a href="####" id="qcdz_count">实时动态情况</a><a href="###" class="js-charts" data-id="4">随机抽查</a></div>
        </div>
    </div>
</div>

<div class="clearfix no-todo-thing">
    <div class="col-12">
        <div class="ind-tit">
            <h4 class="three">待办工作</h4>
            <p><span class="date">更新时间：</span>${rptzqDate}</p>
        </div>
        <div class="ind-work">
            <div class="row mb10 clearfix">
                <div class="one">
                    <h4 class="one"></h4>
                    <div class="line u-two">
                        <a>年报敏感词待审核 <span id="dbgz0">[999]</span></a>
                        <a>年报修改申请待审核 <span id="dbgz1">[999]</span></a>
                        <a>&nbsp;</a>
                    </div>
                </div>
                <div class="two center">
                    <div class="sub-inline">
                        <h4 class="two"></h4>
                        <div class="line">
                            <a>检查人员待抽取 <span id="dbgz2">[99999]</span></a>
                            <a>检查结果待录入 <span id="dbgz3">[#]</span></a>
                            <a>检查结果待审核 <span id="dbgz4">[#]</span></a>
                        </div>
                    </div>
                </div>
                <div class="three">
                    <div class="fr">
                        <h4 class="three"></h4>
                        <div class="line">
                            <a>新设户待建档 <span id="dbgz5">[99999]</span></a>
                            <a>变更户待建档 <span id="dbgz6">[#]</span></a>
                            <a>户口待分配 <span id="dbgz7">[#]</span></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row clearfix">
                <div class="four">
                    <h4 class="four"></h4>
                    <div class="line">
                        <a>行政指导待审核 <span id="dbgz8">[99999]</span></a>
                        <a>责令整改待审核 <span id="dbgz9">[#]</span></a>
                        <a>抄告抄送待审核 <span id="dbgz10">[#]</span></a>
                    </div>
                </div>
                <div class="five center">
                    <div class="sub-inline">
                        <h4 class="five"></h4>
                        <div class="line">
                            <a>企业异常待审核 <span id="dbgz11">[#]</span></a>
                            <a>农专社异常待审核 <span id="dbgz12">[9999]</span></a>
                            <a>个体户异常待审核 <span id="dbgz13">[#]</span></a>
                        </div>
                    </div>
                </div>
                <div class="six">
                    <div class="fr">
                        <h4 class="six"></h4>
                        <div class="line">
                            <a>涉嫌严违待申请 <span id="dbgz14">[9999]</span></a>
                            <a>严违信息待初审 <span id="dbgz15">[#]</span></a>
                            <a>严违信息待审核 <span id="dbgz16">[#]</span></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="clearfix no-todo-thing pdb30">
    <div class="col-12">
        <div class="ind-tit">
            <h4 class="four">风险监测</h4>
            <select class="ind-select" name="selectCode" id="selectCode">
                <!-- 省级人员及管理员可以看到省级 -->
                <c:if test="${userVest == 4 || userVest == 0 }"><option value="">本省</option></c:if>
                <!-- 市局级别及管理员可以看到 -->
                <c:if test="${userVest == 3 || userVest == 0 }"><option value="1">本市</option></c:if>
                <c:if test="${userVest != 1 }"><option value="2" <c:if test="${userVest != 1 }">selected</c:if>>本局</option></c:if>
                <c:if test="${userVest == 1 }"><option value="3" <c:if test="${userVest == 1 }">selected</c:if>>本所</option></c:if>
            </select>
            <p><span class="date">更新时间：</span>${rptDate}</p>
            
            <a style="display: none;" href="/reg/server/rptOptoInfo/rptOptoWillExpiredview" class="h-explain J_menuItem"
               id="fastLink13">经营期限将到期</a>
            <a style="display: none;" href="/reg/server/rptOptoInfo/rptOptoExpiredview" class="h-explain J_menuItem"
               id="fastLink14">经营期限已过期</a>
            <a style="display: none;" href="/reg/server/rptOptoInfo/rptReporteoverview" class="h-explain J_menuItem"
               id="fastLink41">年报逾期未报</a>
        </div>
        <div class="ind-watch">
           <div class="row">
               <div class="u-left">
                   <div class="one">
                       <h4 class="one"></h4>
                       <div class="line bdl0">
                           <a>食品许可证到期<span id="djsx1">[99999]</span></a>
                           <a>药品许可证到期<span id="djsx2">[10]</span></a>
                           <a href="javascript:void(0);" class="h-explain fastLink" data-idx='13'>经营期限将到期<span id="opCome">[99999]</span></a>
                           <a href="javascript:void(0);" class="h-explain fastLink" data-idx='14'>经营期限已到期<span id="opOver">[10]</span></a>
                           <a>任职资格受限<span id="djsx5">[99999]</span></a>
                       </div>
                   </div>
                   <div class="four">
                       <div class="sub-watch">
                           <h4 class="four"></h4>
                           <div class="line">
                               <a>年报逾期未列入异常<span id="sxmd1">[99999]</span></a>
                               <a>补报后未移出异常<span id="sxmd2">[10]</span></a>
                               <a>查无下落后变更<span id="sxmd3">[10]</span></a>
                               <a>查无下落后年报<span id="sxmd4">[10]</span></a>
                               <a>列入异常将满3年<span id="sxmd5">[10]</span></a>
                           </div>
                       </div>
                   </div>
                   <div class="two">
                       <h4 class="two"></h4>
                       <div class="line">
                           <a href="javascript:void(0);" class="h-explain fastLink" data-idx='41'>年报逾期未报<span id="gsxx1">[99999]</span></a>
                           <a>年报信息异常<span id="gsxx2">[99999]</span></a>
                           <a href="javascript:void(0);">&nbsp;</a>
                           <a href="javascript:void(0);">&nbsp;</a>
                           <a href="javascript:void(0);">&nbsp;</a>
                       </div>
                   </div>
                   <div class="three">
                       <div class="sub-watch">
                           <h4 class="three"></h4>
                           <div class="line">
                               <a>责令整改到期<span>[#]</span></a>
                               <a>抄告抄送未反馈<span>[#]</span></a>
                               <a>抽查后续监管未完结<span id="rcjj3">[0]</span></a>
                               <a href="javascript:void(0);">&nbsp;</a>
                               <a href="javascript:void(0);">&nbsp;</a>
                           </div>
                       </div>

                   </div>
               </div>
               <div class="u-right">
                   <div class="five">
                       <h4 class="five"></h4>
                       <div class="line">
                           <a>税收重大违法黑名单<span>[#]</span></a>
                           <a>失信被执行人关联法人企业<span>[#]</span></a>
                           <a>产品质量失信黑名单<span>[#]</span></a>
                           <a>餐饮服务单位失信黑名单<span>[#]</span></a>
                           <a>安全生产不良记录黑名单<span>[#]</span></a>
                       </div>
                   </div>
               </div>
           </div>
        </div>
    </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/bulletin/bulletin_reglist.js"></script>
<script src="/js/reg/server/index_reglist.js"></script>


<script>
window._CONFIG = {
        chooseUrl:'${sessionScope.session_sys_user.userType == '2'?"/syn":"/reg"}'
        }
</script>
</body>
</html>