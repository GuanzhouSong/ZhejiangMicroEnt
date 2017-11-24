<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<script type="text/javascript">
</script>
<body>
 <form id="registInfoForm">
<input type="hidden" name="priPID" value="${registInfoDto.priPID}">
   <div class="layer-bd">
        <div class="mass-distribution pd20">
            <div class="title">
                <span class="name">委托人：${registInfoDto.delegateName}</span>
                <span class="name">委托日期：<fmt:formatDate  value="${registInfoDto.comDate}"/></span>
                <input type="hidden" name="delegateName" value="${registInfoDto.delegateName}">
                <input type="hidden" name="comDate" value="<fmt:formatDate  value='${registInfoDto.comDate}'/>">
                 委托方式：</span><input type="radio" required name="registSource" checked value="1" > 委托<input type="radio" name="registSource"required value="2"> 自管
            </div>
            <span id="registSources">
            <div class="dominion clearfix">
                <div class="fr">
                    <input type="text" placeholder="请输入关键字搜索" class="ipt-txt fl">
                    <input type="button" class="btn-search">
                </div>
            </div>
            <div class="option-box clearfix">
                <div class="col-6 h">
                    <div class="mr40">
                        <div class="">
                            <ul class="ztree" id="permisionTree">
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-5 option-list">
                    <div id="optionlist" class="option-item">
                    </div>
                </div>
            </div>
            <div class="selected clearfix mb10">
                <div class="fl">已选择：</div>
                <div class="fl">
                    <p  id="delegateOrgNamep"></p>

                    <input type="hidden" id="delegateOrgName"  name="delegateOrgName" value="${registInfoDto.delegateOrgName}">
                </div>
            </div>
            </span>
            <div class="center">
                <input id="save"  type="submit" class="btn mr20" value="保 存">
                <input  id="cancel" type="button" class="btn" value="取 消">
            </div>
        </div>
    </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/batchdelegate_edit.js"></script>
</body>
</html>