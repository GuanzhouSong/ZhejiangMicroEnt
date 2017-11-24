<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>纳入经营异常名录信息</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>
<jsp:include page="../../common/basicheader.jsp"></jsp:include>

<div class="mod detail-main">
    <div class="tab-panel">
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>纳入经营异常名录信息
            </h3>
            <table class="table-common table-chufa">
                <thead>
                <tr>
                    <th width="35">
                        序号
                    </th>
                    <th width="220">
                        纳入经营异常名录原因
                    </th>
                    <th width="105">
                        列入日期
                    </th>
                    <th width="140">
                        作出决定机关（列入）
                    </th>
                    <th width="250">
                        移出经营异常名录原因
                    </th>
                    <th width="105">
                        移出日期
                    </th>
                    <th>
                        作出决定机关（移出）
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td class="left">
                        未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的
                    </td>
                    <td>
                        2014年2月1日
                    </td>
                    <td>
                        北京市工商局
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td class="left">
                        未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的
                    </td>
                    <td>
                        2013年10月1日
                    </td>
                    <td>
                        北京市工商局
                    </td>
                    <td class="left">
                        列入经营异常名录3年内且依照《经营异常名录管理办法》第六条规定被列入经营异常名录的企业，可以在补报未报年份的年度报告并公示后，申请移出
                    </td>
                    <td>2013年12月2日</td>
                    <td>北京市工商局</td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td class="left">
                        未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的
                    </td>
                    <td>
                        2013年10月1日
                    </td>
                    <td>
                        北京市工商局
                    </td>
                    <td class="left">
                        列入经营异常名录3年内且依照《经营异常名录管理办法》第六条规定被列入经营异常名录的企业，可以在补报未报年份的年度报告并公示后，申请移出
                    </td>
                    <td>2013年12月2日</td>
                    <td>北京市工商局</td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 885634 条信息，共234页</span>
                <div id="pagination" class="pagination"><a href="javascript:void(0)" class="prev disabled">首页</a><a
                        href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                        href="javascript:void(0)">1</a><span class="current">2</span><a
                        href="javascript:void(0)">3</a><span>...</span><a href="javascript:void(0)">49</a><a
                        href="javascript:void(0)">50</a><a href="javascript:void(0)" class="next">下一页<i
                        class="icon-triangle-right"></i></a><a href="javascript:void(0)" class="prev disabled">末页</a>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="../../../../js/lib/pagination/jquery.pagination.js"></script>
<script src="../../../../js/lib/layer/layer.js"></script>
<script>
    $(document).on('click', '.js-justicedetail-view', function () {
        var id = $(this).closest('tr').attr('data-id');
        layer.open({
            type: 2,
            shadeClose: true,
            closeBtn: 0,
            area: ['590px', '700px'],
            title: false,
            content: '/ui/pub/infopublic/infodetail/justicedetail?id=' + id
        })
    });
    $('#pagination').pagination(500, {
        callback: function () {
        },
        prev_text: '<i class="icon-triangle-left"></i>上一页',
        next_text: '下一页<i class="icon-triangle-right"></i>',
        num_display_entries: 3,
        num_edge_entries: 2,
        current_page: 1,
        link_to: 'javascript:void(0)',
        ellipse_text: '...',
        first_text: '首页',
        last_text: '末页',
    });
</script>
</body>
</html>