<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>严违失信名单查询</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="form-box pd14-mr">
   <form id="hx-form">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt clx" name="regNO" >
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">企业名称：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt clx" name="entName">
                    </div> 
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5"><span class="long-label">法定代表人/负责人：</span></label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt clx" name="leRep">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">列入严违状态：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <select name="addSecState" class="clx">
                            <option value="">全部</option>
                            <option value="未移出">未移出</option>
<!--                             <option value="届满移出">届满移出(已移出)</option> -->
<!--                             <option value="更正移出">更正移出(已移出)</option> -->
<!--                             <option value="撤销移出">撤销移出(已移出)</option> -->
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">列入异常原因：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt clx" name="speCause" id="speCause" value=""/>
                            <input type="text" class="ipt-txt text-over clx" readonly="readonly" id="SpeCauseCN" value="" placeholder="请选择列入异常原因"/>
	                            <span class="add-icon" id="chosespeCause">
	                                <i></i>
	                            </span>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">企业管理部门：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt clx" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt clx" readonly="readonly" id="localAdmName" value="" placeholder="请选择企业管理部门"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
<!--                 <label class="item-name col-5">公示状态：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <select name="publicState" class="clx"> -->
<!--                             <option value="">全部</option> -->
<!--                             <option value="0">未认领</option> -->
<!--                             <option value="1">已认领</option> -->
<!--                         </select> -->
<!--                     </div> -->
<!--                 </div> -->
   			<label class="item-name col-5">严违失信类型：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <select name="secDishonestyType" class="clx">
                            <option value="">全部</option>
                            <option value="异常届满">异常届满</option>
                            <option value="被撤销登记">被撤销登记</option>
                            <option value="传销违法">传销违法</option>
                            <option value="直销违法">直销违法</option>
                            <option value="不正当竞争">不正当竞争</option>
                            <option value="侵害消费者权益">侵害消费者权益</option>
                            <option value="发布虚假广告">发布虚假广告</option>
                            <option value="商标侵权">商标侵权</option>
                            <option value="累计违法">累计违法</option>
                            <%--<option value="商标代理">商标代理</option>--%>
                            <%--<option value="其它法律规定">其它法律规定</option>--%>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
<!--                 <label class="item-name col-5">移出严违原因：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <select name=""> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                         </select> -->
<!--                     </div> -->
<!--                 </div> -->
                <label class="item-name col-5">列入严违日期：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <div class="ipt-box col-575">
                            <input type="text" readonly="readonly" class="ipt-txt laydate-icon clx" onclick="laydate();" name="addSecDateStart">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" readonly="readonly" class="ipt-txt laydate-icon clx" onclick="laydate();" name="addSecDateEnd">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4">
<!--                 <label class="item-name col-5">列入严违机关：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <select name="addSecOrg" class="clx"> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                         </select> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">登记状态：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                            <select name="regState" id="regState" class="clx">
                                <option value="">全部</option>
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}'>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
<!--                 <label class="item-name col-5"> 延期严违原因：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <select name=""> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                         </select> -->
<!--                     </div> -->
<!--                 </div> -->

           
            </div>
            <div class="col-4">
<!--                 <label class="item-name col-5">移出严违机关：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <select name=""> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                         </select> -->
<!--                     </div> -->
<!--                 </div> -->

            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
<!--                 <label class="item-name col-5">严违失信类型：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <select name="secDishonestyType" class="clx"> -->
<!--                             <option value="">全部</option> -->
<!--                             <option value="">异常届满</option> -->
<!--                             <option value="">被撤销登记</option> -->
<!--                             <option value="">传销违法</option> -->
<!--                             <option value="">直销违法</option> -->
<!--                             <option value="">不正当竞争</option> -->
<!--                             <option value="">侵害消费者权益</option> -->
<!--                             <option value="">发布虚假广告</option> -->
<!--                             <option value="">商标侵权</option> -->
<!--                             <option value="">累计违法</option> -->
<!--                             <option value="">商标代理</option> -->
<!--                             <option value="">其它法律规定</option> -->
<!--                         </select> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
            <div class="col-4">
