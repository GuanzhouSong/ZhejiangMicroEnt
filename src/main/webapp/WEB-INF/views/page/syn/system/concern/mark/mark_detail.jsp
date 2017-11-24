<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>关注服务标识信息</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css"> 
</head>
<body  class="pd10">
<div>
    <div class="print-nocard mb20">
        <h3>关注服务标识信息</h3>
    </div>
    <form id="hx-form">
    <div class="form-list">
        <div class="form-item clearfix">
            <label class="item-name col-3">关注服务标识名称：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="markName" value="${csWarnMark.markName}" placeholder="请输入标识名称">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">关注服务标识级别：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markClass">
                     <option>${csWarnMark.markClass=='0'?'关注':(csWarnMark.markClass=='1'?'警示':'限制') }</option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">关注服务标识有效期：</label>
            <div class="col-3">
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt"  readonly value="<fmt:formatDate value="${csWarnMark.markStartDate}" pattern="yyyy-MM-dd" />"  />
                </div>
                <span class="item-txt col-2"><i class="line-icon"></i></span>
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt"  readonly   value="<fmt:formatDate value="${csWarnMark.markEndDate}" pattern="yyyy-MM-dd" />" />
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">关注服务标识内容：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <textarea rows="5" name="markContent">${csWarnMark.markContent}</textarea>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">关注服务标识适用地区：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markUseArea">
                        <option>${csWarnMark.markUseArea}</option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">关注服务标识状态：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markState">
                        <option>${csWarnMark.markState=='1'?'有效':'无效' }</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">标识指定提示方式：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select id="markAppointWay" name="markAppointWay">
                      <option value= "0" >${csWarnMark.markAppointWay=='0'?'对内提示':(csWarnMark.markAppointWay=='1'?'部门共享':'公开发布') }</option>
                   </select>
                </div>
            </div>
            <label class="item-name col-2"> 设置部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
	                <input type="text"  class="ipt-txt" style="height: 30px;" name="markSetDept" value="${csWarnMark.markSetDept}" readonly/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">标识指定提示部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                 <input type="text" class="ipt-txt" style="height: 30px;"value="${csWarnMark.markAppointDept}" readonly/>
                </div>
            </div>
            <label class="item-name col-2">设置时间：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" readonly value="<fmt:formatDate value="${csWarnMark.markSetDate}" pattern="yyyy-MM-dd" />"  />
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">设置部门联系人：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" value="${csWarnMark.setDeptContact}">
                </div>
            </div>
            <label class="item-name col-2">联系电话：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" value="${csWarnMark.tel}">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"> 传真：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt"  value="${csWarnMark.fax}">
                </div>
            </div>
            <label class="item-name col-2"> 邮箱：</label>
            <div class="col-3">
                <div class="ipt-box">
                     <input type="text" class="ipt-txt"  value="${csWarnMark.email}" >
                </div>
            </div>
        </div>
        
        <div class="form-item clearfix mt40">
            <div class="btn-box">
                <input type="button" value="返回" class="btn mr20" id="cancel">
            </div>
        </div>
    </div>
    </form>
    
</div>


<script>
    window._CONFIG = {
        select_dept_url:'<c:url value="/syn/system/sysdepart/alldeptcheckboxtreeselect"/>'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/syn/system/concern/mark/mark_detail.js"></script>
</body>
</html>