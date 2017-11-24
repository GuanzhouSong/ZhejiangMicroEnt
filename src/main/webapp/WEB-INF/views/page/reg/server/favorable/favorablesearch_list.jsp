<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>企业良好信息列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box pd14-mr">
         <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一代码/注册号：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniCode_regNO" value="" placeholder="可输入尾号后四位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value="" placeholder="请选择登记机关" readonly="readonly"/>
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">认定发布年度：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                             <select name="regYear">
                                <option value="">全部</option> 
                                <c:forEach var="nowYear" items="${yearList}" varStatus="status" >
			        		     <option value="${nowYear}">${nowYear}</option>
		        		        </c:forEach>  
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">认定发布文号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                         <input type="text" class="ipt-txt" name="regDocNo" value="" placeholder="请输入认定发布文号"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="请选择管辖单位" readonly="readonly"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">良好信息类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select  class="clx_one" multiple="multiple" id="favType" name="favType">
                                 
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">评定级别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                              <select  class="clx_one" multiple="multiple" id="licZone" name="licZone">
                                 
                              </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">认定发布部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regDeptCn" value="" placeholder="认定发布部门"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix" >
                <div class="col-4">
                    <label class="item-name col-5">不良信息类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                             <select name="infaustlKind" id="infaustlKind">
                                <option value="">全部</option>
                                <option value="1">有</option>
                                <option value="0">无</option>
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">不良信息类型：</label>
                    <div class="col-7">
                         <div class="ipt-box col-12" id="infaustlTypeDiv">
                              <select  class="clx_one" multiple="multiple" id="infaustlType" name="infaustlType">
                                 
                              </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">认定发布时间：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="startRegDate"
                                   id="startRegDate" value=""/>

	                        </div>
	                        <span class="item-line col-05">-</span>
	                        <div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="endRegDate"
	                                   id="endRegDate" value=""/>
	
	                        </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item-more"  id="hideorshow" style="display:none" >
            <div class="form-item clearfix">
                <div class="col-4">
                   	<label class="item-name col-5">不良信息发生日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="startInfaustlDate"
                                   id="startInfaustlDate" value=""/>

	                        </div>
	                        <span class="item-line col-05">-</span>
	                        <div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="endInfaustlDate"
	                                   id="endInfaustlDate" value=""/>
	
	                        </div>
                        </div>
                    </div>
                </div>
                <div class="col-4"> 
                    <label class="item-name col-5">良好有效期限：</label>
                    <div class="col-7">
                         <div class="ipt-box col-12">
                            <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="regFrom"
                                   id="regFrom" value=""/>

	                        </div>
	                        <span class="item-line col-05">-</span>
	                        <div class="ipt-box col-575">
	                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" name="regTo"
	                                   id="regTo" value=""/>
	                        </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select  class="clx_one" multiple="multiple" id="regState" name="regState">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix" >
                <div class="col-4">
                    <label class="item-name col-5">良好信息状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="efftStatus">
                                <option value="">全部</option>
                                <option value="1">有效</option>
                                <option value="0">无效</option>
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"></label>
                    <div class="col-7">
                         <div class="ipt-box col-12">
                               
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"></label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                             
                        </div>
                    </div>
                </div>
            </div>
            </div>
           <!--  <p class="center">
		          <span class="js-fold fold-icon">
		              展开更多查询条件
		          </span>
            </p> -->
            <div class="center mt10">
            <input type="button" id="search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
       		<input type="button" id="more" value="更多查询条件" class="btn mr20 js-fold">
        	</div>
            <!-- <div class="center mt10">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div> -->
        </div>
    </form>

    <div class="light-info mt5">
        <span class="light">提示：未选择查询条件下查询结果默认显示在册企业信息。
	    <i class="bulb yellow-b"></i>表示被列入经营异常
	    &nbsp;&nbsp;
	    ， <i class="bulb orange-b"></i> 表示被列入严重违法
	    ， <i class="bulb red-b"></i>  表示同时被列入经营异常和严重违法。 
	    </span> 
    </div>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="pubopanomalylist_table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
                            <th>警示</th>
                            <th>统一代码/注册号</th> 
                            <th>企业名称</th>
                            <th>良好信息名称</th>
                            <th>良好信息类别</th>
                            <th>评定级别</th>
                            <th>认定发布年度</th>
                            <th>认定类别</th>
                            <th>认定有效期始</th>
                            <th>认定有效期止</th>
                            <th>认定发布时间</th>
                            <th>认定发布文号</th>
                            <th>认定发布部门</th>
                            <th>登记机关</th>
                            <th>管辖单位</th>
                            <th>企业登记状态</th> 
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script>
    window._CONFIG = { 
       _sysUrl:'${sysUrl}'
    }
	</script>
    <script src="<c:url value="/js/reg/server/favorable/favorablesearch_list_main.js"/>"></script>
</body>
</html>