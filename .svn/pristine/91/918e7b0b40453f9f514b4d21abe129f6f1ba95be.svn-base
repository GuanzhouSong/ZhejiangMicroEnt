<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>个体户纸质补录列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
    <form id="taskForm">
        <div class="form-box">
            <div class="form-list">
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">年度：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">                            
                                <select name="yrYear" id="year"> 
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">统一代码/注册号：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="cidRegNO" placeholder="请输入完整统一代码/注册号">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">经营者：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="leRep">
                            </div>
                       </div>
                    </div>
                </div>
                  <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">补录状态：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <select name="addRecState" id="addRecState">   
                                 <option value="">全部</option>
                                 <option value="2">已补录</option>
                                 <option value="1">录入中</option>
                                 <option value="0">未补录</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">名称字号：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="entName" placeholder="可输入名称关键词查询">
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
                </div>
                  <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">补录人：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="addRecUser">
                            </div>
                        </div>
                    </div> 
		            <div class="col-4">
		                <label class="item-name col-5">年报补录日期：</label>
		                <div class="col-7">
		                    <div class="ipt-box col-575">
		                        <input type="text" class="ipt-txt laydate-icon"  name="addRecDateStart" id="addRecDateStart" value="" readonly="readonly"/>
		                    </div>
		                    <span class="item-line col-05">-</span>
		                    <div class="ipt-box col-575">
		                        <input type="text" class="ipt-txt laydate-icon" name="addRecDateEnd" id="addRecDateEnd" value="" readonly="readonly"/>
		                    </div>
		                </div>
		            </div>
		            <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
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
                        <label class="item-name col-5">年报接收人：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="acceptName">
                            </div>
                        </div>
                    </div>
	                <div class="col-4">
	                <label class="item-name col-5">接收日期：</label>
	                <div class="col-7">
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon"  name="acceptDateStart" id="startCogDate" value="" readonly="readonly"/>
	                    </div>
	                    <span class="item-line col-05">-</span>
	                    <div class="ipt-box col-575">
	                        <input type="text" class="ipt-txt laydate-icon" name="acceptDateEnd" id="endCogDate" value="" readonly="readonly"/>
	                    </div>
	                </div>
	                </div>
	                <div class="col-4">
                    <label class="item-name col-5">片区：</label>
                    <div class="col-7">
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
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">登记状态：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                            <select name="regStateM" id="regStateM" multiple="multiple">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
                            	</c:forEach>
                            </select>                            
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">接收部门：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="acceptDept">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">录入部门：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="addRecDept">
                            </div>
                        </div>
                    </div>
	                
                </div>
                </div>                
                <div class="form-item">
                    <div class="btn-box mt10">
                        <input type="button" id="search" value="查 询" class="btn mr20">
                        <input type="button" id="cancel" value="重 置" class="btn mr20" onclick="$('#taskForm')[0].reset();">
                        <input type="button" id="more" value="更多查询条件" class="btn mr20">
                    </div>
                </div>
            </div>
        </div>
    </form>

    <div class="light-info mt10">
        <span class="light">提示：查询结果默认显示本部门登记与管辖且已纸质年报接收的在册个体户信息。</span>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
                    <th style="padding:0 20px;">序号</th>
                    <th>操作</th>
                    <th >统一信用代码/注册号</th>
                    <th >名称字号</th>
                    <th >经营者</th>
                    <th >年报年度</th>
                    <th >接收日期</th>
                    <th >接收人</th>
                    <th >补录状态</th>
                    <th >补录日期</th>
                    <th >补录人</th>
                    <th >补录部门</th>
                    <th >接收部门</th>
                    <th >登记机关</th>
                    <th>管辖单位</th>
                    <th>片区</th>
                    <th>登记状态</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
<script>
    window._CONFIG = {
       year:'${year}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/pbaddrec/pbaddrec_list.js"></script>
</body>
</html>
