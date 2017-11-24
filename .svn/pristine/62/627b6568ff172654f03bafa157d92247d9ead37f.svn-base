<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body  class="pd10">
<div>
    <form id="editForm">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="item-name col-1">审核意见：</div>
            <div class="ipt-box col-10">
                <textarea rows="4"  class="ipt-txt" readonly="readonly" >${csEntWarn.checkView}</textarea>
            </div>
        </div>
    </div>
    <div class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                <label class="item-name col-10 right">批次编号：${csEntWarn.batchNo}</label>
                <input type="hidden" class="ipt-txt" id="batchNo" name="batchNo" value="${csEntWarn.batchNo}" >
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2"><span style="color: red;">*</span> 标识名称：</label>
                <div class="col-3">
                    <div class="ipt-box">
                        <input type="text" class="ipt-txt" name="markName" value="${csWarnMark.markName}" placeholder="请输入企业名称" >
                    </div>
                </div>
                <label class="item-name col-2">标识类型：</label>
                <div class="col-3">
                    <div class="ipt-box col-12">
                        <select name="markType">
                         
                         <option value="${csWarnMark.markType}">${csWarnMark.markType}</option>
                       </select>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2">标识级别：</label>
                <div class="col-3">
                    <div class="ipt-box col-12">
                     <select name="markClass">
                     <option value="0" ${csWarnMark.markClass=='0'?'selected':'' }>关注</option>
                     <option value="1" ${csWarnMark.markClass=='1'?'selected':'' }>警示</option>
                     <option value="2" ${csWarnMark.markClass=='2'?'selected':'' }>限制</option>
                     </select>
                    </div>
                </div>
                <label class="item-name col-2"><span style="color: red;">*</span> 标识有效期：</label>
                <div class="col-3">
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt" onclick="laydate(); " name="markStartDate" value="<fmt:formatDate value="${csWarnMark.markStartDate}" pattern="yyyy-MM-dd" />" />
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                         <input type="text" class="ipt-txt" onclick="laydate();" name="markEndDate" value="<fmt:formatDate value="${csWarnMark.markEndDate}" pattern="yyyy-MM-dd" />" />
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2"><span style="color: red;">*</span> 标识内容：</label>
                <div class="col-8">
                    <div class="ipt-box">
                        <input type="text" class="ipt-txt" name="markContent" value="${csWarnMark.markContent}">
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2"> 指定提示方式：</label>
                <div class="col-3">
                    <div class="ipt-box col-12">
                        <select id="markAppointWay" name="markAppointWay">
                      <option value= "0" ${csWarnMark.markAppointWay=='0'?'selected':'' }>对内提示</option>
                      <option value= "1" ${csWarnMark.markAppointWay=='1'?'selected':'' }>部门共享</option>
                      <option value= "2" ${csWarnMark.markAppointWay=='2'?'selected':'' }>公开发布</option>
                       </select>
                    </div>
                </div>
                <label class="item-name col-2">指定提示部门：</label>
                <div class="col-3">
                    <div class="ipt-box col-12">
                      <input type="text"  id="markAppointDept"  class="ipt-txt" style="height: 30px;" name="markAppointDept" value="${csWarnMark.markAppointDept}" readonly/>
                      <input type="hidden" id="markAppointDeptCode" name="markAppointDeptCode" value="${csWarnMark.markAppointDeptCode}" />
                      <a id="selectMarkSetDept" class="link js-show" style="display: none;">
                             <span class="add-icon" id="yccodetree"><i></i></span>
                      </a>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2"> 设置部门：</label>
                <div class="col-3">
                    <div class="ipt-box col-12">
                        <input type="text"  id="markSetDept"  class="ipt-txt" style="height: 30px;" name="markSetDept" value="${csWarnMark.markSetDept}"  readonly/>
                        <input type="hidden" id="markSetDeptCode" name="markSetDeptCode" value="${csWarnMark.markSetDeptCode}" />
                    </div>
                </div>
                <label class="item-name col-2">设置时间：</label>
                <div class="col-3">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt"  readonly name="markSetDate" value="<fmt:formatDate value="${csWarnMark.markSetDate}" pattern="yyyy-MM-dd" />">
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2"><span style="color: red;">*</span> 设置部门联系人：</label>
                <div class="col-3">
                    <div class="ipt-box">
                       <input type="text" class="ipt-txt" name="setDeptContact" value="${csWarnMark.setDeptContact}">
                    </div>
                </div>
                <label class="item-name col-2"><span style="color: red;">*</span> 联系电话：</label>
                <div class="col-3">
                    <div class="ipt-box">
                        <input type="text" class="ipt-txt" name="tel" value="${csWarnMark.tel}">
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2"> 传真：</label>
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
        </div>
    </div>
     <input type="hidden"  id="checkState" value="${csEntWarn.checkState}" />
     <input type="hidden"  name="uid" value="${csWarnMark.uid}" />
     <input type="hidden"  id="markNo" name="markNo" value="${csWarnMark.markNo}" />
     <input type="hidden"  name="entapplyflag" value="1" />
    <div class="clearfix mb5 mt10">
        <p class="fl"><input type="button" class="btn btn-sm mr5" id="addEnt" value="添加"><input type="button" id="delData" class="btn btn-sm" value="批量删除"></p>
    </div>
    <div>
			<table id="ent-apply-edit" border="0" cellspacing="0" cellpadding="0"
				class="table-row perc-100 nowrap">
				<thead>
					<tr>
						<th>操作</th>
						<th>统一信用代码</th>
						<th>注册号</th>
						<th>企业名称</th>
						<th>法定代表人</th>
						<th>企业类型</th>
						<th>行业</th>
						<th>住所</th>
						<th>登记机关</th>
						<th>管辖单位</th>
						<th>历史预警记录</th>
					</tr>
				</thead>
			</table>
		</div>

    <div class="form-item clearfix">
        <div class="btn-box">
            <input type="submit" value="提交" class="btn mr20">
            <input type="button" id="cancel"  value="返 回" class="btn">
        </div>
    </div>
   </form>
</div>
    <script>
    window._CONFIG = {
        select_dept_url:'<c:url value="/syn/system/sysdepart/alldeptcheckboxtreeselect"/>'
    }
    </script>
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/syn/system/risk/entwarninfo/entwarnapply_edit.js"></script>
</body>
</html>