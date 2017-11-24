<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>预警标识设置</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">

<div class="tabbale" data-component="tab">
    <div class="tab-header tab-chaogao">
        <ul class="clearfix">
            <li class="tab-selected"><span class="tab-item">我增设的预警标识</span></li>
            <li><span class="tab-item" id="tabAll">全部预警标识</span></li>
        </ul>
    </div>
    <div class="tab-content mb20">
        <div class="tab-panel">
            <form id="warnSearchForm">
                <div class="form-box">
                    <div class="form-list">
                        <div class="form-item clearfix">
                            <div class="col-4">
                                <label class="item-name col-5">标识名称：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input type="text" class="ipt-txt clx_one" name="markNameDesc">
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <label class="item-name col-4">标识级别：</label>
                                <div class="col-8">
                                    <div class="ipt-box col-12">
                                        <select name="markClass" class="clx_one">
                                            <option value="">不限</option>
                                            <option value="0">关注</option>
                                            <option value="1">警示</option>
                                            <option value="2">限制</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <label class="item-name col-5"> 标识指定提示方式：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <select id="markAppointWay" name="markAppointWay" class="clx_one">
                                            <option value="">不限</option>
                                            <option value="0">对内提示</option>
                                            <option value="1">部门共享</option>
                                            <option value="2">公开发布</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-item clearfix">
                            <div class="col-4">
                                <label class="item-name col-5"> 标识类型：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <select name="markType" class="clx_one">
                                            <option value="">不限</option>
                                            <option value="手动">手动</option>
                                            <option value="自动">自动</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <label class="item-name col-4">标识有效期：</label>
                                <div class="col-8">
                                    <div class="ipt-box col-5">
                                        <input type="text" class="ipt-txt clx_one" readonly="readonly" onclick="laydate();"
                                               name="markStartDate">
                                    </div>
                                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                                    <div class="ipt-box col-5">
                                        <input type="text" class="ipt-txt clx_one" readonly="readonly" onclick="laydate();"
                                               name="markEndDate">
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <label class="item-name col-5"> 标识状态：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <select name="markState" class="clx_one">
                                            <option value="">不限</option>
                                            <option value="1">有效</option>
                                            <option value="0">无效</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-item clearfix mb10">
                            <div class="col-4">
                            </div>
                            <div class="col-4">
                                <label class="item-name col-5">标识设置年度：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <select name="markSetYear" class="clx_one">
                                            <option value="">不限</option>
                                            <c:if test="${fn:length(yearList) != 0}">
                                                <c:forEach var="cr" items="${yearList}">
                                                    <option value="${cr.markSetYear}">${cr.markSetYear}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-item clearfix">
                            <div class="btn-box mt10">
                                <input type="button" id="mySearch" value="查 询" class="btn mr20">
                                <input type="button" id="reset_one" value="重 置" class="btn">
                            </div>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="markSetDeptCode" value="${csWarnMark.markSetDeptCode}"/>
                <input type="hidden" id="markFunc" name="markFunc" value="yj"/>
            </form>
            <div class="clearfix mb5 mt5">
                <p class="fl"><input type="button" class="btn btn-sm mr5 enaddAddedit" value="新增">
                    </p>
            </div>
            <div class="table-out">
                <table id="warn-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>操作</th>
                        <th>编码</th>
                        <th>设置年度</th>
                        <th>类型</th>
                        <th>级别</th>
                        <th>名称</th>
                        <th>开始日期</th>
                        <th>结束日期</th>
                        <th>状态</th>
                        <th>指定提示方式</th>
                        <th>设置部门</th>
                        <th>设置时间</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
        <div class="tab-panel">
            <form id="warnSearchFormAll">
                <div class="form-box mb5">
                    <div class="form-list">
                        <div class="form-item clearfix">
                            <div class="col-4">
                                <label class="item-name col-5">标识名称：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input type="text" class="ipt-txt clx_all" name="markNameDesc">
                                    </div>
                                </div>

                            </div>
                            <div class="col-4">
                                <label class="item-name col-4">标识级别：</label>
                                <div class="col-8">
                                    <div class="ipt-box col-12">
                                        <select name="markClass" class="clx_all">
                                            <option value="">不限</option>
                                            <option value="0">关注</option>
                                            <option value="1">警示</option>
                                            <option value="2">限制</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <label class="item-name col-5">标识指定提示方式：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <select id="markAppointWay" name="markAppointWay" class="clx_all">
                                            <option value="">不限</option>
                                            <option value="0">对内提示</option>
                                            <option value="1">部门共享</option>
                                            <option value="2">公开发布</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-item clearfix">
                            <div class="col-4">
                                <label class="item-name col-5">标识类型：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <select name="markType" class="clx_all">
                                            <option value="">不限</option>
                                            <option value="手动">手动</option>
                                            <option value="自动">自动</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <label class="item-name col-4">标识有效期：</label>
                                <div class="col-8">
                                    <div class="ipt-box col-5">
                                        <input type="text" class="ipt-txt clx_all" readonly="readonly" onclick="laydate();"
                                               name="markStartDate">
                                    </div>
                                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                                    <div class="ipt-box col-5">
                                        <input type="text" class="ipt-txt clx_all" readonly="readonly" onclick="laydate();"
                                               name="markEndDate">
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <label class="item-name col-5">标识状态：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <select name="markState" class="clx_all">
                                            <option value="">不限</option>
                                            <option value="1">有效</option>
                                            <option value="0">无效</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-item clearfix">
                            <div class="col-4">
                                <label class="item-name col-5">标识设置部门：</label>
                                <div class="col-6">
                                    <div class="ipt-box col-12">
                                        <input type="text" id="markSetDept" class="ipt-txt clx_all"
                                               style="height: 30px;" value="" readonly/>
                                        <input type="hidden" id="markSetDeptCode" name="markSetDeptCode" value=""
                                               class="clx_all"/>
                                        <a id="selectMarkSetDept" class="link js-show">
                                            <span class="add-icon" id="yccodetree"><i></i></span>
                                        </a>
                                    </div>

                                </div>

                            </div>
                            <div class="col-4">
                                <label class="item-name col-4">标识设置年度：</label>
                                <div class="col-8">
                                    <div class="ipt-box col-12">
                                        <select name="markSetYear" class="clx_all">
                                            <option value="">不限</option>
                                            <c:if test="${fn:length(yearList) != 0}">
                                                <c:forEach var="cr" items="${yearList}">
                                                    <option value="${cr.markSetYear}">${cr.markSetYear}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-item clearfix">
                            <div class="btn-box mt10">
                                <input type="button" id="allSearch" value="查 询" class="btn mr20">
                                <input type="button" id="reset_all" value="重 置" class="btn">
                            </div>
                        </div>
                    </div>
                </div>
                <input type="hidden" id="markAppointDeptCode" name="markAppointDeptCode" value="${csWarnMark.markAppointDeptCode}"/>
                <input type="hidden" name="markFunc" value="yj"/>
                <input type="hidden" name="userType" value="${csWarnMark.userType}"/>
            </form>
            <div class="clearfix mb5">
                <p class="fl"><input type="button" class="btn btn-sm mr5 enaddAddedit" value="新增">
                    <input type="button" class="btn btn-sm" value="导出"></p>
            </div>
            <div class="table-out">
                <table id="warn-table-all" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>操作</th>
                        <th>编码</th>
                        <th>设置年度</th>
                        <th>类型</th>
                        <th>级别</th>
                        <th>名称</th>
                        <th>开始日期</th>
                        <th>结束日期</th>
                        <th>状态</th>
                        <th>指定提示方式</th>
                        <th>设置部门</th>
                        <th>设置时间</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    window._CONFIG = {
        select_dept_url: '<c:url value="/common/system/sysdepart/deptSelectByDuty?isFilterBySysUser=true&treeType=radio&isNoCheck=true"/>'
    }
</script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/component/tab.js"></script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/risk/mark/warnmark_list.js"></script>
</body>
</html>