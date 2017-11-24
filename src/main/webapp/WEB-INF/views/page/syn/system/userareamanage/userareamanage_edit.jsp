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
    var _sliceMan='${sliceMan}';
    var _sliceTel='${sliceTel}';
</script>
<body>
<form id="registInfoForm">

    <div class="layer-bd">
        <div class="mass-distribution pd20">

            <div class="dominion clearfix">
                <div class="name fl"><i></i>部门：</div>
                <div class="fr">
                   <!--  <input type="text" id="_key" placeholder="请输入关键字搜索" class="ipt-txt fl">
                    <input type="button" class="btn-search" id="qry"> -->
                </div>
            </div>
            <div class="option-box clearfix">

                <div class="col-7 h" style="height: 450px;">
                    <div class="mr40">
                        <div class="">
                            <ul class="ztree" id="permisionTree">
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="col-5 option-list" >
                    <div class="option-item"><label><input id="checkAll" type="checkbox">全选</label></div>
                    <div id="optionlist" class="option-item">
                    </div>
                </div>
            </div>
            <div class="selected clearfix mb10" >
                <div class="fl">已选择：</div>
                <div class="fl">
                    <p  id="localAdmNamep" ></p>
                    <p  id="sliceManp"></p> 
                    <input type="hidden" id="allCheckedVal"   value="${allCheckedVal}">
                    <input type="hidden" id="uid"   value="${uid}">
                </div>

            </div>
            <div class="center">
                <input id="save"  type="button" class="btn mr20" value="确 定">
                <input  id="cancel" type="button" class="btn" value="关 闭">
            </div>
        </div>
    </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script>
    window._CONFIG = { 
       _sysUrl:'${sysUrl}'
    }
</script>
<script src="/js/syn/system/userareamanage/userareamanage_edit.js"></script>
</body>
</html>