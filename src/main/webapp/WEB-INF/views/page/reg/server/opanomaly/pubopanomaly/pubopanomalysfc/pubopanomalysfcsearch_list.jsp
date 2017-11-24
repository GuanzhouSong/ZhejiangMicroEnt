<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>经营异常名录查询列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box pd14-mr"> 
         <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一代码/注册号：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniCode_regNO" value="" placeholder="统一信用代码/注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
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
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value="" placeholder="请选择登记机关" readonly="readonly"/>
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                        </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="请选择管辖单位" readonly="readonly"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">责任区：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNO" value=""/>
                            <input type="text" class="ipt-txt" id="sliceNoName" value="" placeholder="请选择责任区"/>
	                         <span class="add-icon" id="chooseSliceNo">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">作出决定机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="decorgCN" value="" placeholder="请输入决定机关名称"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">成立日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   id="startExtDate" name="startExtDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" id="endExtDate"
                                   name="endExtDate" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">列入文号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="penDecNo" value="" placeholder="请输入列入文号"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4"> 
                    <label class="item-name col-5">初审人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="firstName" value="" placeholder="请输入初审人"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">列入日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   name="startAbnTime" id="startCogDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   name="endAbnTime" id="endCogDate" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">列入原因：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11"> 
                            <input type="hidden" class="ipt-txt" name="speCause" id="speCause" value=""/>
                            <input type="text" class="ipt-txt text-over" value="" placeholder="请选择列入原因" id="speCauseText" readonly="readonly"/>
                            <span class="add-icon" id="select-intercept_in">
                                <i></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">审核人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="auditName" value="" placeholder="请输入审核人"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">移出日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text"  class="ipt-txt laydate-icon" readonly="readonly"
                                   name="starRemDate" id="startNorDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   name="endRemDate" id="endNorDate" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">移出原因：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="remExcpres" id="remExcpres" value=""/>
                            <input type="text" class="ipt-txt text-over" value="" placeholder="请选择移出原因" id="remExcpresText" readonly="readonly"/>
                            <span class="add-icon" id="select-intercept">
                                <i></i>
                            </span> 
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">年报年度：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="year">
                                <option value="">全部</option>
                               <c:forEach var="nowYear" items="${yearList}" varStatus="status" >
			        		    <option value="${nowYear}">${nowYear}</option>
		        		       </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">列入状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="inState">
                                <option value="">全部</option>
                                <option value="1">已移出</option>
                                <option value="2">未移出</option>
                                <option value="3">已撤销</option>
                            </select>
                        </div>
                    </div>
                </div>
                <!-- <div class="col-4">
                    <label class="item-name col-5">年报年度：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="year">
                               <option value=""  >全部</option>
                               <option value="2016" >2016</option>
                               <option value="2015" >2015</option>
                               <option value="2014" >2014</option>
                              </select>
                        </div>
                    </div>
                </div> -->
            </div>
            <div class="form-group clearfix">
                <div class="center mt10">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
    <div class="light-info mt5 mb5">
        <p class="light">提示：查询范围仅限截止当前有过列入异常记录的农民专业合作社。</p>
        <!-- <i class="xbt-icon close"></i> -->
    </div>
    <p class="tip-info left mb5">查询结果：
        列入并公示农民专业合作社<span id="isPubCount" class="light-blue">0</span>家,
        其中列入未移出农民专业合作社<span id="isInAndNotOutCount" class="light-blue">0</span>家,
        列入已移出农民专业合作社<span id="isInAndIsOutCount" class="light-blue">0</span>家。
    </p>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="pubopanomalylist_table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
                            <th>列入决定书文号</th>
                            <th>统一代码</th>
                            <th>注册号</th>
                            <th>企业名称</th>
                            <th>法定代表人</th>
                            <th>成立日期</th>
                            <th>列入原因</th>
                            <th>列入日期</th>
                            <th>列入决定机关</th>
                            <th>状态</th>
                            <th>移出决定书文号</th>
                            <th>移出原因</th>
                            <th>移出/撤销日期</th>
                            <th>移出/撤销决定机关</th>
                            <th>移出/撤销事实和事由</th>
                            <th>住所地</th>
                            <th>登记机关</th>
                            <th>管辖单位</th>
                            <th>责任区</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
  <script src="<c:url value="/js/lib/require.js"/>"></script>
  <script src="<c:url value="/js/config.js"/>"></script>
  <script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopanomalysfc/pubopanomalysfcsearch_list_main.js"/>"></script>
</body>
</html>