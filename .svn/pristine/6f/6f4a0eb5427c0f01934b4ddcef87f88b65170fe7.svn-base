<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽查名单与人员查询</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="form-box">
	<form id="chooseagentform">
	<input type="hidden" id="auditStates" name="auditStates"/>
	<input type="hidden" id="deptStates" name="deptStates"/>
    <div class="form-list">
        <div class="form-item clearfix">
        	<div class="col-4">
                <label class="item-name col-5">任务年度：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                    	<select name="year" id="year" class="rptselect">
                       		<c:forEach var="nowYear" items="${yearList}" varStatus="status" >
		        		    	<option value="${nowYear}">${nowYear}</option>
	        		        </c:forEach>
                       </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">统一信用代码/注册号：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="regNO">
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
                <label class="item-name col-5">抽查任务：</label>
                <div class="col-6">
                	<div class="ipt-box col-12">
                    <select id="taskUid" name="taskUid">
						<option value=""></option>
						 <c:forEach var="pubScPlanTask" items="${taskNameList}">
						 	<option value="${pubScPlanTask.uid }">【${pubScPlanTask.taskCode }】${pubScPlanTask.taskName }</option>
						</c:forEach>
					</select>
					</div>
                </div>
            </div>
            <div class="col-4">
                <div class="item-name col-5">企业名称：</div>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" name="entName" class="ipt-txt" value="" />
                    </div>
                </div>
            </div>
                        <div class="col-4">
	            <label class="item-name col-5">抽查机关：</label>
	            <div class="col-7">
	                <div class="ipt-box col-11">
	                    <input type="hidden" class="ipt-txt" name="deptCodeArr" id="deptCodeArr" value=""/>
	                    <input type="text" readonly="readonly" class="ipt-txt" id="deptCodeName" value="" />
	                     <span class="add-icon" id="chosedeptReg">
	                         <i></i>
	                  	</span>
	                </div>
	            </div>
            </div>
            
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">检查人员：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="agentName">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">状态：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select id="auditState" multiple="multiple">
                        	<option value="R">待抽取人员</option>
                        	<option value="1">待录入结果</option>
                        	<option value="2">待审核结果</option>
                        	<option value="4">结果审核退回</option>
                        	<option value="5">已公示结果</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">抽查部门：</label>
                <div class="col-7">
                    <div class="ipt-box col-11">
                        <input type="hidden" class="ipt-txt" name="unitDeptCodes" id="unitDeptCodes" value=""/>
	                       <input type="text" readonly="readonly" value="${sysUser.dept }" class="ipt-txt" id="unitDeptNames" value="" />
	                        <span class="add-icon" id="choseDeptUnit">
	                            <i></i>
	                        </span>
                    </div>
                </div>
            </div>
        </div>
        <div id="hideorshow" style="display: none">
            <div class="form-item clearfix">
     	        <div class="col-4">
	                <label class="item-name col-5">专家人员：</label>
	                <div class="col-6">
	                    <div class="ipt-box col-12">
	                        <input type="text" class="ipt-txt" name="teamLeader">
	                    </div>
	                </div>
	            </div>
	            <div class="col-4">
                    <label class="item-name col-5">企业类型：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<input type="hidden" class="ipt-txt" name="entType" id="entType" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="entTypeName" value="" />
	                         <span class="add-icon" id="chooseEntType">
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
	                <label class="item-name col-5">法定代表人：</label>
	                <div class="col-6">
	                    <div class="ipt-box col-12">
	                        <input type="text" class="ipt-txt" name="leRep">
	                    </div>
	                </div>
	            </div>
	            <div class="col-4">
					<label class="item-name col-5">行业：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
			                 <input type="text"  id="industryName"  class="ipt-txt clx" value="" readonly/>
			                 <input type="hidden" id="industryCo" name="industryCo" class="clx" value="" />
				                 <a id="selectIndustry" class="link js-show">
			                  <span class="add-icon" id="yccodetree"><i></i></span>
			                 </a>
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
	                <label class="item-name col-5">联络员：</label>
	                <div class="col-6">
	                    <div class="ipt-box col-12">
	                        <input type="text" class="ipt-txt" name="liaName">
	                    </div>
	                </div>
	            </div>
	            <div class="col-4">
					<label class="item-name col-5">成立日期：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
			                 <div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="estDateStart">
							</div>
							<span class="item-txt col-2"><i class="line-icon"></i></span>
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="estDateEnd">
							</div>
	            		</div>
					</div>
				</div>
               	<div class="col-4">
                    <label class="item-name col-5">住所：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="dom">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
     	        <div class="col-4">
	                <label class="item-name col-5">经营范围：</label>
	                <div class="col-6">
	                    <div class="ipt-box col-12">
	                        <input type="text" class="ipt-txt" name="opScope">
	                    </div>
	                </div>
	            </div>
	            <div class="col-4">
					<label class="item-name col-5">企业抽取日期：</label>
					<div class="col-6">
						<div class="ipt-box col-12">
			                 <div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="randomDateStart">
							</div>
							<span class="item-txt col-2"><i class="line-icon"></i></span>
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="randomDateEnd">
							</div>
	            		</div>
					</div>
				</div>
            </div>
       </div>
        <div class="form-item clearfix mt10">
            <div class="btn-box">
                <input type="button" value="查 询" id="search" class="btn mr20">
                <input type="button" value="重 置" class="btn mr20" onclick="$('#chooseagentform')[0].reset();" id="cancel">
                <input type="button" id="more" value="更多查询条件" class="btn mr20">
            </div>
        </div>
   </div>
    </form>
</div>
<div class="mt5">
<!-- 	 <div class="light-info mb5 mt5"> -->
<!--  	</div> -->
    <table border="0" id="agent-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>任务编号</th>
            <th>任务名称</th>
            <th>状态</th>
            <th>统一社会信用代码/注册号</th>
            <th>企业名称</th>
            <th>企业抽取日期</th>
            <th>检查人员</th>
            <th>专家人员</th>
            <th>成立日期</th>
            <th>法定代表人/负责人</th>
            <th>联系电话</th>
            <th>联络员</th>
            <th>联络员电话</th>
            <th>企业类型</th>
            <th>行业</th>
            <th>经营范围</th>
            <th>住所</th>
            <th>检查部门</th>
            <th>检查机关</th>
            <th>登记机关</th>
            <th>管辖单位</th>
            <th>片区</th>
        </tr>
        </thead>
    </table>
</div>
<script>
    window._CONFIG = {
       chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
       chooseOtherUrl:'${sysUser.userType == 2 ? "/syn" : "/reg/server"}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scentagent/scentagent_search.js"></script>
</body>
</html>