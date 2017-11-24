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
    <title>党员户口查询</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<style type="text/css">
    .commit {
        text-decoration: none;
        color: #003399;
        cursor: pointer;
        font-size: 13px;
    }
</style>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                 <div class="col-4">
                    <label class="item-name col-5">党员姓名：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="memberName" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="uniCodeOrRegNO" value="" placeholder="可输入尾号后四位查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" readonly="readonly" placeholder="请选择管辖单位"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">身份证号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="identityInfo" value="" placeholder=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="可输入名称关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" name="regState" id="regState">
                            <select name="regStateM" id="regStateM" multiple="multiple">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}'>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">企业类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <label><input type="checkbox" name="entCatg" checked="checked" value="1">个体户</label>
                            <label><input type="checkbox" name="entCatg" checked="checked" value="2">私营企业</label>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">是否业主：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <select name="memberType">
                                <option value="">全部</option> 
                                <option value="1">是</option>
                                <option value="2">否</option>
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">是否书记：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                             <select name="isSecretary">
                                <option value="">全部</option> 
                                <option value="1">是</option>
                                <option value="0">否</option>
                             </select>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="form-item clearfix moresearch_oth" style="display:none">
                <div class="col-4">
                    <label class="item-name col-5">党员类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="pmType">
                                <option value="">全部</option> 
                                <option value="1">正式党员</option>
                                <option value="2">预备党员</option>
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">组织关系所在：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                           <select name="orgRelationLoc">
                                <option value="">全部</option> 
                                <option value="1">在本辖区街道、社区、村党组织</option>
                                <option value="2">在本辖个私协会党组织</option>
                                <option value="3">在本辖区市场党组织</option>
                                <option value="4">在原籍党组织的流动党员</option>
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value="" readonly="readonly" placeholder="请选择登记机关"/>
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            
           <div class="form-item clearfix moresearch_oth" style="display:none">
                <div class="col-4">
                    <label class="item-name col-5">党员职务：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="partyPosition">
                                <option value="">全部</option> 
                                <option value="1">普通党员</option>
                                <option value="2">干部</option>
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">所属市场：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                          <input type="text" class="ipt-txt" name="belongMarket" value="" placeholder="请输入关键词查询"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">操作员：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                           <input type="text" class="ipt-txt" name="auditName" value="" placeholder=""/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="form-item clearfix moresearch_oth" style="display:none">
                <div class="col-4">
                    <label class="item-name col-5">党员分布：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="pmDistributed">
                                <option value="">全部</option> 
                                <option value="1">个体</option>
                                <option value="0">市场</option>
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">所属党组织：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="partyOrgID" id="partyOrgID" value=""/>
                            <input type="text" class="ipt-txt" id="partyOrgName" readonly="readonly" placeholder="请选择管辖单位"/>
	                            <span class="add-icon" id="choseOrg">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">建档日期：</label>
                    <div class="col-6">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="createTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="createTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="form-item clearfix moresearch_oth" style="display:none">
                <div class="col-4">
                    <label class="item-name col-5">党员民族：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="nationality">
                                <option value="">全部</option> 
                                <option value="1">汉族</option>
                                <option value="2">其它</option>
                             </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">党员年龄：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon"  name="memberAgeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" name="memberAgeEnd" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">修改日期：</label>
                    <div class="col-6">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="modifyTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="modifyTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="form-item clearfix moresearch_oth" style="display:none">
                <div class="col-4">
                    <label class="item-name col-5">党员学历：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="qualifications">
                              <option value=""></option>
	                          <option value="1">小学</option>
	                          <option value="2">初中</option>
	                          <option value="3">高中</option>
	                          <option value="4">大专</option>
	                          <option value="5">本科</option>
	                          <option value="6">研究生</option>
	                          <option value="7">硕士</option>
	                          <option value="8">博士</option>
	                          <option value="9">博士后</option>
                         </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">党员性别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="sex">
                              <option value=""></option>
	                          <option value="1">男</option>
	                          <option value="2">女</option>
                         </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">入党时间：</label>
                    <div class="col-6">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="joinPartyTimeStart" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt pointer laydate-icon" onclick="laydate()"
                                   readonly="readonly" name="joinPartyTimeEnd" value=""/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group clearfix">
            <div class="center mt10">
                <input type="button" id="search" value="查询" class="btn mr20">
                <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
                <input type="button" value="更多查询条件" status='0' id="moresearch" class="btn mr20">
            </div>
        </div>
    </form>
</div>
 
<div class="iframe-wrap">
    <div class="light-info mb5 mt5">
        <span class="light">提示：此处仅查询已入库建档的党员信息。 <i class="light-box-y mr5"></i>表示党员所在的企业登记状态异常。 </span>
    </div>
    <p class="tip-info left mb5">
        &nbsp;&nbsp;&nbsp;查询结果：党员共&nbsp;<span id="membercount" class="light-blue">0</span>&nbsp;人，
	    &nbsp;其中业主&nbsp;<span id="yzcount" class="light-blue">0</span>&nbsp;人，
	    &nbsp;从业人员&nbsp;<span id="cyrycount" class="light-blue">0</span>&nbsp;人，
	    &nbsp;书记&nbsp;<span id="sjcount" class="light-blue">0</span>&nbsp;人，
	    &nbsp;正式党员&nbsp;<span id="zsdycount" class="light-blue">0</span>&nbsp;人，
	    &nbsp;预备党员&nbsp;<span id="ybcount" class="light-blue">0</span>&nbsp;人。
     </p>	    
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>操作</th>
            <th>修改日期</th>
            <th>党员姓名</th>
            <th>身份证号</th>
            <th>性别</th>
            <th>年龄</th>
            <th>学历</th>
            <th>民族</th>
            <th>入党时间</th>
            <th>是否业主</th>
            <th>是否书记</th>
            <th>户籍所在地</th>
            <th>组织关系所在</th>
            <th>所属市场</th>
            <th>所属党组织</th>
            <th>统一信用代码/注册号</th>
            <th>企业名称</th>
            <th>企业类型</th>
            <th>登记机关</th>
            <th>管辖单位</th>
            <th>登记状态</th>
            <th>建档日期</th>
            <th>操作员</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/partycreate/party_member_search_list.js"></script>
</body>
</html>