<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>认缴变更页面</title>
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
    <div class="mod-cont">
        <h4>股东及出资信息</h4>
        <div class="invactdetail-change invprodetail_change">
            <table border="0" cellpadding="0" cellspacing="0" class="table-special">
                <tr>
                    <th colspan="2" class="before" width="50%">变更前</th>
                    <th colspan="2" class="after" width="50%">变更后</th>
                </tr>
                <tr>
                    <td class="tab-c-title">出资方式</td>
                    <td width="300">2016年5月3日</td>
                    <td class="tab-c-title"><span><input type="checkbox">出资方式</span></td>
                    <td width="300">
                        <span>经审核特许批准</span>
                        <div class="item-txt" style="display: none">
                            <select name="" id="" class="select-txt">
                                <option value="">fsd</option>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="tab-c-title">认缴出资额（万元）</td>
                    <td>北京食药监局</td>
                    <td class="tab-c-title"><span><input type="checkbox">认缴出资额（万元）</span></td>
                    <td><span>北京食药监局</span><input type="text" class="ipt-txt"></td>
                </tr>
                <tr>
                    <td class="tab-c-title">出资日期</td>
                    <td>经审核特许批准</td>
                    <td class="tab-c-title"><span><input type="checkbox">出资日期</span></td>
                    <td><span>2016年5月3日</span><input type="text" value="" class="ipt-txt icon-date" id="end" readonly="readonly" onclick="laydate()"></td>
                </tr>
                <tr>
                    <td class="tab-c-title"></td>
                    <td></td>
                    <td class="tab-c-title">变更时间</td>
                    <td><input type="text" class="ipt-txt icon-date change-time" readonly="readonly" onclick="laydate()"></td>
                </tr>
            </table>
        </div>
        <p class="btn"><input type="button" value="保存" class="btn-common"><input type="button" value="取消" class="btn-common"></p>
    </div>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/lib/laydate/laydate.js"/>"></script>
<script>
    $(document).on('click','.tab-c-title input',function () {
        $(this).closest('td').next('td').find('span').toggle();
        $(this).closest('td').next('td').find('input').toggle();
        $(this).closest('td').next('td').find('.item-txt').toggle();
    })
</script>
</body>
</html>