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
    <title>司法协助信息录入</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style type="text/css">
.commit{    
    text-decoration: none;
    color: #003399;
    cursor: pointer;
    font-size: 13px;
}
</style>
<body class="pd10">
<div class="tabbale" data-component="tab">
      <form id="taskForm" class="form-box">
       <input type="hidden" id="userType" value="${userType }">
       <input type="hidden" id="deptCode" value="${deptCode}">
      <div class="form-list">
         <div class="form-item clearfix">
                 <div class="col-4">
                     <label class="item-name col-5">注册号/统一代码：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="regNO" value="" placeholder="请输入注册号/统一代码">
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">股权所在企业名称：</label>
                     <div class="col-7">
                         <div class="ipt-box col-12">
                             <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入股权所在企业名称">
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">登记机关：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value="" />
	                            <input type="text" class="ipt-txt" id="regOrgName" value="" readonly="readonly" placeholder="请选择登记机关"/>
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
                         </div>
                     </div>
                 </div>
          </div>
          
           <div class="form-item clearfix">
                 <div class="col-4">
                     <label class="item-name col-5">录入员：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="setName" value="" placeholder="请输入录入员">
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">录入日期：</label>
                     <div class="col-7">
                         <div class="ipt-box col-575">
                             <input type="text" class="ipt-txt pointer laydate-icon"  onclick="laydate()" readonly="readonly" name="setDateStart" value="" />
                          </div>
                             <span class="item-line col-05">-</span>
                         <div class="ipt-box col-575">
                           <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()" readonly="readonly" name="setDateEnd" value="" />
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">管辖单位：</label>
                     	<div class="col-7">
                         	<div class="ipt-box col-11">
                             	<input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value="" />
	                            <input type="text" class="ipt-txt" id="localAdmName" value="" readonly="readonly" placeholder="请选择管辖单位"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                         	</div>
                     	</div>
                 </div>
          </div>
          
          <div class="form-item clearfix">
                 <div class="col-4">
                     <label class="item-name col-5">审核员：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="auditName" value="" placeholder="请输入审核员">
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">审核日期：</label>
                     <div class="col-7">
                         <div class="ipt-box col-575">
                             <input type="text" class="ipt-txt pointer laydate-icon"  onclick="laydate()" readonly="readonly" name="auditDateStart" value="" />
                          </div>
                             <span class="item-line col-05">-</span>
                         <div class="ipt-box col-575">
                           <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()" readonly="readonly" name="auditDateEnd" value="" />
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">责任区：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNO" value="" />
	                            <input type="text" class="ipt-txt" id="sliceNOName" value="" readonly="readonly" placeholder="请选择责任区"/>
	                            <span class="add-icon" id="chosesliceNo">
	                            <i></i>
	                         </span>
                         </div>
                     </div>
                 </div>
          </div>
          
          <div class="form-item clearfix">
                 <div class="col-4">
                     <label class="item-name col-5">公示信息类别：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <select id="justiceType" name="justiceType">
			                      <option value="">全部</option>
			                      <option value="1">股权冻结信息</option>
			                      <option value="2">股东强制变更信息</option>
			                 </select>
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">被执行人：</label>
                     <div class="col-7">
                         <div class="ipt-box">
                             <input type="text" class="ipt-txt" name="inv" value="" placeholder="请输入被执行人">
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">执行法院：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="executionCourt" value="" placeholder="请输入执行法院">
                         </div>
                     </div>
                 </div>
          </div>
          
          <div class="form-item clearfix">
                 <div class="col-4">
                     <label class="item-name col-5">执行事项：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <select id="executeItem" name="executeItem">
	                  		  <option value="">全部</option>
	                          <option value="1">公示冻结股权、其他投资权益</option>
	                          <option value="2">续行冻结股权、其他投资权益</option>
	                          <option value="3">解除冻结股权、其他投资权益</option>
	                          <option value="4">强制转让被执行人股权，办理有限责任公司股东变更登记</option>
                  			 </select>
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">状态：</label>
                     <div class="col-7">
                         <div class="ipt-box">
                             <select id="auditState" name="auditState">
	                  		  <option value="">全部</option>
	                          <option value="0">待审核</option>
	                          <option value="1">审核通过</option>
	                          <option value="2">审核不通过</option>
	                  		 </select>
                         </div>
                     </div>
                 </div>
          </div>
          <div class="form-group clearfix ">
   				<div class="center mt10">
               		<input type="button"  id="search" value="查询" class="btn mr20">
               		<input type="button"  id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
              	</div>
         </div>
    </form>
</div>
 
 <div class="mod mod-border investment-info js-content-show js-upload mt10" id="loadFile" style="display:none;">
    <div class="forguarantee-lead">
        <h6 class="download" style="text-align: left;">
            <a  href="<c:url value="${urlType }/other/pubjusticeinfo/file_down"/>" ><b class="download-ico"></b>下载本站EXCEL模版</a>
        </h6>
        <div class="state pos-rel">
            <span>说明：</span>
            <p>1、导入数据时请先下载EXCEL导入模版；</p>
            <p>2、下载导入模板后请按照导入模板格式和内容要求完成导入信息的填录；</p>
            <p>3、使用非本系统提供的导入模板或擅自修改导入模板的格式和内容会导致操作不成功。</p>
        </div>
        <div class="lead-file">
            <label>导入EXCEL文件</label>
            <form id="file_import" enctype="multipart/form-data" method="post">
                <div class="ipt-box">
                    <input type="file" id="js-file" name="file"  class="ipt-txt ipt-txt-lg">
                    
                </div>
                <input type="button" class="btn js-import" value="导入">
            </form>


        </div>
    </div>
    <div style="text-align: center;"><input type="button" class="btn btnCancel"  value="关闭"></div>
</div>
 


<div class="iframe-wrap mt5">
         <button type="button" id="addBtn" class="btn btn-primary">新增</button>
          <button type="button" class="btn btn-primary " id="importExcel">Excel导入</button>
         <div class="light-info mb5 mt5">
         <p class="light">提示：点击“查询”显示已录入信息，需要录入新信息请点击“新增”。审核前可进行修改与删除信息；审核不通过时可修改信息；审核通过后的信息将通过公示系统予以公示。</p>
         </div>
	 <table id="justiceInfo_table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
       <thead>
       <tr>
            <th>序号</th> 
            <th>操作</th> 
            <th>股权所在企业统一代码</th>
            <th>股权所在企业注册号</th>
            <th>股权所在企业名称</th>
            <th>公示信息类别</th>
            <th>执行事项</th>
            <th>被执行人</th>
            <th>股权数额</th>
            <th>执行法院</th>
            <th>状态</th>
            <th>录入员</th>
            <th>录入日期</th> 
            <th>审核员</th>
            <th>审核日期</th>
            <th>登记机关</th>
            <th>管辖单位</th>
            <th>责任区</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/other/pubjusticeinfo/pubjusticeinfo_list_main.js"/>"></script> 
</body>
</html>
