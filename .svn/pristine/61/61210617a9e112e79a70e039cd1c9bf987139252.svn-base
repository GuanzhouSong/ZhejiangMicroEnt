<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>执法人员列表</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<select id="codePositionTypeList" style="display: none;">
    <c:forEach items="${codePositionTypeList}" var="codePositionType">
	 	<option value="${codePositionType.positionCode}">${codePositionType.positionName}</option>
	</c:forEach>
</select>
<select id="codeExpertTypeList" style="display: none;">
    <c:forEach items="${codeExpertTypeList}" var="codeExpertType">
	 	<option value="${codeExpertType.expertCode}">${codeExpertType.expertName}</option>
	</c:forEach>
</select>
<select id="codeRightTypeList" style="display: none;">
    <c:forEach items="${codeRightTypeList}" var="codeRightType">
	 	<option value="${codeRightType.rightCode}">${codeRightType.rightName}</option>
	</c:forEach>
</select>
<input type="hidden" id="userUid"  value="${sysUser.id}">
<form id="qryForm">
    <input type="hidden" id="dutyDeptCode"  value="${dutyDeptCode}">
    <div class="form-box mb5">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">姓名：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="agentName" class="ipt-txt">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">检查事项范围：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="agentRangeArr" id="agentRange" value=""/>
                            <input type="text" class="ipt-txt" id="agentRangeName"/>
	                            <span class="add-icon" id="agentRangeChoose">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">工作单位：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
	                        <input type="text" id="deptName" readonly="readonly" value="" class="fl ipt-txt">
                            <input type="hidden" id="deptCodeArr" name="deptCodeArr" value="">
                            <span class="add-icon" id="deptChoose"><i></i></span>
                        </div>
                    </div>
                </div> 
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">从事岗位大类：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="deptCatgArr" id="deptCatg" value=""/>
	                        <select id="deptCatgM" multiple="multiple">
	                            <c:forEach items="${codePositionTypeList}" var="codePositionType">
		                        	<option value="${codePositionType.positionCode}">${codePositionType.positionName}</option>
		                    	</c:forEach>
	                        </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">是否专家：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="expertFlagArr" id="expertFlag" value=""/>
	                        <select id="expertFlagM" multiple="multiple">
	                            <option value="N">否</option>
<!-- 	                            <option value="Y">是</option> -->
	                            <c:forEach items="${codeExpertTypeList}" var="codeExperType">
		                        	<option value="${codeExperType.expertCode}">${codeExperType.expertName}</option>
		                    	</c:forEach>
	                        </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">单位所在区划：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<input type="hidden" class="ipt-txt" name="agentAreaArr" id="agentArea" value=""/>
                            <select id="agentAreaM" multiple="multiple">
		                        <option value="ZJ">省本级</option>
		                        <option value="H">杭州</option>
		                        <option value="N">宁波</option>
		                        <option value="W">温州</option>
		                        <option value="Jx">嘉兴</option>
		                        <option value="Hu">湖州</option>
		                        <option value="S">绍兴</option>
		                        <option value="J">金华</option>
		                        <option value="Q">衢州</option>
		                        <option value="Z">舟山</option>
		                        <option value="T">台州</option>
		                        <option value="L">丽水</option>
		                      </select>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">岗位资格资质：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="stationTermArr" id="stationTerm" value=""/>
	                        <select id="stationTermM" multiple="multiple">
	                            <option value="N">否</option>
