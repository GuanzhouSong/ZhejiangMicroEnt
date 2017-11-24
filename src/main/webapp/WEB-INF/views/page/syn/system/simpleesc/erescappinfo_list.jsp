<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>简易注销异议公告列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一代码/注册号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniSCIDAndReg" value="" placeholder="请输入统一代码/注册号"/>
                        </div>
                    </div>
                </div>
                <div id="uniCode" class="col-4">
                    <label class="item-name col-3">企业名称：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" readonly="readonly" value="" placeholder="请选择登记机关"/>
                            <span class="add-icon" id=choseorgReg>
                                <i></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">公告期自：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                             <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()"
                                       name="noticeFrom" id="noticeFrom" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">公告期至：</label>
                    <div class="col-9">
                         <div class="ipt-box col-12">
                           <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()"
                                       name="noticeTo" id="noticeTo" value=""/>
                         </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="请选择管辖单位" readonly="readonly"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div> 
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">公告申请日期：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                             <div class="col-5">
                                <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()"
                                       name="startAppDate" id="startAppDate" value=""/>
                            </div>
                            <div class="col-2 item-txt"><i class="line-icon"></i></div>
                            <div class="col-5">
                                <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()"
                                       name="endAppDate" id="endAppDate" value=""/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">住 所：</label>
                    <div class="col-9">
                         <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="dom" id="dom" value="" placeholder="请输入住所"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业类型：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="entTypeName" class="ipt-txt clx" value="" readonly="readonly" placeholder="请选择企业类型"/>
                            <input type="hidden" id="entType" name="entType" class="clx" value=""/>
                            <a id="selectEntType" class="link js-show">
                                <span class="add-icon" id="choseEntType"><i></i></span>
                            </a>
                        </div> 
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form> 
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out"> 
                        <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th> 
                            <th>企业名称</th> 
                            <th>统一代码/注册号</th>
                            <th>简易注销结果</th>
                            <th>登记机关</th> 
                            <th>管辖单位</th> 
                            <th>公告申请日期</th>
                            <th>公告期自</th>
                            <th>公告期至</th> 
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
    <script src="<c:url value="/js/syn/system/simpleesc/erescappinfo_list_main.js"/>"></script>
</body>
</html>