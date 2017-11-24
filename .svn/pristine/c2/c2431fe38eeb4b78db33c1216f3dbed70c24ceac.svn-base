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
    <title>部门公示信息统计</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
            	<div class="col-7">
                    <label class="item-name col-2">公示主体：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="radio" name="entTypeCatgCode" checked="checked" value="00" id="qy"/>企业
							（<input type="checkbox" name="entCatgCode" value="11,12,13,14,31,32,33,34,"  checked="checked"/>内资企业
                            <input type="checkbox" name="entCatgCode" value="21,22,24,27,28,"  checked="checked"/>外资企业）
                            <input type="radio" name="entTypeCatgCode" value="16,17" id="nz"/>农专社
                            <input type="radio" name="entTypeCatgCode" value="50" id="gt"/>个体户
                        </div>
                        <input type="hidden" name="entTypeCatg" id="entTypeCatg" value="11,12,13,14,31,32,33,34,21,22,24,27,28" />
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">统计范围：</label>
                    <div class="col-5">
                        <div class="ipt-box col-12">
                            <select name="statArea" id="statArea" multiple="multiple">
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-7">
                    <label class="item-name col-2">统计日期：</label>
                     <div class="ipt-box col-2">
                           <select name="rptyear" id="rptyear">
                           </select>
                    </div>
                    <div class="ipt-box col-2 mr-col-005">
                           <select name="rptmonth" id="rptmonth">
                           <option value="00" id="00">当前</option>
                           <option value="01" class="rm">1月</option>
                           <option value="02" class="rm">2月</option>
                           <option value="03" class="rm">3月</option>
                           <option value="04" class="rm">4月</option>
                           <option value="05" class="rm">5月</option>
                           <option value="06" class="rm">6月</option>
                           <option value="07" class="rm">7月</option>
                           <option value="08" class="rm">8月</option>
                           <option value="09" class="rm">9月</option>
                           <option value="10">10月</option>
                           <option value="11">11月</option>
                           <option value="12">12月</option>
                           </select>
                    </div>
                     <div class="ipt-box col-4">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"  
                              name="endCheckPushDate" id="endCheckPushDate" value="${endCheckPushDate}"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">统计层级：</label>
                    <div class="col-5">
                        <div class="ipt-box col-12">
                            <select name="statLevel" id="statLevel">
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel == 4 }"><option value="area">按地区</option></c:if>
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel != 1 }"><option value="regOrg">按登记机关</option></c:if>
                                <option value="localAdm">按管辖单位</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>    
       </div>
        <div class="center mt10">
            <input type="button" id="search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
        </div>
    </form>
</div>

    <div class="light-info mt10">
         <p class="light">数据说明：公示主体户数=各类登记状态户数（存续+吊销未注销+撤销+迁出+注销）</p>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
                <th rowspan="3" style="padding:0 20px;">行次</th>
	            <th rowspan="3">地区</th>
	            <th rowspan="3" style="padding:0 40px;">部门</th>
	            <th rowspan="2">公示主体</th> 
	            <th colspan="5">登记状态</th>
	            <th rowspan="2" colspan="2">登记备案</th>
	            <th rowspan="2" colspan="2">动产抵押</th>
	            <th rowspan="2" colspan="2">股权出质</th> 
	            <th rowspan="2" colspan="2">知识产权出质</th> 
	            <th rowspan="2" colspan="2">商标注册</th> 
	            <th rowspan="2" colspan="2">抽查检查</th> 
	            <th rowspan="2" colspan="2">司法协助</th> 
	            <th rowspan="2" colspan="2">行政许可</th> 
	            <th rowspan="2" colspan="2">行政处罚</th> 
	            <th rowspan="2" colspan="2">异常名录</th>
	            <th rowspan="2" colspan="2">严重违法失信</th>
	            <th rowspan="2" colspan="2">简易注销</th>
                </tr>
                <tr> 
	            <th>存续</th>
	            <th>吊销</th>
	            <th>撤销</th>
	            <th>迁出</th>
	            <th>注销</th>
                </tr>
                <tr>
	            <th>户数</th>
	            <th>户数</th>
	            <th>户数</th>
	            <th>户数</th>
	            <th>户数</th>
	            <th>户数</th>
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th> 
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th> 
	            <th>户数</th>
	            <th>条数</th> 
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th> 
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th>
                </tr>
                </thead>
                <tfoot>
	        <tr>
	            <th>合计</th>
	            <th>-</th>
	            <th>-</th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	        </tr> 
	        </tfoot>
            </table>
        </div>
    </div>
<script>
    window._CONFIG = {
       year:'${year}',
       deptCode:'${deptCode}',
       endCheckPushDate:'${endCheckPushDate}',
       month:'${month}',
       _searchRangeLevel:'${sysUser.searchRangeLevel}',
       _isAdmin:'${sysUser.isAdmin}' 
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/rpt/deptpubinforpt_list.js"></script>
</body>
</html>
