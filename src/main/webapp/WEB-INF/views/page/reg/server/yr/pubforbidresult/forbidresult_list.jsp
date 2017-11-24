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
    <title>敏感词库审核</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
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
        <div class="form-list pdr8">
        	<div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">年报主体：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" name="entTypeCatg" id="entTypeCatg">
                            <input type="checkbox" name="entCatg" checked="checked" value="11,13,31,33,12,14,32,34,21,27,24,22,28">企业
                            <input type="checkbox" name="entCatg" checked="checked" value="16,17">农专社
                            <input type="checkbox" name="entCatg" checked="checked" value="50">个体户
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regOrUniCode" value="" placeholder="可输入尾号后4位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">法定代表人/负责人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="leRep" value=""/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">年报年度：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="year">
                                <option value="">全部</option>
                                <c:forEach items="${yearList}" var="year" varStatus="status">
		                 		<option value="${year}">${year}</option>
		                 		</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                        </div>
                    </div>
                </div>
              <div class="col-4">
                  <label class="item-name col-5">登记机关：</label>
                  <div class="col-7">
                      <div class="ipt-box col-11">
                          <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                          <input type="text" class="ipt-txt" id="regOrgName" value="" readonly="readonly" placeholder="请选择登记机关"/>
                           <span class="add-icon" id="choseorgReg">
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
                            <select name="reportState">
                                <option value="">全部</option>
		                 		<option value="12" selected="selected">待审核</option>
		                 		<option value="11">审核通过</option>
		                 		<option value="13">审核不通过</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">提交日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   name="lastReportTimeStart" readonly="readonly"/
                                   value="${currentYC }-01-01">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   name="lastReportTimeEnd" value="${current }" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" readonly="readonly" placeholder="请选择管辖单位"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
         <div id="hideorshow" style="display: none">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">审核人员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="auditUser" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   name="auditDateStart" readonly="readonly"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   name="auditDateEnd" value="" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">住所：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="dom" value=""/>
                        </div>
                    </div>
                </div>
            </div>
         </div>  
            <div class="form-group clearfix mt10">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                    <input type="button" id="more" value="更多查询条件" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
    <div class="light-info">
    <span class="light">提示： 请自企业提交之日起5个工作日内完成敏感词确认审核。系统对未审核且期限≤1个工作日的企业标注黄色予以提示；未审核已超期的企业标注红色予以提示。
    </span>
</div>
    <div class="mt10">
        <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th>序号</th>
                <th>操作</th>
                <th>年报年度</th>
                <th>统一代码/注册号</th>
                <th>企业名称</th>
                <th>法定代表人/负责人</th>
                <th>企业类型</th>
                <th>提交日期</th>
                <th>状态</th>
                <th>审核日期</th>
                <th>审核人员</th>
                <th>住所</th>
                <th>登记机关</th>
                <th>管辖单位</th>
            </tr>
            </thead>
        </table>
    </div>
    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script src="/js/reg/server/yr/pubforbidresult/list_main.js"></script>
</div>
</body>
</html>
