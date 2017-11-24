<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
 
<form id="sysUserForm">
    <div class="pd20 clearfix">
        <h3 class="h3-title center"></h3>
        <c:if test="${empty viewFlag}">
       <div class="clearfix mb5 center">
		 <h5>
		     <input type="text" class="ipt-txt" id="keyword" placeholder="请输入完整的主体名称或统一社会信用代码" style="width: 400px; box-sizing: border-box; padding: 1px 3px;line-height: 28px;height: 30px;font: 13.3333px Arial;"/>
		     <input type="button" class="btn btn-sm" id="search" value="查询">
		 </h5>
		</div>
		</c:if>
		<input type="hidden" id="subjectType" name="subjectType" value="1">
		<input type="hidden" id="dutyDeptCode" value="${dutyDeptCode}">
		<input type="hidden" id="uid" name="uid" value="${drandomSpecialEnt.uid}">
		<input type="hidden" id="dutyDeptCode" name="dutyDeptCode" value="${drandomSpecialEnt.dutyDeptCode}">
		<input type="hidden" id="regOrg" name="regOrg" value="${midBaseInfoDto.regOrg}">
		<input type="hidden" id="localAdm" name="localAdm" value="${midBaseInfoDto.localAdm}">
		<input type="hidden" id="priPID" name="priPID" value="${midBaseInfoDto.priPID}">
		<input type="hidden" id="regState" name="regState" value="${midBaseInfoDto.regState}">
		<input type="hidden" id="regNO" name="regNO" value="${midBaseInfoDto.regState}">
		<input type="hidden" id="uniCode" name="uniCode" value="${midBaseInfoDto.uniCode}">
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
            <tr>
            	<td class="bg-gray right" width="15%">主体名称：</td>
                <td width="35%">
                    <div class="ipt-box pd0">
                        <input type="text" id="entName" name="entName" value="${midBaseInfoDto.entName}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
                <td class="bg-gray right" width="20%">统一社会信用代码/注册号：</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="text" id="regNOV" value="${empty midBaseInfoDto.uniCode?midBaseInfoDto.regNO:midBaseInfoDto.uniCode}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
            	<td class="bg-gray right">法定代表人：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="leRep" name="leRep" value="${midBaseInfoDto.leRep}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
                <td class="bg-gray right">成立日期：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="estDate" name="estDate" value="<fmt:formatDate value="${midBaseInfoDto.estDate}" pattern="yyyy-MM-dd" />" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
            	<td class="bg-gray right">登记机关：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="regOrgName" name="regOrgName" value="${midBaseInfoDto.regOrgName}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
                <td class="bg-gray right">主体类别：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="hidden" id="entTypeCatg" name="entTypeCatg" value="${midBaseInfoDto.entTypeCatg}"/>
                        <input type="text" id="entTypeCatgName" name="entTypeCatgName" value="${midBaseInfoDto.entTypeCatgName}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
            	<td class="bg-gray right">管辖单位：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="localAdmName" name="localAdmName" value="${midBaseInfoDto.localAdmName}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
                <td class="bg-gray right">登记状态：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="regStateV" class="ipt-txt" value="${regStateName}" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
            	<td class="bg-gray right">住所：</td>
                <td colspan="3">
                    <div class="ipt-box pd0">
                        <input type="text" id="dom" name="dom" value="${midBaseInfoDto.dom}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
            	<td class="bg-gray right">经营范围：</td>
                <td colspan="3">
                    <div class="ipt-box pd0">
                        <input type="text" id="opScope" name="opScope" value="${midBaseInfoDto.opScope}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            </table>
          <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12"> 
             <tr>
                <td class="bg-gray right" width="15%"><span class="light">*</span>专项库：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="hidden" class="ipt-txt" name="specialName" id="specialName" value="${drandomSpecialEnt.specialName}"/>
<%--                         <input type="text" class="ipt-txt" id="specialName" name="specialName" value="${drandomSpecialEnt.specialName}" readonly="readonly" placeholder="请选择专项库"/> --%>
<!-- 	                     <span class="add-icon" id="choseSpecial"> -->
<!-- 	                          <i></i> -->
<!-- 	                    </span> -->
	                    <select id="specialCode" name="specialCode" style="width: 300px" required="required">
	                    	<c:if test="${!empty codeSpecialTypeList }">
	                    	<option value="">请选择</option>
	                    	<c:forEach items="${codeSpecialTypeList}" var="codeSpecialType">
	                          <option value="${codeSpecialType.specialCode}" <c:if test="${drandomSpecialEnt.specialCode == codeSpecialType.specialCode}">selected="selected"</c:if>>${codeSpecialType.specialName}</option>
	                    	</c:forEach>
	                    	</c:if>
	                    	<c:if test="${empty codeSpecialTypeList }">
	                    		<option value="">暂无专项库数据，请联系管理员</option>
	                    	</c:if>
                        </select>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span class="light">*</span>对应专项库监管标签：</td>
                <td>
                    <div class="ipt-box pd0">
                    	<input type="hidden" id="markName" name="markName" value="${drandomSpecialEnt.markName}" class="ipt-txt isShow" />
                        <select id="markCode" name="markCode" style="width: 300px" required="required">
                        	<option value="">请选择</option>
                        	<c:forEach items="${codeMarkTypeList}" var="codemark">
	                          <option value="${codemark.markCode}" <c:if test="${drandomSpecialEnt.markCode == codemark.markCode}">selected="selected"</c:if>>${codemark.markName}</option>
	                    	</c:forEach>
                        </select>
                    </div>
                </td>
            </tr>
