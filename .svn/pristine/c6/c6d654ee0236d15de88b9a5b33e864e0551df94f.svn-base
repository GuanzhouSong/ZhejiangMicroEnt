<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="nowdate" class="java.util.Date" />
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>企业回退页面</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/syn.css">      
</head>
<body>
<div class="pd20 clearfix">      
		<div class="light-info left"><span class="light bold f14">明确企业备案事项的备案部门时请选择“重新指派”，否则请选择“回退”。</span></div>							
        <form id="form">
        <input type="hidden" name="uid" id="uid" value="${pubDtInfo.uid }"/>
        <input type="hidden" name="priPID" id="priPID" value="${pubDtInfo.priPID }"/>
        <input type="hidden" name="reassignAccount" value="${sysUser.username}"/>
        <input type="hidden" name="dutyDeptName" id ="dutyDeptName" />
        <input type="hidden" name="dutyDeptCode" id="dutyDeptCode" />
        <input type="hidden" id="orgCodes" />
        
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tr>
			<th class="bg-gray right"  width="20%">操作类型<span style="color:red;">*</span></th>
			<td width="80%" colspan="3">
		    <div class="ipt-box">
                    <label><input type="radio" value="1" name="reassignType" id= "radio1" checked="checked" >重新指派</label>
                    <label><input type="radio" value="2" name="reassignType" id="radio2">回退</label>
            </div>
            </td>
		</tr>
        <tr id="recheck">
			<th class="bg-gray right">重新指派备案机关<span style="color:red;">*</span></th>
			<td colspan="3">
                <div class="ipt-box col-12">
                     <input type="hidden" name="checkDep" value="" id="checkDep">         
                     <input type="text" name="checkDepName" id="checkDepName" value=""  placeholder="选择" class="fl ipt-txt" readonly="readonly">         
                     <span id="selectDept" class="add-icon"><i></i></span>
                </div>
            </td>
		</tr>		
         <tr>
			<th class="bg-gray right">操作执行部门<span style="color:red;">*</span></th>
			<td colspan="3">
              <div class="ipt-box">
              <input type="text" name="reassignDeptName" value="${sysUser.userType == '2' ? sysUser.sysDepart.orgName : sysUser.departMent.deptName}" readonly="readonly" class="fl ipt-txt"/>
			  </div>
			</td>
		</tr>  
		<tr id="reback"  style="display: none">
			<th class="bg-gray right">退回理由<span style="color:red;">*</span></th>
			<td colspan="3">
		    <div class="ipt-box">
            <select name="reassignCode" id = "reassignCode" required >
              <option value="">--请选择--</option>
              <option value="0">经营范围内无此备案事项</option>
              <option value="1">经营范围不在本部门的管辖范围内</option>
              <option value="2">地址不在本部门的管辖范围内</option>
	         </select>
	         </div>
            </td>
		</tr> 
		<tr>
		    <th class="bg-gray right" width="20%" >操作人</th>
		    <td width="30%">
		      <div class="ipt-box">
              <input type="text" name="reassignName" value="${sysUser.realName}" readonly="readonly" class="fl ipt-txt"/>
		      </div>
		    <th class="bg-gray right" width="20%" >操作日期</th>
			<td>
			<div class="ipt-box">
			<fmt:formatDate value="${nowdate}" pattern="yyyy-MM-dd"/>
			</div>
			</td>
		</tr>
		<tr>
			<th class="bg-gray right">备注（限500字以内）</th> 
		    <td colspan="3">
	         <div class="ipt-box">
	         <textarea name="reassignRemark" id="remark" rows="3" cols="" class="fl"></textarea> 
	         </div>
		    </td>
		</tr> 
	    </table>
	    <br></br>
	    <div class="center">
	        <input type="button" class="btn mr20" value="确定" id="save">
	        <input type="button" class="btn" value="取消" id="cancel">
	     </div>
	    </form>
</div>
</body>
<script>
    window._CONFIG = {
       userType:'${sysUser.userType}', 
       adcode:'${sysUser.userType == 2 ? sysUser.dutyDeptCodes : "A058"}',
       chooseUrl:'${userType == 2 ? "/syn" : "/reg/server"}' ,
       deptCode:'${sysUser.deptCode}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/pubdzdtinfo/pubdtinforeback_edit.js"></script>
</html>