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
    <title>任职限制对象管理</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
   	<div class="form-item form-box">
   		<div class="col-12">
   			<label class="item-name col-1"></label>
            <div class="col-7">
                <div class="ipt-box col-12">
                    <input type="radio" value="1" name="limit" id="objRadio" checked="checked">按任职限制对象查询
                    <input type="radio" value="2" name="limit" id="entRadio" >按限制对象关联企业查询
                    <input type="radio" value="3" name="limit" id="limiterRadio" >按失信被执行人关联企业查询
                </div>
            </div>
        </div>
   	</div>
   	<input type="hidden" value="${sysdate }" id="sysdate"/>
    <form id="taskForm-1" class="form-box mb5">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">限制对象名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="clientName" value="" placeholder="可输入关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">失信受限企业统一信用代码/注册号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNO" value="" placeholder="可输入尾号后4位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg-1" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="regOrgName-1" value="" />
	                            <span class="add-icon" id="choseorgReg-1">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">限制对象证件号码：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="certNO" value="" placeholder="精确输入"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">失信受限企业名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="可输入名称关键词查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm-1" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="localAdmName-1" value="" />
	                            <span class="add-icon" id="choseregUnit-1">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">限制解除状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="freeState" id="freeState-1" value="1"/>
	                        <select name="freeStateM" id="freeStateM-1" multiple="multiple">
	                            <option value='1' selected="selected">未解除</option>
	                            <option value='2'>已解除</option>
	                        </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">限制原因类别：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<input type="hidden" class="ipt-txt" name="limitType" id="limitType-1" value=""/>
                            <select id="limitTypeM-1" multiple="multiple">
                                <option value='0'>吊销企业</option>
                                <option value='1'>失信被执行人</option>
                                <option value='2'>刑事责任司法判决</option>
                                <option value='3'>失信惩戒黑名单</option>
                                <option value='4'>工商严重违法失信</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管理记录：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="isMgrRec">
	                            <option value="">全部</option>
	                            <option value="1">有</option>
	                            <option value="0">无</option>
	                        </select>
                        </div>
                    </div>
                </div>
            </div>
	     <div id="hideorshow-1" style="display: none">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">限制对象证件类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="certType">
	                            <option value="">不限</option>
	                            <option value="10">居民身份证</option>
	                            <option value="20">军官证</option>
	                            <option value="30">警官证</option>
	                            <option value="40">外国(地区)护照</option>
	                            <option value="52">香港身份证</option>
	                            <option value="54">澳门身份证</option>
	                            <option value="56">台湾身份证</option>
	                            <option value="90">其他有效身份证件</option>
	                        </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">限制期限：</label>
                    <div class="col-6">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="limitDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly"
                                   name="limitDateEnd" value=""/>
                        </div>
                    </div>
                </div>
            </div>
       	</div>
        <div class="center mt10">
            <input type="button" id="js-search-1" value="查询" class="btn mr20">
            <input type="button" id="cancel-1" onclick="$('#taskForm-1')[0].reset();" value="重置" class="btn mr20">
       		<input type="button" id="more-1" value="更多查询条件" class="btn mr20">
        </div>
        </div>
    </form>
    <form id="taskForm-2" class="form-box mb5" style="display: none">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">限制对象类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="checkbox" name="lerep" value='1' checked>法定代表人/负责人
                            <input type="checkbox" name="member" value='1' checked>高管人员
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">关联企业统一信用代码/注册号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNO" value="" placeholder="可输入尾号后4位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg-2" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="regOrgName-2" value="" />
	                            <span class="add-icon" id="choseorgReg-2">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">限制对象姓名：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="clientName" value="" placeholder="可输入关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">关联企业名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="可输入名称关键词查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm-2" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="localAdmName-2" value="" />
	                            <span class="add-icon" id="choseregUnit-2">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">限制对象证件号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name='certNO' value="" placeholder="精确输入"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">限制原因类别：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<input type="hidden" class="ipt-txt" name="limitType" id="limitType-2" value=""/>
                            <select id="limitTypeM-2" multiple="multiple">
                                <option value='0'>吊销企业</option>
                                <option value='2'>刑事责任司法判决</option>
                                <option value='3'>失信惩戒黑名单</option>
                                <option value='4'>工商严重违法失信</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">限制解除状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="freeState" id="freeState-2" value="1"/>
	                        <select name="freeStateM" id="freeStateM-2" multiple="multiple">
	                            <option value='1' selected="selected">未解除</option>
	                            <option value='2'>已解除</option>
	                        </select>
                        </div>
                    </div>
                </div>
            </div>
	     <div id="hideorshow-2" style="display: none">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">限制对象证件类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="certType">
	                            <option value="">不限</option>
	                            <option value="10">居民身份证</option>
	                            <option value="20">军官证</option>
	                            <option value="30">警官证</option>
	                            <option value="40">外国(地区)护照</option>
	                            <option value="52">香港身份证</option>
	                            <option value="54">澳门身份证</option>
	                            <option value="56">台湾身份证</option>
	                            <option value="90">其他有效身份证件</option>
	                        </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">限制期限：</label>
                    <div class="col-6">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="limitDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly"
                                   name="limitDateEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管理记录：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="isMgrRec">
	                            <option value="">全部</option>
	                            <option value="1">有</option>
	                            <option value="0">无</option>
	                        </select>
                        </div>
                    </div>
                </div>
            </div>
       	</div>
        <div class="center mt10">
            <input type="button" id="js-search-2" value="查询" class="btn mr20">
            <input type="button" id="cancel-2" onclick="$('#taskForm-2')[0].reset();" value="重置" class="btn mr20">
       		<input type="button" id="more-2" value="更多查询条件" class="btn mr20">
        </div>
        </div>
    </form>
    <form id="taskForm-3" class="form-box mb5" style="display: none">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">限制对象类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="checkbox" name="lerep" value='1' checked>法定代表人/负责人
                            <input type="checkbox" name="member" value='1' checked>高管人员
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">关联企业统一信用代码/注册号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNO" id="regNO" value="" placeholder="请输入完整统一信用代码/注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg-3" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="regOrgName-3" value="" />
	                            <span class="add-icon" id="choseorgReg-3">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">关联企业法人或高管姓名：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="clientName"  value="" placeholder="请输入完整信息"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">关联企业名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" id="entName" value="" placeholder="请输入完整企业名称">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm-3" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="localAdmName-3" value="" />
	                            <span class="add-icon" id="choseregUnit-3">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
        <div class="center mt10">
            <input type="button" id="js-search-3" value="查询" class="btn mr20">
            <input type="button" id="cancel-3" onclick="$('#taskForm-3')[0].reset();" value="重置" class="btn mr20">
        </div>
        </div>
    </form>
