<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政指导中止</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
</head>
<script type="text/javascript">
    var _adminguideitem = '${govguide.adminguideitem}';
    var _fromtype = '${fromtype}';
    var _adminguidecercontent = '${govguide.adminguidecercontent}';
</script>
<body>
<div class="pd10">
    <div class="clearfix">
        <h4 class="h4-title mt10">中止行政指导 ${govguide.entname}</h4>

        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10">
            <tbody>
            <tr>
                <td class="bg-gray right" width="12%">统一信用代码/注册号</td>
                <td width="39%">${govguide.uniscid==null||govguide.uniscid==''?govguide.regno:govguide.uniscid}</td>
                <td class="bg-gray right" width="10%">企业名称</td>
                <td width="39%">${govguide.entname}</td>
            </tr>
            <tr>
                <td class="bg-gray right">行政指导项目</td>
                <td width="39%">${govguide.adminguideitem == 1? '其他':''}
                    ${govguide.adminguideitem == 2 ? '股东出资提示':''}
                    ${govguide.adminguideitem == 3 ? '许可证即将到期':''}
                    ${govguide.adminguideitem == 4 ? '经营期限即将到期':''}
                    ${govguide.adminguideitem == 5 ? '长期不开展经营活动':''}
                    ${govguide.adminguideitem == 6 ? '清算':''}</td>
                <td class="bg-gray right">其他送达方式</td>
                <c:set value="${fn:split(govguide.othernoticetype,',')}" var="othernoticetype"/>
                <td width="39%">
                    <div class="ipt-box col-12">
                        <input type="checkbox" name="othernoticetype" value="1" required
                               onclick="return false"
                        <c:forEach var="o"
                                   items="${othernoticetype}">${o == 1 ? 'checked':''}</c:forEach>  >通过公示系统提醒
                        <input type="checkbox" name="othernoticetype" value="2" required
                               onclick="return false"
                        <c:forEach var="o"
                                   items="${othernoticetype}">${o == 2 ? 'checked':''}</c:forEach>  >企信联连
                        <input type="checkbox" name="othernoticetype" value="3" required
                               onclick="return false"
                        <c:forEach var="o"
                                   items="${othernoticetype}">${o == 3 ? 'checked':''}</c:forEach>  >电子邮件
                        <input type="checkbox" name="othernoticetype" value="4" required
                               onclick="return false"
                        <c:forEach var="o"
                                   items="${othernoticetype}">${o == 4 ? 'checked':''}</c:forEach>  >短信
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="bg-gray pdt30lr50b30 mb10">
            <%-- 1 begin  --%>
            <div id="adminguidecercontent-1" ${govguide.adminguideitem==1?'':'style="display:none"'}>
                <c:set value="${fn:split(govguide.adminguidecercontent,'&')}" var="adminguidecercontent"/>
                <div class="form-item2">
                    <div class="item-name2 ">你企业因</div>
                    <div class="ipt-box2">
                        <input id="_adminguidecercontent1" type="text" class="ipt-txt2 adminguidecercontent-1"
                               value=""
                               readonly="readonly"
                        >
                    </div>
                    <div class="item-name2">的情况，特对你企业提醒提示如下:</div>
                </div>
                <div class="form-item2 col-12">
                    <div class="ipt-box2"><textarea rows="5" readonly="readonly" id="_adminguidecercontent2"
                                                    class="adminguidecercontent-1"></textarea>
                    </div>
                </div>
            </div>
            <%-- 1 end  --%>
            <%-- 2 begin  --%>
            <div id="adminguidecercontent-2"${govguide.adminguideitem==2?'':'style="display:none"'}>
                <div class="form-item2">
                    <div class="item-name2 ">根据公司章程和公司登记相关法律法规的规定，你公司投资人（股东）应当于</div>
                    <div class="ipt-box2">
                        <input id="_adminguidecercontent3" type="text" class="ipt-txt2 adminguidecercontent-2 "

                               readonly="readonly" name="prodate"
                               value=""/>
                    </div>
                    <div class="item-name2">前缴纳出资款</div>
                    <div class="ipt-box2">
                        <input id="_adminguidecercontent4" type="text" class="ipt-txt2  adminguidecercontent-2"
                               value=""
                               readonly="readonly"
                        >
                    </div>
                    <div class="item-name2">元（其中：</div>
                </div>
                <div class="form-item2">
                    <div class="ipt-box2">
                        <input id="_adminguidecercontent5" type="text" class="ipt-txt2  adminguidecercontent-2"
                               value=""
                               readonly="readonly"
                        >
                    </div>
                    <div class="item-name2">），出资期限即将届满，</div>
                </div>

                <div class="form-item2">
                    <div class="item-name2 ">特别提醒</div>
                    <div class="ipt-box2">
                        <input id="_adminguidecercontent6" type="text" style=""
                               class="ipt-txt2   adminguidecercontent-2"
                               value=""
                               readonly="readonly"
                        >
                    </div>
                </div>
                <div class="form-item2">
                    <div class="item-name2 " style="white-space:normal;">
                        如果法定出资期限届满你公司投资人（股东）未依法足额出资，你公司未主动采取措施办理减资、变更或注销手续的，工商部门将依法对相关投资人（股东）及你公司实施行政处罚。
                    </div>
                </div>
            </div>
            <%-- 2 end  --%>
            <%-- 3 begin  --%>
            <div id="adminguidecercontent-3"${govguide.adminguideitem==3?'':'style="display:none"'}>
                <div class="form-item2">
                    <div class="item-name2 " style="white-space:normal;">
                        你企业经营范围中涉及的专项审批许可证：<br/>
                    </div>
                </div>
                <div class="form-item2">
                    <div class="ipt-box2">
                        <input id="adminguidecercontent-3-name" name="_adminguidecercontent7" required type="text"
                               style="" class="ipt-txt2   adminguidecercontent-3"
                               value=""
                               readonly="readonly">
                    </div>
                    <div class="item-name2 " style="cursor:pointer"><font color="red" >选择许可证</font></div>
                </div>
                <div class="form-item2">
                    <div class="item-name2 " style="white-space:normal;">
                        有效期即将届满，根据企业登记管理相关法律法规的规定，相关许可证失效后继续从事该许可项目的，或未取得合法有效专项审批许可证擅自从事相关经营项目的，依照无证无照经营行为予以定性查处。因此，建议你企业在许可证有效期届满之前，依法重新申领有关专项审批许可证，或者到工商部门办理相关经营范围变更手续取消该许可经营项目。
                    </div>
                </div>
            </div>
            <%-- 3 end  --%>
            <%-- 4 begin  --%>
            <div id="adminguidecercontent-4"${govguide.adminguideitem==4?'':'style="display:none"'}>
                <div class="item-name2 " style="white-space:normal;">
                    <p> 你企业章程规定的经营期限即将届满，根据企业登记管理相关法律法规的规定，经营期限到期的企业，应当依法清算注销。</p>
                    <p>如你企业需要继续经营的，建议你企业在期限到期之前，向企业登记机关（工商部门）申请办理经营期限延期变更登记手续。</p>
                    <p>经营期限到期后擅自从事经营活动的，依照无证无照经营予以定性查处。</p>
                </div>
            </div>
            <%-- 4 end  --%>
            <%-- 5 begin  --%>
            <div id="adminguidecercontent-5"${govguide.adminguideitem==5?'':'style="display:none"'}>
                <div class="item-name2 " style="white-space:normal;">
                    <p>
                        据了解，你企业已长期未正常开展经营活动，根据《公司法》、《企业法人登记管理条例》等企业登记管理相关法律法规的规定，企业领取执照后6个月未开业或自行停业时间超过6个月以上的，工商部门可以依法吊销企业的营业执照。</p>
                    <p>因此，建议你企业予以重视，加强企业管理，积极从事经营活动，以避免承担因长期未经营而产生的受罚风险。</p>
                </div>
            </div>
            <%-- 5 end  --%>
            <%-- 6 begin  --%>
            <div id="adminguidecercontent-6"${govguide.adminguideitem==6?'':'style="display:none"'}>
                <div class="item-name2 " style="white-space:normal;">
                    <p>你公司已办理清算备案，进入清算阶段。现对你公司建议提示如下：</p>
                    <p>1.尽快完成清算工作，并按照规定办理营业执照注销登记。</p>
                    <p>2.进入清算程序的企业，在办理注销手续前，应当办理年检手续。</p>
                </div>
            </div>
            <%-- 6 end  --%>
            <div class="form-item2">
                <span class="item-name2">补充说明：</span>
                <div class="ipt-box2">
                    <input type="text" class="ipt-txt2" value="${govguide.addremark}" readonly="readonly">
                </div>
            </div>
            <div class="form-item2">
                <div class="item-name2">联系人：</div>
                <div class="ipt-box2">
                    <input type="text" value="${govguide.linkman}" class="ipt-txt2" readonly="readonly">
                </div>
                <div class="item-name2">联系电话：</div>
                <div class="ipt-box2 ">
                    <input type="text" value="${govguide.tel}" class="ipt-txt2" readonly="readonly">
                </div>
                <div class="item-name2">出具日期：</div>
                <div class="ipt-box2 ">
                    <input type="text" value="<fmt:formatDate value="${govguide.prodate}"  />" readonly="readonly"
                           class="ipt-txt2">
                </div>
            </div>
            <div class="form-item2">
                <div class="item-name2">登记机关：</div>
                <div class="ipt-box2">
                    <input type="text" value="${govguide.regorgname}" class="ipt-txt2" readonly="readonly">
                </div>
                <div class="item-name2">管辖单位：</div>
                <div class="ipt-box2">
                    <input type="text" value="${govguide.localadmname}" class="ipt-txt2" readonly="readonly">
                </div>
            </div>
        </div>
    </div>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10">
        <tbody>
        <tr>
            <td class="bg-gray right" width="12%">开始日期</td>
            <td width="15%"><fmt:formatDate value="${govguide.stadate}"/></td>
            <td class="bg-gray right" width="10%">结束日期</td>
            <td width="15%"><fmt:formatDate value="${govguide.enddate}"/></td>
            <td class="bg-gray right" width="10%">申请人</td>
            <td width="13%">${govguide.applyman}</td>
            <td class="bg-gray right" width="12%">申请日期</td>
            <td><fmt:formatDate value="${govguide.applydate}"/></td>
        </tr>
        <tr>
            <td class="bg-gray right">审核结果</td>
            <td colspan="3">同意行政指导
            </td>
            <td class="bg-gray right">审核人</td>
            <td>${govguide.auditname}</td>
            <td class="bg-gray right">审核日期</td>
            <td><fmt:formatDate value="${govguide.auditdate}"/></td>
        </tr>
        </tbody>
    </table>
    <form id="infoForm">
        <input type="hidden" id="uid" name="uid" value="${govguide.uid}">
        <input type="hidden" id="pripid" name="pripid" value="${govguide.pripid}">
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10">
            <tbody>
            <tr>
                <td class="bg-gray right" width="12%">中止说明</td>
                <td colspan="5" width="88%">
                    <div class="ipt-box col-12">
                        <textarea id="susremark"  name="susremark" maxlength="250" ${fromtype=='susview'?'readonly="readonly"':''}
                                  rows="5">${govguide.susremark}</textarea>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="12%">中止日期</td>
                <td width="40%">
                    <div class="ipt-box col-12">
                        <input type="text" ${fromtype=='susview'?'':'onclick="laydate()"'} required readonly="readonly"
                               class="ipt-txt" name="susdate" value="<fmt:formatDate value="${govguide.susdate}"  />">
                    </div>
                </td>
                <td class="bg-gray right" width="10%">申请中止人</td>
                <td width="13%">${govguide.applysusman}</td>
                <input type="hidden" name="applysusman" value="${govguide.applysusman}"/>
                <td class="bg-gray right" width="12%">中止录入日期</td>
                <td><fmt:formatDate value="${govguide.applysusdate}"/></td>
                <input type="hidden" name="applysusdate" value="<fmt:formatDate value="${govguide.applysusdate}"/>"/>
            </tr>
            </tbody>
        </table>
        <div class="center">
            <div>
                <c:if test='${fromtype!="susview"}'>
                    <input id="save" type="submit" class="btn mr20" value="保 存">
                    <input id="cancel" type="button" class="btn" value="取 消">
                </c:if>
                <c:if test='${fromtype=="susview"}'>
                    <input id="cancel" type="button" class="btn" value="取 消">
                </c:if>
            </div>
        </div>
    </form>
</div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/govguide/govguidesus_edit.js"></script>
</body>
</html>