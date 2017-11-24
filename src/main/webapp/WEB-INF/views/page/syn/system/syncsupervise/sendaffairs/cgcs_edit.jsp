<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>协同事务提请审核面</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="pd20">
    <div class="creat-copy">
        <div class="tabbale" data-component="tab">
            <div class="tab-content">
                <div class="tab-panel tab-panel-show">
                    <div class="">
                        <div class="print-nocard">
                            <h3>
                                <p id="copytitle">部门协同事务提请单（${copySendDto.copyTypeName}）</p>
                                <span>协同事务提请单编号： ${copySendDto.copyFormNo}</span>
                            </h3>
                            <form id="content_form">
                            <p class="right print-data">协同事务提请发起日期：
                                <input type="text" style="border: none;"  value="<fmt:formatDate value="${copySendDto.copyDate}" pattern="yyy年MM月dd日"/>"></p>
                                <input id="copyFormNo" type="hidden" name="copyFormNo" value="${copySendDto.copyFormNo}"/>
                                <input id="copyTypeName" type="hidden" value="${copySendDto.copyTypeName}"/>
                                <input id="copyDate" type="hidden" name="copyDate" value="<fmt:formatDate value="${copySendDto.copyDate}" pattern="yyy-MM-dd"/>"/>
                                
                                <input id="illegalStr" type="hidden" name="illegalStr"/>
                                <div class="bg-gray3">
                                    <table border="0" cellspacing="0" cellpadding="0" class="table-form mt30">
                                        <tbody>
                                        <tr>
                                            <td class="tb-form-hd" width="11.7%">
                                                协同事务提请接收部门
                                            </td>
                                            <td width="52%">
                                                <div class="ipt-box">
                                                    <input id="acceptDepartCodes" class="ipt-txt" type="hidden"
                                                           name="acceptDeptCodes"
                                                           value="${copySendDto.acceptDeptCodes}"/>
                                                    <div class="col-10">
                                                        <input id="acceptDepartNames" class="ipt-txt" type="text"
                                                               style="border:0;" name="acceptDeptNames"
                                                               value="${copySendDto.acceptDeptNames}" readonly/>
                                                    </div>
                                                    <input id="depart_check" type="button" class="btn btn-xs chose"
                                                           value="选择">
                                                </div>


                                            </td>
                                            <td class="tb-form-hd" width="15%">
                                                协同事务提请类型
                                            </td>
                                            <td>
                                                <div class="ipt-box">
                                                    <input id="copyCode" class="ipt-txt" type="hidden" name="copyType"
                                                           value="${copySendDto.copyType}"/>
                                                    <input id="copyType" class="ipt-txt" type="text" name="copyTypeName"
                                                           value="${copySendDto.copyTypeName}" readonly/>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tb-form-hd">涉嫌违法事项</td>

                                            <c:if test="${copySendDto.copyType == 'wzwz'}">
                                                <td>
                                                    <div class="ipt-box">
                                                        <div class="col-10">
                                                            <input id="illegalItem" class="ipt-txt" type="text"
                                                                   style="border: 0;" name="illegalItem"
                                                                   value="${copySendDto.illegalItem}" readonly/>
                                                        </div>
                                                        <input id="chose_item" type="button"
                                                               class="btn btn-xs chose nocard_item" value="选择"/>
                                                    </div>

                                                </td>
                                            </c:if>
                                            <c:if test="${copySendDto.copyType == 'qywfaj'}">
                                                <td>
                                                    <div class="ipt-box">
                                                    <div class="col-10">
                                                        <input id="illegalItem" class="ipt-txt" type="text"
                                                               style="border: 0;" name="illegalItem"
                                                               value="${copySendDto.illegalItem}" readonly/>
                                                    </div>
                                                    <input id="chose_item" type="button"
                                                           class="btn btn-xs chose illegal_item" value="选择"/>
                                                    </div>
                                                </td>
                                            </c:if>
                                            <c:if test="${copySendDto.copyType == 'qt'}">
                                                <td>
                                                    <div class="ipt-box">
                                                    <div class="col-10">
                                                        <input id="illegalItem" class="ipt-txt" type="text"
                                                               style="border: 0;" name="illegalItem"
                                                               value="${copySendDto.illegalItem}"/>
                                                               </div>
                                                    </div>
                                                </td>
                                            </c:if>


                                            <td class="tb-form-hd">
                                                信息来源
                                            </td>
                                            <td>
                                                <div class="radio-box">
                                                    <p><label><input class="copyInfoFrom" type="radio" name="copyInfoFrom" value="jcfx" ${copySendDto.copyInfoFrom=='jcfx'?'checked':''}>检查发现</label>
                                                    <label><input class="copyInfoFrom" type="radio" name="copyInfoFrom" value="qzjb" ${copySendDto.copyInfoFrom=='qzjb'?'checked':''}>群众举报</label></p>
                                                    <p><label><input class="copyInfoFrom" type="radio" name="copyInfoFrom" value="sjjb" ${copySendDto.copyInfoFrom=='sjjb'?'checked':''}>上级交办</label>
                                                    <label><input class="copyInfoFrom" type="radio" name="copyInfoFrom" value="qt" ${copySendDto.copyInfoFrom=='qt'?'checked':''}>其他</label></p>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tb-form-hd"><div class="center">
                                                <input id="add_detail" type="button"
                                                       style="position:static;"
                                                       class="btn btn-xs" value="添加涉嫌违法当事人">
                                            </div></td>
                                            <td colspan="3" class="pd0">
                                                <table id="illegal_table" class="inner-table center">
                                                    <tbody id="tb_ent_bd">
                                                    <tr>
                                                        <th width="12%">当事人姓名</th>
                                                        <th width="15%">证件类型</th>
                                                        <th width="22%">证件号</th>
                                                        <th width="29%">地址</th>
                                                        <th width="15%">当事人联系电话</th>
                                                        <th class="last-col">操作</th>
                                                    </tr>
                                                    <c:forEach var="copySendIllegal" varStatus="status"
                                                               items="${copySendIllegalList}">
                                                        <tr>
                                                            <td>${copySendIllegal.clientName}</td>
                                                            <td cardcode="${copySendIllegal.certType}">${copySendIllegal.certTypeName}</td>
                                                            <td>${copySendIllegal.certNo}</td>
                                                            <td>${copySendIllegal.address}</td>
                                                            <td>${copySendIllegal.clientTel}</td>
                                                            <td class='last-col'><a href='javascript:void(0)' delVal="${copySendIllegal.clientName}">删除</a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tb-form-hd">具体违法情况</td>
                                            <td colspan="3" class="pd3">
                                                <div><textarea name="illegalCase" id="illegalCase" cols=" "
                                                               rows="5">${copySendDto.illegalCase}</textarea></div>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td class="tb-form-hd">证据资料上传
                                                <div class="light bold">单个文件不超过20M</div>
                                            </td>
                                            <td colspan="3" class="pd1">
                                                <div id="filelabel">
                                                    <c:forEach items="${files}" var="obj">
                                                        <p><span path="${obj}" style="color:blue;cursor:pointer"
                                                                 title="点击下载"><i
                                                                class="xbt-icon file-icon"></i>${fn:substringAfter(obj, '-')}</span>
                                                            &nbsp;&nbsp;<a href="javascript:void(0)"
                                                                           path="${obj}">删除</a></p>
                                                    </c:forEach>
                                                </div>
                                                <p class="pd10 file-upload" id="fileList">
                                             <span id="fileBox">
		                            	<input type="file" id="btnFile" class="btnFile" name="btnFile"/>
		                            </span>
                                                    <input type="hidden" id="evidenceData" name="evidenceData"
                                                           value="${copySendDto.evidenceData}"/>
                                                    <input type="hidden" id="file" value=""/>
                                                    <iframe width="0" height="0" name="uploadframe"></iframe>
                                                    说明：支持图片、文档、照片等上传
                                                    <input type="button" id="btnUpload" value="点击上传"/>
                                                    <span id="uploadState" style="color:red;display:none">上传中....</span>
                                                </p>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td class="tb-form-hd">
                                                协同事务提请发起部门
                                            </td>

                                            <td width="52%">
                                                <div class="ipt-box">
                                                    <input id="copyDepartCode" type="hidden"
                                                           value="${copySendDto.copyDepartCode}"/>
                                                    <input id="copyDepartName" type="text" class="ipt-txt" style="border: 0;"
                                                           value="${copySendDto.copyDepartName}" readonly="readonly"/>
                                                </div>
                                            </td>
                                            <td class="tb-form-hd" width="160px">
                                                是否需要反馈处理结果
                                            </td>
                                            <td>
                                                <div class="radio-box">
                                                    <label><input type="radio" name="feedbackNeed"
                                                                  value="0" ${copySendDto.feedbackNeed=='0'?'checked':'' }>是</label>
                                                    <label><input type="radio" name="feedbackNeed"
                                                                  value="1" ${copySendDto.feedbackNeed=='1'?'checked':'' }>否</label>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tb-form-hd">协同事务提请发起部门联系人</td>
                                            <td >
                                                <div class="ipt-box">
                                                <input id="copyDepartPerson" name="copyDepartPerson" type="text" value="${copySendDto.copyDepartPerson }" class="ipt-txt">
                                                </div>
                                            </td>
                                            <td class="tb-form-hd">
                                                联系电话（必填）
                                            </td>
                                            <td>
                                                <div class="ipt-box">
                                                    <input id="copyDepartTel" name="copyDepartTel" type="text" class="ipt-txt"
                                                           value="${copySendDto.copyDepartTel }">
                                                </div>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tb-form-hd">
                                                传真
                                            </td>
                                            <td>
                                                <div class="ipt-box">
                                                    <input id="copyDepartFax" name="copyDepartFax" type="text" class="ipt-txt"
                                                           value="${copySendDto.copyDepartFax }">
                                                </div>

                                            </td>
                                            <td class="tb-form-hd">
                                                电子邮件
                                            </td>
                                            <td>
                                                <div class="ipt-box">
                                                    <input id="copyDepartMail" name="copyDepartMail" type="text" class="ipt-txt"
                                                           value="${copySendDto.copyDepartMail}">
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>

                                </div>
                                <p class="center mt20">
                                    <input id="print" type="button" class="btn mr20" value="打 印">
                                    <input id="save" type="button" class="btn mr20" value="提交">
                                    <input id="cancel" type="button" class="btn mr20" value="取消编辑"></p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
    </div>
    <script>
		if("${sysUser.userType}" == "1"){
			 window._CONFIG = {
		    		_urlHead:'/reg/server/sendaffairs/',
		    		_illegalitemUrlHead:'/reg/server/illegalitem/',
		     }
		}else{
			window._CONFIG = {
		    		_urlHead:'/syn/sendaffairs/',
		    		_illegalitemUrlHead:'/syn/illegalitem/',
		     }
		}
</script>
    <script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
    <script>
        $(function () {
            $("#filelabel").delegate('span', 'click', function () {
                var path = $(this).attr("path");
                window.open("/syn/sendaffairs/download?fileName=" + path);
            });
        })
    </script>

    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script src="/js/syn/system/sendaffairs/cgcs_edit.js"></script>
</body>
</html>