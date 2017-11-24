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
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>八大重点统计（年报）</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/vendor/layout-default-latest.css">
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">年报年份：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <select name="year" id="year">   
                           </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">统计层级：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="statLevel" id="statLevel">
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel == 4 }"><option value="areacode">按地区</option></c:if>
                                <c:if test="${sysUser.isAdmin == 1 || sysUser.isAdmin == 2 || sysUser.searchRangeLevel != 1 }"><option value="RegOrg">按登记机关</option></c:if>
                                <option value="LocalAdm">按管辖单位</option>
                            </select>
                        </div>
                    </div>
                </div>
            	<div class="col-4">
	                    <label class="item-name col-5">企业类型：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                        	<input type="hidden" class="hidden_input" name="entType" id="entType" value=""/>
	                            <input type="text" readonly="readonly" class="ipt-txt" id="entTypeName" value="" placeholder="选择"/>
		                         <span class="add-icon" id="chooseEntType">
	                                <i></i>
		                         </span>
	                        </div>
	                    </div>
	             </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">八大重点产业：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <select name="industryCode" id="industryCode">
                               <option value="">请选择</option>
                               <option value="1">信息经济产业</option>
                               <option value="2">环保产业</option>
                               <option value="3">旅游产业</option>
                               <option value="4">金融产业</option>
                               <option value="5">健康产业</option>
                               <option value="6">时尚产业</option>
                               <option value="7">高端装备制造产业</option>
                               <option value="8">文化创意产业</option>
                               <option value="0">全部</option>
                           </select>
                        </div>
                    </div>
                 </div>
                 <div class="col-4" hidden="hidden">
                    <label class="item-name col-5">企业大类：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="entyTypeCatg" id="entyTypeCatg">
                               <option value="">请选择</option>
                               <option value="1">上市</option>
                               <option value="2">股份有限公司</option>
                               <option value="3">国有</option>
                               <option value="4">控股</option>
                               <option value="5">独资</option>
                               <option value="6">内资</option>
                               <option value="7">外资</option>                            
                               <option value="8">港澳台资</option>                            
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" name="regOrg" id="regOrg" value="" class="hidden_input"/>
                            <input type="text" class="fl ipt-txt" id="regOrgName" value="" placeholder="选择"  readonly="readonly"
                                   style="height: 30px;widthcursor: pointer;"/>
                            <span class="add-icon" id="choseorgReg"><i></i></span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="hidden_input" name="localAdm" id="localAdm" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="localAdmName" value="" placeholder="选择" />
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>                 
                </div>
          <div class="more-show" style="display:none;">          
          <div class="form-item clearfix">
				<div class="col-4">
					<label class="item-name col-5">注册资本：</label>
					<div class="col-7">
						<div class="ipt-box col-12">
							<div class="ipt-box col-5">
		                        	<input type="text" class="ipt-txt clx" name="regCapStart" id="regCapStart" placeholder="&ge;(万元)" >
			                    </div>
			                    <span class="item-txt col-2"><i class="line-icon"></i></span>
			                    <div class="ipt-box col-5">
			                        <input type="text" class="ipt-txt clx"  name="regCapEnd" id="regCapEnd" placeholder="&lt;(万元)">
			                    </div>
						</div>
					</div>
				</div>           
                <div class="col-4">
                    <label class="item-name col-5">从业人数规模：</label>
                    <div class="col-7">
						<div class="ipt-box col-12">
							<div class="ipt-box col-5">
		                        	<input type="text" class="ipt-txt clx" name="empNumStart" id="empNumStart" placeholder="&ge;(人)" >
			                    </div>
			                    <span class="item-txt col-2"><i class="line-icon"></i></span>
			                    <div class="ipt-box col-5">
			                        <input type="text" class="ipt-txt clx"  name="empNumEnd" id="empNumEnd" placeholder="&lt;(人)">
			                    </div>
						</div>
                    </div>
                </div>           
                <div class="col-4">
                    <label class="item-name col-5">营业收入规模：</label>
                    <div class="col-7">
						<div class="ipt-box col-12">
							<div class="ipt-box col-5">
		                        	<input type="text" class="ipt-txt clx" name="vendIncStart" id="vendIncStart" placeholder="&ge;(万元)" >
			                    </div>
			                    <span class="item-txt col-2"><i class="line-icon"></i></span>
			                    <div class="ipt-box col-5">
			                        <input type="text" class="ipt-txt clx"  name="vendIncEnd" id="vendIncEnd" placeholder="&lt;(万元)">
			                    </div>
						</div>
                    </div>
                </div>           
           </div>         
          <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">资产规模：</label>
                    <div class="col-7">
						<div class="ipt-box col-12">
							<div class="ipt-box col-5">
		                        	<input type="text" class="ipt-txt clx" name="assGroStart" id="assGroStart" placeholder="&ge;(万元)" >
			                    </div>
			                    <span class="item-txt col-2"><i class="line-icon"></i></span>
			                    <div class="ipt-box col-5">
			                        <input type="text" class="ipt-txt clx"  name="assGroEnd" id="assGroEnd" placeholder="&lt;(万元)">
			                    </div>
						</div>
                    </div>
                </div>                      
                <div class="col-4">
                    <label class="item-name col-5">净利润规模：</label>
                    <div class="col-7">
						<div class="ipt-box col-12">
                            	<div class="ipt-box col-5">
		                        	<input type="text" class="ipt-txt clx" name="netIncStart" id="netIncStart" placeholder="&ge;(万元)" >
			                    </div>
			                    <span class="item-txt col-2"><i class="line-icon"></i></span>
			                    <div class="ipt-box col-5">
			                        <input type="text" class="ipt-txt clx"  name="netIncEnd" id="netIncEnd" placeholder="&lt;(万元)">
			                    </div>
                            
