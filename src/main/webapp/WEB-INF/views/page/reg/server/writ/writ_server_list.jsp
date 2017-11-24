<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>文书回执服务</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">

<div class="tabbale" data-component="tab">
    <form id="writForm" class="form-box mb5">
        <div class="form-list pdr8">

            <!-- 第1行 start  -->
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">主体类别：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12" style="margin-top: 6px;">
                            <label><input type="checkbox" name="entCatg" checked="checked" value="11,13,31,33,12,14,32,34,21,27,24,22,28">企业</label>
                            <label><input type="checkbox" name="entCatg" value="16,17">农专社</label>
                            <label><input type="checkbox" name="entCatg" value="50">个体户</label>
                            <input type="hidden"   id="entTypeCatg" name="entTypeCatg" >
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">统一信用代码/注册号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt js-trim  js-clearValue" name="regno" value="" placeholder="可输入尾号后四位查询">
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">登记机关：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" id="regOrg" class="ipt-txt js-clearValue" name="regOrg"  value=""/>
                            <input type="text"   id="regOrgName"  class="ipt-txt js-choseorgReg js-clearValue"  value="" readonly="readonly" />
	                        <span class="add-icon js-choseorgReg"> <i></i> </span>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 第1行 end  -->

            <!------------------------------------------------------------分割线------------------------------------------------------------------------------>

            <!-- 第2行 start  -->
            <div class="form-item clearfix">

                <div class="col-4">
                    <label class="item-name col-5">文书类型：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="writType" class="js-clearValue">
                                <option value="">-请选择-</option>
                                <option value="1">行政指导书</option>
                                <option value="2">责令整改书</option>
                                <option value="3">抽查检查通知书</option>
                                <option value="4">列入经营异常名录决定书</option>
                                <option value="5">移出经营异常名录决定书</option>
                                <option value="6">撤销列入经营异常名录决定书</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">企业名称：</label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt js-trim js-clearValue" name="entName" value="" placeholder="可输入名称关键字查询"/>
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">管辖单位：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" id="localAdm"     class="ipt-txt js-clearValue" name="localAdm"  value=""/>
                            <input type="text"  id="localAdmName"  class="ipt-txt js-choseregUnit js-clearValue"  value="" readonly="readonly"/>
	                        <span class="add-icon js-choseregUnit"><i></i></span>
                        </div>
                    </div>
                </div>

            </div>
            <!-- 第2行 end  -->

            <!------------------------------------------------------------分割线------------------------------------------------------------------------------>

            <!-- 第3行 start  -->
            <div class="form-item clearfix">

                <div class="col-4">
                    <label class="item-name col-5">消息查阅状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="messageLookStatue" class="js-clearValue">
                                <option value="">-请选择-</option>
                                <option value="1">已查阅</option>
                                <option value="0">未查阅</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">文书回执状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="writReceiveStatue" class="js-clearValue">
                                <option value="">-请选择-</option>
                                <option value="1">已回执</option>
                                <option value="0">未回执</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">片区：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="hidden" id="sliceNo" class="ipt-txt js-clearValue" name="sliceNO"  value=""/>
                            <input type="text"  id="sliceNoName"  class="ipt-txt js-chooseSliceNo js-clearValue"  value="" readonly="readonly"/>
                            <span class="add-icon js-chooseSliceNo"><i></i></span>
                        </div>
                    </div>
                </div>

            </div>
            <!-- 第3行 end  -->

            <!------------------------------------------------------------分割线------------------------------------------------------------------------------>

            <!-- 第4行 start  -->
            <div class="form-item clearfix">

                <div class="col-4">
                    <label class="item-name col-5">文书发送时间：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" id="sendTimeStart" class="ipt-txt laydate-icon js-clearValue"  name="sendTimeStart" value="" readonly="readonly"/>
                        </div>

                        <span class="item-line col-05">-</span>

                        <div class="ipt-box col-575">
                            <input type="text" id="sendTimeEnd" class="ipt-txt laydate-icon js-clearValue"  name="sendTimeEnd" value="" readonly="readonly"/>
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">文书回执时间：</label>
                    <div class="col-7">
                        <div class="ipt-box col-575">
                            <input type="text" id="writReceiveTimeStart" class="ipt-txt laydate-icon js-clearValue"   name="writReceiveTimeStart" value=""  readonly="readonly"/>
                        </div>

                        <span class="item-line col-05">-</span>

                        <div class="ipt-box col-575">
                            <input type="text" id="writReceiveTimeEnd" class="ipt-txt laydate-icon js-clearValue"   name="writReceiveTimeEnd" value=""  readonly="readonly"/>
                        </div>
                    </div>
                </div>

                <div class="col-4">
                    <label class="item-name col-5">登记状态：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select name="regStateM" id="regStateM" multiple="multiple">
                                <c:forEach var="regState" items="${regStateEnumMap}">
                                	<option value='${regState.value.code}' title='${regState.value}' ${regState.value == 'CUNXU' ? 'selected':''}>${regState.value.name}</option>
                            	</c:forEach>
                            </select>
                            <input type="hidden" id="regState" name="regState" >
                        </div>
                    </div>
                </div>
            </div>
            <!-- 第4行 end   -->

            <!------------------------------------------------------------分割线------------------------------------------------------------------------------>


            <div class="center mt10">

                <input type="button" id="js-search" value="查询" class="btn mr20">
                <input type="button" id="js-reset"  value="重置" class="btn mr20">
                <span style="text-align: right !important;"><a href="/reg/server/writ/list/" target="_blank">(新开操作页面)</a></span>
              <%-- &lt;%&ndash; <input type="button" id="more" value="更多查询条件" class="btn mr20">&ndash;%&gt;--%>
            </div>

        </div>
    </form>
</div>

<div class="light-info mt5">
    <span class="light">提示：系统自动发送文书待签收通知提醒企业用数字证书进行电子签收，若通知当日未签收，则系统次日自动催告直至企业签收或催告期结束。</span>
</div>

<p class="tip-info left mb5">查询结果：
    企业共<span id="js-qysum" class="light">0</span>家，
    文书信息共<span id="js-wssum" class="light">0</span>条，
    已签阅<span id="js-look" class="light">0</span>条，
    未签阅<span id="js-notLook" class="light">0</span>条
</p>

<!-- 表格列表 -->
<div class="tab-content mb20 mt10">
    <div class="tab-panel tab-panel-show">
        <div class="">
            <div class="table-out">
                <table id="writ-table" border="0" cellspacing="0" cellpadding="0" class="table-row display nowrap">
                    <thead>
                        <tr>
                            <th>序号</th>
                            <th>操作</th>
                            <th>文书类别</th>
                            <th>统一代码</th>
                            <th>注册号</th>
                            <th>企业名称</th>
                            <th>法定代表人</th>
                            <th>发送时间</th>
                            <th>发送人</th>
                            <th>通知对象</th>
                            <th>联系方式</th>
                            <th>消息查阅状态</th>
                            <th>文书回执状态</th>
                            <th>催告次数</th>
                            <th>最新催告时间</th>
                            <th>登记机关</th>
                            <th>管辖单位</th>
                            <th>片区/商圈</th>
                            <th>登记状态</th>
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/writ/writ_server_list.js"></script>
</body>
</html>
