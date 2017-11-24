<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政指导</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
</head>
<script type="text/javascript">
    var _adminguideitem = '${govguide.adminguideitem}';
    var _fromtype = '${fromtype}';
    var _adminguidecercontent = '${govguide.adminguidecercontent}';
</script>
<body class="pd10">
<div>
    <h4 class="h4-title mt5">${govguide.entname}</h4>
    <form id="infoForm">
        <input type="hidden" id="uid" name="uid" value="${govguide.uid}">
        <input type="hidden" id="pripid" name="pripid" value="${govguide.pripid}">
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
            <tbody>
            <tr>
                <td class="bg-gray right" width="15%">统一信用代码/注册号</td>
                <td colspan="3">${govguide.uniscid==null||govguide.uniscid==''?govguide.regno:govguide.uniscid}</td>
                <input type="hidden" name="uniscid" value="${govguide.uniscid}"/>
                <input type="hidden" name="regno" value="${govguide.regno}"/>
                <td class="bg-gray right">企业名称</td>
                <td colspan="3">${govguide.entname}</td>
                <input type="hidden" name="entname" value="${govguide.entname}"/>
            </tr>
            <tr>
                <td class="bg-gray right" width="10%">开始日期</td>
                <td width="13%">
                    <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt"
                            ${fromtype != 'checkview'?'onclick="laydate()"':''}   required
                                   readonly="readonly" name="stadate"
                                   value="<fmt:formatDate value="${govguide.stadate}"  pattern="yyyy-MM-dd"/>"/>

                    </div>
                </td>
                <td class="bg-gray right" width="10%">结束日期</td>
                <td width="13%">
                    <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt"
                            ${fromtype != 'checkview'?'onclick="laydate()"':''}  required
                                   readonly="readonly" name="enddate"
                                   value="<fmt:formatDate value="${govguide.enddate}"  pattern="yyyy-MM-dd"/>"/>
                    </div>
                </td>
                <td class="bg-gray right" width="10%">申请人</td>
                <td width="13%">${govguide.applyman}</td>
                <input type="hidden" name="applyman" value="${govguide.applyman}"/>
                <td class="bg-gray right" width="10%">申请日期</td>
                <td><fmt:formatDate value="${govguide.applydate}" pattern="yyyy-MM-dd"/></td>
                <input type="hidden" name="applydate" value="<fmt:formatDate value="${govguide.applydate}"  pattern="yyyy-MM-dd"/>"/>
            </tr>

            <!--   动态展示的  ------------------------------------------------------------------------------------ -->

            <!-- 不可以编辑的 -->
            <tr ${fromtype=='backmodi'||fromtype=='checkview'?'':'style="display:none"'}>
                <td class="bg-gray right">审核结果</td>
                <td colspan="3">
                    ${govguide.auditstate==1 ? '同意行政指导':''}
                    ${govguide.auditstate==2 ? '退回修改':''}
                    ${govguide.auditstate==3 ? '取消行政指导':''}
                </td>
                <td class="bg-gray right">审核人</td>
                <td>${govguide.auditname}</td>
                <td class="bg-gray right">审核日期</td>
                <td><fmt:formatDate value="${govguide.auditdate}" pattern="yyyy-MM-dd"/></td>
            </tr>

            <!-- 可以编辑的 -->
            <tr ${fromtype=='check'?'':'style="display:none"'}>
                <td class="bg-gray right">审核结果</td>
                <td colspan="3">
                    <div class="radio-box">
                        <input name="auditstate" value="1" required
                               type="radio" ${govguide.auditstate==1 ? 'checked':''}>同意行政指导
                        <input name="auditstate" value="2" required
                               type="radio" ${govguide.auditstate==2 ? 'checked':''}>退回修改
                        <input name="auditstate" value="3" required
                               type="radio" ${govguide.auditstate==3 ? 'checked':''}>取消行政指导
                    </div>
                </td>

                <td class="bg-gray right">审核人</td>
                <input type="hidden" name="auditname" value="${govguide.auditname}"/>
                <input type="hidden" name="auditdate"
                       value="<fmt:formatDate value="${govguide.auditdate}"  pattern="yyyy-MM-dd"/>"/>
                <td>${govguide.auditname}</td>
                <td class="bg-gray right">审核日期</td>
                <td><fmt:formatDate value="${govguide.auditdate}" pattern="yyyy-MM-dd"/></td>
            </tr>

            <!--  不可以编辑的 -->
            <tr ${fromtype=='backmodi'||fromtype=='checkview'?'':'style="display:none"'}>
                <td class="bg-gray right">审核意见</td>
                <td colspan="7">${govguide.auditremark} </td>
            </tr>

            <!--  可以编辑的 -->
            <tr ${fromtype=='check'?'':'style="display:none"'}>
                <td class="bg-gray right">审核意见</td>
                <td colspan="7">
                    <div class="form-item">
                        <div class="ipt-box">
                            <input name="auditremark" type="text" required class="ipt-txt"
                                   value="">
                        </div>
                    </div>
                </td>
            </tr>
            <!--   动态展示的end  ------------------------------------------------------------------------------------ -->


            <tr>
                <td class="bg-gray right">行政指导项目</td>
                <td colspan="3">
                    <div class="ipt-box col-6">
                        <select name="adminguideitem"
                                id="adminguideitem" ${fromtype=='checkview'||fromtype=='check'?'disabled="true"':''} >
                            <option value="1" ${govguide.adminguideitem == 1 ? 'selected':''}>
                                其他
                            </option>
                            <option value="2" ${govguide.adminguideitem == 2 ? 'selected':''}>股东出资提示</option>
                            <option value="3" ${govguide.adminguideitem == 3 ? 'selected':''}>许可证即将到期</option>
                            <option value="4" ${govguide.adminguideitem == 4 || govguide.adminguideitem=='' ? 'selected':''}>经营期限即将到期</option>
                            <option value="5" ${govguide.adminguideitem == 5 ? 'selected':''}>长期不开展经营活动</option>
                            <option value="6" ${govguide.adminguideitem == 6 ? 'selected':''}>清算</option>
                        </select>
                    </div>
                </td>


                <td class="bg-gray right">其他送达方式</td>
                <c:set value="${fn:split(govguide.othernoticetype,',')}" var="othernoticetype"/>
                <td colspan="3">
                        <div class="ipt-box col-12">
                            <input type="checkbox" name="othernoticetype" value="1" required
                            ${fromtype!='checkview'?'':'onclick="return false"'}
                                <c:forEach var="o"
                                 items="${othernoticetype}">${o == 1 ? 'checked':''}</c:forEach>  >通过公示系统提醒
                            <input type="checkbox" name="othernoticetype" value="2" required
                            ${fromtype!='checkview'?'':'onclick="return false"'}
                                <c:forEach var="o"
                                           items="${othernoticetype}">${o == 2 ? 'checked':''}</c:forEach>  >企信联连
                            <input type="checkbox" name="othernoticetype" value="3" required
                            ${fromtype!='checkview'?'':'onclick="return false"'}
                                <c:forEach var="o"
                                           items="${othernoticetype}">${o == 3 ? 'checked':''}</c:forEach>  >电子邮件
                            <input type="checkbox" name="othernoticetype" value="4" required
                            ${fromtype!='checkview'?'':'onclick="return false"'}
                                <c:forEach var="o"
                                           items="${othernoticetype}">${o == 4 ? 'checked':''}</c:forEach>  >短信
                        </div>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="bg-gray pdt30lr50b30">
            <div class="form-list2">
                <%-- 1 begin  --%>
                <div id="adminguidecercontent-1" ${govguide.adminguideitem==1||govguide.adminguideitem==null?'':'style="display:none"'}>
                    <div class="form-item2">
                        <div class="item-name2 ">你企业因</div>
                        <div class="ipt-box2">
                            <input id="_adminguidecercontent1" type="text" name="_adminguidecercontent1" required
                                   maxlength="60" class="ipt-txt2 adminguidecercontent-1"
                                   value=""
                            ${fromtype=='checkview'?'readonly="readonly"':''}
                            >
                        </div>
                        <div class="item-name2">的情况，特对你企业提醒提示如下:</div>
                    </div>
                    <div class="form-item2 col-12">
                        <div class="ipt-box2"><textarea rows="5"
                                                        maxlength="300" ${fromtype=='checkview'?'readonly="readonly"':''}
                                                        id="_adminguidecercontent2" name="_adminguidecercontent2"
                                                        required class="adminguidecercontent-1"></textarea>
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
                                   name="_adminguidecercontent3" required
                            ${fromtype=='checkview'?'':'onclick="laydate()"'}
                                   readonly="readonly"
                                   value=""/>
                        </div>
                        <div class="item-name2">前缴纳出资款</div>
                        <div class="ipt-box2">
                            <input id="_adminguidecercontent4" type="text" maxlength="20"
                                   class="ipt-txt2  adminguidecercontent-2"
                                   value=""
                                   name="_adminguidecercontent4" required
                            ${fromtype=='checkview'?'readonly="readonly"':''}
                            >
                        </div>
                    </div>


                    <div class="form-item2">
                        <div class="item-name2">元（其中：</div>
                        <div class="ipt-box2">
                            <input id="_adminguidecercontent5" name="_adminguidecercontent5" required type="text"
                                   class="ipt-txt2  adminguidecercontent-2"
                                   value=""
                            ${fromtype=='checkview'?'readonly="readonly"':''}
                            >
                        </div>
                        <div class="item-name2">），出资期限即将届满，</div>
                        <div class="item-name2 ">特别提醒</div>
                        <div class="ipt-box2">
                            <input id="_adminguidecercontent6" name="_adminguidecercontent6" required type="text"
                                   style="" class="ipt-txt2   adminguidecercontent-2"
                                   value=""
                            ${fromtype=='checkview'?'readonly="readonly"':''}
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
                            <input id="adminguidecercontent-3-code" type="hidden" class="adminguidecercontent-3"
                                   value=""/>
                        </div>
                        <div class="item-name2 " style="cursor:pointer"><font color="red" id="choose">选择许可证</font></div>
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
                    <div class="form-item2">
                        <div class="item-name2 " style="white-space:normal;">
                            <p>你企业章程规定的经营期限即将届满，根据企业登记管理相关法律法规的规定，经营期限到期的企业，应当依法清算注销。</p>
                            <p>如你企业需要继续经营的，建议你企业在期限到期之前，向企业登记机关（工商部门）申请办理经营期限延期变更登记手续。</p>
                            <p>经营期限到期后擅自从事经营活动的，依照无证无照经营予以定性查处。</p>
                        </div>
                    </div>
                </div>
                <%-- 4 end  --%>
                <%-- 5 begin  --%>
                <div id="adminguidecercontent-5"${govguide.adminguideitem==5?'':'style="display:none"'}>
                    <div class="form-item2">
                        <div class="item-name2 " style="white-space:normal;">
                            <p>
                                据了解，你企业已长期未正常开展经营活动，根据《公司法》、《企业法人登记管理条例》等企业登记管理相关法律法规的规定，企业领取执照后6个月未开业或自行停业时间超过6个月以上的，工商部门可以依法吊销企业的营业执照。
                            </p>
                            <p>因此，建议你企业予以重视，加强企业管理，积极从事经营活动，以避免承担因长期未经营而产生的受罚风险。</p>
                        </div>
                    </div>
                </div>
                <%-- 5 end  --%>
                <%-- 6 begin  --%>
                <div id="adminguidecercontent-6"${govguide.adminguideitem==6?'':'style="display:none"'}>
                    <div class="form-item2">
                        <div class="item-name2 " style="white-space:normal;">
                            <p>你公司已办理清算备案，进入清算阶段。现对你公司建议提示如下：</p>
                            <p>1.尽快完成清算工作，并按照规定办理营业执照注销登记。</p>
                            <p>2.进入清算程序的企业，在办理注销手续前，应当办理年检手续。</p>
                        </div>
                    </div>
                </div>
                <%-- 6 end  --%>
                <div class="form-item2">
                    <span class="item-name2">补充说明：</span>
                    <div class="ipt-box2">
                        <input type="text" class="ipt-txt2" name="addremark" maxlength="250"
                               value="${govguide.addremark}" ${fromtype=='checkview'?'readonly="readonly"':''}>
                    </div>
                </div>
                <div class="form-item2">
                    <div class="item-name2">联系人：</div>
                    <div class="ipt-box2">
                        <input type="text" required class="ipt-txt2" name="linkman"
                               value="${govguide.linkman}" ${fromtype=='checkview'?'readonly="readonly"':''}>
                    </div>
                    <div class="item-name2">联系电话：</div>
                    <div class="ipt-box2 ">
                        <input type="text" required telandphone="true" class="ipt-txt2" name="tel"
                               value="${govguide.tel}" ${fromtype=='checkview'?'readonly="readonly"':''}>
                    </div>
                    <div class="item-name2">出具日期：</div>
                    <div class="ipt-box2 ">
                        <input type="text" class="ipt-txt2 "
                        ${fromtype=='checkview'?'':'onclick="laydate()"'}
                               readonly="readonly" name="prodate" required
                               value="<fmt:formatDate value="${govguide.prodate}"  pattern="yyyy-MM-dd"/>"/>
                    </div>
                </div>
                <div class="form-item2">
                    <div class="item-name2">登记机关：</div>
                    <div class="ipt-box2">
                        <input type="text"  readonly="readonly" class="ipt-txt2"
                               name="regorgname" value="${govguide.regorgname}">
                        <input type="hidden" value="${govguide.regorg}" name="regorg"/>
                    </div>
                    <div class="item-name2">管辖单位：</div>
                    <div class="ipt-box2">
                        <input type="text"  readonly="readonly" class="ipt-txt2"
                               name="localadmname" value="${govguide.localadmname}">
                        <input type="hidden" value="${govguide.localadm}" name="localadm" />
                    </div>
                </div>
            </div>
        </div>
        <div class="center mt10">


            <c:if test="${govguide.auditstate=='1'}">
                <input id="print" type="button" class="btn" value="打印">
            </c:if>
            <c:if test="${govguide.auditstate!='1'}">
                <input id="edit_print" type="button" class="btn" value="打印">
            </c:if>
            <c:if test="${fromtype!='checkview'}">
                <input id="save" type="submit" class="btn" value="保 存">
            </c:if>
            <input id="cancel" type="button" class="btn" value="取 消">

        </div>
    </form>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/govguide/govguideadd_edit.js"></script>
</body>
</html>