<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>股东及出资信息新增页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>


<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>

<div class="mod pdt20">
<input type="hidden" name="inv" id="inv" value="${invID}"></p>
         <input type="hidden" name="id" id="id" value="${invID}">
          <input type="hidden" name="uniCode" value=${midBaseInfoDto.uniCode }>
         <input type="hidden" name="invID" id="invID" value="${invID}">
    <div class="mod-cont permit-cont">
        <h4>股东及出资信息</h4>
        <div class="investment-add">
            <ul class="form-common-list">
                <li>
                    <div class="col-6">
                        <div class="item-name">股东：</div>
                        <input type="hidden" name="invd" id="invd" value="${invID}"></p>
                        <div class="item-txt">
                            <input type="text" placeholder="请从列表中选择股东，列表以外的股东请直接输入"  value="${inv }" id="invr" class="ipt-txt">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name">
                            <a href="javascript:void(0)" class='js-inv-list' pripid="${midBaseInfoDto.priPID}">股东列表</a>
                        </div>
                    </div>
                </li>
            </ul>
            <div class="add-more">
                <a href="#" class='js-add'>添加+</a>
                <h4 class="h4-title light" >提示：“认缴出资信息”请按照该股东在企业章程中所有的每一次认缴出资金额、认缴出资日期和认缴出资方式填写；同一次认缴出资中有不同出资方式的要按照每一种出资方式分开填写。
                </h4>
            </div>
            <table border="0"  id="permit-table"cellspacing="0" cellpadding="0" class="table-ordinary mb14">
                <thead>
                <tr>
                    <th width="208">出资方式</th>
                    <th width="218">认缴出资额（万${midBaseInfoDto.currencyCn}）</th>
                    <th width="235">出资日期</th>
                    <th>公示状态</th>
                    <th width="80">操作</th>
                </tr>
                </thead>
               
            </table>
              
            <div class="add-more">
                <a href="#" class="js-addAct">添加+</a>
                <h4 class="h4-title light" >
                    提示：“实缴出资信息”请按照该股东截止当前的每一次实缴出资金额、实缴出资日期和实缴出资方式填写；同一次实缴出资中有不同出资方式的要按照每一种出资方式分开填写。
                </h4>
            </div>
            <table border="0" id="investment-table" cellspacing="0" cellpadding="0" class="table-ordinary">
                <thead>
                <tr>
                    <th width="208">出资方式</th>
                    <th width="218">实缴出资额（万${midBaseInfoDto.currencyCn}）</th>
                    <th width="235">出资日期</th>
                    <th>公示状态</th>
                    <th width="80">操作</th>
                </tr>
                </thead> 
            </table>
        </div>
        <p class="btn"><input type="button" value="保存" class="btn-common " id="saveForUpdate"><input type="button" value="取消" id="cancel" class="btn-common"></p>
    </div>
</div>

<%--解决股东列表选择是敏感词的问题--%>
<input type="hidden" id="SensitiveName" value="${! empty inv ?inv:''}">
<input type="hidden" id="Sensitive" value="${! empty inv ?'yes':''}">

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/im/investment/investment_edit.js"/>"></script>
  <script id="tplact" type="text/x-handlebars-template">
    {{#each func}}
    <a  href="#" class="{{this.class}}">{{this.text}}</a>
    {{/each}}
</script>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <a  href="#" class="{{this.class}}">{{this.text}}</a>
    {{/each}}
      </script>
</body>
</html>