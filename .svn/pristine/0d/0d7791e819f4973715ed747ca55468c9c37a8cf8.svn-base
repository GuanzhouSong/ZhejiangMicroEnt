<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政许可</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">

</head>
<body class="pd10">
<form id="qryForm">
     <input type="hidden" id="userType" value="${userType }">
    <input type="hidden" id="regOrg" name="regOrg">
    <input type="hidden" id="localAdm" name="localAdm">
    <input type="hidden" id="entType" name="entType">
    <input type="hidden" id="sliceNO" name="sliceNO">
      <input type="hidden" id="deptCode" value="${deptCode}">
    <div class="form-box">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" name="entName"  placeholder="请输入企业名称" class="ipt-txt">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" name="regNO" class="ipt-txt" placeholder="请输入注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">提交时间：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="setDateStart" value="" />
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="setDateEnd"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">扶持时间：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" name="helpDate"  readonly onclick="laydate()" class="ipt-txt" placeholder="请选择扶持时间">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">提供方式：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                        <select name="provideType">
                          <option value="">全部</option>
                          <option value="1">在线录入</option>
                           <option value="2">批量导入</option>
                            <option value="3">数据接口</option>
                           <option value="4">数据交换</option>
                          
                        </select>
                            <!-- <input type="text" name="licNO" class="ipt-txt"> -->
                        </div>
                    </div>
                </div>
                <!-- <div class="col-4">
                    <label class="item-name col-5">许可文件名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" name="licNameCN" class="ipt-txt">
                        </div>
                    </div>
                </div> -->
            </div>
      <!--       <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">许可有效时间至：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="licValToStart" onclick="laydate()"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="licValToEnd"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="fl ipt-txt" id="regOrgName" placeholder="选择">
                            <span class="add-icon" id="choseorgReg">
                                <i></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="licState">
                                <option value="" checked>全部</option>
                                <option value="1">有效</option>
                                <option value="0">无效</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div> 
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">公示状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="pubFlag">
                                <option value="" checked>全部</option>
                                <option value="0" checked>未公示</option>
                                <option value="1" checked>已公示</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">录入日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="setDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="setDateEnd"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="fl ipt-txt" id="localAdmName" placeholder="选择">
                            <span class="add-icon" id="choseregUnit">
                                <i></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div> 
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">录入人员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" name="setName" class="ipt-txt">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核结果：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="auditState">
                                <option value="" checked>全部</option>
                                <option value="0" checked>待审核</option>
                                <option value="1" checked>审核通过</option>
                                <option value="2" checked>审核不通过</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="auditDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"
                                   onclick="laydate()"
                                   readonly="readonly" name="auditDateEnd"/>
                        </div>
                    </div>
                </div>

            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">责任区：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="fl ipt-txt" id="sliceNoName" placeholder="选择">
                            <span class="add-icon" id="choseSilceno">
                                <i></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" name="auditName" class="ipt-txt">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="fl ipt-txt" id="entTypeName" placeholder="选择">
                            <span class="add-icon" id="choseEntcatg">
                                <i></i>
                            </span>
                        </div>
                    </div>
                </div>

            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">许可内容：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" name="licScope" class="ipt-txt">
                        </div>
                    </div>
                </div>
            </div>-->
            <div class="clearfix">
                <div class="btn-box mt10">
                    <input type="button" id="qry" value="查 询" class="btn mr20">
                    <input type="button" id="cancel" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </div>
</form>

  <%--弹出框--%>
<div class="mod mod-border investment-info js-content-show js-upload mt10" id="loadFile" style="display:none;">
    <div class="forguarantee-lead">
        <h6 class="download" style="text-align: left;">
            <a  href="<c:url value="/reg/server/other/pubSmallSupport/file_down"/>" ><b class="download-ico"></b>下载本站EXCEL模版</a>
        </h6>
        <div class="state pos-rel">
            <span>说明：</span>
            <p>1、导入数据时请先下载EXCEL导入模版；</p>
            <p>2、下载导入模板后请按照导入模板格式和内容要求完成导入信息的填录；</p>
            <p>3、使用非本系统提供的导入模板或擅自修改导入模板的格式和内容会导致操作不成功。</p>
        </div>
        <div class="lead-file">
            <label>导入EXCEL文件</label>
            <form id="file_import" enctype="multipart/form-data" method="post">
                <div class="ipt-box">
                    <input type="file" id="js-file" name="file"  class="ipt-txt ipt-txt-lg">
                    
                </div>
                <input type="button" class="btn js-import" value="导入">
            </form>


        </div>
    </div>
    <div style="text-align: center;"><input type="button" class="btn btnCancel"  value="关闭"></div>
</div>

<div class="clearfix mb5 mt5">
    <p class="fl"><input type="button" class="btn btn-sm mr5  " id="addBtn" value="添加">
        <input type="button" style="display:none" class="btn btn-sm mr5  " id="importExcel" value="Excel导入">
    </p>
</div>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
           style="width: 100%;white-space: nowrap;">
        <thead>
        <tr>
            <th>序号</th> 
            <th>操作</th> 
            <th class="registState">企业名称</th> 
            <th>统一社会信用代码/注册号</th>
            <th>部门</th> 
            <th>扶持内容</th>
            <th>扶持日期</th> 

        </tr>
        </thead>
    </table>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/smallsupport/pubsmallsupport_search_list.js"></script>
</body>
</html>