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
    <title>企业年报综合查询</title>
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
                    <label class="item-name col-5">年报主体：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" name="entTypeCatg" id="entTypeCatg">
                            <input type="checkbox" name="entCatg" checked="checked" value="11,13,31,33,12,14,32,34,21,27,24,22,28">企业
                            <input type="checkbox" name="entCatg" value="16,17">农专社
                            <input type="checkbox" name="entCatg" value="50">个体户
                        </div>
                    </div>
                </div>
                <input type="hidden" name="type" id="type">
                <input type="hidden" name="yrRepState" id="yrRepState" >
                <input type="hidden" name="regState" id="regState">
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cidRegNO" value="" placeholder="可输入尾号后4位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">法定代表人/负责人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="leRep" value=""/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
	                    <label class="item-name col-5">企业类型：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                        	<input type="hidden" class="ipt-txt" name="entType" id="entType" value=""/>
	                            <input type="text" readonly="readonly" class="ipt-txt" id="entTypeName" value="" />
		                         <span class="add-icon" id="chooseEntType">
	                                <i></i>
		                         </span>
	                        </div>
	                    </div>
	             </div>
            	
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="regOrgName" value="" />
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">年度：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="yrYear" id="yrYear">
                            	<c:forEach var="year" items="${yearList }">
                                	<option value='${year-1 }'>${year-1 }</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
	                    <label class="item-name col-5">年报方式：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                            <select name="yrRepMode" id="yrRepMode">
	                                <option value="">全部</option>
	                                <option value="5">数字证书</option>
	                                <option value="2">联络员</option>
	                                <option value="6">纸质报告</option>
	                                <option value="4">手机APP</option>
	                            </select>
	                        </div>
	                    </div>
	             </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="localAdmName" value="" />
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
                
            </div>
            
            <div class="form-item clearfix">
	            <div class="col-4">
	                    <label class="item-name col-5">年度年报状态：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                        	<select name="yrIsRep" id="yrIsRep">
	                                <option value="">全部</option>
	                                <option value="0">未年报</option>
	                                <option value="1,2">已年报</option>
	                                <option value="2">已年报(逾期)</option>
	                            </select>
	                        </div>
	                    </div>
	            </div>
                <div class="col-4">
                    <label class="item-name col-5">年报日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="yrFirRepTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="yrFirRepTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">片区：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNo" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="sliceNoName" value="" />
	                         <span class="add-icon" id="chooseSliceNo">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
             </div>
	     <div id="hideorshow" style="display: none">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">联系电话：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="tel" value="" />
                        </div>
                    </div>
                </div>
                <div class="col-4">
	                    <label class="item-name col-5"><span class="long-label">列入经营异常原因：</span></label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12" id="isOpan">
	                            <select name="isOpan">
	                                <option value="">全部</option>
	                                <option value="1">未按时年报</option>
	                                <option value="2">未在责令期限内公示</option>
	                                <option value="3">公示信息虚假</option>
	                                <option value="4">查无下落</option>
	                            </select>
	                        </div>
	                    </div>
	             </div>
                <div class="col-4">
                    <label class="item-name col-5">行业：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="industryCo" id="industryCo" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="industryCoName" value=""/>
	                            <span class="add-icon" id="choseindustry">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
	                    <label class="item-name col-5"><span class="long-label">个转企：</span></label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <select name="isIndivid" id="isIndivid">
	                                <option value="">全部</option>
	                                <option value="1">是</option>
	                                <option value="0">否</option>
	                            </select>
	                        </div>
	                    </div>
	             </div>
	             <div class="col-4">
                    <label class="item-name col-5">注册资本：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt" id="regCapStart" name="regCapStart" value="" placeholder="单位(万元)"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575"> 
                        	<input type="text" class="ipt-txt" id="regCapEnd" name="regCapEnd" value="" placeholder="单位(万元)"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="regStateM" id="regStateM" multiple="multiple">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
	                    <label class="item-name col-5"><span class="long-label">涉及过敏感词：</span></label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <select name="yrSenCheck" id="yrSenCheck">
	                                <option value="">全部</option>
	                                <option value="Y">是</option>
	                                <option value="N">否</option>
	                            </select>
	                        </div>
	                    </div>
	             </div>
            	<div class="col-4">
                    <label class="item-name col-5">成立日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="estDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly"
                                   name="estDateEnd" value=""/>
                        </div>
                    </div>
                </div>
	             <div class="col-4">
	                    <label class="item-name col-5">经营范围：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <input type="text" class="ipt-txt" name="opScope" value="" placeholder="可输入关键词查询"/>
	                        </div>
	                    </div>
	             </div>
            </div>
            <div class="form-item clearfix">
	             <div class="col-4">
	                    <label class="item-name col-5">当前年报状态：</label>
	                    <div class="col-7">
	                    	<div class="ipt-box col-11">
	                        	<select name="yrRepStateM" id="yrRepStateM" multiple="multiple">
	                                <option value="00">未公示</option>
	                                <option value="10">已公示</option>
	                                <option value="12">已公示(敏感词待审核)</option>
	                                <option value="11">已公示(敏感词通过)</option>
	                                <option value="13">已公示(敏感词不通过)</option>
	                                <option value="20">待修改</option>
	                            </select>
	                        </div>
	                    </div>
	              </div>
	              <div class="col-4">
                    <label class="item-name col-5">最近修改日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" name="yrRecRepTimeStart"
                                   onclick="laydate()" readonly="readonly" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" name="yrRecRepTimeEnd"
                                   onclick="laydate()" readonly="readonly" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">住所：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="dom" value="" placeholder="可输入关键词查询"/>
                        </div>
                    </div>
                 </div>
	         </div>
	         <div class="form-item clearfix">
	         	<div class="col-4">
                    <label class="item-name col-5">工商联络员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" name="liaName" class="ipt-txt" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">不良信息：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="badInfo" id="badInfo" value=""/>
                            <select name="badInfoM" id="badInfoM" multiple="multiple">
                                <option value='1'>列入经营异常</option>
                                <option value='2'>列入严重违法失信（黑名单）</option>
                                <option value='3'>有行政处罚信息</option>
                                <option value='4'>有司法协助信息</option>
                                <option value='5'>任职资格受限</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">是否简易注销：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="isSim" id="isSim">
                                <option value=''>全部</option>
                                <option value='Y'>是</option>
                                <option value='N'>否</option>
                            </select>
                        </div>
                    </div>
                 </div>
             </div>
       </div>
        <div class="center mt10">
            <input type="button" id="js-search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
       		<input type="button" id="more" value="更多查询条件" class="btn mr20">
        </div>
        </div>
    </form>
