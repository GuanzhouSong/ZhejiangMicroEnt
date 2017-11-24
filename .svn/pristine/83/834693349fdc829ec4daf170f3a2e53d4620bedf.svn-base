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
var _fromtype='${fromtype}';
/*var _sliceMan='${registInfoDto.sliceMan}';
var _sliceTel='${registInfoDto.sliceTel}';*/
</script>
<body>
 <form id="registInfoForm">
<input type="hidden" name="priPID" value="${registInfoDto.priPID}">
   <div class="layer-bd">
        <div class="mass-distribution pd20">
            <div class="title" ${fromtype=='sliceman'?'style="display:none"':''}>
                <span class="name">分配人：${registInfoDto.setName}</span>
                分配日期：<fmt:formatDate type='both' value="${registInfoDto.setTime}"/>
                <input type="hidden" name="setName" value="${registInfoDto.setName}">
                <input type="hidden" name="setTime" value="<fmt:formatDate type='both' value='${registInfoDto.setTime}'/>">

            </div>
            <div class="dominion clearfix">
                <div class="name fl"><i></i>管辖单位：</div>
                <div class="fr">
                    <input type="text" id="_key" placeholder="请输入关键字搜索" class="ipt-txt fl">
                    <input type="button" class="btn-search" id="qry">
                </div>
            </div>
            <div class="option-box clearfix">

                <div class="col-${fromtype=='sliceman'?'7':'12'} h">
                    <div class="mr40">
                        <div class="">
                            <ul class="ztree" id="permisionTree">
                            </ul>
                        </div>
                    </div>
                </div>

               <div class="col-5 option-list" ${fromtype=='sliceman'?'':'style="display:none"'}>
                    <div class="option-item"><label><input id="checkAll" type="checkbox">全选</label></div>
                    <div id="optionlist" class="option-item">
                    </div>
                </div>
            </div>
            <div class="selected clearfix mb10" ${fromtype=='sliceman'?'':'style="height:50px"'}>
                <div class="fl">已选择：</div>
                <div class="fl">
                    <p  id="localAdmNamep" ></p>
                    <p  id="sliceManp"></p>
                    <input type="hidden" id="localAdm"  name="localAdm" value="${registInfoDto.localAdm}">
                    <input type="hidden" id="localAdmName"  name="localAdmName" value="${registInfoDto.localAdmName}">
                </div>

            </div>
            <div class="center">
                <input id="save"  type="submit" class="btn mr20" value="确 定">
                <input  id="cancel" type="button" class="btn" value="关 闭">
            </div>
        </div>
    </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/batchdistribute_edit.js"></script>
</body>
</html>