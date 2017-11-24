<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 视图适配  -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- 360浏览器默认视图 -->
    <meta name="renderer" content="webkit">
    <title>新手指南</title>
    <link rel="stylesheet" href="/css/syn.css" type="text/css">
</head>
<body>
<div class="xt-top">
    <div class="mod2">
        <a href="###" class="logo"></a>
    </div>
</div>
<div class="bg-blue2">
<div class="mod2 new-user-help">
    <div class="title"><img src="/img/syn/zn-title.jpg" alt=""></div>
    <div class="new-user-list center">

        <a href="<c:url value='/common/system/util/down?fullFileName=4'/>" class="new-user-icon1"></a>
        <a href="<c:url value='/common/system/util/down?fullFileName=5'/>" class="new-user-icon2"></a>
        <a href="<c:url value='/common/system/util/down?fullFileName=3'/>" class="new-user-icon3"></a>
    </div>
</div>
<div class="mod2">
    <div class="policy-box">
        <dl class="policy-list">
            <dt><i class="rectangle-icon"></i>政策公文<span class="line"></span></dt>
            <dd><a href="http://www.gov.cn/zhengce/content/2015-11/03/content_10263.htm" target="_blank"><em>• </em>国务院关于“先照后证”改革后加强事中事后监管的意见（国发〔2015〕62号）</a></dd>
            <dd><a href="http://www.zj.gov.cn/art/2016/5/3/art_32432_272903.html" target="_blank"><em>• </em>浙江省人民政府办公厅关于深化“先照后证”改革加强事中事后监管的实施意见</a></dd>
            <dd><a href="http://www.zj.gov.cn/art/2016/5/16/art_12881_274302.html" target="_blank"><em>• </em>《浙江省人民政府办公厅关于深化先照后证改革加强事中事后监管的实施意见》政策解读</a></dd>
            <dd><a href="http://www.zj.gov.cn/art/2016/2/1/art_37175_259947.html" target="_blank"><em>• </em>《浙江省人民政府办公厅关于公布浙江省工商登记后置审批事项目录（2015年）的通知》文件政策解读</a></dd>
            <dd><a href="<c:url value='/common/system/util/down?fullFileName=1'/>"><em>• </em>工商登记前置审批事项目录</a></dd>
            <dd><a href="<c:url value='/common/system/util/down?fullFileName=2'/>"><em>• </em>工商登记后置审批目录（2015版）及参考经营范围对照表</a></dd>
            <dd><a href="<c:url value='/common/system/util/down?fullFileName=6'/>"><em>• </em>省政府办公厅《关于做好“先照后证”企业登记信息“双告知”工作通知》</a></dd>
        </dl>
    </div>
</div>
</div>
<div class=" log-footer log-footer2">
    <div class="mod2 center">
        <div class="other-tip">
            <a href="">收藏本站</a>|
            <a href="">关于信息交换共享平台</a>|
            <a href='<c:url value="/common/system/util/xszn"/>' target="_Blank">新手指南</a>|
            <a href="http://www.icinfo.cn/html/service.action" target="_Blank">联系我们</a>
         
            <select onchange="if(this.value!='')window.open(this.value);this.options[0].selected=true">
                <option value="相关链接">相关链接</option>
                <option value="http://www.zjzwfw.gov.cn/">浙江政务服务网</option>
                <option value="http://www.gsxt.gov.cn/">国家企业信用信息公示系统</option>
                <option value="http://www.zjcredit.gov.cn/">信用浙江网</option>
                <option value="http://www.zj.gov.cn/">浙江省人民政府</option>
                <!--                 <option value="http://online.icinfo.cn/eppnet/">企业数字证书（电子执照）服务</option> -->
            </select>
        </div>
        <p>
            主办单位：浙江省人民政府办公厅&nbsp;&nbsp;&nbsp;&nbsp;承办单位：浙江省工商行政管理局<br/>
            技术支持：浙江汇信科技有限公司&nbsp;&nbsp;&nbsp;&nbsp;<span class="light-black">技术服务热线：400-888-4636</span>&nbsp;&nbsp;&nbsp;&nbsp;建议使用1366*768分辨率/IE9.0或以上浏览器访问达到最佳效果
    </div>
</div>
</body>
</html>
