<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>涉嫌违法事项维护</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="layder-hd">
 <div class="form-list send-message">
        	 <form id="sendSearchForm" >
                    	<div class="form-item clearfix">
                    		<div><input name="id" type="hidden" value="${copySendIllegalItems.id}"/></div>
                    		<div class="">
                                <label class="item-name col-2">部门：</label>
                                <div class="">
                                    <div class="ipt-box col-6">
                                        <input id="departCode" class="ipt-txt clearall" type="hidden"
                                               name="deptCode" value="${copySendIllegalItems.deptCode}"/>
                                        <input id="departName" 
                                               class="fl ipt-txt clearall" type="text" value="${copySendIllegalItems.deptCodeName}" placeholder="请选择部门" readonly/>
                                        <a id="selectRegOrg" class="link js-show">
                                            <span class="add-icon" id="codetree"><i></i></span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                    	</div>
                    	<div class="form-item clearfix">
                    	<div class="">
                                <label class="item-name col-2">单位层级：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input id="unitLevel" name="unitLevel" type="text" class="ipt-txt clearall" value="${copySendIllegalItems.unitLevel}">
                                    </div>
                                </div>
                            </div>
                    	</div>
                    	<%-- <div class="form-item clearfix mb10">
                    	<div class="">
                                <label class="item-name col-5">单位：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input id="illegalItems" name="unitCode" type="text" class="ipt-txt clearall" value="${copySendIllegalItems.unitCode}">
                                    </div>
                                </div>
                            </div>
                    	</div> --%>
                    	<div class="form-item clearfix">
                    	<div class="">
                                <label class="item-name col-2">涉嫌违法事项：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input id="illegalItems" name="illegalItems" type="text" class="ipt-txt clearall" value="${copySendIllegalItems.illegalItems}">
                                    </div>
                                </div>
                            </div>
                    	</div>
                    	<div class="form-item clearfix">
                    	<div class="">
                                <label class="item-name col-2">设置人：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
	                                    <c:if test="${pageFlag == 'edit'}">
	                                    <input id="illegalItems" name="setUserName" type="text" class="ipt-txt clearall" value="${copySendIllegalItems.setUserName}" readonly />
	                                    </c:if>
	                                    <c:if test="${pageFlag == 'add'}">
	                                    <input id="illegalItems" name="setUserName" type="text" class="ipt-txt clearall" value="${sessionScope.session_sys_user.realName}" readonly />
	                                    </c:if>
                                    </div>
                                </div>
                            </div>
                    	</div>
                    	<div class="form-item clearfix">
                    	<div class="">
                                    <label class="item-name col-2">设置时间：</label>
                                    <div class="col-3">
                                        <div class="ipt-box">
                                         <c:if test="${pageFlag == 'add'}">
                                            <input name="setTime" readonly="readonly" type="text"
                                                   class="ipt-txt clearall" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
                                         </c:if>
                                         <c:if test="${pageFlag == 'edit'}">
                                            <input name="setTime" readonly="readonly" type="text"
                                                   class="ipt-txt clearall" value="<fmt:formatDate value="${copySendIllegalItems.setTime}" pattern="yyyy-MM-dd"/>">
                                         </c:if>          
                                        </div>
                                    </div>
                                </div>
                    	</div>
                    	<div class="form-item clearfix">
                    		<c:if test="${empty copySendIllegalItems.id}">
                            <div class="btn-box">
                                <input id="save" type="button" value="保 存" class="btn mr20">
                                <input id="cancel" type="button" value="取 消" class="btn">
                            </div>
                            </c:if>
                            <c:if test="${not empty copySendIllegalItems.id}">
                            <div class="btn-box">
                                <input id="edit" type="button" value="确定" class="btn mr20">
                                <input id="cancel" type="button" value="取 消" class="btn">
                            </div>
                            </c:if>
                        </div>
        	 </form>
 </div>
<script>
		if("${sysUser.userType}" == "1"){
			 window._CONFIG = {
		    		_urlHead:'/reg/server/illegalitem/',
		     }
		}else{
			window._CONFIG = {
		    		_urlHead:'/syn/illegalitem/',
		     }
		}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/copysend/cgcs_illegalitems_addandedit.js"></script>
</body>
</html>