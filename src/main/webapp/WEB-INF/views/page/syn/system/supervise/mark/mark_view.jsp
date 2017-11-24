<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>重点监管标识信息</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
</head>
<body  class="pd10">
<div>
    <div class="print-nocard mb20">
        <h3>重点监管标识信息</h3>
    </div>
    <form id="hx-form">
    <div class="form-list">
        <div class="form-item clearfix">
            <label class="item-name col-3">重点监管标识名称：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" readonly name="markName" value="${csWarnMark.markName}" placeholder="请输入监管名称">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"> 重点监管标识级别：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markClass" disabled="disabled" readonly>
                     <option value="0" ${csWarnMark.markClass=='0'?'selected':'' }>关注</option>
                     <option value="1" ${csWarnMark.markClass=='1'?'selected':'' }>警示</option>
                     <option value="2" ${csWarnMark.markClass=='2'?'selected':'' }>限制</option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">重点监管标识有效期：</label>
            <div class="col-3">
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" readonly="readonly"   name="markStartDate" value="<fmt:formatDate value="${csWarnMark.markStartDate}" pattern="yyyy-MM-dd" />"  />
                </div>
                <span class="item-txt col-2"><i class="line-icon"></i></span>
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" readonly="readonly"  name="markEndDate" value="<fmt:formatDate value="${csWarnMark.markEndDate}" pattern="yyyy-MM-dd" />" />
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">重点监管标识内容（包括目的、任务、要求、期限等）：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <textarea rows="5" name="markContent" readonly="readonly">${csWarnMark.markContent}</textarea>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"> 重点监管标识适用地区：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markUseArea" disabled="disabled"  >
                        <option value="省" ${csWarnMark.markUseArea=='省'?'selected':'' }>省</option>
                        <option value="市" ${csWarnMark.markUseArea=='市'?'selected':'' }>市</option>
                        <option value="县（市区）" ${csWarnMark.markUseArea=='县（市区）'?'selected':'' }>县（市区）</option>
                        <option value="省本级" ${csWarnMark.markUseArea=='省本级'?'selected':'' }>省本级</option>
                        <option value="市本级" ${csWarnMark.markUseArea=='市本级'?'selected':'' }>市本级</option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2">重点监管标识状态：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markState" disabled="disabled" >
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
                    <select id="markAppointWay" name="markAppointWay" disabled="disabled" >
                      <option value= "0" ${csWarnMark.markAppointWay=='0'?'selected':'' }>对内提示（仅在本部门内部提示）</option>
                      <option value= "1" ${csWarnMark.markAppointWay=='1'?'selected':'' }>部门共享（按照设置共享部门进行提示）</option>
                      <option value= "2" ${csWarnMark.markAppointWay=='2'?'selected':'' }>公开发布（本平台所有用户均提示并向社会公开）</option>
                   </select>
                </div>
            </div>
            <label class="item-name col-2"> 设置部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
	                <input type="text"  class="ipt-txt" name="markSetDept" value="${csWarnMark.markSetDept}" readonly/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">标识指定提示部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                 <input type="text"  id="markAppointDept"  class="ipt-txt" style="height: 30px;" name="markAppointDept" value="${csWarnMark.markAppointDept}" readonly/>
                 <input type="hidden" id="markAppointDeptCode" name="markAppointDeptCode" value="" />
                 <a id="selectMarkSet" class="link js-show none">
<!--                   <span class="add-icon" id="yccodetree" type="hidden"> -->
<!--                      <i></i> -->
<!--                  </span> -->
                 </a>
                 <!-- <a id="selectMarkSet" class="link js-show none" >选择</a> -->
                </div>
            </div>
            <label class="item-name col-2">设置时间：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" readonly  name="markSetDate" value="<fmt:formatDate value="${csWarnMark.markSetDate}" pattern="yyyy-MM-dd" />"  />
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">设置部门联系人：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="setDeptContact" value="${csWarnMark.setDeptContact}" readonly>
                </div>
            </div>
            <label class="item-name col-2">联系电话：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="tel" value="${csWarnMark.tel}" readonly>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"> 传真：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="fax" value="${csWarnMark.fax}" readonly>
                </div>
            </div>
            <label class="item-name col-2">邮箱：</label>
            <div class="col-3">
                <div class="ipt-box">
                     <input type="text" class="ipt-txt" name="email" value="${csWarnMark.email}" readonly>
                </div>
            </div>
        </div>
        
        <div class="form-item clearfix mt40">
            <div class="btn-box">
                <input type="button" value="关闭" class="btn" id="cancel">
            </div>
        </div>
    </div>
    </form>
    
</div>


<script>
    window._CONFIG = {
        select_dept_url:'<c:url value="/dept/tree/select"/>'
    }
</script>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/syn/system/supervise/mark/mark_view.js"></script>
</body>
</html>