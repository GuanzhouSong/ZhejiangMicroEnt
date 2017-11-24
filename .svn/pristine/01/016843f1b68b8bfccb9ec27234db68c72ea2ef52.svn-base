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
    <title>移出异常名录申请</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<form id="taskForm">
    <div class="form-box">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNO" placeholder="可输入尾号后四位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" placeholder="可输入名称关键词查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value="${codeRegorg.code }"/>
                            <input type="text" readonly="readonly" class="ipt-txt" name="regOrgName" id="regOrgName" value="${codeRegorg.content }"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">移出类型：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" name="isMove" id="isMove" value="" />
                            <label><input type="checkbox" name="isMoves"  value="1" checked="checked">正常移出</label>
                            <label><input type="checkbox" name="isMoves"  value="2" checked="checked">更正（撤销）移出</label>
                        </div>
                    </div>
                </div>                
                <div class="col-4">
                    <label class="item-name col-5">移出文号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="penDecNo">
                        </div>
                    </div>
                </div>               
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" name="localAdm" id="localAdm" value="" class="hidden_input"/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="选择"  readonly="readonly"/>
                        <span class="add-icon" id="choseregUnit">
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
                        <div class="ipt-box col-12">
                            <select name="auditState">
                                <option value="">全部</option>
                                <option value="0">待审核</option>
                                <option value="1">予以移出</option>
                                <option value="2">不予移出</option>
                                <option value="3">予以更正</option>
                                <option value="4">不予更正</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">正常移出原因：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="hidden_input" name="remExcpres" id="remExcpres" value=""/>
                            <input type="text" class="ipt-txt text-over" value="" placeholder="请选择移出原因" id="remExcpresText" readonly="readonly"/>
                            <span class="add-icon" id="select-intercept">
                                <i></i>
                            </span> 
                        </div>
                    </div>
                </div>                          
                <div class="col-4">
                    <label class="item-name col-5">初审人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="firstName">
                        </div>
                    </div>
                </div>                                         
            </div>
            <div class="center mt10">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="reset" id="reset" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </div>
</form>

<div class="clearfix mb5 mt5">
    <p class="fl"><button type="button" id="addMove" class="btn btn-sm">新增移出记录</button></p>
</div>
<div class="light-info mb5">
    <c:if test="${systemType == '1'}">
    <span class="light">提示：查询范围为当前时点本局登记的在册企业。申请信息在完成审核后可打印“经营异常名录审批表”；审核结果为“予以移出、予以更正”时可打印“移出经营异常名录决定书”；予以移出的异常信息自动通过公示系统予以公示；予以更正的异常信息自动从公示系统撤回不予公示。</span>
    </c:if>
    <c:if test="${systemType == '2'}">
    <span class="light">提示：查询范围为当前时点本局登记的在册农民专业合作社。申请信息在完成审核后可打印“经营异常名录审批表”；审核结果为“予以移出、予以更正”时可打印“移出经营异常名录决定书”；予以移出的异常信息自动通过公示系统予以公示；予以更正的异常信息自动从公示系统撤回不予公示。</span>
    </c:if>
</div>

<table id="user_table" border="0" cellspacing="0" cellpadding="0" class="table-row"
       style="width: 100%;white-space: nowrap;">
    <thead>
    <tr>
        <th style="padding:0 20px;">序号</th>
        <th>操作</th>
        <th>统一信用代码/注册号</th>
        <th>企业名称</th>
        <th>状态</th>
        <th>移出文号</th>
        <th>移出异常原因</th>
        <th>决定日期</th>
        <th>决定机关</th>
        <th>初审人</th>
        <th>初审日期</th>
        <th>审核人</th>
        <th>审核日期</th>
        <th>登记机关</th>
        <th>管辖单位</th>
    </tr>
    </thead>
</table>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailmove_list.js"/>"></script>
<script>
    window._CONFIG = {
        _systemType: '${systemType}',
	    _regOrg:'${codeRegorg.code }'
    }
</script>
</body>
</html>
