<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>协同事务提请主页面</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="pd20">
    <div class="creat-copy">
        <div class="tabbale" data-component="tab">
            <div class="tab-header type-tab clear pdb10 border-bottom">
                <label class="right">请协同事务提请类型：</label>
                <ul class="clearfix">
                    <li class="tab-selected"><span class="tab-item"><a id="nocard">无证无照</a></span></li>
                    <li><span class="tab-item"><a id="illegal">企业违法案件线索</a></span></li>
                    <li><span class="tab-item"><a id="other">其它情况协同事务提请</a></span></li>
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-panel tab-panel-show">
                    <div class="">
                        <div class="print-nocard">
                            <h3>
                                <p id="copytitle">部门协同事务提请单（无证无照信息）</p>
                            </h3>
                            <p class="right print-data">协同事务提请发起日期：${date}</p>

                            <form id="content_form">
                                <input id="illegalStr" type="hidden" name="illegalStr"/>
                                <table border="0" cellspacing="0" cellpadding="0" class="table-form mt30">
                                    <tbody>
                                    <tr>
                                        <td class="tb-form-hd" width="11.7%">
                                            协同事务提请接收部门
                                        </td>
                                        <td width="52%">
                                            <div class="ipt-box">
                                                <input id="acceptDepartCodes" class="ipt-txt" type="hidden"
                                                       name="acceptDeptCodes"/>
                                                <div class="col-10">
                                                    <input id="acceptDepartNames" class="ipt-txt" type="text"
                                                           style="border:0;" name="acceptDeptNames" placeholder="请选择部门"
                                                           readonly/>
                                                </div>
                                                <input id="depart_check" type="button" class="btn btn-xs chose" value="选择">
                                            </div>


                                        </td>
                                        <td class="tb-form-hd" width="15%">
                                            协同事务提请类型
                                        </td>
                                        <td>
                                            <div class="ipt-box">
                                                <input id="copyCode" class="ipt-txt" type="hidden" name="copyType"
                                                       value="wzwz"/>
                                                <input id="copyType" class="ipt-txt" type="text" value="无证无照" readonly/>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tb-form-hd">涉嫌违法事项</td>
                                        <td>
                                            <div class="ipt-box clear">
                                                <div class="col-10">
                                                    <input id="illegalItem" placeholder="请选择涉嫌违法事项" class="ipt-txt"
                                                           type="text" style="border: 0;" name="illegalItem" readonly/>
                                                </div>
                                                <input id="chose_item" type="button"
                                                       class="btn btn-xs chose nocard_item" value="选择"/>
                                            </div>

                                        </td>
                                        <td class="tb-form-hd">
                                            信息来源
                                        </td>
                                        <td>
                                            <div class="radio-box">
                                                <p><label><input type="radio" name="copyInfoFrom" value="jcfx">检查发现</label>
                                                <label><input type="radio" name="copyInfoFrom" value="qzjb">群众举报</label></p>
                                                <p><label><input type="radio" name="copyInfoFrom" value="sjjb">上级交办</label>
                                                <label><input type="radio" name="copyInfoFrom" value="qt">其他</label></p>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tb-form-hd"><div class="center pos-rel">
                                            <input id="add_detail" type="button"
                                                    class="btn btn-xs"
                                                   value="添加涉嫌违法当事人">
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
                                                </tbody>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tb-form-hd">具体违法情况</td>
                                        <td colspan="3" class="pd3">
                                            <div><textarea name="illegalCase" id="illegalCase" cols=" " rows="5">具体违法情况如下：</textarea>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="tb-form-hd">证据资料上传
                                            <div class="light bold">单个文件不超过20M</div>
                                        </td>
                                        <td colspan="3" class="pd1">
                                            <div id="filelabel"></div>
                                            <p class="pd10 file-upload" id="fileList">
                                                <!-- <form target="uploadframe" id="needHide" action="/项目名/project.do?method=fileUpLoad" method="post" enctype="multipart/form-data"> -->
											<span id="fileBox">
				                            	<input type="file" id="btnFile" class="btnFile" name="btnFile"/>
				                            </span>
                                                <input type="hidden" id="evidenceData" name="evidenceData" value=""/>
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
                                            	<c:if test="${sessionScope.session_sys_user.userType == 1}">
                                            	<input id="copyDepartCode" type="hidden" name="copyDepartCode"  value="${sysUser.deptCode}"/>
				                                </c:if>
				                                <c:if test="${sessionScope.session_sys_user.userType == 2}">
				                                <input id="copyDepartCode" type="hidden" name="copyDepartCode"  value="${sysUser.sysDepart.adcode}"/>
				                                </c:if> 
                                                
                                                
                                                <input type="text" class="ipt-txt" style="border: 0;"
                                                       name="copyDepartName" value="${sysUser.dept}"
                                                       readonly="readonly"/>
                                            </div>
                                        </td>
                                        <td class="tb-form-hd" width="160px">
                                            是否需要反馈处理结果
                                        </td>
                                        <td>
                                            <div class="radio-box">
                                                <label><input type="radio" name="feedbackNeed" value="0">是</label>
                                                <label><input type="radio" name="feedbackNeed" value="1">否</label>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tb-form-hd">协同事务提请发起部门联系人</td>
                                        <td >
                                        <div class="ipt-box" >
                                                <input id="copyDepartPerson" name="copyDepartPerson" type="text" class="ipt-txt">
                                            </div>
                                        </td>
                                        <td class="tb-form-hd" width="160px">
                                            联系电话（必填）
                                        </td>
                                        <td>
                                            <div class="ipt-box" >
                                                <input name="copyDepartTel" type="text" class="ipt-txt">
                                            </div>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tb-form-hd">
                                            传真
                                        </td>
                                        <td >
                                            <div class="ipt-box">
                                                <input name="copyDepartFax" type="text" class="ipt-txt">
                                            </div>

                                        </td>
                                        <td class="tb-form-hd" >
                                           电子邮件
                                        </td>
                                        <td>
                                            <div class="ipt-box">
                                                <input name="copyDepartMail" type="text" class="ipt-txt">
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                        <p class="center mt20">
<!--                             <input id="print" type="button" class="btn mr20" value="打 印"> -->
                            <input id="save" type="button" class="btn mr20" value="保存并提交审核">
                            <input id="cancel" type="button" class="btn mr20" value="取消编辑"></p>
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

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sendaffairs/cgcs_add.js"></script>
</body>
</html>