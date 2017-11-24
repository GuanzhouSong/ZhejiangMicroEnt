<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>综合抽查实施准备列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
    <div class="pd10 bg-gray" style="margin-top: 10px;">
       <div class="form-list pdr10">
           <form id="taskForm" class="form-box mb5">
           <input type="hidden" name="checkResult" id="checkResult">
           	  <div class="form-item clearfix">
                 <div class="col-4">
                    <label class="item-name col-4">任务名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                        	<input type="text" name="taskName" class="ipt-txt" value="" />
                        </div>
                    </div>
	             </div>
                 <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cidRegNO" value="">
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
	                    <label class="item-name col-4">任务编号：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <input type="text" class="ipt-txt" name="taskCode" value=""/>
	                        </div>
	                    </div>
	                </div>
	            	<div class="col-4">
	                    <div class="item-name col-5">企业名称：</div>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                            <input type="text" name="entName" class="ipt-txt" value="" />
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
	                    <label class="item-name col-4">检查表状态：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <select name="checkTableFlag">
	                                <option value="">全部</option>
	                                <option value="0">未设置</option>
	                                <option value="1">已设置</option>
	                            </select>
	                        </div>
	                    </div>
	                </div>
                 <div class="col-4">
                     <div class="item-name col-5">通知书状态：</div>
                     <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="admissionFlag">
                                <option value="">全部</option>
                                <option value="0">未设置</option>
                                <option value="1">已设置</option>
                            </select>
                        </div>
                      </div>
                   </div>
                   <div class="col-4">
	                    <label class="item-name col-5">片区：</label>
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
         <div id="hideorshow" style="display: none">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-4">指定检查人员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="checkDeptPerson" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">任务结束日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="taskEndTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="taskEndTimeEnd" value=""/>
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
       </form>
    </div>
</div>
    <p class="center mt10 mb10">
        <input type="button" id="js-search" value="查询" class="btn mr20">
        <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
    	<input type="button" id="more" value="更多查询条件" class="btn mr20">
    </p>
 <div class="light-info mb5 mt5">
 	<input type="button" id="js-record" value="打印汇总表" class="btn mr20">
	<input type="button" id="js-checkbook" value="打印检查通知书" class="btn mr20">
	<input type="button" id="js-export" value="导出专项检查表" class="btn mr20">
	<input type="button" id="js-download" value="空检查表下载" class="btn mr20">
    <span class="light">提示：请根据预查比对结果设置汇总表，再根据汇总表内容设置检查通知书。</span>
 </div>
<div> 
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
      <thead>
       <tr>
           <th style="padding:0 20px;">序号</th>
           <th>选择</th>
           <th>操作</th>
           <th>检查表</th>
           <th>通知书</th>
           <th>统一代码/注册号</th>
           <th>企业名称</th>
           <th>任务编号</th>
           <th>任务名称</th>
           <th>任务结束日期</th>
           <th>指定检查人员</th>
           <th>住所</th>
           <th>登记机关</th>
           <th>管辖单位</th>
           <th>片区</th>
           <th>设置人</th>
           <th>设置日期</th>
       </tr>
      </thead>
   </table>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scresult/scresultcheck_list.js"></script>
</body>
</html>