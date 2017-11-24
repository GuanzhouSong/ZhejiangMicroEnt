<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>预警标识查看</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css"> 
</head>
<body  class="pd10">
<div>
    <div class="print-nocard">
        <h3>预警提示标识信息</h3>
    </div>
    <form id="warnForm">
    <div class="form-list">
        <div class="form-item clearfix">
            <label class="item-name col-2">标识名称：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" value="${csWarnMark.markName}" >
                </div>
            </div>
            <label class="item-name col-2">标识类型：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select >
                         <option >${csWarnMark.markType}</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">标识级别：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select >
                     <option>${csWarnMark.markClass=='0'?'关注':(csWarnMark.markClass=='1'?'警示':'限制')}</option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">标识有效期：</label>
            <div class="col-3">
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt"  readonly value="<fmt:formatDate value="${csWarnMark.markStartDate}" pattern="yyyy-MM-dd" />" />
                </div>
                <span class="item-txt col-2"><i class="line-icon"></i></span>
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" readonly name="markEndDate" value="<fmt:formatDate value="${csWarnMark.markEndDate}" pattern="yyyy-MM-dd" />" />
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">标识内容：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt"  value="${csWarnMark.markContent}">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">指定提示方式：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                   <select id="markAppointWay" name="markAppointWay">
                      <option>${csWarnMark.markAppointWay=='0'?'对内提示':(csWarnMark.markAppointWay=='1'?'部门共享':'公开发布') }</option>
                   </select>
                </div>
            </div>
            <label class="item-name col-2">指定提示部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                 <input type="text"  class="ipt-txt" style="height: 30px;"  value="${csWarnMark.markAppointDept}" readonly/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">设置部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text"   class="ipt-txt" style="height: 30px;"value="${csWarnMark.markSetDept}"  readonly/>
                </div>
            </div>
            <label class="item-name col-2">设置时间：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" readonly  name="markSetDate" value="<fmt:formatDate value="${csWarnMark.markSetDate}" pattern="yyyy-MM-dd" />">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">设置部门联系人：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="setDeptContact" value="${csWarnMark.setDeptContact}">
                </div>
            </div>
            <label class="item-name col-2">联系电话：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="tel" value="${csWarnMark.tel}">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">传真：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="fax" value="${csWarnMark.fax}">
                </div>
            </div>
            <label class="item-name col-2">邮箱：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="email" value="${csWarnMark.email}" >
                </div>
            </div>
        </div>
        <div class="form-item clearfix mt40">
            <div class="btn-box">
                <input type="button" id="cancel" value="返回"  class="btn mr20">
            </div>
        </div>
    </div>
    </form>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/syn/system/risk/mark/warnmark_detail.js"></script>
</body>
</html>