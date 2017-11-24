<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


<form id="taskForm" class="form-box">
	<input type="hidden" id="priPID" name="priPID" value="${dto.priPID }">
</form>
<div class="clearfix reg-company-basic reg-company-basic-yellowish">
 <div class="right">
<input type="button" value="返回" id="btn_back" class="btn mr20">
            </div>
    <div class="clearfix reg-caption">
        <div class="title clearfix">
            <span class="name fl mr5">${dto.entName}</span>
            <c:if test="${dto.regState=='K'||dto.regState=='A'||dto.regState=='B'||dto.regState=='DA'||dto.regState=='X'}">
               <span class="icon-rectangle green fl mr10">存续</span>
            </c:if>
            <c:if test="${dto.regState=='XX'||dto.regState=='DX'}">
               <span class="icon-rectangle gray fl mr10">注销</span>
            </c:if>
            <c:if test="${dto.regState=='C'}"> 
                <span class="icon-rectangle green fl" style="font-size:10px;">撤销</span>
            </c:if>
            <c:if test="${dto.regState=='D'}"> 
                <span class="icon-rectangle red fl" style="font-size:10px;">吊销</span>
            </c:if> 
            <c:if test="${dto.regState=='Q'}"> 
                <span class="icon-rectangle blue fl" style="font-size:10px;">迁出</span>
            </c:if>
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
            <!-- <div class="col-4">
                <label class="right col-6">财务负责人：</label>
                <div class="col-6">
                    李二 13596489562
                </div>
            </div> -->
        </div>
    </div>
</div>

  <div class="tabbale" data-component="tab">
    <div class="tab-content">  
          <div class="tab-panel tab-panel-show">
                       <div id="tab_djxkxx">
                            <div class="gold">                            
	                            <span class="fr line-h30">数据来源：工商部门</span>
		                        <h6 class="add-title dib2">消息通知服务记录（<span id="permit-table_span" class="light">0</span>）</h6>
                            </div>
	                        <table id="permit-table" class="table-row display nowrap" cellspacing="0" width="100%">
	                            <thead>
	                            <tr>
	                                <th>序号</th>
	                                <th>操作</th>
	                                <th>消息名称</th>
	                                <th>发送人</th>
	                                <th>发送日期</th>
	                                <th>消息查阅状态</th>
	                                <th>查阅时间</th>
	                                <th>查阅人</th>
	                                <th>联系电话</th>
	                                <th>备注</th>
	                            </tr>
	                            </thead>
	                        </table>
                       </div>
                </div>
         </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/message/message_viewlist.js"></script>
</body>
</html>
