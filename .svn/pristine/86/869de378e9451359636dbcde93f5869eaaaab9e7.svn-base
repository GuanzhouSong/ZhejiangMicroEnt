<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date"%>
<!doctype html>
<html lang="en">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政指导新增</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body class="pd10">
<div class="form-box">
<form id="qryForm">
    <div class="form-list">
       <div class="form-item clearfix">
       				<div class="col-4">
       					<label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
       					<div class="col-6">
       						<div class="ipt-box col-12">
       							<input type="text" class="ipt-txt" name="cidRegNO">
       						</div>
       					</div>
       				</div>
       				<div class="col-4">
       					<label class="item-name col-5">企业名称：</label>
       					<div class="col-6">
       						<div class="ipt-box col-12">
       							<input type="text" class="ipt-txt" name="entName">
       						</div>
       					</div>
       				</div>
       				<div class="col-4">
       					<label class="item-name col-5">法定代表人：</label>
       					<div class="col-6">
       						<div class="ipt-box col-12">
       							<input type="text" class="ipt-txt" name="leRep">
       						</div>
       					</div>
       				</div>
       			</div>
       			<div class="form-item clearfix">
       				<div class="col-4">
       					<label class="item-name col-5">行业：</label>
       					<div class="col-6">
       						<div class="ipt-box col-12">
       			                 <input type="text"  id="industryCoName"  class="ipt-txt clx" value="" readonly/>
       			                 <input type="hidden" id="industryCo" name="industryCo" class="clx" value="" />
       				                 <a id="selectIndustry" class="link js-show">
       			                  <span class="add-icon" id="choseIndustryCo"><i></i></span>
       			                 </a>
       	            		</div>
       					</div>
       				</div>
       				<div class="col-4">
       					<label class="item-name col-5"> 企业类型：</label>
       					<div class="col-6">
       						<div class="ipt-box col-12">
       			                 <input type="text"  id="entTypeName"  class="ipt-txt clx" value="" readonly/>
       			                 <input type="hidden" id="entType" name="entType" class="clx" value="" />
       				                 <a id="selectEntType" class="link js-show">
       			                  <span class="add-icon" id="choseEntType"><i></i></span>
       			                 </a>
       	            		</div>
       					</div>
       				</div>
       				<div class="col-4">
       					<label class="item-name col-5"> 住所：</label>
       					<div class="col-6">
       						<div class="ipt-box col-12">
       							<input type="text" class="ipt-txt" name="dom">
       						</div>
       					</div>
       				</div>
       			</div>
       			<div class="form-item clearfix">
       				<div class="col-4">
       					<label class="item-name col-5">管辖单位：</label>
       					<div class="col-6">
       						<div class="ipt-box col-12">
       			                 <input type="text"  id="localAdmName"  class="ipt-txt clx" value="" readonly/>
       			                 <input type="hidden" id="localAdm" name="localAdm" class="clx" value="" />
       				                 <a id="selectLocalAdm" class="link js-show">
       			                  <span class="add-icon" id="choseregUnit"><i></i></span>
       			                 </a>
       	            		</div>
       					</div>
       				</div>
       				<div class="col-4">
       					<label class="item-name col-5">登记机关：</label>
       					<div class="col-6">
       						<div class="ipt-box col-12">
       			                 <input type="text"  id="regOrgName"  class="ipt-txt clx" value="" readonly/>
       			                 <input type="hidden" id="regOrg" name="regOrg" class="clx" value="" />
       				                 <a id="selectRegOrg" class="link js-show">
       			                  <span class="add-icon" id="choseorgReg"><i></i></span>
       			                 </a>
       	            		</div>
       					</div>
       				</div>
       				<div class="col-4">
       					<label class="item-name col-5">经营范围：</label>
       					<div class="col-6">
       						<div class="ipt-box col-12">
       							<input type="text" class="ipt-txt" name="opScope">
       						</div>
       					</div>
       				</div>
       			</div>
       <!-- 更多查询条件------------------------------------------------------------------------------------------------------ -->
        <div class="form-item-more" style="display:none">
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">成立日期：</label>
                        <div class="col-6">
                            <div class="ipt-box col-5">
                                <input type="text" class="ipt-txt laydate-icon clx" readonly="readonly" onclick="laydate();" name="estDateStart">
                            </div>
                            <span class="item-txt col-2"><i class="line-icon"></i></span>
                            <div class="ipt-box col-5">
                                <input type="text" class="ipt-txt laydate-icon clx" readonly="readonly" onclick="laydate();" name="estDateEnd">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">核准日期：</label>
                        <div class="col-6">
                            <div class="ipt-box col-5">
                                <input type="text" class="ipt-txt laydate-icon clx" onclick="laydate();" readonly="readonly" name="apprDateStart">
                            </div>
                            <span class="item-txt col-2"><i class="line-icon"></i></span>
                            <div class="ipt-box col-5">
                                <input type="text" class="ipt-txt laydate-icon clx" onclick="laydate();" readonly="readonly" name="apprDateEnd">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">营运状况：</label>
                        <div class="col-6">
                            <div class="ipt-box col-12">
                                <select name="regState">
                                    <c:forEach var="regState" items="${regStateEnumMap}">
                                    	<c:if test="${regState.value == 'CUNXU' ||  regState.value == 'DIAOXIAO'}">
                                		<option value='${regState.value.code}'>${regState.value.name}</option>
                                		</c:if>
                            		</c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">许可证名称：</label>
                        <div class="col-6">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" name="licNameAft">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">是否有风险预警：</label>
                        <div class="col-6">
                            <div class="ipt-box col-12">
                                <select name="isRiskWarn">
                                    <option value="">请选择</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5"> 注册资本（万元）：</label>
                        <div class="col-6">
                            <div class="ipt-box col-12">
                                <div class="ipt-box col-5">
                                    <input type="text" class="ipt-txt" name="regCapStart" placeholder="单位（万元）">
                                </div>
                                <span class="item-txt col-2"><i class="line-icon"></i></span>
                                <div class="ipt-box col-5">
                                    <input type="text" class="ipt-txt" name="regCapEnd"placeholder="单位（万元）">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">信用等级：</label>
                        <div class="col-6">
                            <div class="ipt-box col-12">
                                <select name="">
                                    <option value="">暂无数据</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">是否有行政处罚：</label>
                        <div class="col-6">
                            <div class="ipt-box col-12">
                                <select name="isCase">
                                    <option value="">请选择</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">是否进入异常名录</label>
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
                </div>

                <div class="form-item clearfix">
                    <div class="col-4">
                        <label class="item-name col-5">法人是否受限：</label>
                        <div class="col-6">
                            <div class="ipt-box col-12">
                                <select name="leRepIsLim">
                                    <option value="">请选择</option>
                                    <option value="Y">是</option>
                                    <option value="N">否</option>
                                </select>
                            </div>
                        </div>
                    </div>

                </div>
        </div>
         <p class="center">
          <span class="js-fold fold-icon">
              展开更多查询条件
          </span>
          </p>
  <!-- 更多查询条件 end -------------------------------------------------------------------------------------------------------- -->

        <div class="form-item clearfix">
            <div class="btn-box">
                <input id="qry"  type="button" value="查 询" class="btn mr20">
                <input id="cancel"type="button" value="重 置" class="btn mr20">
            </div>
        </div>
    </div>
    </form>
</div>

<div class="clearfix mb5 mt5">
    <p class="fl"><input id="return" type="button" class="btn btn-sm mr5 js-return" value="返回">
    <input type="button" class="btn btn-sm mr5 js-add" value="增加行政指导">
    <%--<input type="button" class="btn btn-sm " value="导出">--%>
    </p>
</div>
<div>
    <table id="user-table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 "width="100%">

        <thead>
        <tr>
           <th width="7%">序号</th>
           <th width="5%">单选</th>
           <th>统一信用代码/注册号</th>
           <th>企业名称 </th>
           <th width="7%"> 法定代表人 </th>
           <th>企业类型</th>
           <th> 行业</th>
           <th>住所</th>
           <th>登记机关</th>
           <th>管辖单位</th>
        </tr>
        </thead>
    </table>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/govguide/govguideadd_list.js"></script>
</body>
</html>
