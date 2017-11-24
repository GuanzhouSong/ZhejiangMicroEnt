<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>个转企调查表查看页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="">
    <div class="mod-bd">
        <div class="content">
          <form id="questionnaireForm">
            <!-- queNo序号 -->
			<input type="hidden" name="questionnaireList[0].queID" value="${questionnaireList[0].queID}"/>
			<input type="hidden" name="questionnaireList[1].queID" value="${questionnaireList[1].queID}"/>
			<!-- corpid与year -->
			<input type="hidden" name="questionnaireList[0].priPID" value="${questionnaireList[0].priPID}"/>
			<input type="hidden" name="questionnaireList[1].priPID" value="${questionnaireList[1].priPID}"/>
			<!-- 转企前&转企后 -->
			<input type="hidden" name="questionnaireList[0].queFlag" value="1"/>
			<input type="hidden" name="questionnaireList[1].queFlag" value="2"/>
			<input type="hidden" name="questionnaireList[0].year" value="${questionnaireList[0].year}"/>
			<input type="hidden" name="questionnaireList[1].year" value="${questionnaireList[1].year}"/>
			<!-- 主表数据 -->
			<!-- 审核状态1：暂存，2：提交待审，3：已审核 -->
			<input type="hidden" name="individQueMainList[0].priPID" value="${individQueMainList[0].priPID}"/>
			<input type="hidden" name="individQueMainList[0].year" value="${individQueMainList[0].year}"/>
			<input type="hidden" name="individQueMainList[0].qmID" value="${individQueMainList[0].qmID}"/>
			<input type="hidden" id="auditState" name="individQueMainList[0].auditState"/>
            <table class="table-horizontal" border="0" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th class="bg-gray center" width="156">项目名称</th>
                    <th class="bg-gray center" width="180">转企前</th>
                    <th class="bg-gray center" width="200">转企后</th>
                    <th class="bg-gray center">转企前/后”说明</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="" colspan="3">
                        <table class="table-noborder table-development pd10">
                            <tbody>
                            <tr class="">
                                <td width="180" class="bg-gray right">年产值或营业额</td>
                                <td width="180">
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[0].vendInc" value="${questionnaireList[0].vendInc}" class="ipt-txt moneyJudge" placeholder="0.00" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">元</span>
                                </td>
                                <td width="180">
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[1].vendInc" value="${questionnaireList[1].vendInc}" class="ipt-txt moneyJudge" placeholder="0.00" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">元</span>
                                </td>
                            </tr>
                            <tr class="">
                                <td class="bg-gray right">年利润</td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[0].proGro" value="${questionnaireList[0].proGro}" class="ipt-txt moneyJudge" placeholder="0.00" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">元</span>
                                </td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[1].proGro" value="${questionnaireList[1].proGro}" class="ipt-txt moneyJudge" placeholder="0.00"  disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">元</span>
                                </td>
                            </tr>
                            <tr class="">
                                <td class="bg-gray right">年纳税总额</td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[0].ratGro" value="${questionnaireList[0].ratGro}" class="ipt-txt moneyJudge" placeholder="0.00" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">元</span>
                                </td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[1].ratGro" value="${questionnaireList[1].ratGro}" class="ipt-txt moneyJudge" placeholder="0.00" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">元</span>
                                </td>
                            </tr>
                            <tr class="">
                                <td class="bg-gray right">年缴纳社保总费用</td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[0].socIns" value="${questionnaireList[0].socIns}" class="ipt-txt moneyJudge" placeholder="0.00" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">元</span>
                                </td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[1].socIns" value="${questionnaireList[1].socIns}" class="ipt-txt moneyJudge" placeholder="0.00" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">元</span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                    <td width="365" class="td-development left">
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
                            <tr class="">
                                <td width="180" class="bg-gray right">经营面积</td>
                                <td width="180">
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[0].opSpace" value="${questionnaireList[0].opSpace}" class="ipt-txt" placeholder="0.00" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    m<sup>2</sup>
                                </td>
                                <td width="180">
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[1].opSpace" value="${questionnaireList[1].opSpace}" class="ipt-txt" placeholder="0.00" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    m<sup>2</sup>
                                </td>
                            </tr>
                            <tr class="">
                                <td class="bg-gray right">从业人员数</td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[0].empNum" value="${questionnaireList[0].empNum}" class="ipt-txt" placeholder="0" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">个</span>
                                </td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[1].empNum" value="${questionnaireList[1].empNum}" class="ipt-txt" placeholder="0" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">个</span>
                                </td>
                            </tr>
                            <tr class="">
                                <td class="bg-gray right">参加社保数</td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[0].insured" value="${questionnaireList[0].insured}" class="ipt-txt" placeholder="0" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">个</span>
                                </td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[1].insured" value="${questionnaireList[1].insured}" class="ipt-txt" placeholder="0" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">个</span>
                                </td>
                            </tr>
                            <tr class="">
                                <td class="bg-gray right">企业融资情况</td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[0].comLoan" value="${questionnaireList[0].comLoan}" class="ipt-txt moneyJudge" placeholder="0.00" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">元</span>
                                </td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[1].comLoan" value="${questionnaireList[1].comLoan}" class="ipt-txt moneyJudge" placeholder="0.00" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">元</span>

                                </td>
                            </tr>
                            <tr class="">
                                <td class="bg-gray right">注册商标数</td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[0].domTraRegs" value="${questionnaireList[0].domTraRegs}" class="ipt-txt" placeholder="0" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">件</span>
                                </td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[1].domTraRegs" value="${questionnaireList[1].domTraRegs}" class="ipt-txt" placeholder="0" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">件</span>
                                </td>
                            </tr>
                            <tr class="">
                                <td class="bg-gray right">专利数</td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[0].patAmount" value="${questionnaireList[0].patAmount}" class="ipt-txt" placeholder="0" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">件</span>
                                </td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[1].patAmount" value="${questionnaireList[1].patAmount}" class="ipt-txt" placeholder="0" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">件</span>
                                </td>
                            </tr>
                            <tr class="">
                                <td class="bg-gray right">各类荣誉数</td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[0].horAmount" value="${questionnaireList[0].horAmount}" class="ipt-txt" placeholder="0" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">个</span>
                                </td>
                                <td>
                                    <div class="ipt-box col-10">
                                        <input type="text" name="questionnaireList[1].horAmount" value="${questionnaireList[1].horAmount}" class="ipt-txt" placeholder="0" disabled="disabled">
                                        <i class="icon-close"></i>
                                    </div>
                                    <span class="item-txt">个</span>
                                </td>
                            </tr>
                            <tr class="">
                                <td class="bg-gray right">纳税人类型</td>
                                <td>
                                    <div class="inline-block">
                                        <label>
                                            <input type="radio" name="questionnaireList[0].taxpayerType" value="1" ${questionnaireList[0].taxpayerType == '1'?'checked':''}>一般
                                        </label>
                                        <label>
                                            <input type="radio" name="questionnaireList[0].taxpayerType" value="2" ${questionnaireList[0].taxpayerType == '2'?'checked':''}>小规模
                                        </label>
                                    </div>
                                </td>
                                <td>
                                    <div class="inline-block">
                                        <label>
                                            <input type="radio" name="questionnaireList[1].taxpayerType" value="1" ${questionnaireList[1].taxpayerType == '1'?'checked':''}>一般
                                        </label>
                                        <label>
                                            <input type="radio" name="questionnaireList[1].taxpayerType" value="2" ${questionnaireList[1].taxpayerType == '2'?'checked':''}>小规模
                                        </label>
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
            <table class="table-horizontal mt10">
                <tbody>
                <tr class="">
                    <td width="165" class="bg-gray right">做大做强信心</td>
                    <td class="left">
                        <div class="inline-block">
                            <label>
                                <input type="radio" name="individQueMainList[0].queFaith" value="1"
                                ${individQueMainList[0].queFaith == '1'?'checked':''}>有信心
                            </label>
                            <label>
                                <input type="radio" name="individQueMainList[0].queFaith" value="2"
                                ${individQueMainList[0].queFaith == '2'?'checked':''}>无信心
                            </label>
                            <label>
                                <input type="radio" name="individQueMainList[0].queFaith" value="3"
                                ${individQueMainList[0].queFaith == '3'?'checked':''}>不确定
                            </label>
                        </div>
                    </td>
                </tr>
                <tr class="">
                    <td class="bg-gray right">优惠政策兑现情况</td>
                    <td class="left">
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
            <table class="table-horizontal mt10">
                <tbody>
                <tr class="">
                    <td width="150" class="bg-gray right">姓名</td>
                    <td width="150">
                        <div class="ipt-box col-10">
                            <input type="text" name="individQueMainList[0].setName" value="${individQueMainList[0].setName}" class="ipt-txt" disabled="disabled">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                    <td width="70" class="bg-gray right">办公电话</td>
                    <td width="150">
                        <div class="ipt-box col-10">
                            <input type="text" name="individQueMainList[0].tel" value="${individQueMainList[0].tel}" class="ipt-txt" disabled="disabled">
                            <i class="icon-close"></i>
                        </div>

                    </td>
                    <td width="70" class="bg-gray right">手机号</td>
                    <td>
                        <div class="ipt-box col-4">
                            <input type="text" name="individQueMainList[0].mobTel" value="${individQueMainList[0].mobTel}" class="ipt-txt" disabled="disabled">
                            <i class="icon-close"></i>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="center mt10">
                <input type="button" id="close" value="关闭" class="btn">
            </div>
           </form>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/questionnaire/search_edit_main.js"></script>
</body>
</html>