<!-- 	                            <option value="Y">是</option> -->
	                            <c:forEach items="${codeRightTypeList}" var="codeRightType">
		                        	<option value="${codeRightType.rightCode}">${codeRightType.rightName}</option>
		                    	</c:forEach>
	                        </select>
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                    <label class="item-name col-5">人员状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select id="stationTermM" name="agentState">
	                            <option value="1">有效</option>
	                            <option value="">全部</option>
	                            <option value="2">失效</option>
	                        </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">单位层级：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<input type="hidden" class="ipt-txt" name="unitLevelArr" id="unitLevel" value=""/>
	                        <select id="unitLevelM" multiple="multiple">
	                            <option value="3">省级</option>
	                            <option value="1">市级</option>
	                            <option value="2">县级</option>
	                            <option value="4">所级</option>
	                        </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="more-show " style="display:none;">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">最高学历：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="studyLevelArr" id="studyLevel" value=""/>
	                        <select id="studyLevelM" multiple="multiple">
	                            <option value="8">小学</option>
	                            <option value="4">初中</option>
	                            <option value="5">高中</option>
	                            <option value="1">大专</option>
	                            <option value="2">本科</option>
	                            <option value="3">研究生</option>
	                            <option value="6">硕士</option>
	                            <option value="7">博士</option>
	                            <option value="9">博士后</option>
	                        </select>
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                    <label class="item-name col-5">年龄：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" name="ageStart">
							</div>
							<span class="item-txt col-2"><i class="line-icon"></i></span>
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" name="ageEnd">
							</div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">业务部门/机构：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" id="unitName" name="unitName"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">执法证：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="lawTypeArr" id="lawType" value=""/>
	                        <select id="lawTypeM" multiple="multiple">
	                            <option value="N">无</option>
	                            <option value="1">有执法证</option>
	                        </select>
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                    <label class="item-name col-5">手机号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="mobile" class="fl ipt-txt">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">担任职务：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="agentPositionArr" id="agentPosition" value=""/>
	                        <select id="agentPositionM" multiple="multiple">
	                            <option value="1" >局领导</option>
	                            <option value="2" >科室（处、办、中心）负责人（正职）</option>
	                            <option value="3" >科室（处、办、中心）负责人（副职）</option>
	                            <option value="4" >所（站、分局）长（正职）</option>
	                            <option value="5" >所（站、分局）长（副职）</option>
	                            <option value="6" >一般干部</option>
	                        </select>
                        </div>
                        </div>
                    </div>
                </div>
            
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">身份证号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" name="agentNO" class="ipt-txt">
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                    <label class="item-name col-5">设置日期：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="setTimeStart">
							</div>
							<span class="item-txt col-2"><i class="line-icon"></i></span>
							<div class="ipt-box col-5">
								<input type="text" class="ipt-txt clx" readonly="readonly" onclick="laydate();" name="setTimeEnd">
							</div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">设置人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="" name="setUserName" class="fl ipt-txt">
                        </div>
                    </div>
                </div>
            </div>
			</div>
            <div class="form-item clearfix mt10">
                <div class="btn-box">
                    <input type="button" value="查 询" id="qry" class="btn mr20">
                    <input type="button" value="重 置" id="cancel"  class="btn mr20">
                    <input type="button" value="更多查询" class="btn mr20 js-more-query">
                </div>
            </div>
        </div>
    </div>
</form>
<div class="clearfix mb5">
    <input type="button" class="btn btn-sm mr5 " id="toAdd" value="添加检查执法人员">
    <input type="button" class="btn btn-sm mr5 " id="toAddExcel" value="导入检查执法人员名单">
    <span style="color: red;">提示：失效人员不纳入检查执法人员抽取范围。</span>
</div>
<div>
    <table border="0" id="scstack-table" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>姓名</th>
            <th>性别</th>
            <th>单位工号</th>
            <th>身份证号</th>
            <th>手机号</th>
            <th>学历</th>
            <th>年龄</th>
            <th>岗位大类</th>
            <th>专家</th>
            <th>岗位状态</th>
            <th>地区</th>
            <th>层级</th>
            <th>部门/机构</th>
            <th>担任职务</th>
            <th>工作单位</th>
            <th>执法证</th>
            <th>有效期</th>
            <th>设置人</th>
            <th>设置日期</th>
        </tr>
        </thead>
    </table>
</div>
</body>
<script id="table-template" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/scagent/scagent_syn_list.js"></script>
</html>