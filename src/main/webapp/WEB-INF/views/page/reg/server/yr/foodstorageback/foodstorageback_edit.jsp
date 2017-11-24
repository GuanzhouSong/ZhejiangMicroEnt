<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container .container-fluid">
    <div class="" style="margin-top: 10px;">
        <form class="form-horizontal" id="modapplication-form">
            <input type="hidden" name="priPID" value="${modApplicationDto.priPID}"/>
            <input type="hidden" name="id" value="${modApplicationDto.id}"/>
            <input type="hidden" name="entName" value="${modApplicationDto.entName}"/>
            <input type="hidden" name="year" value="${modApplicationDto.year}"/>
            <input type="hidden" name="entTypeCatg" value="${modApplicationDto.entTypeCatg}"/>
            <input type="hidden" name="regNo" value="${modApplicationDto.regNo}"/>
        	<table class="table table-striped table-bordered table-hover" width="100%">
	            <tr>
	                <td width="12%" style="font-weight:bold;" align="right">注册号</td>
	                <td width="17%">
	                    ${modApplicationDto.regNo }
	                </td>
	
	                <td width="10%" style="font-weight:bold;" align="right">企业名称</td>
	                <td width="33%">
	                    ${modApplicationDto.entName }
	                </td>
	
	                <td width="8%" style="font-weight:bold;" align="right">年报年度</td>
	                <td width="20%">
	                 ${modApplicationDto.year }
	                </td>
	            </tr>
	            <tr>
	                <td style="font-weight:bold;" align="right">年报状态</td>
	                <td>
	                	<c:if test="${modApplicationDto.reportState == '0'}">未年报</c:if>
	                	<c:if test="${modApplicationDto.reportState == '1'}">已年报</c:if>
	                	<c:if test="${modApplicationDto.reportState == '2'}">已年报（逾期）</c:if>
	                	<c:if test="${modApplicationDto.reportState == '00'}">未公示</c:if>
	                	<c:if test="${modApplicationDto.reportState == '10'}">已公示</c:if>
	                	<c:if test="${modApplicationDto.reportState == '11'}">敏感词通过</c:if>
	                	<c:if test="${modApplicationDto.reportState == '12'}">敏感词待审核</c:if>
	                	<c:if test="${modApplicationDto.reportState == '13'}">敏感词不通过</c:if>
	                	<c:if test="${modApplicationDto.reportState == '20'}">待修改</c:if>
	                </td>
	
	                <td style="font-weight:bold;" align="right">申请日期</td>
	                <td colspan="3">
	                	<fmt:formatDate value="${modApplicationDto.modSubmitDate }" pattern="yyyy-MM-dd"/>
	                </td>
	            </tr>
	            <tr>
	                <td style="font-weight:bold;" align="right">修改原因及内容</td>
	                <td colspan="5">
	                    ${modApplicationDto.modReason}
	                </td>
	            </tr>
	            <tr>
	                <td style="font-weight:bold;" align="right">审核结果</td>
	                <td>
	                    <input type="radio" id ="okRadio" name="modResult" value="1"/>
	                    <label for="okRadio" style="cursor: pointer;">同意</label>
	                    &nbsp;&nbsp;<input type="radio" id="noOkRadio" name="modResult" value="2"/>
	                    <label for="noOkRadio" style="cursor: pointer;">不同意</label> 
	                </td>
	                <td style="font-weight:bold;" align="right">审核人</td>
	                <td>
	                	${modApplicationDto.audName }
	                </td>
	                <td style="font-weight:bold;" align="right">审核日期</td>
	                <td>
	                	${modApplicationDto.currentDate }
	                </td>
	            </tr>
	            <tr>
	            	<td style="font-weight:bold;" align="right">审核意见</td>
	                <td colspan="5">
	                	<div class="col-xs-9">
	                		<input type="text" class="form-control required" width="80%" name="modDescription" id="modDescription"/>
	                	</div>
	                </td>
	            </tr>
            </table>
            <div class="row text-center">
                <button id="save" type="submit" class="btn btn-primary">保存</button>
                <button id="cancel" type="button" class="btn btn-primary">取消</button>
            </div>
        </form><br/>
        <input type="hidden" value="${modApplicationDto.priPID }" id="priPID"/>
         <table id="modapplicationhis" class="table table-striped table-bordered table-hover" width="100%">
	        <thead>
		        <tr>
		            <th>序号</th>
		            <th>申请时间</th>
		            <th>修改原因及内容</th>
		            <th>审核结果</th>
		            <th>审核意见</th>
		            <th>审核人</th>
		            <th>审核日期</th>
		        </tr>
	        </thead>
    </table>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/foodstoragebase/edit_main.js"></script>
</body>
</html>