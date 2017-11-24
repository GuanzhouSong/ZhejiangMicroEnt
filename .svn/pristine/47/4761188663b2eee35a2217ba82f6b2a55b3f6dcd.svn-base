<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>食品仓储备案信息页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<style type="text/css">
    .typeOneView {
        display: none
    }

    .typeTwoView {
        display: none
    }

    .typeThreeView {
        display: none
    }
</style>
<body class="pd10">
<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>
<div style="margin-top: 10px;">
    <div class="mod">
        <div class="mod-hd">
            <div class="title">
                <h3>食品仓储信息登记表</h3>
                <p>以下信息请按照你企业填表时的实际情况填写</p>
            </div>
        </div>
        <div class="mod-bd">
            <div class="content">
                <div class="business-scope">
                    你企业涉及：
                    <label><input type="checkbox" id="typeOne" class="fsScope" value="1"
                                  <c:if test="${fn:indexOf(foodstorageBase.fsScope,'1')!=-1}">checked="checked"</c:if>>食品生产</label>
                    <label><input type="checkbox" id="typeTwo" class="fsScope" value="2"
                                  <c:if test="${fn:indexOf(foodstorageBase.fsScope,'2')!=-1}">checked="checked"</c:if>>食品经营</label>
                    <label><input type="checkbox" id="typeThree" class="fsScope" value="3"
                                  <c:if test="${fn:indexOf(foodstorageBase.fsScope,'3')!=-1}">checked="checked"</c:if>>食品仓储服务</label>
                    <label><input type="checkbox" id="typeFive" class="fsScope" value="5"
                                  <c:if test="${fn:indexOf(foodstorageBase.fsScope,'5')!=-1}">checked="checked"</c:if>>营业执照经营范围含“食用农产品”</label>
                    <label><input type="checkbox" id="typeFour" value="4"
                                  <c:if test="${fn:indexOf(foodstorageBase.fsScope,'4')!=-1}">checked="checked"</c:if>>都不涉及</label>
                </div>
                <!-------------------------------------------------------------------------------------------------------------------------------------->
                <div class="inner-title mt10 typeOneView">
                    <h4>食品生产许可证信息</h4>
                    <div class="currency">
                        <div class="show-tips drop-on" id="proDrop">
                            <span>收起</span>
                            <i></i>
                        </div>
                    </div>
                </div>
                <!-- 食品生产许可证信息 -->
                <div id="pro_license" class="mod mod-border investment-info js-content-show js-editUI"
                     style="width: 920px">
                    <jsp:include page="../../yr/auxtab/fspro_edit.jsp"></jsp:include>
                </div>

                <div class="typeOneView" id="proDropContent">
                    <div class="license-tips">
                        许可证数量：<span class="light-blue" id="proCount"></span>个
                        <c:if test="${foodstorageBase.submitState !='2'}">
                            <div class="btn-box">
                                <a href="javascript:void(0)" class="btn-common pro-btn-add">添加</a>
                            </div>
                        </c:if>
                    </div>
                    <div class="subcapital-tips" style="margin-top: 20px">
                        <c:if test="${foodstorageBase.submitState !='2'}">
                            <label><input type="checkbox" class="checkAll" id="1">全选</label>
                            请根据企业当前实际情况进行<strong class="light">添加/修改</strong>
                            <div class="fr edit">
                                <a href="javascript:void(0)" id="proEdit" class="btn-edit">修改</a>
                                <a href="javascript:void(0)" id="proDel" class="btn-delete">删除</a>
                            </div>
                        </c:if>
                    </div>
                    <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th width="59">序号</th>
                            <th width="129" class="pos">许可证编号
                                <div class="arrow-box">
                                    <i class="icon-arrow-up icon-arrow-up-gray"></i>
                                    <i class="icon-arrow-down icon-arrow-down-gray"></i>
                                </div>
                            </th>
                            <th width="129">有效期至</th>
                            <th width="129" class="pos">有效期止
                                <div class="arrow-box">
                                    <i class="icon-arrow-up icon-arrow-up-gray"></i>
                                    <i class="icon-arrow-down icon-arrow-down-gray"></i>
                                </div>
                            </th>
                            <th width="178">许可机关</th>
                            <th width="178">许可内容</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="pro_page">
                        </tbody>
                    </table>
                    <div class="notice-pagination-box clearfix">
                        <span class="page-total">共查询到<em id="pro_total"></em>条信息，共<em id="pro_pageNum"></em>页</span>
                        <div id="" class="pagination">

                        </div>
                    </div>
                </div>
                <!---------------------------------------------------------------------------------------------------------------------------- -->
                <div class="inner-title mt10 typeTwoView">
                    <h4>食品流通（经营）许可证信息</h4>
                    <div class="currency">
                        <div class="show-tips drop-on" id="cirDrop">
                            <span>收起</span>
                            <i></i>
                        </div>
                    </div>
                </div>
                <!-- 食品流通（经营）许可证信息 -->
                <div id="cir_license" class="mod mod-border investment-info js-content-show js-editUI"
                     style="width: 920px">
                    <jsp:include page="../../yr/auxtab/fscir_edit.jsp"></jsp:include>
                </div>

                <div class="typeTwoView" id="cirDropContent">
                    <div class="license-tips">
                        许可证数量：<span class="light-blue" id="cirCount"></span>个
                        <c:if test="${foodstorageBase.submitState !='2'}">
                            <div class="btn-box">
                                <a href="javascript:void(0)" class="btn-common cir-btn-add">添加</a>
                            </div>
                        </c:if>
                    </div>
                    <div class="subcapital-tips" style="margin-top: 20px">
                        <c:if test="${foodstorageBase.submitState !='2'}">
                            <label><input type="checkbox" class="checkAll" id="2">全选</label>
                            请根据企业当前实际情况进行<strong class="light">添加/修改</strong>
                            <div class="fr edit">
                                <a href="javascript:void(0)" id="cirEdit" class="btn-edit">修改</a>
                                <a href="javascript:void(0)" id="cirDel" class="btn-delete">删除</a>
                            </div>
                        </c:if>
                    </div>
                    <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th width="59">序号</th>
                            <th width="129" class="pos">许可证编号
                                <div class="arrow-box">
                                    <i class="icon-arrow-up icon-arrow-up-gray"></i>
                                    <i class="icon-arrow-down icon-arrow-down-gray"></i>
                                </div>
                            </th>
                            <th width="129">有效期至</th>
                            <th width="129" class="pos">有效期止
                                <div class="arrow-box">
                                    <i class="icon-arrow-up icon-arrow-up-gray"></i>
                                    <i class="icon-arrow-down icon-arrow-down-gray"></i>
                                </div>
                            </th>
                            <th width="178">许可机关</th>
                            <th width="178">许可内容</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="cir_page">

                        </tbody>
                    </table>
                    <div class="notice-pagination-box clearfix">
                        <span class="page-total">共查询到<em id="cir_total"></em>条信息，共<em id="cir_pageNum"></em>页</span>
                        <div id="" class="pagination">

                        </div>
                    </div>
                </div>
                <!---------------------------------------------------------------------------------------------------------------------------- -->
                <div class="inner-title mt10 typeThreeView">
                    <h4>仓库信息</h4>
                    <div class="currency">
                        <div class="show-tips drop-on" id="wareDrop">
                            <span>收起</span>
                            <i></i>
                        </div>
                    </div>
                </div>

                <div id="fsstorage" class="mod mod-border investment-info js-content-show js-editUI"
                     style="width: 920px">
                    <jsp:include page="../../yr/auxtab/fsstorage_edit.jsp"></jsp:include>
                </div>

                <div class="typeThreeView" id="wareDropContent">
                    <div class="license-tips">
                        仓库数量：<span class="light-blue" id="storageCount"></span>个
                        <c:if test="${foodstorageBase.submitState !='2'}">
                            <div class="btn-box">
                                <a href="javascript:void(0)" class="btn-common storage-btn-add">添加</a>
                            </div>
                        </c:if>
                    </div>
                    <div class="subcapital-tips" style="margin-top: 20px">
                        <c:if test="${foodstorageBase.submitState !='2'}">
                            <label><input type="checkbox" class="checkAll" id="3">全选</label>
                            请根据企业当前实际情况进行<strong class="light">添加/修改</strong>
                            <div class="fr edit">
                                <a href="javascript:void(0)" id="infoEdit" class="btn-edit">修改</a>
                                <a href="javascript:void(0)" id="infoDel" class="btn-delete">删除</a>
                            </div>
                        </c:if>
                    </div>
                    <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <th width="59">序号</th>
                            <th width="200">注册地址</th>
                            <th width="200">仓库地址</th>
                            <th width="80">仓库面积<br/>(m<sup>2</sup>)</th>
                            <th width="80">仓储从业<br/>人员数量</th>
                            <th width="80">仓库类型</th>
                            <th width="80">建筑类型</th>
                            <th width="80">库负责人</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="storage_page">
                        </tbody>
                    </table>
                    <div class="notice-pagination-box clearfix">
                        <span class="page-total">共查询到<em id="info_total"></em>条信息，共<em id="info_pageNum"></em>页</span>
                        <div id="" class="pagination">

                        </div>
                    </div>
                </div>
                <form id="baseForm">
                    <input type="hidden" name="id" value="${foodstorageBase.id}"/>
                    <input type="hidden" id="fsScope" name="fsScope" value="${foodstorageBase.fsScope}"/>
                    <input type="hidden" name="priPID" value="${sessionScope.midBaseInfoDto.priPID}"/>
                    <input type="hidden" id="proAmount" name="proAmount" value="${foodstorageBase.proAmount}"/>
                    <input type="hidden" id="disAmount" name="disAmount" value="${foodstorageBase.disAmount}"/>
                    <input type="hidden" id="wareAmount" name="wareAmount" value="${foodstorageBase.wareAmount}"/>
                    <input type="hidden" id="submitState" name="submitState" value="${foodstorageBase.submitState}"/>
                    <table class="table-public outer-border table-development mt20">
                        <tbody>
                        <tr class="focus-state">
                            <td width="94" class="tar">姓名</td>
                            <td width="150">
                                <div class="ipt-box">
                                    <input type="text" name="setName" value="${foodstorageBase.setName}" class="ipt-txt"
                                           required>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                            <td width="65" class="tar">办公电话</td>
                            <td width="150">
                                <div class="ipt-box">
                                    <input type="text" name="tel" value="${foodstorageBase.tel}" class="ipt-txt isTel"
                                           required>
                                    <i class="icon-close"></i>
                                </div>

                            </td>
                            <td width="65" class="tar">手机号</td>
                            <td width="150">
                                <div class="ipt-box">
                                    <input type="text" name="mobTel" value="${foodstorageBase.mobTel}"
                                           class="ipt-txt checkMobile" required>
                                    <i class="icon-close"></i>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <p class="btn-box">
                        <c:if test="${foodstorageBase.submitState !='2'}">
                            <input type="submit" id="commitall" value="提交" class="btn-common btn-save">
                            <input type="submit" id="saveall" value="暂存" class="btn-common btn-save">
                        </c:if>
                        <input id="closeWindow" type="button" value="关闭" class="btn-common btn-save">
                    </p>
                </form>
            </div>
        </div>
    </div>
