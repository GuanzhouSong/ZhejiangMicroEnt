<%--
  Created by IntelliJ IDEA.
  User: dxh
  Date: 2017/2/22
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>industry</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/smallent.css"/>"/>
</head>
<body>
<div class="header">
    <h1 class="logo"></h1>
    <span class="logo_text">（浙江）</span>
</div>
<div class="nav">
    <ul class="nav_list">
        <li>
            <a href="http://xwqy.gsxt.gov.cn/home?df=33" >
                <i class="i_n1"></i>
                <span>首页</span>
            </a>
        </li>
        <li>
            <a href="http://xwqy.gsxt.gov.cn/home/mirco/info_list?channelId=2200&organId=33" >
                <i class="i_n2"></i>
                <span>扶持政策集中公示</span>
            </a>
        </li>
        <li>
            <a href="http://xwqy.gsxt.gov.cn/home/mirco/info_list?channelId=2300&organId=33" >
                <i class="i_n3"></i>
                <span>申请扶持导航</span>
            </a>
        </li>
        <li >
            <a href="<c:url value="/pub/smallentsupport/index"/>" >
                <i class="i_n4"></i>
                <span>企业享受扶持信息公示</span>
            </a>
        </li>
        <li class="default">
            <a href="<c:url value="/pub/smallentdir/index"/>" >
                <i class="i_n5"></i>
                <span>小微企业库</span>
            </a>
        </li>
    </ul>
