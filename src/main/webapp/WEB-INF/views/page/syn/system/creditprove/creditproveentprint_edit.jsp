<%--
  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title></title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <style media="print" type="text/css"> 
		.Noprint{ 
		display:none;
		}
		.height40{
			height: 40px;
		}
	</style>
</head>
<body class="pd10">
<div class="button Noprint" style="width:600px;">
    <a href="javascript:void(0);" id="printButton"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>

<div class="clearfix">
    <input type="hidden" id="pripids"   value="${pripids}"/> 
    <input type="hidden" id="ProveNo"   value="${creditProveInfoList[0].proveNo}"/> 
    <input type="hidden" id="proveStartDate" value="<fmt:formatDate value="${creditProveInfoList[0].proveStartDate}"
								pattern="yyyy-MM-dd" />"/> 
    <input type="hidden" id="proveEntDate"  value="<fmt:formatDate value="${creditProveInfoList[0].proveEntDate}"
								pattern="yyyy-MM-dd" />"/>
								
	<%-- <div class="mt40"  >
        <h1 class="h4-title left mt5">查证单打印记录</h1>
        <table id="prove_print-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 40px">序号</th>
                <th>查证单打印编号</th>
                <th>打印时间</th>
                <th>打印人</th>
                <th>打印部门</th>
            </tr>
            </thead>
            <tbody id="prove_printPage">
               <c:if test="${not empty creditProvePrintHisList}">
                  <c:forEach var="creditProvePrintHis" items="${creditProvePrintHisList}" varStatus="status">
					<tr>
					<td >${status.count}</td>
					<td >${creditProvePrintHis.printNo}</td>
					<td >
					<fmt:formatDate value="${creditProvePrintHis.printTime}"
								pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td >${creditProvePrintHis.printName}</td>
					<td >${creditProvePrintHis.printDeptName}</td>
				   </tr>
				</c:forEach>
               
               </c:if>
               <c:if test="${empty creditProvePrintHisList}"> 
                  <td valign='top' colspan='5' class='dataTables_empty'>无</td>
               </c:if> 
            </tbody>
        </table> 
    </div>  --%>
    
    <div class="mt40">
	    <div  style="width:1375px; margin:0 auto; page-break-before:auto; height:70px; *height:600px; _height:600px;position: relative;">
	    	<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">证 明</span>
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
			</p>
	    </div>
    </div>

    <div class="mt40">
          <!-- 多家企业 -->
         <c:if test="${fn:length(creditProveInfoList)> 1 &&ispunish>0}">
         <div  style="width:1375px; margin:0 auto; page-break-before:auto; height:70px; *height:600px; _height:600px;position: relative;">
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查询，<span style="color: blue">${creditProveInfoList[0].entName}</span></span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">等共<span style="color: blue">${fn:length(creditProveInfoList) }</span>
				家公司自<span style="color: blue" class="proveStart"><fmt:formatDate value="${creditProveInfoList[0].proveStartDate}" pattern="yyyy年MM月dd日" /></span>至
				<span style="color: blue" class="proveEnt"><fmt:formatDate value="${creditProveInfoList[0].proveEntDate}" pattern="yyyy年MM月dd日" /></span>的工商违法行为或行政处罚记录如下：</span>
			</p>
		 </div>
		 </c:if>
		  
		 <c:if test="${fn:length(creditProveInfoList)> 1 &&ispunish==0}">
		 <!-- 未发现违法记录 -->
		 <div id="ent_more_no" style="width:1375px; margin:0 auto; page-break-before:auto; height:70px; *height:600px; _height:600px;position: relative;">
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查询，<span style="color: blue">${creditProveInfoList[0].entName}</span></span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">等共<span style="color: blue">${fn:length(creditProveInfoList) }</span>家公司自
				<span style="color: blue" class="proveStart"><fmt:formatDate value="${creditProveInfoList[0].proveStartDate}" pattern="yyyy年MM月dd日" /></span>至
				<span style="color: blue" class="proveEnt"><fmt:formatDate value="${creditProveInfoList[0].proveEntDate}" pattern="yyyy年MM月dd日" /></span>未发现有工商违法行为或处罚记录。</span>
			</p>
		 </div>
		 </c:if>
		 
		 <c:if test="${fn:length(creditProveInfoList)=='1' &&ispunish>0}">
		 <!-- 只有一家企业 -->
		 <div id="ent_one_yes" style="width:1375px; margin:0 auto; page-break-before:auto; height:70px; *height:600px; _height:600px;position: relative;">
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查询，<span style="color: blue">${creditProveInfoList[0].entName}</span></span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">自
				<span style="color: blue" class="proveStart"><fmt:formatDate value="${creditProveInfoList[0].proveStartDate}" pattern="yyyy年MM月dd日" /></span>至
				<span style="color: blue" class="proveEnt"><fmt:formatDate value="${creditProveInfoList[0].proveEntDate}" pattern="yyyy年MM月dd日" /></span>的工商违法行为或行政处罚记录如下：</span>
			</p>
		 </div>
		 </c:if>
		 
		 <c:if test="${fn:length(creditProveInfoList)=='1' &&ispunish==0}">
		 <!-- 未发现违法记录 -->
		 <div id="ent_one_no" style="width:1375px; margin:0 auto; page-break-before:auto; height:70px; *height:600px; _height:600px;position: relative;">
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查询，<span style="color: blue">${creditProveInfoList[0].entName}</span></span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">自
				<span style="color: blue" class="proveStart"><fmt:formatDate value="${creditProveInfoList[0].proveStartDate}" pattern="yyyy年MM月dd日" /></span>至
				<span style="color: blue" class="proveEnt"><fmt:formatDate value="${creditProveInfoList[0].proveEntDate}" pattern="yyyy年MM月dd日" /></span>未发现有工商违法行为或处罚记录。</span>
			</p>
		 </div>
		 </c:if>
    </div>
