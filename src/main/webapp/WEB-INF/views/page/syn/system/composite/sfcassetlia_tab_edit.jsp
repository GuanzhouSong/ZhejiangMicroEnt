<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>年报详情tab页</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="clearfix pd10">
    <h2 class="border-bottom pdb10 h15-title">注册号:${regNo} &nbsp;&nbsp;农专社名称：${entName}</h2>
    <div class="tabbale" data-component="tab">
        <div class="tab-header">   
            <ul class="clearfix type-tab clear js-type-tab">
                <!-- 综合信息 -->
                <li class="js-item" data-name="zhxx" id="zhxxli">
                    <span class="tab-item tab-selected" ><a href="javascript:void(0);">综合信息</a></span>
                </li>
               
                <!-- 资产分配 -->
                <li class="js-item" data-name="zcfz" >
                    <span class="tab-item" ><a href="javascript:void(0);"  >资产负债</a></span>
                </li>
                
                <!-- 盈余分配-->
                <li class="js-item" data-name="yyfp" >
                    <span class="tab-item" ><a href="javascript:void(0);"  >盈余及盈余分配</a></span>
                </li>
                
                <!-- 成员权益变动 -->
                <li class="js-item" data-name="cyqy" >
                    <span class="tab-item" ><a href="javascript:void(0);"  >成员权益变动</a></span>
                </li>
                
                <!-- 基本情况信息 -->
                <li class="js-item" data-name="jbqk" >
                    <span class="tab-item" ><a href="javascript:void(0);"  >基本信息</a></span>
                </li>
                 
            </ul>
        </div>


        <div class="tab-content js-tab-content" style="text-align: center;">
            <!-- 综合信息 -->
            <div class="tab-panel tab-panel-show" id="zhxx">
                <div class="tab-mt10" >
                         <iframe  src="<c:url value="${sysUrl}/cominfoserver/show"/>?year=${year}&priPID=${priPID}" frameborder="0" style="width: 100%; height: 2200px;" id="zhxxiframe"></iframe>
                </div>
            </div>
              
           <!--资产负债 -->   
           <div class="tab-panel " id="zcfz">
               <div class="tab-mt10" >
                   <iframe id="zcfziframe" src="<c:url value="${sysUrl}/balanctsheet/show"/>?year=${year}&priPID=${priPID}" frameborder="0" style="width: 100%;"  ></iframe>
               </div>
           </div> 
           
           <!-- 盈余分配 -->
           <div class="tab-panel " id="yyfp">
               <div class="tab-mt10" >
                  <iframe id="yyfpiframe" src="<c:url value="${sysUrl}/balanctsheet/incStatement"/>?year=${year}&priPID=${priPID}" frameborder="0" style="width: 100%;"  ></iframe>
               </div>
           </div>
           
           <!--成员权益变动 -->
           <div class="tab-panel " id="cyqy">
               <div class="tab-mt10" >
                    <iframe id="cyqyiframe" src="<c:url value="${sysUrl}/balanctsheet/incomeChange"/>?year=${year}&priPID=${priPID}" frameborder="0" style="width: 100%;"  ></iframe>
               </div>
           </div>
           
           <!--基本情况信息 -->
           <div class="tab-panel " id="jbqk">
               <div class="tab-mt10" >
                    <iframe  id="jbqkiframe" src="<c:url value="${sysUrl}/balanctsheet/sfcBaseInfo"/>?year=${year}&priPID=${priPID}" frameborder="0" style="width: 100%;"  ></iframe>
               </div>
           </div>
          <jsp:include page="cominfocheck_edit.jsp"></jsp:include>
        </div>
    </div> 
</body>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/syn/system/composite/sfcgeneralinfo_tab_main.js"/>"></script>

</html>