<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>后置备案事项管理新增</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="layder-bd ">
    <div class="form-list name-specification jyexpire">
  	   	       <div class="form-item clearfix">
	            <label class="item-name col-3">* 备案事项编码：</label>
	            <div class="col-4">
	                <div class="ipt-box mr10">
	                    <input type="text"  id="exaCodeTem"   class="ipt-txt" value="${codeLicense.exaCode}" maxlength="10">
	                </div>
	            </div>
	            <div class="example col-5">
	                示例：015
	            </div>
	          </div>
	           <div class="form-item clearfix">
	            <label class="item-name col-3">* 备案事项名称：</label>
	            <div class="col-4">
	                <div class="ipt-box mr10">
	                    <input type="text"  id="exaNameTem"  class="ipt-txt" value="${codeLicense.exaName}" maxlength="200">
	                </div>
	            </div>
	            <div class="example col-5">
	                示例：设立保安培训单位备案
	            </div>
	          </div>
   	          <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span> 备案部门：</label>
            <div class="col-4">
                <div class="ipt-box mr10">
                    <input type="text"  id="licDeptTem" class="ipt-txt" value="${codeLicense.licDept}" maxlength="100">
                </div>
            </div>
            <div class="example col-5">
                示例：省公安厅
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span> 备案部门级别：</label>
            <div class="col-4">
                <div class="ipt-box mr10">
                    <label style="line-width:215px;width: 255px;">
                    <input   type="checkbox" value="0" name="licZoneTem">国家级
                    </label> 
                    <label style="line-width:215px;width: 255px;">
                        <input   type="checkbox" value="1" name="licZoneTem">省级
                    </label> 
                    <label style="line-width:215px;width: 255px;">
                        <input   type="checkbox" value="2" name="licZoneTem">市级
                    </label> 
                    <label style="line-width:215px;width: 255px;">
                        <input   type="checkbox" value="3" name="licZoneTem">县级
                    </label>
                </div>
            </div>
            <div class="example col-5">
                示例：        <input   type="checkbox" value="" checked="checked" name="licZoneExample" disabled="disabled">省级
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span> 职能部门：</label>
            <div class="col-4">
                <div class="ipt-box mr10">
                    <input type="text"  id="licDeptTypeTem" readonly="readonly" class="ipt-txt" value="${licDeptTypeStr}" maxlength="100">
               		<c:if test="${viewFlag=='1'}">
               		  <span class="add-icon" id="choselicDeptType"><i></i></span>
               		</c:if> 
                </div>
            </div>
            <div class="example col-5">
                示例：公安部门
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span> 法律依据：</label>
            <div class="col-4">
             <div class="ipt-box mr10">
					<input type="text" id="licReaTem"  class="ipt-txt" value="${codeLicense.licRea}" maxlength="1000">                </div>
             </div>
            <div class="example col-5">
                示例：《保安服务管理条例》（国务院令第564号）
            </div>
        </div>  
        <!-- 传递参数区域 -->
	    <form  id="codeLicenseform"> 
	        <input type="hidden"  id="exaCode" name="exaCode" value="${codeLicense.exaCode}" >
	        <input type="hidden"  id="exaName" name="exaName" value="${codeLicense.exaName}" >
	        <input type="hidden"  id="licDept" name="licDept" value="${codeLicense.licDept}" >
	        <input type="hidden"  id="licZone" name="licZone" value="${codeLicense.licZone}" >
	        <input type="hidden"  id="licRea" name="licRea" value="${codeLicense.licRea}" > 
	        <input type="hidden"  id="licType" name="licType" value="2" > 
	        <input type="hidden"  id="licDeptType" name="licDeptType" value="${codeLicense.licDeptType}" >  
	    </form> 
		<div class="form-item clearfix col-offset-3 mt10">
            <div class="ml60">
                <!--  viewFlag 1 修改  2查看-->
                <c:if test="${viewFlag=='1'}">
                <input id="savecodelicense" type="submit" class="btn mr20" value="保存" />
                </c:if> 
                <input id="cancelcodelicense" type="button" class="btn" value="取消"/>
            </div>
        </div>
   </div>
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/syn/system/codedzLicense/codedzlicense_edit_main.js"/>"></script>
<script>
    window._CONFIG = {
       _flag:'${viewFlag}',//修改标识   
       _licZone:'${codeLicense.licZone}'
      }
</script></body>
</html>