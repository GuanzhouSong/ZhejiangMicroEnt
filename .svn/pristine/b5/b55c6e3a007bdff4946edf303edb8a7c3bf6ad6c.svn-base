<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>详细信息</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
</head>
<style type="text/css">
.gold{background-color: #fff4df;}
</style>
<body class="pd10">
<form id="hx-form">
    <input type="hidden" id="priPID" name="priPID" value="${priPID}">
    <input type="hidden" id="markCodes" name="markCodes">
    <input type="hidden" id="markNames" name="markNames">
		<div class="page-content clear">
        <div class="col-4 border-box" style="border-right: 1px solid #CCC; min-height: 500px">
            <div>
            	<div class="ipt-box col-7">
					<input class="ipt-txt clx" id="idname" title="输入小类标签名称" placeholder="输入小类标签名称">
				</div>
				<input type="button" class="tree-box-searcher-btn btn" id="tree-box-searcher" value="检索">
                <ul id="ycCodeLicenseTree" class="ztree" style="width:100%;max-height:80%;overflow-y: auto"></ul>
            </div>
        </div>
        <div class="col-8 border-box pdl15">
            <table class="table table-horizontal ">
                <tbody id="showArea">
                </tbody>
            </table>
            <p class="center mt10 mb10">
				<input type="button" id="save" class="btn mr20" value="保存" /> <input type="button" class="btn" value="取 消" id="cancel" />
			</p>
        </div>
    </div>

		

</form>
<script id="viewTemplate" type="text/x-handlebars-template">
    <tr>
                <tr>
                    <td class="right bg-gray"  width="18%">标签名称：</td>
                    <td class="left">{{idname}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">有效期至：</td>
                    <td class="left">{{validDateFormat validDate}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">适用范围：</td>
                    <td class="left">{{applicationScopeName}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">对应的双随机检查事项：</td>
                    <td class="left">{{doublyStoStateFormat doublyStoState doublyStoFirName doublyStoSecName doublyStoThiName}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">备注说明：</td>
                    <td class="left">{{iddesc}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">创建日期：</td>
                    <td class="left">{{createTime}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">最近修改日期：</td>
                    <td class="left">{{updateTime}}</td>
                </tr>
 				<tr>
                    <td class="right bg-gray">申请人：</td>
                    <td class="left"><input type="text" name="setName" readonly="readonly" class="ipt-txt"  value="${null == markUuid || '' eq markUuid?sysUser.realName:mainMarkDto.setName}" style="border: 0"/></td>
                </tr>
</script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/mainmark_edit.js"></script>
</body>
</html>
