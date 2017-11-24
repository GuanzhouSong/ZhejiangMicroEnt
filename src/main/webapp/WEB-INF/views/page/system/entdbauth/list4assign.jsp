<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>企业数据权限-指定分配</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">

<div class="tabbale" data-component="tab">
    <form id="entSearchForm"  class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">统一代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regNO" value="" placeholder="请输入注册号">
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" value="" placeholder="请输入企业名称"/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">法定代表人：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" name="leRep" value="" placeholder="请输入法定代表人"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value="" />
                            <input type="text" class="ipt-txt" id="regOrgName" value="" placeholder="请选择登记机关"/>
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
                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value="" />
                            <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="请选择管辖单位"/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5">片区：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="sliceNo" id="sliceNo" value="" />
                            <input type="text" class="ipt-txt" id="sliceNoName" value="" placeholder="请选择片区"/>
	                         <span class="add-icon" id="chooseSliceNo">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4" >
                    <label class="item-name col-5">联系电话：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="tel" value="" placeholder="请输入联系电话"/>
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="regState">
                                <option value="">全部</option>
                                <option value="K">存续</option>
                                <option value="B">备案</option>
                                <option value="DA">吊销未注销</option>
                                <option value="D">吊销已注销</option>
                                <option value="Q">撤销</option>
                                <option value="X">注销</option>
                                <option value="C">迁出</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5">企业类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" class="ipt-txt" name="entType" id="entType" value=""/>
                            <input type="text" class="ipt-txt" id="entTypeName" value="" placeholder="请选择企业类型"/>
	                         <span class="add-icon" id="chooseEntType">
                                <i></i>
	                         </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4" >
                    <label class="item-name col-5">成立日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" name="startEstDate" value="" />
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                           <input type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" name="endEstDate" value="" />
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5">注册资本：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"  name="startRegCap" value="" class="ipt-txt laydate-icon"/>
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt"  name="endRegCap" value="" class="ipt-txt laydate-icon"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="center mt10">
            <input type="button"  id="search" value="查询" class="btn mr20">
            <input type="button"  id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn mr20">
        </div>
    </form>
    <div class="clearfix mb5 mt5">
        <p class="fl">
            <input type="button" class="btn btn-sm mr5 enadd js-add" id="assign" value="指定分配">
        </p>
    </div>
</div>
<div class="table-out">
    <table id="entTable" border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <thead>
        <tr>
            <th>序号</th>
            <th>全选<br/><input type='checkbox' id='checkAll'></th>
            <th>统一代码/注册号</th>
            <th>企业名称</th>
            <th>法定代表人</th>
            <th>法人代表手机号码</th>
            <th>成立日期</th>
            <th>企业类型</th>
            <th>住所地</th>
            <th>登记机关</th>
            <th>管辖单位</th>
            <th>年检机关</th>

        </tr>
        </thead>
    </table>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/entdbauth/list4assign.js"></script>
</body>
</html>
