<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>电子回执操作</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <style>
        .hz-content{
            border: 1px solid #cec5c5;width: 900px;margin: 10px auto;position: relative;
        }
        .not-hz{ /*未回执*/
            position: absolute;  right: 0px; top: 0px; width: 100px; height: 40px; border-radius: 2px; background: red; color: #fff; line-height: 40px; text-align: center; font-weight: bold; font-size: 16px;
        }
        .already-hz{/*已回执*/
            position: absolute;  right: 0px; top: 0px; width: 100px; height: 40px; border-radius: 2px; background: green; color: #fff; line-height: 40px; text-align: center; font-weight: bold; font-size: 16px;
        }
    </style>
</head>
<body>
<!-- 头部 -->
<div >
    <div class="mod1366 info-tb-hd border-top9">
        <div class="logo"><a href="http://118.178.31.19/client/entsearch/toEntSearch"></a></div>
    </div>
</div>

<div class="hz-content">


    <!--回执状态-->
    <c:if test="${!empty dzhz}">
        <div class="js-hz already-hz">已回执</div>
    </c:if>
    <c:if test="${empty dzhz}">
        <div class="js-hz not-hz">未回执</div>
    </c:if>

    <div class="light-info mt5" style="margin-top: 40px;font-size: 14px;">
        <span class="light">提醒：亲爱的企业用户,本文书已成功送达(即已查阅)给贵企，请在规定的时间前完成下方回执，逾期会影响您企业的信用。</span>
    </div>



    <!-- 用于判断显示不同的决定书 -->

    <c:if test="${typeMark=='4'}">
        <!-- 列入异常决定书-->
        <%@include file="../../commpage/writepage/book4.jsp"%>
    </c:if>

    <c:if test="${typeMark=='5'||typeMark=='6'}">
        <!-- 移出和撤销 异常决定书-->
        <%@include file="../../commpage/writepage/book5-6.jsp"%>
    </c:if>

</div>

<!--************************************  电子回执  start*****************************************************-->

<!-- 回执表单查看 start -->
<c:if test="${!empty dzhz}">
<div class="mod mod-border investment-info mt10 " >
    <div>
        <div class="title" style="text-align:center;">
            <h3>${sessionScope.midBaseInfoDto.entName} 电子回执</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content liaison-layer">
            <div> XX局（工商局）：</div>
            <br>
            <div>我司已收阅并知悉以上文书内容！</div>
            <br>
            <div>${sessionScope.midBaseInfoDto.entName}</div>
            <br/>
            <p style="font-weight: bold;font-size: 16px;">>>>>>>>:${dzqz.qzStatus=='1'?'签章成功':'签章失败'}</p>
            <br/>
            <form class="form-horizontal error-bottom" >
                <table>
                    <tr>
                        <td>回执人</td>
                        <td>
                            <input type="text"  name="receivePeople" value="${dzhz.receivePeople}" class="ipt-txt" readonly>
                        </td>
                        <td>联系电话</td>
                        <td>
                            <input type="text"  name="tel" value="${dzhz.tel}" class="ipt-txt"  readonly>
                        </td>
                        <td>回执日期</td>
                        <td>
                            <input type="text" name="receiveTime" value="<fmt:formatDate value="${dzhz.receiveTime}"  pattern="yyyy-MM-dd" />" class="ipt-txt" readonly >
                        </td>
                    </tr>
                </table>
                <br/>
            </form>
        </div>
    </div>
</div>
</c:if>
<!-- 回执表单查看  end -->


<!-- 填写回执表单 未填写 start -->
<c:if test="${empty dzhz}">
<div class="mod mod-border investment-info mt10 " id="js-change-UI" >
    <div>
        <div class="title" style="text-align:center;">
            <h3>${sessionScope.midBaseInfoDto.entName} 电子回执</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content liaison-layer">
            <div> XX局（工商局）：</div>
            <br>
            <div>我司已收阅并知悉以上文书内容！</div>
            <br>
            <div>${sessionScope.midBaseInfoDto.entName}</div>
            <br/>
            <form class="form-horizontal error-bottom" id="dzhzFrom">
                <%-- 隐藏参数 start --%>
                <input type="hidden" name="year"      value="${writParams.year}">
                <input type="hidden" name="priPID"    value="${writParams.priPID}">
                <input type="hidden" name="writUuid"  value="${writParams.uuid}">
                <input type="hidden" name="entName"   value="${sessionScope.midBaseInfoDto.entName}">
                <%-- 隐藏参数 end --%>
                <table>
                    <tr>
                        <td>回执人</td>
                        <td>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="hzr" name="receivePeople" value="${lianname}" class="ipt-txt js-content" placeholder="读取联络员姓名,可以修改">
                            </div>
                        </td>
                        <td>联系电话</td>
                        <td>
                            <div class="ipt-box js-ipt-box">
                                <input type="text" id="lxdh" name="tel" value="${tel}" class="ipt-txt js-content"
                                       placeholder="读取联系人的手机号码,可修改">
                            </div>
                        </td>
                        <td>回执日期</td>
                        <td>
                            <input type="text" name="receiveTime" value="${sysDate}" class="ipt-txt js-content" placeholder="默认读取系统时间">
                        </td>
                    </tr>
                </table>
               <br/>
            </form>

            <%-- 电子签章参数 start --%>
            <form id="js_signature_form">
                <input type="hidden"  name="year"      value="${writParams.year}">
                <input type="hidden"  name="priPID"    value="${writParams.priPID}">
                <input type="hidden"  name="keyCerSn"  value="${sessionScope.keyCerSn}">
                <input type="hidden"  name="writUuid"  value="${writParams.uuid}"   id="js-uuid">
            </form>

            <div class="btn-box" id="js-module-one">
                <button class="btn-common js-stamp-preview" style="width: 97px;">盖章并预览</button>
            </div>

            <div class="btn-box" id="js-module-two" style="display: none;">
                <button class="btn-common js-submit-receipt" style="width: 97px;">提交回执</button>
                <button class="btn-common js-rewrite" style="width: 97px;">重新填写</button>
            </div>
        </div>
    </div>
</div>
</c:if>
<!-- 填写回执表单 未填写 end -->

<!--************************************  电子回执  end *****************************************************-->
    <div style="text-align: center;margin-top: 3px;">
        <button id="js-close" type="button" class="btn-common btn-save">关闭</button>
    </div>



<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/writ/promptly_writ.js"/>"></script>
</body>
</html>
