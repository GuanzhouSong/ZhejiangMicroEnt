<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!doctype html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>行政许可归集查询</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" placeholder="可输入名称关键词查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">许可文件编号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="licNO" placeholder="可输入编号关键词查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">许可文件名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="licNameCN" placeholder="可输入名称关键词查询">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
               <div class="col-4">
                    <label class="item-name col-5">是否记名：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="pubFlag">
                            	<option value="">全部</option>
                            	<option value="1">是</option>
                            	<option value="0">否</option>
                            </select>
                        </div>
                    </div>
                </div>
               <div class="col-4">
                    <label class="item-name col-5">许可有效时间自：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="licValFromStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="licValFromEnd"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">许可机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="licAnth" placeholder="可输入关键词查询">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
               <div class="col-4">
                    <label class="item-name col-5">许可内容：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="licScope" placeholder="可输入关键词查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">许可有效时间至：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="licValToStart" onclick="laydate()"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="licValToEnd"/>
                        </div>
                    </div>
               </div>
            </div>
        </div>
        <div class="mt10">
            <div class="center">
                <input type="button" value="查 询" id="search" class="btn mr20">
                <input type="button" value="重 置" id="cancel" class="btn mr20" onclick="$('#taskForm')[0].reset();">
            </div>
        </div>
    </form>
	<p class="tip-info left mb5">查询结果：
            共采集行政许可机关<span id="anthTotal"class="light-blue">0</span>个,
            记录<span id="allTotal"class="light-blue">0</span>条；
             经与市场主体比对记于名下机关<span id="compareTotal"class="light-blue">0</span>个,
             记录<span id="regTotal"class="light-blue">0</span>条。
            
    </p>
    <div class="mt10">
        <div class="iframe-wrap">
            <table id="permit-table" class="table-row display nowrap" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>企业名称</th>
                    <th>许可证名称</th>
                    <th>许可证编号</th>
                    <th>许可内容</th>
                    <th>有效期始</th>
                    <th>有效期至</th>
                    <th>许可证机关</th>
                    <th>是否记名</th>
                    <th>状态</th>
                </tr>
                </thead>
            </table>
        </div>
  </div>
  </div>
        <script src="/js/lib/require.js"></script>
        <script src="/js/config.js"></script>
        <script src="/js/reg/server/other/pubotherlicencegov/pubotherlicencegov_list_main.js"></script>
</body>
</html>
