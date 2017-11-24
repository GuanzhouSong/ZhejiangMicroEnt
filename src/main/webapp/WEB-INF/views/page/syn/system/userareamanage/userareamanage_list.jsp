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
    <title>区域管理员列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box pd14-mr"> 
         <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">用户名：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="username" value="" class="ipt-txt"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">姓名：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="realNameLike" value="" class="ipt-txt" />
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">单位：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="jurUnit" value="" class="ipt-txt" />
                        </div>
                    </div>
                </div>
            </div> 
             <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">区域层级：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select  id="levels" name="levels"> 
                           		<option value="">不限</option> 
                                <option value="0">省级</option>
                                <option value="3">市级</option>
                                <option value="2">县级</option> 
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">状态：</label>
                    <div class="col-6">
                    	<div class="ipt-box col-12">
	                        <select  id="userMangeStatus" name="userMangeStatus"> 
	                           		<option value="">全部</option> 
	                                <option value="1">有效</option>
	                                <option value="0">无效</option> 
	                       </select>
                       </div>
                    </div>
                </div>
                 <div class="col-4">
                    <label class="item-name col-5">所属部门：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt"  name="checkDep" id="checkDep" value="" />
                            <input type="text" class="ipt-txt" readonly id="checkDepName" value="" />
	                            <span class="add-icon" id="choseDept">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div> 
            <div class="center mt10">
            <input type="button" id="search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
       		</div>
        </div>
    </form>
    <div class="clearfix mb5 mt5">
        <p class="fl"><input type="button" id="add" class="btn btn-sm mr5" value="添加区域管理员"></p>
    </div>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="pubopanomalylist_table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
	                        <th>操作</th>
				            <th>用户名</th>
				            <th>姓名</th>
				            <th>所属部门</th>
				            <th>单位</th>
				            <th>职务</th>
				            <th>手机</th>
				            <th>座机</th>
				            <th>区域层级</th>
				            <th>状态</th>
				            <th>设置人</th>
				            <th>设置日期</th>
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
    <script src="/js/syn/system/userareamanage/userareamanage_list_main.js"></script>
</body>
</html>