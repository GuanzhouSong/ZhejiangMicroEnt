<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>多证合一部门对照维护列表</title>
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
                    <label class="item-name col-5">备案事项编码：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="exaCode" value="" placeholder="请输入备案事项编码">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">是否有效：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <select name="isValid">
                                <option value="">全部</option>
                                <option value="1">有效</option>
                                <option value="0">无效</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">备案事项名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="exaName" value="" placeholder="请输入备案事项名称"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">备案机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="licDept" value="" placeholder="请输入备案机关">
                            <!-- <span class="add-icon"  id="yccodetree"><i></i></span> -->
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">行政区划：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                           <input type="hidden" id="yiedistrict" name="yiedistrict" value="" >
                           <input type="text" class="ipt-txt" id="areaNameText" value="" placeholder="请选择行政区划">
                           <span class="add-icon"  id="selectcity"><i></i></span> 
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">对应备案部门：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" id="deptCode" name="deptCode" value=""  />
                            <input type="text" class="ipt-txt" id="deptNameText" value="" placeholder="请选择对应备案部门"/>
                            <span class="add-icon"  id="selctDept"><i></i></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb10">
                <div class="col-4">
                    <label class="item-name col-5">部门级别：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="licZone">
                                <option value="">全部</option>
                                <option value="0">国家级</option>
                                <option value="1">省级</option>
                                <option value="2">市级</option>
                                <option value="3">县级</option>
                                <option value="4">混合</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">设置日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <div class="col-5">
                                <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate()"
                                       name="startSetTime" id="startSetTime" value=""/>
                            </div>
                            <div class="item-txt col-2"><i class="line-icon"></i></div>
                            <div class="col-5">
                                <input type="text" class="ipt-txt"
                                       readonly="readonly" onclick="laydate()" name="endSetTime" id="endSetTime"
                                       value=""/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">设置人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="setName" value="" placeholder="请输入设置人"/>
                        </div>
                    </div>
                </div>
            </div>
             <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">实际备案部门：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" id="adCode" name="adCode" value="" >
                            <input type="text" class="ipt-txt" id="orgNameText" value="" placeholder="请选择实际备案部门">
                            <span class="add-icon"  id="selectAdDept"><i></i></span> 
                        </div>
                    </div>
                </div>
                <div class="col-4">
                   
                </div>
                <div class="col-4">
                    <label class="item-name col-5"></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                             
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
    <div class="clearfix mb5">
        <p class="fl"><input type="button" class="btn btn-sm mr5" value="新增" id="pubdtinfohandpushlist"></p>
        <!-- <p class="fl" ><input type="button" class="btn btn-sm mr5" value="生成备案对照数据"
                                                   id="executeLicDeptData"></p> -->
      <!--  <p class="fl" ><input type="button" class="btn btn-sm mr5" value="生成下放数据"
       id="transferExaCode"></p> -->
    </div>
    <div class="tab-content mb20">
        <div class="tab-panel tab-panel-show">
            <div class="">
                <div class="table-out">
                    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
                            <th>操作</th>
                            <th>备案事项编码</th>
                            <th>备案事项名称</th>
                            <th>备案机关</th>
                            <th>对应备案部门</th>
                            <th>实际备案部门</th>
                            <th>职能部门</th>
                            <th>企业所属行政区划</th>
                            <th>部门级别</th>
                            <th>是否有效</th>
                            <th>设置人</th>
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
 <script src="<c:url value="/js/syn/system/licdzdept/licdzdept_list_main.js"/>"></script>
 </body>
</html>