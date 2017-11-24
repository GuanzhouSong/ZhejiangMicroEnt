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
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>个体户接收列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">

    <form id="taskForm">
        <div class="form-box">
            <div class="form-list">
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">年度：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <select name="yrYear" id="year">   
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">统一代码/注册号：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="cidRegNO">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">个体户名称：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="entName">
                            </div>
                       </div>
                    </div>
                </div>
                  <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">状态：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <select name="yrRepModeGT" id="yrRepMode">   
                                 <option value="">全部</option>
                                 <option value="400" selected="selected">待接收</option>
                                 <option value="6">已接收</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">经营者：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="leRep">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">接收人：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="acceptName">
                            </div>
                        </div>
                    </div>
                </div>
                  <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">接收部门：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="acceptDept">
                            </div>
                        </div>
                    </div>
	            <div class="col-4">
	                <label class="item-name col-5">接收日期：</label>
	                <div class="col-7">
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon"  name="acceptDateStart" id="startCogDate" value="" readonly="readonly"/>
	                    </div>
	                    <span class="item-line col-05">-</span>
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon" name="acceptDateEnd" id="endCogDate" value="" readonly="readonly"/>
	                    </div>
	                </div>
	            </div>
                </div>
                
                <input type="hidden" name="repTypeNotIn" value="Y">
                
                <div class="form-item">
                    <div class="btn-box mt10">
                        <input type="button" id="search" value="查 询" class="btn mr20">
                        <input type="button" id="cancel" value="重 置" class="btn" onclick="$('#taskForm')[0].reset();">
                    </div>
                </div>
            </div>
        </div>
    </form>

    <div class="light-info mt10">
        <span class="light">提示：报告书当面送达的，可选择是否打印收讫通知书交企业备存；邮寄方式送达的，可选择是否发送短信方式通知个体户经营者。同一个年度只能电子年报或纸质年报一种方式。纸质年报接收范围仅限未被系统锁定为电子年报的应年报在册个体户。</span>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
                    <th style="padding:0 20px;">序号</th>
                    <th>操作</th>
                    <th >统一社会信用代码/注册号</th>
                    <th >企业名称</th>
                    <th >经营者</th>
                    <th >经营者手机</th>
                    <th >接收日期</th>
                    <th >接收人</th>
                    <th >接收部门</th>
                    <th >住所</th>
                    <th >登记机关</th>
                    <th>管辖单位</th>
                    <th>片区</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
    <div class="layder-bd" id="send-message-layer" style="display: none;">
        <div class="send-message">
            <p>
                系统即将发送短信至该个体户经营者：<br />
                注册号为<span id="regNo"></span>的个体户，于<span id="sendDate"></span>完成<span id="sendYear"></span>年度报告报送。<br />
                请确定是否要发送此短信？
            </p>
            <div class="ml60">
                <input type="button" class="btn btn-sm mr10" value="确定" id="send">
                <input type="button" class="btn btn-sm" value="取消" id="cancel">
            </div>
        </div>
    </div>
<script>
    window._CONFIG = {
       year:'${year}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/pbreceive/pbreceive_list.js"></script>
</body>
</html>
