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
    <title>信用查证状况列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box pd14-mr"> 
         <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">查证类别：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                             <input type="checkbox" name="proveTypeStr" checked="checked" value="1">企业信用查证
                             <input type="checkbox" name="proveTypeStr"  checked="checked"  value="2">个人信用查证
                             <input type="hidden" name="proveType"  id="proveType"  value="1,2">
                             <input type="hidden" name="searchFlag"  id="searchFlag"  value="0">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">证照/证件号码：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <input type="text" class="ipt-txt" name="cidRegNO" value="" placeholder="可输入尾号后4位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">出查证部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="setDept" value="" placeholder="请输入出证部门"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">查证日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                             <div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="startInfaustlDate"
	                                   id="startInfaustlDate" value=""/>
	
		                        </div>
		                        <span class="item-line col-05">-</span>
		                        <div class="ipt-box col-575">
		                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="endInfaustlDate"
		                                   id="endInfaustlDate" value=""/>
		
		                        </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称/姓名：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                         <input type="text" class="ipt-txt" name="cname" value="" placeholder="可输入关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">查证人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="setName" value="" placeholder="请输入查证人"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">查证单编号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <input type="text" class="ipt-txt" name="proveNo" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                               
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> </label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                          
                        </div>
                    </div>
                </div>
            </div>
              
            <div class="center mt10">
            <input type="button" id="search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
       		</div>
        </div>
    </form>
    <div class="clearfix mb5 mt5">
        <p class="fl"><input type="button" id="add" class="btn btn-sm mr5" value="添加信用状况出证"></p>
    </div>
    <div class="light-info mt5">
        <span class="light">提示：查询结果默认显示本部门已有的信用查证记录信息。
    </div>
    <div class="tip-info left">
	    查询结果：出证查询共<label id="proveInfoCount" class="light-blue">0</label>单，
	    查证企业信用<label id="entCount" class="light-blue">0</label>户，
	    查证个人信用<label id="manCount" class="light-blue">0</label>名。
	</div>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="pubopanomalylist_table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
	                        <th>操作</th>
	                        <th>证照/证件号码</th>
	                        <th>企业名称/姓名</th>
	                        <th>查证主体</th>
	                        <th>查证时间</th>
	                        <th>查证单编号</th>
	                        <th>查证人</th>
	                        <th>查证部门</th>
	                        <th>打印计次</th> 
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script>
    window._CONFIG = { 
       _sysUrl:'${sysUrl}'
    }
	</script>
    <script src="/js/syn/system/creditprove/creditprovesearch_list_main.js"></script>
</body>
</html>