<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>企业失信联合惩戒查询</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css"> 
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    
    <form id="searchForm" class="form-box mb5">
    	 <input type="hidden" name="type" value="ent" >
    	 <input type="hidden" id="sysDate" value="${sysDate }" >
    	 
         <div class="form-list">
         
             <div class="form-item clearfix">
                 <div id="uniCode" class="col-4">
                     <label class="item-name col-6">统一信用代码/注册号：</label>
                     <div class="col-6">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="uniCode" value="" placeholder="请输入统一信用代码/注册号" />
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">法定的代表人/负责人：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="leRep" value="" placeholder="" />
                         </div>
                     </div>
                 </div> 
                 <div class="col-4">
                     <label class="item-name col-5">惩戒提请部门：</label>
                     <div class="col-6">
                         <div class="ipt-box col-12">
                             <input type="text" class="ipt-txt" id="punReqDept" name="punReqDept" value=""  readonly />
        					 <input type="hidden" name="punReqDeptCode" id="punReqDeptCode" value=""/>
        					 <a id="selectPunReqDept" class="link js-show">
				                  <span class="add-icon"><i></i></span>
			                 </a>
                         </div>
                     </div>
                 </div>
             </div>
             
             <div class="form-item clearfix">
                 <div class="col-4" id="entName">
                     <label class="item-name col-6">被惩戒企业名称：</label>
                     <div class="col-6">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称" />
                         </div>
                     </div>
                 </div> 
                 <div class="col-4">
                     <label class="item-name col-5">证件号码：</label>
                     <div class="col-7">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="cardNo" value="" placeholder="" />
                         </div>
                     </div>
                 </div> 
                 <div class="col-4">
                     <label class="item-name col-5">惩戒执行部门：</label>
                     <div class="col-6">
                         <div class="ipt-box col-12">
                             <input type="text" class="ipt-txt" id="punExeDept" name="punExeDept" value=""  readonly />
            				 <input type="hidden" name="punExeDeptCode" id="punExeDeptCode" value=""/>
            				 <a id="selectPunExeDept" class="link js-show">
				                  <span class="add-icon"><i></i></span>
			                 </a>
                           </div>
                       </div>
                   </div>                 
             </div>
             <div class="form-item clearfix">             
                 <div class="col-4">
                     <label class="item-name col-6">惩戒领域：</label>
                     <div class="col-6">
                         <div class="ipt-box col-11">
                             <select name="punField">
                 				<option value="" >不限</option>
                  				<option value="安全生产领域" >安全生产领域</option>
								<option value="旅行社经营领域" >旅行社经营领域</option>
								<option value="国有企业监督管理领域" >国有企业监督管理领域</option>
								<option value="互联网上网服务及娱乐场所经营领域" >互联网上网服务及娱乐场所经营领域</option>
								<option value="食品药品经营领域" >食品药品经营领域</option>
								<option value="饲料及兽药经营领域" >饲料及兽药经营领域</option>
								<option value="出版经营领域" >出版经营领域</option>
								<option value="电影经营领域" >电影经营领域</option>
								<option value="营业性演出经营领域" >营业性演出经营领域</option>
								<option value="建筑施工领域（含施工、勘察、设计和工程监理）" >建筑施工领域（含施工、勘察、设计和工程监理）</option>
								<option value="电子认证领域" >电子认证领域</option>
								<option value="证券期货市场监督管理领域" >证券期货市场监督管理领域</option>
								<option value="税收管理" >税收管理</option>
								<option value="普遍性限制措施" >普遍性限制措施</option>
              				</select>
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                     <label class="item-name col-5">惩戒事由：</label>
                   	 <div class="col-7">
                       	<div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" id="punCause" name="punCause" value="" readonly/>
                            <a id="selectRule" class="link js-show">
                                <span class="add-icon"><i></i></span>
                            </a>
                        </div>
                   	 </div>
               	 </div>
                  <div class="col-4">
                       <label class="item-name col-5">惩戒措施：</label>
                       <div class="col-6">
                           <div class="ipt-box col-12">
	                            <input type="text" class="ipt-txt" id="punMea" name="punMea" value="" readonly/>
	                            <a id="selectMea" class="link js-show">
	                                <span class="add-icon"><i></i></span>
	                            </a>
	                        </div>
                       </div>
                   </div>                 
             </div>
             <div class="more-show " style="display:none;">
             <div class="form-item clearfix mb10">
                 <div class="col-4">
                     <label class="item-name col-6">惩戒有效状态：</label>
                     <div class="col-6">
                         <div class="ipt-box col-11">
                             <select name="state">
                				<option value="" >全部</option>
                  				<option value="1" >有效</option>
                  				<option value="0" >无效</option>
