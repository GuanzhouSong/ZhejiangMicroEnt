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
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>检查小组维护</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix moresearch_oth">
                <div class="col-4">
                    <label class="item-name col-5">检查人员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="agentNames" value="" placeholder="可输入关键字查询">
                        </div>
                    </div>
                </div>
				<div class="col-4">
                    <label class="item-name col-5">设置日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="setTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="setTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">设置部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-9">
                        	<input type="text" id="sysDept" class="ipt-txt" value="${sysUser.dept}" placeholder="" readonly="readonly">
                        </div>
                    </div>
                </div>
            </div>
            
             <div class="form-item clearfix moresearch_oth">
				<!-- <div class="col-4">
                    <label class="item-name col-5">人员状态：</label>
                    <div class="col-7">
                    <div class="ipt-box col-11">
                        <select name="agentIsVlid">
                            <option value=""></option>
                            <option value="1">有效</option>
                            <option value="2">无效</option>	
                         </select>
                         </div>
                    </div>
                </div> -->
                <div class="col-4">
                    <label class="item-name col-5">设置人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="setUserName" value="" placeholder="可输入关键字查询">
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="form-group clearfix">
	            <div class="center mt10">
	                <input type="button" id="search" value="查询" class="btn mr20">
	                <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
	            </div>
        	</div>
        </div>
    </form>
</div>
 
<div class="iframe-wrap">
    <p class="tip-info left mb5 mt10">
        <span class="light"><i class="light-box-y mr5"></i>表示人员已失效，带*人员为无执法证的辅助人员。</span>
    </p>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>选择</th>
            <th>小组成员数</th>
            <th>检查小组成员</th>
            <th>组长人员</th>
            <th>专家人员</th>
            <th>设置人</th>
            <th>设置日期</th>
            <th>设置部门</th>
        </tr>
        </thead>
    </table>
    
     <div class="form-group clearfix">
	            <div class="center mt10">
	                <input type="button" id="commit" value="提交" class="btn mr20">
	                <input type="button" id="close" value="关闭" class="btn mr20">
	            </div>
        	</div>
</div>
<script>
    window._CONFIG = {
       chooseUrl:'${sysUser.userType == 2 ? "/syn" : "/reg"}', 
    }
    </script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/checkgroup/checkgroup_choise.js"></script>
</body>
</html>
