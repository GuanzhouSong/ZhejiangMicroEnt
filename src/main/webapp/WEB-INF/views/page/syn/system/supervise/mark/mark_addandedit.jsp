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
<body class="pd10">
<div>
    <div class="print-nocard mb20">
        <h3>重点监管标识信息</h3>
    </div>
    <form id="hx-form">
    <div class="form-list">
        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span> 重点监管标识名称：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="markName" name="markName" value="${csWarnMark.markName}" placeholder="请输入监管对象标识名称">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"></label>
            <div class="col-8">
                <div class="light-info pdl5">
                	<span class="light">命名规则  地区/设置部门/适用范围/对象类别/监管活动目的 &nbsp;&nbsp;&nbsp;&nbsp;如：杭州市场监管局全市本级危险化学品经营企业专项监管</span>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span> 重点监管标识级别：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select name="markClass" id="markClass">
                     <option value="0" ${csWarnMark.markClass=='0'?'selected':'' }>关注</option>
                     <option value="1" ${csWarnMark.markClass=='1'?'selected':'' }>警示</option>
                     <option value="2" ${csWarnMark.markClass=='2'?'selected':'' }>限制</option>
                    </select>
                </div>
            </div>
            <label class="item-name col-2"><span class="light">*</span> 重点监管标识有效期：</label>
            <div class="col-3">
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate();" name="markStartDate" id="markStartDate" value="<fmt:formatDate value="${csWarnMark.markStartDate}" pattern="yyyy-MM-dd" />"  />
                </div>
                <span class="item-txt col-2"><i class="line-icon"></i></span>
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" readonly="readonly" onclick="laydate();" name="markEndDate" id="markEndDate" value="<fmt:formatDate value="${csWarnMark.markEndDate}" pattern="yyyy-MM-dd" />" />
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span> 重点监管标识内容（包括目的、<br />任务、要求、期限等）：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <textarea rows="5" name="markContent" id="markContent">${csWarnMark.markContent}</textarea>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span class="light">*</span> 重点监管标识适用地区：</label>
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
            <label class="item-name col-2"><span class="light">*</span> 重点监管标识状态：</label>
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
            <label class="item-name col-3"><span class="light">*</span> 标识指定提示方式：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <select id="markAppointWay" name="markAppointWay" id="markAppointWay">
                      <option value= "0" ${csWarnMark.markAppointWay=='0'?'selected':'' }>对内提示（仅在本部门内部提示）</option>
                      <option value= "1" ${csWarnMark.markAppointWay=='1'?'selected':'' }>部门共享（按照设置共享部门进行提示）</option>
                      <option value= "2" ${csWarnMark.markAppointWay=='2'?'selected':'' }>公开发布（本平台所有用户均提示并向社会公开）</option>
                   </select>
                </div>
            </div>
            <label class="item-name col-2"> 设置部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
	                <input type="text"  class="ipt-txt" id="markSetDept" name="markSetDept" value="${csWarnMark.markSetDept}" readonly/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"> 标识指定提示部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                 <input type="text"  id="markAppointDept"  class="ipt-txt"  name="markAppointDept" value="${csWarnMark.markAppointDept}" readonly/>
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
            <label class="item-name col-3"><span class="light">*</span> 设置部门联系人：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="setDeptContact" id="setDeptContact" value="${csWarnMark.setDeptContact}">
                </div>
            </div>
            <label class="item-name col-2"><span class="light">*</span> 联系电话：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="tel" id="tel" value="${csWarnMark.tel}">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"> 传真：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="fax" id="fax" value="${csWarnMark.fax}">
                </div>
            </div>
            <label class="item-name col-2"><span class="light">*</span> 邮箱：</label>
            <div class="col-3">
                <div class="ipt-box">
                     <input type="text" class="ipt-txt" name="email" id="email" value="${csWarnMark.email}" >
                </div>
            </div>
        </div>
        
        <input type="hidden" name = "markFunc" value="jg"/>
        <input type="hidden" name = "uid" value="${csWarnMark.uid}"/>
        <input type="hidden" name="markNo" value="${csWarnMark.markNo}"/>
        <input type="hidden" name="markSetYear" value="${csWarnMark.markSetYear}"/>
        <input type="hidden" name="markSetDeptCode" value="${csWarnMark.markSetDeptCode}" />
        <div class="form-item clearfix mt40">
            <div class="btn-box">
                <input type="submit" value="提 交" class="btn mr20">
                <input type="button" value="取消申请" class="btn mr20" id="cancel">
                <input type="button" id="print" value="打 印" class="btn mr20">
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
<script src="/js/syn/system/supervise/mark/mark_addandedit.js"></script>
</body>
</html>