<c:if test="${fn:indexOf(creditProveInfoList[0].proveScope,'1') != -1 &&ispunish>0}">
    <div class="mt40" id="midCasetplDiv" >
        <h1 class="h4-title left mt5">工商部门行政处罚记录</h1>
        <table id="permit-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 40px">序号</th>
                <th>统一社会信用代码/注册号</th>
                <th>企业名称</th>
                <th>处罚决定书文号</th>
                <th>违法行为类型</th>
                <th>处罚决定机关</th>
                <th>处罚决定日期</th>
            </tr>
            </thead>
            <tbody id="midCasetplPage">
            	<c:forEach var="gsPunish" items="${gsPunishList}" varStatus="status">
					<tr>
	                    <td>${status.count}</td>
	                    <td>
	                        ${gsPunish.regNO}
	                    </td>
	                    <td>${gsPunish.entName}</td>
						<td>${gsPunish.penDecNo}</td>
						<td>${gsPunish.illegActType}</td>
						<td>${gsPunish.judAuth}</td>
						<td>
						<fmt:formatDate value="${gsPunish.penDecIssDate}"
								pattern="yyyy-MM-dd" />
						</td>
		            </tr> 
		            <c:if test="${not empty gsPunish.pubOtherPunishAlterList }">
		               <tr >
			            <td colspan="7" class="tip2">
			                 <div class="fl">有变更情形：</div>
			                 <div class="fl">
			                 <c:forEach var="gsPunishpubOtherPunishAlter" items="${gsPunish.pubOtherPunishAlterList}" varStatus="status">
			                       <p class="fl">
			                       ${status.count}、
			                       ${gsPunishpubOtherPunishAlter.judAuth}
			                       <fmt:formatDate value="${gsPunishpubOtherPunishAlter.altDate}"
								    pattern="yyyy-MM-dd" />
			                                                                      将${gsPunishpubOtherPunishAlter.contents}
			                       </p>
			                 </c:forEach>
			                 </div>
			            </td>
			            </tr>
		            </c:if>
				</c:forEach>
            </tbody>
        </table>
    </div>
    </c:if>
    
    <c:if test="${fn:indexOf(creditProveInfoList[0].proveScope,'2') != -1 &&ispunish>0}">
    <div class="mt40" id="OtherpunishDiv">
        <h1 class="h4-title left mt5">其他部门行政处罚记录</h1>
        <table id="permit-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 40px">序号</th>
                <th>统一社会信用代码/注册号</th>
                <th>企业名称</th>
                <th>处罚决定书文号</th>
                <th>违法行为类型</th>
                <th>处罚决定机关</th>
                <th>处罚决定日期</th>
            </tr>
            </thead>
            <tbody id="OtherpunishtplPage">
            	<c:forEach var="pubOtherpunish" items="${pubOtherpunishList}" varStatus="status">
					<tr>
	                    <td>${status.count}</td>
	                    <td>
	                        ${pubOtherpunish.regNO}
	                    </td>
	                    <td>${pubOtherpunish.entName}</td>
						<td>${pubOtherpunish.penDecNo}</td>
						<td>${pubOtherpunish.illegActType}</td>
						<td>${pubOtherpunish.judAuth}</td>
						<td>
						<fmt:formatDate value="${pubOtherpunish.penDecIssDate}"
								pattern="yyyy-MM-dd" />
						</td>
		            </tr> 
		            <c:if test="${not empty pubOtherpunish.pubOtherPunishAlterList }">
		            <tr>
			            <td colspan="7" class="tip2">
			                 <div class="fl">有变更情形：</div>
			                 <div class="fl">
			                 <c:forEach var="pubOtherPunishAlter" items="${pubOtherpunish.pubOtherPunishAlterList}" varStatus="status">
			                       <p class="fl">
			                       ${status.count}、
			                       ${pubOtherPunishAlter.judAuth}
			                       <fmt:formatDate value="${pubOtherPunishAlter.altDate}"
								    pattern="yyyy-MM-dd" />
			                                                                   将${pubOtherPunishAlter.contents}
			                       </p></br>
			                 </c:forEach>
			                 </div>
			            </td>
		            </c:if>
		            </tr>
				</c:forEach>
            </tbody>
        </table>
         <!-- <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="OtherpunishitemCount">0</em> 条信息，共<em id="OtherpunishpageCount">0</em>页</span>
                <div id="Otherpunish_pagination_one" class="pagination">

                </div>
        </div> 
        <script id="Otherpunish-table-template" type="text/x-handlebars-template">
    	 {{#each data}}
            <tr>
                <td> {{xh @index}}</td>
				<td>{{transUniSCID uniSCID}}</td>
 				<td>{{entName}}</td>
                <td>{{penDecNo}}</td>
                <td>{{illegActType}}</td>
                <td>{{judAuth}}</td>
                <td>{{penDecIssDate}}</td>
            </tr>
			{{#if pubOtherPunishAlterList}}
            <tr >
                <td colspan="7" class="tip2">
                    <div class="fl">有变更情形：</div>
 					<div class="fl">
                    {{#each pubOtherPunishAlterList}}
                     <p class="fl">{{xh @index}}、 {{judAuth}} {{altDate}}将{{contents}}</p><br/> 
 					{{/each}}
					</div>
                </td> 
            </tr>
 			{{/if}}
            {{/each}} 
		</script>-->
    </div>
    </c:if>
    
    <c:if test="${fn:indexOf(creditProveInfoList[0].proveScope,'3') != -1 &&ispunish>0}">
    <div class="mt40" id="opanomalyDiv" >
        <h1 class="h4-title left mt5">列入经营异常名录记录</h1>
        <table id="opanomaly-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 40px">序号</th>
                <th>统一社会信用代码/注册号</th>
                <th>企业名称</th>
                <th>列入决定书文号</th>
                <th>列入异常名录原因</th>
                <th>作出决定机关（列入）</th>
                <th>列入日期</th>
            </tr>
            </thead>
            <tbody id="tplPage"> 
            	<c:forEach var="pubOpanoMaly" items="${pubOpanoMalyList}" varStatus="status">
					<tr>
	                    <td>${status.count}</td>
	                    <td>
	                        ${empty pubOpanoMaly.uniSCID?pubOpanoMaly.regNO:pubOpanoMaly.uniSCID}
	                    </td>
	                    <td>${pubOpanoMaly.entName}</td>
						<td>${pubOpanoMaly.penDecNo}</td>
						<td>${pubOpanoMaly.speCauseCN}</td>
						<td>${pubOpanoMaly.decorgCN}</td>
						<td>
						<fmt:formatDate value="${pubOpanoMaly.abnTime}"
								pattern="yyyy-MM-dd" />
						</td>
		            </tr> 
				</c:forEach>
            </tbody>
        </table>
       <!--  <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount">0</em> 条信息，共<em id="pageCount">0</em>页</span>
                <div id="pagination_one" class="pagination">

                </div>
        </div>
        <script id="table-template" type="text/x-handlebars-template">
    	{{#each data}}  
            <tr>
                    <td>{{xh @index}}</td>
                    <td>{{transUniSCID uniSCID}}</td>
                    <td>{{entName}}</td>
					<td>{{penDecNo}}</td>
					<td>{{speCauseCN}}</td>
					<td>{{decorgCN}}</td>
					<td>{{abnTime}}</td>
            </tr> 
    	{{/each}} 
		</script> -->
    </div>
    </c:if>
    
    <c:if test="${fn:indexOf(creditProveInfoList[0].proveScope,'4') != -1 &&ispunish>0}">
    <div class="mt40" id="permitDiv" >
        <h1 class="h4-title left mt5">列入严重违法失信记录</h1>
        <table id="permit-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 40px">序号</th>
                <th>统一社会信用代码/注册号</th>
                <th>企业名称</th>
                <th>列入决定书文号</th>
                <th>列入严重违法失信企业名单（黑名单）原因</th>
                <th>作出决定机关（列入）</th>
                <th>列入日期</th>
            </tr>
            </thead>
            <tbody id="ExpSeriousCrimetplPage"> 
               <c:forEach var="expSeriousCrimeList" items="${expSeriousCrimeListList}" varStatus="status">
					<tr>
	                    <td>${status.count}</td>
	                    <td>
	                        ${empty expSeriousCrimeList.uniSCID?expSeriousCrimeList.regNO:expSeriousCrimeList.uniSCID}
	                    </td>
	                    <td>${expSeriousCrimeList.entName}</td>
						<td>${expSeriousCrimeList.penDecNo}</td>
						<td>${expSeriousCrimeList.addSecCause}</td>
						<td>${expSeriousCrimeList.addSecOrg}</td>
						<td>
						<fmt:formatDate value="${expSeriousCrimeList.addSecDate}"
								pattern="yyyy-MM-dd" />
						</td>
		            </tr> 
				</c:forEach>
            </tbody>
        </table>
        <!-- <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="ExpSeriousCrimeitemCount">0</em> 条信息，共<em id="ExpSeriousCrimepageCount">0</em>页</span>
                <div id="ExpSeriousCrimepagination_one" class="pagination">

                </div>
        </div>
        <script id="ExpSeriousCrime-table-template" type="text/x-handlebars-template">
    	{{#each data}}  
            <tr>
                    <td>{{xh @index}}</td>
                    <td>{{transUniSCID uniSCID}}</td>
                    <td>{{entName}}</td>
					<td>{{penDecNo}}</td>
					<td>{{addSecCause}}</td>
					<td>{{addSecOrg}}</td>
					<td>{{addSecDate}}</td>
            </tr> 
    	{{/each}} 
		</script> -->
    </div>
    </c:if>
    
    <c:if test="${fn:indexOf(creditProveInfoList[0].proveScope,'5') != -1 &&ispunish>0}">
    <div class="mt40" id="qualificationLimitDiv" >
        <h1 class="h4-title left mt5">任职资格限制情况</h1>
        <table id="permit-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 40px">序号</th>
                <th>统一社会信用代码/注册号</th>
                <th>企业名称</th>
                <th>任职受限对象姓名</th>
                <th>任职资格受限原因</th>
                <th>限制到期日期</th>
            </tr>
            </thead>
            <tbody id="QualificationLimittplPage">  
            	<c:forEach var="qualificationLimit" items="${qualificationLimitList}" varStatus="status">
					<tr>
	                    <td>${status.count}</td>
	                    <td>
	                        ${empty qualificationLimit.uniCode?qualificationLimit.regNO:qualificationLimit.uniCode}
	                    </td>
	                    <td>${qualificationLimit.entName}</td>
						<td>${qualificationLimit.clientName}</td>
						<td>${qualificationLimit.limitReason}</td>
						<td>
						<fmt:formatDate value="${qualificationLimit.limitDateEnd}"
								pattern="yyyy-MM-dd" />
						</td>
		            </tr> 
				</c:forEach>
            </tbody>
        </table>
       <!--  <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="QualificationLimititemCount">0</em> 条信息，共<em id="QualificationLimitepageCount">0</em>页</span>
                <div id="QualificationLimitpagination_one" class="pagination">

                </div>
        </div> 
        <script id="QualificationLimit-table-template" type="text/x-handlebars-template">
    	{{#each data}}  
            <tr>
                    <td>{{xh @index}}</td>
                    <td>{{transUniSCID uniCode}}</td>
                    <td>{{entName}}</td>
					<td>{{clientName}}</td>
					<td>{{limitReason}}</td>
					<td>{{limitDateEnd}}</td>
            </tr> 
    	{{/each}} 
		</script>-->
    </div>
    </c:if>
    
    <c:if test="${fn:indexOf(creditProveInfoList[0].proveScope,'6') != -1 &&ispunish>0}">
    <div class="mt40" id="otherPermitDiv" >
        <h1 class="h4-title left mt5">其他失信信息记录</h1>
        <table id="permit-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 40px">序号</th>
                <th>统一社会信用代码/注册号</th>
                <th>企业名称</th>
                <th>列入决定书文号</th>
                <th>列入严重违法失信企业名单（黑名单）原因</th>
                <th>作出决定机关（列入）</th>
                <th>列入日期</th>
            </tr>
            </thead>
        </table>
    </div>
    </c:if>
</div>
<c:if test="${fn:length(creditProveInfoList)> 1}">
<div class="mt71" >
<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; layout-grid-mode: char; text-align:left ;">
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '宋体';color: blue;" id="ent_list"><a href="##">附：企业查证名单</a></span>
</p>
<table align=center style="border-collapse: collapse; width: 500.4000pt; margin-left: 4.0000pt; mso-table-layout-alt: fixed; padding: 0.0000pt 1.4000pt 0.0000pt 1.4000pt;" id="ent_table_list">
				<tr style="height: 19.8500pt;">
					<td width="10%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">序号</span>
					</td>
					<td width="30%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">企业注册号</span>
					</td>
					<td width="60%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">企业名称</span>
					</td>
				</tr>
				<c:forEach var="printForBatch" items="${creditProveInfoList}" varStatus="status">
					<tr style="height: 19.8500pt;">
					<td valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">${status.count}</span>
					</td>
					<td valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">${printForBatch.regNO}</span>
					</td>
					<td valign=center style="text-align:left;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">${printForBatch.entName}</span>
					</td>
				</tr>
				</c:forEach>
</table>
</div>
</c:if>


<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;" >
	<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';" > 
	 <fmt:formatDate value="${creditProveInfoList[0].setDate}" pattern="yyyy年MM月dd日 "/>
	</span>
	<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
</p>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script>
    window._CONFIG = {
    		url:'${sysUrl}',
    		nowDateStr:'${nowDateStr}',
    		proveScope:'${creditProveInfoList[0].proveScope}'
    }
</script>
<script src="/js/syn/system/creditprove/creditproveentprint_edit.js"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</body>
</html>