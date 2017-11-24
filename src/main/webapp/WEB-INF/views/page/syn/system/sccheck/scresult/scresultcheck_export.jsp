<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="print-nocard">
    <div class="mt10">
        <div class="tabbale" data-component="tab">
            <div class="tab-content">
              	<div class="tab-panel tab-panel-show" id="itemPanelDivId">
              	<form id="taskForm" method="post">
              	    <input type="hidden" id="downLoadFlag" value="${downLoadFlag}"/>
              	    <c:forEach var="sccheckItem" items="${pubSccheckItemResultList}" varStatus="status">
              	        <input type="hidden" class="checkClass" value="${sccheckItem.checkCode}"/>
              	    </c:forEach>
                    <div class="mt10">
	                       <table id="table2" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                            	<td class="bg-gray center" width="10%"></td>
	                                <td class="bg-gray center" width="60%"><strong>检查事项</strong></td> 
	                                <td class="bg-gray center" width="30%"><strong>操作</strong></td>
	                            </tr>
	                            <c:forEach var="pubSccheckItem" items="${pubSccheckTypeList}" varStatus="status">
		                            <tr>
		                                <td class="center">
		                                  <input type="checkbox" class="allItemClass" id="" name="" value="${pubSccheckItem.code}"/>
		                                </td>
		                                <td>${status.index + 1}. ${pubSccheckItem.content}</td>
		                                <td class="center"><a checkCode="${pubSccheckItem.code}" class="export">下载</a></td>
		                            </tr>
	                            </c:forEach>
	                          </tbody>
	                       </table><br/>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<form id="exportform" method="post" action="/reg/sccheck/pubscentresult/sccheck_export">
   <input type="hidden" name="priPID" value="${priPID}"/>
   <input type="hidden" name="taskUid" value="${taskUid}"/>
   <input type="hidden" id="itemCode" name="checkCode" value=""/>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scresult/sccheckItem_export.js"></script>
</body>
</html>