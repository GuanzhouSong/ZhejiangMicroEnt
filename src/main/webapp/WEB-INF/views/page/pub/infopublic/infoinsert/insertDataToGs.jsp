<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>数据导入工商云页面</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
    <meta charset="utf-8">
</head>
<body>
<div>-------------------------------------------索引更新--------------------------------------------------</div><br>
    <form action="updateOrSaveToGs" method="get" id="form1">
                企业名称/统一代码/注册号：
        <input type="text" id="condition" name="condition" placeholder="请输入企业名称、统一社会信用代码或注册号" size="40" value="${condition }">
        <input type="button" value="提交" id="popup-submit1">
    </form>
    <br><div>-------------------------------------------------------------------------------------------------------</div><br>
    <form action="doInsertPubDataToGsByApprDate" method="get" id="form2">
    	核准日期：
    	<input type="text"  onclick="laydate()" readonly="readonly" id="apprDate" name="apprDate" value="${apprDate }"/>
        <input type="button" value="提交" id="popup-submit2">
    </form>
    <br><div>-------------------------------------------------------------------------------------------------------</div><br>
    <form action="deleteEntByPriPID" method="post" id="form3">
    	根据内部序号删除索引：
    	<input type="text" id="priPID" name="priPID" placeholder="请输入企业内部序号" size="20" value="${priPID }">
    	<input type="text" id="password" name="password" placeholder="请输入key" size="20">
        <input type="button" value="提交" id="popup-submit3">
    </form> 
    <br><div>-------------------------------------------------------------------------------------------------------</div><br>
    <form action="isSimpleCancle" method="post" id="form4">
    	是否简易注销：
    	<input type="text" id="priPID2" name="priPID" placeholder="请输入企业内部序号" size="20" value="${priPID }">
    	<input type="text" id="password" name="password" placeholder="请输入key" size="20">
    	<input type="radio" value="1" checked="checked" name="isSimpleCancle"> 是
    	<input type="radio" value="0" name="isSimpleCancle"> 否
        <input type="button" value="提交" id="popup-submit4">
    </form> 
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script>
require(['laydate'],function (layer, dataTable, util, http, handlebars) {})

	  var msg = "${msg}";
	  if (msg != "") {
	     alert(msg);
	  }
      $("#popup-submit1").click(function () {
          var condition = $("#condition").val();
          if ($.trim(condition) == "") {
              alert("企业名称、统一社会信用代码或注册号不能为空!");
          } else {
        	  $("#form1").submit();
          }
      });
      
      $("#popup-submit2").click(function () {
    	  var apprDate = $("#apprDate").val();
    	  if (apprDate == "") {
              alert("核准日期不能为空!");
          } else {
        	  $("#form2").submit();
          }
      });
      
      $("#popup-submit3").click(function () {
          var priPID = $("#priPID").val();
          if ($.trim(priPID) == "") {
              alert("内部序号不能为空!");
          } else {
        	  $("#form3").submit();
          }
      });
      
      $("#popup-submit4").click(function () {
          var priPID = $("#priPID2").val();
          if ($.trim(priPID) == "") {
              alert("内部序号不能为空!");
          } else {
        	  $("#form4").submit();
          }
      });
</script>
</body>
</html>