<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>经营期限到期管理</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <div class="tab-conten">
        <div class="tab-panel tab-panel-show">
       	<form id="searchForm" class="searchForm">
            <div class="form-box pd14-mr">
                <div class="form-list">
                    <div class="form-item clearfix">
                        <div class="col-4">
                            <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
                            <div class="col-7">
                                <div class="ipt-box col-12">
                                <input name="cidRegNO" type="text" class="ipt-txt clear">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">企业名称：</label>
                            <div class="col-7">
                                <div class="ipt-box col-12">
                                 	<input name="entName" type="text" class="ipt-txt clear">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">法定代表人：</label>
                            <div class="col-7">
                                <div class="ipt-box col-11">
                                 	<input name="leRep" type="text" class="ipt-txt clear">
                                </div>
                            </div>
                        </div>
                        </div>
                </div>
                <div class="form-list">
                    <div class="form-item clearfix">
                        <div class="col-4">
                            <label class="item-name col-5">住所：</label>
                            <div class="col-7">
                                <div class="ipt-box col-12">
                                 	<input name="dom" type="text" class="ipt-txt clear">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">登记机关：</label>
                            <div class="col-7">
                                <div class="ipt-box col-12">
                                    <input id="regOrg" name="regOrg" type="hidden" class="ipt-txt clear">
                                    <input id="regOrgName" type="text" class="ipt-txt clear" readonly/>
                                    <a id="choseorgReg" class="link js-show"> 
											<span class="add-icon" id=""><i></i></span>
											</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">管辖单位：</label>
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
                </div>
                <div class="form-list">
                    <div class="form-item clearfix">
                        <div class="col-4">
                            <label class="item-name col-5">提示信息：</label>
                            <div class="col-7">
                                <div class="ipt-box col-12">
			                        <select id="opTip" name="opTip">
			                        	<option value="0" selected>不限</option>
			                        	<option value="1">经营期限到期</option>
			                        	<option value="2">经营期限即将到期</option>
			                        </select>            
                                </div>
                            </div>
                        </div>
                         <div class="col-4">
                             <label class="item-name col-5">经营期限：</label>
                            <div class="col-7">
                                <div class="ipt-box col-5">
                                    <input name="opFrom" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
                                </div>
                                <span class="item-txt">至</span>
                                <div class="ipt-box col-5">
                                    <input name="opTo" type="text" class="ipt-txt laydate-icon clear" onclick="laydate();" readonly />
                                </div>
                            </div>
                          </div>
                        <div class="col-4">
                            <label class="item-name col-5">登记状态：</label>
                            <div class="col-7">
                                <div class="ipt-box col-11">
			                        <select id="regState" name="regState">
			                        	<c:forEach var="regState" items="${regStateEnumMap}">
		                                	<c:if test="${regState.value == 'CUNXU'}">
				                        		<option value='${regState.value.code}' selected="selected">${regState.value.name}</option>
				                        	</c:if>
		                            	</c:forEach>
			                        </select> 
                                </div>
                          </div>
                      </div>
                    </div>
                    <div class="form-item clearfix mt10">
                        <div class="btn-box">
                            <input id="qua-search" type="button" value="查 询" class="btn mr20">
                            <input id="reset" type="button" value="重 置" class="btn">
                        </div>
                    </div>
                </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="clearfix mb5 mt5">
    <p class="fl"><input id="adminguide" type="button" class="btn btn-sm mr5" value="行政指导"/><input id="reform" type="button" class="btn btn-sm mr5" value="责令整改"/></p>
</div>

<div class="table-out">
<div class="iframe-wrap">
    <table id="qua-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="white-space: nowrap;width: 100%;">
        <thead><tr>
            <th width="5%">序号</th>
            <th>选择 </th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人</th>
            <th>住所</th>
            <th>经营期限开始日期</th>
            <th>经营期限截止日期</th>
            <th>提示信息</th>
            <th>登记机关</th>
            <th>管辖单位</th>
        </tr>
        </thead>
     </table>
</div>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registmanage/investmanage/investmanage.js"></script>
</body>
</html>