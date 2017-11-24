<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>股权变更信息列表页面</title>
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
        <h4>行政许可信息<a href="#">查看填报须知</a></h4>
        <div class="permit-list">
            <table border="0" cellspacing="0" cellpadding="0" class="table-ordinary">
                <tr>
                    <th width="170">股东</th>
                    <th>变更前股权比例</th>
                    <th>变更后股权比例</th>
                    <th>股权变更日期</th>
                    <th width="120">公示状态</th>
                    <th width="80">操作</th>
                </tr>
                <tr>
                    <td>招商局集团有限公司</td>
                    <td>80%</td>
                    <td>90%</td>
                    <td>2013年2月1日</td>
                    <td>已公示</td>
                    <td><a href="#">修改</a></td>
                </tr>
                <tr>
                    <td>招商局集团有限公司</td>
                    <td>80%</td>
                    <td>90%</td>
                    <td>2013年2月1日</td>
                    <td>已公示</td>
                    <td><a href="#">修改</a> <a href="#">删除</a></td>
                </tr>
            </table>
        </div>
        <p class="btn"><input type="button" value="添加"  class="btn-common js-add">
        <input type="button" value="打印预览" class="btn-common">
        <input type="button" value="保存并公示" class="btn-common">
        <input type="button" value="关闭" class="btn-common" id="close">
        </p>
    </div>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include>
</body>
</html>