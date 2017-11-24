<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>食品生产许可证编辑页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<div class="mod-food">
  <form id="cir_licenseForm">
    <ul class="form-common-list food-list">
        <input id="cir_id" name="id" type="hidden" >
        <input id="licType" name="licType" type="hidden" value="2">
        <li>
            <div class="col-5">
                <div class="item-name">许可证编号</div>
                <div class="item-txt">
                    <input type="text" id="cir_licNO" name="licNO" value="${foodstorageLicense.licNO}" class="ipt-txt ipt-txt-w138" required>
                </div>
            </div>
            <div class="col-7">
                <div class="item-name">许可机关</div>
                <div class="item-txt">
                    <input type="text" id="cir_licAnth" name="licAnth" value="${foodstorageLicense.licAnth}" class="ipt-txt ipt-txt-w238" required>
                </div>
            </div>
        </li>
        <li>
            <div class="col-5">
                <div class="item-name">有效期自</div>
                <div class="item-txt">
                    <input type="text" id="cir_licValFrom" value="" name="licValFrom" class="ipt-txt ipt-txt-w138 icon-date"  readonly="readonly" required>
                </div>
            </div>
            <div class="col-7">
                <div class="item-name">有效期止</div>
                <div class="item-txt">
                    <input type="text" id="cir_licValTo" value="" name="licValTo" class="ipt-txt ipt-txt-w138 ipt-txt- icon-date"  readonly="readonly" required>
                    <input type="checkbox" class="isLongterm">长期有效
                </div>
            </div>
        </li>
        <li>
            <div class="col-12">
                <div class="item-name">许可内容</div>
                <div class="item-txt">
                    <textarea  id="cir_licScope" name="licScope"  cols="" rows="5" class="textarea" required>${foodstorageLicense.licScope}</textarea>
                </div>
            </div>
        </li>
    </ul>
    <p class="btn center">
    <input type="submit" id="circommit" value="保存" class="btn-common">
    <input id="cirCancel" type="button" value="取消" class="btn-common">
    </p>
   </form>
</div>
</body>
</html>