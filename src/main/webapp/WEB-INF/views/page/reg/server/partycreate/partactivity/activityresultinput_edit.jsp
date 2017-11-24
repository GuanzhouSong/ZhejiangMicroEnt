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
    <title>党建活动结果录入</title>
    <link rel="stylesheet" type="text/css" href="/css/reg.server.css"/>
</head>
<body>
<div class="form-box bgfff mb5 pdt15 pdb46">
    <div class="form-list">
        <form id="pre_form">
            <div class="form-item clearfix pd50">
               <div class="col-7">
                    <label class="item-name col-3"><span class="ml-15">活动发布部门：</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="hidden" id="publishDeptUID" >
                            <input type="text" id="publishDeptName" name="publishDeptName"  value="${partyActivityInfoDto.publishDeptName }" class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;">
                        </div>
                    </div>
                </div>
                <div class="col-5">
                    <label class="item-name col-6">活动发布日期：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="publishDate" name="publishDate" class="ipt-txt clx" readonly="readonly" value="<fmt:formatDate value="${partyActivityInfoDto.publishDate}" type="date" pattern="yyyy-MM-dd"/>" style="background-color: #f4f4f4;">
                        </div>
                    </div>
                </div>                
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-7">
                    <label class="item-name col-3">活动类别：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;" value="${partyActivityInfoDto.activityType == '1' ? '重点常规活动' : '党员日常活动'}">
                        </div>
                    </div>
                </div>
                <div class="col-5">
                    <label class="item-name col-6">要求活动结束日期：</label>
                    <div class="col-6">
                        <div class="ipt-box col-12">
                            <input type="text" id="requireEndDate" class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;" value="<fmt:formatDate value="${partyActivityInfoDto.requireEndDate}" type="date" pattern="yyyy-MM-dd"/>" >
                        </div>
                    </div>
                </div>
            </div>            
             <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w146">活动名称：</label>
                    <div class="w854">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;" value="${partyActivityInfoDto.activityName}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w146 wfss-lb1">活动内容：</label>
                    <div class="w854">
                        <div class="ipt-box col-12">
                            <textarea class="wfss-tt1" name="" cols="30" rows="10" readonly="readonly" style="background-color: #f4f4f4;">${partyActivityInfoDto.activityName}</textarea>
                        </div>

                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w146">活动附件：</label>
                    <div class="w854">
                        <div class="ipt-box col-12" id="upfile">
                        <c:forEach items="${upfiles}" var="obj">
                            <span path="${obj}" class="active-file xbt-icon" style="cursor:pointer" title="点击下载">${fn:substringAfter(obj, '-')}</span>
		                </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
           </form>           			
           <form id="content_form">
            <input type="hidden" id="setDeptCode" value="${sysUser.departMent.deptCode}"/>
			<input type="hidden" id="inputState" name="inputState"  value="1"/>
			<input type="hidden" id="uid" name="UID" value="${partyActivityInfoDto.UID}"/> 
            <p class="result-info">党建活动结果信息</p>
            <div class="form-item clearfix pd50">
                <div class="col-7">
                    <label class="item-name col-3"><span class="light">*</span>活动地点：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" id="activityPlace" name="activityPlace" value="${partyActivityInfoDto.activityPlace}">
                        </div>
                    </div>
                </div>
                <div class="col-5">
                    <label class="item-name col-4">所在党组织：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="hidden" id="claimDeptUID" name="claimDeptUID" value="${partyActivityInfoDto.claimDeptUID}">
                            <input type="text" class="ipt-txt clx" id="claimDeptName" name="claimDeptName" value="${partyOrganizeInfo.partyOrgName}" readonly="readonly">
                        </div>
                    </div>
                </div>
            </div> 
            <div class="form-item clearfix pd50">
                <div class="col-7">
                    <label class="item-name col-3"><span class="ml-15"><em class="light">*</em> 活动起止时间：</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt zxyxq-btn clx" id="activitybeginDate" name="activitybeginDate" onclick="laydate();" readonly="readonly" value="<fmt:formatDate value="${partyActivityInfoDto.activitybeginDate}" type="date" pattern="yyyy-MM-dd"/>">
                            <span class="date-middle-line"></span>
                            <input type="text" class="ipt-txt zxyxq-btn clx" id="activityEndDate" name="activityEndDate" onclick="laydate();" readonly="readonly" value="<fmt:formatDate value="${partyActivityInfoDto.activityEndDate}" type="date" pattern="yyyy-MM-dd"/>">
                        </div>
                    </div>
                </div>
                <div class="col-5">
                    <label class="item-name col-4">管辖单位：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="hidden" id="claimLocalAdm" name="claimLocalAdm" value="${partyOrganizeInfo.localAdm}">
                            <input type="text" class="ipt-txt clx" name="claimLocalAdmName" id="claimLocalAdmName" value="${partyOrganizeInfo.localAdmName}" readonly="readonly">
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix pd50">
                <div class="col-7">
                    <label class="item-name col-3"><span class="light">*</span> 活动发起人：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" id="originator" name="originator" value="${partyActivityInfoDto.originator}" readonly="readonly">
                            <input type="hidden" id="originatorID" name="originatorID" value="${partyActivityInfoDto.originatorID}" >
                            <span class="add-icon" id="chooseoriginator"><i></i></span>
                        </div>
                    </div>
                </div>
                <div class="col-5">
                    <label class="item-name col-4">参与人数：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" id="joinNum" name="joinNum" readonly="readonly" value="${partyActivityInfoDto.joinNum}">
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w146 wfss-lb1"><span class="light">*</span> 活动参与人：</label>
                    <div class="w854">
                        <div class="ipt-box col-11">
                            <textarea class="wfss-tt1" id="joiner" name="joiner" cols="30" rows="10" readonly="readonly">${partyActivityInfoDto.joiner}</textarea>
                            <input type="hidden" id="joinerId" name="joinerId" value="${partyActivityInfoDto.joinerId}" >
                        </div>
                        <div class="btn-box col-1">
                            <input type="button" value="选择" class="btn1" id="choosejoiner">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w146 wfss-lb1"><span class="light">*</span> 活动情况：</label>
                    <div class="w854">
                        <div class="ipt-box col-12">
                            <textarea class="wfss-tt1" name="activitySituation" id="activitySituation" maxlength="500" cols="30" rows="10">${partyActivityInfoDto.activitySituation}</textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb5 pd50">
                <div class="col-12">
                    <label class="item-name w146"><span class="light">*</span> 结果附件：</label>
                    <div class="w854">
                        <div class="ipt-box col-12">
                            <div class="file-box mr5">
                                <input type="button" class="btn btn-sm file-btn" value="添加附件" style="font-size: 12px;">
                                <span id="fileBox"><input type="file" class="btnFile" name="btnFile" id="btnFile"></span>
                            </div>
                            <input type="hidden" id="files" name="resultFilePath" value="${partyActivityInfoDto.resultFilePath}"/>
                            <input type="hidden" id="file" value=""/>
                        </div>
                        <div class="col-4 fr file-explain">说明：支持图片、文档等上传</div>
                    </div>
                </div>
            </div>            
            <div id="filelabel" style="padding-left:18%;">
				<c:forEach items="${files}" var="obj">
                     <p><span path="${obj}" style="color:blue;cursor:pointer" title="点击下载"><i class="xbt-icon file-icon"></i>${fn:substringAfter(obj, '-')}</span>
                         &nbsp;&nbsp;<a href="javascript:void(0)" path="${obj}">删除</a></p>
                </c:forEach>
			</div>            
            <div class="form-item clearfix pd50">
                <div class="col-7">
                    <label class="item-name col-3">录入员：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="hidden" name="resultInputCode" id="resultInputCode"  value="${sysUser.id}" />
                            <input type="text" name="resultInputName" class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;" value="${sysUser.realName}">                        </div>
                    </div>
                </div>
                <div class="col-5">
                    <label class="item-name col-4">录入日期：</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;" name="resultInputDate" value="<fmt:formatDate value="${nowdate}" type="date" pattern="yyyy-MM-dd"/>">
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
<script src="/js/reg/server/partycreate/partactivity/activityresultinput_edit.js"></script>
</body>
</html>
