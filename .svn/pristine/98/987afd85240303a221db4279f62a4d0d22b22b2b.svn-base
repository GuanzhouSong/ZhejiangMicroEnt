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
    <input type="hidden" id="" name="uid" value="${pubScSpecialLibrary.uid}"/>
    <input type="hidden" id="" name="priPID" value="${baseInfo.priPID}"/>
    <input type="hidden" id="" name="regNO" value="${baseInfo.regNO}"/>
    <input type="hidden" id="" name="uniCode" value="${baseInfo.uniCode}"/>
    <input type="hidden" id="" name="regOrg" value="${baseInfo.regOrg}"/>
    <input type="hidden" id="" name="localAdm" value="${baseInfo.localAdm}"/>
    <input type="hidden" id="" name="regState" value="${baseInfo.regState}"/>
    <input type="hidden" id="" name="sliceNO" value="${baseInfo.sliceNO}"/>
    <input type="hidden" id="" name="sliceNOName" value="${baseInfo.sliceNOName}"/>
    <input type="hidden" id="viewFlag" value="${viewFlag}"/>
    <div class="pd20 clearfix">
        <h3 class="h3-title center"></h3>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
            <tr>
                <td class="bg-gray right" width="30%">统一社会信用代码/注册号：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="uniCodeOrReg"  value="${empty baseInfo.uniCode?baseInfo.regNO:baseInfo.uniCode}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%">企业名称：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="entName" name="entName"  value="${baseInfo.entName}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%">主体类别：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="hidden" id="entType" name="entType" value="${baseInfo.entTypeCatg}" class="ipt-txt"/>
                        <c:if test="${fn:indexOf('11,13,31,33,12,14,32,34,21,27,24,22,28',baseInfo.entTypeCatg)!=-1}">
                           <input type="text"  value="企业" class="ipt-txt" readonly="readonly"/>
                        </c:if>
                        <c:if test="${fn:indexOf('16,17',baseInfo.entTypeCatg)!=-1}">
                           <input type="text"  value="农专社" class="ipt-txt" readonly="readonly"/>
                        </c:if>
                        <c:if test="${fn:indexOf('50',baseInfo.entTypeCatg)!=-1}">
                           <input type="text"  value="个体户" class="ipt-txt" readonly="readonly"/>
                        </c:if>
                        <c:if test="${fn:indexOf('23',baseInfo.entTypeCatg)!=-1}">
                           <input type="text"  value="外企代表机构" class="ipt-txt" readonly="readonly"/>
                        </c:if>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%">登记机关：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="regOrgName" name="regOrgName"  value="${baseInfo.regOrgName}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%">管辖单位：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="localAdmName" name="localAdmName"  value="${baseInfo.localAdmName}" class="ipt-txt" readonly="readonly"/>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>专项库：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="hidden" class="ipt-txt" name="specialCode" id="specialCode" value="${pubScSpecialLibrary.specialCode}"/>
                        <input type="text" class="ipt-txt" id="specialName" name="specialName" value="${pubScSpecialLibrary.specialName}" readonly="readonly" placeholder="请选择专项库" required/>
	                     <span class="add-icon" id="choseSpecial">
	                          <i></i>
	                    </span>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>对应专项库监管标签：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <select id="markCode" name="markCode" style="width: 300px">
                          <option value="${pubScSpecialLibrary.markCode}" selected="selected">${pubScSpecialLibrary.markName}</option>
                        </select>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>对应专项库的许可证：</td>
                <td width="70%">
                    <div style="font-size: 13px">
                        <label><input type="radio" id="isSpecial" name="specialLicFlag"  value="1" class="ipt-txt" ${pubScSpecialLibrary.specialLicFlag=='1'?'checked':''}/>有&nbsp;</label>
                        <label><input type="radio" id="notSecial" name="specialLicFlag"  value="0" class="ipt-txt" ${pubScSpecialLibrary.specialLicFlag=='0'?'checked':''}/>无&nbsp;</label>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>许可证名称：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="licName" name="licName" value="${pubScSpecialLibrary.licName}" class="ipt-txt isShow" required="required"  placeholder="无则手动输入"/>
                        <span class="add-icon" id="qzcodetree">
                          <i></i>
                        </span>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>许可证编号：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="licNO" name="licNO"  value="${pubScSpecialLibrary.licNO}" class="ipt-txt isShow" required="required"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>许可批准日期：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="licApprDate" name="licApprDate" onclick="laydate()" readonly="readonly" style="width: 150px;cursor: pointer;"
                        value="<fmt:formatDate value="${pubScSpecialLibrary.licApprDate}" pattern="yyyy-MM-dd" />" class="ipt-txt isShow" required="required"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>许可有效期至：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="licSaveEndDate" name="licSaveEndDate" onclick="laydate()" readonly="readonly" style="width: 150px;cursor: pointer;" 
                         value="<fmt:formatDate value="${pubScSpecialLibrary.licSaveEndDate}" pattern="yyyy-MM-dd" />" class="ipt-txt isShow" required="required"/>
                         <label><input type="checkbox" id="isLongTime"/>长期有效</label>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>许可发证机关：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="licSendDept" name="licSendDept"  value="${pubScSpecialLibrary.licSendDept}" class="ipt-txt isShow" required="required"/>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>是否需要专业监管：</td>
                <td width="70%">
                    <div style="font-size: 13px">
                        <label><input type="radio" id="isSupervise" name="superviseFlag"  value="1" class="ipt-txt" ${pubScSpecialLibrary.superviseFlag =='1'?'checked':''}/>是&nbsp;</label>
                        <label><input type="radio" id="noSupervise" name="superviseFlag"  value="0" class="ipt-txt" ${pubScSpecialLibrary.superviseFlag =='0'?'checked':''}/>否&nbsp;</label>
                    </div>
                </td>
            </tr>
             <tr class="noInput">
                <td class="bg-gray right" width="30%"><span class="light show">*</span>是否需要专业资质资格：</td>
                <td width="70%">
                    <div style="font-size: 13px">
                        <label><input type="radio" id="isRightFlag" name="rightFlag"  value="N" class="ipt-txt rightFlag" ${pubScSpecialLibrary.rightFlag =='N'?'checked':''}/>否&nbsp;</label>
                        <label><input type="radio" id="noRightFlag"   name="rightFlag" value="Y" class="ipt-txt rightFlag" ${(pubScSpecialLibrary.rightFlag !='N'&& !empty pubScSpecialLibrary.rightFlag)?'checked':''}/>是&nbsp;</label>
                        <span id="checkRight" style="display:none">
	                        (<label><input type="checkbox" id="tip" class="detailsClassF"  value="1" ${fn:indexOf(pubScSpecialLibrary.rightFlag,'1')!=-1?'checked':''}/>保化检查员</label>
	                         <label><input type="checkbox" class="detailsClassF"  value="2" ${fn:indexOf(pubScSpecialLibrary.rightFlag,'2')!=-1?'checked':''}/>药品检查员</label>
	                         <label><input type="checkbox" class="detailsClassF"  value="3" ${fn:indexOf(pubScSpecialLibrary.rightFlag,'3')!=-1?'checked':''}/>医疗器械检查员</label>
	                         <label><input type="checkbox" class="detailsClassF"  value="4" ${fn:indexOf(pubScSpecialLibrary.rightFlag,'4')!=-1?'checked':''}/>特种设备安全专员</label>)
                         </span>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>是否需要配备专家（组长）：</td>
                <td width="70%">
                    <div style="font-size: 13px">
                        <label><input type="radio" id="isLeadFlag" name="leadFlag"  value="N" class="ipt-txt leadFlag" ${pubScSpecialLibrary.leadFlag =='N'?'checked':''}/>否&nbsp;</label>
                        <label><input type="radio" id="noLeadFlag" name="leadFlag" value="Y"  class="ipt-txt leadFlag" ${(pubScSpecialLibrary.leadFlag !='N' && !empty pubScSpecialLibrary.leadFlag)?'checked':''}/>是&nbsp;</label>
                        <span id="checkLead" style="display:none">
	                       (<label><input type="checkbox" id="firTip" class="detailsClassL" value="1" ${fn:indexOf(pubScSpecialLibrary.leadFlag,'1')!=-1?'checked':''}/>保化组长</label>
	                        <label><input type="checkbox"   class="detailsClassL" value="2" ${fn:indexOf(pubScSpecialLibrary.leadFlag,'2')!=-1?'checked':''}/>药品GSP</label>
	                        <label><input type="checkbox"   class="detailsClassL" value="3" ${fn:indexOf(pubScSpecialLibrary.leadFlag,'3')!=-1?'checked':''}/>药品GMP</label>
	                        <label><input type="checkbox"   class="detailsClassL" value="4" ${fn:indexOf(pubScSpecialLibrary.leadFlag,'4')!=-1?'checked':''}/>医疗器械GSP</label>
	                        <label><input type="checkbox"   class="detailsClassL" value="5" ${fn:indexOf(pubScSpecialLibrary.leadFlag,'5')!=-1?'checked':''}/>医疗器械GMP</label>)
                        </span>
                    </div>
                </td>
            </tr>
            <c:if test="${viewFlag == '1'}">
	            <tr>
	               <td class="bg-gray right" width="30%"><span class="light">*</span>专项检查主体状态：</td>
	               <td width="70%">
	                   <div style="font-size: 13px">
	                        <label><input type="radio" id="isScVlid" name="isScVlid"  value="1" class="ipt-txt" ${pubScSpecialLibrary.isScVlid =='1'?'checked':''}/>有效&nbsp;</label>
	                        <label><input type="radio" id="noScVlid" name="isScVlid"  value="0" class="ipt-txt" ${pubScSpecialLibrary.isScVlid =='0'?'checked':''}/>失效&nbsp;</label>
	                    </div>
	               </td>
	            </tr>
            </c:if>
        </table>
        <c:if test="${viewFlag != '2'}">
	        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
	           <tr>
	             <td class="bg-gray right">设置人：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="text" id="setUserName" name="setUserName"  value="${sessionScope.session_sys_user.realName}" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	             <td class="bg-gray right">设置日期：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="text" id="setTime" name="setTime" value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	             <td class="bg-gray right">设置部门：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="hidden" id="setDeptcode" name="setDeptcode"  value="${sessionScope.session_sys_user.departMent.deptCode}" class="ipt-txt" readonly="readonly"/>
	                        <input type="text" id="setDeptName" name="setDeptName"  value="${sessionScope.session_sys_user.departMent.deptName}" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	           </tr>
	        </table>
        </c:if>
        <c:if test="${!empty viewFlag && viewFlag == '2'}">
           <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
	           <tr>
	             <td class="bg-gray right">设置人：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="text" id="setUserName"   value="${pubScSpecialLibrary.setUserName}" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	             <td class="bg-gray right">设置日期：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="text" id="setTime"  value="<fmt:formatDate value="${pubScSpecialLibrary.setTime}" pattern="yyyy-MM-dd" />" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	             <td class="bg-gray right">设置部门：</td>
	             <td>
	                    <div class="ipt-box pd0">
	                        <input type="text" id="setDeptName" value="${pubScSpecialLibrary.setDeptName}" class="ipt-txt" readonly="readonly"/>
	                    </div>
	             </td>
	           </tr>
	        </table>
        </c:if>
        <c:if test="${viewFlag !='2'}">
	         <p class="center mt10">
		        <input type="submit" id="save" class="btn mr20" value="保 存"/>
		        <button id="cancel" type="button" class="btn">关闭</button>
		     </p>
        </c:if>
    </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/scspecial/speciallibrary_edit_main.js"></script>
</body>
</html>