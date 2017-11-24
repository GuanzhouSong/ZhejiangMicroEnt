<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>分类标签审核列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box pd14-mr">
        <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">标签名称：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="IDName" value="" placeholder="可输入关键字查询">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">标签编号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="IDCode" value="" placeholder="可输入标签编号"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">申请人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="setName" value="" placeholder="请输入申请人"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">标签类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12"> 
                             <select name="IDType" id="IDType" multiple="multiple">
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">适用范围：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text"  id="setDeptName"  class="ipt-txt clx" value="" readonly/>
                            <input type="hidden" id="setDeptCode" name="setDeptCode" class="clx" value="" />
                            <a id="selectRegOrg" class="link js-show">
                                <span class="add-icon" id="yccodetree"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                             <input type="text" class="ipt-txt" name="auditorName" value="" placeholder="可输入审核人"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">标签状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                              <select name="IDStateCode">
                                <option value="">全部</option>
                                <option value="1">有效</option>
                                <option value="2">失效</option>
                              </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核状态：</label>
                    <div class="col-7">
                       <div class="ipt-box col-12">
                          <select name="auditState">
                                <option value="">全部</option>
                                <option value="1">待审核</option>
                                <option value="2">审核通过</option>
                                <option value="3">审核不通过</option>
                           </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"></label>
                    <div class="col-7">
                         
                    </div>
                </div>
            </div>
            <div class="center mt10">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
     
    <div class="light-info mt5 mb5">
        <span class="light">提示：只有已审核且状态为有效的标签才可用。</span> 
    </div>
    
    <div class="clearfix mb5 mt5">
    <p class="fl">
        <input id="btn_add" type="button" class="btn btn-sm mr5 js-batchregist" value="新增标签">
    </p>
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
                            <th>标签名称</th>
                            <th>标签类别</th>
                            <th>标签状态</th>
                            <th>有效期至</th>
                            <th>适用范围</th>
                            <th>对应双随机部门</th>
                            <th>双随机事项</th>
                            <th>双随机主体库</th>
                            <th>创建日期</th>
                            <th>修改日期</th>
                            <th>审核状态</th>
                            <th>申请人</th>
                            <th>申请部门</th>
                            <th>审核人</th>
                            <th>审核部门</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
<script>
    window._CONFIG = {
       deptCode:'${deptCode}',
       isAdmin :'${sysUser.isAdmin}',
       searchRangeLevel:'${sysUser.searchRangeLevel}'
    }
</script>
    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script src="<c:url value="/js/reg/server/registmark/registmarkapply_list.js"/>"></script>
</body>
</html>