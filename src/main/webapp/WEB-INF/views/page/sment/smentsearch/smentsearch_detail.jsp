<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>小微企业信息查询详细信息</title>
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<style type="text/css">
.gold{background-color: #fff;}
</style>
<body class="pd10">
<form id="hx-form">
    <input type="hidden" id="priPID" name="priPID" value="${dto.priPID}">
    <input type="hidden" id="regNO" name="regNO" value="${dto.regNO}">
    <input type="hidden" id="uniCode" name="uniCode" value="${dto.uniCode}">
    <input type="hidden" id="entName" name="entName" value="${dto.entName}">
    <input type="hidden" id="entTypeCatg" name="entTypeCatg" value="${dto.entTypeCatg}">
</form>
<div class="clearfix reg-company-basic reg-company-basic-yellowish">
    <div class="clearfix reg-caption">
        <div class="title clearfix">
            <span class="name fl mr5">${dto.entName}</span>
            <span class="${hx:yReportStyle(dto.regState)}">${hx:publicStatus(dto.regState)}</span>
            <c:if test="${dto.isIndivid=='1'}"> 
             <span class="icon-rectangle blue fl mr10">个转企</span>
            </c:if>
            <c:if test="${isOpanomaly=='1'}">
             <span class="icon-rectangle red fl mr10">被列入经营异常名录和严重违法失信（黑名单）</span>
            </c:if>
            <c:if test="${isOpanomaly=='2'}">
             <span class="icon-rectangle red fl mr10">被列入经营异常名录</span>
            </c:if>
            <c:if test="${isOpanomaly=='3'}">
             <span class="icon-rectangle red fl mr10">被列入严重违法失信（黑名单）</span>
            </c:if>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="book2-icon"></i>统一社会信用代码/注册号：<span>${empty dto.uniCode?dto.regNO:dto.uniCode}</span>
            </p>
            <p>
                <i class="local-icon"></i>登记机关：<span>${dto.regOrgName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="person-icon"></i>法定代表人：<span>${dto.leRep}</span>
            </p>
            <p>
                <i class="government-icon"></i>管辖单位：<span>${dto.localAdmName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="capital-icon"></i>注册资本：<span><fmt:formatNumber value="${dto.regCap}" pattern="###,###,###,##0.0000"/>万元</span>
            </p>
            <p><i class="date-icon"></i>成立日期：<span><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></span></p>
        </div>
        <div class="clearfix">
           <c:if test="${dto.isIndivid=='1'}"> 
            <p class="w360">
                <i class="date-icon"></i>转企日期：<span><fmt:formatDate value="${dto.individDate}" pattern="yyyy-MM-dd"/></span>
            </p>
           </c:if> 
            <p>
                <c:if test="${dto.regState=='D'}">
	                <i class="date-icon"></i>吊销日期：
	                <span class="light"><fmt:formatDate value="${dto.punishDate}" pattern="yyyy-MM-dd"/></span>
                </c:if>
                <c:if test="${dto.regState=='XX'||dto.regState=='DX'}">
	                <i class="date-icon"></i>注销日期：
	                <span class="light"><fmt:formatDate value="${dto.altDate}" pattern="yyyy-MM-dd"/></span>
                </c:if>
            </p>
        </div>
    </div>
</div>

  <div class="tabbale" data-component="tab">
     <div class="tab-header w-a145 type-tab tbmr1 ent-tab person-tab">
                <ul class="clearfix">
                    <li class="tab-selected"><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="0">登记许可信息</a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="1">企业年报信息</a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="2">工商业务信息</a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="3">企业培育信息</a></span>
                    </li>
                </ul>
          </div>
    <div class="tab-content">  
          <div class="tab-panel tab-panel-show">
             <div id="">
              <div class="gold">
	              <i class="flex-icon dib2 va-3" id="baseinfo"></i>
		          <h6 class="add-title dib2">企业基本信息</h6>
	          </div>
	          <table id="table_baseinfo" cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
                            <tbody>
                            <c:if test="${empty dto.entTypeCatg}">
                                <tr>
                                    <td colspan='9' class='dataTables_empty2'>无</td>
                                </tr>
                            </c:if>
                            <c:if test="${not empty dto.entTypeCatg}">
                                <!-- 分支机构 start-->
                                <c:if test="${fn:indexOf('12,14,34,32,22,28,24', dto.entTypeCatg)!=-1}">
                                    <tr>
                                        <td class="bg-gray right" width="10%">名称</td>
                                        <td width="40%">${dto.entName}</td>
                                        <td class="bg-gray right" width="15%">统一社会信用代码/注册号</td>
                                        <td>${dto.uniCode==null?dto.regNO:dto.uniCode}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">类型</td>
                                        <td width="40%">${dto.entTypeName}</td>
                                        <td class="bg-gray right">负责人</td>
                                        <c:if test="${!empty isLimit}"><td class="red">${dto.leRep}&nbsp;(受限)</td></c:if>
                                        <c:if test="${empty isLimit}"><td>${dto.leRep}</td></c:if>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td width="40%">${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">管辖单位</td>
                                        <td width="40%">${dto.localAdmName}</td>
                                        <td class="bg-gray right">片区</td>
                                        <td>${dto.sliceNOName}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td width="40%">${hx:publicStatus(dto.regState)}</td>
                                        <td class="bg-gray right">成立日期</td>
                                        <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">营业场所</td>
                                        <td  width="40%">${dto.dom}</td>
                                        <td class="bg-gray right">营业期限</td>
                                        <td><fmt:formatDate value="${dto.opFrom}" pattern="yyyy年MM月dd日"/>—
                                        <fmt:formatDate value="${dto.opTo}" pattern="yyyy年MM月dd日"/></td>
                                     </tr>
                                     <tr>
                                        <td class="bg-gray right">经营范围</td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>

                                </c:if>
                                <!-- 分支机构 end-->

                                <!-- 公司,外商投资企业,非公司企业法人 start-->
                                <c:if test="${fn:indexOf('11,21,13', dto.entTypeCatg)!=-1}">
                                    <tr>
                                        <td class="bg-gray right" width="10%">名称</td>
                                        <td width="40%">${dto.entName}</td>
                                        <td class="bg-gray right" width="15%">统一社会信用代码/注册号</td>
                                        <td>${dto.uniCode==null?dto.regNO:dto.uniCode}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">类型</td>
                                        <td width="40%">${dto.entTypeName}</td>
                                        <td class="bg-gray right">法定代表人</td>
                                        <c:if test="${!empty isLimit}"><td class="red">${dto.leRep}&nbsp;(受限)</td></c:if>
                                        <c:if test="${empty isLimit}"><td>${dto.leRep}</td></c:if>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td width="40%">${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">管辖单位</td>
                                        <td width="40%">${dto.localAdmName}</td>
                                        <td class="bg-gray right">片区</td>
                                        <td>${dto.sliceNOName}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td width="40%">${hx:publicStatus(dto.regState)}</td>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('11,21', dto.entTypeCatg)!=-1}">营业期限</c:if>
                                            <c:if test="${fn:indexOf('13', dto.entTypeCatg)!=-1}">经营期限</c:if>
                                        </td>
                                        <td><fmt:formatDate value="${dto.opFrom}" pattern="yyyy年MM月dd日"/>—
                                        <fmt:formatDate value="${dto.opTo}" pattern="yyyy年MM月dd日"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">经营范围</td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">住所</td>
                                        <td colspan="3">${dto.dom}</td>
                                    </tr>
                                </c:if>
                                <!-- 公司,外商投资企业,非公司企业法人 end-->

                                <!-- 合伙企业,外商投资合伙企业 start-->
                                <c:if test="${fn:indexOf('33,27', dto.entTypeCatg)!=-1}">
                                    <tr>
                                        <td class="bg-gray right" width="10%">名称</td>
                                        <td width="40%">${dto.entName}</td>
                                        <td class="bg-gray right" width="15%">统一社会信用代码/注册号</td>
                                        <td>${dto.uniCode==null?dto.regNO:dto.uniCode}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">类型</td>
                                        <td>${dto.entTypeName}</td>
                                        <td class="bg-gray right">执行事务合伙人</td>
                                        <c:if test="${!empty isLimit}"><td class="red">${dto.leRep}&nbsp;(受限)</td></c:if>
                                        <c:if test="${empty isLimit}"><td>${dto.leRep}</td></c:if>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td>${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">管辖单位</td>
                                        <td width="40%">${dto.localAdmName}</td>
                                        <td class="bg-gray right">片区</td>
                                        <td>${dto.sliceNOName}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">状态</td>
                                        <td>${hx:publicStatus(dto.regState)}</td>
                                        <td class="bg-gray right">成立日期</td>
                                        <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">主要经营场所</td>
                                        <td width="40%">${dto.dom}</td>
                                        <td class="bg-gray right">合伙期限</td>
                                        <td><fmt:formatDate value="${dto.opFrom}" pattern="yyyy年MM月dd日"/>—
                                        <fmt:formatDate value="${dto.opTo}" pattern="yyyy年MM月dd日"/></td>
                                     </tr>
                                     <tr>
                                        <td class="bg-gray right">经营范围</td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                </c:if>
                                <!-- 合伙企业,外商投资合伙企业 end-->

                                <!-- 个人独资企业,农民专业合作社分支机构 start-->
                                <c:if test="${fn:indexOf('31,17', dto.entTypeCatg)!=-1}">
                                    <tr>
                                        <td class="bg-gray right" width="10%">名称</td>
                                        <td width="40%">${dto.entName}</td>
                                        <td class="bg-gray right" width="15%">统一社会信用代码/注册号</td>
                                        <td>${dto.uniCode==null?dto.regNO:dto.uniCode}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">类型</td>
                                        <td>${dto.entTypeName}</td>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('31', dto.entTypeCatg)!=-1}">投资人</c:if>
                                            <c:if test="${fn:indexOf('17', dto.entTypeCatg)!=-1}">负责人</c:if>
                                        </td>
                                        <c:if test="${!empty isLimit}"><td class="red">${dto.leRep}&nbsp;(受限)</td></c:if>
                                        <c:if test="${empty isLimit}"><td>${dto.leRep}</td></c:if>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td>${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">管辖单位</td>
                                        <td width="40%">${dto.localAdmName}</td>
                                        <td class="bg-gray right">片区</td>
                                        <td>${dto.sliceNOName}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td>${hx:publicStatus(dto.regState)}</td>
                                        <td class="bg-gray right">成立日期</td>
                                        <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('31', dto.entTypeCatg)!=-1}">经营范围</c:if>
                                            <c:if test="${fn:indexOf('17', dto.entTypeCatg)!=-1}">业务范围</c:if>
                                        </td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('31', dto.entTypeCatg)!=-1}">住所</c:if>
                                            <c:if test="${fn:indexOf('17', dto.entTypeCatg)!=-1}">经营场所</c:if>
                                        </td>
                                        <td colspan="3">${dto.dom}</td>
                                    </tr>
                                </c:if>
                                <!-- 个人独资企业,农民专业合作社分支机构 end-->


                                <!-- 个体户,农民专业合作社 start-->
                                <c:if test="${fn:indexOf('50,16', dto.entTypeCatg)!=-1}">
                                    <tr>
                                        <td class="bg-gray right" width="10%">名称</td>
                                        <td width="40%">${dto.entName}</td>
                                        <td class="bg-gray right" width="15%">统一社会信用代码/注册号</td>
                                        <td>${dto.uniCode==null?dto.regNO:dto.uniCode}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">类型</td>
                                        <td>${dto.entTypeName}</td>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('50', dto.entTypeCatg)!=-1}">经营者</c:if>
                                            <c:if test="${fn:indexOf('16', dto.entTypeCatg)!=-1}">法定代表人</c:if>
                                        </td>
                                        <c:if test="${!empty isLimit}"><td class="red">${dto.leRep}&nbsp;(受限)</td></c:if>
                                        <c:if test="${empty isLimit}"><td>${dto.leRep}</td></c:if>
                                    </tr>
                                    <c:if test="${fn:indexOf('50', dto.entTypeCatg)!=-1}">
                                        <tr>
                                            <td class="bg-gray right">组成形式</td>
                                            <td>${dto.compFormName}</td>
                                            <td class="bg-gray right">注册日期</td>
                                            <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${fn:indexOf('16', dto.entTypeCatg)!=-1}">
                                        <tr>
                                            <td class="bg-gray right">成员出资总额</td>
                                            <td>>${dto.regCapUSD }万元人民币</td>
                                            <td class="bg-gray right">成立日期</td>
                                            <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
                                        </tr>
                                    </c:if>

                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td>${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">管辖单位</td>
                                        <td width="40%">${dto.localAdmName}</td>
                                        <td class="bg-gray right">片区</td>
                                        <td>${dto.sliceNOName}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td colspan="3">${hx:publicStatus(dto.regState)}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('50', dto.entTypeCatg)!=-1}">经营范围</c:if>
                                            <c:if test="${fn:indexOf('16', dto.entTypeCatg)!=-1}">业务范围</c:if>
                                        </td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                     <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('50', dto.entTypeCatg)!=-1}">经营场所</c:if>
                                            <c:if test="${fn:indexOf('16', dto.entTypeCatg)!=-1}">住所</c:if>
                                        </td>
                                        <td colspan="3">${dto.dom}</td>
                                    </tr>
                                </c:if>
                                <!-- 个体户,农民专业合作社 end-->
                            </c:if>
                            </tbody>
                        </table>
                     </div>
                        
                       <div id="tab_djxkxx">
                            <div class="gold">
	                            <i id="manageinfo" class="flex-icon dib2 va-3"></i>
		                        <h6 class="add-title dib2">高管人员信息（<span id="ggryxx" class="light">0</span>）</h6>
                            </div>
	                        <table id="table_ggryxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
	                               width="100%">
	                            <thead>
	                            <tr>
	                                <th width="8%">序号</th>
	                                <th>姓名</th>
	                                <th>身份证号</th>
	                                <th>职务</th>
	                            </tr>
	                            </thead>
	                        </table>
                       </div>
                        
                      <div id="tab_fzjgxx">
                         <div class="gold">
	                        <i id="branchinfo" class="flex-icon dib2 va-3"></i>
	                        <h6 class="add-title  dib2">分支机构信息（<span id="fzjg" class="light">0</span>）</h6>
	                     </div>
                         <table id="table_fzjgxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                               width="100%">
                            <thead>
                            <tr>
                                <th width="8%">序号</th>
                                <th>统一社会信用代码/注册号</th>
                                <th>企业名称</th>
                                <th>登记机关</th>
                                <th>登记状态</th>
                            </tr>
                            </thead>
                        </table>
                       </div>
                       
                        <div id="tab_qsxx">
                            <div class="gold">
		                        <i id="clearInfo" class="flex-icon dib2 va-3"></i>
		                        <h6 class="add-title dib2">清算信息<span>（<span id="qsxx" class="light">0</span>）</span></h6>
	                        </div>
	                        <table id="table_qsxx" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
	                             <thead>
				                    <tr>
				                        <th width="20%">清算组负责人</th>
				                        <td id="ligPrincipal"></td>
				                    </tr>
				                    <tr>
				                        <th width="20%">清算组成员</th>
				                        <td id="liqMem"></td>
				                    </tr>
				                  </thead>
	                         </table> 
                        </div>
                        
                       <div id="tab_bgxx" class="mb30">
                            <div class="gold"> 
		                        <i id="changeInfo" class="flex-icon dib2 va-3"></i>
		                        <h6 class="add-title  dib2">变更信息（<span id="bgxx" class="light">0</span>）</h6>
	                        </div>
	                        <table id="table_bgxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
	                               width="100%">
	                            <thead>
	                            <tr>
	                                <th width="8%">序号</th>
	                                <th>变更事项</th>
	                                <th>变更前内容</th>
	                                <th>变更后内容</th>
	                                <th>变更日期</th>
	                            </tr>
	                            </thead>
	                        </table> 
                       </div>
                </div>
                
                <div class="tab-panel">
                	<div>
                     <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="yrinfo_li"></i>
	                    <h6 class="add-title dib2">企业年度报告（<span class="light" id="yrinfoTotal">0</span>）</h6>
                    </div>
                    <table id="yrinfo_table" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">报送年度</th>
                            <th>公示日期</th> 
                            <th>是否小微企业</th> 
                            <th>企业标记</th> 
                            <th>详情</th> 
                        </tr>
                        </thead>
                        <tbody id="table-yrinfo">
                          <tr id="pubtable-yrinfo"></tr>
                        </tbody>
                    </table>
                    </div>
                </div>
                <div class="tab-panel">
                	<div class="gold"> 
	                    <i id="licenceinfo" class="flex-icon dib2 va-3"></i>
	                    <h6 class="add-title dib2">行政许可信息（<span id="pubotherlicTotal" class="light">0</span>）</h6>
                    </div>
                    <table id="_tab-pubotherlicence" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th class="col-first">序号 </th>
		                    <th class="col-second">许可文件编号 </th>
		                    <th class="col-three">许可文件名称 </th>
		                    <th class="col-four">有效期自 </th>
		                    <th class="col-five">有效期至 </th>
		                    <th class="col-six">许可机关 </th>
		                    <th class="col-seven">许可内容 </th> 
		                    <th>状态</th>
                        </tr>
                        </thead>
                        <tbody id="table-pubotherlicence">
                          <tr id="tr-pubotherlicence"></tr>
                        </tbody>
                    </table>
                    <div id="tab_qysbxx">
                    <div class="gold"> 
	                    <i id="tmdetailsinfo" class="flex-icon dib2 va-3"></i>
	                    <h6 class="add-title  dib2">企业商标信息（<span id="qysbxx" class="light">0</span>）</h6>
                    </div>
                    <table id="table_qysbxx" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                       <thead>
                         <tr>
                           <th width="8%">序号</th>
                           <th>商标图形</th>
                           <th>商标注册号</th>
                           <th>类别</th>
                           <th>商标专用权起止日期</th>
                           <th>注册公告日期</th>
                           <th>注册公告期号</th>
                           <th>商品/服务项目</th>
                         </tr>
                       </thead>
                    </table>
                  </div>
                  <div id="tab_qyzlxx">
                    <div class="gold"> 
	                    <i id="entzlinfo" class="flex-icon dib2 va-3"></i>
	                    <h6 class="add-title  dib2">企业专利信息（<span id="qyzlxx" class="light">0</span>）</h6>
                    </div>
                    <table id="table_qyzlxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                          width="100%">
                       <thead>
                       <tr>
                           <th width="8%">序号</th>
                           <th>专利申请号</th>
                           <th>发明名称</th>
                           <th>专利类型</th>
                           <th>申请人名称</th>
                       </tr>
                       </thead>
                   </table>
                 </div>
                 	<div>
                    <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="qydcdyxx_li"></i>
	                    <h6 class="add-title dib2">动产抵押信息 （<span id="qydcdyxxTotal" class="light">0</span>）</h6>
	                </div>
                    <table id="table_qydcdyxx" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr style="white-space: nowrap;">
                            <th width="8%">序号</th>
                            <th width="22%">登记编号</th>
                            <th>登记日期</th>
                            <th>登记机关</th>
                            <th>被担保债权数额（万元）</th>
                            <th>状态</th>
                            <th>公示日期</th>
                            <th>详情</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                    
                    <div>
                    <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="qybdcdyxx_li"></i>
	                    <h6 class="add-title dib2">不动产抵押信息 （<span class="light" id="qybdcdyxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_qybdcdyxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">抵押证编号</th>
                            <th>抵押物类型</th>
                            <th>抵押担保范围</th>
                            <th>抵押权人名称</th>
                            <th>抵押权人证件号</th>
                            <th>被担保主债权数额（万元）</th>
                            <th>债务期限起</th>
                            <th>债务期限至</th>
                            <th>申请抵押原因</th>
                        </tr>
                        </thead>
                    </table> 
                    </div>
                    
                    <div>
                    <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="ippldg_li"></i>
	                    <h6 class="add-title dib2">知识产权出质登记信息（<span class="light" id="ippldgTotal">0</span>）</h6>
                    </div>
                    <table id="ippldg_table" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th>知识产权登记证号</th>
                            <th>名称</th>
                            <th>种类</th>
                            <th>出质人名称</th>
                            <th>质权人名称</th>
                            <th>质权登记期限</th>
                            <th>状态</th>
                            <th>公示日期</th>
                            <th>详情</th>
                        </tr>
                        </thead> 
                        <!-- <tbody id="ippldg">
                        <tr id="ippldgtplPage"></tr>
                        </tbody> -->
                    </table>
                    </div>
                    
                    <div>
                    <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="qygqczxx_li"></i>
	                    <h6 class="add-title dib2">股权出质登记信息（<span class="light" id="qygqczxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_qygqczxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">登记编号</th>
                            <th>出质人</th>
                            <th>出质人证照/证件号</th>
                            <th>出质股权数额（万元）</th>
                            <th>质权人</th>
                            <th>质权人证照/证件号</th>
                            <th>股权出质设立登记日期</th>
                            <th>状态</th>
                            <th>公示日期</th>
                            <th>详情</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                    
                    <div>
                    <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="forguaranteeinfo_li"></i>
	                    <h6 class="add-title dib2">对外提供担保信息（<span class="light" id="forguaranteeinfoTotal">0</span>）</h6>
                    </div>
                    <table id="table_forguaranteeinfo" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th >序号</th>
                            <th >债权人</th>
	                        <th >债务人</th>
	                        <th >主债权</br>种类</th>
	                        <th >主债权</br>数额（万元）</th>
	                        <th >履行债务的期限</th>
	                        <th>保证的</br>期间</th>
	                        <th>保证的</br>方式</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                    <div> 
                    <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="ccjcxx_li"></i>
	                    <h6 class="add-title dib2">抽查检查信息 （<span class="light" id="ccjcxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_ccjcxx" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>检查类别</th>
                            <th>检查任务编号</th>
                            <th>检查实施机关</th>
                            <th>类型</th>
                            <th>日期</th>
                            <th>结果</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                    <div> 
                    <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="qyjyqcxx_li"></i>
	                    <h6 class="add-title dib2">列入经营异常名录（<span class="light" id="qyjyqcxxTotal">0</span>）</h6>
                    </div> 
                    <table id="table_qyjyqcxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <c:choose>
                          <c:when test="${dto.entTypeCatg=='50'}">
                            <tr>
                            <th>序号</th>
                            <th>标记经营异常状态原因</th>
                            <th>标记日期</th>
                            <th>作出决定机关（标记）</th>
                            <th>恢复正常记载状态原因</th>
                            <th>恢复日期</th>
                            <th>作出决定机关（恢复）</th>
                            </tr>
                          </c:when>
                          <c:otherwise>
                            <tr>
                            <th>序号</th>
                            <th>列入经营异常原因</th>
                            <th>列入日期</th>
                            <th>列入决定书文号</th>
                            <th>作出决定机关（列入）</th>
                            <th>移出经营异常名录原因</th>
                            <th>移出日期</th>
                            <th>移出决定书文号</th>
                            <th>作出决定机关（移出）</th>
                            </tr>
                          </c:otherwise>
                        </c:choose> 
                        </thead>
                    </table>
                    </div>
                    <div>
                    <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="yzwfsxxx_li"></i>
	                    <h6 class="add-title dib2">列入严重违法失信（黑名单）（<span class="light" id="yzwfsxxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_yzwfsxxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">类别</th>
                            <th>列入严重违法失信企业名单（黑名单）原因</th>
                            <th>列入日期</th>
                            <th>列入决定书文号</th>
                            <th>作出决定机关（列入）</th>
                            <th>移出严重违法失信企业名单（黑名单）原因</th>
                            <th>移出日期</th>
                            <th>移出决定书文号</th>
                            <th>作出决定机关（移出）</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                    <div>
                     <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="jsxzcfxx_li"></i>
	                    <h6 class="add-title dib2">行政处罚信息（<span class="light" id="pubOtherpunishTotal">0</span>）</h6>
                    </div>
                    <table id="table_jsxzcfxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th>决定书文号</th>
                            <th>违法行为类型</th>
                            <th>行政处罚内容</th>
                            <th>决定机关名称</th>
                            <th>处罚决定日期</th>
                            <th>公示日期</th>
                        </tr>
                        </thead>
                        <tbody id="pubOtherpunish">
                        <tr id="pubOtherpunishPage"></tr>
                        </tbody>
                    </table>
                    </div>
                    <div>
                     <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="qygqdjxx_li"></i>
	                    <h6 class="add-title dib2">司法协助信息（<span class="light" id="qygqdjxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_qygqdjxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">被执行人</th>
                            <th>股权数额</th>
                            <th>执行法院</th>
                            <th>执行通知书文号</th>
                            <th>类型</th>
                            <th>状态</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                    <div>
                     <div class="gold">
	                    <i class="flex-icon dib2 va-3" id="qybdccfxx_li"></i>
	                    <h6 class="add-title dib2">不动产查封信息（<span class="light" id="qybdccfxxTotal">0</span>）</h6>
                    </div>
                    <table id="table_qybdccfxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">查封类型</th>
                            <th>查封文号</th>
                            <th>查封房屋坐落</th>
                            <th>申请查封单位</th>
                            <th>查封申请日期</th>
                            <th>撤销查封日期</th>
                            <th>状态</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                </div>
                <div class="tab-panel">
                	<div id="tab_pyxx" class="mb30">
                            <div class="gold"> 
		                        <i id="archiveInfo" class="flex-icon dib2 va-3 flexed-icon"></i>
		                        <h6 class="add-title  dib2">培育信息（<span id="pyxx" class="light">0</span>）</h6>
	                        </div>
                       </div>
                </div>
         </div>
</div>

<script id="investment-templates" type="text/x-handlebars-template">
 					 {{#each data}}
                        <tr>
 							<td> {{addOne @index}}</td>
                            <td>{{inv}}</td>
                            <td>{{liSubConAm}}</td>
                            <td>{{liAcConAm}}</td>
                            <td valign="top">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table">
                                    <tbody> {{#with imInvprodetailList}} {{#each this}}
                                    <tr>
                                        <td width="20%">{{conFormCN}}</td>
                                        <td width="20%">{{subConAm}}</td>
                                        <td width="20%">{{transDate conDate}}</td>
                                        <td width="20%">{{transDate publicDate}}</td>
                                        <td width="20%">{{trsPubFlag pubFlag}}</td>
                                    </tr>
                                    {{/each}} {{/with}}
                                    </tbody>
                                </table>
                            </td>
                            <td valign="top">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table">
                                    <tbody> {{#with imInvactdetailList}} {{#each this}}
                                    <tr>
                                        <td width="20%">{{acConFormCn}}</td>
                                        <td width="20%">{{acConAm}}</td>
                                        <td width="20%">{{transDate conDate}}</td>
                                        <td width="20%">{{transDate publicDate}}</td>
										<td width="20%">{{trsPubFlag pubFlag}}</td>
                                    </tr>
                                    {{/each}} {{/with}}
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        {{/each}}
</script>

<script id="investment-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{inv}}</td>
        <td>{{liSubConAm}}</td>
        <td>{{liAcConAm}}</td>
        <td valign="top">
             <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody> {{#with imInvprodetailList}} {{#each this}}
                <tr>
                    <td width="28%">{{conFormCN}}</td>
                    <td width="30%">{{subConAm}}</td>
                    <td width="28%">{{transDate conDate}}</td>
                    <td>{{trsPubFlag pubFlag}}</td>
                </tr>
                {{/each}} {{/with}}
                </tbody>
            </table>
        </td>
        <td valign="top">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tbody> {{#with imInvactdetailList}} {{#each this}}
                <tr>
                    <td width="28%">{{acConFormCn}}</td>
                    <td width="30%">{{acConAm}}</td>
                    <td width="28%">{{transDate conDate}}</td>
                    <td>{{trsPubFlag pubFlag}}</td>
                </tr>
                {{/each}} {{/with}}
                </tbody>
            </table>
        </td>

    </tr>
    {{/each}}
</script>
<!-- 工商和其他部门的行政处罚 -->
<script id="pubOtherpunish-template" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td> {{addOne @index}}</td>
                <td>{{penDecNo}}</td>
                <td>{{illegActType}}</td>
                <td >{{{transPenContent penContent}}}</td>
                <td>{{judAuth}}</td>
                <td>{{penDecIssDate}}</td>
                <td>{{transPubFlag pubFlag}}</td>
            </tr>
			{{#if pubOtherPunishAlterList}}
            <tr >
                <td colspan="7" class="tip2">
                    <div class="fl">有变更情形：</div>
 					<div class="fl">
                    {{#each pubOtherPunishAlterList}}
                     <p class="fl">{{addOne @index}}、 {{judAuth}} {{altDate}}将{{contents}}</p><br/> 
 					{{/each}}
					</div>
                </td> 
            </tr>
 			{{/if}}
            {{/each}}
</script>
<!-- 企业年度报告 -->
<script id="table-template-yrinfo" type="text/x-handlebars-template">
            {{#each data}}
            <tr data-id="{{year}}">
                <td>{{addOne @index}}</td>
                <td>{{{year}}}</td>
                <td>{{{transAncheDate ancheDate}}}</td>
				<td>{{{transIsSment isSment}}}</td>
				<td>{{{cultivationTypeName}}}</td>
                <td><a href="javascript:void(0)" class="js-yrinfo">查看</a></td>
            </tr>
            {{/each}}
</script>

<!-- 简易注销公告 -->
<script id="table-template-er_esc_appinfo" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td>{{xh @index}}</td>
                <td>{{{transAncheDate noticeFrom}}}</td>
                <td>{{{transNoticeTo noticeTo}}}</td>
            </tr>
            {{/each}}
</script>

<script id="ippldg-template" type="text/x-handlebars-template">
                    {{#each data}}
                    <tr>
                        <td>{{addOne @index}}</td>
                        <td>
                            {{tmregNo}}
                        </td>
                        <td>{{tmname}}</td>
                        <td>{{transkinds kinds}}</td>
                        <td> {{pledgor}}</td>
                        <td>{{impOrg}}</td>
                        <td>{{transDate pleRegPerFrom}}-{{transDate pleRegPerTo}}</td>
                        <td>{{transType pubType}}</td>
                        <td>{{dataFormat publicDate}}</td>
                        <td><a id={{pleID}} href="javascript:void(0)" class="showIppldg">查看</a></td>
                    </tr>
                    {{/each}}
</script>

<script id="imcase-template" type="text/x-handlebars-template">
                    {{#each data}}
                    <tr>
                        <td> {{addOne @index}}</td>
                        <td>{{penDecNo}}</td>
                        <td>{{illegActType}}</td>
                        <td>{{{penContent}}}</td>
                        <td>{{judAuth}}</td>
                        <td>{{transDate penDecIssDate}}</td>
                        <td>{{dataFormat publicDate}}</td>

                        <td rowspan="">{{transType pubType}}</td>
                    </tr>
                    <tr style="{{dataList caslatList}}">
                        <td colspan="8" class="tip2">
                            <div class="fl">有变更情形：</div>
                            <div class="fl">
                                {{#with caslatList}}
                                {{#each this}}
                                <p>{{addOne @index}}.{{dataFormat altDate}}{{penAuthName}}将{{penContent}}。</p>
                                {{/each}}
                                {{/with}}
                            </div>
                        </td>
                    </tr>

                    {{/each}}
</script>

<script id="table-template_pubotherlicence" type="text/x-handlebars-template">
    {{#each data}}
    		<tr>
        		<td>{{addOne @index}}</td>
        		<td>{{licNO}}</td>
        		<td>{{licNameCN}}</td>
        		<td>{{licValFromDesc}}</td>
        		<td>{{licValToDesc}}</td>
        		<td>{{licAnth}}</td>
        		<td style="width: 600px;">{{licScope}}</td>
				<td >{{translicState licState}}</td>
    		</tr>
			<tr style="{{dataList pubOtherlicenceModList}}">
            	<td colspan="9" class="tip2">
                        <div class="fl">有变更情形：</div>
                        <div class="fl">
                            {{#with pubOtherlicenceModList}}
                            	{{#each this}}
                                <p>{{addOne @index}}、{{altDate altDate}}将{{altItem}}由{{altBe}}变更为{{altAf}}。</p>
                                {{/each}}
                        	{{/with}}
                        </div>
            	</td>
            </tr>
    {{/each}}
</script>
<script>
window._CONFIG = {
		_encryPriPID:'${encryPriPID}',
		_currency:'${dto.currencyCn}'
 } 
</script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/component/tab.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/smentsearch/smentsearch_detail.js"></script>
</body>
</html>
