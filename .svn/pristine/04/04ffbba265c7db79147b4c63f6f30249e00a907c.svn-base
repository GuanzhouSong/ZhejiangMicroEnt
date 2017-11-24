<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政处罚新增页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include>
<div class="banner-bg">
    <div class="mod banner">
        <h4>欢迎您！${midBaseInfoDto.entName}<font>（登记机关：${midBaseInfoDto.regOrgName}）</font></h4>
        <p><em>统一社会信用代码：3300001006258 </em><em>注册号：3300001006258</em></p>
    </div>
</div>
<div class="mod pdt20">
    <div class="mod-cont permit-cont">
        <h4>行政处罚信息</h4>
        <div>
            <ul class="form-common-list">
                <li>
                    <div class="col-6">
                        <div class="item-name item-name-md">
                            处罚决定书文号
                        </div>
                        <div class="item-txt item-txt-md">
                            <input type="text" name="" value="" class="ipt-txt">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name item-name-md">处罚决定书签发日期</div>
                        <div class="item-txt item-txt-md">
                            <input type="text" value="" class="ipt-txt ipt-txt-sm icon-date" id="start" readonly="" onclick="laydate()"> —
                            <input type="text" value="" class="ipt-txt ipt-txt-sm icon-date" id="end" readonly="" onclick="laydate()">
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-12">
                        <div class="item-name item-name-md">处罚机关</div>
                        <div class="item-txt item-txt-md">
                            <select name="" id="" class="select-txt">
                                <option value=""></option>
                            </select>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-12">
                        <div class="item-name item-name-md">违法行为类型</div>
                        <div class="item-txt item-txt-md">
                            <input type="text" name="" value="" class="ipt-txt">
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-name item-name-md">处罚种类</div>
                    <div class="item-txt item-txt-md item-punish-type">
                        <span><label><input type="checkbox">警告</label></span>
                        <span><label><input type="checkbox">罚款</label></span>
                        <span><label><input type="checkbox">没收违法所得和非法财物</label></span>
                        <span><label><input type="checkbox">责令停产停业</label></span>
                        <span><label><input type="checkbox">暂扣许可证</label></span>
                        <span><label><input type="checkbox">暂扣执照(登记证)</label></span>
                        <span><label><input type="checkbox">吊销许可证</label></span><br/>
                        <span><label><input type="checkbox">吊销执照(登记证)</label></span>
                        <span><label><input type="checkbox">法律、法规规定的其他行政处罚方式</label></span>
                    </div>
                </li>
                <li>
                    <div class="col-6">
                        <div class="item-name item-name-md">罚款金额（万元）</div>
                        <div class="item-txt item-txt-md">
                            <input type="text" name="" value="" class="ipt-txt">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name item-name-md">没收金额（万元）</div>
                        <div class="item-txt item-txt-md">
                            <input type="text" name="" value="" class="ipt-txt">
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-12">
                        <div class="item-name item-name-md">备注</div>
                        <div class="item-txt item-txt-md">
                            <input type="text" name="" value="" class="ipt-txt ">
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <p class="btn"><input type="button" value="保存" class="btn-common"><input type="button" value="取消"  class="btn-common"></p>
    </div>
</div>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/lib/laydate/laydate.js"/>"></script>
</body>
</html>