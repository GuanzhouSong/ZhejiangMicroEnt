<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>经营异常名录审核列表</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box pd14-mr">
        <div class="form-list">
            <div class="form-item clearfix">
                <div id="uniCode" class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniCode_regNO" value="" placeholder="可输入尾号后四位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrgQx" id="regOrg" value="${codeRegorg.code }"/>
                            <input type="text" readonly="readonly" class="ipt-txt" name="regOrgName" id="regOrgName" value="${codeRegorg.content }"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">列入原因：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="speCause" id="speCause" value=""/>
                            <input type="text" class="ipt-txt text-over" value="" placeholder="请选择列入原因" id="speCauseText" readonly="readonly"/>
                            <span class="add-icon" id="select-intercept_in">
                                <i></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">列入文号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="penDecNo" value="" placeholder="请输入列入文号"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
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
                    <label class="item-name col-5">列入状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="auditState">
                                <option value="">全部</option>
                                <option value="0">待审核</option>
                                <option value="1">予以列入</option>
                                <option value="2">不予列入</option>
                            </select>
                        </div>
                    </div>
                </div>               
                <div class="col-4">
                    <label class="item-name col-5">决定日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text"  class="ipt-txt laydate-icon" readonly="readonly"
                                   name="startAbnTime" id="startNorDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text"  class="ipt-txt laydate-icon" readonly="readonly"
                                   name="endAbnTime" id="endNorDate" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="auditName" value=""/>
                        </div>
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
        <span class="light">提示：查询范围为当前时点本局登记的在册企业。审核后可打印“经营异常名录审批表”，予以列入情况下可打印“列入经营异常名录决定书”。予以列入信息将自动公示于公示系统。</span>
        <!-- <i class="xbt-icon close"></i> -->
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
                            <th>统一信用代码/注册号</th>
<!--                             <th>注册号</th> -->
                            <th>企业名称</th>
<!--                             <th>法定代表人</th> -->
<!--                             <th>成立日期</th> -->
                            <th>列入状态</th>
                            <th>列入文号</th>
                            <th>列入异常原因</th>
                            <th>决定日期</th>
                            <th>决定机关</th>
                            <th>初审人</th>
                            <th>初审日期</th>
                            <th>审核人</th>
                            <th>审核日期</th>
                            <th>登记机关</th>
                            <th>管辖单位</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script>
    window._CONFIG = {
 	       _regOrg:'${codeRegorg.code }'
 	     }
    </script>
    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentaudit_list_main.js"/>"></script>

</body>
</html>