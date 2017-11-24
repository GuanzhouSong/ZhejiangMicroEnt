<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>公示出资到期监控管理</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
	<div class="tabbale" data-component="tab">
       	<form id="searchForm" class="form-box mb5 searchForm">
       	<input type="hidden" id="entTypeCatg" value="11,13,31,33,12,14,32,34,21,27,24,22,28">
            <div class="form-list pdr8">
                   <div class="form-item clearfix">
                   	<div class="col-4">
                           <label class="item-name col-5"><span class="long-label">实缴认缴：</span></label>
                           <div class="col-7">
                               <div class="ipt-box col-12">
                               		<input type="checkbox" checked="checked" disabled="disabled">实缴
                               		<input type="checkbox" checked="checked" disabled="disabled">认缴
                               </div>
                           </div>
                       </div>
                       <div class="col-4">
                           <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
                           <div class="col-7">
                               <div class="ipt-box col-11">
                               <input name="cidRegNO" type="text" class="ipt-txt clear">
                               </div>
                           </div>
                       </div>
                       <div class="col-4">
                           <label class="item-name col-5">企业登记机关：</label>
                           <div class="col-7">
                               <div class="ipt-box col-11">
                                   <input id="regOrg" name="regOrg" type="hidden" class="ipt-txt clear">
                                   <input id="regOrgName" type="text" class="ipt-txt clear" readonly/>
                                   <a id="choseorgReg" class="link js-show"> 
										<span class="add-icon" id=""><i></i></span>
										</a>
                               </div>
                           </div>
                       </div>
                     </div>
                    <div class="form-item clearfix">
                    	<div class="col-4">
                            <label class="item-name col-5">分期出资：</label>
                            <div class="col-7">
                                <div class="ipt-box col-12">
                                	<select name="isInvStages">
                                		<option value="">全部</option>
                                		<option value="1">是</option>
                                		<option value="0">否</option>
                                	</select>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">企业名称：</label>
                            <div class="col-7">
                                <div class="ipt-box col-11">
                                 	<input name="entName" type="text" class="ipt-txt clear">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">企业管辖单位：</label>
                            <div class="col-7">
                                <div class="ipt-box col-11">
                                    <input id="localAdm" name="localAdm" type="hidden" class="ipt-txt clear">
                                    <input id="localAdmName" type="text" class="ipt-txt clear" readonly/>
                                     <a id="choseregUnit" class="link js-show">
											<span class="add-icon" id=""><i></i></span>
											</a>
                                </div>
                            </div>
                        </div>
                    </div>
                  <div class="form-item clearfix">
                  	<div class="col-4">
                          <label class="item-name col-5">出资到位情况：</label>
                          <div class="col-7">
                              <div class="ipt-box col-12">
                              		<input type="hidden" name="invPlace" id="invPlace">
                               	    <select name="invPlaceM" id="invPlaceM" multiple="multiple">
	                              		<option value="1">零出资</option>
	                              		<option value="2">部分出资</option>
	                              		<option value="3">全额出资</option>
	                              	</select>
                              </div>
                          </div>
                      </div>
                      <div class="col-4">
                          <label class="item-name col-5">出资到期情况：</label>
                          <div class="col-7">
                              <div class="ipt-box col-11">
                              	<select name="invExpire">
                              		<option value="">全部</option>
                              		<option value="1">未到期</option>
                              		<option value="2">将到期</option>
                              		<option value="3">已到期</option>
                              	</select>
                              </div>
                          </div>
                      </div>
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
                </div>
              <div id="hideorshow" style="display: none">
                   <div class="form-item clearfix">
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
                            <label class="item-name col-5">成立日期：</label>
                           <div class="col-7">
                               <div class="ipt-box col-5">
                                   <input name="estDateStart" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
                               </div>
                               <span class="item-txt">至</span>
                               <div class="ipt-box col-5">
                                   <input name="estDateEnd" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
                               </div>
                           </div>
                       </div>
                       <div class="col-4">
                           <label class="item-name col-5">住所：</label>
                           <div class="col-7">
                               <div class="ipt-box col-11">
                                	<input name="dom" type="text" class="ipt-txt clear">
                               </div>
                           </div>
                       </div>
                   </div>
                   <div class="form-item clearfix">
	                   	<div class="col-4">
                           <label class="item-name col-5">设置人：</label>
                           <div class="col-7">
                               <div class="ipt-box col-12">
                                	<input name="setName" type="text" class="ipt-txt clear">
                               </div>
                           </div>
                       </div>
                       <div class="col-4">
                            <label class="item-name col-5">最近应出资期限：</label>
                           <div class="col-7">
                               <div class="ipt-box col-5">
                                   <input name="lastTermInvDateStart" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
                               </div>
                               <span class="item-txt">至</span>
                               <div class="ipt-box col-5">
                                   <input name="lastTermInvDateEnd" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
                               </div>
                           </div>
                       </div>
                       <div class="col-4">
                           <label class="item-name col-5">币种：</label>
                           <div class="col-7">
                               <div class="ipt-box col-11">
                                	<input name="currencyCN" type="text" class="ipt-txt clear">
                               </div>
                           </div>
                       </div>
                   </div>
                   <div class="form-item clearfix">
                   	<div class="col-4">
                           <label class="item-name col-5">正在进行简易注销：</label>
                           <div class="col-7">
                               <div class="ipt-box col-12">
                               		<select name="isSim">
                               			<option value="">全部</option>
                               			<option value="1">是</option>
                               			<option value="0">否</option>
                               		</select>
                               </div>
                           </div>
                       </div>
                       <div class="col-4">
                            <label class="item-name col-5">最末应出资期限：</label>
                           <div class="col-7">
                               <div class="ipt-box col-5">
                                   <input name="endTermInvDateStart" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
                               </div>
                               <span class="item-txt">至</span>
                               <div class="ipt-box col-5">
                                   <input name="endTermInvDateEnd" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
                               </div>
                           </div>
                       </div>
                   </div>
              </div>
              	<div class="center mt10">
		            <input type="button" id="qua-search" value="查询" class="btn mr20">
		            <input type="button" id="cancel" onclick="$('#searchForm')[0].reset();" value="重置" class="btn mr20">
		       		<input type="button" id="more" value="更多查询条件" class="btn mr20">
	        	</div>
                </div>
            </form>
        </div>
 <div class="light-info">
    <span class="light">提示：系统默认查询结果为在本局登记或管辖的在册公司类企业的出资信息。 
     <i class="light-box-y mr5"></i>表示企业正在进行简易注销公告。企业出资信息通过工商部门、企业年报、企业即时信息中进行综合取值。
    </span>
