<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>维护惩戒规则</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div>
    <form class="form-list mt10" id="ruleForm">

        <input type="hidden" name="id" value="${rule.id}">

        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light"> *</span>惩戒领域：</label>
            <div class="col-2">
                <div class="ipt-box">
                    <select name="punField" id="punField">
                        <option value="" <c:if test="${rule.punField==''}">selected="selected"</c:if>>请选择..</option>
                        <option value="安全生产领域" <c:if test="${rule.punField=='安全生产领域'}">selected="selected"</c:if>>
                            安全生产领域
                        </option>
                        <option value="旅行社经营领域" <c:if test="${rule.punField=='旅行社经营领域'}">selected="selected"</c:if>>
                            旅行社经营领域
                        </option>
                        <option value="食品药品经营领域"
                                <c:if test="${rule.punField=='食品药品经营领域'}">selected="selected"</c:if>>食品药品经营领域
                        </option>
                        <option value="饲料及兽药经营领域"
                                <c:if test="${rule.punField=='饲料及兽药经营领域'}">selected="selected"</c:if>>饲料及兽药经营领域
                        </option>
                        <option value="出版经营领域"
                                <c:if test="${rule.punField=='出版经营领域'}">selected="selected"</c:if>>出版经营领域
                        </option>
                        <option value="电影经营领域"
                                <c:if test="${rule.punField=='电影经营领域'}">selected="selected"</c:if>>电影经营领域
                        </option>
                        <option value="营业性演出经营领域"
                                <c:if test="${rule.punField=='营业性演出经营领域'}">selected="selected"</c:if>>营业性演出经营领域
                        </option>
                        <option value="建筑施工领域（含施工、勘察、设计和工程监理）"
                                <c:if test="${rule.punField=='建筑施工领域（含施工、勘察、设计和工程监理）'}">selected="selected"</c:if>>建筑施工领域（含施工、勘察、设计和工程监理）
                        </option>
                        <option value="电子认证领域"
                                <c:if test="${rule.punField=='电子认证领域'}">selected="selected"</c:if>>电子认证领域
                        </option>
                        <option value="证券期货市场监督管理领域"
                                <c:if test="${rule.punField=='证券期货市场监督管理领域'}">selected="selected"</c:if>>证券期货市场监督管理领域
                        </option>
                        <option value="普遍性限制措施"
                                <c:if test="${rule.punField=='普遍性限制措施'}">selected="selected"</c:if>>普遍性限制措施
                        </option>
                        <option value="税收管理"
                                <c:if test="${rule.punField=='税收管理'}">selected="selected"</c:if>>税收管理
                        </option>
                        <option value="国有企业监督管理领域"
                                <c:if test="${rule.punField=='国有企业监督管理领域'}">selected="selected"</c:if>>国有企业监督管理领域
                        </option>
                        <option value="互联网上网服务及娱乐场所经营领域"
                                <c:if test="${rule.punField=='互联网上网服务及娱乐场所经营领域'}">selected="selected"</c:if>>
                            互联网上网服务及娱乐场所经营领域
                        </option>
                    </select>
                </div>
            </div>
        </div>

        <div class="form-item clearfix">
            <label class="item-name col-3">限制时间(惩戒期限)：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="limitTime" value="${rule.limitTime}"
                           placeholder="例如：自吊销之日起3年内。100字以内" maxlength="100">
                </div>
            </div>
        </div>

        <div class="form-item clearfix">
            <label class="item-name col-3">法律依据：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <textarea rows="3" name="legBasis" placeholder="200字以内" maxlength="200">${rule.legBasis}</textarea>
                </div>
            </div>
        </div>

        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light"> *</span>惩戒事由：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <textarea rows="3" name="punCause" placeholder="200字以内" maxlength="200">${rule.punCause}</textarea>
                </div>
            </div>
        </div>

        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light"> *</span>惩戒规则：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <textarea rows="3" name="punRule" placeholder="200字以内" maxlength="200">${rule.punRule}</textarea>
                </div>
            </div>
        </div>

        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light"> *</span>惩戒措施(限制方式)：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <textarea rows="3" name="punMea" placeholder="200字以内" maxlength="200">${rule.punMea}</textarea>
                </div>
            </div>
        </div>

        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light"> *</span>惩戒提请部门：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <div class="col-9">
                        <input type="text" class="ipt-txt" id="punReqDept" name="punReqDept" value="${rule.punReqDept}" />
                    </div>
                    <!--  <input type="hidden" name="punReqDeptCode" id="punReqDeptCode" value="${rule.punReqDeptCode}"/>
                    <input type="button" id="selectPunReqDept" class="btn btn-xs chose" value="选择">-->
                </div>
            </div>
        </div>

        <div class="form-item clearfix mb10">
            <label class="item-name col-3"><span class="light"> *</span>惩戒执行部门：</label>
            <div class="col-6">
                <div class="ipt-box">
                    <div class="col-9">
                        <input type="text" class="ipt-txt" id="punExeDept" name="punExeDept" value="${rule.punExeDept}" />
                    </div>
                    <!--  <input type="hidden" name="punExeDeptCode" id="punExeDeptCode" value="${rule.punExeDeptCode}"/>
                    <input type="button" id="selectPunExeDept" class="btn btn-xs chose" value="选择">-->
                </div>
            </div>
        </div>

        <div class="form-item clearfix">
            <div class="center">
                <input type="submit" id="save" value="保 存" class="btn mr20">
                <input type="button" id="cancel" value="取 消" class="btn mr20">
            </div>
        </div>
    </form>
</div>

<script>
	var userType = '${sessionScope.session_sys_user.userType}';
	var urlHead = '/syn';
	if(userType==1){
		urlHead='/reg/server';
	}
    window._CONFIG = {
   		urlHead: urlHead
    }
</script>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/nocreditPunish/rule/edit_main.js"></script>
</body>
</html>