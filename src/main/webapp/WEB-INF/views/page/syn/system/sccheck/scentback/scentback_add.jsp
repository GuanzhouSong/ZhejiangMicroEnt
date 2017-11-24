<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>添加检查对象</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
     <link rel="stylesheet" href="/css/reg.server.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
<!--     <LINK REL="STYLESHEET" HREF="/CSS/VENDOR/BOOTSTrap.min.css"> -->
</head>
<body class="pd10">
<div class="form-box mb5">
    <div class="form-list">
    	<form id="paramForm">
    	<input type="hidden" value="${taskUid }" id="taskUid" name="taskUid"/>
    	<input type="hidden" id="userType" value="${sysUser.userType}"> 
    	</form>
    	<form id="searchForm">
    	<input type="hidden" value="${taskUid }" id="taskUid" name="taskUid"/>
        <div class="form-item clearfix">
        	<div class="col-4">
				<label class="item-name col-5">企业名称：</label>
				<div class="col-6">
					<div class="ipt-box col-12">
						<input type="text" class="ipt-txt clx" name="entName" placeholder="可输入名称关键词查询">
					</div>
				</div>
			</div>
			<div class="col-4">
				<label class="item-name col-5">统一信用代码/注册号：</label>
				<div class="col-6">
					<div class="ipt-box col-12">
						<input type="text" class="ipt-txt clx" name="cidRegNO" placeholder="可输入尾号后4位查询">
					</div>
				</div>
			</div>
			 <div class="col-4">
                <label class="item-name col-5">登记机关：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" id="regOrgName" readonly="readonly" class="fl ipt-txt" placeholder="选择"/>
                            <span class="add-icon" id="selectRegOrg">
                                <i></i>
                            </span>
                            <input type="hidden" id="regOrg" name="regOrg">
                    </div>
                </div>
            </div>
         </div>
         <div class="form-item clearfix">
         	<div class="col-4">
                <label class="item-name col-5">检查主体类型：</label>
                <div class="col-7">
                    <div class="radio-box f12">
                    	<input type="hidden" name="regState" value="K,B,A,DA,X,Q">
                        <input type="hidden" name="entTypeCatg" id="entTypeCatg" value="11,13,31,33,12,14,32,34,21,27,24,22,28,16,17,50,23"/>
                        <input type="checkbox" name="entCatg"  value="11,13,31,33,12,14,32,34,21,27,24,22,28" checked="checked">企业
                        <input type="checkbox" name="entCatg" value="16,17" checked="checked">农专社
                        <input type="checkbox" name="entCatg" value="50" checked="checked">个体户
                        <input type="checkbox" name="entCatg" value="23" checked="checked">外企代表机构
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">成立日期：</label>
                <div class="col-7">
                    <div class="ipt-box col-4">
                        <input type="text" class="ipt-txt" readonly="readonly" id="estDateStart" name="estDateStart"/>
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-4">
                        <input type="text" class="ipt-txt" readonly="readonly" id="estDateEnd" name="estDateEnd"/>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">管辖单位：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="fl ipt-txt" readonly="readonly" id="localAdmName" placeholder="选择"/>
                            <span class="add-icon" id="selectLocalAdm">
                                <i></i>
                            </span>
                            <input type="hidden" name="localAdm" id="localAdm">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">行业：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" id="industryName" readonly="readonly" class="fl ipt-txt" placeholder="选择"/>
                            <span class="add-icon" id="selectIndustry">
                                <i></i>
                            </span>
                            <input type="hidden" name="industryCo" id="industryCo">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">注册资本：</label>
                <div class="col-6">
                    <div class="ipt-box col-5">
                        <input type="text" id="regCapStart" name="regCapStart" placeholder="单位（万元）" class="ipt-txt"/>
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" id="regCapEnd" name="regCapEnd"  placeholder="单位（万元）" class="ipt-txt"/>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">经营范围：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" name="opScope" class="ipt-txt"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">信用等级：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                       <select name="creLevel">
                       <option value="">暂无数据</option>
                       </select>
                       <!--  <select name="creLevel">
                            <option value="">全部</option>
                            <option value="1">一级</option>
                            <option value="2">二级</option>
                            <option value="3">三级</option>
                        </select> -->
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">实缴实缴制企业：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                    <select name="creLevel">
                       <option value="">暂无数据</option>
                       </select>
                       <!--  <select name="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select> -->
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4">行政处罚：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <select name="isCase">
									<option value="">请选择</option>
									<option value="Y">是</option>
									<option value="N">否</option>
								</select>
                    </div>
                </div>
            </div>
