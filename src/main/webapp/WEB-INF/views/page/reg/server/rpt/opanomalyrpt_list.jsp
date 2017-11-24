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
    <title>异常名录统计</title>
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
                    <label class="item-name col-5">主体类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="radio" name="entCatgCode" checked="checked" value="1" id="qy">企业
                            <input type="radio" name="entCatgCode" value="2" id="nz">农专社
                            <input type="radio" name="entCatgCode" value="3" id="gt">个体户
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-6">统计层级：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="statLevel" id="statLevel">
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel == 4 }"><option value="area">按地区</option></c:if>
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel != 1 }"><option value="regOrg">按登记机关</option></c:if>
                                <option value="localAdm">按管辖单位</option>
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
            	<div class="col-10">
                    <label class="item-name col-2">决定日期：</label>
                     <div class="ipt-box col-2">
                           <select name="rptyear" id="rptyear">
                           </select>
                    </div>
                    <div class="ipt-box col-2 mr-col-005">
                           <select name="rptmouth" id="rptmouth">
                           <option value="00" id="00">当前</option>
                           <option value="01">1月</option>
                           <option value="02">2月</option>
                           <option value="03">3月</option>
                           <option value="04">4月</option>
                           <option value="05">5月</option>
                           <option value="06">6月</option>
                           <option value="07">7月</option>
                           <option value="08">8月</option>
                           <option value="09">9月</option>
                           <option value="10">10月</option>
                           <option value="11">11月</option>
                           <option value="12">12月</option>
                           </select>
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
                <!-- <div class="col-4">
                    <label class="item-name col-6"></label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            
                        </div>
                    </div>
                </div> -->           
                <div class="col-4">
                    <label class="item-name col-5"></label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                             
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
         <p class="light">1、一家企业可能因不同原因被列入异常或因不同的理由被移出异常，列入或移出异常总户数不一定等于各类原因列入或移出异常户数之和。列入、移出、撤销“户数”为统计时点内有过列入、移出、撤销记录的企业户数，与企业当前登记状态如已注吊销或迁出无关。</p>
         <p class="light">2、“总列入（标记）经营异常”条数 -“列入（标记）后更正撤销”条数=“列入（标记）经营异常”条数；“总列入（标记）经营异常”条数等于各类列入经营异常原因条数之和；“移出（恢复）经营异常”条数等于各类移出经营异常原因条数之和。</p>
    </div>
    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
                <th rowspan="3" style="padding:0 20px;">行次</th>
	            <th rowspan="3">地区</th>
	            <th rowspan="3" style="padding:0 40px;">部门</th>
	            <th rowspan="2" colspan="2">总列入（标记）经营异常</th> 
	            <th rowspan="2" colspan="2">列入（标记）后更正撤销</th>
	            <th rowspan="2" colspan="2">列入（标记）经营异常</th>
	            <th rowspan="2" colspan="2">移出（恢复）经营异常</th>
	            <th colspan="8">列入（标记）经营异常原因</th> 
	            <th colspan="14">移出（恢复）经营异常理由</th> 
                </tr>
                <tr> 
	            <th colspan="2">未按时年报</th>
	            <th colspan="2">拒不公示信息</th>
	            <th colspan="2">公示虚假信息</th>
	            <th colspan="2">查无下落</th> 
	            <th colspan="2">已补报年报</th>
	            <th colspan="2">已履行公示义务</th>
	            <th colspan="2">已更正公示信息</th> 
	            <th colspan="2">已变更登记住所</th>
	            <th colspan="2">重新取得联系</th> 
	            <th colspan="2">列入严违名单移出</th> 
	            <th colspan="2">注销/个转企移出</th>
                </tr>
                <tr>
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th> 
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th> 
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th> 
	            <th>户数</th>
	            <th>条数</th> 
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th> 
	            <th>户数</th>
	            <th>条数</th>
	            <th>户数</th>
	            <th>条数</th>
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
       _searchRangeLevel:'${sysUser.searchRangeLevel}',
       _isAdmin:'${sysUser.isAdmin}' 
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/rpt/opanomalyrpt_list.js"></script>
</body>
</html>
