<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>个转企调查表统计</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">年度：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="year" id="year">
                                <option value="">全部</option>
                                <c:forEach items="${yearList}" var="year" varStatus="status">
	                 				<option value="${year}"
	                 				<c:if test="${year==yearOption }">selected</c:if>
	                 				>${year}</option>
		                 		</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">提交日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" id="setDateStart" name="setDateStart" value="${setDateStart }"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" id="setDateEnd" name="setDateEnd" value="${setDateEnd }"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value="${regOrgs }"/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="regOrgName" value="${regOrgNames }" />
                            <span class="add-icon" id="choseorgReg">
                                <i></i>
                         	</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <div class="form-box">
	    <div class="form-item clearfix">
	       <div class="col-4">
	           <label class="item-name col-5">统计方式：</label>
	           <div class="col-7">
	               <div class="ipt-box col-11">
	                   <input type="radio" value="1" name="countType" id="riseRate" checked="checked"> 按增长率 
	                   <input type="radio" value="2" name="countType" id="investMethod" > 调查量 
	               </div>
	           </div>
	       </div>
	   </div>
   </div>
   <div class="form-group clearfix">
       <div class="center mt10">
           <input type="button" id="js-search-1" value="查询" class="btn mr20">
           <input type="button" id="cancel" value="重置" class="btn mr20">
       </div>
   </div>
 <div id="div1">
      <div class="light-info mt5 mb5">
          <span>调查数量：共 ${individQueMainDto.count } 户</span>
      </div>
      <table id="user" border="0" cellspacing="0" cellpadding="0" class="table-row mt30"
             style="width: 100%;white-space: nowrap;">
          <thead>
           <tr>
               <th style="min-width: 30px">序号</th>
               <th style="min-width: 100px">项目</th>
               <th style="min-width: 70px">转企前</th>
               <th style="min-width: 70px">转企后</th>
               <th style="min-width: 70px">增长率</th>
           </tr>
           <tr>
           	<td>1</td>
           	<td>年产值或营业额（元）</td>
           	<td>${individQuestionnaireDtoBefore.vendIncTotal }</td>
           	<td>${individQuestionnaireDtoAfter.vendIncTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.vendIncTotal!=0&&individQuestionnaireDtoBefore.vendIncTotal!=null&&individQuestionnaireDtoBefore.vendIncTotal!='0.000000' }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.vendIncTotal-individQuestionnaireDtoBefore.vendIncTotal)/individQuestionnaireDtoBefore.vendIncTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.vendIncTotal==0||individQuestionnaireDtoBefore.vendIncTotal==null||individQuestionnaireDtoBefore.vendIncTotal=='0.000000' }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>2</td>
           	<td>年利润（元）</td>
           	<td>${individQuestionnaireDtoBefore.proGroTotal }</td>
           	<td>${individQuestionnaireDtoAfter.proGroTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.proGroTotal!=0&&individQuestionnaireDtoBefore.proGroTotal!=null&&individQuestionnaireDtoBefore.proGroTotal!='0.000000' }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.proGroTotal-individQuestionnaireDtoBefore.proGroTotal)/individQuestionnaireDtoBefore.proGroTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.proGroTotal==0||individQuestionnaireDtoBefore.proGroTotal==null||individQuestionnaireDtoBefore.proGroTotal=='0.000000' }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>3</td>
           	<td>年纳税总额（元）</td>
           	<td>${individQuestionnaireDtoBefore.ratGroTotal }</td>
           	<td>${individQuestionnaireDtoAfter.ratGroTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.ratGroTotal!=0&&individQuestionnaireDtoBefore.ratGroTotal!=null&&individQuestionnaireDtoBefore.ratGroTotal!='0.000000' }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.ratGroTotal-individQuestionnaireDtoBefore.ratGroTotal)/individQuestionnaireDtoBefore.ratGroTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.ratGroTotal==0||individQuestionnaireDtoBefore.ratGroTotal==null||individQuestionnaireDtoBefore.ratGroTotal=='0.000000' }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>4</td>
           	<td>年缴纳社保总费用（元）</td>
           	<td>${individQuestionnaireDtoBefore.socInsTotal }</td>
           	<td>${individQuestionnaireDtoAfter.socInsTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.socInsTotal!=0&&individQuestionnaireDtoBefore.socInsTotal!=null }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.socInsTotal-individQuestionnaireDtoBefore.socInsTotal)/individQuestionnaireDtoBefore.socInsTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.socInsTotal==0||individQuestionnaireDtoBefore.socInsTotal==null }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>5</td>
           	<td>经营面积（㎡）</td>
           	<td>${individQuestionnaireDtoBefore.opSpaceTotal }</td>
           	<td>${individQuestionnaireDtoAfter.opSpaceTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.opSpaceTotal!=0&&individQuestionnaireDtoBefore.opSpaceTotal!=null }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.opSpaceTotal-individQuestionnaireDtoBefore.opSpaceTotal)/individQuestionnaireDtoBefore.opSpaceTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.opSpaceTotal==0||individQuestionnaireDtoBefore.opSpaceTotal==null }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>6</td>
           	<td>从业人员数（人）</td>
           	<td>${individQuestionnaireDtoBefore.empNumTotal }</td>
           	<td>${individQuestionnaireDtoAfter.empNumTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.empNumTotal!=0&&individQuestionnaireDtoBefore.empNumTotal!=null }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.empNumTotal-individQuestionnaireDtoBefore.empNumTotal)/individQuestionnaireDtoBefore.empNumTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.empNumTotal==0||individQuestionnaireDtoBefore.empNumTotal==null }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>7</td>
           	<td>参加社保数（人）</td>
           	<td>${individQuestionnaireDtoBefore.insuredTotal }</td>
           	<td>${individQuestionnaireDtoAfter.insuredTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.insuredTotal!=0&&individQuestionnaireDtoBefore.insuredTotal!=null }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.insuredTotal-individQuestionnaireDtoBefore.insuredTotal)/individQuestionnaireDtoBefore.insuredTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.insuredTotal==0||individQuestionnaireDtoBefore.insuredTotal==null }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>8</td>
           	<td>企业融资情况（元）</td>
           	<td>${individQuestionnaireDtoBefore.comLoanTotal }</td>
           	<td>${individQuestionnaireDtoAfter.comLoanTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.comLoanTotal!=0&&individQuestionnaireDtoBefore.comLoanTotal!=null&&individQuestionnaireDtoBefore.comLoanTotal!='0.000000' }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.comLoanTotal-individQuestionnaireDtoBefore.comLoanTotal)/individQuestionnaireDtoBefore.comLoanTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.comLoanTotal==0||individQuestionnaireDtoBefore.comLoanTotal==null||individQuestionnaireDtoBefore.comLoanTotal=='0.000000' }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>9</td>
           	<td>注册商标件数（件）</td>
           	<td>${individQuestionnaireDtoBefore.domTraRegsTotal }</td>
           	<td>${individQuestionnaireDtoAfter.domTraRegsTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.domTraRegsTotal!=0&&individQuestionnaireDtoBefore.domTraRegsTotal!=null }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.domTraRegsTotal-individQuestionnaireDtoBefore.domTraRegsTotal)/individQuestionnaireDtoBefore.domTraRegsTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.domTraRegsTotal==0||individQuestionnaireDtoBefore.domTraRegsTotal==null }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>10</td>
           	<td>注册专利件数（件）</td>
           	<td>${individQuestionnaireDtoBefore.patAmountTotal }</td>
           	<td>${individQuestionnaireDtoAfter.patAmountTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.patAmountTotal!=0&&individQuestionnaireDtoBefore.patAmountTotal!=null }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.patAmountTotal-individQuestionnaireDtoBefore.patAmountTotal)/individQuestionnaireDtoBefore.patAmountTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.patAmountTotal==0||individQuestionnaireDtoBefore.patAmountTotal==null }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>11</td>
           	<td>各类荣誉数（件）</td>
           	<td>${individQuestionnaireDtoBefore.horAmountTotal }</td>
           	<td>${individQuestionnaireDtoAfter.horAmountTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.horAmountTotal!=0&&individQuestionnaireDtoBefore.horAmountTotal!=null }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.horAmountTotal-individQuestionnaireDtoBefore.horAmountTotal)/individQuestionnaireDtoBefore.horAmountTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.horAmountTotal==0||individQuestionnaireDtoBefore.horAmountTotal==null }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td rowspan="2">12</td>
           	<td>纳税人类型（一般）</td>
           	<td>${individQuestionnaireDtoBefore.taxpayerTypeCommTotal }</td>
           	<td>${individQuestionnaireDtoAfter.taxpayerTypeCommTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.taxpayerTypeCommTotal!=0&&individQuestionnaireDtoBefore.taxpayerTypeCommTotal!=null }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.taxpayerTypeCommTotal-individQuestionnaireDtoBefore.taxpayerTypeCommTotal)/individQuestionnaireDtoBefore.taxpayerTypeCommTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.taxpayerTypeCommTotal==0||individQuestionnaireDtoBefore.taxpayerTypeCommTotal==null }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>纳税人类型（小规模）</td>
           	<td>${individQuestionnaireDtoBefore.taxpayerTypeSmallscaleTotal }</td>
           	<td>${individQuestionnaireDtoAfter.taxpayerTypeSmallscaleTotal }</td>
           	<td>
           		<c:if test="${individQuestionnaireDtoBefore.taxpayerTypeSmallscaleTotal!=0&&individQuestionnaireDtoBefore.taxpayerTypeSmallscaleTotal!=null }">
           			<fmt:formatNumber type="number" value="${(individQuestionnaireDtoAfter.taxpayerTypeSmallscaleTotal-individQuestionnaireDtoBefore.taxpayerTypeSmallscaleTotal)/individQuestionnaireDtoBefore.taxpayerTypeSmallscaleTotal*100 }" pattern="0.0000" maxFractionDigits="2"/>%
           		</c:if>
           		<c:if test="${individQuestionnaireDtoBefore.taxpayerTypeSmallscaleTotal==0||individQuestionnaireDtoBefore.taxpayerTypeSmallscaleTotal==null }">
           			0%
           		</c:if>
           	</td>
           </tr>
           <tr>
           	<td>13</td>
           	<td>做大做强信心</td>
           	<td>有信心：${individQueMainDto.hasQueFaith }户</td>
           	<td>无信心：${individQueMainDto.noQueFaith }户</td>
           	<td>不确定：${individQueMainDto.notSure }户</td>
           </tr>
           <tr>
           	<td>14</td>
           	<td>优惠政策兑现情况</td>
           	<td>财政一次性奖励：${individQueMainDto.quePolicyAllTotal }户</td>
           	<td>地税留地方部分补助：${individQueMainDto.quePolicyPartTotal }户</td>
           	<td>社保补助：${individQueMainDto.quePolicySocTotal }户</td>
           </tr>
          </thead>
      </table>
  </div>
  <div id="div2" style="display: none;margin-top: 5px;">
      <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30"
             style="width: 100%;white-space: nowrap;">
          <thead>
           <tr>
               <th rowspan="2">序号</th>
               <th rowspan="2">登记机关</th>
               <th rowspan="2">调查量</th>
               <th colspan="2">纳税人类型</th>
               <th colspan="3">做大做强信心</th>
               <th colspan="3">优惠政策兑现情况</th>
           </tr>
           <tr>
               <th>一般</th>
               <th>小规模</th>
               <th>有信心</th>
               <th>无信心</th>
               <th>不确定</th>
               <th>财政</th>
               <th>地税</th>
               <th>社保</th>
           </tr>
          </thead>
          <tfoot>
	        <tr>
	            <th colspan="2">合计</th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	        </tr> 
	     </tfoot>
      </table>
  </div>
    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script src="/js/reg/server/yr/questionnaire/questionnaire_count.js"></script>
</div>
</body>
</html>
