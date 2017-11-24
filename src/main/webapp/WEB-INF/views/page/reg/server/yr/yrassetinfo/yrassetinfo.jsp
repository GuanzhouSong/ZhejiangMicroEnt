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
    <title>年报资产类信息查询</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
   	<form id="taskForm" class="form-box mb5">
   		<input type="hidden" name="zeroAppItem1" id="zeroAppItem1" >
   		<input type="hidden" name="zeroAppItem2" id="zeroAppItem2" >
   		<input type="hidden" name="zeroAppItem3" id="zeroAppItem3" >
        <div class="form-list pdr8">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">年报主体：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="radio" id="ent" name="entTypeCatg" checked="checked" value="11,13,31,33,12,14,32,34,21,27,24,22,28">企业
                            <input type="radio" id="slf" name="entTypeCatg" value="16,17">农专社
                            <input type="radio" id="pb" name="entTypeCatg" value="50">个体户
                        </div>
                    </div>
                </div>
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
                    <label class="item-name col-5">年报年度：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="year" id="year">
                            	<c:forEach var="year" items="${yearList }">
                                	<option value='${year-1 }'>${year-1 }</option>
                            	</c:forEach>
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
	     <div id="hideorshow" style="display: none">
            <div class="form-item clearfix">
            	<div class="col-4">
	                    <label class="item-name col-5">控股情况：</label>
	                    <div class="col-7">
	                    	<div class="ipt-box col-11">
	                        	<select name="entControl" id="entControl">
	                                <option value="">全部</option>
	                                <option value="1">国有控股</option>
	                                <option value="2">集体控股</option>
	                                <option value="3">私人控股</option>
	                                <option value="4">港澳台商控股</option>
	                                <option value="5">外商控股</option>
	                                <option value="7">私营企业</option>
	                                <option value="6">其他</option>
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
                                   name="ancheDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="ancheDateEnd" value=""/>
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
             <div class="form-item clearfix">
	             <div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="regState" id="regState" >
                            	<option value=''>全部</option>
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
                            	</c:forEach>
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
	                    <label class="item-name col-5"><span class="long-label">零申报项：</span></label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12" id="zero1">
	                            <select name="zeroAppItemM" id="zeroAppItemM1" multiple="multiple">
	                                <option value="1">资产总额</option>
	                                <option value="2">负债总额</option>
	                                <option value="3">所有者权益合计</option>
	                                <option value="4">营业总收入</option>
	                                <option value="5">主营业务收入</option>
	                                <option value="6">利润总额</option>
	                                <option value="7">净利润</option>
	                                <option value="8">纳税总额</option>
	                            </select>
	                        </div>
	                        <div class="ipt-box col-12" style="display: none" id="zero2">
	                            <select name="zeroAppItemM" id="zeroAppItemM2" multiple="multiple">
	                                <option value="1">销售额或营业收入</option>
	                                <option value="2">盈余总额</option>
	                                <option value="3">纳税金额</option>
	                                <option value="4">获得政府扶持资金</option>
	                                <option value="5">补助</option>
	                                <option value="6">金融贷款</option>
	                            </select>
	                        </div>
	                        <div class="ipt-box col-12" style="display: none" id="zero3">
	                            <select name="zeroAppItemM" id="zeroAppItemM3" multiple="multiple">
	                                <option value="1">营业额或营业收入</option>
	                                <option value="2">纳税总额</option>
	                            </select>
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
	                    <label class="item-name col-5"><span class="long-label">经营状态：</span></label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <select name="busSt" id="busSt">
	                                <option value="">全部</option>
	                                <option value="1">开业</option>
	                                <option value="2">筹建</option>
	                                <option value="3">停业</option>
	                                <option value="4">歇业</option>
	                                <option value="5">清算</option>
	                            </select>
	                        </div>
	                    </div>
	             </div>
            	<div class="col-4">
                    <label class="item-name col-5">从业人数：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt" id="empNumStart" name="empNumStart" value="" />
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575"> 
                        	<input type="text" class="ipt-txt" id="empNumEnd" name="empNumEnd" value="" />
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
       </div>
        <div class="center mt10">
            <input type="button" id="js-search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
       		<input type="button" id="more" value="更多查询条件" class="btn mr20">
        </div>
        </div>
    </form>
