<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>短信群发</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body class="pd10">
<div class="form-box pd14-mr">
    <form id="qryForm">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5"><span class="long-label">统一信用代码/注册号：</span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="cidRegNO">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">年报年度：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="yrYear" id="yrYear"class="notReset">
                                <option value="2017" selected>2017</option>
                                <option value="2016" >2016</option>
                                <option value="2015">2015</option>
                                <option value="2014">2014</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">成立日期：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clx" readonly="readonly" onclick="laydate();"
                                   name="estDateStart">
                        </div>
                        <span class="item-line col-05">-</span>
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon clx" readonly="readonly" onclick="laydate();"
                                   name="estDateEnd">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">年度年报状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="yrIsRep" id="yrIsRep" class="notReset">
                                <option value="Y" selected>已年报</option>
                                <option value="N">未年报</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">当前年报状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="yrRepState">
                                <option value="">请选择</option>
                                <option value="00">未公示</option>
                                <option value="10">已公示</option>
                                <option value="12">敏感词待审核</option>
                                <option value="13">敏感词不通过</option>
                                <option value="11">敏感词通过</option>
                                <option value="20">待修改</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" id="localAdmName" class="ipt-txt clx" value="" readonly/>
                            <input type="hidden" id="localAdm" name="localAdm" class="clx" value=""/>
                            <a id="selectLocalAdm" class="link js-show">
                                <span class="add-icon" id="choseregUnit"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" id="regOrgName" class="ipt-txt clx" value="" readonly/>
                            <input type="hidden" id="regOrg" name="regOrg" class="clx" value=""/>
                            <a id="selectRegOrg" class="link js-show">
                                <span class="add-icon" id="choseorgReg"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">抽查机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="checkDepName" class="ipt-txt clx" value="" readonly/>
                            <input type="hidden" id="checkDep" name="checkDep" class="clx" value=""/>
                            <a id="" class="link js-show">
                                <span class="add-icon" id="chosecheckDep"><i></i></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb10">
                <div class="col-4">
                    <label class="item-name col-5">企业类型：</label>
                    <div class="ipt-box col-7">
                        <input type="text" class="fl ipt-txt" readonly="readonly" id="entTypeName" placeholder="选择">
                        <input type="hidden" id="entType" name="entType">
                        <span class="add-icon" id="choseEntType"> <i></i></span>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">联络员确认：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <select name="yrLiaConfirm">
                                <option value="">请选择</option>
                                <option value="N">未确认</option>
                                <option value="Y">已确认</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>


            <div class="form-item clearfix">
                <div class="btn-box">
                    <input id="qry" type="button" value="查 询" class="btn mr20">
                    <input id="cancel" type="button" value="重 置" class="btn mr20">
                </div>
            </div>
        </div>
    </form>
</div>

<div class="clearfix mb5 mt5">
    <p class="fl"><input id="return" type="button" class="btn btn-sm mr5 js-masssms" value="短信群发">
</div>
<div>
    <table id="user-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>全选<input type='checkbox' id='checkAll'></th>
            <th>年报年度</th>
            <th class="uniscid">统一信用代码/注册号</th>
            <th>企业名称</th>
            <th class="yrLiaConfirm"> 联络员确认</th>
            <th class="yrIsRep">年度年报状态</th>
            <th class="yrRepState"> 当前年报状态</th>
            <th>法定代表人(负责人)</th>
            <th>法定代表人(负责人)手机</th>
            <th>企业联络员</th>
            <th>联络员手机</th>
            <th>企业类型</th>
            <th>登记机关</th>
            <th>抽查机关</th>
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
<script src="/js/reg/server/masssms/masssms_list.js"></script>
</body>
</html>
