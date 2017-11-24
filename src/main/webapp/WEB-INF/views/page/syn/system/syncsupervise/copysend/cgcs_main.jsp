<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>抄告抄送主页面</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<input id="realtab" type="hidden" value="${realtab}"/>
<div class="tabbale" id="cgcs-tab">
    <div class="tab-header tab-chaogao">
        <ul class="clearfix">
            <li class="tab-selected"><span id="sendTab" class="tab-item">我发起的抄告抄送</span></li>
            <li><span id="acceptTab" class="tab-item">我接收的抄告抄送</span></li>
        </ul>
    </div>
    <div class="tab-content mb20">
        <div id="sendbody" class="tab-panel">
            <div class="tabbale">
                <form id="sendSearchForm" class="searchForm">
                    <div class="form-box mb5">
                        <div class="form-list">
                            <div class="form-item clearfix">
                                <div>
                                <c:if test="${sessionScope.session_sys_user.userType == 1}">
                                    <input type="hidden" id="deptCode" class="deptCode" name="deptCode" value="${sysUser.deptCode}"/>
                                </c:if>
                                <c:if test="${sessionScope.session_sys_user.userType == 2}">
                                    <input type="hidden" id="deptCode" class="deptCode" name="deptCode" value="${sysUser.sysDepart.adcode}"/>
                                    <input type="hidden" name="dutyDeptCodes" value="${sysUser.dutyDeptCodes}"/>
                                </c:if>          
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-5">抄告信息来源：</label>
                                    <div class="col-6">
                                        <div class="ipt-box col-12">
                                            <select name="copyInfoFrom" class="clearall">
                                                <option value="">不限</option>
                                                <option value="jcfx">检查发现</option>
                                                <option value="qzjb">群众举报</option>
                                                <option value="sjjb">上级交办</option>
                                                <option value="qt">其他</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-4">抄告类型：</label>
                                    <div class="col-8">
                                        <div class="ipt-box col-12">
                                            <select name="copyType" class="clearall">
                                                <option value="">不限</option>
                                                <option value="wzwz">无证无照</option>
                                                <option value="qywf">企业违法案件</option>
                                                <option value="qt">其他</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-5"> 是否需要反馈：</label>
                                    <div class="col-6">
                                        <div class="ipt-box col-12">
                                            <select name="feedbackNeed" class="clearall">
                                                <option value="">不限</option>
                                                <option value="0">是</option>
                                                <option value="1">否</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-item clearfix">
                                <div class="col-4">
                                    <label class="item-name col-5">涉嫌违法事项：</label>
                                    <div class="col-6">
                                        <div class="ipt-box col-12">
                                            <input name="illegalItem" type="text" class="ipt-txt clearall"/>

                                        </div>
                                    </div>

                                </div>
                                <div class="col-4">
                                    <label class="item-name col-4">抄告发起日期：</label>
                                    <div class="col-8">
                                        <div class="ipt-box col-5">
                                            <input name="startDate" readonly="readonly" type="text"
                                                   class="ipt-txt clearall" onclick="laydate();">
                                        </div>
                                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                                        <div class="ipt-box col-5">
                                            <input name="endDate" readonly="readonly" type="text"
                                                   class="ipt-txt clearall" onclick="laydate();">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-5">涉嫌违法当事人：</label>
                                    <div class="col-6">
                                        <div class="ipt-box col-12">
                                            <input name="clientName" type="text" class="ipt-txt clearall">
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="form-item clearfix mb10">
                                <div class="col-4">
                                    <label class="item-name col-5">抄告接收部门：</label>
                                    <div class="col-6">
                                        <div class="ipt-box col-12">
                                            <input id="acceptDepartCode" class="ipt-txt clearall" type="hidden"
                                                   name="acceptDeptCodes"/>
                                            <input id="acceptDepartName" class="fl ipt-txt clearall" type="text"
                                                   placeholder="请选择部门"
                                                   readonly/>
                                            <a id="selectRegOrg" class="link js-show">
                                                <span class="add-icon" id="codetree"><i></i></span>
                                            </a>
                                        </div>
                                    </div>

                                </div>
                                <div class="col-4">
                                    <label class="item-name col-4">抄告状态：</label>
                                    <div class="col-8">
                                        <div class="ipt-box col-12">
                                            <select name="copyState" class="clearall">
                                                <option value="">不限</option>
                                                <option value="dsh">抄告申请待审核</option>
                                                <option value="yshth">抄告申请被退回</option>
                                                <option value="ycgfkz">已抄告待反馈</option>
                                                <option value="ycgfkwc">已抄告已反馈</option>
                                                <option value="qxcg">取消抄告</option>
                                                <option value="ycgwc">已抄告完成</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-item clearfix">
                                <div class="btn-box">
                                    <input id="send-search" type="button" value="查 询" class="btn mr20">
                                    <input id="reset" type="button" value="重 置" class="btn">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="clearfix mb5">
                <p class="fl"><input id="add" type="button" class="btn btn-sm mr5" value="新建"/></p>
                <span class="light-yellow fr mt5">共发起<span id="cgcstotal"></span>条抄告抄送，其中<span id="cgcsdshNum"></span>条待审核，<span
                        id="cgcsshthNum"></span>条审核退回，<span id="cgcsycgfkzNum"></span>条已抄告反馈中，<span
                        id="cgcsycgfkwcNum"></span>条已抄告反馈完成，<span id="cgcsqxcgNum"></span>条取消抄告，<span
                        id="cgcscgwc"></span>条已抄告完成</span>
            </div>

            <div class="table-out">
                <div class="iframe-wrap">
                    <table id="cgcs-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
                        <thead>
                        <tr>
                            <th width="3%">序号</th>
                            <th width="7%">操作</th>
                            <th width="5%">抄告状态</th>
                            <th width="5%">抄告类型</th>
                            <th width="10%">抄告接收部门</th>
                            <th width="20%">涉嫌违法事项</th>
                            <th width="10%">抄告单编号</th>
                            <th width="10%">抄告信息来源</th>
                            <th width="5%">是否需要反馈</th>
                            <th width="8%">抄告发起日期</th>
                            <th width="8%">抄告最新处理日期</th>
                            <th width="13%">抄告发起部门</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
        <div id="acceptbody" class="tab-panel">
            <div class="tabbale">
                <form id="acceptSearchForm" class="searchForm">
                    <div class="form-box mb5">
                        <div class="form-list">
                            <div class="form-item clearfix">
                                <div>
                                <c:if test="${sessionScope.session_sys_user.userType == 1}">
                                <input type="hidden" name=acceptDepartCode value="${sessionScope.session_sys_user.deptCode}"/>
                                <input type="hidden" name=userType value="1"/>
                                </c:if>
                                <c:if test="${sessionScope.session_sys_user.userType == 2}">
                                    <input type="hidden" name="acceptDepartCode" value="${sysUser.sysDepart.adcode}"/>
                                   <input type="hidden" name=userType value="2"/>
                                </c:if>  
                                    
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-5">抄告信息来源：</label>
                                    <div class="col-6">
                                        <div class="ipt-box col-12">
                                            <select name="copyInfoFrom" class="acceptclearall">
                                                <option value="">不限</option>
                                                <option value="jcfx">检查发现</option>
                                                <option value="qzjb">群众举报</option>
                                                <option value="sjjb">上级交办</option>
                                                <option value="qt">其他</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-4">抄告类型：</label>
                                    <div class="col-8">
                                        <div class="ipt-box col-12">
                                            <select name="copyType" class="acceptclearall">
                                                <option value="">不限</option>
                                                <option value="wzwz">无证无照</option>
                                                <option value="qywfaj">企业违法案件</option>
                                                <option value="qt">其他</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-5">抄告状态：</label>
                                    <div class="col-6">
                                        <div class="ipt-box col-12">
                                            <select name="fkState" class="acceptclearall">
                                                <option value="">不限</option>
                                                <option value="1">已反馈</option>
                                                <option value="0">待反馈</option>
                                                <option value="2">已接收</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-item clearfix">
                                <div class="col-4">
                                    <label class="item-name col-5">涉嫌违法事项：</label>
                                    <div class="col-6">
                                        <div class="ipt-box col-12">
                                            <input type="text" name="illegalItem" class="ipt-txt acceptclearall">
                                        </div>
                                    </div>

                                </div>
                                <div class="col-4">
                                    <label class="item-name col-4">是否需要反馈：</label>
                                    <div class="col-8">
                                        <div class="ipt-box col-12">
                                            <select name="feedbackNeed" class="acceptclearall">
                                                <option value="">不限</option>
                                                <option value="0">是</option>
                                                <option value="1">否</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-5">涉嫌违法当事人：</label>
                                    <div class="col-6">
                                        <div class="ipt-box col-12">
                                            <input type="text" name="clientName" class="ipt-txt acceptclearall">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-item clearfix mb10">
                                <div class="col-4">
                                    <label class="item-name col-5">抄告发起部门：</label>
                                    <div class="col-6">
                                        <div class="ipt-box col-12">
                                            <input id="acceptCopyDepart" class="ipt-txt acceptclearall" type="hidden" name="sendDeptCode"/>
                                            <input id="dutyCodes" class="ipt-txt acceptclearall" type="hidden" name="dutyCodes"/>
                                            <input id="acceptCopyDepartName"
                                                   class="ipt-txt acceptclearall" type="text" placeholder="请选择部门"
                                                   readonly/>
                                            <a class="link js-show">
                                                <span class="add-icon" id="acceptcodetree"><i></i></span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-4">抄告发起日期：</label>
                                    <div class="col-8">
                                        <div class="ipt-box col-5">
                                            <input name="acceptStartDate" readonly="readonly" type="text"
                                                   class="ipt-txt acceptclearall" onclick="laydate();">
                                        </div>
                                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                                        <div class="ipt-box col-5">
                                            <input name="acceptEndDate" readonly="readonly" type="text"
                                                   class="ipt-txt acceptclearall" onclick="laydate();">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label class="item-name col-5">抄告发起人：</label>
                                    <div class="col-6">
                                        <div class="ipt-box col-12">
                                            <input type="text" name="copyDepartPerson" class="ipt-txt acceptclearall">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-item clearfix">
                                <div class="btn-box">
                                    <input id="accept-search" type="button" value="查 询" class="btn mr20">
                                    <input id="acceptreset" type="button" value="重 置" class="btn">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="clearfix mb5">
                <span class="light-yellow fr mt5">共发起<span id="cgcsceeptTotal"></span>条抄告抄送，其中<span
                        id="cgcsdfkNum"></span>条待反馈，<span id="cgcsyfkNum"></span>条已反馈</span>
            </div>

            <div class="table-out">
                <div class="iframe-wrap">
                    <table id="accept-cgcs-table" border="0" cellspacing="0" cellpadding="0"
                           class="table-row perc-100 nowrap">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>操作</th>
                            <th>抄告状态</th>
                            <th>抄告类型</th>
                            <th>抄告接收部门</th>
                            <th>涉嫌违法事项</th>
                            <th>抄告单编号</th>
                            <th>抄告信息来源</th>
                            <th>是否需要反馈</th>
                            <th>抄告发起日期</th>
                            <th>抄告最新处理日期</th>
                            <th>抄告发起部门</th>
                            <th width="20%">抄告发起部门联系人</th>
                            <th width="20%">抄告发起部门联系电话</th>
                            <th width="20%">抄告发起部门传真</th>
                            <th width="20%">抄告发起部门邮箱</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
		if("${sysUser.userType}" == "1"){
			 window._CONFIG = {
		    		_urlHead:'/reg/server/copysend/',//整改项目 
		     } 
		}else{
			window._CONFIG = {
		    		_urlHead:'/syn/copysend/',//整改项目 
		     } 
		}
</script>

<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>

<script id="accept_tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/copysend/cgcs_main.js"></script>
</body>
</html>