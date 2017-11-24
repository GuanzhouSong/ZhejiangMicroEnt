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
    <title>专项整治结果录入列表</title>
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
                 <div class="col-4">
                    <div class="item-name col-4">企业名称：</div>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" name="entName" class="ipt-txt" value="" />
                        </div>
                    </div>
                 </div>
                 <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cidRegNO" value="">
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
	                    <label class="item-name col-5">任务类型：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                            <select name="taskType">
	                                <option value="">全部</option>
	                                <option value="1">本部门</option>
	                                <option value="2">跨部门</option>
	                            </select>
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
	                    <label class="item-name col-4">检查结果状态：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <select name="checkState">
	                                <option value="">全部</option>
	                                <option value="0">未录入</option>
	                                <option value="1">已录入</option>
	                            </select>
	                        </div>
	                    </div>
	                </div>
                 <div class="col-4">
                     <div class="item-name col-5">后续处置状态：</div>
                     <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="disposeState">
                                <option value="">全部</option>
                                <option value="1">未完结</option>
                                <option value="2">已完结</option>
                            </select>
                        </div>
                      </div>
                   </div>
                   <div class="col-4">
                    <label class="item-name col-5">检查部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="checkDeptName" value=""/>
                        </div>
                    </div>
                </div>
               </div>
         <div id="hideorshow" style="display: none">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-4">检查结果：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="checkResultM" id="checkResultM" multiple="multiple">
                                <option value='1'>未发现违法行为</option>
                                <option value='2'>违反工商行政管理相关规定</option>
                                <option value='3'>违反食品药品管理相关规定</option>
                                <option value='4'>违反质量技术监督相关规定</option>
                                <option value='5'>违反其他部门相关规定</option>
                                <option value='6'>查无下落</option>
                                <option value='7'>已关闭停业或正在组织清算</option>
                                <option value='8'>不予配合情节严重</option>
                                <option value='9'>注销</option>
                                <option value='10'>被吊销</option>
                                <option value='11'>被撤销</option>
                                <option value='12'>迁出</option>
                                <option value='A'>发现问题待后续处理</option>
                                <option value='B'>未按规定公示应当公示的信息</option>
                                <option value='C'>公示信息隐瞒真实情况弄虚作假</option>
                                <option value='D'>违反其他工商行政管理规定行为</option>
                                <option value='E'>发现问题经责令已改正</option>
                                <option value='F'>未发现开展本次抽查涉及的经营活动</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">检查日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="checkDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="checkDateEnd" value=""/>
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
                    <label class="item-name col-4">检查人员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="checkDeptPerson" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">录入日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="enterStartDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="enterEndDate" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">录入员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="enterUserName" value=""/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
          		<div class="col-4">
                    <label class="item-name col-4">修改人员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="modifyName" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">修改日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="modifyDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate()" readonly="readonly"
                                   name="modifyDateEnd" value=""/>
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
    <span class="light">提示：此处仅查询已录入检查结果的专项整治检查信息。 专项整治检查结果信息不对外公示。</span>
 </div>
<div class="tip-info right">
	查询结果：
	已录入<label id="ylrgs" class="light-blue">0</label>条，
	其中未完结<label id="wwjgs" class="light-blue">0</label>条，
	已完结<label id="ywjgs" class="light-blue">0</label>条。
</div>
<div> 
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
      <thead>
       <tr>
           <th style="padding:0 20px;">序号</th>
           <th>操作</th>
           <th>检查结果状态</th>
           <th>后续处置状态</th>
           <th>统一代码/注册号</th>
           <th>企业名称</th>
           <th>任务类型</th>
           <th>任务编号</th>
           <th>任务名称</th>
           <th>检查日期</th>
           <th>检查结果</th>
           <th>检查人员</th>
           <th>检查部门</th>
           <th>登记机关</th>
           <th>管辖单位</th>
           <th>片区</th>
           <th>录入员</th>
           <th>录入日期</th>
           <th>修改人</th>
           <th>修改日期</th>
       </tr>
      </thead>
   </table>
</div>
<script>
window._CONFIG = {
   chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/specialrec/specialrec_alter_list.js"></script>
</body>
</html>