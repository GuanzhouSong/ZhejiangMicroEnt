<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>部门维护</title>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
<div class="pd20 clearfix post-permissions">
    <div class="col-6">
        <div class="fl mr40 col-12">
            <div class="col-12" style="overflow-y:auto;height: 600px;width: 300px;">
                <h4 class="ft14"><i class="xbt-icon icon-send-dept"></i><strong>部门列表</strong></h4>
                <ul class="ztree" id="sysDepartTree"></ul>
            </div>
        </div>
    </div>

    <div class="col-6">
        <h4 class="ft14"><strong>部门维护</strong></h4>
        <p class="row mt5" id="optBtns">
        </p>
        <div id="showArea" class="col-12">
        </div>
    </div>
    <script id="optBtnsTemplate" type="text/x-handlebars-template">
        {{#if addBtn}}
        <input type="button" class="btn btn-xs mr5" id="addBtn" value="添 加"/>
        {{/if}}
        {{#if editBtn}}
        <input type="button" class="btn btn-xs mr5"  id="editBtn" value="修 改"/>
        {{/if}}
        {{#if delBtn}}
        <input type="button" class="btn btn-xs"  id="delBtn" value="删 除"/>
        {{/if}}
    </script>
    <script id="viewTemplate" type="text/x-handlebars-template">
        <input type="hidden" id="id" value="{{id}}"/>
        <div class="pd20 clearfix">
            <h3 class="h3-title center"></h3>
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
                <tr>
                    <td class="bg-gray right" width="15%"><span class="light"> </span>上级部门编码：</td>
                    <td width="30%">
                        <div class="ipt-box pd0">
                            {{porgCoding}}
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right" width="15%"><span class="light"> </span>上级部门名称：</td>
                    <td width="30%">
                        <div class="ipt-box pd0">
                            {{parentName}}
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right" width="15%"><span class="light"> </span>部门编码：</td>
                    <td width="30%">
                        <div class="ipt-box pd0">
                            {{orgCoding}}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="15%"><span class="light"> </span>部门名称(简称)：</td>
                    <td width="30%">
                        <div class="ipt-box pd0">
                            {{orgName}}
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right" width="15%"><span class="light"> </span>部门名称(全称)：</td>
                    <td width="30%">
                        <div class="ipt-box pd0">
                            {{organizeAllName}}
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right" width="15%"><span class="light"> </span>职能部门编码：</td>
                    <td width="30%">
                        <div class="ipt-box pd0">
                            {{dutyCodes}}
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right" width="15%"><span class="light"> </span>职能部门名称：</td>
                    <td width="30%">
                        <div class="ipt-box pd0">
                            {{dutyNames}}
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="bg-gray right" width="15%"><span class="light"> </span>行政编码：</td>
                    <td width="30%">
                        <div class="ipt-box pd0">
                            {{adcode}}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="15%"><span class="light"> </span>部门联络员：</td>
                    <td width="30%">
                        <div class="ipt-box pd0">
                            {{liaName}}
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right" width="15%"><span class="light"> </span>联络员电话号码：</td>
                    <td width="30%">
                        <div class="ipt-box pd0">
                            {{liaPhone}}
                        </div>
                    </td>
                </tr>
                <%--<tr>--%>
                    <%--<td class="bg-gray right" width="15%"><span class="light"> </span>DevCoding：</td>--%>
                    <%--<td width="30%">--%>
                        <%--<div class="ipt-box pd0">--%>
                            <%--{{devCoding}}--%>
                        <%--</div>--%>
                    <%--</td>--%>
                <%--</tr>--%>
            </table>
        </div>
    </script>
</div>


<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/sysdepart/list_main.js"></script>
<script type="text/javascript">
    window._CONFIG = {
        treeUrl: '<c:url value="/common/system/sysdepart/treeWithAllDept"/>',
        isAdmin:'${sessionScope.session_sys_user.isAdmin}'
    }
</script>
</body>
</html>
