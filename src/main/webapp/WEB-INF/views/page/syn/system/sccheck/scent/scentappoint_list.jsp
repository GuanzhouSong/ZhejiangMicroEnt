<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽查任务名单指派列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
    <div class="pd10 bg-gray" style="margin-top: 10px;">
       <div class="form-list pdr10">
           <form id="taskForm" class="form-box mb5">
           <input type="hidden" name="checkResult" id="checkResult">
           	  <div class="form-item clearfix">
<!--                  <div class="col-4"> -->
<!--                     <div class="item-name col-4">检查主体：</div> -->
<!--                     <div class="col-7"> -->
<!--                         <div class="ipt-box col-12"> -->
<!--                             <input type="hidden" name="entTypeCatg" id="entTypeCatg"> -->
<!--                             <input type="checkbox" name="entCatg" class="entCatg" checked="checked" value="11,13,31,33,12,14,32,34,21,27,24,22,28">企业 -->
<!--                             <input type="checkbox" name="entCatg" class="entCatg" value="16,17" checked="checked">农专社 -->
<!--                             <input type="checkbox" name="entCatg" class="entCatg" value="50" checked="checked">个体户<br/> -->
<!--                             <input type="checkbox" name="entCatg" class="entCatg" value="23" checked="checked">外企代表 -->
<!--                         </div> -->
<!--                     </div> -->
<!--                  </div> -->
                 <div class="col-4">
                    <div class="item-name col-4">任务年度：</div>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="taskYear"  style="width: 80px">
				               <c:forEach var="year" items="${yearList}" varStatus="status" >
			        		   	<option value="${year}">${year}</option>
		        		       </c:forEach>
				            </select>
                        </div>
                    </div>
                 </div>
                 <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regNO" value="">
                        </div>
                    </div>
                  </div>
                  <div class="col-4">
                    <label class="item-name col-5">任务组织部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="taskLeadDeptName" id="taskLeadDeptName" value="" />
                        </div>
                    </div>
                   </div>
               </div>
               <div class="form-item clearfix">
               		<div class="col-4">
	                    <label class="item-name col-4">任务编号：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <input type="text" class="ipt-txt" name="taskCode" value=""/>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
                    <div class="item-name col-5">企业名称：</div>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" name="entName" class="ipt-txt" value="" />
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
                    <label class="item-name col-4">任务名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                        	<input type="text" name="taskName" class="ipt-txt" value="" />
                        </div>
                    </div>
	             </div>
                 <div class="col-4">
                    <label class="item-name col-5">检查部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" name="unitDeptCodes" id="unitDeptCodes"/>
			              <input type="text" class="ipt-txt" id="unitDeptNames" value="${sysUser.dept }" placeholder="选择抽查部门" readonly/>
			              <span class="add-icon" id="choseregUnitDept">
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
         <div id="hideorshow" style="display: none">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-4">指派人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="adjustUserName" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">指派日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" name="adjustTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" name="adjustTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                    <div class="item-name col-5">住所：</div>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" name="dom" class="ipt-txt" value="" />
                        </div>
                    </div>
                 </div>
            </div>
       </div>
       </form>
    </div>
</div>
    <p class="center mt10 mb10">
        <input type="button" id="js-search" value="查询" class="btn mr20">
        <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
    	<input type="button" id="more" value="更多查询条件" class="btn mr20">
    </p>
 <div class="light-info mb5 mt5">
    <span class="light"><input type="button" id="js-appoint" value="指派抽查机关" class="btn">提示：仅允许对未录入检查结果的抽查任务名单指派新的检查部门。系统默认选择对本部门的检查名单进行指派，如需查询本部门以外的检查名单请注意选择检查部门。</span>
 </div>
<div> 
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
      <thead>
       <tr>
           <th style="padding:0 20px;">序号</th>
           <th><input type="checkbox" id="checkall"></th>
           <th>统一信用代码/注册号</th>
           <th>企业名称</th>
           <th>住所</th>
           <th>检查部门</th>
           <th>登记机关</th>
           <th>管辖单位</th>
           <th>任务编号</th>
           <th>任务名称</th>
           <th>任务组织部门</th>
           <th>指派人</th>
           <th>指派日期</th>
       </tr>
      </thead>
   </table>
</div>
<script>
    window._CONFIG = {
	    chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scent/scentappoint_list.js"></script>
</body>
</html>