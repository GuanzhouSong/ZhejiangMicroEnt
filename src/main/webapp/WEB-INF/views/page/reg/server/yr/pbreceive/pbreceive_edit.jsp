<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
<div class="pd20 clearfix">
        <div style="color:red;"><strong>提示：</strong></div>
        <div id="confirmTip" style="text-indent:2em;color:red;">系统记录的联系电话如与经营者手机号码不一致，请直接修改为最新有效手机号码，方便今后短信通知发送；如无手机号码请输入带区号的固定号码信息。</div>
        <form class="form-horizontal" id="yrPbform">
            <input type="hidden" name="priPID" value="${yrRegCheck.priPID }"/>
            <input type="hidden" name="year" value="${yrRegCheck.year }"/>
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <tr>
	                <td width="30%" style="font-weight:bold;" align="right">个体户注册号</td>
	                <td width="70%">
		                <div class="ipt-box">
	                    <input type="text" name="regNO" readonly="readonly" class="ipt-txt"
                           value="${yrRegCheck.regNO }"/>
                        </div>
	                </td>
	        </tr>
	        <tr>
	                <td style="font-weight:bold;" align="right">个体户名称</td>
	                <td >
		                <div class="ipt-box">
	                    <input type="text" name="entName" readonly="readonly" class="ipt-txt"
                           value="${yrRegCheck.entName }"/>
		                <div class="ipt-box">
	                </td>
	        </tr>
	        
	         <tr>
	                <td style="font-weight:bold;" align="right">经营者</td>
	                <td >
		                <div class="ipt-box">
	                    <input type="text" name="leRep" readonly="readonly" class="ipt-txt"
                           value="${yrRegCheck.leRep }"/>
                        </div>
	                </td>
	        </tr>
	        <tr>
	                <td style="font-weight:bold;" align="right">联系电话<span style="color:red;">*</span></td>
	                <td >
		                <div class="ipt-box">
	                    <input type="text" name="tel" value="${yrRegCheck.tel }"  class="ipt-txt"/>
	                    </div>
	                </td>
	        </tr>
	        </table>  
	       <div class="center mt10">
                <button id="save" type="submit" class="btn btn-info">保存</button>
                <button id="cancel" type="button" class="btn">取消</button>
           </div>
        </form>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/pbreceive/pbreceive_edit.js"></script>
</body>
</html>