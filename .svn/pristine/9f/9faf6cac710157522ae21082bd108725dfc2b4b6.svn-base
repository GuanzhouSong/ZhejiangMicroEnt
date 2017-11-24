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
    <title>司法协助信息查询</title>
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
                    <label class="item-name col-5">注册号/统一代码：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regNO" value="" placeholder="请输入注册号/统一代码">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">股权所在企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入股权所在企业名称">
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
                    <label class="item-name col-5">被执行人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="inv" value="" placeholder="请输入被执行人">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">被执行人证照号码：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cerNO" value="" placeholder="请输入被执行人证照号码">
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
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">股权冻结状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select id="frozState" name="frozState">
                                <option value="">全部</option>
                                <option value="1">冻结</option>
                                <option value="2">解除冻结</option>
                                <option value="3">失效</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">工商公示日期：</label>
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
                    <label class="item-name col-5">执行事项：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select id="executeItem" name="executeItem">
                                <option value="">全部</option>
                                <option value="1">公示冻结股权、其他投资权益</option>
                                <option value="2">续行冻结股权、其他投资权益</option>
                                <option value="3">解除冻结股权、其他投资权益</option>
                                <option value="4">强制转让被执行人股权，办理有限责任公司股东变更登记</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">司法公示日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="publicDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="publicDateEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                     <label class="item-name col-5">执行法院：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="executionCourt" value="" placeholder="请输入执行法院">
                         </div>
                     </div>
                 </div>
            </div>
            <div class="form-item clearfix">
               <div class="col-4">
                     <label class="item-name col-5">公示信息类别：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <select id="justiceType" name="justiceType">
			                      <option value="">全部</option>
			                      <option value="1">股权冻结信息</option>
			                      <option value="2">股东强制变更信息</option>
			                 </select>
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">受让人：</label>
                     <div class="col-7">
                         <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="assInv" value="" placeholder="请输入受让人">
                         </div>
                     </div>
                 </div>
            </div>
        </div>
        <div class="form-group clearfix mt10">
            <div class="center">
                <input type="button" id="search" value="查询" class="btn mr20">
                <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
            </div>
        </div>
    </form>
    <div>
        <div class="light-info mb5 mt5">
            <p class="light">查询结果：
                司法协助公示企业共<span id="totalAll">0</span>家， 共<span id="amountAll">0</span>条；
                其中股权冻结信息<span id="oneCount">0</span>条； 股东强制变更信息<span id="twoCount">0</span>条。
            </p>
        </div>
        <table id="justiceInfo_table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
            <thead>
            <tr>
                <th>序号</th>
                <th>操作</th>
                <th>股权所在企业统一代码</th>
                <th>股权所在企业注册号</th>
                <th>股权所在企业名称</th>
                <th>公示信息类别</th>
                <th>执行事项</th>
                <th>被执行人</th>
                <th>被执行人证照号码</th>
                <th>股权数额</th>
                <th>执行法院</th>
                <th>股权冻结状态</th>
                <th>受让人</th>
                <th>司法公示时间</th>
                <th>工商公示时间</th>
                <th>登记机关</th>
                <th>管辖单位</th>
                <th>责任区</th>
            </tr>
            </thead>
        </table>
    </div>
    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script src="<c:url value="/js/reg/server/other/pubjusticeinfo/pubjusticeinfosearch_list_main.js"/>"></script>
</div>
</body>
</html>
