<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政许可变更页面</title>
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
<div class="mod pdt20 ">
    <div class="mod-cont permit-cont">
        <h4>行政许可信息</h4>
        <div class="permit-change">
            <div class="tabbale" data-component="tab" data-contain="input">
                <div class="tab-header">
                    <label>类别选择： </label>
                    <ul class="clearfix">
                        <li class="tab-selected"><label class="tab-item"><input type="radio" name="chose" checked>变更</label></li>
                        <li><label class="tab-item"><input type="radio" name="chose">注销</label></li>
                        <li><label class="tab-item"><input type="radio" name="chose">被吊销</label></li>
                        <li><label class="tab-item"><input type="radio" name="chose">其他无效信息</label></li>
                    </ul>
                </div>
                <div class="tab-content">
                    <div class="tab-panel tab-panel-show">
                        <table border="0" cellpadding="0" cellspacing="0" class="table-special">
                            <tr>
                                <th colspan="2" class="before" width="50%">变更前</th>
                                <th colspan="2" class="after" width="50%">变更后</th>
                            </tr>
                            <tr>
                                <td class="tab-c-title">许可文件编号</td>
                                <td width="328">201312142</td>
                                <td class="tab-c-title">许可文件编号</td>
                                <td width="330">201312142</td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">许可文件名称</td>
                                <td>餐饮许可证</td>
                                <td class="tab-c-title">许可文件名称</td>
                                <td>餐饮许可证</td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">有效期开始时间</td>
                                <td>2013年5月3日</td>
                                <td class="tab-c-title"><span><input type="checkbox">有效期开始时间</span></td>
                                <td><span>2013年5月3日</span><input type="text" value="" class="ipt-txt icon-date" id="start" readonly="readonly" onclick="laydate()"></td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">有效期结束时间</td>
                                <td>2016年5月3日</td>
                                <td class="tab-c-title"><span><input type="checkbox">有效期结束时间</span></td>
                                <td><span>2016年5月3日</span><input type="text" value="" class="ipt-txt icon-date" id="end" readonly="readonly" onclick="laydate()"></td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">许可机关</td>
                                <td>北京食药监局</td>
                                <td class="tab-c-title"><span><input type="checkbox">许可机关</span></td>
                                <td><span>北京食药监局</span><input type="text" class="ipt-txt"></td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">许可内容</td>
                                <td>经审核特许批准</td>
                                <td class="tab-c-title"><span><input type="checkbox">许可内容</span></td>
                                <td><span>经审核特许批准</span><input type="text" class="ipt-txt"></td>
                            </tr>
                            <tr>
                                <td class="tab-c-title"></td>
                                <td></td>
                                <td class="tab-c-title">变更时间</td>
                                <td><input type="text" class="ipt-txt icon-date change-time" readonly="readonly" onclick="laydate()"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="tab-panel">
                        <ul class="form-common-list">
                            <li>
                                <div class="col-4">
                                    <div class="item-name">注销时间</div>
                                    <div class="item-txt">
                                        <input type="text" name="" value="" class="ipt-txt">
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="item-name">注销原因</div>
                                    <div class="item-txt">
                                        <input type="text" name="" value="" class="ipt-txt">
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="tab-panel">
                        <ul class="form-common-list">
                            <li>
                                <div class="col-4">
                                    <div class="item-name">被吊销时间</div>
                                    <div class="item-txt">
                                        <input type="text" name="" value="" class="ipt-txt">
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="item-name">被吊销原因</div>
                                    <div class="item-txt">
                                        <input type="text" name="" value="" class="ipt-txt">
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="tab-panel">
                        <ul class="form-common-list">
                            <li>
                                <div class="col-4">
                                    <div class="item-name">其他无效时间</div>
                                    <div class="item-txt">
                                        <input type="text" name="" value="" class="ipt-txt">
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="item-name">其他无效原因</div>
                                    <div class="item-txt">
                                        <input type="text" name="" value="" class="ipt-txt">
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>        
        </div>
        <p class="btn"><input type="button" value="保存" class="btn-common"><input type="button" value="取消" class="btn-common"></p>
    </div>
</div>

<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/tab.js"/>"></script>
<script src="<c:url value="/js/lib/laydate/laydate.js"/>"></script>
<script>
    $(document).on('click','.tab-c-title input',function () {
        $(this).closest('td').next('td').find('span').toggle();
        $(this).closest('td').next('td').find('input').toggle();
    })
</script>

</body>
</html>