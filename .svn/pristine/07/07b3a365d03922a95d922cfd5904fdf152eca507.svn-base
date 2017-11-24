<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>农专社报表审核列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <input type="hidden" id="deptType" name="deptType" value="${deptType}"/>
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一社会信用代码：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniCode" value="" placeholder="请输入统一社会信用代码"/>
                        </div>
                    </div>
                </div>
                <div id="uniCode" class="col-4">
                    <label class="item-name col-3">注册号：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNO" value="" placeholder="请输入注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4" id="entName">
                    <label class="item-name col-5">农专社名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入农专社名称"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">法定代表人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep" value="" placeholder="请输入法定代表人"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3">登记机关：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" readonly="readonly" value=""
                                   placeholder="请选择登记机关"/>
                            <span class="add-icon" id=choseorgReg>
                                <i></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">申报年度：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="year" name="year">
                               <c:forEach var="nowYear" items="${yearList}" varStatus="status" >
			        		    <option value="${nowYear}">${nowYear}</option>
		        		       </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <c:if test="${deptType=='0'}">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">审核状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="status" name="status"> 
			        		    <option value="">全部</option> 
			        		    <option value="1" selected="selected">待审核</option> 
			        		    <option value="2" >已审核</option> 
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-3"></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            
                        </div>
                    </div>
                </div>
            </div> 
            </c:if> 
            <div class="form-item clearfix mt10">
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
                    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap"
                           width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
                            <th>统一社会信用代码</th>
                            <th>注册号</th>
                            <th>农专社名称</th>
                            <th>申报年度</th>
                            <th>法定代表人</th>
                            <th>登记机关</th>
                            <th>管辖单位</th>
                            <th>综合信息备案</th>
                            <th>核实反馈(农业)</th>
                            <th>核实反馈(工商)</th>
                            <th>核实反馈(金融)</th>
                            <th>住所</th>
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
            _sysUrl: '${sysUrl}'
        }
    </script>
    <script src="<c:url value="/js/syn/system/composite/cominfocheck_list_main.js"/>"></script>
</div>
</body>
</html>