</div>
<div class="mainbody">
    <h2 class="bread_crumbs">当前位置：<a href="">首页</a> > <a href="">小微企业库</a></h2>
    <div class="main_con">
        <div class="mrb_tent">
            <h3 class="mrb_title">
                <span>基本信息</span>
            </h3>
            <table class="mrb_info">
                <col width="20%"/><col width="30%"/><col width="20%"/><col width="30%"/>
                <!-- 个体户 start -->
            <c:if test="${smBaseInfo.entTypeCatg =='50'}">
                <tr>
                    <td class="mf_lf">企业名称：</td>
                    <td>${smBaseInfo.entName}</td>
                    <td class="mf_lf">统一社会信用代码/注册号：</td>
                    <td>${smBaseInfo.regNO}</td>
                </tr>
                <tr>
                    <td class="mf_lf">企业类型：</td>
                    <td>${smBaseInfo.entTypeCatgDesc}</td>
                    <td class="mf_lf">注册日期：</td>
                    <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
                </tr>
                <tr>
                    <td class="mf_lf">资金数额：</td>
                    <td>${smBaseInfo.regCap}万元</td>
                    <td class="mf_lf">登记机关：</td>
                    <td>${smBaseInfo.regOrgDesc}</td>
                </tr>
                <tr>
                    <td class="mf_lf">所属门类：</td>
                    <td>${smBaseInfo.industryMlDesc}</td>
                    <td class="mf_lf">行业代码：</td>
                    <td>${smBaseInfo.industryCo}</td>
                </tr>
            </c:if>
           <!-- 个体户 end -->
          <%--------------------------------------------------------------%>
            <!--  内资公司法人 start -->
            <c:if test="${smBaseInfo.entTypeCatg =='11'}">
                <tr>
                    <td class="mf_lf">企业名称：</td>
                    <td>${smBaseInfo.entName}</td>
                    <td class="mf_lf">统一社会信用代码/注册号：</td>
                    <td>${smBaseInfo.regNO}</td>
                </tr>
                <tr>
                    <td class="mf_lf">企业类型：</td>
                    <td>${smBaseInfo.entTypeCatgDesc}</td>
                    <td class="mf_lf">成立日期：</td>
                    <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
                </tr>
                <tr>
                    <td class="mf_lf">资金数额：</td>
                    <td>${smBaseInfo.regCap}万元</td>
                    <td class="mf_lf">登记机关：</td>
                    <td>${smBaseInfo.regOrgDesc}</td>
                </tr>
                <tr>
                    <td class="mf_lf">所属门类：</td>
                    <td>${smBaseInfo.industryMlDesc}</td>
                    <td class="mf_lf">行业代码：</td>
                    <td>${smBaseInfo.industryCo}</td>
                </tr>
            </c:if>
            <!--  内资公司法人 end -->
            <%--------------------------------------------------------------%>
                <!--  内资非法人企业 start -->
                <c:if test="${smBaseInfo.entTypeCatg =='14'}">
                    <tr>
                        <td class="mf_lf">企业名称：</td>
                        <td>${smBaseInfo.entName}</td>
                        <td class="mf_lf">统一社会信用代码/注册号：</td>
                        <td>${smBaseInfo.regNO}</td>
                    </tr>
                    <tr>
                        <td class="mf_lf">企业类型：</td>
                        <td>${smBaseInfo.entTypeCatgDesc}</td>
                        <td class="mf_lf">成立日期：</td>
                        <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
                    </tr>
                    <tr>
                        <td class="mf_lf">资金数额：</td>
                        <td>${smBaseInfo.regCap}万元</td>
                        <td class="mf_lf">登记机关：</td>
                        <td>${smBaseInfo.regOrgDesc}</td>
                    </tr>
                    <tr>
                        <td class="mf_lf">所属门类：</td>
                        <td>${smBaseInfo.industryMlDesc}</td>
                        <td class="mf_lf">行业代码：</td>
                        <td>${smBaseInfo.industryCo}</td>
                    </tr>
                </c:if>
                <!--  内资非法人企业 end -->

                <%--------------------------------------------------------------%>
                <!--  内资分公司 start -->
                <c:if test="${smBaseInfo.entTypeCatg =='12'}">
                    <tr>
                        <td class="mf_lf">企业名称：</td>
                        <td>${smBaseInfo.entName}</td>
                        <td class="mf_lf">统一社会信用代码/注册号：</td>
                        <td>${smBaseInfo.regNO}</td>
                    </tr>
                    <tr>
                        <td class="mf_lf">企业类型：</td>
                        <td>${smBaseInfo.entTypeCatgDesc}</td>
                        <td class="mf_lf">成立日期：</td>
                        <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
                    </tr>
                    <tr>
                        <td class="mf_lf">登记机关：</td>
                        <td>${smBaseInfo.regOrgDesc}</td>
                        <td class="mf_lf">所属门类：</td>
                        <td>${smBaseInfo.industryMlDesc}</td>
                    </tr>
                    <tr>
                        <td class="mf_lf">行业代码：</td>
                        <td>${smBaseInfo.industryCo}</td>
                        <td class="mf_lf">&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </c:if>
                <!--  内资分公司 end -->

                <%--------------------------------------------------------------%>
                <!--  外商公司法人 start -->
                <c:if test="${smBaseInfo.entTypeCatg =='21'}">
                    <tr>
                        <td class="mf_lf">企业名称：</td>
                        <td>${smBaseInfo.entName}</td>
                        <td class="mf_lf">统一社会信用代码/注册号：</td>
                        <td>${smBaseInfo.regNO}</td>
                    </tr>
                    <tr>
                        <td class="mf_lf">企业类型：</td>
                        <td>${smBaseInfo.entTypeCatgDesc}</td>
                        <td class="mf_lf">成立日期：</td>
                        <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
                    </tr>
                    <tr>
                        <td class="mf_lf">登记机关：</td>
                        <td>${smBaseInfo.regOrgDesc}</td>
                        <td class="mf_lf">所属门类：</td>
                        <td>${smBaseInfo.industryMlDesc}</td>
                    </tr>
                    <tr>
                        <td class="mf_lf">行业代码：</td>
                        <td>${smBaseInfo.industryCo}</td>
                        <td class="mf_lf">&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </c:if>
                <!--  外商公司法人 end -->

                <%--------------------------------------------------------------%>
                <!--  外商投资合伙企业分支机构 start -->
                <c:if test="${smBaseInfo.entTypeCatg =='28'}">
                    <tr>
                        <td class="mf_lf">企业名称：</td>
                        <td>${smBaseInfo.entName}</td>
                        <td class="mf_lf">统一社会信用代码/注册号：</td>
                        <td>${smBaseInfo.regNO}</td>
                    </tr>
                    <tr>
                        <td class="mf_lf">企业类型：</td>
                        <td>${smBaseInfo.entTypeCatgDesc}</td>
                        <td class="mf_lf">成立日期：</td>
                        <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
                    </tr>
                    <tr>
                        <td class="mf_lf">登记机关：</td>
                        <td>${smBaseInfo.regOrgDesc}</td>
                        <td class="mf_lf">所属门类：</td>
                        <td>${smBaseInfo.industryMlDesc}</td>
                    </tr>
                    <tr>
                        <td class="mf_lf">行业代码：</td>
                        <td>${smBaseInfo.industryCo}</td>
                        <td class="mf_lf">&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </c:if>
                <!--  外商投资合伙企业分支机构 end -->

            </table>
        </div>
        <div class="mrb_tent">
            <h3 class="mrb_title">
                <span>享受扶持政策信息</span>
            </h3>
            <c:forEach items="${smSupportInfoList}" var="list">
                <dl class="policy_list">
                    <dt>
                        <span>实施扶持政策的部门：<em>${list.impSpDepart}</em></span>
                        <span>实施扶持政策日期：<em><fmt:formatDate value="${list.impSpDate}" pattern="yyyy年MM月dd日" /></em></span>
                    </dt>
                    <dd>
                        ${list.enjSpContent}
                    </dd>
                </dl>
            </c:forEach>


        </div>
    </div>
</div>
<div class="footer">
    <p>版权所有：浙江省工商行政管理局</p>
    <p>地址：杭州市莫干山路77号金汇大厦北门&nbsp;&nbsp;邮政编码：310005</p>
</div>
</body>
</html>
