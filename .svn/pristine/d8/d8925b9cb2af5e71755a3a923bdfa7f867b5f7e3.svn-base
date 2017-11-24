<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="tab-panel tab-panel-show">
    <div class="title">
        <h3>公务文书回执操作</h3>
        <p>
            本系统推送的文书信息，将同步通过“企信联连”通知给您，请关注“企信联连（客户端或微信）”，实时接收公务文书通知。
            <strong class="light">已送达</strong>（即已查阅）贵企的文书，逾期未及时回执，将会影响您企业的信用
        </p>
    </div>
    <div class="ann-report pdt10">
        <table class="table-cw">
            <thead>
            <tr>
                <th width="90">序号</th>
                <th width="165">文书名称</th>
                <th width="135">通知时间</th>
                <th width="135">回执状态</th>
                <th width="90">回执人</th>
                <th width="196">回执时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="writ_list"></tbody>
        </table>
        <div class="notice-pagination-box clearfix" id="data_total">
            <span class="page-total">共查询到  <em id="writ_total"></em> 条信息，共<em id="writ_pageNum"></em>页</span>
            <div id="writ_tody_pagination" class="pagination"></div>
        </div>
    </div>
</div>

</body>

<%-- 模板列表 start --%>
<script id="tody-template" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{num @index}}</td>
        <td>{{writName}}</td>
        <td>{{sendTime}}</td>
        {{#compare writReceiveStatue 1}}
        <td style="color: green">已回执</td>
        {{else}}
        <td style="color: red">未回执</td>
        {{/compare}}
        <td>{{receivePeople}}</td>
        <td>{{writReceiveTime}}</td>
        {{#compare writReceiveStatue 1}}
        <td style="color: #3B6CAA;font-size: 14px;cursor: pointer"><a id="view_details" data-uuid="{{uuid}}" data-pripid="{{priPID}}" data-year="{{year}}">查看详情</a></td>
        {{else}}
        <td style="color: #FF9900;font-size: 14px;cursor:pointer"><a id="dz_hz" data-uuid="{{uuid}}" data-pripid="{{priPID}}" data-year="{{year}}">立即回执</a></td>
        {{/compare}}
    </tr>
    {{/each}}
</script>
<%-- 模板列表 end --%>
