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
<body>
<div class="pd20">
    <div class="print-nocard mb20">
        <h3>关注服务标识信息</h3>
    </div>
    <form id="hx-form">
    <div class="form-list">
        <div class="form-item clearfix">
            <label class="item-name col-3"><span style="color: red;">*</span> 关注服务标识名称：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="markName" name="markName" value="${csWarnMark.markName}" placeholder="请输入标识名称">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">关注服务标识级别：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markClass" id="markClass">
                     <option value="0" ${csWarnMark.markClass=='0'?'selected':'' }>关注</option>
                     <option value="1" ${csWarnMark.markClass=='1'?'selected':'' }>警示</option>
                     <option value="2" ${csWarnMark.markClass=='2'?'selected':'' }>限制</option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2"><span style="color: red;">*</span> 关注服务标识有效期：</label>
            <div class="col-3">
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" onclick="laydate();" readonly id="markStartDate" name="markStartDate" value="<fmt:formatDate value="${csWarnMark.markStartDate}" pattern="yyyy-MM-dd" />"  />
                </div>
                <span class="item-txt col-2"><i class="line-icon"></i></span>
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" onclick="laydate();" readonly  id="markEndDate" name="markEndDate" value="<fmt:formatDate value="${csWarnMark.markEndDate}" pattern="yyyy-MM-dd" />" />
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span style="color: red;">*</span> 关注服务标识内容：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <textarea rows="5" name="markContent" id="markContent">${csWarnMark.markContent}</textarea>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">关注服务标识适用地区：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markUseArea" id="markUseArea">
                        <option value="省" ${csWarnMark.markUseArea=='省'?'selected':'' }>省</option>
                        <option value="市" ${csWarnMark.markUseArea=='市'?'selected':'' }>市</option>
                        <option value="县（市区）" ${csWarnMark.markUseArea=='县（市区）'?'selected':'' }>县（市区）</option>
                        <option value="省本级" ${csWarnMark.markUseArea=='省本级'?'selected':'' }>省本级</option>
                        <option value="市本级" ${csWarnMark.markUseArea=='市本级'?'selected':'' }>市本级</option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">关注服务标识状态：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markState" id="markState">
                        <option value="1" ${csWarnMark.markState=='1'?'selected':'' }>有效</option>
                        <option value="0" ${csWarnMark.markState=='0'?'selected':'' }>无效</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">标识指定提示方式：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select id="markAppointWay" name="markAppointWay">
                      <option value= "0" ${csWarnMark.markAppointWay=='0'?'selected':'' }>对内提示</option>
                      <option value= "1" ${csWarnMark.markAppointWay=='1'?'selected':'' }>部门共享</option>
                      <option value= "2" ${csWarnMark.markAppointWay=='2'?'selected':'' }>公开发布</option>
                   </select>
                </div>
            </div>
            <label class="item-name col-2"> 设置部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
	                <input type="text"  class="ipt-txt" style="height: 30px;" id="markSetDept" name="markSetDept" value="${csWarnMark.markSetDept}" readonly/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">标识指定提示部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                 <input type="text"  id="markAppointDept"  class="ipt-txt" style="height: 30px;" name="markAppointDept" value="${csWarnMark.markAppointDept}" readonly/>
                 <input type="hidden" id="markAppointDeptCode" name="markAppointDeptCode" value="${csWarnMark.markAppointDeptCode}" />
                 <a id="selectMarkSet" class="link js-show" style="display: none;">
                  <span class="add-icon" id="yccodetree"><i></i></span>
                 </a>
                </div>
            </div>
            <label class="item-name col-2">设置时间：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" readonly id="markSetDate" name="markSetDate" value="<fmt:formatDate value="${csWarnMark.markSetDate}" pattern="yyyy-MM-dd" />"  />
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span style="color: red;">*</span> 设置部门联系人：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="setDeptContact" name="setDeptContact" value="${csWarnMark.setDeptContact}">
                </div>
            </div>
            <label class="item-name col-2"><span style="color: red;">*</span> 联系电话：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="tel" name="tel" value="${csWarnMark.tel}">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"> 传真：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="fax" name="fax" value="${csWarnMark.fax}">
                </div>
            </div>
            <label class="item-name col-2"> 邮箱：</label>
            <div class="col-3">
                <div class="ipt-box">
                     <input type="text" class="ipt-txt" id="email" name="email" value="${csWarnMark.email}" >
                </div>
            </div>
        </div>
        
        <input type="hidden" name = "markFunc" value="gz"/>
        <input type="hidden" name = "uid" value="${csWarnMark.uid}"/>
        <input type="hidden" name="markNo" value="${csWarnMark.markNo}"/>
        <input type="hidden" name="markSetYear" value="${csWarnMark.markSetYear}"/>
        <input type="hidden" name="markSetDeptCode" value="${csWarnMark.markSetDeptCode}" />
        <div class="form-item clearfix mt40">
            <div class="btn-box">
                <input type="submit" value="提交" class="btn mr20"> 
                <input type="button" value="返回" class="btn mr20" id="cancel">
                <input type="button" value="打 印" class="btn doenprint">
            </div>
        </div>
    </div>
    </form>
    
</div>


<script>
    window._CONFIG = {
        _urlHead:'/syn/risk/cswarnmark',
        select_dept_url:'<c:url value="/syn/system/sysdepart/alldeptcheckboxtreeselect"/>'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/syn/system/concern/mark/mark_edit.js"></script>
</body>
</html>