<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>随机抽取企业</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
<!--     <LINK REL="STYLESHEET" HREF="/CSS/VENDOR/BOOTSTrap.min.css"> -->
</head>
<body class="pd10">
<h3 class="h3-title2">
   第一步： 检查对象名单筛选
</h3>
<div class="form-box mb5">
    <div class="form-list">
    	<form id="paramForm"><input type="hidden" value="${taskNO }" id="taskNO" name="taskNO"/></form>
    	<form id="searchForm">
    	<input type="hidden" value="" id="firstNum" name="firstNum"/>
    	<input type="hidden" value="" id="total" name="total"/>
    	<input type="hidden" value="${taskNO }" name="taskNO"/>
    	<input type="hidden" id="taskEntCatgCode" name="taskEntCatgCode" value="${pubSctask.taskEntCatgCode}" />
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">检查主体类型：</label>
                <div class="col-7">
                    <div class="radio-box f12">
                        <span id="entType_0" style="display:none"><label><input type="checkbox" id="comType"  name="_checkobx" value="comType" disabled="disabled"/>企业</label></span>
                        <span id="entType_1" style="display:none"><label><input type="checkbox" id="perType" name="_checkobx" value="perType" disabled="disabled"/>个体户</label></span>
                        <span id="entType_2" style="display:none"><label><input type="checkbox" id="farmType" name="_checkobx" value="farmType" disabled="disabled"/>农专社</label></span>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">企业类型：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                       <select name="entTypeCatg" id="entType">
                        <option value="">请选择</option>
                       </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">成立日期：</label>
                <div class="col-7">
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt" readonly="readonly" id="estDateStart" name="estDateStart"/>
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt" readonly="readonly" id="estDateEnd" name="estDateEnd"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">行业：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" id="industryName" readonly="readonly" class="fl ipt-txt" placeholder="选择"/>
                            <span class="add-icon" id="selectIndustry">
                                <i></i>
                            </span>
                            <input type="hidden" name="industryCo" id="industryCo">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">注册资本：</label>
                <div class="col-6">
                    <div class="ipt-box col-5">
                        <input type="text" id="regCapStart" name="regCapStart" placeholder="单位（万元）" class="ipt-txt"/>
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" id="regCapEnd" name="regCapEnd"  placeholder="单位（万元）" class="ipt-txt"/>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">经营范围：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" name="opScope" class="ipt-txt"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">登记机关：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" id="regOrgName" readonly="readonly" class="fl ipt-txt" placeholder="选择"/>
                            <span class="add-icon" id="selectRegOrg">
                                <i></i>
                            </span>
                            <input type="hidden" id="regOrg" name="regOrg">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">管辖单位：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="fl ipt-txt" readonly="readonly" id="localAdmName" placeholder="选择"/>
                            <span class="add-icon" id="selectLocalAdm">
                                <i></i>
                            </span>
                            <input type="hidden" name="localAdm" id="localAdm">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">住所：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" name="dom" class="ipt-txt"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">信用等级：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                       <select name="creLevel">
                       <option value="">暂无数据</option>
                       </select>
                       <!--  <select name="creLevel">
                            <option value="">全部</option>
                            <option value="1">一级</option>
                            <option value="2">二级</option>
                            <option value="3">三级</option>
                        </select> -->
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">实缴实缴制企业：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                    <select name="creLevel">
                       <option value="">暂无数据</option>
                       </select>
                       <!--  <select name="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select> -->
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">行政处罚：</label>
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
<!--             <div class="col-4">
                <label class="item-name col-4 rel-top-16">行政许可：</label>
                <div class="col-7">
                    <div class="col-4 mt6"><label><input type="checkbox"/>前置</label></div>
                    <div class="ipt-box col-8">
                        <select name="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div> -->
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">重点监管对象：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="isIndRegObjName">
                            <option value="">请选择</option>
                            <option value="Y">是</option>
                            <option value="N">否</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">关注服务对象：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="isFocusObjName">
                            <option value="">请选择</option>
                            <option value="Y">是</option>
                            <option value="N">否</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name rel-top-16 col-4">年报情况：</label>
                <div class="col-7">
                    <div class="col-4 item-name">年度：</div>
                    <div class="ipt-box col-8">
                        <select name="yrYear"  id="reportYear">
                            <option value=""></option>
		                 	<c:forEach items="${yearList}" var="year" varStatus="status">
		                 		<option value="${year}">${year}</option>
		                 	</c:forEach>
                        </select>
                    </div>
                </div>
            </div>