</div>

<script id="pro_license_table" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td><input type="checkbox" name="checkbox1" value="{{id}}">{{xh @index}}</td>
        <td>{{licNO}}</td>
        <td>{{licValFrom}}</td>
        <td>{{licValTo}}</td>
        <td>{{licAnth}}</td>
        <td>{{licScope}}</td>
        <td><a href="javascript:void(0)" class="pro_details">详情</a></td>
    </tr>
    {{/each}}
</script>
<script id="cir_license_table" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td><input type="checkbox" name="checkbox2" value="{{id}}">{{xh @index}}</td>
        <td>{{licNO}}</td>
        <td>{{licValFrom}}</td>
        <td>{{licValTo}}</td>
        <td>{{licAnth}}</td>
        <td>{{licScope}}</td>
        <td><a href="javascript:void(0)" class="cir_details">详情</a></td>
    </tr>
    {{/each}}
</script>
<script id="storage_table" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td><input type="checkbox" name="checkbox3" value="{{fsinfoID}}">{{xh @index}}</td>
        <td>{{addr}}</td>
        <td>{{wareAddr}}</td>
        <td>{{opSpace}}</td>
        <td>{{empNum}}</td>
        <td>{{storageType}}</td>
        <td>{{buildType}}</td>
        <td>{{linkman}}</td>
        <td><a href="javascript:void(0)" class="sto_details">详情</a></td>
    </tr>
    {{/each}}
</script>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/yr/auxtab/foodstorage_list_main.js"></script>
</body>
</html>