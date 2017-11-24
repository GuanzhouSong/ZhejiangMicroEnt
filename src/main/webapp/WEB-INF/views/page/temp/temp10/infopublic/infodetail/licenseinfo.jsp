<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>行政许可信息</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>
<jsp:include page="../../common/basicheader.jsp"></jsp:include>

<div class="mod detail-main">
    <div class="tab-panel">
        <!-- 行政许可信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>行政许可信息
            </h3>
            <table class="table-common table-xuke mb20">
                <thead>
                <tr>
                    <th class="col-first">
                        序号
                    </th>
                    <th class="col-second">
                        许可文件编号
                    </th>
                    <th class="col-three">
                        许可文件名称
                    </th>
                    <th class="col-four">
                        有效期自
                    </th>
                    <th class="col-five">
                        有效期至
                    </th>
                    <th class="col-six">
                        许可机关
                    </th>
                    <th class="col-seven">
                        许可内容
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        20130000018587
                    </td>
                    <td>
                        矿产经营资格证书
                    </td>
                    <td>
                        2010年1月3日
                    </td>
                    <td>
                        2014年5月3日
                    </td>
                    <td>北京发展和改革委员会</td>
                    <td>矿产开采经营</td>
                </tr>
                <tr>
                    <td colspan="8" class="tip2">
                        <div class="fl">有变更情形：</div>
                        <div class="fl">
                            <p>1、北京市工商行政管理局2013年5月4日将行政复议罚款金额由100万变更为50万。<br>2、北京市工商行政管理局2012年3月4日将行政复议罚款金额由50万变更为60万。
                            </p>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        20130000018587
                    </td>
                    <td>
                        矿产经营资格证书
                    </td>
                    <td>
                        2010年1月3日
                    </td>
                    <td>
                        2014年5月3日
                    </td>
                    <td>北京发展和改革委员会</td>
                    <td>矿产开采经营</td>
                </tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        20130000018587
                    </td>
                    <td>
                        矿产经营资格证书
                    </td>
                    <td>
                        2010年1月3日
                    </td>
                    <td>
                        2014年5月3日
                    </td>
                    <td>北京发展和改革委员会</td>
                    <td>矿产开采经营</td>
                </tr>
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 885634 条信息，共234页</span>
                <div id="pagination4" class="pagination"><a href="javascript:void(0)" class="prev disabled">首页</a><a
                        href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                        href="javascript:void(0)">1</a><span class="current">2</span><a
                        href="javascript:void(0)">3</a><span>...</span><a href="javascript:void(0)">49</a><a
                        href="javascript:void(0)">50</a><a href="javascript:void(0)" class="next">下一页<i
                        class="icon-triangle-right"></i></a><a href="javascript:void(0)"
                                                               class="prev disabled">末页</a>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="../../../../js/lib/pagination/jquery.pagination.js"></script>

<script>
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