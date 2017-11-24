<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>年报进度统计</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">年报主体：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="radio" name="entCatgCode" checked="checked" value="1" id="qy">企业
                            <input type="radio" name="entCatgCode" value="2" id="nz">农专社
                            <input type="radio" name="entCatgCode" value="3" id="gt">个体户
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">年报年度：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                           <select name="year" id="year">   
                           </select>
                        </div>
                    </div>
                </div>           
                <div class="col-4">
                    <label class="item-name col-5">统计范围：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="statArea" id="statArea" multiple="multiple">
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统计层级：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="statLevel" id="statLevel">
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel == 4 }"><option value="area">按地区</option></c:if>
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel != 1 }"><option value="regOrg">按登记机关</option></c:if>
                                <option value="localAdm">按管辖单位</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-8">
                <label class="item-name col-3">统计日期：</label>
                <div class="col-9">
                    <div class="ipt-box col-2">
                           <select name="rptyear" id="rptyear" class="rptselect">
                           </select>
                    </div>
                    <div class="ipt-box col-2 mr-col-005">
                           <select name="rptway" id="rptway" class="rptselect">
                           <option value="00" id="now">当前</option>
                           <option value="01" id="month">月度</option>
                           </select>
                    </div>
                    <div class="monthchoose" style="display: none;">
                    <div class="ipt-box">                  
                    <span class="item-line">月份：</span>
                    </div>
                     <div class="ipt-box col-1">
                           <select name="rptbeginmouth" id="rptbeginmouth" class="rptselect">
                           <option value="01">1</option>
                           <option value="02">2</option>
                           <option value="03">3</option>
                           <option value="04">4</option>
                           <option value="05">5</option>
                           <option value="06">6</option>
                           <option value="07">7</option>
                           <option value="08">8</option>
                           <option value="09">9</option>
                           <option value="10">10</option>
                           <option value="11">11</option>
                           <option value="12">12</option>
                           </select>
                    </div>
                    <div class="ipt-box">                  
                    <span class="item-line">-</span>
                    </div>
                    <div class="ipt-box col-1 mr-col-005">
                           <select name="rptendmouth" id="rptendmouth" class="rptselect">
                           <option value="01">1</option>
                           <option value="02">2</option>
                           <option value="03">3</option>
                           <option value="04">4</option>
                           <option value="05">5</option>
                           <option value="06">6</option>
                           <option value="07">7</option>
                           <option value="08">8</option>
                           <option value="09">9</option>
                           <option value="10">10</option>
                           <option value="11">11</option>
                           <option value="12">12</option>
                           </select>
                    </div>
                    </div>
                      <div class="ipt-box col-4">
                     	  <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly" id="startCheckPushDate"
                                   name="startCheckPushDate" value="${startCheckPushDate}" />
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" readonly="readonly"  
                              name="endCheckPushDate" id="endCheckPushDate" value="${endCheckPushDate}"/>
                        </div>
                     </div>
               </div>
              </div>          
       </div>
        <div class="center mt10">
            <input type="button" id="search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
        </div>
    </form>
</div>

    <div class="light-info mt10">
         <p class="light">数据说明：</p>
         <p class="light">1、“初始应年报数”指上年度末时点的在册应年报企业数（固定值）；“实际应年报数”指统计时点的在册应年报企业数（动态值）；“已年报数”指统计时点年报状态为已年报的在册企业数；已年报中逾期年报数”指统计时点已年报中首次报送日期在6月30日之后的在册企业数；“未年报中因查无下落列入异常数”指截止统计时点因查无下落列入异常且未年报的在册企业数；注：除初始应年报数锁定外，其余统计项的在册企业数都会因企业注吊销、迁出而减少，因迁入、注吊销恢复而增加，因企业类型变化如个转企等情况而发生变化。</p>
         <p class="light">2、“实际应年报数”=“未年报数”+“已年报数”；“自然年报率”=已年报数/实际应年报数；“工作年报率”=（已年报数+未年报中因查无下落列入异常数）/实际应年报数；“已年报数”=各类年报方式之和（数字证书+联络员+纸质报告+手机APP）。</p>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
                <th>行次</th>
	            <th>地区</th>
	            <th>部门</th>
	            <th>年初应报数</th>
	            <th>实际应报数</th>
	            <th>未年报数</th>
	            <th>未年报中因查无<br/>下落列入异常数</th>
	            <th>已年报数</th>
	            <th>已年报中<br/>逾期年报数</th>
	            <th>自然年报率（%）</th>
	            <th>工作年报率（%）</th>
	            <th>数字证书年报数</th>
	            <th>联络员年报数</th>
	            <th>纸质报告年报数</th>
	            <th>手机APP年报数</th>
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
	            <th></th>
	            <th></th>
	            <th></th>
	            <th></th>
	        </tr> 
	        </tfoot>
            </table>
        </div>
    </div>
<script>
    window._CONFIG = {
       year:'${year}',
       deptCode:'${deptCode}',
       endCheckPushDate:'${endCheckPushDate}',
       month:'${month}',
       isAdmin :'${sysUser.isAdmin}',
       searchRangeLevel:'${sysUser.searchRangeLevel}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/rpt/rptyrcount_list.js"></script>
</body>
</html>
