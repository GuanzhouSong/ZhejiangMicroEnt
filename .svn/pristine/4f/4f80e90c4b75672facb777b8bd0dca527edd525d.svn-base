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
    <title>经营异常状态查询</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<form id="taskForm">
    <div class="form-box pdr8">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="regNO" value="" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">法定代表人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep" value=""/>
                        </div>
                    </div>
                </div>
            </div>
                           <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="hidden_input" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value="" placeholder="选择" readonly="readonly"/>
	                            <span class="add-icon" id="choseorgReg">
	                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="hidden_input" name="localAdm" id="localAdm" value=""/>
                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="选择" readonly="readonly"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">抽检机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" name="checkDep" id="checkDep" value="" class="hidden_input"/>
                            <input type="text" class="fl ipt-txt" id="checkDepName" value="" placeholder="选择" readonly="readonly"
                                   style="height: 30px;widthcursor: pointer;"/>
                            <span class="add-icon" id="choseCheckDep"><i></i></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">标记原因：</label>
                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <input type="hidden" class="hidden_input" name="excpStaRes" id="excpStaRes" value=""/>
	                            <input type="text" class="ipt-txt text-over" value="" placeholder="请选择标记原因" id="excpStaResText" readonly="readonly"/>
	                            <span class="add-icon" id="select-intercept-in">
	                                <i></i>
	                            </span> 
	                        </div> 
                        </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">标记日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon pointer" readonly="readonly"
                                   name="startCogDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon pointer" readonly="readonly"
                                   name="endCogDate" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">成立日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon pointer" readonly="readonly"
                                   name="startEstDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon pointer" readonly="readonly"
                                   name="endEstDate" value=""/>
                        </div>
                    </div>
                </div>
            </div>
               <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">恢复原因：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                           <input type="hidden" class="hidden_input" name="norRea" id="norRea" value=""/>
                           <input type="text" class="ipt-txt text-over" value="" placeholder="请选择恢复原因" id="norReaText" readonly="readonly"/>
                           <span class="add-icon" id="select-intercept-out">
                               <i></i>
                           </span> 
                       </div>                       
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">恢复日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon pointer" readonly="readonly"
                                   name="startNorDate" value=""/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon pointer" readonly="readonly"
                                   name="endNorDate" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">作出决定机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="decorgCN" value=""/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">标记状态：</label>
                    <div class="col-7">
                         <div class="ipt-box col-11">
                            <select name="isRecovery">
                                <option value="">全部</option>
                                <option value="0">已恢复</option>
                                <option value="1">未恢复</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">年度：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="year" id="year">
                                <option value="">全部</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="center mt10">
                <div class="btn-box">
                    <input type="button" id="search" value="查 询" class="btn mr20">
                    <input type="reset" id="reset" value="重 置" class="btn">
                </div>
            </div>
        </div>
    </div>
</form>

<div class="iframe-wrap mt10">
    <div class="light-info mb5 mt5">
        <p class="light">提示：查询范围仅限截止当前有过标记异常记录的在册个体工商户，包含已注销、吊销的个体户信息。</p>
    </div>
    <p class="info-tip mb5">查询结果：
        标记记录企业<span id="entCount" class="light-blue">0</span>家,
        其中标记未恢复企业<span id="markEntCount" class="light-blue">0</span>家,
        标记已恢复企业<span id="renewEntCount" class="light-blue">0</span>家。
    </p>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row"
           style="width: 100%;white-space: nowrap;" cellspacing="0">
        <thead>
        <tr>
            <th style="padding:0 20px;">序号</th>
            <th>注册号</th>
            <th>企业名称</th>
            <th>经营者</th>
            <th>成立日期</th>
            <th>住所</th>
            <th>标记原因</th>
            <th>标记日期</th>
            <th>恢复原因</th>
            <th>恢复日期</th>
            <th>作出决定机关</th>
            <th>登记机关</th>
            <th>管辖单位</th>
            <th>责任区</th>
        </tr>
        </thead>
    </table>
</div>
<script>
    window._CONFIG = {
       year:'${year}', 
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pbopanomaly/pbopanomalysearch/list_main.js"/>"></script>
</body>
</html>