<!--             <div class="col-4">
                <label class="item-name col-4"></label>
                <div class="col-7">
                    <div class="col-4 mt6"><label><input type="checkbox"/>后置</label></div>
                    <div class="ipt-box col-8">
                        <select name="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div> -->
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">是否进入异常名录：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                       <select name="isOpan">
							 <option value="">请选择</option>
							 <option value="Y">是</option>
							 <option value="N">否</option>
						</select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">是否有风险预警：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="markClass" class="clx">
                            <option value="">请选择</option>
							 <option value="Y">是</option>
							 <option value="N">否</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4"></label>
                <div class="col-7">
                    <div class="col-4 item-name">年报状态：</div>
                    <div class="ipt-box col-8">
                      <select name="yrIsRep" >
                        <option value=""></option>
                        <option value="0">未年报</option>
                        <option value="1">已年报</option>
                        <option value="2">已年报（逾期）</option>
                      </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">一年内是否被抽查：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="spotDate">
                            <option value="">请选择</option>
                            <option value="Y">是</option>
                            <option value="N">否</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix mb10">
        </div>
        <div class="form-item clearfix">
            <div class="center">
                <input type="button" value="查 询" id="search" class="btn mr20"/>
                <input type="button" value="重 置" id="cancel" class="btn"/>
            </div>
        </div>
    </div>
</div>
</form>
<h5 class="h5-title">筛选结果  
<input type="checkbox" id="chooseAll" name="chooseAll"/>
<label for="chooseAll">选中所有结果</label>
</h5>
<div>
    <table border="0" id="list-table" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 nowrap">
        <thead>
        <tr>
            <th style="padding:0 20px;">序号</th>
            <th><label><input type="checkbox" id="checkboxallid"/>全选（当前页）</label></th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人</th>
            <th>联系电话</th>
            <th>联络员</th>
            <th>联络员电话</th>
            <th>成立日期</th>
            <th>企业类型</th>
        </tr>
        </thead>
    </table>
</div>
<h3 class="h3-title2">
   第二步： 生成确认待抽取对象名录库
</h3>
<div class="center">
    <input type="button" class="btn" id="addPubscinfoBack" value="加入待抽检库"/>
</div>

<div class="clearfix mb5 mt20">
    <h5 class="fl mr10 h5-title">待抽检库</h5>
    <p class="fl">
    <input type="button" class="btn btn-sm" id="insertBatchBack" value="excel导入"/>
    <input type="button" class="btn btn-sm mr5" id="cleanPubscinfoBack" value="清除"/>
    </p>
</div>
<div>
    <table border="0" id="back-table" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 mb10 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人</th>
            <th>联系电话</th>
            <th>联络员</th>
            <th>联络员电话</th>
            <th>成立日期</th>
            <th>企业类型</th>
            <th>行业</th>
        </tr>
        </thead>
    </table>
</div>
<div class="center">
    <input type="button" class="btn" id="confirmPubscinfoBack" value="确认本次抽取对象"/>
    <input type="hidden" id="confirmFlag" value="N"/>
</div>
<h3 class="h3-title2">
 第三步：摇号抽取被检查对象
</h3>
<h5 class="h5-title">抽查检查名单抽取设置</h5>
<div class="form-box">
    <div class="form-list">
        <div class="form-item clearfix mb10">
            <div class="col-3">
                <div class="col-6 item-name">本次任务待抽取对象</div>
                <div class="col-6 left item-txt" id="totalWating">共0户</div>
            </div>
            <div class="col-3">
                <div class="col-4 item-name">抽取方式：</div>
                <div class="col-7 left item-txt">
                <select>
                	<option>按序号等比例抽取</option>
                	<option>按登记机关等量抽取</option>
                </select>
                </div>
            </div>
            <div class="col-3">
                <div class="col-6 item-name">本次抽取比例：</div>
                <div class="col-6 ipt-box">
                    <div class="col-8"><input type="text" class="ipt-txt" id="checkpercent"/></div>
                    <div class="col-1 item-txt">%</div>
                </div>
            </div>
            <div class="col-3">
                <div class="col-6 item-name" id="itemcount">应抽取户数：</div>
                <div class="col-6 item-txt left" id="totalSelected">0</div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="center">
                <input type="button" value="随机抽取被检查名单" class="btn mr20" id="randombutton"/>
                <input type="button" value="查看已抽取被检查名单" class="btn" id="searchInfo"/>
            </div>
        </div>
    </div>
</div>
<div class="clearfix mb5 mt20">
    <h5 class="fl mr10 h5-title" id="totalH5">抽查检查名单：共${pubSctask.totalEnt == '' || empty pubSctask.totalEnt ? 0:pubSctask.totalEnt }户</h5>
    <input type="hidden" value="" id="totalEnt"/>
    <p class="fl">
<!--     <input type="button" class="btn btn-sm mr5" id="cleanInfo" value="清除"/> -->
<!--     <input type="button" class="btn btn-sm" value="导出"/> -->
    </p>
</div>
<div>
    <table border="0" id="info-table" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 mb10 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人</th>
            <th>联系电话</th>
            <th>联络员</th>
            <th>联络员电话</th>
            <th>成立日期</th>
            <th>企业类型</th>
            <th>行业</th>
        </tr>
        </thead>
    </table>
    <div class="center mb20">
<!--         <input type="button" value="打印" class="btn mr20"/> -->
        <input type="button" value="锁定并发送抽查任务" id="commit" class="btn mr20"/>
        <input type="button" value="取消本次摇号结果" id="close" class="btn"/>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/sctack/randomentinfo_main.js"></script>
</body>
</html>