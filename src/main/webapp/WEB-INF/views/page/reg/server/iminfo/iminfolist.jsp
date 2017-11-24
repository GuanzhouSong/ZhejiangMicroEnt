<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>即时信息综合查询</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box mb5">
        <div class="form-list pdr8">
            <div class="form-item clearfix">
                <!-- 企业类型大类 -->
                <input type="hidden" name="entTypeCatg" value="13,34,26,14,33,23,11,12,32,21,25,24,15,22,31,27,28">
                
                <input type="hidden" name="yrRepState" id="yrRepState" >
                <input type="hidden" name="regState" id="regState">
                
                <!-- 即时信息  -->
                <div style="display: none;" id="imitem"> 
                </div>
                
                
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="cidRegNO" value="" placeholder="可输入尾号后4位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">法定代表人/负责人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="leRep" value=""/>
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                    <label class="item-name col-5">住所：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt clx" name="dom" value="" placeholder="可输入关键词查询"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
	                    <label class="item-name col-5">企业类型：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                        	<input type="hidden" class="ipt-txt clx" name="entType" id="entType" value=""/>
	                            <input type="text" readonly="readonly" class="ipt-txt clx" id="entTypeName" value="" />
		                         <span class="add-icon" id="chooseEntType">
	                                <i></i>
		                         </span>
	                        </div>
	                    </div>
	             </div>
            	
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="entName" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt clx" name="regOrg" id="regOrg" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt clx" id="regOrgName" value="" />
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
                
            </div>
            <div class="form-item clearfix">
	          
                 <div class="col-4">
                    <label class="item-name col-5">即时信息公示：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt clx" name="item" id="item" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt clx" id="itemName" value="" />
	                         <span class="add-icon" id="choseItem">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
	             <div class="col-4">
                    <label class="item-name col-5">成立日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clx" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="estDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clx" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly"
                                   name="estDateEnd" value=""/>
                        </div>
                    </div>
                </div>
                  <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt clx" name="localAdm" id="localAdm" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt clx" id="localAdmName" value="" />
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
             </div>
            
	        
	     <div class="hideorshow" style="display: none">
            <div class="form-item clearfix">
            	 
                <div class="col-4">
	                    <label class="item-name col-5"><span class="long-label">个转企：</span></label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                            <select name="isIndivid" id="isIndivid" class="clx">
	                                <option value="">全部</option>
	                                <option value="1">是</option>
	                                <option value="0">否</option>
	                            </select>
	                        </div>
	                    </div>
	             </div>
                
                <div class="col-4">
	                    <label class="item-name col-5"><span class="long-label">列入经营异常：</span></label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                            <select id="isOpan" name="isOpan" class="clx"> 
	                                <option value="">全部</option>
	                                <option value="Y">是</option>
	                                <option value="N">否</option>
	                            </select>
	                        </div>
	                    </div>
	             </div>
                <div class="col-4">
                    <label class="item-name col-5">行业：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt clx" name="industryCo" id="industryCo" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt clx" id="industryCoName" value=""/>
	                            <span class="add-icon" id="choseindustry">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
           
           <div class="form-item clearfix">
           <div class="col-4">
                    <label class="item-name col-5">年报记录：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                          <select name="imYear" id="imYear" class="clx">
                           <option value="">请选择</option>
                           <option value="none">无年报记录</option>
                         	<c:forEach var="year" items="${yearList }">
                                	<option value='${year-1 }'>${year-1 }</option>
                            	</c:forEach>  
                            </select>   
                        </div>
                    </div>
             </div> 
             <div class="col-4">
	                    <label class="item-name col-5"><span class="long-label">列入严违名单：</span></label>
	                    <div class="col-7">
	                        <div class="ipt-box col-12">
	                            <select class="clx">
	                                <option value="">暂无数据</option>
<!-- 	                                <option value="Y">是</option> -->
<!-- 	                                <option value="N">否</option> -->
	                            </select>
	                        </div>
	                    </div>
	         </div>
            	 
                 <div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="regStateM" id="regStateM" multiple="multiple" class=" clx">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                
            </div>
            
            <div class="form-item clearfix">
             
            	   <div class="col-4">
                    <label class="item-name col-5">注册资本：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt clx" id="regCapStart" name="regCapStart" value=""  placeholder="单位（万元）" />
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575"> 
                        	<input type="text" class="ipt-txt clx" id="regCapEnd" name="regCapEnd" value="" placeholder="单位（万元）"/>
                        </div>
                    </div>
                </div>
	             <div class="col-4">
                    <label class="item-name col-5">经营范围：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="opScope" value="" placeholder="可输入关键词查询">
                        </div>
                    </div>
                </div>
                
                 <div class="col-4">
                    <label class="item-name col-5">联系电话：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt clx" name="tel" value="" placeholder="可输入关键词查询">
                        </div>
                    </div>
                </div>
              
            </div>
            
            <div class="form-item clearfix">
             <div class="col-4">
                    <label class="item-name col-5">片区/商圈：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt clx" name="sliceNO" id="sliceNo" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt clx" id="sliceNoName" value="" />
	                         <span class="add-icon" id="chooseSliceNo">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                    <label class="item-name col-5">最近公示日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clx" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="imPubDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clx" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="imPubDateEnd" value=""/>
                        </div>
                    </div>
                </div>
                
              </div>
        
            
       </div>
        <div class="center mt10">
            <input type="button" id="js-search" value="查询" class="btn mr20">
            <input type="button" id="reset" value="重置" class="btn mr20">
       		<input type="button" id="more" value="更多查询条件" class="btn mr20">
        </div>
    </form>
</div>

<div class="light-info">
    <span class="light">提示：系统默认显示本部门登记或管辖的在册企业信息。
    <img src='/img/reg/server/year-status3.png' width='15' height='15'/> 表示被列入严违名单或异常名录企业
    &nbsp;&nbsp;
    <img src='/img/reg/server/year-status0.png' width='15' height='15'/> 表示无即时信息公示记录企业
    &nbsp;&nbsp;
     
    </span>
</div>

<div class="tab-content mb20 mt10">
    <div class="tab-panel tab-panel-show">
        <div class="">
            <div class="table-out">
                <table id="user-table" border="0" cellspacing="0" cellpadding="0"
                       class="table-row display nowrap">
                    <thead>
	                    <tr>
	                        <th>序号</th>
	                        <th>警示</th>
<!-- 	                        <th>年度</th> -->
	                        <th>统一代码/注册号</th>
	                        <th>企业名称</th>
	                        <th>成立日期</th> 
	                        <th>即时信息公示</th>
	                        <th>最近年报记录</th>
	                        <th>最近公示日期</th> 
	                        <th>法定代表人/负责人</th>
	                        <th>负责人电话</th>
	                        <th>企业联络员</th>
	                        <th>联络员电话</th>
	                        <th>注册资本(万元)</th>
	                        <th>企业类型</th>
	                        <th>行业</th>
	                        <th>住所地</th>
	                        <th>登记机关</th>
	                        <th>管辖单位</th>
	                        <th>片区/商圈</th>
	                        <th>登记状态</th>
	                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/iminfo/list_main.js"></script>
</div>
</body>
</html>
