<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>发起协同事务提请</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <div class="tab-content">
        <div class="tab-panel tab-panel-show">
            <form id="sendSearchForm" class="searchForm">
                <div class="form-box mb5">
                    <div class="form-list">
                        <div class="form-item clearfix">
                            <div>
                            <c:if test="${sessionScope.session_sys_user.userType == 1}">
                                    <input type="hidden" id="deptCode" class="deptCode" name="deptCode" value="${sessionScope.session_sys_user.deptCode}"/>
                                </c:if>
                                <c:if test="${sessionScope.session_sys_user.userType == 2}">
                                    <input type="hidden" id="deptCode" class="deptCode" name="deptCode" value="${sessionScope.session_sys_user.sysDepart.adcode}"/>
                                    <input type="hidden" name="dutyDeptCodes" value="${sessionScope.session_sys_user.dutyDeptCodes}"/>
                                </c:if>

                            </div>
                            <div class="col-4">
                                <label class="item-name col-5">协同事务提请信息来源：</label>
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
                                <label class="item-name col-4">协同事务提请类型：</label>
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
                                <label class="item-name col-4">协同事务提请发起日期：</label>
                                <div class="col-8">
                                    <div class="ipt-box col-5">
                                        <input name="startDate" readonly="readonly" type="text" class="ipt-txt clearall"
                                               onclick="laydate();">
                                    </div>
                                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                                    <div class="ipt-box col-5">
                                        <input name="endDate" readonly="readonly" type="text" class="ipt-txt clearall"
                                               onclick="laydate();">
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
                                <label class="item-name col-5">协同事务提请接收部门：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input id="acceptDepartCode" class="ipt-txt clearall" type="hidden"
                                               name="acceptDeptCodes"/>
                                        <input id="acceptDepartName"
                                               class="fl ipt-txt clearall" type="text" placeholder="请选择部门" readonly/>
                                        <a id="selectRegOrg" class="link js-show">
                                            <span class="add-icon" id="codetree"><i></i></span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                    <label class="item-name col-4">协同事务提请状态：</label>
                                    <div class="col-8">
                                        <div class="ipt-box col-12">
                                            <select name="copyState" class="clearall">
                                                <option value="">不限</option>
                                                <option value="dsh">协同事务提请申请待审核</option>
                                                <option value="yshth">协同事务提请申请被退回</option>
                                                <option value="ycgfkz">已协同事务提请待反馈</option>
                                                <option value="ycgfkwc">已协同事务提请已反馈</option>
                                                <option value="qxcg">取消协同事务提请</option>
                                                <option value="ycgwc">协同事务提请已完成</option>
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
    </div>
</div>


<div class="table-out">
    <div class="iframe-wrap">
        <table id="cgcs-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
            <thead>
            <tr>
                <th width="3%">序号</th>
                <th width="7%">操作</th>
                <th width="5%">协同事务提请状态</th>
                <th width="5%">协同事务提请类型</th>
                <th width="10%">协同事务提请接收部门</th>
                <th width="20%">涉嫌违法事项</th>
                <th width="10%">协同事务提请单编号</th>
                <th width="10%">协同事务提请信息来源</th>
                <th width="5%">是否需要反馈</th>
                <th width="8%">协同事务提请发起日期</th>
                <th width="8%">协同事务提请最新处理日期</th>
                <th width="13%">协同事务提请发起部门</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script>
		if("${sysUser.userType}" == "1"){
			 window._CONFIG = {
		    		_urlHead:'/reg/server/sendaffairs/',//整改项目 
		     } 
		}else{
			window._CONFIG = {
		    		_urlHead:'/syn/sendaffairs/',//整改项目 
		     } 
		}
</script>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sendaffairs/cgcs_view.js"></script>
</body>
</html>