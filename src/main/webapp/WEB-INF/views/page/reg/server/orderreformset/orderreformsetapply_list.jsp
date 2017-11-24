<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>责令整改企业列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="form-box pd14-mr">
    <form id="qryForm">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cidRegNO">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">法定代表人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">行业：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" id="industryCoName" class="ipt-txt clx" value="" readonly/>
                            <input type="hidden" id="industryCo" name="industryCo" class="clx" value=""/>
                            <a id="selectIndustry" class="link js-show">
                                <span class="add-icon" id="choseIndustryCo"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 企业类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" id="entTypeName" class="ipt-txt clx" value="" readonly/>
                            <input type="hidden" id="entType" name="entType" class="clx" value=""/>
                            <a id="selectEntType" class="link js-show">
                                <span class="add-icon" id="choseEntType"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 住所：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="dom">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" id="localAdmName" class="ipt-txt clx" value="" readonly/>
                            <input type="hidden" id="localAdm" name="localAdm" class="clx" value=""/>
                            <a id="selectLocalAdm" class="link js-show">
                                <span class="add-icon" id="choseregUnit"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" id="regOrgName" class="ipt-txt clx" value="" readonly/>
                            <input type="hidden" id="regOrg" name="regOrg" class="clx" value=""/>
                            <a id="selectRegOrg" class="link js-show">
                                <span class="add-icon" id="choseorgReg"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">经营范围：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="opScope">
                        </div>
                    </div>
                </div>
            </div>
            <!-- 更多查询条件------------------------------------------------------------------------------------------------------ -->
            <div class="form-item-more"  id="hideorshow" style="display:none" >
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">成立日期：</label>
                        <div class="col-7">
                            <div class="ipt-box col-575">
                                <input type="text" class="ipt-txt laydate-icon clx" readonly="readonly"
                                       onclick="laydate();" name="estDateStart">
                            </div>
                            <span class="item-line col-05">-</span>
                            <div class="ipt-box col-575">
                                <input type="text" class="ipt-txt laydate-icon clx" readonly="readonly"
                                       onclick="laydate();" name="estDateEnd">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">核准日期：</label>
                        <div class="col-7">
                            <div class="ipt-box col-575">
                                <input type="text" class="ipt-txt laydate-icon clx" onclick="laydate();"
                                       readonly="readonly" name="apprDateStart">
                            </div>
                            <span class="item-line col-05">-</span>
                            <div class="ipt-box col-575">
                                <input type="text" class="ipt-txt laydate-icon clx" onclick="laydate();"
                                       readonly="readonly" name="apprDateEnd">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">营运状况：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <select name="regState">
                                    <c:forEach var="regState" items="${regStateEnumMap}">
                                		<c:if test="${regState.value == 'CUNXU' ||  regState.value == 'DIAOXIAO'}">
                                		<option value='${regState.value.code}'>${regState.value.name}</option>
                                		</c:if>
                            		</c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">许可证名称：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="licName">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5"> 许可证状态：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <select name="licState">
                                    <option value="">不限</option>
                                    <option value="Y">有效</option>
                                    <option value="N">无效</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5"> 注册资本：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <div class="ipt-box col-575">
                                    <input type="text" class="ipt-txt" name="regCapStart">
                                </div>
                                <span class="item-line col-05">-</span>
                                <div class="ipt-box col-575">
                                    <input type="text" class="ipt-txt" name="regCapEnd">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">信用等级：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <select name="">
                                    <option value="">暂无数据</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">是否有行政处罚：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <select name="isCase">
                                    <option value="">请选择</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">是否进入异常名录</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <select name="isOpan">
                                    <option value="">请选择</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">法人是否受限：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <select name="leRepIsLim">
                                    <option value="">请选择</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">是否有风险预警：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <select name="isRiskWarn">
                                    <option value="">请选择</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
            <!-- 更多查询条件 end -------------------------------------------------------------------------------------------------------- -->
            <div class="">
                <div class="center mt10">
                    <input id="qry" type="button" value="查 询" class="btn mr20">
                    <input id="cancel" type="button" value="重 置" class="btn mr20">
                    <input type="button" id="more" value="更多查询条件" class="btn mr20 js-fold">
                </div>
            </div>
        </div>
    </form>
</div>

<div class="clearfix mb5 mt5">
    <p class="fl"><input type="button" class="btn btn-sm mr5" value="返回" id="backOrderReformSet"></p>
    <p class="fl"><input type="button" class="btn btn-sm mr5" value="增加责令整改" id="orderReformSetapply"></p>
    <!-- <p class="fl"><input type="button" class="btn btn-sm mr5" value="导出" id=""></p> -->
</div>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
        <thead>
        <tr>
            <th style="padding:0 20px;">序号</th>
            <th>单选</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th> 法定代表人</th>
            <th>企业类型</th>
            <th> 行业</th>
            <th>住所</th>
            <th>登记机关</th>
            <th>管辖单位</th>
        </tr>
        </thead>
    </table>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/orderreformset/orderreformsetapply_list_main.js"/>"></script>
</body>
</html>
