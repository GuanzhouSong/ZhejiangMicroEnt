<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/smallent/main.css"/>"/>
</head>
<style>
.wd { width:353px; display:inline; }
.wd ul { height:180px; padding:15px 20px; background:#f7f7f7; }
.zc { float:left; }
.zc li ,.links li { height:30px; line-height:30px; }
	</style>
<body>
	<div class='wd zc'>
      <ul id="smallentgrid"></ul>
      </div>
</body>
<script id="supportTemplate" type="text/x-handlebars-template">
    {{#each data}}
    <li>
        <a class="doView" href="javascript:void(0)" _id="{{uid}}">{{entName}}</a>
    </li>
    {{/each}}
	</script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/pagination/jquery.pagination.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/smallent/smsupport_insert.js"></script>
</html>