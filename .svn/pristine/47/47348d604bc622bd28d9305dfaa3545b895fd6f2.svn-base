<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<!-- <div class="layder-hd">
 <div class="form-list">
        	 <form id="sendSearchForm" class="searchForm">
        	 	<div class="form-box mb5">
                    <div class="form-list">
                    	<div class="form-item clearfix mb10">
                    		<center>
                    		<div class="">
                                <label class="item-name col-5">部门：</label>
                                <div class="">
                                    <div class="ipt-box col-12">
                                        <input id="departCode" class="ipt-txt clearall" type="hidden"
                                               name="deptCode" />
                                        <input id="departName" 
                                               class="fl ipt-txt clearall" type="text"  placeholder="请选择部门" readonly/>
                                        <a id="selectRegOrg" class="link js-show">
                                            <span class="add-icon" id="codetree"><i></i></span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            </center>
                    	</div>
                    	<div class="form-item clearfix mb10">
                    	<div class="">
                                <label class="item-name col-5">单位层级：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input id="unitLevel" name="unitLevel" type="text" class="ipt-txt clearall" >
                                    </div>
                                </div>
                            </div>
                    	</div>
                    	<div class="form-item clearfix mb10">
                    	<div class="">
                                <label class="item-name col-5">单位：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input id="illegalItems" name="unitCode" type="text" class="ipt-txt clearall" >
                                    </div>
                                </div>
                            </div>
                    	</div>
                    	<div class="form-item clearfix mb10">
                    	<div class="">
                                <label class="item-name col-5">涉嫌违法事项：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input id="illegalItems" name="illegalItems" type="text" class="ipt-txt clearall">
                                    </div>
                                </div>
                            </div>
                    	</div>
                    	<div class="form-item clearfix mb10">
                    	<div class="">
                                <label class="item-name col-5">设置人：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input id="illegalItems" name="setUserName" type="text" class="ipt-txt clearall">
                                    </div>
                                </div>
                            </div>
                    	</div>
                    	<div class="form-item clearfix mb10">
                    	<div class="">
                                    <label class="item-name col-4">设置时间：</label>
                                    <div class="col-8">
                                        <div class="ipt-box col-5">
                                            <input name="setTime" readonly="readonly" type="text"
                                                   class="ipt-txt clearall" onclick="laydate();">
                                        </div>
                                    </div>
                                </div>
                    	</div>
                    	<div class="form-item clearfix">
                            <div class="btn-box">
                                <input id="save" type="button" value="保 存" class="btn mr20">
                                <input id="cancel" type="button" value="取 消" class="btn">
                            </div>
                        </div>
                    </div>
                </div>
        	 </form>
 </div> -->


<div class="layder-hd">
    <div class="form-list send-message">
        <form id="sendSearchForm">
            <div class="form-item clearfix">
                <div class="">
                    <label class="item-name col-2">部门：</label>
                    <div class="ipt-box col-9">
                        <input id="departCode" class="ipt-txt clearall" type="hidden"
                               name="deptCode"/>
                        <input id="departName"
                               class="fl ipt-txt clearall" type="text" placeholder="请选择部门" readonly/>
                        <a id="selectRegOrg" class="link js-show">
                            <span class="add-icon" id="codetree"><i></i></span>
                        </a>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2">单位层级：</label>
                <div class="col-9">
                    <div class="ipt-box col-12">
                        <input id="unitLevel" name="unitLevel" type="text" class="ipt-txt clearall">
                    </div>
                </div>

            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2">涉嫌违法事项：</label>
                <div class="col-9">
                    <div class="ipt-box col-12">
                        <input id="illegalItems" name="illegalItems" type="text" class="ipt-txt clearall">
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2">设置人：</label>
                <div class="col-9">
                    <div class="ipt-box col-12">
                        <input id="illegalItems" name="setUserName" type="text" class="ipt-txt clearall">
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2">设置时间：</label>
                <div class="col-3">
                    <div class="ipt-box">
                        <input name="setTime" readonly="readonly" type="text"
                               class="ipt-txt laydate-icon clearall" onclick="laydate();">
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mt10">
                <div class="ml60 center">
                    <input id="save" type="button" value="保 存" class="btn mr20">
                    <input id="cancel" type="button" value="取 消" class="btn">
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    if ("${sysUser.userType}" == "1") {
        window._CONFIG = {
            _urlHead: '/reg/server/illegalitem/',
        }
    } else {
        window._CONFIG = {
            _urlHead: '/syn/illegalitem/',
        }
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sendaffairs/cgcs_illegalitems_add.js"></script>
</body>
</html>