<!--                             <select name="netInc"> -->
<!--                                <option value="">不限</option> -->
<!--                                <option value="1">净利润>0</option> -->
<!--                                <option value="0">净利润=0</option> -->
<!--                                <option value="-1">净利润<0</option>                            -->
<!--                             </select> -->
						</div>
                    </div>
                </div>           
           </div>         
          <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">固定资产规模：</label>
                    <div class="col-7">
						<div class="ipt-box col-12">
							<div class="ipt-box col-5">
		                        	<input type="text" class="ipt-txt clx" name="fixAssetsStart" id="fixAssetsStart" placeholder="&ge;(万元)" >
			                    </div>
			                    <span class="item-txt col-2"><i class="line-icon"></i></span>
			                    <div class="ipt-box col-5">
			                        <input type="text" class="ipt-txt clx"  name="fixAssetsEnd" id="fixAssetsEnd" placeholder="&lt;(万元)">
			                    </div>
						</div>
                    </div>
                </div>           
                <div class="col-4">
                    <label class="item-name col-5">负债总额规模：</label>
                    <div class="col-7">
						<div class="ipt-box col-12">
							<div class="ipt-box col-5">
		                        	<input type="text" class="ipt-txt clx" name="liaGroStart" id="liaGroStart" placeholder="&ge;(万元)" >
			                    </div>
			                    <span class="item-txt col-2"><i class="line-icon"></i></span>
			                    <div class="ipt-box col-5">
			                        <input type="text" class="ipt-txt clx"  name="liaGroEnd" id="liaGroEnd" placeholder="&lt;(万元)">
			                    </div>
						</div>
                    </div>
                </div>           
                <div class="col-4">
                    <label class="item-name col-5">纳税总额规模：</label>
                    <div class="col-7">
						<div class="ipt-box col-12">
							<div class="ipt-box col-5">
		                        	<input type="text" class="ipt-txt clx" name="ratGroStart" id="ratGroStart" placeholder="&ge;(万元)" >
			                    </div>
			                    <span class="item-txt col-2"><i class="line-icon"></i></span>
			                    <div class="ipt-box col-5">
			                        <input type="text" class="ipt-txt clx"  name="ratGroEnd" id="ratGroEnd" placeholder="&lt;(万元)">
			                    </div>
						</div>
                    </div>
                </div>           
           </div>         
       </div>
       </div>
        <div class="center mt10">
            <input type="button" id="search" value="查询" class="btn mr20">
            <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
            <input type="button" value="更多查询" class="btn mr20 js-more-query">
        </div>
    </form>
</div>