</div>
<div id="entlist">
	<div class="light-info">
	    <span class="light">提示：金额信息单位均为万元。个体户纸质报告方式的数据来自补录信息。</span>
	</div>
	<div class="tab-content mb20 mt10">
       <div class="table-out">
           <table id="user-table-1" border="0" cellspacing="0" cellpadding="0"
                  class="table-row display nowrap">
               <thead>
                <tr>
                    <th>序号</th>
                    <th>统一信用代码/注册号</th>
                    <th>企业名称</th>
                    <th>法定代表人/负责人</th>
                    <th>成立日期</th>
                    <th>注册资本</th>
                    <th>币种</th>
                    <th>个转企</th>
                    <th>年报年度</th>
                    <th>年报日期</th>
                    <th>资产总额</th>
                    <th>负债总额</th>
                    <th>所有者权益合计</th>
                    <th>营业总收入</th>
                    <th>主营业务收入</th>
                    <th>利润总额</th>
                    <th>净利润</th>
                    <th>纳税总额</th>
                    <th>从业人数</th>
                    <th>女性从业人数</th>
                    <th>控股情况</th>
                    <th>经营状态</th>
                    <th>登记机关</th>
                    <th>管辖单位</th>
                    <th>片区</th>
                    <th>登记状态</th>
                </tr>
               </thead>
               <tfoot>
			        <tr>
			            <th>合计</th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
			            <th></th>
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
	</div>
</div>
<div id="sfclist" style="display: none">
	<div class="light-info">
	    <span class="light">提示：金额信息单位均为万元。个体户纸质报告方式的数据来自补录信息。</span>
	</div>
	<div class="tab-content mb20 mt10">
	    <div class="tab-panel tab-panel-show">
	        <div class="">
	            <div class="table-out">
	                <table id="user-table-2" border="0" cellspacing="0" cellpadding="0"
	                       class="table-row display nowrap">
	                    <thead>
		                    <tr>
		                        <th>序号</th>
			                    <th>统一信用代码/注册号</th>
			                    <th>企业名称</th>
			                    <th>法定代表人/负责人</th>
			                    <th>成立日期</th>
			                    <th>注册资本</th>
			                    <th>年报年度</th>
			                    <th>年报日期</th>
			                    <th>销售额或营业收入</th>
			                    <th>盈余总额</th>
			                    <th>纳税金额</th>
			                    <th>获得政府扶持资金、补助</th>
			                    <th>金融贷款</th>
			                    <th>从业人数</th>
			                    <th>女性从业人数</th>
			                    <th>登记机关</th>
			                    <th>管辖单位</th>
			                    <th>片区</th>
			                    <th>登记状态</th>
		                    </tr>
	                    </thead>
	                    <tfoot>
					        <tr>
					            <th>合计</th>
					            <th></th>
					            <th></th>
					            <th></th>
					            <th></th>
					            <th></th>
					            <th></th>
					            <th></th>
					            <th></th>
					            <th></th>
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
	        </div>
	    </div>
	</div>
</div>
<div id="pblist" style="display: none">
	<div class="light-info">
	    <span class="light">提示：金额信息单位均为万元。个体户纸质报告方式的数据来自补录信息。</span>
	</div>
	<div class="tab-content mb20 mt10">
	    <div class="tab-panel tab-panel-show">
	        <div class="">
	            <div class="table-out">
	                <table id="user-table-3" border="0" cellspacing="0" cellpadding="0"
	                       class="table-row display nowrap" style="width: 100%">
	                    <thead>
		                    <tr>
		                        <th>序号</th>
			                    <th>统一信用代码/注册号</th>
			                    <th>企业名称</th>
			                    <th>经营者</th>
			                    <th>成立日期</th>
			                    <th>年报年度</th>
			                    <th>年报日期</th>
			                    <th>营业额或营业收入</th>
			                    <th>纳税总额</th>
			                    <th>从业人数</th>
			                    <th>登记机关</th>
			                    <th>管辖单位</th>
			                    <th>片区</th>
			                    <th>登记状态</th>
		                    </tr>
		                    
	                    </thead>
	                    <tfoot>
					        <tr>
					            <th>合计</th>
					            <th></th>
					            <th></th>
					            <th></th>
					            <th></th>
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
	        </div>
	    </div>
	</div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/yrassetinfo/yrassetinfo_main.js"></script>
</body>
</html>