<!--             <div class="col-4">
                <label class="item-name col-4 rel-top-16">行政许可：</label>
                <div class="col-7">
                    <div class="col-4 mt6"><label><input type="checkbox"/>前置</label></div>
                    <div class="ipt-box col-8">
                        <select name="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div> -->
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">重点监管对象：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="isIndRegObjName">
                            <option value="">请选择</option>
                            <option value="Y">是</option>
                            <option value="N">否</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">关注服务对象：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="isFocusObjName">
                            <option value="">请选择</option>
                            <option value="Y">是</option>
                            <option value="N">否</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name rel-top-16 col-4">年报情况：</label>
                <div class="col-7">
                    <div class="col-4 item-name">年度：</div>
                    <div class="ipt-box col-8">
                        <select name="yrYear"  id="reportYear">
                            <option value=""></option>
		                 	<c:forEach items="${yearList}" var="year" varStatus="status">
		                 		<option value="${year}">${year}</option>
		                 	</c:forEach>
                        </select>
                    </div>
                </div>
            </div>
<!--             <div class="col-4">
                <label class="item-name col-4"></label>
                <div class="col-7">
                    <div class="col-4 mt6"><label><input type="checkbox"/>后置</label></div>
                    <div class="ipt-box col-8">
                        <select name="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div> -->
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">是否进入异常名录：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                       <select name="isOpan">
							 <option value="">请选择</option>
							 <option value="Y">是</option>
							 <option value="N">否</option>
						</select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">是否有风险预警：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="markClass" class="clx">
                            <option value="">请选择</option>
							 <option value="Y">是</option>
							 <option value="N">否</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-4"></label>
                <div class="col-7">
                    <div class="col-4 item-name">年报状态：</div>
                    <div class="ipt-box col-8">
                      <select name="yrIsRep" >
                        <option value=""></option>
                        <option value="0">未年报</option>
                        <option value="1">已年报</option>
                        <option value="2">已年报（逾期）</option>
                      </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">一年内是否被抽查：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="spotDate">
                            <option value="">请选择</option>
                            <option value="Y">是</option>
                            <option value="N">否</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-5">
                <label class="item-name col-4">住所：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" name="dom" class="ipt-txt"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix mb10">
        </div>
        <div class="form-item clearfix">
            <div class="center">
                <input type="button" value="查 询" id="search" class="btn mr20"/>
                <input type="button" value="重 置" id="cancel" class="btn"/>
            </div>
        </div>
    </div>
</div>
</form>
<div>
    <table border="0" id="list-table" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30 nowrap">
        <thead>
        <tr>
            <th style="padding:0 20px;">序号</th>
            <th><label><input type="checkbox" id="checkboxallid"/>全选（当前页）</label></th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人</th>
            <th>联系电话</th>
            <th>联络员</th>
            <th>联络员电话</th>
            <th>成立日期</th>
            <th>企业类型</th>
        </tr>
        </thead>
    </table>
</div>
<div class="center">
    <input type="button" value="加入抽取库" id="add" class="btn mr20"/>
<!--     <input type="button" value="全选加入抽取库" id="addAll" class="btn mr20"/> -->
    <input type="button" value="返回" id="close" class="btn"/>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scentback/scentback_add.js"></script>
</body>
</html>