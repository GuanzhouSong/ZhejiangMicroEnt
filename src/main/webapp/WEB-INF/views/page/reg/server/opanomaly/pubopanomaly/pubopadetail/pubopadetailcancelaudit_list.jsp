<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>更正（撤销）异常名录审核</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd20">
<form id="taskForm">
<div class="form-box pd14-mr">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">统一代码/注册号：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="regNO">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">企业名称：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="entName">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">法定代表人：</label>
                <div class="col-7">
                    <div class="ipt-box col-11">
                        <input type="text" class="ipt-txt" name="leRep">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">初审人：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="firstName">
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">初审日期：</label>
                <div class="col-7">
                    <div class="ipt-box col-575">
                        <input type="text" class="ipt-txt laydate-icon"  name="startFirstdate" id="startCogDate" value="" readonly="readonly"/>
                    </div>
                    <span class="item-line col-05">-</span>
                    <div class="ipt-box col-575">
                        <input type="text" class="ipt-txt laydate-icon" name="endFirstdate" id="endCogDate" value="" readonly="readonly"/>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">登记机关：</label>
                <div class="col-7">
                    <div class="ipt-box col-11">
                        <input type="hidden" name="regOrg" id="regOrg" value="" class="hidden_input" />
                        <input type="text"  class="fl ipt-txt" id="regOrgName" value="" placeholder="选择" style="height: 30px;widthcursor: pointer;" readonly="readonly"/>
                        <span class="add-icon" id=choseorgReg><i></i></span>
                    </div>
                </div>
            </div>            
        </div>
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">审核人：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="auditName">
                    </div>
                </div>
            </div>       
             <div class="col-4">
                <label class="item-name col-5">审核日期：</label>
                <div class="col-7">
                    <div class="ipt-box col-575">
                     <input type="text" class="ipt-txt laydate-icon" name="startAuditDate" id="startNorDate" value=""  readonly="readonly"/>
                    </div>
                    <span class="item-line col-05">-</span>
                    <div class="ipt-box col-575">
                     <input type="text" class="ipt-txt laydate-icon"  name="endAuditDate" id="endNorDate" value=""  readonly="readonly" />
                    </div>
                </div>
            </div>            
            <div class="col-4">
                <label class="item-name col-5">管辖单位：</label>
                	<div class="col-7">
                    	<div class="ipt-box col-11">
                        	<input type="hidden" class="hidden_input" name="localAdm" id="localAdm" value=""/>
                        <input type="text" class="ipt-txt" id="localAdmName" value="" placeholder="选择"  readonly="readonly"/>
                        <span class="add-icon" id="choseregUnit">
                            <i></i>
                        </span>
                    	</div>
                	</div>
            </div>

        </div>
        
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5">状态：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
	                  <select name="auditState">
		               	<option value="">全部</option>
		               	<option value="0">待审核</option>
		               	<option value="1">予以撤销</option>
		               	<option value="2">不予撤销</option>
	                  </select>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <label class="item-name col-5">成立日期：</label>
                <div class="col-7">
                    <div class="ipt-box col-575">
                     <input type="text" class="ipt-txt laydate-icon"  id="startEstDate" name="startEstDate" value=""  readonly="readonly"/>
                    </div>
                    <span class="item-line col-05">-</span>
                    <div class="ipt-box col-575">
                     <input type="text" class="ipt-txt laydate-icon"   id="endEstDate"  name="endEstDate" value=""  readonly="readonly"/>
                    </div>
                </div>
            </div>            
            <div class="col-4">
                <label class="item-name col-5">抽检机关：</label>
                <div class="col-7">
                    <div class="ipt-box col-11">
                        <input type="hidden" name="checkDep" id="checkDep" value="" class="hidden_input" />
                        <input type="text"  class="fl ipt-txt" id="checkDepName" value="" placeholder="选择" style="height: 30px;widthcursor: pointer;"  readonly="readonly"/>
                        <span class="add-icon" id=choseCheckDep><i></i></span>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="form-item clearfix">
            <div class="col-4">
                <label class="item-name col-5"><span class="long-label">更正（撤销）原因：</span></label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt" name="removeRea">
                    </div>
                </div>
            </div>         
            <div class="col-4">
                <label class="item-name col-5">责任区：</label>
                <div class="col-7">
                    <div class="ipt-box col-12">
                        <input type="hidden" name="sliceNO" id="sliceNO" value="" class="hidden_input" />
                        <input type="text"  class="fl ipt-txt" id="sliceNOName" value="" placeholder="选择" style="height: 30px;widthcursor: pointer;"  readonly="readonly"/>
                        <span class="add-icon" id=chosesliceNo><i></i></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="center mt10">
            <div class="btn-box">
                <input type="button" id="search" value="查 询" class="btn mr20">
                <input type="reset" id="reset" value="重 置" class="btn">
            </div>
        </div>
     </div>
</div>
</form>
<div class="light-info mb5 mt5">
    <span class="light">
         提示：发现已列入生效的异常名录信息有误时可通过更正（撤销）功能进行特殊的移出异常名录处理。更正（撤销）的异常名录信息不对外公示。点击“查询”为已录入的更正（撤销）记录信息列表。审核通过后可打印“经营异常名录审批表”，审核不通过后可继续审核。
</span>
    <i class="xbt-icon close"></i>
</div>
<table id="user_table" border="0" cellspacing="0" cellpadding="0" class="table-row"
       style="width: 100%;white-space: nowrap;" cellspacing="0">
    <thead>
    <tr>
        <th style="padding:0 20px;">序号</th>
        <th>操作</th>
        <th>注册号</th>
        <th>企业名称</th>
        <th>法定代表人</th>
        <th>成立日期</th>
        <th>更正（撤销）原因</th>
        <th>决定日期</th>
        <th>决定机关</th>
        <th>初审人</th>
        <th>初审日期</th>
        <th>状态</th>
        <th>审核人</th>
        <th>审核日期</th>
        <th>登记机关</th>
        <th>抽检机关</th>
        <th>管辖单位</th>
        <th>责任区</th>
    </tr>
    </thead>
</table>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailcancelaudit_list.js"/>"></script>
<script>
    window._CONFIG = {
        _systemType: '${systemType}'
    }
</script>
</body>
</html>
