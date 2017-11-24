<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>任职资格限制提前解除</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <div class="tab-content">
        <div class="tab-panel tab-panel-show">
       	<form id="searchForm" class="searchForm">
            <div class="form-box">
                <div class="form-list">
                    <div class="form-item clearfix">
                        <div class="col-4">
                            <label class="item-name col-5">限制类别：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                    <select name="limitType">
                                    	<option value="">不限</option>
                                        <option value="0">吊销企业</option>
                                        <option value="1">失信被执行人</option>
                                        <option value="2">刑事责任司法判决</option>
                                        <option value="3">失信惩戒黑名单</option>
                                        <option value="4">工商严重违法失信</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">当事人名称：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                 	<input name="clientName" type="text" class="ipt-txt">
                                </div>
                            </div>
                        </div>
                         <div class="col-4">
                             <label class="item-name col-3">限制期限：</label>
                            <div class="col-9">
                                <div class="ipt-box col-5">
                                    <input name="limitDateStart" type="text" class="ipt-txt laydate-icon" onclick="laydate();" readonly />
                                </div>
                                <span class="item-txt">至</span>
                                <div class="ipt-box col-5">
                                    <input name="limitDateEnd" type="text" class="ipt-txt laydate-icon" onclick="laydate();" readonly />
                                </div>
                            </div>
                            </div>
                        </div>
                    <div class="form-item clearfix">
                        <div class="col-4">
                            <label class="item-name col-5">当事人证件类型：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                   <select id="certType" name="certType" >
                                   		<option value="">不限</option>
				                		<option value="0">营业执照</option>
				                		<option value="1">居民身份证</option>
				                		<option value="2">军官证</option>
				                		<option value="3">警官证</option>
				                		<option value="4">外国(地区)护照</option>
				                		<option value="5">香港身份证</option>
				                		<option value="6">澳门身份证</option>
				                		<option value="7">台湾身份证</option>
				                		<option value="8">其他有效身份证件</option>
				                   </select>
                                    
                                </div>
                            </div>

                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">当事人证件号：</label>
                            <div class="col-7">
                                <div class="ipt-box col-8">
                                    <input name="certNO" type="text" class="ipt-txt">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mt10">
                        <div class="btn-box">
                            <input id="qua-search" type="button" value="查 询" class="btn mr20">
                            <input id="reset" type="reset" value="重 置" class="btn">
                        </div>
                    </div>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>

<div >

<div class="clearfix mb5 mt5">
    <p class="fl"><input id="limitremove" type="button" class="btn btn-sm mr5" value="提前解除限制"/></p>
</div>

<div id="aheadremove" style="display: none;" class='pd20'>
<form id="ahead_form" >
	<h3 class='h3-title2 light-blue mb10'>提前解除限制</h3>
	<label class='mr5 ml10'>限制解除日期</label><input id="endtime" name="limitDateEnd" type="text" class="ipt-txt laydate-icon needclear" onclick="laydate();">
	<input id="uid" type="hidden" name="uid" class="needclear">
	<div class="form-item clearfix mt20">
                        <div class="btn-box">
                            <input id="save" type="button" value="保  存" class="btn mr20">
                            <input id="cancle" type="button" value="关  闭" class="btn">
                        </div>
                    </div>
                    </form>
</div>

<div class="table-out">
<div class="iframe-wrap">
    <table id="qua-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="white-space: nowrap;width: 100%;">
        <thead><tr>
            <th width="5%">序号</th>
            <th>选择 </th>
            <th>当事人名称</th>
            <th>当事人证件类型</th>
            <th>当事人证件号</th>
            <th>限制类别</th>
            <th>限制开始日期</th>
            <th>限制结束日期</th>
            <th>最近修改日期</th>
            <th>最近修改人</th>
        </tr>
        </thead>
     </table>
</div>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registmanage/qualifiedmanage/qualifiedlimitremove.js"></script>
</body>
</html>