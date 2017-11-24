<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>个转企调查表填报页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<div class="mod">
    <div class="mod-hd">
        <div class="title">
            <h3>“个转企”企业发展情况调查表 </h3>
            <div class="currency">币种：<strong class="light">人民币</strong></div>
            <p>转企前的数据只需第一次填表时填写，次年会自动显示上一年已填报的数据，无需再填</p>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content">
          <form id="questionnaireForm">
            <!-- queNo序号 -->
			<input type="hidden" name="questionnaireList[0].queID" value="${questionnaireList[0].queID}"/>
			<input type="hidden" name="questionnaireList[1].queID" value="${questionnaireList[1].queID}"/>
			<!-- corpid与year -->
			<input type="hidden" name="questionnaireList[0].priPID" value="${sessionScope.midBaseInfoDto.priPID}"/>
			<input type="hidden" name="questionnaireList[1].priPID" value="${sessionScope.midBaseInfoDto.priPID}"/>
			<!-- 转企前&转企后 -->
			<input type="hidden" name="questionnaireList[0].queFlag" value="1"/>
			<input type="hidden" name="questionnaireList[1].queFlag" value="2"/>
			<!-- 主表数据 -->
			<!-- 审核状态1：暂存，2：提交待审，3：已审核 -->
			<input type="hidden" name="individQueMainList[0].priPID" value="${sessionScope.midBaseInfoDto.priPID}"/>
			<input type="hidden" name="individQueMainList[0].qmID" value="${individQueMainList[0].qmID}"/>
			<input type="hidden" id="auditState" name="individQueMainList[0].auditState" value="${individQueMainList[0].auditState}"/>
            <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="156">项目名称</th>
                    <th width="180">转企前</th>
                    <th width="200">转企后</th>
                    <th>转企前/后”说明</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="" colspan="3">
                        <table class="table-noborder table-development">
                            <tbody>
                            <tr class="focus-state">
                                <td width="166" class="tar">年产值或营业额</td>
                                <td width="180">
                                <div class="ipt-box js-ipt-box">
                                    <input type="text" name="questionnaireList[0].vendInc"  value="${questionnaireList[0].vendInc}" class="ipt-txt moneyJudge  units"  placeholder="0.00" required>
                                    <i class="icon-close"></i>
                                </div>
                                元
                            </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[1].vendInc" value="${questionnaireList[1].vendInc}" class="ipt-txt moneyJudge  units" placeholder="0.00" required>
                                         <i class="icon-close"></i>
                                    </div>
                                    元
                                </td>
                            </tr>
                            <tr class="focus-state">
                                <td class="tar">年利润</td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[0].proGro" value="${questionnaireList[0].proGro}" class="ipt-txt moneyJudge  units" placeholder="0.00" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    元
                                </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[1].proGro" value="${questionnaireList[1].proGro}" class="ipt-txt moneyJudge  units" placeholder="0.00" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    元
                                </td>
                            </tr>
                            <tr class="focus-state">
                                <td class="tar">年纳税总额</td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[0].ratGro" value="${questionnaireList[0].ratGro}" class="ipt-txt moneyJudge  units" placeholder="0.00" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    元
                                </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[1].ratGro" value="${questionnaireList[1].ratGro}" class="ipt-txt moneyJudge  units" placeholder="0.00" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    元
                                </td>
                            </tr>
                            <tr class="focus-state">
                                <td class="tar">年缴纳社保总费用</td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[0].socIns" value="${questionnaireList[0].socIns}" class="ipt-txt moneyJudge  units" placeholder="0.00" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    元
                                </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[1].socIns" value="${questionnaireList[1].socIns}" class="ipt-txt moneyJudge  units" placeholder="0.00" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    元
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                    <td width="365" class="td-development">
                        <p>
                            “转企前”<strong class="light">指以转企时点为准，前推12个月的数据加总</strong>
                            如：于2013年10月15日转企，则按照2012年10月至2013年9月期间的数
                            据加总填写。
                        </p>
                        <p>
                            “转企后”<strong class="light">指以当前填表时点为准，前推12个月的数据加总</strong>
                            如：在2014年12月13日填表，则按照2013年12月至2014年11月期间的
                            数据加总填写。
                        </p>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <table class="table-noborder  table-development">
                            <tbody>
                            <tr class="focus-state">
                                <td width="166" class="tar">经营面积</td>
                                <td width="180">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[0].opSpace" value="${questionnaireList[0].opSpace}" class="ipt-txt opSpace  area" placeholder="0.00" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    m<sup>2</sup>
                                </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[1].opSpace" value="${questionnaireList[1].opSpace}" class="ipt-txt opSpace  area" placeholder="0.00" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    m<sup>2</sup>
                                </td>
                            </tr>
                            <tr class="focus-state">
                                <td class="tar">从业人员数</td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[0].empNum" value="${questionnaireList[0].empNum}" class="ipt-txt number digits" placeholder="0" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    个
                                </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[1].empNum" value="${questionnaireList[1].empNum}" class="ipt-txt number digits" placeholder="0" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    个
                                </td>
                            </tr>
                            <tr class="focus-state">
                                <td class="tar">参加社保数</td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[0].insured" value="${questionnaireList[0].insured}" class="ipt-txt number digits" placeholder="0" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    个
                                </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[1].insured" value="${questionnaireList[1].insured}" class="ipt-txt number digits" placeholder="0" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    个
                                </td>
                            </tr>
                            <tr class="focus-state">
                                <td class="tar">企业融资情况</td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[0].comLoan" value="${questionnaireList[0].comLoan}" class="ipt-txt moneyJudge " placeholder="0.00" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    元
                                </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[1].comLoan" value="${questionnaireList[1].comLoan}" class="ipt-txt moneyJudge " placeholder="0.00" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    元
                                </td>
                            </tr>
                            <tr class="focus-state">
                                <td class="tar">注册商标数</td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[0].domTraRegs" value="${questionnaireList[0].domTraRegs}" class="ipt-txt number digits" placeholder="0" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    件
                                </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[1].domTraRegs" value="${questionnaireList[1].domTraRegs}" class="ipt-txt number digits" placeholder="0" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    件
                                </td>
                            </tr>
                            <tr class="focus-state">
                                <td class="tar">专利数</td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[0].patAmount" value="${questionnaireList[0].patAmount}" class="ipt-txt number digits" placeholder="0" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    件
                                </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[1].patAmount" value="${questionnaireList[1].patAmount}" class="ipt-txt number digits" placeholder="0" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    件
                                </td>
                            </tr>
                            <tr class="focus-state">
                                <td class="tar">各类荣誉数</td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[0].horAmount" value="${questionnaireList[0].horAmount}" class="ipt-txt number digits" placeholder="0" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    个
                                </td>
                                <td>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" name="questionnaireList[1].horAmount" value="${questionnaireList[1].horAmount}" class="ipt-txt number digits" placeholder="0" required>
                                        <i class="icon-close"></i>
                                    </div>
                                    个
                                </td>
                            </tr>
                            <tr class="focus-state">
                                <td class="tar">纳税人类型</td>
                                <td>
                                    <div class="inline-block">
                                        <div class="radio-box">
                                            <label>
                                                <input type="radio" id="before"  name="questionnaireList[0].taxpayerType" value="1" class="required" ${questionnaireList[0].taxpayerType == '1'?'checked':''}>一般
                                            </label>
                                            <label>
                                                <input type="radio"  name="questionnaireList[0].taxpayerType" value="2" class="required" ${questionnaireList[0].taxpayerType == '2'?'checked':''}>小规模
                                            </label>
                                         </div>
                                    </div>
                                </td>
                                <td>
                                    <div class="inline-block">
                                        <div class="radio-box">
                                            <label>
                                                <input type="radio" id="after"  name="questionnaireList[1].taxpayerType" class="required" value="1" ${questionnaireList[1].taxpayerType == '1'?'checked':''}>一般
                                            </label>
                                            <label>
                                                <input type="radio"  name="questionnaireList[1].taxpayerType" value="2" class="required" ${questionnaireList[1].taxpayerType == '2'?'checked':''}>小规模
                                            </label>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                    <td width="365" class="td-development">
                        <p>“转企前”<strong class="light">栏填写转企时点的数据</strong></p>
                        <p>“转企后”<strong class="light">栏填写企业当前的数据</strong></p>
                    </td>
                </tr>
                </tbody>
            </table>
            <table class="table-public outer-border table-development mt10">
                <tbody>
                <tr class="focus-state">
                    <td width="165" class="tar">做大做强信心</td>
                    <td>
                        <div class="inline-block">
                            <div class="radio-box">
                                <label>
                                    <input type="radio" id="confidence" confidence="confidence" name="individQueMainList[0].queFaith" value="1" class="required" ${individQueMainList[0].queFaith == '1'?'checked':''}>有信心
                                </label>
                                <label>
                                    <input type="radio" confidence="confidence" name="individQueMainList[0].queFaith" value="2"  class="required" ${individQueMainList[0].queFaith == '2'?'checked':''}>无信心
                                </label>
                                <label>
                                    <input type="radio" confidence="confidence" name="individQueMainList[0].queFaith" value="3" class="required" ${individQueMainList[0].queFaith == '3'?'checked':''}>不确定
                                </label>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr class="focus-state">
                    <td class="tar">优惠政策兑现情况</td>
                    <td>
                        <div class="inline-block">
                            <label>
                                <input type="checkbox" class="policy" name="individQueMainList[0].quePolicyAll" value="1" ${individQueMainList[0].quePolicyAll == '1'?'checked':''}>财政一次性奖励
                            </label>
                            <label>
                                <input type="checkbox" class="policy" name="individQueMainList[0].quePolicyPart" value="2" ${individQueMainList[0].quePolicyPart == '2'?'checked':''}>地税留地方部分补助
                            </label>
                            <label>
                                <input type="checkbox" class="policy" name="individQueMainList[0].quePolicySoc" value="3" ${individQueMainList[0].quePolicySoc == '3'?'checked':''}>社保补助
                            </label>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <table class="table-public outer-border table-development mt10">
                <tbody>
                <tr class="focus-state">
                    <td width="150" class="tar">姓名</td>
                    <td width="150">
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="individQueMainList[0].setName" value="${individQueMainList[0].setName}" class="ipt-txt"  required>
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td width="70" class="tar">办公电话</td>
                    <td width="150">
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="individQueMainList[0].tel" value="${individQueMainList[0].tel}" class="ipt-txt isTel" required>
                            <i class="icon-close"></i>
                        </div>

                    </td>
                    <td width="70" class="tar">手机号</td>
                    <td>
                        <div class="ipt-box js-ipt-box">
                            <input type="text" name="individQueMainList[0].mobTel" value="${individQueMainList[0].mobTel}" class="ipt-txt" required>
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <c:if test="${individQueMainList[0].auditState != '2' && individQueMainList[0].auditState != '3'}">
            <div class="btn-box">
                <input type="submit" id="commit" value="提交" class="btn-common">
                <input type="submit" id="save" value="暂存" class="btn-common">
                <input type="button" id="close" value="关闭" class="btn-common">
            </div>
            </c:if>
             <c:if test="${individQueMainList[0].auditState == '2' || individQueMainList[0].auditState == '3'}">
            <div class="btn-box">
                <input type="button" id="close" value="关闭" class="btn-common btn-save">
            </div>
            </c:if>
           </form>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/yr/individquestion/edit_main.js"></script>
</body>
</html>