</div>
<div class="tip-info">
	<div class="right">
		<label class="light-blue">查询结果</label>：
		企业共<label id="ent" class="light-blue">0</label>家，
		零出资<label id="zereoinv" class="light-blue">0</label>家，
		部分出资<label id="partinv" class="light-blue">0</label>家，
		全额出资<label id="allinv" class="light-blue">0</label>家，
		未全额出资企业中将到期<label id="partinvexpire" class="light-blue">0</label>家，
		已到期<label id="alreadyexpire" class="light-blue">0</label>户。
	</div>
</div>
<div class="table-out">
<div class="iframe-wrap">
    <table id="qua-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="white-space: nowrap;width: 100%;">
        <thead>
        <tr>
            <th>序号</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>成立日期</th>
            <th>注册资本</th>
            <th>币种</th>
            <th>实缴公示总额</th>
            <th>分期出资</th>
            <th>出资状况</th>
            <th>最近应出资日期</th>
            <th>最末应出资日期</th>
            <th>企业类型</th>
            <th>企业登记机关</th>
            <th>企业管辖单位</th>
            <th>企业法定代表人</th>
            <th>联系电话</th>
            <th>工商联络员</th>
            <th>联络员电话</th>
            <th>住所</th>
            <th>设置人</th>
            <th>设置日期</th>
        </tr>
        </thead>
     </table>
</div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registmanage/inv/invexpire_list.js"></script>
</body>
</html>