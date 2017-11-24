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
    <title>小微企业信息查询</title>
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="cidRegNO" value="">
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
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="regOrgName" value="" />
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
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
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="regState" id="regState">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
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
                    <label class="item-name col-5">住所：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="dom" value="" placeholder="可输入关键词查询"/>
                        </div>
                    </div>
                 </div>
	             <div class="col-4">
	                    <label class="item-name col-5">经营范围：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                            <input type="text" class="ipt-txt" name="opScope" value="" placeholder="可输入关键词查询"/>
	                        </div>
	                    </div>
	             </div>
	            <div class="col-4">
                    <label class="item-name col-5">八大产业类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                        	<select name="industryType" id="industryType">
                                <option value="">请选择</option>
                                <option value="1">信息经济产业</option>
                                <option value="2">环保产业</option>
                                <option value="3">旅游产业</option>
                                <option value="4">金融产业</option>
                                <option value="5">健康产业</option>
                                <option value="6">时尚产业</option>
                                <option value="7">高端装备制造产业</option>
                                <option value="8">文化创意产业</option>
                                <option value="0">全部</option>
                            </select>
                        </div>
                    </div>
	            </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">培育库类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                        	<select name="cultivationTypeCode" id="cultivationTypeCode">
                                <option value="">请选择</option>
                                <option value="1">初创型</option>
                                <option value="2">成长型</option>
                                <option value="3">领军型</option>
                            </select>
                        </div>
                    </div>
	            </div>
	            <div class="col-4">
					<label class="item-name col-5">企业需求类别：</label>
					<div class="col-7">
						<div class="ipt-box col-12">
							 <input type="text"  id="helpTypeName"  class="ipt-txt clx" value="" readonly/>
			                 <input type="hidden" id="helpTypeCode" name="helpTypeCode" class="clx" value="" />
				                 <a id="selecthelpTypeCode" class="link js-show">
			                  		<span class="add-icon" id="yccodetree"><i></i></span>
			                	 </a>
						</div>
					</div>
				</div>
            </div>
        <div class="center mt10">
            <input type="button" id="js-search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
        </div>
        </div>
    </form>
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
	                        <th>登记状态</th>
	                        <th>统一代码/注册号</th>
	                        <th>企业名称</th>
	                        <th>培育库类别</th>
	                        <th>企业需求类别数量</th>
	                        <th>企业帮扶服务类别数量</th>
	                        <th>八大行业类别</th>
	                        <th>成立日期</th>
	                        <th>注册资本(万元)</th>
	                        <th>企业类型</th>
	                        <th>行业</th>
	                        <th>住所</th>
	                        <th>登记机关</th>
	                        <th>管辖单位</th>
	                        <th>片区/商圈</th>
	                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/smentsearch/smentsearch_view.js"></script>
</body>
</html>
