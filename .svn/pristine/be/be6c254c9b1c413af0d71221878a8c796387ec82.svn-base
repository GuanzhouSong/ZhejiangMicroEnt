<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>关注活动服务列表</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">

<form id="searchForm">
    <div class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">关注服务对象：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" id="markName" name="markName" value="" readonly/>
                                <input type="hidden" name="markNo" id="markNo" value=""/>
                                <a id="selectMark" class="link js-show">
                                    <span class="add-icon"><i></i></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4">开展服务日期：</label>
                    <div class="col-8">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" onclick="laydate();" name="dateBegin"
                                   readonly="readonly">
                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" onclick="laydate();" name="dateEnd" readonly="readonly">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">开展部门：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" id="lauDeptName" name="lauDeptName" value="" readonly/>
                            <input type="hidden" name="lauDeptCode" id="lauDeptCode" value=""/>
                            <a id="selectLauDeptCode" class="link js-show">
                                <span class="add-icon"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb10">
                <div class="col-4">
                    <label class="item-name col-5">关注服务形式：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="actFormat">
                                <option value="">请选择..</option>
                                <option value="贷款授信">贷款授信</option>
                                <option value="奖金奖励">奖金奖励</option>
                                <option value="税费优惠">税费优惠</option>
                                <option value="培训讲座">培训讲座</option>
                                <option value="表彰评优">表彰评优</option>
                                <option value="补贴补助">补贴补助</option>
                                <option value="品牌培育">品牌培育</option>
                                <option value="回访走访">回访走访</option>
                                <option value="展销展会">展销展会</option>
                                <option value="登记许可指导">登记许可指导</option>
                                <option value="其它">其它</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-4">关注服务金额：</label>
                    <div class="col-8">
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" name="amountMin" onblur="check(this)"
                                   onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" >

                        </div>
                        <span class="item-txt col-2"><i class="line-icon"></i></span>
                        <div class="ipt-box col-5">
                            <input type="text" class="ipt-txt" name="amountMax" onblur="check(this)"
                                   onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" >
                        </div>
                    </div>
                </div>
                <script>
                    function check(e) {
                        var re = /^\d+(?=\.{0,1}\d+$|$)/
                        if (e.value != "") {
                            if (!re.test(e.value)) {
                                alert("请输入正确的数字");
                                e.value = "";
                                e.focus();
                            }
                        }
                    }
                </script>
            </div>
            <input value="${user.deptCode}" name="deptCode" type="hidden">

            <div class="form-item clearfix">
                <div class="btn-box mt10">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="button" id="rest" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </div>
</form>
<div class="clearfix mb5">
    <p class="fl"><input type="button" id="add" class="btn btn-sm mr5" value="新增"></p>
</div>

<div>
    <table id="con_activity_tb" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>id</th>
            <th>服务主题</th>
            <th>服务对象</th>
            <th>服务形式</th>
            <th>服务金额</th>
            <th>开展服务日期</th>
            <th>开展服务部门</th>
            <th>录入部门</th>
            <th>录入人</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/concern/activity/con_activity_list.js"></script>
</body>
</html>