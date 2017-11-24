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
    <title>短信群发记录</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
    <div class="pd10 bg-gray" style="margin-top: 10px;">
       <div class="form-list pdr10">
           <form id="taskForm" class="form-box mb5">
           	  <div class="form-item clearfix">
                 <div class="col-4">
                    <div class="item-name col-4">短信任务编号：</div>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" name="taskid" class="ipt-txt" value="" />
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
		                    <label class="item-name col-4">短信任务名称：</label>
		                    <div class="col-7">
		                        <div class="ipt-box col-11">
		                        	<input type="text" name="taskName" class="ipt-txt" value="" />
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
	                    <label class="item-name col-4">发送主体类别：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                        	<input type="hidden" name="entTypeCatg" id="entTypeCatg">
	                            <input type="checkbox" name="type" value="11,13,31,33,11,14,32,34,21,27,24,22,28">企业
	                            <input type="checkbox" name="type" value="16,17">农专社
	                            <input type="checkbox" name="type" value="50">个体户
	                        </div>
	                    </div>
	              </div>
                 <div class="col-4">
                     <div class="item-name col-5">发送对象类型：</div>
                     <div class="col-6">
                        <div class="ipt-box">
                             <input type="checkbox" name="smsLerep"> 负责人
                             <input type="checkbox" name="smsLia"> 联络员
                         </div>
                      </div>
                   </div>
                   <div class="col-4">
	                    <label class="item-name col-5">短信类别：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <select name="smsType">
	                                <option value="">全部</option>
	                                <option value="1">年报提醒（适用企业、农专社）</option>
	                                <option value="2">年报提醒（适用个体户）</option>
	                            </select>
	                        </div>
	                    </div>
	                </div>
               </div>
         <div id="hideorshow" style="display: none">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-4">发送对象姓名：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="name" value="" />
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">发送日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="sendTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="sendTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">发送人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="setName" value=""/>
                        </div>
                    </div>
                </div>
                <!-- 
                <div class="col-4">
                    <label class="item-name col-5">发送部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="dept" id="dept" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="deptName" value=""/>
	                            <span class="add-icon" id="chosedept">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
                 -->
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-4">发送对象号码：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="phone" value="" />
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">成立日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="estDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="estDateEnd" value=""/>
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
        <span class="light">提示：此处仅查询短信群发成功的发送记录。</span>
 </div>
<div class="tip-info left">
    查询结果：发送成功企业共<label id="sendEntSuccess" class="light-blue">0</label>户，
   发送成功手机号共<label id="sendTelSuccess" class="light-blue">0</label>条，
    其中发送成功负责人手机号<label id="sendLerepTelSuccess" class="light-blue">0</label>条，
   发送成功联络员手机号<label id="sendLiaTelSuccess" class="light-blue">0</label>条，
</div>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
      <thead>
       <tr>
           <th>序号</th>
           <th>短信任务编号</th>
           <th>短信任务名称</th>
           <th>统一代码/注册号</th>
           <th>企业名称</th>
           <th>成立日期</th>
           <th>主体类别</th>
           <th>短信类别</th>
           <th>发送对象类型</th>
           <th>发送对象姓名</th>
           <th>发送对象号码</th>
           <th>短信发送时间</th>
           <th>企业登记机关</th>
           <th>企业管辖单位</th>
       </tr>
      </thead>
   </table>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/smsgroupsend/smstaskinfo_list.js"></script>
</body>
</html>