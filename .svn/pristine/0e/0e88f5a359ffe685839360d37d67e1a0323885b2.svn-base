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
    <title>详细信息</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body>
<form id="hx-form">
    <input type="hidden" id="priPID" name="priPID" value="${dto.priPID}">
    <input type="hidden" id="regNO" name="regNO" value="${dto.regNO}">
    <input type="hidden" id="uniCode" name="uniCode" value="${dto.uniCode}">
    <input type="hidden" id="entTypeCatg" name="entTypeCatg" value="${dto.entTypeCatg}">
</form>
<div class="pd20">
    <div class="clearfix bg-gray pd20 pos-rel">
        <div class="fl"><img src="/img/syn/header-img.jpg" alt=""></div>
        <div class="fl comp-intro ml10">
            <h4 class="mb5">${dto.entName}</h4>
            <p class="com-info"><span>统一社会信用代码：${dto.uniCode}</span><span>注册号：${dto.regNO}</span><span>纳税人识别号：-</span>
            </p>
            <p class="com-info"><span>信用评分： -</span><span>行业平均得分：-</span><span>行业排名：-</span></p>
            <p class="spec-info mt5">
                <span id="zdhybs">重点行业标识： （<font class="light">${jgNum}</font>）</span>
                <span id="gzfwbs">关注服务标识： （<font class="light">${gzNum}</font>）</span>
                <span id="qyfxbs">企业风险标识： （<font class="light">${yjNum}</font>）</span>
                <span>直接关联企业: （<font class="light">-</font>）</span>
            </p>
            <div class="user-cz">
                <a class="atten-icon"><i class="xbt-icon"></i>关注</a><font></font>
                <a class="print-icon"><i class="xbt-icon"></i>打印</a>
            </div>
        </div>
    </div>
    <div class="mt10">
        <div class="tabbale" data-component="tab">
            <div class="tab-header w-a120 type-tab tbmr1 border-bottom">
                <ul class="clearfix">
                    <li class="tab-selected"><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="0">登记备案信息</a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="1">出资投资</a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="2">许可资质</a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="3">知识产权</a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="4">抵押质押担保</a></span>
                    
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="5">抽查检查</a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="6">不良失信</a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="7">良好荣誉</a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="8">企业公示信息</a></span>
                    </li>
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-panel tab-panel-show" id="tab_djxkxx">
                    <div class="">
                        <p class="right mt10 mb5"><input id="change_his" type="button" class="btn btn-sm" value="变更历史">
                        </p>
                        <h5 class="com-info-title">主体登记信息 <span class="fr">数据由工商部门提供</span></h5>
                        <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
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
                                        <td>${dto.leRep}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">营业场所</td>
                                        <td colspan="3">${dto.dom}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">营业期限自</td>
                                        <td width="40%"><fmt:formatDate value="${dto.opFrom}"
                                                                        pattern="yyyy-MM-dd"/></td>
                                        <td class="bg-gray right">营业期限至</td>
                                        <td><fmt:formatDate value="${dto.opTo}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">经营范围</td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td width="40%">${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td width="40%">${hx:publicStatus(dto.regState)}</td>
                                        <td class="bg-gray right">成立日期</td>
                                        <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
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
                                        <td>${dto.leRep}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">住所</td>
                                        <td colspan="3">${dto.dom}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('11,21', dto.entTypeCatg)!=-1}">营业期限自</c:if>
                                            <c:if test="${fn:indexOf('13', dto.entTypeCatg)!=-1}">经营期限自</c:if>
                                        </td>
                                        <td width="40%"><fmt:formatDate value="${dto.opFrom}"
                                                                        pattern="yyyy-MM-dd"/></td>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('11,21', dto.entTypeCatg)!=-1}">营业期限至</c:if>
                                            <c:if test="${fn:indexOf('13', dto.entTypeCatg)!=-1}">经营期限至</c:if>
                                        </td>
                                        <td><fmt:formatDate value="${dto.opTo}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">经营范围</td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td width="40%">${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td colspan="3">${hx:publicStatus(dto.regState)}</td>
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
                                        <td>${dto.leRep}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">主要经营场所</td>
                                        <td colspan="3">${dto.dom}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">合伙期限自</td>
                                        <td><fmt:formatDate value="${dto.opFrom}" pattern="yyyy-MM-dd"/></td>
                                        <td class="bg-gray right">合伙期限至</td>
                                        <td><fmt:formatDate value="${dto.opTo}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">经营范围</td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td>${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">状态</td>
                                        <td>${hx:publicStatus(dto.regState)}</td>
                                        <td class="bg-gray right">成立日期</td>
                                        <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
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
                                        <td>${dto.leRep}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('31', dto.entTypeCatg)!=-1}">住所</c:if>
                                            <c:if test="${fn:indexOf('17', dto.entTypeCatg)!=-1}">经营场所</c:if>
                                        </td>
                                        <td colspan="3">${dto.dom}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('31', dto.entTypeCatg)!=-1}">经营范围</c:if>
                                            <c:if test="${fn:indexOf('17', dto.entTypeCatg)!=-1}">业务范围</c:if>
                                        </td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td>${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td>${hx:publicStatus(dto.regState)}</td>
                                        <td class="bg-gray right">成立日期</td>
                                        <td><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></td>
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
                                        <td>${dto.leRep}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('50', dto.entTypeCatg)!=-1}">经营场所</c:if>
                                            <c:if test="${fn:indexOf('16', dto.entTypeCatg)!=-1}">住所</c:if>
                                        </td>
                                        <td colspan="3">${dto.dom}</td>
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
                                        <td class="bg-gray right">
                                            <c:if test="${fn:indexOf('50', dto.entTypeCatg)!=-1}">经营范围</c:if>
                                            <c:if test="${fn:indexOf('16', dto.entTypeCatg)!=-1}">业务范围</c:if>
                                        </td>
                                        <td colspan="3">${dto.opScope}</td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记机关</td>
                                        <td>${dto.regOrgName}</td>
                                        <td class="bg-gray right">核准日期</td>
                                        <td><fmt:formatDate value="${dto.apprDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-gray right">登记状态</td>
                                        <td colspan="3">${hx:publicStatus(dto.regState)}</td>
                                    </tr>
                                </c:if>
                                <!-- 个体户,农民专业合作社 end-->
                            </c:if>
                            </tbody>
                        </table>

                        <h5 class="com-info-title mt10">高管人员信息 <span class="fr">数据由工商部门提供</span></h5>
                        <table id="table_ggryxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                               width="100%">
                            <thead>
                            <tr>
                                <th width="8%">序号</th>
                                <th width="22%">姓名</th>
                                <th>职务</th>
                            </tr>
                            </thead>
                        </table>
                        
                      <h5 class="com-info-title mt10">分支机构信息 <span class="fr">数据由工商部门提供</span></h5>
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
                        
                        <h5 class="com-info-title mt10">清算信息 <span class="fr">数据由工商部门提供</span></h5>
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
                         
                        <h5 class="com-info-title mt10">变更信息 <span class="fr">数据由工商部门提供</span></h5>
                        <table id="table_bgxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                               width="100%">
                            <thead>
                            <tr>
                                <th width="8%">序号</th>
                                <th>变更事项</th>
                                <th>变更前内容</th>
                                <th>变更好内容</th>
                                <th>变更日期</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>

                <div class="tab-panel" id="tab_qyzxgsxx">
                   <h5 class="com-info-title mt10">股东及出资信息 <span class="fr">数据来源：工商部门</span></h5>
                    <table id="table_gdjczxx" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">股东名称</th>
