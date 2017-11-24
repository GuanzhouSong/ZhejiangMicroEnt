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
    <title>区域管理员查看</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>

<form id="sysUserForm">
    <h3 class="h22-title center"></h3>
    <div class="pd10 bg-gray">
        <div class="border-bottom clearfix">
            <div class="fl w70p" style="width: 100%">
                <h5 class="h6-title mb10">区域管理员基本信息</h5>
                <div class="form-list border-bottom pdr10">
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <div class="item-name col-4"><span class="light"></span>姓名：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" name="realName" class="ipt-txt" readonly="readonly" value="${sysUser.realName}"  >
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="item-name col-3"><span class="light"></span>所属部门：</div>
                            <div class="col-9">
                                <div class="ipt-box">
                                    <input type="text" id="s_deptName" class="ipt-txt" readonly="readonly" value="${sysUser.dept}"  readonly="readonly" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <div class="item-name col-4"><span class="light"> </span>手机：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" name="telPhone" class="ipt-txt"   readonly="readonly"  value="${sysUser.telPhone}" />
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="item-name col-3">科室：</div>
                            <div class="col-9">
                                <div class="ipt-box">
                                    <input type="text"   class="ipt-txt"  value="${sysUser.deptName}" readonly="readonly"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <div class="item-name col-4"><span class="light"></span>座机：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" name="phone" class="ipt-txt" value="${sysUser.phone}" readonly="readonly"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="item-name col-3">职务：</div>
                            <div class="col-9">
                                <div class="ipt-box">
                                    <input type="text" name="post" class="ipt-txt" value="${sysUser.post}" readonly="readonly"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2"><span class="light"></span>工作电话：</div>
                            <div class="col-3">
                                <div class="ipt-box">
                                    <input type="text" name="phoneExt" class="ipt-txt" value="${sysUser.phoneExt}" readonly="readonly"/>
                                </div>
                            </div>
                            <div class="item-name col-6 left"></div>
                        </div>
                    </div>
                    <div class="form-item clearfix">

                        <div class="col-6">
                            <div class="item-name col-4"><span class="light"> </span>单位：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text" name="jurUnit" class="ipt-txt"  value="${sysUser.jurUnit}" readonly="readonly"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="item-name col-3"><span class="light"> </span>电子邮箱：</div>
                            <div class="col-9">
                                <div class="ipt-box">
                                    <input type="text" name="email" class="ipt-txt" value="${sysUser.email}" readonly="readonly"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-12">
                            <div class="item-name col-2"><span class="light"> </span>办公地址：</div>
                            <div class="col-10">
                                <div class="ipt-box">
                                    <input type="text" name="desc" class="ipt-txt" value="${sysUser.desc}" readonly="readonly"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-list border-bottom pdr10">
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <div class="item-name col-4"><span class="light"></span>用户名：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text"  readonly="readonly" value="${sysUser.username}" class="ipt-txt"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="item-name col-4"><span class="light"></span>账户状态：</div>
                            <div class="col-8">
                                <div class="radio-box">
                                        <label class="font-12">
                                        <input type="radio" name="status" disabled="disabled"
                                               value="1" ${sysUser.status=='1'?'checked':''}/>有效
	                                    </label>
	                                    <label class="font-12">
	                                        <input type="radio" name="status"  disabled="disabled"
	                                               value="0" ${sysUser.status=='0'?'checked':''}/>无效
	                                    </label> 
                                </div>
                            </div>
                        </div>
                    </div> 
                </div>
                <div class="form-list border-bottom pdr10">
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <div class="item-name col-4"><span class="light"></span>设置人：</div>
                            <div class="col-6">
                                <div class="ipt-box">
                                    <input type="text"  readonly="readonly" value="${sysUserAreaManage.setName}" class="ipt-txt"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="item-name col-4"><span class="light"></span>设置日期：</div>
                            <div class="col-8">
                            	<div class="ipt-box">
                            	<input type="text"  readonly="readonly" value="<fmt:formatDate  value="${sysUserAreaManage.setDate}" pattern="yyyy-MM-dd"/>" class="ipt-txt"/>
                            	</div>
                            </div>
                        </div>
                    </div> 
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <div class="item-name col-4"><span class="light"></span>区域管理员状态：</div>
                            <div class="col-6">
                                <div class="radio-box">
                                        <label class="font-12">
                                        <input type="radio" name="userStatus" disabled="disabled"
                                               value="1" ${sysUserAreaManage.userStatus=='1'||sysUserAreaManage.userStatus==null?"checked":""}/>有效
	                                    </label>
	                                    <label class="font-12">
	                                        <input type="radio" name="userStatus"  disabled="disabled"
	                                               value="0" ${sysUserAreaManage.userStatus=='0'?"checked":""}/>无效
	                                    </label> 
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="item-name col-4"><span class="light"></span></div>
                            <div class="col-8">
                            	<div class="ipt-box">
                            	
                            	</div>
                            </div>
                        </div>
                    </div> 
                </div> 
            </div>
        </div>
    </div>
    <p class="center mt10 mb10"> 
        <input type="button" class="btn" value="关 闭"  id="cancel"/>
    </p>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/userareamanage/userareamanage_detail_main.js"></script>
</body>
</html>