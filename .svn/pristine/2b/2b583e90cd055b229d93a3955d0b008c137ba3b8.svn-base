<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>添加企业标识</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css"> 
</head>
<body>
<div class="pd20">
    <div class="form-list">
       <form id="entWarnForm">
        <div class="form-item clearfix">
            <label class="item-name col-10 right">批次编号：${csEntWarn.batchNo}</label>
            <input type="hidden" class="ipt-txt" name="batchNo" value="${csEntWarn.batchNo}">
            
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"><span style="color: red;">*</span> 预警标识名称：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" placeholder="请输入标识名称" name="markName">
                </div>
            </div>
            <label class="item-name col-2">预警标识类型：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markType">
                        <option value="手动">手动</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">预警标识级别：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markClass">
                        <option value="0">关注</option>
                        <option value="1">警示</option>
                        <option value="2">限制</option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2"><span style="color: red;">*</span> 预警标识有效期：</label>
            <div class="col-3">
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" name="markStartDate" onclick="laydate();" readonly>
                </div>
                <span class="item-txt col-2"><i class="line-icon"></i></span>
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" name="markEndDate" onclick="laydate();" readonly>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"><span style="color: red;">*</span> 预警标识内容：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="markContent">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">指定提示方式：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markAppointWay" id="markAppointWay">
                        <option value="0">对内提示</option>
                        <option value="1">部门共享</option>
                        <option value="2">公开发布</option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">指定提示部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                 <input type="text"  id="markAppointDept" class="ipt-txt" style="height: 30px;" name="markAppointDept" value="" readonly/>
                 <input type="hidden" id="markAppointDeptCode" name="markAppointDeptCode" value="" />
                  <a id="selectWarnMarkAppoint" class="link js-show" style="display: none;">
                  <span class="add-icon" id="yccodetree"><i></i></span>
                 </a>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">设置部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" name="markSetDept" value="${csEntWarn.markSetDept}"  readonly>
                    <input type="hidden" id="markSetDeptCode" name="markSetDeptCode" value="${csEntWarn.markSetDeptCode}" />
                </div>
            </div>
            <label class="item-name col-2">设置时间：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text" name="markSetDate" class="ipt-txt" readonly value="<fmt:formatDate value="${csEntWarn.markSetDate}" pattern="yyyy-MM-dd" />">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"><span style="color: red;">*</span> 设置部门联系人：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="setDeptContact">
                </div>
            </div>
            <label class="item-name col-2"><span style="color: red;">*</span> 联系电话：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="tel">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">传真：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="fax">
                </div>
            </div>
            <label class="item-name col-2">邮箱：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="email">
                </div>
            </div>
        </div>
        <input type="hidden"  name="entStr" value="${csEntWarn.entStr}">
        <input type="hidden"  name="checkState" value="2">
        <input type="hidden"  name="entWarnState" value="1">
        <input type="hidden"  name="markNo" value="${csEntWarn.markNo}">
        <input type="hidden"  name="importPeople" value="${csEntWarn.importPeople}">
        <input type="hidden"  name="importSetId" value="${csEntWarn.importSetId}" />
        <input type="hidden"  name="deptCode" value="${csEntWarn.deptCode}" />
        <div class="form-item clearfix mt40">
            <div class="btn-box">
                <input type="submit" value="提交申请" class="btn mr20">
                <input type="button" value="关闭" id="cancel" class="btn">
            </div>
        </div>
        </form>
    </div>
</div>
<script>
    window._CONFIG = {
            select_dept_url:'<c:url value="/syn/system/sysdepart/alldeptcheckboxtreeselect"/>'
    }
</script>
<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/syn/system/risk/entwarninfo/entwarnapply_addmark.js"></script>
</body>
</html>