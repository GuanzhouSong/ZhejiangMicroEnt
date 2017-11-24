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
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="clearfix">
 	<div class="light-info mb5 mt5">
        <span class="light">提示：请设置人员信用查证比对条件。 </span>
    </div>
    <form id="taskForm">
        <input type="hidden" id="pripids" name="pripids" value="${pripids}"/>
        <input type="hidden" id="ProveNo"  value=""/>
        <input type="hidden" id="uids"  value="${uids}"/>
        <input type="hidden" id="cerNO"  value="${cerNOs}"/>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <tr>
                <td class="bg-gray right" width="20%">* 使用查证开始日期</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="text" id="proveStartDate"  name="proveStartDate" class="ipt-txt pointer laydate-icon" value="" onclick="laydate()"
                               readonly="readonly"/>
                    </div>
                </td>
                <td class="bg-gray right" width="20%">* 使用查证结束日期</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="text" id="proveEntDate" name="proveEntDate" class="ipt-txt pointer laydate-icon" value="" onclick="laydate()"
                               readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">* 信用查证范围</td>
                <td>
                    <div class="ipt-box pd0">
                             <input type="checkbox" name="searchType" checked="checked"  value="1">工商部门行政处罚
                             <input type="checkbox" name="searchType" checked="checked"  value="2">其他部门行政处罚
                             <input type="checkbox" name="searchType" checked="checked"  value="3">列入经营异常
                             <input type="checkbox" name="searchType" checked="checked"  value="4">列入严重违法失信（黑名单）
                             <input type="checkbox" name="searchType" checked="checked"  value="5">失信被执行人黑名单
                             <input type="checkbox" name="searchType" checked="checked"  value="6">其他失信信息
                    </div>
                </td>
                <td class="bg-gray right"></td>
                <td>
                    <div class="ipt-box pd0">
                         
                    </div>
                </td>
            </tr>
        </table>
        <p class="center mt10">
            <input type="button" id="createProButton" class="btn btn-primary save" value="生成查证单"/>
        </p>
    </form>
    
     <div class="mt40" id="grgszm_one" style="display: none;">
         <div  style="width:1375px; margin:0 auto; page-break-before:auto; height:70px; *height:600px; _height:600px;position: relative;">
		     <p   class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: center;">
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';">个人工商信用状况证明</span>
				<span style="mso-spacerun: 'yes'; font-weight: bold; font-size: 22.0000pt; font-family: '宋体';"><o:p></o:p></span>
			</p>
		</div>
	</div>	

    <div class="mt40">
         <div  style="width:1375px; margin:0 auto; page-break-before:auto; height:70px; *height:600px; _height:600px;position: relative;">
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 128.0000pt;display: none;" id="cerNO_more">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查询，<span style="color: blue">${creditProveListDtoList[0].name}</span></span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">等共<span style="color: blue">${fn:length(creditProveListDtoList) }</span>人当前在我局登记管辖的企业中<span style="font-weight: bold;">投资/任职情况</span>如下：</span>
			</p>
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 128.0000pt;display: none;" id="cerNO_one">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查询，<span style="color: blue">${creditProveListDtoList[0].name}（${creditProveListDtoList[0].cerNO}）</span></span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">在我局登记管辖的企业中<span style="font-weight: bold;">投资/任职情况</span>如下：</span>
			</p>
		</div>
	</div>
		
		
		
		<div class="mt40" id="mid_invDiv_none" style="display: none;">
	        <table id="mid-inv-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
	               style="width: 100%;white-space: nowrap;">
	            <thead>
	            <tr>
	                <th style="min-width: 40px">序号</th>
	                <th>姓名</th>
	                <th>身份证件号码</th>
	                <th>投资/任职企业名称</th>
	                <th>投资/任职企业统一信用代码/注册号</th>
	                <th>投资/任职关系</th>
	            </tr>
	            </thead>
	            <tbody id="mid-inv-tplPage"> 
	            </tbody>
	        </table>
	        <div class="notice-pagination-box clearfix">
	                <span class="page-total">共查询到 <em id="mid-inv-itemCount">0</em> 条信息，共<em id="mid-inv-pageCount">0</em>页</span>
	                <div id="mid-inv-pagination-one" class="pagination">
	
	                </div>
	        </div>
	        <script id="mid-invtable-template" type="text/x-handlebars-template">
	    	{{#each data}}  
	            <tr>
	                    <td>{{xh @index}}</td>
						<td>{{name}}</td>
	                    <td>{{cerNO}}</td>
	                    <td>{{entName}}</td>
						<td>{{transUniSCID uniSCID}}</td>
						<td>{{regOrgName}}</td>
	            </tr> 
	    	{{/each}} 
			</script>
	    </div>
		
		  
		 <div style="width:1375px; margin:0 auto; page-break-before:auto; height:70px; *height:600px; _height:600px;position: relative;display: none;" class="sxbzxr">
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 130.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查询，<span style="color: blue">上述人员</span></span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">自<span style="color: blue" class="proveStart"></span>至<span style="color: blue" class="proveEnt"></span>期间属于<span style="font-weight: bold;">失信被执行人黑名单</span>记录如下：</span>
			</p>
		 </div>
		 <div class="mt40 sxbzxr" style="display: none;">
	        <table id="QualificationLimitType-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
	               style="width: 100%;white-space: nowrap;">
	            <thead>
	            <tr>
	                <th style="min-width: 40px">序号</th>
	                <th>失信被执行人姓名</th>
	                <th>身份证号码</th>
	                <th>执行依据文号</th>
	                <th>执行部门</th>
	                <th>发布日期</th>
	            </tr>
	            </thead>
	            <tbody id="QualificationLimitType-tplPage"> 
	            </tbody>
	        </table>
	        <div class="notice-pagination-box clearfix">
	                <span class="page-total">共查询到 <em id="QualificationLimitType-itemCount">0</em> 条信息，共<em id="QualificationLimitType-pageCount">0</em>页</span>
	                <div id="QualificationLimitType-pagination-one" class="pagination">
	
	                </div>
	        </div>
	        <script id="QualificationLimitType-table-template" type="text/x-handlebars-template">
	    	{{#each data}}  
	            <tr>
	                    <td>{{xh @index}}</td>
	                    <td>{{clientName}}</td>
	                    <td>{{certNO}}</td>
						<td>{{limitNO}}</td>
						<td>{{limitDepartName}}</td>
						<td>{{limitDateStart}}</td>
	            </tr> 
	    	{{/each}} 
			</script>
	    </div>
	    
	    <div id="ent_more_yes1" style="width:1375px; margin:0 auto; page-break-before:auto; height:70px; *height:600px; _height:600px;position: relative;display: none;">
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 130.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查询，上述人员在我局所投资/任职的企业</span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">自<span style="color: blue" class="proveStart"></span>至<span style="color: blue" class="proveEnt"></span>工商违法行为或行政处罚记录如下：</span>
			</p>
		 </div>
	    
		 <!-- 未发现违法记录 -->
		 <div id="ent_more_no" style="width:1375px; margin:0 auto; page-break-before:auto; height:70px; *height:600px; _height:600px;position: relative;display: none;">
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查询，<span style="color: blue">${creditProveListDtoList[0].name}（${creditProveListDtoList[0].cerNO}）</span></span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">等共<span style="color: blue">${fn:length(creditProveListDtoList) }人</span>没有在我局登记管辖的企业中有投资/任职情况。</span>
			</p>
		 </div>
		 <%-- </c:if> --%>
		 
		 <%-- <c:if test="${fn:length(midBaseInfoDtoList)=='1'}"> --%>
		 <!-- 未发现违法记录 -->
		 <div id="ent_one_no" style="width:1375px; margin:0 auto; page-break-before:auto; height:70px; *height:600px; _height:600px;position: relative;display: none;">
			<p class=p0 style="text-indent: 32.0000pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 28.0000pt;">
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">经查询，<span style="color: blue">${creditProveListDtoList[0].name}（${creditProveListDtoList[0].cerNO}）</span></span>
				<span style="mso-spacerun: 'yes'; letter-spacing: 1.0000pt; font-size: 16.0000pt; font-family: '仿宋_GB2312';">没有在我局登记管辖的企业中有投资/任职情况。</span>
			</p>
		 </div>
		 <%-- </c:if> --%>
    </div>

    <div class="mt40" id="midCasetplDiv" style="display: none;">
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
            </tbody>
        </table>
        <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="midCaseitemCount">0</em> 条信息，共<em id="midCasepageCount">0</em>页</span>
                <div id="midCase_pagination_one" class="pagination">

                </div>
        </div>
        <script id="midCase-table-template" type="text/x-handlebars-template">
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
		</script>
    </div>
    
    <div class="mt40" id="OtherpunishDiv" style="display: none;">
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
            </tbody>
        </table>
         <div class="notice-pagination-box clearfix">
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
		</script>
    </div>
    
    <div class="mt40" id="opanomalyDiv" style="display: none;">
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
            </tbody>
        </table>
        <div class="notice-pagination-box clearfix">
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
		</script>
    </div>
    
    <div class="mt40" id="permitDiv" style="display: none;">
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
            </tbody>
        </table>
        <div class="notice-pagination-box clearfix">
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
		</script>
    </div>
    
    <div class="mt40" id="qualificationLimitDiv" style="display: none;">
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
            </tbody>
        </table>
        <div class="notice-pagination-box clearfix">
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
		</script>
    </div>
    
    <div class="mt40" id="otherPermitDiv" style="display: none;">
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
            <tbody>
             <tr>
		         <td valign='top' colspan='7' class='dataTables_empty'>无</td>
		     </tr>
            </tbody>
        </table>
    </div>
</div>
<c:if test="${fn:length(creditProveListDtoList)> 1}">
<div id="entList" style="display: none;" class="mt60">
<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; layout-grid-mode: char; text-align:left ;">
				<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '宋体';color: blue;" id="ent_list"><a href="##">附：个人查证名单</a></span>
</p>
<table align=center style="border-collapse: collapse; width: 500.4000pt; margin-left: 4.0000pt; mso-table-layout-alt: fixed; padding: 0.0000pt 1.4000pt 0.0000pt 1.4000pt;display: none;" id="ent_table_list">
				<tr style="height: 19.8500pt;">
					<td width="10%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">序号</span>
					</td>
					<td width="30%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">姓名</span>
					</td>
					<td width="30%" valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">身份证号码</span>
					</td>
				</tr>
				<c:forEach var="creditProveListDto" items="${creditProveListDtoList}" varStatus="status">
					<tr style="height: 19.8500pt;">
					<td valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">${status.count}</span>
					</td>
					<td valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">${creditProveListDto.cerNO}</span>
					</td>
					<td valign=center style="text-align:center;padding: 2px; border-left: 0.7500pt solid rgb(0, 0, 0); mso-border-left-alt: 0.7500pt solid rgb(0, 0, 0); border-right: 0.7500pt solid rgb(0, 0, 0); mso-border-right-alt: 0.7500pt solid rgb(0, 0, 0); border-top: 0.7500pt solid rgb(0, 0, 0); mso-border-top-alt: 0.7500pt solid rgb(0, 0, 0); border-bottom: 0.7500pt solid rgb(0, 0, 0); mso-border-bottom-alt: 0.7500pt solid rgb(0, 0, 0);">
							<span style="mso-spacerun: 'yes'; font-size: 15.0000pt; font-family: '宋体';">${creditProveListDto.name}</span>
					</td>
				</tr>
				</c:forEach>

</table>
</div>
</c:if> 

<div style="display: none;" id="butDiv">
<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;" >
	<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';" > 
	 ${deptName}
	</span>
	<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
</p>
<p class=p0 style="margin-bottom: 0pt; margin-top: 0pt; text-align: right; line-height: 28.0000pt;" >
	<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';" > 
	 <fmt:formatDate value="${nowDate}" pattern="yyyy年MM月dd日   HH:mm:ss"/>
	</span>
	<span style="mso-spacerun: 'yes'; font-size: 16.0000pt; font-family: '仿宋_GB2312';"><o:p></o:p></span>
</p>
<div class="center mt10" >
     <input type="button" id="addTz"    value="加入查证台账" class="btn mr20">
     <input type="button" id="printTz"  value="打印台账单" class="btn mr20">
     <input type="button" id="closeW"  value="关闭" class="btn mr20">
</div>
</div>



<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script>
    window._CONFIG = {
    		url:'${sysUrl}',
    		creditProveListDtoListLength:'${fn:length(creditProveListDtoList)}',
    		nowDateStr:'${nowDateStr}'
    }
</script>
<script src="/js/syn/system/creditprove/creditprovemancompare_edit.js"></script>
</body>
</html>