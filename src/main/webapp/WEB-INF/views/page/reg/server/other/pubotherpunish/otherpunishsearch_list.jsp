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
    <title>行政处罚信息查询</title>
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
     <input type="hidden" id="userType" value="${userType }">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regNO" value="" placeholder="请输入注册号">
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
                    <label class="item-name col-5">法定代表人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="leRep" value="" placeholder="请输入法定代表人"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">处罚决定书文号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="penDecNo" value="" placeholder="请输入处罚决定书文号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">处罚决定机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="judAuth" value="" placeholder="请输入处罚决定机关"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">经营范围：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="opScope" value="" placeholder="请输入经营范围"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">违法行为类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="illegActType" value="" placeholder="请输入违法行为类型"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">处罚变更：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select id="status" name="isAlter">
                                <option value="">全部</option>
                                <option value="1">有</option>
                                <option value="0">无</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">责任区：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNO" value=""/>
                            <input type="text" class="ipt-txt" id="sliceNOName" value="" readonly="readonly" placeholder="请选择责任区"/>
	                            <span class="add-icon" id="chosesliceNo">
	                            <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">来源：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select id="status" name="punSource">
                                <option value="">全部</option>
                                <option value="1">其它部门公示</option>
                                <option value="2">工商部门公示</option>
                                <option value="3">企业公示</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">处罚决定日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="penDecIssDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="penDecIssDateEnd" value=""/>
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
                    <label class="item-name col-5">企业状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select id="regState" name="regState">
                                <option value="">全部</option>
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}'>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">公示日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="auditDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="auditDateEnd" value=""/>
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
            <div class="form-group clearfix">
                <div class="center mt10">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
    <div class="iframe-wrap">
        <div class="light-info mb5 mt5">
            <span class="light">说明：查询范围仅限截止当前所公示的行政处罚信息。</span>
        </div>
        <p class="tip-info left mb5">查询结果：
            行政处罚公示企业共<span id="totalAll"class="light-blue">0</span>家,<span id="amountAll"class="light-blue">0</span>条,
            其中，来自工商部门公示为<span id="businessTotal"class="light-blue">0</span>家,<span id="businessAmount"
                                                                                   class="light-blue">0</span>条,
            来自其他部门公示为<span id="otherTotal"class="light-blue">0</span>家,<span id="otherAmount"
                                                                             class="light-blue">0</span>条。
            来自企业公示为<span id="comTotal"class="light-blue">0</span>家,<span id="comAmount"class="light-blue">0</span>条。
        </p>
        <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
            <thead>
            <tr>
                <th>序号</th>
                <th>操作</th>
                <th>处罚决定书文号</th>
                <th>违法行为类型</th>
                <th>处罚决定机关</th>
                <th>处罚决定日期</th>
                <th>处罚变更</th>
                <th>来源</th>
                <th>公示日期</th>
                <th>注册号</th>
                <th>企业名称</th>
                <th>企业状态</th>
                <th>住所</th>
                <th>登记机关</th>
                <th>管辖单位</th>
                <th>责任区</th>
            </tr>
            </thead>
        </table>
    </div>
    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script src="/js/reg/server/other/otherpunish/otherpunishsearch_list_main.js"></script>
</div>
</body>
</html>