<!--                   				<option value="2">终身有效</option> -->
              				</select>
                         </div>
                     </div>
                 </div>
                 <div class="col-4">
                    <label class="item-name col-5">文书日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="startLegDate" value="">
                        </div>
                        <span class="item-txt col-1"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="endLegDate" value="">
                        </div>
                    </div>
                </div> 
                 <div class="col-4">
                     <label class="item-name col-5">联系人：</label>
                     <div class="col-6">
                         <div class="ipt-box col-12">
                             <input type="text" class="ipt-txt" name="contact" value="" placeholder="" />
                         </div>
                     </div>
                 </div>                  
             </div>
             <div class="form-item clearfix mb10">
                 <div class="col-4">
                     <label class="item-name col-6">法律文书编号：</label>
                     <div class="col-6">
                         <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="legNo" value="" placeholder="" />
                         </div>
                     </div>
                 </div> 
                 <div class="col-4">
                    <label class="item-name col-5">公示日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="startAuditTime" value="">
                        </div>
                        <span class="item-txt col-1"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()" name="endAuditTime" value="">
                        </div>
                    </div>
                </div>                  
             </div>
             </div>  
               <div class="form-item clearfix">
     				<div class="center mb5">
                 		<input type="button"  id="search" value="查询" class="btn mr20">
                 		<input type="button"  id="rest" value="重置" class="btn mr20">
                 		<input type="button" value="更多查询" class="btn mr20 js-more-query">
                	</div>
               </div>
           </div>
     </form>
	<div class="light-info mb5">
	    <p class="light">提示：审核退回信息可至联合惩戒提请功能中进行修改，审核通过信息将自动通过公示系统予以公告公示。</p>
	</div> 
     <div class="tab-content mb20">
    	
           <div class="">
			<div class="table-out">
			
			    <table id="ent_table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
			        <thead>
			        <tr>
			            <th >序号</th>
			            <th >操作</th>			            
			            <th >状态</th>
			            <th >公示日期</th>
			            <th >企业名称</th>
			            <th >统一信用代码/注册号</th>
			            <th >法定代表人/负责人</th>
			            <th >证件号码</th>
			            <th >法律文书编号</th>
			            <th >文书日期</th>
			            <th >惩戒领域</th>
			            <th >惩戒事由</th>
			            <th >惩戒措施</th>			            
			            <th >惩戒期限</th>
			            <th >惩戒执行部门</th>			            
			            <th >惩戒提请部门</th>
			            <th >联系人</th>
			            <th >联系电话</th>
			        </tr>
			        </thead>
			    </table>
			</div>
       	</div>
    	
	</div>
<script>
	var userType = '${sessionScope.session_sys_user.userType}';
	var url='/common/system/sysdepart/alldeptradiotreeselect';
	var urlHead = '/reg/server';
	if(userType==2){
		url='/syn/system/sysdepart/alldeptradiotreeselect';
		urlHead='/syn';
	}
    window._CONFIG = {
   		select_dept_url: url,
   		urlHead: urlHead
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/nocreditPunish/info/list_ent.js"></script>

</body>
</html>