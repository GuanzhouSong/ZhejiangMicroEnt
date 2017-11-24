<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>登记信息统计（普通统计）</title>
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
                    <label class="item-name col-5">时间区间：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="estDateStart" value="<fmt:formatDate value="${startCheckPushDate}" type="date" pattern="yyyy-MM-dd"/>"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly"
                                   name="estDateEnd" value="<fmt:formatDate value="${endCheckPushDate}" type="date" pattern="yyyy-MM-dd"/>"/>
                        </div>
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
                    <label class="item-name col-6">法定代表人（负责人）年龄：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="cer" id="cer">
                                <option value="">不限</option>
                                <option value="cer60">60后</option>
                                <option value="cer70">70后</option>
                                <option value="cer80">80后</option>
                                <option value="cer90">90后</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">三次产业：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <select name="thrIndustry" id="thrIndustry">
                               <option value="">请选择</option>
                               <option value="thrIndustry1">第一产业</option>
                               <option value="thrIndustry2">第二产业</option>
                               <option value="thrIndustry3">第三产业</option>
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
              </div>     
            
            <div class="more-show" style="display:none;">     
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">行业：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="hidden_input" name="industryCo" id="industryCo" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="industryCoName" value="" placeholder="选择"/>
	                            <span class="add-icon" id="choseindustry">
	                                <i></i>
	                            </span>
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
                <div class="col-4">
                    <label class="item-name col-6">管辖单位：</label>
                    <div class="col-6">
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
          <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">注册资本规模：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <select name="regCap" id="regCap">
                               <option value="">请选择</option>
                               <option value="regCap10">0-10</option>
                               <option value="regCap50">10-50</option>
                               <option value="regCap100">50-100</option>
                               <option value="regCap500">100-500</option>
                               <option value="regCapO500">500-</option>
                           </select>
                        </div>
                    </div>
                </div>           
                <div class="col-4">
                    <label class="item-name col-5">从业人数规模：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <select name="empNum" id="empNum">
                               <option value="">请选择</option>
                               <option value="empnum5">0-5</option>
                               <option value="empnum10">5-10</option>
                               <option value="empnum20">10-20</option>
                               <option value="empnum50">20-50</option>
                               <option value="empnum100">50-100</option>
                               <option value="empnum200">100-200</option>
                               <option value="empnum300">200-300</option>
                               <option value="empnum500">300-500</option>
                               <option value="empnumO500">500-</option>
                           </select>
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


<div class="designator-con form-box" style="padding: 20px; margin-bottom: 20px;" >
    
    <div class="designator-list" >
    <div style="display: none;">
        <label><input type="checkbox" class="zbxchoose"  name="zbxchoose" value="0" checked="checked" >行次</label>
        <label><input type="checkbox" class="zbxchoose"  name="zbxchoose" value="1" checked="checked" >时间区间</label>
        <label><input type="checkbox" class="zbxchoose"  name="zbxchoose" value="2" checked="checked">三次产业</label>
        <label><input type="checkbox" class="zbxchoose"  name="zbxchoose" value="3" checked="checked" >行业</label>
<!--         <label><input type="checkbox" class="zbxchoose"  name="zbxchoose" value="4" checked="checked" >企业大类</label> -->
        <label><input type="checkbox" class="zbxchoose"  name="zbxchoose" value="4" checked="checked" >企业类型</label>
        <label><input type="checkbox" class="zbxchoose"  name="zbxchoose" value="5" checked="checked" >登记机关</label>
     </div>
        <label style="padding-left: 20px;"><span class="mr5"><input type="checkbox" id="zbxchooseAll" name="zbxchoose" checked></span></span><strong style="font-size: 14px;color: red;">全选/反选</strong></label>
        <ul class="clearfix">
            <li>
                <label><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="6"></span></span>在册小微企业数</label>
            </li>
            <li>
                <label><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="7" ></span></span>新设小微企业数</label>
            </li>
            <li>
                <label><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="8" ></span></span>注销小微企业数</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="9"></span></span>在册小微企业注册资本总额</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="10"></span></span>新设小微企业注册资本总额</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="11"></span></span>新设小微企业平均注册资本</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="12"></span></span>新设小微企业负责人平均年龄</label>
            </li>
<!--             <li> -->
<!--                 <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="15"></span></span>负责人80后的新设小微企业数</label> -->
<!--             </li> -->
<!--             <li> -->
<!--                 <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="16"></span></span>负责人90后的新设小微企业数</label> -->
<!--             </li> -->
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="13"></span></span>负责人是省内的新设小微企业数</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="14"></span></span>股东全为自然人的新设小微企业数</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="15"></span></span>在册企业数</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="16"></span></span>新设企业数</label>
            </li>
            <li>
                <label style="display: none;" class="choose-n"><span class="mr5"><input type="checkbox" class="zbxchoose zbxchoose-ususal" name="zbxchoose" checked  value="17"></span></span>注销企业数</label>
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
	            <th>时间区间</th>
	            <th>三次产业</th>
	            <th>行业</th>
<!-- 	            <th>企业大类</th> -->
	            <th>企业类型</th>
	            <th>部门</th>
	            <th>在册小微企业数（户）</th>
	            <th>新设小微企业数（户）</th>
	            <th>注销小微企业数（户）</th>
	            <th>在册小微企业<br/>注册资本总额（万元）</th>
	            <th>新设小微企业<br/>注册资本总额（万元）</th>
	            <th>新设小微企业<br/>平均注册资本（万元）</th>
	            <th>新设小微企业<br/>负责人平均年龄（岁）</th>
<!-- 	            <th>负责人80后的<br/>新设小微企业数（户）</th> -->
<!-- 	            <th>负责人90后的<br/>新设小微企业数（户）</th> -->
	            <th>负责人是省内的<br/>新设小微企业数（户）</th>
	            <th>股东全部为自然人的<br/>新设小微企业数（户）</th>
	            <th>在册企业数（户）</th>
	            <th>新设企业数（户）</th>
	            <th>注销企业数（户）</th>	            
	            <th style="display: none;">法人个数（身份证号存在）</th>
                </tr>
                </thead>
                <tfoot>
	        <tr>
	            <th>合计</th>
	            <th>-</th>
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
<!-- 	            <th></th> -->
<!-- 	            <th></th> -->
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
<script src="/js/sment/rpt/rptsmnormal_list.js"></script>
</body>
</html>
