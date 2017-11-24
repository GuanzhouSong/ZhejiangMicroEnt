<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>食品仓储信息统计</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" style="width: 40%">
                    <label class="item-name col-5">统计日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"
                                   readonly="readonly"  id="startCheckPushDate"
                                   name="startCheckPushDate" value="${startSetdate}"/>
                        </div>
                        <span class="item-txt col-1"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"
                                   readonly="readonly"  id="endCheckPushDate" name="endCheckPushDate"
                                   value="${endSetdate}"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">统计层级：</label>
                    <div class="col-9">
                      <div class="ipt-box col-5">
                         	<select name="statLevel" id="statLevel">
                         	 <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2||sysUser.userVest!=1}">
                         		 <option value="regOrg">按登记机关</option>
                         	 </c:if>
                                <option value="localAdm">按管辖单位</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5"></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                             
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item mt10">
                <div class="center">
                    <input type="button" id="ssearch" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                <div class="light-info"> 
			    <p class="light">
			            提示：应申报企业为标记有食品仓储的企业；申报率=已申报企业/应申报企业；“涉及食品仓储企业”为已申报企业中有勾选食品生产、经营、仓储服务、食用农产品的企业。</p>
			    </div>
			    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                           	<th>序号</th>
				            <th>部门</th>
				            <th>应申报企业(户)</span></th>
				            <th>已申报企业(户)</span></th>
				            <th>申报率(%)</th>
				            <th>涉及食品仓储企业(户)</th>
				            <th>食品生产企业(户)</th>
				            <th>食品经营企业(户)</th>
				            <th>食品仓储服务企业(户)</th>
				            <th>食用农产品企业(户)</th>
				            <th>食品生产许可证(个)</th>
				            <th>食品流通许可证(个)</th>
				            <th>仓库总数(个)</th>
                        </tr>
                        </thead>
                        <tfoot>
				        <tr>
				            <th>合计</th>
				            <th>-</th>
				            <th>-</th>
				            <th></th>
				            <th></th>
				            <th></th>
				            <th></th>
				            <th></th>
				            <th></th>
				            <th></th>
				            <th></th>
				            <th></th>
				            <th></th>
				        </tr> 
				        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script>
    window._CONFIG = { 
       _sysUrl:'${sysUrl}',
       _deptCode:'${deptCode}', 
       _startSetdate:'${startSetdate}',
       _endSetdate:'${endSetdate}'
    }
</script>
<script src="/js/reg/server/yr/foodstoragebase/foodstoragecount_list_main.js"></script>
 </body>
</html>