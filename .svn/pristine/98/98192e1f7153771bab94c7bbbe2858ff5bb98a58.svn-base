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
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>党建活动查询</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<form id="taskForm">
    <div class="form-box">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">活动名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="activityName" placeholder="可输入关键词查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">所在党组织：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="claimDeptUID" id="specialCode" />
                            <input type="text" readonly="readonly" class="ipt-txt" name="claimDeptName" id="specialName" />
                            <span class="add-icon" id="choseSpecial"><i></i></span>
                        </div>                        
                    </div>
                </div>
             <div class="col-4">
                <label class="item-name col-5">管辖单位：</label>
                	<div class="col-7">
                    	<div class="ipt-box col-12">
                        	<input type="hidden" class="hidden_input" name="claimLocalAdm" id="localAdm" value=""/>
                        <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="选择"  readonly="readonly"/>
                        <span class="add-icon" id="choseregUnit">
                            <i></i>
                        </span>
                    	</div>
                	</div>
            </div>  
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">活动类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="activityType">
                                <option value="">全部</option>
                                <option value="1">重点常规活动</option>
                                <option value="2">党员日常活动</option>
                            </select>
                        </div>
                    </div>
                </div>
	             <div class="col-4">
	                <label class="item-name col-5">活动地点：</label>
	                <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="activityPlace">
                        </div>
	                </div>
	            </div> 	            
                <div class="col-4">
                    <label class="item-name col-5">发起人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="originator">
                        </div>
                    </div>
                </div>                             
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">活动人数：</label>
                    <div class="col-7">
 	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt"  name="joinNumStart" id="joinNumStart" value="" />
	                    </div>
	                    <span class="item-line col-05">-</span>
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt" name="joinNumEnd" id="joinNumEnd" value="" />
	                    </div>
                    </div>
                </div>
	             <div class="col-4">
	                <label class="item-name col-5">活动日期：</label>
	                <div class="col-7">
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon"  name="activitybeginDate" id="activitybeginDate" value="" readonly="readonly" onclick="laydate();"/>
	                    </div>
	                    <span class="item-line col-05">-</span>
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon" name="activityEndDate" id="activityEndDate" value="" readonly="readonly" onclick="laydate();"/>
	                    </div>
	                </div>
	            </div> 
                <div class="col-4">
                    <label class="item-name col-5">参与人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">  
                            <input type="hidden" class="ipt-txt" name="joinerIds" id="joinerId"/>
                            <input type="text" class="ipt-txt" id="joiner" readonly="readonly">
                            <span class="add-icon" id="chosejoiner"><i></i></span>
                        </div>
                    </div>
                </div>                             
            </div>
            <div class="more-show " style="display:none;">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">活动发布部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="publishDeptUID" id="publishDeptUID" />
                            <input type="text" readonly="readonly" class="ipt-txt" name="publishDeptName" id="publishDeptName" />
                            <span class="add-icon" id="chosePublishDept"><i></i></span>
                        </div>                        
                    </div>
                </div>
	             <div class="col-4">
	                <label class="item-name col-5">要求活动结束日期：</label>
	                <div class="col-7">
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon"  name="startRequireEndDate" id="startRequireEndDate" value="" readonly="readonly" onclick="laydate();"/>
	                    </div>
	                    <span class="item-line col-05">-</span>
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon" name="endRequireEndDate" id="endRequireEndDate" value="" readonly="readonly" onclick="laydate();"/>
	                    </div>
	                </div>
	            </div> 
                <div class="col-4">
	                <label class="item-name col-5">发布日期：</label>
	                <div class="col-7">
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon"  name="startPublishDate" id="publishStartDate" value="" readonly="readonly" onclick="laydate();"/>
	                    </div>
	                    <span class="item-line col-05">-</span>
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon" name="endPublishDate" id="publishEndDate" value="" readonly="readonly" onclick="laydate();"/>
	                    </div>
	                </div>
                </div>                             
            </div>
            </div>
            <div class="center mt10">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="reset" id="reset" value="重 置" class="btn mr20">
                 	<input type="button" value="更多查询" class="btn mr20 js-more-query">
                </div>
            </div>
        </div>
    </div>
</form>

<div class="light-info mb5">
    <span class="light">提示：仅查询已录入结果的党建活动信息。</span>
</div>
<div class="tip-info left" style="padding-left: 20px;">
 <span class="light-blue"> 查询结果：</span>活动共<label id="activityNum" class="light-blue">0</label>个，
    参与人数<label id="joinerNum" class="light-blue">0</label>人。
</div>

<table id="user_table" border="0" cellspacing="0" cellpadding="0" class="table-row" style="width: 100%;white-space: nowrap;">
    <thead>
    <tr>
        <th style="padding:0 20px;">序号</th>
        <th>操作</th>
        <th>活动类别</th>
        <th>活动名称</th>
        <th>参与人数</th>
        <th>活动开始日期</th>
        <th>活动结束日期</th>
        <th>活动地点</th>
        <th>活动所在党组织</th>
        <th>管辖单位</th>
        <th>发起人</th>
        <th>参与人</th>
        <th>活动发布部门</th>
        <th>发布日期</th>
        <th>要求活动结束日期</th>
    </tr>
    </thead>
</table>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/partycreate/partactivity/activitysearch_list.js"/>"></script>
</body>
</html>