</div>
<div id="obj">
	<div class="light-info">
	    <span class="light">提示：系统默认查询结果为在本局登记或管辖的失信受限企业的限制对象信息。
	    </span>
	</div>
	<div style="margin-top: 2px;">
		<input type="button" id="js-liq" value="打印清算通知书" class="btn mr20">
		<input type="button" id="js-can" value="打印解除证明" class="btn mr20">
		查询结果：限制对象共 <label id="limitObj" class="light-blue">0</label> 人，关联企业共 <label id="relEnt" class="light-blue">0</label> 家 
	</div>
	<div class="tab-content mb20 mt10">
       <div class="table-out">
           <table id="user-table-1" border="0" cellspacing="0" cellpadding="0"
                  class="table-row display nowrap">
               <thead>
                <tr>
                    <th>序号</th>
                    <th>操作</th>
                    <th>姓名</th>
                    <th>证件类型</th>
                    <th>证件号码</th>
                    <th>限制原因类别</th>
                    <th>失信受限企业</th>
                    <th>统一信用代码/注册号</th>
                    <th>受限关联企业</th>
                    <th>管理记录</th>
                    <th>限制开始日期</th>
                    <th>限制结束日期</th>
                    <th>限制解除状态</th>
                    <th>登记机关</th>
                    <th>管辖单位</th>
                </tr>
               </thead>
           </table>
       </div>
	</div>
</div>
<div id="ent" style="display: none">
	<div class="light-info">
	    <span class="light">提示：系统默认查询结果为在本局登记或管辖的受限对象关联企业信息。
	    </span>
	</div>
	<div style="margin-top: 2px;">
		查询结果：限制对象共 <label id="limitObj2" class="light-blue">0</label> 人，关联企业共 <label id="relEnt2" class="light-blue">0</label> 家 
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
		                        <th>受限关联企业</th>
		                        <th>管理记录</th>
		                        <th>限制对象</th>
		                        <th>证件号码</th>
		                        <th>限制开始日期</th>
		                        <th>限制结束日期</th>
		                        <th>限制解除状态</th>
		                        <th>住所</th>
		                        <th>登记机关</th>
		                        <th>管辖单位</th>
		                    </tr>
	                    </thead>
	                </table>
	            </div>
	        </div>
	    </div>
	</div>
</div>
<div id="limiter" style="display: none">
	<div class="tab-content mb20 mt10">
	    <div class="tab-panel tab-panel-show">
	        <div class="">
	            <div class="table-out">
	                <table id="user-table-3" border="0" cellspacing="0" cellpadding="0" width="100%"
	                       class="table-row display nowrap">
	                    <thead>
		                    <tr>
		                        <th>序号</th>
			                    <th>姓名</th>
			                    <th>证件类型</th>
			                    <th>证件号码</th>
			                    <th>限制开始日期</th>
			                    <th>限制结束日期</th>
			                    <th>限制解除状态</th>
		                    </tr>
	                    </thead>
	                </table>
	            </div>
	        </div>
	    </div>
	</div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registmanage/qualifiedmanage/limitobj_main.js"></script>
</body>
</html>
