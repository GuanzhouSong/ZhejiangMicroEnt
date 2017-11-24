<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>新增群发短信</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
    	<input type='hidden' value='K,B,A,DA,X' name='regState'>
        <div class="form-list pdr8">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">年报主体：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="radio" name="entTypeCatg" checked="checked" value="11,13,31,33,12,14,32,34,21,27,24,22,28">企业
                            <input type="radio" name="entTypeCatg" value="16,17">农专社
                            <input type="radio" name="entTypeCatg" value="50">个体户
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cidRegNO" value="" placeholder="可输入尾号后4位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="regOrgName" value="" />
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
	                    <label class="item-name col-5">企业类型：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                        	<input type="hidden" class="ipt-txt" name="entType" id="entType" value=""/>
	                            <input type="text" readonly="readonly" class="ipt-txt" id="entTypeName" value="" />
		                         <span class="add-icon" id="chooseEntType">
	                                <i></i>
		                         </span>
	                        </div>
	                    </div>
	             </div>
            	
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="localAdmName" value="" />
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
	            <div class="col-4">
                    <label class="item-name col-5">年度年报与状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                        	<input type="hidden" class="ipt-txt" name="yearMode" id="yearMode" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="yearModeName" value="" />
	                         <span class="add-icon" id="chooseYearMode">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">成立日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="estDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly"
                                   name="estDateEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">片区/商圈：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNo" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="sliceNoName" value="" />
	                         <span class="add-icon" id="chooseSliceNo">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5"><span class="long-label">列入经营异常：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select id="isOpan" name="isOpan">
                                <option value="">全部</option>
                                <option value="Y">是</option>
                                <option value="N">否</option>
                            </select>
                        </div>
                    </div>
	            </div>
	            <div class="col-4">
                    <label class="item-name col-5">${year }年报日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="yrFirRepTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="yrFirRepTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
            </div>
       </div>
        <div class="center mt10">
            <input type="button" id="js-search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
        </div>
    </form>
</div>


<div>
	<!-- <input type="button" id="selectAll" value="点击选择全部" class="btn mr20"> -->
	<input type="button" id="smsGroupSend" value="短信群发" class="btn mr20">
	<input type="button" id="return" value="返回" class="btn mr20">
</div>

<div style="display: none">
	<form action="/reg/server/smstaskinfo/smsShow" method="post" name="form1">
		<input type="hidden" name="params" id="params">
	</form>
	<form action="/syn/panoramasearch/smsQueryPageAll" method="post" name="form2">
		<input type="hidden" name="map" id="map">
	</form>
</div>
<div class="tab-content mb20 mt10">
    <div class="tab-panel tab-panel-show">
        <div class="">
            <div class="table-out">
                <table id="user-table" border="0" cellspacing="0" cellpadding="0"
                       class="table-row display nowrap">
                    <thead>
	                    <tr>
	                        <th>序号</th>
	                        <th>全选<input type="checkbox" id="checkAll"></th>
	                        <th>统一代码/注册号</th>
	                        <th>企业名称</th>
	                        <th>成立日期</th>
	                        <th>企业类型</th>
	                        <th>负责人</th>
	                        <th>联系电话</th>
	                        <th>联络员</th>
	                        <th>联络员手机</th>
	                        <th>登记机关</th>
	                        <th>管辖单位</th>
	                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/smsgroupsend/addsmsgroup.js"></script>
</body>
</html>
