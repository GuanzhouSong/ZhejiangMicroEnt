<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>信息推送情况统计列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5">部 门：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" name="checkDep" id="checkDep" value="" class="fl ipt-txt"
                                   placeholder="选择">
                            <input type="text" id="checkDepName" readonly="readonly" value="" class="fl ipt-txt"
                                   placeholder="选择">
                            <span class="add-icon" id="selectDept">
                                <i></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">推送日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"
                                   readonly="readonly"  id="startCheckPushDate"
                                   name="startCheckPushDate" value="${startCheckPushDate}" onclick="laydate()"/>
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"
                                   readonly="readonly"  id="endCheckPushDate" name="endCheckPushDate"
                                   value="${endCheckPushDate}" onclick="laydate()"/>
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5">统计区域：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="area" id="area">
                                <option value="">全部</option>
                                <option value="3300">省级</option>
                                <option value="3301">杭州</option>
                                <option value="3302">宁波</option>
                                <option value="3303">温州</option>
                                <option value="3304">嘉兴</option>
                                <option value="3305">湖州</option>
                                <option value="3306">绍兴</option>
                                <option value="3307">金华</option>
                                <option value="3308">衢州</option>
                                <option value="3309">舟山</option>
                                <option value="3310">台州</option>
                                <option value="3325">丽水</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <%-- <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5">认领日期：</label>
                    <div class="col-6">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"
                                   readonly="readonly"  id="startCheckClaimDate"
                                   name="startCheckClaimDate" value="${startCheckPushDate}"/>
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt"
                                   readonly="readonly"  id="endCheckClaimDate" name="endCheckClaimDate"
                                   value="${endCheckPushDate}"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3"></label>
                    <div class="col-9">
                        
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5"></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                             
                        </div>
                    </div>
                </div>
            </div> --%>
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
                                                注意：数据的统计范围从推送日期2016-12-26开始。
			    </p>
			    <p class="light">
			            提示：1.推送户数是指:针对某一审批部门自动推送、手动推送、退回的市场主体多少家。2.推送条数是指:针对某一审批部门名下自动推送、手动推送、退回的总条数（推送条数=审批部门处理条数+未认领条数）。3. 审批认领户数是指：审批部门认领的市场主体多少家。4.审批认领条数是指：审批部门已经认领的总条数。
			    5.未认领条数是指:推送到审批部门名下待认领的总条数。6.审批部门处理条数指:审批部门操作处理的总条数（审批部门处理条数=认领条数+回退条数）。7.退回条数是指:审批部门执行退回操作的总条数。
			    8.完成率=(审批部门处理条数/推送条数)*100。
			    <!-- 8.认领率是指：已经认领的条数在推送审批总条数中所占的百分比(认领率=已经认领总条数/推送的审批部门总条数(不包含推送失败、回退、终止))。9.接收率是指:已经接收的条数在推送同级属地总条数中所占的百分比(接收率=已经接收总条数/推送的同级属地部门总条数(不包含推送失败、回退、终止)) -->
			    </p>
			    </div>
			    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th>序号</th>
				            <th>地区</th>
				            <th>部门名称</th>
				            <th>推送户数</th>
				            <th>推送条数</th>
				            <th>审批认领户数</th>
				            <th>审批认领条数</th>
				            <th>未认领条数</th>
				            <th>审批部门处理条数</th>
				            <th>退回条数</th>
				            <th>完成率(%)</th>
				            <!-- 
				            <th style="display: none;">接收率(%)</th>
				            <th style="display: none;">抄告总条数</th>
				            <th style="display: none;">审批总条数</th>
				             -->
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
				            <!-- <th style="display: none;"></th>
				            <th style="display: none;"></th>
				            <th style="display: none;"></th>
				            <th style="display: none;"></th> -->
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
       _deptCode:'${deptCode}'
    }
</script>
<script src="/js/syn/system/pubdtinfo/pubdtinfocount_list_main.js"></script>
 </body>
</html>