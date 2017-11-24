<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>惩戒管理</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">

    <form id="searchForm" class="form-box">
    
        <div class="form-list pd14-mr">
        
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-6"><span class="long-label">统一信用代码/注册号：</span></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniCode" value="">
                        </div>
                    </div>
                </div>
                
                <div class="col-4" id="cardNo">
                    <label class="item-name col-5">涉案人身份证号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cardNo" value="" placeholder=""/>
                        </div>
                    </div>
                </div>
                
                <div class="col-4" id="entName">
                    <label class="item-name col-5">被惩戒对象名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="form-item clearfix">
            	<div class="col-4" id="litiName">
                    <label class="item-name col-6">涉案人姓名：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="litiName" value="" placeholder=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">惩戒提请部门：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" id="punReqDept" name="punReqDept" value="" readonly/>
                            <input type="hidden" name="punReqDeptCode" id="punReqDeptCode" value=""/>
                            <a id="selectPunReqDept" class="link js-show">
                                <span class="add-icon"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">惩戒领域：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="punField">
                                <option value="">不限</option>
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
            </div>
            
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-6">惩戒事由：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" id="punCause" name="punCause" value="" readonly/>
                            <a id="selectRule" class="link js-show">
                                <span class="add-icon"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">惩戒有效状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="expired">
                                <option value="">不限</option>
                                <option value="1">有效</option>
                                <option value="0">无效</option>
                                <option value="2">终身有效</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">惩戒执行部门：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" id="punExeDept" name="punExeDept" value="" readonly/>
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
                    <label class="item-name col-6">惩戒执行措施：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" id="punMea" name="punMea" value="" readonly/>
                            <a id="selectMea" class="link js-show">
                                <span class="add-icon"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">反馈状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="backState">
                                <option value="">不限</option>
                                <option value="0">待反馈</option>
                                <option value="1">已反馈</option>
                                <option value="2">无须反馈</option>
                            </select>
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                     <label class="item-name col-5">惩戒单类型：</label>
                     <div class="col-6">
                         <div class="ipt-box col-12">
                             <select name="type" id="type">
                  		      <option value="" >不限</option>
                  		      <option value="ent" >企业</option>
                  		      <option value="man" >自然人</option>
              			   </select>
                         </div>
                     </div>
                 </div>
            </div>
            
            <div class="form-item clearfix">
                 <div class="col-4">
                     <label class="item-name col-6">批次编号：</label>
                     <div class="col-6">
                         <div class="ipt-box col-12">
                             <input type="text" class="ipt-txt" name="batchNo" value="" />
                         </div>
                     </div>
                 </div>
             </div>
               
            <div class="form-item clearfix">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="rest" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
    <div class="clearfix mb5 mt5">
        <p class="fl"><input type="button" id="add" class="btn btn-sm mr5" value="添加惩戒记录" style="display:none"></p>
    </div>

    <div class="tab-content mb20">

        <div class="">
            <div class="table-out">
                <table id="table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
                    <thead>
                    <tr>
                        <th >序号</th>
                        <th >操作</th>
                        <th >反馈状态</th>
                        <th >批次编号</th>
                        <th >录入时间</th>
                        <th >惩戒领域</th>
                        <th >惩戒依据</th>
                        <th >惩戒事由</th>
                        <th >惩戒规则</th>
                        <th >惩戒提请部门</th>
                        <th >执行有效期</th>
                        <th >惩戒执行部门</th>
                        <th >惩戒执行措施</th>
                        <th >联系人</th>
                        <th >联系电话</th>
                        <th >联系传真</th>
                        <th >联系邮箱</th>
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
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/component/tab.js"></script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/nocreditPunish/info/list_main.js"></script>

</body>
</html>