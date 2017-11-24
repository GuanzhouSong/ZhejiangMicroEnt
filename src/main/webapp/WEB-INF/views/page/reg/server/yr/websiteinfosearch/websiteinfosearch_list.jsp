<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!doctype html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>网站网店信息查询</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="taskForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">年报主体：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="checkbox" name="entTypeCatgCode" value="13,34,26,14,33,23,11,12,32,21,25,24,15,22,31,27,28" checked="checked">企业
                            <input type="checkbox" name="entTypeCatgCode" value="16,17" checked="checked">农专社
                            <input type="checkbox" name="entTypeCatgCode" value="50" checked="checked">个体户
                        </div>
                        <input type="hidden" name="entTypeCatg" id="entTypeCatg">
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="regno" placeholder="可输入尾号后四位查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">法定代表人/负责人：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="leRep">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">类型：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="checkbox" name="webTypeCode" value="1" checked="checked">网站
                            <input type="checkbox" name="webTypeCode" value="2" checked="checked">网店
                        </div>
                        <input type="hidden" name="webType" id="webType">
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="entName" placeholder="可输入名称关键词查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
                            <input type="text" class="ipt-txt" id="regOrgName" value=""/>
                        <span class="add-icon" id="choseorgReg">
                            <i></i>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">网站类型：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="webSmallType">
                            	<option value="">全部</option>
                            	<option value="1">交易网站</option>
                            	<option value="2">信息网站</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5"> 年报年度：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="yrYear" id="yrYear">
                            	<c:forEach var="year" items="${yearList}">
                                	<option value='${year-1 }'>${year-1 }</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
				<div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="regUnit" id="regUnit" value=""/>
                            <input type="text" class="ipt-txt" id="regUnitName" value=""/>
	                            <span class="add-icon" id="choseregUnit">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
            	<div class="col-4">
                    <label class="item-name col-5">网站网店名称：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="webSitName" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">网址（域名）：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt" name="webSite" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<input type="hidden" name="regState" id="regState">
                            <select name="regStateM" id="regStateM" multiple="multiple">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix" id="hiddendiv1" style="display: none;">
            	<div class="col-4">
                    <label class="item-name col-5">网店所属平台：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <select name="belongPlatFormName">
                            	<option value="">全部</option>
                            	<option value="天猫">天猫</option>
                            	<option value="淘宝">淘宝</option>
                            	<option value="京东">京东</option>
                            	<option value="1688">1688</option>
                            	<option value="other">其他</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">ICP备案号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input  class="ipt-txt" name="icpBackNO" id="icpBackNO" value=""/>
                          </span>
                        </div>
                    </div>
                </div>
				<div class="col-4">
                    <label class="item-name col-5">行业：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="hidden" class="ipt-txt" name="industryCo" id="industryCo" value=""/>
                            <input type="text" readonly="readonly" class="ipt-txt" id="industryCoName" value=""/>
	                            <span class="add-icon" id="choseindustry">
	                                <i></i>
	                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix" id="hiddendiv2" style="display: none;">
            	<div class="col-4">
                    <label class="item-name col-5">微信公众号：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input class="ipt-txt" name="weChatPublicNO" id="weChatPublicNO" value=""/>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name col-5">手机APP服务：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                        	<input type="text" class="ipt-txt" name="appNames" id="appNames">
                        </div>
                    </div>
                </div>
				<div class="col-4">
                    <label class="item-name col-5">企业类型：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
	                        	<input type="hidden" class="ipt-txt" name="entType" id="entType" value=""/>
	                            <input type="text" readonly="readonly" class="ipt-txt" id="entTypeName" value="" />
		                         <span class="add-icon" id="chooseEntType">
	                                <i></i>
		                         </span>
	                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="mt10">
            <div class="center">
                <input type="button" value="查 询" id="search" class="btn mr20">
                <input type="button" value="重 置" id="cancel" class="btn mr20" onclick="$('#taskForm')[0].reset();">
                <input type="button" value="更多查询条件" id="moresearch" class="btn mr20">
            </div>
        </div>
    </form>
<!--     <div class="light-info"> -->
<!--     <span class="light">提示：此处仅查询已年报的企业信息。</span> -->
<!-- 	</div> -->
	<p class="tip-info left mb5">查询结果：
            企业<span id="entTotal"class="light-blue">0</span>户，
            网站<span id="websiteTotal"class="light-blue">0</span>个，
            网店<span id="onlinestoreTotal"class="light-blue">0</span>个。
    </p>
    <div class="mt10">
        <div class="iframe-wrap">
            <table id="permit-table" class="table-row display nowrap" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>统一信用代码/注册号</th>
                    <th>企业名称</th>
                    <th>年报年度</th>
                    <th>类型</th>
                    <th>网站类型/网店所属平台</th>
                    <th>网站网店名称</th>
                    <th>网址（域名）</th>
                    <th>ICP备案号</th>
                    <th>微信公众号</th>
                    <th>手机APP服务</th>
                    <th>发货地址</th>
                    <th>退货地址</th>
                    <th>法定代表人</th>
                    <th>联系电话</th>
                    <th>联络员</th>
                    <th>联络员电话</th>
                    <th>住所</th>
                    <th>登记机关</th>
                    <th>管辖单位</th>
                    <th>登记状态</th>
                </tr>
                </thead>
            </table>
        </div>
  </div>
  </div>
        <script src="/js/lib/require.js"></script>
        <script src="/js/config.js"></script>
        <script src="/js/reg/server/yr/websiteinfosearch/websiteinfosearch_list_main.js"></script>
</body>
</html>
