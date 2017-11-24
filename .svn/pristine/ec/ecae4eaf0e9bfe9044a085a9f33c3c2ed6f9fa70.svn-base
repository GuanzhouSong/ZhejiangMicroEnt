<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="nowdate" class="java.util.Date" />
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 视图适配  -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- 360浏览器默认视图 -->
    <meta name="renderer" content="webkit">
    <title>党建活动新增</title>
    <link rel="stylesheet" type="text/css" href="/css/reg.server.css"/>
</head>
<body>
<div class="form-box bgfff mb5">
    <div class="form-list">
        <form id="content_form">
            <input type="hidden" id="setDeptCode" value="${sysUser.departMent.deptCode}"/>
			<input type="hidden" id="inputState" name="inputState"  value="${inputState}"/>
            <div class="form-item clearfix pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span>活动发布部门：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="hidden" id="publishDeptUID" name="publishDeptUID" >
                            <input type="text" id="publishDeptName" name="publishDeptName"  class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;">
                            <span class="add-icon" id="chosePublishDept"><i></i></span>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-4"><span class="red">*</span>活动发布日期：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" id="publishDate" name="publishDate" readonly="readonly" onclick="laydate();" class="ipt-txt clx">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span>活动类别：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <select name="activityType" id="activityType" >
                                <option value="1" >重点常规活动</option>
                                <option value="2" >党员日常活动</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-4"><span class="red">*</span>要求活动结束日期：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" id="requireEndDate" name="requireEndDate" readonly="readonly" onclick="laydate();" class="ipt-txt clx">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125"><span class="red">*</span>活动名称：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <input type="text" id="activityName" name="activityName"   class="ipt-txt clx" >
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125 wfss-lb"><span class="red">*</span>活动内容：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <textarea class="wfss-tt" name="activityContent" id="activityContent" style="resize: none;" maxlength="500" cols="30" rows="10"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125"><span class="red">*</span>活动接收部门：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <input type="hidden" id="claimDeptUID" name="claimDeptUID" >
                            <input type="text" id="claimDeptName" name="claimDeptName"   class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;">
                            <span class="add-icon" id="choseClaimDept"><i></i></span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix mb5 pd50">
                <div class="col-12">
                    <label class="item-name w125"><span class="red">*</span>活动附件：</label>
                    <div class="w875">
                        <div class="ipt-box col-9">
                            <div class="file-box mr5">
                            	<input type="button" class="btn btn-sm file-btn" value="添加附件">
                                <span id="fileBox"><input type="file" class="btnFile" name="btnFile" id="btnFile"></span>
                            </div>
                            <input type="hidden" id="files" name="upfilePath" value=""/>
                            <input type="hidden" id="file" value=""/>
                        </div>
                        <div class="col-4 fr file-explain">说明：支持图片、文档等上传</div>
                    </div>
                </div>
            </div>
			<div id="filelabel" style="padding-left:16%;">
			</div>
			
            <div class="form-item clearfix mb5 pd50">
                <div class="col-6">
                    <label class="item-name col-3">录入员：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                       		<input type="hidden" name="inputCode" id="inputCode"  value="${sysUser.id}" />
                            <input style="background-color: #f4f4f4;" readonly="readonly" type="text" class="ipt-txt clx" name="inputName" value="${sysUser.realName}">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3">录入日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input style="background-color: #f4f4f4;" readonly="readonly" type="text"  class="ipt-txt clx" name="inputDate" value="<fmt:formatDate value="${nowdate}" type="date" pattern="yyyy-MM-dd"/>">
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="form-item clearfix">
                <div class="btn-box mt10">
                    <input type="button" value="提交" id="savebutton" class="btn mr20">
                    <input type="button" value="关闭" id="cancel"  class="btn mr20">
                </div>
            </div>
        </form>
    </div>
</div>
<script>
	var userType = '${sessionScope.session_sys_user.userType}';
	var url='/common/system/sysdepart/alldeptcheckboxtreeselect';
	var urlHead = '/reg/server';
	if(userType==2){
		url='/syn/system/sysdepart/alldeptcheckboxtreeselect';
		urlHead='/syn';
	}
    window._CONFIG = {
   		select_dept_url: url,
   		urlHead: urlHead
    }
</script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/partycreate/partactivity/activityinput_add.js"></script>
</body>
</html>
