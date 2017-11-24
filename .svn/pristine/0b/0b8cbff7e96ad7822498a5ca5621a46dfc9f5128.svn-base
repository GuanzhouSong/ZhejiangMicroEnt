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
    <title>标记异常状态申请列表页面</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<form id="taskForm">
<input type="hidden" id="rocode" value="${codeRegorg.code }">
<input type="hidden" id="rocontent" value="${codeRegorg.content }">
    <div class="form-box pdr8">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regNO" value="" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            	<input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value="${codeRegorg.code }"/>
                            <input type="text" readonly="readonly" class="ipt-txt" name="regOrgName" id="regOrgName" value="${codeRegorg.content }"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
	            <div class="col-4">
                    <label class="item-name col-5">标记异常原因：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="hidden_input" name="excpStaRes" id="excpStaRes" value=""/>
                            <input type="text" class="ipt-txt text-over" value="" placeholder="请选择标记原因" id="excpStaResText" readonly="readonly"/>
                            <span class="add-icon" id="select-intercept-in">
                                <i></i>
                            </span> 
                        </div> 
                      </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">经营者：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="hidden_input" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" readonly="readonly"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">状态：</label>
                    <div class="col-7">
                         <div class="ipt-box col-11">
                            <select name="auditState">
                                <option value="">全部</option>
                                <option value="0">待审核</option>
                                <option value="1">予以标记异常</option>
                                <option value="2">不予标记异常</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">标记日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon pointer" readonly="readonly"
                                   name="startCogDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon pointer" readonly="readonly"
                                   name="endCogDate" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">初审人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="firstName" value=""/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="center mt10">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="reset" id="reset" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </div>
</form>
<div class="iframe-wrap mt10">
	<input type="button" id="add" value="新增标记异常记录" class="btn mr20">
    <div class="light-info mb5 mt5">
        <p class="light">提示：查询范围为当前时点本局登记的在册个体工商户。对未按时年报情形的经营异常状态标记无需人工设置，由系统自动处理。申请信息审核后可打印“经营异常名录审批表”，予以标记异常信息将自动公示于公示系统。 </p>
    </div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
           style="width: 100%;white-space: nowrap;" cellspacing="0">
        <thead>
        <tr>
            <th style="padding:0 20px;">序号</th>
            <th>操作</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>经营者</th>
            <th>状态</th>
            <th>标记异常原因</th>
            <th>标记日期</th>
            <th>决定机关</th>
            <th>初审人</th>
            <th>初审日期</th>
            <th>审核人</th>
            <th>审核日期</th>
            <th>登记机关</th>
            <th>管辖单位</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value='/js/reg/server/opanomaly/pbopanomaly/pbopanomalyapp_list.js'/>"></script>
</body>
</html>
