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
    <title>食品仓储信息查询</title>
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
    <form id="taskForm" class="form-box">
        <input type="hidden" id="fsScopeValue" name="fsScopeValue" value="">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regNo" value="" placeholder="请输入统一代码/注册号">
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
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value="" placeholder="请选择登记机关" readonly="readonly"/>
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">法定代表人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="leRep" value="" placeholder="请输入法定代表人"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">成立日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly"
                                   name="estDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly"
                                   name="estDateEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="请选择管辖单位" readonly="readonly"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">经营范围：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="dom" value="" placeholder="请输入经营范围"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">填报日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly"
                                   name="setTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly"
                                   name="setTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">责任区：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNO" value=""/>
                            <input type="text" class="ipt-txt" id="sliceNOName" value="" placeholder="请选择责任区" readonly="readonly"/>
	                            <span class="add-icon" id="chosesliceNo">
	                            <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">填报状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="submitState">
                                <option value="">全部</option>
                                <option value="2">已填报</option>
                                <option value="1">未填报</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">填报年度：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="year">
                                <option value="">全部</option>
                                <c:forEach items="${yearList}" var="year" varStatus="status">
                                    <option value="${year}">${year}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="entTypeCode" id="entTypeCode" value=""/>
                            <input type="text" class="ipt-txt" id="entTypeName" value="" placeholder="请选择企业类型" readonly="readonly"/>
	                            <span class="add-icon" id="choseEntType">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">仓储类型：</label>
                    <div class="col-7">
                        <div class="radio-box col-12">
                            <input type="checkbox" id="fsscope_1" name="fsscopename" value="1"><label for="fsscope_1"
                                                                                                      style="cursor: pointer;font-weight:normal;" class="font-12">食品生产</label>
                            <input type="checkbox" id="fsscope_2" name="fsscopename" value="2"><label for="fsscope_2"
                                                                                                      style="cursor: pointer;font-weight:normal;" class="font-12">食品经营</label>
                            <input type="checkbox" id="fsscope_3" name="fsscopename" value="3"><label for="fsscope_3"
                                                                                                      style="cursor: pointer;font-weight:normal;" class="font-12">食品仓储服务</label>
                            <input type="checkbox" id="fsscope_5" name="fsscopename" value="5"><label for="fsscope_5"
                                                                                                      style="cursor: pointer;font-weight:normal;" class="font-12">食用农产品</label>
                            <input type="checkbox" id="fsscope_4" name="fsscopename" value="4"><label for="fsscope_4"
                                                                                                      style="cursor: pointer;font-weight:normal;" class="font-12">都不涉及</label>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">抽查机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="checkDep" id="checkDep" value=""/>
                            <input type="text" class="ipt-txt" id="checkDepName" value="" placeholder="请选择抽查机关" readonly="readonly"/>
	                            <span class="add-icon" id="chosecheckDep">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">行业类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="industryCo" id="industryCo" value=""/>
                            <input type="text" class="ipt-txt" id="industryName" value="" placeholder="请选择行业类型" readonly="readonly"/>
		                            <span class="add-icon" id="chooseindustry">
		                            <i></i>
		                         </span>
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
        </div>
    </form>
    <div class="iframe-wrap mt10">
        <table id="foodstoragebase-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt20"
               style="width: 100%;white-space: nowrap;">
            <thead>
            <tr>
                <th style="min-width: 50px">序号</th>
                <th style="min-width: 70px">操作</th>
                <th style="min-width: 70px">统一代码/注册号</th>
                <th style="min-width: 150px">企业名称</th>
                <th style="min-width: 80px">法定代表人</th>
                <th style="min-width: 100px">联系电话</th>
                <th style="min-width: 120px">成立日期</th>
                <th style="min-width: 100px">企业类型</th>
                <th style="min-width: 100px">行业</th>
                <!--        <th>经营范围</th> -->
                <th style="min-width: 100px">仓储类型</th>
                <th style="min-width: 120px">填报日期</th>
                <th style="min-width: 100px">登记机关</th>
                <th style="min-width: 100px">抽查机关</th>
                <th style="min-width: 100px">管辖单位</th>
                <th style="min-width: 100px">责任区</th>
            </tr>
            </thead>
        </table>
    </div>
    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script src="/js/reg/server/yr/foodstoragebase/list_main.js"></script>
</div>
</body>
</html>
