<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>经营异常记录查询</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box pd14-mr">
         <div class="form-list">
            <div class="form-item clearfix">
               <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">主体类别：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <label><input type="radio" name="entTypeFlag" checked="checked" value="01">企业</label>
                            <label><input type="radio" name="entTypeFlag"  value="02">农专社</label>
                            <label><input type="radio" name="entTypeFlag"  value="03">个体户</label>
                        </div>
                    </div>
                </div>
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一代码/注册号：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniCode_regNO" value="" placeholder="统一信用代码/注册号">
                        </div>
                    </div>
                </div>
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
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">列入原因：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="speCause" id="speCause" value=""/>
                            <input type="text" class="ipt-txt text-over" value="" placeholder="请选择列入原因" id="speCauseText" readonly="readonly"/>
                            <span class="add-icon" id="select-intercept_in">
                                <i></i>
                            </span>
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
            </div>
            <div class="form-item clearfix">
            	<div id="remType" class="col-4">
                    <label class="item-name col-5"><span class="long-label">移出类型：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <label><input type="checkbox" name="shiftOutType"  value="1">正常移出</label>
                            <label><input type="checkbox" name="shiftOutType"  value="3">更正移出</label>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">正常移出原因：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="remExcpres" id="remExcpres" value=""/>
                            <input type="text" class="ipt-txt text-over" value="" placeholder="请选择移出原因" id="remExcpresText" readonly="readonly"/>
                            <span class="add-icon" id="select-intercept">
                                <i></i>
                            </span> 
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">列入状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select id="inState" name="inState">
                                <option value="">全部</option>
                                <option value="1">已移出</option>
                                <option value="2">未移出</option>
                                <option value="3">已撤销</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix moresearch_oth" style="display:none">
                <div class="col-4">
                    <label class="item-name col-5">决定书文号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="penDecNo" value="" placeholder="请输入决定书文号"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">法定代表人/负责人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep" value="" placeholder="请输入法定代表人"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">责任区：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNO" value=""/>
                            <input type="text" class="ipt-txt" id="sliceNoName" value="" placeholder="请选择责任区" readonly="readonly"/>
	                         <span class="add-icon" id="chooseSliceNo">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix moresearch_oth" style="display:none">
                <div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                        	<input type="hidden" name="regState" id="regState">
                            <select  class="clx_one" multiple="multiple" id="regStateM" name="regStateM">
                                 <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}'>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">列入日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="startAbnTime"
                                   id="startCogDate" value=""/>

                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="endAbnTime"
                                   id="endCogDate" value=""/>
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                    <label class="item-name col-5">住所地：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="dom" value="" placeholder="请输入住所地"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix moresearch_oth" style="display:none">
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
                    <label class="item-name col-5">移出日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
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
                    <label class="item-name col-5">列入机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="decorgCN" value="" placeholder="请输入决定机关名称"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix moresearch_oth" style="display:none">
                <div class="col-4 yearhis">
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
                    <label class="item-name col-5">企业类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="entType" id="entTypeCode" value=""/>
                            <input type="text" class="ipt-txt" id="entTypeName" value="" placeholder="请选择企业类型" readonly="readonly"/>
	                            <span class="add-icon" id="choseEntType">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">移出机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="reDecOrgCN" value="" placeholder="请输入决定机关名称"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix moresearch_oth" style="display:none">
                <div class="col-4">
                    <label class="item-name col-5">简易注销：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="isErescEnt">
                                <option value="">全部</option>
                                <option value="1">是</option>
                                <option value="0">否</option>  
                            </select>
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                    <label class="item-name col-5">个转企：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="isIndivid">
                                <option value="">全部</option>
                                <option value="1">是</option>
                                <option value="0">否</option>  
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">行业类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="industryCo" id="industryCo" value=""/>
                            <input type="text" class="ipt-txt" id="industryName" value="" placeholder="请选择行业类型" readonly="readonly"/>
	                            <span class="add-icon" id="chooseindustry">
	                            <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="center mt10">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                    <input type="button" value="更多查询条件" status='0' id="moresearch" class="btn mr20">
                </div>
            </div>
        </div>
    </form>

    <div class="light-info mt5">
        <span class="light">提示：查询范围为截止当前列入经营异常历史记录信息。<i class="light-box-y mr5"></i>表示企业正在进行简易注销公告。</span>
        <!-- <i class="xbt-icon close"></i> -->
    </div>
    <p class="tip-info left mb5">
        <input type="button" id="countResult" value="统计结果请点击" class="btn">：
	            列入对象&nbsp;<span id="disCountAllTotal"class="light-blue">0</span>&nbsp;家,共&nbsp;<span id="countAll"class="light-blue">0</span>&nbsp;条,
	            其中列入未移出&nbsp;<span id="disNoShiftOutTotal"class="light-blue">0</span>&nbsp;家,共&nbsp;<span id="noShiftOutAll"class="light-blue">0</span>&nbsp;条,
	            正常移出&nbsp;<span id="disShiftOutTotal"class="light-blue">0</span>&nbsp;家,共&nbsp;<span id="shiftOutCount"class="light-blue">0</span>&nbsp;条，
	            更正移出&nbsp;<span id="disChangeOutTotal"class="light-blue">0</span>&nbsp;家,共&nbsp;<span id="changeOutCount"class="light-blue">0</span>&nbsp;条。
    </p>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="pubopanomalylist_table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
                            <th>操作</th>
                            <th>登记状态</th>
                            <th>统一社会信用代码/注册号</th>
                            <th>企业名称</th>
                            <th>法定代表人/负责人</th>
                            <th>状态</th>
                            <th>列入文号</th>
                            <th>列入异常原因</th>
                            <th>列入日期</th>
                            <th>列入机关</th>
                            <th>移出文号</th>
                            <th>移出异常原因</th>
                            <th>移出日期</th>
                            <th>移出机关</th>
                            <th>成立日期</th>
                            <th>住所</th>
                            <th>登记机关</th>
                            <th>管辖单位</th>
                            <th>片区</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script>
    window._CONFIG = {
       chooseUrl:'${userType == 2 ? "/syn" : "/reg"}', 
    }
    </script>
    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script src="<c:url value="/js/reg/server/opanomaly/opanosearch/opanohissearch_list.js"/>"></script>
</body>
</html>