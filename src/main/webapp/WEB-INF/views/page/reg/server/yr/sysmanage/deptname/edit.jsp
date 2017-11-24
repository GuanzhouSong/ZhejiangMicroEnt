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
    <title>部门名称规管理修改</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
<div class="layder-bd ">
    <div class="form-list name-specification">
   	<form class="form-horizontal" id="deptEditInfoForm">
   	 <input type="hidden" id ="deptDID" name ="deptDID"  value="${departMent.deptDID}"/>
	   	       <div class="form-item clearfix">
	            <label class="item-name col-3">行政编码：</label>
	            <div class="col-4">
	                <div class="ipt-box mr10">
	                    <input type="text" name="deptCode" id="deptCode" readonly="readonly" class="ipt-txt" value="${departMent.deptCode}">
	                </div>
	            </div>
	            <div class="example col-5">
	                示例：330106
	            </div>
	          </div>
	           <div class="form-item clearfix">
	            <label class="item-name col-3">上级部门名称：</label>
	            <div class="col-4">
	                <div class="ipt-box mr10">
	                    <input type="text" name="deptUpName" id="deptUpName"  class="ipt-txt" value="${departMent.deptUpName}">
	                </div>
	            </div>
	            <div class="example col-5">
	                示例：杭州市市场监督管理局
	            </div>
	          </div>
   	          <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span>部门全称：</label>
            <div class="col-4">
                <div class="ipt-box mr10">
                    <input type="text" name="deptName" id="deptName" class="ipt-txt" value="${departMent.deptName}">
                </div>
            </div>
            <div class="example col-5">
                示例：杭州市市场监督管理局西湖分局
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span>部门简称：</label>
            <div class="col-4">
                <div class="ipt-box mr10">
                     <input type="text" name="deptShortName"  class="ipt-txt"  value="${departMent.deptShortName}">
                </div>
            </div>
            <div class="example col-5">
                示例：西湖市监分局
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span>部门字号：</label>
            <div class="col-4">
                <div class="ipt-box mr10">
                    <input type="text" name="docShortName" id="docShortName" class="ipt-txt" value="${departMent.docShortName}">
                </div>
            </div>
            <div class="example col-5">
                示例：西市监
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span>同级人民政府：</label>
            <div class="col-4">
                <div class="ipt-box col-8 mr2">
                     <input type="text" id="sameGov" name="sameGov"  class="ipt-txt" value="${departMent.sameGov}">
                </div>
                <div class="item-txt">人民政府</div>
            </div>
            <div class="example col-5">
                示例：西湖区  人民政府
            </div>
        </div>
        <div class="form-item clearfix mb20">
            <label class="item-name col-3"><span class="light">*</span>同级人民法院：</label>
            <div class="col-4">
                <div class="ipt-box col-8 mr2">
                    <input type="text" id="sameCourt" name="sameCourt"  class="ipt-txt" value="${departMent.sameCourt}">
                </div>
                <div class="item-txt">人民法院</div>
            </div>
            <div class="example h32 col-5">
                示例：西湖区  人民法院
            </div>
        </div>
		 <div class="form-item clearfix col-offset-3">
            <div class="ml60">
		        <input id="save" type="submit" class="btn mr20" value="保存" />
                <input id="cancel" type="button" class="btn" value="取消"/>
             </div>
         </div>
	</form>
  </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/deptname/edit_main.js"></script>
</body>
</html>