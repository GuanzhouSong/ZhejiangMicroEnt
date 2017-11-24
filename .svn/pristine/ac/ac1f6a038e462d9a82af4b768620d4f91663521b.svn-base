<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>补报核查录入</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">

    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body class="pd10">
<div class="form-box">
    <form id="taskForm">
        <input type="hidden" id="regOrg" name="regOrg">
        <input type="hidden" id="localAdm" name="localAdm">
        <input type="hidden" id="sliceNO" name="sliceNO">

        <div class="form-list pd14-mr">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-3"><span class="long-label">补报主体：</span></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="checkbox" name="subject" value="ent" checked> 企业
                            <input type="checkbox" name="subject" value="sfc" checked> 农专社
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniCode" placeholder="可输入尾号后4位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 登记机关：</label>
                    <div class="ipt-box col-6">
                        <input type="text" class="fl ipt-txt" readonly="readonly" id="regOrgName" placeholder="选择">
                        <span class="add-icon" id="choseorgReg">
                             <i></i>
                         </span>
                    </div>
                </div>


            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-3">补报年度：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="year">
                                <option value="">全部</option>
                                 <c:forEach items="${yearList}" var="year" varStatus="status">
                                    <option value="${year }">${year }</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" placeholder="可输入关键词查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 管辖单位：</label>
                    <div class="ipt-box col-6">
                        <input type="text" readonly="readonly" class="fl ipt-txt" id="localAdmName" placeholder="选择">
                        <span class="add-icon" id="choseregUnit">
                            <i></i>
                        </span>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">

                <div class="col-4">
                    <label class="item-name col-3">检查结果状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="infoAuditResult">
                                <option value="">全部</option>
                                <option value="3">待录入</option>
                                <option value="5">已录入</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                     <div class="item-name col-5">后续处置状态：</div>
                     <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="disposeState">
                                <option value="">全部</option>
                                <option value="1">未完结</option>
                                <option value="2">已完结</option>
                            </select>
                        </div>
                      </div>
                   </div>
                <div class="col-4">
                        <label class="item-name col-5">检查部门：</label>
                        <div class="ipt-box col-6">
                            <input type="text" class="fl ipt-txt" readonly="readonly" id="checkDepName"
                                   placeholder="选择">
                            <input type="hidden" name="checkDep" id="checkDep">
                            <span class="add-icon" id="choseCheckDep">
                        <i></i>
                    </span>
                        </div>
                    </div>   
            </div>
			<div id="hideorshow" style="display: none">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-3">检查结果：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="resResult" id="resResult"   multiple="multiple">
                                <option value="1">正常（符合信息公示相关规定）</option>
                                <option value="2">未按规定公示年报</option>
                                <option value="3">未按规定公示其他应当公示的信息</option>
                                <option value="4">公示信息隐瞒真实情况、弄虚作假</option>
                                <option value="5">通过登记的住所（经营场所）无法联系</option>
                                <option value="6">不予配合情节严重</option>
                                <option value="7">企业注销、被吊销、被撤销或迁出</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">检查日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="infoCheckDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="infoCheckDateEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 片区/商圈：</label>
                    <div class="ipt-box col-6">
                        <input type="text" class="fl ipt-txt" readonly="readonly" id="sliceNoName" placeholder="选择">
                        <span class="add-icon" id="choseSilceno">
                        <i></i>
                    </span>
                    </div>
                </div>
             </div>   
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-3">检查人员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="infoCheckMan" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">录入日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="infoFillDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="infoFillDateEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">录入人员：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="infoFillMan" value=""/>
                        </div>
                    </div>
                </div>
            </div>
       </div>
        </div>
    </form>
</div>
<p class="center mt10 mb10">
        <input type="button" id="js-search" value="查询" class="btn mr20">
        <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
    	<input type="button" id="more" value="更多查询条件" class="btn mr20">
    </p>
<div class="clearfix mb5 mt5">

</div>
<div id="div-new-history" >
<div class="light-info">
    <span class="light">
    提示：此处仅查询本局登记及市局委托管辖且已补报的在册企业与农专社。 补报核查结果信息不对外公示。
    </span>
    <span class="light-blue">查询结果</span>：
            已录入 <span id="infoAuditResult5Total"class="light-blue">0</span> 条， 
            其中未完结 <span id="disposeState1Total"class="light-blue">0</span> 条 ，
            已完结 <span id="disposeState2Total"class="light-blue">0</span> 条。
</div>
<table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
    <thead>
    <tr>
        <th width="12%">序号</th>
        <th width="16%">操作</th>
        <th width="10%">检查结果状态</th>
        <th width="10%">后续处置状态</th>
        <th width="10%" class="uniCode">统一信用代码/注册号</th>
        <th width="12%">企业名称</th>
        <th width="6%">成立日期</th>
        <th width="7%">补报年度</th>
        <th width="7%">检查日期</th>
        <th width="7%">检查结果</th>
        <th width="7%">检查人员</th>
        <th width="7%">检查部门</th>
        <th width="7%">登记机关</th>
        <th width="7%">管辖单位</th>
        <th width="7%">片区/商圈</th>
        <th width="7%">录入人员</th>
        <th width="7%">录入日期</th>
    </tr>
    </thead>
</table>
</div>
<script>
    window._CONFIG = {
        <c:if test="${sessionScope.session_sys_user.isAdmin!='1'}">
        select_dept_url: '<c:url value="/common/system/dept/tree/select"/>',
        </c:if>
        <c:if test="${sessionScope.session_sys_user.isAdmin=='1'}">
        select_dept_url: '<c:url value="/common/system/dept/tree/selectAll"/>',
        </c:if>
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/inspect/inputinfo_list.js"></script>
</body>
</html>
