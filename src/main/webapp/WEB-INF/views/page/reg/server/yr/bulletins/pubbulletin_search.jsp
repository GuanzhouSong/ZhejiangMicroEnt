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
    <title>公式系统公告查询</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
        <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div>
    <form id="taskForm">
        <div class="form-box pdlr10">
            <div class="form-list">
                <div class="form-item clearfix">
                    <div class="col-4">
	                    <label class="item-name col-5">主体类型：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <label><input type="checkbox" name="entCatg" checked="checked" value="11,13,31,33,12,14,32,34,21,27,24,22,28">企业</label>
	                            <label><input type="checkbox" name="entCatg" checked="checked" value="16,17">农专社</label>
	                            <label><input type="checkbox" name="entCatg" checked="checked" value="50">个体户</label>
	                        </div>
	                    </div>
                	</div>
                    <div class="col-4">
                        <label class="item-name col-5">统一信用代码/注册号：</label>
                        <div class="ipt-box col-7">
                            <div class="ipt-box col-12">
                                <input type="text" name="uniCodeOrRegNO" class="ipt-txt" placeholder="可输入尾号后四位查询"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value="" readonly="readonly" placeholder="请选择登记机关"/>
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
             </div>
             <div class="form-item clearfix">
                    <div class="col-4">
	                    <label class="item-name col-5">公告类型：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <select  class="clx_one" multiple="multiple" id="pubType" name="pubType">
                                 
                                </select>
	                        </div>
	                    </div>
                	</div>
                    <div class="col-4">
                        <label class="item-name col-5">企业名称：</label>
                        <div class="ipt-box col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="entName" value="" placeholder="可输入名称关键词查询"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                       <label class="item-name col-5">发布部门：</label>
                       <div class="ipt-box col-7">
                           <div class="ipt-box col-11">
                               <input type="text" class="ipt-txt" name="auditDeptName" value="" placeholder=""/>
                           </div>
                       </div>
                   </div>
             </div>
             <div class="form-item clearfix">
                    <div class="col-4">
	                    <label class="item-name col-5">发布方式：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                           <label><input type="checkbox" name="bulletinWay" value="0" />手动</label>
	                           <label><input type="checkbox" name="bulletinWay" value="1" />自动</label>
	                        </div>
	                    </div>
                	</div>
                    <div class="col-4">
                        <label class="item-name col-5">公告标题：</label>
                        <div class="ipt-box col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="pubTitle" value="" placeholder=""/>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                       <label class="item-name col-5">发布人：</label>
                       <div class="ipt-box col-7">
                           <div class="ipt-box col-11">
                               <input type="text" class="ipt-txt" name="setName" value="" placeholder=""/>
                           </div>
                       </div>
                   </div>
             </div>
             <div class="form-item clearfix">
                    <div class="col-4">
	                    <label class="item-name col-5">公示状态：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                          <select name="pubState">
	                             <option value="">全部</option>
	                             <option value="0">公示</option>
	                             <option value="1">不公示</option>
	                           </select>
	                        </div>
	                    </div>
                	</div>
                    <div class="col-4">
                        <label class="item-name col-5">公示日期：</label>
                        <div class="ipt-box col-7">
                            <div class="ipt-box col-12">
                               <div class="ipt-box col-575">
	                                  <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
		                                   readonly="readonly" name="auditDateStart" value=""/>
		                        </div>
		                        <span class="item-line col-05">-</span>
		                        <div class="ipt-box col-575">
		                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
		                                   readonly="readonly" name="auditDateEnd" value=""/>
		                        </div>
	                        </div>
                        </div>
                    </div>
                    <div class="col-4">
                       <label class="item-name col-5">登记状态：</label>
                       <div class="ipt-box col-7">
                           <div class="ipt-box col-11">
                                <select  class="clx_one" multiple="multiple" id="regState" name="regState">
                                 
                                </select>
                           </div>
                       </div>
                   </div>
             </div>
         </div>
                <div class="form-item">
                    <div class="btn-box mt10">
                        <input type="button" id="search" value="查 询" class="btn mr20">
                        <input type="button" id="cancel" value="重 置" class="btn" onclick="$('#taskForm')[0].reset();">
                    </div>
                </div>
        </div>
    </form>
</div>

<div class="light-info mb5">
    <p class="light">提示：此处仅查询通过国家企业信用信息公示系统发布过的信息公告记录。</p>
</div>
  <p class="tip-info left mb5">查询结果：
             公告企业：&nbsp;<span id="distinctTotal" class="light-blue">0</span>&nbsp;户,
             公告信息：&nbsp;<span id="allTotal" class="light-blue">0</span>&nbsp;条 &nbsp;
  </p>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
        <thead>
        <tr>
            <th>序号</th>
<!--        <th>操作</th> -->
            <th>公告标题</th>
            <th>公告类型</th>
            <th>发布方式</th>
            <th>公示状态</th>
            <th>公示日期</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>主体大类</th>
            <th>登记状态</th>
            <th>发布人</th>
            <th>发布部门</th>
            <th>登记机关</th>
        </tr>
        </thead>
    </table>
</div>
<script>
    window._CONFIG = {
       chooseUrl:'${userType == 2 ? "/syn" : "/reg/server"}',
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/bulletins/search_list.js"></script>
</body>
</html>
