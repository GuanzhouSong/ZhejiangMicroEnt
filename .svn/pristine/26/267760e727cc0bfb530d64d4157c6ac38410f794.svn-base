<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="nowdate" class="java.util.Date" />
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>年报公告维护</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div>
    <form id="taskForm">
        <div class="form-box pdlr10">
            <div class="form-list">
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">标题：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" name="title" class="ipt-txt"/>
                            </div>
                        </div>
                    </div>
<!--                     <div class="col-4"> -->
<!--                         <label class="item-name col-5">公告类型：</label> -->
<!--                         <div class="ipt-box col-7"> -->
<!--                             <div class="ipt-box col-12"> -->
<!--                                 <select name="bulType"> -->
<!--                                     <option value="">请选择</option> -->
<!--                                     <option value="3">对内公告</option> -->
<!--                                     <option value="1">对外公告</option> -->
<!--                                     <option value="5">内外公告</option> -->
<!--                                 </select> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
                    <div class="col-4">
                        <label class="item-name col-5">公告类型：</label>
                        <div class="ipt-box col-7">
                            <div class="ipt-box col-12">
                                <select name="bulScope">
                                    <option value="">全部</option>
                                    <option value="4">拟吊销营业执照听证公告</option>
                                    <option value="5">吊销营业执照公告</option>
                                    <option value="6">企业登记机关注销公告</option>
                                    <option value="7">年度抽查工作计划公告</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-4">发布人：</label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" name="setName" class="ipt-txt"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-list">
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">状态：</label>
                        <div class="ipt-box col-7">
                            <div class="ipt-box col-12">
                                <select name="isValid">
                                    <option value="">全部</option>
                                    <option value="1" selected="selected">有效</option>
                                    <option value="0">无效</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">公示日期：</label>
                        <div class="ipt-box col-7">
                            <div class="ipt-box col-575">
                                <input type="text" name="setTimeStart" style="cursor: pointer;" id="setTimeStart" readonly="readonly"
                                       class="ipt-txt laydate-icon" onclick="laydate();"/>
                            </div>
                            <span class="item-line col-05">-</span>
                            <div class="ipt-box col-575">
                                <input type="text" name="setTimeEnd" style="cursor: pointer;" id="setTimeEnd" readonly="readonly"
                                      class="ipt-txt laydate-icon" onclick="laydate();"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                <div class="form-item">
                    <div class="btn-box mt10">
                        <input type="button" id="search" value="查 询" class="btn mr20">
                        <input type="reset" id="cancel" value="重 置" class="btn" onclick="$('#taskForm')[0].reset();">
                    </div>
                </div>
        </div>
    </form>
</div>

<div class="clearfix mb5 mt5">
    <p class="left">
        <button class="btn" type="button" id="addPage">&nbsp;新增
        </button>
    </p>
</div>

<div class="light-info mb5">
    <p class="light">提示：此处仅对公示系统非自动生成的公告信息进行公示管理。失效状态的公告信息将从公示系统中撤回不予对外公示。</p>
</div>

<div>
    <table id="user-table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>标题</th>
            <th>状态</th>
            <th>公告类型</th>
<!--             <th>发布范围</th> -->
            <th>公示日期</th>
            <th>修改日期</th>
            <th>发布人</th>
            <th>发布部门</th>
        </tr>
        </thead>
    </table>
</div>
<script>
    window._CONFIG = {
       chooseUrl:'${userType == 2 ? "/syn" : "/reg/server"}',
       bulType:1
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/bulletins/list_main.js"></script>
</body>
</html>
