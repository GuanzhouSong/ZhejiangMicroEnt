<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>异议受理反馈</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box pd14-mr">
         <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一代码/注册号：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="searchFlag" value="2" >
                            <input type="text" class="ipt-txt" name="uniCode_regNO" value="" placeholder="统一信用代码/注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">标题：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="consultTitle" value="" placeholder="请输入标题"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value="" placeholder="请选择登记机关" readonly="readonly"/>
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="请选择管辖单位" readonly="readonly"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">异议内容：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="consultContent" value="" placeholder="请输入异议内容"/>
                        </div>
                    </div>
                </div>
            </div> 
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">反馈人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="backName" value="" placeholder="请输入反馈人"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">反馈日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="startBackTime"
                                   id="startBackTime" value=""/>

                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="endBackTime"
                                   id="endBackTime" value=""/>

                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">反馈状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="state">
                                <option value="">全部</option>
                                <option value="0">未反馈</option>
                                <option value="1">已反馈</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <!-- <div class="col-4">
                   	<label class="item-name col-5">咨询人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="consultName" value="" placeholder="请输入咨询人"/>
                        </div>
                    </div>
                </div> -->
                <div class="col-4"> 
                    <label class="item-name col-5">申请日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   name="startConsultTime" id="startConsultTime" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   name="endConsultTime" id="endConsultTime" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    
                </div>
            </div> 
            <div class="center mt10">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>

     
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="pubopanomalylist_table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
                            <th>操作</th>
                            <th>反馈状态</th>
                            <th>统一代码</th>
                            <th>注册号</th>
                            <th>企业名称</th>
                            <th>登记机关</th>
                            <th>管辖单位</th>
                            <th>标题</th>
                           <!--  <th>咨询人</th> -->
                            <th>异议内容</th> 
                            <th>申请日期</th>
                            <th>反馈人</th>
                            <th>反馈内容</th>
                            <th>反馈日期</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script>
    window._CONFIG = {
       chooseUrl: "/reg"
    }
    </script>
    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script src="<c:url value="/js/reg/server/consult/consult_list_main.js"/>"></script>
</body>
</html>