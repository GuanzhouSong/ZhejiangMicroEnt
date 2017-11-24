<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>涉嫌违法事项维护</title>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="h4-title"><span>涉嫌违法事项维护表</span></div>
<div class="tabbale" data-component="tab">
    <div class="tab-content">
        <div class="tab-panel tab-panel-show">
            <form id="sendSearchForm" class="searchForm">
                <div class="form-box mb5">
                    <div class="form-list">
                        <div class="form-item clearfix mb10">
                            <div class="col-4">
                                <label class="item-name col-5">部门：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
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
                            <div class="col-4">
                                <label class="item-name col-5">涉嫌违法事项：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input id="illegalItems" name="illegalItems" type="text" class="ipt-txt clearall">
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-item clearfix">
                            <div class="btn-box">
                                <input id="send-search" type="button" value="查 询" class="btn mr20">
                                <input id="reset" type="button" value="重 置" class="btn">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="clearfix mb5">
<p class="fl"><input id="add" type="button" class="btn btn-sm mr5" value="新建"/></p>
</div>
<div class="table-out">
    <div class="iframe-wrap">
        <table id="cgcs-illegalitems-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
            <thead>
            <tr>
                <th width="3%">序号</th>
                <th width="7%">操作</th>
                <th width="7%">单位层级</th>
                <!-- <th width="5%">单位</th> -->
                <th width="5%">部门</th>
                <th width="20%">涉嫌违法事项</th>
                <th width="10%">设置人</th>
                <th width="10%">设置时间</th>
            </tr>
            </thead>
        </table>
    </div>
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
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/copysend/cgcs_illegalitems_weihu.js"></script>
</body>
</html>