<!--              <tr> -->
<!--                 <td class="bg-gray right">对应专项库的许可证：</td> -->
<!--                 <td> -->
<!--                     <div style="font-size: 13px"> -->
<%--                         <label><input type="radio" id="isSpecial" name="specialLicFlag"  value="1" class="ipt-txt" ${pubScSpecialLibrary.specialLicFlag=='1'?'checked':''}/>有&nbsp;</label> --%>
<%--                         <label><input type="radio" id="notSecial" name="specialLicFlag"  value="0" class="ipt-txt" ${pubScSpecialLibrary.specialLicFlag=='0'?'checked':''}/>无&nbsp;</label> --%>
<!--                     </div> -->
<!--                 </td> -->
<!--             </tr> -->
             <tr>
                <td class="bg-gray right">许可证名称：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="licName" name="licName" value="${drandomSpecialEnt.licName}" class="ipt-txt isShow" />
<!--                         <span class="add-icon" id="qzcodetree"> -->
<!--                           <i></i> -->
<!--                         </span> -->
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right">许可证编号：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="licNO" name="licNO"  value="${drandomSpecialEnt.licNO}" class="ipt-txt isShow" />
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">许可批准日期：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="licApprDate" name="licApprDate" onclick="laydate()" readonly="readonly" style="width: 150px;cursor: pointer;"
                        value="<fmt:formatDate value="${drandomSpecialEnt.licApprDate}" pattern="yyyy-MM-dd" />" class="ipt-txt isShow" />
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">许可有效期至：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="licSaveEndDate" name="licSaveEndDate" onclick="laydate()" readonly="readonly" style="width: 150px;cursor: pointer;" 
                         value="<fmt:formatDate value="${drandomSpecialEnt.licSaveEndDate}" pattern="yyyy-MM-dd" />" class="ipt-txt isShow" />
                         <label><input type="checkbox" id="isLongTime"/>长期有效</label>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right">许可发证机关：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="licSendDeptName" name="licSendDeptName"  value="${drandomSpecialEnt.licSendDeptName}" class="ipt-txt isShow" />
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span class="light">*</span>检查部门：</td>
                <td>
                    <div class="ipt-box pd0">
                    	<input type="hidden" id="checkDeptCode" name="checkDeptCode" value="${drandomSpecialEnt.checkDeptCode}"/>
                        <input type="text" id="checkDeptName" name="checkDeptName" value="${drandomSpecialEnt.checkDeptName}" class="ipt-txt isShow" disabled="disabled" required="required"/>
                        <span class="add-icon" id="checkDeptNameAdd">
                          <i></i>
                        </span>
                    </div>
                </td>
            </tr>
            <tr>
               <td class="bg-gray right">专项检查主体状态：</td>
               <td>
                   <div style="font-size: 13px">
                        <label><input type="radio" id="isScVlid" name="isVlid" <c:if test="${drandomSpecialEnt.isVlid == '1' || empty drandomSpecialEnt.isVlid}"> checked="checked"</c:if> value="1" class="ipt-txt"/>有效&nbsp;</label>
                        <label><input type="radio" id="noScVlid" name="isVlid" <c:if test="${drandomSpecialEnt.isVlid == '0'}"> checked="checked"</c:if> value="0" class="ipt-txt" />失效&nbsp;</label>
                    </div>
               </td>
            </tr>
        </table>
         <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
           <tr>
             <td class="bg-gray right">设置人：</td>
             <td>
                 <div class="ipt-box pd0">
                     <input type="text" id="setUserName"   value="${drandomSpecialEnt.setUserName}" class="ipt-txt" readonly="readonly"/>
                 </div>
             </td>
             <td class="bg-gray right">设置日期：</td>
             <td>
                 <div class="ipt-box pd0">
                     <input type="text" id="setTime"  value="<fmt:formatDate value="${drandomSpecialEnt.creatTime}" pattern="yyyy-MM-dd" />" class="ipt-txt" readonly="readonly"/>
                 </div>
             </td>
           </tr>
         </table>
         <p class="center mt10">
         	<c:if test="${viewFlag != '2'}">
	        <input type="submit" id="save" class="btn mr20" value="保 存"/>
	        </c:if>
	        <button id="cancel" type="button" class="btn">关闭</button>
	     </p>
    </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/specialent/specialent_edit.js"></script>
</body>
</html>
