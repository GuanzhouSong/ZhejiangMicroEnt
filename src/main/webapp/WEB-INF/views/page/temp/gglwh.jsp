<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>人员维护</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="pd20 clearfix">
    <h3 class="h3-title center">新增公告</h3>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
        <tr>
            <td class="bg-gray right" width="15%">标题</td>
            <td colspan="3">
                <div class="ipt-box col-12"><input type="text" class="ipt-txt"></div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">公告类型 </td>
            <td width="35%">
                <div class="radio-box pd0">
                    <label><input type="radio">对内公告</label>
                    <label><input type="radio">对外公告</label>
                    <label><input type="radio">内外公告</label>
                </div>
            </td>
            <td class="bg-gray right" width="15%">是否有效 </td>
            <td>
                <div class="radio-box pd0">
                    <label><input type="radio">是</label>
                    <label><input type="radio">否</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">发布范围</td>
            <td>
                <div class="radio-box pd0">
                    <label><input type="radio">本局</label>
                </div>
            </td>
            <td class="bg-gray right">添加人 </td>
            <td>汇信维护员</td>
        </tr>
        <tr>
            <td class="bg-gray right">内容</td>
            <td colspan="3">
                <div class="ipt-box col-12"><input type="text" class="ipt-txt" value="编辑器编辑器编辑器"></div>
                <span class="light-green">字数统计 0</span>
            </td>
        </tr>

    </table>
    <p class="center mt10"><input type="button" class="btn mr20" value="保 存"/><input type="button" class="btn" value="取 消"/></p>
</div>
</body>
</html>