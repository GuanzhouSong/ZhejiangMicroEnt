<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>批量列入异常（企业、农专社）</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">列入对象：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" name="batchEntTypes" id="batchEntTypes" value="1,2,3">
                            <input type="checkbox" name="entCatg" checked="checked" value="1">内资企业
                            <input type="checkbox" name="entCatg" checked="checked" value="3">外资企业
                            <input type="checkbox" name="entCatg" checked="checked" value="2">农专社
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">列入文号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="penDecNo" value="" placeholder="">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">决定机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" readonly="readonly" class="ipt-txt" name="decorgCN" value="${codeRegorg.content }"/>
                            <input type="hidden" class="ipt-txt" name="decOrg" id="decOrg" value="${codeRegorg.code }"/>
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
				        		     <option value="${nowYear}" <c:if test="${nowYear == nowNbYear}">selected</c:if> >${nowYear}</option>
			        		        </c:forEach>  
	                             </select>
	                        </div>
	                    </div>
	             </div>
                <div class="col-4">
                    <label class="item-name col-5">决定日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   name="startAbnDate" id="startAbnDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   name="endAbnDate" id="endAbnDate" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">初审日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   name="starFirstDate" id="starFirstDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   name="endFirstDate" id="endFirstDate" value=""/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">初审人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="firstName" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="auditName" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   name="startAuditDate" id="startAuditDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"
                                   name="endAuditDate" id="endAuditDate" value=""/>
                        </div>
                    </div> 
               </div>
          </div>
        <div class="center mt10">
            <input type="button" id="js-search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
        </div>
        </div>
    </form>
</div>

 <div class="clearfix mt5">
     <p class="fl"><input type="button" class="btn btn-sm mr5" value="新增批量列入异常记录" id="addBatchIn"></p>
 </div>
 <div class="light-info mt5 mb5">
     <span class="light">提示：查询范围仅为本部门对未按时年报情形的批量列入异常记录信息。批量列入完成后可打印“经营异常名录审批表”与“列入经营异常名录决定书”。批量列入异常信息将自动通过公示系统记名对应的企业进行公示。 发现错误批量列入异常的对象时，请通过更正移出进行修正。</span>
 </div>
<div class="tab-content mb20 mt10">
    <div class="tab-panel tab-panel-show">
        <div class="">
            <div class="table-out">
                <table id="user-table" border="0" cellspacing="0" cellpadding="0" width="100%" class="table-row display nowrap">
                    <thead>
	                    <tr>
	                        <th>序号</th>
	                        <th>操作</th>
	                        <th>年报年度</th>
	                        <th>列入对象</th>
	                        <th>初始列入数量</th>
	                        <th>实际有效列入</th>
	                        <th>后续更正移出</th>
	                        <th>决定日期</th>
	                        <th>列入文号</th>
	                        <th>列入异常原因</th>
	                        <th>决定机关</th>
	                        <th>初审人</th>
	                        <th>初审日期</th>
	                        <th>审核人</th>
	                        <th>审核日期</th>
	                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
window._CONFIG = {
	       _decOrg:'${codeRegorg.code }'
	     }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalybatch_list.js"></script>
</body>
</html>
