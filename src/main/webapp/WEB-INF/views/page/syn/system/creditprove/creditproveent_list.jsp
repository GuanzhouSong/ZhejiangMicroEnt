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
    <title>企业名单</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<style type="text/css">
    .commit {
        text-decoration: none;
        color: #003399;
        cursor: pointer;
        font-size: 13px;
    }
</style>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <input type="hidden"  id="searchTypeStr" name="searchTypeStr" value="" >
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="uniCode_regNO" id="uniCode_regNO" value="" placeholder="可输入尾号后四位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">名称/字号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" id="entName"  name="entName" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">法定代表人/负责人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="leRep" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">筛选范围：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                             <input type="checkbox" name="searchType"   value="1">含分支机构
                             <input type="checkbox" name="searchType"   value="2">含关联企业（同一负责人/高管）
                             <input type="checkbox" name="searchType"   value="3">含关联企业（企业投资人）
                             <input type="checkbox" name="searchType"   value="4">含关联企业（企业对外投资）
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select  class="clx_one" multiple="multiple" id="regState" name="regState">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </div> 
        <div class="form-group clearfix">
            <div class="center mt10">
                <input type="button" id="search" value="查询" class="btn mr20">
                <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
            </div>
        </div>
    </form>
</div>
 
 
 <div class="mod-border investment-info js-content-show js-upload mt10" id="loadFile" style="display:none;">
    <div class="forguarantee-lead">
        <h6 class="download" style="text-align: left;">
            <a  href="<c:url value="${sysUrl}/creditprovelist/downLoadEnt"/>"><b class="download-ico"></b>下载本站EXCEL模版</a>
        </h6>
        <div class="state pos-rel">
            <span>说明：</span>
            <p>1、导入数据时请先下载EXCEL导入模版；</p>
            <p>2、下载导入模板后请按照导入模板格式和内容要求完成导入信息的填录；</p>
            <p>3、使用非本系统提供的导入模板或擅自修改导入模板的格式和内容会导致操作不成功。</p>
        </div>
        <div class="lead-file">
            <label>导入EXCEL文件</label>
            <form id="file_import" enctype="multipart/form-data" method="post">
                <div class="ipt-box">
                    <input type="file" id="js-file" name="file"  class="ipt-txt ipt-txt-lg">
                </div>
                <input type="button" class="btn mt10 js-import" value="导入">
            </form>
        </div>
    </div>
    <div style="text-align: center;"><input type="button" class="btn btnCancel"  value="关闭"></div>
</div>
 
 

<div class="iframe-wrap">
    <button type="button" id="comparBtn" class="btn btn-primary mt5">信用查证比对</button>
    <button type="button" id="importExcel" class="btn btn-primary mt5">导入名单</button>
    <button type="button" id="deleteBtn" class="btn btn-primary mt5">删除名单</button>
    <button type="button" id="addBtn" class="btn btn-primary mt5">新增名单</button>
    <button type="button" id="entRebackBtn" class="btn btn-primary mt5">返回查证列表</button>
    <div class="light-info mb5 mt5">
        <span class="light">
                        提示：1、增减单个查证名单请使用“添加名单”和“删除名单”功能，批量添加请使用“导入名单”功能。
            2、选择筛选范围时需输入完整的统一信用代码/注册号或名称/字号。
        </span>
    </div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
        <thead>
        <tr>
            <th style="padding:0 20px;">序号</th>
            <th>全选 <input type="checkbox" id="checkAll"></th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人/负责人</th>
            <th>登记机关</th>
            <th>管辖单位</th>
            <th>登记状态</th> 
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script>
    window._CONFIG = {
    		url:'${sysUrl}'
    }
</script>
<script src="/js/syn/system/creditprove/creditproveent_list_main.js"></script>
</body>
</html>