</div>

<div style="display: none">
	<form action="/reg/server/panoramasearch/comPanoQueryPageDownLoad" method="post" name="_form">
		<input type="hidden" name="map" id="map">
	</form>
</div>
<div>
	<input type="button" id="js-download"  value="导出全部" class="btn mr20">
	注：导出全部最多支持2万条，请务必先填写条件，查询出不要超过2万条的数据，再点击全部导出。
</div>
<!--
<div>
	 <a href="<c:url value='/reg/server/panoramasearch/comPanoQueryPageDownLoad'/>">导出全部</a>
	 <input type="button" id="js-download"  value="导出全部" class="btn mr20">
</div>
-->
<div class="light-info">
    <span class="light">提示：
    <i class="bulb yellow-b"></i>
        表示被列入经营异常，
         <i class="bulb orange-b"></i>
        表示被列入严重违法失信，
         <i class="bulb red-b"></i>
        表示被列入严违名单和异常名录企业。
    <i class="light-box-y mr5"></i>
   表示企业正在进行简易注销公告。
   <!-- 
    &nbsp;&nbsp;
    <img src='/img/reg/server/year-status4.png' width='15' height='15'/> 表示≤30天到期未年报的企业
    &nbsp;&nbsp;
    <img src='/img/reg/server/year-status2.png' width='15' height='15'/> 表示年报敏感词不通过的企业
    &nbsp;&nbsp;
    <img src='/img/reg/server/year-status1.png' width='15' height='15'/> 表示已正常年报的企业
     -->
    </span>
</div>

<div class="tab-content mb20 mt10">
    <div class="tab-panel tab-panel-show">
        <div class="">
            <div class="table-out">
                <table id="user-table" border="0" cellspacing="0" cellpadding="0"
                       class="table-row display nowrap">
                    <thead>
	                    <tr>
	                        <th>序号</th>
	                        <th>警示</th>
	                        <th>统一代码/注册号</th>
	                        <th>企业名称</th>
	                        <th>成立日期</th>
	                        <th>年度</th>
	                        <th>年报状态</th>
	                        <th>年报方式</th>
	                        <th>年报日期</th>
	                        <th>最近修改日期</th>
	                        <th>当前年报状态</th>
	                        <th>法定代表人/负责人</th>
	                        <th>负责人电话</th>
	                        <th>企业联络员</th>
	                        <th>联络员电话</th>
	                        <th>注册资本(万元)</th>
	                        <th>企业类型</th>
	                        <th>行业</th>
	                        <th>住所地</th>
	                        <th>登记机关</th>
	                        <th>管辖单位</th>
	                        <th>片区/商圈</th>
	                        <th>登记状态</th>
	                        <th>是否列入经营异常</th>
	                        <th>是否列入严重违法失信</th>
	                        <th>是否正在简易注销公告</th>
	                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

<form id="praramContent">
    <input type="hidden" id="_entTypeCatg" name="entTypeCatg" value="">
    <input type="hidden" id="entType1"    name="entType"     value="">
    <input type="hidden" id="priPID"      name="priPID"      value="">
    <input type="hidden" id="year"        name="year"        value="">
    <input type="hidden" id="regNO"       name="regNO"       value="">
    <input type="hidden" id="entName"     name="entName"     value="">
    <input type="hidden" id="uniscid"     name="uniscid"     value="">
    <input type="hidden" id="estDate"     name="estDate"     value="">
    <input type="hidden" id="liaName"     name="liaName"     value="">
    <input type="hidden" id="liaTel"      name="liaTel"      value="">
    <input type="hidden" id="js_isIndivid" name="isIndivid"  value="">
    <input type="hidden" id="altDate"      name="altDate"     value="">
    <input type="hidden" id="leRep"        name="leRep"       value="">
    <input type="hidden" id="leRepTel"     name="leRepTel"     value="">
</form>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/entreportsearch/list_main.js"></script>
</body>
</html>
