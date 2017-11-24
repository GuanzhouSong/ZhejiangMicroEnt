<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>许可证失效到期管理</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
	<div class="tabbale" data-component="tab">
       	<form id="searchForm" class="form-box mb5 searchForm">
       		<input type="hidden" name="regState" value="${regState}">
            <div class="form-list pdr8">
                   <div class="form-item clearfix">
                   	<div class="col-4">
                           <label class="item-name col-5"><span class="long-label">许可证名称：</span></label>
                           <div class="col-7">
                               <div class="ipt-box col-12">
                               		<input name="licNameCN" type="text" class="ipt-txt clear">
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
                            <label class="item-name col-5">许可证来源：</label>
                            <div class="col-7">
                                <div class="ipt-box col-12">
                                 	<input type="text" class="ipt-txt clear" value="专项检查主体库" readonly="readonly">
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
                          <label class="item-name col-5">许可证类型：</label>
                          <div class="col-7">
                              <div class="ipt-box col-12">
                               	<input name="leixing" type="checkbox"> 前置
                               	<input name="leixing" type="checkbox"> 后置
                              </div>
                          </div>
                      </div>
                      <div class="col-4">
                          <label class="item-name col-5">许可证到期情况：</label>
                          <div class="col-7">
                              <div class="ipt-box col-11">
                              	<select name="expire">
                              		<option value="">全部</option>
                              		<option value="1">未到期</option>
                              		<option value="2">将到期</option>
                              		<option value="3">已到期</option>
                              	</select>
                              </div>
                          </div>
                      </div>
                      <div class="col-4">
                          <label class="item-name col-5">许可证有效状态：</label>
                          <div class="col-7">
                              <div class="ipt-box col-11">
                              	<select name="licState">
                              		<option value="">全部</option>
                              		<option value="1">有效</option>
                              		<option value="0">无效</option>
                              	</select>
                              </div>
                          </div>
                      </div>
                </div>
              <div id="hideorshow" style="display: none">
                   <div class="form-item clearfix">
                   	<div class="col-4">
                           <label class="item-name col-5">许可证编号：</label>
                           <div class="col-7">
                               <div class="ipt-box col-12">
                                	<input name="licNO" type="text" class="ipt-txt clear">
                               </div>
                           </div>
                       </div>
                       <div class="col-4">
                            <label class="item-name col-5">许可证期止：</label>
                           <div class="col-7">
                               <div class="ipt-box col-5">
                                   <input name="licValFrom" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
                               </div>
                               <span class="item-txt">至</span>
                               <div class="ipt-box col-5">
                                   <input name="licValTo" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
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
                           <label class="item-name col-5">许可证登记状态：</label>
                           <div class="col-7">
                               <div class="ipt-box col-12">
                               		<input type="text" class="ipt-txt clear" readonly="readonly" id="licType" value="不限"/>
                               		<!-- 
                               		<select name="licTypeM" id="licTypeM" multiple="multiple">
	                              		<option value="1">存续</option>
	                              		<option value="2">注销</option>
	                              		<option value="3">吊销</option>
	                              		<option value="4">撤销</option>
	                              	</select>
	                              	-->
                               </div>
                           </div>
                       </div>
                       <div class="col-4">
                            <label class="item-name col-5">设置日期：</label>
                           <div class="col-7">
                               <div class="ipt-box col-5">
                                   <input name="setDateStart" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
                               </div>
                               <span class="item-txt">至</span>
                               <div class="ipt-box col-5">
                                   <input name="setDateEnd" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
                               </div>
                           </div>
                       </div>
                       <div class="col-4">
                           <label class="item-name col-5">许可证发证部门：</label>
                           <div class="col-7">
                               <div class="ipt-box col-11">
                                	<input name="licAnth" type="text" class="ipt-txt clear">
                               </div>
                           </div>
                       </div>
                   </div>
                   <div class="form-item clearfix">
                   	<div class="col-4">
                           <label class="item-name col-5">企业类型：</label>
                           <div class="col-7">
                               <div class="ipt-box col-12">
                               		<input type="hidden" name="entTypeCatg" id="entTypeCatg">
                                	<input name="entType" type="checkbox" value="11,13,31,33,12,14,32,34,21,27,24,22,28" checked>企业
                                	<input name="entType" type="checkbox" value="16,17" checked>农专社
                                	<input name="entType" type="checkbox" value="50" checked>个体户
                               </div>
                           </div>
                       </div>
                       <div class="col-4">
                           <label class="item-name col-5">管理记录：</label>
                           <div class="col-7">
                               <div class="ipt-box col-11">
                                	<select name="mgrrec">
	                              		<option value="">全部</option>
	                              		<option value="1">有</option>
	                              		<option value="0">无</option>
	                              	</select>
                               </div>
                           </div>
                       </div>
                       <div class="col-4">
                           <label class="item-name col-5">设置人：</label>
                           <div class="col-7">
                               <div class="ipt-box col-11">
                                	<input name="setName" type="text" class="ipt-txt clear">
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
    <span class="light">提示：系统默认查询结果为在本局登记或管辖的在册企业的许可证信息。
     <i class="light-box-y mr5"></i>表示企业正在进行简易注销公告。许可证到期情况中的“将到期”指截止当前≤30天到期的许可证，包含在未到期许可证中。
    </span>
</div>
<div class="tip-info">
	<div class="right">
		<label class="light-blue">查询结果</label>：
		企业共<label id="ent" class="light-blue">0</label>户，
		许可证<label id="licence" class="light-blue">0</label>张。
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
            <th>企业类型</th>
            <th>许可证名称</th>
            <th>许可证编号</th>
            <th>许可期始</th>
            <th>许可期止</th>
            <th>许可证发证部门</th>
            <th>许可证登记状态</th>
            <th>许可证来源</th>
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
<script src="/js/reg/server/other/otherlicence/licenceinvalid_list.js"></script>
</body>
</html>