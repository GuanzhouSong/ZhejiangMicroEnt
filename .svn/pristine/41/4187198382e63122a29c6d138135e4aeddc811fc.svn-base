<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>联络员确认通知书查询</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">主体类别：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="checkbox" name="entTypeCode" value="13,34,26,14,33,23,11,12,32,21,25,24,15,22,31,27,28" checked="checked">企业
                            <input type="checkbox" name="entTypeCode" value="16,17" >农专社
                            <input type="checkbox" name="entTypeCode" value="50" >个体户
                        </div>
                        <input type="hidden" name="entType" id="entType">
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">统一代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regno" placeholder="请输入完整的统一代码/注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">法定代表人/负责人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">联络员姓名：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="liaName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" placeholder="请输入完整的企业名称">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value=""/>
                        <span class="add-icon" id="choseorgReg">
                            <i></i>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">联系电话：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" id="mobile" name="liaTel" value=""
                                   placeholder="联络员或法定代表人电话">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 最近备案方式：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="baType">
                            	<option value="">全部</option>
                            	<option value="0">在线备案</option>
                            	<option value="1">书式备案</option>
                            </select>
                        </div>
                    </div>
                </div>
				<div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regUnit" id="regUnit" value=""/>
                            <input type="text" class="ipt-txt" id="regUnitName" value=""/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix" id="hiddendiv1" style="display: none;">
            	<div class="col-4">
                    <label class="item-name col-5">最近备案日期：</label>
                    <div class="col-6">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="startDate" value="" id="startDate"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly"
                                   name="endDate" value="" id="endDate"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">备案表接收部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="appReviewOrg" id="appReviewOrg" value=""/>
                            <input type="text" class="ipt-txt" id="appReviewOrgName" value=""/>
                              <span class="add-icon" id="choseappReviewOrgDep">
                              <i></i>
                          </span>
                        </div>
                    </div>
                </div>
				<div class="col-4">
                    <label class="item-name col-5">片区：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNo" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="sliceNoName" value="" />
	                         <span class="add-icon" id="chooseSliceNo">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix" id="hiddendiv2" style="display: none;">
            	<div class="col-4">
                    <label class="item-name col-5">企业成立日期：</label>
                    <div class="col-6">
                           <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="estDateStart" value="" id="estDateStart"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly"
                                   name="estDateEnd" value="" id="estDateEnd"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">备案表接收人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                        	<input type="text" class="ipt-txt" name="userName" id="userName">
                        </div>
                    </div>
                </div>
				<div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<select name="regStateM" id="regStateM" multiple="multiple">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                            <input type="hidden" name="regState" id="regState">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="mt10">
            <div class="center">
                <input type="button" value="查 询" id="search" class="btn mr20">
                <input type="button" value="重 置" id="cancel" class="btn mr20" onclick="$('#taskForm')[0].reset();">
                <input type="button" value="更多查询条件" id="moresearch" class="btn mr20">
            </div>
        </div>
    </form>
    <div class="mt10">

        <div class="iframe-wrap">
            <%--    <p><h2>企业名称:${map.entName}&nbsp;&nbsp;&nbsp;注册号/ 统一信用社会代码:${map.uniCode }</h2></p> --%>
            <table id="permit-table" class="table-row display nowrap" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>操作</th>
                    <th>统一代码/注册号</th>
                    <th>企业名称</th>
                    <th>法定代表人/负责人</th>
                    <th>负责人电话</th>
                    <th>联络员姓名</th>
                    <th>联络员手机</th>
                    <th>最近备案日期</th>
                    <th>最近备案方式</th>
                    <th>备案表接收人</th>
                    <th>备案表接收部门</th>
                    <th>企业成立日期</th>
                    <th>住所</th>
                    <th>登记机关</th>
                    <th>管辖单位</th>
                    <th>片区</th>
                </tr>
                </thead>
            </table>
        </div>
  </div>
  </div>
        <script src="/js/lib/require.js"></script>
        <script src="/js/config.js"></script>
        <script src="/js/reg/server/backup/liainfosearch_list_main.js"></script>
</body>
</html>