<!--                 <label class="item-name col-5">列入严违日期：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <div class="ipt-box col-575"> -->
<!--                             <input type="text" class="ipt-txt laydate-icon clx" onclick="laydate();" name="addSecDateStart"> -->
<!--                         </div> -->
<!--                         <span class="item-line col-05">-</span> -->
<!--                         <div class="ipt-box col-575"> -->
<!--                             <input type="text" class="ipt-txt laydate-icon clx" onclick="laydate();" name="addSecDateStartEnd"> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
            <div class="col-4">
<!--                 <label class="item-name col-5">延期严违机关：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <select name=""> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                         </select> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
<!--                 <label class="item-name col-5"><span class="long-label">列入/移出严违文号：</span></label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <select name="addSecNo" class="clx"> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                         </select> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
            <div class="col-4">
<!--                 <label class="item-name col-5">移出严违日期：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <div class="ipt-box col-575"> -->
<!--                             <input type="text" class="ipt-txt laydate-icon" onclick="laydate();"> -->
<!--                         </div> -->
<!--                         <span class="item-line col-05">-</span> -->
<!--                         <div class="ipt-box col-575"> -->
<!--                             <input type="text" class="ipt-txt laydate-icon" onclick="laydate();"> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
            <div class="col-4">
<!--                 <label class="item-name col-5">严违届满日期：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <div class="ipt-box col-575"> -->
<!--                             <input type="text" class="ipt-txt laydate-icon" onclick="laydate();"> -->
<!--                         </div> -->
<!--                         <span class="item-line col-05">-</span> -->
<!--                         <div class="ipt-box col-575"> -->
<!--                             <input type="text" class="ipt-txt laydate-icon" onclick="laydate();"> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
<!--                 <label class="item-name col-5">延期严违日期：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <div class="ipt-box col-575"> -->
<!--                             <input type="text" class="ipt-txt laydate-icon" onclick="laydate();"> -->
<!--                         </div> -->
<!--                         <span class="item-line col-05">-</span> -->
<!--                         <div class="ipt-box col-575"> -->
<!--                             <input type="text" class="ipt-txt laydate-icon" onclick="laydate();"> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
            <div class="col-4">
<!--                 <label class="item-name col-5">是否延期严违：</label> -->
<!--                 <div class="col-7"> -->
<!--                     <div class="ipt-box col-12"> -->
<!--                         <select name=""> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                             <option value=""></option> -->
<!--                         </select> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
            <div class="col-4">

            </div>
        </div>

        <div class="center mt10">
            <div class="btn-box">
                <input type="button" id="search" value="查 询" class="btn mr20">
                <input type="button" id="reset" value="重 置" class="btn mr20">
            </div>
        </div>
    </div>
   </form>
</div>
<div class="light-info mb5 mt5">
    <span class="light">提示：查询范围仅限截止当前已审核通过的严重违法失信名单列入、延期及移出记录。</span>
</div>
<div class="clearfix mb5">
<!--     <span class="light-yellow fr mt5">查询结果：严违失信企业0家，列入严违失信记录0条，其中未移出0条，已移出0条，移出记录中届满移出0条，更正移出0条，撤销移出0条。</span> -->
</div>
<div>
<table id="search-table" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap"> 
       <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>统一代码</th>
            <th>注册号</th>
            <th>企业名称</th>
            <th>法定代表人/负责人</th>
            <th>列入严违状态</th>
            <th>严违失信类型</th>
            <th>列入严违原因</th>
            <th>列入严违日期</th>
            <th>列入严违文号</th>
            <th>列入严违机关</th>
            <th>登记状态</th>
            <th>企业管理部门</th>
            <th>列入异常原因</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/secnocreditmanage/secnocreditsearch/secnocreditsearch_list.js"></script>
</body>
</html>