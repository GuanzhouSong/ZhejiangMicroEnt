
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
    #unusualCatalog {
        padding: 0px;
        margin: 0px;
        overflow-x: hidden;
        overflow-y: auto;
        height: 100px;
    }

    .warn {
        background: #F00 !important;
        color: #FFF !important
    }
    
    .hide {
        display: none; 
    }

    #form select, #form textarea {
        background: #F4F8F9;
    }
</style>
<style type="text/css">
    table.gridtable {
        font-family: verdana, arial, sans-serif;
        font-size: 11px;
        color: #333333;
        border-width: 1px;
        border-color: #666666;
        border-collapse: collapse;
    }

    table.gridtable th {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #dedede;
    }

    table.gridtable td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #ffffff;
    }
</style>
<body>
<div class="main">
    <h1 id="title"></h1>
        <form id="pubauditosaveform"> 
            <!-- 参数传递列表 -->
            <input type="hidden" name="year" id="year" value="${yrRegCheck.year}">
            <input type="hidden" name="priPID" id="priPID"  value="${yrRegCheck.priPID}">
            <input type="hidden" name="checkOpinBank" id="checkOpinBank" value="${yrRegCheck.checkOpinBank}">
            <input type="hidden" name="checkOpinBur"  id="checkOpinBur" value="${yrRegCheck.checkOpinBur}">
            <input type="hidden" name="checkOpinSfc" id="checkOpinSfc" value="${yrRegCheck.checkOpinSfc}">
            <input type="hidden" id="declStatus" name="declStatus" value="${yrRegCheck.declStatus}"/>
            <input type="hidden" id="reportType" name="reportType" value="${deptType}"/> 
        </form>
        <br/>
        <div class="listBox2 thBg"> 
            <table width="100%" border="0" class="table-horizontal ny"> 
                <tr>
                    <td class="bg-gray right" width="170" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">* 农业部门审核意见(限500字)</div>
                    </td>
                    <td colspan="6">
                        <div class="radio-box left">
                            <c:if test="${deptType=='0' }">
                                <span id="nySpanY"><input type="radio"   name="nyState" value="2">接收</span>
                                <span id="nySpanN"><input type="radio"   name="nyState" value="3">退回</span>
                            </c:if>
                        </div>
                        <div class="ipt-box">
                             <textarea ${deptType!='0'?'readonly=readonly':'' } id="nyCheckOpinSfc" name="nyCheckOpinSfc" style="width: 100%;height: 80px;overflow:auto;">${yrRegCheck.checkOpinSfc}</textarea>
                        </div>
                    </td>
                </tr> 
            </table>
            <br>
            <table width="100%" border="0" class="table-horizontal gs"> 
                 <tr>
                    <td class="bg-gray right" width="170" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">* 工商部门审核意见(限500字)</div>
                    </td>
                    <td colspan="6">
                        <div class="radio-box left">
                        <c:if test="${deptType=='1' }">
                            <span id="gsSpanY"><input type="radio"  name="gsState" value="3">有异议</span>
                            <span id="gsSpanN"><input type="radio"  name="gsState" value="2">无异议</span>
                        </c:if>
                        </div>
                        <div class="ipt-box">
                             <textarea ${deptType!='1'?'readonly=readonly':'' }  id="gsCheckOpinBur"  style="width: 100%;height: 80px;overflow:auto;">${yrRegCheck.checkOpinBur}</textarea>
                        </div>
                    </td>
                </tr>
            </table>
            <br>
            <table width="100%" border="0" class="table-horizontal jr"> 
                 <tr>
                    <td class="bg-gray right" width="170" valign="middle" class="lb_1" style="text-align:center">
                        <div class="ipt-box">* 金融部门审核意见(限500字)</div>
                    </td>
                    <td colspan="6">
                        <div class="radio-box left">
                         <c:if test="${deptType=='2' }">
                            <span id="jrSpanY"><input type="radio"  name="jrState" value="3">有异议</span>
                            <span id="jrSpanN"><input type="radio"  name="jrState" value="2">无异议</span>
                         </c:if>
                        </div>
                        <div class="ipt-box">
                             <textarea ${deptType!='2'?'readonly=readonly':'' }  id="jrCheckOpinBank" name="auditOpin" style="width: 100%;height: 80px;overflow:auto;">${yrRegCheck.checkOpinBank}</textarea>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    <br><br>
    <div align="center">
        <input type="button" class="btn btn-info" id="savepubOpanoBtn" value="保存"/>
        <input type="button" class="btn " id="cancel" value="取消"/>
    </div>
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script>
    window._CONFIG = { 
       _sysUrl:'${sysUrl}',
       _deptType:'${deptType}',
       _realName:'${sysUser.realName}',
       _aduitDate:'${aduitDate}'
    }
</script>
<script src="<c:url value="/js/syn/system/composite/cominfocheck_edit_main.js"/>"></script>
</body>

