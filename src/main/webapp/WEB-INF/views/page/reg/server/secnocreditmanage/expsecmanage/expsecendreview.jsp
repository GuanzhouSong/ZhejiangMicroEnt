<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>异常类严违名单列入审核</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="form-box pd14-mr">
<form id="searchForm" class="searchForm">
<input type="hidden" name="endreview" value="endreview" />
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">
                        <span class="long-label">统一信用代码/注册号：</span>
                    </label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clearall" name="regNO">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clearall" name="entName">
                        </div>
                    </div>
                </div>
                 <div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="regState" id="regState" class="clearall">
                                <option value="">全部</option>
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}'>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <!-- 
                <div class="col-4">
                    <label class="item-name col-5">业务类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="businessType" class="clearall">
                                <option value="">全部</option>
                                <option value="1">提醒公告</option>
                                <option value="2">列入</option>
                                <option value="3">届满移出</option>
                                <option value="4">届满延期</option>
                                <option value="5">更正移出</option>
                            </select>
                        </div>
                    </div>
                </div>
                 -->
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">
                        <span class="long-label">法定代表人/负责人：</span>
                    </label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clearall" name="leRep">
                        </div>
                    </div>
                </div>
                
<!--                 <div class="col-4"> -->
<!--                     <label class="item-name col-5">移出严违原因：</label> -->
<!--                      <div class="col-7"> -->
<!--                         <div class="ipt-box col-12"> -->
<!--                             <select name="publicState" class="clearall"> -->
<!--                                 <option value="">全部</option> -->
<!--                                 <option value="0">未认领</option> -->
<!--                                 <option value="1">已认领</option> -->
<!--                             </select> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
                <div class="col-4">
                    <label class="item-name col-5">初审人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clearall" name="firstName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业管理部门：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt clearall" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt clearall" readonly="readonly" id="localAdmName" value="" placeholder="请选择企业管理部门"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">业务状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="businessStatus" class="clearall">
                                <option value="">全部</option>
                                <!-- <option value="0">待列入</option>
                                <option value="1">待初审</option>
                                <option value="2">初审不通过</option> -->
                                <option value="3">待审核</option>
                                <option value="4">审核通过</option>
                                <option value="5">审核不通过</option>
                                <!-- <option value="6">待移出</option>
                                <option value="7">待延期</option>
                                <option value="8">异常将届满</option> -->
                            </select>
                        </div>
                    </div>
                </div>
<!--                 <div class="col-4"> -->
<!--                     <label class="item-name col-5">延期严违原因：</label> -->
<!--                     <div class="col-7"> -->
<!--                         <div class="ipt-box col-12"> -->
<!--                             <input type="text" class="ipt-txt clearall" name=""> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
                <div class="col-4">
                    <label class="item-name col-5">审核人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clearall" name=auditName>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">列入严违原因：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clearall" name="addSecCause" >
                        </div>
                    </div>
                </div>

            </div>
            <div class="form-item clearfix">
				<div class="col-4">
                    <label class="item-name col-5">经办人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clearall" name="applyMan">
                        </div>
                    </div>
                </div>
                
                 <div class="col-4">
                    <label class="item-name col-5">申请日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clearall" readonly="readonly" onclick="laydate()"
                                   name="applyDateStart" value="">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clearall" readonly="readonly" onclick="laydate()"
                                   name="applyDateEnd" value="">
                        </div>
                    </div>
                </div>
                
                <div class="col-4">
                    <label class="item-name col-5">列入严违期限：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clearall" readonly="readonly" onclick="laydate()"
                                   name="addSecTermStart" value="">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clearall" readonly="readonly" onclick="laydate()"
                                   name="addSecTermEnd" value="">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
               
<!--                 <div class="col-4"> -->
<!--                     <label class="item-name col-5">移出严违期限：</label> -->
<!--                     <div class="col-7"> -->
<!--                         <div class="ipt-box col-575"> -->
<!--                             <input type="text" class="ipt-txt laydate-icon clearall" readonly="readonly" onclick="laydate()" -->
<!--                                    name="" value=""> -->
<!--                         </div> -->
<!--                         <span class="item-line col-05">-</span> -->
<!--                         <div class="ipt-box col-575"> -->
<!--                             <input type="text" class="ipt-txt laydate-icon clearall" readonly="readonly" onclick="laydate()" -->
<!--                                    name="" value=""> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
                <div class="col-4">
                    <label class="item-name col-5">初审日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clearall" readonly="readonly" onclick="laydate()"
                                   name="firstdateStart" value="">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clearall" readonly="readonly" onclick="laydate()"
                                   name="firstdateEnd" value="">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">审核日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clearall" readonly="readonly" onclick="laydate()"
                                   name="auditDateStart" value="">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clearall" readonly="readonly" onclick="laydate()"
                                   name="auditDateEnd" value="">
                        </div>
                    </div>
                </div>
            </div>
            <!-- <div class="form-item clearfix">
               <div class="col-4 apply_in">
                    <label class="item-name col-5">公示状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="publicState" >
                                <option value="">全部</option>
                                <option value="0">未认领</option>
                                <option value="1">已认领</option>
                            </select>
                        </div>
                    </div>
                </div>
				
            </div>  -->
            
            <div class="form-item">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="button" id="reset" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </form>
</div>
<div class="light-info mt5">
    <span class="light">提示：初审不通过信息将退回至经办人，初审通过信息进入异常类严违名单待审核列表。点击“详情”与“打印”可查看与打印企业异常类严违名单相关资料。</span>
</div>
<div class="clearfix mb5 mt5">
    <span class="light-yellow fr mt5">查询结果：待审核<span id="dshNum"></span>条，审核不通过<span id="shbtgNum"></span>条，审核通过<span id="cstgNum"></span>条</span>
</div>

<div class="table-out">
    <div class="iframe-wrap">
        <table id="qua-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30"
               style="white-space: nowrap;width: 100%;">
            <thead>
            <tr>
                <th width="5%">序号</th>
                <th>操作</th>
                <th>统一代码/注册号</th>
                <th>企业名称</th>
                <th>法定代表人/负责人</th>
                <th>业务类型</th>
                <th>业务状态</th>
                <th>列入严违原因</th>
                <th>列入严违期限</th>
               <!--  <th>公示状态</th> -->
                <th>登记状态</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/secnocreditmanage/expsecmanage/expsecendreview.js"></script>
</body>
</html>