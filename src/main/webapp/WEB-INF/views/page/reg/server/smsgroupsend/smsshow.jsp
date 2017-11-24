<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>短信任务详情</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<form id="smsForm">
<input type="hidden" name="deptId" value="${deptId}" />
    <h3 class="h22-title center"></h3>
    <div class="pd10 bg-gray">
        <div class="clearfix">
            <div class="col-8 border0">
                <h5 class="h6-title mb10">短信任务信息</h5>
                <div class="form-list">
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2"><span class='light'>*</span>短信任务名称：</div>
                            <div class="col-10">
                                <div class="ipt-box">
                                    <input type="text" name="taskName" class="ipt-txt" value="" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <div class="item-name col-4"><span class='light'>*</span>短信任务模板：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <select name="smsType" id="smsType">
                                    	<option value="1">年报提醒(适用企业、农专社)</option>
                                    	<option value="2">年报提醒(适用个体工商户)</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2"></div>
                            <div class="col-10">
                                <div class="ipt-box">
                                	<input type="hidden" id="deptName" value="${deptName }">
                                    <textarea readonly="readonly" id="smsMsg" name="smsMsg" rows="3" cols="50">【${deptName }】企业年报至6月30日结束，请及时登录公示系统zj.gsxt.gov.cn报送，逾期将被列入异常名录，如已报送请忽略。</textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <div class="item-name col-4"><span class='light'>*</span>短信发送对象：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="checkbox" name="smsLerep" id="smsLerep"> 负责人&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="checkbox" name="smsLia" id="smsLia"> 联络员
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="item-name col-3"><span class='light'>*</span>任务开始日期：</div>
                            <div class="col-9">
                                <div class="ipt-box">
                                    <input type="hidden" name='smsDate' id="hiddensmsDate"> 
                                    <label><input type="checkbox" name="isCurrentTask" id="isCurrent" checked="checked"/>当前日期</label>
                                    <input type="text" id="smsDate" onclick="" readonly="readonly" class="ipt-txt" required="required"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2">任务原始名单：</div>
                            <div class="col-10">
                                <div class="ipt-box">
                                	<p class="noread-txt">${smsIntroduction }</p>
                                    <input type="hidden" name="smsIntroduction" id="smsIntroduction" value="${smsIntroduction }" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2">手机号码去重：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="checkbox" disabled="disabled" name="repeatLerep" id="repeatLerep"> 负责人手机号去重&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="checkbox" disabled="disabled" name="repeatLia" id="repeatLia"> 联络员手机号去重
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2">任务去重名单：</div>
                            <div class="col-10">
                                <div class="ipt-box">
                                	<input type="hidden" id="rsmsIntroductionAnd" value="${rsmsIntroductionAnd }" />
                                	<input type="hidden" id="rsmsIntroductionLerep" value="${rsmsIntroductionLerep }" />
                                	<input type="hidden" id="rsmsIntroductionLia" value="${rsmsIntroductionLia }" />
                                	<p class="noread-txt" id="rsms" ></p>
                                    <input type="hidden" id="rsmsIntroduction" name="rsmsIntroduction" value="" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4">
            	<div class='pdl10'>
	                <h5 class="h6-title mb10 pdl10">发送任务说明（<span class="light">200</span>字内）</h5>
	                <div class="ipt-box pd0 clearfix h300">
	                	<textarea cols="" rows="19" class='border0' name="taskInstruction"></textarea>
	                </div>
                </div>
            </div>
            <div class="clear">
	            <div class="form-item ">
	                <div class="col-4">
	                    <div class="item-name col-4">设置人：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" readonly="readonly" name="setName" class="ipt-txt"  value="${setName}" />
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-4">设置日期：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" readonly="readonly" id="setTime" name="setTime" class="ipt-txt"  value="" />
	                        </div>
	                    </div>
	                </div>
	                <div class="col-4">
	                    <div class="item-name col-3">设置部门：</div>
	                    <div class="col-6">
	                        <div class="ipt-box">
	                            <input type="text" readonly="readonly" name="deptName" class="ipt-txt"  value="${deptName}" />
	                        </div>
	                    </div>
	                </div>
                </div>
            </div>
        </div>
    </div>
    <p class="center mt10 mb10">
        <input type="submit" class="btn mr20" value="确定"/>
        <input type="button" class="btn" value="关闭"  id="cancel"/>
    </p>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/smsgroupsend/smsshow.js"></script>
</body>
</html>