<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>联络员确认通知书查询</title>
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
                    <label class="item-name col-5">主体类别：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="checkbox" name="entTypeCode" value="13,34,26,14,33,23,11,12,32,21,25,24,15,22,31,27,28" checked="checked">企业
                            <input type="checkbox" name="entTypeCode" value="16,17" >农专社
                            <input type="checkbox" name="entTypeCode" value="50" >个体户
                        </div>
                        <input type="hidden" name="entType" id="entType">
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">统一代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNO" placeholder="可输入尾号后四位查询">
                        </div>
                    </div>
                </div>
               
                 <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value=""/>
                        <span class="add-icon" id="choseorgReg">
                            <i></i>
                        </span>
                        </div>
                    </div>
                </div>
               
               
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">消息名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="msgTitle">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" placeholder="可输入名称关键字查询">
                        </div>
                    </div>
                </div>
              	<div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value=""/>
	                            <span class="add-icon" id="choselocalAdm">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
              
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">消息查阅状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                           <select name="msgPcReadState">
                            	<option value="">全部</option>
                            	<option value="1">已查阅</option>
                            	<option value="0">未查阅</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 发送时间：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="sendTimeStart" value="" id="sendTimeStart"/>
	                        </div>
	                        <span class="item-line col-05">-</span>
	                        <div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
	                                   readonly="readonly"
	                                   name="sendTimeEnd" value="" id="sendTimeEnd"/>
	                        </div>
                        </div>
                    </div>
                </div>
			
				<div class="col-4">
                    <label class="item-name col-5">片区/商圈：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNo" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="sliceNoName" value="" />
	                         <span class="add-icon" id="chooseSliceNo">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
			
			
            </div>
            <div class="form-item clearfix" id="hiddendiv1" style="display: none;">
            	<div class="col-4">
                    <label class="item-name col-5">发送人：</label>
                    <div class="col-6">
                         <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="sendName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">消息查阅时间：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="msgPcReadTimeStart" value="" id="msgPcReadTimeStart"/>
	                        </div>
	                        <span class="item-line col-05">-</span>
	                        <div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
	                                   readonly="readonly"
	                                   name="msgPcReadTimeEnd" value="" id="msgPcReadTimeEnd"/>
	                        </div>
                        </div>
                    </div>
                </div>
				<div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<select name="regStateM" id="regStateM" multiple="multiple">
                                <option value='K,B,A,DA,X' selected="selected">存续</option>
                                <option value='C'>撤销</option>
                                <option value='D'>吊销</option>
                                <option value='Q'>迁出</option>
                                <option value='XX,DX'>注销</option>
                            </select>
                            <input type="hidden" name="regState" id="regState">
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="mt10">
            <div class="center">
                <input type="button" value="查 询" id="search" class="btn mr20">
                <input type="button" value="重 置" id="cancel" class="btn mr20" onclick="$('#taskForm')[0].reset();">
                <input type="button" value="更多查询条件" id="moresearch" class="btn mr20">
            </div>
        </div>
    </form>

    <div class="mt10">
        <div class="clearfix mb5 mt5">
    <p class="fl">
        <input id="btn_add" type="button" class="btn btn-sm mr5 js-batchregist" value="新增消息通知">
    </p>
</div>
    <div class="light-info mt5">
        <span class="light">提示：消息将通过企信联连（联连PC客户端、联连公众号和短信）全渠道用户智能推送，消息推送、用户阅签全过程记录，让您在在企业的消息发送中更省心。
    </div>
    <div class="tip-info left">
	    查询结果： 企业共<label id="label_entNum" class="light-blue">0</label>家，消息通知共<label id="label_msgNum" class="light-blue">0</label>条，已查阅<label id="label_msgReadNum" class="light-blue">0</label>条，未查阅<label id="label_msgUnReadNum" class="light-blue">0</label>条，
	</div>

        <div class="iframe-wrap">
            <%--    <p><h2>企业名称:${map.entName}&nbsp;&nbsp;&nbsp;注册号/ 统一信用社会代码:${map.uniCode }</h2></p> --%>
            <table id="permit-table" class="table-row display nowrap" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>操作</th>
                    <th>消息名称</th>
                    <th>统一代码/注册号</th>
                    <th>企业名称</th>
                    <th>法定代表人/负责人</th>
                    <th>发送时间</th>
                    <th>发送人</th>
                    <th>通知对象</th>
                    <th>联系方式</th>
                    <th>消息查阅状态</th>
                    <th>消息查阅时间</th>
                    <th>登记机关</th>
                    <th>管辖单位</th>
                    <th>片区/商圈</th>
                    <th>登记状态</th>
                </tr>
                </thead>
            </table>
        </div>
  </div>
  </div>
        <script src="/js/lib/require.js"></script>
        <script src="/js/config.js"></script>
        <script src="/js/reg/server/message/message_list.js"></script>
</body>
</html>
