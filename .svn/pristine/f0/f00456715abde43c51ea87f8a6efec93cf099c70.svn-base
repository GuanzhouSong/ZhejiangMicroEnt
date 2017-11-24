<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>处罚类严违名单初审</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="form-box pd14-mr">
    <form id="searchForm" class="searchForm">
    <input type="hidden" name="firstreview" value="firstreview"/>
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">
                        <span class="long-label">统一信用代码/注册号：</span>
                    </label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNO">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">当事人名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">严违失信类型：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="secDishonestyType">
                                <option value="">全部</option>
                                <option value="被撤销登记">被撤销登记</option>
                                <option value="传销违法">传销违法</option>
                                <option value="直销违法">直销违法</option>
                                <option value="不正当竞争">不正当竞争</option>
                                <option value="侵害消费者权益">侵害消费者权益</option>
                                <option value="发布虚假广告">发布虚假广告</option>
                                <option value="商标侵权">商标侵权</option>
                                <option value="累计违法">累计违法</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">
                        <span class="long-label">法定代表人/负责人：</span>
                    </label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业管理部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" readonly="readonly" id="localAdmName" value="" placeholder="请选择企业管理部门"/>
                          <span class="add-icon" id="choseregUnit">
                              <i></i>
                          </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">业务状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="businessStatus" id="businessStatus" >
                                <option value="">全部</option>
                                <%--<option value="0">已列入</option>--%>
                                <option value="1">待初审</option>
                                <option value="2">初审不通过</option>
                                <option value="3">待审核</option>
                                <%--<option value="4">审核通过</option>
                                <option value="5">审核不通过</option>--%>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="regState" id="regState">
                                <option value="">全部</option>
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                    <option value='${regState.value.code}'>${regState.value.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4 apply_in">
                    <label class="item-name col-5">列入严违期限：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" onclick="laydate()" name="addSecTermBegin" value="">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" onclick="laydate()" name="addSecTermEnd" value="">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">逾期列入：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="applyExp">
                                <option value="">全部</option>
                                <option value="1">是</option>
                                <option value="0">否</option>
                            </select>
                        </div>
                    </div>
                </div>
                <!-- 
                <div class="col-4">
                    <label class="item-name col-5">审核人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="auditName" value="" >
                        </div>
                    </div>
                </div>
                <div class="col-4 apply_in">
                    <label class="item-name col-5">公示状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="publicState">
                                <option value="">全部</option>
                                <option value="0">未认领</option>
                                <option value="1">已认领</option>
                            </select>
                        </div>
                    </div>
                </div> -->
            </div>
            <div class="form-item clearfix apply_in">
               <!--  <div class="col-4">
                    <label class="item-name col-5">列入严违机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="addSecOrg">
                        </div>
                    </div>
                </div> -->
                <div class="col-4">
                    <label class="item-name col-5">初审日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" onclick="laydate()"
                                   name="firstdateBegin" value="">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" onclick="laydate()"
                                   name="firstdateEnd" value="">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">初审人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="firstName" value="" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">列入严违原因：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="addSecCause">
                                <option value="">请选择..</option>
                                <option value="提交虚假材料或者采取其他欺诈手段隐瞒重要事实，取得公司变更或者注销登记，被撤销登记的">
                                    提交虚假材料或者采取其他欺诈手段隐瞒重要事实，取得公司变更或者注销登记，被撤销登记的</option>
                                <option value="组织策划传销的，或者因为传销行为提供便利条件两年内受到三次以上行政处罚的">
                                    组织策划传销的，或者因为传销行为提供便利条件两年内受到三次以上行政处罚的</option>
                                <option value="因直销违法行为两年内受到三次以上行政处罚的">因直销违法行为两年内受到三次以上行政处罚的</option>
                                <option value="因不正当竞争行为两年内受到三次以上行政处罚的">因不正当竞争行为两年内受到三次以上行政处罚的</option>
                                <option value="因提供的商品或者服务不符合保障人身、财产安全要求，造成人身伤害等严重侵害消费者权益的违法行为，两年内受到三次以上行政处罚的">
                                    因提供的商品或者服务不符合保障人身、财产安全要求，造成人身伤害等严重侵害消费者权益的违法行为，两年内受到三次以上行政处罚的</option>
                                <option value="因发布虚假广告两年内受到三次以上行政处罚的，或者发布关系消费者生命健康的商品或者服务的虚假广告，造成人身伤害的或者其他严重社会不良影响的">
                                    因发布虚假广告两年内受到三次以上行政处罚的，或者发布关系消费者生命健康的商品或者服务的虚假广告，造成人身伤害的或者其他严重社会不良影响的</option>
                                <option value="因商标侵权行为五年内受到两次以上行政处罚的">
                                    因商标侵权行为五年内受到两次以上行政处罚的</option>
                                <option value="企业违反工商行政管理法律、行政法规，有第2项至第8项行为之一，两年内累计受到三次以上行政处罚的">
                                    企业违反工商行政管理法律、行政法规，有第2项至第8项行为之一，两年内累计受到三次以上行政处罚的</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix apply_in">
                <div class="col-4">
                    <label class="item-name col-5">申请日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" onclick="laydate()"
                                   name="applyDateBegin" value="">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" onclick="laydate()"
                                   name="applyDateEnd" value="">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">经办人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="applyMan" value="" >
                        </div>
                    </div>
                </div>
                <!-- <div class="col-4">
                    <label class="item-name col-5">审核日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" onclick="laydate()"
                                   name="auditDateBegin" value="">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" onclick="laydate()"
                                   name="auditDateEnd" value="">
                        </div>
                    </div>
                </div> -->
                <!-- <div class="col-4">
                    <label class="item-name col-5">列入严违文号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="addSecNo" value="" >
                        </div>
                    </div>
                </div> -->
            </div>
            <div class="form-item clearfix apply_in" >
                <!-- <div class="col-4">
                    <label class="item-name col-5">列入严违日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" onclick="laydate()"
                                   name="addSecDateBegin" value="">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" onclick="laydate()"
                                   name="addSecDateEnd" value="">
                        </div>
                    </div>
                </div> -->
            </div>
            <div class="form-item clearfix mb10 apply_in" >
                
            </div>
            <div class="form-item">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="reset" id="reset" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </form>
</div>
<div class="light-info mt5">
    <span class="light">提示：列入严违失信名单的处罚类依据仅限来自工商部门的行政处罚。“列入严违期限”指企业列入严重违法失信名单依据的相关信息在企业信用信息公示系统公示之日起10个自然日内。点击“详情”和“打印”可查看与打印企业处罚类严违名单相关资料。</span>
</div>
<div class="clearfix mb5 mt5">
    <span class="light-yellow fr mt5">查询结果：
    	待初审<span id="firstTotal"></span>条，
    	初审不通过<span id="firstNotTotal"></span>条，
    	待审核<span id="auditTotal"></span>条
   	</span>
</div>

<div class="table-out">
    <div class="iframe-wrap">
        <table id="qua-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="white-space: nowrap;width: 100%;">
            <thead>
	            <tr>
	                <th>序号</th>
	                <th>操作</th>
	                <th>统一代码/注册号</th>
	                <th>当事人名称</th>
	                <th>法定代表人/负责人</th>
	                <th>业务类型</th>
	                <th>业务状态</th>
	                <th>严违失信类型</th>
	                <th>列入严违期限</th>
	                <th>列入严违原因</th>
	            </tr>
            </thead>
        </table>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/secnocreditmanage/exppunmanage/apply_first_list.js"></script>
</body>
</html>