<!--                        <th>国别</th> -->
                            <th>股东类型</th>
                            <th>证件类型</th>
                            <th>证件号码</th>
                            <th>认缴出资额</th>
                            <th>币种</th>
                            <th>百分比</th>
                            <th>实缴出资额</th>
                        </tr>
                        </thead>
                    </table>

                    <h5 class="com-info-title mt10">企业对外投资信息 <span class="fr">数据来源：企业年报</span></h5>
                    <table id="table_dwtzxx" border="0" cellspacing="0" cellpadding="0" class="table-row">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th>对外投资企业统一社会信用代码(或注册号)</th>
		                    <th>投资设立（或购买股权）境内企业名称</th>
		                    <th>认缴投资总额</th>
		                    <th>认缴投资方式</th>
		                    <th>认缴投资总额占比（%）</th>
		                    <th>实缴投资总额</th>
		                    <th>实缴投资方式</th>
		                    <th>实缴投资总额占比</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                
                 <div class="tab-panel" >
                    <h5 class="com-info-title mt10">行政许可信息（<lable id="pubotherlicTotal">0</lable>） <span class="fr">数据来源：各审批许可部门</span></h5>
                    <table id="_tab-pubotherlicence" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th class="col-first"> 序号 </th>
		                    <th class="col-second"> 许可文件编号 </th>
		                    <th class="col-three"> 许可文件名称 </th>
		                    <th class="col-four"> 有效期自 </th>
		                    <th class="col-five"> 有效期至 </th>
		                    <th class="col-six"> 许可机关 </th>
		                    <th class="col-seven"> 许可内容 </th> 
		                    <th>状态</th>
                            <th>详情</th>
                        </tr>
                        </thead>
                        <tbody id="table-pubotherlicence">
                          <tr id="tr-pubotherlicence"></tr>
                        </tbody>
                    </table>
                  </div>
                  
                 <div class="tab-panel">
                     <h5 class="com-info-title mt10">企业商标信息 <span class="fr">数据由工商部门提供</span></h5>
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
                    
                  <h5 class="com-info-title mt10">企业专利信息 <span class="fr">数据由知识产权部门提供</span></h5>
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

                <div class="tab-panel" id="tab_dyzyxx">
                    <h5 class="com-info-title mt10">动产抵押信息 （<label id="qydcdyxxTotal">0</label>）<span class="fr">数据来源：工商部门</span></h5>
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
                  
                    <h5 class="com-info-title mt10">不动产抵押信息 （<label id="qybdcdyxxTotal">0</label>）<span class="fr">数据来源：国土部门</span></h5>
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
                    <h5 class="com-info-title mt10">股权出质登记信息（<label id="qygqczxxTotal">0</label>）<span class="fr">数据来源：工商部门</span></h5>
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
                    
                    <h5 class="com-info-title mt10">对外提供担保信息（<label id="forguaranteeinfoTotal">0</label>）<span class="fr">数据来源：企业报送信息</span></h5>
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
                

                <div class="tab-panel" id="tab_ccjcxx">
                    <h5 class="com-info-title mt10">抽查检查信息 （<label id="ccjcxxTotal">0</label>）<span class="fr">数据来源：工商部门</span></h5>
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

                <div class="tab-panel" id="tab_pjdjxx">
                    <h5 class="com-info-title mt10">列入经营异常名录（<label id="qyjyqcxxTotal">0</label>） <span class="fr">数据来源：工商部门</span></h5>
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
                    <h5 class="com-info-title mt10">列入严重违法失信（黑名单）（<label id="yzwfsxxxTotal">0</label>） <span class="fr">数据来源：工商部门</span></h5>
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
                    <h5 class="com-info-title mt10">行政处罚信息（<label id="pubOtherpunishTotal">0</label>）<span class="fr">数据来源：工商部门和其它部门</span></h5>
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
                            <th>详情</th>
                        </tr>
                        </thead>
                        <tbody id="pubOtherpunish">
                        <tr id="pubOtherpunishPage"></tr>
                        </tbody>
                    </table>
                    <h5 class="com-info-title mt10">司法协助信息（<label id="qygqdjxxTotal">0</label>）<span class="fr">数据来源：人民法院</span></h5>
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
                    <h5 class="com-info-title mt10">不动产查封信息（<label id="qybdccfxxTotal">0</label>）<span class="fr">数据来源：不动产登记部门</span></h5>
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
                    <h5 class="com-info-title mt10">失信联合惩戒信息 （<label id="sxlhcjxxTotal">0</label>）<span class="fr">数据来源：各相关政府部门</span></h5>
                    <table id="table_sxlhcjxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">惩戒领域</th>
                            <th>惩戒依据</th>
                            <th>惩戒事由</th>
                            <th>惩戒规则</th>
                            <th>惩戒提请部门</th>
                            <th>执行有效期</th>
                            <th>惩戒执行部门</th>
                            <th>惩戒执行措施</th>
                            <th>惩戒状态</th>
                        </tr>
                        </thead>
                    </table>
                </div>

                <div class="tab-panel" id="tab_wfsxxx">
                    <h5 class="com-info-title mt10">良好荣誉信息 （<label id="wfsxxxTotal">0</label>）<span class="fr">数据来源:各相关政府部门</span></h5>
                    <table id="table_qyxzcfxx" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr style="white-space: nowrap;">
                            <th>序号</th>
                            <th>良好信息类别</th>
                            <th>信息级别</th>
                            <th>认定发布年度</th>
                            <th>认定类别</th>
                            <th>认定有效期始</th>
                            <th>认定有效期止</th> 
                            <th>状态</th>
                            <th>认定发布时间</th>
                            <th>认定发布文号</th>
                            <th>认定发布部门</th>
                        </tr>
                        </thead>
                    </table> 
                </div>

                <div class="tab-panel">
                    <h5 class="com-info-title mt10">企业年度报告（<label id="yrinfoTotal">0</label>） <span class="fr">数据来源：国家企业信用信息公示系统企业信息填报</span></h5>
                    <table id="" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">报送年度</th>
                            <th>公示日期</th> 
                            <th>详情</th> 
                        </tr>
                        </thead>
                        <tbody id="table-yrinfo">
                          <tr id="pubtable-yrinfo"></tr>
                        </tbody>
                    </table>
                    <h5 class="com-info-title mt10">股东及出资信息 （<label id="investmentTotal">0</label>）<span class="fr">数据来源：国家企业信用信息公示系统企业信息填报</span></h5>
                    <table id="table_jsgdyczxx" class="table-common table-gudong-imme table-nest" cellspacing="0"
                           cellpadding="0">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>股东</th>
                            <th>认缴额(万元)</th>
                            <th>实缴额(万元)</th>
                            <th valign="top">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                    <tr>
                                        <td colspan="4">认缴明细</td>
                                    </tr>
                                    <tr>
                                        <td width="28%">认缴<br/>出资方式</td>
                                        <td width="30%">认缴出资额<br/>（万元）</td>
                                        <td width="28%">认缴<br/>出资日期</td>
                                        <td>公示<br/>状态</td>
                                    </tr>
                                </table>
                            </th>
                            <th valign="top">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                    <tr>
                                        <td colspan="4">实缴明细</td>
                                    </tr>
                                    <tr>
                                        <td width="28%">实缴出资方式</td>
                                        <td width="30%">实缴出资额<br/>（万元）</td>
                                        <td width="28%">实缴<br/>出资日期</td>
                                        <td>公示<br/>状态</td>
                                    </tr>
                                </table>
                            </th>
                        </tr>
                        </thead>
                        <tbody id="investments">
                        <tr id="investmenttplPage"></tr>
                        </tbody>
                    </table>
                    <h5 class="com-info-title mt10">股权变更信息（<label id="invsralTotal">0</label>） <span class="fr">数据来源：国家企业信用信息公示系统企业信息填报</span></h5>
                    <table  border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">股东</th>
                            <th>变更前股权比例</th>
                            <th>变更后股权比例</th>
                            <th>股权变更日期</th>
                            <th>公示日期</th>
                        </tr>
                        </thead>
                        <tbody id="invsral">
                        <tr id="invsraltplPage"></tr>
                        </tbody>
                    </table>
                    <h5 class="com-info-title mt10">行政许可信息（<label id="permittplTotal">0</label>）<span class="fr">数据来源：国家企业信用信息公示系统企业信息填报</span></h5>
                    <table  border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">许可文件编号</th>
                            <th>许可文件名称</th>
                            <th>有效期自</th>
                            <th>有效期至</th>
                            <th>许可机关</th>
                            <th>许可内容</th>
                            <th>状态</th>
                            <th>详情</th>
                        </tr>
                        </thead>
                        <tbody id="permit">
                        <tr id="permittplPage"></tr>
                        </tbody>
                    </table>
                    <h5 class="com-info-title mt10">知识产权出质登记信息（<label id="ippldgTotal">0</label>）<span class="fr">数据来源：国家企业信用信息公示系统企业信息填报</span></h5>
                    <table id="" border="0" cellspacing="0" cellpadding="0" class="table-row"
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
                        <tbody id="ippldg">
                        <tr id="ippldgtplPage"></tr>
                        </tbody>
                    </table>
                    <h5 class="com-info-title mt10">行政处罚信息（<label id="imcaseTotal">0</label>）<span class="fr">数据由企业自行提供</span></h5>
                    <table id="" border="0" cellspacing="0" cellpadding="0" class="table-row"
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
                            <th>备注</th>
                        </tr>
                        </thead>
                        <tbody id="imcase">
                        <tr id="imcasetplPage"></tr>
                        </tbody>
                    </table>
                    
                    
                    
                    <h5 class="com-info-title mt10">简易注销公告信息（<lable id="er_esc_appinfoTotal">0</lable>） <span class="fr">数据来源：企业自行公示</span></h5>
                    <table  border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">简易注销信息</th>
                            <th>详情</th> 
                        </tr>
                        </thead>
                        <tbody id="table-er_esc_appinfo">
                          <tr id="tr-er_esc_appinfo"></tr>
                        </tbody>
                    </table>
                </div>
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
                                        <td width="28%">{{conFormCN}}</td>
                                        <td width="30%">{{subConAm}}</td>
                                        <td width="28%">{{transDate conDate}}</td>
                                        <td>{{transDate publicDate}}</td>
                                        <td>{{trsPubFlag pubFlag}}</td>
                                    </tr>
                                    {{/each}} {{/with}}
                                    </tbody>
                                </table>
                            </td>
                            <td valign="top">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table">
                                    <tbody> {{#with imInvactdetailList}} {{#each this}}
                                    <tr>
                                        <td width="28%">{{acConFormCn}}</td>
                                        <td width="30%">{{acConAm}}</td>
                                        <td width="28%">{{transDate conDate}}</td>
                                        <td>{{transDate publicDate}}</td>
										<td>{{trsPubFlag pubFlag}}</td>
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
                <td title={{transPenContent penContent}}>{{transPenContent penContent}}</td>
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
                <td>{{{transType reportType}}}</td>
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

<!-- 即时股权变更 -->
 <script id="invsral-template" type="text/x-handlebars-template">
                        {{#each data}}
                        <tr>
                            <td>{{addOne @index}}</td>
                            <td> {{inv}}</td>
                            <td> {{beTransAmPr}}%</td>
                            <td> {{afTransAmPr}}%</td>
                            <td> {{transDate equAltDate}}</td>
                            <td> {{dataFormat publicDate}}</td>
                        </tr>
                        {{/each}}
</script>

<!-- 即时行政许可 -->
<script id="permit-template" type="text/x-handlebars-template">
                    {{#each data}}
                    <tr>
                        <td> {{addOne @index}}</td>
                        <td> {{licNO}}</td>
                        <td>{{licNameCN}}</td>
                        <td>{{transDate valFrom}}</td>
                        <td> {{transDate valTo}}</td>
                        <td>{{licAnth}}</td>
                        <td>{{licItem}}</td>
                        <td>{{transPubType pubType}}</td>
                        <td><a href="javascript:void(0)" id="{{licID}}" class="showPermit">查看</a></td>
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
                        <td>{{penContent}}</td>
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
				<td ></td>
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
		if("${sysUser.userType}" == "1"){
			 window._CONFIG = {
					 _urlHead:'/reg/server/panoramasearch/',
		     } 
		}else{
			window._CONFIG = {
					_urlHead:'/syn/panoramasearch/',
		     } 
		}
</script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/component/tab.js"></script>
<!-- <script src="/js/lib/laydate/laydate.js"></script> -->
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/search/appsearch/appsearchdetails.js"></script>
</body>
</html>