<div class="designator-con  form-box" style="padding: 20px; margin-bottom: 20px;" >
    
    <div class="designator-list">
    <div style="display: none;">
        <label><input type="checkbox" class="zbxchoose zbxchoose-Special"  name="zbxchoose" value="0" checked="checked" >行次</label>
        <label><input type="checkbox" class="zbxchoose zbxchoose-Special"  name="zbxchoose" value="1" checked="checked" >年报年份</label>
        <label><input type="checkbox" class="zbxchoose zbxchoose-Special"  name="zbxchoose" value="2" checked="checked">八大重点产业</label>
        <label><input type="checkbox" class="zbxchoose zbxchoose-Special"  name="zbxchoose" value="3" checked="checked" >行业</label>
<!--         <label><input type="checkbox" class="zbxchoose zbxchoose-Special"  name="zbxchoose" value="4" checked="checked" >企业大类</label> -->
        <label><input type="checkbox" class="zbxchoose zbxchoose-Special"  name="zbxchoose" value="4" checked="checked" >企业类型</label>
     </div>
        <label style="padding-left: 20px;"><span class="mr5"><input type="checkbox" id="zbxchooseAll" name="zbxchoose" checked></span></span><strong style="font-size: 14px;color: red;">全选/反选</strong></label>
        <ul class="clearfix">
            <li>
                <label><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="5"></span></span>已年报企业</label>
            </li>
            <li>
                <label><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="6"></span></span>年报率</label>
            </li>
            <li>
                <label><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="7"></span></span>开业数</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="8" ></span></span>开业率</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="9"></span></span>营业收入总额</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="10"></span></span>资产总额</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="11"></span></span>固定资产总额</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="12"></span></span>负债总额</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="13"></span></span>资产负债率</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="14"></span></span>利润总额</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="15"></span></span>净利润</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="16"></span></span>盈利企业数</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="17"></span></span>亏损企业数</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="18"></span></span>纳税总额</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked="checked" value="19"></span></span>从业人数</label>
            </li>
        </ul>
        <div class="l-line"></div>
        <div class="r-line"></div>
    </div>
    <div class="center mt10">
        <a href="javascript:void(0)" class="btn mr20" id="save">查询</a>
        <a href="javascript:void(0)" class="btn mr20" id="re">重置</a>
        <input type="button" value="更多指标项" class="btn mr20 js-more-choose">
    </div>
</div>


    <div class="table-out">
        <div>
            <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30" style="width: 100%;white-space: nowrap;">
                <thead>
                <tr>
                <th style="padding:0 20px;">行次</th>
	            <th>年报年份</th>
	            <th>八大重点产业</th>
<!-- 	            <th>企业大类</th> -->
	            <th>企业类型</th>
	            <th>部门</th>
	            <th>小微企业<br/>已年报企业（户）</th>
	            <th>小微企业<br/>年报率（%）</th>
	            <th>小微企业<br/>开业数（户）</th>
	            <th>小微企业<br/>开业率（%）</th>
	            <th>小微企业<br/>营业收入总额（万元）</th>
	            <th>小微企业<br/>资产总额（万元）</th>
	            <th>小微企业<br/>固定资产总额（万元）</th>
	            <th>小微企业<br/>负债总额（万元）</th>
	            <th>小微企业<br/>资产负债率（%）</th>
	            <th>小微企业<br/>利润总额（万元）</th>
	            <th>小微企业<br/>净利润（万元）</th>
	            <th>小微企业<br/>盈利企业数（户）</th>
	            <th>小微企业<br/>亏损企业数（户）</th>
	            <th>小微企业<br/>纳税总额（万元）</th>
	            <th>小微企业<br/>从业人数（户）</th>
	            <th style="display: none;">应年报数</th>
                </tr>
                </thead>
                <tfoot>
	        <tr>
	            <th>合计</th>
	            <th>-</th>
	            <th>-</th>
<!-- 	            <th>-</th> -->
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
	            <th style="display: none;"></th>
	        </tr> 
	        </tfoot>
            </table>
        </div>
    </div>


<script>
    window._CONFIG = {
        year: '${year}',
        deptCode: '${deptCode}',
        endCheckPushDate: '${endCheckPushDate}',
        month: '${month}',
        isAdmin: '${sysUser.isAdmin}',
        searchRangeLevel: '${sysUser.searchRangeLevel}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/sment/rpt/rptyrsmimport_list.js"></script>
</body>
</html>
