<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>部门公示信息查询</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">公示主体：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="checkbox" name="entTypeCatgCode" value="13,34,26,14,33,23,11,12,32,21,25,24,15,22,31,27,28" checked="checked">企业
                            <input type="checkbox" name="entTypeCatgCode" value="16,17">农专社
                            <input type="checkbox" name="entTypeCatgCode" value="50">个体户
                        </div>
                        <input type="hidden" name="entTypeCatg" id="entTypeCatg">
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regno" placeholder="可输入尾号后四位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">法定代表人/负责人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">企业类型：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
	                        	<input type="hidden" class="ipt-txt" name="entType" id="entType" value=""/>
	                            <input type="text" readonly="readonly" class="ipt-txt" id="entTypeName" value="" />
		                         <span class="add-icon" id="chooseEntType">
	                                <i></i>
		                         </span>
	                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="entName" placeholder="可输入名称关键词查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value=""/>
                        <span class="add-icon" id="choseorgReg">
                            <i></i>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">公示信息项：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="pubItem" id="pubItem">
                                <option value='isMort' selected="selected">动产抵押</option>
                                <option value='isStock'>股权出质</option>
                                <option value='isIppldg'>知识产权出质</option>
                                <option value='isBrand'>商标注册</option>
                                <option value='isSccheck'>抽查检查</option>
                                <option value='isJustice'>司法协助</option>
                                <option value='isPermit'>行政许可</option>
                                <option value='isPunish'>行政处罚</option>
                                <option value='isAnomaly'>经营异常名录</option>
                                <option value='isIllegal'>严重违法失信</option>
                                <option value='isSimpleesc'>简易注销</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">成立日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly" name="estDateStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" style="cursor: pointer;" onclick="laydate()"
                                   readonly="readonly"
                                   name="estDateEnd" value=""/>
                        </div>
                    </div>
                </div>
				<div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regUnit" id="regUnit" value=""/>
                            <input type="text" class="ipt-txt" id="regUnitName" value=""/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
             <div class="form-item clearfix" id="hiddendiv1" style="display: none;">
                <div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<input type="hidden" name="regState" id="regState">
                            <select name="regStateM" id="regStateM" multiple="multiple">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">注册资本：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt" id="regCapStart" name="regCapStart" value="" placeholder="单位(万元)"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575"> 
                        	<input type="text" class="ipt-txt" id="regCapEnd" name="regCapEnd" value="" placeholder="单位(万元)"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">片区：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="sliceNO" id="sliceNo" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="sliceNoName" value="" />
	                         <span class="add-icon" id="chooseSliceNo">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix" id="hiddendiv2" style="display: none;">
				<div class="col-4">
                    <label class="item-name col-5">行业：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="industryCo" id="industryCo" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="industryCoName" value=""/>
	                            <span class="add-icon" id="choseindustry">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                   <label class="item-name col-5">经营范围：</label>
                   <div class="col-7">
                       <div class="ipt-box col-11">
                           <input type="text" class="ipt-txt" name="opScope" value="" placeholder="可输入关键词查询"/>
                       </div>
                   </div>
	            </div>
	            <div class="col-4">
                    <label class="item-name col-5">住所：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="dom" value="" placeholder="可输入关键词查询"/>
                        </div>
                    </div>
                 </div>
            </div>
        </div>
        <div class="mt10">
            <div class="center">
                <input type="button" value="查 询" id="search" class="btn mr20">
                <input type="button" value="重 置" id="cancel" class="btn mr20" onclick="$('#taskForm')[0].reset();">
                <input type="button" value="更多查询条件" id="moresearch" class="btn mr20">
            </div>
        </div>
    </form>
	<div class="light-info">
	    <span class="light">提示：未选择查询条件下查询就默认显示本部门登记或者管辖的在册企业信息。
<!-- 	    <i class="bulb yellow-b"></i> -->
<!-- 	        表示被列入经营异常， -->
<!-- 	         <i class="bulb orange-b"></i> -->
<!-- 	        表示被列入严重违法失信， -->
<!-- 	         <i class="bulb red-b"></i> -->
<!-- 	        表示被列入经营异常和严重违法失信。 -->
<!-- 	    <i class="light-box-y mr5"></i> -->
<!-- 	   	表示企业正在进行简易注销公告。 -->
	    </span>
	</div>
    <div class="mt10">
        <div class="iframe-wrap">
            <table id="permit-table" class="table-row display nowrap" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>序号</th>
<!--                     <th>警示</th> -->
                    <th>统一信用代码/注册号</th>
                    <th>企业名称</th>
                    <th>法定代表人</th>
                    <th>成立日期</th>
<!--                     <th>动产抵押</th> -->
<!--                     <th>股权出质</th> -->
<!--                     <th>知识产权出质</th> -->
<!--                     <th>商标注册</th> -->
<!--                     <th>抽查检查</th> -->
<!--                     <th>司法协助</th> -->
<!--                     <th>行政许可</th> -->
<!--                     <th>行政处罚</th> -->
<!--                     <th>经营异常名录</th> -->
<!--                     <th>严重违法失信</th> -->
<!--                     <th>简易注销</th> -->
                    <th>住所</th>
                    <th>登记机关</th>
                    <th>管辖单位</th>
                    <th>片区</th>
                    <th>登记状态</th>
                </tr>
                </thead>
            </table>
        </div>
  </div>
  </div>
        <script src="/js/lib/require.js"></script>
        <script src="/js/config.js"></script>
        <script src="/js/reg/server/deptpubinfo/deptpubinfo_list_main.js"></script>
</body>
</html>
