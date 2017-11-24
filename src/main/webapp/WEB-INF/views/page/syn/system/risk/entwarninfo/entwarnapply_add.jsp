<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<h6 class="h6-title mt10 mb5 light-yellow">第一步：请选择企业添加至下方表单（支持多次选择）</h6>
<div class="form-box mb5">
    <div class="form-list">
        <form id="entSearchForm">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-7">统一信用代码/注册号：</label>
                    <div class="col-5">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="cidRegNO">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">企业名称：</label>
                    <div class="col-5">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="entName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">法定代表人：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="leRep">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-7">行业：</label>
                    <div class="col-5">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" id="industryCoName" style="height: 30px;" name=""
                                   value="" readonly>
                            <input type="hidden" id="industryCo" class="clx" name="industryCo" value=""/>
                            <a id="selectIndustryCo" class="link">
                                <span class="add-icon" id="yccodetree"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6"> 企业类型：</label>
                    <div class="col-5">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" id="entType" style="height: 30px;" name="" value=""
                                   readonly>
                            <input type="hidden" id="entTypeCode" class="clx" name="entType" value=""/>
                            <a id="selectEntType" class="link">
                                <span class="add-icon" id="yccodetree"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3"> 住所：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="dom">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-7">管辖单位：</label>
                    <div class="col-5">
                        <div class="ipt-box col-12">
                            <input type="text" id="localAdm" class="ipt-txt clx" style="height: 30px;" name="" value=""
                                   readonly/>
                            <input type="hidden" id="localAdmCode" class="clx" name="localAdm" value=""/>
                            <a id="selectLocalAdm" class="link">
                                <span class="add-icon" id="yccodetree"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">登记机关：</label>
                    <div class="col-5">
                        <div class="ipt-box col-12">
                            <input type="text" id="regOrg" class="ipt-txt clx" style="height: 30px;" name="" value=""
                                   readonly/>
                            <input type="hidden" id="regOrgCode" class="clx" name="regOrg" value=""/>
                            <a id="selectRegOrg" class="link">
                                <span class="add-icon" id="yccodetree"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">经营范围：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="opScope">
                        </div>
                    </div>
                </div>
            </div>
            <div class="js-show" style="display:none;">
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-7">法人是否受限：</label>
                        <div class="col-5">
                            <div class="ipt-box col-12">
                                <select name="leRepIsLim" class="clx">
                                    <option value="">不限</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-6">营运状况：</label>
                        <div class="col-5">
                            <div class="ipt-box col-12">
                                <select name="regState" class="clx">
                                    <option value="">不限</option>
                                    <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}'>${regState.value.name}</option>
                            		</c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-3">成立日期：</label>
                        <div class="col-8">
                            <div class="ipt-box col-5">
                                <input type="text" class="ipt-txt clx" onclick="laydate();" name="estDateStart"
                                       readonly>
                            </div>
                            <span class="item-txt col-2"><i class="line-icon"></i></span>
                            <div class="ipt-box col-5">
                                <input type="text" class="ipt-txt clx" onclick="laydate();" name="estDateEnd" readonly>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-7">许可证名称：</label>
                        <div class="col-5">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt clx" name="licName">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-6"> 注册资本：</label>
                        <div class="col-5">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt clx" name="regCap">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-3">信用等级：</label>
                        <div class="col-8">
                            <div class="ipt-box col-12">
                                <select name="creLevel" class="clx">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-7"> 是否有行政处罚：</label>
                        <div class="col-5">
                            <div class="ipt-box col-12">
                                <select name="isCase" class="clx">
                                    <option value="">不限</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-6"> 是否进入异常名录：</label>
                        <div class="col-5">
                            <div class="ipt-box col-12">
                                <select name="isOpan" class="clx">
                                    <option value="">不限</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-3"> 核准日期：</label>
                        <div class="col-8">
                            <div class="ipt-box col-5">
                                <input type="text" class="ipt-txt clx" onclick="laydate();" name="apprDateStart"
                                       readonly>
                            </div>
                            <span class="item-txt col-2"><i class="line-icon"></i></span>
                            <div class="ipt-box col-5">
                                <input type="text" class="ipt-txt clx" onclick="laydate();" name="apprDateEnd" readonly>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix mb10">
                    <div class="col-4">
                        <label class="item-name col-7">是否重点行业监管对象：</label>
                        <div class="col-5">
                            <div class="ipt-box col-12">
                                <select name="isIndRegObj" class="clx">
                                    <option value="">不限</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-6">是否为关注服务对象：</label>
                        <div class="col-5">
                            <div class="ipt-box col-12">
                                <select name="isFocusObj" class="clx">
                                    <option value="">不限</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="btn-box">
                    <input type="button" value="查 询" class="btn mr20" id="search"> <input
                        type="button" value="重 置" id="reset" class="btn mr20"> <input
                        type="button" value="更多查询" class="btn mr20 js-more-query">
                </div>
            </div>
        </form>
    </div>
</div>
<div>
    <table id="search-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th><input type="checkbox" class="chbAll">选择</th>
            <th>统一信用代码</th>
            <th>注册号</th>
            <th>企业名称</th>
            <th>法定代表人</th>
            <th>企业类型</th>
            <th>行业</th>
            <th>住所</th>
            <th>登记机关</th>
            <th>管辖单位</th>
            <th>历史预警记录</th>
        </tr>
        </thead>
    </table>
    <div class="form-item clearfix">
        <div class="btn-box">
            <input type="button" value="确定添加选中企业" class="btn" id="getData">
        </div>
    </div>
</div>
<h6 class="h6-title mt20 mb5 light-yellow">第二步：添加预警提示标识</h6>
<div class="clearfix mb5">
    <p class="fl">
        <input type="button" class="btn btn-sm mr5" id="cancel" value="返回"><input
            type="button" class="btn btn-sm" id="enaddmark" value="增加预警标识"><span
            class="ml20">您已经选中了<span id="entNum"></span>家企业</span>
    </p>
</div>
<div style="padding-bottom: 50px;">
    <table border="0" cellspacing="0" cellpadding="0"
           class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th style="text-align: center;width: 60px;">操作</th>
            <th style="text-align: center;width: 100px;">统一信用代码</th>
            <th style="text-align: center;width: 100px;">注册号</th>
            <th style="text-align: center;width: 150px;">企业名称</th>
            <th style="text-align: center;width: 100px;">法定代表人</th>
            <th style="text-align: center;width: 100px;">企业类型</th>
            <th style="text-align: center;width: 100px;">行业</th>
            <th style="text-align: center;width: 150px;">住所</th>
            <th style="text-align: center;width: 100px;">登记机关</th>
            <th style="text-align: center;width: 100px;">管辖单位</th>
            <th style="text-align: center;width: 100px;">历史预警记录</th>
        </tr>
        </thead>
        <tbody id="enttbody">
        </tbody>
    </table>
</div>
<script>
    window._CONFIG = {
        select_regOrg_url: '<c:url value="/commom/server/regorg/regorgmutiselect"/>',
        select_localAdm_url: '<c:url value="/commom/server/regunit/regunitmutiselect"/>',
        select_entType_url: '<c:url value="/commom/server/entcatg/entcatgmutiselect"/>',
        select_industryCo_url: '<c:url value="/commom/server/industry/toIndustryPhyTree"/>'
    }
</script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/risk/entwarninfo/entwarnapply_add.js"></script>
</body>
</html>